package com.crm.generic.baseutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.com.crm.objectrepositoryutility.HomePage;
import com.comcast.com.crm.objectrepositoryutility.LoginPage;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.com.generic.webdriverutility.JavaUtility;
import com.comcast.com.generic.webdriverutility.UtilityClassObject;

public class BaseClass {
	
	
	/* Object creation */
   public   FileUtility fLib = new FileUtility();
   public	ExcelUtility eLib = new ExcelUtility();
   public	JavaUtility jLib = new JavaUtility();

//   public ExtentSparkReporter spark=null;

 //static non static webdriver instence
   public static WebDriver sdriver=null; 
   public WebDriver driver=null;
  
   
	@BeforeSuite(groups={"smokeTest","regresionTest"})
	
	public void configBeforeSuite() {
		System.out.println("connection to db successfull");
		
	

	}
	
	@AfterSuite(groups={"smokeTest","regresionTest"})
	public void configAfterSuite() {
		System.out.println("disconnected");
		
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regresionTest"})
	public void configBeforeClass(/*String browser*/) throws IOException {
		String BROWSER ="chrome";
				//fLib.getData("BROWSER");
		String URL =fLib.getData("URL");
		
		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("firefox"))
		driver=new FirefoxDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else 
			driver=new ChromeDriver();
		
		sdriver=driver;
		
		UtilityClassObject.setDriver(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		System.out.println("before class");
		
		}
	
	@AfterClass(groups={"smokeTest","regresionTest"})
	public void configAfterClass() {
		
		driver.close();
		System.out.println("After class");
		
	}
	
	@BeforeMethod(groups={"smokeTest","regresionTest"})
	public void configBeforeMethod() throws IOException {
		String USERNAME=fLib.getData("USERNAME");
		String USERPASSWORD=fLib.getData("USERPASSWORD");
		LoginPage l = new LoginPage(driver);
		l.login(USERNAME, USERPASSWORD);
		System.out.println("before method");
		
	}
	
	@AfterMethod(groups={"smokeTest","regresionTest"})
	public void configAfterMethod() {
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		System.out.println("log out");
		HomePage hp=new HomePage(driver);
		hp.signOut();
		
		System.out.println("After method");
	}
	
}
