package firedingo.project.bot.commands;

import firedingo.project.bot.Levels.Permitted;
import firedingo.project.bot.TheDingoPack;
import firedingo.project.bot.events.EventHandler;
import firedingo.project.bot.reference.Reference;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;
import firedingo.project.bot.TheDingoPack;

import java.sql.Ref;

/**
 * Created by firedingo on 1/1/2015.
 * This Project does contain an attached license and readme.
 * Please see these files for additonal information.
 * You can reach firedingo on twitter using the tag @firedingo
 */


public class BasicCommands extends ListenerAdapter<PircBotX> {
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        if (Reference.visitor == false) {

            if (event.getMessage().equalsIgnoreCase("hello")) {
                event.getChannel().send().message("Hello " + event.getUser().getNick());
            }

            if (event.getMessage().equalsIgnoreCase("hey")) {
                event.getChannel().send().message("Hey " + event.getUser().getNick());
            }
            if (event.getMessage().equalsIgnoreCase("!version")) {
                event.getChannel().send().message("The bot is currently in version " + Reference.VERSION);
            }
            if (event.getMessage().equalsIgnoreCase("!code")) {
                event.getChannel().send().message("The Bot's Source Code Can Be Found Here: https://github.com/firedingo/TheDingoPack");
            }
            if (event.getMessage().contains("o/")) {
                event.getChannel().send().message("Hello " + event.getUser().getNick() + " o/");
            }
            if (event.getMessage().contains("www.") || (event.getMessage().contains("http://"))) {
                event.getChannel().send().message("You are not permitted to post Links! Bye Bye Link o/");
                event.getChannel().send().message(".timeout " + event.getUser().getNick() + " 1");
            }
            //for testing can be removed later
            if (event.getMessage().contains("!opMe")) {
                event.getChannel().send().op(event.getUser());
            }
            if (event.getMessage().length() > 300) {
                event.getChannel().send().message("Stop Sending Walls Of Text! Message Too Long!");
                event.getChannel().send().message(".timeout " + event.getUser().getNick() + " 1");
            }
            //ban a user through the bot
          //  if (event.getMessage().)
            //host a channel manually
           // if (event.getMessage().)
            //Can join channel but seems to have issues with hosting, will need further testing
            if (event.getMessage().equalsIgnoreCase("!join")) {
                event.getChannel().send().message("Now Joining the Channel #" + event.getUser().getNick() +
                        ". Please Use !leave If you want me to leave!");
                event.getBot().sendIRC().joinChannel("#" + event.getUser().getNick());
            }

            if (event.getMessage().equalsIgnoreCase("!leave")) {
                event.getChannel().send().part();
            }

        }//End Visitor If
        if(Permitted.Streamer.compareToIgnoreCase(event.getUser().getNick()) == 0) {
            if (event.getMessage().equalsIgnoreCase("!visitor")) {
                if (Reference.visitor == false) {
                    Reference.visitor = true;
                    event.getChannel().send().message("The Visitor Mode Has Been Turned On!");
                } else if (Reference.visitor == true) {
                    Reference.visitor = false;
                    event.getChannel().send().message("The Visitor Mode Has Been Turned Off!");
                }
            }
        }
        else {
            event.getChannel().send().message("You do not have the permission to run that Command!");
        }


    }
}
