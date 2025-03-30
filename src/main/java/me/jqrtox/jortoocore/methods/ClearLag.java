package me.jqrtox.jortoocore.methods;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class ClearLag {

    public static void clearLagInit() {

        Bukkit.getScheduler().runTaskTimer(JortooCore.plugin, s -> {

            clearLag();

        }, 20 * (60L * rtClearlagInterval()), 20 * (60L * rtClearlagInterval()));

    }

    public static void clearLag() {

        int entityAmount = 0;

        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity.getType() != EntityType.ITEM) continue;
                entity.remove();
                entityAmount++;
            }
        }

        MiniMessage mm = MiniMessage.miniMessage();
        Bukkit.broadcast(mm.deserialize(JortooCore.clearlagPrefix + "Cleared <yellow>" + entityAmount + "<white> dropped items"));

    }

    public static int rtClearlagInterval() {

        FileConfiguration config = JortooCore.plugin.getConfig();
        int clearLagInterval = 0;
        clearLagInterval = (clearLagInterval + config.getInt("config.clearlag-interval"));
        return clearLagInterval;
    }

}
