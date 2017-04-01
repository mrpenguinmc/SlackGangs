package me.slacktooth.slackgangs.gangs;

import org.bukkit.entity.Player;

import java.util.List;

public interface Gang {

    public GangType getType();
    public String getName();
    public List<String> getMemberNames();
    public boolean setName(String name);
    public void setDesc(String desc);
    public void setLeader(String leader);
    public void setLeader(Player player);
    public String getLeaderName();
    public boolean isLeader(String leader);
    public boolean isLeader(Player player);
    public void setMembers(List<String> members);
    public boolean isMember(String member);
    public boolean isMember(Player player);
    public void addMember(String member);
    public void addMember(Player player);
    public void removeMember(String member);
    public void removeMember(Player player);
    public void setAllies(List<String> allies);
    public boolean isAlly(String ally);
    public void addAlly(String ally);
    public void removeAlly(String ally);
    public void sendMessage(String message);
}
