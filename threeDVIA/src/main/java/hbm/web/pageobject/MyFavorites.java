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

public class MyFavorites {

	WebDriver driver;

	public MyFavorites(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.collection>div.left-inner>div>button.bt-icon-circle")
	private WebElement createNewList;
	
	@FindBy(css = "div#collection>ul>li>article>h3.name")
	private WebElement createNewListText;

	@FindBy(css = "div.sheet-header>h2")
	private WebElement createAListHeader;

	@FindBy(css = "div.sheet-header>button.bt-icon")
	private WebElement closeCreateAListDialog;

	@FindBy(id = "collection-name")
	private WebElement nameInputBox;

	@FindBy(css = "div.sheet-content>div.sheet-footer>button.sheet-button.button--alt")
	private WebElement cancelButton;

	@FindBy(css = "div.sheet-content>div.sheet-footer>button.sheet-button.button")
	private WebElement createButton;
	
	@FindBy(css = "div.sheet-content>div.sheet-footer>button.sheet-button.button[disabled]")
	private WebElement createButtonDisabled;

	@FindBy(css = "div#app-notification>p.success")
	private WebElement favoriteListSuccessMsg;
	
	@FindBy(css = "div#app-notification>p.success>button.bt-icon-alt-light")
	private WebElement closeFavoriteListSuccessMsg;

	@FindBy(css = "div#collection>ul>a")
	private List<WebElement> collectionLists;

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(xpath = "//nav[@class='header__nav']/a[@title='My Favorites']/span[contains(text(),'My Favorites')]")
	private WebElement myCollections;
	
	@FindBy(xpath = "//nav[@class='header__nav']/a[contains(@href,'/en/inspiration')]/span[.='Inspiration']")
	private WebElement galleryLink;
	
	@FindBy(xpath = "//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement myProjects;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle") 
	private WebElement userAvatar;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Account']")
	private WebElement accountLink;
	
	@FindBy(css = "div.page-loader>.loader")
	List<WebElement> collectionPageLoader;


	public MyFavorites createNewCollection(String collectionName) {
		clickCreateNewList();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		nameInputBox.sendKeys(collectionName);
		UtilHBM.waitExplicitClickable(driver, createButton);
		createButton.click();
		UtilHBM.waitExplicitDisplayed(driver, favoriteListSuccessMsg);
		Verification.VerifyEquals("Incorrect favoriteListSuccessMsg!!", favoriteListSuccessMsg.getText(),
				"Your collection has successfully been created");
		UtilHBM.waitExplicitDisplayed(driver, closeFavoriteListSuccessMsg);
		UtilHBM.waitExplicitClickable(driver, closeFavoriteListSuccessMsg);
		closeFavoriteListSuccessMsg.click();
		return this;
	}
	
	public MyFavorites verifyNoCollectionsAvailable() {
		UtilHBM.waitExplicitDisplayed(driver, createNewListText);
		UtilHBM.waitExplicitClickable(driver, createNewListText);
		Verification.VerifyEquals("Wrong createNewListText", createNewListText.getText(), "Create a collection");

		int limit = 5;
		for (int i = 0; i < limit; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFavListsAvailable = collectionLists.isEmpty();
			boolean isLoaderDisplayed = !collectionPageLoader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.reportInfo(
					"Collection lists not displayed for : " + i + "seconds!! Loader displayed : " + isLoaderDisplayed);
			UtilHBM.waitFixTime(1000);
			if (!isFavListsAvailable) {
				UtilHBM.reportKO(
						"Collection lists displayed in my collections page!! Collection lists expected : false");
			}
		}
		UtilHBM.reportOK("Collection lists not displayed!! Collection list expected : false");
		return this;
	}

	public UserHomePage clickHbmLogo() {
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public MyFavorites verifyCollection(String collectionName, int noOfImages, int noOfProducts) {
		UtilHBM.waitExplicitDisplayed(driver, collectionLists.get(0));
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> expectedList1 = driver.findElements(
				By.xpath("//div[@id='collection']/ul/a/li/article/h3[text()='" + collectionName + "']/../../.."));
		UtilHBM.turnOnImplicitWaits(driver);
		WebElement expectedList = null;
		String expectedListName = null;
		if (expectedList1.isEmpty()) {
			UtilHBM.reportKO("Collection list not displayed!!! Collection name :" + collectionName);
		} else {
			expectedList = expectedList1.get(0);
			UtilHBM.waitExplicitDisplayed(driver, expectedList.findElement(By.cssSelector("li>article>h3")));
			UtilHBM.waitExplicitClickable(driver, expectedList);
			expectedListName = expectedList.findElement(By.cssSelector("li>article>h3")).getText();
			UtilHBM.reportInfo("Opening collection list : " + expectedListName);
		}
		if (expectedListName.equals(collectionName)) {
			UtilHBM.reportOK("Correct favorite list name displayed");
			int totalItems = noOfImages + noOfProducts;
			UtilHBM.reportInfo("Total items in favorites list : " + totalItems);
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> firstPreview = expectedList
					.findElements(By.cssSelector("li>article>div.collection>div.left-inner"));
			List<WebElement> otherPreviews = expectedList
					.findElements(By.cssSelector("li>article>div.collection>div.right-inner>div.image-item"));
			int firstPreviewSize = firstPreview.size();
			int otherPreviewSize = otherPreviews.size();

			if ((totalItems) > 5) {
				UtilHBM.reportInfo("Total number of items is greater than 5!!");
				totalItems = 5;
			}
			if ((totalItems) == 0) {
				if (firstPreviewSize == 0 && otherPreviewSize == 0) {
					UtilHBM.reportOK("No items displayed in fav list with 0 image and 0 products");
				} else {
					UtilHBM.reportOK(
							"Some items displayed in fav list with 0 image and 0 products !!! firstPreviewItems :"
									+ firstPreviewSize + ",otherPreviewItems :" + otherPreviewSize);
				}
			} else {
				if (firstPreviewSize == 1 && otherPreviewSize == (totalItems - 1)) {
					UtilHBM.reportOK("1 item displayed in first preview and " + (totalItems - 1)
							+ " items displayed for fav list with " + totalItems + " items");
				} else {
					UtilHBM.reportOK("Incorrect number of items displayed in fav list with " + totalItems
							+ " item !!! firstPreviewItems :" + firstPreviewSize + ",otherPreviewItems :"
							+ otherPreviewSize);
				}
			}
			UtilHBM.turnOnImplicitWaits(driver);
		} else {
			UtilHBM.reportKO("Incorrect favorite list name displayed!! Expected list name : " + expectedListName
					+ ", List name displayed : " + collectionName);
		}
		openCollection(0, collectionName).verifyCollectionTitle(collectionName).verifyCollectionContents(noOfImages, noOfProducts)
				.goToMyCollections();
		return this;
	}

	public MyFavorites goToMyCollections() {
		UtilHBM.waitExplicitDisplayed(driver, myCollections);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}

	public FavoritesListPage openCollection(int index, String collectionName) {
		UtilHBM.waitExplicitDisplayed(driver, createNewList);
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFavListsAvailable = !collectionLists.isEmpty();
			boolean isLoaderDisplayed = !collectionPageLoader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.reportInfo(
					"Collection lists not displayed for : " + i + "seconds!! Loader displayed : " + isLoaderDisplayed);
			UtilHBM.waitFixTime(1000);
			if (isFavListsAvailable || i == limit - 1) {
				UtilHBM.reportInfo("Collection lists displayed in my collections page after " + (i + 1)
						+ " seconds!! Collection lists expected : true");
				break;
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, collectionLists.get(0));
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> expectedList = driver
				.findElements(By.xpath("//div[@id='collection']/ul/a/li/article/h3[text()='" + collectionName + "']"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (expectedList.isEmpty()) {
			UtilHBM.reportKO("Collection list not displayed!!! Collection name :" + collectionName);
		} else {
			WebElement expectedCollection = expectedList.get(index);
			UtilHBM.waitExplicitDisplayed(driver, expectedCollection);
			UtilHBM.waitExplicitClickable(driver, expectedCollection);
			UtilHBM.reportInfo("Opening favorite list : " + expectedCollection.getText());
			expectedCollection.click();
		}
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}
	
	public MyFavorites verifyFirstCollectionName(String collectionName) {
		UtilHBM.waitFixTime(1000);
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFavListsAvailable = collectionLists.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (!isFavListsAvailable || i == limit - 1) {
				UtilHBM.reportInfo("Collection lists displayed in my collections page after " + (i + 1)
						+ " seconds!! Collection lists expected : true");
				break;
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, collectionLists.get(0));
		UtilHBM.turnOffImplicitWaits(driver);
		WebElement firstCollection = driver.findElements(By.xpath("//div[@id='collection']/ul/a/li/article/h3")).get(0);
		UtilHBM.turnOnImplicitWaits(driver);
		Verification.VerifyEquals("Collection not displayed at top", firstCollection.getText(), collectionName);
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	

	public FavoritesListPage openCollection(int index) {
		UtilHBM.waitExplicitDisplayed(driver, createNewList);
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFavListsAvailable = collectionLists.isEmpty();
			boolean isLoaderDisplayed = !collectionPageLoader.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.reportInfo(
					"Collection lists not displayed for : " + i + " seconds!! Loader displayed : " + isLoaderDisplayed);
			UtilHBM.waitFixTime(1000);
			if (!isFavListsAvailable || i == limit - 1) {
				UtilHBM.reportInfo("Collection lists displayed in my collections page after " + (i + 1)
						+ " seconds!! Collection lists expected : true");
				break;
			}
		}
		collectionLists.get(index).click();
		UtilHBM.reportInfo("Opening favorite list at index :" + (index + 1));
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}

	public MyFavorites clickCreateNewList() {
		UtilHBM.waitExplicitDisplayed(driver, createNewListText);
		UtilHBM.waitExplicitClickable(driver, createNewListText);
		Verification.VerifyEquals("Wrong createNewListText", createNewListText.getText(), "Create a collection");
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFavListsAvailable = !collectionLists.isEmpty();
			boolean isLoaderDisplayed = !collectionPageLoader.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isFavListsAvailable || i == limit - 1 || !isLoaderDisplayed) {
				break;
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, createNewList);
		UtilHBM.waitExplicitClickable(driver, createNewList);
		createNewList.click();
		return this;
	}

	public MyFavorites verifyCreateAListDialog() {
		String handle1 = driver.getWindowHandle();
		clickCreateNewList();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		UtilHBM.waitExplicitDisplayed(driver, createAListHeader);
		Verification.VerifyEquals("Incorrect Create A List header", createAListHeader.getText(), "Create a collection");
		Verification.displayOfWebElement(closeCreateAListDialog);
		Verification.displayOfWebElement(createButtonDisabled);
		UtilHBM.reportOK("Create button is disabled by default!!");
		nameInputBox.sendKeys("Demo Favorite list 1");
		cancelButton.click();
		UtilHBM.reportInfo("Cancel button clicked!!");
		driver.switchTo().window(handle1);

		clickCreateNewList();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		UtilHBM.waitExplicitDisplayed(driver, createAListHeader);
		Verification.VerifyEquals("Incorrect Create A List header", createAListHeader.getText(), "Create a collection");
		Verification.displayOfWebElement(closeCreateAListDialog);
		Verification.displayOfWebElement(createButtonDisabled);
		UtilHBM.reportOK("Create button is disabled by default!!");
		nameInputBox.sendKeys("Demo Favorite list 2");
		closeCreateAListDialog.click();
		UtilHBM.reportInfo("Close button clicked!!");
		driver.switchTo().window(handle1);

		clickCreateNewList();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		UtilHBM.waitExplicitDisplayed(driver, createAListHeader);
		Verification.VerifyEquals("Incorrect Create A List header", createAListHeader.getText(), "Create a collection");
		Verification.displayOfWebElement(closeCreateAListDialog);
		Verification.displayOfWebElement(createButtonDisabled);
		UtilHBM.reportOK("Create button is disabled by default!!");
		nameInputBox.sendKeys("Demo Favorite list 1");
		cancelButton.click();
		return this;
	}

	public DecorationInspiration goToInspiration() {
		UtilHBM.waitExplicitClickable(driver, galleryLink);
		galleryLink.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}
	
	public MyProjects goToMyProjects() {
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
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
	
	public MyFavorites verifyPageTitle() {
		UtilHBM.waitExplicitDisplayed(driver, createNewList);
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("My collections")) {
			UtilHBM.reportOK("My collections page displayed!!");
		} else {
			UtilHBM.reportKO("My collections page not displayed!!");
		}
		Assert.assertFalse(pageTitle.contains("Error"));
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
	
	public MyAccount goToAccountPage(){		
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, accountLink);		
		accountLink.click();		
		return PageFactory.initElements(driver, MyAccount.class);
	}
}
