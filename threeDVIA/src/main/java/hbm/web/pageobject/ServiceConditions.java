package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ServiceConditions {

private WebDriver driver;
	
	public ServiceConditions (WebDriver driver){
		this.driver = driver;
	}	

	@FindBy(css="div.modal-header>h2")
	WebElement additionalTermsHeader;
	
	@FindBy(css="div.form-item>label.required")
	WebElement readAndAcceptTermsCheckBox;
	
	@FindBy(css="div>button.button")
	WebElement continuePayment;
	
	public Payment acceptServiceConditionsAndCloseTab() {	
		String handle=driver.getWindowHandle();
		for(String handle1:driver.getWindowHandles()) {
			if(!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);	
				
			}			
		}
		UtilHBM.waitExplicitClickable(driver, continuePayment);		
		Verification.VerifyEquals("additionalTermsHeader incorrect", additionalTermsHeader.getText(), "Additional Terms");
		Verification.VerifyEquals("readAndAcceptTermsText incorrect", readAndAcceptTermsCheckBox.getText(), "I have read and I accept the additional terms 3DS Website");
		readAndAcceptTermsCheckBox.click();
		
		continuePayment.click();
		UtilHBM.waitFixTime(2000);
		Payment pay = PageFactory.initElements(driver, Payment.class);
		pay.verifyPaymentPage();
		driver.close();
		driver.switchTo().window(handle);
		driver.navigate().refresh();
		return PageFactory.initElements(driver, Payment.class);
	}
	
	public Payment acceptServiceConditions() {
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		UtilHBM.waitExplicitClickable(driver, continuePayment);
		Verification.VerifyEquals("additionalTermsHeader incorrect", additionalTermsHeader.getText(),
				"Additional Terms");
		Verification.VerifyEquals("readAndAcceptTermsText incorrect", readAndAcceptTermsCheckBox.getText(),
				"I have read and I accept the additional terms 3DS Website");
		readAndAcceptTermsCheckBox.click();
		continuePayment.click();
		UtilHBM.waitFixTime(2000);
		Payment pay = PageFactory.initElements(driver, Payment.class);
		pay.verifyPaymentPage();
		driver.navigate().refresh();
		return PageFactory.initElements(driver, Payment.class);
	}
	
}