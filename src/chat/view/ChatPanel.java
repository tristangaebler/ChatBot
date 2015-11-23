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
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Click to chat");
		chatTextField = new JTextField("Type to chat");
	
		setUpPanel();
		setUpLayout();
		setUpListeners();
		
	}
	
	private void setUpPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextField);
	}
	
	private void setUpLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -176, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 37, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 158, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 146, SpringLayout.WEST, this);
	}
	
	private void setUpListeners()
	{
		
	}
}
