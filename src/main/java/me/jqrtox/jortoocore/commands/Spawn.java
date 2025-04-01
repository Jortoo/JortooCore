    package me.jqrtox.jortoocore.commands;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        FileConfiguration config = JortooCore.plugin.getConfig();
        Location spawnLocation = config.getLocation("config.spawn-location");

        String prefix = JortooCore.prefix;
        if (spawnLocation == null) {
            player.sendRichMessage(prefix + "The spawn location hasn't been set yet");
            return true;
        }
        player.teleport(spawnLocation);
        player.sendRichMessage(prefix + "You have been teleported to <yellow>Spawn");

        return true;
    }

    public static Location getSpawnLocation() {

        FileConfiguration config = JortooCore.plugin.getConfig();
        Location spawnLocation = config.getLocation("config.spawn-location");

        return spawnLocation;

    }

}
