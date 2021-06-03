package fr.groupeb.pluginiut;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		
		Player player = event.getPlayer();
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear @p" );
		ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
		player.sendMessage("Bienvenue sur le campus de Poitiers,");
		player.sendMessage("Grâce à votre boussole vous pouvez vous téléportez à travers tout le campus.");
		player.sendMessage("Si jamais vous ne l'avez plus faites /boussole");
		player.sendMessage("Pour plus d'aide faites /aide");
		ItemMeta customN = customcompass.getItemMeta();
		customN.setDisplayName("Téléporteur");
		customN.setLore(Arrays.asList("Téléporteur"));
		customcompass.setItemMeta(customN);
		player.getInventory().setItem(4, customcompass);
		
		player.updateInventory();
		
		
	}

	@EventHandler
	public void onIteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;
		if(it.getType () == Material.COOKIE) {
			if(action == Action.RIGHT_CLICK_AIR) {
				player.sendMessage("Ceci est un cookie :)");
			}
			}
		
	if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Téléporteur")) {
			
			Inventory inv = Bukkit.createInventory(null, 27,"§8Le Menu");
			
			ItemStack customlaineB = new ItemStack(Material.BLUE_WOOL, 1);
			ItemMeta LaineB = customlaineB.getItemMeta();
			LaineB.setDisplayName("Zone A");
			customlaineB.setItemMeta(LaineB);
			
			ItemStack customlaineR = new ItemStack(Material.RED_WOOL, 1);
			ItemMeta LaineR = customlaineR.getItemMeta();
			LaineR.setDisplayName("Zone B");
			customlaineR.setItemMeta(LaineR);
			
			ItemStack customlaineY = new ItemStack(Material.YELLOW_WOOL, 1);
			ItemMeta LaineY = customlaineY.getItemMeta();
			LaineY.setDisplayName("Zone C");
			customlaineY.setItemMeta(LaineY);
			
			inv.setItem(11, customlaineB);
			inv.setItem(13, customlaineR);
			inv.setItem(15, customlaineY);
			

			player.openInventory(inv);
			
			
	}

	}
	
	@EventHandler
	public void onPlayerClickInventory(InventoryClickEvent event) {
		 

			Player player = (Player) event.getWhoClicked();
			ItemStack current = event.getCurrentItem();
			
			if(current == null) return ;
			
			 if(event.getView().getTitle().equalsIgnoreCase("§8Le menu")) { 
				 
				 event.setCancelled(true);
				 if(current.getType() == Material.RED_WOOL ) {
					 
					player.closeInventory();
					event.setCancelled(true);
					player.sendMessage("Zone B sélectionnée ");
					Inventory inv2 = Bukkit.createInventory(null, 27,"§8Zone B");
					inv2.setItem(1, getItem(Material.RED_WOOL, "B2"));
					inv2.setItem(2, getItem(Material.RED_WOOL, "B3"));
					inv2.setItem(3, getItem(Material.RED_WOOL, "B4"));
					inv2.setItem(4, getItem(Material.RED_WOOL, "B5"));
					inv2.setItem(5, getItem(Material.RED_WOOL, "B7"));
					inv2.setItem(6, getItem(Material.RED_WOOL, "B8"));
					inv2.setItem(7, getItem(Material.RED_WOOL, "B9"));
					inv2.setItem(10, getItem(Material.RED_WOOL, "B10"));
					inv2.setItem(11, getItem(Material.RED_WOOL, "B11"));
					inv2.setItem(12, getItem(Material.RED_WOOL, "B13"));
					inv2.setItem(13, getItem(Material.RED_WOOL, "B14"));
					inv2.setItem(14, getItem(Material.RED_WOOL, "B25"));
					inv2.setItem(15, getItem(Material.RED_WOOL, "B27"));
					inv2.setItem(16, getItem(Material.RED_WOOL, "B28"));
					inv2.setItem(19, getItem(Material.RED_WOOL, "B31"));
					inv2.setItem(20, getItem(Material.RED_WOOL, "B34"));
					inv2.setItem(21, getItem(Material.RED_WOOL, "B35"));
					player.openInventory(inv2);
					
				 }
				 if(current.getType() == Material.BLUE_WOOL ) {
					
					 player.closeInventory();
					 event.setCancelled(true);
					 player.sendMessage("Zone A sélectionnée ");
					 Inventory inv3 = Bukkit.createInventory(null, 27,"§8Zone A");
					 inv3.setItem(1, getItem(Material.BLUE_WOOL, "A1"));
					 inv3.setItem(2, getItem(Material.BLUE_WOOL, "A2"));
					 inv3.setItem(3, getItem(Material.BLUE_WOOL, "A3"));
					 inv3.setItem(4, getItem(Material.BLUE_WOOL, "A4"));
					 inv3.setItem(5, getItem(Material.BLUE_WOOL, "A5"));
					 inv3.setItem(6, getItem(Material.BLUE_WOOL, "A6"));
					 inv3.setItem(7, getItem(Material.BLUE_WOOL, "A7"));
					 inv3.setItem(10, getItem(Material.BLUE_WOOL, "A8"));
					 inv3.setItem(11, getItem(Material.BLUE_WOOL, "A9"));
					 player.openInventory(inv3);

				 }
				 if(current.getType() == Material.YELLOW_WOOL ) {
					
					 player.closeInventory();
					 event.setCancelled(true);
					 player.sendMessage("Zone C sélectionnée ");
					 Inventory inv4 = Bukkit.createInventory(null, 27,"§8Zone C");
					 inv4.setItem(1, getItem(Material.YELLOW_WOOL, "C1"));
					 inv4.setItem(2, getItem(Material.YELLOW_WOOL, "C4"));
					 inv4.setItem(3, getItem(Material.YELLOW_WOOL, "C5"));
					 inv4.setItem(4, getItem(Material.YELLOW_WOOL, "C6"));
					 inv4.setItem(5, getItem(Material.YELLOW_WOOL, "C7"));
					 inv4.setItem(6, getItem(Material.YELLOW_WOOL, "C8"));
					 inv4.setItem(7, getItem(Material.YELLOW_WOOL, "C9"));
					 inv4.setItem(10, getItem(Material.YELLOW_WOOL, "C10"));
					 inv4.setItem(11, getItem(Material.YELLOW_WOOL, "C11"));
					 inv4.setItem(12, getItem(Material.YELLOW_WOOL, "C12"));
					 inv4.setItem(13, getItem(Material.YELLOW_WOOL, "C13"));
					 inv4.setItem(14, getItem(Material.YELLOW_WOOL, "C14"));
					 inv4.setItem(15, getItem(Material.YELLOW_WOOL, "C15"));
					 inv4.setItem(16, getItem(Material.YELLOW_WOOL, "C16"));
					 inv4.setItem(19, getItem(Material.YELLOW_WOOL, "C17"));
					 inv4.setItem(20, getItem(Material.YELLOW_WOOL, "C20"));
					 inv4.setItem(21, getItem(Material.YELLOW_WOOL, "C21"));
					 player.openInventory(inv4);
				 }	
				 
			 }
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B2"))
					{
						player.closeInventory();
						player.sendMessage("Téléportation en B2 ");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -382 64 48" );
					}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B3"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B3 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -287 64 55" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B4"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B4 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -326 63 118" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B5"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B5 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -385 63 114" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B7"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B7 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -232 64 152" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B8"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B8 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -170 64 276" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B9"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B9 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -343 67 388" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B10"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B10 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -516 63 277" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B11"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B11 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -581 63 206" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B13"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B13 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -171 70 -67" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B14"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B14 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -92 72 -83" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B25"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B25 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -129 71 -27" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B27"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B27 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -172 68 121" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B28"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B28 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -129 69 96" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B31"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B31 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -8 72 194" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B34"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B34 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -218 68 29" );
}
if(current.getType() == Material.RED_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("B35"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en B35 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -108 68 237" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C1"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C1 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 154 75 54" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C4"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C4 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 164 70 286" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C5"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C5 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 304 70 237" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C6"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C6 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 369 72 215" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C7"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C7 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 343 72 164" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C8"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C8 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 489 73 210" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C9"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C9 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 544 75 187" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C10"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C10 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 659 78 229" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C11"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C11 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 645 78 191" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C12"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C12 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 623 77 229" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C13"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C13 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 563 75 160" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C14"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C14 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 620 77 156" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C15"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C15 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 504 76 69" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C16"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C16 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 488 76 65" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C17"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C17 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 507 76 87" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C20"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C20 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 169 74 -151" );
}
if(current.getType() == Material.YELLOW_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("C21"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en C21 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 421 71 -304" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A1"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A1 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -535 63 -81" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A2"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A2 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -527 63 -190" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A3"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A3 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -413 63 -184" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A4"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A4 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -270 65 -206" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A5"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A5 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -160 66 -266" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A6"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A6 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p -62 69 -255" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A7"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A7 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 0 68 -320" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A8"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A8 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 29 67 -362" );
}
if(current.getType() == Material.BLUE_WOOL && current.hasItemMeta() && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().equalsIgnoreCase("A9"))
{
	player.closeInventory();
	player.sendMessage("Téléportation en A9 ");
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @p 80 70 -307" );
}
}
			
	
	public ItemStack getItem(Material material, String customName) {
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		itM.setDisplayName(customName);
		it.setItemMeta(itM);
		return it ;
		
	}
}
	

