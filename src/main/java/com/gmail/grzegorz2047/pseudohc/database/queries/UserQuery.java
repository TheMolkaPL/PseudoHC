package com.gmail.grzegorz2047.pseudohc.database.queries;

import com.gmail.grzegorz2047.pseudohc.User;
import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;
import com.gmail.grzegorz2047.pseudohc.database.queries.exceptions.PlayerNotFoundException;

import java.sql.*;
import java.util.concurrent.ConcurrentHashMap;

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
                            "username VARCHAR(16) PRIMARY KEY NOT NULL," +
                            "guild VARCHAR(32) NOT NULL DEFAULT ''," +
                            "elopoints INT NOT NULL DEFAULT  1000," +
                            "kills INT NOT NULL DEFAULT  0," +
                            "deaths INT NOT NULL DEFAULT  0," +
                            "firstjoindate DATETIME," +
                            "lastseen TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                            ");";
            //System.out.print(query + " zapytanie");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String query = "CREATE TABLE " + table + "(username VARCHAR(16) PRIMARY KEY, elopoint INT, kills INT, deaths INT, firstjoindate TIMESTAMP DEFAULT  NOW(), lastseen TIMESTAMP) ";

    }

    private void addPlayer(String username) {
        Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query =
                    "INSERT  INTO  " +
                            table +
                            "(username, firstjoindate) VALUES(?, ?) ON duplicate KEY UPDATE username=username ";
            //System.out.print(query + " zapytanie");
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setDate(2, new Date(System.currentTimeMillis()));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //String query = "CREATE TABLE " + table + "(username VARCHAR(16) PRIMARY KEY, elopoint INT, kills INT, deaths INT, firstjoindate TIMESTAMP DEFAULT  NOW(), lastseen TIMESTAMP) ";
    }

    public ConcurrentHashMap<String, User> loadAllUsers() {//Pewnie tego nie użyje xd
        ConcurrentHashMap<String, User> users = new ConcurrentHashMap<String, User>();
        Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query =
                    "SELECT * FROM " + table;

            //System.out.print(query + " zapytanie");
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String guild = resultSet.getString("guild");
                int elopoints = resultSet.getInt("elopoints");
                int kills = resultSet.getInt("kills");
                int deaths = resultSet.getInt("deaths");
                Date firstJoinDate = resultSet.getDate("firstjoindate");
                Timestamp lastseen = resultSet.getTimestamp("lastseen");
                User user = new User(username, elopoints, kills, deaths, firstJoinDate, lastseen, guild);
                users.put(username, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public User loadUser(String username) throws PlayerNotFoundException {
        addPlayer(username);
        Connection connection = null;//userid BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query =
                    "SELECT * FROM " + table + " WHERE username = ? LIMIT 1";

            //System.out.print(query + " zapytanie");
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String guild = resultSet.getString("guild");
                int elopoints = resultSet.getInt("elopoints");
                int kills = resultSet.getInt("kills");
                int deaths = resultSet.getInt("deaths");
                Date firstJoinDate = resultSet.getDate("firstjoindate");
                Timestamp lastseen = resultSet.getTimestamp("lastseen");
                return new User(username, elopoints, kills, deaths, firstJoinDate, lastseen, guild);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new PlayerNotFoundException("Player " + username + " not found in database!");
    }


}
