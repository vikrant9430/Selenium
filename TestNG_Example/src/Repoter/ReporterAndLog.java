package Repoter;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterAndLog {
	private static WebDriver driver = null;
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	@Test
	public static void test() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\selenium"
				+ "\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		DOMConfigurator.configure("log4j.xml");
		
		
		driver = new FirefoxDriver();
		log.info("Browser Invoked");
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        log.info("Timedout applied for 30 Seconds");
 
        driver.get("http://www.store.demoqa.com");
        
        Reporter.log("Application Lauched successfully | ");
        
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
        log.info("Click action performed on My Account link");
 
        driver.findElement(By.id("log")).sendKeys("testuser_1");
 
        log.info("Username entered in the Username text box");
 
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
        log.info("Password entered in the Password text box");
 
        driver.findElement(By.id("login")).click();
 
        /*log.info("Click action performed on Submit button");
 
        // Here we are done with our Second main event
 
        Reporter.log("Sign In Successful | " );
 
        driver.findElement(By.id("account_logout"));
 
        log.info("Click action performed on Log out link");*/
       String text = driver.findElement(By.xpath(".//*[@id='menu-item-33']/a")).getText();
        
        if(text.equals("Product Category")){
        	 
			Reporter.log("Verification Passed forText");
 
		}else{
 
			Reporter.log("Verification Failed for Text");
 
		}
 
        driver.quit();
 
        log.info("Browser closed");
 
        // This is the third main event
 
        Reporter.log("User is Logged out and Application is closed | ");
 
	}
 	}
