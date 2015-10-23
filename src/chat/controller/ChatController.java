package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author Tristan Gaebler
 * @version 1.11 10/21/15 Imported ChatVeiw. Fixed the error.
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
	}
}
