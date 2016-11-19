package com.gmail.grzegorz2047.pseudohc.commands.guild;

import com.gmail.grzegorz2047.pseudohc.api.command.BaseWithAliasCommand;
import com.gmail.grzegorz2047.pseudohc.commands.guild.args.CreateArg;
import org.bukkit.plugin.Plugin;

/**
 * Created by grzegorz2047 on 19.11.2016.
 */
public class GuildCommand extends BaseWithAliasCommand {
    public GuildCommand(String baseCmd, String[] aliases, Plugin plugin) {
        super(baseCmd, aliases, plugin);
        this.commands.put(new String[]{"stworz","zaloz","create","make"}, new CreateArg(plugin));
    }
}
