package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Users  implements Storage{

    ConcurrentHashMap<String, User> users = new ConcurrentHashMap<String, User>();


    @Override
    public void load() {

    }
}
