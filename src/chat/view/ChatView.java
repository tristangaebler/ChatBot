package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


/**
 * Popup display to get input and show output.
 * @author Tristan Gaebler
 * @version 1.3 11/5/15 Added icons to my project!
 */

public class ChatView 	 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	
	public ChatView ()
	{
		windowMessage = "Hello from the computer";
		chatIcon = new ImageIcon(getClass().getResource("images/Chat.png"));
	}
	
	/**
	 * Displays the input from the user.
	 * @param userInput
	 */
	public void showOutput(String userInput)
	{
		JOptionPane.showMessageDialog(null, userInput, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
	
	/**
	 * Grabs the user input and uses JOptionPane to display it.
	 * @param displayText
	 * @return userAnswer
	 */
	public String grabInput(String displayText)
	{
		String userAnswer = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here:").toString();
		
		return userAnswer;
	}
}
