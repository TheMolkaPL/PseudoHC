package com.gmail.grzegorz2047.pseudohc;

import com.gmail.grzegorz2047.pseudohc.api.file.YmlFileHandler;
import com.gmail.grzegorz2047.pseudohc.commands.guild.GuildCommand;
import com.gmail.grzegorz2047.pseudohc.database.queries.SQLManager;
import com.gmail.grzegorz2047.pseudohc.listeners.*;
import com.gmail.grzegorz2047.pseudohc.messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class PseudoHC extends JavaPlugin {


    private FileConfiguration config;
    private FileConfiguration configMessages;
    private SQLManager sqlManager;
    private HashMap<String, Storage> storage = new HashMap<String, Storage>();

    @Override
    public void onEnable() {
        System.out.println(this.getName() + " juz sobie dziala");
        this.saveDefaultConfig();
        YmlFileHandler messageFile = new YmlFileHandler(this, this.getDataFolder().toString(), "messages.yml");
        messageFile.load();
        configMessages = messageFile.getConfig();
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
        initStorage();
        registerListeners();
        registerCommands();
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void initStorage() {
        fillStorage();
        loadStorage();
    }

    private void fillStorage() {
        storage.put("Users", new Users());
        storage.put("Guilds", new Guilds());
        storage.put("Regions", new Regions());
        storage.put("Messages", new Messages(configMessages));
        storage.put("Configuration", new Configuration(config));
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
        pm.registerEvents(new PlayerQuitListener(this), this);
        pm.registerEvents(new PlayerLoginListener(this), this);
        pm.registerEvents(new PlayerKickListener(this), this);
        pm.registerEvents(new AsyncPreLoginListener(this), this);
    }

    private void registerCommands() {
        this.getCommand("guild").setExecutor(new GuildCommand("guild", new String[]{"g", "gildia", "guild", "clan", "f"}, this));
    }


    public Storage getStorage(String storageType) {
        return this.storage.get(storageType);
    }
}
