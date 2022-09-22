package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.BaseClass;

public class RetryAnalyserDemo extends BaseClass {
	
	@Test (retryAnalyzer = com.vtiger.genericLibrary.RetryAnalyserImplementationClass.class)
	public void demoTest() {
		System.out.println("===========step1============");
	Assert.fail();
	System.out.println("===========step2============");
	}

}
