import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Command {

	public static void main(String[] args) {
		
		
		//Launch a new Chrome browser
				
		//Open a URL --- https://www.letskodeit.com/practice
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		//driver.get("https://www.letskodeit.com/practice");
		
		//Or
		String url = "https://www.letskodeit.com/practice";
		driver.get(url);
		
		//Get the page title and title length.
		String pageTitle = driver.getTitle();
		
		//Fetch the title  length
		int titleLength = pageTitle.length();
		
		
		//Print the page title and title length on the console.
		System.out.println("The Title of the webPage is: " +pageTitle);
		
		//Print the page title length
		System.out.println("Length of the title is : "+ titleLength);
		
		//Get the page URL and verify if it is a correct URL opened.
		String actualUrl = driver.getCurrentUrl();
		
		if(actualUrl.equals(url)) {
		
		System.out.println("Verification successfull");
		
		}
		else
		{
			System.out.println("Verification failed");
		}
		
		
		//Get the page source and source length.
		String pageSourceCode = driver.getPageSource();
		
		//Fetch the page source length
		int pageSourceLength = pageSourceCode.length();
		
		//Print the source length on the console
		System.out.println("The length of the page source length: " +pageSourceLength);
		
		//Close the browser.
		driver.close();

	}

}
