package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        Location spawnLocation = player.getLocation();
        JortooCore plugin = JortooCore.plugin;
        FileConfiguration config = plugin.getConfig();
        config.set("config.spawn-location", spawnLocation);
        player.sendRichMessage(JortooCore.prefix + "You have set the spawn to your location! <gray>(" + spawnLocation + ")");
        plugin.saveConfig();

        return  true;
    }
}
