package hbm.web.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BuyAdditionalProjectsWhenExhausted1 {

	private WebDriver driver;

	public BuyAdditionalProjectsWhenExhausted1(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.ReactModal__Content.ReactModal__Content--after-open.pg-modal>div>div>div>h2")
	private WebElement exhastedItemtDialogTitle;

	@FindBy(css = "div.ReactModal__Content.ReactModal__Content--after-open.pg-modal>div>div>div>strong>a")
	private WebElement openBuyAdditionalItemsDialogLink;
	
	@FindBy(css = ".offer-modal-content>div>section>article>p")
	private WebElement exhastedItemDialogText;

	@FindBy(css = "div.ReactModal__Content.ReactModal__Content--after-open.pg-modal>div>div>div>h2>strong>a")
	private WebElement AdditionalProjectLink;

	@FindBy(css = ".offer-modal-content section>article>[href*='pricing_products_realistic_images']")
	private WebElement RealisticImageLink;

	@FindBy(css = ".offer-modal-content section>article>[href*='pricing_products_panoramic_images']")
	private WebElement image360Link;

	@FindBy(css = ".offer-modal-content>div>form>ul>li.u-txtRight>[title='Buy']")
	private WebElement buyButton;

	@FindBy(css = ".offer-modal-content>.panoramic-offer>div>footer>.button.button--l[title='Buy']")
	private WebElement buy360Button;

	@FindBy(xpath = "//form/ul/li/input[@checked]/following-sibling::label/span[@class='label']")
	private WebElement selectedPack;
	
	@FindBy(xpath = "//*[@class='offer-modal-content']/div/section/aside/span[2]")
	private WebElement subscriptionPriceText;

	public Payment buyAdditionalProjectsWhenExhausted1(int packOf2or10or50) {
		UtilHBM.waitExplicitDisplayed(driver, exhastedItemtDialogTitle);
		Verification.VerifyEquals("Wrong header for No remaining projects dialog box",
				exhastedItemtDialogTitle.getText(), "Unlimited projects");
		UtilHBM.waitExplicitDisplayed(driver, openBuyAdditionalItemsDialogLink);
		Verification.VerifyEquals("Wrong header for No remaining projects dialog box",
				openBuyAdditionalItemsDialogLink.getText(), "Just want some additional projects?");
		UtilHBM.waitExplicitClickable(driver, openBuyAdditionalItemsDialogLink);
		openBuyAdditionalItemsDialogLink.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, buyButton);
		Verification.VerifyEquals("Wrong header for No remaining projects dialog box",
				exhastedItemtDialogTitle.getText(), "Additional projects");
		Verification.VerifyEquals("exhastedProjectDialogText not correct", exhastedItemDialogText.getText().trim(),
				"You have used all available project spaces in your account. You can delete a project to make room for a new project or buy a pack to increase your project limit!");
		Verification.displayOfWebElement(AdditionalProjectLink);
		Verification.VerifyEquals("Pack of 2 not selected initially!!!", selectedPack.getText(), "Pack of 2");
		WebElement expectedPack = driver.findElement(
				By.xpath("//form/ul/li[not(@class='u-txtRight')]/label/span[@class='label'][normalize-space()='Pack of "
						+ packOf2or10or50 + "']/../.."));
		expectedPack.click();
		UtilHBM.reportInfo("Pack of " + packOf2or10or50 + " selected!!!");
		UtilHBM.waitExplicitDisplayed(driver,  driver.findElement(By.xpath(
				"//*[@class='offer-modal-content']/div/section/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='additional-projects-"
						+ packOf2or10or50 + "']")));
		WebElement spanPrice = driver.findElement(By.xpath(
				"//*[@class='offer-modal-content']/div/section/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='additional-projects-"
						+ packOf2or10or50 + "']"));
		UtilHBM.reportInfo("Price displayed for Pack of " + packOf2or10or50 + " : " + spanPrice.getText());
		String priceDisplayed = spanPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCartePrice", priceDisplayed);
		buyButton.click();
		return PageFactory.initElements(driver, Payment.class);
	}

	public Payment buyAdditionalRealisticImages(int packOf2or10or50) {
		UtilHBM.waitExplicitDisplayed(driver, exhastedItemtDialogTitle);
		UtilHBM.waitExplicitDisplayed(driver, buyButton);
		Verification.VerifyEquals("Wrong header for No remaining realistic image dialog box",
				exhastedItemtDialogTitle.getText(), "Additional realistic images");
		Verification.VerifyEquals("exhastedItemDialogText not correct", exhastedItemDialogText.getText().trim(),
				"You have used all the realistic images available in your offer. Choose a new pack to continue your creations!");
		Verification.displayOfWebElement(RealisticImageLink);
		WebElement expectedPack = driver.findElement(
				By.xpath("//form/ul/li[not(@class='u-txtRight')]/label/span[@class='label'][normalize-space()='Pack of "
						+ packOf2or10or50 + "']/../.."));
		expectedPack.click();
		UtilHBM.reportInfo("Pack of " + packOf2or10or50 + " selected!!!");
		WebElement spanPrice = driver.findElement(By.xpath(
				"//*[@class='offer-modal-content']/div/section/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='realistic-renderings-"
						+ packOf2or10or50 + "']"));
		UtilHBM.waitExplicitDisplayed(driver, spanPrice);
		UtilHBM.reportInfo("Price displayed for Pack of " + packOf2or10or50 + " : " + spanPrice.getText());
		String priceDisplayed = spanPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCartePrice", priceDisplayed);
		buyButton.click();
		return PageFactory.initElements(driver, Payment.class);
	}

	public Payment buyAdditional360Images(int packOf1or2or10) {
		UtilHBM.waitExplicitDisplayed(driver, exhastedItemtDialogTitle);
		UtilHBM.waitExplicitDisplayed(driver, buyButton);
		Verification.VerifyEquals("Wrong header for No remaining realistic image dialog box",
				exhastedItemtDialogTitle.getText(), "360° Images");
		Verification.VerifyEquals("exhastedItemDialogText not correct", exhastedItemDialogText.getText().trim(),
				"You have used all your 360° images. Choose a new pack to discover your project from all angles.");
		Verification.displayOfWebElement(RealisticImageLink);
		Verification.VerifyEquals("Pack of 1 not selected initially!!!", selectedPack.getText(), "Pack of 1");
		WebElement expectedPack = driver.findElement(
				By.xpath("//form/ul/li[not(@class='u-txtRight')]/label/span[@class='label'][normalize-space()='Pack of "
						+ packOf1or2or10 + "']/../.."));
		expectedPack.click();
		UtilHBM.reportInfo("Pack of " + packOf1or2or10 + " selected!!!");
		WebElement spanPrice = driver.findElement(By.xpath(
				"//*[@class='offer-modal-content']/article/div/footer/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='360-renderings-"
						+ packOf1or2or10 + "']"));
		UtilHBM.waitExplicitDisplayed(driver, spanPrice);
		UtilHBM.reportInfo("Price displayed for Pack of " + packOf1or2or10 + " : " + spanPrice.getText());
		String priceDisplayed = spanPrice.getText().substring(1);
		UtilHBM.setProperty("testData", "LaCartePrice", priceDisplayed);
		buyButton.click();
		return PageFactory.initElements(driver, Payment.class);
	}
	
	public BuyAdditionalProjectsWhenExhausted1 buySubscription(String subscriptionType) {
		UtilHBM.waitExplicitDisplayed(driver, exhastedItemtDialogTitle);
		UtilHBM.waitExplicitDisplayed(driver, buyButton);
		Verification.VerifyEquals("Wrong header for No remaining projects dialog box",
				exhastedItemtDialogTitle.getText(), "Unlimited projects");
		Verification.VerifyEquals("exhastedProjectDialogText not correct", exhastedItemDialogText.getText().trim(),
				"You have used all available project spaces in your account.  Upgrade to a Pro Subscription and get unlimited project space. No contracts required, cancel at any time!”");
		UtilHBM.waitExplicitDisplayed(driver, openBuyAdditionalItemsDialogLink);
		Verification.VerifyEquals("Wrong header for No remaining projects dialog box",
				openBuyAdditionalItemsDialogLink.getText(), "Just want some additional projects?");
		Verification.VerifyEquals("Pro monthly pack not selected initially!!!", selectedPack.getText(), "Pro monthly");
		WebElement expectedPack = driver.findElement(
				By.xpath("//form/ul/li[not(@class='u-txtRight')]/label/span[@class='label'][normalize-space()='"
						+ subscriptionType + "']/../.."));
		expectedPack.click();
		UtilHBM.reportInfo(subscriptionType + " pack selected!!!");
		UtilHBM.waitExplicitDisplayed(driver,subscriptionPriceText);
		WebElement spanPrice = null;
		if (subscriptionType.equals("Pro monthly")) {
			Verification.VerifyEquals("Wrong subscriptionPriceText", subscriptionPriceText.getText(), " / month");
			spanPrice = driver.findElement(By.xpath(
					"//*[@class='offer-modal-content']/div/section/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='pro-monthly']"));
		} else if (subscriptionType.equals("Pro yearly")) {
			Verification.VerifyEquals("Wrong subscriptionPriceText", subscriptionPriceText.getText(), " / year");
			spanPrice = driver.findElement(By.xpath(
					"//*[@class='offer-modal-content']/div/section/aside/span[@class='price'][contains(text(),'.')][@data-fsc-item-path='pro-yearly']"));
		}
		UtilHBM.waitExplicitDisplayed(driver, spanPrice);
		UtilHBM.reportInfo("Price displayed for " + subscriptionType + " pack : " + spanPrice.getText());
		String priceDisplayed = spanPrice.getText().substring(3);
		UtilHBM.setProperty("testData", "LaCarte2Price", priceDisplayed);
		UtilHBM.waitExplicitDisplayed(driver, buyButton);
		Verification.VerifyEquals("Wrong button text displayed!!", buyButton.getText(), "Subscribe");
		buyButton.click();
		return this;
	}

	public void closeBuyAdditionalItemsDialog() {
		UtilHBM.waitFixTime(1000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		driver.findElement(By.cssSelector(".modal-close.button-close")).click();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")));
	}
}
