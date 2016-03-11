package chat.model;

import java.util.ArrayList;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import chat.controller.ChatController;
/**
 * 
 * @author Tristan Gaebler
 * @version 0.6
 * 
 * This is the CTECTwitter class that will gather and sort information. It will use the Twitter API to gather data, and java to sort that data. Going to interact with twitter.
 *
 */

public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! - From Tristan");
		}
		catch (TwitterException e)
		{
			baseController.handleErrors("Error caused the death of the program. How does it feel now that you murdered a java program.");
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
			
		}
		
		for(Status currentStatus : statusList)
		{
			String [] tweetText = currentStatus.getText().split(" ");
			for(String word : tweetText) 
			{
				wordList.add(removePuncuation(word).toLowerCase());
			}
		}
		
		removeCommonEnglishWords(wordList);
		removeEmptyText();
	}
	
	private String removePuncuation(String word)
	{
		return null;
	}
	
	private void removeCommonEnglishWords(ArrayList<String> text)
	{
		
	}
	
	private void removeEmptyText()
	{
		
	}
}
