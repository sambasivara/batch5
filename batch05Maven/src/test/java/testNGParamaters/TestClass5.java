package testNGParamaters;

import org.testng.annotations.Test;

import reusables.Common;

public class TestClass5 extends Common{

	
	
	@Test
	public void smapleTest() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.shoppersstop.com");
			//implementation code
						
	}
	
	@Test
	public void smapleTest2() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.google.com");
			//implementation code
						
	}
	
	@Test
	public void smapleTest3() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.facebook.com");
			//implementation code
						
	}
}
