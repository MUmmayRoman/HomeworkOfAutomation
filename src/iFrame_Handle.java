import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame_Handle {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Launch a new chrome browser.
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
								
		//Open the URL "https://www.letskodeit.com/practice";
		String url = "https://www.letskodeit.com/practice";
		driver.get(url);
						
	    //Adding Implict wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Switch to iFrame and Locate the Search textbox.
		WebElement frameID = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(frameID);
		
		//Search with Keyword Selenium.
		WebElement textbox_Search = driver.findElement(By.name("course"));
		textbox_Search.sendKeys("Selenium");
		Thread.sleep(2000);
		
		//Select the course Selenium WebDriver with Python 3.x.
		driver.findElement(By.xpath("//*[@id=\"course-list\"]/div[3]/div/a/div[2]/h4")).click();
		Thread.sleep(2000);
		
		//Return back to default page.
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		System.out.println("Currently in the default page");
		
		
		//Scroll Up
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-350)");
		Thread.sleep(2000);
		
		
		// Refreshing the webpage
		driver.navigate().refresh();
		
		
		// Alter example textbox
		
		WebElement textbox = driver.findElement(By.name("enter-name"));
		textbox.sendKeys("Ummay");
		
		//Click on alert button.
		WebElement button_Alert = driver.findElement(By.id("alertbtn"));
		button_Alert.click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		
		//Accept the Alert.
		simpleAlert.accept();
		//Close the Browser.
		driver.close();

	}

}
