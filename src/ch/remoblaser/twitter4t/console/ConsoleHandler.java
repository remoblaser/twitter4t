package ch.remoblaser.twitter4t.console;

import ch.remoblaser.twitter4t.commands.ITwitterCommand;
import ch.remoblaser.twitter4t.commands.NotRecognizedCommand;
import ch.remoblaser.twitter4t.commands.SearchTweetCommand;
import ch.remoblaser.twitter4t.commands.ShowMenuCommand;
import ch.remoblaser.twitter4t.commands.ShowTwitterFeedCommand;
import ch.remoblaser.twitter4t.commands.StatusUpdateCommand;

public class ConsoleHandler {
	
	public void writeCommandLines() {
		ShowMenuCommand command = new ShowMenuCommand();
		command.execute();
	}
	
	public void handle(String consoleCommand)
	{	
		ITwitterCommand command = null;
		switch(consoleCommand) {
			case "t":
				command = new StatusUpdateCommand();
				break;
			case "h":
				command = new ShowMenuCommand();
				break;
			case "r":
				command = new ShowTwitterFeedCommand();
				break;
			case "s":
				command = new SearchTweetCommand();
				break;
			default:
				command = new NotRecognizedCommand();
				break;
		}
		command.execute();
		
		System.out.println("-----------------");
		if(consoleCommand != "h")
			this.writeCommandLines();
	}
	 
}
