package me.robertle.itemcoinflip;

import me.robertle.itemcoinflip.Utils.CenterStringUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getLabel().equalsIgnoreCase("coinflip")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("accept")) {
                        if (player.hasPermission("coinflip.player")) {

                        } else {
                            player.sendMessage(Config.noPermission);
                        }
                    }
                    else if (args[0].equalsIgnoreCase("decline")) {
                        if (player.hasPermission("coinflip.player")) {

                        } else {
                            player.sendMessage(Config.noPermission);
                        }
                    }
                    else if (args[0].equalsIgnoreCase("reload")) {
                        if (player.hasPermission("coinflip.admin")) {

                        } else {
                            player.sendMessage(Config.noPermission);
                        }
                    }
                    //else if args 0 is player
                } else {
                    CenterStringUtil.sendCenteredMessage(player, "§a§lItem Coinflip §fv" + Core.version);
                    player.sendMessage("§2/cf §f<player>");
                    player.sendMessage("§2/cf §aaccept");
                    player.sendMessage("§2/cf §adecline");
                    player.sendMessage("§2/cf §areload");
                }
            } else {
                sender.sendMessage("§cOnly players can use this command.");
            }
        }
        return false;
    }

}
