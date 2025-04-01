package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Vanish implements CommandExecutor {

    private static List<UUID> vanishedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;


        MiniMessage mm = MiniMessage.miniMessage();
        JortooCore plugin = JortooCore.plugin;
        FileConfiguration config = plugin.getConfig();

        String joinMessage = config.getString("config.join-message");
        String leaveMessage = config.getString("config.leave-message");

        if (joinMessage.contains("<player>"))
            joinMessage = joinMessage.replaceAll("<player>", player.getName());

        if (leaveMessage.contains("<player>"))
            leaveMessage = leaveMessage.replaceAll("<player>", player.getName());


        boolean isInvisible = vanishedPlayers.contains(player.getUniqueId());

        if (!isInvisible) {

            Bukkit.broadcast(mm.deserialize(leaveMessage));
            vanishedPlayers.add(player.getUniqueId());

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.hasPermission("jortoo.staff.vanish"))
                    continue;
                onlinePlayer.hidePlayer(plugin, player);
            }

            return true;
        }

        Bukkit.broadcast(mm.deserialize(joinMessage));
        vanishedPlayers.remove(player.getUniqueId());

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.showPlayer(plugin, player);
        }

        return true;

    }
}
