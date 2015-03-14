package firedingo.project.bot.events;

import firedingo.project.bot.reference.EntryValues;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.PartEvent;

/**
 * Created by firedingo on 15/2/2015.
 * This Project does contain an attached license and readme.
 * Please see these files for additonal information.
 * You can reach firedingo on twitter using the tag @firedingo
 */
public class EventHandler extends ListenerAdapter<PircBotX> {
    @Override
    public void onPart(PartEvent<PircBotX> event) throws Exception {
        //This resets the value that tracks if a user is in the channel and isn't lurking after they leave.
        if (event.getUser().getNick().compareToIgnoreCase("drwarfighter") == 0 ) {
            EntryValues.DrEnter = false;
        }
        if (event.getUser().getNick().compareToIgnoreCase("lisageek24") == 0 ) {
            EntryValues.LisaEnter = false;
        }
        if (event.getUser().getNick().compareToIgnoreCase("muted") == 0 ) {
            EntryValues.MutedEnter = false;
        }
        //I am a test case that can be removed
        if (event.getUser().getNick().compareToIgnoreCase("ameria5") == 0 ) {
            EntryValues.AmeriaEnter = false;
        }
    }
}
