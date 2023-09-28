import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupAlert_Handle {

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
		
		//Enter your First Name in the Alert textbox.
		WebElement textbox_alert = driver.findElement(By.id("name"));		
		textbox_alert.sendKeys("Ummay");
				
		//Click on alert button.
		WebElement button_Alert = driver.findElement(By.id("alertbtn"));
		button_Alert.click();
		
		Alert simpleAlert = driver.switchTo().alert();
					
		//Fetch the Alert text and print it on the console.
		String firstAlert = simpleAlert.getText();
		System.out.println(firstAlert);
				
		Thread.sleep(2000);
		
		//Accept the alert.
		simpleAlert.accept();
		 
		 
		//Enter the last Name in the alert textbox.
						
		textbox_alert.sendKeys("Roman");
		
		//Click on the confirm button.
		 WebElement button_Confirm = driver.findElement(By.id("confirmbtn"));
		 button_Confirm.click();
		 
		 Alert confirmAlert = driver.switchTo().alert();
		 
		//Fetch the alert text and print it on the console.
		 String secondAlert = confirmAlert.getText();
		 System.out.println(secondAlert);
		
		 Thread.sleep(2000);
		 
		//Cancel the popup.
		 confirmAlert.dismiss();
		 
		//Again click on the confirm button and now accept the alert.
		 //driver.findElement(By.id("confirmbtn")).click();
		 button_Confirm.click();
		 
		 Thread.sleep(2000);
		 confirmAlert.accept();
		 
		//Close the Browser.
        driver.close();
	}

}
