package ch.remoblaser.twitter4t;


import ch.remoblaser.twitter4t.commands.AuthenticateCommand;
import ch.remoblaser.twitter4t.console.ConsoleHandler;
import ch.remoblaser.twitter4t.console.TwitterConsole;

public class TerminalTwitter {

	public static void main(String[] args) {
		
		ConsoleHandler console = new ConsoleHandler();
		TwitterConsole.write("Welcome to Twitter4T - Initializing..");
		
		AuthenticateCommand authCommand = new AuthenticateCommand();
        authCommand.execute();
		
        String command = "h";        
        console.handle(command);
        
        while(command != "q") {
    		command = TwitterConsole.read();   
        	console.handle(command);
        }
	}

}
