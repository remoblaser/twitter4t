package ch.remoblaser.twitter4t;

import java.util.Scanner;

import ch.remoblaser.twitter4t.commands.AuthenticateCommand;
import ch.remoblaser.twitter4t.console.ConsoleHandler;

public class TerminalTwitter {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ConsoleHandler console = new ConsoleHandler();
		
		System.out.println("Welcome to Twitter4T - Initializing..");
		Scanner in = new Scanner(System.in);
		
        String command = "h";
        
        AuthenticateCommand authCommand = new AuthenticateCommand();
        authCommand.execute();
        console.handle(command);
        while(command != "q") {
        	
    		command = in.nextLine();
        	console.handle(command);
        }
	}

}
