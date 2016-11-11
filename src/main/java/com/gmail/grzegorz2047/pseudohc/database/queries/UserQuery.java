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
        Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        try {
            connection = getConnection();
            String query =
                    "CREATE TABLE IF NOT EXISTS " +
                            table +
                            "(" +
                            "username VARCHAR(16) PRIMARY KEY," +
                            "elopoint INT NOT NULL DEFAULT  0," +
                            "kills INT NOT NULL DEFAULT  0," +
                            "deaths INT NOT NULL DEFAULT  0," +
                            "firstjoindate TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                            "lastseen TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                            ");";
            //System.out.print(query + " zapytanie");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String query = "CREATE TABLE " + table + "(username VARCHAR(16) PRIMARY KEY, elopoint INT, kills INT, deaths INT, firstjoindate TIMESTAMP DEFAULT  NOW(), lastseen TIMESTAMP) ";

    }

    public void addPlayer(String username) {
        Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        try {
            connection = getConnection();
            String query =
                    "INSERT INTO " +
                            table +
                            "(username) VALUES(" + username + ")";
            //System.out.print(query + " zapytanie");
            PreparedStatement statement = null;

            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String query = "CREATE TABLE " + table + "(username VARCHAR(16) PRIMARY KEY, elopoint INT, kills INT, deaths INT, firstjoindate TIMESTAMP DEFAULT  NOW(), lastseen TIMESTAMP) ";
    }
}
