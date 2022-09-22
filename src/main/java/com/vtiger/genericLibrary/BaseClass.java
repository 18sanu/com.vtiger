package com.vtiger.genericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.pomRepository.HomePage;
import com.vtiger.pomRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	
	// creating object for all the libraries
			public JavaUtility jUtils = new JavaUtility();
			public FileUtility fUtils = new FileUtility();
			public ExcelUtility eUtils = new ExcelUtility();
			public WebDriverUtility wUtils = new WebDriverUtility();
			
			
			@BeforeSuite (groups={"smokeTesting","regressionTesting"})
			public void bsConfig() {
				System.out.println("====database connection is established======");
			}
			
			//@Parameters ("BROWSER")
			@BeforeClass (groups={"smokeTesting","regressionTesting"})
			public void bcConfig(/*String BROWSER*/) throws IOException {
				//reading data from property files
			String BROWSER = fUtils.getDataFromPropertyFile(IPathConstant.BROWSER_KEY);
				String URL = fUtils.getDataFromPropertyFile(IPathConstant.URL_KEY);	
				
				//launch the browser
				if (BROWSER.equals("chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equals("firefox")) {
					driver = new FirefoxDriver();
				} else
					System.out.println("browser not available");
				
				sDriver=driver;
				
				driver.get(URL);
				driver.manage().window().maximize();
				wUtils.waitForElement(driver);
			}
			
			@BeforeMethod (groups={"smokeTesting","regressionTesting"})
			public void bmConfig() throws IOException {
				String USERNAME = fUtils.getDataFromPropertyFile(IPathConstant.USERNAME_KEY);
				String PASSWORD = fUtils.getDataFromPropertyFile(IPathConstant.PASSWORD_KEY);
				LoginPage login = new LoginPage(driver);
				
				// log in action
				login.loginAction(USERNAME, PASSWORD);
				
			}
			
			@AfterMethod (groups={"smokeTesting","regressionTesting"})
			public void amConfig() {
				HomePage home=new HomePage(driver);
				home.logoutAction();
			}
			
			@AfterClass (groups={"smokeTesting","regressionTesting"})
			public void acConfig() {
				driver.quit();
			}
			
			@AfterSuite (groups={"smokeTesting","regressionTesting"})
			public void asConfig() {
				System.out.println("=======database connection closed========");
			}

}
