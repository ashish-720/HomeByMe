package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class SponsorshipDialog {

	WebDriver driver;

	public SponsorshipDialog(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div>h2")
	private WebElement sponsorshipDialogHeader;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div>div.modal-close.button-close")
	private WebElement sponsorshipDialogCloseButton;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(1)>span")
	private WebElement forYouHeader;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(1)>div>div.sponsorship-perk-number>span")
	private WebElement forYouHQImgNumber;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(1)>div>div.sponsorship-perk-text>h3")
	private WebElement forYouFreeHQImgs;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(1)>div>div.sponsorship-perk-text>p")
	private WebElement forYouText1;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(1)>p")
	private WebElement forYouText2;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(2)>span")
	private WebElement forYourFriendsHeader;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(2)>div>div.sponsorship-perk-number>span")
	private WebElement forYourFriendsHQImgNumber;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-perks>div:nth-child(2)>div>div.sponsorship-perk-text>h3")
	private WebElement forYourFriendsFreeHQImgs;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-info>p")
	private WebElement sponsorshipEmailText;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>form.sponsorship-form>button>span")
	private WebElement addAnEmail;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>form.sponsorship-form>div>div>input")
	private WebElement emailInput;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>form.sponsorship-form>div.sponsorship-footer-actions>button[disabled]")
	private WebElement sendMyCodeDisabled;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>form.sponsorship-form>div.sponsorship-footer-actions>button")
	private WebElement sendMyCodeActive;

	@FindBy(css = "div.ReactModalPortal>div.ReactModal__Overlay.ReactModal__Overlay--after-open>div>div.modal-content>div.sponsorship-info>p>span")
	private WebElement friendshipCode;

	public SponsorshipDialog updateFriendshipCode() {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, friendshipCode);
		UtilHBM.reportInfo("Updating Friendship reward code : " + friendshipCode.getText());
		UtilHBM.setProperty("testData", "rewardCode", friendshipCode.getText());
		return this;
	}
	
	public MyAccount sendSponsorshipCode(String userEmailId) {
		UtilHBM.waitExplicitDisplayed(driver, sponsorshipDialogHeader);
		Verification.displayOfWebElement(sendMyCodeDisabled);
		UtilHBM.waitExplicitClickable(driver, addAnEmail);
		UtilHBM.waitExplicitDisplayed(driver, emailInput);
		emailInput.sendKeys(userEmailId);
		UtilHBM.waitExplicitClickable(driver, sendMyCodeActive);
		sendMyCodeActive.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public MyAccount closeSponsorshipDialogMyAccount() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorshipDialogCloseButton);
		UtilHBM.waitExplicitClickable(driver, sponsorshipDialogCloseButton);
		sponsorshipDialogCloseButton.click();
		return PageFactory.initElements(driver, MyAccount.class);
	}

	public ProjectPage closeSponsorshipDialogProjectPAge() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorshipDialogCloseButton);
		UtilHBM.waitExplicitClickable(driver, sponsorshipDialogCloseButton);
		sponsorshipDialogCloseButton.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public SponsorshipDialog verifySponsorshipDialog() {
		UtilHBM.waitExplicitDisplayed(driver, sponsorshipDialogHeader);
		Verification.VerifyEquals("Wrong sponsorshipDialogHeader", sponsorshipDialogHeader.getText(),
				"Recommend HomeByMe to your friends");
		Verification.VerifyEquals("Wrong forYouHeader", forYouHeader.getText(), "For you");
		Verification.VerifyEquals("Wrong forYouHQImgNumber", forYouHQImgNumber.getText(), "10");
		Verification.VerifyEquals("Wrong forYouFreeHQImgs", forYouFreeHQImgs.getText(), "Free realistic images");
		Verification.VerifyEquals("Wrong forYouText1", forYouText1.getText(), "for each friend who signs up.");
		Verification.VerifyEquals("Wrong forYouText2", forYouText2.getText(), "limited to 6 sponsorships/month");
		Verification.VerifyEquals("Wrong forYourFriendsHeader", forYourFriendsHeader.getText(), "For your friends");
		Verification.VerifyEquals("Wrong forYourFriendsHQImgNumber", forYourFriendsHQImgNumber.getText(), "3");
		Verification.VerifyEquals("Wrong forYourFriendsFreeHQImgs", forYourFriendsFreeHQImgs.getText(),
				"Free realistic images");
		Verification.elementContainsString(sponsorshipEmailText,
				"Enter your friends' email addresses to send them your sponsorship code", "Wrong sponsorshipEmailText");
		String friendshipCode1 = friendshipCode.getText();
		if (friendshipCode1.equals("")) {
			UtilHBM.reportKO("Empty friendshipCode displayed!!");
		}
		UtilHBM.reportInfo("Sponsorship code displayed : " + friendshipCode1);
		Verification.displayOfWebElement(addAnEmail);
		Verification.displayOfWebElement(sendMyCodeDisabled);
		UtilHBM.waitExplicitDisplayed(driver, emailInput);
		emailInput.sendKeys("example@example.com");
		Verification.displayOfWebElement(sendMyCodeActive);
		return this;
	}

}
