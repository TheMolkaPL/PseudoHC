package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

    public List<Region> getRegionsByGuildName(String tag) {
        return regionsByGuildName.get(tag);
    }

    public Region addRegion(UUID world, int x, int z, String tag) {
        Region region = new Region(world, x, z, tag);
        regionsByCords.put(x, z, region);
        ArrayList<Region> regions = createRegionListIfNotExists(tag);
        regions.add(region);
        return region;
    }

    public void takeRegionFromGuild(int x, int z, String tag) {
        regionsByCords.remove(x, z);
        regionsByGuildName.remove(tag);
    }

    public void reclaimRegionByNewGuild(int x, int z, String tag) {
        Region region = regionsByCords.get(x, z);
        region.setGuild(tag);
    }

    private ArrayList<Region> createRegionListIfNotExists(String tag) {
        ArrayList<Region> regions = regionsByGuildName.get(tag);
        if (regions == null) {
            return new ArrayList<>();
        } else {
            return regions;
        }
    }

}
