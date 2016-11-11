package com.gmail.grzegorz2047.pseudohc.database;

import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class DatabaseConnector {
    private final String host;
    private final int port;
    private final String db;
    private final String user;
    private final String password;
    private HikariDataSource hikari;

    public DatabaseConnector(String host, int port, String db, String user, String password) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
        connectMysqlDB();
    }
    public DatabaseConnector(String host, int port, String db, String user, String password, String sqlitepath) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
        connectSQliteDB(sqlitepath);
    }

    private void connectMysqlDB() {
        hikari = new HikariDataSource();
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", host);
        hikari.addDataSourceProperty("port", port);
        hikari.addDataSourceProperty("databaseName", db);
        hikari.addDataSourceProperty("user", user);
        hikari.addDataSourceProperty("password", password);
        hikari.addDataSourceProperty("cachePrepStmts", true);
        hikari.addDataSourceProperty("prepStmtCacheSize", 250);
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    }
    private void connectSQliteDB(String sqlitepath) {
        hikari = new HikariDataSource();
        hikari.setDriverClassName("org.sqlite.JDBC");
        //hikari.setDataSourceClassName("org.sqlite.SQLiteDataSource");
        hikari.setPoolName("GuildSQLitePool");
        hikari.setJdbcUrl("jdbc:sqlite:" + sqlitepath + File.separator + db + ".db");
        System.out.println("path ========== " + sqlitepath + File.separator + db + ".db");
        hikari.setConnectionTestQuery("SELECT 1");
        hikari.setMaxLifetime(60000); // 60 Sec
        hikari.setIdleTimeout(45000); // 45 Sec
        hikari.setMaximumPoolSize(50);
    }
    public Connection getConnection() throws SQLException {
        return hikari.getConnection();
    }
}
