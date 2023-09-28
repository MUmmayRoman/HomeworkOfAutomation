import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchData_FromWebTable {

	public static void main(String[] args) {
		
		
//Launch a new Chrome browser
		
//Open a URL --- https://www.letskodeit.com/practice
WebDriver driver;
System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
driver = new ChromeDriver();

//Maximize the browser
driver.manage().window().maximize();
driver.get("https://www.letskodeit.com/practice");

//Fetch the text "Selenium WebDriver With Java" Using First method and print it in the console.
WebElement element = driver.findElement(By.xpath
		("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr[2]/td[2]"));
String text = element.getText();
System.out.println(text);

//Fetch the text "25" using second Method and print it in the console.

String sRow = "4";
String sCol = "3";

  WebElement colValue = driver.findElement(By.xpath
("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr["+sRow+"]/td["+sCol+"]"));
String columnText = colValue.getText();
System.out.println(columnText);

//Fetch the text "30" using second Method and print it in the console.

String sRows = "3";
String sCols = "3";

WebElement priceValue = driver.findElement
(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr["+sRows+"]/td["+sCols+"]"));
String columnText1 = priceValue.getText();
System.out.println(columnText1);


//Fetch all the values of the price column using third method and print it in the console.
String Column = "Price";
for(int i=1; i<=3; i++)  {
	
	String sValue = null;
 WebElement Rows = driver.findElement(By.xpath
		("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr[1]/th["+i+"]"));
sValue = Rows.getText();
System.out.println(sValue);

if(sValue.equalsIgnoreCase(Column)) {
	for(int j=2; j<=4; j++) {
String columnValue = driver.findElement(By.xpath
	("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr["+j+"]/td["+i+"]")).getText();
System.out.println(columnValue);
	}
	
	break;
	}
}


// Fetch all the values of the Course column using third method and print it in the console.
String Column2 = "Course";
for(int i=1; i<=3; i++)  {
	
	String sValue = null;
	sValue = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr[1]/th["+i+"]")).getText();
	System.out.println(sValue);
	
	if(sValue.equalsIgnoreCase(Column2)) {
		for(int j=2; j<=4; j++) {
			String columnValue = driver.findElement
			(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr["+j+"]/td["+i+"]")).getText();
		System.out.println(columnValue);
		}
		break;
	}
	
}


//Close the browser.
driver.close();



	}

}
