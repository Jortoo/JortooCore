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

public class StoneCutter implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        Inventory stoneCutter = Bukkit.createInventory(player, InventoryType.STONECUTTER);
        player.openInventory(stoneCutter);
        player.sendRichMessage(JortooCore.prefix + "you opened a stonecutter inventory.");

        return true;
    }
}
