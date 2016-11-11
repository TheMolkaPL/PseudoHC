package com.gmail.grzegorz2047.pseudohc;

import api.file.YmlFileHandler;
import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;
import com.gmail.grzegorz2047.pseudohc.database.queries.SQLManager;
import com.gmail.grzegorz2047.pseudohc.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class PseudoHC extends JavaPlugin {

    //Table<Integer, Integer, String> table = HashBasedTable.create();

    private FileConfiguration config;
    private SQLManager sqlManager;

    @Override
    public void onEnable() {
        System.out.println(this.getName() + "juz sobie dziala");
        this.saveDefaultConfig();
        config = this.getConfig();
        try {
            sqlManager = new SQLManager(
                    config.getString("mysql.players.host"),
                    config.getInt("mysql.players.port"),
                    config.getString("mysql.players.database"),
                    config.getString("mysql.players.user"),
                    config.getString("mysql.players.password"),
                    config.getString("mysql.prefix")
            );
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        registerListeners();
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(this), this);
    }
}
