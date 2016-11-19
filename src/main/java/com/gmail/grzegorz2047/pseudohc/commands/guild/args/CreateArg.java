package com.gmail.grzegorz2047.pseudohc.commands.guild.args;

import com.gmail.grzegorz2047.pseudohc.*;
import com.gmail.grzegorz2047.pseudohc.api.command.Arg;
import com.gmail.grzegorz2047.pseudohc.messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created by grzegorz2047 on 19.11.2016.
 */
public class CreateArg implements Arg {


    private final PseudoHC plugin;

    public CreateArg(Plugin plugin) {
        this.plugin = (PseudoHC) plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Messages messages = (Messages) plugin.getStorage("Messages");
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(messages.getMsg("cmd-only-for-player"));
            return;
        }
        Player p = (Player) sender;
       // Users users = (Users) plugin.getStorage("Users");
        Regions regions = (Regions) plugin.getStorage("Regions");
        Guilds guilds = (Guilds) plugin.getStorage("Guilds");

        String tag = args[0];
        String fullName = args[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }
        String description = sb.toString();
        Location home = p.getLocation();


        Region region = regions.addRegion(p.getWorld().getUID(), home.getChunk().getX(), home.getChunk().getZ(), tag);
        Guild guild = guilds.add(p.getName(), fullName, tag, home, description);

        p.sendMessage(messages.getMsg("create-guild-success"));

    }
}
