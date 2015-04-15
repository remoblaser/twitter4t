package ch.remoblaser.twitter4t.commands;

import ch.remoblaser.twitter4t.console.TwitterConsole;

public class NotRecognizedCommand implements ITwitterCommand{

	@Override
	public void execute() {
		TwitterConsole.write("Command not found, use h for help");
	}
	

}
