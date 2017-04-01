package me.slacktooth.slackgangs;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {

    private static ConfigurationSection general;
    private static ConfigurationSection settings;
    private static String reloadMessage;
    private static String noPermMessage;
    private static String createHelpMessage;
    private static String createMessage;
    private static String alreadyExistsMessage;
    private static String alreadyInGangMessage;
    private static String disbandMessage;
    private static String notLeaderMessage;
    private static String notInGangMessage;
    private static String inviteHelpMessage;
    private static String alreadyInvitedMessage;
    private static String alreadyInvitedOtherMessage;
    private static String inviteMessage;
    private static String invitedMessage;
    private static String notOnlineMessage;
    private static String leaveMessage;
    private static String cantLeaveMessage;
    private static String kickHelpMessage;
    private static String kickedMessage;
    private static String kickMessage;
    private static String renameHelpMessage;
    private static String renameMessage;
    private static String descHelpMessage;
    private static String setDescMessage;
    private static String notInvitedMessage;
    private static String joinMessage;
    private static String notInYourGangMessage;
    private static String cantKickYourselfMessage;
    private static String cantInviteMessage;
    private static String allyMessage;
    private static String unallyMessage;
    private static String noGangMessage;
    private static String allyHelpMessage;
    private static String infoHelpMessage;
    private static String disbandBroadcast;
    private static String inviteBroadcast;
    private static String joinBroadcast;
    private static String leaveBroadcast;
    private static String kickBroadcast;
    private static String renameBroadcast;
    private static String setDescBroadcast;
    private static String unallyBroadcast;
    private static String allyBroadcast;
    private static String chatMessage;
    private static String chatOnMessage;
    private static String chatOffMessage;
    private static String consoleMessage;
    private static List<String> infoMessage;
    private static List<String> helpMessage;
    private static String defaultGang;
    private static int maxNameLength;

    public static void loadConfig(FileConfiguration config) {
        general = config.getConfigurationSection("general");
        settings = config.getConfigurationSection("settings");
        reloadMessage = Utils.color(general.getString("reloadMessage"));
        noPermMessage = Utils.color(general.getString("noPermMessage"));
        createHelpMessage = Utils.color(general.getString("createHelpMessage"));
        createMessage = Utils.color(general.getString("createMessage"));
        alreadyExistsMessage = Utils.color(general.getString("alreadyExistsMessage"));
        alreadyInGangMessage = Utils.color(general.getString("alreadyInGangMessage"));
        disbandMessage = Utils.color(general.getString("disbandMessage"));
        notLeaderMessage = Utils.color(general.getString("notLeaderMessage"));
        notInGangMessage = Utils.color(general.getString("notInGangMessage"));
        inviteHelpMessage = Utils.color(general.getString("inviteHelpMessage"));
        alreadyInvitedMessage = Utils.color(general.getString("alreadyInvitedMessage"));
        alreadyInvitedOtherMessage = Utils.color(general.getString("alreadyInvitedOtherMessage"));
        inviteMessage = Utils.color(general.getString("inviteMessage"));
        invitedMessage = Utils.color(general.getString("invitedMessage"));
        notOnlineMessage = Utils.color(general.getString("notOnlineMessage"));
        leaveMessage = Utils.color(general.getString("leaveMessage"));
        cantLeaveMessage = Utils.color(general.getString("cantLeaveMessage"));
        kickHelpMessage = Utils.color(general.getString("kickHelpMessage"));
        kickedMessage = Utils.color(general.getString("kickedMessage"));
        kickMessage = Utils.color(general.getString("kickMessage"));
        renameHelpMessage = Utils.color(general.getString("renameHelpMessage"));
        renameMessage = Utils.color(general.getString("renameMessage"));
        descHelpMessage = Utils.color(general.getString("descHelpMessage"));
        setDescMessage = Utils.color(general.getString("setDescMessage"));
        notInvitedMessage = Utils.color(general.getString("notInvitedMessage"));
        joinMessage = Utils.color(general.getString("joinMessage"));
        notInYourGangMessage = Utils.color(general.getString("notInYourGangMessage"));
        cantKickYourselfMessage = Utils.color(general.getString("cantKickYourselfMessage"));
        cantInviteMessage = Utils.color(general.getString("cantInviteMessage"));
        allyMessage = Utils.color(general.getString("allyMessage"));
        unallyMessage = Utils.color(general.getString("unallyMessage"));
        noGangMessage = Utils.color(general.getString("noGangMessage"));
        allyHelpMessage = Utils.color(general.getString("allyHelpMessage"));
        infoHelpMessage = Utils.color(general.getString("infoHelpMessage"));
        disbandBroadcast = Utils.color(general.getString("disbandBroadcast"));
        inviteBroadcast = Utils.color(general.getString("inviteBroadcast"));
        joinBroadcast = Utils.color(general.getString("joinBroadcast"));
        leaveBroadcast = Utils.color(general.getString("leaveBroadcast"));
        kickBroadcast = Utils.color(general.getString("kickBroadcast"));
        renameBroadcast = Utils.color(general.getString("renameBroadcast"));
        setDescBroadcast = Utils.color(general.getString("setDescBroadcast"));
        unallyBroadcast = Utils.color(general.getString("unallyBroadcast"));
        allyBroadcast = Utils.color(general.getString("allyBroadcast"));
        chatMessage = Utils.color(general.getString("chatMessage"));
        chatOnMessage = Utils.color(general.getString("chatOnMessage"));
        chatOffMessage = Utils.color(general.getString("chatOffMessage"));
        consoleMessage = general.getString("consoleMessage");
        infoMessage = Utils.color(general.getStringList("infoMessage"));
        helpMessage = Utils.color(general.getStringList("helpMessage"));
        defaultGang = settings.getString("defaultGang");
        maxNameLength = settings.getInt("maxNameLength");
    }

    public static ConfigurationSection getGeneral() {
        return general;
    }

    public static ConfigurationSection getSettings() {
        return settings;
    }

    public static String getReloadMessage() {
        return reloadMessage;
    }

    public static String getNoPermMessage() {
        return noPermMessage;
    }

    public static String getCreateHelpMessage() {
        return createHelpMessage;
    }

    public static String getCreateMessage() {
        return createMessage;
    }

    public static String getAlreadyExistsMessage() {
        return alreadyExistsMessage;
    }

    public static String getAlreadyInGangMessage() {
        return alreadyInGangMessage;
    }

    public static String getDisbandMessage() {
        return disbandMessage;
    }

    public static String getNotLeaderMessage() {
        return notLeaderMessage;
    }

    public static String getNotInGangMessage() {
        return notInGangMessage;
    }

    public static String getInviteHelpMessage() {
        return inviteHelpMessage;
    }

    public static String getAlreadyInvitedMessage() {
        return alreadyInvitedMessage;
    }

    public static String getAlreadyInvitedOtherMessage() {
        return alreadyInvitedOtherMessage;
    }

    public static String getInviteMessage() {
        return inviteMessage;
    }

    public static String getInvitedMessage() {
        return invitedMessage;
    }

    public static String getNotOnlineMessage() {
        return notOnlineMessage;
    }

    public static String getLeaveMessage() {
        return leaveMessage;
    }

    public static String getCantLeaveMessage() {
        return cantLeaveMessage;
    }

    public static String getKickHelpMessage() {
        return kickHelpMessage;
    }

    public static String getKickedMessage() {
        return kickedMessage;
    }

    public static String getKickMessage() {
        return kickMessage;
    }

    public static String getRenameHelpMessage() {
        return renameHelpMessage;
    }

    public static String getRenameMessage() {
        return renameMessage;
    }

    public static String getDescHelpMessage() {
        return descHelpMessage;
    }

    public static String getSetDescMessage() {
        return setDescMessage;
    }

    public static String getNotInvitedMessage() {
        return notInvitedMessage;
    }

    public static String getJoinMessage() {
        return joinMessage;
    }

    public static String getNotInYourGangMessage() {
        return notInYourGangMessage;
    }

    public static String getCantKickYourselfMessage() {
        return cantKickYourselfMessage;
    }

    public static String getCantInviteMessage() {
        return cantInviteMessage;
    }

    public static String getAllyMessage() {
        return allyMessage;
    }

    public static String getUnallyMessage() {
        return unallyMessage;
    }

    public static String getNoGangMessage() {
        return noGangMessage;
    }

    public static String getAllyHelpMessage() {
        return allyHelpMessage;
    }

    public static String getInfoHelpMessage() {
        return infoHelpMessage;
    }

    public static String getDisbandBroadcast() {
        return disbandBroadcast;
    }

    public static String getInviteBroadcast() {
        return inviteBroadcast;
    }

    public static String getJoinBroadcast() {
        return joinBroadcast;
    }

    public static String getLeaveBroadcast() {
        return leaveBroadcast;
    }

    public static String getKickBroadcast() {
        return kickBroadcast;
    }

    public static String getRenameBroadcast() {
        return renameBroadcast;
    }

    public static String getSetDescBroadcast() {
        return setDescBroadcast;
    }

    public static String getUnallyBroadcast() {
        return unallyBroadcast;
    }

    public static String getAllyBroadcast() {
        return allyBroadcast;
    }

    public static String getChatMessage() {
        return chatMessage;
    }

    public static String getChatOnMessage() {
        return chatOnMessage;
    }

    public static String getChatOffMessage() {
        return chatOffMessage;
    }

    public static String getConsoleMessage() {
        return consoleMessage;
    }

    public static List<String> getInfoMessage() {
        return infoMessage;
    }

    public static List<String> getHelpMessage() {
        return helpMessage;
    }

    public static String getDefaultGang() {
        return defaultGang;
    }

    public static int getMaxNameLength() {
        return maxNameLength;
    }
}
