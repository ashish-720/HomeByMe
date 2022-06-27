package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class OurOffers {
	WebDriver driver;

	public OurOffers(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(css = "div.hero-subscriptions__text.cell-6.prepend-3>h1")
	WebElement ourOfferHeaderText;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div/h2")
	WebElement starterPlanHeader;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div/div[@class='pricing-plan__baseline']")
	WebElement starterPlanText1;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div/div/div/p")
	WebElement starterPlanText2;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div/a[contains(text(),'Try it now')]")
	WebElement starterPlanButton;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div/div[@class='pricing-plan__details']")
	WebElement starterPlanText3;

	@FindBy(id = "services-tabs-head")
	WebElement serviceTab;
	
	@FindBy(id = "packs-tabs-head")
	WebElement packsTab;
	
	@FindBy(id = "plans-tabs-head")
	WebElement plansTab;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[1]/div[@class='pricing-plan__features']/ul/li[1]/p")
	WebElement starterFeature1;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[1]/div[@class='pricing-plan__features']/ul/li[2]/p")
	WebElement starterFeature2;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[1]/div[@class='pricing-plan__features']/ul/li[3]/p")
	WebElement starterFeature3;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[1]/div[@class='pricing-plan__features']/ul/li[4]/p")
	WebElement starterFeature4;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[1]/div[@class='pricing-plan__features']/ul/li[5]/p")
	WebElement starterFeature5;



	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div/div/div/p[@class='pricing-plan__price__default']/strong[@data-fsid='pro-monthly']")
	WebElement premiumMonthlyPrice;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row']/div/div[2]/div/a[@data-tag-label='buy_premium_plan_monthly']")
	WebElement premiumMonthlySubscribe;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row is-yearly']/div/div[2]/div/div/div/p[@class='pricing-plan__price__yearly']/strong[@data-fsid='pro-yearly']")
	WebElement premiumYearlyPrice;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row is-yearly']/div/div[2]/div/a[@data-tag-label='buy_premium_plan_yearly']")
	WebElement premiumYearlySubscribe;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div/h2")
	WebElement premiumHeader;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div/div[@class='pricing-plan__baseline']")
	WebElement premiumBaseline;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div/div[@class='pricing-plan__details']")
	WebElement premiumText1;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/p")
	WebElement premiumFeatureText;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[1]/p")
	WebElement premiumFeature1;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[2]/p")
	WebElement premiumFeature2;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[3]/p")
	WebElement premiumFeature3;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[4]/p")
	WebElement premiumFeature4;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[5]/p")
	WebElement premiumFeature5;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[6]/p")
	WebElement premiumFeature6;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div[@class='pricing-plan__features']/ul/li[7]/p")
	WebElement premiumFeature7;
	
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row']/div/div[3]/div/a[@data-tag-label='buy_unlimited_plan_monthly']")
	WebElement unlimitedMonthlySubscribe;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row is-yearly']/div/div[2]/div/a[@data-tag-label='buy_unlimited_plan_yearly']")
	WebElement unlimitedYearlySubscribe;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[2]/div/div/div/p[@class='pricing-plan__price__default']/strong[@data-fsid='pro-monthly']")
	WebElement unlimitedMonthlyPrice;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row is-yearly']/div/div[2]/div/div/div/p[@class='pricing-plan__price__yearly']/strong[@data-fsid='pro-yearly']")
	WebElement unlimitedYearlyPrice;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div/h2")
	WebElement unlimitedHeader;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div/div[@class='pricing-plan__baseline']")
	WebElement unlimitedBaseline;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/p")
	WebElement unlimitedFeatureText;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[1]/p")
	WebElement unlimitedFeature1;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[2]/p")
	WebElement unlimitedFeature2;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[3]/p")
	WebElement unlimitedFeature3;
	
	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[4]/p")
	WebElement unlimitedFeature4;
	
	
	@FindBy(xpath = "//div[@class='reassurance__title']")
	WebElement brandHeader;
	
	@FindBy(xpath = "//div[@class='reassurance__logos']/img")
	List<WebElement> brandList;


	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div/div[@class='pricing-plan__baseline']")
	WebElement unlimitedText;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row']/div/div/button[@class='switchbox__box']")
	List<WebElement> activeMonthlyToggle;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div[@class='hero-subscriptions__pricings row is-yearly']/div/div/button[@class='switchbox__box']")
	List<WebElement> activeYearlyToggle;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div/button[@class='switchbox__box']")
	WebElement labelSwitch;

//	@FindBy(xpath = "//div[@class='pricing-plan__switcher']/div[@class='switchbox']/div/span")
//	WebElement freeMonthsFigcaption;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4']/div/div[@class='pricing-plan__price']/p[@class='pricing-plan__price__default']/strong")
	WebElement monthlySubscriptionPrice;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4']/div/span[@class='pricing-plan__subprice']/span[1]")
	WebElement monthlySubscriptionPriceText;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4 is-yearly']/div/div[@class='pricing-plan__price']/p[@class='pricing-plan__price__yearly']/strong")
	WebElement yearlySubscriptionPrice;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4 is-yearly']/div/span[@class='pricing-plan__subprice']/span[2]")
	WebElement yearlySubscriptionPriceText;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div/div[@class='pricing-plan__details'][1]/p")
	WebElement monthlyDisclaimerText;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div/div[@class='pricing-plan__details'][2]/p")
	WebElement yearlyDisclaimerText;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4']/div/a[@data-tag-label='buy_subscription_month']")
	WebElement subscribeButtonMonthly;

	@FindBy(xpath = "//div[@class='pricing-plan is-recommended cell-4 is-yearly']/div/a[@data-tag-label='buy_subscription_year']")
	WebElement subscribeButtonYearly;


	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[1]/p")
	WebElement subscriptionBenefits1;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[2]/p")
	WebElement subscriptionBenefits2;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[3]/p")
	WebElement subscriptionBenefits3;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']//div[contains(@class,'hero-subscriptions__pricings__plan')]/div[3]/div[@class='pricing-plan__features']/ul/li[4]/p")
	WebElement subscriptionBenefits4;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__header']/div/div/h3")
	WebElement featureHeader1;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__header']/div/div/div[@class='list-check__text']")
	WebElement featureHeader2;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[1]/p")
	WebElement feature1;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[2]/p")
	WebElement feature2;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[3]/p")
	WebElement feature3;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[4]/p")
	WebElement feature4;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[5]/p")
	WebElement feature5;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[6]/p")
	WebElement feature6;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[7]/p")
	WebElement feature7;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[8]/p")
	WebElement feature8;

	@FindBy(xpath = "//section[@class='panel panel--default list-check']/div[@class='list-check__container row']/ul/li[9]/p")
	WebElement feature9;

	@FindBy(xpath = "//section[@class='panel panel--default title-offer']/div[@class='title-offer__header']/div/div/h3")
	WebElement servicesHeader;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[2]/div[@class='pricing-plan__main']/h2")
	WebElement idsHeader;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[2]/div[@class='pricing-plan__main']/div[@class='pricing-plan__baseline']")
	WebElement idsDesc;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[2]/div[@class='pricing-plan__features']/p")
	WebElement idsText;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[2]/div[@class='pricing-plan__main']/div[@class='pricing-plan__priceBox']/span/span")
	WebElement idsStratsAtText;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[2]/div[@class='pricing-plan__main']/div[@class='pricing-plan__priceBox']/div/div/strong")
	WebElement idsPrice;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[1]/div[@class='pricing-plan__features']/p")
	WebElement fpText;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[1]/div[@class='pricing-plan__main']/h2")
	WebElement floorplanHeader;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[1]/div[@class='pricing-plan__main']/div[@class='pricing-plan__baseline']")
	WebElement floorplanDesc;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[1]/div[@class='pricing-plan__main']/div[@class='pricing-plan__priceBox']/span/span")
	WebElement floorplanStratsAtText;

	@FindBy(xpath = "//div[@id='services-tabs-body']/div/div/div[1]/div[@class='pricing-plan__main']/div[@class='pricing-plan__priceBox']/div/div/strong")
	WebElement floorplanPrice;


	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__main']/h2")
	WebElement panoramicHeader;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__main']/div[@class='pricing-plan__baseline']")
	WebElement panoramicDesc;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__main']/a[text()='Buy']")
	WebElement panoramicBuy;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__footer']/a[@href='https://preprod-home.by.me/en/services/create-360-image/']")
	WebElement panoramicDiscover;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-2-1']/following-sibling::label/p[.='Pack of 1']/../..")
	WebElement panoramicPackOf1;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-2-2']/following-sibling::label/p[.='Pack of 2']/../..")
	WebElement panoramicPackOf2;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-2-3']/following-sibling::label/p[.='Pack of 10']/../..")
	WebElement panoramicPackOf10;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__main']/div/div/div[@class='pricing-plan__price__default']/div[not(@style = 'display: none;')]/strong")
	WebElement panoramicPrice;
	
	@FindBy(xpath = "//section[@class='panel panel--default title-offer'][3]/div/div/a/img")
	WebElement realisticImg;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__main']/h2")
	WebElement realisticHeader;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__main']/div[@class='pricing-plan__baseline']")
	WebElement realisticDesc;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__main']/a[text()='Buy']")
	WebElement realisticBuy;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__footer']/a[@href='https://preprod-home.by.me/en/services/get-additional-realistic-images/']")
	WebElement realisticDiscover;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-1-1']/following-sibling::label/p[.='Pack of 2']/../..")
	WebElement realisticPackOf2;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-1-2']/following-sibling::label/p[.='Pack of 10']/../..")
	WebElement realisticPackOf10;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-1-3']/following-sibling::label/p[.='Pack of 50']/../..")
	WebElement realisticPackOf50;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__main']/div/div/div[@class='pricing-plan__price__default']/div[not(@style = 'display: none;')]/strong")
	WebElement realisticPrice;
	
	@FindBy(xpath = "//section[@class='panel panel--default title-offer'][4]/div/div/a/img")
	WebElement projectImg;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__main']/h2")
	WebElement projectHeader;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__main']/div[@class='pricing-plan__baseline']")
	WebElement projectDesc;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__main']/a[text()='Buy']")
	WebElement projectBuy;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__footer']/a[@href='https://preprod-home.by.me/en/services/get-additional-projects/']")
	WebElement projectDiscover;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-3-1']/following-sibling::label/p[.='Pack of 2']/../..")
	WebElement projectPackOf2;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-3-2']/following-sibling::label/p[.='Pack of 10']/../..")
	WebElement projectPackOf10;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__features']/div/div[@class='radiobox']/input[@id='-addon-3-3']/following-sibling::label/p[.='Pack of 100']/../..")
	WebElement projectPackOf100;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[3]/div[@class='pricing-plan__main']/div/div/div[@class='pricing-plan__price__default']/div[not(@style = 'display: none;')]/strong")
	WebElement projectPrice;
	
	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div/div/div/h3[@class='accordion-tight__title']")
	WebElement faqTitle;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div/div/div/div[@class='accordion-tight__text']")
	WebElement faqText;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div/div/div/a[@href='https://homebyme.supporthero.io/']")
	WebElement helpCenter;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[1]")
	WebElement faq1;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[2]")
	WebElement faq2;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[3]")
	WebElement faq3;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[4]")
	WebElement faq4;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][1]/div[@class='accordion__heading']")
	WebElement faq1Q;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][2]/div[@class='accordion__heading']")
	WebElement faq2Q;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][3]/div[@class='accordion__heading']")
	WebElement faq3Q;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][4]/div[@class='accordion__heading']")
	WebElement faq4Q;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][1]/div[@class='accordion__panel']")
	WebElement faqAns1;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][2]/div[@class='accordion__panel']")
	WebElement faqAns2;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][3]/div[@class='accordion__panel']")
	WebElement faqAns3;

	@FindBy(xpath = "//section[@class='panel panel--default accordion-tight']/div[@class='accordion-tight__container row grid']/div/div/div[@class='accordion__item is-open'][4]/div[@class='accordion__panel']")
	WebElement faqAns4;

	@FindBy(css = "section.faq>ul>li:nth-child(1)>div.tab-content>span")
	WebElement faqAns1MoreInfo;

	@FindBy(css = "section.faq>ul>li:nth-child(2)>div.tab-content>span")
	WebElement faqAns2MoreInfo;

	@FindBy(css = "section.faq>ul>li:nth-child(3)>div.tab-content>span")
	WebElement faqAns3MoreInfo;

	@FindBy(css = "section.faq>ul>li:nth-child(4)>div.tab-content>span")
	WebElement faqAns4MoreInfo;

	@FindBy(css = ".header>.wrapper>.header-btnMenu")
	WebElement headerMenuMobile;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[1]/div[@class='pricing-plan__main']/a[@class='button button--l']")
	WebElement discoverFPS;

	@FindBy(xpath = "//div[@class='hero-subscriptions__tabs-body-item js-tabs-body-item is-active']/div/div/div[2]/div[@class='pricing-plan__main']/a[@class='button button--l']")
	WebElement discoverIDS;
	
	@FindBy(css = "body>header[id='bar']>div>nav>span:nth-child(2)>span")
	public WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;
	
	@FindBy(xpath="//a[@class='hero-subscriptions__tabs-head-item js-tabs-head-item is-active']/p")
	WebElement activeTab;

	public OurOffers verifyPage(String subscriptionStatus) {
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, ".page.page--pricing"));
		Verification.VerifyEquals("Our offers HeaderText not displayed", ourOfferHeaderText.getText(), "Our offers");
		Verification.VerifyEquals("Starter plan header not displayed", starterPlanHeader.getText(), "Starter plan");
		Verification.VerifyEquals("starterPlanText1 not displayed", starterPlanText1.getText(), "To discover the 3D experience");
		Verification.VerifyEquals("starterPlanText2 not displayed", starterPlanText2.getText(), "Free");
		Verification.VerifyEquals("starterPlanText3 not displayed", starterPlanText3.getText(), "No credit card required");
		Verification.displayOfWebElement(starterPlanButton);
		Verification.VerifyEquals("starterFeature1 not displayed", starterFeature1.getText(), "5 projects");
		Verification.VerifyEquals("starterFeature2 not displayed", starterFeature2.getText(), "3 high definition images");
		Verification.VerifyEquals("starterFeature3 not displayed", starterFeature3.getText(), "9 standard definition images");
		Verification.VerifyEquals("starterFeature4 not displayed", starterFeature4.getText(), "3D Branded models catalog");
		Verification.VerifyEquals("starterFeature5 not displayed", starterFeature5.getText(), "10 DIY furniture included (MakeByMe)");

		Verification.VerifyEquals("premiumHeader not displayed", premiumHeader.getText(), "Premium");
		Verification.VerifyEquals("premiumBaseline not displayed", premiumBaseline.getText(), "For passionate users");
		Verification.VerifyEquals("premiumFeatureText not displayed", premiumFeatureText.getText(), "Everything in Starter plus:");
		Verification.VerifyEquals("premiumText1 not displayed", premiumText1.getText(), "No commitment, cancel anytime");
		Verification.VerifyEquals("premiumFeature1 not displayed", premiumFeature1.getText(), "Unlimited projects");
		Verification.VerifyEquals("premiumFeature2 not displayed", premiumFeature2.getText(), "Unlimited realistic images");
		Verification.VerifyEquals("premiumFeature3 not displayed", premiumFeature3.getText(), "Unlimited Standard definition images");
		Verification.VerifyEquals("premiumFeature4 not displayed", premiumFeature4.getText(), "5 x 4K images (free)");
		Verification.VerifyEquals("premiumFeature5 not displayed", premiumFeature5.getText(), "5 x 360° images (free)");
		Verification.VerifyEquals("premiumFeature6 not displayed", premiumFeature6.getText(), "Upload 3D models");
		Verification.VerifyEquals("premiumFeature7 not displayed", premiumFeature7.getText(), "Priority online support");
		
		Verification.VerifyEquals("Unlimited HeaderText not displayed", unlimitedHeader.getText(), "Unlimited+");
		Verification.VerifyEquals("Unlimited Text not displayed", unlimitedText.getText(),
				"For decoration lovers");
		Verification.VerifyEquals("unlimitedFeatureText not displayed", unlimitedFeatureText.getText(), "Everything in Premium plus: ");
		Verification.VerifyEquals("unlimitedBaseline not displayed", unlimitedBaseline.getText(), "For decoration lovers");
		Verification.VerifyEquals("unlimitedFeature1 not displayed", unlimitedFeature1.getText(), "Unlimited 4K images");
		Verification.VerifyEquals("unlimitedFeature2 not displayed", unlimitedFeature2.getText(), "10 x 360° images (free)");
		Verification.VerifyEquals("unlimitedFeature3 not displayed", unlimitedFeature3.getText(), "Removable HomeByMe logo");
		
		if (!activeYearlyToggle.isEmpty()) {
			UtilHBM.reportOK("Yearly toggle option is active initially!!");
		} else {
			UtilHBM.reportKO("Yearly toggle option is not active initially!!");
		}
		Verification.displayOfWebElement(premiumYearlyPrice);
		Verification.displayOfWebElement(unlimitedYearlyPrice);
		Verification.displayOfWebElement(premiumYearlySubscribe);
		Verification.displayOfWebElement(unlimitedYearlySubscribe);	
		labelSwitch.click();
		if (!activeMonthlyToggle.isEmpty()) {
			UtilHBM.reportOK("Monthly toggle option is active!!");
		} else {
			UtilHBM.reportKO("Monthly toggle option is not active!!");
		}	
		Verification.displayOfWebElement(premiumMonthlyPrice);
		Verification.displayOfWebElement(unlimitedMonthlyPrice);
		Verification.displayOfWebElement(premiumMonthlySubscribe);
		Verification.displayOfWebElement(unlimitedMonthlySubscribe);	
		labelSwitch.click();
		
		Verification.displayOfWebElement(activeYearlyToggle.get(0));
		Verification.VerifyEquals("featureText not displayed", brandHeader.getText(),
				"TRUSTED BY YOUR FAVORITE BRANDS");
		if (brandList.size() != 3) {
			UtilHBM.reportKO("Incorrect number of brands displayed!!");
		}
		for (WebElement a : brandList) {
			Verification.displayOfWebElement(a);
		}

		openServicesTab();
		
		
		
		
//		switch (subscriptionStatus) {
//
//		case "":
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice1", monthlySubscriptionPrice.getText(), "US$ 35.39");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice2", monthlySubscriptionPriceText.getText(),
//					"/month");
//			Verification.displayOfWebElement(subscribeButtonMonthly);
//			Verification.VerifyEquals("Wrong disclaimerText", monthlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			switchSubscriptionType("Yearly");
//			Verification.VerifyEquals("Wrong freeMonthsFigcaption", freeMonthsFigcaption.getText(),
//					"2 MONTHS\n" + "FREE");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice", yearlySubscriptionPrice.getText(), "US$ 352.82");
//			Verification.VerifyEquals("Wrong activeSubscriptionPriceText", yearlySubscriptionPriceText.getText(),
//					"/year");
//			Verification.displayOfWebElement(subscribeButtonYearly);
//			Verification.VerifyEquals("Wrong disclaimerText", yearlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			break;
//
//		case "Pro monthly":
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice1", monthlySubscriptionPrice.getText(), "US$ 35.39");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice2", monthlySubscriptionPriceText.getText(),
//					"/month");
////			Verification.VerifyEquals("Subscribed button not displayed for subscription status : "+subscriptionStatus, activeProSubscribed.getText(), "Subscribed");
//			Verification.VerifyEquals("Wrong disclaimerText", monthlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			switchSubscriptionType("Yearly");
//			Verification.VerifyEquals("Wrong freeMonthsFigcaption", freeMonthsFigcaption.getText(),
//					"2 MONTHS\n" + "FREE");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice", yearlySubscriptionPrice.getText(), "US$ 352.82");
//			Verification.VerifyEquals("Wrong activeSubscriptionPriceText", yearlySubscriptionPriceText.getText(),
//					"/year");
//			Verification.VerifyEquals("Wrong disclaimerText", yearlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			Verification.displayOfWebElement(subscribeButtonYearly);
//
//			break;
//
//		case "Pro yearly":
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice1", monthlySubscriptionPrice.getText(), "US$ 35.39");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice2", monthlySubscriptionPriceText.getText(),
//					"/month");
//			Verification.displayOfWebElement(subscribeButtonMonthly);
//			Verification.VerifyEquals("Wrong disclaimerText", monthlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			switchSubscriptionType("Yearly");
//			Verification.VerifyEquals("Wrong freeMonthsFigcaption", freeMonthsFigcaption.getText(),
//					"2 MONTHS\n" + "FREE");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice", yearlySubscriptionPrice.getText(), "US$ 352.82");
//			Verification.VerifyEquals("Wrong activeSubscriptionPriceText", yearlySubscriptionPriceText.getText(),
//					"/year");
////			Verification.VerifyEquals("Subscribed button not displayed for subscription status : "+subscriptionStatus, activeProSubscribed.getText(), "Subscribed");
//			Verification.VerifyEquals("Wrong disclaimerText", yearlyDisclaimerText.getText(),
//					"No commitment, cancel anytime");
//			break;
//
//		default:
//			UtilHBM.reportInfo("Incorrect subscriptionStatus : " + subscriptionStatus);
//		}
//
//		Verification.VerifyEquals("subscriptionBenefits1 not displayed", subscriptionBenefits1.getText(),
//				"Unlimited projects");
//		Verification.VerifyEquals("subscriptionBenefits2 not displayed", subscriptionBenefits2.getText(),
//				"Unlimited realistic images");
//		Verification.VerifyEquals("subscriptionBenefits3 not displayed", subscriptionBenefits3.getText(),
//				"5 360° images");
//		Verification.VerifyEquals("subscriptionBenefits4 not displayed", subscriptionBenefits4.getText(),
//				"Professional usage rights");
//
//		Verification.VerifyEquals("Wrong feature1 Text", feature1.getText(), "An easy to use 3D planner");
//		Verification.VerifyEquals("Wrong feature2 Text", feature2.getText(), "Switch from 2D to 3D instantly");
//		Verification.VerifyEquals("Wrong feature3 Text", feature3.getText(),
//				"Expertly curated gallery of images to get inspired");
//		Verification.VerifyEquals("Wrong feature4 Text", feature4.getText(),
//				"More than 20,000 products to furnish your project");
//		Verification.VerifyEquals("Wrong feature5 Text", feature5.getText(),
//				"Mainstream and top-of-the-line brands, and designer creations");
//		Verification.VerifyEquals("Wrong feature6 Text", feature6.getText(),
//				"Various products to express your style: furniture, lighting fixtures, wall and floor covering");
//		Verification.VerifyEquals("Wrong feature7 Text", feature7.getText(),
//				"Amazing HD images that looks like a real photos");
//		Verification.VerifyEquals("Wrong feature8 Text", feature8.getText(),
//				"360° images to see your project from every angle");
//		Verification.VerifyEquals("Wrong feature9 Text", feature9.getText(),
//				"An immersive view to project yourself in your future house with VR");
//
//		Verification.VerifyEquals("Wrong featuresHeader", servicesHeader.getText(), "Our helping-hand services");
//		UtilHBM.turnOnImplicitWaits(driver);

		Verification.VerifyEquals("Wrong floorplanHeader", floorplanHeader.getText(), "We draw for you");
		Verification.VerifyEquals("Wrong floorplan text", floorplanDesc.getText(),
				"Would you like to have a 3D turnkey project? Let us do it for you!");
		Verification.VerifyEquals("FDS StratsAt text nt displayed!!!", floorplanStratsAtText.getText(), "Start at");
		Verification.elementContainsString(floorplanPrice, "17.69", "Initial(By default) Floorplan Price");
		Verification.displayOfWebElement(discoverFPS);
		Verification.VerifyEquals("Wrong fpText", fpText.getText(), "Would you like to have a 3D turnkey project? Let us do it for you!");
		Verification.VerifyEquals("Wrong idsText", idsText.getText(), "Need an expert eye? Let our team of professionals decorate your room!");
		Verification.VerifyEquals("Wrong IDS Header", idsHeader.getText(), "We decorate for you");
		Verification.VerifyEquals("Wrong IDS Text", idsDesc.getText(),
				"Need an expert eye? Let our team of professionals decorate your room!");
		Verification.VerifyEquals("IDS StratsAt text nt displayed!!!", idsStratsAtText.getText(), "start at");
		Verification.elementContainsString(idsPrice, "81.42", "IDS starting Price");
		Verification.displayOfWebElement(discoverIDS);
		openPacksTab();
		
//		Verification.displayNAttributeCheckOfElement(realisticImg, "realistic Img", "src",
//				"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2021/10/homebyme-homepage-gallery-9-1422x800.jpg");
		Verification.VerifyEquals("Wrong realisticHeader", realisticHeader.getText(), "Realistic images");
		Verification.VerifyEquals("Wrong realisticDesc", realisticDesc.getText(),
				"Get additional realistic images and express your talent. Choose your viewing angles, you're the artist!");
		Verification.displayOfWebElement(realisticDiscover);
		Verification.displayOfWebElement(realisticBuy);
		if (!realisticPackOf2.findElement(By.xpath("input")).isSelected()) {
			UtilHBM.reportKO("By default pack of 2 is not selected while purchasing realistic images");
		}
		selectRealisticPack("2").selectRealisticPack("10").selectRealisticPack("50");
//		Verification.displayNAttributeCheckOfElement(projectImg, "project Img", "src",
//				"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2021/11/tropical-livin-room-1422x1053.png");
		Verification.VerifyEquals("Wrong projectHeader", projectHeader.getText(), "Additional Projects");
		Verification.VerifyEquals("Wrong projectDesc", projectDesc.getText(),
				"Buy additional projects to express your creativity through HomeByMe possibilities!");
		Verification.displayOfWebElement(projectDiscover);
		Verification.displayOfWebElement(projectBuy);
		if (!projectPackOf2.findElement(By.xpath("input")).isSelected()) {
			UtilHBM.reportKO("By default pack of 2 is not selected while purchasing additional projects!!");
		}
		selectProjectPack("2").selectProjectPack("10").selectProjectPack("100");
//		Verification.displayNAttributeCheckOfElement(panoramicImg, "Panoramic Img", "src",
//				"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/11/create-360-image-hero-1422x753.jpg");
		Verification.VerifyEquals("Wrong panoramicHeader", panoramicHeader.getText(), "360° Images");
		Verification.VerifyEquals("Wrong panoramicDesc", panoramicDesc.getText(),
				"Select the amount of images you need and take a tour of your future interior as if you were already there!");
		Verification.displayOfWebElement(panoramicDiscover);
		Verification.displayOfWebElement(panoramicBuy);
		if (!panoramicPackOf1.findElement(By.xpath("input")).isSelected()) {
			UtilHBM.reportKO("By default pack of 1 is not selected while purchasing 360 images");
		}
		selectPanoramicPack("1").selectPanoramicPack("2").selectPanoramicPack("10");
		Verification.VerifyEquals("FAQ title not displayed", faqTitle.getText(), "Any questions?");
		Verification.VerifyEquals("FAQ text not displayed", faqText.getText(),
				"Find the answers to all your questions in our FAQ section.");
		faq1.click();
		Verification.VerifyEquals("faq1 not displayed", faq1Q.getText(), "What are the paid services on HomeByMe?");
		UtilHBM.waitExplicitDisplayed(driver, faqAns1);
		Verification.VerifyEquals("faqAns1 not displayed", faqAns1.getText(),
				"HomeByMe is a service dedicated to the home, free and for personal use.\nYou can create up to 3 projects and 3 realistic images per account for free. In addition, you can buy packs of additional projects, realistic images or 360° images.");
		UtilHBM.waitFixTime(2000);

		faq2.click();
		Verification.VerifyEquals("faq2 not displayed", faq2Q.getText(), "I am a professional, can I use HomeByMe?");
		UtilHBM.waitExplicitDisplayed(driver, faqAns2);
		Verification.VerifyEquals("faqAns2 not displayed", faqAns2.getText(),
				"HomeByMe is a comprehensive online home-design service for individuals and professionals, including real estate agents, architects, interior designers, developers, and more. To use HomeByMe for commercial purposes, you must subscribe to our HomeByMe Pro service via the Services tab on your profile page.");
		UtilHBM.waitFixTime(2000);

		faq3.click();
		Verification.VerifyEquals("faq3 not displayed", faq3Q.getText(), "Can I modify my subscription?");
		UtilHBM.waitExplicitDisplayed(driver, faqAns3);
		Verification.VerifyEquals("faqAns3 not displayed", faqAns3.getText(),
				"Of course you can! You can modify your Pro subscription from your account settings.\n"
						+ "If you currently have a monthly Pro subscription and you want to order the yearly Pro subscription, you will be directly upgraded to the yearly Pro subscription and charged for the whole year.");
		UtilHBM.waitFixTime(2000);

		faq4.click();
		Verification.VerifyEquals("faq4 not displayed", faq4Q.getText(),
				"What happens if I cancel my current subscription?");
		UtilHBM.waitExplicitDisplayed(driver, faqAns4);
		Verification.VerifyEquals("faqAns4 not displayed", faqAns4.getText(),
				"You can cancel your Pro subscription through your account settings at any time. Your subscription will then terminate at the end of the current subscription period. If you don’t want to renew your subscription, simply cancel it at least 24 hours before the renewal date.");

		return this;
	}

	public FloorplanServicePage clickDiscoverFPS() {
		UtilHBM.waitExplicitClickable(driver, discoverFPS);
		UtilHBM.waitExplicitDisplayed(driver, discoverFPS);
		discoverFPS.click();
		return PageFactory.initElements(driver, FloorplanServicePage.class);
	}

	public InteriorDesignServicePage clickDiscoverIDS() {
		UtilHBM.waitExplicitClickable(driver, discoverIDS);
		UtilHBM.waitExplicitDisplayed(driver, discoverIDS);
		discoverIDS.click();
		return PageFactory.initElements(driver, InteriorDesignServicePage.class);
	}
	
	public OurOffers openServicesTab() {
		UtilHBM.waitExplicitClickable(driver, serviceTab);
		UtilHBM.waitExplicitDisplayed(driver, serviceTab);
		serviceTab.click();
		Verification.VerifyEquals("Services tab is not selected!!", activeTab.getText(), "SERVICES");
		return this;
	}
	
	public OurOffers openPlansTab() {
		UtilHBM.waitExplicitClickable(driver, plansTab);
		UtilHBM.waitExplicitDisplayed(driver, plansTab);
		plansTab.click();
		Verification.VerifyEquals("Plans tab is not selected!!", activeTab.getText(), "PLANS");
		return this;
	}
	
	public OurOffers openPacksTab() {
		UtilHBM.waitExplicitClickable(driver, packsTab);
		UtilHBM.waitExplicitDisplayed(driver, packsTab);
		packsTab.click();
		Verification.VerifyEquals("Packs tab is not selected!!", activeTab.getText(), "PACKS");
		return this;
	}
	

	public OurOffers selectPanoramicPack(String numberOf360ToPurchase) {
		String expectedPrice = null;
		switch (numberOf360ToPurchase) {
		case "1":
			if (!panoramicPackOf1.findElement(By.xpath("input")).isSelected()) {
				UtilHBM.reportKO("By default pack of 1 is not selected while purchasing 360 images");
			}
			expectedPrice = UtilHBM.getProperty("testData", "PanoramicPackOf" + numberOf360ToPurchase + "Price");
			Verification.VerifyEquals("Incorrect Panoramic pack of 1 Price!!", panoramicPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "2":
			panoramicPackOf2.click();
			expectedPrice = UtilHBM.getProperty("testData", "PanoramicPackOf" + numberOf360ToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect Panoramic pack of 2 Price!!", panoramicPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "10":
			panoramicPackOf10.click();
			expectedPrice = UtilHBM.getProperty("testData", "PanoramicPackOf" + numberOf360ToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect Panoramic pack of 10 Price!!", panoramicPrice.getText(),
					"US$ " + expectedPrice);
			break;

		default:
			UtilHBM.reportInfo("Incorrect numberOf360ToPurchase : " + numberOf360ToPurchase);
		}
		return this;
	}
	
	public OurOffers selectRealisticPack(String noOfRealisticToPurchase) {
		String expectedPrice = null;
		switch (noOfRealisticToPurchase) {
		case "2":
			if (!realisticPackOf2.findElement(By.xpath("input")).isSelected()) {
				UtilHBM.reportKO("By default pack of 2 is not selected while purchasing realistic images");
			}
			expectedPrice = UtilHBM.getProperty("testData", "RealisticPackOf" + noOfRealisticToPurchase + "Price");
			Verification.VerifyEquals("Incorrect realistic pack of 2 Price!!", realisticPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "10":
			realisticPackOf10.click();
			expectedPrice = UtilHBM.getProperty("testData", "RealisticPackOf" + noOfRealisticToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect realistic pack of 10 Price!!", realisticPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "50":
			realisticPackOf50.click();
			expectedPrice = UtilHBM.getProperty("testData", "RealisticPackOf" + noOfRealisticToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect realistic pack of 50 Price!!", realisticPrice.getText(),
					"US$ " + expectedPrice);
			break;

		default:
			UtilHBM.reportInfo("Incorrect noOfRealisticToPurchase : " + noOfRealisticToPurchase);
		}
		return this;
	}
	
	public OurOffers selectProjectPack(String noOfProjectsToPurchase) {
		String expectedPrice = null;
		switch (noOfProjectsToPurchase) {
		case "2":
			if (!projectPackOf2.findElement(By.xpath("input")).isSelected()) {
				UtilHBM.reportKO("By default pack of 2 is not selected while purchasing projects");
			}
			expectedPrice = UtilHBM.getProperty("testData", "ProjectPackOf" + noOfProjectsToPurchase + "Price");
			Verification.VerifyEquals("Incorrect project pack of 2 Price!!", projectPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "10":
			projectPackOf10.click();
			expectedPrice = UtilHBM.getProperty("testData", "ProjectPackOf" + noOfProjectsToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect project pack of 10 Price!!", projectPrice.getText(),
					"US$ " + expectedPrice);
			break;

		case "100":
			projectPackOf100.click();
			expectedPrice = UtilHBM.getProperty("testData", "ProjectPackOf" + noOfProjectsToPurchase + "Price");
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Incorrect project pack of 100 Price!!", projectPrice.getText(),
					"US$ " + expectedPrice);
			break;

		default:
			UtilHBM.reportInfo("Incorrect noOfProjectsToPurchase : " + noOfProjectsToPurchase);
		}
		return this;
	}

	public Payment purchase360Image(String numberOf360ToPurchase) {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(panoramicImg).build().perform();
		selectPanoramicPack(numberOf360ToPurchase);
		String priceDisplayed = panoramicPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
		panoramicBuy.click();
		return PageFactory.initElements(driver, Payment.class);
	}
	
	public Payment purchaseRealisticImages(String noOfRealisticToPurchase) {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(realisticImg).build().perform();
		selectRealisticPack(noOfRealisticToPurchase);
		String priceDisplayed = realisticPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
		realisticBuy.click();
		return PageFactory.initElements(driver, Payment.class);
	}
	
	public Payment purchaseAddnlProjects(String noOfProjectsToPurchase) {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(projectImg).build().perform();
		selectProjectPack(noOfProjectsToPurchase);
		String priceDisplayed = projectPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
		projectBuy.click();
		return PageFactory.initElements(driver, Payment.class);
	}

	public Payment buySubscription(String expectedSubscriptionType) {
		switchSubscriptionType(expectedSubscriptionType);
		if (expectedSubscriptionType.equalsIgnoreCase("monthly")) {
			Verification.VerifyEquals("Wrong activeSubscriptionPrice1", premiumMonthlyPrice.getText(), "US$ 35.39");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice2", monthlySubscriptionPriceText.getText(),
//					"/ month");
			String priceDisplayed = premiumMonthlyPrice.getText().substring(3);
			UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
			UtilHBM.waitExplicitClickable(driver, premiumMonthlySubscribe);
			premiumMonthlySubscribe.click();
		} else if (expectedSubscriptionType.equalsIgnoreCase("yearly")) {
//			Verification.VerifyEquals("Wrong freeMonthsFigcaption", freeMonthsFigcaption.getText(), "2 free months");
			Verification.VerifyEquals("Wrong activeSubscriptionPrice1", premiumYearlyPrice.getText(), "US$ 352.82");
//			Verification.VerifyEquals("Wrong activeSubscriptionPrice2", yearlySubscriptionPriceText.getText(),
//					"/ year");
			String priceDisplayed = premiumYearlyPrice.getText().substring(3);
			UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
			UtilHBM.waitExplicitClickable(driver, premiumYearlySubscribe);
			premiumYearlySubscribe.click();
		} else {
			UtilHBM.reportKO("Wrong input given or No toggle (Monthly/Yearly) is selected initially!!");
		}
		
		return PageFactory.initElements(driver, Payment.class);
	}

	public Payment buyOneTimePack() {
//		for (int i = 0; i < 10; i++) {
//			if (oneTimePackPrice.getText().contains("US$ ")) {
//				break;
//			}
//			UtilHBM.waitFixTime(500);
//		}
//		Verification.VerifyEquals("Price text not displayed", oneTimePackPrice.getText(), "US$ 19.47");
//		String priceDisplayed = oneTimePackPrice.getText().substring(3);
//		UtilHBM.setProperty("testData", "LaCarte1Price", priceDisplayed);
//		UtilHBM.waitExplicitClickable(driver, buyOneTimePack);
//		buyOneTimePack.click();
		return PageFactory.initElements(driver, Payment.class);
	}

	private OurOffers switchSubscriptionType(String expectedSubscriptionType) {
		if (expectedSubscriptionType.equalsIgnoreCase("monthly")) {
			UtilHBM.waitFixTime(500);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean activeMonthlyToggleEmpty = activeMonthlyToggle.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (activeMonthlyToggleEmpty) {
				UtilHBM.waitExplicitClickable(driver, labelSwitch);
				labelSwitch.click();
			}
			UtilHBM.waitExplicitDisplayed(driver, activeMonthlyToggle.get(0));
			UtilHBM.reportInfo("Monthly toggle option is active!!");
		} else if (expectedSubscriptionType.equalsIgnoreCase("yearly")) {
			UtilHBM.waitFixTime(500);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean activeYearlyToggleEmpty = activeYearlyToggle.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (activeYearlyToggleEmpty) {
				UtilHBM.waitExplicitClickable(driver, labelSwitch);
				labelSwitch.click();
			}
			UtilHBM.waitExplicitDisplayed(driver, activeYearlyToggle.get(0));
			UtilHBM.reportInfo("Yearly toggle option is active!!");
		} else {
			UtilHBM.reportKO("Wrong input!!!");
		}
		return this;
	}

	public UserHomePage goTouserHomePage() {
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public LandingPage goToLandingPage() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, homebymeLink);
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public BuyHMSForm buyMeasuringServiceNew(String hmsInput) {
		WebElement buyHMS = driver.findElement(By.cssSelector(
				"#home-measure>#intro>.flex.flex-middle.wrapper>.flex.flex-column>.flex.flex-middle>.button.button--l"));
		UtilHBM.waitExplicitClickable(driver, buyHMS);
		buyHMS.click();
		return PageFactory.initElements(driver, BuyHMSForm.class);
	}
	
	public Magazine goToMagazine() {
		UtilHBM.waitExplicitDisplayed(driver, magazine);
		Actions actions=new Actions(driver);
		actions.moveToElement(magazine).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, magazineHomePage);
		UtilHBM.waitExplicitClickable(driver, magazineHomePage);
		magazineHomePage.click();
		return PageFactory.initElements(driver, Magazine.class);
	}
	
	public OurOffers verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Pricing and offers to design your home interior | HomeByMe")) {
			UtilHBM.reportOK("Offers page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("Offers page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public OurOffers goToPlans() {
		UtilHBM.waitExplicitDisplayed(driver, magazineHomePage);
		UtilHBM.waitExplicitClickable(driver, magazineHomePage);
		magazineHomePage.click();
		return this;
	}
	

	public HeaderMenusMobile clickHeaderMenuMobile() {
		headerMenuMobile.click();
//		new Actions(driver).moveToElement(headerMenuMobile, 0, 10).click().build().perform();
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}
}
