package firedingo.project.bot;


import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class TheDingoPack {
	
	Configuration config = new Configuration.Builder()
    .setName(firedingo.project.bot.reference.Reference.NICK) //Nick of the bot. CHANGE IN YOUR CODE
    .setLogin(" ") //Login part of hostmask, eg name:login@host
    .setAutoNickChange(true) //Automatically change nick when the current one is in use
    .setServer(" ") //The server were connecting to
    .addAutoJoinChannel("#TheDingoPack") //Join #TheDingoPack channel on connect
    .buildConfiguration(); //Create an immutable configuration from this builder

	PircBotX TheDingoPack = new PircBotX(config);
}
