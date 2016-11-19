package com.gmail.grzegorz2047.pseudohc;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Guild {

    private String leader;
    private User viceLeader;
    private Location home;
    private String description;
    private String fullName;
    private String tag;
    private List<String> members = new ArrayList<>();

    private Guild() {
    }

    public Guild(String leader, String fullName, String tag, Location home, String description) {
        this.leader = leader;
        this.fullName = fullName;
        this.tag = tag;
        this.home = home;
        this.description = description;
    }


    public String getTag() {
        return tag;
    }

    public List<String> getMembers() {
        return members;
    }

    public void addMemeber(String user) {
        this.members.add(user);
    }
}
