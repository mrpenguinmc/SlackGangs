package me.slacktooth.slackgangs.listener.listeners;

import me.slacktooth.slackgangs.Config;
import me.slacktooth.slackgangs.listener.ListenerHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    private ListenerHandler handler;

    public PlayerChat(ListenerHandler handler) {
        this.handler = handler;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        String name = Config.getDefaultGang();
    }
}
