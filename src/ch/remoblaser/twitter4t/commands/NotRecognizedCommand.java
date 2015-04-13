package ch.remoblaser.twitter4t.commands;

public class NotRecognizedCommand implements ITwitterCommand{

	@Override
	public void execute() {
		System.out.println("Command not found, use h for help");
		
	}
	

}
