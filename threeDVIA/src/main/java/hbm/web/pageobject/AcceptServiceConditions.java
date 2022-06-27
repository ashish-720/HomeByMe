package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class AcceptServiceConditions {

private WebDriver driver;
	
	public AcceptServiceConditions (WebDriver driver){
		this.driver = driver;
	}	

	@FindBy(css="div.modal-header>h2")
	WebElement additionalTermsHeader;
	
	@FindBy(css="div.form-item>label.required")
	WebElement readAndAcceptTermsCheckBox;
	
	@FindBy(css="div>button.button")
	WebElement continuePayment;
	
	public Payment acceptServiceConditions() {
		Verification.VerifyEquals("additionalTermsHeader incorrect", additionalTermsHeader.getText(), "Additional Terms");
		Verification.VerifyEquals("readAndAcceptTermsText incorrect", readAndAcceptTermsCheckBox.getText(), "I have read and I accept the additional terms 3DS Website");
		readAndAcceptTermsCheckBox.click();
		UtilHBM.waitExplicitClickable(driver, continuePayment);
		continuePayment.click();
		return PageFactory.initElements(driver, Payment.class);
	}
	
}