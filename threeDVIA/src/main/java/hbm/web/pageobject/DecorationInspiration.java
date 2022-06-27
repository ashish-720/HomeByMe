package hbm.web.pageobject;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class DecorationInspiration {
	WebDriver driver;

	public DecorationInspiration(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;
	
	@CacheLookup
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;
	
	@FindBy(css = "#explore>div>div>div>ul>li:nth-child(1)>a")
	private WebElement allRoomsCategory;
	
	@FindBy(xpath = "//div[@id='explore']/div/div/div/ul[@class='filter-button-list']/li/a")
	List<WebElement> roomsCategories;
	
	@FindBy(css = "#explore>div>div>div>ul>span>span")
	private WebElement loadMoreRoomCategories;
	
	@FindBy(xpath = "//div[@id='explore']/div/div/button[@id='sticky-pimple']")
	private WebElement filterButton;
	
	@FindBy(xpath = "//div[@id='explore']/div/div/button[@id='sticky-pimple']/div[@class='ato-expo-num']")
	private WebElement noOfFilterApplied;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/div[@class='recap-left']/span[@name='room']")
	private WebElement roomFilterApplied;

	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/div[@class='recap-left']/span[@name='color']")
	private WebElement colorFilterApplied;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/div[@class='recap-left']/span[@name='style']")
	private WebElement styleFilterApplied;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/div[@class='recap-left']/span[@name='brand']")
	private WebElement brandFilterApplied;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/div[@class='recap-left']/span[@name='category']")
	private WebElement categoryFilterApplied;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/h1")
	private WebElement filterHeader;
	
	@FindBy(xpath = "//div[@id='explore']/div[@class='panel-container panel-container--open']/div/div/button")
	private WebElement filterClose;

	@FindBy(xpath = "//div[@class='popin-panel-module']/div[@class='recap-filter is-expand']/div[@class='recap-right']/span")
	private WebElement clearAllFilters;
	

	@FindBy(xpath = "//*[@id='explore']/div[3]/div/div[@class='no-result']")
	private WebElement noResults;

	@FindBy(xpath = "//*[@id='explore']/div[@class='take-chance']")
	private WebElement youMayAlsoLike;

	@FindBy(css = "div.feed-view>div>div#header-text>h1")
	WebElement headerTitle;

	@FindBy(css = "div.feed-view>div>div#header-text>div.under-title>div:nth-child(1)")
	WebElement headerText1;

	@FindBy(xpath = "//div[@class='part2']/a[text()='Show more']")
	WebElement showMoreInfoIcon;
	
	@FindBy(xpath = "//div[@class='part2']/a[text()='Show less']")
	WebElement showLessInfoIcon;

	@FindBy(xpath = "//*[@id='explore']/div[3]/div/div[@class='tag image-related']")
	private List<WebElement> mediaList;

	@FindBy(xpath = "//*[@id='explore']/div[5]/div/div[contains(@class,'tag image-related')]")
	private List<WebElement> mediaListWhenNoResults;

	@FindBy(css = "a[title='Inspiration']")
	private WebElement galleryLink;

	@FindBy(css = "#app-notification>p.success")
	private WebElement addToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.success>button>span.icon-view-close.icon-content")
	private WebElement closeAddToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.error")
	private WebElement alreadyAvailableInCollection;
	
	@FindBy(css = "#app-notification>p.error>button>span.icon-view-close.icon-content")
	private WebElement closeAlreadyAvailableInCollection;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/a[@title='My Collections']/span[contains(text(),'My Collections')]")
	private WebElement myCollections;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[@class='section-filter category ']/div[@class='header-section-filter']")
	private List<WebElement> categoryFilter;

	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter category is-expand')]/ul/li/a")
	private List<WebElement> categoryFilterList;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[@class='section-filter room ']/div[@class='header-section-filter']")
	private List<WebElement> roomFilter;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter room is-expand')]/ul/div")
	private WebElement showAllRoom;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'popin-panel-module overlay false')]/div/ul/li/a")
	private List<WebElement> allFilterOptions;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'popin-panel-module overlay false')]/div[@class='header-filter']/h1")
	private WebElement allFilterOptionsHeader;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'popin-panel-module overlay false')]/div[@class='header-filter']/span")
	private WebElement allFilterOptionsBack;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter style is-expand')]/ul/div")
	private WebElement showAllStyles;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter color is-expand')]/ul/div")
	private WebElement showAllColors;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter brand is-expand')]/ul/div")
	private WebElement showAllBrands;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'popin-panel-module overlay false')]/div/ul/input")
	private WebElement searchBrand;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[@class='section-filter style ']/div[@class='header-section-filter']")
	private List<WebElement> styleFilter;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[@class='section-filter color ']/div[@class='header-section-filter']")
	private List<WebElement> colorFilter;

	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter category is-expand')]/div[@class='header-section-filter']")
	private WebElement categoryFilterExpanded;

	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter room is-expand')]/div[@class='header-section-filter']")
	private WebElement roomFilterExpanded;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter style is-expand')]/div[@class='header-section-filter']")
	private WebElement styleFilterExpanded;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter color is-expand')]/div[@class='header-section-filter']")
	private WebElement colorFilterExpanded;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[@class='section-filter brand ']/div[@class='header-section-filter']")
	private List<WebElement> brandFilter;
	
	@FindBy(xpath = "//div[@class='body-filter']/div[contains(@class,'section-filter brand is-expand')]/div[@class='header-section-filter']")
	private WebElement brandFilterExpanded;
	
	@FindBy(xpath = "//div[@class='footer-filter']/div[@class='footer-btn']")
	private WebElement applyfilterButton;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;

	static String staffPickedImgAttribute;
	
	
	public LandingPage clickHbmLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		homebymeLink.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public DecorationInspiration filterByRoomCategory(String roomCategory) {
		UtilHBM.waitExplicitDisplayed(driver, allRoomsCategory);
		UtilHBM.waitExplicitClickable(driver, loadMoreRoomCategories);
		List<String> allCategoriesExpected=new ArrayList<String>();    
		allCategoriesExpected.add("All rooms");
		allCategoriesExpected.add("Living Room");
		allCategoriesExpected.add("Kitchen");
		allCategoriesExpected.add("Bedroom");
		allCategoriesExpected.add("Dining room");
		allCategoriesExpected.add("Bathroom");
		allCategoriesExpected.add("Office");
		allCategoriesExpected.add("Kids room");
		allCategoriesExpected.add("Game Room");
		loadMoreRoomCategories.click();
		int roomcatgoriesSizeExpected = 9;
		int roomcatgoriesSizeDisplayed = roomsCategories.size();
		if (!(roomcatgoriesSizeDisplayed == roomcatgoriesSizeExpected)) {
			UtilHBM.reportKO("Incorrect number of room categories displayed!! Expected : " + roomcatgoriesSizeExpected
					+ " , Available : " + roomcatgoriesSizeDisplayed);
		}
		for (int i = 0; i < roomcatgoriesSizeDisplayed; i++) {
			Verification.VerifyEquals("Wrong room category!!", roomsCategories.get(i).getText(),
					allCategoriesExpected.get(i));
		}
		UtilHBM.waitExplicitClickable(driver, driver.findElement(
				By.xpath("//div[@id='explore']/div/div/div/ul/li/a[contains(text(),'" + roomCategory + "')]")));
		driver.findElement(
				By.xpath("//div[@id='explore']/div/div/div/ul/li/a[contains(text(),'" + roomCategory + "')]")).click();
		Verification.displayOfWebElement(driver.findElement(By
				.xpath("//div[@id='explore']/div/div/div/ul/li/a[@class='filter-option is-selected'][contains(text(),'"
						+ roomCategory + "')]")));
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration applyFilter(String filterByCategory, String filterByRoom, String filterByStyle,
			String filterByColor, String filterByBrand) {
		UtilHBM.waitExplicitClickable(driver, filterButton);
		filterButton.click();
		UtilHBM.waitExplicitDisplayed(driver, filterHeader);
		UtilHBM.reportInfo("Applying filters :");
		Verification.VerifyEquals("Wrong filter header!!", filterHeader.getText(), "Filters");
		UtilHBM.turnOffImplicitWaits(driver);
		if (!categoryFilter.isEmpty()) {
			UtilHBM.waitExplicitClickable(driver, categoryFilter.get(0).findElement(By.tagName("svg")));
			UtilHBM.waitExplicitClickable(driver, categoryFilter.get(0));
			categoryFilter.get(0).click();
		}
		UtilHBM.turnOnImplicitWaits(driver);
		for (WebElement a : categoryFilterList) {
			if (a.getText().equals(filterByCategory)) {
				a.click();
				Verification.displayNAttributeCheckOfElement(a, "Filter by category", "class",
						"filter-option is-selected");
			}
		}
		UtilHBM.waitExplicitClickable(driver, categoryFilterExpanded);
		categoryFilterExpanded.click();
		UtilHBM.waitFixTime(200);
		UtilHBM.turnOffImplicitWaits(driver);
		boolean isRoomFilterEmpty=roomFilter.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (!isRoomFilterEmpty) {
			UtilHBM.waitExplicitClickable(driver, roomFilter.get(0).findElement(By.tagName("svg")));
			UtilHBM.waitExplicitClickable(driver, roomFilter.get(0));
			roomFilter.get(0).click();
		}
		UtilHBM.waitExplicitClickable(driver, showAllRoom);
		showAllRoom.click();
		UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
		Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Room");
		for (WebElement a : allFilterOptions) {
			if (a.getText().equals(filterByRoom)) {
				a.click();
				Verification.displayNAttributeCheckOfElement(a, "Filter by room", "class", "filter-option is-selected");
			}
		}
		UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
		allFilterOptionsBack.click();
		UtilHBM.waitExplicitClickable(driver, roomFilterExpanded);
		roomFilterExpanded.click();
		UtilHBM.waitFixTime(200);
		if (!filterByStyle.equalsIgnoreCase("NA")) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isStyleFilterEmpty=styleFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isStyleFilterEmpty) {
				UtilHBM.waitExplicitDisplayed(driver, styleFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, styleFilter.get(0));
				styleFilter.get(0).click();
			}
			UtilHBM.waitExplicitClickable(driver, showAllStyles);
			showAllStyles.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Style");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByStyle)) {
					a.click();
					Verification.displayNAttributeCheckOfElement(a, "Filter by style", "class",
							"filter-option is-selected");
					Verification.displayOfWebElement(a.findElement(By.tagName("img")));
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, styleFilterExpanded);
			styleFilterExpanded.click();
		}
		UtilHBM.waitFixTime(200);
		if (!filterByColor.equalsIgnoreCase("NA")) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!colorFilter.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, colorFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, colorFilter.get(0));
				colorFilter.get(0).click();
			}
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitExplicitClickable(driver, showAllColors);
			showAllColors.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Color");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByColor)) {
					a.click();
					Verification.displayNAttributeCheckOfElement(a, "Filter by color", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, colorFilterExpanded);
			colorFilterExpanded.click();
		}
		UtilHBM.waitFixTime(200);
		if (!filterByBrand.equalsIgnoreCase("NA")) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isBrandFilterEmpty=brandFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isBrandFilterEmpty) {
				UtilHBM.waitExplicitClickable(driver, brandFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, brandFilter.get(0));
				brandFilter.get(0).click();
			}
			
			UtilHBM.waitExplicitClickable(driver, showAllBrands);
			showAllBrands.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Brand");
			searchBrand.sendKeys(filterByBrand);
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByBrand)) {
					a.click();
					Verification.displayNAttributeCheckOfElement(a, "Filter by brand", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, brandFilterExpanded);
			brandFilterExpanded.click();
		}
		UtilHBM.waitExplicitClickable(driver, applyfilterButton);
		applyfilterButton.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration verifyFilteredListHeader(String filterByCategory, String filterByRoom,
			String filterByStyle, String filterByColor, String filterByBrand) {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		String headerText = headerText1.getText().toLowerCase();
		String currentURL = driver.getCurrentUrl().toLowerCase();
		String pageTitle = driver.getTitle().toLowerCase();
		String headerTitle1 = headerTitle.getText().toLowerCase();
		if (filterByCategory.equalsIgnoreCase("All") && filterByRoom.equalsIgnoreCase("All rooms")
				&& filterByStyle.equalsIgnoreCase("NA") && filterByColor.equalsIgnoreCase("NA")
				&& filterByBrand.equalsIgnoreCase("NA")) {
			Verification.VerifyEquals("Wronmg header title displayed!!", headerTitle.getText(),
					"Discover decor ideas and inspiration for your home");
			Verification.VerifyEquals("Wrong header text 1 displayed!!", headerText1.getText(),
					"Get inspired by our community images to create your own design Show more");
			Verification.VerifyEquals("Wrong page title displayed!!", driver.getTitle(),
					"Inspiration | HomeByMe community| HomeByMe");
			UtilHBM.reportInfo("Verifying first 10 images displayed in feed when no filters are applied!!");
			UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
			for (int i = 0; i < 4; i++) {
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
			Actions action = new Actions(driver);
			action.moveToElement(headerTitle).build().perform();
		} else {
			if (!filterByRoom.equalsIgnoreCase("All rooms")) {
				if (headerText.contains(filterByRoom.toLowerCase())
						&& currentURL.contains(filterByRoom.toLowerCase().replaceAll(" ", ""))
						&& pageTitle.contains(filterByRoom.toLowerCase())
						&& headerTitle1.contains(filterByRoom.toLowerCase())) {
					UtilHBM.reportOK(filterByRoom
							+ " filter text displayed in page headerText, currentURL, pageTitle, headerTitle1");
				} else {
					UtilHBM.reportKO("Room filter " + filterByRoom
							+ " not displayed in page headerText, currentURL, pageTitle, headerTitle1 !! headerText : "
							+ headerText + ", currentURL : " + currentURL + ", pageTitle : " + pageTitle
							+ ", headerTitle1 : " + headerTitle1);
				}
			}
			if (!filterByStyle.equalsIgnoreCase("NA")) {
				if (headerText.contains(filterByStyle.toLowerCase())
						&& currentURL.contains(filterByStyle.toLowerCase().replaceAll(" ", ""))
						&& pageTitle.contains(filterByStyle.toLowerCase())
						&& headerTitle1.contains(filterByStyle.toLowerCase())) {
					UtilHBM.reportOK(filterByStyle
							+ " filter text displayed in page headerText, currentURL, pageTitle, headerTitle1");
				} else {
					UtilHBM.reportKO("Style filter " + filterByStyle
							+ " not displayed in page headerText, currentURL, pageTitle, headerTitle1 !! headerText : "
							+ headerText + ", currentURL : " + currentURL + ", pageTitle : " + pageTitle
							+ ", headerTitle1 : " + headerTitle1);
				}
			}
			if (!filterByColor.equalsIgnoreCase("NA")) {
				if (headerText.contains(filterByColor.toLowerCase())
						&& currentURL.contains(filterByColor.toLowerCase().replaceAll(" ", ""))
						&& pageTitle.contains(filterByColor.toLowerCase())
						&& headerTitle1.contains(filterByColor.toLowerCase())) {
					UtilHBM.reportOK(filterByColor
							+ " filter text displayed in page headerText, currentURL, pageTitle, headerTitle1");
				} else {
					UtilHBM.reportKO("Color filter " + filterByColor
							+ " not displayed in page headerText, currentURL, pageTitle, headerTitle1 !! headerText : "
							+ headerText + ", currentURL : " + currentURL + ", pageTitle : " + pageTitle
							+ ", headerTitle1 : " + headerTitle1);
				}
			}
			if (!filterByBrand.equalsIgnoreCase("NA")) {
				if (headerText.contains(filterByBrand.toLowerCase())
						&& currentURL.contains(filterByBrand.toLowerCase().replaceAll(" ", ""))
						&& pageTitle.contains(filterByBrand.toLowerCase())
						&& headerTitle1.contains(filterByBrand.toLowerCase())) {
					UtilHBM.reportOK(filterByBrand
							+ " filter text displayed in page headerText, currentURL, pageTitle, headerTitle1");
				} else {
					UtilHBM.reportKO("Brand filter " + filterByBrand
							+ " not displayed in page headerText, currentURL, pageTitle, headerTitle1 !! headerText : "
							+ headerText + ", currentURL : " + currentURL + ", pageTitle : " + pageTitle
							+ ", headerTitle1 : " + headerTitle1);
				}
			}
		}
		int numberOfFiltersAppliedExpected = 0;
		int numberOfFiltersAppliedDisplayed = 0;
		if (!noOfFilterApplied.getText().equals("")) {
			numberOfFiltersAppliedDisplayed = Integer.parseInt(noOfFilterApplied.getText());
		}
		if (!filterByCategory.equalsIgnoreCase("All")) {
			numberOfFiltersAppliedExpected++;
		}
		if (!filterByRoom.equalsIgnoreCase("All rooms")) {
			numberOfFiltersAppliedExpected++;
		}
		if (!filterByStyle.equalsIgnoreCase("NA")) {
			numberOfFiltersAppliedExpected++;
		}
		if (!filterByColor.equalsIgnoreCase("NA")) {
			numberOfFiltersAppliedExpected++;
		}
		if (!filterByBrand.equalsIgnoreCase("NA")) {
			numberOfFiltersAppliedExpected++;
		}
		if (numberOfFiltersAppliedExpected == numberOfFiltersAppliedDisplayed) {
			UtilHBM.reportOK("Correct number of filters displayed on filter icon!!");
		} else {
			UtilHBM.reportKO("Incorrect number of filters displayed on filter icon!! Expected : "
					+ numberOfFiltersAppliedExpected + " , Available : " + numberOfFiltersAppliedDisplayed);
		}
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration checkMediaListDisplayed() {
		int limit = 2;
		if (mediaList.size() <= limit) {
			limit = mediaList.size();
		} else {
			UtilHBM.reportInfo(
					"More than 2 images displayed in filter results!!Verifying first " + limit + " from the list : ");
		}
		UtilHBM.reportInfo("Verifying first " + limit + " filter results displayed in feed when filters are applied!!");
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
		Actions action = new Actions(driver);
		action.moveToElement(headerTitle).build().perform();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration checkFilterResults(boolean isFilterResultsExpected, String filterByCategory, String filterByRoom, String filterByStyle,
			String filterByColor, String filterByBrand) {
		UtilHBM.waitExplicitDisplayed(driver, filterButton);
		Actions action = new Actions(driver);
		action.moveToElement(headerTitle).build().perform();
		int filterResults = mediaList.size();
		UtilHBM.reportInfo("Filter results displayed!! " + filterResults);
		if (isFilterResultsExpected) {
			if (filterResults > 2) {
				UtilHBM.reportOK("More than 2 results displayed for applied filters");
			} else {
				UtilHBM.reportOK("Number of results displayed for applied filters : " + filterResults);
			}
			int limit = 2;
			if (mediaList.size() <= limit) {
				limit = mediaList.size();
			} else {
				UtilHBM.reportInfo("More than 2 images displayed in filter results!!Verifying first " + limit
						+ " from the list : ");
			}
			UtilHBM.reportInfo("Verifying filter results displayed in feed when filters are applied!!");
			UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
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
			Actions action1 = new Actions(driver);
			action1.moveToElement(headerTitle).build().perform();
			String userName = mediaList.get(0)
					.findElement(
							By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div/div/span"))
					.getText();
			openImageAtIndex(0).verifyMediaPage(userName, "", "No", filterByCategory + ";" + filterByRoom + ";"
					+ filterByStyle + ";" + filterByColor + ";" + filterByBrand).goToGallery();
		} else {
			if (filterResults == 0) {
				String noResultImgSrc=noResults.findElement(By.tagName("img")).getAttribute("src");
				if (noResultImgSrc.contains(
						"/dist/images/no-image.11f89af488e49cefed70858438b7eb25.svg")) {
					UtilHBM.reportOK("No results image displayed sucessfully");
				} else {
					UtilHBM.reportKO("No results image not displayed!!");
				}
				Verification.VerifyEquals("Wrong no results text", noResults.getText(),
						"We don't have any results to display according to the filters you have chosen");
				Verification.VerifyEquals("Wrong You may also like text", youMayAlsoLike.getText(),
						"You may also like\nDiscover also different kinds of inspiration thanks to HomeByMe users");
				UtilHBM.waitExplicitDisplayed(driver, mediaListWhenNoResults.get(0));
				int mediaListWhenNoResults1 = mediaListWhenNoResults.size();
				if (mediaListWhenNoResults1 > 0) {
					UtilHBM.reportOK(
							"Media list displayed in you may also like section when no filter results available");
					UtilHBM.reportInfo(
							"Verifying first 2 images displayed in you may also like section when no filter results available!!");
					for (int i = 0; i < 2; i++) {
						WebElement imageExpected = mediaListWhenNoResults.get(i);
						Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
						String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
						if (!imgSrc.contains("https://")) {
							UtilHBM.reportKO("Image not displayed!!");
						}
						Actions actions = new Actions(driver);
						actions.moveToElement(imageExpected).build().perform();
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
						WebElement bookmark = imageExpected
								.findElement(By.xpath("div/div/span[@class='img item-link']"));
						Verification.displayOfWebElement(addToCollectionText);
						Verification.displayOfWebElement(userProfileLink);
						Verification.displayOfWebElement(bookmark);
					}
				} else if (mediaListWhenNoResults1 == 0) {
					UtilHBM.reportKO(
							"Media list not displayed in you may also like sectio when no filter results!!! Number of media displayed : "
									+ mediaListWhenNoResults1);
				}
			} else {
				UtilHBM.reportKO("Filter results displayed!!!No results expected from fiters!!");
			}
		}
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration verifyTagsInFeed(String tagToCheck) {
		UtilHBM.reportInfo("Verifying tag on inspiration page :" + tagToCheck);
		List<String> roomOptions = Arrays.asList("All rooms", "Living Room", "Kitchen", "Bedroom", "Dining room",
				"Bathroom", "Office", "Kids room", "Game Room");
		List<String> colorOptions = Arrays.asList("Beige", "Black", "Blue", "Brown", "Green", "Grey", "Orange", "Pink",
				"Red", "White", "Yellow", "Purple");
		List<String> brandOptions = Arrays.asList("All Modern", "Castorama", "CB2", "Cole & Son", "Crate & Barrel",
				"Eichholtz", "Farrow & Ball", "Fermob", "Flos", "Gautier", "Habitat", "Holly Hunt", "Homary",
				"Isidore Leroy", "Juniqe", "Kathy Kuo Home", "Lampatron", "La Redoute Interieurs", "Le French Design",
				"Ligne Roset", "Made", "Magnolia", "Maisons du monde", "Neology", "Open Desk", "Overstock",
				"Pottery Barn", "Ralph Lauren Home", "Restoration Hardware", "Smeg", "Vitra", "Waterfall Audio",
				"Wayfair", "West Elm", "Williams Sonoma");
		List<String> categoryOptions = Arrays.asList("All", "Staff picks");
		List<String> styleOptions = Arrays.asList("Bohemian", "Coastal", "Contemporary", "Hollywood Regency",
				"Mid-Century Modern", "Minimalist", "Modern Farmhouse", "Scandinavian");
		if (roomOptions.contains(tagToCheck)) {
			verifyFilters("All", tagToCheck, "NA", "NA", "NA");
		} else if (colorOptions.contains(tagToCheck)) {
			verifyFilters("All", "All rooms", "NA", tagToCheck, "NA");
		} else if (brandOptions.contains(tagToCheck)) {
			verifyFilters("All", "All rooms", "NA", "NA", tagToCheck);
		} else if (categoryOptions.contains(tagToCheck)) {
			verifyFilters(tagToCheck, "All rooms", "NA", "NA", "NA");
		} else if (styleOptions.contains(tagToCheck)) {
			verifyFilters("All", "All rooms", tagToCheck, "NA", "NA");
		} else {
			UtilHBM.reportKO("Tag not available in inspiration filter lists!! Tag name : " + tagToCheck);
		}
		return this;
	}

	public DecorationInspiration verifyFilters(String filterByCategory, String filterByRoom, String filterByStyle,
			String filterByColor, String filterByBrand) {

		verifyFilteredListHeader(filterByCategory, filterByRoom, filterByStyle, filterByColor, filterByBrand);
		UtilHBM.waitExplicitClickable(driver, filterButton);
		filterButton.click();
		UtilHBM.waitExplicitDisplayed(driver, filterHeader);
		UtilHBM.waitExplicitDisplayed(driver, roomFilter.get(0).findElement(By.tagName("svg")));
		Verification.VerifyEquals("Wrong filter header!!", filterHeader.getText(), "Filters");
		if (!filterByCategory.equalsIgnoreCase("All")) {
			Verification.VerifyEquals("Wrong categoryFilterApplied!!", categoryFilterApplied.getText(),
					filterByCategory);
			UtilHBM.turnOffImplicitWaits(driver);
			if (!categoryFilter.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, categoryFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, categoryFilter.get(0));
				categoryFilter.get(0).click();
			}
			UtilHBM.turnOnImplicitWaits(driver);
			for (WebElement a : categoryFilterList) {
				if (a.getText().equals(filterByRoom)) {
					Verification.displayNAttributeCheckOfElement(a, "Filter by category", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, categoryFilterExpanded);
			categoryFilterExpanded.click();
			UtilHBM.waitFixTime(200);
		}
		if (!filterByRoom.equalsIgnoreCase("All rooms")) {
			Verification.VerifyEquals("Wrong roomFilterApplied!!", roomFilterApplied.getText(), filterByRoom);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isRoomFilterEmpty=roomFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isRoomFilterEmpty) {
				UtilHBM.waitExplicitClickable(driver, roomFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, roomFilter.get(0));
				roomFilter.get(0).click();
			}
			UtilHBM.waitExplicitClickable(driver, showAllRoom);
			showAllRoom.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Room");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByRoom)) {
					Verification.displayNAttributeCheckOfElement(a, "Filter by room", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, roomFilterExpanded);
			roomFilterExpanded.click();
			UtilHBM.waitFixTime(200);
		}
		if (!filterByStyle.equalsIgnoreCase("NA")) {
			Verification.VerifyEquals("Wrong styleFilterApplied!!", styleFilterApplied.getText(), filterByStyle);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isStyleFilterEmpty=styleFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isStyleFilterEmpty) {
				UtilHBM.waitExplicitClickable(driver, styleFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, styleFilter.get(0));
				styleFilter.get(0).click();
			}
			UtilHBM.waitExplicitClickable(driver, showAllStyles);
			showAllStyles.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Style");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByStyle)) {
					Verification.displayNAttributeCheckOfElement(a, "Filter by style", "class",
							"filter-option is-selected");
					Verification.displayOfWebElement(a.findElement(By.tagName("img")));
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, styleFilterExpanded);
			styleFilterExpanded.click();
			UtilHBM.waitFixTime(200);
		}
		if (!filterByColor.equalsIgnoreCase("NA")) {
			Verification.VerifyEquals("Wrong colorFilterApplied!!", colorFilterApplied.getText(), filterByColor);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isColorFilterEmpty=colorFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isColorFilterEmpty) {
				UtilHBM.waitExplicitClickable(driver, colorFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, colorFilter.get(0));
				colorFilter.get(0).click();
			}
			UtilHBM.waitExplicitClickable(driver, showAllColors);
			showAllColors.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Color");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByColor)) {
					Verification.displayNAttributeCheckOfElement(a, "Filter by color", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, colorFilterExpanded);
			colorFilterExpanded.click();
			UtilHBM.waitFixTime(200);
		}
		if (!filterByBrand.equalsIgnoreCase("NA")) {
			Verification.VerifyEquals("Wrong brandFilterApplied!!", brandFilterApplied.getText(), filterByBrand);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isBrandFilterEmpty=brandFilter.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isBrandFilterEmpty) {
				UtilHBM.waitExplicitClickable(driver, brandFilter.get(0).findElement(By.tagName("svg")));
				UtilHBM.waitExplicitClickable(driver, brandFilter.get(0));
				brandFilter.get(0).click();
			}
			UtilHBM.waitExplicitClickable(driver, showAllBrands);
			showAllBrands.click();
			UtilHBM.waitExplicitDisplayed(driver, allFilterOptionsHeader);
			Verification.VerifyEquals("Wromg allFilterOptionsHeader", allFilterOptionsHeader.getText(), "Brand");
			for (WebElement a : allFilterOptions) {
				if (a.getText().equals(filterByBrand)) {
					Verification.displayNAttributeCheckOfElement(a, "Filter by brand", "class",
							"filter-option is-selected");
				}
			}
			UtilHBM.waitExplicitClickable(driver, allFilterOptionsBack);
			allFilterOptionsBack.click();
			UtilHBM.waitExplicitClickable(driver, brandFilterExpanded);
			brandFilterExpanded.click();
			UtilHBM.waitFixTime(200);
		}
		UtilHBM.waitExplicitClickable(driver, filterClose);
		filterClose.click();
		
		
//		Verification.VerifyEquals("Wrong filter1 option selected!!",
//				filter1.findElement(By.cssSelector("p.title")).getText(), filterByRoom);
//		Verification.VerifyEquals("Wrong filter2 name!!", filter2.findElement(By.cssSelector("p.label")).getText(),
//				"Color");
//		Verification.VerifyEquals("Wrong filter2 option selected!!",
//				filter2.findElement(By.cssSelector("p.title")).getText(), filterByColor);
//		Verification.VerifyEquals("Wrong filter3 name!!", filter3.findElement(By.cssSelector("p.label")).getText(),
//				"Brand");
//		Verification.VerifyEquals("Wrong filter3 option selected!!",
//				filter3.findElement(By.cssSelector("p.title")).getText(), filterByBrand);
		
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration clearFilters() {
		UtilHBM.waitExplicitClickable(driver, filterButton);
		filterButton.click();
		UtilHBM.waitExplicitDisplayed(driver, filterHeader);
		UtilHBM.reportInfo("Clearing filters!!");
		UtilHBM.waitExplicitDisplayed(driver, clearAllFilters);
		UtilHBM.waitExplicitClickable(driver, clearAllFilters);
		clearAllFilters.click();
		UtilHBM.waitExplicitClickable(driver, applyfilterButton);
		applyfilterButton.click();
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public DecorationInspiration verifyFeedPage() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		Verification.VerifyEquals("Wronmg header title displayed for Feed page!!", headerTitle.getText(),
				"Discover decor ideas and inspiration for your home");
		Verification.VerifyEquals("Wrong header text 1 displayed at first!!", headerText1.getText(),
				"Get inspired by our community images to create your own design\n\n\n\n\n\n\n\n\nShow more");
		UtilHBM.waitExplicitClickable(driver, showMoreInfoIcon);
		showMoreInfoIcon.click();
		Verification.VerifyEquals("Wrong header text 1 displayed after clicking showMoreInfo icon!!",
				headerText1.getText(), "Get inspired by our community images to create your own designLooking for inspiration? Browse through the images created by The HomeByMe community to find home design ideas. Select an image to see the products in detail and get design inspiration for your own interior design project !\n\nOur thread of inspiration allows you to discover all the achievements created by our community to meet your needs. The filters let you select the themes that interest you, whether it is a piece, a color or even a brand.\n\nWhether you are looking for the latest trends, or simple decoration ideas for your home or even your garden, our inspiration thread will guide you and allow you to express your creativity. From the bedroom to the living room, through the bathroom, the hallways, the dining room, the playroom and even the laundry room, all the rooms of a house are there to help you realize all your home design projects.\nBrowse through our thread, select the creations that inspire you and create your own project, mixing styles and making your realization unique! Find the home design ideas that suit you thanks to our search tool and explore thousands of projects. Post your projects to enrich the community with your creations and inspire those around you.\n\nFor more Décor ideas, check out our latest articles on our Interior design Magazine!\n\nDid you finally find the idea you were looking for and would like to start your interior design project? Before starting any home improvement work, create your house floor plans to visualize your dream interior as if you were there. HomeByMe is a complete and easy-to-use free home plan software, so start your project now by signing up, it's without commitment!Show less");
		showLessInfoIcon.click();
		Verification.VerifyEquals("Wrong header text 1 displayed after clicking show less!!", headerText1.getText(),
				"Get inspired by our community images to create your own design\n\n\n\n\n\n\n\n\nShow more");
		for (int i = 0; i < 4; i++) {
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
			UtilHBM.waitExplicitDisplayed(driver, imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']")));
			WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
			Verification.displayOfWebElement(addToCollectionText);
			Verification.displayOfWebElement(userProfileLink);
			Verification.displayOfWebElement(bookmark);
		}
//		VerifyShareMedia(0);
		String userName = mediaList.get(0)
				.findElement(
						By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div/div/span"))
				.getText();
		openImageAtIndex(0).verifyMediaPage(userName, "", "No", "All;All rooms;NA;NA;NA").goToGallery();
		UtilHBM.webElement(driver, "body").sendKeys(Keys.PAGE_DOWN);
//		Verification.displayOfWebElement(clearFiltersSticky);
//		UtilHBM.waitExplicitClickable(driver, closeStickyFilters);
//		closeStickyFilters.click();
//		UtilHBM.waitExplicitClickable(driver, openStickyFilters);
//		openStickyFilters.click();
//		Verification.displayOfWebElement(clearFiltersSticky);
//		UtilHBM.webElement(driver, "body").sendKeys(Keys.PAGE_DOWN);
		return this;
	}

//	public DecorationInspiration verifyMediaPage(String isUserLoggedYesOrNo) {
//		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
//		new Actions(driver).moveToElement(mediaList.get(0)).build().perform();
//		String firstUser = mediaList.get(0)
//				.findElement(By.xpath("div[@class='caption']/a[1]/div/div[@class='infos-user']")).getText();
//		UtilHBM.reportInfo("User of first media : " + firstUser);
//		String viewCount = "";
//		openImageAtIndex(0).verifyMediaPage(firstUser, viewCount, isUserLoggedYesOrNo, "All rooms;All colors;All brands").goToGallery();
//		return this;
//	}

	public DecorationInspiration goToBottomOfList() {
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(500);
		}
		return this;
	}
	
	public DecorationInspiration verifyMediaAvailableAtIndex(int index) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		List<WebElement> mediaList1 = driver.findElements(By.xpath(
				 "//*[@id='explore']/div[3]/div/div[@class='tag image-related']"));
		String imgSrc = mediaList1.get(index).findElement(By.xpath("div/a/img")).getAttribute("src");
		assertTrue(imgSrc.contains("https://") && imgSrc.contains("/images/renderHQ/"));
		UtilHBM.reportOK("Image available at index : " + index + " , ImgSrc : " + imgSrc);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public FeaturedMediaPage openImageAtIndex(int index) {
		String imgSrc = null;
		for (int i = 0; i <= index; i++) {
			WebElement imageExpected = mediaList.get(i).findElement(By.xpath("div/a/img"));
			Verification.displayOfWebElement(imageExpected);
			Actions actions = new Actions(driver);
			actions.moveToElement(imageExpected).build().perform();
			imgSrc = imageExpected.getAttribute("src");
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
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public AddToFavorites clickCollectionIconFirstImage(int mediaIndex) {
		WebElement imageExpected = mediaList.get(mediaIndex);
		Actions actions = new Actions(driver);
		actions.moveToElement(imageExpected).build().perform();
		WebElement addToCollectionText = imageExpected
				.findElement(By.xpath("div/div/div[@class='legend'][contains(text(),'Add to collection')]"));
		WebElement noOfProductsText = imageExpected.findElement(By.xpath("div/div[@class='caption-footer']/div"));
		WebElement userProfileLink = imageExpected
				.findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
		Verification.displayOfWebElement(addToCollectionText);
		Verification.displayOfWebElement(noOfProductsText);
		Verification.displayOfWebElement(userProfileLink);
		WebElement bookmark = imageExpected.findElement(By.xpath("div/div/span[@class='img item-link']"));
		UtilHBM.waitExplicitDisplayed(driver, bookmark);
		UtilHBM.waitExplicitClickable(driver, bookmark);
		bookmark.click();
		return PageFactory.initElements(driver, AddToFavorites.class);
	}

	public MyFavorites goToMyCollections() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}

	public String getImgSrc(int index) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		UtilHBM.waitExplicitDisplayed(driver,
				mediaList.get(index).findElement(By.xpath("div/a/img[contains(@src,'https://')]")));
		WebElement imgPath = mediaList.get(index).findElement(By.cssSelector("div>a>img"));
		String imgSrc = imgPath.getAttribute("src");
		return imgSrc;
	}

	public FavoritesListPage addItemInCollectionFromFeed(boolean isNewCollection, boolean isItemAlreadyAvailableInCollection,
			String collectionName, int noOfImages, int noOfProducts, String itemType) {
		if (itemType.equals("Product")) {
			openImageAtIndex(0).clickFurnituresDisplayed().openFirstFurniture("Yes");
			ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
			String prdName = productInfo.getPrdName();
			String brndName = productInfo.getBrndName();
			String prdImgSrc = productInfo.getPrdImgSrc();
			productInfo.clickProductBookmark().addToCollection(isNewCollection, collectionName, itemType);
			DecorationInspiration decorationInspiration1 = PageFactory.initElements(driver,
					DecorationInspiration.class);
			decorationInspiration1.verifyAddToCollectionSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				decorationInspiration1.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, prdName + ";" + brndName + ";" + prdImgSrc)
					.openProductsTab(noOfProducts)
					.verifyCollectionItem(itemType, prdName + ";" + brndName);
			}
		} else if (itemType.equals("Image")) {
			DecorationInspiration decorationInspiration = PageFactory.initElements(driver, DecorationInspiration.class);
			String imgSrc1 = decorationInspiration.getImgSrc(0);
			String imgAttribute = imgSrc1.substring(imgSrc1.lastIndexOf("/") + 1, imgSrc1.indexOf("_"));
			clickCollectionIconFirstImage(0).addToCollection(isNewCollection, collectionName, itemType);
			DecorationInspiration decorationInspiration1 = PageFactory.initElements(driver,
					DecorationInspiration.class);
			decorationInspiration1.verifyAddToCollectionSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				decorationInspiration1.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, imgAttribute)
					.openImagesTab(noOfImages)
					.verifyCollectionItem(itemType, imgAttribute);
			}
		}
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}

	public FavoritesListPage addItemInCollectionFrmImgPage(boolean isNewCollection, boolean isItemAlreadyAvailableInCollection,
			String collectionName, int noOfImages, int noOfProducts, String itemType) {
		if (itemType.equals("Product")) {
			openImageAtIndex(1).clickProductPinButton().clickpinProduct(0).openProductSheet();
			ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
			String prdImgSrc = productInfo.getPrdImgSrc();
			productInfo.clickProductInfoCloseButton();
			FeaturedMediaPage featuredMediaPage = PageFactory.initElements(driver, FeaturedMediaPage.class);
			featuredMediaPage.clickpinProduct(0);
			String prdAttribute = featuredMediaPage.getPrdAttributeFrmPin();
			String prdName = prdAttribute.split(";")[0];
			String brndName = prdAttribute.split(";")[1];
			featuredMediaPage.addToCollectionFromPin().addToCollection(isNewCollection, collectionName, itemType);
			FeaturedMediaPage featuredMediaPage1 = PageFactory.initElements(driver, FeaturedMediaPage.class);
			featuredMediaPage1.verifyAddToCollectionSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				featuredMediaPage1.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, prdName + ";" + brndName + ";" + prdImgSrc)
					.openProductsTab(noOfProducts)
					.verifyCollectionItem(itemType, prdName + ";" + brndName + ";" + prdImgSrc);
			}
		} else if (itemType.equals("Image")) {
			DecorationInspiration decorationInspiration = PageFactory.initElements(driver, DecorationInspiration.class);
			String imgSrc1 = decorationInspiration.getImgSrc(1);
			String imgAttribute = imgSrc1.substring(imgSrc1.lastIndexOf("/") + 1, imgSrc1.indexOf("_"));
			decorationInspiration.openImageAtIndex(1).clickImageBookmark().addToCollection(isNewCollection, collectionName,
					itemType);
			FeaturedMediaPage featuredMediaPage = PageFactory.initElements(driver, FeaturedMediaPage.class);
			featuredMediaPage.verifyAddToCollectionSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				featuredMediaPage.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, imgAttribute)
					.openImagesTab(noOfImages)
					.verifyCollectionItem(itemType, imgAttribute);
			}
		}
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}

	public DecorationInspiration VerifyShareMedia(int mediaIndex) {
		clickShareMediaButton(mediaIndex);
		ShareContainer shareContainer = PageFactory.initElements(driver, ShareContainer.class);
		shareContainer.verifyShareContainerNew().GoBackToFeedPage();
		return this;
	}

	public ShareContainer clickShareMediaButton(int mediaIndex) {
		Actions actions = PageFactory.initElements(driver, Actions.class);
		actions.moveToElement(mediaList.get(mediaIndex)).build().perform();
		WebElement shareButton1 = mediaList.get(mediaIndex)
				.findElement(By.xpath("div[@class='caption']/div/span[@class='share item-link']"));
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		shareButton1.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}

//	public DecorationInspiration verifyUserProfilePage(int mediaIndex, String isUserLoggedYesOrNo) {
//		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(mediaIndex - 1));
//		WebElement imageExpected = mediaList.get(mediaIndex - 1);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(imageExpected).build().perform();
//		String selectedUserName = mediaList.get(mediaIndex - 1).findElement(By.xpath(
//				"div/div[@class='caption-footer']/a[@class='user']/div[@class='image-user ']/div[@class='user-name']/span"))
//				.getText();
//		clickUserProfileLink(mediaIndex - 1).verifyUserDetails("others", selectedUserName).verifyMyPictures("others",
//				"", selectedUserName, true);
//		return this;
//	}

	public UserProfilePage clickUserProfileLink(String userName) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		UtilHBM.waitFixTime(1000);
		WebElement imageExpected = null;
		boolean imageFound = false;
		for (int i = 0; i < 50; i++) {
			if (i == 3 || (i + 1) % 8 == 0) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			}
			Actions actions = new Actions(driver);
			actions.moveToElement(mediaList.get(i).findElement(By.xpath(
					"div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div[@class='image-user ']/div[@class='user-name']/span")))
					.build().perform();
			String currentUser = mediaList.get(i).findElement(By.xpath(
					"div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div[@class='image-user ']/div[@class='user-name']/span"))
					.getText();
			if (currentUser.equals(userName)) {
				imageExpected = mediaList.get(i);
				imageFound = true;
				break;
			} else {
				continue;
			}
		}
		if (!imageFound) {
			UtilHBM.reportKO("Image not displayed for user : " + userName);
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(imageExpected).build().perform();
		WebElement expectedUserProfileLink = imageExpected
				.findElement(By.xpath("div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]"));
		UtilHBM.waitExplicitDisplayed(driver, expectedUserProfileLink);
		UtilHBM.waitExplicitClickable(driver, expectedUserProfileLink);
		Verification.displayOfWebElement(expectedUserProfileLink);
		expectedUserProfileLink.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public FeaturedMediaPage openImageOfUser(String userName) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		UtilHBM.waitFixTime(1000);
		WebElement imageExpected = null;
		boolean imageFound = false;
		for (int i = 0; i < 20; i++) {
			Actions actions = new Actions(driver);
			actions.moveToElement(mediaList.get(i)).build().perform();
			UtilHBM.waitFixTime(500);
			String currentUser = mediaList.get(i).findElement(By.xpath(
					"div/div[@class='caption-footer']/a[contains(@href,'/en/profile/')]/div[@class='image-user ']/div[@class='user-name']/span"))
					.getText();
			if (currentUser.equals(userName)) {
				imageExpected = mediaList.get(i);
				imageFound = true;
				break;
			} else {
				continue;
			}
		}
		if (!imageFound) {
			UtilHBM.reportKO("Image not displayed for user : " + userName);
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(imageExpected).build().perform();
		UtilHBM.waitFixTime(500);
		WebElement expectedImgLink = imageExpected.findElement(By.xpath("div"));
		UtilHBM.reportInfo(
				"Opening image of user : " + userName + " , Image link : " + expectedImgLink.getAttribute("href"));
		UtilHBM.waitExplicitDisplayed(driver, expectedImgLink);
		UtilHBM.waitExplicitClickable(driver, expectedImgLink);
		Verification.displayOfWebElement(expectedImgLink);
		expectedImgLink.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}

	public Gallery goToGallery() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitClickable(driver, galleryLink);
		galleryLink.click();
		return PageFactory.initElements(driver, Gallery.class);
	}

	public DecorationInspiration verifyAddToCollectionSuccess(String collectionName, boolean isItemAlreadyAvailableInCollection) {
		if (isItemAlreadyAvailableInCollection) {
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
					addToCollectionSuccess.getText(), "Added to " + collectionName);
			UtilHBM.waitExplicitDisplayed(driver, closeAddToCollectionSuccess);
			UtilHBM.waitExplicitClickable(driver, closeAddToCollectionSuccess);
			closeAddToCollectionSuccess.click();
			UtilHBM.waitFixTime(500);
		}
		return this;
	}
	
	public DecorationInspiration addToStaffPicks() {
		UtilHBM.waitExplicitDisplayed(driver, filterButton);
		UtilHBM.reportInfo("Verifying filter results displayed in feed when filters are applied!!");
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(0));
		boolean isImageAlreadyStaffPicked = true;
		UtilHBM.waitFixTime(1000);
		int noImgsToCheckInFeed = 30;
		for (int i = 0; i < noImgsToCheckInFeed; i++) {
			if ((i + 1) % 8 == 0) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			}
			WebElement imageExpected = mediaList.get(i);
			Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
			String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
			if (!imgSrc.contains("https://")) {
				UtilHBM.reportKO("Image not displayed!!");
			}
			Actions actions = new Actions(driver);
			actions.moveToElement(imageExpected).perform();
			UtilHBM.waitFixTime(1000);
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(imageExpected).build().perform();
			UtilHBM.waitExplicitDisplayed(driver,
					imageExpected.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img")));
			WebElement addToStaffPicksIcon = imageExpected
					.findElement(By.xpath("div/div/div[@class='staff-pick']/span/img"));
			String addToStaffPicksIconAttribute = addToStaffPicksIcon.getAttribute("src");
			if (!addToStaffPicksIconAttribute.contains("quality-focus1")) {
				isImageAlreadyStaffPicked = false;
				String imgAttribute = imgSrc.substring(imgSrc.indexOf("/renderHQ/") + 10, imgSrc.indexOf("_"));
				UtilHBM.setProperty("testData", "ImgAddedToStaffPick", imgAttribute);
				UtilHBM.reportInfo("Adding image in staff picks : " + imgAttribute);
				addToStaffPicksIcon.click();
				UtilHBM.waitFixTime(500);
				if (addToStaffPicksIcon.getAttribute("src").contains("quality-focus1")) {
					UtilHBM.reportOK("Image added in staff picks");
				} else {
					UtilHBM.reportKO("Image not added in staff picks");
				}
				break;
			}
		}
		if (isImageAlreadyStaffPicked) {
			UtilHBM.reportKO("First " + noImgsToCheckInFeed + " images are already added in staff picks!!");
		}
		return this;
	}
	
	public DecorationInspiration verifyImageAddedInStaffPick() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		boolean isImageAvailableWithStaffPicksFilter = false;
		String imgAttribute = UtilHBM.getProperty("testData", "ImgAddedToStaffPick");
		UtilHBM.waitFixTime(1000);
		int limit = 20;
		for (int i = 0; i < limit; i++) {
			WebElement imageExpected = mediaList.get(i);
			Verification.displayOfWebElement(imageExpected.findElement(By.xpath("div/a/img")));
			String imgSrc = imageExpected.findElement(By.xpath("div/a/img")).getAttribute("src");
			if (imgSrc.contains(imgAttribute)) {
				isImageAvailableWithStaffPicksFilter = true;
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
					openMediaPage(imageExpected).verifyMediaDisplayed();
					driver.navigate().back();
					break;
				} else {
					UtilHBM.reportKO("Staff picks icon is not selected for image added in staff pick page!!");
				}
			}
		}
		if (!isImageAvailableWithStaffPicksFilter) {
			UtilHBM.reportKO("Image added in staff picks not displayed in first " + limit + " images!!");
		}
		return this;
	}
	
	public DecorationInspiration verifyImageRemovedFrmStaffPick() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		for (int i = 0; i < 6; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(500);
		}
		String imgAttribute = UtilHBM.getProperty("testData", "ImgAddedToAtaffPick");
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> expectedImage = driver.findElements(
				By.xpath("//*[@id='explore']/div[3]/div/div[@class='tag image-related']/div/a/img[contains(@src,'"
						+ imgAttribute + "')]"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (!expectedImage.isEmpty()) {
			UtilHBM.reportKO(
					"Image removed from staff picks is displayed with staff pick filter in inspiration page!! , Img Src : "
							+ expectedImage.get(0).getAttribute("src"));
		} else {
			UtilHBM.reportOK(
					"Images removed from staff picks is not displayed with staff pick filter in inspiration page!!");
		}
		return this;
	}
	
	public FeaturedMediaPage openMediaPage(WebElement imgPath) {
		UtilHBM.waitExplicitDisplayed(driver, imgPath);
		UtilHBM.waitExplicitClickable(driver, imgPath);
		imgPath.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public LandingPage logout(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(2000);
		if (userAvatar.isDisplayed()){			
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
	
	public Magazine goToMagazine() {
		UtilHBM.waitExplicitDisplayed(driver, magazine);
		Actions actions=new Actions(driver);
		actions.moveToElement(magazine).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, magazineHomePage);
		UtilHBM.waitExplicitClickable(driver, magazineHomePage);
		magazineHomePage.click();
		return PageFactory.initElements(driver, Magazine.class);
	}
	
	public DecorationInspiration verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Inspiration | HomeByMe community| HomeByMe")) {
			UtilHBM.reportOK("Inspiration page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("Inspiration page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
}