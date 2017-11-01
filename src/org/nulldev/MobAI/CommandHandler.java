package org.nulldev.MobAI;

import org.bukkit.ChatColor;
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
    		if (args.length > 0){
    			Boolean onlyNearestMob = plugin.getConfig().getBoolean("OnlyNearestMob");
        		if (onlyNearestMob){
        			
        		}
        		else {
        			//TODO: Get mobs in radius
        		}
    		}
    		else {
    			psender.sendMessage(
    				(Object)ChatColor.DARK_AQUA + "--=== "      +  
    				(Object)ChatColor.YELLOW + "USAGE:"         + 
    				(Object)ChatColor.DARK_AQUA + " ===--\n- "  +
    				(Object)ChatColor.YELLOW + "/mob YOUR TEXT" +
    				(Object)ChatColor.DARK_AQUA + " -\n"        +
    				"--==============--"
    			);
    		}
    		return true;
    	}
    }
}
