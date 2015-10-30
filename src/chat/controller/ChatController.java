package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author Tristan Gaebler
 * @version 1.2 10/21/15 Added control structures for the chat method
 */
public class ChatController 
{
	private ChatView myDisplay;
	private Chatbot myChatbot;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabInput("What is your name?");
		myChatbot = new Chatbot(userName);
	}
	
	public void start()
	{
		myDisplay.showOutput("Hello " + myChatbot.getUserName());
		chat();
		
	}
	
	private void chat()
	{
		//=======REMEMBER========
		//Cody's variables are not named the same as yours.
		String conversation = myDisplay.grabInput("What would you like too talk about?");
		
		while(myChatbot.lengthChecker(conversation))
		{
			if(myChatbot.contentChecker(conversation))
			{
				myDisplay.showOutput("wow, you are interested in " + myChatbot.getContent() + ". Me too!");
			}
			else if(myChatbot.memeChecker(conversation))
			{
				myDisplay.showOutput("I didn't know you liked memes");
			}
			else if(myChatbot.politicalTopicChecker(conversation))
			{
				myDisplay.showOutput("Woah you wanna talk about" + myChatbot.getContent() + ". we just met..");
			}
			conversation = myDisplay.grabInput(conversation);
		}
	}
}
