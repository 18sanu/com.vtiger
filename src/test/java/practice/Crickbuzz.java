package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Crickbuzz {
	@Test
	public void crickbuzzTest() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.cricbuzz.com/");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
    WebElement img = driver.findElement(By.xpath("//img[contains(@title,'Nathan')]"));
	js.executeScript("arguments[0].scrollIntoView(true)",img);
	System.out.println(img.getCssValue("border-radius"));
	System.out.println(img.getCssValue("color"));
	//int h = img.getSize().getHeight();
	//int w=img.getSize().getWidth();
	
	//System.out.println(h+" "+w);
  //  driver.close();

}
}