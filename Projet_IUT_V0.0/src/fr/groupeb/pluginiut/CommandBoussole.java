package fr.groupeb.pluginiut;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandBoussole implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			 player.sendMessage("�aCeci est une boussole");
			 ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
			 ItemMeta customN = customcompass.getItemMeta();
			customN.setDisplayName("T�l�porteur");
			customN.setLore(Arrays.asList("T�l�porteur"));
			customcompass.setItemMeta(customN);
			 player.getInventory().setItem(4, customcompass);
		}
		return false;
	}

}
