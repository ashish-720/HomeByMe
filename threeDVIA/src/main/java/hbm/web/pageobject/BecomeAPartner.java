package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BecomeAPartner {
	WebDriver driver;

	public BecomeAPartner(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "/html/body/main/div[1]/div/div/div/div/div[1]/div/a/span")
	WebElement becomeAPartner;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/iframe")
	WebElement partnerFormIframe;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div/section/div[1]/div/div/div/div/div[1]/picture")
	WebElement hbmLogoImg;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div/section/div[1]/div/div/div/div/div[2]/div/h1/span")
	WebElement partnerText1;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div/section/div[1]/div/div/div/div/div[2]/div/p")
	WebElement partnerText2;

	@FindBy(xpath = "//button[@class='ButtonWrapper-sc-__sc-1qu8p4z-0 IxArD']")
	WebElement startButton;
	
	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[1]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement titleText;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[1]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement titleInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[1]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement titleOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement fullName;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement fullNameInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement fullNameOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement position;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement positionInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement positionOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement company;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement companyInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement companyOK;

	@FindBy(xpath ="/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement emailAddress;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement emailAddressInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement emailAddressOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[1]/div[1]/div[2]/span/span")
	WebElement phone;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[2]/div[1]/input")
	WebElement phoneInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[2]/div[2]/div/div/div/div/div/button")
	WebElement phoneOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement country;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[2]/div[1]/div/button")
	WebElement countryDropDownButton;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[2]/div[1]/div/div/div/div/div/div[1]/div/input")
	WebElement searchCountry;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/fieldset/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/div/div/div/span/../..")
	WebElement countryFrance;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/input")
	WebElement countryInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/button")
	WebElement countryOK;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[3]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/label/span")
	WebElement more;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[3]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div[1]/div/textarea")
	WebElement moreInput;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[3]/div[3]/div/div/div/div[2]/section/div/div/div/div/div/div/div/div/div[2]/div[3]/div/div/div/div/div[1]/div/div/button")
	WebElement submit;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div/section/div[1]/div/div/div/div/div[1]/picture")
	WebElement hbmLogoSubmitted;

	@FindBy(xpath = "/html/body/div[3]/main/div[1]/div/div[2]/div/section/div[1]/div/div/div/div/div[2]/div/h1")
	WebElement submittedText1;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/img")
	WebElement closePartnerForm;

	public BecomeAPartner partnerForm() {
		UtilHBM.waitExplicitDisplayed(driver, partnerFormIframe);
		driver.switchTo().frame(partnerFormIframe);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, hbmLogoImg);
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(hbmLogoImg);
		Verification.VerifyEquals("Wrong partnerText1", partnerText1.getText(),
				"Expose your products to customers ready to buy");
		Verification.VerifyEquals("Wrong partnerText2", partnerText2.getText(),
				"Thanks for your interest.\nPlease fill-in this short form so that we can get to know you better.");
//		UtilHBM.waitFixTime(5000);
		UtilHBM.waitExplicitDisplayed(driver, startButton);
		UtilHBM.waitExplicitClickable(driver, startButton);
		startButton.click();
//		partnerText2.sendKeys(Keys.ENTER);
		UtilHBM.waitExplicitDisplayed(driver, titleText);
		Verification.VerifyEquals("Wrong titleText", titleText.getText(), "Title");
		titleInput.sendKeys("Partner Form Test");
		titleOK.click();
		UtilHBM.waitExplicitDisplayed(driver, fullName);
		Verification.VerifyEquals("Wrong fullNameText", fullName.getText(), "Full name");
		fullNameInput.sendKeys("Full Name");
		fullNameOK.click();
		UtilHBM.waitExplicitDisplayed(driver, position);
		Verification.VerifyEquals("Wrong positionText", position.getText(), "Position");
		positionInput.sendKeys("3DVIA QA");
		positionOK.click();
		UtilHBM.waitExplicitDisplayed(driver, company);
		Verification.VerifyEquals("Wrong companyText", company.getText(), "Company");
		companyInput.sendKeys("3DPLM");
		companyOK.click();
		UtilHBM.waitExplicitDisplayed(driver, emailAddress);
		Verification.VerifyEquals("Wrong emailAddressText", emailAddress.getText(), "Email address");
		emailAddressInput.sendKeys("email@email.com");
		emailAddressOK.click();
		UtilHBM.waitExplicitDisplayed(driver, phone);
		Verification.VerifyEquals("Wrong phoneText", phone.getText(), "Phone number");
		UtilHBM.waitExplicitClickable(driver, countryDropDownButton);
		countryDropDownButton.click();
		UtilHBM.waitExplicitDisplayed(driver, searchCountry);
		searchCountry.sendKeys("France");
		countryFrance.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, phoneInput);
		phoneInput.sendKeys("+33111000011");
		phoneOK.click();
		UtilHBM.waitExplicitDisplayed(driver, country);
		Verification.VerifyEquals("Wrong countryText", country.getText(), "Country");
		countryInput.sendKeys("France");
		countryOK.click();
		UtilHBM.waitExplicitDisplayed(driver, more);
		Verification.VerifyEquals("Wrong moreText", more.getText(), "Tell us more about what you’re looking for");
		moreInput.sendKeys("Testing Partner Form");
		Verification.displayOfWebElement(submit);
		UtilHBM.reportInfo("Closing partner form");
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, closePartnerForm);
		UtilHBM.waitExplicitClickable(driver, closePartnerForm);
		UtilHBM.reportOK("Partner form tested  OK");
		return PageFactory.initElements(driver, BecomeAPartner.class);
	}

	public BecomeAPartner clickBecomeAPartner() {
		UtilHBM.waitExplicitDisplayed(driver, becomeAPartner);
		UtilHBM.waitExplicitClickable(driver, becomeAPartner);
		becomeAPartner.click();
		return PageFactory.initElements(driver, BecomeAPartner.class);
	}

}
