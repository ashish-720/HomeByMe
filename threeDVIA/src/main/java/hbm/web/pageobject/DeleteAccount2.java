package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccount2 {
	
WebDriver driver;
	
	public DeleteAccount2(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(xpath="//input[@id='accept']/following-sibling::label")
	private WebElement deleteReadAndAcceptCheckbox;
	
	@FindBy(css="div.modal-inner>div>p>strong")
	private WebElement deleteActionIsNotIrreversible;
	
	@FindBy(css="#gdpr>div.modal-inner>div>div.form-item>div>input")
	private WebElement deletePassword;
	
	@FindBy(xpath="//div[@id='gdpr']/div/div/div[@class='popinForm-actions u-mtn']/a[.='Continue']")
	private WebElement deleteContinue;
	
	public LandingPage deleteAccount2(SignUpData signUpData, String hbmOrSocial) {
		UtilHBM.waitExplicitDisplayed(driver, deleteReadAndAcceptCheckbox);
		Verification.VerifyEquals("deleteActionIsIrreversible text not available", deleteActionIsNotIrreversible.getText(), "this action is irreversible");
		Verification.VerifyEquals("deleteReadAndAcceptCheckbox",deleteReadAndAcceptCheckbox.getText(),"* I have read and accept that my account will be erased and there will be no way to restore it.");		
		deleteReadAndAcceptCheckbox.click();
		deleteContinue.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, LandingPage.class);
	}	

}
