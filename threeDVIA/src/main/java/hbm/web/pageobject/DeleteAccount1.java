package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class DeleteAccount1 {
	
WebDriver driver;
	
	public DeleteAccount1(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="div.modal-header>h2")
	private WebElement deleteYourAccountHeader;
	
	@FindBy(xpath="//input[@id='any_value']/following-sibling::label")
	private WebElement deleteReason;
	
	@FindBy(css="div.form-item>ul>li>label")
	private List<WebElement> deleteReasonList;
	
	@FindBy(css="div.form-item>p")
	private WebElement feedbackText;
	
	@FindBy(css="a.button--alt.u-mrxs")
	private WebElement cancelButton;
	
	@FindBy(css="#gdpr>div.modal-inner>div>div.popinForm-actions.u-mtn>a[class='button']")
	private WebElement deleteContinue;
	
	@FindBy(css="#gdpr>div.modal-inner>div>div.form-item>textarea")
	private WebElement deleteComment;

	public DeleteAccount2 deleteAccount1() {
		UtilHBM.waitExplicitClickable(driver, deleteContinue);
		Verification.VerifyEquals("deleteYourAccountHeader not displayed", deleteYourAccountHeader.getText(), "Delete your account");
		int i=1;
		for(WebElement a:deleteReasonList) {
			if(a.isDisplayed())
				UtilHBM.reportOK("Option "+i+" Displayed");
			else
				UtilHBM.reportKO("Option "+i+" not Displayed");
		i++;
		}
		
		if(i==6)
			UtilHBM.reportOK("All Options Displayed");
		else
			UtilHBM.reportKO("All Options not Displayed");
		
		deleteReason.click();
		Verification.VerifyEquals("FeedbackText not displayed", feedbackText.getText(), "Your feedback matters. Is there anything else you would like us to know?");
		deleteComment.sendKeys("Delete comment is here!!!");
		cancelButton.isDisplayed();
		deleteContinue.click();
		return PageFactory.initElements(driver, DeleteAccount2.class);
	}
	
}
