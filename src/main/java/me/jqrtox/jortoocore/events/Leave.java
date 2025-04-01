package me.jqrtox.jortoocore.events;

import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.commands.staff.Vanish;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        MiniMessage mm = MiniMessage.miniMessage();
        FileConfiguration config = JortooCore.plugin.getConfig();
        String leaveMessage = config.getString("config.leave-message");

        if (leaveMessage.contains("<player>")) {
            leaveMessage = leaveMessage.replaceAll("<player>", event.getPlayer().getName());
        }
        if (Vanish.vanishedPlayers.contains(event.getPlayer().getUniqueId())) {
            event.quitMessage(mm.deserialize(""));
            return;
        }
        event.quitMessage(mm.deserialize(leaveMessage));
    }

}
