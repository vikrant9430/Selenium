package date_Time;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;;

public class DatePicker2 {

 public WebDriver driver;
 private String today;
 
 @BeforeTest
 public void start(){
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\Software Testing\\"
     		+ "Selenium WebDriver\\Browser Driver\\chromedriver.exe");  
 driver = new ChromeDriver();
 }
 
 @Test
 public void Test(){
 
  driver.get("http://jqueryui.com/datepicker/");
  driver.switchTo().frame(0);
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  
  //Click on textbox so that datepicker will come
  
  driver.findElement(By.id("datepicker")).click();
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  
  //Click on next so that we will be in next month
  driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
  
  today = getCurrentDay();
  System.out.println("Today's number: " + today + "\n");
  
  /*DatePicker is a table.So navigate to each cell 
   * If a particular cell matches value 13 then select it
   */
  WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
 
  for (WebElement cell: columns){
   
	  //Select 13th Date 
   if (cell.getText().equals("13")){
   cell.findElement(By.linkText("13")).click();
   break;
   }
  }
  
 }
 
 
//Get The Current Day
private String getCurrentDay() {
	//Create a Calendar Object
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    
    //Get Current Day as a number
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("Today Int: " + todayInt +"\n");

    //Integer to String Conversion
    String todayStr = Integer.toString(todayInt);
    System.out.println("Today Str: " + todayStr + "\n");

    return todayStr;
	}
}