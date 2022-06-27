package kitchen.threeDCloudByMe.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class LegalEntities {
	WebDriver driver;

	public LegalEntities(WebDriver driver) {
		this.driver=driver;	
	}
	
	
	@FindBy(css="label[for='updateLegalEntity']")
	WebElement pageHeader1;
	
	@FindBy(css="label[for='brands']")
	WebElement pageHeader2;
	
	@FindBy(css="label[for='addLegalEntity']")
	WebElement pageHeader3;
	
	@FindBy(css="label[for='addBrand']")
	WebElement pageHeader4;
	
	
	public LegalEntities pageVerification()
	{
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Update an existing legal entity");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "Associated brand(s)");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "Add a new legal entity");
		Verification.VerifyEquals("Text not displayed", pageHeader4.getText(), "Add a new brand");
		return this;
	}
}
