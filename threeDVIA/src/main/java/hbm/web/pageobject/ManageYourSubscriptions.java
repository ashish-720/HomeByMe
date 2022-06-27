package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ManageYourSubscriptions {

	WebDriver driver;

	public ManageYourSubscriptions(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "html[class='js'] #vue-pricing>.pricing-subscriptions>.subscription-cards>div:nth-child(1)>footer")
	WebElement firstServiceActions;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>footer>.actions.flex.u-mtxs>.button--outline[title='More info']")
	WebElement moreInfoMonthlySubscribe;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>footer>.actions.flex.u-mtxs>.button--outline[title='More info']")
	WebElement moreInfoYearlySubscribe;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>.subscription>.flex.flex-middle>h3")
	WebElement monthlySubscribeTitle;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.flex.flex-middle>h3")
	WebElement yearlySubscribeTitle;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>.subscription>.flex.flex-middle>p>span.price")
	WebElement monthlySubscribePrice;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.flex.flex-middle>p>span.price")
	WebElement yearlySubscribePrice;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(1)>span[class=' u-mrxs']")
	WebElement monthlySubscribeBenefits1;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(2)")
	WebElement monthlySubscribeBenefits2;

	@FindBy(css = ".subscription-cards>div:nth-child(1)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(3)")
	WebElement monthlySubscribeBenefits3;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(1)>span[class=' u-mrxs']")
	WebElement yearlySubscribeBenefits1;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(2)")
	WebElement yearlySubscribeBenefits2;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(3)")
	WebElement yearlySubscribeBenefits3;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(4)")
	WebElement yearlySubscribeBenefits4;

	@FindBy(css = ".subscription-cards>div:nth-child(2)>.subscription>.list-subscription.list-reset.u-mbs>li:nth-child(5)")
	WebElement yearlySubscribeBenefits5;

	public ManageYourSubscriptions verifyActiveSubscription(String activeSubscription) {
		UtilHBM.waitExplicitDisplayed(driver, firstServiceActions);

		Actions action1 = new Actions(driver);
		action1.moveToElement(moreInfoYearlySubscribe).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, yearlySubscribePrice);
		Verification.VerifyEquals("monthlySubscribeTitle Not Displayed", monthlySubscribeTitle.getText(),
				"Pro monthly");
		Verification.VerifyEquals("yearlySubscribeTitle Not Displayed", yearlySubscribeTitle.getText(), "Pro yearly");
		Verification.displayOfWebElement(monthlySubscribePrice);
		Verification.displayOfWebElement(yearlySubscribePrice);
		Verification.VerifyEquals("monthlySubscribeBenefits1 not displayed", monthlySubscribeBenefits1.getText(),
				"Unlimited realistic images");
		Verification.VerifyEquals("monthlySubscribeBenefits2 not displayed", monthlySubscribeBenefits2.getText(),
				"Unlimited projects");
		Verification.VerifyEquals("monthlySubscribeBenefits3 not displayed", monthlySubscribeBenefits3.getText(),
				"PROFESSIONAL USAGE RIGHTS");
		Verification.VerifyEquals("yearlySubscribeBenefits1 not displayed", yearlySubscribeBenefits1.getText(),
				"Unlimited realistic images");
		Verification.VerifyEquals("yearlySubscribeBenefits2 not displayed", yearlySubscribeBenefits2.getText(),
				"Unlimited projects");
		Verification.VerifyEquals("yearlySubscribeBenefits3 not displayed", yearlySubscribeBenefits3.getText(),
				"PROFESSIONAL USAGE RIGHTS");
		Verification.VerifyEquals("yearlySubscribeBenefits4 not displayed", yearlySubscribeBenefits4.getText(),
				"10% off on à la carte services");
		Verification.VerifyEquals("yearlySubscribeBenefits5 not displayed", yearlySubscribeBenefits5.getText(),
				"2 months free");
		Verification.displayOfWebElement(moreInfoMonthlySubscribe);
		Verification.displayOfWebElement(moreInfoYearlySubscribe);

		if (activeSubscription.equalsIgnoreCase("Pro Monthly")) {
			WebElement monthlySubscribed = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(1)>footer>.actions.flex.u-mtxs>.button--outline.button--l.flex-center.flex-item-1.icon-content[title='Subscribed']");
			Verification.VerifyEquals("Incorrect text displayed for active subscrption!!", monthlySubscribed.getText(),
					"Subscribed");
		} else if (activeSubscription.equalsIgnoreCase("Pro Yearly")) {
			WebElement yearlySubscribed = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(2)>footer>.actions.flex.u-mtxs>.button--outline.button--l.flex-center.flex-item-1.icon-content[title='Subscribed']");
			Verification.VerifyEquals("Incorrect text displayed for active subscrption!!", yearlySubscribed.getText(),
					"Subscribed");
		}
		return this;
	}

	public SubscriptionUpdatesDialog clickNonActiveSubscribe(String activeSubscription) {
		if (activeSubscription.equalsIgnoreCase("Pro Monthly")) {
			WebElement monthlySubscribed = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(1)>footer>.actions.flex.u-mtxs>.button--outline.button--l.flex-center.flex-item-1.icon-content[title='Subscribed']");
			Verification.VerifyEquals("Incorrect text displayed for active subscrption!!", monthlySubscribed.getText(),
					"Subscribed");
			WebElement yearlySubscription = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(2)>footer>.actions.flex.u-mtxs>.js-open-ajax-modal.button.button--l.flex-item-1[title='Subscribe']");
			yearlySubscription.click();
		} else if (activeSubscription.equalsIgnoreCase("Pro Yearly")) {
			WebElement yearlySubscribed = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(2)>footer>.actions.flex.u-mtxs>.button--outline.button--l.flex-center.flex-item-1.icon-content[title='Subscribed']");
			Verification.VerifyEquals("Incorrect text displayed for active subscrption!!", yearlySubscribed.getText(),
					"Subscribed");
			WebElement monthlySubscription = UtilHBM.webElement(driver,
					".subscription-cards>div:nth-child(1)>footer>.actions.flex.u-mtxs>.js-open-ajax-modal.button.button--l.flex-item-1[title='Subscribe']");
			monthlySubscription.click();
		}
		return PageFactory.initElements(driver, SubscriptionUpdatesDialog.class);
	}

	public MyAccount navigateBack() {
		driver.navigate().back();
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
}
