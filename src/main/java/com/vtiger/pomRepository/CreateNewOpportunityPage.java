package com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author sanu
 *
 */
public class CreateNewOpportunityPage {

	WebDriver driver;
	
	public CreateNewOpportunityPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[@class='lvtHeaderText']")
	private WebElement createOpportunityPageHeading;
	
	public WebElement getCreateOpportunityPageHeading() {
		return createOpportunityPageHeading;
	}

	@FindBy (name="potentialname")
	private WebElement opportunityNameTextField;
	
	@FindBy (xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement plusImageOfRelatedToTextField;

    @FindBy (xpath="//input[@value='T']")
    private WebElement groupRadioButton;
    
    @FindBy (name="assigned_group_id")
    private WebElement teamSellingOption;
    
    @FindBy (name="closingdate")
    private WebElement expectedCloseDateTextField;
    
    @FindBy (name="sales_stage")
    private WebElement salesStageDropDown;
    
    @FindBy (xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

	public WebElement getOpportunityNameTextField() {
		return opportunityNameTextField;
	}

	public WebElement getPlusImageOfRelatedToTextField() {
		return plusImageOfRelatedToTextField;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getTeamSellingOption() {
		return teamSellingOption;
	}

	public WebElement getExpectedCloseDateTextField() {
		return expectedCloseDateTextField;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
    
    
}
