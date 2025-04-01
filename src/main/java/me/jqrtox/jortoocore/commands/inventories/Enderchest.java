package me.jqrtox.jortoocore.commands.inventories;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class Enderchest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        String prefix = JortooCore.prefix;
        if (args.length == 1) {
            if (!player.hasPermission("jortoo.staff.endersee")) {
                player.sendRichMessage(prefix + "You do not have the permission to view someone else's ender chest");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);
            player.openInventory(target.getEnderChest());
            player.sendRichMessage(prefix + "You are currently viewing <yellow>" + target.getName() + "'s <white>ender chest");
            return true;
        }

        player.openInventory(player.getEnderChest());
        player.sendRichMessage(prefix + "you opened your ender chest.");

        return true;
    }
}
