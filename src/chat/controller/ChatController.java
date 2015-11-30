package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * Application controller for the Chatbot project.
 * @author Tristan Gaebler
 * @version 1.2 10/21/15 Added control structures for the chat method
 */
public class ChatController 
{
	private ChatView myDisplay;
	private Chatbot myChatbot;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabInput("What is your name?");
		myChatbot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		myDisplay.showOutput("Hello " + myChatbot.getUserName());
		chat();
		
	}
	
	private void shutDown()
	{
		myDisplay.showOutput("Goodbye" + myChatbot.getUserName() + " it has been a pleasure");
		System.exit(0);
	}
	
	private void chat()
	{
		//=======REMEMBER========
		//Cody's variables are not named the same as yours.
		String conversation = myDisplay.grabInput("What would you like too talk about?");
		
		while(myChatbot.lengthChecker(conversation))
		{
			conversation = myDisplay.grabInput(myChatbot.processConversation(conversation));
			
		}
	}
}
