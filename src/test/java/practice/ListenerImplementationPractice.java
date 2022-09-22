package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners (com.vtiger.genericLibrary.ListenerImplementationClass.class)
public class ListenerImplementationPractice {
@Test
	public void demo1(){
		System.out.println("step1");
		Assert.fail();
	}

}
