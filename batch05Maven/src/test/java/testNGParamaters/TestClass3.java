package testNGParamaters;

import org.testng.annotations.Test;

import reusables.Common;

public class TestClass3 extends Common{

	
	
	@Test
	public void sampleTest3() throws InterruptedException {
		System.out.println("@Test sampleTest3");
		driver.get("https://courses.letskodeit.com/practice");
		
	}
			
}
