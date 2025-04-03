package com.comcast.com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="user_name")
	WebElement userEdt;
	
	@FindBy(name="user_password")
	WebElement passEdt;
	
	@FindBy(id="submitButton")
	WebElement loginEdt;


	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPassEdt() {
		return passEdt;
	}


	public WebElement getLoginEdt() {
		return loginEdt;
	}


	public void login(String user,String pass) {
		
		userEdt.sendKeys(user);
		passEdt.sendKeys(pass);
		loginEdt.click();
		
//		getUserEdt().sendKeys(user);
//		getPassEdt().sendKeys(pass);
//		getLoginEdt().click();
	}
	
}
