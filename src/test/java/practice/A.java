package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	public WebDriver intializeDriver(WebDriver driver) {
		
		return new ChromeDriver();
	}
	
}
