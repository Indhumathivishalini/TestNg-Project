package annotationsPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TrialAnnotatePrgm {

	@AfterClass
	public void display() {
		System.out.println("after class2");
	}
	
	@Test
	public void print() {
		System.out.println("test class2");
	}
	
	@BeforeClass 
	public void display1() {
		System.out.println("before class2");
	}
}
