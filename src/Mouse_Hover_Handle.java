import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Hover_Handle {

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
		
		//Perfrom Mouse hover action and Click on the Top button.
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.id("mousehover"));
		action.moveToElement(menu).perform();
		Thread.sleep(2000);
		
		WebElement subMenu = driver.findElement(By.linkText("Top"));
		subMenu.click();
		
		//Navigate to URL "https://demo.guru99.com/test/simple_context_menu.html".
		driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
		
		//Perfrom RightClick and Click on Quit button.
		//Actions actionOnbutton = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		action.contextClick(element).perform();
		
		WebElement quit_Button = driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[7]/span"));
		quit_Button.click();
		
		Thread.sleep(2000);
		//Accept the alert.
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		
		//Perfrom Double Click.
		//Actions perfromOnButton = new Actions(driver);
		WebElement doubleClickButton = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		action.doubleClick(doubleClickButton).perform();
		
		Thread.sleep(2000);
		//Accept the alert.
		simpleAlert.accept();
		
		//Navigate to URL "https://demoqa.com/droppable/".
		driver.navigate().to("https://demoqa.com/droppable/");
		
		//Perfrom Drag and Drop.
		//Actions dragAndDrop = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		action.dragAndDrop(from, to).build().perform();
		Thread.sleep(2000);
		
		//Close the Browser.
		driver.quit();

	}

}
