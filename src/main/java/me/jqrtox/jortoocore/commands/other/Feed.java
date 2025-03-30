package me.jqrtox.jortoocore.commands.other;

import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.methods.Cooldowns;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Feed implements CommandExecutor {

    public static Map<UUID, Long> feedCooldowns = new HashMap<>();
    private static JortooCore plugin = JortooCore.plugin;
    private static FileConfiguration config = plugin.getConfig();

    private static int cooldownTime = config.getInt("config.feed-cooldown");
    private static boolean staffCooldownBypass = config.getBoolean("config.staff-feed-cooldown-bypass");
    private static String staffBypassPermission = config.getString("config.staff-feed-cooldown-bypass-permission");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        if (!Cooldowns.returnCooldown(player, feedCooldowns, cooldownTime)) {

            if (!staffCooldownBypass)
                Cooldowns.setCooldown(player, feedCooldowns);
            else if (!player.hasPermission(staffBypassPermission))
                Cooldowns.setCooldown(player, feedCooldowns);

            player.setFoodLevel(20);
            player.setSaturation(20f);
            player.playSound(player, Sound.ENTITY_WANDERING_TRADER_DRINK_POTION, 1L, 1L);
            player.sendRichMessage(JortooCore.prefix + "You have fed yourself");

        }
        return true;

    }
}
