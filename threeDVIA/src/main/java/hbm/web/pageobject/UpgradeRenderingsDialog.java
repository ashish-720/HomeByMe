package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class UpgradeRenderingsDialog {
	WebDriver driver;

	public UpgradeRenderingsDialog(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css="div.modal-inner > form > button")
	 WebElement UpgradeButton;
	
	@FindBy(css="body>.modal.current>div>.modal-header>h2")
    private WebElement upgradeScrnTitle;
    
    @FindBy(xpath="//body/div/div/div/h2[.='CONGRATULATIONS!']")
    private WebElement upgradeScrnTitle2;
    
    @FindBy(css="body>.modal.current>div>.modal-inner>p")
    private WebElement upgradeScrnText;
    
    @FindBy(css="body[class='no-scroll']>.modal.current>div>.modal-inner>figure>img")
    private WebElement upgradeScrnImg;
    
    @FindBy(css="body>.modal.current>div>.modal-inner>footer>p:nth-child(1)")
    private WebElement upgradeScrnFooterText1;   	
	
    @FindBy(css="body>.modal.current>div>.modal-inner>footer>p:nth-child(2)")
    private WebElement upgradeScrnFooterText2; 
	
	@FindBy(css="a.close-modal.button-close")
	private WebElement closePopup;
    
	public ProjectPage upgradeRenderings() {
		UtilHBM.waitExplicitDisplayed(driver, upgradeScrnImg);
		Verification.VerifyEquals("Wrong upgrade realistic dialog header", upgradeScrnTitle.getText(), "Upgrade your image in HD");
		Verification.VerifyEquals("Wrong upgrade realistic dialog header", upgradeScrnText.getText(), "Do you like your image? We'll generate a high quality version of it for you to show your creation to all your friends. They'll be impressed!");
		Verification.verifyText(upgradeScrnFooterText1,
				"As a subscriber, you can create as many realistic images as you need.", "Upgrade Screen Footer");
		UpgradeButton.click();
		UtilHBM.waitExplicitDisplayed(driver, upgradeScrnTitle2);
		Verification.verifyText(upgradeScrnTitle, "CONGRATULATIONS!", "Congratulations title");
		Verification.verifyText(upgradeScrnText, "We’ve successfully received your order.",
				"Upgrade image success Text");
		Verification.verifyText(upgradeScrnFooterText1, "Your realistic image is currently generating.",
				"Upgrade Success Footer1");
		Verification.verifyText(upgradeScrnFooterText2, "You will be notified as soon as it’s ready!",
				"Upgrade Success Footer2");
		UtilHBM.waitExplicitClickable(driver, closePopup);
		closePopup.click();
		UtilHBM.reportOK("Upgrade image request sent");
		return PageFactory.initElements(driver, ProjectPage.class);
	}
}
