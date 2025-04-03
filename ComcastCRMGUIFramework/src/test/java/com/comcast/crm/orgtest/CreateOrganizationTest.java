package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.com.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.com.crm.objectrepositoryutility.HomePage;
import com.comcast.com.crm.objectrepositoryutility.LoginPage;
import com.comcast.com.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.com.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.com.generic.webdriverutility.JavaUtility;
import com.comcast.com.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImplentationClass;
import com.crm.generic.baseutility.BaseClass;


//@Listeners(com.comcast.crm.listenerutility.ListImplentationClass.class)
public class CreateOrganizationTest extends BaseClass {

	
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws IOException{

		
		//login to application
		
		HomePage hp = new HomePage(driver);
		
		//clicking on organization link
		UtilityClassObject.getTest().log(Status.INFO,"clicking on organization link");//log statement
		hp.getOrgLink().click();

		OrganizationPage org = new OrganizationPage(driver);

		UtilityClassObject.getTest().log(Status.INFO,"clicking on organization link");//log statement
		org.getCreateOrgButton().click();

		// create organization page WebElements
		CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO,"clicking on organization link");//log statement
		String orgname = eLib.getData("work", 1, 0) + jLib.getRandomNumber();// FETCHING DATA FROM EXCEL FILE
		
		UtilityClassObject.getTest().log(Status.INFO,"clicking on organization link");//log statement
		co.createOrg(orgname);

		// VERIFY THE ORGANIZATION CREATED OR NOT
		
		UtilityClassObject.getTest().log(Status.INFO,"clicking on organization link");//log statement
		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String craetedOrgname = op.getOrgname().getText();
		if (orgname.equals(craetedOrgname)) {
			Assert.assertEquals("a", "b");
			System.out.println("organization created successfully");
		} else {
			System.out.println("organization not created ");
		}

	}

	@Test(groups = "regresionTest")
	public void createOrganizationWithIndustriesTest() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage org = new OrganizationPage(driver);

		org.getCreateOrgButton().click();

		// create organization page WebElements
		CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		String orgname = eLib.getData("work", 1, 0) + jLib.getRandomNumber();// FETCHING DATA FROM EXCEL FILE
		co.createOrg(orgname, "Education");

		// VERIFY THE ORGANIZATION CREATED OR NOT
		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String craetedOrgname = op.getOrgname().getText();
		if (orgname.equals(craetedOrgname)) {
			Assert.assertEquals("a", "b");
			System.out.println("organization created successfully");
		} else {
			System.out.println("organization not created ");
		}

	}

	@Test(groups = "regresionTest")
	public void createOrganizationWithPhoneNumberTest() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage org = new OrganizationPage(driver);

		org.getCreateOrgButton().click();

		// create organization page WebElements
		CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		String orgname = eLib.getData("work", 1, 0) + jLib.getRandomNumber();// FETCHING DATA FROM EXCEL FILE
		co.createOrg(orgname, 454545);

		// VERIFY THE ORGANIZATION CREATED OR NOT
		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String craetedOrgname = op.getOrgname().getText();
		if (orgname.equals(craetedOrgname)) {
			Assert.assertEquals("a", "b");
			System.out.println("organization created successfully");
		} else {
			System.out.println("organization not created ");
		}

	}

}
