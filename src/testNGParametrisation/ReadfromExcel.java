package testNGParametrisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadfromExcel {

	public WebDriver driver;
	public WebDriverWait wait;

	
	
	String url ="http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=0001211294";
	public By byEmail = By.xpath("//input[@id='email']");
	public By byPassword = By.xpath("//input[@id='pwd']");
	public By byLogin = By.id("//button[@id='login-btn']");
	public By byClose = By.id("//div[@class='greeting']/i");
	
	
	@BeforeSuite
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10);

	}
	
	
//	@DataProvider(name= "SBLogin")
//	public String[][] getExcelData() throws IOException {
		
	/*
	XSSFWorkbook wbook =  new XSSFWorkbook("./data/SwitchBoardData.xlsx"); 
	XSSFSheet sheet = wbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount+"row count"+rowCount);
		String data[][]= new String [rowCount][columnCount];
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <columnCount; j++) {
				String value = row.getCell(j).getStringCellValue();
				data[i-1][j]=value;
				System.out.println(value);
			}
		}
	return data;
		
	}*/

	@Test(dataProvider ="SBLogin")
	public void verifyLogin(String userID, String password) {
		
		driver.get(url);
		// sign in 
		driver.findElement(byEmail).sendKeys(userID);
		driver.findElement(byPassword).sendKeys(password);
		driver.findElement(byLogin).click();
		// Close button
		driver.findElement(byClose).click();
	}
	
}
