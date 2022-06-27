package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Share {
	WebDriver driver;

	public Share(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-popin-share-medium mod-open']")
	private WebElement sharePopIn;

	@FindBy(xpath = "//div[@class='wrap']/div[@class='media']")
	private WebElement shareMedia;

	@FindBy(xpath = "//div[@class='header-actions']/button[@class='bt-icon-alt']")
	private WebElement closeShare;

	@FindBy(xpath = "//article[@class='mod-popin-share-medium mod-open']/div/div/h3")
	private WebElement shareTitle;

	@FindBy(xpath = "//button[@class='bt-icon-label.mod-tooltip']/span[@class='icon-share-facebook']")
	private WebElement iconFacebook;

	@FindBy(xpath = "//button[@class='bt-icon-label.mod-tooltip']/span[@class='icon-share-twitter']")
	private WebElement iconTwitter;

	@FindBy(xpath = "//button[@class='bt-icon-label.mod-tooltip']/span[@class='icon-share-pinterest']")
	private WebElement iconPinterest;

	@FindBy(xpath = "//button[@class='bt-icon-label.mod-tooltip']/span[@class='icon-share-mail']")
	private WebElement iconEmail;

	@FindBy(xpath = "//input[@id='share-input']")
	private WebElement shareInput;
	
	@FindBy(xpath = "//button[@data-ui-action='copy-link']")
	private WebElement copyLink;
	
	public Share verifyShare() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://preprod-widgets.enterprise-dev.by.me/ShareView/embed.html']")));
		UtilHBM.waitExplicitDisplayed(driver, sharePopIn);
		UtilHBM.waitExplicitDisplayed(driver, shareTitle);
		UtilHBM.waitFixTime(500);
		if((shareMedia.findElement(By.xpath("img")).getAttribute("src").startsWith("data:image/jpeg"))||
				(shareMedia.findElement(By.xpath("img")).getAttribute("src").startsWith("https://byme-enterprise-preprod"))) {
		UtilHBM.waitExplicitDisplayed(driver, shareMedia);
		Verification.displayOfWebElement(shareMedia);
		UtilHBM.reportOK("Image available and image src is :" +shareMedia.findElement(By.xpath("img")).getAttribute("src"));
		}
		Verification.displayOfWebElement(closeShare);
		Verification.VerifyEquals("Share your project text not displayed", shareTitle.getText(), "Share your project");
//		Verification.displayOfWebElement(iconFacebook);
//		Verification.VerifyEquals("Facebook text not displayed",
//				iconFacebook.findElement(By.xpath("following-sibling::span")).getText(), "Facebook");
//		Verification.displayOfWebElement(iconFacebook);
//		Verification.VerifyEquals("Twitter text not displayed",
//				iconTwitter.findElement(By.xpath("following-sibling::span")).getText(), "Twitter");
//		Verification.displayOfWebElement(iconFacebook);
//		Verification.VerifyEquals("Pinterest text not displayed",
//				iconPinterest.findElement(By.xpath("following-sibling::span")).getText(), "Pinterest");
//		Verification.displayOfWebElement(iconFacebook);
//		Verification.VerifyEquals("Email text not displayed",
//				iconEmail.findElement(By.xpath("following-sibling::span")).getText(), "Email");
		Verification.displayOfWebElement(shareInput);
		Verification.displayOfWebElement(copyLink);
		return PageFactory.initElements(driver, Share.class);
	}
}
