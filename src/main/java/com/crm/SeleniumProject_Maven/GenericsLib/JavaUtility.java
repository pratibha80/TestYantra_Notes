package com.crm.SeleniumProject_Maven.GenericsLib;

import java.util.Random;

/**
 * this class contains generics methods pertaining to java
 * @author Pratibha
 *
 */

public class JavaUtility {
	
	/**
	 * this method generate random number
	 * @return 
	 */
	
	public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum = ran.nextInt(1000);
		
		return randomNum;
	}
}
