import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_Command {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch a New Chrome Browser.
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Open the URL "https://www.letskodeit.com/practice".
		driver.navigate().to("https://www.letskodeit.com/practice");
		
		//Adding a delay of 10 seconds
		Thread.sleep(10000);
		
		//OR
		//String url = "https://www.letskodeit.com/practice";
		//driver.navigate().to(url);
		
		//Manually Click on the SignIn Link.
		
		//Click On Back Button.
		driver.navigate().back();
		System.out.println("Navigate backward");
		
		//Click On Forward button.
		driver.navigate().forward();
		System.out.println("Navigate forward");
		
		//Refresh the web Page.
		driver.navigate().refresh();
		System.out.println("Refresh the webpage");
		
		//Close the Browser.
		driver.close();
		
		

	}

}
