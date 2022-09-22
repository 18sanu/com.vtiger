package Opportunity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLibrary.BaseClass;
import com.vtiger.genericLibrary.ExcelUtility;
import com.vtiger.genericLibrary.FileUtility;
import com.vtiger.genericLibrary.JavaUtility;
import com.vtiger.genericLibrary.WebDriverUtility;
import com.vtiger.pomRepository.CreateNewOpportunityPage;
import com.vtiger.pomRepository.CreateNewOrganizationPage;
import com.vtiger.pomRepository.HomePage;
import com.vtiger.pomRepository.LoginPage;
import com.vtiger.pomRepository.OpportunitiesPage;
import com.vtiger.pomRepository.OpportunityInformationPage;
import com.vtiger.pomRepository.OrganizationsPage;

/**
 * 
 * @author sanu
 *
 */
public class CreateOpportunitywithSalesStageNegotiationReviewTest extends BaseClass{
    @Test
	public void createOpportunitywithSalesStageNegotiationReviewTest() throws EncryptedDocumentException, IOException, InterruptedException {
    	 // generating random numbers
		int randomNum = jUtils.randomValue();
        
		//reading data from excel file
		String orgName = eUtils.getStringDataFromExcelSheet("Sheet1", 4, 2) + randomNum;
		String firstName = eUtils.getStringDataFromExcelSheet("Sheet1", 4, 3) + randomNum;
		String lastName = eUtils.getStringDataFromExcelSheet("Sheet1", 4, 4) + randomNum;
		String opportunityName = eUtils.getStringDataFromExcelSheet("Sheet1", 4, 5) + randomNum;
		String salesStage = eUtils.getStringDataFromExcelSheet("Sheet1", 4, 6);
        
		//creating object for POM classes
		LoginPage login = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		OrganizationsPage organization = new OrganizationsPage(driver);
		CreateNewOrganizationPage createOrganization = new CreateNewOrganizationPage(driver);
		OpportunitiesPage opportunities = new OpportunitiesPage(driver);
		CreateNewOpportunityPage createOpportunity = new CreateNewOpportunityPage(driver);
		OpportunityInformationPage opportunityInformation = new OpportunityInformationPage(driver);
		
		
		
		// verifying home page is displayed or not
		String titleHome = driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(titleHome.contains("Home"));
	

		// creating new organization
		homePage.clickOnOrganizationLink();
		organization.clickOnOrganizationPlusImage();
		createOrganization.passValueToOrganizationTextField(orgName);
		createOrganization.clickOnSaveButton();
		Thread.sleep(5000);

		// creating new opportunity
		homePage.getOpportunitiesLink().click();
		
		// verifying Opportunity page is displayed or not
		String titleOpportunity = driver.getTitle();
		soft.assertTrue(titleOpportunity.contains("Opportunities"));
	     
		opportunities.clickOnplusImageOfOpporunity();

		// verifying creating new opportunity page is displayed or not
		String CrtNwOpp = createOpportunity.getCreateOpportunityPageHeading().getText();
		soft.assertTrue(CrtNwOpp.contains("Creating New Opportunity"));
	
		createOpportunity.getOpportunityNameTextField().sendKeys(opportunityName);
		createOpportunity.getPlusImageOfRelatedToTextField().click();
		
        String s = driver.getWindowHandle();
		String parentTitle = driver.getTitle();
		wUtils.switchToWindow(driver, parentTitle);
		
		// verifying organization page is displayed or not
		String moduleName = driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
		soft.assertTrue(moduleName.contains("Organizations"));

		driver.findElement(By.id("search_txt")).sendKeys(orgName + Keys.ENTER);
		driver.findElement(By.linkText("" + orgName + "")).click();
		driver.switchTo().window(s);

		createOpportunity.getGroupRadioButton().click();
		wUtils.handleDropDown(createOpportunity.getTeamSellingOption(), "Team Selling");
        createOpportunity.getExpectedCloseDateTextField().clear();
        createOpportunity.getExpectedCloseDateTextField().sendKeys(jUtils.getSystemDateInYYYY_MM_DDFormat());

		WebElement salesStageBox = createOpportunity.getSalesStageDropDown();
		wUtils.handleDropDown(salesStage, salesStageBox);
		
		// verifying sales stage
		soft.assertTrue(salesStageBox.getText().contains(salesStage));
		
		createOpportunity.getSaveButton().click();
		//verifying opportunity is created or not
		String actualOpportunityName = opportunityInformation.getActualOpportunityName().getText();
		
		soft.assertTrue(actualOpportunityName.contains(opportunityName));
		soft.assertAll();

	}
}
