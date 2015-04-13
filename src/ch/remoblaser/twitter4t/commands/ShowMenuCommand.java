package ch.remoblaser.twitter4t.commands;


public class ShowMenuCommand implements ITwitterCommand {

	@Override
	public void execute() {
		System.out.println("l = list tweets - t = tweet - s = search - h = help/show menu - q = quit");
	}

}
