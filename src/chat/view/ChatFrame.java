package chat.view;

import javax.swing.JFrame;
import java.awt.Color;
import chat.controller.ChatController;
/**
 * Setting up the frame and making the ChatBot look nice...trying not making Cody's eyes bleed. 
 * @author Tristan Gaebler
 * @version 1.4 Added documentation to ChatFrame
 */
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
	/**
	 * This is were my frame is set up
	 * Setting values to show the frame
	 */
	private void setUpFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setBackground(Color.orange);
		this.setTitle("Chat Window");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Getter for baseController
	 * @return
	 */
	public ChatController getBaseController()
	{
		return baseController;
	}
}
