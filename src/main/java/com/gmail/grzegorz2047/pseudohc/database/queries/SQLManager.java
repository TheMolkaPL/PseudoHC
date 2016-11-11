package com.gmail.grzegorz2047.pseudohc.database.queries;

import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;
import org.bukkit.plugin.Plugin;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class SQLManager {
    private DatabaseConnector databaseConnector;
    private HashMap<String, Query> queries = new HashMap<String, Query>();

    public enum DATABASETYPE {SQLITE, MYSQL}

    public SQLManager(String host, int port, String db, String user, String password, String tablePrefix) throws SQLException {
        connectWithDatabase(host, port, db, user, password);

        addQueries(tablePrefix);
        createTables();
    }

    private void createTables() throws SQLException {
        for (Query query : queries.values()) {
            query.createTable();
        }
    }

    private void addQueries(String tablePrefix) {
        queries.put("UserQuery", new UserQuery(databaseConnector, "Users", tablePrefix));
    }

    private void connectWithDatabase(String host, int port, String db, String user, String password) {
        databaseConnector = new DatabaseConnector(host, port, db, user, password);
    }

    public HashMap<String, Query> getQueries() {
        return queries;
    }
}
