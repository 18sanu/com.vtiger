package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Google {
@Test
	public void googleTest() {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement searchbar = driver.findElement(By.name("q"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='java'",searchbar);
		
		WebElement search = driver.findElement(By.name("btnK"));
		
		js.executeScript("arguments[0].click()",search);
	//	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement next = driver.findElement(By.xpath("//span[.='Next']"));
		js.executeScript("arguments[0].scrollIntoView(true)",next);
      //  driver.close();
	}	
	}


