package me.jqrtox.jortoocore.events;

import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.commands.staff.Vanish;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        FileConfiguration config = JortooCore.plugin.getConfig();
        MiniMessage mm = MiniMessage.miniMessage();
        String joinMessage = config.getString("config.join-message");
        String firstJoinMessage = config.getString("config.first-join-message");
        Location spawnLocation = config.getLocation("config.spawn-location");

        if (joinMessage.contains("<player>"))
            joinMessage = joinMessage.replaceAll("<player>", player.getName());
        if (firstJoinMessage.contains("<player>"))
            firstJoinMessage.replaceAll("<player>", player.getName());
        if (firstJoinMessage.contains("<total-joins>"))
            firstJoinMessage.replaceAll("<total-joins>", Bukkit.getOfflinePlayers().length + "");

        if (spawnLocation != null) {
            if (!config.getBoolean("config.teleport-spawn-onjoin"))
                return;
            player.teleport(spawnLocation);
        }
        if (player.hasPlayedBefore()) {
            event.joinMessage(mm.deserialize(joinMessage));
            return;
        }

        event.joinMessage(mm.deserialize(firstJoinMessage));


    }

}
