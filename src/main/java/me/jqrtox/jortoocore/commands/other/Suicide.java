package me.jqrtox.jortoocore.commands.other;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Suicide implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        player.damage(100000000);
        player.sendRichMessage(JortooCore.prefix + "You have killed yourself, NOOB!");

        return true;
    }
}
