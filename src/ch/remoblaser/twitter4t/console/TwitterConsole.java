package ch.remoblaser.twitter4t.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwitterConsole {
	public static void write(String content) {
		System.out.println(content);
	}
	
	public static String read() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
