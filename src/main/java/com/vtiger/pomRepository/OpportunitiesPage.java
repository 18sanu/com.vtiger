package com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	WebDriver driver;
	
	public OpportunitiesPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@alt='Create Opportunity...']")
	private WebElement plusImageOfOpporunity;

	public WebElement getPlusImageOfOpporunity() {
		return plusImageOfOpporunity;
	}
	
	public void clickOnplusImageOfOpporunity() {
		plusImageOfOpporunity.click();
	}

}
