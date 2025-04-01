package me.jqrtox.jortoocore.commands.staff;

import me.jqrtox.jortoocore.JortooCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FreezeChat implements CommandExecutor {

    public static List<String> serverToggles = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        MiniMessage mm = MiniMessage.miniMessage();

        if (serverToggles.contains("chat-freeze")) {

            serverToggles.remove("chat-freeze");
            Bukkit.broadcast(mm.deserialize(JortooCore.prefix + "A staff member has unfrozen the chat! you can speak again"));
            return true;
        }

        serverToggles.add("chat-freeze");
        Bukkit.broadcast(mm.deserialize(JortooCore.prefix + "A staff member has frozen the chat! you can speak again when unfrozen"));
        return true;
    }
}
