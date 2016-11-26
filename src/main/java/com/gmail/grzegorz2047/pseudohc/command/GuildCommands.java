package com.gmail.grzegorz2047.pseudohc.command;

import com.gmail.grzegorz2047.pseudohc.Guild;
import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.themolka.commons.command.CommandContext;
import pl.themolka.commons.command.CommandInfo;
import pl.themolka.commons.command.CommandPermissionException;
import pl.themolka.commons.command.CommandUsageException;
import pl.themolka.commons.session.Session;

import java.util.List;

public class GuildCommands {
    private final PseudoHC plugin;

    public GuildCommands(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @CommandInfo(name = {"zaloz", "create"}, description = "Zaloz gildie", min = 3,
            userOnly = true, usage = "<tag> <name> <description...>", permission = "pseudohc.command.create")
    public void create(Session<Player> sender, CommandContext context)  {
        String tag = context.getParam(0);
        String name = context.getParam(1);
        String description = context.getParams(2);
    }

    @CommandInfo(name = {"usun", "delete"}, description = "Usun gildie",
            userOnly = true, permission = "pseudohc.command.delete")
    public void delete(Session<Player> sender, CommandContext context) {

    }

    @CommandInfo(name = {"info"}, description = "Informacje o gildii",
            usage = "[tag]", permission = "pseudohc.command.info", completer = "infoCompleter")
    public void info(Session<Player> sender, CommandContext context) {
        String tag = context.getParam(0);

        Guild guild = null;
        if (tag != null) {
            if (!sender.hasPermission("pseudohc.command.info.other")) {
                throw new CommandPermissionException();
            }

            // find and set `guild` by the given tag
        } else if (sender.isConsole()) {
            throw new CommandUsageException();
        } else {
            Player player = sender.getRepresenter();

            if (true) {
                throw new CommandUsageException("Nie posiadasz gildii - Podaj tag.");
            }

            // get players guild and set `guild`
            // set tag to guilds tag
        }

        if (guild == null) {
            throw new CommandUsageException("Gildia '" + tag + "' nie zostala znaleziona.");
        }

        this.printInfo(sender, guild);
    }

    public List<String> infoCompleter(Session<Player> sender, CommandContext context) {
        if (context.getParamsLength() != 0) {
            return null;
        }

        return null; // return guilds array
    }

    private void printInfo(Session<Player> to, Guild guild) {
        to.send(this.getKeyValue("Tag", guild.getTag()));
    }

    private String getKeyValue(String key, String value) {
        return ChatColor.DARK_AQUA + key + ChatColor.RESET + ChatColor.YELLOW + ": " + ChatColor.AQUA + value;
    }
}
