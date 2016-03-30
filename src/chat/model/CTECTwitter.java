package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
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
		statusList.clear();
		wordList.clear();
		
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
			String [] tweetText = currentStatus.getText().split(" "); //The split method will make a string and put them into an array 
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
		String punctuation = ".,?;:\"(){}^[]<>-";
		String scrubbedString ="";
		
		for(int i = 0; i < word.length(); i++)
		{
			if(punctuation.indexOf(word.charAt(i)) == -1) //Check if the punctuation is there and eleminate
			{
				scrubbedString += word.charAt(i);
			}
		}
		
		return scrubbedString;
	}
	
	/*
	 * March 15, 2016
	 * Today I learned about analysing tweets. The way we analysis tweets is through nested loops. When we click the
	 * analysis twitter button, the first method to come into action is the listener. Then from the listener, we go to the analyze method. After analysis we go to the topResults method. From topResults we get wordList, 
	 * which has been edited by removeCommonEnglishWords, removeEmptyText, and importWordsToArray.
	 */
	@SuppressWarnings("unchecked")
	private List removeCommonEnglishWords(ArrayList<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		//removeTwitterUsernamesFromList(wordList);
		
		return wordList;
	}
	
	//Removes empty text entries from the tweetTexts list. 
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			if(wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--; //Go backward to check
				//jake and jake 
			}
		}
	}
	 
	private String[] importWordsToArray()
	{
		String [] boringWords;
		int wordCount = 0;

			Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			while(wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		return boringWords;
	}
	
	public String topResults()
	{
		String tweetResults = "";
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			int wordUseCount = 1;
			for(int index = spot + 1; index < wordList.size(); index++)
			{
				if(wordList.get(index).equals(wordList.get(spot)));
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweet was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times!";
		
		return tweetResults;
	}
	public String sampleInvestigation()
	{
		String results = "";
		Query query = new Query("University of Utah");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.86978), 20, Query.MILES);
		query.setSince("2016-1-1");
		
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results += "Count : " + result.getTweets().size();
			for(Status tweet : result.getTweets())
			{
				results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		catch(TwitterException error)
		{
			error.printStackTrace();
		}
		return results;
	}
}







