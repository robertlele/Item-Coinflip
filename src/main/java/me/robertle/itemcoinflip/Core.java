package me.robertle.itemcoinflip;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    public static JavaPlugin instance;

    public static Economy econ;

    public static String version = "1.0";

    @Override
    public void onEnable() {
        instance = this;

        econ = getServer().getServicesManager().getRegistration(Economy.class).getProvider();

        getCommand("coinflip").setExecutor(new Commands());

        getServer().getPluginManager().registerEvents(new Events(), this);

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        new Config(getConfig()).loadConfig();

        Bukkit.getLogger().info("§aItem Coinflip v" + version + " by Poo enabled.");
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
