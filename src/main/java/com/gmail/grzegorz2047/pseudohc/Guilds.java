package com.gmail.grzegorz2047.pseudohc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Guilds  implements Storage{

    ConcurrentHashMap<String, Guild> guilds = new ConcurrentHashMap<String, Guild>();

    @Override
    public void load(){
        if(guilds.isEmpty()){

        }
    }
}
