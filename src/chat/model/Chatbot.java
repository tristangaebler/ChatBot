package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Tristan Gaebler
 * @version 1.1 10/23/15 Completed length check method. 
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>(); 
		this.userName = userName;
		this.content = "theoretical physics";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("what if i told you");
		this.memesList.add("aliens");
		this.memesList.add("bad luck brian");
		this.memesList.add("rare pepe");
		this.memesList.add("spuderman");
		this.memesList.add("me gusta");
		this.memesList.add("troll");
		this.memesList.add("highschool teacher");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("immigration");
		this.politicalTopicList.add("minimum wage");
		this.politicalTopicList.add("wall street");
		this.politicalTopicList.add("isis and the middle east");
		this.politicalTopicList.add("Iran");
		this.politicalTopicList.add("taxes");
		this.politicalTopicList.add("benghazi");
		this.politicalTopicList.add("speaker of the house");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
		
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}		
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{	
		boolean hasTopic = false;
		
		for(String currentTopic: politicalTopicList)
		{
			if(currentTopic.equalsIgnoreCase(currentInput))
			{
				hasTopic = true;
			}
		}
		return hasTopic;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String currentMeme: memesList)
		{
			if(currentInput.toLowerCase().contains(currentMeme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
	
	public String processConversation(String currentChat)
	{
		String nextConversation = "oh, well that's awkward...we have nothing to talk about";
		
		//Generates random numbers between 0 and 4. 
		int randomTopic = (int) (Math.random() * 5);
		
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentChat))
				{
					nextConversation = "That meme is the dankest! What else?";
				}
				else
				{
					nextConversation = "TEST FAILED MEMES";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentChat))
				{
					nextConversation = "I agree and disagree. What else?";
				}				
				else
				{
					nextConversation = "TEST FAILED POLITICS";
				}
				break;
			case 2:
				if(contentChecker(currentChat))
				{
					nextConversation = "Wow words";
				}
				else
				{
					nextConversation = "TEST FAILED CONTENT";
				}
				break;
			case 3:
				if(currentChat.length() > 20)
				{
					nextConversation = "You typed less than 20 words";
				}
				else
				{
					nextConversation = "Test failed words";
				}
				break;
			case 4:
				nextConversation = "What else do you want to talk about?";
				break;
			default:
				nextConversation = "Is this real life????";
					break;
		}
		return nextConversation;
	}
}





