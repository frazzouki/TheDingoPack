package firedingo.project.bot.commands;

import firedingo.project.bot.reference.EntryValues;
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
//these commands are spammy at the moment
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        if (Reference.visitor == false) {
            if (event.getMessage().equalsIgnoreCase("poke")) {
                event.getChannel().send().message("Hey That hurts, Quit it!");

            }
            //Bot responds to first post by the account known as drwarfighter
            if (event.getUser().getNick().equalsIgnoreCase("drwarfighter") && (EntryValues.DrEnter == false)) {
                event.getChannel().send().message("Hey Look It's The Sexy Dr :)");
                EntryValues.DrEnter = true;
            }
            if (event.getMessage().equalsIgnoreCase("!dr")) {
                event.getChannel().send().message("Look! Is It A Plane? Is It A Bird? No, It's The Royal Dr!!");
            }
            //Bot responds to first post by the account known as lisageek24
            if (event.getUser().getNick().equalsIgnoreCase("lisageek24") && (EntryValues.LisaEnter == false)) {
                event.getChannel().send().message("All Hail Dr Geekasaurus, Queen Of The Dinos!");
                EntryValues.LisaEnter = true;
            }
            //Bot responds to first post by the account known as muted
            if (event.getUser().getNick().equalsIgnoreCase("muted") && (EntryValues.MutedEnter == false)) {
                event.getChannel().send().message("Muted Came in Like a Wrecking Ball, In the End He banned them all!");
                EntryValues.MutedEnter = true;
            }

            //This is a test case
            if (event.getUser().getNick().equalsIgnoreCase("ameria5") && (EntryValues.AmeriaEnter == false)) {
                event.getChannel().send().message("I am a test case and can be removed later.");
                EntryValues.AmeriaEnter = true;
            }
        }//End visitor If

        if (event.getMessage().contains("!streaming ") || (event.getMessage().contains("!Streaming "))) {
            if (event.getMessage().split(" ")[0].equalsIgnoreCase("!streaming")) {
              //  event.getBot().sendIRC().joinChannel("#" + event.getMessage().split(" ")[1]);
                event.getChannel().send().message("#" + event.getMessage().split(" ")[1]);
                //insert delay here
                event.getChannel().send().message("Hello " + event.getMessage().split(" ")[1] + " I'm Firedingo99365's Bot Project For Experience's Sake."
                        + "I just dropped by to tell you I Hope You have a good stream!");
                event.getChannel().send().part();
                //temp can be removed after delay added
                event.getBot().sendIRC().joinChannel("#thedingopack");
            } else {
                event.respond("The Correct Syntax Is !streaming <username>");
            }
        }
    }
}
