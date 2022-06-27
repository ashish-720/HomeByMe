package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FurnitureConfigurator {
	
	WebDriver driver;
	
	public FurnitureConfigurator(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(id="configurator-container")
	private WebElement confugratorApp;
	
	@FindBy(css="body>.overlay-top>div>div>.overlay-top-title-message")
	private WebElement title;
	
	@FindBy(css="body>.overlay-top>div>#cancel-design-tool")
	private WebElement closeBtn;
	
	@FindBy(css="body>.overlay-top>div>div>div>.overlayProduct-txt-title")
	private WebElement productTitle;
	
	@FindBy(css="body>.interface-react.noselect>div>div[class='loader-screen']+div+ul+a.done-button")
	private WebElement doneBtn;
	
	protected ThreeDPlanner verifyNClickDone(String productName){
		UtilHBM.waitExplicitDisplayed(driver, title);
		Verification.displayNAttributeCheckOfElement(title, "Title of Configurator", "text", "Configure your product");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));		
		driver.switchTo().frame(UtilHBM.webElement(driver, "#configurator-container>iframe[src='https://d2iury6ergb1tc.cloudfront.net']"));
		driver.switchTo().frame(UtilHBM.webElement(driver, "#configurator"));
		UtilHBM.waitExplicitDisplayed(driver, "//div[@id='conf3D'][@class='loader-configurateur-3D active']");
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='loader-screen active']");
		UtilHBM.waitExplicitClickable(driver, doneBtn);
		UtilHBM.waitExplicitDisplayed(driver, doneBtn);
		doneBtn.click();		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-embed-iframe")));
//		closeBtn.click();
		UtilHBM.waitTillElementDisappear(driver, confugratorApp);		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	

}
