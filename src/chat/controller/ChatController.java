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
	private ChatView ChatView;
	private Chatbot myChatbot;
	private ChatFrame baseFrame;

	/**
	 * Constructor that initializes all my class variables
	 */
	public ChatController()
	{
		ChatView = new ChatView();
		String userName = ChatView.grabInput("What is your name?");
		myChatbot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	/**
	 * This method is called when ChatBot starts. 
	 */
	public void start()
	{
		//ChatView.showOutput("Hello " + myChatbot.getUserName());
		chat();
		
	}
	/**
	 * Shuts down the chatBot program.
	 */
	private void shutDown()
	{
		ChatView.showOutput("Goodbye" + myChatbot.getUserName() + " it has been a pleasure");
		System.exit(0);
	}
	
	private void chat()
	{
		//=======REMEMBER========
		//Cody's variables are not named the same as yours.
		//String conversation = ChatView.grabInput("What would you like too talk about?");
		
		//while(myChatbot.lengthChecker(conversation))
		//{
			//conversation = ChatView.grabInput(myChatbot.processConversation(conversation));
			
		//}
	}
	
	/**
	 * I'm returning the response to the user. 
	 * @param userText
	 * @return
	 */
	public String userToChatbot(String userText)
	{
		String response = "";
		
		if(myChatbot.quitChecker(userText)) shutDown();
		
		response = myChatbot.processConversation(userText);
		
		return response;
	}

	/**
	 * These are my getters and setters.
	 * @return
	 */
	public ChatView getChatView()
	{
		return ChatView;
	}

	public void setChatView(ChatView chatView)
	{
		ChatView = chatView;
	}
	
	public Chatbot getMyChatbot()
	{
		return myChatbot;
	}

	public void setMyChatbot(Chatbot myChatbot)
	{
		this.myChatbot = myChatbot;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

}
