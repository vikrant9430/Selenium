package Google_001.GoogleTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppTest{
	protected WebDriver driver;
	
	@Test
	public void Title(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Vikrant Nandan\\Desktop\\Software Testing\\"
        		+ "Selenium WebDriver\\Browser Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		String eTitle = "Google";
		String aTitle = "";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		aTitle = driver.getTitle();
		
		if (aTitle.contentEquals(eTitle)){
			System.out.println("Test Passed");
		}
		else{
			System.out.println("Test Failed");
					
		}
		
		driver.quit();
		
		
		
		
	}
	
	
}
   