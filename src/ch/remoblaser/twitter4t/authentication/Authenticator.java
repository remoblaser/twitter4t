package ch.remoblaser.twitter4t.authentication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ch.remoblaser.twitter4t.console.TwitterConsole;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class Authenticator {

	private Properties authProperties;
	private String propertiesFileName = "src/twitter4j.properties";
	private Twitter tw;
	private AccessToken accessToken;

	public Authenticator() {
		this.tw = TwitterFactory.getSingleton();
		this.authProperties = new Properties();
		try {
			FileInputStream in = new FileInputStream(this.propertiesFileName);
			this.authProperties.load(in);
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}
	public void authenticate() {
		if(this.hasAccessToken()) {
			this.loadAccessToken();
		}
		else {
			this.getAccessTokenFromTwitter();
		}

	}

	private boolean hasAccessToken() {
		String token = this.authProperties.getProperty("oauth.accessToken");
		String tokenSecret = this.authProperties.getProperty("oauth.accessTokenSecret");

		if(token == null || tokenSecret == null) {
			return false;
		}
		return true;
	}

	private void getAccessTokenFromTwitter() {
		try {
			RequestToken requestToken = this.tw.getOAuthRequestToken();
			while (null == this.accessToken) {
				TwitterConsole.write("Open the following URL and grant access to your account:");
				TwitterConsole.write(requestToken.getAuthorizationURL());
				TwitterConsole.write("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
				String pin = null;

				pin = TwitterConsole.read();
				if(pin.length() > 0){
					accessToken = this.tw.getOAuthAccessToken(requestToken, pin);
				} 
				else {
					accessToken = this.tw.getOAuthAccessToken();
				}
				this.storeAccessToken(accessToken);
			}
		} 
		catch (TwitterException te) {
			te.printStackTrace();
		}
	}

	private void writeProperty() {
		try {
			FileOutputStream out = new FileOutputStream(propertiesFileName);
			this.authProperties.store(out, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void storeAccessToken(AccessToken accessToken){
		TwitterConsole.write("Storing token..");
		this.authProperties.setProperty("oauth.accessToken", accessToken.getToken());
		this.authProperties.setProperty("oauth.accessTokenSecret", accessToken.getTokenSecret());
		this.writeProperty();

	}

	private void loadAccessToken() {
		String token = this.authProperties.getProperty("oauth.accessToken");
		String tokenSecret = this.authProperties.getProperty("oauth.accessTokenSecret");

		this.accessToken = new AccessToken(token, tokenSecret);
	}
}
