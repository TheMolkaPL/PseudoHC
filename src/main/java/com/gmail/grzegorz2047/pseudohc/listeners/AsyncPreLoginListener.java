package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import com.gmail.grzegorz2047.pseudohc.database.queries.UserQuery;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class AsyncPreLoginListener implements Listener {


    private final PseudoHC plugin;

    public AsyncPreLoginListener(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent e) {
        String playername = e.getName();
        if(e.getLoginResult().equals(AsyncPlayerPreLoginEvent.Result.ALLOWED)){
            UserQuery userQuery = (UserQuery) plugin.getSqlManager().getQueries().get("UserQuery");
            userQuery.addPlayer(playername);
        }
    }
}
