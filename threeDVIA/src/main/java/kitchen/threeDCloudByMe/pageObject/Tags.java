package kitchen.threeDCloudByMe.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class Tags {
	WebDriver driver;

	public Tags(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="label[for='tag']")
	WebElement pageHeader1;
	
	@FindBy(css=".col-xs-1.u-plm.u-mts>p")
	WebElement pageHeader2;
	
	@FindBy(css="label[for='addTag']")
	WebElement pageHeader3;
	
	@FindBy(css="div.col-xs-2.form-group.u-mtxs>span")
	WebElement pageHeader4;
	
	@FindBy(css="label[for='typeTag']")
	WebElement pageHeader5;
	
	@FindBy(css="#tagForm>div>div:nth-child(2)>div>div>span")
	WebElement pageHeader6;
	
	@FindBy(css="div>label[for='trad']")
	WebElement pageHeader7;
	
	@FindBy(css="#tagForm>div>div:nth-child(4)>div>div:nth-child(2)>span")
	WebElement pageHeader8;
	
	@FindBy(css="#tagForm>div>div:nth-child(4)>div>div:nth-child(3)>span")
	WebElement pageHeader9;
	
	@FindBy(css="#tagForm>div>div:nth-child(4)>div>div:nth-child(4)>span")
	WebElement pageHeader10;
	
	@FindBy(css="#tagForm>div>div:nth-child(4)>div>div:nth-child(5)>span")
	WebElement pageHeader11;
	
	@FindBy(css="#tagForm>div>div:nth-child(4)>div>div.col-xs-12>span")
	WebElement pageHeader12;
	
	@FindBy(css="#validate-tag-button")
	WebElement validateButtonText;
	
	public Tags pageVerification()
	{		
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Update existing tag");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "or");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "Add a new tag");
		Verification.VerifyEquals("Text not displayed", pageHeader4.getText(),"Check this and fill tag information to add a new tag");
		Verification.VerifyEquals("Text not displayed", pageHeader5.getText(), "Tag type");
		Verification.VerifyEquals("Text not displayed", pageHeader6.getText(), "Nature of the tag");
		Verification.VerifyEquals("Text not displayed", pageHeader7.getText(), "Translation");
		Verification.VerifyEquals("Text not displayed", pageHeader8.getText(), "FR");
		Verification.VerifyEquals("Text not displayed", pageHeader9.getText(), "EN");
		Verification.VerifyEquals("Text not displayed", pageHeader10.getText(), "ES");
		Verification.VerifyEquals("Text not displayed", pageHeader11.getText(), "DE");
		Verification.VerifyEquals("Text not displayed", pageHeader12.getText(), "Translate the selected or the new tag");
		Verification.VerifyEquals("Text not displayed", validateButtonText.getText(), "VALIDATE");
		return this;
	}
	
}
