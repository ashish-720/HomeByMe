package hbm.web.pageobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class FeaturedMediaPage {
	WebDriver driver;

	public FeaturedMediaPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	List<WebElement> userAvatar;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(3)")
	private WebElement myProfile;

	@FindBy(css = "body>main>.media-view>.container>.media-system.media-ready>picture>img")
	private WebElement featuredImage;
	
	@FindBy(css = "body>main>.media-view>.container>.media-system.media-ready>picture>span#expand-collapse-button>button.open_fullscreen.icon.icon-fullscreen")
	private WebElement openFullscreenImg;
	
	@FindBy(xpath = "//*[@id='pins-product-container'][@class='is-invisible']/div[@id='display-button']/i[@id='toggle-pins']")
	private List<WebElement> productPinButton;


	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-fields>h1")
	private List<WebElement> imagetName1;

	@FindBy(css = "#image-user>.user")
	private WebElement userProfileLink;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>#image-like>.like:nth-child(2)")
	private List<WebElement> likeCount1;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>.views")
	private List<WebElement> views1;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-meta>a")
	private List<WebElement> tags;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-details>a[class='button--alt open-planner-embed']")
	private WebElement openProject;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>#image-like>.like>.item-link>img[src*='like.']")
	private WebElement likeNotLogged;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>#image-like>.like>.item-link>img[src*='like.']")
	private List<WebElement> likeAction;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>#image-like>.like>.item-link>img[src*='liked']")
	private List<WebElement> unlikeAction;

	@FindBy(css = "body>main>.media-view>.container>.footer>.top-meta>.project-media-actions>#image-share>span.share.item-link>img")
	private WebElement shareMedia;

	@FindBy(css = "#container-related-images>.react-tabs>.container-related-images>li[class='image-tab']:nth-child(1)")
	private List<WebElement> youWillAlsoLike;

	@FindBy(css = "#container-related-images>.react-tabs>.container-related-images>li[class*='image-tab']:nth-child(2)")
	private List<WebElement> furnitureOnThisPhoto;
	
	@FindBy(xpath = "//*[@id='container-related-images']/div/div/div/ul/li/article[@class='mol-product-card']/div[@class='mol-label-product-presentation']/div[@class='ato-label-brand'][contains(text(),'GENERIQUE')]/../..")
	private List<WebElement> generiqueFurnitureList;
	
	@FindBy(xpath = "//*[@id='container-related-images']/div/div/div/ul/li/article[@class='mol-product-card']/div[@class='mol-label-product-presentation']/div[@class='ato-label-brand'][not(contains(text(),'GENERIQUE'))]/../..")
	private List<WebElement> nonGeneriqueFurnitureList;

	@FindBy(xpath = "//*[@id='container-related-images']/div/div/div/div/div[contains(@class,'tag image-related')]")
	private List<WebElement> relatedMediaList;

	@FindBy(xpath = "//*[@id='container-related-images']/div/div/div/div/div[contains(@class,'tag image-related')][1]/div/a/img")
	private WebElement firstRelatedMedia;

	@FindBy(xpath ="//nav[@class='header__nav']/a[contains(@href,'/en/inspiration')]/span[.='Inspiration']")
	public WebElement inspirationLink;
	
	@FindBy(css = "#image-user>.user>.image-user>.user-name>span")
	private WebElement userNameDisplayed;
	
	@FindBy(css = "body>main>.media-view>.container>.media-system.media-ready>picture>span#expand-collapse-button>button.open_fullscreen.button-close.button-close--light")
	private WebElement closeFullscreenImg;
	
	@FindBy(css = "div.media-view>.container>.media-system.media-ready>picture>img")
	private WebElement fullscreenImg;
	
	@FindBy(css = "#image-bookmark>div.bookmark>span")
	private WebElement bookmarkIcon;

	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My Collections']/span[contains(text(),'My Collections')]")
	private WebElement myCollections;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement myProjects;
	
	@FindBy(xpath="//*[@id='pins-product-container']/div[contains(@class,'pins-product is-active')]/div/ul/div/div/div/span[1]")
	private WebElement brandName;
	
	@FindBy(xpath="//*[@id='pins-product-container']/div[contains(@class,'pins-product is-active')]/div/ul/div/div/div/span[2]")
	private List<WebElement> prdName;
	
	@FindBy(xpath="//*[@id='pins-product-container']/div[contains(@class,'pins-product is-active')]/div/ul/div/div/div/div[@class='bubble-product-arrow']")
	private List<WebElement> AddToFavIcon;
	
	@FindBy(xpath="//*[@id='pins-product-container']/div[contains(@class,'pins-product is-active')]/div/ul/div/div/div/div[@class='bubble-product-price']")
	private List<WebElement> prdPriceInPin;
	
	@FindBy(xpath="//*[@id='pins-product-container'][@class='']/div[contains(@class,'pins-product is-active')]/div/ul/div/div/div/span[@class='bubble-product-brand']")
	private WebElement activePinPrdName;
	
	@FindBy(css = "#app-notification>p.success")
	private WebElement addToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.success>button>span.icon-view-close.icon-content")
	private WebElement closeAddToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.error")
	private WebElement alreadyAvailableInCollection;
	
	@FindBy(css = "#app-notification>p.error>button>span.icon-view-close.icon-content")
	private WebElement closeAlreadyAvailableInCollection;

	public FeaturedMediaPage verifyMediaPage(String userName, String viewCount1, String isUserLoggedYesOrNo, String tagsExpected) {	
		verifyMediaDisplayed()
			.verifyFullscreenImg()
			.verifyImageDetails(userName)
			.verifyViewCount(userName, viewCount1)
			.verifyTags(tagsExpected)
//			.likeImage(isUserLoggedYesOrNo)
			.clickShareMedia()
			.verifyShareContainerNew()
			.verifyYouMayAlsoLike()
			.clickFurnituresDisplayed()
			.verifyFurnitursOnThisImg()
			.clickYouWillAlsoLike()
			;
		
		// openProject().threeDView().closePlannerWithoutSave();
		// openProject.sendKeys(Keys.END);
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public UserProfilePage goToMyProfile() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, userAvatar.get(0));
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar.get(0)).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProfile);
		myProfile.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public MyProjects goToMyProjects() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public FeaturedMediaPage verifyImageDetails(String userName) {

		if (imagetName1.isEmpty()) {
			UtilHBM.reportInfo("ImageName not available!!");
		} else {
			UtilHBM.reportInfo("ImageName displayed!! ImageName : " + imagetName1.get(0).getText());
		}
		if (userName.equals("")) {
			UtilHBM.reportKO("Empty Username Displayed : " + userNameDisplayed.getText());
		} else {
			Verification.VerifyEquals("Incorrect user name displayed!!", userNameDisplayed.getText(), userName);
		}
		return this;
	}
	
	public FeaturedMediaPage verifyFullscreenImg() {
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		UtilHBM.waitExplicitClickable(driver, openFullscreenImg);
		openFullscreenImg();
		String handle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}		
		verifyFullscreenImgDisplayed().closeFullscreenImg();
		driver.switchTo().window(handle);
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		return this;
	}
	
	public String getFeaturedImgSrc() {
		String pageURL = driver.getCurrentUrl();
		UtilHBM.reportInfo("Image page opened!! Link  : " + pageURL);
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		String imgSrc = featuredImage.getAttribute("src");
		UtilHBM.reportInfo("Img Src : " + imgSrc);
		return imgSrc;
	}
	
	public AddToFavorites clickImageBookmark() {
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		UtilHBM.waitExplicitDisplayed(driver, bookmarkIcon);
		UtilHBM.waitExplicitClickable(driver, bookmarkIcon);
		bookmarkIcon.click();
		return  PageFactory.initElements(driver, AddToFavorites.class);
	}
	
	public FeaturedMediaPage verifyAddToCollectionSuccess(String favListName, boolean isItemAlreadyAvailableInFavList) {
		if (isItemAlreadyAvailableInFavList) {
			UtilHBM.waitExplicitDisplayed(driver, alreadyAvailableInCollection);
			Verification.VerifyEquals(
					"Your product has already been added to this favorites list message not displayed",
					alreadyAvailableInCollection.getText(), "Your product has already been added to this collection");
			UtilHBM.waitExplicitDisplayed(driver, closeAlreadyAvailableInCollection);
			UtilHBM.waitExplicitClickable(driver, closeAlreadyAvailableInCollection);
			closeAlreadyAvailableInCollection.click();
			UtilHBM.waitFixTime(500);
			AddToFavorites addToFavorites = PageFactory.initElements(driver, AddToFavorites.class);
			addToFavorites.closeAddToCollectionInInspiration();
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		} else {
			UtilHBM.waitExplicitDisplayed(driver, addToCollectionSuccess);
			Verification.VerifyEquals("Added to favorite list succcess message not displayed",
					addToCollectionSuccess.getText(), "Added to " + favListName);
			UtilHBM.waitExplicitDisplayed(driver, closeAddToCollectionSuccess);
			UtilHBM.waitExplicitClickable(driver, closeAddToCollectionSuccess);
			closeAddToCollectionSuccess.click();
			UtilHBM.waitFixTime(500);
		}
		return this;
	}
	
	public FeaturedMediaPage openFullscreenImg() {
		UtilHBM.waitExplicitDisplayed(driver, openFullscreenImg);
		UtilHBM.waitExplicitClickable(driver, openFullscreenImg);
		openFullscreenImg.click();
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
		}
	
	public FeaturedMediaPage verifyFullscreenImgDisplayed() {
		UtilHBM.waitExplicitDisplayed(driver, closeFullscreenImg);
		UtilHBM.waitExplicitDisplayed(driver, fullscreenImg);
		String imgSrc = fullscreenImg.getAttribute("src");
		if (imgSrc.contains("https://")) {
			UtilHBM.reportOK("Fullscreen image displayed from dedicated media page!!");
		} else {
			UtilHBM.reportKO("Fullscreen image not displayed from dedicated media page!!");
		}
		return PageFactory.initElements(driver, FeaturedMediaPage.class);

	}

	public FeaturedMediaPage closeFullscreenImg() {
		UtilHBM.waitExplicitDisplayed(driver, closeFullscreenImg);
		UtilHBM.waitExplicitClickable(driver, closeFullscreenImg);
		closeFullscreenImg.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public String returnUserName() {
		String userNameDisplayed = userProfileLink.findElement(By.cssSelector(".image-user>.user-name")).getText();
		return userNameDisplayed;
	}

	public DecorationInspiration goToGallery() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitDisplayed(driver, inspirationLink);
		UtilHBM.waitExplicitClickable(driver, inspirationLink);
		UtilHBM.waitFixTime(500);
		inspirationLink.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public FeaturedMediaPage verifyViewCount(String userName, String viewsCount1) {
		UtilHBM.waitExplicitDisplayed(driver, userProfileLink.findElement(By.cssSelector(".image-user>.user-name")));
		String userNameDisplayed = userProfileLink.findElement(By.cssSelector(".image-user>.user-name")).getText();
		int views = 0;
		if (views1.isEmpty()) {
			UtilHBM.reportInfo("No views on this image yet!!");
			UtilHBM.reportInfo("Verifying whether image displayed is belongs to logged user !!");
			Actions action = new Actions(driver);
			action.moveToElement(userAvatar.get(0)).build().perform();
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,
					"span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(1)"));
			String uName = UtilHBM
					.webElement(driver,
							"span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(1)")
					.getText().trim();
			String uName1 = uName.split(" ")[1];
			Verification.VerifyEquals("Zero views displayed even if media page is opened by different user!!",
					userNameDisplayed, uName1);
		} else {
			views = Integer.parseInt(views1.get(0).getText().split(" ")[0]);
		}
		if (!userName.equalsIgnoreCase(userNameDisplayed)) {
			if (!viewsCount1.equals("")) {
				int viewsCount = Integer.parseInt(viewsCount1);
				if (viewsCount + 1 == views) {
					UtilHBM.reportOK("View count increased!!");
				} else {
					UtilHBM.reportKO("View count not increased!! Number of views expected : " + (viewsCount + 1)
							+ " , Number of views available : " + views);
				}
			}
		} else {
			UtilHBM.reportInfo("Image views not increased as this image belongs to user : " + userName);
		}
		UtilHBM.reportInfo("Number of views available : " + views);
		return this;
	}
	
	public FeaturedMediaPage verifyUserProfileLink() {
		UtilHBM.waitExplicitDisplayed(driver, userProfileLink.findElement(By.cssSelector(".image-user>.user-name")));
		String userNameDisplayed = userProfileLink.findElement(By.cssSelector(".image-user>.user-name")).getText();
		String uName1="abc";
		String profilePageOwnership=null;
		if(!userAvatar.isEmpty()) {
			Actions action = new Actions(driver);
			action.moveToElement(userAvatar.get(0)).build().perform();
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,
					"div.byUser.dropdown.is-open>.dropdown__content>.dropdown__content__items>a:nth-child(1)"));
			String uName = UtilHBM
					.webElement(driver,
							"div.byUser.dropdown.is-open>.dropdown__content>.dropdown__content__items>a:nth-child(1)")
					.getText().trim();
			uName1 = uName.split(" ")[1];
		}
			
		if (uName1.equalsIgnoreCase(userNameDisplayed)) {
			UtilHBM.reportInfo("Image belongs to user logged : "+userNameDisplayed);
			profilePageOwnership="own";
		} else {
			profilePageOwnership="others";
		}
		openProfilePage().verifyUserProfilePage(profilePageOwnership, userNameDisplayed);
		driver.navigate().back();
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		return this;
	}

	public FeaturedMediaPage verifyTags(String tagsExpected) {
		String[] tagsExpectedList = tagsExpected.split(";");
		String categoryFilter = tagsExpectedList[0];
		String roomFilter = tagsExpectedList[1];
		String styleFilter = tagsExpectedList[2];
		String colorFilter = tagsExpectedList[3];
		String brandFilter = tagsExpectedList[4];
		if (tags.size() == 0) {
			if (tagsExpected.equalsIgnoreCase("All;All rooms;NA;NA;NA")) {
				UtilHBM.reportKO("No media tags displayed in image page!!! Applied filters : " + tagsExpected + "!!");
			} else {
				UtilHBM.reportKO(
						"No tags displayed in image page even if image is opened from filter results!! Applied filters : "
								+ tagsExpected);
			}
		} else {
			UtilHBM.reportInfo("Following media tags displayed : ");
			for (WebElement a : tags) {
				UtilHBM.reportInfo(a.getText());
			}

			if (!categoryFilter.equals("All")) {
				boolean success = false;
				for (WebElement a : tags) {
					if (a.getText().equalsIgnoreCase(colorFilter)) {
						success = true;
						UtilHBM.reportOK("Category filter " + categoryFilter + " is displayed in image tags");
					}
				}
				if (!success) {
					UtilHBM.reportKO("Category filter " + categoryFilter + " is not displayed in image tags");
				}
			} else if (!roomFilter.equals("All rooms")) {
				boolean success = false;
				for (WebElement a : tags) {
					if (a.getText().equalsIgnoreCase(roomFilter)) {
						success = true;
						UtilHBM.reportOK("Room filter " + roomFilter + " is displayed in image tags");
					}
				}
				if (!success) {
					UtilHBM.reportKO("Room filter " + roomFilter + " is not displayed in image tags");
				}
			} else if (!styleFilter.equals("NA")) {
				boolean success = false;
				for (WebElement a : tags) {
					if (a.getText().equalsIgnoreCase(styleFilter)) {
						success = true;
						UtilHBM.reportOK("Style filter " + styleFilter + " is displayed in image tags");
					}
				}
				if (!success) {
					UtilHBM.reportKO("Style filter " + styleFilter + " is not displayed in image tags");
				}
			} else if (!colorFilter.equals("NA")) {
				boolean success = false;
				for (WebElement a : tags) {
					if (a.getText().equalsIgnoreCase(colorFilter)) {
						success = true;
						UtilHBM.reportOK("Color filter " + colorFilter + " is displayed in image tags");
					}
				}
				if (!success) {
					UtilHBM.reportKO("Color filter " + colorFilter + " is not displayed in image tags");
				}
			} else if (!brandFilter.equals("NA")) {
				boolean success = false;
				for (WebElement a : tags) {
					if (a.getText().equalsIgnoreCase(brandFilter)) {
						success = true;
						UtilHBM.reportOK("Brand filter " + brandFilter + " is displayed in image tags");
					}
				}
				if (!success) {
					UtilHBM.reportKO("Brand filter " + brandFilter + " is not displayed in image tags");
				}
			} else {
				if (!tagsExpected.equalsIgnoreCase("All;All rooms;NA;NA;NA")) {
					UtilHBM.reportOK("No filters applied for image!! Following media tags displayed : ");
					for (WebElement a : tags) {
						UtilHBM.reportInfo(a.getText());
					}
				} else {
					UtilHBM.reportOK("No tags displayed in image page for applied filters!! Applied filters : "
							+ tagsExpected + " !!, Following media tags displayed : ");
					for (WebElement a : tags) {
						UtilHBM.reportInfo(a.getText());
					}
				}
			}
			String firstTagName = tags.get(0).getText();
			UtilHBM.reportInfo("Opening tag page : " + firstTagName);
			openFirstTag().verifyTagsInFeed(firstTagName).checkMediaListDisplayed();
			driver.navigate().back();
			UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		}
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public DecorationInspiration openFirstTag() {
		UtilHBM.waitExplicitClickable(driver, tags.get(0));
		tags.get(0).click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public FeaturedMediaPage verifyYouMayAlsoLike() {
		UtilHBM.webElement(driver, "body").sendKeys(Keys.PAGE_DOWN);
		if (!youWillAlsoLike.isEmpty()) {
			youWillAlsoLike.get(0).click();
		}
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		boolean isRelatedMediaListEmpty = relatedMediaList.isEmpty();
		UtilHBM.turnOffImplicitWaits(driver);
		if (isRelatedMediaListEmpty) {
			UtilHBM.reportKO("No images displayed in youWillAlsoLike section for image :" + driver.getCurrentUrl());
		} else {
			int relatedMediaListSize = relatedMediaList.size();
			int limit = 2;
			if (relatedMediaListSize <= 2) {
				limit = relatedMediaListSize;
			} else {
				UtilHBM.reportInfo(
						"More than 2 images displayed in you may also like section!!Verifying first 5 from the list : ");
			}
			for (int i = 0; i < limit; i++) {
				WebElement imageExpected = relatedMediaList.get(i);
				Actions actions = new Actions(driver);
				actions.moveToElement(imageExpected).build().perform();
				WebElement addToCollectionText = imageExpected
						.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
				WebElement noOfProductsText = imageExpected
						.findElement(By.xpath("div/div[@class='caption-footer']/div"));
				WebElement currentImg = imageExpected.findElement(By.xpath("div/a/img"));
				WebElement userProfileLink = imageExpected
						.findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
				WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
				if (currentImg.getAttribute("src").contains("https://")) {
					UtilHBM.reportOK("Related media image displayed");
				} else {
					UtilHBM.reportKO("Related media image not displayed at index : " + i);
				}
				Verification.displayOfWebElement(addToCollectionText);
				Verification.elementContainsString(noOfProductsText, "products", "noOfProductsText");
				int noOfProducts = Integer.parseInt(noOfProductsText.getText().split(" ")[0]);
				UtilHBM.reportInfo(noOfProducts + " products are available in image!!");
				Verification.displayOfWebElement(userProfileLink);
				Verification.displayOfWebElement(bookmark);
			}
			Actions actions = PageFactory.initElements(driver, Actions.class);
			actions.moveToElement(firstRelatedMedia).build().perform();
			UtilHBM.waitExplicitClickable(driver, firstRelatedMedia);
			firstRelatedMedia.click();
			verifyMediaDisplayed().clickBackButton();
			UtilHBM.waitFixTime(1000);
		}
		return this;
	}
	
	public FeaturedMediaPage clickBackButton() {
		driver.navigate().back();
		return this;
	}

	public FeaturedMediaPage verifyFurnitursOnThisImg() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
				"//*[@id='container-related-images']/div/ul/li[@class='image-tab react-tabs__tab--selected'][@id='react-tabs-2']")));
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElements(By.xpath(
				"//*[@id='container-related-images']/div/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/div/ul/li/article[@class='mol-product-card']"))
				.get(0));
		List<WebElement> furnitureList = driver.findElements(By.xpath(
				"//*[@id='container-related-images']/div/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/div/ul/li/article[@class='mol-product-card']"));
		if (!furnitureList.isEmpty()) {
			for (WebElement a : furnitureList) {
				UtilHBM.waitExplicitDisplayed(driver,
						a.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
				Verification.displayOfWebElement(
						a.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
				String brandName = a
						.findElement(
								By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-brand']"))
						.getText();
				String productName = a
						.findElement(By
								.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-product']"))
						.getText();
				if (!(brandName.equals("") || productName.equals(""))) {
					UtilHBM.reportOK("Brand and product names displayed for related products");
				} else {
					UtilHBM.reportInfo("Brand or product name not displayed for related product!! Brand name :"
							+ brandName + ",Product name : " + productName);
				}
			}
			verifyProductSheet();
		} else {
			UtilHBM.reportKO("No furnitures displayed in furniture on this media list!!");
		}
		return this;
	}

	public FeaturedMediaPage clickYouWillAlsoLike() {
		UtilHBM.waitExplicitDisplayed(driver, youWillAlsoLike.get(0));
		UtilHBM.waitExplicitClickable(driver, youWillAlsoLike.get(0));
		youWillAlsoLike.get(0).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public FeaturedMediaPage clickFurnituresDisplayed() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, furnitureOnThisPhoto.get(0));
		UtilHBM.waitExplicitClickable(driver, furnitureOnThisPhoto.get(0));
		furnitureOnThisPhoto.get(0).click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public ThreeDPlanner openProject() {
		UtilHBM.waitExplicitClickable(driver, openProject);
		openProject.click();
		UtilHBM.waitFixTime(2000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public FeaturedMediaPage verifyMediaDisplayed() {
		UtilHBM.reportInfo("Verifying media page : " + driver.getCurrentUrl());
		UtilHBM.waitExplicitDisplayed(driver, featuredImage);
		String imgSrc = featuredImage.getAttribute("src");
		if (imgSrc.contains("https")) {
			UtilHBM.reportOK("Media image displayed on dedicated media page!!");
		} else {
			UtilHBM.reportKO("Media image not displayed on dedicated media page!!");
		}
		return this;
	}

	public FeaturedMediaPage verifyProductSheet() {
		if (!generiqueFurnitureList.isEmpty()) {
			UtilHBM.reportInfo("Verifying product sheet for generique brand product !!");
			UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(0)
					.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
			String brandTitle = generiqueFurnitureList.get(0)
					.findElement(By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-brand']"))
					.getText();
			UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(0).findElement(
					By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-brand']")));
			String productName = generiqueFurnitureList.get(0)
					.findElement(
							By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-product']"))
					.getText();
			openFirstFurniture("Yes").verifyProductSheetDisplayed(brandTitle, productName).verifyProductDescription()
					.verifyRelatedProducts().verifyProductModels(brandTitle, productName)
					.clickProductInfoCloseMediaPage();
		} else {
			UtilHBM.reportInfo("Generique brand products not available for this image");
		}

		if (!nonGeneriqueFurnitureList.isEmpty()) {
			UtilHBM.reportInfo("Verifying product sheet for non-generique brand product !!");
			UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(0)
					.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
			String brandTitle = nonGeneriqueFurnitureList.get(0)
					.findElement(By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-brand']"))
					.getText();
			UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(0).findElement(
					By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-brand']")));
			String productName = nonGeneriqueFurnitureList.get(0)
					.findElement(
							By.xpath("div[@class='mol-label-product-presentation']/div[@class='ato-label-product']"))
					.getText();
			openFirstFurniture("No").verifyProductSheetDisplayed(brandTitle, productName)
					.verifyProductVisitStore(productName).clickShareProduct().verifyShareProductDialog()
					.closeSharePoductContainer().verifyProductDescription().verifyRelatedProducts()
					.verifyProductModels(brandTitle, productName).clickProductInfoCloseMediaPage();
		} else {
			UtilHBM.reportInfo("Non-generique brand products not available for this image");
		}
		return this;
	}
	
	public MyFavorites goToMyCollections() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	
	public ProductInfo openFirstFurniture(String generiqueOrNot) {
		if (generiqueOrNot.equalsIgnoreCase("Yes")) {
			int generiqueFurnitureListSize = generiqueFurnitureList.size();
			for (int i = 0; i < generiqueFurnitureListSize; i++) {
				UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(i)
						.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
				UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(i));
				UtilHBM.waitExplicitClickable(driver, generiqueFurnitureList.get(i));
				generiqueFurnitureList.get(i).click();
				ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
				boolean isBookmarkAvailable = productInfo.isBookmarkAvailable();
				if (isBookmarkAvailable) {
					break;
				} else {
					productInfo.clickProductInfoCloseButton();
					continue;
				}
			}
		} else if (generiqueOrNot.equalsIgnoreCase("No")) {
			int nonGeneriqueFurnitureListSize = nonGeneriqueFurnitureList.size();
			for (int i = 0; i < nonGeneriqueFurnitureListSize; i++) {
				UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(i)
						.findElement(By.xpath("div[@class='ato-card-square']/img[@class='ato-thumb-product']")));
				UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(i));
				UtilHBM.waitExplicitClickable(driver, nonGeneriqueFurnitureList.get(i));
				nonGeneriqueFurnitureList.get(i).click();
				ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
				boolean isBookmarkAvailable = productInfo.isBookmarkAvailable();
				if (isBookmarkAvailable) {
					break;
				} else {
					productInfo.clickProductInfoCloseButton();
					continue;
				}
			}
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public String getFirstPrdName(String generiqueOrNot) {
		if (generiqueOrNot.equalsIgnoreCase("Yes")) {
			UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(0));
			UtilHBM.waitExplicitClickable(driver, generiqueFurnitureList.get(0));
			return generiqueFurnitureList.get(0).findElement(By.xpath("div/div[@class='ato-label-product']")).getText();
		} else if (generiqueOrNot.equalsIgnoreCase("No")) {
			UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(0));
			UtilHBM.waitExplicitClickable(driver, nonGeneriqueFurnitureList.get(0));
		}
		return nonGeneriqueFurnitureList.get(0).findElement(By.xpath("div/div[@class='ato-label-product']")).getText();
	}

	public String getFirstBrndName(String generiqueOrNot) {
		if (generiqueOrNot.equalsIgnoreCase("Yes")) {
			UtilHBM.waitExplicitDisplayed(driver, generiqueFurnitureList.get(0));
			UtilHBM.waitExplicitClickable(driver, generiqueFurnitureList.get(0));
			return generiqueFurnitureList.get(0).findElement(By.xpath("div/div[@class='ato-label-brand']")).getText();
		} else if (generiqueOrNot.equalsIgnoreCase("No")) {
			UtilHBM.waitExplicitDisplayed(driver, nonGeneriqueFurnitureList.get(0));
			UtilHBM.waitExplicitClickable(driver, nonGeneriqueFurnitureList.get(0));
		}
		return nonGeneriqueFurnitureList.get(0).findElement(By.xpath("div/div[@class='ato-label-brand']")).getText();
	}
	
	public FeaturedMediaPage clickProductPinButton() {
		if (!productPinButton.isEmpty()) {
			UtilHBM.waitExplicitClickable(driver, productPinButton.get(0));
			productPinButton.get(0).click();
		}
		return this;
	}
	
	public ProductInfo openProductSheet() {
		UtilHBM.waitExplicitDisplayed(driver, activePinPrdName);
		UtilHBM.waitExplicitClickable(driver, activePinPrdName);
		activePinPrdName.click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public FeaturedMediaPage clickpinProduct(int index) {
		List<WebElement> pinProducts = driver
				.findElements(By.xpath("//*[@id='pins-product-container'][@class='']/div[@class='pins-product']"));
		for (WebElement a : pinProducts) {
			a.click();
			UtilHBM.waitExplicitDisplayed(driver, brandName);
			UtilHBM.turnOffImplicitWaits(driver);
			if (AddToFavIcon.isEmpty()) {
				UtilHBM.turnOnImplicitWaits(driver);
				continue;
			} else {
				UtilHBM.turnOnImplicitWaits(driver);
				break;
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, brandName);
		return this;
	}
	
	public FeaturedMediaPage verifyPinProducts(String prdList) {
		String[] productList = prdList.split(";");
		List<WebElement> pinProducts = driver
				.findElements(By.xpath("//*[@id='pins-product-container'][@class='']/div[@class='pins-product']"));
		int noOfpinProductsAvailable = pinProducts.size();
		int noOfpinProductsExpected = productList.length;
		if (noOfpinProductsAvailable == noOfpinProductsExpected) {
			UtilHBM.reportOK("Number of pin products displayed are as expected");
		} else {
			UtilHBM.reportKO("Number of pin products displayed are not as expected!!Expected : "
					+ noOfpinProductsExpected + " , Available pin products : " + noOfpinProductsAvailable);
		}
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement a : pinProducts) {
			UtilHBM.waitExplicitClickable(driver, a);
			a.click();
			UtilHBM.waitExplicitDisplayed(driver, brandName);
			String prdName1 = "";
			UtilHBM.turnOffImplicitWaits(driver);
			if (!prdName.isEmpty()) {
				prdName1 = prdName.get(0).getText();
			}
			UtilHBM.turnOnImplicitWaits(driver);
			list.add(prdName1 + "," + brandName.getText());
			UtilHBM.waitFixTime(500);
		}
		for (int i = 0; i < noOfpinProductsExpected; i++) {
			String currentProduct = productList[i];
			if (!list.contains(currentProduct)) {
				UtilHBM.reportKO("Expected product is not available in pin products!! Product : " + currentProduct);
			}
		}
		Set<String> st = new HashSet<String>(list);
		boolean isAnyProductDisplayedMultipleTimes = false;
		for (String s : st) {
			if (Collections.frequency(list, s) > 1) {
				isAnyProductDisplayedMultipleTimes = true;
				UtilHBM.reportKO(
						"Multiple product pins displayed for multiple instances of same product in media page!!!Product name : "
								+ s + " , Frequency : " + Collections.frequency(list, s));
			}
		}
		if (!isAnyProductDisplayedMultipleTimes) {
			UtilHBM.reportOK("Separate pins not displayed for multiple instances of same product in media page!");
		}
		return this;
	}
	
	public String getPrdAttributeFrmPin() {
		UtilHBM.waitExplicitDisplayed(driver, brandName);
		String prdName1 = "";
		UtilHBM.turnOffImplicitWaits(driver);
		if (!prdName.isEmpty()) {
			prdName1 = prdName.get(0).getText();
		}
		UtilHBM.turnOnImplicitWaits(driver);
		String prdAttribute = prdName1 + ";" + brandName.getText();
		UtilHBM.reportInfo("Pin product to be added in favorites list is : " + prdAttribute);
		UtilHBM.waitExplicitClickable(driver, AddToFavIcon.get(0));
		return prdAttribute;
	}
	
	public AddToFavorites addToCollectionFromPin() {
		UtilHBM.waitExplicitDisplayed(driver, brandName);
		String prdName1 = null;
		UtilHBM.turnOffImplicitWaits(driver);
		if (!prdName.isEmpty()) {
			prdName1 = prdName.get(0).getText();
		}
		if (!prdPriceInPin.isEmpty()) {
			UtilHBM.reportInfo("Product price displayed in pin : " + prdPriceInPin.get(0).getText());
		}
		UtilHBM.turnOnImplicitWaits(driver);
		String prdAttribute = prdName1 + ";" + brandName.getText();
		UtilHBM.reportInfo("Pin product to be added in favorites list is : " + prdAttribute);
		UtilHBM.waitExplicitClickable(driver, AddToFavIcon.get(0));
		AddToFavIcon.get(0).click();
		return PageFactory.initElements(driver, AddToFavorites.class);
	}
	
	public DecorationInspiration GoBackToFeedPage() {
		driver.navigate().back();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public ShareContainer clickShareMedia() {
		UtilHBM.waitExplicitDisplayed(driver, shareMedia);
		UtilHBM.waitExplicitClickable(driver, shareMedia);
		shareMedia.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}

	public FeaturedMediaPage likeImage(String isUserLoggedYesOrNo) {
		if (isUserLoggedYesOrNo.equalsIgnoreCase("Yes")) {
			if (unlikeAction.isEmpty()) {
				UtilHBM.reportInfo("Image is not liked yet!!");
				int likeCountBefore;
				if (likeCount1.isEmpty()) {
					likeCountBefore = 0;
				} else {
					likeCountBefore = Integer.parseInt(likeCount1.get(0).getText());
				}
				likeAction.get(0).click();
				UtilHBM.waitExplicitDisplayed(driver, unlikeAction.get(0));
				int likecountAfter = Integer.parseInt(likeCount1.get(0).getText());
				if (likecountAfter == 1 + likeCountBefore) {
					UtilHBM.reportOK("Like operation successful!!");
				} else {
					UtilHBM.reportKO("Like operation unsuccessful!!likeCountBefore : " + likeCountBefore
							+ ", likecountAfter :" + likecountAfter);
				}
				unlikeAction.get(0).click();
				UtilHBM.waitExplicitDisplayed(driver, likeAction.get(0));

			} else if (likeAction.isEmpty()) {
				UtilHBM.reportInfo("Image is already liked!!");
				int likeCountBefore = Integer.parseInt(likeCount1.get(0).getText());
				unlikeAction.get(0).click();
				UtilHBM.waitExplicitDisplayed(driver, likeAction.get(0));
				int likecountAfter;
				if (likeCount1.isEmpty()) {
					likecountAfter = 0;
				} else {
					likecountAfter = Integer.parseInt(likeCount1.get(0).getText());
				}
				if (likecountAfter == likeCountBefore - 1) {
					UtilHBM.reportOK("Unlike operation successful!!");
				} else {
					UtilHBM.reportKO("Unlike operation unsuccessful!!likeCountBefore : " + likeCountBefore
							+ ", likecountAfter :" + likecountAfter);
				}
				likeAction.get(0).click();
				UtilHBM.waitExplicitDisplayed(driver, unlikeAction.get(0));

			}
		} else {
			Verification.displayOfWebElement(likeNotLogged);
		}
		return this;
	}

	public UserProfilePage openProfilePage() {
		UtilHBM.waitExplicitDisplayed(driver, userProfileLink);
		UtilHBM.waitExplicitClickable(driver, userProfileLink);
		userProfileLink.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public UserHomePage clickHbmLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
}