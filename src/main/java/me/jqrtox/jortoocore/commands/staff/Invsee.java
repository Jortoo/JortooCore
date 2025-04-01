package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Invsee implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;


        String prefix = JortooCore.prefix;
        if (args.length < 1) {
            player.sendRichMessage(prefix + "Correct usage: /invsee <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        player.openInventory(target.getInventory());
        player.sendRichMessage(prefix + "You are currently viewing <yellow>" + target.getName() + "'s <white>inventory");
        return true;
    }
}
