package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearChat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        MiniMessage mm = MiniMessage.miniMessage();
        for (int i = 0; i < 1000; i++) {

            Bukkit.broadcast(mm.deserialize(""));

        }
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer, Sound.BLOCK_FIRE_EXTINGUISH, 1L, 1L);
        }
        Bukkit.broadcast(mm.deserialize(JortooCore.prefix + "chat has been cleared by: <yellow><u>" + player.getName() + "</u><white>." + "\n<gray><italic>Please follow chat rules!"));

        return true;
    }
}
