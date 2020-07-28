package me.robertle.itemcoinflip;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static String prefix;
    public static String noPermission;
    public static String receiveItem;
    public static String receiveMoney;

    private FileConfiguration config;

    public void loadConfig() {
        prefix = ChatColor.translateAlternateColorCodes('&', config.getString("Prefix"));
        noPermission = ChatColor.translateAlternateColorCodes('&', config.getString("No Permission"));
        receiveItem = ChatColor.translateAlternateColorCodes('&', config.getString("Receive Item"));
        receiveMoney = ChatColor.translateAlternateColorCodes('&', config.getString("Receive Money"));
    }

    public Config(FileConfiguration config) {
        this.config = config;
    }

}
