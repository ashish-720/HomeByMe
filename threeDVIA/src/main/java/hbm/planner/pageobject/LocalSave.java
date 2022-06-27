package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocalSave {
	
	WebDriver driver;
	
	public LocalSave(WebDriver driver){
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(css="div>div>.modal-title")
	private WebElement msgTitle;
	
	@CacheLookup
	@FindBy(css="div>div>form>.modal-inner")
	private WebElement msgText;
	
	@CacheLookup
	@FindBy(css="div>div>form>.modal-footer>#openOnlineVersion")
	private WebElement noThanksButton;
	
	@CacheLookup
	@FindBy(css="div>div>form>.modal-footer>#openLocalVersion")
	private WebElement yesButton;
	
	public ThreeDPlanner openLocalVersion(String yesOrNo){	
		driver.navigate().refresh();
		try {  
			   Alert alt = driver.switchTo().alert();
			   alt.accept();
			} catch(NoAlertPresentException noe) {
			   // no alert.
				noe.printStackTrace();
			}	
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestLocalSavedProject();
		if(yesOrNo.equalsIgnoreCase("yes")){
			yesButton.click();
		}else{
			noThanksButton.click();
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));				
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
}
