package testNGParamaters;

import org.testng.annotations.Test;

import reusables.Common;

public class TestClass1 extends Common{

	
	
	@Test
	public void smapleTest() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.google.com");
			//implementation code
						
	}
		
}
