package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class AssertPractice {

	@Test
	public void verify() {
		SoftAssert soft=new SoftAssert();
		
		System.out.println("Test 1 passed");
		System.out.println("Test 2 passed");
      Reporter.log("failled",true);
		System.out.println("Test 3 passed");
		System.out.println("Test 4 passed");
		soft.assertAll();
	}
}
