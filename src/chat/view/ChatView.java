package chat.view;

import javax.swing.JOptionPane;
/**
 * Popup display to get input and show output.
 * @author Tristan Gaebler
 * @version 1.0 10/21/15
 */

public class ChatView 	 
{
	/**
	 * Displays the input from the user.
	 * @param userInput
	 */
	public void showOutput(String userInput)
	{
		JOptionPane.showMessageDialog(null, userInput);
	}
	
	/**
	 * Grabs the user input and uses JOptionPane to display it.
	 * @param displayText
	 * @return userAnswer
	 */
	public String grabInput(String displayText)
	{
		String userAnswer = " ";
		
		JOptionPane.showInputDialog(null, displayText);
		
		return userAnswer;
	}
}
