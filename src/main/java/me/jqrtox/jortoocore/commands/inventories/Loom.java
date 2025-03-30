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

public class Loom implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        Inventory loom = Bukkit.createInventory(player, InventoryType.LOOM);
        player.openInventory(loom);
        player.sendRichMessage(JortooCore.prefix + "you opened a loom inventory.");

        return true;
    }
}
