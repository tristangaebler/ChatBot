package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Font;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JTextField chatTextField;
	private SpringLayout baseLayout;
	private JTextArea chatTextArea;
	private JLabel promptLabel;
	
	/**
	 * Constructor initializes all my panel variables.
	 * setUpPanel(), setUpLayout(), and setUpListeners() need to be in that order.
	 * @param baseController
	 * Takes baseController as a parameter and assigns it to an instance of a baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Click to chat");
		chatTextField = new JTextField("Type to chat", 15);
		chatTextArea = new JTextArea("Lets talk about memes, politics, or things that you like.");
		promptLabel = new JLabel("Chat me away");

		setUpPanel();
		setUpLayout();
		setUpListeners();
		
	}
	
	private void setUpPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatTextArea);
		this.add(chatButton);
		this.add(chatTextField);
		this.add(promptLabel);
		chatTextField.setToolTipText("Type here");
		chatTextArea.setEnabled(false);
		
	}
	
	/**
	 * This is all my garbage code
	 */
	private void setUpLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 36, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -45, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextArea, 97, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -33, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, promptLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 84, SpringLayout.WEST, this);
	}
	
	/**
	 * When the chatButton is clicked it grabs the users answer. Then it displays it to the screen.
	 * Then it sends the text back to the chatBot for it to process the response.
	 * Then it displays the response
	 */
	private void setUpListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clickEvent)
			{
				String userText = chatTextField.getText(); //Grabbed users typed answer
				chatTextArea.append("\nUser: " + userText); //Displaying user answer
				chatTextField.setText("");
				String response = baseController.userToChatbot(userText); //Sending the text back to chatBot
				chatTextArea.append("\nChatbot: " + response); //Display response
			}
		
		});
	}
	
	/**
	 * Getters and setters for JTextField
	 * @return
	 */
	public JTextField getChatTextField()
	{
		return chatTextField;
	}

	public void setChatTextField(JTextField chatTextField)
	{
		this.chatTextField = chatTextField;
	}
}
