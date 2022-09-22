package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFb {
	WebDriver driver;
 @BeforeClass
 public void bcconfig() {
	 WebDriverManager.chromedriver().setup();
	     ChromeOptions options=new ChromeOptions();
	     options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 }
 @AfterClass
 public void acconfig() {
	 driver.quit();
 }
}
