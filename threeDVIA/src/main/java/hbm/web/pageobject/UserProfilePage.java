package hbm.web.pageobject;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
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

public class UserProfilePage {
	
	WebDriver driver;

	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(css = "div.profile-view>.user-header>.image-user>.user-name>span")
	WebElement userNameDisplayed;

	@FindBy(css = "div.profile-view>.user-header>.image-user>.user-name>.description")
	List<WebElement> userDescription;

	@FindBy(css = "div.profile-view>.user-header>.image-user>.avatar>img[src^='https:']")
	List<WebElement> userProfileImg;

	@FindBy(css = "div.profile-view>.user-header>.image-user>.avatar>.initial")
	WebElement userProfileInitial;

	@FindBy(css = "div.profile-view>div>div>.end-of-list")
	private List<WebElement> endOfList;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='My profile']")
	private WebElement myProfile;

	@FindBy(css = "div.profile-view>.react-tabs>.container-related-images>li:nth-child(2)")
	private WebElement myContent;

	@FindBy(css = "div.profile-view>.react-tabs>.container-related-images>li:nth-child(1)")
	private WebElement myPictures;

	@FindBy(css = "div.profile-view>.react-tabs>.container-related-images>li[class*='selected']")
	private WebElement selectedTab;

	@FindBy(css = "div.profile-view>.react-tabs>div[class*='selected']>div>div>.no-result")
	private WebElement noMediaText;

	@FindBy(css = "div.profile-view>.user-header>.edit-profile>[href='/en/my-account']")
	private WebElement editProfile;

	@FindBy(css = "div.end-of-list>a[class='button'][href*='/en/inspiration']")
	public List<WebElement> discoverNewMedia;

	@FindBy(xpath = "//div[@id='community-content']/div/div/div/div/..")
	public List<WebElement> myContentList;
	
	@FindBy(xpath = "//div[@id='community-content']/div/div/div/a")
	public WebElement createNewContent;
	
	@FindBy(xpath = "//div[@id='community-content']/div/div/div/button")
	public WebElement importYourOwn3DCProduct;

	@FindBy(css = "div.ReactModalPortal>div>div>div.modal-header>h2")
	private WebElement deletePopupHeader;

	@FindBy(css = "div.ReactModalPortal>div>div>div.modal-content>p")
	private WebElement deletePopupText;

	@FindBy(css = "div.ReactModalPortal>div>div>div.modal-header>div.modal-close.button-close")
	private WebElement closeDeletePopup;

	@FindBy(css = "div.ReactModalPortal>div>div>div.modal-content>div.confirm-box-btns>button[class='button--alt']")
	private WebElement cancelDelete;

	@FindBy(css = "div.ReactModalPortal>div>div>div.modal-content>div.confirm-box-btns>button[class='button']")
	private WebElement confirmDelete;

	@FindBy(css = "#app-notification>p.success")
	private WebElement successNotification;

	@FindBy(css = ".profile-view>.react-tabs>div[class*='selected']>div>div>div[class='tag image-related']")
	private List<WebElement> mediaList;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;
	
	@FindBy(xpath = "//html/body/div[1]/div/div/span[@class='spinner']")
	List<WebElement> loader;
	
	@FindBy(xpath="/html/body/div[@class='ReactModalPortal']/div/div[@class='ReactModal__Content ReactModal__Content--after-open layer-3deditor-wrapper']/div/div/iframe")
	WebElement threeDEditorIframe;

	public UserProfilePage verifyUserDetails(String profilePAgeOwnerShip, String userName) {
		UtilHBM.waitExplicitDisplayed(driver, userNameDisplayed);
		if (userName.equals("")) {
			UtilHBM.reportInfo("User full name displayed as : " + userNameDisplayed.getText());
		} else {
			Verification.elementContainsString(userNameDisplayed, userName, " Username");
		}
		UtilHBM.turnOffImplicitWaits(driver);
		if (userProfileImg.isEmpty()) {
			if (!userProfileInitial.getText().equals("")) {
				UtilHBM.reportOK(
						"Profile initial for user " + userName + " is displayed as :" + userProfileInitial.getText());
			} else {
				UtilHBM.reportKO("User profile initials not diaplayed for user " + userName);
			}
			Verification.displayOfWebElement(userProfileInitial);
		} else {
			Verification.displayOfWebElement(userProfileImg.get(0));
		}
		if (profilePAgeOwnerShip.equalsIgnoreCase("own")) {
			Verification.VerifyEquals("My pictures tab not selected by default!! ", selectedTab.getText(),
					"My pictures");
		}
		if (!userDescription.isEmpty()) {
			UtilHBM.reportOK("User Description displayed!!");
			UtilHBM.reportInfo("User description displayed :" + userDescription.get(0).getText());

		} else {
			UtilHBM.reportInfo("User description is empty for user : " + userName);
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public UserProfilePage verifyMyPictures(String userName, boolean isMediaExpected) {
		UtilHBM.waitFixTime(1000);
		List<WebElement> mediaList = driver.findElements(
				By.cssSelector(".profile-view>.react-tabs>div[class*='selected']>div>div>div[class='tag image-related']"));
		if (isMediaExpected) {
			if (mediaList.isEmpty()) {
				UtilHBM.reportKO("No media displayed in m pictures section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
						"You haven't created any images yet");
			} else {
				UtilHBM.reportOK("Medias displayed in my pictures section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
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
					UtilHBM.waitFixTime(500);
					UtilHBM.waitExplicitDisplayed(driver, imageExpected.findElement(
							By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]")));
					WebElement addToCollectionText = imageExpected
							.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
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
				}
				WebElement firstMedia = mediaList.get(0).findElement(By.cssSelector("div"));
				Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector("a>img[src^='https://']")));
				openMediaPage(firstMedia).verifyMediaPage(userName.trim(), "", "Yes", "All;All rooms;NA;NA;NA")
						.goToMyProfile();
			}
		} else {
			if (mediaList.isEmpty()) {
				UtilHBM.reportOK("No media displayed in my pictures section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
						"You haven't created any images yet");
			} else {
				UtilHBM.reportKO("Medias displayed in my pictures section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
			}
		}
		return this;
	}

	public UserProfilePage verifyUserProfilePage(String profilePageOwnerShip, String userName) {
		UtilHBM.waitFixTime(1000);
		List<WebElement> mediaList = null;
		if (profilePageOwnerShip.equalsIgnoreCase("own")) {
			mediaList = driver.findElements(
					By.cssSelector(".profile-view>.react-tabs>div[class*='selected']>div>div>div[class='tag image-related']"));
		} else {
			mediaList = driver.findElements(By.cssSelector(".profile-view>div>div>div[class='tag image-related']"));
		}
		if (mediaList.isEmpty()) {
//			UtilHBM.reportInfo("No media displayed in profile page of user " + userName);
//			Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
//					"You haven't created any images yet");
//			Verification.elementContainsString(discoverNewMedia.get(0), "discover new media", "discoverNewMedia");
		} else {
			UtilHBM.reportOK("Medias displayed in profile page of user " + userName);
			int limit = 2;
			if (mediaList.size() <= limit) {
				limit = mediaList.size();
			} else {
				UtilHBM.reportInfo("More than 2 images displayed in profile page of user : " + userName
						+ "!!Verifying first " + limit + " from the list : ");
			}
			UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
			UtilHBM.reportInfo("Verifying first " + limit + " images displayed in profile page of user : " + userName);
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
						.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> noOfProductsText = imageExpected
						.findElements(By.xpath("div/div[@class='caption-footer']/div"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (noOfProductsText.isEmpty()) {
					UtilHBM.reportInfo("No products available in image!!");
				} else {
					int noOfProducts = Integer.parseInt(noOfProductsText.get(0).getText().split(" ")[0]);
					Verification.elementContainsString(noOfProductsText.get(0), "products", "noOfProductsText");
					UtilHBM.reportInfo(noOfProducts + " products are available in image!!");
				}
				WebElement userProfileLink = imageExpected
						.findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
				WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
				Verification.displayOfWebElement(addToCollectionText);
				Verification.displayOfWebElement(userProfileLink);
				Verification.displayOfWebElement(bookmark);
			}
		}
		return this;
	}

	public FeaturedMediaPage verifyOtherUsersProfilePage(String userName) {
		UtilHBM.waitFixTime(1000);
		List<WebElement> mediaList = driver.findElements(By.cssSelector(".profile-view>div>div>div[class='tag image-related']"));
		if (mediaList.isEmpty()) {
			UtilHBM.reportInfo("No media displayed in profile page of user " + userName);
			Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
					"You haven't created any images yet");
			Verification.elementContainsString(discoverNewMedia.get(0), "discover new media", "discoverNewMedia");
		} else {
			UtilHBM.reportOK("Medias displayed in my likes section of profile page of user " + userName);
			int limit = 2;
			if (mediaList.size() <= limit) {
				limit = mediaList.size();
			} else {
				UtilHBM.reportInfo("More than 2 images displayedin my likes section of profile page of user : "
						+ userName + "!!Verifying first " + limit + " from the list : ");
			}
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
			UtilHBM.reportInfo("Verifying first " + limit + " images displayed in profile page of user : " + userName);
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
						.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> noOfProductsText = imageExpected
						.findElements(By.xpath("div/div[@class='caption-footer']/div"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (noOfProductsText.isEmpty()) {
					UtilHBM.reportInfo("No products available in image!!");
				} else {
					int noOfProducts = Integer.parseInt(noOfProductsText.get(0).getText().split(" ")[0]);
					Verification.elementContainsString(noOfProductsText.get(0), "products", "noOfProductsText");
					UtilHBM.reportInfo(noOfProducts + " products are available in image!!");
				}
				WebElement userProfileLink = imageExpected
						.findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
				WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
				Verification.displayOfWebElement(addToCollectionText);
				Verification.displayOfWebElement(userProfileLink);
				Verification.displayOfWebElement(bookmark);
			}
			WebElement firstMedia = mediaList.get(0).findElement(By.cssSelector("div"));
			Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector("a>img[src^='https://']")));
			openMediaPage(firstMedia).verifyMediaPage(userName, "", "Yes", "All;All rooms;NA;NA;NA");
		}
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public FeaturedMediaPage openMediaPage(WebElement imgPath) {
		UtilHBM.waitExplicitDisplayed(driver, imgPath);
		UtilHBM.waitExplicitClickable(driver, imgPath);
		imgPath.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public FeaturedMediaPage openFirstMedia(String mediaOwnership) {
		List<WebElement> mediaListAlpha = null;
		if (mediaOwnership.equalsIgnoreCase("own")) {
			mediaListAlpha = driver.findElements(
					By.cssSelector(".profile-view>.react-tabs>div[class*='selected']>div>div>.image-related"));
		} else {
			mediaListAlpha = driver.findElements(By.cssSelector(".profile-view>div>div>.image-related"));
		}
		openMediaPage(mediaListAlpha.get(0).findElement(By.cssSelector("a:nth-child(1)")));
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public UserProfilePage goToBottomOfList() {
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(500);
		}
		return this;
	}
	
	public UserProfilePage verifyMediaAvailableAtIndex(int index) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		List<WebElement> mediaList1 = driver.findElements(By.cssSelector(
				".profile-view>.react-tabs>div[class*='selected']>div>div>div[class='tag image-related']"));
		String imgSrc = mediaList1.get(index).findElement(By.xpath("div/a/img")).getAttribute("src");
		assertTrue(imgSrc.contains("https://") && imgSrc.contains("/images/renderHQ/"));
		UtilHBM.reportOK("Image available at index : " + index + " , ImgSrc : " + imgSrc);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public FeaturedMediaPage openImageAtIndex(int index) {
		String imgSrc = null;
		for (int i = 0; i < index; i++) {
			WebElement imageExpected = mediaList.get(i);
			Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
			imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
			Actions actions = new Actions(driver);
			actions.moveToElement(imageExpected).build().perform();
		}
		UtilHBM.reportInfo("Opening image at index  : " + index + " , ImgSrc : " + imgSrc);
		UtilHBM.waitExplicitDisplayed(driver,
				mediaList.get(index).findElement(By.xpath("div/a/img[contains(@src,'https://')]")));
		UtilHBM.waitFixTime(1000);
		WebElement expectedImage = mediaList.get(index)
				.findElement(By.xpath("div/a/img[contains(@src,'https://')][contains(@src,'/images/renderHQ/')]"));
		UtilHBM.waitExplicitDisplayed(driver, expectedImage);
		UtilHBM.waitExplicitClickable(driver, expectedImage);
		expectedImage.click();
		UtilHBM.reportOK("Opening image at index : " + index);
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public UserHomePage clickHbmLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserProfilePage goToMyProfile() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, userAvatar);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProfile);
		myProfile.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public LandingPage openLandingPage() {
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public UserProfilePage verifyProcessingProduct(String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = null;
		boolean isPrdAvailable = false;
		int myContentListSize = myContentList.size();
		for (int i = 0; i < myContentListSize; i++) {
			if (myContentList.get(i).findElement(By.cssSelector("p>span.product-name")).getText()
					.equalsIgnoreCase(prdName)) {
				expectedProduct = myContentList.get(i);
				isPrdAvailable = true;
				break;
			} else {
				continue;
			}
		}
		if (!isPrdAvailable) {
			UtilHBM.reportKO("Product not available in my content!! Product name :" + prdName);
		}
		String productSrc = expectedProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
		if (productSrc.contains("Thumbnails") && productSrc.contains("https:")) {
			UtilHBM.reportOK("Product thumbnail displayed");
		} else {
			UtilHBM.reportKO(productSrc+"Product thumbnail not displayed for product : " + prdName + " , " + productSrc);
		}
		Verification.VerifyEquals("Wrong product name!!",
				expectedProduct.findElement(By.cssSelector("p>span.product-name")).getText(), prdName);
		Verification.VerifyEquals("Waiting for process text not displayed for processing product",
				expectedProduct.findElement(By.cssSelector("div>div.caption-message.waiting>div.message")).getText(),
				"Waiting for process");
		Verification.VerifyEquals("Coming soon text not displayed for processing product",
				expectedProduct.findElement(By.cssSelector("div>article>div.layer-message")).getText(), "Coming soon");
		return this;
	}

	public UserProfilePage verifyEditSuccessNotification() {
		UtilHBM.waitExplicitDisplayed(driver, successNotification);
		Verification.VerifyEquals("Wrong success notification displayed for edit user product!!",
				successNotification.getText(), "Changes saved successfully");
//		driver.navigate().refresh();
		return this;
	}

	public UserProfilePage verifyDeleteSuccessNotification() {
		UtilHBM.waitExplicitDisplayed(driver, successNotification);
		Verification.VerifyEquals("Wrong success notification displayed after deleting user product!!",
				successNotification.getText(), "The item has been deleted");
		driver.navigate().refresh();
		return this;
	}

	public UserProfilePage verifyMyContentPage() {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		List<String> processedProducts = new ArrayList<String>();
		List<String> processingProduct = new ArrayList<String>();
		int limit = 2;
		if (myContentList.size() <= limit) {
			limit = myContentList.size();
		} else {
			UtilHBM.reportInfo("More than 2 products displayed in my content section!!Verifying first " + limit
					+ " from the list : ");
		}
		UtilHBM.reportInfo("Verifying first " + limit + " products displayed in my content section!!");
		for (int i = 0; i < limit; i++) {
			WebElement currentProduct = myContentList.get(i);
			UtilHBM.waitExplicitDisplayed(driver, currentProduct);
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> processingProduct1 = currentProduct
					.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitExplicitDisplayed(driver, currentProduct.findElement(By.cssSelector("p>span.product-name")));
			String productName = currentProduct.findElement(By.cssSelector("p>span.product-name")).getText();
			if (processingProduct1.isEmpty()) {
				String productSrc = currentProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");

				if (productSrc.contains("Thumbnails") && productSrc.contains("https:")) {
					UtilHBM.reportOK("Product thumbnail displayed");
				} else {
					UtilHBM.reportKO(
							productSrc+"Product thumbnail not displayed for product : " + productName + " , " + productSrc);
				}
				Actions actions = new Actions(driver);
				actions.moveToElement(currentProduct).build().perform();
				UtilHBM.waitExplicitDisplayed(driver, currentProduct
						.findElement(By.xpath("div/div[@class='caption-actions']/div[2]/span")));
				WebElement editButton = currentProduct
						.findElement(By.xpath("div/div[@class='caption-actions']/div[1]/span"));
				WebElement deleteButton = currentProduct
						.findElement(By.xpath("div/div[@class='caption-actions']/div[2]/span"));
				Verification.displayOfWebElement(editButton);
				Verification.displayOfWebElement(deleteButton);
				processedProducts.add(productName);
			} else {
				String productSrc = currentProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
				if (productSrc.contains("Thumbnails") && productSrc.contains("https:")) {
					UtilHBM.reportOK("Product thumbnail displayed");
				} else {
					UtilHBM.reportKO(
							productSrc+	"Product thumbnail not displayed for product : " + productName + " , " + productSrc);
				}
				Verification.VerifyEquals(
						"Waiting for process text not displayed for processing product", currentProduct
								.findElement(By.cssSelector("div>div.caption-message.waiting>div.message")).getText(),
						"Waiting for process");
				Verification.VerifyEquals("Coming soon text not displayed for processing product",
						currentProduct.findElement(By.cssSelector("div>article>div.layer-message")).getText(),
						"Coming soon");
				processingProduct.add(productName);
			}
		}
		UtilHBM.reportInfo("Number of products in processing : " + processingProduct.size());
		UtilHBM.reportInfo("Products in processing : ");
		for (String a : processingProduct) {
			UtilHBM.reportInfo(a);
		}
		UtilHBM.reportInfo("Number of products processed : " + processedProducts.size());
		UtilHBM.reportInfo("Processed products : ");
		for (String a : processedProducts) {
			UtilHBM.reportInfo(a);
		}
		return this;
	}

	
	public UserProfilePage verifyProcessedProduct(int index, String prdName, String description) {
		UtilHBM.waitExplicitDisplayed(driver, userNameDisplayed);
		String userName = userNameDisplayed.getText();
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = myContentList.get(index);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> processingProduct = expectedProduct
				.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, expectedProduct.findElement(By.cssSelector("p>span.product-name")));
		if (expectedProduct.findElement(By.cssSelector("p>span.product-name")).getText().equalsIgnoreCase(prdName)) {
			if (processingProduct.isEmpty()) {
				UtilHBM.reportInfo("Checking first product with name : " + prdName);
			} else {
				UtilHBM.reportKO("First product is in processing stage!!Product name : " + prdName);
			}
		} else {
			UtilHBM.reportKO("Incorrect First product displayed : " + prdName);
		}
		String productSrc1 = expectedProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
		String prdSrc1 = productSrc1.substring(0, productSrc1.indexOf("/Thumbnails/"));
		String productSrc = prdSrc1.substring(prdSrc1.lastIndexOf("/")+1);
		WebElement productName = expectedProduct.findElement(By.cssSelector("p>span.product-name"));
		if (productSrc1.contains("Thumbnails") && productSrc1.contains("https:")) {
			UtilHBM.reportOK("Product thumbnail displayed");
		} else {
			UtilHBM.reportKO("Product thumbnail not displayed for product : " + prdName + " , " + productSrc1);
		}
		Verification.VerifyEquals("Wrong product name!!", productName.getText(), prdName);
		Actions actions = new Actions(driver);
		actions.moveToElement(expectedProduct).build().perform();
		UtilHBM.waitExplicitDisplayed(driver,
				expectedProduct.findElement(By.xpath("div/div[@class='caption-actions']/div[1]/span")));
		WebElement editButton = expectedProduct
				.findElement(By.xpath("div/div[@class='caption-actions']/div[1]/span"));
		WebElement deleteButton = expectedProduct
				.findElement(By.xpath("div/div[@class='caption-actions']/div[2]/span"));
		Verification.displayOfWebElement(editButton);
		Verification.displayOfWebElement(deleteButton);
		openProductSheet(0)
			.verifyProductSheetUserProducts(prdName, userName, productSrc, description)
			.clickProductInfoCloseUserProfilePage();
		return this;
	}
	
	public ProductInfo openProductSheet(int index, String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(index));
		WebElement expectedProduct = myContentList.get(index);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> processingProduct1 = expectedProduct
				.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (expectedProduct.findElement(By.cssSelector("p>span.product-name")).getText().equalsIgnoreCase(prdName)) {
			if (!processingProduct1.isEmpty()) {
				UtilHBM.reportInfo(
						"Product is in processing stage!!Product name : " + prdName + " , index in list :" + index);
				UtilHBM.reportInfo("Checking next product with name : " + prdName);
			}
			UtilHBM.reportOK("Product is in processed stage!!Product name : " + prdName + " , index in list :" + index);

		}
		WebElement productName = expectedProduct.findElement(By.cssSelector("p>span.product-name"));
		UtilHBM.reportInfo(
				"Opening product sheet of product displayed at index : " + index + " , Product name : " + prdName);
		UtilHBM.waitExplicitClickable(driver, productName);
		expectedProduct.click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ProductInfo openProductSheet(int index) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(index));
		WebElement productName = myContentList.get(index).findElement(By.cssSelector("p>span.product-name"));
		UtilHBM.reportInfo(
				"Opening product sheet of product displayed at index : " + index + " , Product name : " + productName);
		UtilHBM.waitExplicitClickable(driver, myContentList.get(index));
		myContentList.get(index).click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public UserProfilePage deleteProduct(String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = null;
		int myContentListSize = myContentList.size();
		int index = 0;
		for (int i = 0; i < myContentListSize; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> processingProduct1 = myContentList.get(i)
					.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitExplicitDisplayed(driver,
					myContentList.get(i).findElement(By.cssSelector("p>span.product-name")));
			if (myContentList.get(i).findElement(By.cssSelector("p>span.product-name")).getText()
					.equalsIgnoreCase(prdName)) {
				if (!processingProduct1.isEmpty()) {
					UtilHBM.reportInfo(
							"Product is in processing stage!!Product name : " + prdName + " , index in list :" + i);
					UtilHBM.reportInfo("Checking next product with name : " + prdName);
					continue;
				}
				expectedProduct = myContentList.get(i);
				index = i;
				break;
			} else {
				continue;
			}
		}
		UtilHBM.reportInfo("Deleting product displayed at index : " + index + " , Product name : " + prdName);
		String productSrc = expectedProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
		clickDeleteProductButton(prdName).clickCloseDeletePopup().clickDeleteProductButton(prdName).clickCancelDelete()
				.clickDeleteProductButton(prdName).verifyDeleteDialog().clickConfirmDelete()
				.verifyDeleteSuccessNotification();
		List<WebElement> deletedProduct = driver.findElements(By.cssSelector(
				"div#community-content>div>div>div.tag.image-related>div>article>img[src='" + productSrc + "']"));
		if (deletedProduct.isEmpty()) {
			UtilHBM.reportOK("Product deleted!! Product name  :" + prdName);
		} else {
			UtilHBM.reportKO("Product not deleted!! Product name : " + prdName);
		}
		return this;
	}

	public UserProfilePage clickDeleteProductButton(String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = null;
		boolean isPrdAvailable = false;
		int myContentListSize = myContentList.size();
		int index = 0;
		for (int i = 0; i < myContentListSize; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> processingProduct1 = myContentList.get(i)
					.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitExplicitDisplayed(driver,
					myContentList.get(i).findElement(By.cssSelector("p>span.product-name")));
			if (myContentList.get(i).findElement(By.cssSelector("p>span.product-name")).getText()
					.equalsIgnoreCase(prdName)) {
				if (!processingProduct1.isEmpty()) {
					UtilHBM.reportInfo(
							"Product is in processing stage!!Product name : " + prdName + " , index in list :" + i);
					UtilHBM.reportInfo("Checking next product with name : " + prdName);
					continue;
				}
				expectedProduct = myContentList.get(i);
				isPrdAvailable = true;
				index = i;
				break;
			} else {
				continue;
			}
		}
		if (!isPrdAvailable) {
			UtilHBM.reportKO("Product not available in my content!! Product name :" + prdName);
		}
		UtilHBM.reportInfo("clicking delete product button for product displayed at index : " + index
				+ " , Product name : " + prdName);
		Actions actions = new Actions(driver);
		actions.moveToElement(expectedProduct).build().perform();
		UtilHBM.waitExplicitDisplayed(driver,
				expectedProduct.findElement(By.xpath("div/div[@class='caption-actions']/div[2]/span")));
		WebElement deleteButton = expectedProduct
				.findElement(By.xpath("div/div[@class='caption-actions']/div[2]/span"));
		UtilHBM.waitExplicitClickable(driver, deleteButton);
		deleteButton.click();
		return this;
	}

	public EditUserProductDialog clickEditProductButton(String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = null;
		boolean isPrdAvailable = false;
		int myContentListSize = myContentList.size();
		int index = 0;
		for (int i = 0; i < myContentListSize; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> processingProduct1 = myContentList.get(i)
					.findElements(By.cssSelector("div>div.caption-message.waiting>div.message"));
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitExplicitDisplayed(driver,
					myContentList.get(i).findElement(By.cssSelector("p>span.product-name")));
			if (myContentList.get(i).findElement(By.cssSelector("p>span.product-name")).getText()
					.equalsIgnoreCase(prdName)) {
				if (!processingProduct1.isEmpty()) {
					UtilHBM.reportInfo(
							"Product is in processing stage!!Product name : " + prdName + " , index in list :" + i);
					UtilHBM.reportInfo("Checking next product with name : " + prdName);
					continue;
				}
				expectedProduct = myContentList.get(i);
				isPrdAvailable = true;
				index = i;
				break;
			} else {
				continue;
			}
		}
		if (!isPrdAvailable) {
			UtilHBM.reportKO("Product not available in my content!! Product name :" + prdName);
		}
		UtilHBM.waitExplicitDisplayed(driver, expectedProduct);
		UtilHBM.reportInfo("clicking edit product button for product displayed at index : " + index
				+ " , Product name : " + prdName);
		Actions actions = new Actions(driver);
		actions.moveToElement(expectedProduct).build().perform();
		WebElement editButton = expectedProduct
				.findElement(By.xpath("div/div[@class='caption-actions']/div[1]/span"));
		UtilHBM.waitExplicitDisplayed(driver, editButton);
		UtilHBM.waitExplicitDisplayed(driver, editButton);
		Verification.displayOfWebElement(editButton);
		editButton.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, EditUserProductDialog.class);
	}

	public UserProfilePage verifyDeleteDialog() {
		UtilHBM.waitExplicitDisplayed(driver, deletePopupHeader);
		Verification.VerifyEquals("Wrong ", deletePopupHeader.getText(), "Confirm Deletion");
		Verification.VerifyEquals("Wrong ", deletePopupText.getText(), "Are you sure you want to remove this item?");
		Verification.displayOfWebElement(closeDeletePopup);
		Verification.VerifyEquals("Wrong cancelDelete button text", cancelDelete.getText(), "Cancel");
		Verification.VerifyEquals("Wrong confirmDelete button text", confirmDelete.getText(), "Delete");
		return this;
	}

	public UserProfilePage clickCloseDeletePopup() {
		UtilHBM.waitExplicitDisplayed(driver, closeDeletePopup);
		UtilHBM.waitExplicitClickable(driver, closeDeletePopup);
		closeDeletePopup.click();
		return this;
	}

	public UserProfilePage clickCancelDelete() {
		UtilHBM.waitExplicitDisplayed(driver, cancelDelete);
		UtilHBM.waitExplicitClickable(driver, cancelDelete);
		cancelDelete.click();
		return this;
	}

	public UserProfilePage clickConfirmDelete() {
		UtilHBM.waitExplicitDisplayed(driver, confirmDelete);
		UtilHBM.waitExplicitClickable(driver, confirmDelete);
		confirmDelete.click();
		return this;
	}

	public UserProfilePage clickMyContent() {
		UtilHBM.waitExplicitDisplayed(driver, myContent);
		UtilHBM.waitExplicitClickable(driver, myContent);
		myContent.click();
		return this;
	}
	
	public LandingPage3DByMe clickCreateNewContent() {
		UtilHBM.waitExplicitDisplayed(driver, createNewContent);
		UtilHBM.waitExplicitClickable(driver, createNewContent);
		Verification.VerifyEquals("Wrong createNewContent button text ",
				createNewContent.findElement(By.xpath("div/article/span")).getText(), "Create a new content");
		createNewContent.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, LandingPage3DByMe.class);
	}

	public UserProfilePage verifyMyLikesPage(String userName, boolean isMediaExpected) {
		Verification.VerifyEquals("My likes tab not selected!! ", selectedTab.getText(), "My \"likes\"");
//		UtilHBM.webElement(driver, "body").sendKeys(Keys.END);
//		if (!discoverNewMedia.isEmpty()) {
//			Verification.elementContainsString(discoverNewMedia.get(0), "discover new media", "discoverNewMedia");
//		}
//		UtilHBM.webElement(driver, "body").sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		List<WebElement> mediaList = driver.findElements(
				By.cssSelector(".profile-view>.react-tabs>div[class*='selected']>div>div>div[class='tag image-related']"));
		if (isMediaExpected) {
			if (mediaList.isEmpty()) {
				UtilHBM.reportKO("No media displayed in my likes section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
						"You haven't created any images yet");
			} else {
				UtilHBM.reportOK("Medias displayed in my likes section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
				int limit = 2;
				if (mediaList.size() <= limit) {
					limit = mediaList.size();
				} else {
					UtilHBM.reportInfo("More than 2 images displayed in user profile page!!Verifying first " + limit
							+ " from the list : ");
				}
				UtilHBM.waitFixTime(1000);
				UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
				UtilHBM.reportInfo("Verifying first " + limit + " images displayed in my likes!!");
				for (int i = 0; i < limit; i++) {
					WebElement imageExpected = mediaList.get(i);
					Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
					String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
					if (!imgSrc.contains("https://")) {
						UtilHBM.reportKO("Image not displayed!!");
					}
					Actions actions = new Actions(driver);
					actions.moveToElement(imageExpected).build().perform();
					UtilHBM.waitFixTime(500);
					UtilHBM.waitExplicitDisplayed(driver, imageExpected.findElement(
							By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]")));
					WebElement addToCollectionText = imageExpected.findElement(
							By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
					UtilHBM.turnOffImplicitWaits(driver);
					List<WebElement> noOfProductsText = imageExpected
							.findElements(By.xpath("div/div[@class='caption-footer']/div"));
					UtilHBM.turnOnImplicitWaits(driver);
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
				WebElement firstMedia = mediaList.get(0).findElement(By.cssSelector("div"));
				String otherUserName= mediaList.get(0).findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div/div[@class='user-name']/span")).getText();
				Verification.displayOfWebElement(firstMedia.findElement(By.cssSelector("a>img[src^='https://']")));
				openMediaPage(firstMedia).verifyMediaPage(otherUserName.trim(), "", "Yes", "All;All rooms;NA;NA;NA")
						.goToMyProfile();
			}
		} else {
			if (mediaList.isEmpty()) {
				UtilHBM.reportOK("No media displayed in my likes section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
				Verification.VerifyEquals("Wrong no media available message displayed", noMediaText.getText(),
						"You haven't created any images yet");
			} else {
				UtilHBM.reportKO("Medias displayed in my likes section of profile page of user " + userName
						+ " , isMediaExpected : " + isMediaExpected);
			}
		}
		return this;
	}

	public UserProfilePage editProfile() {
		UtilHBM.waitExplicitDisplayed(driver, userNameDisplayed);
		UtilHBM.reportInfo("User is logged in!!");
		String descriptionEarlier = "";
		if (!userDescription.isEmpty()) {
			UtilHBM.reportOK("User Description displayed!!");
			descriptionEarlier = userDescription.get(0).getText();
		} else {
			UtilHBM.reportInfo("User description is empty!!");
		}
		clickEditProfile().editDescription("Edited Description").clickProfileInfoSave().goToMyProfile();
		Verification.VerifyEquals("Wrong edited description!!", userDescription.get(0).getText(), "Edited Description");
		clickEditProfile().editDescription(descriptionEarlier).clickProfileInfoSave().goToMyProfile();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public MyAccount clickEditProfile() {
		UtilHBM.waitExplicitDisplayed(driver, editProfile);
		UtilHBM.waitExplicitClickable(driver, editProfile);
		editProfile.click();
		return PageFactory.initElements(driver, MyAccount.class);
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
	
	public UserProfilePage verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("HomeByMe - Home")) {
			UtilHBM.reportOK("My profile  page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("My profile page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public UserProfilePage openAlphaLink() {
		String currentUrl=driver.getCurrentUrl();
		String alphaLink= currentUrl.substring(0, currentUrl.indexOf("#my-content"))+"?alpha&"+currentUrl.substring(currentUrl.indexOf("#my-content"));
		driver.get(alphaLink);
		return this;
	}
	
	public InfoPageGeometryEditor clickImportYourOwn3DProductToOpenInfoPage() {
		UtilHBM.waitExplicitDisplayed(driver, importYourOwn3DCProduct);
		UtilHBM.waitExplicitClickable(driver, importYourOwn3DCProduct);
		Verification.VerifyEquals("Wrong importYourOwn3DCProduct button text!!",
				importYourOwn3DCProduct.findElement(By.xpath("div/article/span")).getText(), "Import your own 3D product");
		importYourOwn3DCProduct.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, InfoPageGeometryEditor.class);
	}
	
	public Upload3dModel clickImportYourOwn3DProductToOpenUpload3dModel() {
		UtilHBM.waitExplicitDisplayed(driver, importYourOwn3DCProduct);
		UtilHBM.waitExplicitClickable(driver, importYourOwn3DCProduct);
		Verification.VerifyEquals("Wrong importYourOwn3DCProduct button text!!",
				importYourOwn3DCProduct.findElement(By.xpath("div/article/span")).getText(), "Import your own 3D product");
		importYourOwn3DCProduct.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		UtilHBM.waitFixTime(2000);
		int i;
		boolean temp = false;
		for (i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = loader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isLoaderDisappreared) {
				UtilHBM.reportInfo("Loader displayed for " + i + " seconds while opening geometry editor");
				temp = true;
				break;
			}
		}
		if (!temp) {
			UtilHBM.reportKO("Loader displayed for more than 10 seconds");
		}
		Upload3dModel upload3dModel=PageFactory.initElements(driver, Upload3dModel.class);
		upload3dModel.swtichFrame(); 
		return PageFactory.initElements(driver, Upload3dModel.class);
	}
	
	public UserProfilePage switchToParentFrame() {
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, userNameDisplayed);
		return PageFactory.initElements(driver, UserProfilePage.class);
		
	}
	
	public UserProfilePage refreshPage() {
		driver.navigate().refresh();
		return PageFactory.initElements(driver, UserProfilePage.class);
		
	}

}