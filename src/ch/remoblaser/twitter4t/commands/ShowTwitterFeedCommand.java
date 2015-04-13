package ch.remoblaser.twitter4t.commands;

import java.util.List;

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
		        System.out.println(status.getUser().getName() + ":" +
		                           status.getText());
		        System.out.println();
		    }
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
