package date_Time;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DateTimePicker {

    @Test
    public void dateTimePicker(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\Software Testing\\"
        		+ "Selenium WebDriver\\Browser Driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/selenium");

        //Find the date time picker control
        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

        //Fill date as mm/dd/yyyy as 02/28/2017
        dateBox.sendKeys("02282017");

        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);

        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");

    }

    }
