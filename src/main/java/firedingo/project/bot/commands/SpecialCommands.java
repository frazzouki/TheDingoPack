package firedingo.project.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.QuitEvent;

/**
 * Created by firedingo on 1/1/2015.
 * This Project does contain an attached license and readme.
 * Please see these files for additonal information.
 * You can reach firedingo on twitter using the tag @firedingo
 */
public class SpecialCommands extends ListenerAdapter<PircBotX> {
    private static boolean enter = false;
//these commands are spammy at the moment
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        if (event.getMessage().equalsIgnoreCase("poke")) {
            event.getChannel().send().message("Hey That hurts, Quit it!");

        }
        if (enter == false) {
            if (event.getUser().getNick().equalsIgnoreCase("drwarfighter")) {
                event.getChannel().send().message("Hey Look It's The Sexy Dr :)");
                enter = true;
            }
        }
        if (event.getMessage().equalsIgnoreCase("!dr")) {
            event.getChannel().send().message("Look! Is It A Plane? Is It A Bird? No, It's The Royal Dr!!");
        }
    }
}
