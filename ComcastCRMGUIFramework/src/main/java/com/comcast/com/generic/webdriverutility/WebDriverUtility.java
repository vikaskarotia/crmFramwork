package com.comcast.com.generic.webdriverutility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
//waitForPageToLoad
	//waitForElementPresent
	//switchToTabOnPartialUrl(driver,String partialUrl) 
    ////switchToTabOnTitle(driver,String title) 
	//switchtoFrame-index,nameId,WebElement
	//switchToAlert
	//select
	//mousemoveONElement
	//doubleClick
	private void switchToTabOnTitle(WebDriver driver,String partialTitle) {
	Set<String>	set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext()) {
		String windowID=it.next();
		driver.switchTo().window(windowID);
		
		String actUrl=driver.getTitle();
		if(actUrl.contains(partialTitle)) {
			break;
		}
	}

	}
}
