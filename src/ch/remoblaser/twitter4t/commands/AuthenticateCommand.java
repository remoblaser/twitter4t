package ch.remoblaser.twitter4t.commands;


import ch.remoblaser.twitter4t.authentication.Authenticator;

public class AuthenticateCommand implements ITwitterCommand {

	private Authenticator authenticator;
	
	public AuthenticateCommand() {
		this.authenticator = new Authenticator();
	}
	
	@Override
	public void execute() {
		this.authenticator.authenticate();
	}

}
