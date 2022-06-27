package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		 this.driver=driver;
		 }
	
	@FindBy(css="div[title]>a")
	WebElement legalEntitySelection;
	
	@FindBy(css="#switchLegalEntity_chosen>div>div>input")
	WebElement legalEntityInput;
	
	@FindBy(css="button[id='dashboard-entity-button']")
	WebElement goToDashboardButton;
	
	@FindBy(css="a>label[class='tabs-item-label']")
	WebElement pageHeader1;
	
	@FindBy(css="div>label[for='switchLegalEntity']")
	WebElement pageSubheader1;
	
	@FindBy(css="button[id='dashboard-entity-button']>span")
	WebElement button1;
	
	
	public Content selectLegalEntity(String searchInputKey)
	{
		Verification.VerifyEquals("Page header not displayed", pageHeader1.getText(), "Dashboards");
		Verification.VerifyEquals("Page sub header not displayed", pageSubheader1.getText(), "Switch legal entity");
		Verification.VerifyEquals("Button text not displayed", button1.getText(), "GO TO DASHBOARD");
		search(searchInputKey);
		clickGoToDashboard();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Content clickGoToDashboard()
	{
		goToDashboardButton.click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Dashboard search(String searchInputKey)
	{
		legalEntitySelection.click();
		legalEntityInput.sendKeys(searchInputKey);
		legalEntityInput.sendKeys(org.openqa.selenium.Keys.ENTER);		
		
		return this;
	}
	
}
