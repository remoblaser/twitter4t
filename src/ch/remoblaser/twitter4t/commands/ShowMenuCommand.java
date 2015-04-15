package ch.remoblaser.twitter4t.commands;

import ch.remoblaser.twitter4t.console.TwitterConsole;


public class ShowMenuCommand implements ITwitterCommand {

	@Override
	public void execute() {
		TwitterConsole.write("l = list tweets - t = tweet - s = search - h = help/show menu - q = quit");
	}

}
