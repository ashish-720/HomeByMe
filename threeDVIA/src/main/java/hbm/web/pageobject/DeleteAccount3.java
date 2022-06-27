package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class DeleteAccount3 {
	
WebDriver driver;
	
	public DeleteAccount3(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="div.modal-inner>div>p")
	private WebElement accountDeletedText;
	
	@FindBy(xpath="//div[@class='modal-inner']/div/div/a[.='Back to homepage']")
	private WebElement backToHomepage;
	
	@FindBy(css="#gdpr>div.modal-inner>div>div.popinForm-actions.u-mtn>a[class='button']")
	private WebElement deleteContinue;

	public LandingPage deleteAccount3() {
		UtilHBM.waitExplicitDisplayed(driver, backToHomepage);
		Verification.VerifyEquals("accountDeletedText is not correct",accountDeletedText.getText(),"Your account has been deleted. To be redirected to the home page, please click on the button below.");
		backToHomepage.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
