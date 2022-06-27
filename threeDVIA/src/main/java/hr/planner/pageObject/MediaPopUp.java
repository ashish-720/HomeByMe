package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MediaPopUp {
	
	WebDriver driver;
	public MediaPopUp(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(css = "[data-i18n='project_overview.print']")
	private WebElement printMyProject;
	
	@FindBy(css = "[aria-controls='project-overview-tab-1']")
	private WebElement projectOverview;
	
	@FindBy(css = "[aria-controls='project-overview-tab-2']")
	private WebElement priceDetail;
	
	@FindBy(css = "[aria-controls='project-overview-tab-3']")
	private WebElement myPicture;
	
	
	
	@FindBy(css = "#project-overview-tab-3>h1")
	private WebElement myMediaText;
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//h2[text()='Duplicate-HR']")
	private WebElement projectName;
	
	@FindBy(xpath = "//p[text()='£2,844.00']")
	private WebElement priceText;
	
	@FindBy(css = "[data-ui-action='layer-iframe-close']>[data-i18n='project_overview.close']")
	private WebElement closeMedia;
	
	public MediaPopUp projectName(String name, String price) {
		
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		Verification.VerifyEquals("Project Title KO", projectName.getText(), name);
		
//		UtilHBM.waitExplicitDisplayed(driver, price);
//		Verification.VerifyEquals("Project Title KO", priceText.getText(), price);
		
		return PageFactory.initElements(driver, MediaPopUp.class);
	}
	
	public MediaPopUp projectOverview() {
	
		projectOverview.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".project-overview-section>.tt-1")));
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".project-overview-flex-wrapper>figure>img")));
		
		return PageFactory.initElements(driver, MediaPopUp.class);
	}
	
	public MediaPopUp priceDetail() {
		
		priceDetail.click();
		return PageFactory.initElements(driver, MediaPopUp.class);
	}
	
	public MediaPopUp myPicture() {
		
		myPicture.click();
		UtilHBM.waitExplicitDisplayed(driver, myMediaText);
		return PageFactory.initElements(driver, MediaPopUp.class);
	}
	
	public HomePlanner close() {
		
		closeMedia.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
}
