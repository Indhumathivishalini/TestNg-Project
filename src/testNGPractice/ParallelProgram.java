package testNGPractice;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ParallelProgram {


	@Test
	public void getChrome() throws AWTException, InterruptedException  {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();


		// tutorialsPoint
		driver.get("https://www.tutorialspoint.com/xpath/");
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		
		
		Thread.sleep(2000);
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs1.size());
		driver.switchTo().window(tabs1.get(1));
		// Gmail
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.switchTo().window(tabs1.get(0));
		driver.get("https://www.tutorialspoint.com");
		/*String title1 = driver.getTitle();
		System.out.println(title1);*/
		//driver.close();

	}

	@Test
	public void getWindow() throws AWTException, InterruptedException  {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		// yoco link 
		driver.get("https://my.yocoboard.com/hours");

		Robot robot1 = new Robot();
		
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_T);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2000);

		ArrayList<String> listOfwin = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(listOfwin.size());
	
		driver.switchTo().window(listOfwin.get(1));
		// geeksforgeeks 
		driver.get("https://www.geeksforgeeks.org/java/#Basics");
	
		
		}
	

	} 

	


	

/*@Test
	public void getFirefox()  {
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 driver.get("http://www.SoftwareTestingMaterial.com");
		driver.close();
}*/
