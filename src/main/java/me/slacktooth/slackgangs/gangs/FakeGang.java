package me.slacktooth.slackgangs.gangs;

import me.slacktooth.slackgangs.Config;
import org.bukkit.entity.Player;

import java.util.List;

public class FakeGang implements Gang {

    @Override
    public GangType getType() {
        return GangType.FAKE;
    }

    @Override
    public String getName() {
        return Config.getDefaultGang();
    }

    @Override
    public List<String> getMemberNames() {
        return null;
    }

    @Override
    public boolean setName(String name) {
        return false;
    }

    @Override
    public void setDesc(String desc) {}

    @Override
    public void setLeader(String leader) {}

    @Override
    public void setLeader(Player player) {}

    @Override
    public boolean isLeader(String leader) {
        return false;
    }

    @Override
    public boolean isLeader(Player player) {
        return false;
    }

    @Override
    public void setMembers(List<String> members) {}

    @Override
    public boolean isMember(String member) {
        return false;
    }

    @Override
    public boolean isMember(Player player) {
        return false;
    }

    @Override
    public void addMember(String member) {}

    @Override
    public void addMember(Player player) {}

    @Override
    public void removeMember(String member) {}

    @Override
    public void removeMember(Player player) {}

    @Override
    public void setAllies(List<String> allies) {}

    @Override
    public boolean isAlly(String ally) {
        return false;
    }

    @Override
    public void addAlly(String ally) {}

    @Override
    public void removeAlly(String ally) {}

    @Override
    public void sendMessage(String message) {}

    @Override
    public String getLeaderName() {
        return "Unknown";
    }
}
