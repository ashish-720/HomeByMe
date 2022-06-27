package hbm.web.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class CompleteProfile{
	WebDriver driver;
	
	public CompleteProfile(WebDriver driver){
		this.driver = driver;	
	}
	
	@FindBy(css = "div.modal-header>.modal-title")
	WebElement headerText;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>img.form-image-logo")
	WebElement hbmLogo;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>h3")
	WebElement headerText2;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>div.hbm-checkbox-container")
	List<WebElement> UsageType;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>div.multiple-form-element>input[id='cgs']")
	WebElement serviceConditionsLabel;
	
	@FindBy(xpath = "//div[@class='multiple-form-element']/input[@id='cgs']/following-sibling::label")
	WebElement serviceConditionsText;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>div.multiple-form-element>input[id='newsletter']")
	WebElement newsletterLabel;
	
	@FindBy(xpath = "//div[@class='multiple-form-element']/input[@id='newsletter']/following-sibling::label")
	WebElement newsletterText;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>div.form-button-container>.hbm-button")
	WebElement continueButton;
	
	@FindBy(css = "div#registration>div.form>form>.form-container>div[class='hbm-checkbox-container selected']")
	WebElement selectedUsageType;
	
	@FindBy(xpath = "//div[@class='hbm-checkbox-content']/p[contains(text(),'Professional use')]")
	WebElement professionalUse;
	
	@FindBy(xpath = "//div[@class='hbm-checkbox-content']/p[contains(text(),'Personal use')]")
	WebElement personalUse;
	
	@FindBy(xpath = "//div[@class='form-container']/div[@class='hbm-select-container false undefined']")
	WebElement fieldOfActivity;
	
	@FindBy(xpath = "//div[@class='form-container']/div[@class='hbm-select-option-container']/div")
	List<WebElement> profileOptions;
	
	@FindBy(xpath = "//div[@class='hbm-select-option false'][@value='Other']")
	WebElement otherProfileOption;
	
	@FindBy(xpath = "//input[@class='hbm-input']")
	WebElement otherProfileInput;
	
	@FindBy(xpath = "//input[@type='checkbox'][@data-label='student']")
	WebElement studentCheckbox;
	
	@FindBy(css = "div.form>form>div>div.alert.alert--error-registration")
	WebElement sponsorAlert;
	
	@FindBy(css = "div.form>form>div>div.hbm-optional-input-container>input.hbm-input")
	WebElement sponsorCodeInput;
	
	@FindBy(css = "form>div>div.hbm-optional-input-container")
	WebElement sponsorCodeButton;
	
	public CompleteProfile verifyCompleteProfileDialog() {
		UtilHBM.waitExplicitDisplayed(driver, headerText2);
		Verification.displayNAttributeCheckOfElement(hbmLogo, "HBM logo in complete profile tab", "src","/dist/images/logo-homebyme.095fc252b6a5285faf09ef273cf3d2b0.svg");
		Verification.VerifyEquals("Wrong complete profile header displayed", headerText2.getText(), "Complete your profile");
		Verification.VerifyEquals("Wrong serviceConditionsText", serviceConditionsText.getText(), "* I have read and accept the General service conditions and the Privacy policy");
		Verification.VerifyEquals("Wrong newsletterText", newsletterText.getText(), "I would like to receive the newsletter, updates on new features or HomeByMe promotions");
		Verification.VerifyEquals("Personal use subtitle", personalUse.findElement(By.xpath("following-sibling::p[@class='subtitle']")).getText(), "I have a personal project and I want to find inspiration to furnish and decorate my home in 3D");
		Verification.VerifyEquals("Professional use subtitle", professionalUse.findElement(By.xpath("following-sibling::p[@class='subtitle']")).getText(), "I have a professional project and I want to boost my activity by offering immersive 3D experiences to my clients");
		Verification.VerifyEquals("Incorrect usage type selected by default",selectedUsageType.findElement(By.cssSelector(".hbm-checkbox-content>.title")).getText() , "Personal use");
		selectUsageType("Professional");
		fieldOfActivity.click();
		ArrayList<String> profileOptionsExpected= new ArrayList<String>();
		profileOptionsExpected.add("Interior designer");
		profileOptionsExpected.add("Architect");
		profileOptionsExpected.add("Real estate agent");
		profileOptionsExpected.add("Property Developer");
		profileOptionsExpected.add("Craftsman");
		profileOptionsExpected.add("Prime contractor");
		profileOptionsExpected.add("Other");
		if (!(profileOptionsExpected.size() == profileOptions.size())) {
			UtilHBM.reportKO("All options not displayed while selecting profile!!");
		}
		for (WebElement p : profileOptions) {
			if (profileOptionsExpected.contains(p.getText())) {
				UtilHBM.reportOK(p.getText() + " option displayed while selecting profile!!");
			} else {
				UtilHBM.reportKO(p.getText() + " option not displayed while selecting profile!!");
			}
		}
		otherProfileOption.click();
		Verification.VerifyEquals("Other option not selected", fieldOfActivity.findElement(By.xpath("p[2]")).getText(),"Other");
		studentCheckbox.click();
		selectUsageType("Personal");
		return this;
	}
	
	public UserHomePage clickContinue() {
		UtilHBM.waitExplicitClickable(driver, continueButton);
		continueButton.click();		
		UtilHBM.reportOK("User profile completed.");
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public CompleteProfile clickContinueInvalidSponsorCode() {
		UtilHBM.waitExplicitClickable(driver, continueButton);
		continueButton.click();		
		return PageFactory.initElements(driver, CompleteProfile.class);
	}

	public CompleteProfile selectProfile(String profile) {
		UtilHBM.waitExplicitClickable(driver, fieldOfActivity);
		if (profile.equals("Student")) {
			UtilHBM.waitExplicitClickable(driver, studentCheckbox);
			studentCheckbox.click();
			UtilHBM.reportInfo("Profile selected : "+ profile);
		} else if (!profile.equals("Student")) {
			fieldOfActivity.click();
			WebElement optionToSelect = driver
					.findElement(By.xpath("//div[@class='hbm-select-option false'][@value='" + profile + "']"));
			UtilHBM.waitExplicitClickable(driver, optionToSelect);
			optionToSelect.click();
			UtilHBM.reportInfo("Profile selected : "+ profile);
			Verification.VerifyEquals(profile + "  option not selected",
					fieldOfActivity.findElement(By.xpath("p[2]")).getText(), profile);
		} else {
			UtilHBM.reportInfo("wrong profile input :" + profile);
		}
		return this;
	}
	
	public CompleteProfile selectUsageType(String usageType) {
		
		if (usageType.equalsIgnoreCase("Professional")) {
			professionalUse.findElement(By.xpath("../following-sibling::div[@class='checkbox hbm-checkbox-icon ']"))
					.click();
			UtilHBM.reportInfo("Clicked on " + usageType + " use");
			Verification.VerifyEquals("Professional use not selected",
					selectedUsageType.findElement(By.cssSelector(".hbm-checkbox-content>.title")).getText(),
					"Professional use");

		} else if (usageType.equalsIgnoreCase("Personal")) {
			if (!selectedUsageType.findElement(By.cssSelector(".hbm-checkbox-content>.title")).getText()
					.equals("Personal use")) {
				personalUse.findElement(By.xpath("../following-sibling::div[@class='checkbox hbm-checkbox-icon ']"))
						.click();
				UtilHBM.reportInfo("Clicked on " + usageType + " use");
				Verification.VerifyEquals("Personal use not selected",
						selectedUsageType.findElement(By.cssSelector(".hbm-checkbox-content>.title")).getText(),
						"Personal use");
			}else {
				UtilHBM.reportInfo("Personal use / Individual profile selected by default");;
			}
		} else {
			UtilHBM.reportInfo("Wrong input for usage type");
		}
		return this;
	}

	public UserHomePage completeProfile(String profileType, String rewardCode, boolean isSponsorshipCodeExpected) {
		UtilHBM.waitExplicitDisplayed(driver, headerText2);
		if (profileType.equalsIgnoreCase("Individual")) {
			selectUsageType("Personal");
		} else {
			selectUsageType("Professional").selectProfile(profileType);
		}
		if (isSponsorshipCodeExpected) {
			verifySponsorshipCode();
		} else if (!rewardCode.equals("")) {
			clickSponsorButton().enterSponsorCode(rewardCode);
		}
		clickServiceConditionsLabel().clickNewsletterLabel().clickContinue();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public CompleteProfile clickServiceConditionsLabel() {
		UtilHBM.waitExplicitClickable(driver, serviceConditionsLabel);
		serviceConditionsLabel.click();
		return this;
	}
	
	public CompleteProfile clickNewsletterLabel() {
		UtilHBM.waitExplicitClickable(driver, newsletterLabel);
		newsletterLabel.click();
		return this;
	}

	public CompleteProfile verifySponsorAlert() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorAlert);
		Verification.VerifyEquals(
				"Wrong sponsor alert displayed when more than number of sponsorship per month exceeds!!",
				sponsorAlert.getText(),
				"This sponsor code has already been used 6 times this month. Please try again next month!");
		UtilHBM.waitTillElementDisappear(driver, sponsorAlert);
		return this;
	}
	
	
	public CompleteProfile clickSponsorButton() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorCodeButton);
		Verification.VerifyEquals("Wrong sponsorCodeButton text",
				sponsorCodeButton.findElement(By.tagName("p")).getText(), "Do you have a friendship code?");
		UtilHBM.waitExplicitClickable(driver, sponsorCodeButton.findElement(By.cssSelector("div.hbm-plus-icon")));
		sponsorCodeButton.findElement(By.cssSelector("div.hbm-plus-icon")).click();
		return this;
	}

	public CompleteProfile enterSponsorCode(String rewardCode) {
		UtilHBM.waitExplicitDisplayed(driver, sponsorCodeInput);
		UtilHBM.waitExplicitClickable(driver, sponsorCodeInput);
		sponsorCodeInput.sendKeys(rewardCode);
		return this;
	}

	public CompleteProfile verifySponsorshipCode() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorCodeInput);
		String sponsorshipCodeDisplayed = sponsorCodeInput.getAttribute("value");
		String sponsorshipCodeExpected = UtilHBM.getProperty("testData", "rewardCode");
		if (sponsorshipCodeDisplayed.equals(sponsorshipCodeExpected)) {
			UtilHBM.reportOK("Correct sponsorship code displayed in complete profile page!!");
		} else {
			UtilHBM.reportKO("Incorrect sponsorship code displayed in complete profile page!!Expected : "
					+ sponsorshipCodeExpected + " , Displayed : " + sponsorshipCodeDisplayed);
		}
		return this;
	}

	public CompleteProfile clearSponsorCode() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorCodeInput);
		String sponsorshipCodeBefore = sponsorCodeInput.getAttribute("value");
		UtilHBM.reportInfo("Sponsorship code displayed : " + sponsorshipCodeBefore);
//		sponsorCodeInput.clear();
		for(int i=0;i<8;i++) {
		sponsorCodeInput.sendKeys(Keys.BACK_SPACE);
		}
		String sponsorshipCodeAfter = sponsorCodeInput.getAttribute("value");
		if (!sponsorshipCodeAfter.equals("")) {
			UtilHBM.reportKO("Sponsorship code not cleared!! Sponsor code displayed : " + sponsorshipCodeAfter);
		}
		return this;
	}

	public UserHomePage completeProfileMDM() {
		serviceConditionsLabel.click();
		newsletterLabel.click();
		UtilHBM.waitExplicitClickable(driver, continueButton);
		continueButton.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.reportOK("User profile completed.");
		return PageFactory.initElements(driver, UserHomePage.class);
	}
}