package firedingo.project.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by firedingo on 2/1/2015.
 * This Project does contain an attached license and readme.
 * Please see these files for additonal information.
 * You can reach firedingo on twitter using the tag @firedingo
 */
public class FunCommands extends ListenerAdapter<PircBotX> {
    private static String userVariable;

//these commands work well, need to add next step to some
        public void onMessage (MessageEvent < PircBotX > event)throws Exception {
            userVariable = event.getMessage().substring(5);
            if (event.getMessage().contains("!slap")) {
                event.getChannel().send().message(event.getUser().getNick() + " Slaps " + userVariable + " in the face!");
            }
            userVariable = event.getMessage().substring(5);
            if (event.getMessage().contains("!gift")) {
                event.getChannel().send().message((event.getUser().getNick() + " Has Given You A Present " + userVariable
                + ". Awww Isn't That Nice! Why Don't you !open it."));
            }
            if (event.getMessage().equalsIgnoreCase("!open")) {
                event.getChannel().send().message("Aww Look You Got a <3 :)");
            }
        }
    }