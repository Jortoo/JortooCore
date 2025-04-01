package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        String prefix = JortooCore.prefix;
        if (args.length  < 1) {
            player.sendRichMessage(prefix + "Correct usage: /tp <player> [<player>]");
            return true;
        }
        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) == player) {
                player.sendRichMessage(prefix + "You can't teleport to yourself");
                return true;
            }
            player.teleport(Bukkit.getPlayer(args[0]).getLocation());
            player.sendRichMessage(prefix + "You have been teleported to: <yellow>" + args[0]);
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[1]);

        if (Bukkit.getPlayer(args[0]) == Bukkit.getPlayer(args[1])) {
            player.sendRichMessage(prefix + "You can't teleport a player to itself");
            return true;
        }
        player.sendRichMessage(prefix + "You have teleported <yellow>" + args[0] + "<white> to <yellow>" + args[1]);
        Bukkit.getPlayer(args[0]).teleport(Bukkit.getPlayer(args[1]).getLocation());
        return true;
    }
}
