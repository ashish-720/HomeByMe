package hbm.web.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class FavoritesListPage {

	WebDriver driver;

	public FavoritesListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle") 
	private WebElement userAvatar;

	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;

	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My Collections']/span[contains(text(),'My Collections')]")
	private WebElement myCollections;

	@FindBy(css = "div.collection-title>h2>div>span.span-inline-edit.active")
	private WebElement favListName;
	
	@FindBy(css = "div.collection-title>h2>div")
	private WebElement collectionNameBox;

	@FindBy(css = "button.bt-icon>span.icon-action-edit")
	private WebElement editfavListName;

	@FindBy(css = "div.collection-title>h2>div>input[class='input-inline-edit input-inline-edit--active']")
	private WebElement collectionNameActiveInput;

	@FindBy(id = "collection-actions")
	private WebElement collectionActions;
	
	@FindBy(xpath = "//body[@class='ReactModal__Body--open']//div[@class='mod-sheet-actions']/div/div[@class='sheet-body']/span[text()='Edit collection']")
	private WebElement editCollection;
	
	@FindBy(xpath = "//body[@class='ReactModal__Body--open']//div[@class='mod-sheet-actions']/div/div[@class='sheet-body']/span[text()='Rename collection']")
	private WebElement renameCollection;
	
	@FindBy(xpath = "//body[@class='ReactModal__Body--open']//div[@class='mod-sheet-actions']/div/div[@class='sheet-body']/span[@class='sheet-attention'][text()='Delete collection']")
	private WebElement deleteCollection;
	
	@FindBy(css = "button.button--alt.delete-favorite.delete-icon")
	private WebElement deleteButton;

	@FindBy(css = "button.button--alt.delete-favorite.delete-icon")
	private WebElement deleteButton1;

	@FindBy(css = "div.sheet-header>h2.modal-title")
	private WebElement deleteDialogHeader;

	@FindBy(css = "div.sheet-header>button.bt-icon")
	private WebElement closeDeleteDialog;

	@FindBy(css = "div.sheet-body>p:nth-child(1)")
	private WebElement confirmText1;

	@FindBy(css = "div.sheet-body>p:nth-child(2)")
	private WebElement confirmText2;

	@FindBy(css = "div.sheet-body>div>button.sheet-button.button--alt")
	private WebElement cancelButton;

	@FindBy(css = "div.sheet-body>div>button.sheet-button.button")
	private WebElement confirmDeleteButton;

	@FindBy(css = "div.react-tabs>ul>li")
	private List<WebElement> tabList;
	
	@FindBy(xpath = "//div[@class='react-tabs']/ul/li[contains(@class,'tab-title-button')]/span[contains(text(),'Products')]")
	private WebElement productsTab;
	
	@FindBy(xpath = "//div[@class='react-tabs']/ul/li[contains(@class,'tab-title-button')]/span[contains(text(),'Images')]")
	private WebElement imagesTab;
	
	@FindBy(xpath = "//div[@class='react-tabs']/ul/li[@class='tab-title-button']/span[contains(text(),'All')]")
	private WebElement allItemsTab;
	
	@FindBy(xpath = "//div[@class='react-tabs']/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/div/div[contains(@class,'grid-item')]")
	private List<WebElement> allItemsList;

	@FindBy(xpath = "//div[@class='react-tabs']/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/ul/li")
	private List<WebElement> productsList;

	@FindBy(xpath = "//div[@class='react-tabs']/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/div/div/div[@class='tag image-related']")
	private List<WebElement> imagesList;

	@FindBy(css = "div#collection>div>div>div>div>div.no-result>img[src='/dist/images/item.0ff12cc39d43b3c03e5d7fa3fa527ee2.svg']")
	private WebElement noResultsImg;

	@FindBy(css = "div#collection>div>div>div>div>div.no-result")
	private WebElement noResultsText;

	@FindBy(css = "div#collection>div>div>div>div>div.no-result>a")
	private WebElement findInspiration;

	@FindBy(xpath = "//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement myProjects;

	@FindBy(xpath = "//nav[@class='header__nav']/a[contains(@href,'/en/inspiration')]/span[.='Inspiration']")
	private WebElement galleryLink;
	
	@FindBy(xpath = "//div[@id='header-context']/div/div/span[@class='selected-count']")
	private WebElement selectedCount;
	
	@FindBy(xpath = "//div[@id='header-context']/div/div/span[@class='selected-switch'][text()='Unselect all']")
	private WebElement unselectAll;
	
	@FindBy(xpath = "//div[@id='header-context']/div/div/span[@class='selected-switch'][text()='Select all']")
	private WebElement selectAll;
	
	@FindBy(xpath = "//div[@id='header-context']/div/div/span[text()='Cancel']")
	private WebElement cancelEdit;
	
	@FindBy(css = "div#header-context>div>div>button[class='button--alt'][disabled]")
	private WebElement deleteButtonDisabled;
	
	@FindBy(css = "div#header-context>div>div>button[class='button--alt']")
	private WebElement deleteButtonActive;
	
	@FindBy(css = "div.collection-header>button#sticky-pimple")
	WebElement shareCollectionButton;

	public UserHomePage clickHbmLogo() {
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public MyFavorites deleteCollection(String collectionTitle, int noOfItems) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		verifyCollectionTitle(collectionTitle);
		UtilHBM.reportInfo("Favorite list page opened for list : " + favListName.getText());
		UtilHBM.waitFixTime(500);
		clickCollectionActions().clickDeleteCollection().verifyDeleteCollectionDialog(collectionTitle, noOfItems)
				.closeConfirmDelete().clickCollectionActions().clickDeleteCollection()
				.verifyDeleteCollectionDialog(collectionTitle, noOfItems).clickCancelConfirmDelete()
				.clickCollectionActions().clickDeleteCollection()
				.verifyDeleteCollectionDialog(collectionTitle, noOfItems).clickConfirmDelete().verifyPageTitle();
		UtilHBM.reportInfo("Favorite list deleted!! : " + collectionTitle);
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	
	public FavoritesListPage verifyDeleteCollectionDialog(String collectionTitle, int noOfItems) {
		UtilHBM.waitExplicitDisplayed(driver, deleteDialogHeader);
		Verification.VerifyEquals("Wrong header text displayed for confirm delete header!!",
				deleteDialogHeader.getText(), "Confirm deletion");
		String confirmText11 = confirmText1.getText();
		String itemsOrElement="items";
		if(noOfItems==1) {
			itemsOrElement="element";
		}	
		Verification.VerifyEquals("Wrong confirmText1 displayed in delete dialog!!", confirmText1.getText(), "Your collection \""+collectionTitle+"\" regroups " + noOfItems + " "+itemsOrElement);
		String[] favListName1 = confirmText11.split("\"");
		String favListNameDisplayed = favListName1[1];
		if (favListNameDisplayed.equalsIgnoreCase(collectionTitle)) {
			UtilHBM.reportOK("Correct collection list name displayed in confirm delete dialog");
		} else {
			UtilHBM.reportKO("Incorrect collection list name displayed in confirm delete dialog!!Expected : "
					+ collectionTitle + ",Available : " + favListNameDisplayed);
		}
		Verification.VerifyEquals("Wrong confirmText2", confirmText2.getText(),
				"Are you sure you want to permanently delete the selected collection ?");
		return this;
	}

	public FavoritesListPage verifyFavListPageDisplayed(String favListTitle, int noOfImages, int noOfProducts) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		UtilHBM.reportInfo("Favorite list page opened for list :  " + favListName.getText());
		verifyCollectionTitle(favListTitle);
		return this;
	}
	
	public FavoritesListPage clickCollectionActions() {
		UtilHBM.waitExplicitDisplayed(driver, collectionActions);
		UtilHBM.waitExplicitClickable(driver, collectionActions);
		collectionActions.click();
		return this;
	}
	
	public FavoritesListPage clickRenameCollection() {
		UtilHBM.waitExplicitDisplayed(driver, renameCollection);
		UtilHBM.waitExplicitClickable(driver, renameCollection);
		renameCollection.click();
		return this;
	}
	
	public FavoritesListPage clickEditCollection() {
		UtilHBM.waitExplicitDisplayed(driver, editCollection);
		UtilHBM.waitExplicitClickable(driver, editCollection);
		editCollection.click();
		return this;
	}
	
	public FavoritesListPage clickDeleteCollection() {
		UtilHBM.waitExplicitDisplayed(driver, deleteCollection);
		UtilHBM.waitExplicitClickable(driver, deleteCollection);
		deleteCollection.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return this;
	}
	
	public ShareContainer clickShareCollectionButton() {
		UtilHBM.waitExplicitDisplayed(driver, shareCollectionButton);
		UtilHBM.waitExplicitClickable(driver, shareCollectionButton);
		shareCollectionButton.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}

	public FavoritesListPage verifyCollectionContents(int noOfImages, int noOfProducts) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		int totalItems = noOfImages + noOfProducts;
		UtilHBM.turnOffImplicitWaits(driver);
		int noOfTabsDisplayed = tabList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		if (totalItems != 0) {
			if (tabList.get(0).getAttribute("class").equals("tab-title-button react-tabs__tab--selected")
					&& tabList.get(0).findElement(By.cssSelector("span")).getText().contains("All")) {
				UtilHBM.reportOK("All items tab is selected by default as noOfProducts are " + noOfProducts
						+ " and noOfImages are " + noOfImages);
				}else {
					UtilHBM.reportKO(
							"All items tab is not selected by default!!");
				}
			if (!((noOfProducts == 0) || (noOfImages == 0))) {
				if (noOfTabsDisplayed != 3) {
					UtilHBM.reportKO("Incorrect noOfTabsDisplayed!! Expected : 3 , Available : " + noOfTabsDisplayed);
				}
			} else if (noOfProducts == 0) {
				if (noOfTabsDisplayed != 2) {
					UtilHBM.reportKO("Incorrect noOfTabsDisplayed!! Expected : 2 , Available : " + noOfTabsDisplayed);
				}
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> productsTab = driver.findElements(By.xpath(
						"//div[@class='react-tabs']/ul/li[contains(@class,'tab-title-button')]/span[contains(text(),'Products')]"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (!productsTab.isEmpty()) {
					UtilHBM.reportKO("Products tab is displayed even if noOfProducts are not 0 and noOfImages are "
							+ noOfImages + " !!");
				}
			} else if (noOfImages == 0) {
				if (noOfTabsDisplayed != 2) {
					UtilHBM.reportKO("Incorrect noOfTabsDisplayed!! Expected : 2 , Available : " + noOfTabsDisplayed);
				}
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> imagesTab = driver.findElements(By.xpath(
						"//div[@class='react-tabs']/ul/li[contains(@class,'tab-title-button')]/span[contains(text(),'Images')]"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (!imagesTab.isEmpty()) {
					UtilHBM.reportKO("Images tab is displayed even if noOfImages are not 0 and noOfProducts are "
							+ noOfProducts + " !!");
				}
			}
		} else {
			UtilHBM.reportInfo("Empty collection list displayed!!");
			UtilHBM.waitExplicitDisplayed(driver, findInspiration);
			UtilHBM.turnOffImplicitWaits(driver);
			if (!tabList.isEmpty()) {
				UtilHBM.reportKO("Products or images tab displayed for empty favorites list!!");
			}
			Verification.VerifyEquals("Wrong noResultsText", noResultsText.getText(),
					"Your collection is empty\nFind inspiration");
			Verification.displayOfWebElement(noResultsImg);
			Verification.displayOfWebElement(findInspiration);
			Verification.VerifyEquals("Wrong findInspiration button text", findInspiration.getText(),
					"Find inspiration");
			UtilHBM.turnOffImplicitWaits(driver);
		}
		verifyAllItemsTab(noOfProducts , noOfImages).openProductsTab(noOfProducts).verifyProductsTab(noOfProducts).openImagesTab(noOfImages)
				.verifyImagesTab(noOfImages).openAllItemsTab(noOfProducts + noOfImages);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		return this;
	}
	
	public ProductInfo openProductSheet(WebElement prdToBeOpened) {
		UtilHBM.waitExplicitDisplayed(driver, prdToBeOpened);
		UtilHBM.waitExplicitClickable(driver, prdToBeOpened);
		prdToBeOpened.click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public FeaturedMediaPage openImagePage(WebElement imgToBeOpened) {
		UtilHBM.waitExplicitDisplayed(driver, imgToBeOpened);
		UtilHBM.waitExplicitClickable(driver, imgToBeOpened);
		imgToBeOpened.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}


	public FavoritesListPage openAllItemsTab(int noOfItems) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> allItemsTabSelected = driver.findElements(By.xpath(
				"//div[@class='react-tabs']/ul/li[@class='tab-title-button react-tabs__tab--selected']/span[contains(text(),'All')]"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (noOfItems != 0) {
			if (allItemsTabSelected.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, allItemsTab);
				allItemsTab.click();
			} else {
				UtilHBM.reportInfo("All tab is already selected");
			}
		} else {
			UtilHBM.reportInfo("noOfItems in favorite list are :" + noOfItems);
		}
		return this;
	}

	public FavoritesListPage openProductsTab(int noOfProducts) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> productsTabSelected = driver.findElements(By.xpath(
				"//div[@class='react-tabs']/ul/li[@class='tab-title-button react-tabs__tab--selected']/span[contains(text(),'Products')]"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (noOfProducts != 0) {
			if (productsTabSelected.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, productsTab);
				productsTab.click();
			} else {
				UtilHBM.reportInfo("Products tab is already selected");
			}
		} else {
			UtilHBM.reportInfo("noOfProducts in favorite list are :" + noOfProducts);
		}
		return this;
	}

	public FavoritesListPage openImagesTab(int noOfImages) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> imagesTabSelected = driver.findElements(By.xpath(
				"//div[@class='react-tabs']/ul/li[@class='tab-title-button react-tabs__tab--selected']/span[contains(text(),'Images')]"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (noOfImages != 0) {
			if (imagesTabSelected.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, imagesTab);
				imagesTab.click();
				UtilHBM.waitFixTime(1000);
			} else {
				UtilHBM.reportInfo("Images tab is already selected");
			}
		} else {
			UtilHBM.reportInfo("Image tab not opened as noOfImages in favorite list are :" + noOfImages);
		}
		return this;
	}
	
	public FavoritesListPage verifyAllItemsTab(int noOfProducts,int noOfImages) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		int totalItems = noOfImages + noOfProducts;
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
		UtilHBM.waitFixTime(500);
		int noOfItemsDisplayed = allItemsList.size();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		if (noOfItemsDisplayed == totalItems) {
			UtilHBM.reportOK("Correct noOfItems displayed in all items tab");
		} else {
			UtilHBM.reportKO("Incorrect noOfItems displayed in all items tab!!Expected: " + totalItems
					+ " , Available :" + noOfItemsDisplayed);
		}
		UtilHBM.turnOffImplicitWaits(driver);
		int noOfImagesDisplayed = 0;
		int noOfProductsDisplayed = 0;
		ArrayList<WebElement> imageList = new ArrayList<WebElement>();
		ArrayList<WebElement> prdList = new ArrayList<WebElement>();
		for (WebElement a : allItemsList) {
			Actions actions = new Actions(driver);
			actions.moveToElement(a).build().perform();
			String currentItemSrc = a.findElement(By.cssSelector("img")).getAttribute("src");
			if (currentItemSrc.contains("/images/renderHQ/")) {
				imageList.add(a);
			} else if (currentItemSrc.contains("/Thumbnails/")) {
				prdList.add(a);
			} else {
				UtilHBM.reportKO("Incorrect item type displayed in all items tab of collection list!!");
			}
		}
		noOfImagesDisplayed = imageList.size();
		noOfProductsDisplayed = prdList.size();
		if ((noOfImagesDisplayed == noOfImages) && (noOfProductsDisplayed == noOfProducts)) {
			UtilHBM.reportOK("Correct noOfImages and noOfProducts displayed in all items tab");
		} else {
			UtilHBM.reportKO("Incorrect noOfImages and noOfProducts displayed in all items tab!!"
					+ "noOfImages expected: " + noOfImages + " , noOfImages Available :"
					+ noOfImagesDisplayed + "noOfProducts expected: " + noOfProducts
					+ " , noOfProducts Available :" + noOfProductsDisplayed);
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if (!(noOfProducts == 0)) {
			WebElement prdToCheck = prdList.get(0);
			openProductSheet(prdToCheck).verifyProductSheetDisplayed("NA", "NA").clickProductInfoCloseButton();
		} else if (!(noOfProducts == noOfProductsDisplayed)) {
			UtilHBM.reportKO("Incorrect number of products displayed in all items tab!!Expected : " + noOfProducts
					+ " ,Displayed : " + noOfProductsDisplayed);
		}
		if (!(noOfImages == 0)) {
			WebElement imageToCheck = imageList.get(0);
			FavoritesListPage favoritesListPage = PageFactory.initElements(driver, FavoritesListPage.class);
			favoritesListPage.openImagePage(imageToCheck).verifyMediaDisplayed();
			driver.navigate().back();
		} else if (!(noOfImages == noOfImagesDisplayed)) {
			UtilHBM.reportKO("Incorrect number of images displayed in all items tab!!Expected : " + noOfImages
					+ " ,Displayed : " + noOfImagesDisplayed);
		}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public FavoritesListPage verifyProductsTab(int noOfProducts) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		if (noOfProducts != 0) {
			for (WebElement a : productsList) {
				UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.xpath("a/div[@class='ato-card-square ']/img")));
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.xpath("a/div[@class='ato-card-square ']/img"));
				WebElement currentBrandName = a.findElement(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-brand']"));
				List<WebElement> currentProductName = a.findElements(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-product']"));
				List<WebElement> currentPriceName = a.findElements(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-price']"));
				UtilHBM.turnOnImplicitWaits(driver);
				Verification.displayOfWebElement(currentImg);
				Verification.displayOfWebElement(currentBrandName);
				if (!currentProductName.isEmpty()) {
					if (currentProductName.get(0).getText().equals("")) {
						UtilHBM.reportInfo("Empty product name displayed!!Img Src : " + currentImg.getAttribute("src"));
					} else {
						Verification.displayOfWebElement(currentProductName.get(0));
					}
				}
				if (!currentPriceName.isEmpty()) {
					Verification.displayOfWebElement(currentPriceName.get(0));
				}
			}
		}
		return this;
	}

	public FavoritesListPage verifyImagesTab(int noOfImages) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		if (noOfImages != 0) {
			for (WebElement a : imagesList) {
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.xpath("div/img"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (currentImg.getAttribute("src").contains("https://")) {
					UtilHBM.reportOK("Image displayed");
				} else {
					UtilHBM.reportKO("Image not displayed");
				}
			}
		}
		return this;
	}
	
	public FavoritesListPage verifyCollectionItemInAllItemsTab(int noOfImages, int noOfProducts, String itemType,
			String itemAttribute) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		boolean isItemAvailable = false;
		if (itemType.equals("Product")) {
			String prdName = itemAttribute.split(";")[0];
			String brndName = itemAttribute.split(";")[1];
			String prdImgSrc = itemAttribute.split(";")[2];
			for (WebElement a : allItemsList) {
				WebElement currentImg = a.findElement(By.cssSelector("img"));
				String currentImgSrc = currentImg.getAttribute("src");
				if (currentImgSrc.contains(prdImgSrc)) {
					UtilHBM.reportOK("Product added displayed in All items tab in collections list");
					Verification.displayOfWebElement(currentImg);
					a.click();
					ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
					productInfo.verifyProductSheetDisplayed(brndName, prdName).clickProductInfoCloseButton();
					isItemAvailable = true;
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Product added not displayed in All items tab in collections list!!");
			}
		} else if (itemType.equals("Image")) {
			for (WebElement a : allItemsList) {
				UtilHBM.waitExplicitClickable(driver, a.findElement(By.cssSelector("img[src^='https://']")));
				WebElement currentImg = a.findElement(By.cssSelector("img"));
				String currentImgSrc = currentImg.getAttribute("src");
				if (currentImgSrc.contains(itemAttribute)) {
					UtilHBM.reportOK("Image added is displayed in All items tab in collections list");
					isItemAvailable = true;
					a.click();
					FeaturedMediaPage featuredMediaPage1 = PageFactory.initElements(driver, FeaturedMediaPage.class);
					featuredMediaPage1.verifyMediaDisplayed();
					driver.navigate().back();
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Image added not displayed in All items tab  in collections list!!");
			}
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
			UtilHBM.waitFixTime(500);
		}
		return this;
	}

	public FavoritesListPage verifyCollectionItem(String itemType, String itemAttribute) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		boolean isItemAvailable = false;
		if (itemType.equals("Product")) {
			String prdName = itemAttribute.split(";")[0];
			String brndName = itemAttribute.split(";")[1];
			for (WebElement a : productsList) {
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.cssSelector("a>div>img"));
				WebElement currentBrandName = a
						.findElement(By.cssSelector("a>div.mol-product-card-footer>div>div.ato-label-brand"));
				List<WebElement> currentProductName = a
						.findElements(By.cssSelector("a>div.mol-product-card-footer>div>div.ato-label-product"));
				List<WebElement> currentPriceName = a
						.findElements(By.cssSelector("a>div.mol-product-card-footer>div>div.ato-label-price"));
				UtilHBM.turnOnImplicitWaits(driver);
				String currentPrdName=currentProductName.get(0).getText();
				if (prdName.equals(currentPrdName)) {
					UtilHBM.reportOK("Product added in the favorites list");
					Verification.VerifyEquals("Wrong brndName", currentBrandName.getText(), brndName);
					Verification.displayOfWebElement(currentImg);
					if (!currentPriceName.isEmpty()) {
						Verification.displayOfWebElement(currentPriceName.get(0));
					}
					a.click();
					ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
					productInfo.verifyProductSheetDisplayed(brndName, prdName).clickProductInfoCloseButton();
					isItemAvailable = true;
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Product not added in favorites list!!");
			}
		} else if (itemType.equals("Image")) {
			for (WebElement a : imagesList) {
				UtilHBM.waitExplicitClickable(driver, a.findElement(By.cssSelector("img[src^='https://']")));
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.cssSelector("div>img"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (currentImg.getAttribute("src").contains(itemAttribute)) {
					UtilHBM.reportOK("Image added in favorites list");
					isItemAvailable = true;
					a.click();
					FeaturedMediaPage featuredMediaPage1 = PageFactory.initElements(driver, FeaturedMediaPage.class);
					featuredMediaPage1.verifyMediaDisplayed();
					driver.navigate().back();
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Image not added in favorites list!!");
			}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		}
		return this;
	}

	public FavoritesListPage deleteCollectionItem(String itemType, String itemAttribute) {
		UtilHBM.waitExplicitDisplayed(driver, selectAll);
		verifyEditCollectionHeader(0);
		UtilHBM.turnOffImplicitWaits(driver);
		int noOfProducts1 = productsList.size();
		int noOfImages1 = imagesList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		WebElement itemToDelete = null;
		boolean isItemAvailable = false;
		if (itemType.equals("Product")) {
			String prdName = itemAttribute.split(";")[0];
			String brndName = itemAttribute.split(";")[1];
			for (WebElement a : productsList) {
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.cssSelector("div>img"));
				WebElement currentBrandName = a.findElement(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-brand']"));
				List<WebElement> currentProductName = a.findElements(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-product']"));
				List<WebElement> currentPriceName = a.findElements(
						By.xpath("a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-price']"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (prdName.equals(currentProductName.get(0).getText())) {
					UtilHBM.reportOK("Product available in the collection list");
					Verification.VerifyEquals("Wrong prdName", currentProductName.get(0).getText(), prdName);
					Verification.VerifyEquals("Wrong brndName", currentBrandName.getText(), brndName);
					Verification.displayOfWebElement(currentImg);
					if (!currentPriceName.isEmpty()) {
						Verification.displayOfWebElement(currentPriceName.get(0));
					}
					itemToDelete = a;
					isItemAvailable = true;
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Item not available in favorites list !! Item Attribute : " + itemAttribute);
			}
			WebElement checkBox = itemToDelete.findElement(By.xpath("a/div[@class='ato-card-square ']/img"));
			UtilHBM.turnOffImplicitWaits(driver);
//			Before selecting any item
			verifyEditCollectionHeader(0).selectItem(checkBox)
//			After selecting item
			.verifyEditCollectionHeader(1).verifySelectedCount(1).clickUnselectAll()
//			After clicking unselect all
			.verifyEditCollectionHeader(0).selectItem(checkBox)
//			After reselecting item after unselect all					
			.verifyEditCollectionHeader(1).clickDeleteItem().verifyConfirmDeleteDialog(itemType)
					.closeConfirmDelete().clickDeleteItem().clickCancelConfirmDelete().clickDeleteItem()
					.clickConfirmDeleteItem();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			int noOfProducts3 = productsList.size();
			if (noOfProducts3 == (noOfProducts1 - 1)) {
				UtilHBM.reportOK("Product deleted successfully!!");
			} else {
				UtilHBM.reportKO("Product not deleted!! NoOfProducts before deletion : " + noOfProducts1
						+ " , NoOfProducts before deletion  : " + noOfProducts3);
			}
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> prdListAfterDelete = driver
					.findElements(By.xpath("//ul[@class='tabs']/li[contains(text(),'Products')]"));
			UtilHBM.turnOnImplicitWaits(driver);
			if ((noOfProducts1 == 1) && !prdListAfterDelete.isEmpty()) {
				UtilHBM.reportKO("Product tab displayed after deleting last product in favorites list!!");
			}
			if (noOfProducts1 >= 1 && noOfProducts3 == 0) {
				UtilHBM.reportKO(
						"products list not displayed after deleting product!! No of products before deletion  : "
								+ noOfProducts1);
			} else {
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> productAfterDeletion = driver.findElements(By.xpath(
						"//div[@class='react-tabs']/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/ul/li/a/div[@class='mol-product-card-footer']/div/div[@class='ato-label-product'][text()='"
								+ prdName + "']"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (!productAfterDeletion.isEmpty()) {
					UtilHBM.reportKO("Deleted product displayed in collection list!! Product : " + itemAttribute);
				} else {
					UtilHBM.reportOK("Deleted product not displayed in collection list!!");
				}
			}
		} else if (itemType.equals("Image")) {
			for (WebElement a : imagesList) {
				UtilHBM.waitExplicitClickable(driver, a.findElement(By.cssSelector("div>img[src^='https://']")));
				UtilHBM.turnOffImplicitWaits(driver);
				WebElement currentImg = a.findElement(By.cssSelector("div>img"));
				UtilHBM.turnOnImplicitWaits(driver);
				Actions actions = PageFactory.initElements(driver, Actions.class);
				actions.moveToElement(currentImg).build().perform();
				if (currentImg.getAttribute("src").contains(itemAttribute)) {
					UtilHBM.reportOK("Image available in favorites list");
					itemToDelete = a;
					isItemAvailable = true;
					break;
				}
			}
			if (!isItemAvailable) {
				UtilHBM.reportKO("Image not added i favorites list!!");
			}
			Actions actions = PageFactory.initElements(driver, Actions.class);
			actions.moveToElement(itemToDelete).build().perform();
			WebElement checkBox = itemToDelete;
			UtilHBM.turnOffImplicitWaits(driver);
//			Before selecting any item
			verifyEditCollectionHeader(0).selectItem(checkBox)
//			After selecting item
			.verifyEditCollectionHeader(1).verifySelectedCount(1).clickUnselectAll()
//			After clicking unselect all
			.verifyEditCollectionHeader(0).selectItem(checkBox)
//			After reselecting item after unselect all					
			.verifyEditCollectionHeader(1).clickDeleteItem().verifyConfirmDeleteDialog(itemType)
					.closeConfirmDelete().clickDeleteItem().clickCancelConfirmDelete().clickDeleteItem()
					.clickConfirmDeleteItem();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			int noOfImages3 = imagesList.size();
			if (noOfImages3 == (noOfImages1 - 1)) {
				UtilHBM.reportOK("Image deleted successfully!!");
			} else {
				UtilHBM.reportKO("Image not deleted!! noOfImages before deletion : " + noOfImages1
						+ " , noOfImages before deletion  : " + noOfImages3);
			}
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> imgListAfterDelete = driver
					.findElements(By.xpath("//ul[@class='tabs']/li[contains(text(),'Images')]"));
			UtilHBM.turnOnImplicitWaits(driver);
			if ((noOfImages1 == 1) && !imgListAfterDelete.isEmpty()) {
				UtilHBM.reportKO("Image tab displayed after deleting last image in favorites list!!");
			}
			if (noOfImages1 >= 1 && noOfImages3 == 0) {
				UtilHBM.reportKO("Images list not displayed after deleting image!! No of images before deletion  : "
						+ noOfImages1);
			} else {
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> imageAfterDeletion = driver.findElements(By.xpath(
						"//div[@class='react-tabs']/div[@class='react-tabs__tab-panel react-tabs__tab-panel--selected']/div/div/div[@class='tag image-related']/div/img[contains(@src,'"
								+ itemAttribute + "')]"));
				UtilHBM.turnOnImplicitWaits(driver);
				if (!imageAfterDeletion.isEmpty()) {
					UtilHBM.reportKO("Deleted image displayed in collection list!! Image attribute : " + itemAttribute);
				} else {
					UtilHBM.reportOK("Deleted image not displayed in collection list!!");
				}
			}
		}
		return this;
	}
	
	public FavoritesListPage deleteFavListItem(String itemType, int index) {
		UtilHBM.waitExplicitDisplayed(driver, selectAll);
		verifyEditCollectionHeader(0);
		UtilHBM.turnOffImplicitWaits(driver);
		int noOfProducts1 = productsList.size();
		int noOfImages1 = imagesList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		if (itemType.equals("Product")) {
			UtilHBM.waitExplicitDisplayed(driver, productsList.get(index).findElement(By.xpath("a/div[@class='ato-card-square ']/img")));
			UtilHBM.waitExplicitClickable(driver, productsList.get(index));
			UtilHBM.turnOffImplicitWaits(driver);
			verifyEditCollectionHeader(0).selectItem(itemType, index).verifyEditCollectionHeader(1)
					.verifySelectedCount(1).clickUnselectAll().verifyEditCollectionHeader(0).selectItem(itemType, index)
					.verifyEditCollectionHeader(1).clickDeleteItem().verifyConfirmDeleteDialog(itemType)
					.closeConfirmDelete().clickDeleteItem().clickCancelConfirmDelete().clickDeleteItem()
					.clickConfirmDeleteItem();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			int noOfProducts3 = productsList.size();
			if (noOfProducts3 == (noOfProducts1 - 1)) {
				UtilHBM.reportOK("Product deleted successfully!!");
			} else {
				UtilHBM.reportKO("Product not deleted!! NoOfProducts before deletion : " + noOfProducts1
						+ " , NoOfProducts before deletion  : " + noOfProducts3);
			}
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> prdListAfterDelete = driver
					.findElements(By.xpath("//ul[@class='tabs']/li[contains(text(),'Products')]"));
			UtilHBM.turnOnImplicitWaits(driver);
			if ((noOfProducts1 == 1) && !prdListAfterDelete.isEmpty()) {
				UtilHBM.reportKO("Product tab displayed after deleting last product in favorites list!!");
			}
			if ((noOfProducts1 > 1) && (noOfProducts3 == 0)) {
				UtilHBM.reportKO(
						"products list not displayed after deleting product!! No of products before deletion  : "
								+ noOfProducts1);
			}
		} else if (itemType.equals("Image")) {
			UtilHBM.waitExplicitDisplayed(driver, imagesList.get(index));
			UtilHBM.waitExplicitClickable(driver, imagesList.get(index));
			UtilHBM.turnOffImplicitWaits(driver);
			verifyEditCollectionHeader(0).selectItem(itemType, index).verifyEditCollectionHeader(1)
					.verifySelectedCount(1).clickUnselectAll().verifyEditCollectionHeader(0).selectItem(itemType, index)
					.verifyEditCollectionHeader(1).clickDeleteItem().verifyConfirmDeleteDialog(itemType)
					.closeConfirmDelete().clickDeleteItem().clickCancelConfirmDelete().clickDeleteItem()
					.clickConfirmDeleteItem();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			int noOfImages3 = imagesList.size();
			if (noOfImages3 == (noOfImages1 - 1)) {
				UtilHBM.reportOK("Image deleted successfully!!");
			} else {
				UtilHBM.reportKO("Image not deleted!! noOfImages before deletion : " + noOfImages1
						+ " , noOfImages before deletion  : " + noOfImages3);
			}
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> imgListAfterDelete = driver
					.findElements(By.xpath("//ul[@class='tabs']/li[contains(text(),'Images')]"));
			UtilHBM.turnOnImplicitWaits(driver);
			if ((noOfImages1 == 1) && !imgListAfterDelete.isEmpty()) {
				UtilHBM.reportKO("Image tab displayed after deleting last image in favorites list!!");
			}
			if (noOfImages1 >= 1 && noOfImages3 == 0) {
				UtilHBM.reportKO("Images list not displayed after deleting image!! No of images before deletion  : "
						+ noOfImages1);
			}
		}
		return this;
	}
	
	public FavoritesListPage verifyEditCollectionHeader(int itemsSelected) {
		int noOfItemsDisplayedInDelete = 0;
		UtilHBM.reportInfo("Verifying edit collection header actions after selecting " + itemsSelected + " items");
		if (itemsSelected != 0) {
			UtilHBM.waitExplicitDisplayed(driver, unselectAll);
			Verification.displayOfWebElement(unselectAll);
			Verification.displayOfWebElement(deleteButtonActive);
			Verification.displayOfWebElement(cancelEdit);
			String noOfItemsDisplayedInDeleteButton2 = deleteButtonActive.findElement(By.xpath("span")).getText();
			noOfItemsDisplayedInDelete = Integer.parseInt(
					noOfItemsDisplayedInDeleteButton2.substring(noOfItemsDisplayedInDeleteButton2.indexOf("(") + 1,
							noOfItemsDisplayedInDeleteButton2.indexOf(")")));
		} else {
			UtilHBM.waitExplicitDisplayed(driver, selectAll);
			Verification.displayOfWebElement(selectAll);
			Verification.displayOfWebElement(deleteButtonDisabled);
			Verification.displayOfWebElement(cancelEdit);
			String noOfItemsDisplayedInDeleteButton3 = deleteButtonActive.findElement(By.xpath("span")).getText();
			noOfItemsDisplayedInDelete = Integer.parseInt(
					noOfItemsDisplayedInDeleteButton3.substring(noOfItemsDisplayedInDeleteButton3.indexOf("(") + 1,
							noOfItemsDisplayedInDeleteButton3.indexOf(")")));
		}
		if (noOfItemsDisplayedInDelete != itemsSelected) {
			UtilHBM.reportKO(itemsSelected + " no of items not displayed in delete button text when " + itemsSelected
					+ " items are selected!!Expected : " + itemsSelected + " , Displayed : "
					+ noOfItemsDisplayedInDelete);
		}
		return this;
	}
	
	public FavoritesListPage selectItem(WebElement elementCheckboxPath) {
		UtilHBM.waitExplicitDisplayed(driver, elementCheckboxPath);
		UtilHBM.waitExplicitClickable(driver, elementCheckboxPath);
		elementCheckboxPath.click();
		return this;
	}
	
	public FavoritesListPage selectItem(String itemType, int index) {
		WebElement expectedItem = null;
		if (itemType.equalsIgnoreCase("Product")) {
			expectedItem = productsList.get(index).findElement(By.xpath("a/div[@class='ato-card-square ']/img"));
		} else if (itemType.equalsIgnoreCase("Image")) {
			expectedItem = imagesList.get(index);
		}
		UtilHBM.waitExplicitDisplayed(driver, expectedItem);
		UtilHBM.waitExplicitClickable(driver, expectedItem);
		expectedItem.click();
		return this;
	}

	public FavoritesListPage clickDeleteItem() {
		UtilHBM.waitExplicitDisplayed(driver, deleteButtonActive);
		UtilHBM.waitExplicitClickable(driver, deleteButtonActive);
		UtilHBM.reportInfo("Clicking deleteButtonActive button");
		deleteButtonActive.click();
		return this;
	}

	public FavoritesListPage clickCancelEdit() {
		UtilHBM.waitExplicitDisplayed(driver, cancelEdit);
		UtilHBM.waitExplicitClickable(driver, cancelEdit);
		UtilHBM.reportInfo("Clicking cancelEdit button");
		cancelEdit.click();
		return this;
	}

	public FavoritesListPage clickUnselectAll() {
		UtilHBM.waitExplicitDisplayed(driver, unselectAll);
		UtilHBM.waitExplicitClickable(driver, unselectAll);
		UtilHBM.reportInfo("Clicking unselectAll button");
		unselectAll.click();
		return this;
	}

	public FavoritesListPage clickSelectAll() {
		UtilHBM.waitExplicitDisplayed(driver, selectAll);
		UtilHBM.waitExplicitClickable(driver, selectAll);
		UtilHBM.reportInfo("Clicking selectAll button");
		selectAll.click();
		return this;
	}

	public FavoritesListPage verifySelectedCount(int expectedCount) {
		UtilHBM.waitExplicitDisplayed(driver, selectedCount);
		String countDisplayed1 = selectedCount.getText();
		int countDisplayed = Integer.parseInt(countDisplayed1.split(" ")[0]);
		if (expectedCount == 1) {
			Verification.elementContainsString(selectedCount, "item selected", "selected text for 1 item");
		} else {
			Verification.elementContainsString(selectedCount, "items selected", "selected text for more than 1 item");
		}
		if (countDisplayed == expectedCount) {
			UtilHBM.reportOK("Selected items count displayed correctly");
		} else {
			UtilHBM.reportKO("Selected items count displayed incorrectly!! Expected : " + expectedCount
					+ " , available : " + countDisplayed);
		}
		return this;
	}

	public FavoritesListPage verifyConfirmDeleteDialog(String itemType) {
		UtilHBM.waitExplicitDisplayed(driver, deleteDialogHeader);
		Verification.VerifyEquals("Wrong header text displayed for confirm delete header!!",
				deleteDialogHeader.getText(), "Confirm deletion");
		if (itemType.equals("Product")) {
			Verification.VerifyEquals("Wrong header text displayed for confirm delete header!!", confirmText1.getText(),
					"Are you sure to permanently delete this product from this collection?");
		} else if (itemType.equals("Image")) {
			Verification.VerifyEquals("Wrong header text displayed for confirm delete header!!", confirmText1.getText(),
					"Are you sure to permanently delete these items from the collection ?");
		}
		return this;
	}

	public FavoritesListPage closeConfirmDelete() {
		UtilHBM.waitExplicitDisplayed(driver, closeDeleteDialog);
		UtilHBM.waitExplicitClickable(driver, closeDeleteDialog);
		UtilHBM.reportInfo("Closing confirm delete dialog by clicking close icon");
		closeDeleteDialog.click();
		return this;
	}

	public FavoritesListPage clickCancelConfirmDelete() {
		UtilHBM.waitExplicitDisplayed(driver, cancelButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		UtilHBM.reportInfo("Closing confirm delete dialog by clicking cancel button");
		cancelButton.click();
		return this;
	}

	public FavoritesListPage clickDeleteFavListItem(WebElement item) {
		Actions actions = PageFactory.initElements(driver, Actions.class);
		actions.moveToElement(item).build().perform();
		WebElement imgDeleteButton = item.findElement(By.cssSelector("button>span.icon-action-delete"));
		UtilHBM.reportInfo("Clicking delete button in favorites list item");
		imgDeleteButton.click();
		return this;
	}

	public MyFavorites clickConfirmDelete() {
		UtilHBM.waitExplicitDisplayed(driver, confirmDeleteButton);
		UtilHBM.waitExplicitClickable(driver, confirmDeleteButton);
		UtilHBM.reportInfo("Clicking confirm delete button in confirm delete dialog");
		confirmDeleteButton.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	
	public FavoritesListPage clickConfirmDeleteItem() {
		UtilHBM.waitExplicitDisplayed(driver, confirmDeleteButton);
		UtilHBM.waitExplicitClickable(driver, confirmDeleteButton);
		UtilHBM.reportInfo("Clicking confirm delete item button in confirm delete dialog");
		confirmDeleteButton.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}

	public DecorationInspiration clickFindInspiration() {
		UtilHBM.waitExplicitDisplayed(driver, findInspiration);
		UtilHBM.waitExplicitClickable(driver, findInspiration);
		UtilHBM.reportInfo("Clicking findInspiration button in empty favorites list");
		findInspiration.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public FavoritesListPage verifyCollectionTitle(String collectionTitle) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		Verification.VerifyEquals("Wrong favorites list title displayed in favorites list page!!",
				favListName.getText(), collectionTitle);
		return this;
	}

	public FavoritesListPage editCollectionNameFromTitle(String collectionTitle) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		collectionNameBox.click();
//		editNameInput.getAttribute("value");
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, collectionNameActiveInput);
		collectionNameActiveInput.clear();
		collectionNameActiveInput.sendKeys(collectionTitle);
		collectionNameActiveInput.sendKeys(Keys.ENTER);
//		collectionActions.click();
//		UtilHBM.waitFixTime(1000);
//		collectionActions.click();
		String titleAfter = favListName.getText();
		Verification.VerifyEquals("Collection title not updated!!", titleAfter, collectionTitle);
		Verification.VerifyEquals("Wrong Collection list title displayed in Collection list page!!", titleAfter,
				collectionTitle);
		return this;
	}
	
	public FavoritesListPage editCollectionNameFromActions(String collectionTitle) {
		UtilHBM.waitExplicitDisplayed(driver, favListName);
		UtilHBM.waitExplicitDisplayed(driver, collectionActions);
		UtilHBM.waitExplicitClickable(driver, collectionActions);
		collectionActions.click();
		UtilHBM.waitExplicitDisplayed(driver, renameCollection);
		UtilHBM.waitExplicitClickable(driver, renameCollection);
		renameCollection.click();
		UtilHBM.waitExplicitDisplayed(driver, collectionNameActiveInput);
		collectionNameActiveInput.clear();
		collectionNameActiveInput.sendKeys(collectionTitle);
		collectionNameActiveInput.sendKeys(Keys.ENTER);
//		collectionActions.click();
		UtilHBM.waitFixTime(1000);
		String titleAfter = favListName.getText();
		Verification.VerifyEquals("Collection title not updated!!", titleAfter, collectionTitle);
		Verification.VerifyEquals("Wrong Collection list title displayed in Collection list page!!", titleAfter,
				collectionTitle);
		return this;
	}

	public MyProjects goToMyProjects() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public MyFavorites goToMyCollections() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}

	public DecorationInspiration goToInspiration() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, galleryLink);
		galleryLink.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
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
	
}
