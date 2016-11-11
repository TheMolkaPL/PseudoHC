package com.gmail.grzegorz2047.pseudohc;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class User {
    private Timestamp lastseen;
    private Date firstJoinDate;
    private int deaths;
    private int kills;
    private int elopoints;
    private String username;
    private String guild;

    public User(String username, int elopoints, int kills, int deaths, Date firstJoinDate, Timestamp lastseen, String guild) {
        this.username = username;
        this.elopoints = elopoints;
        this.kills = kills;
        this.deaths = deaths;
        this.firstJoinDate = firstJoinDate;
        this.lastseen = lastseen;
        this.guild = guild;
    }
}
