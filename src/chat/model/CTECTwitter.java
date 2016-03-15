package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while(wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
			
		}
		catch(FileNotFoundException e)
		{
			return new String[0];
		}
		
		return boringWords;
	}
	
	public String topResults(List<String> wordList)
	{
		String tweetResults = "";
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			int wordUseCount = 1;
			for(int index = spot + 1; spot < wordList.size(); index++)
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
}







