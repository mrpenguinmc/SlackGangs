package me.slacktooth.slackgangs.listener;

import me.slacktooth.slackgangs.SlackGangs;
import me.slacktooth.slackgangs.listener.listeners.PlayerChat;
import org.bukkit.event.Listener;

public class ListenerHandler {

    private SlackGangs instance;

    public ListenerHandler(SlackGangs instance) {
        this.instance = instance;
    }

    private Listener[] listeners = {
            new PlayerChat(this)
    };

    private void loadListeners() {
        for (Listener listener : listeners) {
            instance.getServer().getPluginManager().registerEvents(listener, instance);
        }
    }
}
