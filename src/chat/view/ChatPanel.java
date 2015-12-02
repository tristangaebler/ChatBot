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
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Click to chat");
		chatTextField = new JTextField("Type to chat");
		chatTextArea = new JTextArea("Chat Text Area");
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
	
	private void setUpLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -176, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 37, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 158, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 146, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -38, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextArea, 0, SpringLayout.EAST, chatTextField);
	}
	
	
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
				chatTextArea.append("\nChatbot: " + response);
			}
		
		});
	}
	
	public JTextField getChatTextField()
	{
		return chatTextField;
	}

	public void setChatTextField(JTextField chatTextField)
	{
		this.chatTextField = chatTextField;
	}
}
