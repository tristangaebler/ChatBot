package chat.view;

import javax.swing.JFrame;
import java.awt.Color;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	private ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setUpFrame();
	}
	
	private void setUpFrame()
	{
		
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
