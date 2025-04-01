package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        if (s.equals("gamemode") || s.equals("gm")) {

            String prefix = JortooCore.prefix;
            if (args.length < 1) {
                player.sendRichMessage(prefix + "Correct usage: /gamemode <gamemode> [<player>]");
                return false;
            }
            if (args.length != 2) {
                player.setGameMode(GameMode.valueOf(args[0].toUpperCase()));
                player.sendRichMessage(prefix + "Your gamemode has been set to: <yellow>" + args[0]);
                return true;
            }

            Player targetPlayer = Bukkit.getPlayer(args[1]);
            if (!targetPlayer.isOnline()) {
                player.sendRichMessage(prefix + "This player is not online");
                return false;
            }
            targetPlayer.setGameMode(GameMode.valueOf(args[0].toUpperCase()));
            targetPlayer.sendRichMessage(prefix + "Your gamemode has been set to: <yellow>" + args[0]);
            return true;
        }

        Player targetPlayer;

        if (args.length > 0) {
            targetPlayer = Bukkit.getPlayer(args[0]);
            if (!targetPlayer.isOnline()) {
                player.sendRichMessage(JortooCore.prefix + "This player is not online!");
                return false;
            }
        } else {
            targetPlayer = player;
        }

        switch (s) {
            case "gms" -> {
                targetPlayer.setGameMode(GameMode.SURVIVAL);
                targetPlayer.sendRichMessage(JortooCore.prefix + "Your gamemode has been set to: <yellow>Survival");
            }
            case "gmsp" -> {
                targetPlayer.setGameMode(GameMode.SPECTATOR);
                targetPlayer.sendRichMessage(JortooCore.prefix + "Your gamemode has been set to: <yellow>Spectator");
            }
            case "gmc" -> {
                targetPlayer.setGameMode(GameMode.CREATIVE);
                targetPlayer.sendRichMessage(JortooCore.prefix + "Your gamemode has been set to: <yellow>Creative");
            }
            case "gma" -> {
                targetPlayer.setGameMode(GameMode.ADVENTURE);
                targetPlayer.sendRichMessage(JortooCore.prefix + "Your gamemode has been set to: <yellow>Adventure");
            }
        }

        return true;
    }

}
