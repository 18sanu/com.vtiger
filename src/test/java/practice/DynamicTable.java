package practice;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	      ChromeOptions option=new ChromeOptions();
	      option.addArguments("disable-popup-blocking");
	      option.addArguments("start-maximized");
	      
	      WebDriver driver=new ChromeDriver(option);
	      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	      driver.get("https://demo.guru99.com/test/web-table-element.php");
	      List<WebElement> pricelist = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody//td[4]"));
	      List<WebElement> companylist = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody//td[1]"));
	    
	      int maxindex=0;
	      for(int i=0;i<pricelist.size();i++) {
	    	  if(Double.parseDouble(pricelist.get(i).getText())>Double.parseDouble(pricelist.get(maxindex).getText())) {
	    		  maxindex=i;
	    	  }
	    	  
	      }
	   
				System.out.println(companylist.get(maxindex).getText());
		
		}
	    
	   
	    
	   
	                               

	}


