package testNGPractice;


import org.testng.annotations.Test;
@Test
public class SecondTestNGProgram extends ThirdTestNGProgram{

	/*@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("testBeforeSuite()");
	}

	@AfterSuite
	public void testAfterSuite() {
		System.out.println("testAfterSuite()");
	}*/
	
	@Test
	public void test2() {
		System.out.println("test of second program is executed");
	}
	
/*
	@BeforeTest
	public void testBeforeTest() {
		System.out.println("testBeforeTest()");
	}

	@AfterTest
	public void testAfterTest() {
		System.out.println("testAfterTest()");
	}*/

	
	
}
