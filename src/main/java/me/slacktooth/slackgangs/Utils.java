package me.slacktooth.slackgangs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.json.simple.parser.JSONParser;

import java.util.List;
import java.util.UUID;

public class Utils {

    private static final JSONParser parser = new JSONParser();

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String stripColor(String string) {
        return ChatColor.stripColor(string);
    }

    public static String limit(String string, int length) {
        return string.substring(0, Math.min(string.length(), length));
    }

    public static List<String> color(List<String> list) {
        for (int i = 0, s = list.size(); i < s; i++) {
            list.set(i, color(list.get(i)));
        }

        return list;
    }

    public static void sendMessages(CommandSender sender, List<String> messages) {
        for (String message : messages) {
            sender.sendMessage(message);
        }
    }

    public static void emptySection(ConfigurationSection section) {
        for (String key : section.getKeys(true)) {
            section.set(key, null);
        }
    }

    public static void emptySection(FileConfiguration config, String path) {
        ConfigurationSection section = config.getConfigurationSection(path);

        if (section != null) {
            emptySection(section);
        }
    }

    public static void copySection(FileConfiguration config, ConfigurationSection origin, String target) {
        config.set(target, null);

        for (String key : origin.getKeys(true)) {
            config.set(String.format("%s.%s", target, key), origin.get(key));
        }
    }

    public static String buildString(String[] args, int start) {
        StringBuilder builder = new StringBuilder();

        for (int i = start, s = args.length; i < s; i++) {
            builder.append(args[i]).append(" ");
        }

        return builder.toString().trim();
    }

    public static String buildEnumeration(List<String> list) {
        if (!list.isEmpty()) {
            StringBuilder builder = new StringBuilder();

            for (String string : list) {
                builder.append(", ").append(string);
            }

            return builder.toString().substring(2);
        } else {
            return "None";
        }
    }

    public static String getName(String uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));

        return player == null ? null : player.getName();
    }

    public static JSONParser getParser() {
        return parser;
    }
}
