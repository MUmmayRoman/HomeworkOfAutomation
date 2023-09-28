import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenFramework_UsingJXL_TestNG_Log4J {


       WebDriver driver;
       Logger logger=Logger.getLogger("Log4jExample");
		
       @BeforeClass
   	   public void setup() throws InterruptedException
		{   
	         	   
    	 // configure log4j properties file
		 PropertyConfigurator.configure("Log4j.properties");
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
								
		//Adding Implict wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
    	@AfterClass
	    public void tear() throws InterruptedException
	    {
		// Close Browser
        driver.close();
        Thread.sleep(2000);
       logger.info("Browser Closed");
	
	    }
    	@Test
	    public void log4jExample() throws InterruptedException, BiffException, IOException
	    {
		
		
		FileInputStream fi = new FileInputStream("C:\\Roman's_WorkPlace\\Selenium\\Login.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		int z = s.getRows();
		logger.info("The number of rows in an excel sheet are: " +z);
		
		
		String url = "https://demo.guru99.com/V4/index.php";
		driver.get(url);
		
		for(int row=0; row<z; row++) {
			
			String username = s.getCell(0, row).getContents();
			logger.info("Username : " +username);
			
			WebElement text_Username = driver.findElement(By.name("uid"));
			text_Username.clear();
			text_Username.sendKeys(username);
			Thread.sleep(2000);
			logger.info("Enter the Username : "+username);
			
			String password = s.getCell(1, row).getContents();
			logger.info("Password : " +password);
			
			WebElement text_Password = driver.findElement(By.name("password"));
			text_Password.clear();
			text_Password.sendKeys(password);
			Thread.sleep(2000);
			logger.info("Enter the Password : "+password);
			
			WebElement buttonSignIn = driver.findElement(By.name("btnLogin"));
			buttonSignIn.click();
			Thread.sleep(2000);
			logger.info("Click on the login button");
			
			
			String userText = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
			logger.info(userText);
			Thread.sleep(2000);
			logger.info("Fetch the username from the screen");
			
			WebElement linkSignOut = driver.findElement(By.linkText("Log out"));
			linkSignOut.click();
			Thread.sleep(2000);
			logger.info("Click on Logout link");
			
			Alert alert = driver.switchTo().alert();		
			String alertText = alert.getText();
			logger.info(alertText);
			alert.accept();
			logger.info("Accepting the alert");
			Thread.sleep(2000);
			
		}
		
	

	}
}