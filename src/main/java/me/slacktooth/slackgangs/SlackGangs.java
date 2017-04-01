package me.slacktooth.slackgangs;

import me.slacktooth.slackgangs.listener.ListenerHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStreamReader;

public class SlackGangs extends JavaPlugin {

    private static SlackGangs instance;
    public static CConfig gangs;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        new ListenerHandler(this);
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        gangs = new CConfig(getDataFolder(), "gangs.yml");
        Config.loadConfig(getConfig());
        FileConfiguration plugin = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource("plugin.yml")));
        for (String command : plugin.getConfigurationSection("commands").getKeys(false)) {
            getCommand(command).setPermissionMessage(Config.getNoPermMessage());
        }
    }

    public static SlackGangs getInstance() {
        return instance;
    }

    public static CConfig getGangs() {
        return gangs;
    }
}
