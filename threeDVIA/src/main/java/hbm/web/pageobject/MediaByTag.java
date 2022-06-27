package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class MediaByTag {
	WebDriver driver;

	public MediaByTag(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "html[class=''] .feed-view>.header-feed>h1")
	private WebElement mediaTagHeader;

	@FindBy(css = "html[class=''] #explore>div>div>.tag.image-related:nth-child(1)")
	private WebElement firstMedia;

	@FindBy(css = "html[class=''] #explore>div>div>.end-of-list")
	private List<WebElement> endOfList;

	@FindBy(css = "html[class=''] #explore>div>div>.end-of-list>a.button")
	private WebElement discoverNewMedia;

	public FeaturedMediaPage verifyMediaByTagPage(String mediaTag) {
		UtilHBM.waitExplicitDisplayed(driver, mediaTagHeader);
		Verification.VerifyEquals("Wrong media tag header displayed!!!", mediaTagHeader.getText(), mediaTag);
		UtilHBM.turnOffImplicitWaits(driver);
		for (int i = 0; i < 1; i++) {
			UtilHBM.webElement(driver, "html[class='']").sendKeys(Keys.END);
			if (!endOfList.isEmpty()) {
				Verification.elementContainsString(endOfList.get(0), "End of the list", "endOfList");
				Verification.displayOfWebElement(discoverNewMedia);
				break;
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver,firstMedia);
		Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector("a:nth-child(1)>img[src$='.jpg']")));
		Actions actions = PageFactory.initElements(driver, Actions.class);
		actions.moveToElement(firstMedia).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, firstMedia.findElement(By.cssSelector(".caption>.like>.item-link>img[src*='like']")));
		if (firstMedia.findElement(By.cssSelector(".caption>a.user>.image-user>.infos-user")).getText().equals("")) {
			UtilHBM.reportKO("User not displayed!!!");
		}
		Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector(".caption>.like>.item-link>img[src*='like']")));
		Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector(".caption>.share.item-link")));
		driver.navigate().back();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
}