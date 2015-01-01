package firedingo.project.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by firedingo on 1/1/2015.
 * This Project does contain an attached license and readme.
 * Please see these files for additonal information.
 * You can reach firedingo on twitter using the tag @firedingo
 */


public class BasicCommands extends ListenerAdapter<PircBotX> {
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {

        if (event.getMessage().equalsIgnoreCase("hello")) {
            event.getChannel().send().message("Hello " + event.getUser().getNick());
        }

        if (event.getMessage().equalsIgnoreCase("hey")) {
            event.getChannel().send().message("Hey " + event.getUser().getNick());
        }
    }
}
