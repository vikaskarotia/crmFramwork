package practice;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.generic.baseutility.BaseClass;

import junit.framework.Assert;




@Listeners(com.comcast.crm.listenerutility.ListImplentationClass.class)
public class ExtentReportTest extends BaseClass {
	@Test
	public void createContactTest() {
		
		System.out.println("in createContactTest");
		Assert.assertEquals("a","b");
	}
	
	}
	



	

