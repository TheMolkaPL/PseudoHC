package com.gmail.grzegorz2047.pseudohc;

import org.bukkit.Location;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Guilds implements Storage {

    private ConcurrentHashMap<String, Guild> guilds = new ConcurrentHashMap<String, Guild>();

    @Override
    public void load() {
        if (guilds.isEmpty()) {

        }
    }

    public Guild add(String leader, String fullName, String tag, Location home, String description) {
        Guild guild = new Guild(leader, fullName, tag, home, description);
        guilds.put(tag, guild);
        return guild;
    }

    public Guild findGuild(String tag) {
        return guilds.get(tag);
    }

}
