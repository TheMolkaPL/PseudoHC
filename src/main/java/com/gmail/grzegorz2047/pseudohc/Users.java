package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Users implements Storage {

    private ConcurrentHashMap<String, User> precachedUsers = new ConcurrentHashMap<String, User>();
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<String, User>();


    @Override
    public void load() {
        //
    }

    public void precacheUser(User user) {
        precachedUsers.put(user.getUsername(), user);
    }

    public User loadUserData(String username) {
        User user = precachedUsers.get(username);
        users.put(username, user);
        precachedUsers.remove(username);
        return user;
    }

    public void unloadUserData(String username) {
        users.remove(username);
    }

    public void removePrecachedPlayer(String username) {
        precachedUsers.remove(username);
    }
}
