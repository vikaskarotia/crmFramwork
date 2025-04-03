package com.comcast.com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {

	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	WebElement orgnameTextField;
	
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 WebElement saveButton;
	 
	 @FindBy(xpath="//select[@name='industry']")
	 WebElement dropDown;
	 
	 public WebElement getDropDown() {
		return dropDown;
	}


	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	@FindBy(xpath="//input[@id='phone']")
	 WebElement phoneTextField;
	 
	
	 public WebElement getOrgname() {
		return orgnameTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

	public void createOrg(String orgname) {
		 this.orgnameTextField.sendKeys(orgname);
		 saveButton.click();
	 }
	
	public void createOrg(String orgname,String industry) {
		 this.orgnameTextField.sendKeys(orgname);
		 Select sel=new Select(dropDown);
		 sel.selectByValue(industry);
		 saveButton.click();
	 }
	
	public void createOrg(String orgname,int phone) {
		 this.orgnameTextField.sendKeys(orgname);
		 phoneTextField.sendKeys("5484464856");
		 saveButton.click();
	 }
	
	
	
}
