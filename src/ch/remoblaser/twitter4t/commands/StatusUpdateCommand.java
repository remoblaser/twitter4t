package ch.remoblaser.twitter4t.commands;

import ch.remoblaser.twitter4t.console.TwitterConsole;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class StatusUpdateCommand implements ITwitterCommand{

	private StatusUpdate status;
	private Twitter tw;
	
	public StatusUpdateCommand() {
		TwitterConsole.write("Enter your Tweet text: ");
		this.status = new StatusUpdate(TwitterConsole.read());
		tw = TwitterFactory.getSingleton();
	}
	
	@Override
	public void execute() {
		
		try {
			this.tw.updateStatus(this.status);
			TwitterConsole.write("Tweet sent!");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

}
