package com.bridgelabz.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Utility
{
static Scanner scr = new Scanner(System.in);

	
	
	/**
	 * @return number a user given number
	 */
	//function to return a Integer value which is given by user.
	public static int retInt() {         
		return scr.nextInt();
	}

	
	/**
	 * @return String a user given word
	 */
	 //function to return a word of String value which is given by user.
	public static String retNext() {      
		return scr.next();
	}

	
	/**
	 * @return String a user given sentence/multiple words
	 */
	 //function to return a String line which is given by user.
	public static String retNextLine() {      
		return scr.nextLine();
	}



	/**
	 * @return boolean a user given boolen value
	 */
	public static boolean retBoolean() {
		return scr.nextBoolean();
	}


	/**
	 * @return number a number which is of double type and is given by the user
	 */
	public static double retDouble() {
		return scr.nextDouble();
	}
	

	/**
	 * @return
	 */
	public static long retLong() {
		
		return scr.nextLong();
	}
	
	public static String getProperty(String key)
	{
		String value=null;
		Properties properties=new Properties();
		try 
		{
			FileReader fileReader=new FileReader("/home/adminstrato/BijayaWorkSpace/LoginValidation/src/com/bridgelabz/files/details.properties");
			properties.load(fileReader);
			value=properties.getProperty(key);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return value;
	}
}
