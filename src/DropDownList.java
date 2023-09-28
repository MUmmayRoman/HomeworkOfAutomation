import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {
	
	//Launch a new Chrome browser
	//Open a URL --- https://www.letskodeit.com/practice
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver;
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
     driver = new ChromeDriver();
	
	//Maximize the browser
	driver.manage().window().maximize();
	
	driver.get("https://www.letskodeit.com/practice");
	
	//Locate the single select example using id locator.
	WebElement singleSelectExample = driver.findElement(By.id("carselect"));
	Select select = new Select(singleSelectExample);
	
	//Select the value Benz Using index.
	select.selectByIndex(1);
	
	//Select the value Honda Using visible text.
	select.selectByVisibleText("Honda");
	
	//Select the value BMW Using Value.
	select.selectByValue("bmw");
	
	//Get all the options of the drop down and print the count and value in the console.
	
	List<WebElement>allOption = select.getOptions();
	int isize =allOption.size();
	System.out.println(isize);
	
	for(int i=0; i<isize; i++) {
		String sValue = allOption.get(i).getText();
		System.out.println(sValue);
	}

	
	//Check the Multi select example is Multiple or Not.
	WebElement multiSelectExample = driver.findElement(By.id("multiple-select-example"));
	Select multiSelect = new Select(multiSelectExample);
	
	
	//If True then select Apple using selectByValue and peach using selectByVisibleText and Orange using select index.if(select.isMultiple()) {
	
	if(multiSelect.isMultiple())  {
		
		multiSelect.selectByIndex(1);
		multiSelect.selectByValue("apple");
		multiSelect.selectByVisibleText("Peach");
	
	}
    //Fetch the first selected option from the dropdown.
	WebElement firstSelectedOption = multiSelect.getFirstSelectedOption();
	System.out.println(firstSelectedOption);
	
	//Deselect The option orange using any deselect method.
	multiSelect.deselectByValue("orange");
	
	//deselect all the selected option.
	multiSelect.deselectAll();
	
	//Close the browser.
	driver.close();
	
	
	}

}	