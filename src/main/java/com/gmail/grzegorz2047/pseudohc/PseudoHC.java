package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by grzegorz2047 on 10.11.2016.
 */
public class PseudoHC extends JavaPlugin {

    Table<Integer, Integer, String> table = HashBasedTable.create();
    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
