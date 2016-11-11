package com.gmail.grzegorz2047.pseudohc;

import api.file.YmlFileHandler;
import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;
import com.gmail.grzegorz2047.pseudohc.database.queries.SQLManager;
import com.gmail.grzegorz2047.pseudohc.listeners.AsyncPreLoginListener;
import com.gmail.grzegorz2047.pseudohc.listeners.PlayerJoinListener;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class PseudoHC extends JavaPlugin {


    private FileConfiguration config;
    private SQLManager sqlManager;
    private HashMap<String, Storage> storage = new HashMap<String, Storage>();

    @Override
    public void onEnable() {
        System.out.println(this.getName() + " juz sobie dziala");
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

    private void fillStorage() {
        storage.put("Users", new Users());
        storage.put("Guilds", new Guilds());
        storage.put("Regions", new Regions());
    }

    private void loadStorage() {
        for (Storage s : storage.values()) {
            s.load();
        }
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(this), this);
        pm.registerEvents(new AsyncPreLoginListener(this), this);
    }

    public HashMap<String, Storage> getStorage() {
        return storage;
    }
}
