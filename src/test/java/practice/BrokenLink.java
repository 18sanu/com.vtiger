package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions option=new ChromeOptions();
      option.addArguments("disable-popup-blocking");
      option.addArguments("start-maximized");
      
      WebDriver driver=new ChromeDriver(option);
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      String homepage="https://www.flipkart.com/";
      driver.get(homepage);
      Actions action=new Actions(driver);
      action.moveByOffset(28, 95).click().perform();
      List<WebElement> links = driver.findElements(By.tagName("a"));
      Iterator<WebElement> itr=links.iterator();
      while (itr.hasNext()) {
		String url = itr.next().getAttribute("href");
		System.out.println(url);
		if(url==null||url.isEmpty()) {
			continue;
		}
		 if(!url.startsWith(homepage)){
             System.out.println("URL belongs to another domain, skipping it.");
             continue;
         }
		 try {
			HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			int rc = huc.getResponseCode();
			if(rc >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

}
