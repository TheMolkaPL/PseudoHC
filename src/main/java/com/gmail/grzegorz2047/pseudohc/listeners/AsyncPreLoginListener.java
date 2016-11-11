package com.gmail.grzegorz2047.pseudohc.listeners;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import com.gmail.grzegorz2047.pseudohc.User;
import com.gmail.grzegorz2047.pseudohc.Users;
import com.gmail.grzegorz2047.pseudohc.database.queries.UserQuery;
import com.gmail.grzegorz2047.pseudohc.database.queries.exceptions.PlayerNotFoundException;
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
        String username = e.getName();
        if (e.getLoginResult().equals(AsyncPlayerPreLoginEvent.Result.ALLOWED)) {
            loadPlayerData(username);
        }
    }

    private void loadPlayerData(String username) {
        UserQuery userQuery = (UserQuery) plugin.getSqlManager().getQueries().get("UserQuery");
        try {
            User user = userQuery.loadUser(username);
            Users users = (Users) plugin.getStorage().get("Users");
            users.precacheUser(user);
        } catch (PlayerNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
