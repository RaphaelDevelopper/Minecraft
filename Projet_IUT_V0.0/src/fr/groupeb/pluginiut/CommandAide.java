package fr.groupeb.pluginiut;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class CommandAide implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("�a==============================================");
			player.sendMessage("	Pour pouvoir se d�placer dans le campus            ");
			player.sendMessage("	vous pouvez cliquer sur la boussole pour acc�der   ");
			player.sendMessage("	aux 3 zones. Ensuite choisissez votre zone puis    ");
			player.sendMessage("	choisissez votre b�timent pour vous y t�l�porter.  ");
			player.sendMessage("	Sinon vous pouvez vous balader.                    ");
			player.sendMessage("�a==============================================");

		}
		return false;
	}

}
