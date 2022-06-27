package hbm.web.pageobject;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class MyAccount {

	WebDriver driver;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.notifications-banner>p.success")
	WebElement updateSuccessStatus;

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement hbmLogo;

	@FindBy(css = "ul.userMenu-list")
	WebElement navList;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account/credits']")
	private WebElement credits;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account/subscription']")
	private WebElement subscriptions;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account']")
	private WebElement profileInfo;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account/private-details']")
	private WebElement privateInfo;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account/friendship-reward']")
	private WebElement friendshipReward;

	@FindBy(css = ".section>.wrapper>.grid>.grid-1-4>.userMenu>.userMenu-list>.userMenu-item>a.userMenu-link[href='/en/my-account/purchase']")
	private WebElement purchases;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.u-txtCenter.u-mtl>button.button")
	private WebElement saveButtonProfileInfo;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-uploadMedia>.form-uploadMedia-photo>.userHeader-thumb>img#preview_avatar")
	private List<WebElement> upLoadedProfilePhotoPreview;

//	@FindBy(css = ".header>.wrapper>.header-right>.header-account.header-account--logged>.byUser>.byUser-thumb>img#header_avatar")
//	private List<WebElement> upLoadedProfilePhotoHeader;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-uploadMedia>.form-uploadMedia-opts>button#delete_avatar")
	private WebElement deleteProfilePhoto;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_profile_measureUnit_0")
	private WebElement meterRadioButton;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_profile_measureUnit_0+label")
	private WebElement metricLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_profile_measureUnit_1")
	private WebElement feetRadioButton;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_profile_measureUnit_1+label")
	private WebElement imperialLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-uploadMedia>.form-uploadMedia-opts>#uploadifive-file_upload>input[type='file']:last-child")
	private WebElement photoUploadLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.u-txtCenter.u-mtm>#account_private_save")
	private WebElement savePrivateInfo;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>input#account_private_email")
	private WebElement userEmail;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor.form-item--pwd-change>input.form-control")
	private WebElement passwordField;

	@FindBy(css = "#app-notification>.success")
	private WebElement saveNotification;

	@FindBy(css = "#app-notification>.success>button.bt-icon-alt-light")
	private WebElement saveNotificationCloseBtn;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(3)>label.required")
	private WebElement emailLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(4)>label")
	private WebElement passwordLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(5)>label")
	private WebElement firstNameLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(6)>label")
	private WebElement lastNameLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(7)>span")
	private WebElement titleLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(8)>label")
	private WebElement countryLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(9)>label")
	private WebElement stateLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>div:nth-child(10)>label.required")
	private WebElement yourProfileLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>input#account_private_firstName")
	private WebElement firstName1;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>input#account_private_lastName")
	private WebElement lastName1;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>#account_private_country")
	private WebElement country;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>#account_private_zip")
	private WebElement zip;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>#account_private_state")
	private WebElement state;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.grid>.grid-1-3>select#account_private_birthday_day")
	private WebElement day;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.grid>.grid-1-3>select#account_private_birthday_month")
	private WebElement month;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.grid>.grid-1-3>select#account_private_birthday_year")
	private WebElement year;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_private_civility_1+label")
	private WebElement MrsLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_private_civility_0+label")
	private WebElement MrLabel;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_private_civility_1")
	private WebElement MrsInput;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>.form-item-field>.form-radios>.form-radios-item.u-mrs>#account_private_civility_0")
	private WebElement MrInput;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[1]/label")
	private WebElement newsLetter;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[2]/label")
	private WebElement promos;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[3]/label")
	private WebElement activityMails;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[1]/input[@checked='checked']")
	List<WebElement> newsLetterChecked;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[2]/input[@checked='checked']")
	List<WebElement> promosChecked;

	@FindBy(xpath = "//*[@id='emailSettings']/div/div/ul/li[3]/input[@checked='checked']")
	List<WebElement> activityMailsChecked;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>h1.box-title")
	private WebElement privateProfileHeader;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_profile']>h2.box-title")
	private WebElement publicProfileHeader;

	@FindBy(css = ".form-item>.form-item-field>#account_profile_description")
	private WebElement descriptionTextArea;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(3)")
	private WebElement myProfile;

	@FindBy(xpath = "//h2[.='Data sharing']/following-sibling::p")
	WebElement dataSharingText1;

	@FindBy(xpath = "//h2[.='Data sharing']/following-sibling::div/div/ul[@class='form-radios']/li/label")
	WebElement tnCText1;

	@FindBy(xpath = "//h2[.='Data sharing']")
	List<WebElement> dataSharing;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>p>span#open-gdpr")
	private WebElement viewMoreDeleteAccount;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>.u-txtBold")
	private WebElement beforeDeleteAccountHeader;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>ul>li:nth-child(1)")
	private WebElement beforeDeleteAccountTextOne;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>ul>li:nth-child(2)")
	private WebElement beforeDeleteAccountTextTwo;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>ul>li:nth-child(3)")
	private WebElement beforeDeleteAccountTextThree;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>ul>li:nth-child(4)")
	private WebElement beforeDeleteAccountTextFour;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.u-mts>.gdpr-description>.item-link.u-mts.js-open-ajax-modal")
	private WebElement deleteMyAccount;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor.form-item--pwd-change>a.link-soft.xsmall.js-open-ajax-modal")
	private WebElement changePassword;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>form[name='account_private']>.form-item.form-item--inline.form-item--inline-minor>#account_private_details_profile_type")
	private WebElement userProfile;

	@FindBy(css = ".header>.wrapper>.header-right>.header-menu>li>a[title='Our Offers']")
	private WebElement ourOffersLink;
	
	@FindBy(css = "div#sponsorship-push>section>div>img")
	private WebElement sponsorshipImg;

	@FindBy(css = "div#sponsorship-push>section>div.sponsorship-push-text>p:nth-child(1)")
	private WebElement sponsorshipText1;
	
	@FindBy(css = "div#sponsorship-push>section>div.sponsorship-push-text>p:nth-child(2)")
	private WebElement sponsorshipText2;


	@FindBy(css = "div#sponsorship-push>section>div.sponsorship-push-text>button.button--outline")
	private WebElement inviteFriendsButton;
	
	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.box-title")
	private WebElement myAccountHeaderText;

	@FindBy(css = "div#account-credits>h1.box-title")
	private WebElement creditsHeader;

	@FindBy(css = "div#account-credits>.list-credits.list-reset.flex.flex-wrap.flex-center.u-mtm>.flex.flex-column")
	List<WebElement> availableCredits;
	
	@FindBy(xpath = "//div[@class='purchase-data u-mtxs']/a[text()='Reload page']")
	List<WebElement> reloadPageButton;

	@FindBy(css = ".section>.wrapper>.grid>.grid-3-4>.info-credits-subscription.flex.flex-middle>.u-mbn")
	private WebElement subscriptionText1;

	@FindBy(xpath = "//div[@class='grid-3-4']//a[@href='/en/offers/'][text()='Discover our offers'][@class='button']")
	WebElement discoverOurOffersFromCredits;
	
	@FindBy(xpath = "//div[@class='grid-3-4']//a[@href='/en/offers/'][text()='Discover our offers'][@class='button u-mts']")
	WebElement discoverOurOffersFromPurchase;

	@FindBy(css = "div.purchase-data>p:nth-child(1)")
	private WebElement subscriptionText;
	
	@FindBy(css = "div#account-subscription>h1")
	private WebElement subscriptionHeader;

	@FindBy(css = "h2.box-title")
	WebElement discoverSubscriptionTitle;

	@FindBy(css = "div.subscription-cards>div:nth-child(1)>div.subscription>header>h3")
	WebElement monthlySubscribeTitle;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div.subscription>header>h3")
	WebElement yearlySubscribeTitle;

	@FindBy(css = "div.subscription-cards>div:nth-child(1)>div>header>p>span:nth-child(1)")
	WebElement monthlySubscribePrice;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>header>p>span:nth-child(1)")
	WebElement yearlySubscribePrice;

	@FindBy(css = "div.subscription-cards>div:nth-child(1)>div>ul>li:nth-child(1)")
	WebElement monthlySubscribeBenefits1;

	@FindBy(css = "div.subscription-cards>div:nth-child(1)>div>ul>li:nth-child(2)")
	WebElement monthlySubscribeBenefits2;
	
	@FindBy(css = "div.subscription-cards>div:nth-child(1)>div>ul>li:nth-child(3)")
	WebElement monthlySubscribeBenefits3;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>ul>li:nth-child(1)")
	WebElement yearlySubscribeBenefits1;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>ul>li:nth-child(2)")
	WebElement yearlySubscribeBenefits2;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>ul>li:nth-child(3)")
	WebElement yearlySubscribeBenefits3;

	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>ul>li:nth-child(4)")
	WebElement yearlySubscribeBenefits4;
	
	@FindBy(css = "div.subscription-cards>div:nth-child(2)>div>ul>li:nth-child(5)")
	WebElement yearlySubscribeBenefits5;

	@FindBy(xpath = "//a[@href='/en/services/pro-monthly/buy']/following-sibling::a[contains(text(),'More info')]")
	WebElement moreInfoMonthlySubscribe;

	@FindBy(xpath = "//a[@href='/en/services/pro-yearly/buy']/following-sibling::a[contains(text(),'More info')]")
	WebElement moreInfoYearlySubscribe;

	@FindBy(xpath = "//a[@href='/en/services/pro-yearly/buy'][contains(text(),'Subscribe')]")
	WebElement yearlySubscribe;

	@FindBy(xpath = "//a[@href='/en/services/pro-monthly/buy'][contains(text(),'Subscribe')]")
	WebElement monthlySubscribe;

	@FindBy(css = "li.subscription>div.purchase-data>p:nth-child(1)")
	private WebElement subscriptionOffer;

	@FindBy(css = ".purchase-data.u-mtxs>p.u-mts")
	private WebElement subscriptionBenifitsText;

	@FindBy(css = ".parent-list-subscription>ul:nth-child(1)>li:nth-child(1)")
	WebElement activeSubscriptionBenefits1;

	@FindBy(css = ".parent-list-subscription>ul:nth-child(1)>li:nth-child(2)")
	WebElement activeSubscriptionBenefits2;

	@FindBy(css = ".parent-list-subscription>ul:nth-child(1)>li:nth-child(3)")
	WebElement activeSubscriptionBenefits3;

	@FindBy(css = ".parent-list-subscription>ul:nth-child(2)>li:nth-child(1)")
	WebElement activeSubscriptionBenefits4;

	@FindBy(css = ".parent-list-subscription>ul:nth-child(2)>li:nth-child(2)")
	WebElement activeSubscriptionBenefits5;

	@FindBy(css = "li.subscription>div.purchase-data>p:nth-child(2)")
	private WebElement subscriptionOfferRenew;

	@FindBy(css = "li.subscription>div.purchase-data>p:nth-child(2)>strong")
	private WebElement subscriptionOfferRenewDate;

	@FindBy(css = "a[href='/en/my-account/payment-details/edit']")
	private WebElement editPaymentInfo;

	@FindBy(css = ".flex.links.u-mts>.btns>.button[href='/en/subscriptions']")
	private WebElement modifySubscription;

	@FindBy(css = ".modal-inner>.u-mtn.u-mbn>strong")
	private WebElement subscriptionEndDate;

	@FindBy(css = "div>a[title='Unsubscribe']")
	private WebElement unsubscribeButton;

	@FindBy(css = "#vue-account-subscription>h2")
	private WebElement yourInvoices;

	@FindBy(css = "li.flex.subscription>div")
	List<WebElement> yourInvoicesList;

	@FindBy(css = ".subscription>.purchase-data.u-mtxs>p:nth-child(2)>strong")
	private WebElement subscriptionRenewDate;

	@FindBy(css = "ul.list-dates>p")
	private WebElement purchaseText1;
	
	@FindBy(xpath="//header[@id='bar']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@id='bar']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;
	
	@CacheLookup
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//article[@id='vue-account-subscription']/ul/li/div/p[contains(text(),'Cancel your subscription')]")
	WebElement cancelYourSubscription;
	
	@FindBy(xpath="//article[@id='vue-account-subscription']/ul/li/div/p[2]")
	WebElement cancelYourSubscriptionText;
	
	@FindBy(xpath="//article[@id='vue-account-subscription']/ul/li/div/div/div/a[text()='Cancel']")
	WebElement cancelUnsubscriptionButton;

	public UserHomePage goToUserHomePage() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		hbmLogo.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public MyAccount checkUpdateAppointmentSuccess() {
		UtilHBM.waitExplicitDisplayed(driver, updateSuccessStatus);
		Verification.VerifyEquals("Appointment Not Updated", updateSuccessStatus.getText(),
				"Your appointment has been updated");
		return this;
	}

	public MyAccount clickProfileInfo() {
		UtilHBM.waitExplicitDisplayed(driver, profileInfo);
		UtilHBM.waitExplicitClickable(driver, profileInfo);
		UtilHBM.waitFixTime(1000);
		profileInfo.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount clickPrivateInfo() {
		UtilHBM.waitExplicitDisplayed(driver, privateInfo);
		UtilHBM.waitExplicitClickable(driver, privateInfo);
		UtilHBM.waitFixTime(1000);
		privateInfo.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount clickFriendshipReward() {
		UtilHBM.waitExplicitDisplayed(driver, friendshipReward);
		UtilHBM.waitExplicitClickable(driver, friendshipReward);
		UtilHBM.waitFixTime(1000);
		friendshipReward.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount clickCredits() {
		UtilHBM.waitExplicitDisplayed(driver, credits);
		UtilHBM.waitExplicitClickable(driver, credits);
		UtilHBM.waitFixTime(1000);
		credits.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount clickPurchases() {
		UtilHBM.waitExplicitDisplayed(driver, purchases);
		UtilHBM.waitExplicitClickable(driver, purchases);
		UtilHBM.waitFixTime(1000);
		purchases.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount clickSubscriptions() {
		UtilHBM.waitExplicitDisplayed(driver, subscriptions);
		UtilHBM.waitExplicitClickable(driver, subscriptions);
		UtilHBM.waitFixTime(1000);
		subscriptions.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}
	
	public Payment buySubscription(String expectedSubscriptionType) {
		if (expectedSubscriptionType.equalsIgnoreCase("monthly")) {
			UtilHBM.waitExplicitDisplayed(driver, monthlySubscribeTitle);
			Verification.VerifyEquals("monthlySubscribeTitle Not Displayed", monthlySubscribeTitle.getText(),
					"Pro monthly");
			UtilHBM.waitExplicitClickable(driver, monthlySubscribePrice);
			Verification.displayOfWebElement(monthlySubscribePrice);
			UtilHBM.waitExplicitDisplayed(driver, monthlySubscribe);
			UtilHBM.waitExplicitClickable(driver, monthlySubscribe);
			monthlySubscribe.click();
		} else if (expectedSubscriptionType.equalsIgnoreCase("yearly")) {
			UtilHBM.waitExplicitDisplayed(driver, yearlySubscribeTitle);
			Verification.VerifyEquals("yearlySubscribeTitle Not Displayed", yearlySubscribeTitle.getText(),
					"Pro yearly");
			UtilHBM.waitExplicitClickable(driver, yearlySubscribePrice);
			Verification.displayOfWebElement(yearlySubscribePrice);
			UtilHBM.waitExplicitDisplayed(driver, yearlySubscribe);
			UtilHBM.waitExplicitClickable(driver, yearlySubscribe);
			yearlySubscribe.click();
		} else {
			UtilHBM.reportKO("Wrong input given or No toggle (Monthly/Yearly) is selected initially!!");
		}
		return PageFactory.initElements(driver, Payment.class);
	}

	public SponsorshipDialog clickInviteFriendsButton() {
		UtilHBM.waitExplicitDisplayed(driver, inviteFriendsButton);
		UtilHBM.waitExplicitClickable(driver, inviteFriendsButton);
		inviteFriendsButton.click();
		return PageFactory.initElements(driver, SponsorshipDialog.class);
	}
	
	public LandingPage deleteAccount(SignUpData signUpData, String hbmOrSocial) {
		UtilHBM.waitExplicitDisplayed(driver, privateProfileHeader);
		UtilHBM.waitExplicitClickable(driver, viewMoreDeleteAccount);
		clickViewMore();
		UtilHBM.waitExplicitDisplayed(driver, beforeDeleteAccountHeader);
		Verification.VerifyEquals("DeleteAccountHeader not displayed", beforeDeleteAccountHeader.getText(),
				"Before you go, keep in mind:");
		Verification.VerifyEquals("BeforeDeleteAccountTextOne not displayed", beforeDeleteAccountTextOne.getText(),
				"Account deletion is final. There will be no way to restore your account.");
		Verification.VerifyEquals("BeforeDeleteAccountTextTwo not displayed", beforeDeleteAccountTextTwo.getText(),
				"All your projects, realistic images, images 360°, comments etc. will be unlinked to your account.");
		Verification.VerifyEquals("BeforeDeleteAccountTextThree not displayed", beforeDeleteAccountTextThree.getText(),
				"We have no control over content indexed by search engines like Google. It means that your items might stay visible online for a while but they won't be related to your identity.");
		Verification.VerifyEquals("BeforeDeleteAccountTextFour not displayed", beforeDeleteAccountTextFour.getText(),
				"If you have purchased any service on HomeByMe and want to delete the information provided to our reseller, you'll need to deal directly with Fastspring since we do not store any information related to your purchase.");
		// deleteMyAccount.click();
		new Actions(driver).moveToElement(deleteMyAccount).click().build().perform();
		DeleteAccount1 deleteAccount1 = PageFactory.initElements(driver, DeleteAccount1.class);
		deleteAccount1.deleteAccount1().deleteAccount2(signUpData, hbmOrSocial);
		UtilHBM.reportOK("Account deleted for account " + signUpData.getLoginId());
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public MyAccount checkCredits(String projects, String realistic4K, String realisticSD, String realisticHD,
			String panaromic, String subscriptionStatus) {
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickCredits()
			.verifyCredits(projects, realistic4K, realisticSD, realisticHD, panaromic,subscriptionStatus);
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public String getAvailableCreditsValues(String attribute) {
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.goToAccountPage().clickCredits();
		String attributeValue = availableCreditValues().get(attribute);
		return attributeValue;
	}

	public MyAccount verifyNoPurchases() {
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPurchases();
		Verification.VerifyEquals("Purchase Header is incorrect", myAccountHeaderText.getText(), "Your purchases");
		Verification.VerifyEquals("purchaseText1", purchaseText1.getText(),
				"You currently have no purchases. Do not hesitate to discover all of Homebyme's offers in the service section of your profile.");
		Verification.displayOfWebElement(discoverOurOffersFromPurchase);
		return this;
	}

	public void editPurchase(String service) {
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPurchases();
		DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
		Date date = new Date();
		String d1 = dateFormat.format(date);
		List<WebElement> serviceAvailable1 = driver
				.findElements(By.xpath("//time[contains(text(),'" + d1 + "')]/preceding-sibling::p[contains(text(),'"
						+ service + "')]/../../following-sibling::div/div[@class=' u-txtRight']/a"));
		UtilHBM.reportInfo("\"" + serviceAvailable1.get(0).getText() + "\" clicked for " + service + " of date " + d1);
		serviceAvailable1.get(0).click();
	}

	public MyAccount clickProfileInfoSave() {
		UtilHBM.waitExplicitClickable(driver, saveButtonProfileInfo);
		saveButtonProfileInfo.click();
		UtilHBM.reportInfo("Save button clicked");
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount deletePhoto() {
		if (!upLoadedProfilePhotoPreview.isEmpty()) {
			UtilHBM.reportInfo("Profile Photo is available to delete!!!");
			clickDeleteButton().clickProfileInfoSave();
		} else {
			UtilHBM.reportKO("Profile Photo Not available to delete!!!");
		}
		return this;
	}

	public MyAccount verifyPhotoDeleted() {
		if (upLoadedProfilePhotoPreview.get(0).isDisplayed()
//				&& upLoadedProfilePhotoHeader.get(0).isDisplayed()
		) {
			UtilHBM.reportKO("Profile photo not deleted");
		} else {
			UtilHBM.reportOK("Profile photo deleted");
		}
		return this;
	}

	private MyAccount clickDeleteButton() {
		UtilHBM.waitExplicitClickable(driver, deleteProfilePhoto);
		deleteProfilePhoto.click();
		return this;
	}

	public MyAccount setUnit(String unitMorFt) {
		UtilHBM.waitFixTime(1000);
		if (unitMorFt.equalsIgnoreCase("m")) {
			if (!meterRadioButton.isSelected()) {
				metricLabel.click();
				clickProfileInfoSave();
				if (meterRadioButton.isSelected()) {
					UtilHBM.reportOK("Measure Unit changed to 'm' from 'ft'");
				} else {
					UtilHBM.reportKO("Measure Unit not changed to 'm' from 'ft'");
				}
			} else {
				UtilHBM.reportInfo("Measure unit is already set as 'm'");
			}
		} else {
			if (!feetRadioButton.isSelected()) {
				imperialLabel.click();
				clickProfileInfoSave();
				if (feetRadioButton.isSelected()) {
					UtilHBM.reportOK("Measure Unit changed to 'ft' from 'm'");
				} else {
					UtilHBM.reportKO("Measure Unit not changed to 'ft' from 'm'");
				}
			} else {
				UtilHBM.reportInfo("Measure unit is already set as 'ft'");
			}
		}
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public MyAccount uploadPhoto(String fpPath) {
		photoUploadLabel.sendKeys(new File(Setting.imgPath + fpPath).getAbsolutePath());
		UtilHBM.waitExplicitDisplayed(driver, upLoadedProfilePhotoPreview.get(0));
		Verification.displayOfWebElement(upLoadedProfilePhotoPreview.get(0));
		clickProfileInfoSave();
		UtilHBM.waitExplicitDisplayed(driver, upLoadedProfilePhotoPreview.get(0));
		if (upLoadedProfilePhotoPreview.get(0).getAttribute("src").contains("placeholder")
//				&& upLoadedProfilePhotoHeader.get(0).getAttribute("src").contains("placeholder")
		) {
			UtilHBM.reportKO("Photo not uploaded to Preview or to Profile header");
		} else if (upLoadedProfilePhotoPreview.get(0).getAttribute("src").contains("/avatar/")
//				&& upLoadedProfilePhotoHeader.get(0).getAttribute("src").contains("/avatar/")
		) {
			UtilHBM.reportOK("Photo uploaded to both Preview and Profile header");
		} else {
			UtilHBM.reportKO("Both profile photo and placeholder not displayed!!");
		}
		return this;
	}

	public MyAccount clickPrivateInfoSave() {
		savePrivateInfo.click();
		UtilHBM.waitExplicitDisplayed(driver, saveNotification);
		Verification.verifyText(saveNotification, "Changes saved successfully", "Save Notification in Accounts");
		saveNotificationCloseBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, navList);
		return this;
	}

	public MyAccount verifyPrivateInfoForm(String email, String firstName, String lastName, String title,
			String countryName, String stateName, String profile) {
		UtilHBM.waitExplicitDisplayed(driver, privateProfileHeader);
		if (userEmail.isEnabled() && !passwordField.isEnabled() && firstName1.isEnabled() && lastName1.isEnabled()
				&& country.isEnabled() && state.isEnabled()) {
			UtilHBM.reportOK("All Private Information form fields are enabled");
		} else {
			UtilHBM.reportKO("All Private Information form fields are not enabled");
		}
		Verification.VerifyEquals("Wrong emailLabel", emailLabel.getText(), "Email");
		Verification.VerifyEquals("Wrong passwordLabel", passwordLabel.getText(), "Password");
		Verification.VerifyEquals("Wrong firstNameLabel", firstNameLabel.getText(), "First name");
		Verification.VerifyEquals("Wrong lastNameLabel", lastNameLabel.getText(), "Last name");
		Verification.VerifyEquals("Wrong titleLabel", titleLabel.getText(), "Title");
		Verification.VerifyEquals("Wrong countryLabel", countryLabel.getText(), "Country");
		Verification.VerifyEquals("Wrong stateLabel", stateLabel.getText(), "State");
		Verification.VerifyEquals("Wrong yourProfileLabel", yourProfileLabel.getText(), "Your profile");

		Verification.VerifyEquals("Wrong email Id", userEmail.getAttribute("value"), email);
		if (firstName.equals("") && firstName1.getAttribute("value").equals("")) {
			UtilHBM.reportOK("No value displayed in First name field");
		} else {
			Verification.VerifyEquals("Wrong first name value", firstName1.getAttribute("value"), firstName);
		}
		if (lastName.equals("") && lastName1.getAttribute("value").equals("")) {
			UtilHBM.reportOK("No value displayed in last name field");
		} else {
			Verification.VerifyEquals("Wrong last name value", lastName1.getAttribute("value"), lastName);
		}
		Select select = new Select(country);
		Verification.VerifyEquals("Wrong country value", select.getFirstSelectedOption().getText(), countryName);
		if (stateName.equals("") && state.getAttribute("value").equals("")) {
			UtilHBM.reportOK("No value displayed in state field");
		} else {
			Verification.VerifyEquals("Wrong state value", state.getAttribute("value"), stateName);
		}
		Select select1 = new Select(userProfile);
		Verification.VerifyEquals("Wrong profile valuel", select1.getFirstSelectedOption().getText(), profile);
		if (title.equalsIgnoreCase("")) {
			if (!MrInput.isSelected() && !MrsInput.isSelected()) {
				UtilHBM.reportOK("Both Gender fields are not selected");
			} else {
				UtilHBM.reportKO("One of Gender field is selected!!Mr field selcted : " + MrInput.isSelected()
						+ " , Mrs field selected : " + MrsInput.isSelected());
			}
		} else if (title.equalsIgnoreCase("Mr")) {
			if (MrInput.isSelected() && !MrsInput.isSelected()) {
				UtilHBM.reportOK("Mr field is selected");
			} else {
				UtilHBM.reportKO("Mr field is not selected!!");
			}
		} else if (title.equalsIgnoreCase("Mrs")) {
			if (MrsInput.isSelected() && !MrInput.isSelected()) {
				UtilHBM.reportOK("Mrs field is selected");
			} else {
				UtilHBM.reportKO("Mrs field is not selected!!");
			}
		}
		if (MrInput.isSelected() && MrsInput.isSelected()) {
			UtilHBM.reportKO("Both Gender fields are selected");
		}
		UtilHBM.turnOffImplicitWaits(driver);
		if (!newsLetterChecked.isEmpty()) {
			UtilHBM.reportInfo("News letter option not selected initially");
			newsLetter.click();
		}
		if (!promosChecked.isEmpty()) {
			UtilHBM.reportInfo("Promos checkbox in not selected initially!!");
			promos.click();
		}
		if (!activityMailsChecked.isEmpty()) {
			UtilHBM.reportInfo("activityMails checkbox in not selected initially!!");
			activityMails.click();
		}
		clickPrivateInfoSave();
		
		if (!newsLetterChecked.isEmpty()) {
			UtilHBM.reportKO("News Letter checkbox in not selected!!");
		}
		if (!promosChecked.isEmpty()) {
			UtilHBM.reportKO("Promos checkbox is not selected!!");
		}
		if (!activityMailsChecked.isEmpty()) {
			UtilHBM.reportKO("Activity mails checkbox in not selected!!");
		}
		newsLetter.click();
		promos.click();
		activityMails.click();
		clickPrivateInfoSave();
		if (newsLetterChecked.isEmpty()) {
			UtilHBM.reportKO("News Letter checkbox is selected!!");
		}
		if (promosChecked.isEmpty()) {
			UtilHBM.reportKO("Promos checkbox is selected!!");
		}	
		if (activityMailsChecked.isEmpty()) {
			UtilHBM.reportKO("Activity mails checkbox is selected!! ");
		}
		clickPrivateInfoSave();
		UtilHBM.reportOK("Verified Private Information form");
		return this;
	}

	public MyAccount editPrivateInfo(String firstName, String lastName, String title, String countryName,
			String stateName, String profile) {
		UtilHBM.waitExplicitDisplayed(driver, privateProfileHeader);
		firstName1.clear();
		firstName1.sendKeys(firstName);
		lastName1.clear();
		lastName1.sendKeys(lastName);
		Select select = new Select(country);
		select.selectByVisibleText(countryName);
		state.clear();
		state.sendKeys(stateName);
		Select select1 = new Select(userProfile);
		select1.selectByVisibleText(profile);
		clickPrivateInfoSave().editTitle(title);
		return this;
	}

	public MyAccount editTitle(String title1) {
		if (!MrInput.isSelected() && !MrsInput.isSelected()) {
			UtilHBM.reportInfo("Both Gender fields are not selected");
			MrsLabel.click();
			UtilHBM.reportInfo("Mrs field is selected");
			clickPrivateInfoSave();
			if (!MrInput.isSelected() && MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mrs field is selected after saving");
			}
			MrLabel.click();
			UtilHBM.reportInfo("Mr field is selected");
			clickPrivateInfoSave();
			if (MrInput.isSelected() && !MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mr field is selected after saving");
			}
		} else if (MrInput.isSelected() && !MrsInput.isSelected()) {
			UtilHBM.reportOK("Only Mr field is selected initially");
			MrsLabel.click();
			UtilHBM.reportInfo("Mrs field is selected");
			clickPrivateInfoSave();
			if (!MrInput.isSelected() && MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mrs field is selected after saving");
			}
			MrLabel.click();
			UtilHBM.reportInfo("Mr field is selected");
			clickPrivateInfoSave();
			if (MrInput.isSelected() && !MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mr field is selected after saving");
			}
		} else if (!MrInput.isSelected() && MrsInput.isSelected()) {
			UtilHBM.reportOK("Only Mrs field is selected initially");
			MrLabel.click();
			UtilHBM.reportInfo("Mr field is selected");
			clickPrivateInfoSave();
			if (MrInput.isSelected() && !MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mr field is selected after saving");
			}
			MrsLabel.click();
			UtilHBM.reportInfo("Mrs field is selected");
			clickPrivateInfoSave();
			if (!MrInput.isSelected() && MrsInput.isSelected()) {
				UtilHBM.reportOK("Only Mrs field is selected after saving");
			}
		} else if (MrInput.isSelected() && MrsInput.isSelected()) {
			UtilHBM.reportKO("Both Gender fields are selected");
		}
		if (title1.equalsIgnoreCase("Mr")) {
			if (!MrInput.isSelected()) {
				MrLabel.click();
				clickPrivateInfoSave();
			}
		} else if (title1.equalsIgnoreCase("Mrs")) {
			if (!MrsInput.isSelected()) {
				MrsLabel.click();
				clickPrivateInfoSave();
			}
		}
		return this;
	}
	
	public MyAccount disallowDataSharing() {
		UtilHBM.waitExplicitDisplayed(driver, dataSharingText1);
		Verification.VerifyEquals("dataSharingText1 not displayed", dataSharingText1.getText(),
				"You can delete access to your data:");
		Verification.VerifyEquals("Wrong TnC text1", tnCText1.getText(),
				"I would like to share my personal information / projects with Gautier");
		tnCText1.click();
		clickPrivateInfoSave();
		if (dataSharing.isEmpty())
			UtilHBM.reportOK("Data sharing stopped!!!");
		else
			UtilHBM.reportKO("Data sharing not stopped!!!");
		return PageFactory.initElements(driver, MyAccount.class);
	}

	private MyAccount clickViewMore() {
		UtilHBM.waitExplicitDisplayed(driver, viewMoreDeleteAccount);
		UtilHBM.waitExplicitClickable(driver, viewMoreDeleteAccount);
		UtilHBM.waitFixTime(1000);
		viewMoreDeleteAccount.click();
		return this;
	}

	public ChangePasswordDialog clickChangePassword() {
		UtilHBM.waitExplicitDisplayed(driver, changePassword);
		UtilHBM.waitExplicitClickable(driver, changePassword);
		changePassword.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, ChangePasswordDialog.class);
	}
	
	public MyAccount changeUserProfile(String profile) {
		Select profileSelect = new Select(userProfile);
		profileSelect.selectByVisibleText(profile);
		clickPrivateInfoSave();
		return this;
	}

	public MyAccount VerifyUserProfile(String expectedProfile) {
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPrivateInfo();
		Select profileSelect = new Select(userProfile);
		String selectedProfile = profileSelect.getFirstSelectedOption().getText();
		Verification.VerifyEquals("Wrong profile displayed!!!", selectedProfile, expectedProfile);
		return this;
	}

//	public UserHomePage verifyOfferSequence() {
//		Select profileSelect = new Select(userProfile);
//		List<WebElement> profileOptions = profileSelect.getOptions();
//		ArrayList<String> profileOptions1 = new ArrayList<String>();
//		for (int i = 1; i < profileOptions.size(); i++) {
//			profileOptions1.add(profileOptions.get(i).getText());
//		}
//		if (profileOptions1.size() == 6) {
//			UtilHBM.reportOK("Correct no. of user profile available!!");
//		} else {
//			UtilHBM.reportKO(
//					"Incorrect no. of user profile available!!Available : " + profileOptions1.size() + "Expected : 6");
//		}
//
//		for (String user : profileOptions1) {
//			UtilHBM.turnOffImplicitWaits(driver);
//			UtilHBM.reportInfo("Verifying offer sequence for user profile : " + user);
//			String expectedTitle = null;
//			if (user.equalsIgnoreCase("Individual") || user.equalsIgnoreCase("Student")
//					|| user.equalsIgnoreCase("Other")) {
//				expectedTitle = "Giving you a helping hand";
//			} else if (user.equalsIgnoreCase("Interior designer") || user.equalsIgnoreCase("Real estate agent")
//					|| user.equalsIgnoreCase("Craftsman")) {
//				expectedTitle = "Our subscriptions";
//			}
//			UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
//			userHomePage.goToAccountPage().clickPrivateInfo().changeUserProfile(user).goToOurOffers();
//			UtilHBM.turnOnImplicitWaits(driver);
//			OurOffers ourOffers = PageFactory.initElements(driver, OurOffers.class);
//			ourOffers.verifyFirstService(expectedTitle);
//		}
//
//		return PageFactory.initElements(driver, UserHomePage.class);
//	}

	public OurOffers goToOurOffers() {
		ourOffersLink.click();
		return PageFactory.initElements(driver, OurOffers.class);
	}

	public MyAccount verifyFriendshipReward() {
		Verification.VerifyEquals("friendshipRewardHeader is incorrect", myAccountHeaderText.getText(),
				"Your friendship reward");
		Verification.displayOfWebElement(sponsorshipImg);
		Verification.VerifyEquals("sponsorshipText1 is incorrect", sponsorshipText1.getText(),
				"Everything is better with friends! Receive 10 free realistic images for each friend who signs up. Your friend too will receive 3 additional realistic images.");
		Verification.VerifyEquals("sponsorshipText2 is incorrect", sponsorshipText2.getText(),
				"You can recommend HomeByMe to up to 6 friends every month.");
		Verification.displayOfWebElement(inviteFriendsButton);
		UtilHBM.waitExplicitClickable(driver, inviteFriendsButton);
		clickInviteFriendsButton().verifySponsorshipDialog().closeSponsorshipDialogMyAccount();
		return this;
	}

	public MyAccount verifyCredits(String projects, String realistic4K, String realisticSD, String realisticHD,
			String panaromic, String subscriptionStatus) {
		UtilHBM.waitExplicitDisplayed(driver, creditsHeader);
		Verification.VerifyEquals("Wrong Header displayed for Credits", creditsHeader.getText(), "Your credits");
		String availableProjects = availableCreditValues().get("Projects");
		if (projects.equalsIgnoreCase(availableProjects))
			UtilHBM.reportOK("No of projects verified!!!");
		else
			UtilHBM.reportKO("Incorrect no of projects !!! Available projects value : " + availableProjects
					+ " ,Expected projects value : " + projects);

		String available4K = availableCreditValues().get("4K realistic images");
		if (projects.equalsIgnoreCase(availableProjects))
			UtilHBM.reportOK("No of 4K realistic images verified!!!");
		else
			UtilHBM.reportKO("Incorrect no of 4K realistic images !!! Available 4K realistic images value : "
					+ available4K + " ,Expected 4K realistic images value : " + projects);

		String availableHDRealistic = availableCreditValues().get("HD realistic images");
		if (realisticHD.equalsIgnoreCase(availableHDRealistic))
			UtilHBM.reportOK("No of HD realistic images verified!!!");
		else
			UtilHBM.reportKO("Incorrect no of HD realistic images!!! Available HD realistic images value : "
					+ availableHDRealistic + " ,Expected HD realistic images value : " + realisticHD);

		String availableSDRealistic = availableCreditValues().get("SD realistic images");
		if (realisticSD.equalsIgnoreCase(availableSDRealistic))
			UtilHBM.reportOK("No of SD realistic images verified!!!");
		else
			UtilHBM.reportKO("Incorrect no of SD realistic images!!! Available SD realistic images value : "
					+ availableSDRealistic + " ,Expected SD realistic images value : " + realisticSD);

		String available360 = availableCreditValues().get("360° Photos");
		if (panaromic.equalsIgnoreCase(available360))
			UtilHBM.reportOK("No of 360° Photos verified!!!");
		else
			UtilHBM.reportKO("Incorrect no of 360° Photos !!! Available 360° Photos value : " + available360
					+ " ,Expected 360° Photos value : " + panaromic);
		return this;
	}

	public HashMap<String, String> availableCreditValues() {
		HashMap<String, String> availableCreditsMap = new HashMap<String, String>();
		for (WebElement a : availableCredits) {
			String key1 = a.findElement(By.tagName("p")).getText();
			String value1 = a.findElement(By.tagName("span")).getText();
			availableCreditsMap.put(key1, value1);
		}
		return availableCreditsMap;
	}

	public MyAccount verifyCreditsPage(String subscriptionStatus) {
		if (subscriptionStatus.equalsIgnoreCase("yes")) {
			UtilHBM.reportInfo(subscriptionText1.getText());
			for (WebElement a : availableCredits) {
				Verification.displayOfWebElement(a.findElement(By.tagName("i")));
				Verification.displayOfWebElement(a.findElement(By.tagName("p")));
				Verification.displayOfWebElement(a.findElement(By.tagName("span")));
			}
		}
		Verification.displayOfWebElement(discoverOurOffersFromCredits);
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public OurOffers discoverOurOffersFromCredits() {
		UtilHBM.waitExplicitDisplayed(driver, discoverOurOffersFromCredits);
		UtilHBM.waitExplicitClickable(driver, discoverOurOffersFromCredits);
		discoverOurOffersFromCredits.click();
		return PageFactory.initElements(driver, OurOffers.class);
	}

	public MyAccount verifyPurchase(String service, int noOfPurchasesOfService) {
		DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy");
		Date date = new Date();
		String d1 = dateFormat.format(date);
		List<WebElement> serviceAvailable = driver.findElements(By.xpath(
				"//div[@class='section']/div[@class='wrapper']/div[@class='grid']/div[@class='grid-3-4']/ul[@class='list-dates']/li[@class='purchase']/div[@class='purchase-data u-mtxs']/div[@class='flex flex-bottom status']/div/time[contains(text(),'"
						+ d1 + "')]/preceding-sibling::p[contains(text(),'" + service + "')]/../.."));
		if (serviceAvailable.isEmpty())
			UtilHBM.reportKO(service + " not available in purchase list");
		else {
			if (noOfPurchasesOfService == serviceAvailable.size())
				UtilHBM.reportOK(service + " is available in purchase list. No of Orders displayed : "
						+ serviceAvailable.size() + "  No of Orders expected :" + noOfPurchasesOfService);
			else
				UtilHBM.reportKO(service + " is available in purchase list. No of Orders displayed : "
						+ serviceAvailable.size() + "  No of Orders expected :" + noOfPurchasesOfService);

			UtilHBM.reportInfo("Displaying purchase information for " + service + " :");

			if (service.equalsIgnoreCase("One room design") || service.equalsIgnoreCase("Multi-purpose room design")) {
				for (int i = 0; i < serviceAvailable.size(); i++) {
					WebElement price = serviceAvailable.get(i)
							.findElement(By.xpath("div[@class=' u-txtRight']/p[@class='u-mbn']"));
					WebElement invoice = serviceAvailable.get(i)
							.findElement(By.xpath("div[@class=' u-txtRight']/a[@class='link-soft u-clr2']"));
					Verification.displayOfWebElement(price);
					if (service.equalsIgnoreCase("One room design")) {
						Verification.elementContainsString(price, UtilHBM.getProperty("testData", "IDS1Price"),
								"Price for one room design");
					} else {
						Verification.elementContainsString(price, UtilHBM.getProperty("testData", "IDS4Price"),
								"Price for Multi-room room design");
					}
					Verification.displayOfWebElement(invoice);
					UtilHBM.turnOffImplicitWaits(driver);
					WebElement orderStatus = serviceAvailable.get(i)
							.findElement(By.xpath("following-sibling::div/div/p[1]"));
					UtilHBM.turnOnImplicitWaits(driver);
					BackOffice backoffice = PageFactory.initElements(driver, BackOffice.class);
					backoffice.dates();
					if (orderStatus.getText().contains("Status: in progress")) {
						UtilHBM.reportInfo("Order " + orderStatus.getText());
						WebElement viewMyOrder = serviceAvailable.get(i).findElement(
								By.xpath("following-sibling::div/div[@class=' u-txtRight']/a[@title='View my order']"));
						WebElement estimatedDelivery = serviceAvailable.get(i)
								.findElement(By.xpath("following-sibling::div/div/p[2]"));
						Verification.displayOfWebElement(viewMyOrder);
						Verification.displayOfWebElement(estimatedDelivery);
						Verification.elementContainsString(estimatedDelivery, "Estimated delivery date:",
								"Estimated Delivery Date");
						Verification.elementContainsString(estimatedDelivery, BackOffice.getDeliveryDateIDS(),
								"Estimated Delivery Date");
					} else if (orderStatus.getText().contains("Your order was delivered on")) {
						UtilHBM.reportInfo("Order status :" + orderStatus.getText());
						WebElement viewMyProject = serviceAvailable.get(i).findElement(By
								.xpath("following-sibling::div/div[@class=' u-txtRight']/a[@title='View my project']"));
						Verification.displayOfWebElement(viewMyProject);
						Verification.elementContainsString(orderStatus, BackOffice.getReqstDateIDS(),
								"Order delivered on");
					} else if (orderStatus.getText().contains("Status: pending")) {
						UtilHBM.reportInfo("Order " + orderStatus.getText());
						WebElement operationToBeDone = serviceAvailable.get(i)
								.findElement(By.xpath("following-sibling::div/div/p[2]"));
						WebElement completeMyOrder = serviceAvailable.get(i).findElement(By.xpath(
								"following-sibling::div/div[@class=' u-txtRight']/a[contains(text(),'Complete my order')]"));
						Verification.displayOfWebElement(completeMyOrder);
						Verification.elementContainsString(operationToBeDone, "Your order must be edited",
								"OperationToBeDone");
					} else {
						UtilHBM.reportKO("Incorrect order status OR status not avilable!!");
					}
				}
			} else if (service.equalsIgnoreCase("Home Measurement Service")) {
				BackOffice backoffice = PageFactory.initElements(driver, BackOffice.class);
				backoffice.dates();
				for (int i = 0; i < serviceAvailable.size(); i++) {
					WebElement price = serviceAvailable.get(i).findElement(By.xpath("div[@class=' u-txtRight']/p"));
					WebElement invoice = serviceAvailable.get(i).findElement(By.xpath("div[@class=' u-txtRight']/a"));
					List<WebElement> status = serviceAvailable.get(i)
							.findElements(By.xpath("following-sibling::div/div/p[contains(text(),'Status:')]"));
					WebElement appointment = serviceAvailable.get(i)
							.findElement(By.xpath("following-sibling::div/div/p[contains(text(),'Appointment :')]"));
					WebElement location = serviceAvailable.get(i)
							.findElement(By.xpath("following-sibling::div/div/p[contains(text(),'Location:')]"));
					Verification.displayOfWebElement(price);
					Verification.displayOfWebElement(invoice);
					Verification.displayOfWebElement(appointment);
					Verification.displayOfWebElement(location);
					Verification.elementContainsString(location, UtilHBM.getProperty("testData", "HMS2Address"),
							"Location");
					if (status.isEmpty()) {
						UtilHBM.reportInfo("HMS order creation completed!!");
						WebElement estimatedDelivery = serviceAvailable.get(i).findElement(
								By.xpath("following-sibling::div/div/p[contains(text(),'Estimated delivery time: ')]"));
						Verification.displayOfWebElement(estimatedDelivery);
						Verification.elementContainsString(estimatedDelivery, BackOffice.getDueDateHMS(),
								"Estimated Delivery Date");
					} else if (status.get(0).getText().contains("in the process of creation")) {
						UtilHBM.reportInfo("HMS order " + status.get(0));
						WebElement estimatedDelivery = serviceAvailable.get(i).findElement(
								By.xpath("following-sibling::div/div/p[contains(text(),'Estimated delivery time: ')]"));
						Verification.displayOfWebElement(estimatedDelivery);
						Verification.elementContainsString(estimatedDelivery, BackOffice.getDueDateHMS(),
								"Estimated Delivery Date");
					} else if (status.get(0).getText().contains("scheduled appointment")) {
						UtilHBM.reportInfo("HMS order " + status.get(0));
					} else {
						UtilHBM.reportKO("Incorrect order status!!!");
					}
				}
			} else if (service.equalsIgnoreCase("Floor plan")) {
				int furnished = 0;
				int unfurnished = 0;
				List<WebElement> serviceAvailable1 = driver.findElements(By.xpath(
						"//div[@class='section']/div[@class='wrapper']/div[@class='grid']/div[@class='grid-3-4']/ul[@class='list-dates']/li[@class='purchase']/div[@class='purchase-data u-mtxs']/div[@class='flex flex-bottom status']/div/time[contains(text(),'"
								+ d1 + "')]/preceding-sibling::p[contains(text(),'" + service + "')]"));
				for (int i = 0; i < serviceAvailable1.size(); i++) {
					WebElement price = serviceAvailable1.get(i)
							.findElement(By.xpath("../../div[@class=' u-txtRight']/p"));
					if (serviceAvailable1.get(i).getText().contains(" Furnished")) {
						Verification.elementContainsString(price, UtilHBM.getProperty("testData", "FP1Price"),
								"Price for Furnished FPS");
						furnished++;
					} else if (serviceAvailable1.get(i).getText().contains(" Unfurnished")) {
						Verification.elementContainsString(price, UtilHBM.getProperty("testData", "FP3Price"),
								"Price for Unfurnished FPS");
						unfurnished++;
					}
					WebElement invoice = serviceAvailable1.get(i)
							.findElement(By.xpath("../../div[@class=' u-txtRight']/a"));
					Verification.displayOfWebElement(invoice);
				}
				if (serviceAvailable1.size() == furnished + unfurnished) {
					UtilHBM.reportOK("All furnished and unfurnished FPS displayed!!!");
					UtilHBM.reportInfo("No of Furnished projects : " + furnished);
					UtilHBM.reportInfo("No of Unfurnished projects : " + unfurnished);
				} else {
					UtilHBM.reportKO("All furnished and unfurnished FPS not displayed!!!");
					UtilHBM.reportInfo("No of Furnished projects : " + furnished);
					UtilHBM.reportInfo("No of Unfurnished projects : " + unfurnished);
				}
				UtilHBM.reportInfo(
						"No of Furnished projects : " + furnished + " , No of Unfurnished projects : " + unfurnished);
			}
		}
		return this;
	}

	public MyAccount saveSubscriptionDetails(SignUpData signUpData, int index, String subscriptionType) {
		UtilHBM.waitExplicitDisplayed(driver, subscriptionOfferRenewDate);
		String subscriptionOfferRenewDate1 = subscriptionOfferRenewDate.getText();
		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy");
		DateFormat targetFormat = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(originalFormat.parse(subscriptionOfferRenewDate1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		if (index == 1) {
//			cal.add(Calendar.DAY_OF_MONTH, 1);
//		}
		String email = signUpData.getLoginId();
		String newDateEmail = email.split("@")[0] + "+" + UtilHBM.getDate(0, "ddMMyyyy") + "-" + String.valueOf(index)
				+ "@" + email.split("@")[1];
		String subscriptionToBeCheckedOnDate = targetFormat.format(cal.getTime());
		String subscriptionOfferPurchaseDate1 = UtilHBM.getDate(0, "ddMMyyyy");
		UtilHBM.setProperty("hbmSubscriptionLogs", subscriptionToBeCheckedOnDate + "-" + index,
				"Purchase date-" + subscriptionOfferPurchaseDate1 + ";Expiry date-" + subscriptionOfferPurchaseDate1
						+ ";Subscription type-" + subscriptionType + ";Email-" + newDateEmail);
		return this;
	}

	public MyAccount verifySubscription(String subscriptionStatus) {
		UtilHBM.waitExplicitDisplayed(driver, subscriptionHeader);
		Verification.VerifyEquals("Wrong subscriptionHeader!!", subscriptionHeader.getText(), "Your subscription");
		int invoicesListSize=0;
		if (!subscriptionStatus.equals("")) {
			UtilHBM.waitExplicitDisplayed(driver, subscriptionOffer);
			Verification.VerifyEquals("Wrong Your Invoices Text", yourInvoices.getText(), "Your invoices");
			invoicesListSize= yourInvoicesList.size();
			for (WebElement a : yourInvoicesList) {
				Verification.displayOfWebElement(a.findElement(By.tagName("time")));
				Verification.displayOfWebElement(a.findElement(By.xpath("span[1]")));
				Verification.displayOfWebElement(a.findElement(By.xpath("span[2]")));

				Verification.displayOfWebElement(a.findElement(By.xpath("div/a")));

				UtilHBM.reportInfo("Invoices Status:-Purchased on: " + a.findElement(By.tagName("time")).getText()
						+ ",Subscription: " + a.findElement(By.xpath("span[1]")).getText() + ",Payment :"
						+ a.findElement(By.xpath("span[2]")).getText());
				if (a.findElement(By.xpath("div/a")).getAttribute("href").contains("https://"))
					UtilHBM.reportOK("Download Link Verified");
				else
					UtilHBM.reportOK("Wrong Download Link");
			}
			UtilHBM.reportInfo("Active subscription invoices verified");
		}
		switch (subscriptionStatus) {
		case "Pro monthly":
			Verification.VerifyEquals("Wrong Order Status", subscriptionOffer.getText(), "Pro monthly");
			Verification.elementContainsString(subscriptionOfferRenew,
					"Your subscription will be automatically renewed on", "subscriptionOfferRenew");
			Verification.displayOfWebElement(subscriptionOfferRenewDate);
			Verification.VerifyEquals("Wrong subscriptionBenifitsText", subscriptionBenifitsText.getText(),
					"With your subscription, you benefit from:");
			Verification.VerifyEquals("activeSubscriptionBenefits1 not displayed",
					activeSubscriptionBenefits1.getText(), "Unlimited realistic images");
			Verification.VerifyEquals("activeSubscriptionBenefits2 not displayed",
					activeSubscriptionBenefits2.getText(), "Unlimited projects");
			Verification.VerifyEquals("activeSubscriptionBenefits3 not displayed",
					activeSubscriptionBenefits3.getText(), "Professional usage rights");

			Verification.VerifyEquals("Wrong Edit PAyment information text", editPaymentInfo.getText(),
					"Edit payment information");
			if(invoicesListSize!=1) {
				UtilHBM.reportKO("Incorret number of invoices displayed!!");
			}
			break;

		case "Pro yearly":
			Verification.VerifyEquals("Wrong Order Status", subscriptionOffer.getText(), "Pro yearly");
			Verification.elementContainsString(subscriptionOfferRenew,
					"Your subscription will be automatically renewed on", "subscriptionOfferRenew");
			Verification.displayOfWebElement(subscriptionOfferRenewDate);
			Verification.VerifyEquals("Wrong subscriptionBenifitsText", subscriptionBenifitsText.getText(),
					"With your subscription, you benefit from:");
			Verification.VerifyEquals("activeSubscriptionBenefits1 not displayed",
					activeSubscriptionBenefits1.getText(), "Unlimited realistic images");
			Verification.VerifyEquals("activeSubscriptionBenefits2 not displayed",
					activeSubscriptionBenefits2.getText(), "Unlimited projects");
			Verification.VerifyEquals("activeSubscriptionBenefits3 not displayed",
					activeSubscriptionBenefits3.getText(), "Professional usage rights");
			Verification.VerifyEquals("activeSubscriptionBenefits4 not displayed",
					activeSubscriptionBenefits4.getText(), "10% off on à la carte services");
			Verification.VerifyEquals("activeSubscriptionBenefits5 not displayed",
					activeSubscriptionBenefits5.getText(), "2 months free");
			if(invoicesListSize!=1) {
				UtilHBM.reportKO("Incorret number of invoices displayed!!");
			}
			Verification.VerifyEquals("Wrong Edit Payment information text", editPaymentInfo.getText(),
					"Edit payment information");
			break;

		case "":
			Verification.VerifyEquals("subscriptionText1 is incorrect", subscriptionText.getText(),
					"You currently have no subscription");
			Verification.VerifyEquals("discoverSubscriptionTitle is incorrect", discoverSubscriptionTitle.getText(),
					"Discover our professional subscriptions:");
			Verification.VerifyEquals("monthlySubscribeTitle Not Displayed", monthlySubscribeTitle.getText(),
					"Pro monthly");
			UtilHBM.waitExplicitClickable(driver, monthlySubscribePrice);
			Verification.displayOfWebElement(monthlySubscribePrice);
			Verification.VerifyEquals("monthlySubscribeBenefits1 not displayed", monthlySubscribeBenefits1.getText(),
					"Unlimited realistic imagesNEW");
			Verification.VerifyEquals("monthlySubscribeBenefits2 not displayed", monthlySubscribeBenefits2.getText(),
					"Unlimited projects");
			Verification.VerifyEquals("monthlySubscribeBenefits3 not displayed", monthlySubscribeBenefits3.getText(),
					"Professional usage rights");
			Verification.displayOfWebElement(monthlySubscribe);
			Verification.displayOfWebElement(moreInfoMonthlySubscribe);
			verifyMoreInfoLink("Monthly");
			UtilHBM.waitExplicitDisplayed(driver, yearlySubscribeTitle);
			Verification.VerifyEquals("yearlySubscribeTitle Not Displayed", yearlySubscribeTitle.getText(),
					"Pro yearly");
			UtilHBM.waitExplicitClickable(driver, yearlySubscribePrice);
			Verification.displayOfWebElement(yearlySubscribePrice);
			Verification.VerifyEquals("yearlySubscribeBenefits1 not displayed", yearlySubscribeBenefits1.getText(),
					"Unlimited realistic imagesNEW");
			Verification.VerifyEquals("yearlySubscribeBenefits2 not displayed", yearlySubscribeBenefits2.getText(),
					"Unlimited projects");
			Verification.VerifyEquals("yearlySubscribeBenefits3 not displayed", yearlySubscribeBenefits3.getText(),
					"Professional usage rights");
			Verification.VerifyEquals("yearlySubscribeBenefits4 not displayed", yearlySubscribeBenefits4.getText(),
					"10% off on à la carte services");
			Verification.VerifyEquals("yearlySubscribeBenefits4 not displayed", yearlySubscribeBenefits5.getText(),
					"2 months free");
			Verification.displayOfWebElement(yearlySubscribe);
			Verification.displayOfWebElement(moreInfoYearlySubscribe);
			verifyMoreInfoLink("Monthly");
			break;

		case "Pro yearly-Modified":
			Verification.VerifyEquals("Wrong Order Status", subscriptionOffer.getText(), "Pro yearly");
			Verification.elementContainsString(subscriptionOfferRenew,
					"Your subscription will be automatically renewed on", "subscriptionOfferRenew");
			Verification.displayOfWebElement(subscriptionOfferRenewDate);
			Verification.VerifyEquals("Wrong subscriptionBenifitsText", subscriptionBenifitsText.getText(),
					"With your subscription, you benefit from:");
			Verification.VerifyEquals("activeSubscriptionBenefits1 not displayed",
					activeSubscriptionBenefits1.getText(), "Unlimited realistic images");
			Verification.VerifyEquals("activeSubscriptionBenefits2 not displayed",
					activeSubscriptionBenefits2.getText(), "Unlimited projects");
			Verification.VerifyEquals("activeSubscriptionBenefits3 not displayed",
					activeSubscriptionBenefits3.getText(), "Professional usage rights");
			Verification.VerifyEquals("activeSubscriptionBenefits4 not displayed",
					activeSubscriptionBenefits4.getText(), "10% off on à la carte services");
			Verification.VerifyEquals("activeSubscriptionBenefits5 not displayed",
					activeSubscriptionBenefits5.getText(), "2 months free");
			
			Verification.VerifyEquals("Wrong Edit Payment information text", editPaymentInfo.getText(),
					"Edit payment information");
			if(invoicesListSize!=2) {
				UtilHBM.reportKO("Incorret number of invoices displayed!!");
			}
			break;

		case "Pro monthly-Modified":

			break;
		default:
			UtilHBM.reportKO("Incorrect input for subscription status!!!");
		}
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public MyAccount verifyMoreInfoLink(String monthlyOrYearly) {
		if (monthlyOrYearly.equalsIgnoreCase("monthly")) {
			UtilHBM.waitExplicitClickable(driver, moreInfoMonthlySubscribe);
			moreInfoMonthlySubscribe.click();
		} else if (monthlyOrYearly.equalsIgnoreCase("yearly")) {
			UtilHBM.waitExplicitClickable(driver, moreInfoYearlySubscribe);
			moreInfoYearlySubscribe.click();
		}
		UtilHBM.waitFixTime(1000);
		String pageTitle = driver.getTitle();
		if (pageTitle.trim().equals("A professional service to draw your clients' house projects in 3D")) {
			UtilHBM.reportOK("HomeByMe pro subscription page displayed after clicking more info button!!");
		} else {
			UtilHBM.reportKO("HomeByMe pro subscription page not displayed after clicking more info button!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		driver.navigate().back();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public MyAccount unsubscribe(String activeSubscription) {
		String renewDate = subscriptionRenewDate.getText();
		clickUnsubscribeButton().verifyCancelYourSubscription(activeSubscription, renewDate).clickValidateButton()
				.verifyUnsubscribed(activeSubscription, renewDate);
		return this;
	}

	public MyAccount cancelUnsubscribe() {
		clickCancelUnsubscribeButton().verifyCancelUnsubscribeDialog().cancelUnsubscribeYes();
		return this;
	}
	
	public MyAccount verifyUnsubscribed(String activeSubscription, String renewDate) {
		UtilHBM.waitFixTime(2000);
		driver.navigate().refresh();
		UtilHBM.waitExplicitDisplayed(driver, cancelYourSubscription);
		Verification.VerifyEquals("Wrong subscription details displayed after cancelling subscription!1",
				cancelYourSubscriptionText.getText(),
				"You asked to cancel your " + activeSubscription + " subscription on "
						+ UtilHBM.getDate(0, "MMMM d, yyyy") + ".\nIt will end on " + renewDate + ".");
		UtilHBM.waitExplicitDisplayed(driver, subscriptionOffer);
		Verification.VerifyEquals("Wrong Your Invoices Text", yourInvoices.getText(), "Your invoices");
		for (WebElement a : yourInvoicesList) {
			Verification.displayOfWebElement(a.findElement(By.tagName("time")));
			Verification.displayOfWebElement(a.findElement(By.xpath("span[1]")));
			Verification.displayOfWebElement(a.findElement(By.xpath("span[2]")));
			Verification.displayOfWebElement(a.findElement(By.xpath("div/a")));
			UtilHBM.reportInfo("Invoices Status:-Purchased on: " + a.findElement(By.tagName("time")).getText()
					+ ",Subscription: " + a.findElement(By.xpath("span[1]")).getText() + ",Payment :"
					+ a.findElement(By.xpath("span[2]")).getText());
			if (a.findElement(By.xpath("div/a")).getAttribute("href").contains("https://"))
				UtilHBM.reportOK("Download Link Verified");
			else
				UtilHBM.reportOK("Wrong Download Link");
		}
		UtilHBM.reportInfo("Invoices verified");
		return this;
	}

	public SubscriptionUpdatesDialog clickUnsubscribeButton() {
		UtilHBM.waitExplicitClickable(driver, unsubscribeButton);
		unsubscribeButton.click();
		return PageFactory.initElements(driver, SubscriptionUpdatesDialog.class);
	}

	public SubscriptionUpdatesDialog clickCancelUnsubscribeButton() {
		UtilHBM.waitExplicitDisplayed(driver, cancelUnsubscriptionButton);
		UtilHBM.waitExplicitClickable(driver, cancelUnsubscriptionButton);
		cancelUnsubscriptionButton.click();
		return PageFactory.initElements(driver, SubscriptionUpdatesDialog.class);
	}
	
	public ManageYourSubscriptions clickModifySubscription() {
		UtilHBM.waitExplicitClickable(driver, modifySubscription);
		modifySubscription.click();
		return PageFactory.initElements(driver, ManageYourSubscriptions.class);
	}
	
	public MyAccount clickReloadPage() {
		for (int i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isReloadPageButtonDisplayed = !reloadPageButton.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isReloadPageButtonDisplayed) {
				break;
			} else {
				UtilHBM.waitExplicitClickable(driver, reloadPageButton.get(0));
				reloadPageButton.get(0).click();
				UtilHBM.waitFixTime(500);
			}
		}
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public MyAccount modifySubscription(String activeSubscription) {
		String renewDate = subscriptionRenewDate.getText();
		clickModifySubscription().verifyActiveSubscription(activeSubscription)
				.clickNonActiveSubscribe(activeSubscription).verifySubscriptionUpdates(activeSubscription, renewDate)
				.clickValidateButton().clickReloadPage();
		return this;
	}

	public MyAccount editDescription(String description) {
		UtilHBM.waitExplicitDisplayed(driver, publicProfileHeader);
		descriptionTextArea.clear();
		Verification.VerifyEquals("Wrong placeholder displayed for profile description!!",
				descriptionTextArea.getAttribute("placeholder"),
				"Tell us a little about yourself. Let us discover who you are, what your passions are, why you are using HomeByMe…");
		descriptionTextArea.sendKeys(description);
		return this;
	}

	public UserProfilePage goToMyProfile() {
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProfile);
		myProfile.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
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
	
	public MyAccount verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("My account HomeByMe")) {
			UtilHBM.reportOK("My account page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("My account page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public LandingPage logout(){
		if (userAvatar.isDisplayed()){			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
			UtilHBM.waitFixTime(2000);
			UtilHBM.waitExplicitDisplayed(driver,userAvatar);
			Actions action = new Actions(driver);			
			action.moveToElement(userAvatar).build().perform();
			UtilHBM.waitExplicitClickable(driver, logout);
			logout.click();
//			action.moveToElement(logout).click().build().perform();	
			UtilHBM.reportOK("Logout success");					
			return PageFactory.initElements(driver, LandingPage.class);
		}else {
			UtilHBM.reportKO("Logout failed. User Name is not displayed");
		}					
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
