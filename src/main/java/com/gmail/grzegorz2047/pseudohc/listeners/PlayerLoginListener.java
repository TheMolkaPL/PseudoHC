package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import com.gmail.grzegorz2047.pseudohc.Users;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class PlayerLoginListener implements Listener {


    private final PseudoHC plugin;

    public PlayerLoginListener(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        Users users = (Users) plugin.getStorage("Users");
        if(!e.getResult().equals(PlayerLoginEvent.Result.ALLOWED)){
            users.removePrecachedPlayer(p.getName());
        }
    }
}
