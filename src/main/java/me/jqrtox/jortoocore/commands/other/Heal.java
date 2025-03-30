package me.jqrtox.jortoocore.commands.other;

import me.jqrtox.jortoocore.JortooCore;
import me.jqrtox.jortoocore.methods.Cooldowns;
import org.bukkit.Bukkit;
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

public class Heal implements CommandExecutor {

    public static Map<UUID, Long> healCooldowns = new HashMap<>();
    private static JortooCore plugin = JortooCore.plugin;
    private static FileConfiguration config = plugin.getConfig();

    private static int cooldownTime = config.getInt("config.heal-cooldown");
    private static boolean staffCooldownBypass = config.getBoolean("config.staff-heal-cooldown-bypass");
    private static String staffBypassPermission = config.getString("config.staff-heal-cooldown-bypass-permission");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        if (!Cooldowns.returnCooldown(player, healCooldowns, cooldownTime)) {

            if (!staffCooldownBypass)
                Cooldowns.setCooldown(player, healCooldowns);
            else if (!player.hasPermission(staffBypassPermission))
                Cooldowns.setCooldown(player, healCooldowns);

            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
            player.setFoodLevel(20);
            player.setSaturation(20f);
            player.playSound(player, Sound.ENTITY_WANDERING_TRADER_DRINK_POTION, 1L, 1L);
            player.sendRichMessage(JortooCore.prefix + "You have healed yourself");

        }
        return true;
    }
}
