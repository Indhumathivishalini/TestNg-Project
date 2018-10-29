package testNGPractice;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchBoard {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void launchbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10);
		driver.get("http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=0001211294");
		// sign in 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("indhumathi.rajavel@anywhere.co");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Indhu@123");
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();
		// Close button
		driver.findElement(By.xpath("//div[@class='greeting']/i")).click();
		Thread.sleep(1000);
     	System.out.println("Executing BeforeTest");
    	
	}
	
	// we cannot use priority and depends together
	
	@Test//(enabled = false)
	public void verifyHomepageTitle() {
		 String expectedTitle = "SB";
         String actualTitle = driver.getTitle();
         Assert.assertEquals(actualTitle, expectedTitle);
      	System.out.println("Executing Verify Test");
    	
	}
	
//	@Test//(priority= 1)
	@Test(dependsOnMethods = "verifyHomepageTitle")
	public void SwitchboardMessage() throws InterruptedException {
	  
	         	// enter name
				driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("johnie");
				
			/*	WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']/preceding::label[2]")));
				until.click();
			*/	// verify the name
				//Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='checkbox']/preceding::label[2]")).click();
				// enter email id
				driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("john@gmail.com");
				// verify email
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]/parent::label")).click();
				//enter the message
				driver.findElement(By.xpath("//div[@class=\"paragraph-field\"]//following::textarea")).sendKeys("Hi!!!");
				// enter company name
				driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("Full Creative");
				// verify company name
				driver.findElement(By.xpath("(//input[@type='checkbox'])[3]/parent::label")).click();

				// select country code
				driver.findElement(By.xpath("//p[@class='phoneCodeDwn']")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

				WebElement cc = driver.findElement(By.xpath("//ul[@class='phoneCountryCode']/li[2]"));
				cc.click();		

				// enter phone num
				driver.findElement(By.xpath("//input[@class='phoneNo']")).sendKeys("1234560");
				// enter extension
				driver.findElement(By.xpath("//input[@class='ext']")).sendKeys("04288");

				// click on check box
				driver.findElement(By.xpath("(//input[@type='checkbox'])[4]/parent::label")).click();

				// select deliver method
				WebElement selectdropdown = driver.findElement(By.xpath("//select[@style='border-color:red;']"));

				Select dropdown = new Select(selectdropdown);
				//dropdown.selectByVisibleText("test");
				dropdown.selectByIndex(1);

				// finish call dropdown

				WebElement finishdd = driver.findElement(By.xpath("//a[@class='fa fa-caret-down dropdown-toggle']"));
				finishdd.click();
				driver.findElement(By.xpath("//ul[@id='substatusfinishcall']/li[2]")).click();

		     	System.out.println("Executing SwitchBoard Testcase");
		    	
	}
	
	@AfterTest
	public void close() {
		
		System.out.println("Executing AfterTest");
		driver.close();
	}
	
}
