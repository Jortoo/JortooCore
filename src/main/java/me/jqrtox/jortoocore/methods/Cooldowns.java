package me.jqrtox.jortoocore.methods;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class Cooldowns {

    public static boolean returnCooldown(Player player, Map<UUID, Long> cooldowns, int cooldownTime) {

        UUID uniqueId = player.getUniqueId();

        if (!cooldowns.containsKey(uniqueId)) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long timeSinceLastUse = currentTime - cooldowns.get(uniqueId);
        long cdTime = (cooldownTime * 60L) * 1000;

        if (timeSinceLastUse >= cdTime) {
            return false;
        }

        timeSinceLastUse = currentTime - cooldowns.get(uniqueId);
        long timeLeft = (cdTime - timeSinceLastUse) / 1000;

        player.sendRichMessage(JortooCore.prefix + "You have to wait <yellow>" + timeLeft + "<white> seconds before using this again");
        return true;


    }

    public static void setCooldown(Player player, Map<UUID, Long> cooldown) {

        long currentTime = System.currentTimeMillis();
        cooldown.put(player.getUniqueId(), currentTime);

    }

}

