import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlePractice {

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
		
		 //Store the parent window handle using getWindowHandle Command and print in the console.
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " +parentWindow);

		//Clicking on open window button
		WebElement button_OpenWindow = driver.findElement(By.id("openwindow"));
		button_OpenWindow.click();
		
		//Store all the windows using getWindowHandles command.
		Set<String> allWindows = driver.getWindowHandles();
		int isize = allWindows.size();
		System.out.println("Total number of windows available : " +isize);
		
		//Switch to child window from parent window.
		Iterator<String> iterator = allWindows.iterator();
		
		while(iterator.hasNext()) 
		{
			String childWindow = iterator.next();
			
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("ChildWindow : " +childWindow);
				
				//Locating the search textbox in the child window and type "Selenium" in the searchBox.
				WebElement textbox_Search = driver.findElement(By.name("course"));
				textbox_Search.sendKeys("Selenium");
				Thread.sleep(2000);
				
				//Click on the course Selenium WebDriver with python 3.x.
				driver.findElement(By.xpath("//*[@id=\"course-list\"]/div[3]/div/a/div[2]/h4")).click();
				Thread.sleep(2000);
				
				//Close the child window.
				driver.close();
			}
		}
		
						
		//Return back to parent window.
		driver.switchTo().window(parentWindow);
		
		//Click on Hide and Show button simaltaneously.
		WebElement elemnetHide = driver.findElement(By.id("hide-textbox"));
		elemnetHide.click();
		System.out.println("Clicked on hide button");
		Thread.sleep(2000);
		
		WebElement elemnetShow = driver.findElement(By.id("show-textbox"));
		elemnetShow.click();
		System.out.println("Clicked on show button");
		Thread.sleep(2000);
		
		//Close the browser.
		driver.quit();
				

	}

	

}
