package me.jqrtox.jortoocore.events;

import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.commands.staff.Vanish;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class VanishJoin implements Listener {

    @EventHandler
    public void vanishJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        MiniMessage mm = MiniMessage.miniMessage();

        if (player.hasPermission("jortoo.staff.vanish")) {

            if (!Vanish.vanishedPlayers.contains(player.getUniqueId())) {
                return;
            }

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.hasPermission("jortoo.staff.vanish"))
                    continue;
                onlinePlayer.hidePlayer(JortooCore.plugin, player);
            }

            event.joinMessage(mm.deserialize(""));

            return;
        }

        for (UUID vanishedPlayer : Vanish.vanishedPlayers) {
            player.hidePlayer(JortooCore.plugin, Bukkit.getPlayer(vanishedPlayer));
        }

    }

}
