package me.slacktooth.slackgangs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class CConfig {

    private FileConfiguration config;
    private File file;

    public CConfig(File folder, String name) {
        this.file = new File(folder, name);
        reloadConfig();
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (Exception exception) {
            SlackGangs.getInstance().getLogger().severe("Couldn't save SlackGangs config, please report this error to the developer: " + exception.getMessage());
        }
    }

    public <T> void set(String path, T value, boolean save) {
        if (path != null && !path.isEmpty()) {
            config.set(path, value);
            if (save) saveConfig();
        }
    }

    public <T> void set(String path, T value) {
        set(path, value, false);
    }

    public boolean getBoolean(String path, boolean revert) {
        return config.getBoolean(path, revert);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public File getFile() {
        return file;
    }
}
