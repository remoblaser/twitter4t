package ch.remoblaser.twitter4t.commands;

import ch.remoblaser.twitter4t.console.TwitterConsole;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SearchTweetCommand implements ITwitterCommand {
	private Twitter tw;
	private Query searchQuery;
	
	public SearchTweetCommand() {
		TwitterConsole.write("Enter Search term: ");
		this.searchQuery = new Query(TwitterConsole.read());
		tw = TwitterFactory.getSingleton();
	}
	
	@Override
	public void execute() {
		try {
			QueryResult result = this.tw.search(this.searchQuery);
			for (Status status : result.getTweets()) {
				TwitterConsole.write("@" + status.getUser().getScreenName() + ":" + status.getText());
		    }

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	}

}
