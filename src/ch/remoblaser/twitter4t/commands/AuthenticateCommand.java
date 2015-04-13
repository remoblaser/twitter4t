package ch.remoblaser.twitter4t.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class AuthenticateCommand implements ITwitterCommand {

	private Twitter tw;
	
	public AuthenticateCommand() {
		tw = TwitterFactory.getSingleton();
	}
	
	@Override
	public void execute() {
		AccessToken accessToken = loadAccessToken();
	    RequestToken requestToken = null;
	    if(accessToken == null) {
		try {
			requestToken = this.tw.getOAuthRequestToken();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    while (null == accessToken) {
		      System.out.println("Open the following URL and grant access to your account:");
		      System.out.println(requestToken.getAuthorizationURL());
		      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
		      String pin = null;
			try {
				pin = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		      try{
		         if(pin.length() > 0){
		           accessToken = this.tw.getOAuthAccessToken(requestToken, pin);
		         }else{
		           accessToken = this.tw.getOAuthAccessToken();
		           
		         }
		         storeAccessToken(this.tw.verifyCredentials().getId() , accessToken);
		      } catch (TwitterException te) {
		        if(401 == te.getStatusCode()){
		          System.out.println("Unable to get the access token.");
		        }else{
		          te.printStackTrace();
		        }
		      }
		    }
	    }
	   

	}
	
	private static void storeAccessToken(long l, AccessToken accessToken){
		System.out.println("Storing token..");
		try {
	        Properties props = new Properties();
	        props.load(new FileInputStream("src/twitter4j.properties"));
	        props.setProperty("oauth.accessToken", accessToken.getToken());
	        props.setProperty("oauth.accessTokenSecret", accessToken.getTokenSecret());
	 
	        File f = new File("src/twitter4j.properties");
	        OutputStream out = new FileOutputStream( f );
	        props.store(out, null);
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
		
	  }
	
	private static AccessToken loadAccessToken() {
		Properties props = new Properties();
        try {
			props.load(new FileInputStream("src/twitter4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        String token = props.getProperty("oauth.accessToken");// load from a persistent store
	    String tokenSecret = props.getProperty("oauth.accessTokenSecret"); // load from a persistent store
	    if(!token.isEmpty() && !tokenSecret.isEmpty()) {
	    	return new AccessToken(token, tokenSecret);
	    }
	    else {
	    	return null;
	    }
	}

}
