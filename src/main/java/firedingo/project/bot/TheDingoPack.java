package firedingo.project.bot;


import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class TheDingoPack {
	
	//Basic bot configuration setup
	Configuration config = new Configuration.Builder()
    .setName(firedingo.project.bot.reference.Reference.NICK) //Nick of the bot. CHANGE IN YOUR CODE
    //.setLogin(" ") //Login part of hostmask, eg name:login@host (MIGHT NOT BE NEEDED)
    .setAutoNickChange(true) //Automatically change nick when the current one is in use
    .setServer(firedingo.project.bot.reference.Reference.HOST, firedingo.project.bot.reference.Reference.PORT) //The server were connecting to
    .addAutoJoinChannel("#TheDingoPack") //Join #TheDingoPack channel on connect
    .buildConfiguration(); //Create an immutable configuration from this builder
	
	
	

	
	//Constructor to actually create the bot
	public TheDingoPack() {
		System.out.println("Random Test 2");
	PircBotX TheDingoPack = new PircBotX(config);
	System.out.println("Random Test 3");
	try {
	TheDingoPack.startBot();
	System.out.println("Attempting To Connect");
	
	} catch(Exception e) {
		System.out.println("Connection Failed");
	}
	
}
	//realized constructor needed a call so added it here. Nearly derped :P
	 public static void main(String[] args) {
		 TheDingoPack bot = new TheDingoPack();
	 }
}

