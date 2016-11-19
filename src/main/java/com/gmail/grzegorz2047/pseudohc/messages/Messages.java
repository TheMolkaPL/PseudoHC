package com.gmail.grzegorz2047.pseudohc.messages;

import com.gmail.grzegorz2047.pseudohc.Storage;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

/**
 * Created by grzegorz2047 on 19.11.2016.
 */
public class Messages implements Storage {

    private final Configuration config;
    private HashMap<String, String> messages = new HashMap<>();

    public Messages(Configuration config) {
        this.config = config;
    }

    public String getMsg(String msg) {
        return messages.get(msg);
    }


    @Override
    public void load() {
        ConfigurationSection section = config.getConfigurationSection("");
        for (String key : section.getKeys(false)) {
            System.out.print(" " + key);
            messages.put(key, ChatColor.translateAlternateColorCodes('&', config.getString(key)));
        }
    }
}
