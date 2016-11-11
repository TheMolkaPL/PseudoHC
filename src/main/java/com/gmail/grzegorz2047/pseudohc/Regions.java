package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Regions implements Storage {

    private Table<Integer, Integer, Region> regionsByCords = HashBasedTable.create();
    private HashMap<String, ArrayList<Region>> regionsByGuildName = new HashMap<String, ArrayList<Region>>();

    @Override
    public void load() {

    }

    public Region getRegionByCords(int x, int z) {
        return regionsByCords.get(x, z);
    }

    public List<Region> getRegionsByGuildName(String guildName) {
        return regionsByGuildName.get(guildName);
    }
}
