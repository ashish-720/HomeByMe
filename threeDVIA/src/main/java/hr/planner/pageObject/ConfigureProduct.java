package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigureProduct {
	
	WebDriver driver;

	public ConfigureProduct(WebDriver driver) {
		this.driver = driver;
	}	
	@FindBy(css=".mod-layer.mod-open>div>header>.wrap>.text>.title")
	private WebElement configureTitle;
	
	@FindBy(css=".title+.info")
	private WebElement configureTitleInfo;
	
	@FindBy(css = ".done-button")
	private WebElement configureDoneButton;
	
	@FindBy(css=".loader-screen.active")
	private WebElement loaderScreen;
	
	@FindBy(css="#errorText")
	private WebElement errorText;
	
	@FindBy(css=".content>header>.wrap>div>button>span.icon-view-close[aria-hidden='true']")
	private WebElement closeBtn;
	
	
	public ConfigureProduct verifyConfigurator() {		
		UtilHBM.waitExplicitDisplayed(driver, loaderScreen);
//		UtilHBM.waitExplicitDisplayed(driver, errorText);
//		Verification.verifyText(errorText, "Your browser is not compatible with the 3D viewer.", "Error msg in configurator");		
		return PageFactory.initElements(driver, ConfigureProduct.class);
	}
	
	@FindBy(xpath =  "//span[@data-ui-selector='notification-text']" )
	private WebElement issueText;
	
	public HomePlanner closeConfigurator(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		Verification.displayNAttributeCheckOfElement(configureTitle, "Configurator Title", "text", "Your Configuration");
		Verification.displayNAttributeCheckOfElement(configureTitleInfo, "Configurator Title info", "text", "Design your product");
		closeBtn.click();
			
		if(driver.equals(issueText)){
		Verification.displayNAttributeCheckOfElement(issueText, "error msg", "text", "We're sorry but we've encountered an issue to configure this product.");	
			UtilHBM.reportKO("error msg appear");
			
		}else{
			UtilHBM.reportOK("error msg does not appear");
		}
		
		return PageFactory.initElements(driver, HomePlanner.class);
	}	
}
