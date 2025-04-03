package com.comcast.com.generic.webdriverutility;

import java.util.Random;



public class JavaUtility {

	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(2000);
	
     	return randomNumber;
		}
	//getSystemDateYYYYDDMM
	//getRequaredDate
}
