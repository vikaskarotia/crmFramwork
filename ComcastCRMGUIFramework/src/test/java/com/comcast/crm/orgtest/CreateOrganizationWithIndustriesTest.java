package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.com.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.com.crm.objectrepositoryutility.HomePage;
import com.comcast.com.crm.objectrepositoryutility.LoginPage;
import com.comcast.com.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.com.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.com.generic.webdriverutility.JavaUtility;
import com.crm.generic.baseutility.BaseClass;

public class CreateOrganizationWithIndustriesTest extends BaseClass {

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
			System.out.println("organization created successfully");
		} else {
			System.out.println("organization not created ");
		}

	}

}
