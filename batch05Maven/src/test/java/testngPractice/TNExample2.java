package testngPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TNExample2 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void tearDown() {
		System.out.println("AfterClass");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
		
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
	@Test
	public void test4() {
		System.out.println("test4");
	}
	@Test
	public void test5() {
		System.out.println("test5");
	}
	@Test
	public void test6() {
		System.out.println("test6");
	}
	@Test
	public void test7() {
		System.out.println("test7");
	}
	@Test
	public void test8() {
		System.out.println("test8");
	}
	@Test
	public void test9() {
		System.out.println("test9");
	}
	@Test
	public void test10() {
		System.out.println("test10");
	}
	@Test
	public void test11() {
		System.out.println("test11");
	}
	
}
