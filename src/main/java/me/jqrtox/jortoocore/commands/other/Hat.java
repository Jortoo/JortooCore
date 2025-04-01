package me.jqrtox.jortoocore.commands.other;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Hat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        ItemStack playerHeldItem = player.getInventory().getItemInMainHand();
        ItemStack playerHeadItem = player.getInventory().getHelmet();

        String prefix = JortooCore.prefix;

        if (playerHeldItem.getType() == Material.AIR) {
            player.sendRichMessage(prefix + "You must have an item in your head!");
            return true;
        }

        MiniMessage mm = MiniMessage.miniMessage();

        player.getInventory().setItemInMainHand(playerHeadItem);
        player.getInventory().setHelmet(playerHeldItem);
        player.sendRichMessage(prefix + "You have put your held item on your head!");

        return true;
    }
}
