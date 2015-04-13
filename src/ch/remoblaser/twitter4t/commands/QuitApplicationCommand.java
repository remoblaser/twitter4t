package ch.remoblaser.twitter4t.commands;

public class QuitApplicationCommand implements ITwitterCommand {

	@Override
	public void execute() {
		System.exit(0);
	}

}
