package testNGParamaters;

import org.testng.annotations.Test;

import reusables.Common;

public class TestClass2 extends Common{

	
	
	@Test
	public void sampleTest2() throws InterruptedException {
		System.out.println("@Test sampleTest2");
		driver.get("https://www.facebook.com");
//implmentation
		Thread.sleep(2000);
		System.out.println("done");
		Thread.sleep(5000);
	}
			
}
