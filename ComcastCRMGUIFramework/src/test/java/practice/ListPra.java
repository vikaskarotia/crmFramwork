package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
import com.crm.generic.baseutility.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListImplentationClass.class)
public class ListPra extends BaseClass {

	@Test
	public void listPractice() {
		
		System.out.println("hello from listPractice");
		Assert.assertTrue(false);
	}
	 
}
