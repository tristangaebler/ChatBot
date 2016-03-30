package chat.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IOController
{
	public static String saveFile(String textToSave)
	{
		String fileName = "Saved chat file...";
		fileName += Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		fileName += ":" + Calendar.getInstance().get(Calendar.MINUTE);
		fileName += ".txt";
		FileWriter chatWritter;
		
		try
		{
			chatWritter = new FileWriter(fileName);
			chatWritter.write("This is the " + fileName + "\n");
			chatWritter.write(textToSave);
			JOptionPane.showMessageDialog(null, "File saved as: " + fileName);
		}
		catch(IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		return fileName;
	}
	
	public static String readTextFromFile(String fileName)
	{
		String text = "";
		File chatTextFile = new File(fileName);
		Scanner chatScanner;
		try
		{
			chatScanner = new Scanner(chatTextFile);
			while(chatScanner.hasNext())
			{
				text += chatScanner.nextLine();
			}
			chatScanner.close();
			JOptionPane.showMessageDialog(null, fileName + " was loaded to the chatTextArea");
			
		}
		catch(IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		return text;
	}
}
