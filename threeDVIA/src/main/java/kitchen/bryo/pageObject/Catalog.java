package kitchen.bryo.pageObject;

import static org.testng.Assert.assertNotEquals;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {
	private String tabName;
	private String mainCatagory;
	private String typeOfProduct;
	private String filter;
	private String[] dimKey;
	private String[] dimValue;
	private static String productPath;
	WebDriver driver;

	public Catalog(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#sketcher-catalog-browser>header>h2[class='title']")
	private WebElement catalogTitle;

	@FindBy(css = "#design-catalog-browser>header>ul>li>button[data-ui-action='panel-close']")
	private WebElement closeCatalog;

	@FindBy(css = "#furniture-add-mod-panel>header>ul>li>button[data-ui-action='panel-close']")
	private WebElement closeCatalogForCompose;

	@FindBy(css = "#furniture-edit-panel>header>ul>li>button[data-ui-action='panel-close']")
	private WebElement closeCatalogEditForCompose;

	@FindBy(css = "#furniture-catalog-browser>header>ul>li>button[data-ui-action='panel-close']")
	private List<WebElement> closeCatalogReplaceForCompose;

	@FindBy(css = "#sketcher-catalog-browser>header>ul>li>button[data-ui-action='panel-close']")
	private WebElement closeSketcherCatalog;

	@FindBy(css = "#design-edit-panel>header>ul>li>button[data-ui-action='panel-close']")
	private WebElement closeEditCatalog;

	@FindBy(xpath = "//article[@class='options-mod-panel mod-open']/header/ul/li/button[@data-ui-action='panel-close']")
	private WebElement closeOptionsPanel;

	@FindBy(css = "#design-replace-panel>header>ul>li>button[data-ui-action='panel-close']")
	private List<WebElement> closeReplacePanel;

	@FindBy(css = "#sketcher-catalog-browser>header>ul>li[class='expand']")
	private WebElement expandCatalog;

	@FindBy(css = "#mod-product-list>li>article>div>h3>button[data-ui-action='product-info']")
	private List<WebElement> productInfo;

	@FindBy(css = "article[class*='mod-popin-product-info']")
	private WebElement productInfoPopIn;

	@FindBy(xpath = "//article[@class='mod-popin-product-info mod-open']/div/header/div/div/button/span[@class='icon-view-close']")
	private WebElement closeProductInfo;

	@FindBy(id = "bt-icon-view-3d")
	private WebElement threeDview;

	@FindBy(css = ".inner-overlay")
	private WebElement applyOverlay;

	@FindBy(css = ".inner-overlay>button[data-ui-action='product-option1']")
	private WebElement applySelection;

	@FindBy(css = ".inner-overlay>button[data-ui-action='product-option2']")
	private WebElement applyAll;

	@FindBy(css = "#mod-product-list>li>div>div>button[class='bt-icon']")
	private WebElement catalogProductInfo;

	@FindBy(css = ".mod-popin-product-info.mod-open>div>header")
	private WebElement productInfoTitle;

	@FindBy(css = ".inner-content>div>div[class='left-col']>img")
	private WebElement productInfoImg;

	@FindBy(css = ".product-area>section>p")
	private WebElement productInfotext;

	@FindBy(css = "button[data-ui-action='toggle-filters']")
	private List<WebElement> filtersToggle;

	@FindBy(css = "fieldset>p>label")
	private List<WebElement> filterOptions;

	@FindBy(id = "openings")
	private WebElement openings;

	@FindBy(id = "catalog-covering")
	private WebElement coverings;

	@FindBy(css = "body>div>main>div>div>div>div>#sketcher-toolbox-catalogs>li>li>button[id='catalog-objects']")
	private WebElement roomObjectButton;

	@FindBy(css = ".img")
	private List<WebElement> catalogImg;

	@FindBy(css = "#mod-product-list>li")
	private List<WebElement> productList;

	@FindBy(xpath = "//ul[@id='mod-product-list']/li/article/div/p")
	private List<WebElement> replaceProductList;

	@FindBy(xpath = "//button[@data-ui-publicationid='handle'and @data-ui-action='product-option-replace']")
	private WebElement replaceHandle;

	@FindBy(xpath = "//div[@aria-hidden='false']/div/ul/li/ul[@class='subsubcat']")
	private List<WebElement> subCatagoryList;

	@FindBy(css = ".step-3:nth-of-type(1)>#step-3-project-detail>p>span>span[data-ui='total-price-container']>span[class='standard-price ']")
	private List<WebElement> kitchenPrice;

	@FindBy(id = "add-button")
	private WebElement addToMyKitchenButton;

	@FindBy(css = "#filters>ul>li")
	private List<WebElement> productPropertyfilters;

	@FindBy(xpath = "//div[@id='filters']/ul/li/button[contains(text(),'Worktop type')]")
	private WebElement worktopType;

	@FindBy(xpath = "//div[@id='filters']/ul/li/button[contains(text(),'worktopMaterial')]")
	private WebElement worktopMaterial;

	@FindBy(xpath = "//div[@id='filters']/ul/li/button[contains(text(),'worktopThickness')]")
	private WebElement worktopThickness;

	@FindBy(css = "#catalogbrowser-content-inner>.message")
	private List<WebElement> emptyCatalog;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(css = "#header-filter>.tt")
	private WebElement addAProductTitle;

	@FindBy(css = "#filters>ul>li[data-ui-name='Depth']>button")
	private WebElement depthFilter;

	@FindBy(css = "#filters>ul>li[data-ui-name='Width']>button")
	private WebElement widthFilter;

	@FindBy(css = "#filters>ul>li[data-ui-name='Worktop']>button")
	private WebElement worktopTypeFilter;
	
	@FindBy(css = "#filters>ul>li[data-ui-name='worktopMaterial']>button")
	private WebElement worktopMaterialFilter;
	
	@FindBy(css = "#filters>ul>li[data-ui-name='worktopThickness']>button")
	private WebElement worktopThicknessFilter;
	
	@FindBy(css = ".mod-loader>.content>.spinner>.icon-view-loader[aria-hidden='false']")
	private WebElement catalogLodingScreen;

	@FindBy(css = "button[data-ui-action='product-replace']")
	private WebElement productReplaceButton;

	@FindBy(xpath = "//p[@id='moreResults']/button[@data-i18n='product_browser.show_more_label']")
	private WebElement showMoreButton;

	@FindBy(xpath = "//p[@id='moreResults']/button[@data-i18n='product_browser.show_more_label']")
	private List<WebElement> showMoreButtonList;
	
	@FindBy(xpath = "//p[@data-notif-action='save']/span")
	private WebElement nonVisibleItemsRibbon;

	@FindBy(css = ".mod-popin-unavailable-products-small.mod-open>.content>.inner-content>.tt")
	private WebElement noDefaultStylePrdMsgHeading;

	@FindBy(css = ".mod-popin-unavailable-products-small.mod-open>.content>.inner-content>.text")
	private WebElement noDefaultStylePrdMsgText;

	@FindBy(css = ".mod-popin-unavailable-products-small.mod-open>.content>.popin-footer>.cta-primary-alt-xl")
	private WebElement noDefaultStylePrdMsgOKBtn;

	@FindBy(css = ".mod-popin-partial-apply-all-small.mod-open>.content>.inner-content>.tt")
	private WebElement ikeaNoDefaultStylePrdMsgHeading;

	@FindBy(css = ".mod-popin-partial-apply-all-small.mod-open>.content>.inner-content>.text")
	private WebElement ikeaNoDefaultStylePrdMsgText;

	@FindBy(css = ".mod-popin-partial-apply-all-small.mod-open>.content>.popin-footer>.cta-primary-alt-xl")
	private WebElement ikeaNoDefaultStylePrdMsgOKBtn;
	
	@FindBy(css = "ul[class='actions']>li>button>span[class='icon-view-maximize']")
	private WebElement maximizeCatalog;

	@FindBy(css = "ul[class='actions']>li>button>span[class='icon-view-minimize']")
	private WebElement minimizeCatalog;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text']")
	private WebElement favoriteSuccessMsg;

	@FindBy(css = "#sketcher-mod-properties-window-regular>ul")
	private List<WebElement> balloon;

	@FindBy(xpath = "//div[@class='last-use']/h2[contains(text(),'Last used')]")
	private WebElement lastUsedTitle;

	@FindBy(xpath = "//div[@class='last-use']/div[@data-ui-selector='last-used-list']/div")
	private List<WebElement> materialID;

		@FindBy(xpath = "//p[@id='search-result-number']")
	private WebElement searchResults;
	
		
		@FindBy(xpath = "//article[@class='mod-panel-catalog-browser-search mod-open mod-panel-catalog-browser']/div/div/ul[@class='catalog-list']/li")
		private List<WebElement> searchedProductList;
		
	private String prdName, prdId = "", prdSize = "", prdDesc = "", prdInfo = "", prdPrice = "",searchCount= "";

	public Catalog toggleFilters(String option) {
		if (filtersToggle.size() != 0) {
			filtersToggle.get(0).click();
			UtilHBM.reportOK("Filter Option available and clicked");
			int iSize = filterOptions.size();
			for (int i = 0; i < iSize; i++) {
				String sValue = filterOptions.get(i).findElement(By.tagName("input")).getAttribute("data-value");
				System.out.println("Filter options: "
						+ filterOptions.get(i).findElement(By.tagName("input")).getAttribute("data-value"));
				if (sValue.equalsIgnoreCase(option)) {
					filterOptions.get(i).click();
					break;
				}
			}
			UtilHBM.waitFixTime(1000);

		} else {
			UtilHBM.reportOK("Filter Option not available");
		}
		return this;
	}

	public Catalog clickProductInfoIcon(String product) {
		WebElement productToBeclicked = getProduct(productList).get(product);
		UtilHBM.waitFixTime(2000);
		System.out.println("Product to be added:" + productToBeclicked);
		if (productToBeclicked.findElements(By.cssSelector("article>div>h3>button[data-ui-action='product-info']"))
				.size() > 0) {
			System.out.println("Waiting for info icon done");
			if (productToBeclicked.findElement(By.cssSelector("div>h3>button[data-ui-action='product-info']"))
					.isDisplayed()) {

				WebElement icon = productToBeclicked
						.findElement(By.cssSelector("div>h3>button[data-ui-action='product-info']"));
				new Actions(driver).moveToElement(icon).build().perform();
				icon.sendKeys(Keys.ENTER);
				productInfo();
			} else {
				UtilHBM.reportKO("product info icon not visible for " + product);
			}

		} else {
			UtilHBM.reportKO("product info icon not displayed for " + product);
		}
		return this;
	}

	public Catalog productInfo() {
		UtilHBM.waitFixTime(2500);
		System.out.println("Info");
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, productInfoPopIn);
		Verification.displayOfWebElement(productInfoTitle);
		if (productInfoImg.getAttribute("src").startsWith("https:")) {
			UtilHBM.reportOK("product Image displayed in info pop-up");
		}
		Verification.displayOfWebElement(closeProductInfo);
		closeProductInfo.click();
		driver.switchTo().frame(0);

		// UtilHBM.waitTillElementDisappear(driver, ".mod-loader");

		return this;
	}

	protected Catalog addProductFilter(String product) {

		WebElement addThisProduct = setProduct(product, 0, 1, 0)
				.findElement(By.cssSelector("#catalogbrowser-content-inner>#mod-product-list>li>article"));

		UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
		UtilHBM.waitExplicitClickable(driver, addThisProduct);
		addThisProduct.click();
		closeCatalogPanel();
		return PageFactory.initElements(driver, Catalog.class);
	}

	private WebElement setProduct(String product, int fromBrands, int applyFilter, int search) {
		setProductPath(product);
		setTabName();
		setMainCatagory();
		setTypeOfProduct();
		setFilter();

		WebElement productToBeAdded;

		if (search == 0) {

			WebElement catagoryToClick;
			for (WebElement catagory : subCatagoryList) {
				String tempTypeOfProduct = catagory.getText();
				for (WebElement type : catagory.findElements(By.cssSelector("li>button"))) {
					tempTypeOfProduct = type.getText();

					catagoryToClick = type;
					new Actions(driver).moveToElement(catagoryToClick).click().build().perform();
				}
			}
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector("#catalogbrowser-content-inner>#mod-product-list")));
//			UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
			UtilHBM.waitExplicitDisplayed(driver,
					UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
			Filters sort = PageFactory.initElements(driver, Filters.class);
			sort.filters();
		}

		productToBeAdded = locateProduct(productList, product);
		return productToBeAdded;
	}

	private void setProductPath(String product) {
		String productPath;
		productPath = UtilHBM.getKeyValue(Setting.bryoCatalogPath).get(product);
		Catalog.productPath = productPath;
	}

	private void setTabName() {
		String tabName = null;
		tabName = productPath.split(">")[0];
		this.tabName = tabName;
	}

	private void setMainCatagory() {
		String mainCatagory = "";
		if (!productPath.equalsIgnoreCase("Search")) {
			mainCatagory = productPath.split(">")[1];
		}
		this.mainCatagory = mainCatagory;
	}

	private void setTypeOfProduct() {
		String typeOfProduct = null;
		if (!productPath.equalsIgnoreCase("Search")) {
			typeOfProduct = productPath.split(">")[2];
		}
		this.typeOfProduct = typeOfProduct;
	}

	private void setFilter() {
		String filter = null;
		if (!productPath.equalsIgnoreCase("Search") && productPath.split(">").length > 3) {
			filter = productPath.split(">")[3];

		}
		this.filter = filter;

	}

	static String getFilter() {
		String filter = null;
		filter = productPath.split(">")[3];

		return filter;

	}

	private WebElement locateProduct(List<WebElement> productList, String product) {

		WebElement productToBeAdded = getProduct(productList).get(product);
		if (productToBeAdded == null) {

			productToBeAdded = getProduct(productList).get(product);
		}
		return productToBeAdded;
	}

	public MakeItYours addProduct(String product) {

		WebElement productToBeclicked = getProduct(productList).get(product);
		clickProductInfoIcon(product);
		new Actions(driver).moveToElement(productToBeclicked).build().perform();

		productToBeclicked.click();

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours addNon3DItem(String product, int addCount, int minusCount) {
		WebElement productToBeclicked = getProduct(productList).get(product);
		productToBeclicked.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div[data-ui-id='add-non-3d-item']")));
		Verification.displayOfWebElement(driver.findElement(By.cssSelector("span[class='mod-number-input']")));
		Verification
				.displayOfWebElement(driver.findElement(By.cssSelector("button[data-ui-action='add-to-my-project']")));
		for (int i = 2; i <= addCount; i++) {
			driver.findElement(By.cssSelector("button[data-ui-action='increment']>span")).click();
			UtilHBM.waitFixTime(500);

		}

		for (int j = 1; j >= minusCount; j--) {
			driver.findElement(By.cssSelector("button[data-ui-action='decrement']>span")).click();
			UtilHBM.waitFixTime(500);
		}
		String inputVal = driver.findElement(By.cssSelector("span[class='mod-number-input']>input"))
				.getAttribute("value");
		int val = Integer.parseInt(inputVal);
		if (val == addCount - minusCount) {
			driver.findElement(By.cssSelector("button[data-ui-action='add-to-my-project']")).click();
		}
		UtilHBM.waitExplicitDisplayed(driver, nonVisibleItemsRibbon);
		if (nonVisibleItemsRibbon.getText().equalsIgnoreCase("WORKTOP BOLTS added to your project")) {
			UtilHBM.reportOK("Non-visible items notification message displayed is correct and message is : "
					+ nonVisibleItemsRibbon.getText());
		} else {
			UtilHBM.reportKO("Non-visible items notification message displayed is in-correct and message is : "
					+ nonVisibleItemsRibbon.getText());
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyNon3DItems(String product, int count) {
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("li[data-ui-action='product-list-update']")));
		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("div[class='item-quantity']>span[class='mod-number-input']")));
		WebElement pro = driver.findElement(
				By.xpath("//li[@data-ui-action='product-list-update']/article/div/h3[@title='" + product + "']"));
		System.out.println("pro " + pro.getText());
		String inputVal = driver
				.findElement(By.cssSelector("div[class='item-quantity']>span[class='mod-number-input']>input"))
				.getAttribute("value");
		int val = Integer.parseInt(inputVal);
		System.out.println("val " + val);
		if (pro.getText().equalsIgnoreCase(product) && (val == count)) {
			UtilHBM.reportOK("Non-visible item added to my projects catalog with product name :" + pro.getText()
					+ " with count : " + val);
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Catalog addFurnitureFromInfo(String product) {
		double BPrice = 0;
		if (kitchenPrice.size() != 0) {
			if (!kitchenPrice.get(0).isDisplayed()) {
				UtilHBM.reportKO("Kitchen Price not available");
			} else {
				String beforePrice = kitchenPrice.get(0).getText().replaceAll("[^0-9.]", "");
				BPrice = Double.parseDouble(beforePrice);
				System.out.println("Before Price: " + BPrice);
				if (beforePrice.isEmpty()) {
					UtilHBM.reportKO("Price not displayed");
				} else if (BPrice == 0) {
					UtilHBM.reportMsg("Price before adding any product is " + BPrice);
				} else if (BPrice > 0) {
					UtilHBM.reportMsg("Some products are already available in kitchen");
				}
			}

		} else {
			UtilHBM.reportInfo("Price not displayed");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement data;
		data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#catalogbrowser-content-inner>ul>li>article>div>h3>button[data-ui-iterate='" + product + "']")));
		data.click();
		MakeItYours design = PageFactory.initElements(driver, MakeItYours.class);
		design.checkProductInfo();
		addToMyKitchenButton.click();
		UtilHBM.waitFixTime(8000);
		double APrice = 0;
		if (kitchenPrice.size() != 0) {
			String afterPrice = kitchenPrice.get(0).getText().replaceAll("[^0-9.]", "");
			APrice = Double.parseDouble(afterPrice);
			System.out.println(" Price: " + APrice);
			if (afterPrice.isEmpty()) {
				UtilHBM.reportKO("Price not displayed after adding product");
			} else if (BPrice == APrice) {
				UtilHBM.reportKO("Price displayed before and after adding product is same");
			} else {
				UtilHBM.reportOK("Price updated after adding product and price is " + APrice);
			}
		} else {
			UtilHBM.reportInfo("Price not displayed");
		}
		return this;
	}

	public Catalog replaceProduct(String product, boolean defaultStylePrd, boolean filter, boolean productInfoSheet) {
		productReplaceButton();
		addProductDesignStep(product, defaultStylePrd, filter, productInfoSheet);
//		addProductFromSearchOrReplace(product, defaultStylePrd);
		return this;
	}
	
	public Catalog productReplaceButton() {
		productReplaceButton.click();
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitFixTime(200);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("#design-catalog-browser:not([class*=loading])")));
		return this;
	}

	public Catalog addProductFromFilter(String product) {

		List<WebElement> prdNameList = driver
				.findElements(By.xpath("//ul[@id='mod-product-list']/li/div/p/span[.='" + product + "']"));
		if (prdNameList.size() > 0) {
			prdNameList.get(0).click();
			System.out.println("Product Name clicked");
		}

		else {
			// UtilHBM.waitExplicitClickable(driver, closeCatalog);
			WebElement element = driver.findElement(
					By.xpath("//ul[@id='mod-product-list']/li/article/img[@data-ui-id='" + product + "']"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			System.out.println("Image source: " + element.getAttribute("srcset"));
		}
		closeCatalog.click();
		return this;
	}

	protected Catalog selectCoveringMaterial(String product, String allOrSelected) {
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#sketcher-catalog-browser:not([class*=loading])"));
		System.out.println("In paint");
//		UtilHBM.waitExplicitDisplayed(driver,
//				"//*[@data-ui-id='content'][@class='content']//*[@class='content-inner']");
		UtilHBM.waitExplicitDisplayed(driver, "//*[@class='content-fluid']//*[@class='content-inner']");
		UtilHBM.waitFixTime(1200);
		List<WebElement> prd;
		if (product.contains("|")) {
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			if (prdId.matches("[0-9]")) {

				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));

				}
			} else {
				prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				}
			}

		} else {
			prdName = product;
			prd = driver.findElements(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			if (prd.size() == 0) {
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}
		}
		new Actions(driver).moveToElement(prd.get(0)).pause(500).click().build().perform();
		UtilHBM.waitFixTime(1000);
		if (!allOrSelected.isEmpty()) {
			WebElement selection = prd.get(0).findElement(By.cssSelector(
					"div[data-ui-id='from-product']>p[class='inner-overlay']>button[class='cta-primary']"));
			WebElement all = prd.get(0).findElement(By.cssSelector(
					"div[data-ui-id='from-product']>p[class='inner-overlay']>button[class='cta-secondary']"));
			if (allOrSelected.equalsIgnoreCase("all")) {
				System.out.println("all");
			new Actions(driver).moveToElement(all).click().build().perform();
//			all.click();
				UtilHBM.waitFixTime(2000);
			} else {
				new Actions(driver).moveToElement(selection).click().build().perform();
//				selection.click();
				UtilHBM.waitFixTime(2000);
				clickBlank();
			}
		} 
		return PageFactory.initElements(driver, Catalog.class);
	}

	public Catalog verifyLastUsed(String prdID) {
		UtilHBM.waitExplicitDisplayed(driver, lastUsedTitle);
		if (!prdID.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, materialID.get(0));
			Verification.VerifyEquals("wrong matrial id displayed for last used ",
					materialID.get(0).getAttribute("data-attribute-product-id"), prdID);
		}
		return PageFactory.initElements(driver, Catalog.class);
	}

	public Catalog applyMaterialFromLastUsedList(String prdID) {
		UtilHBM.waitExplicitDisplayed(driver, lastUsedTitle);
		if (!prdID.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, materialID.get(0));
			WebElement prd = driver.findElement(By.xpath(
					"//div[@class='last-use']/div[@data-ui-selector='last-used-list']/div[@data-attribute-product-id='"
							+ prdID + "']"));
			prd.click();
		}
		return PageFactory.initElements(driver, Catalog.class);
	}

	public FloorPlan clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, FloorPlan.class);
	}
//	public FloorPlan changeProductProperties(String filterType, String filterMaterial, String filterThickness,
//			String product, String allOrSelected) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		if (productPropertyfilters.size() > 0) {
//			if (!(filterType.isEmpty())) {
//				if (worktopType.getText().equalsIgnoreCase("Worktop type")) {
//					worktopType.click();
//					WebElement check = driver.findElement(By.xpath(
//							"//div[@id='filters']/div[@id='nav-overlay-filters-collapse-0']/div/form/ul[@class='subsubcat']/li/label/span[@class='label'][contains(text(),'"
//									+ filterType + "')]/preceding-sibling::span"));
//
//					UtilHBM.waitExplicitDisplayed(driver, check);
//					UtilHBM.waitExplicitClickable(driver, check);
//					List<WebElement> typePath = driver.findElements(By.xpath(
//							"//div[@id='nav-overlay-filters-collapse-0']/div/form/ul[@class='subsubcat']/li/label/span[@class='label']"));
//					for (WebElement type : typePath) {
//						if (filterType.equalsIgnoreCase(type.getText())) {
//							check.click();
//							UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//						}
//					}
//				}
//			}
//			if (!(filterMaterial.isEmpty())) {
//				if (worktopMaterial.getText().equalsIgnoreCase("worktopMaterial")) {
//					UtilHBM.waitExplicitClickable(driver, worktopMaterial);
//					new Actions(driver).moveToElement(worktopMaterial).build().perform();
//					worktopMaterial.click();
//
//					WebElement check = driver.findElement(By.xpath(
//							"//div[@id='filters']/div[@id='nav-overlay-filters-collapse-1']/div/form/ul[@class='subsubcat']/li/label/span[@class='label'][contains(text(),'"
//									+ filterMaterial + "')]/preceding-sibling::span"));
//					UtilHBM.waitExplicitDisplayed(driver, check);
//					UtilHBM.waitExplicitClickable(driver, check);
//					List<WebElement> materialPath = driver.findElements(By.xpath(
//							"//div[@id='nav-overlay-filters-collapse-1']/div/form/ul[@class='subsubcat']/li/label/span[@class='label']"));
//					for (WebElement material : materialPath) {
//						if (filterMaterial.equalsIgnoreCase(material.getText())) {
//							check.click();
//							UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//						}
//					}
//				}
//			}
//			if (!(filterThickness.isEmpty())) {
//				if (worktopThickness.getText().equalsIgnoreCase("worktopThickness")) {
//					worktopThickness.sendKeys(Keys.ENTER);
//					WebElement check = UtilHBM.webElementXPath(driver,
//							"//div[@id='filters']/div[@id='nav-overlay-filters-collapse-2']/div/form/ul[@class='subsubcat']/li/label/span[@class='label'][contains(text(),'"
//									+ filterThickness + "')]/preceding-sibling::span");
//
//					UtilHBM.waitExplicitDisplayed(driver, check);
//					UtilHBM.waitExplicitClickable(driver, check);
//					List<WebElement> thicknessPath = driver.findElements(By.xpath(
//							"//div[@id='nav-overlay-filters-collapse-2']/div/form/ul[@class='subsubcat']/li/label/span[@class='label']"));
//					for (WebElement thickness : thicknessPath) {
//						if (filterThickness.equalsIgnoreCase(thickness.getText())) {
//							check.click();
//							UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//						}
//					}
//				}
//			} else
//				UtilHBM.reportMsg("No filter given");
//
//		}
//		if (productList.size() > 0) {
//			// UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By
//			// .cssSelector(".mod-panel-catalog-browser.mod-open")));
//			WebElement prdNameList = getProduct(productList).get(product);
////			UtilHBM.waitExplicitClickable(driver, prdNameList);
//			new Actions(driver).moveToElement(prdNameList).click().build().perform();
//			UtilHBM.waitFixTime(3000);
//			System.out.println("product clicked:" + product);
//			System.out.println("product clicked:-" + prdNameList);
//			// WebElement
//			// all=prdNameList.findElement(By.xpath("//p[@class='inner-overlay']/button[.='Apply
//			// to selection']"));
//			WebElement selection = prdNameList.findElement(By.cssSelector(
//					"#design-replace-panel>div>#catalogbrowser-content-inner>ul>li>article>div>p>button[data-ui-option='1']"));
//			WebElement all = prdNameList.findElement(By.cssSelector(
//					"#design-replace-panel>div>#catalogbrowser-content-inner>ul>li>article>div>p>button[data-ui-option='2']"));
//			if (allOrSelected.equalsIgnoreCase("all")) {
//				System.out.println("all");
//				new Actions(driver).moveToElement(all).click().build().perform();
//			} else {
//				selection.click();
//			}
//			UtilHBM.waitFixTime(2000);
//		} else if (emptyCatalog.size() > 0) {
//			UtilHBM.reportMsg("Catalog is empty as no compatible product found");
//
//		}
//		return PageFactory.initElements(driver, FloorPlan.class);
//	}

	public FloorPlan closeSketcherCatalogPanel() {
		closeSketcherCatalog.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

//	public FloorPlan closeCatalogFloorPlan() {
//		closeSketcherCatalog.click();
//		UtilHBM.waitFixTime(2000);
//		return PageFactory.initElements(driver, FloorPlan.class);
//	}
	public MakeItYours closeCatalogPanel() {
			closeCatalog.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Catalog closeCatalogPanelForCompose() {
		closeCatalogForCompose.click();
		return this;
	}

	public Catalog closeCatalogEditPanelForCompose() {
		closeCatalogEditForCompose.click();
		return this;
	}

	public Catalog closeCatalogReplacePanelForCompose() {
		if (closeCatalogReplaceForCompose.size() > 0) {
			closeCatalogReplaceForCompose.get(0).click();
		}
		return this;
	}

	public Catalog closeCatalogForEditPanel() {
		closeEditCatalog.click();
		UtilHBM.reportOK("Catalog closed");
		return this;
	}

	public Catalog closeCatalogForOptionPanel() {

		new Actions(driver).moveToElement(closeOptionsPanel).clickAndHold().pause(500).release().build().perform();
		UtilHBM.reportOK("Catalog closed");
		return this;
	}

	public Catalog closeCatalogForReplacePanel() {
		if (closeReplacePanel.size() > 0) {
			closeReplacePanel.get(0).click();
		}
		return this;
	}

	public Map<String, WebElement> getProduct(List<WebElement> listProduct) {
		Map<String, WebElement> map = new HashMap<String, WebElement>();

		if (!listProduct.isEmpty()) {
			for (WebElement p : listProduct) {
				UtilHBM.turnOffImplicitWaits(driver);
				if (p.findElements(By.cssSelector(".name")).size() > 0) {
					String name = p.findElement(By.cssSelector(".name")).getText().split("\\r?\\n")[0];
					map.put(name, p);
				}
				/*
				 * if (p.findElements(By.className("desc")).size() > 0) { String desc =
				 * p.findElement(By.className("desc")).getText(); map.put(desc, p); }
				 */
				String dataId = p.getAttribute("data-ui-id");
				map.put(dataId, p);

			}
		} else {
			UtilHBM.reportKO("Empty catalog displayed");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return map;
	}

	public String getDescNShortDesc(String product) {
		String descNShortDesc = null, desc = null, shortDesc = null;
		WebElement targetPrd = getProduct(productList).get(product);
		UtilHBM.turnOffImplicitWaits(driver);
		if (targetPrd.findElements(By.className("desc")).size() > 0) {
			desc = targetPrd.findElement(By.className("desc")).getText();
		}
		if (targetPrd.findElements(By.className("secondary-desc")).size() > 0) {
			shortDesc = targetPrd.findElement(By.className("secondary-desc")).getText();
		}
		descNShortDesc = desc + ";" + shortDesc;
		UtilHBM.turnOnImplicitWaits(driver);
		return descNShortDesc;
	}

	private void setProductInfo(String product) {
		if (driver.getCurrentUrl().contains("bathroom")) {
			String prdInfo = UtilHBM.getKeyValue(Setting.bryoBathroomCatalogPath).get(product);
			if (product.contains("|")) {
				prdName = product.split("\\|")[0];
				prdId = product.split("\\|")[1];
			} else {
				prdName = product;
			}
		} else {

			String prdInfo = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
			if (product.contains("|")) {
				prdName = product.split("\\|")[0];
				prdId = product.split("\\|")[1];
			} else {
				prdName = product;
			}
			if (prdInfo.split(">").length > 4) {
				prdSize = prdInfo.split(">")[4];
			}
			if (prdInfo.split(">").length > 5) {
				prdDesc = prdInfo.split(">")[5];
			}
			if (prdInfo.split(">").length > 6) {
				prdPrice = prdInfo.split(">")[6];
			}
		}
	}

	public MakeItYours addProductDesignStep(String product, boolean defaultStylePrd, boolean filter,
			boolean productInfoSheet) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
		List<WebElement> prd;
		setProductInfo(product);
		if (filter) {
			filterProduct();
		}
		if (product.contains("|")) {
			prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
					+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			if (prd.size() == 0) {
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			}
		} else {

			prd = driver.findElements(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			if (prd.size() == 0) {
				Verification.displayOfWebElement(showMoreButton);
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}
		}
		if (!(prdDesc.isEmpty())) {
			if(product.equalsIgnoreCase("UEDBD10060L")) {
				List<WebElement> descList=driver.findElements(By.xpath("//h3/button/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article/div/p[@class='desc']"));
				for (WebElement e : descList) {
					Verification.VerifyEquals("Incorrect Corner Cabinet desc for cabinet : "+e.findElement(By.xpath("preceding-sibling::h3")).getText(), e.getText(), "Left Corner Base Unit");
				}
			}
			else {
			WebElement disc = prd.get(0).findElement(By.cssSelector("div.text .desc"));
			Verification.displayNAttributeCheckOfElement(disc, "Product Description", "text", prdDesc);
			}
		}
		if (!(prdSize.isEmpty())) {
			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc"));
			Verification.displayNAttributeCheckOfElement(size, "Product Size", "text", prdSize);
		}
//		if (!(prdEnergyEffi.isEmpty())) {
//			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc .energy-badge-aaa"));
//			Verification.displayNAttributeCheckOfElement(size, "Product Energy Efficiency", "text", prdEnergyEffi);
//		}
		if (!(prdPrice.isEmpty())) {
			if (!System.getProperty("os.name").contains("win")) {
				UtilHBM.reportInfo("This is test on Mac");
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayOfWebElement(price);
				String expectedPrice = prdPrice.split(" ")[1];
				String actualPrice = price.getText().split(" ")[1];
				if (!(actualPrice.equalsIgnoreCase(expectedPrice))) {
					UtilHBM.reportKO("Price of the " + product + " in catalog is not same as expected. Expected Price "
							+ expectedPrice + ", Actual Price is: " + actualPrice);
				}
			} else {
				byte[] bytesOfString = prdPrice.getBytes();
				String encoded_String = new String(bytesOfString, StandardCharsets.UTF_8);
				assertNotEquals(encoded_String, prdPrice);
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayNAttributeCheckOfElementExcludeLineBreak(price, "Product Price", "text",
						encoded_String);
			}

		}
		if (productInfoSheet) {
			productInfoSheet(prd.get(0));
		}

		new Actions(driver).moveToElement(prd.get(0)).build().perform();
		new Actions(driver).moveToElement(prd.get(0)).click().build().perform();

		if (!defaultStylePrd) {
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".mod-popin-unavailable-products-small.mod-open")));
			UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
			Verification.verifyText(noDefaultStylePrdMsgText,
					"The product(s) you selected are unavailable and will be inserted into your project in a different style.",
					"Product not availalbe in default style msg");
			Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products",
					"Unavailable product msg heading");
			noDefaultStylePrdMsgOKBtn.click();
		}
		UtilHBM.waitFixTime(4500);
//		closeCatalogPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours addProductDragAndDrop(String product, boolean defaultStylePrd, boolean filter,
			boolean productInfoSheet, int finalxcoordinate, int finalycoordinate) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
		List<WebElement> prd;
		setProductInfo(product);
		if (filter) {
			filterProduct();
		}
		if (product.contains("|")) {
			prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
					+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			if (prd.size() == 0) {
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			}
		} else {

			prd = driver.findElements(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			if (prd.size() == 0) {
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}
		}
		if (!(prdDesc.isEmpty())) {
			WebElement disc = prd.get(0).findElement(By.cssSelector("div.text .desc"));
			Verification.displayNAttributeCheckOfElement(disc, "Product Description", "text", prdDesc);
		}
		if (!(prdSize.isEmpty())) {
			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc"));
			Verification.displayNAttributeCheckOfElement(size, "Product Size", "text", prdSize);
		}
//		if (!(prdEnergyEffi.isEmpty())) {
//			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc .energy-badge-aaa"));
//			Verification.displayNAttributeCheckOfElement(size, "Product Energy Efficiency", "text", prdEnergyEffi);
//		}
		if (!(prdPrice.isEmpty())) {
			WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
			Verification.displayNAttributeCheckOfElementExcludeLineBreak(price, "Product Price", "text", prdPrice);
		}
		if (productInfoSheet) {
			productInfoSheet(prd.get(0));
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(prd.get(0)).clickAndHold().pause(1000)
		.moveToElement(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		if (!defaultStylePrd) {
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".mod-popin-unavailable-products-small.mod-open")));
			UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
			Verification.verifyText(noDefaultStylePrdMsgText,
					"The product(s) you selected are unavailable and will be inserted into your project in a different style.",
					"Product not availalbe in default style msg");
			Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products",
					"Unavailable product msg heading");
			noDefaultStylePrdMsgOKBtn.click();
		}
		UtilHBM.waitFixTime(4500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected FloorPlan replaceProductInFloorplan(String product) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(1000);

		if (driver.findElements(By.xpath("//div[@id='catalogbrowser-content-inner']/p[@class='message']")).size() > 0) {
			UtilHBM.reportInfo("Catalog appears empty therefore cannot replace product");
			driver.findElement(By.xpath("//button[@data-ui-action='panel-back']")).click();

		} else {
			WebElement prd;
			if (product.contains("|")) {
				prdName = product.split("\\|")[0];
				prdId = product.split("\\|")[1];
				String regex = "(.)*(\\d)(.)*";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(prdId);
				boolean isMatched = matcher.matches();
				if (isMatched) {
					prd = driver.findElement(By.xpath("//h3[@title='" + prdName
							+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li[@data-ui-id='"
							+ prdId + "']/article"));
				} else {
					prd = driver.findElement(
							By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='" + prdName
									+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
				}

			} else if (product.matches("^[0-9].*$")) {
				prdId = product;
				prd = driver.findElement(By.xpath(
						"//h3/../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li[@data-ui-id='"
								+ prdId + "']/article"));
			} else {
				prdName = product;
				prd = driver.findElement(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}

			prd.click();
		}
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	protected MakeItYours addProductFromSearchOrReplace(String product, boolean defaultStylePrd, boolean productInfoSheet ) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(1000);
		
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".mod-panel-catalog-browser.mod-open")));
		List<WebElement> prd;
		if (product.contains("|")) {
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (product.contains("|")) {
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				if (prd.size() == 0) {
					showMoreButton.click();
//					UtilHBM.waitFixTime(1000);
					prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				}
			} else {
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
				if (prd.size() == 0) {
					showMoreButton.click();
					prd = driver.findElements(By.xpath("//h3[@title='" + prdName
							+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
				}
			}

		} else {
			prdName = product;
			prd = driver.findElements(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));

		}
		if (!(prdDesc.isEmpty())) {
			WebElement disc = prd.get(0).findElement(By.cssSelector("div.text .desc"));
			Verification.displayNAttributeCheckOfElement(disc, "Product Description", "text", prdDesc);
		}
		if (!(prdSize.isEmpty())) {
			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc"));
			Verification.displayNAttributeCheckOfElement(size, "Product Size", "text", prdSize);
		}
//		if (!(prdEnergyEffi.isEmpty())) {
//			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc .energy-badge-aaa"));
//			Verification.displayNAttributeCheckOfElement(size, "Product Energy Efficiency", "text", prdEnergyEffi);
//		}
		if (!(prdPrice.isEmpty())) {
			if (!System.getProperty("os.name").contains("win")) {
				UtilHBM.reportInfo("This is test on Mac");
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayOfWebElement(price);
				String expectedPrice = prdPrice.split(" ")[1];
				String actualPrice = price.getText().split(" ")[1];
				if (!(actualPrice.equalsIgnoreCase(expectedPrice))) {
					UtilHBM.reportKO("Price of the " + product + " in catalog is not same as expected. Expected Price "
							+ expectedPrice + ", Actual Price is: " + actualPrice);
				}
			} else {
				byte[] bytesOfString = prdPrice.getBytes();
				String encoded_String = new String(bytesOfString, StandardCharsets.UTF_8);
				assertNotEquals(encoded_String, prdPrice);
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayNAttributeCheckOfElementExcludeLineBreak(price, "Product Price", "text",
						encoded_String);
			}

		}
		if (productInfoSheet) {
			productInfoSheet(prd.get(0));
		}
		UtilHBM.waitFixTime(500);
		new Actions(driver).moveToElement(prd.get(0)).click().build().perform();
//		UtilHBM.waitExplicitClickable(driver, prd.get(0));
//		prd.get(0).click();
		if (!defaultStylePrd) {
			UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
			Verification.verifyText(noDefaultStylePrdMsgText,
					"The product(s) you selected are unavailable and will be inserted into your project in a different style.",
					"Product not availalbe in default style msg");
			Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products",
					"Unavailable product msg heading");
			noDefaultStylePrdMsgOKBtn.click();
		}
//		UtilHBM.waitFixTime(3000);
		closeCatalogPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours ecoFee(String product) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(1000);
		WebElement prd;
		if (product.contains("|")) {
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
				prd = driver.findElement(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li[@data-ui-id='"
						+ prdId + "']/article"));
				verifyEcoFee(product);
			} else {
				prd = driver.findElement(By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='"
						+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
				verifyEcoFee(product);
			}

		} else if (product.matches("^[0-9].*$")) {
			prdId = product;
			prd = driver.findElement(
					By.xpath("//h3/../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li[@data-ui-id='"
							+ prdId + "']/article"));
			verifyEcoFee(product);
		} else {
			prdName = product;
			prd = driver.findElement(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			verifyEcoFee(product);
		}

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyEcoFee(String product) {
		if (driver
				.findElements(By.xpath("//h3[@title='" + product
						+ "']/../following-sibling::div/span/span/span[@class='price-fee']/bt[@id='ecoFee']"))
				.size() > 0) {
			driver.findElements(By.xpath("//h3[@title='" + product
					+ "']/../following-sibling::div/span/span/span[@class='price-fee']/bt[@id='ecoFee']")).get(0)
					.click();
			driver.switchTo().parentFrame();
			Verification.displayOfWebElement(driver.findElement(
					By.xpath("//article[@class='mod-popin-alert-ecofee mod-open']/div/header/div/div/h3")));
			driver.findElement(By.cssSelector(".bt-icon-alt")).click();
			List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
			driver.switchTo().frame(frames.get(0));

		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours addProductInComposeEditor(String product,boolean productInfoSheet) {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='furniture-add-mod-panel']")));
		WebElement prd;
		if (product.contains("|")) {
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
				prd = driver.findElement(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li[@data-ui-id='"
						+ prdId + "']/article"));
			} else {
				prd = driver.findElement(By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='"
						+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}

		} else {
			prdName = product;
			prd = driver.findElement(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			UtilHBM.waitFixTime(1000);
		}
		if (productInfoSheet) {
			productInfoSheet(prd);
		}
		
		new Actions(driver).moveToElement(prd).build().perform();
		new Actions(driver).moveToElement(prd).click().build().perform();
//		if (closeCatalog.size() > 0) {
//			closeCatalog.get(0).click();
//		}
		UtilHBM.waitFixTime(1500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours addProductProperty(String propertyName, String product, String allOrSelected,
			boolean defaultStylePrd, String acceptDelCustModifications, String... resetCustomizedLinearAppSettingIsFalse) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		WebElement prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
//			if (prdId.matches("[^0-9]")) {
				System.out.println("id " + prdId);

				prd = driver.findElement(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			} else {
				prd = driver.findElement(By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='"
						+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}

		} else {

			prdName = product;
			prd = driver.findElement(By.xpath("//div[@id='catalogbrowser-content-inner']/ul/li/article/div/h3[@title='"
					+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
		}

		if (!allOrSelected.isEmpty()) {
			new Actions(driver).moveToElement(prd).click().build().perform();
			WebElement selection = prd
					.findElement(By.cssSelector("p[class='inner-overlay']>button[class='cta-primary']"));
			WebElement all = prd.findElement(By.cssSelector("p[class='inner-overlay']>button[class='cta-secondary']"));
			UtilHBM.waitFixTime(4000);
			if (allOrSelected.equalsIgnoreCase("all")) {
				all.sendKeys(Keys.ENTER);
				System.out.println("All clicked");
				UtilHBM.waitFixTime(4000);
			} else {
//				new Actions(driver).moveToElement(selection).click().build().perform();
				selection.sendKeys(Keys.ENTER);
				System.out.println("Selection clicked");
				// UtilHBM.clickImg(imgIncaseOfSelection);
				UtilHBM.waitFixTime(3000);
			}
			UtilHBM.waitFixTime(3000);
		} else {
			new Actions(driver).moveToElement(prd).click().build().perform();
		}
		if (!defaultStylePrd) {
			if(driver.findElement(By.xpath("//footer/button[@class='cta-primary-alt-xl']/span")).getText().equalsIgnoreCase("Update")) {
				System.out.println("footer button:" +driver.findElement(By.xpath("//footer/button[@class='cta-primary-alt-xl']/span")).getText());
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".mod-popin-partial-apply-all-small.mod-open")));
			UtilHBM.waitExplicitDisplayed(driver, ikeaNoDefaultStylePrdMsgText);
			Verification.verifyText(ikeaNoDefaultStylePrdMsgText,
					"We can't apply this option to all the products in your design so a partial update will be made.",
					"Product not availalbe in default style msg");
			Verification.verifyText(ikeaNoDefaultStylePrdMsgHeading, "Unavailable products",
					"Unavailable product msg heading");
			ikeaNoDefaultStylePrdMsgOKBtn.click();
			}else {
				System.out.println("footer button:" +driver.findElement(By.xpath("//footer/button[@class='cta-primary-alt-xl']/span")).getText());
				UtilHBM.waitExplicitDisplayed(driver,
						driver.findElement(By.cssSelector(".mod-popin-unavailable-products-small.mod-open")));
				UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
				Verification.verifyText(noDefaultStylePrdMsgText,
						"The product(s) you selected are unavailable and will be inserted into your project in a different style.",
						"Product not availalbe in default style msg");
				Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products",
						"Unavailable product msg heading");
				noDefaultStylePrdMsgOKBtn.click();
			}
		}

		if (resetCustomizedLinearAppSettingIsFalse.length == 0) {
			if (acceptDelCustModifications.equalsIgnoreCase("Yes")) {
				UtilHBM.waitFixTime(1000);
				ChangeCustomMaterialConfirmation confirm = PageFactory.initElements(driver,
						ChangeCustomMaterialConfirmation.class);
				confirm.confirmCustomMaterialChange("Yes");
			} else if (acceptDelCustModifications.equalsIgnoreCase("No")) {
				UtilHBM.waitFixTime(1000);
				ChangeCustomMaterialConfirmation confirm = PageFactory.initElements(driver,
						ChangeCustomMaterialConfirmation.class);
				confirm.confirmCustomMaterialChange("No");
			}
		} else {
			if (resetCustomizedLinearAppSettingIsFalse[0].equalsIgnoreCase("yes")) {
				if (acceptDelCustModifications.equalsIgnoreCase("OK")) {
					UtilHBM.waitFixTime(1000);
					ChangeCustomMaterialConfirmation confirm = PageFactory.initElements(driver,
							ChangeCustomMaterialConfirmation.class);
					confirm.confirmCustomMaterialChange("OK", "yes");
				} else if (acceptDelCustModifications.equalsIgnoreCase("Undo")) {
					UtilHBM.waitFixTime(1000);
					ChangeCustomMaterialConfirmation confirm = PageFactory.initElements(driver,
							ChangeCustomMaterialConfirmation.class);
					confirm.confirmCustomMaterialChange("Undo", "yes");
				} else if (acceptDelCustModifications.isEmpty())
					return PageFactory.initElements(driver, MakeItYours.class);
			}
		}
		verifyProductCurrentSelection(product);

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours verifyCurrentCoveringSelectionMpbile(String product) {
//		UtilHBM.waitExplicitDisplayed(driver,
//				"//article[contains(@class,'mod-panel-catalog-browser') and contains(@class,'mod-open')]");
		// Added for bathroom
		if (driver.getCurrentUrl().contains("bathroom")) { UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@class,'catalog-browser-tabs-material-mod-panel') and contains(@class,'mod-open')]");
		}else {
			UtilHBM.waitExplicitDisplayed(driver,
					"//article[contains(@class,'mod-panel-catalog-browser-tabs-material with-footer mod-open')]");
		}
		List<WebElement> prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
				System.out.println("id " + prdId);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					UtilHBM.waitFixTime(1000);
					prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));

					if (prd.get(0).findElement(By.xpath("article[@class='selected']")).isDisplayed()) {
						UtilHBM.reportOK(product + ": Product applied is in selected mode");
					} else {
						UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
					}
				}
			} else {
				prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					UtilHBM.waitFixTime(1000);
					prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]"));
					if (prd.get(0).findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
						UtilHBM.reportOK(product + ": Product applied is in selected mode");
					} else {
						UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
					}
				}
			}

		} else {
			prdName = product;
			prd = driver.findElements(By.xpath("//div[@id='catalogbrowser-content-inner']/ul/li/article/div/h3[@title='"
					+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]"));
			if (prd.get(0).findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
				UtilHBM.reportOK(product + ": Product applied is in selected mode");
			} else {
				UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
			}
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours verifyProductCurrentSelection(String product) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		WebElement prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
				System.out.println("id " + prdId);
				prd = driver.findElement(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li"));
				if (prd.findElement(By.xpath("article[@class='selected']")).isDisplayed()) {
					UtilHBM.reportOK(product + ": Product applied is in selected mode");
				} else {
					UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
				}
			} else {
				prd = driver.findElement(By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='"
						+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]"));
				if (prd.findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
					UtilHBM.reportOK(product + ": Product applied is in selected mode");
				} else {
					UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
				}
			}

		} else {
			prdName = product;
			prd = driver.findElement(By.xpath("//div[@id='catalogbrowser-content-inner']/ul/li/article/div/h3[@title='"
					+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]"));
			if (prd.findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
				UtilHBM.reportOK(product + ": Product applied is in selected mode");
			} else {
				UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
			}
		}

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	protected MakeItYours replaceProductInCompose(String product, boolean productInfoSheet) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		List<WebElement> prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
//			if (prdId.matches("[^0-9]")) {
				System.out.println("id " + prdId);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			} else {
				prd = driver.findElements(
						By.xpath("//p[contains(text(),'" + prdId + "')]/preceding-sibling::h3[@title='" + prdName
								+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}

		} else {
			prdName = product;
			prd = driver.findElements(By.xpath("//div[@id='catalogbrowser-content-inner']/ul/li/article/div/h3[@title='"
					+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
		}

		if (!(prd.get(0).findElements(By.cssSelector("div.text .secondary-desc")).isEmpty())) {

			System.out.println("size :" + prd.get(0).findElement(By.cssSelector("div.text .secondary-desc")).getText());
			Verification.displayNAttributeCheckOfElement(
					prd.get(0).findElement(By.cssSelector("div.text .secondary-desc")), "Product Size", "text",
					prd.get(0).findElement(By.cssSelector("div.text .secondary-desc")).getText());
		}
		if (!(prd.get(0).findElements(By.cssSelector("div.text .desc")).isEmpty())) {
			System.out.println("desc :" + prd.get(0).findElement(By.cssSelector("div.text .desc")).getText());

			Verification.displayNAttributeCheckOfElement(prd.get(0).findElement(By.cssSelector("div.text .desc")),
					"Product Description", "text",
					prd.get(0).findElement(By.cssSelector("div.text .desc")).getText().trim().replaceAll("\n\r", ""));
		}
		if (!(prd.get(0).findElements(By.cssSelector("div.detailed-price .price-container")).isEmpty())) {

//			WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
			Verification.displayNAttributeCheckOfElementExcludeLineBreak(
					prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container")), "Product Price",
					"text", prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container")).getText());
		}
		if (productInfoSheet) {
			productInfoSheet(prd.get(0));
		}
		new Actions(driver).moveToElement(prd.get(0)).click().build().perform();
		closeCatalogReplacePanelForCompose();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public Catalog applyCabinetFiltersInSearch(String depth,String width) {
		if(!depth.isEmpty()) {
		clickDepthFilterMenu();
		selectFilterValueCheckBoxForSearch(depth);
		}
		if(!width.isEmpty()) {
		clickWidthFilterMenu();
		selectFilterValueCheckBoxForSearch(width);
		}
		return PageFactory.initElements(driver, Catalog.class);
	}
	public Catalog applyWorktopFiltersInSearch(String type,String material, String thickness) {
		if(!type.isEmpty()) {
		clickWorktopTypeFilterMenu();
		selectFilterValueCheckBoxForSearch(type);
		}
		if(!material.isEmpty()) {
		clickWorktopMaterialFilterMenu();
		selectFilterValueCheckBoxForSearch(material);
		}
		if(!thickness.isEmpty()) {
		clickWorktopThicknessFilterMenu();
		selectFilterValueCheckBoxForSearch(thickness);
		}
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog clickWorktopTypeFilterMenu() {
		worktopTypeFilter.click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog clickWorktopMaterialFilterMenu() {
		worktopMaterialFilter.click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog clickWorktopThicknessFilterMenu() {
		worktopThicknessFilter.click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog filterProduct() {
		String depth = prdSize.split("x")[1].trim().replace("D", "");
		String width = prdSize.split("x")[0].trim().replace("W", "");
		clickDepthFilterMenu();
		selectFilterValueCheckBox(depth);
		clickWidthFilterMenu();
		selectFilterValueCheckBox(width);
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog clickDepthFilterMenu() {
		depthFilter.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog clickWidthFilterMenu() {
		widthFilter.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog selectFilterValueCheckBox(String value) {
		WebElement valueCheckBox = driver.findElement(By.xpath(
				"//div[@class='mod-nav-overlay'][@aria-hidden='false']/div/form/ul/li/ul/li/label/input[@data-value='"
						+ value + "']/following-sibling::span[@class='state']"));
		valueCheckBox.click();
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>.spinner>.icon-view-loader");
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
		addAProductTitle.click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog selectFilterValueCheckBoxForSearch(String value) {
		WebElement valueCheckBox = driver.findElement(By.xpath(
				"//div[@class='mod-nav-overlay'][@aria-hidden='false']/div/form/ul/li/ul/li/label/input[@data-value='"
						+ value + "']/following-sibling::span[@class='state']"));
		valueCheckBox.click();
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>.spinner>.icon-view-loader");
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
UtilHBM.waitFixTime(1000);
searchResults.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog productInfoSheet(WebElement prd) {
		String img = prd.findElement(By.tagName("img")).getAttribute("srcset");
		clickPrdInfoIcon(prd).verifyProductSheet(prdName, prdSize, prdDesc, img).closeProductInfoSheet();
		return PageFactory.initElements(driver, Catalog.class);
	}

	private ProductInfoSheet clickPrdInfoIcon(WebElement prd) {
//		UtilHBM.waitExplicitDisplayed(driver,prd.findElement(By.cssSelector("div.text .desc")));
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
//		new Actions(driver).moveToElement(prd.findElement(By.cssSelector("div.text .desc"))).build().perform();
//		UtilHBM.waitFixTime(1000);
		WebElement info = prd.findElement(By.cssSelector("div>h3>button[data-ui-action='product-info']"));
//		WebElement info = prd.findElement(By.xpath("div/h3/button/span[contains(text(),'More info')]"));
//		System.out.println("info: "+info.getText());
		UtilHBM.scrollToElementWithOffset(driver, prd, 0);
		UtilHBM.waitExplicitClickable(driver, info);
//		new Actions(driver).moveToElement(info).build().perform();
//		new Actions(driver).moveToElement(info).clickAndHold().pause(500).release().build().perform();
//		prd.findElement(By.cssSelector(".text>.name>button[data-ui-action='product-info']")).click();
		info.click();
		driver.switchTo().frame(UtilHBM.webElement(driver,"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProductSheetView/embed.html']"));
		return PageFactory.initElements(driver, ProductInfoSheet.class);
	}

	public Catalog minMaxCatalogPanel() {

		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, maximizeCatalog);
		UtilHBM.waitExplicitClickable(driver, maximizeCatalog);
		Verification.displayOfWebElement(maximizeCatalog);
		new Actions(driver).moveToElement(maximizeCatalog).build().perform();
		maximizeCatalog.click();
		UtilHBM.waitFixTime(2000);
		Verification.displayOfWebElement(minimizeCatalog);
		return PageFactory.initElements(driver, Catalog.class);
	}

	public Catalog favIconInCatalogList(String dataId, String name, int index) {

		WebElement favIcon = UtilHBM.webElementXPath(driver,
				"//li[@data-ui-id='" + dataId + "']//div[@class='favorite-button-container']/button");
		UtilHBM.waitExplicitClickable(driver, favIcon);
		favIcon.click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> favList = driver.findElements(By.xpath(
				"//li/article/h3[text()='" + name + "']//following-sibling::button[@class='cta-primary-alt-sm']"));
		favList.get(index).click();
		UtilHBM.waitExplicitDisplayed(driver, favoriteSuccessMsg);
		Verification.displayNAttributeCheckOfElement(favoriteSuccessMsg, "favorite msg", "text",
				"Product has been added to the list: BRYO Fav List");

		return PageFactory.initElements(driver, Catalog.class);
	}
	public Catalog verifySearchResultNumber(String product) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, searchResults);
		searchCount = searchResults.getText().split("\\ ")[0];
		int count=Integer.parseInt(searchCount);
		String text=searchResults.getText().replaceAll("&nbsp;", "");
		String searchText=text.substring(text.indexOf(" "));
		Verification.VerifyEquals("Incorrect Search results text", searchText.trim(), "search results");
		if(count>0) {
			UtilHBM.reportOK("More than 0 results available for search");
				if( count==searchedProductList.size()){
				UtilHBM.reportOK("Correct Number of products displayed on searching the product ");				
			}else if(showMoreButtonList.size()>0){
				int x=1;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));						
				while(showMoreButtonList.size()>0 &&showMoreButtonList.get(0).isDisplayed()){	
					if(!(searchedProductList.size()/x==24)){
						UtilHBM.reportKO("Number of products per page in catalog is not 24");
					}
					showMoreButtonList.get(0).click();
					UtilHBM.waitFixTime(3000);
					x++;														
				}											
				if( count==searchedProductList.size()){
					UtilHBM.reportOK("Correct Number of products displayed on searching the product ");		
				}else{
					UtilHBM.reportWarning("Number of products displayed  in search after searching product- verification failed");
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}else{
				UtilHBM.reportWarning("Number of products displayed  in search after searching product- verification failed");
			}
			
		}else {
			UtilHBM.reportKO("Search results incorrect for given product "+product+"and count is :" +count);
		}
		return PageFactory.initElements(driver, Catalog.class);
	}
	public Catalog verifySearchResultNumberAfterFilter(String product) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, searchResults);
		searchCount = searchResults.getText().split("\\ ")[0];
		int count=Integer.parseInt(searchCount);
		String text=searchResults.getText().replaceAll("&nbps;", "");
		String searchText=text.substring(text.indexOf(" "));
		System.out.println("1:"+searchText);
		Verification.VerifyEquals("Incorrect Search results text", searchText.trim(), " search results");
		if(count>0) {
			UtilHBM.reportOK("More than 0 results available for search");
				if( count==searchedProductList.size()){
				UtilHBM.reportOK("Correct Number of products displayed on applying filter for  the product ");				
			}else if(showMoreButtonList.size()>0){
				int x=1;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));						
				while(showMoreButtonList.size()>0 &&showMoreButtonList.get(0).isDisplayed()){	
					if(!(searchedProductList.size()/x==24)){
						UtilHBM.reportKO("Number of products per page in catalog is not 24");
					}
					showMoreButtonList.get(0).click();
					UtilHBM.waitFixTime(3000);
					x++;														
				}											
				if( count==searchedProductList.size()){
					UtilHBM.reportOK("Correct Number of products displayed on applying filter for  the product ");		
				}else{
					UtilHBM.reportWarning("Number of products after applying filter in search verification failed");
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}else{
				UtilHBM.reportWarning("Number of products after applying filter in search verification failed");
			}
			
		}else {
			UtilHBM.reportKO("Search results incorrect for given product "+product+"and count is :" +count);
		}
		
		return PageFactory.initElements(driver, Catalog.class);
	}
	public MakeItYours addProductFromInfo(String product, boolean defaultStylePrd, boolean filter,
			boolean productInfoSheet) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,
				UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
		List<WebElement> prd;
		setProductInfo(product);
		if (filter) {
			filterProduct();
		}
		if (product.contains("|")) {
			prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
					+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			if (prd.size() == 0) {
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
			}
		} else {

			prd = driver.findElements(By.xpath("//h3[@title='" + prdName
					+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			if (prd.size() == 0) {
				Verification.displayOfWebElement(showMoreButton);
				UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
				UtilHBM.waitExplicitClickable(driver, showMoreButton);
				showMoreButton.click();
				UtilHBM.waitFixTime(1000);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName
						+ "']/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"));
			}
		}
		if (!(prdDesc.isEmpty())) {
			WebElement disc = prd.get(0).findElement(By.cssSelector("div.text .desc"));
			Verification.displayNAttributeCheckOfElement(disc, "Product Description", "text", prdDesc);
		}
		if (!(prdSize.isEmpty())) {
			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc"));
			Verification.displayNAttributeCheckOfElement(size, "Product Size", "text", prdSize);
		}
//		if (!(prdEnergyEffi.isEmpty())) {
//			WebElement size = prd.get(0).findElement(By.cssSelector("div.text .secondary-desc .energy-badge-aaa"));
//			Verification.displayNAttributeCheckOfElement(size, "Product Energy Efficiency", "text", prdEnergyEffi);
//		}
		if (!(prdPrice.isEmpty())) {
			if (!System.getProperty("os.name").contains("win")) {
				UtilHBM.reportInfo("This is test on Mac");
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayOfWebElement(price);
				String expectedPrice = prdPrice.split(" ")[1];
				String actualPrice = price.getText().split(" ")[1];
				if (!(actualPrice.equalsIgnoreCase(expectedPrice))) {
					UtilHBM.reportKO("Price of the " + product + " in catalog is not same as expected. Expected Price "
							+ expectedPrice + ", Actual Price is: " + actualPrice);
				}
			} else {
				byte[] bytesOfString = prdPrice.getBytes();
				String encoded_String = new String(bytesOfString, StandardCharsets.UTF_8);
				assertNotEquals(encoded_String, prdPrice);
				WebElement price = prd.get(0).findElement(By.cssSelector("div.detailed-price .price-container"));
				Verification.displayNAttributeCheckOfElementExcludeLineBreak(price, "Product Price", "text",
						encoded_String);
			}

		}
		if (productInfoSheet) {
			String img = prd.get(0).findElement(By.tagName("img")).getAttribute("srcset");
			clickPrdInfoIcon(prd.get(0));
			ProductInfoSheet productInfo = PageFactory.initElements(driver, ProductInfoSheet.class);
			productInfo.verifyProductSheetDisplayed(prdName, prdDesc,prdSize)
			.verifyProductInformation(prdDesc)
				.verifySimilarProducts()
				.addInProjectButton();
//				.clickProductInfoCloseButton();
//			clickPrdInfoIcon(prd.get(0)).verifyProductSheet(prdName, prdSize, prdDesc, img).addInProjectButton();
		}

		if (!defaultStylePrd) {
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".mod-popin-unavailable-products-small.mod-open")));
			UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
			Verification.verifyText(noDefaultStylePrdMsgText,
					"The product(s) you selected are unavailable and will be inserted into your project in a different style.",
					"Product not availalbe in default style msg");
			Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products",
					"Unavailable product msg heading");
			noDefaultStylePrdMsgOKBtn.click();
		}
		UtilHBM.waitFixTime(4500);
//		closeCatalogPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public int getReplacementCount() {
		return productList.size();
	}
//***********************************MOBILE**************************
	protected MakeItYours verifyCurrentCoveringSelection(String product) {
//		UtilHBM.waitExplicitDisplayed(driver,
//				"//article[contains(@class,'mod-panel-catalog-browser') and contains(@class,'mod-open')]");
		// Added for bathroom
		if (driver.getCurrentUrl().contains("bathroom")) { UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@class,'catalog-browser-tabs-material-mod-panel') and contains(@class,'mod-open')]");
		}else {
			UtilHBM.waitExplicitDisplayed(driver,
					"//article[contains(@class,'mod-panel-catalog-browser') and contains(@class,'mod-open')]");
		}
		List<WebElement> prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
				System.out.println("id " + prdId);
				prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					UtilHBM.waitFixTime(1000);
					prd = driver.findElements(By.xpath("//h3[@title='" + prdName + "']/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]/../parent::li/article"));

					if (prd.get(0).findElement(By.xpath("article[@class='selected']")).isDisplayed()) {
						UtilHBM.reportOK(product + ": Product applied is in selected mode");
					} else {
						UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
					}
				}
			} else {
				prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
						+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]"));
				if (prd.size() == 0) {
					UtilHBM.waitExplicitDisplayed(driver, showMoreButton);
					UtilHBM.waitExplicitClickable(driver, showMoreButton);
					showMoreButton.click();
					UtilHBM.waitFixTime(1000);
					prd = driver.findElements(By.xpath("//h3/button[@data-ui-id='" + prdId
							+ "']/../../preceding-sibling::img[starts-with(@srcset, 'https')]"));
					if (prd.get(0).findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
						UtilHBM.reportOK(product + ": Product applied is in selected mode");
					} else {
						UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
					}
				}
			}

		} else {
			prdName = product;
			prd = driver.findElements(By.xpath("//div[@id='catalogbrowser-content-inner']/ul/li/article/div/h3[@title='"
					+ prdName + "']/../preceding-sibling::img[starts-with(@srcset, 'https')]"));
			if (prd.get(0).findElement(By.xpath("//parent::article[@class='selected']")).isDisplayed()) {
				UtilHBM.reportOK(product + ": Product applied is in selected mode");
			} else {
				UtilHBM.reportKO(product + ": Product applied is  not in selected mode");
			}
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}


}
