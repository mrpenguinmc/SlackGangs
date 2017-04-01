package me.slacktooth.slackgangs.gangs;

import me.slacktooth.slackgangs.CConfig;
import me.slacktooth.slackgangs.SlackGangs;
import me.slacktooth.slackgangs.Utils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GangManager {

    private static Map<String, PlayerGang> gangs = new ConcurrentHashMap<String, PlayerGang>();
    private static Map<String, Gang> players = new ConcurrentHashMap<String, Gang>();

    public static void clearGangs() {
        gangs.clear();
    }

    public static void clearPlayers() {
        players.clear();
    }

    public static Gang getGang(String name) {
        Gang gang = gangs.get(name);
        return gang == null ? createGang(name) : gang;
    }

    public static Gang createGang(String name) {
        FileConfiguration config = SlackGangs.getGangs().getConfig();
        ConfigurationSection section = config.getConfigurationSection(name);

        if (section != null && section.contains("desc") && section.contains("leader") && section.contains("members") && section.contains("allies")) {
            String desc = Utils.color(section.getString("desc"));
            String leader = section.getString("leader");
            List<String> members = section.getStringList("members");
            List<String> allies = section.getStringList("allies");
            PlayerGang playerGang = new PlayerGang(name, desc, leader, members, allies);

            gangs.put(name, playerGang);
            return playerGang;
        }
        return null;
    }
    public static Set<String> getAllGangs() {
        return SlackGangs.getGangs().getConfig().getKeys(false);
    }

    public static Gang getGang(Player player) {
        String uuid = player.getUniqueId().toString();
        Gang gang = players.get(uuid);

        if (gang == null) {
            FileConfiguration config = SlackGangs.getGangs().getConfig();

            for (String name : getAllGangs()) {
                gang = gangs.get(name);

                if (gang == null) {
                    if (config.getStringList(String.format("%s.members", name)).contains(uuid)) {
                        gang = getGang(name);
                        if (gang == null) {
                            gang = new FakeGang();
                        }
                        players.put(uuid, gang);
                        return gang;
                    }
                } else if (gang.isMember(uuid)) {
                    players.put(uuid, gang);
                    return gang;
                }
            }
            gang = new FakeGang();
            players.put(uuid, gang);
            return gang;
        }
        return gang;
    }

    public static void createGang(String name, String desc, String leader) {
        PlayerGang gang = new PlayerGang(name, desc, leader, new ArrayList<String>(Arrays.asList(leader)), new ArrayList<String>());
        CConfig cConfig = SlackGangs.getGangs();
        FileConfiguration config = cConfig.getConfig();

        gangs.put(name, gang);
        players.put(leader, gang);
        config.set(String.format("%s.desc", name), desc);
        config.set(String.format("%s.leader", name), leader);
        config.set(String.format("%s.members", name), gang.getMembers());
        config.set(String.format("%s.allies", name), gang.getAllies());
        cConfig.saveConfig();
    }
    public static void createGang(String name, String desc, Player leader) {
        createGang(name, desc, leader.getUniqueId().toString());
    }

    public static void removeGang(PlayerGang Gang) {
        String name = Gang.getName();

        gangs.remove(name);

        for (Map.Entry<String, Gang> entry : players.entrySet()) {
            if (entry.getValue() instanceof PlayerGang) {
                PlayerGang playerGang = (PlayerGang) entry.getValue();

                if (playerGang.getName().equals(name)) {
                    players.remove(entry.getKey());
                }
            }
        }
        SlackGangs.getGangs().set(name, null, true);
    }

    public static boolean isInGang(Player player) {
        Gang gang = getGang(player);

        return gang != null && gang instanceof PlayerGang;
    }

    public static boolean doesGangExist(String name) {
        return gangs.containsKey(name) || SlackGangs.getGangs().contains(name);
    }

    public static void removePlayer(String uuid) {
        players.remove(uuid);
    }

    public static void setPlayer(String uuid, Gang Gang) {
        players.put(uuid, Gang);
    }

    public static void removeGang(String name) {
        players.remove(name);
    }

    public static void addGang(String name, Gang Gang) {
        players.put(name, Gang);
    }
}
