package chat.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JTextField chatTextField;
	private SpringLayout baseLayout;
	private JTextArea chatTextArea;
	private JLabel promptLabel;
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton analyzeTwitterButton;
	
	/**
	 * Constructor initializes all my panel variables.
	 * setUpPanel(), setUpLayout(), and setUpListeners() need to be in that order.
	 * @param baseController
	 * Takes baseController as a parameter and assigns it to an instance of a baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController; //Controller reference 
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Click to chat");
	
		chatTextField = new JTextField("Type to chat", 15);
	

		chatTextArea = new JTextArea("Lets talk about memes, politics, or things that you like.");
		promptLabel = new JLabel("Chat me away");
		tweetButton = new JButton("Click to send tweet");

		analyzeTwitterButton = new JButton("Analyze Twitter");

	
	
		setUpPane();
		setUpPanel();
		setUpLayout();
		setUpListeners();
		
	}
	
	private void setUpPane()
	{	
		chatTextArea.setLineWrap(true);
		chatTextArea.setWrapStyleWord(true);
		chatTextArea.setEditable(false);
		textPane = new JScrollPane(chatTextArea);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * All my GUI components
	 */
	private void setUpPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextField);
		this.add(promptLabel);
		this.add(textPane);
		this.add(tweetButton);
		this.add(analyzeTwitterButton);
		//this.add(tweetButton);
		//this.add(saveButton);
		//this.add(loadButton);
		chatTextField.setToolTipText("Type here");
		this.setPreferredSize(new Dimension(500, 500));
	}
	
	/**
	 * This is all my garbage code
	 */
	private void setUpLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatTextArea, 19, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -33, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -15, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -45, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 104, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, analyzeTwitterButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 6, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 291, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -6, SpringLayout.WEST, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatTextField);
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
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clickEvent)
			{
				baseController.sendTweet("no text to send");
			}
		});
		
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = chatTextField.getText();
				String results = baseController.analyze(user);
				chatTextArea.setText(results);
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
