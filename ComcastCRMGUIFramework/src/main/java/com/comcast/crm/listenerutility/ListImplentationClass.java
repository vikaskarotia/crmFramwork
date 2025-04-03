package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.com.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseutility.BaseClass;

public class ListImplentationClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public ExtentSparkReporter spark;
    public  ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		// spark report config.
		String time=new Date().toString().replace(" ","-").replace(":","_");
		spark = new ExtentSparkReporter("./AdavceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM REPORT");
		spark.config().setReportName("Contact Module");
		spark.config().setTheme(Theme.DARK);
		// add enviroment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window 10");
		report.setSystemInfo("BROWSER", "chrome");

		System.out.println("suite from listener start");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("suite from listener finish");
	}

	@Override
	public void onTestStart(ITestResult result) {
		  test=report.createTest("createContactTest");
		  UtilityClassObject.setTest(test);
		 test.log(Status.INFO,  result.getMethod().getMethodName()+" is started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getMethodName()+" is completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===========Listener============");
		String var = result.getName();
		String time=new Date().toString().replace(" ","-").replace(":","_");
        test.log(Status.FAIL,var+" is failled");
//             taking screen shot
//		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
        TakesScreenshot eDriver = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,var+time);

		System.out.println("this " + var + " is failled");

		// ITestListener.super.onTestFailure(result);
	}

}
