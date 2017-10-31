package org.nulldev.MobAI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    private Main plugin;
    public CommandHandler(Main plugin) { this.plugin = plugin; }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player)) {
        	sender.sendMessage("This command can't be executed from the console");
            return false;
		}
    	else {
    		Player psender = (Player)sender;
    		return true;
    	}

    }
}
