package me.robertle.itemcoinflip.Coinflip;

import me.robertle.itemcoinflip.Config;
import me.robertle.itemcoinflip.Core;
import me.robertle.itemcoinflip.Utils.ItemHelper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CoinflipLoot {

    public List<ItemStack> items = new ArrayList<>();
    public int money = 0;

    public CoinflipLoot() {}

    public void claimLoot(Player player) {
        for (ItemStack i : items) {
            if (i != null)
                givePlayerItem(player, i);
            player.sendMessage(Config.receiveItem.replaceAll("%amount%", String.valueOf(i.getAmount())).replaceAll("%item%", ItemHelper.getName(i)));
        }
        items.clear();
        Core.econ.depositPlayer(player, money);
        player.sendMessage(Config.receiveItem.replaceAll("%money%", String.valueOf(money)));
        money = 0;
    }

    public void givePlayerItem(Player player, ItemStack item) {
        for (ItemStack i : player.getInventory().addItem(item).values()) {
            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), i);
        }
    }

}
