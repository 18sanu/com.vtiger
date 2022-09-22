package practice;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B  {
static WebDriver driver;
@BeforeSuite
public void intialize() {
	WebDriverManager.chromedriver().setup();
	driver=new A().intializeDriver(driver);
}

@Test
public void Test() {
	driver.get("https://mail.google.com/mail/u/0/");
}



}
