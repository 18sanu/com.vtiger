package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbUnTest extends BaseFb {
    @Test(dataProvider = "dp",dataProviderClass = DataP.class)
	public void fbTest(String un,String pw) {
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
	}
}
