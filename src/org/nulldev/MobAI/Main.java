package org.nulldev.MobAI;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import org.nulldev.MobAI.CommandHandler;


public class Main extends JavaPlugin {
    public static Main instance;
    public File f;
    public YamlConfiguration wfile;
    public Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {
    	PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(String.valueOf(pdfFile.getName())) + " Version: " + pdfFile.getVersion() + " by NullDev [EpticMC] has been enabled!");
        this.generateFiles();
        instance = this;
        
        String[] cmd = {"mob", "mobai"};
        for (int i = 0; i < cmd.length; i++) this.getCommand(cmd[i]).setExecutor((CommandExecutor) new CommandHandler(this));
    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(String.valueOf(pdfFile.getName())) + " Version: " + pdfFile.getVersion() + " by NullDev [EpticMC] has been disabled!");
    }

    private void generateFiles() {
        File config = new File(this.getDataFolder(), "config.yml");
        if (!config.exists()) {
            this.saveDefaultConfig();
            this.getLogger().info("config.yml created.");
        }
    }

    public static Main getInstance() { return instance; }
}
