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
            if (event.getMessage().equalsIgnoreCase("!commands")) {
                event.getChannel().send().message("The commands for the bot can be found at: https://github.com/firedingo/TheDingoPack/blob/master/README.md");
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
            if (event.getUser().getNick().compareToIgnoreCase("firedingo99365") == 0) {
                if (event.getMessage().contains("!opMe")) {
                   // event.getChannel().send().op(event.getUser());
                    event.getChannel().send().message(".mod " + event.getUser().getNick());
                    event.getChannel().send().message("Now Giving Mod To " + event.getUser().getNick());
                }
                if (event.getMessage().contains("!deopMe")) {
                    //event.getChannel().send().deOp(event.getUser());
                    event.getChannel().send().message(".unmod " + event.getUser().getNick());
                    event.getChannel().send().message("Now Taking Mod From " + event.getUser().getNick());
                }
            }
                if (event.getMessage().length() > 300) {
                    event.getChannel().send().message("Stop Sending Walls Of Text! Message Too Long!");
                    event.getChannel().send().message(".timeout " + event.getUser().getNick() + " 1");
                }

            //ban a user through the bot
            //Takes The command !ban <username> <reason>
            if (event.getMessage().split(" ")[0].equalsIgnoreCase("!ban")) {
                event.getChannel().send().message(".ban " + event.getMessage().split(" ")[1]);
                event.getChannel().send().message(event.getMessage().split(" ")[1] + ", You Have Been Banned because: " +
                event.getMessage().split(" ")[2]);
            }
            //unban a user through the bot
            //Takes the command !unban <username>
            if (event.getMessage().split(" ")[0].equalsIgnoreCase("!unban")) {
                event.getChannel().send().message(".unban " + event.getMessage().split(" ")[1]);
                event.getChannel().send().message(event.getMessage().split(" ")[1] + ", You have been unbanned! Don't Break The Rules This Time!");
            }
            //host a channel manually
            if (event.getMessage().split(" ")[0].equalsIgnoreCase("!host")) {
                event.getChannel().send().message("We Are Now Hosting " + event.getMessage().split(" ")[1]);
                event.getChannel().send().message(".host " + event.getMessage().split(" ")[1]);
            }
            //unhost a channel manually
            if (event.getMessage().split(" ")[0].equalsIgnoreCase("!unhost")) {
                event.getChannel().send().message("We Have Stopped Hosting " + event.getMessage().split(" ")[1]);
                event.getChannel().send().message(".unhost");
            }
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
            if (event.getMessage().equalsIgnoreCase("!visitor") && (event.getUser().getNick().compareToIgnoreCase(Permitted.Streamer) == 0)) {
                if (Reference.visitor == false) {
                    Reference.visitor = true;
                    event.getChannel().send().message("The Visitor Mode Has Been Turned On!");
                } else if (Reference.visitor == true) {
                    Reference.visitor = false;
                    event.getChannel().send().message("The Visitor Mode Has Been Turned Off!");
                }
            }
        else {
            event.getChannel().send().message("You do not have the permission to run that Command!");
        }


    }
}
