import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions_Command {

	public static void main(String[] args) {
		
		//Launch a new Chrome browser
		
		//Open a URL --- https://www.letskodeit.com/practice
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Maximize the browser
		
		driver.manage().window().maximize();
		
		String url = "https://www.letskodeit.com/practice";
		driver.get(url);
		
		//Locate the alert textbox using ID attribute.
		//Enter your First Name in the alert text box.
		WebElement textbox_name = driver.findElement(By.id("name"));
		textbox_name.sendKeys("Ummay");
		
		
		//Clear the first name and enter the last name in the alert textbox.
		textbox_name.clear();
		textbox_name.sendKeys("Roman");
		
		//Locate the Element displayed example textbox using name attribute.
		WebElement textbox_hide_show = driver.findElement(By.name("show-hide"));
		
		//Enter any text on the text box.
		//WebElement element = driver.findElement(By.id("displayed-text"));
		textbox_hide_show.sendKeys("Hello World");
		
		//Click on he Hide button.
		WebElement button_hide = driver.findElement(By.id("hide-textbox"));
		button_hide.click();
		
		//Click on the Show button.
		WebElement button_show = driver.findElement(By.id("show-textbox"));
		button_show.click();
		
		
		//Find the total number of Links availble in the webpage.
		List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
		int isize = noOfLinks.size();
		
		//Print the count of Links in the eclipse console.
		System.out.println(isize);
		
		
		// Close the browser.
		driver.close();
		

	}

}
