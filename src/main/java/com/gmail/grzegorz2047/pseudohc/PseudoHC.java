package com.gmail.grzegorz2047.pseudohc;

import api.file.YmlFileHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class PseudoHC extends JavaPlugin {

    //Table<Integer, Integer, String> table = HashBasedTable.create();
    @Override
    public void onEnable() {
        System.out.println(this.getName()+ "juz sobie dziala");
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
