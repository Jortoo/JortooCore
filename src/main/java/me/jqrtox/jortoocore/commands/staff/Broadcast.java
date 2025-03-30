package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Arrays;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        if (args.length < 1) {
            player.sendRichMessage(JortooCore.prefix + "Please add a broadcast message");
            return false;
        }

        FileConfiguration config = JortooCore.plugin.getConfig();
        boolean broadcastPing = config.getBoolean("config.broadcast-ping");
        boolean broadcastTitle = config.getBoolean("config.broadcast-title");
        String broadcastTitleContent = config.getString("config.broadcast-title-content");
        String broadcastSubTitleContent = config.getString("config.broadcast-subtitle-content");
        String broadcastPrefix = config.getString("config.broadcast-prefix");
        Sound pingSound = Sound.valueOf(config.getString("config.broadcast-ping-sound"));

        MiniMessage mm = MiniMessage.miniMessage();

        String join = String.join(" ", Arrays.copyOfRange(args, 0, args.length));
        mm.deserialize(join);

        Title.Times times = Title.Times.times(
                Duration.ofMillis(1000L),
                Duration.ofMillis(1000L),
                Duration.ofMillis(1000L)
        );

        Title title = Title.title(
                mm.deserialize(broadcastTitleContent),
                mm.deserialize(broadcastSubTitleContent)
                , times);

        if (broadcastPing || broadcastTitle) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (broadcastPing)
                    onlinePlayer.playSound(onlinePlayer, pingSound, 1L, 1L);
                if (broadcastTitle)
                    onlinePlayer.showTitle(title);
            }
        }

        Bukkit.broadcast(mm.deserialize("\n" + broadcastPrefix + join + "\n"));

        return true;
    }
}
