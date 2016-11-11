package com.gmail.grzegorz2047.pseudohc;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;

import java.util.UUID;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Region {

    private int x;
    private int z;
    private UUID worldid;

    public Region(UUID worldid, int x, int z) {
        this.x = x;
        this.z = z;
        this.worldid = worldid;
    }

    public Chunk getChunk() {
        return Bukkit.getWorld(worldid).getChunkAt(x, z);
    }

}
