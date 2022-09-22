package com.vtiger.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author sanu
 *
 */
public class WebDriverUtility {
	/**
	 * this method is used to wait for the element to load on the webpage
	 * @param driver
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to wait for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * this method will wait for the element to be clickable for specific pollingPeriod
	 * @param driver
	 * @param element
	 * @param pollingPeriod
	 * @throws InterruptedException
	 */
	public void waitForElementToBeClickableForSpecificTime(WebDriver driver,WebElement element,int pollingPeriod) throws InterruptedException {
		FluentWait wait=new FluentWait(driver);
	    wait.pollingEvery(pollingPeriod, TimeUnit.SECONDS);
	    wait.wait(20);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	/**
	 * this method will wait for the element to be clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20){
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * this method will switch between windows
	 * @param driver
	 * @param parentWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String parentWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String winID=it.next();
			driver.switchTo().window(winID);
			String currentWindowTitle = driver.getTitle();
			if(!currentWindowTitle.contains(parentWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * this method will accept alert popup
	 * @param driver
	 */
     public void acceptAlertPopUp(WebDriver driver) {
    	 driver.switchTo().alert().accept();
     }
     
     /**
 	 * this method will dismiss alert popup
 	 * @param driver
 	 */
      public void dismissAlertPopUp(WebDriver driver) {
    	 driver.switchTo().alert().dismiss();
     }
      /**
       * this method handles drop down using visible text
       * @param element
       * @param visibleText
       */
     public void handleDropDown(WebElement element ,String visibleText) {
    	 Select select = new Select(element);
    	 select.selectByVisibleText(visibleText);
     }
     /**
      * this method handles drop down using index number
      * @param element
      * @param index
      */
     public void handleDropDown(WebElement element,int index) {
    	 Select select = new Select(element);
    	 select.selectByIndex(index);
     }
     /**
      * this method handles drop down using value
      * @param value
      * @param element
      */
     public void handleDropDown(String value,WebElement element) {
    	 Select select = new Select(element); 
                 select.selectByValue(value);          
     }
     /**
      * this method will do mouse hover action
      * @param driver
      * @param element
      */
     public void moveToElement(WebDriver driver, WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
	}
     /**
      * this method will perform right click action
      * @param driver
      */
     public void rightClick(WebDriver driver) {
    		Actions action=new Actions(driver);
            action.contextClick().perform();     
     }
     /**
      * this method will perform right click action on particular element
      * @param driver
      */
     public void rightClick(WebDriver driver,WebElement element) {
 		Actions action=new Actions(driver);
         action.contextClick(element).perform();     
  }
     /**
      * this method will handle asynchronus script
      * @param driver
      * @param javaScriptCode
      */
     public void handleAsyncScript(WebDriver driver,String javaScriptCode) {
    	 JavascriptExecutor js=(JavascriptExecutor) driver;
    	 js.executeAsyncScript(javaScriptCode, null);
     }
     /**
      * this method will take screenshot of particular webpage
      * @param driver
      * @param FileName
      * @throws IOException
      */
     public void takeScreenshot(WebDriver driver,String FileName) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./errorShots/"+FileName+".png");
    	Files.copy(src, dest);
     }
     /**
      * this method will switch to frame using index
      * @param driver
      * @param element
      */
     public void switchToFrame(WebDriver driver,int index) {
    	 driver.switchTo().frame(index);
     }
     /**
      * this method will switch to frame using value
      * @param driver
      * @param element
      */
     public void switchToFrame(WebDriver driver,String value) {
    	 driver.switchTo().frame(value);
     }
     /**
      * this method will switch to frame using particular web element
      * @param driver
      * @param element
      */
     public void switchToFrame(WebDriver driver,WebElement element) {
    	 driver.switchTo().frame(element);
     }
     
}


