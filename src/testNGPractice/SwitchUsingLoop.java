package testNGPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchUsingLoop {

	WebDriver driver;

	@Test
	public void SwitchTabs() throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();


		// tutorialsPoint
		driver.get("https://www.tutorialspoint.com/css_online_training/index.asp");
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);

Thread.sleep(2000);
		ArrayList<String> listWin = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(listWin.size());
		driver.switchTo().window(listWin.get(1));
		driver.get("https://www.guru99.com");

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);


		ArrayList<String> listWin1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(listWin1);
     //    int num = listWin1.size();
		System.out.println(listWin1.size());
		driver.switchTo().window(listWin1.get(2));
		driver.get("https://www.geeksforgeeks.org/");
		Thread.sleep(2000);
		
		ArrayList<String> titles = new ArrayList<String>();
		titles.add("CSS Online Training");
		titles.add("Meet Guru99 - Free Training Tutorials & Video for IT Courses");
		titles.add("GeeksforGeeks | A computer science portal for geeks");
		
	for (int i = 0; i<listWin1.size();i++) {
		driver.switchTo().window(listWin1.get(i));
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals(titles.get(i))) {
		System.out.println("sucessfully switched"+i);
	}
	
	}
	
	

	
	/*public void switchToWindow(String title){
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles()); // Gets all the available windows
		for(String handle : handles)
		{
			driver.switchTo().window(handle); // switching back to each window in loop
			if(driver.getTitle().equals(title)) { // Compare title and if title matches stop loop and return true
			driver.switchTo().window(currentWindow);	// We switched to window, so stop the loop and come out of funcation with positive response
			}

		}}
*/
	}}







