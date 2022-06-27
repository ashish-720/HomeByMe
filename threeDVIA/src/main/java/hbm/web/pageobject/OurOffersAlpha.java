package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class OurOffersAlpha {
	WebDriver driver;

	public OurOffersAlpha(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.page.page--pricing>div>div.hero-subscriptions__content>div>h1")
	WebElement ourOfferHeaderText;

	@FindBy(css = "div.page.page--pricing>div>div.hero-subscriptions__content>div>div>p")
	WebElement ourOfferInformationText;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__main>h2")
	WebElement starterPlanHeader;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__main>div.pricing-plan__baseline")
	WebElement starterPlanText;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__main>div.pricing-plan__price>p>strong")
	WebElement priceText;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__main>div.pricing-plan__details>p")
	WebElement starterPackDisclaimer;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__features>ul>li:nth-child(1)>p")
	WebElement starterFeature1;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__features>ul>li:nth-child(2)>p")
	WebElement starterFeature2;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(1)>div.pricing-plan__features>ul>li:nth-child(3)>p")
	WebElement starterFeature3;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__main>h2")
	List<WebElement> oneTimePackHeader;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__main>div.pricing-plan__baseline")
	WebElement oneTimePackText;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__main>div.pricing-plan__price>p>strong")
	WebElement oneTimePackPrice;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__features>ul>li:nth-child(1)>p")
	WebElement additionalItem1;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__features>ul>li:nth-child(2)>p")
	WebElement additionalItem2;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__features>ul>li:nth-child(3)>p")
	WebElement additionalItem3;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(2)>div.pricing-plan__main>a[href='https://home.by.me/en/services/one-time-pack/buy']")
	WebElement buyOneTimePack;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__main>h2")
	WebElement unlimitedHeader;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__main>div.pricing-plan__baseline")
	WebElement unlimitedText;

	@FindBy(css = "#vue-pricing>.pricing-3-cols>.card-pricing.unlimited-plan>.top-card>.offer>.disclaimer")
	WebElement disclaimerText;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__features>ul>li:nth-child(1)>p")
	WebElement subscriptionBenefits1;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__features>ul>li:nth-child(2)>p")
	WebElement subscriptionBenefits2;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__features>ul>li:nth-child(3)>p")
	WebElement subscriptionBenefits3;

	@FindBy(css = "div.hero-subscriptions__pricings.row>div>div:nth-child(3)>div.pricing-plan__features>ul>li:nth-child(4)>p")
	WebElement subscriptionBenefits4;

	@FindBy(css = "section.pricing-helping-hand-services>h2")
	WebElement servicesHeader;

	public OurOffersAlpha verifyPage(boolean isUserLoggedIn, String subscriptionStatus) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] div.page.page--pricing"));
		UtilHBM.turnOffImplicitWaits(driver);
		Verification.VerifyEquals("Our offers HeaderText not displayed", ourOfferHeaderText.getText(), "Our offers");
		Verification.VerifyEquals("Our offers InformationText not displayed", ourOfferInformationText.getText(),
				"To ensure we meet your needs and for optimal use of HomeByMe, a plan tailor-made for you.");

		Verification.VerifyEquals("Starter plan header not displayed", starterPlanHeader.getText(), "Starter plan");
		Verification.VerifyEquals("Starter plan text not displayed", starterPlanText.getText(),
				"All you need to design your ideas easily");
		Verification.VerifyEquals("Price text not displayed", priceText.getText(), "Free");
		Verification.VerifyEquals("starterPackDisclaimer text not displayed", starterPackDisclaimer.getText(),
				"no credit card required");
		Verification.VerifyEquals("starterFeature1 not displayed", starterFeature1.getText(), "3 projects");
		Verification.VerifyEquals("starterFeature2 not displayed", starterFeature2.getText(), "3 realistic renderings");
		Verification.VerifyEquals("starterFeature3 not displayed", starterFeature3.getText(), "1 panoramic 360° image");

		Verification.VerifyEquals("oneTimePackHeader Text not displayed", oneTimePackHeader.get(0).getText(),
				"One-time Pack");
		Verification.VerifyEquals("oneTimePackText not displayed", oneTimePackText.getText(),
				"Get more projects and images to optimize your HomeByMe experience");
		Verification.VerifyEquals("Additional item 1 not displayed", additionalItem1.getText(), "5 projects");
		Verification.VerifyEquals("Additional item 2 not displayed", additionalItem2.getText(), "15 realistic images");
		Verification.VerifyEquals("Additional item 3 not displayed", additionalItem3.getText(), "3 360° images");
		Verification.VerifyEquals("Price text not displayed", oneTimePackPrice.getText(), "€14.99");
		Verification.VerifyEquals("Price text not displayed", buyOneTimePack.getText(), "buy");

//		unlimited tab pricing verification not done
		return this;
	}
}
