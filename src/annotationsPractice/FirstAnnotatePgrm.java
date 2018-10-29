package annotationsPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FirstAnnotatePgrm extends TrialAnnotatePrgm {

	
@AfterClass	
	public void print() {
		// TODO Auto-generated method stub
System.out.println("after class1");
	}
@Test
public void print1() {
	// TODO Auto-generated method stub
System.out.println("test class 1");
}
@BeforeClass
public void display() {
	System.out.println("before class1");
}
}
