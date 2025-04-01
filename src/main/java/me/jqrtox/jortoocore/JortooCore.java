package me.jqrtox.jortoocore;

import me.jqrtox.jortoocore.commands.other.*;
import me.jqrtox.jortoocore.commands.staff.*;
import me.jqrtox.jortoocore.commands.inventories.*;
import me.jqrtox.jortoocore.events.*;
import me.jqrtox.jortoocore.methods.ClearLag;
import org.bukkit.plugin.java.JavaPlugin;

public final class JortooCore extends JavaPlugin {

    public static JortooCore plugin;
    public static String prefix;
    public static String clearlagPrefix;

    @Override
    public void onEnable() {

        plugin = this;

        saveDefaultConfig();

        prefix = this.getConfig().getString("config.prefix");
        clearlagPrefix = this.getConfig().getString("config.clearlag-prefix");

        getServer().getPluginManager().registerEvents(new Crafting(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Leave(), this);
        getServer().getPluginManager().registerEvents(new VanishJoin(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);

        getCommand("clearlag").setExecutor(new ClearLagCommand());
        // Inventory commands
        getCommand("craft").setExecutor(new Craft());
        getCommand("anvil").setExecutor(new Anvil());
        getCommand("cartography").setExecutor(new Cartography());
        getCommand("grindstone").setExecutor(new Grindstone());
        getCommand("loom").setExecutor(new Loom());
        getCommand("smithingtable").setExecutor(new SmithingTable());
        getCommand("stonecutter").setExecutor(new StoneCutter());
        getCommand("enderchest").setExecutor(new Enderchest());
        // Staff commands
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("god").setExecutor(new GodMode());
        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("hat").setExecutor(new Hat());
        getCommand("freezechat").setExecutor(new FreezeChat());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("teleport").setExecutor(new Teleport());
        getCommand("invsee").setExecutor(new Invsee());
        // Other commands
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("suicide").setExecutor(new Suicide());

        ClearLag.clearLagInit();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
