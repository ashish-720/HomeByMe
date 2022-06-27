package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class SubscriptionUpdatesDialog {

	WebDriver driver;

	public SubscriptionUpdatesDialog(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".modal-wrapper.modal-light.-thin>.modal-header.full>.modal-title.thin")
	private WebElement subscriptionUpdatesTitle;

	@FindBy(css = ".modal-inner>.u-mbs")
	private WebElement subscriptionUpdatesText1;

	@FindBy(css = ".modal-inner>.u-mbs>strong:nth-child(1)")
	private WebElement subscriptionType;

	@FindBy(css = ".modal-inner>.u-mbs>strong:nth-child(2)")
	private WebElement subscriptionRenewDate;

	@FindBy(css = ".modal-inner>.u-mtn.u-mbn")
	private WebElement subscriptionUpdatesText2;

	@FindBy(css = ".modal-inner>.u-mtn.u-mbn>strong")
	private WebElement subscriptionUpdatesText2Bold;

	@FindBy(css = ".modal-buttons.flex>.button--alt")
	private WebElement cancelButton;

	@FindBy(css = ".modal-buttons.flex>.button")
	private WebElement validateButton;
	
	@FindBy(css = "div.modal-inner.u-pbn>p")
	private WebElement cancelUnsubscribeText;
	
	@FindBy(css = "div.modal-wrapper.modal-light.-thin>div>a.button--alt")
	private WebElement cancelUnsubscribeNo;
	
	@FindBy(css = "div.modal-wrapper.modal-light.-thin>div>a.button")
	private WebElement cancelUnsubscribeYes;

	public SubscriptionUpdatesDialog verifySubscriptionUpdates(String activeSubscription, String renewDate) {
		UtilHBM.waitExplicitDisplayed(driver, subscriptionUpdatesTitle);
		Verification.VerifyEquals("Wrong subscriptionUpdatesTitle", subscriptionUpdatesTitle.getText(),
				"Subscription updates");
		if (activeSubscription.equals("Pro monthly")) {
			Verification.elementContainsString(subscriptionUpdatesText1, "Your new subscription",
					"subscriptionUpdatesText1");
			Verification.elementContainsString(subscriptionUpdatesText1, "will start after your validation.",
					"subscriptionUpdatesText1");
			Verification.VerifyEquals("Wrong subscriptionType!!", subscriptionType.getText(), "Pro yearly");
			Verification.VerifyEquals("Wrong subscriptionUpdatesText2", subscriptionUpdatesText2.getText(),
					"You will be charged in proportion to the cost of your current subscription.");

		} else if (activeSubscription.equals("Pro yearly")) {
			Verification.elementContainsString(subscriptionUpdatesText1, "Your new subscription",
					"subscriptionUpdatesText1");
			Verification.VerifyEquals("Wrong subscriptionType!!", subscriptionType.getText(), "Pro monthly");
			Verification.elementContainsString(subscriptionUpdatesText1, " will start on", "subscriptionUpdatesText1");
			Verification.VerifyEquals("Wrong subscriptionUpdatesText1 renew date", subscriptionRenewDate.getText(),
					renewDate);
			Verification.elementContainsString(subscriptionUpdatesText2,
					"On this date, you will no longer be able to use the features associated with your plan",
					"subscriptionUpdatesText2");
			Verification.VerifyEquals("Wrong subscriptionUpdatesText2 active subscription",
					subscriptionUpdatesText2Bold.getText(), activeSubscription);
		} else {
			UtilHBM.reportInfo("Wrong active subscription input!!");
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		Verification.displayOfWebElement(validateButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		Verification.displayOfWebElement(cancelButton);
		return this;

	}

	public SubscriptionUpdatesDialog verifyCancelYourSubscription(String activeSubscription, String renewDate) {
		UtilHBM.waitExplicitDisplayed(driver, subscriptionUpdatesTitle);
		Verification.VerifyEquals("Wrong subscriptionUpdatesTitle", subscriptionUpdatesTitle.getText(),
				"Cancel your subscription");
		if (activeSubscription.equals("Pro monthly")) {
			Verification.elementContainsString(subscriptionUpdatesText1, "Do you really want to end your subscription",
					"subscriptionUpdatesText1");
			Verification.VerifyEquals("Wrong active subscription!!", subscriptionType.getText(), activeSubscription);
			Verification.elementContainsString(subscriptionUpdatesText2,
					"If you want to, your subscription will end on", "subscriptionUpdatesText2");
			Verification.VerifyEquals("Wrong subscriptionUpdatesText2 active subscription",
					subscriptionUpdatesText2Bold.getText(), renewDate);

		} else if (activeSubscription.equals("Pro yearly")) {
			Verification.elementContainsString(subscriptionUpdatesText1, "Do you really want to end your subscription",
					"subscriptionUpdatesText1");
			Verification.VerifyEquals("Wrong active subscription!!", subscriptionType.getText(), activeSubscription);
			Verification.elementContainsString(subscriptionUpdatesText2,
					"If you want to, your subscription will end on", "subscriptionUpdatesText2");
			Verification.VerifyEquals("Wrong subscriptionUpdatesText2 active subscription",
					subscriptionUpdatesText2Bold.getText(), renewDate);
		} else {
			UtilHBM.reportInfo("Wrong active subscription input!!");
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		Verification.displayOfWebElement(validateButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		Verification.displayOfWebElement(cancelButton);
		return this;
	}
	
	public SubscriptionUpdatesDialog verifyCancelUnsubscribeDialog() {
		UtilHBM.waitExplicitDisplayed(driver, cancelUnsubscribeText);
		Verification.VerifyEquals("Wrong cancelUnsubscribeText", cancelUnsubscribeText.getText(), "Are you sure you want to revoke your subscription cancellation?");
		Verification.displayOfWebElement(cancelUnsubscribeNo);
		Verification.displayOfWebElement(cancelUnsubscribeYes);
		return this;
	}
	
	public MyAccount cancelUnsubscribeYes() {
		UtilHBM.waitExplicitClickable(driver, cancelUnsubscribeYes);
		cancelUnsubscribeYes.click();
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public MyAccount clickValidateButton() {
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public ManageYourSubscriptions clickCancelButton() {
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		return PageFactory.initElements(driver, ManageYourSubscriptions.class);
	}

}
