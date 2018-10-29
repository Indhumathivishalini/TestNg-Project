package testNGPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwtichBetweenTabs {

	WebDriver driver;
	
	@Test
	public void SwitchTabs() throws AWTException, InterruptedException {
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
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);
		
		ArrayList<String> listWin = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(listWin);
		
		System.out.println(listWin.size());
		driver.switchTo().window(listWin.get(2));
		Thread.sleep(2000);
		driver.get("https://my.yocoboard.com/hours");
		
		driver.switchTo().window(listWin.get(1));
				
	}
}
