package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import com.gmail.grzegorz2047.pseudohc.Users;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class PlayerQuitListener implements Listener {

    private final PseudoHC plugin;

    public PlayerQuitListener(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Users users = (Users) plugin.getStorage().get("Users");
        users.unloadUserData(p.getName());
    }

}
