package chat.model;

import java.util.ArrayList;

import twitter4j.*;
/**
 * 
 * @author Tristan Gaebler
 * @version 0.4
 * 
 * This is the CTECTwitter class that will gather and sort information. It will use the Twitter API to gather data, and java to sort that data. Going to interact with twitter.
 *
 */

public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException e)
		{
			e.printStackTrace();
		}
	}
	
}
