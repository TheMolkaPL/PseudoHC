package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class PlayerKickListener implements Listener {

    private final PseudoHC plugin;

    public PlayerKickListener(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onKick(PlayerKickEvent e){
        Player p = e.getPlayer();
        System.out.println(p.getName()+ " zostal wyrzucony!");
    }

}
