package ch.remoblaser.twitter4t.commands;

import java.util.Scanner;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class StatusUpdateCommand implements ITwitterCommand{

	private StatusUpdate status;
	private Twitter tw;
	
	@SuppressWarnings("resource")
	public StatusUpdateCommand() {
		System.out.println("Enter your Tweet text: ");
		Scanner in = new Scanner(System.in);
		this.status = new StatusUpdate(in.nextLine());
		tw = TwitterFactory.getSingleton();
	}
	
	@Override
	public void execute() {
		
		try {
			this.tw.updateStatus(this.status);
			System.out.println("Tweet sent!");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

}
