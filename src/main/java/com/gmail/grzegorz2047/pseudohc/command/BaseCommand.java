package com.gmail.grzegorz2047.pseudohc.command;

import com.gmail.grzegorz2047.pseudohc.PseudoHC;
import org.bukkit.entity.Player;
import pl.themolka.commons.command.Command;
import pl.themolka.commons.command.CommandContext;
import pl.themolka.commons.command.CommandInfo;
import pl.themolka.commons.command.CommandUsageException;
import pl.themolka.commons.command.Commands;
import pl.themolka.commons.session.Session;

import java.util.ArrayList;
import java.util.List;

public class BaseCommand extends Commands {
    private final PseudoHC plugin;

    public BaseCommand(PseudoHC plugin) {
        this.plugin = plugin;
    }

    @Override
    public void registerCommand(Command command) {
        this.registerCommand(command, false);
    }

    public void registerCommand(Command command, boolean local) {
        super.registerCommand(command);

        if (!local) {
            // push to Bukkit's commandMap
            this.plugin.getCommons().getCommands().registerCommand(command);
        }
    }

    @CommandInfo(name = {"gildia", "guild", "g", "f"}, description = "Komendy gildii",
            usage = "<arg[s]...> Type 'guild help' for help", completer = "guildCompleter")
    public void guild(Session<Player> sender, CommandContext context) {
        if (context.getParamsLength() == 0) {
            this.printHome(sender, context);
            return;
        }

        String label = context.getParam(0).toLowerCase();
        Command command = this.getCommand(label);

        if (command == null) {
            this.printNotFound(sender, context);
            return;
        }

        String[] args = new String[context.getArgs().length - 1];
        for (int i = 1; i < context.getArgs().length; i++) {
            args[i - 1] = context.getArgs()[i];
        }

        this.handleCommand(sender, command, label, args);
    }

    public List<String> guildCompleter(Session<Player> sender, CommandContext context) {
        if (context.getParamsLength() == 0) {
            return new ArrayList<>(this.getCommandNames());
        }

        String label = context.getParam(0).toLowerCase();
        Command command = this.getCommand(label);

        if (command == null) {
            return null;
        }

        String[] args = new String[context.getArgs().length - 1];
        for (int i = 1; i < context.getArgs().length; i++) {
            args[i - 1] = context.getArgs()[i];
        }

        return this.handleCompleter(sender, command, label, args);
    }

    private void printHome(Session<Player> sender, CommandContext context) {
        // temporary solution
        throw new CommandUsageException("Nie podano zadnego polecenia!");
    }

    private void printNotFound(Session<Player> sender, CommandContext context) {
        // temporary solution
        throw new CommandUsageException("Nie znaleziono podanego polecenia!");
    }
}
