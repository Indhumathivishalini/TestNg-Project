package testNGParametrisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
 
	@Test
	@Parameters({"userId","pwd"})
	public void launchBrowser(String userId, String pwd)  {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.get("http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=0001211294");
		// sign in 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userId);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();
		// Close button
		driver.findElement(By.xpath("//div[@class='greeting']/i")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
