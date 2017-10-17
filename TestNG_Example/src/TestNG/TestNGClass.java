package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass {
	public WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Abhisek Kumar\\Desktop\\Software Tetsting Material\\Selenium WebDriver\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		//Puts a Implicit wait, Will wait for 10 seconds before throwing exception
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Launch WebSite
	    driver.navigate().to("http://www.calculator.net");
	}
	  @Test
	  public void calculatepercent() throws Exception
	  {
		  Thread.sleep(10000);
		// Click on Math Calculators 
		driver.findElement(By.xpath("html/body/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/div[3]/a")).click();    

		// Click on Percent Calculators	
		driver.findElement(By.xpath("html/body/div[3]/div[1]/ul[1]/li[3]/a")).click();     

		// Enter value 10 in the first number of the percent Calculator
		driver.findElement(By.id("cpar1")).sendKeys("10"); 		

		// Enter value 50 in the second number of the percent Calculator    	
		driver.findElement(By.id("cpar2")).sendKeys("50");		

		// Click Calculate Button	
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr/td[2]/input")).click();	   

		// Get the Result Text based on its xpath    	
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/span/font/b")).getText();		  

		//Print a Log In message to the screen		
		System.out.println(" The Result is " + result);					
			
		if(result.equals("5"))
		{
			System.out.println(" The Result is Pass");
		}
		else
		{
			System.out.println(" The Result is Fail");
		}		    
	  }

	  @AfterTest
	  public void terminatetest()
	  {   
	    driver.close();
	  }
}
