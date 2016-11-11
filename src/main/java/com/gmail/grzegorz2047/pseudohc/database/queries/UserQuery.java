package com.gmail.grzegorz2047.pseudohc.database.queries;

import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class UserQuery extends Query {


    public UserQuery(DatabaseConnector databaseConnector, String table, String prefix) {
        super(databaseConnector, table, prefix);
    }

    @Override
    public void createTable() throws SQLException {
        Connection connection = this.databaseConnector.getConnection();//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        //String query = "CREATE TABLE " + table + "(username VARCHAR(16) PRIMARY KEY, elopoint INT, kills INT, deaths INT, firstjoindate TIMESTAMP DEFAULT  NOW(), lastseen TIMESTAMP) ";
        String query =
                "CREATE TABLE " +
                        table +
                        "(" +
                        "userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE," +
                        "elopoint INT NOT NULL," +
                        "kills INT NOT NULL," +
                        "deaths INT NOT NULL," +
                        "firstjoindate TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        "lastseen TIMESTAMP NOT NULL" +
                        ");";
        //System.out.print(query + " zapytanie");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
    }
}
