import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton_CheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch a new Chrome browser
		//Open a URL --- https://www.letskodeit.com/practice
        
		WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();

        //Maximize the browser
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        
        //Locate The radio button BMW using ID attribute and click on it.
        //Select the radio BMW if it is not selected using isSelected.
        
        WebElement buttonRadioBmw = driver.findElement(By.id("bmwradio"));
        buttonRadioBmw.click();
        Thread.sleep(10000);
        boolean Status = buttonRadioBmw.isSelected();
        
        if(Status == true)
        {
        	buttonRadioBmw.click();
        	
        }
        
        //Locate The radio button BENZ using Xpath attribute and click on it.
        WebElement buttonRadioBenz = driver.findElement(By.xpath("//*[@id=\"benzradio\"]"));
        buttonRadioBenz.click();
        
        //Locate The radio button Honda using CssSelector attribute and click on it.
        WebElement buttonRadioHonda = driver.findElement(By.cssSelector("input[id=hondaradio]"));
        buttonRadioHonda.click();
        
               
        
        //CheckBox
       
		         
        //Locate The Checkbox BMW using ID attribute and click on it.
        WebElement checkBoxBmw = driver.findElement(By.id("bmwcheck"));
        checkBoxBmw.click();
        
        //Locate The Checkbox BENZ using Xpath attribute and click on it.
        //Uncheck the checkbox Benz.
       
        WebElement checkBoxBenz = driver.findElement(By.xpath("//*[@id=\"benzcheck\"]"));
        checkBoxBenz.click();
        Thread.sleep(10000);
        boolean Status1 = checkBoxBenz.isSelected();
        
       
        if(Status1 == true)
        {
        	checkBoxBenz.click();
        }
        
        //Locate The Checkbox Honda using CssSelector attribute and click on it.
        WebElement checkBoxHonda = driver.findElement(By.cssSelector("input[id=hondacheck]"));
        checkBoxHonda.click();
        
        //Select the Checkbox Honda if it is Displyed using isDisplayed.
        boolean Status2 = checkBoxHonda.isDisplayed();
        if (Status2 == true)
        {
        	checkBoxHonda.click();
        }
        
        
        //Close the browser.
        driver.close();
	}

}
