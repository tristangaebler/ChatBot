package chat.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.model.Chatbot;

/**
 * Class designed for testing the Chatbot object with JUnit. 
 * We will be developing tests for this as a class.
 * Each additional test will be a version decimal update.
 * @author CodyH
 * @version 1.0
 */
public class ChatbotTest
{
	private Chatbot myChatbot;
	private String userName;

	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		myChatbot = new Chatbot(userName);
	}

	@After
	public void tearDown() throws Exception
	{
		userName = null;
		myChatbot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("The memesList is not present",myChatbot.getMemesList());
		assertNotNull("The politicalTopicsList is not present", myChatbot.getPoliticalTopicList());
		assertSame("The username is the same object", userName, myChatbot.getUserName());
	}

	@Test
	public void testLengthChecker()
	{
		assertFalse("Correct zero length check",myChatbot.lengthChecker(""));
		assertFalse("Correct null check", myChatbot.lengthChecker(null));
		assertTrue("Correct length check", myChatbot.lengthChecker("       "));
	}

	@Test
	public void testContentChecker()
	{
		String content = "some words";
		myChatbot.setContent(content);
		assertFalse("Check blank failed", myChatbot.contentChecker(" "));
		assertFalse("Check partial failed", myChatbot.contentChecker("words"));
		assertFalse("Check partial failed", myChatbot.contentChecker("some"));
		assertTrue("Check match failed", myChatbot.contentChecker(content));
		assertTrue("Check match plus failed", myChatbot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", myChatbot.contentChecker(content + " other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", myChatbot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", myChatbot.keyboardMashChecker("derf"));
		assertTrue("Mash not detected", myChatbot.keyboardMashChecker("sdf"));
		assertTrue("Mash not detected", myChatbot.keyboardMashChecker("dfg"));
		assertTrue("Mash not detected", myChatbot.keyboardMashChecker("cvb"));
		assertTrue("Mash not detected", myChatbot.keyboardMashChecker(",./"));
	}

	@Test
	public void testPoliticalTopicChecker()
	{
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testMemeChecker()
	{
		assertTrue("Topic check", myChatbot.getMemesList().contains("doge"));
		assertTrue("Topic check", myChatbot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testQuitChecker()
	{
		assertFalse("False positive", myChatbot.quitChecker("exit"));
		assertTrue("False negative", myChatbot.quitChecker("quit"));
	}
	
	@Test
	public void testBuildMemesList()
	{
		assertTrue("Size check", myChatbot.getMemesList().size() >= 10);
		assertTrue("Topic check", myChatbot.getMemesList().contains("doge"));
		assertTrue("Topic check", myChatbot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testBuildPoliticalTopicList()
	{
		assertTrue("Size check", myChatbot.getPoliticalTopicList().size() >= 10);
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", myChatbot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, myChatbot.getUserName());
	}

	@Test
	public void testGetContent()
	{
		String content = "topic area of interest";
		myChatbot.setContent(content);
		assertSame("Setters and Getters work", content, myChatbot.getContent());
	}

	@Test
	public void testGetMemesList()
	{
		assertNotNull("Getters work again", myChatbot.getMemesList());
	}

	@Test
	public void testGetPoliticalTopicList()
	{
		assertNotNull("Getters still work in Java", myChatbot.getPoliticalTopicList());
	}
	
	@Test
	public void testSetContent()
	{
		String oldContent = myChatbot.getContent();
		String content = "some other content";
		myChatbot.setContent(content);
		assertNotSame("Changed values", oldContent, myChatbot.getContent());
		assertSame("Setters work", content, myChatbot.getContent());
	}

}
