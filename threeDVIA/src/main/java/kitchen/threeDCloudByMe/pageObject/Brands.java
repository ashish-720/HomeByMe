package kitchen.threeDCloudByMe.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class Brands {
	WebDriver driver;

	public Brands(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="label[for='updateBrand']")
	WebElement pageHeader1;
	
	@FindBy(css="label[for='brandLegalEntity']")
	WebElement pageHeader2;
	
	@FindBy(css="label[for='brandName']")
	WebElement pageHeader3;
	
	@FindBy(css="#upload-logo>span")
	WebElement uploadBrandLogoButtonText;
	
	@FindBy(css="#validate-brand-button>span")
	WebElement validateButtonText;
	
	public Brands pageVerification()
	{
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Update an existing brand");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "Associated legal entity");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "Brand name");
		Verification.VerifyEquals("Text not displayed", uploadBrandLogoButtonText.getText(), "UPLOAD BRAND LOGO");
		Verification.VerifyEquals("Text not displayed", validateButtonText.getText(), "VALIDATE");
		return this;
	}
	
}
