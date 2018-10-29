package testNGPractice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGProgram {
//extends SecondTestNGProgram {
	@Test
	public void test3() {
		
		System.out.println("test of first program is executed ");
	}  

	@Test(enabled = false)
	public void test4() {
		
		System.out.println("test4 of first program is executed ");
	}  
	
	@BeforeClass
	public void beforeclass () {
		System.out.println("executing before class ");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("executing After class ");
	}
	
	@BeforeMethod
	public void beforemethod() {
		

		System.out.println("executing before method");

	}
	@AfterMethod
	public void aftermethod() {

		System.out.println("executing after method");
	}
	
	
	/*
	@BeforeTest
	public void beforetest() {
		System.out.println("executing before test ");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("executing after test ");
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("Executing beforeSuite");

	}



	@AfterSuite

	public void afterSuite() {

		System.out.println("Executing afterSuite");

	}
	*/

}
