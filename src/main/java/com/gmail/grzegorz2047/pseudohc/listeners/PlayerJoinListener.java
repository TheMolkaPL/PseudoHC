package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import com.gmail.grzegorz2047.pseudohc.database.queries.UserQuery;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class PlayerJoinListener implements Listener {

    private final PseudoHC plugin;

    public PlayerJoinListener(PseudoHC plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage(null);
        UserQuery userQuery = (UserQuery) plugin.getSqlManager().getQueries().get("UserQuery");
        userQuery.addPlayer();
    }

}
