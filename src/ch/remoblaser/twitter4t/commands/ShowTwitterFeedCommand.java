package ch.remoblaser.twitter4t.commands;

import java.util.List;

import ch.remoblaser.twitter4t.console.TwitterConsole;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class ShowTwitterFeedCommand implements ITwitterCommand {

	private Twitter tw;
	
	public ShowTwitterFeedCommand() {
		this.tw = TwitterFactory.getSingleton();
	}

	@Override
	public void execute() {
		try {
			List<Status> statuses = this.tw.getHomeTimeline();
			for (Status status : statuses) {
				TwitterConsole.write(status.getUser().getName() + ":" +
		                           status.getText());
		    }
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

}
