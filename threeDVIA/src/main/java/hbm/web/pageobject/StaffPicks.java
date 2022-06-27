package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class StaffPicks {
	WebDriver driver;

	public StaffPicks(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(css = "span.header__nav__item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;

	@CacheLookup
	@FindBy(css = "span.header__nav__item.header__nav__account.dropdown.is-open>.dropdown__content>div>a[title='Logout']")
	private WebElement logout;

	@FindBy(css = "div.feed-view>div.header-feed.flex-middle.flex-spaceBetween>h1")
	WebElement headerTitle;

	@FindBy(xpath = "//*[@id='staff-pick']/div/div/div[@class='tag image-related']")
	private List<WebElement> mediaList;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;

	public StaffPicks verifyStaffPicksPage(boolean isMediaExpected) {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		Verification.VerifyEquals("Wrong staff picks page header displayed!!", headerTitle.getText(),
				"Staff Pick - image list");
		if (isMediaExpected) {
			if (mediaList.isEmpty()) {
				UtilHBM.reportKO("No media displayed in staff picks!! , isMediaExpected : " + isMediaExpected);
//				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
//						"You haven't created any images yet");
			} else {
				UtilHBM.reportOK("Medias displayed in staff picks!! , isMediaExpected : " + isMediaExpected);
				int limit = 2;
				if (mediaList.size() <= limit) {
					limit = mediaList.size();
				} else {
					UtilHBM.reportInfo("More than 2 images displayed in user profile page!!Verifying first " + limit
							+ " from the list : ");
				}
				UtilHBM.waitFixTime(1000);
				UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
				UtilHBM.reportInfo("Verifying first " + limit + " images displayed in my pictures!!");
				for (int i = 0; i < limit; i++) {
					WebElement imageExpected = mediaList.get(i);
					Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
					String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
					if (!imgSrc.contains("https://")) {
						UtilHBM.reportKO("Image not displayed!!");
					}
					Actions actions = new Actions(driver);
					actions.moveToElement(imageExpected).build().perform();
					WebElement addToCollectionText = imageExpected
							.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to favorites')]"));
					List<WebElement> noOfProductsText = imageExpected
							.findElements(By.xpath("div/div[@class='caption-footer']/div"));
					WebElement addToStaffPicksIcon = imageExpected
							.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img"));
					String addToStaffPicksIconAttribute = addToStaffPicksIcon.getAttribute("src");
					if (addToStaffPicksIconAttribute.contains("quality-focus1")) {
						UtilHBM.reportOK("Selected staff picks icon displayed!!");
					} else {
						UtilHBM.reportKO("Selected staff picks icon not displayed");
					}
					if (noOfProductsText.isEmpty()) {
						UtilHBM.reportInfo("No products available in image!!");
					} else {
						int noOfProducts = Integer.parseInt(noOfProductsText.get(0).getText().split(" ")[0]);
						Verification.elementContainsString(noOfProductsText.get(0), "products", "noOfProductsText");
						UtilHBM.reportInfo(noOfProducts + " products are available in image!!");
					}
					WebElement userProfileLink = imageExpected.findElement(
							By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
					WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
					Verification.displayOfWebElement(addToCollectionText);
					Verification.displayOfWebElement(userProfileLink);
					Verification.displayOfWebElement(bookmark);
				}
				Actions action1 = new Actions(driver);
				action1.moveToElement(headerTitle).build().perform();
				String userName = mediaList.get(0)
						.findElement(By.xpath(
								"div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div/div/span"))
						.getText();
				openImageAtIndex(0).verifyMediaPage(userName, "", "No", "All;All rooms;NA;NA;NA").goToGallery();
			}
		} else {
			if (mediaList.isEmpty()) {
				UtilHBM.reportOK("No media displayed in staff picks!! , isMediaExpected : " + isMediaExpected);
//				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
//						"You haven't created any images yet");
			} else {
				UtilHBM.reportKO("Medias displayed in staff picks!! , isMediaExpected : " + isMediaExpected);
			}
		}
		return this;
	}
	
	public StaffPicks verifyImageAddedToStaffPick() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		boolean isImageAvailableInStaffPicks = false;
		String imgAttribute = UtilHBM.getProperty("testData", "ImgAddedToStaffPick");
		UtilHBM.waitFixTime(1000);
		int limit = 20;
		for (int i = 0; i < limit; i++) {
			WebElement imageExpected = mediaList.get(i);
			Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
			String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
			if (imgSrc.contains(imgAttribute)) {
				isImageAvailableInStaffPicks = true;
				Actions actions = new Actions(driver);
				actions.moveToElement(imageExpected).build().perform();
				UtilHBM.waitFixTime(1000);
				UtilHBM.waitExplicitDisplayed(driver,
						imageExpected.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img")));
				WebElement addToStaffPicksIcon = imageExpected
						.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img"));
				String addToStaffPicksIconAttribute = addToStaffPicksIcon.getAttribute("src");
				if (addToStaffPicksIconAttribute.contains("quality-focus1")) {
					UtilHBM.reportOK("Image added sucessfully in staff picks");
					WebElement addToCollectionText = imageExpected
							.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to favorites')]"));
					List<WebElement> noOfProductsText = imageExpected
							.findElements(By.xpath("div/div[@class='caption-footer']/div"));
					if (noOfProductsText.isEmpty()) {
						UtilHBM.reportInfo("No products available in image!!");
					} else {
						int noOfProducts = Integer.parseInt(noOfProductsText.get(0).getText().split(" ")[0]);
						Verification.elementContainsString(noOfProductsText.get(0), "products", "noOfProductsText");
						UtilHBM.reportInfo(noOfProducts + " products are available in image!!");
					}
					WebElement userProfileLink = imageExpected.findElement(
							By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
					WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
					Verification.displayOfWebElement(addToCollectionText);
					Verification.displayOfWebElement(userProfileLink);
					Verification.displayOfWebElement(bookmark);
					openMediaPage(imageExpected).verifyMediaDisplayed();
					driver.navigate().back();
					break;
				} else {
					UtilHBM.reportKO("Staff picks icon is not selected for image added in staff pick page!!");
				}
			}
		}
		if (!isImageAvailableInStaffPicks) {
			UtilHBM.reportKO("Image added in staff picks not displayed in first " + limit + " images!!");
		}
		return this;
	}
	
	public StaffPicks removeFrmStaffPick() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		for (int i = 0; i < 6; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(500);
		}
		String imgAttribute = UtilHBM.getProperty("testData", "ImgAddedToStaffPick");
		List<WebElement> expectedImage = driver.findElements(
				By.xpath("//*[@id='staff-pick']/div/div/div[@class='tag image-related']/div/a/img[contains(@src,'"
						+ imgAttribute + "')]"));
		if (!expectedImage.isEmpty()) {
			UtilHBM.reportOK(
					"Images found in staff pick page!! , Img Src : " + expectedImage.get(0).getAttribute("src"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(expectedImage.get(0)).build().perform();
			UtilHBM.waitFixTime(1000);
			WebElement addToStaffPicksIcon = expectedImage.get(0)
					.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img"));
			String addToStaffPicksIconAttribute = addToStaffPicksIcon.getAttribute("src");
			if (addToStaffPicksIconAttribute.contains("quality-focus1")) {
				UtilHBM.reportOK("Selected staff picks icon displayed for image added in staff picks!!");
			} else {
				UtilHBM.reportKO("Selected staff picks icon not displayed for image added in staff picks!!");
			}
			UtilHBM.waitExplicitClickable(driver, addToStaffPicksIcon);
			addToStaffPicksIcon.click();
			String addToStaffPicksIconAttribute1 = addToStaffPicksIcon.getAttribute("src");
			if (addToStaffPicksIconAttribute1.contains("quality-focus1")) {
				UtilHBM.reportKO("Selected staff picks icon displayed for image added in staff picks!!");
			} else {
				UtilHBM.reportOK("Selected staff picks icon not displayed for image added in staff picks!!");
			}
		} else {
			UtilHBM.reportKO("Expected Image is not displayed in staff pick page!!");
		}
		return this;
	}
	
	public StaffPicks verifyImageRemovedFrmStaffPick() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		for (int i = 0; i < 6; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(500);
		}
		String imgAttribute = UtilHBM.getProperty("testData", "ImgAddedToAtaffPick");
		List<WebElement> expectedImage = driver.findElements(
				By.xpath("//*[@id='staff-pick']/div/div/div[@class='tag image-related']/div/a/img[contains(@src,'"
						+ imgAttribute + "')]"));
		if (!expectedImage.isEmpty()) {
			UtilHBM.reportKO("Image removed from staff picks is displayed in staff picks page!! , Img Src : "
					+ expectedImage.get(0).getAttribute("src"));
		} else {
			UtilHBM.reportOK("Images removed from staff picks is not displayed in staff picks page!!");
		}
		return this;
	}

	public FeaturedMediaPage openImageAtIndex(int index) {
		UtilHBM.waitExplicitDisplayed(driver,
				mediaList.get(index).findElement(By.xpath("div/a/img[contains(@src,'https://')]")));
		WebElement expectedImage = mediaList.get(index)
				.findElement(By.xpath("div/a/img[contains(@src,'https://')][contains(@src,'/images/renderHQ/')]"));
		UtilHBM.waitExplicitDisplayed(driver, expectedImage);
		UtilHBM.waitExplicitClickable(driver, expectedImage);
		expectedImage.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public LandingPage logout() {
		if (userAvatar.isDisplayed()) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
			UtilHBM.waitFixTime(2000);
			UtilHBM.waitExplicitDisplayed(driver, userAvatar);
			Actions action = new Actions(driver);
			action.moveToElement(userAvatar).build().perform();
			UtilHBM.waitExplicitClickable(driver, logout);
			logout.click();
//			action.moveToElement(logout).click().build().perform();	
			UtilHBM.reportOK("Logout success");
			return PageFactory.initElements(driver, LandingPage.class);
		} else {
			UtilHBM.reportKO("Logout failed. User Name is not displayed");
		}
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public FeaturedMediaPage clickFirstMedia(WebElement firstMedia) {
		UtilHBM.waitExplicitDisplayed(driver, firstMedia);
		UtilHBM.waitExplicitClickable(driver, firstMedia);
		firstMedia.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public FeaturedMediaPage openMediaPage(WebElement imgPath) {
		UtilHBM.waitExplicitDisplayed(driver, imgPath);
		UtilHBM.waitExplicitClickable(driver, imgPath);
		imgPath.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public UserHomePage clickHbmLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
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
	
	public StaffPicks verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Decoration inspiration | HomeByMe")) {
			UtilHBM.reportOK("Staff picks page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("Staff picks page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
}
