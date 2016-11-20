package com.gmail.grzegorz2047.pseudohc;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by grzegorz2047 on 20.11.2016.
 */
public class Configuration implements Storage {

    private final FileConfiguration config;

    public Configuration(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public void load() {
        for (String key : config.getConfigurationSection("").getKeys(false)) {
            System.out.print(key + " ");
        }
    }
}
