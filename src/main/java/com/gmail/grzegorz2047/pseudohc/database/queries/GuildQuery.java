package com.gmail.grzegorz2047.pseudohc.database.queries;

import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by grzegorz2047 on 20.11.2016.
 */
public class GuildQuery extends Query {

    public GuildQuery(DatabaseConnector databaseConnector, String table, String prefix) {
        super(databaseConnector, table, prefix);

    }

    @Override
    public void createTable() throws SQLException {
     /*   Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        try {
            connection = getConnection();
            String query = "CREATE TABLE IF NOT EXISTS `" + GenConf.sqlTablePrefix + "guilds`"
                    + "(tag VARCHAR(11),"
                    + "description VARCHAR(100),"
                    + "leader VARCHAR(37),"
                    + "lives INT,"
                    + "home_x INT,"
                    + "home_y INT,"
                    + "home_z INT,"
                    + "home_world VARCHAR(16),"
                    + "PRIMARY KEY(tag));";
            //System.out.print(query + " zapytanie");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    */
    }
}
