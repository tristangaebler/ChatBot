package chat.controller;
/**
 * Starts the ChatBot program.
 * @author Tristan Gaebler
 * @version 1.0 10/21/15
 */
public class Runnner 
{
	public static void main(String [] agrs)
	{
		ChatController myChatController = new ChatController();
		myChatController.start();
	}
}
