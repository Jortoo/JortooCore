package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodMode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        if (player.isInvulnerable()) {
            player.setInvulnerable(false);
            player.sendRichMessage(JortooCore.prefix + "You have <red>Disabled<white> god mode");
            return true;
        }
        player.setInvulnerable(true);
        player.sendRichMessage(JortooCore.prefix + "You have <green>Enabled<white> god mode");
        return true;
    }
}
