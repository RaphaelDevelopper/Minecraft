package fr.groupeb.pluginiut;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin vient de s'allumer");
		getCommand("test").setExecutor(new CommandTest());
		getServer().getPluginManager().registerEvents(new MainListener(), this);
		getCommand("boussole").setExecutor(new CommandBoussole());
		getCommand("aide").setExecutor(new CommandAide());
		
		
		
		
	}
	
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin s'eteint ");
	}

}
