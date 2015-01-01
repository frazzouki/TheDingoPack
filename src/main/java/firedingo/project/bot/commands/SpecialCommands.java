package firedingo.project.bot.commands;

import firedingo.project.bot.reference.Reference;
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
        if (Reference.visitor == false) {
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
        }//End visitor If

        if (event.getMessage().split(" ")[0].equalsIgnoreCase("!streaming")) {
            event.getBot().sendIRC().joinChannel("#" + event.getMessage().split(" ")[1]);
            //insert delay here
            event.getChannel().send().message("Hello " + event.getMessage().split(" ")[1] + " I'm Firedingo99365's Bot Project For Experience's Sake."
            + "I just dropped by to tell you I Hope You have a good stream!");
            event.getChannel().send().part();
        }
        else {
            event.respond("The Correct Syntax Is !streaming <username>");
        }
    }
}
