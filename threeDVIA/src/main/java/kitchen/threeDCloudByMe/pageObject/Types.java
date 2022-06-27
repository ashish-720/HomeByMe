package kitchen.threeDCloudByMe.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class Types {
	WebDriver driver;

	public Types(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="a[href='/en/admin/types']>label.tabs-item-label")
	WebElement pageHeader1;
	
	@FindBy(css="div>div[data-step='attributes']>label")
	WebElement pageHeader2;	
	
	@FindBy(css="div>div[data-step='notlisted']>label")
	WebElement pageHeader3;
	
	public Types pageVerification()
	{
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Manage your types");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "Attributes");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "Types not listed");
		return this;
	}
}
