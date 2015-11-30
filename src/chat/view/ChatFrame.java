package chat.view;

import javax.swing.JFrame;
import java.awt.Color;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	//If errors occur, try changing to private again
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setUpFrame();
	}
	
	private void setUpFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setBackground(Color.RED);
		this.setTitle("Chat Window");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
