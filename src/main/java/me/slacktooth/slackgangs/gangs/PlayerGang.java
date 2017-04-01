package me.slacktooth.slackgangs.gangs;

import me.slacktooth.slackgangs.CConfig;
import me.slacktooth.slackgangs.SlackGangs;
import me.slacktooth.slackgangs.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerGang implements Gang {

    private String name;
    private String desc;
    private String leader;
    private List<String> members;
    private List<String> allies;

    @Override
    public GangType getType() {
        return GangType.PLAYER;
    }

    @Override
    public boolean setName(String name) {
        CConfig config = SlackGangs.getGangs();

        if (!config.contains(name)) {
            FileConfiguration fileConfig = config.getConfig();

            GangManager.removeGang(this.name);
            GangManager.addGang(name, this);
            Utils.copySection(fileConfig, fileConfig.getConfigurationSection(this.name), name);
            config.set(this.name, null, true);
            config.saveConfig();
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        SlackGangs.getGangs().set(String.format("%s.desc", name), desc, true);
    }

    @Override
    public void setLeader(String leader) {
        this.leader = leader;
        SlackGangs.getGangs().set(String.format("%s.leader", name), leader, true);
    }

    @Override
    public void setLeader(Player player) {
        setLeader(player.getUniqueId().toString());
    }

    @Override
    public String getLeaderName() {
        String name = Utils.getName(leader);

        return name == null ? "Unknown" : name;
    }

    @Override
    public boolean isLeader(String leader) {
        return this.leader.equals(leader);
    }

    @Override
    public boolean isLeader(Player player) {
        return this.leader.equals(player.getUniqueId().toString());
    }

    @Override
    public List<String> getMemberNames() {
        List<String> names = new ArrayList<String>();

        for (String member : members) {
            String name = Utils.getName(member);

            if (name != null) {
                names.add(name);
            }
        }

        return names;
    }

    @Override
    public void setMembers(List<String> members) {
        this.members = members;
        SlackGangs.getGangs().set(String.format("%s.members", name), members, true);
    }
    
    @Override
    public boolean isMember(String member) {
        return this.members.contains(member);
    }

    @Override
    public boolean isMember(Player player) {
        return isMember(player.getUniqueId().toString());
    }
    
    @Override
    public void addMember(String member) {
        if (!members.contains(member)) {
            members.add(member);
            SlackGangs.getGangs().set(String.format("%s.members", name), members, true);
        }
    }

    @Override
    public void addMember(Player player) {
        addMember(player.getUniqueId().toString());
    }
    
    @Override
    public void removeMember(String member) {
        if (members.contains(member)) {
            members.remove(member);
            SlackGangs.getGangs().set(String.format("%s.members", name), members, true);
        }
    }

    @Override
    public void removeMember(Player player) {
        removeMember(player.getUniqueId().toString());
    }

    @Override
    public void setAllies(List<String> allies) {
        this.allies = allies;
        SlackGangs.getGangs().set(String.format("%s.allies", name), allies, true);
    }

    @Override
    public boolean isAlly(String ally) {
        return allies.contains(ally);
    }

    @Override
    public void addAlly(String ally) {
        if (!allies.contains(ally)) {
            allies.add(ally);
            SlackGangs.getGangs().set(String.format("%s.allies", name), allies, true);
        }
    }

    @Override
    public void removeAlly(String ally) {
        if (allies.contains(ally)) {
            allies.remove(ally);
            SlackGangs.getGangs().set(String.format("%s.allies", name), allies, true);
        }
    }

    @Override
    public void sendMessage(String message) {
        for (String member : members) {
            Player player = Bukkit.getPlayer(UUID.fromString(member));

            if (player != null) {
                player.sendMessage(message);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getLeader() {
        return leader;
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getAllies() {
        return allies;
    }
}
