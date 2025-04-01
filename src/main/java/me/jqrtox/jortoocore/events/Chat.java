package me.jqrtox.jortoocore.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.commands.staff.FreezeChat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Chat implements Listener {

    @EventHandler
    public void asyncChat(AsyncChatEvent event) {

        if (FreezeChat.serverToggles.contains("chat-freeze")) {

            FileConfiguration config = JortooCore.plugin.getConfig();
            String bypassPermission = config.getString("config.chat-freeze-bypass-permission", "jortoo.staff.freezechat.bypass");
            Player player = event.getPlayer();
            if (!player.hasPermission(bypassPermission)) {
                event.setCancelled(true);
                player.sendRichMessage(JortooCore.prefix + "You can not chat right now! the chat has been frozen");
            }
        }

    }

}
