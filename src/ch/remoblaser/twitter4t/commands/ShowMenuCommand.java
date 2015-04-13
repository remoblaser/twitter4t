package ch.remoblaser.twitter4t.commands;


public class ShowMenuCommand implements ITwitterCommand {

	@Override
	public void execute() {
		System.out.println("r = refresh - t = tweet - h = help/show menu - q = quit");
	}

}
