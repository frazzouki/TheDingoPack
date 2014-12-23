package firedingo.project.bot;


import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

/**
 * Created by Nay on 23/12/2014.
 */
public class TheDingoPack {
    //starting config again in case config derp is issue, will need clean up HERE
    Configuration<PircBotX> Config = new Configuration.Builder<PircBotX>()
            .setServerPassword(firedingo.project.bot.reference.Reference.OAUTH)
            .setName(firedingo.project.bot.reference.Reference.NICK)
            .setLogin(firedingo.project.bot.reference.Reference.NICK)
            .setAutoNickChange(true)
            .setServerHostname(firedingo.project.bot.reference.Reference.HOST)
            .setServerPort(firedingo.project.bot.reference.Reference.PORT)

            .addAutoJoinChannel(firedingo.project.bot.reference.Reference.BOTCHAN)
            .buildConfiguration();


    //Constructor to actually create the bot
    public TheDingoPack() {
        PircBotX TheDingoPack = new PircBotX(Config);
        try {
            TheDingoPack.startBot();
            System.out.println("Attempting To Connect");
        }
        catch (Exception e) {
            System.out.println("Connection Failed - Error Thrown");
        }
        if (TheDingoPack.isConnected() == true) {
            System.out.println("Connection Successful");
        }
        else {
            System.out.println("Connection Failed");
        }

    }

    //realized constructor needed a call so added it here. Nearly derped :P
    public static void main(String[] args) {
        new TheDingoPack();
    }

}
