package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyszerTest {

	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("retry");
		Assert.assertEquals("x","c");  
	}
}
