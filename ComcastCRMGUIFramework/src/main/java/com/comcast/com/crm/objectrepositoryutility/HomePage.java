package com.comcast.com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
    private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Products']")
	   private WebElement productLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement moveToSignOut;
	
	public WebElement getMoveToSignOut() {
		return moveToSignOut;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement  signOutButton;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public void signOut() {
		moveToSignOut.click();
		signOutButton.click();
	}
	

}
