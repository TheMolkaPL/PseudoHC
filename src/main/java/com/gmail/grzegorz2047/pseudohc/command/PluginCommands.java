package com.gmail.grzegorz2047.pseudohc.command;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.themolka.commons.command.CommandContext;
import pl.themolka.commons.command.CommandInfo;
import pl.themolka.commons.session.Session;

public class PluginCommands {
    private final PseudoHC plugin;

    public PluginCommands(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @CommandInfo(name = {"pomoc", "help", "?"}, description = "Centrum pomocy", usage = "[query]")
    public void help(Session<Player> sender, CommandContext context) {
        // jakiś fajny system pomocy z przeszukiwaniem komend, gildii, graczy, itd. Można by dodawać własne tematy z
        // poradnikami :D Takie centrum pomocowo/poradnikowe. W każdym razie coś dużo lepszego od tego:
        // https://github.com/iBotSpeak/iBot/blob/master/ibot-core/src/main/java/pl/themolka/ibot/terminal/commands/HelpCommand.java
    }

    @CommandInfo(name = {"wersja", "version", "about", "ver"}, description = "Informacje o pluginie")
    public void version(Session<Player> sender, CommandContext context) {
        sender.send(ChatColor.YELLOW + this.plugin.getName() + " wersja " + this.plugin.getDescription().getVersion() +
                " by " + StringUtils.join(this.plugin.getDescription().getAuthors(), ", "));
        sender.send(ChatColor.YELLOW + ChatColor.ITALIC.toString() + this.plugin.getDescription().getDescription());
        sender.sendInfo(this.plugin.getDescription().getWebsite());
    }
}
