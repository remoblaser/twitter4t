package ch.remoblaser.twitter4t.commands;

import java.util.Scanner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SearchTweetCommand implements ITwitterCommand {
	private Twitter tw;
	private Query searchQuery;
	
	@SuppressWarnings("resource")
	public SearchTweetCommand() {
		System.out.println("Enter Search term: ");
		Scanner in = new Scanner(System.in);
		this.searchQuery = new Query(in.nextLine());
		tw = TwitterFactory.getSingleton();
	}
	
	@Override
	public void execute() {
		try {
			QueryResult result = this.tw.search(this.searchQuery);
			for (Status status : result.getTweets()) {
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		    }

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	}

}
