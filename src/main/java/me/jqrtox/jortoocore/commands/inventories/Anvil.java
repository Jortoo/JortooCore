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

public class Anvil implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        Inventory anvil = Bukkit.createInventory(player, InventoryType.ANVIL);
        player.openInventory(anvil);
        player.sendRichMessage(JortooCore.prefix + "you opened an anvil inventory.");

        return true;
    }
}
