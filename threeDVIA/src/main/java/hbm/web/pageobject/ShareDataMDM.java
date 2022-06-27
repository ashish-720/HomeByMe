package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ShareDataMDM {

	WebDriver driver;
	public ShareDataMDM(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(css = "div.wrapper>section>h2")
	WebElement yourPersonalisedOffer;

	@FindBy(css = "section.form-container>div>p")
	WebElement shareYourInformationText;

	@FindBy(css = "a[title='No, thank you']")
	WebElement noThankYouButton;

	@FindBy(css = "a[title='Yes, I accept']")
	WebElement yesIAcceptButton;

	public UserHomePage acceptShareDataOffer() {
		UtilHBM.waitExplicitDisplayed(driver, noThankYouButton);
		UtilHBM.waitExplicitClickable(driver, noThankYouButton);
		Verification.VerifyEquals("Wrong Your personalised offer Header", yourPersonalisedOffer.getText(),
				"Your personalised offer");
		Verification.VerifyEquals("Wrong shareYourInformationText Text", shareYourInformationText.getText(),
				"Share your contact/project information with Gautier to receive special offers related to products you have in your projects.");
		Verification.displayOfWebElement(noThankYouButton);
		Verification.displayOfWebElement(yesIAcceptButton);
		yesIAcceptButton.click();
		UtilHBM.reportInfo("Yes I Accept Button clicked !!");
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public UserHomePage rejectShareDataOffer() {
		UtilHBM.waitExplicitDisplayed(driver, yourPersonalisedOffer);
		Verification.VerifyEquals("Wrong Your personalised offer Header", yourPersonalisedOffer.getText(),
				"Your personalised offer");
		Verification.VerifyEquals("Wrong shareYourInformationText Text", shareYourInformationText.getText(),
				"Share your contact/project information with Maisons Du Monde to receive special offers related to products you have in your projects.");
		Verification.displayOfWebElement(noThankYouButton);
		Verification.displayOfWebElement(yesIAcceptButton);
		noThankYouButton.click();
		UtilHBM.reportInfo("No Thank You Button clicked !!");
		return PageFactory.initElements(driver, UserHomePage.class);
	}

}
