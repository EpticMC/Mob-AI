package org.nulldev.MobAI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.MathHelper;

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
        			//TODO: Nearest entity
        		}
        		else {
        			Integer range = plugin.getConfig().getInt("BlockDistance");
        			Location ploc = psender.getLocation();
        			List<Entity> entities = getEntities(ploc, range);
        			String chatPrefix = plugin.getConfig().getString("ChatPrefix");
        			if (entities.isEmpty()) psender.sendMessage(
        				(Object)ChatColor.DARK_GRAY + "[" + 
        				(Object)ChatColor.DARK_AQUA + chatPrefix + 
        				(Object)ChatColor.DARK_GRAY + "] " +
        				(Object)ChatColor.DARK_RED + "Error: No entity near you!"
        			);
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
    
    public static List<Entity> getEntities(Location location, double radius) {
        List<Entity> entities = new ArrayList<Entity>();
        World world = location.getWorld();

        // Find chunck by coordinates
        int smallX = MathHelper.floor((location.getX() - radius) / 16.0D);
        int bigX = MathHelper.floor((location.getX() + radius) / 16.0D);
        int smallZ = MathHelper.floor((location.getZ() - radius) / 16.0D);
        int bigZ = MathHelper.floor((location.getZ() + radius) / 16.0D);

        for (int x = smallX; x <= bigX; x++) 
        	for (int z = smallZ; z <= bigZ; z++) 
        		if (world.isChunkLoaded(x, z)) entities.addAll(Arrays.asList(world.getChunkAt(x, z).getEntities()));

        Iterator<Entity> entityIterator = entities.iterator();
        while (entityIterator.hasNext()) 
        	if (entityIterator.next().getLocation().distanceSquared(location) > radius * radius) entityIterator.remove(); 
        
        return entities;
    }
}
