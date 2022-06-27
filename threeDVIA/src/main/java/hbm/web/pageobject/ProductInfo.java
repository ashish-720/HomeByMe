package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ProductInfo {
	WebDriver driver;

	public ProductInfo(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.productSheet-head > div:nth-child(1) > div:nth-child(2) > div > div > a.addthis_button_facebook")
	private WebElement facebook;

	@FindBy(css = "div.productSheet-head > div:nth-child(1) > div:nth-child(2) > div > div > a.addthis_button_twitter")
	private WebElement twitter;

	@FindBy(css = "div.productSheet-head > div:nth-child(1) > div:nth-child(2) > div > div > a.addthis_button_pinterest_share")
	private WebElement pinterest;

	@FindBy(css = "div.productSheet-head > div:nth-child(1) > div:nth-child(2) > div > div > a.button_email")
	private WebElement email;

	@FindBy(id = "sheet-model-combo")
	WebElement modelSelect;

	@FindBy(css = "div.productSheet-head-table>div>p")
	private List<WebElement> model;

	@FindBy(css = "body>main>section>div.section>div>div>div>div>div>div>.media-legend>h3")
	private List<WebElement> allBrandNames;

	@FindBy(css = "body>main>section>div.section>div>div>div>div>div>div>.media-legend>span")
	private List<WebElement> allProductNames;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>.mod-filters-tab-sm.product-tab-buttons>ul>li")
	private List<WebElement> productTabList;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-tab-contents>div.product-tab-content-details>div>p.desc")
	WebElement productInfoTabDescription;

	@FindBy(css = "div[class='ReactModal__Content ReactModal__Content--after-open modal']>div>div.modal-inner>div>div.productSheet-infos-inner>h3:nth-child(3)")
	List<WebElement> productInfoTabRelatedProductText;

	@FindBy(css = "div.product-tab-contents>div.product-tab-content-details[id='product-tab-2-simple-readonly']>div.catalog-browser>ul>li>article")
	List<WebElement> productInfoTabRelatedProductList;

	@FindBy(css = "div.product-tab-contents>div.product-tab-content-details[id='product-tab-2-simple-readonly']>div.catalog-browser>ul>div>div>li>article")
	List<WebElement> productInfoTabRelatedContentList;

	@FindBy(css = "div[class='ReactModal__Content ReactModal__Content--after-open modal']>div>div.modal-inner>div>div>div>div>a")
	WebElement infoVisitStore;

	@FindBy(css = "div.media")
	private List<WebElement> shoppingTabProduct;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>button.bt-back")
	List<WebElement> productInfoBack;

	@FindBy(xpath = "//div[@class='modal-header']/span")
	List<WebElement> productInfoBackMDM;

	@FindBy(css = "div.content>header.popin-header>button.bt-icon>span.icon-view-close")
	WebElement productInfoClose;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>h1")
	List<WebElement> productTitle;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>div>h1")
	WebElement productTitleUserProduct;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>div>div>div>div.name>a")
	WebElement userNameUserProduct;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-header>.product-brand")
	WebElement brandTitle;

	@FindBy(css = "body[class='ReactModal__Body--open'] div.content>div.inner-content>div.left-col>div>div>ul>li>img")
	WebElement productInfoTabImg;

	@FindBy(css = "body[class='ReactModal__Body--open'] div.content>div.inner-content>div.right-col>div.product-footer>a.bt-icon-label-horizontal")
	List<WebElement> productInfoTabVisitStore;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>div.productSheet-infos-inner>p")
	WebElement productInfoTabDescriptionMDM;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>div.productSheet-infos-inner>h3:nth-child(3)")
	List<WebElement> productInfoTabRelatedProductTextMDM;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>div.productSheet-infos-inner>div>div>div.media.u-mbs")
	List<WebElement> productInfoTabRelatedProductListMDM;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>div>div>div>a")
	WebElement infoVisitStoreMDM;

	@FindBy(css = "div.modal.current>a")
	WebElement productInfoCloseMDM;

	@FindBy(css = "div.modal.current>div>div.modal-header>h2")
	WebElement firstProductTitleMDM;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>img")
	WebElement productInfoTabImgMDM;

	@FindBy(css = "div.modal.current>div>div.modal-inner>div>div>div>div>img")
	WebElement productInfoTabBrandImgMDM;

	@FindBy(css = "div.productSheet-head-item>a")
	List<WebElement> productInfoTabVisitStoreMDM;

	@FindBy(xpath = "//body[@class='ReactModal__Body--open']//div[@class='product-footer']/button[@data-ui-action='open-share-subpopin']/span[contains(text(),'Share')]/..")
	WebElement productInfoTabShare;

	@FindBy(css = "div.product-footer>a.bt-icon-label-horizontal")
	List<WebElement> productInfoTabDiscoverMore;

	@FindBy(xpath = "//body[@class='hbmfor partner style-gautier no-scroll']//div[@class='productSheet-head-item']/div/a[@title='Share']")
	List<WebElement> productInfoTabShareMDM;

	@FindBy(xpath = "//h3[.='Product Description']")
	List<WebElement> productInfoTabDescriptionTextMDM;

	@FindBy(css = "div.content>div.inner-content>div.right-col>div.product-tab-contents>div.product-tab-content-details>div>p.desc")
	List<WebElement> productInfoTabDescriptionText;

	@FindBy(css = "nav.projectNav>div>ul>li>a[title*='Shopping list']")
	private WebElement shoppingListTab;

	@FindBy(css = "div.media>.media-thumb>.media-thumb-link")
	private List<WebElement> shoppingTabProductMobile;

	@FindBy(css = ".productSheet.modal-wrapper>.modal-inner>.productSheet-infos>h2")
	WebElement firstProductTitleMobile;

	@FindBy(css = "html[class=''] .productSheet.modal-wrapper>.modal-inner>.productSheet-thumb>img")
	WebElement productInfoTabImgMobile;

	@FindBy(css = ".productSheet.modal-wrapper>.modal-inner>.productSheet-infos>.productSheet-head>div>div>img[src*='/brands/']")
	WebElement productInfoTabBrandImgMobile;

	@FindBy(css = "div.productSheet-infos-inner>p")
	WebElement productInfoTabDescriptionMobile;

	@FindBy(css = "main>.productSheet.modal-wrapper>.modal-inner>div>div>div>div[class='productSheet-head-item']>span[class='button--alt button--full u-mtxs js-open-modal']")
	List<WebElement> productInfoTabShareMobile;

	@FindBy(css = "html[class=''] #shareModal>.shareBox-modal-content>div>.addthis_button_facebook[title='Facebook']>i.icon.icon-facebook")
	private WebElement facebookMobile;

	@FindBy(css = "html[class=''] #shareModal>.shareBox-modal-content>div>.addthis_button_twitter[title='Twitter']>i.icon.icon-twitter")
	private WebElement twitterMobile;

	@FindBy(css = "html[class=''] #shareModal>.shareBox-modal-content>div>.addthis_button_pinterest_share[title='Pinterest']>i.icon.icon-pinterest")
	private WebElement pinterestMobile;

	@FindBy(css = "html[class=''] #shareModal>.shareBox-modal-content>div>.addthis_button_email[title='Email']>i.icon.icon-email")
	private WebElement emailMobile;

	@FindBy(css = "html[class=''] #shareModal>.close-modal.button-close")
	private WebElement closeShareMobile;

	@FindBy(css = "html[class=''] .productSheet-infos-inner>h3:nth-child(3)")
	List<WebElement> relatedProductTextMobile;

	@FindBy(css = "html[class=''] .productSheet-infos-inner>div>div>div.media.u-mbs")
	List<WebElement> relatedProductListMobile;

	@FindBy(css = "nav.projectNav>div>ul>li>a[title='About']")
	private WebElement aboutTab;

	@FindBy(css = "body[class='ReactModal__Body--open'] div.bookmark-button-container>button")
	private List<WebElement> bookmarkIcon;

	@FindBy(css = "#app-notification>p.success")
	private WebElement addToFavSuccess;
	
	public ProductInfo openRelatedProducts() {
		UtilHBM.waitExplicitClickable(driver, productTabList.get(1).findElement(By.cssSelector("button")));
		productTabList.get(1).findElement(By.cssSelector("button")).click();
		Verification.VerifyEquals("Related products tab not displayed", productTabList.get(1).findElement(By.cssSelector("button>span.text")).getText(),"Related Product");
		Verification.displayNAttributeCheckOfElement(productTabList.get(1).findElement(By.cssSelector("button")), "Related products", "aria-expanded", "true");
		return this;	
	}
	
	public ProductInfo openRelatedContent() {
		UtilHBM.waitExplicitClickable(driver, productTabList.get(1).findElement(By.cssSelector("button")));
		productTabList.get(1).findElement(By.cssSelector("button")).click();
		Verification.VerifyEquals("Related Content tab not displayed", productTabList.get(1).findElement(By.cssSelector("button>span.text")).getText(),"Related Content");
		Verification.displayNAttributeCheckOfElement(productTabList.get(1).findElement(By.cssSelector("button")), "Related Content", "aria-expanded", "true");
		return this;	
	}
	
	public ProductInfo openProductDescription() {
		UtilHBM.waitExplicitClickable(driver, productTabList.get(0).findElement(By.cssSelector("button")));
		productTabList.get(0).findElement(By.cssSelector("button")).click();
		Verification.VerifyEquals("Product Description tab not displayed", productTabList.get(0).findElement(By.cssSelector("button>span.text")).getText(),"Product Description");
		Verification.displayNAttributeCheckOfElement(productTabList.get(0).findElement(By.cssSelector("button")), "Product description", "aria-expanded", "true");
		return this;	
	} 	
	
	public AddToFavorites clickProductBookmark() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		UtilHBM.waitExplicitDisplayed(driver, bookmarkIcon.get(0));
		UtilHBM.waitExplicitClickable(driver, bookmarkIcon.get(0));
		bookmarkIcon.get(0).click();
		return  PageFactory.initElements(driver, AddToFavorites.class);
	}
	
	public boolean isBookmarkAvailable() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		UtilHBM.waitExplicitDisplayed(driver, brandTitle);
		UtilHBM.waitFixTime(1000);
		boolean isBookmarkAvailable = false;
		UtilHBM.turnOffImplicitWaits(driver);
		if (!bookmarkIcon.isEmpty()) {
			isBookmarkAvailable = true;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return isBookmarkAvailable;
	}
	
	public String getPrdName() {
		UtilHBM.waitExplicitDisplayed(driver, productTitle.get(0));
		String prdName1 = "";
		UtilHBM.turnOffImplicitWaits(driver);
		if (!productTitle.isEmpty()) {
			prdName1 = productTitle.get(0).getText();
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return prdName1;
	}

	public String getBrndName() {
		UtilHBM.waitExplicitDisplayed(driver, brandTitle);
		String brndName=brandTitle.getText();
		return brndName;
	}
	
	public String getPrdImgSrc() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		String prdImgSrc1 = productInfoTabImg.getAttribute("src");
		String prdImgSrc = prdImgSrc1.substring(prdImgSrc1.lastIndexOf("/geometries/") + 12,prdImgSrc1.indexOf("/Thumbnails/"));
		return prdImgSrc;
	}

	private ProductInfo clickOnWebelement(WebElement webElement) {
		UtilHBM.waitExplicitClickable(driver, webElement);
		webElement.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ShareContainer clickShareProduct() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabShare);
		UtilHBM.waitExplicitClickable(driver, productInfoTabShare);
		productInfoTabShare.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	public ProjectPage checkProductSheet(String brandTitle, String productName,String generiqueOrNot) {
		verifyProductSheetDisplayed(brandTitle, productName);
		if(!generiqueOrNot.equalsIgnoreCase("Yes")) {	
			verifyProductVisitStore(productName)
				.clickShareProduct()
				.verifyShareProductDialog()
				.closeSharePoductContainer();
	}
		verifyProductDescription()
			.verifyRelatedProducts()
			.verifyProductModels(brandTitle, productName)
			.clickProductInfoCloseButton();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProductInfo verifyProductVisitStore(String productName) {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		UtilHBM.turnOffImplicitWaits(driver);
		boolean isVisitStoreDisplayed=!productInfoTabVisitStore.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (isVisitStoreDisplayed) {
			if ((productInfoTabVisitStore.get(0).getAttribute("href").startsWith("http://")
					|| productInfoTabVisitStore.get(0).getAttribute("href").startsWith("https://"))
					&& productInfoTabVisitStore.get(0).findElement(By.tagName("span")).getText().equalsIgnoreCase("VISIT STORE")) {
				UtilHBM.reportOK(productInfoTabVisitStore + " displayed");
			} else {
				UtilHBM.reportKO(productInfoTabVisitStore + " not displayed");
			}
		} else {
			UtilHBM.reportKO("Visit Store option not available for product :" + productName);
		}
		return this;
	}
	
	public ProductInfo verifyProductDescription() {
		String onlyProductDescriptionTab = productTabList.get(0)
				.findElement(By.cssSelector("button[aria-expanded='true']>span.text")).getText();
		boolean productsDescriptionTabAvailable = false;
		if (productTabList.size() > 1) {
			Verification.VerifyEquals(
					"Product description tab not displayed by default when two tabs available in product sheet",
					onlyProductDescriptionTab, "Product Description");
			productsDescriptionTabAvailable = true;
		} else if (productTabList.size() == 1) {
			UtilHBM.reportInfo("Only one tab displayed in product sheet : " + onlyProductDescriptionTab);
			if (onlyProductDescriptionTab.equalsIgnoreCase("Product Description")) {
				productsDescriptionTabAvailable = true;
			}
		}
		if (productsDescriptionTabAvailable) {
			Verification.VerifyEquals("Incorrect product description tab name displayed", onlyProductDescriptionTab,
					"Product Description");
			if (!productInfoTabDescriptionText.isEmpty()) {
				UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionText.get(0));
				UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescription);
				if (!(productInfoTabDescription.getText().equals(""))) {
					UtilHBM.reportOK("Product Description displayed");
				} else {
					UtilHBM.reportKO(" Product Description not displayed");
				}
			} else {
				UtilHBM.reportInfo("Product description Title not displayed");
			}
		} else {
			UtilHBM.reportInfo("Product description Tab not displayed");
		}
		return this;
	}
	
	public ProductInfo verifyProductInformation(String information) {
		if (!productTabList.isEmpty()) {
			String onlyProductInformationTab = productTabList.get(0)
					.findElement(By.cssSelector("button[aria-expanded='true']>span.text")).getText();
			boolean productsInformationTabAvailable = false;
			if (productTabList.size() > 1) {
				Verification.VerifyEquals(
						"Product Information tab not displayed by default when two tabs available in product sheet",
						onlyProductInformationTab, "Information");
				productsInformationTabAvailable = true;
			} else if (productTabList.size() == 1) {
				UtilHBM.reportInfo("Only one tab displayed in product sheet : " + onlyProductInformationTab);
				if (onlyProductInformationTab.equalsIgnoreCase("Information")) {
					productsInformationTabAvailable = true;
				}
			}
			if (productsInformationTabAvailable) {
				Verification.VerifyEquals("Incorrect product Information tab name displayed", onlyProductInformationTab,
						"Information");
				if (!information.equals("")) {
					if (!productInfoTabDescriptionText.isEmpty()) {
						UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionText.get(0));
						UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescription);
						if (!(productInfoTabDescription.getText().equals(""))) {
							UtilHBM.reportOK("Product Information displayed");
							Verification.VerifyEquals("Incorrect product information displayed!!!",
									productInfoTabDescription.getText(), information);
						} else {
							UtilHBM.reportKO(" Product Information not displayed");
						}
					} else {
						UtilHBM.reportInfo("Product Information Title not displayed");
					}
				}
			} else {
				UtilHBM.reportInfo("Product Information Tab not displayed");
			}
		}
		return this;
	}
	
	public ProductInfo verifyProductModels(String brandTitle, String productName) {
		UtilHBM.waitFixTime(1000);
		if (model.size() != 0) {
			Select select = new Select(modelSelect);
			int noOfMdels = select.getOptions().size();
			String previousImgSrc = productInfoTabImg.getAttribute("src");
			UtilHBM.waitFixTime(1000);
			int temp = 0;
			for (int i = 0; i < noOfMdels; i++) {
				if (!select.getOptions().get(0).isSelected()) {
					select.getOptions().get(i).click();
					UtilHBM.waitFixTime(1500);
					String currntImgSrc = productInfoTabImg.getAttribute("src");
					if (currntImgSrc.equals(previousImgSrc)) {
						UtilHBM.reportKO("Product Model not changed");
					} else {
						UtilHBM.reportOK("Product Model changed");
					}
					previousImgSrc = currntImgSrc;
				} else {
					temp++;
				}
			}
			for (int i = 0; i < noOfMdels-temp; i++) {
				clickProductInfoBackButton();
			}
		} else {
			UtilHBM.reportInfo("Models not available for " + brandTitle + " : " + productName);
		}
		return this;
	}

	public ProductInfo verifyRelatedProducts() {
		boolean relatedProductsTabAvailable = false;
		if (productTabList.size() > 1) {
			openRelatedProducts();
			relatedProductsTabAvailable = true;
		} else if (productTabList.size() == 1) {
			String onlyRelatedProductsTab = productTabList.get(0)
					.findElement(By.cssSelector("button[aria-expanded='true']>span.text")).getText();
			UtilHBM.reportInfo("Only one tab displayed in product sheet : " + onlyRelatedProductsTab);
			if (onlyRelatedProductsTab.equalsIgnoreCase("Related Product")) {
			Verification.VerifyEquals("Related products tab not available for product", onlyRelatedProductsTab,
					"Related Product");
				relatedProductsTabAvailable = true;
			}
		}
		if (relatedProductsTabAvailable) {
			if (productInfoTabRelatedProductList.size() != 0) {
				
				for (WebElement a : productInfoTabRelatedProductList) {
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div.ato-card-square>img")));
					if (a.findElement(By.cssSelector("div.ato-card-square>img")).getAttribute("src")
							.startsWith("https://")) {
						UtilHBM.reportOK("Related product image displayed");
					} else {
						UtilHBM.reportKO("Related product image not displayed");
					}
					UtilHBM.waitExplicitDisplayed(driver,
							a.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-brand")));
					String brandName = a.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-brand"))
							.getText();
					String productName = a.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-product"))
							.getText();

					if (!(brandName.equals("") || productName.equals(""))) {
						UtilHBM.reportOK("Brand and product names displayed for related products");
					} else {
						UtilHBM.reportInfo("Brand or product name not displayed for related product!! Brand name :"
								+ brandName + ",Product name : " + productName);
					}
				}
				String brandName = productInfoTabRelatedProductList.get(0)
						.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-brand"))
						.getText();
				String productTitle = productInfoTabRelatedProductList.get(0)
						.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-product"))
						.getText();
				clickOnWebelement(
						productInfoTabRelatedProductList.get(0).findElement(By.cssSelector("div.ato-card-square>img")));
				verifyProductSheetDisplayed(brandName, productTitle);
				UtilHBM.waitFixTime(1000);
				clickProductInfoBackButton();
			} else {
				UtilHBM.reportKO("Related products not displayed");
			}

		} else {
			UtilHBM.reportKO("Related products not available for product!!");
		}
		return this;
	}
	
	public ProductInfo verifyRelatedContent() {
		boolean relatedContentTabAvailable = false;
		if (productTabList.size() > 1) {
			openRelatedContent();
			relatedContentTabAvailable = true;
		} else if (productTabList.size() == 1) {
			String onlyRelatedContentTab = productTabList.get(0)
					.findElement(By.cssSelector("button[aria-expanded='true']>span.text")).getText();
			UtilHBM.reportInfo("Only one tab displayed in product sheet : " + onlyRelatedContentTab);
			if (onlyRelatedContentTab.equalsIgnoreCase("Related Content")) {
				relatedContentTabAvailable = true;
				Verification.VerifyEquals("Related content tab not available for product", onlyRelatedContentTab,
						"Related Content");
			}
		}
		if (relatedContentTabAvailable) {
			if (productInfoTabRelatedContentList.size() != 0) {		
				for (WebElement a : productInfoTabRelatedContentList) {
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div.ato-card-square>img")));
					if (a.findElement(By.cssSelector("div.ato-card-square>img")).getAttribute("src")
							.startsWith("https://")) {
						UtilHBM.reportOK("Related content image displayed");
					} else {
						UtilHBM.reportKO("Related content image not displayed");
					}
					String productName = a.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-product"))
							.getText();

					if (!productName.equals("")) {
						UtilHBM.reportOK("Product names displayed for related products");
					} else {
						UtilHBM.reportInfo("Product name not displayed for related product!! Product name : " + productName);
					}
				}
				String prdImgSrc1 = productInfoTabRelatedContentList.get(0)
						.findElement(By.cssSelector("div.ato-card-square>img")).getAttribute("src");
				String prdImgSrc=prdImgSrc1.split("/Thumbnails/")[0];
				String productTitle = productInfoTabRelatedContentList.get(0)
						.findElement(By.cssSelector("div.mol-label-product-presentation>div.ato-label-product"))
						.getText();
				clickOnWebelement(
						productInfoTabRelatedContentList.get(0).findElement(By.cssSelector("div.ato-card-square>img")))
							.verifyUserProductsDetails(productTitle, "", prdImgSrc);
				UtilHBM.waitFixTime(1000);
				clickProductInfoBackButton();
			} else {
				UtilHBM.reportKO("Related products not displayed");
			}

		} else {
			UtilHBM.reportInfo("Related products not available for product!!");
		}
		return this;
	}

	public ProjectPage checkProductSheetMDM(String brandTitle,String productName) {
		verifyProductInfoTabMDM(brandTitle, productName);
		if (!productInfoTabShareMDM.isEmpty()) {
			UtilHBM.waitExplicitClickable(driver, productInfoTabShareMDM.get(0));
			productInfoTabShareMDM.get(0).click();
			UtilHBM.waitExplicitDisplayed(driver, facebook);
			if (!facebook.isDisplayed() || !twitter.isDisplayed() || !pinterest.isDisplayed() || !email.isDisplayed()) {
				UtilHBM.reportKO("One or more of share options is/are not available in product info panel");
			}
			productInfoTabShareMDM.get(0).click();
		} else {
			UtilHBM.reportKO("Share option not available for product :" + productName);
		}
		if (productInfoTabRelatedProductTextMDM.size() != 0) {
			if (productInfoTabRelatedProductListMDM.size() != 0) {
				for (WebElement a : productInfoTabRelatedProductListMDM) {
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>a>img")));
					if (a.findElement(By.cssSelector("div>a>img")).getAttribute("src").startsWith("https://")) {
						UtilHBM.reportOK(a.findElement(By.cssSelector("div>a>img")) + " displayed");
					} else {
						UtilHBM.reportKO(a.findElement(By.cssSelector("div>a>img")) + " not displayed"); 
					}
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>h6>span")));
					if (!(a.findElement(By.cssSelector("div>h6>span")).getText().isEmpty())) {
						UtilHBM.reportOK(a.findElement(By.cssSelector("div>h6>span")) + " displayed");
					} else {
						UtilHBM.reportKO(a.findElement(By.cssSelector("div>h6>span")) + " not displayed");
					}
				}
				String title1 = productInfoTabRelatedProductListMDM.get(0).findElement(By.cssSelector("div>h6>span")).getText();
				String brandName = title1.split("-")[0];
				String productTitle = title1.split("-")[1];
				clickOnWebelement(productInfoTabRelatedProductListMDM.get(0).findElement(By.cssSelector(".media-thumb>.media-thumb-link")));				
				verifyProductInfoTabMDM(brandName.trim(), productTitle.trim());
				UtilHBM.waitFixTime(1000);
				clickProductInfoBackButtonMDM();
			} else {
				UtilHBM.reportKO("Related products not displayed");
			}
		} else {
			UtilHBM.reportInfo("Related products not available for product :" + brandTitle + " : " + productName);
		}
		UtilHBM.waitFixTime(1000);
//		if (model.size() != 0) {
//			Select select = new Select(modelSelect);
//			int noOfMdels = select.getOptions().size();
//			String previousImgSrc = productInfoTabImgMDM.getAttribute("src");
//			UtilHBM.waitFixTime(1000);
//			int temp = 0;
//			for (int i = 0; i < noOfMdels; i++) {
//				if (i == 0 && select.getOptions().get(0).isSelected()) {
//					temp = 1;
//					continue;
//				}
//				select.getOptions().get(i).click();
//				UtilHBM.waitFixTime(1500);
//				String currntImgSrc = productInfoTabImgMDM.getAttribute("src");
//				if (currntImgSrc.equals(previousImgSrc)) {
//					UtilHBM.reportKO("Product Model not changed");
//				} else {
//					UtilHBM.reportOK("Product Model changed");
//				}
//				previousImgSrc = currntImgSrc;
//
//			}
//			for (int i = 0; i < noOfMdels-temp; i++) {
//				clickProductInfoBackButtonMDM();
//			}
//		} else {
//			UtilHBM.reportInfo("Models not available for " + brandTitle + " : " + productName);
//		}
		clickProductInfoCloseButtonMDM();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProductInfo verifyProductSheetDisplayed(String brandName, String productName) {
		if (!(brandName.equals("NA") && productName.equals("NA"))) {
			UtilHBM.reportInfo("Verifying product : " + brandName);
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
			Verification.VerifyEquals(" Incorrect " + brandTitle.getText(), brandTitle.getText(), brandName);
			UtilHBM.waitExplicitDisplayed(driver, productTitle.get(0));
			if (productTitle.get(0).getText().trim().contains(productName)) {
				UtilHBM.reportOK("ProductName displayed");
			} else {
				UtilHBM.reportKO("ProductName not displayed!!Expected : " + productName + " , Available : "
						+ productTitle.get(0).getText());
			}
		} else {
			UtilHBM.reportInfo("Verifying product sheet : " + brandName);
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
			String brndName = brandTitle.getText();
			String prdName = productTitle.get(0).getText();
			if (brndName.equals("")) {
				UtilHBM.reportKO("Brand name not displayed in product sheet!!Expected Brandname : " + brandName
						+ " , expected productname : " + productName);
			}
			if (prdName.equals("")) {
				UtilHBM.reportInfo("Product name not displayed in product sheet!!Expected Brandname : " + brandName
						+ " , expected productname : " + productName);
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		if (productInfoTabImg.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productInfoTabImg + " displayed");
		} else {
			UtilHBM.reportKO(productInfoTabImg + " not displayed");
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public ProductInfo verifyProductSheetUserProducts(String productName, String userName, String prdImgSrc,
			String information) {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		verifyUserProductsDetails(productName, userName, prdImgSrc)
			.discoverMoreUserProduct(productName)
			.shareUserProduct(productName)
			.verifyProductInformation(information)
			.verifyRelatedContent();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ProductInfo verifyUserProductsDetails(String productName, String userName, String prdImgSrc) {
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		String ImgSrcAvailable=productInfoTabImg.getAttribute("src");
		if (ImgSrcAvailable.contains(prdImgSrc)) {
			UtilHBM.reportOK("productInfoTabImg displayed for product " + productName);
		} else {
			UtilHBM.reportKO("productInfoTabImg not displayed for product " + productName);
		}
		UtilHBM.waitExplicitDisplayed(driver, productTitleUserProduct);
		Verification.VerifyEquals("Wrong productTitle displayed", productTitleUserProduct.getText().trim(),
				productName);
		if (userName.equals("")) {
			UtilHBM.reportInfo("Username displayed : " + userNameUserProduct.getText());
		} else {
			Verification.VerifyEquals("Wrong username displayed", userNameUserProduct.getText(), userName);
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public ProductInfo shareUserProduct(String productName) {
		UtilHBM.reportInfo("Verifying share function for product : " + productName);
		clickShareProduct().verifyShareContainerUserProduct().closeSharePoductContainer();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ProductInfo discoverMoreUserProduct(String productName) {
		if (productInfoTabDiscoverMore.isEmpty()) {
			UtilHBM.reportInfo("Discover more button not displayed for product : " + productName);
		} else {
			Verification.VerifyEquals("Wrong discovermore button text",
					productInfoTabDiscoverMore.get(0).findElement(By.tagName("span")).getText(), "Discover More");
			String handle = driver.getWindowHandle();
			productInfoTabDiscoverMore.get(0).click();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			UtilHBM.reportInfo("URL displayed after clicking discover more : " + driver.getCurrentUrl());
			driver.close();
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public ProductInfo verifyProductInfoTabMDM(String brandName, String productName) {
		UtilHBM.reportInfo("Verifying product : " + brandName);
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMDM);
		Verification.elementContainsString(firstProductTitleMDM, brandName, "firstProductBrandName");
		UtilHBM.waitExplicitDisplayed(driver, firstProductTitleMDM);
		if (firstProductTitleMDM.getText().trim().contains(productName)) {
			UtilHBM.reportOK("ProductName displayed");
		} else {
			UtilHBM.reportKO("ProductName not displayed!!Expected : "+productName+" , Available : "+firstProductTitleMDM.getText());
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMDM);
		if (productInfoTabImgMDM.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productInfoTabImgMDM + " displayed");
		} else {
			UtilHBM.reportKO(productInfoTabImgMDM + " not displayed");
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabBrandImgMDM);
		if (productInfoTabBrandImgMDM.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productInfoTabBrandImgMDM + " displayed");
		} else {
			UtilHBM.reportKO(productInfoTabBrandImgMDM + " not displayed");
		}

		if (!productInfoTabVisitStoreMDM.isEmpty()) {
			if ((productInfoTabVisitStoreMDM.get(0).getAttribute("href").startsWith("http://")
					|| productInfoTabVisitStoreMDM.get(0).getAttribute("href").startsWith("https://"))
					&& productInfoTabVisitStoreMDM.get(0).getText().equalsIgnoreCase("VISIT STORE")) {
				UtilHBM.reportOK(productInfoTabVisitStoreMDM + " displayed");
			} else {
				UtilHBM.reportKO(productInfoTabVisitStoreMDM + " not displayed");
			}
		} else {
			UtilHBM.reportKO("Visit Store option not available for product :" + productName);
		}
		if (!productInfoTabDescriptionTextMDM.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionTextMDM.get(0));
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionMDM);
			if (!(productInfoTabDescriptionMDM.getText().equals(""))) {
				UtilHBM.reportOK("Product Description displayed");
			} else {
				UtilHBM.reportKO(" Product Description not displayed");
			}
		} else {
			UtilHBM.reportInfo("Product description Title not displayed");
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public ProductInfo clickProductInfoBackButton() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoBack.get(0));
		UtilHBM.waitExplicitClickable(driver, productInfoBack.get(0));
		productInfoBack.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ProductInfo clickProductInfoBackButtonMDM() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoBackMDM.get(0));
		UtilHBM.waitExplicitClickable(driver, productInfoBackMDM.get(0));
		productInfoBackMDM.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	
	public ProjectPage clickProductInfoCloseButton() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoClose);
		UtilHBM.waitExplicitClickable(driver, productInfoClose);
		productInfoClose.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public UserProfilePage clickProductInfoCloseUserProfilePage() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoClose);
		UtilHBM.waitExplicitClickable(driver, productInfoClose);
		productInfoClose.click();
		UtilHBM.waitTillElementDisappear(driver, productInfoClose);
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public UserProfilePage clickProductInfoCloseMediaPage() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoClose);
		UtilHBM.waitExplicitClickable(driver, productInfoClose);
		productInfoClose.click();
		UtilHBM.waitTillElementDisappear(driver, productInfoClose);
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public CommunityContent clickUserPrdInfoCloseButton() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoClose);
		UtilHBM.waitExplicitClickable(driver, productInfoClose);
		productInfoClose.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, CommunityContent.class);
	}
	
	public ProjectPage clickProductInfoCloseButtonMDM() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoCloseMDM);
		UtilHBM.waitExplicitClickable(driver, productInfoCloseMDM);
		productInfoCloseMDM.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	
	/*---------------------Following methods are used for mobile automation---------------------*/
	public ProjectPage checkProductsMobile() {
		String brandTitle = allBrandNames.get(0).getText().trim();
		Verification.displayOfWebElement(allProductNames.get(0));
		String productName = allProductNames.get(0).getText().trim();
		if (allProductNames.get(0).getText().trim().contains("...")) {
			productName = productName.replace("...", "");
		}
		
		clickOnWebelement(allProductNames.get(0)).verifyProductInfoTabMobile(brandTitle, productName);
//		Share button not clicked
//		if (!productInfoTabShareMobile.isEmpty()) {
//			UtilHBM.waitExplicitClickable(driver, productInfoTabShareMobile.get(0));
//			productInfoTabShareMobile.get(0).click();
//			UtilHBM.waitExplicitDisplayed(driver, facebookMobile);
//			if ( !facebookMobile.isDisplayed() || 
//				 !twitterMobile.isDisplayed() || 
//				 !pinterestMobile.isDisplayed() || 
//				 !emailMobile.isDisplayed() ) {
//				UtilHBM.reportKO("One or more of share options is/are not available in product info panel");
//			}
//			closeShareMobile.click();
//		} else {
//			UtilHBM.reportKO("Share option not available for product :" + productName);
//		}
		if (relatedProductTextMobile.size() != 0) {
			if (relatedProductListMobile.size() != 0) {
				for (WebElement a : relatedProductListMobile) {
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>a>img")));
					if (a.findElement(By.cssSelector("div>a>img")).getAttribute("src").startsWith("https://")) {
						UtilHBM.reportOK(a.findElement(By.cssSelector("div>a>img")) + " displayed");
					} else {
						UtilHBM.reportKO(a.findElement(By.cssSelector("div>a>img")) + " not displayed");
					}
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>h6>span")));
					if (!(a.findElement(By.cssSelector("div>h6>span")).getText().isEmpty())) {
						UtilHBM.reportOK(a.findElement(By.cssSelector("div>h6>span")) + " displayed");
					} else {
						UtilHBM.reportKO(a.findElement(By.cssSelector("div>h6>span")) + " not displayed");
					}
				}
				String title1 = relatedProductListMobile.get(0).findElement(By.cssSelector("div>h6>span")).getText();
				clickOnWebelement(relatedProductListMobile.get(0));
				verifyProductInfoTabMobile(title1.split(" ")[0], "");
				UtilHBM.waitFixTime(1000);
				driver.navigate().back();
			} else {
				UtilHBM.reportKO("Related products not displayed");
			}
		} else {
			UtilHBM.reportInfo("Related products not available for product :" + brandTitle + " : " + productName);
		}
		
		if (model.size() != 0) {
			Select select = new Select(modelSelect);
			List<WebElement> modelList = select.getOptions();
			int noOfMdels = modelList.size();
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMobile);
			String previousImgSrc = productInfoTabImgMobile.getAttribute("src");
			UtilHBM.waitFixTime(1000);
			int temp = 0;
			for (int i = 0; i < noOfMdels; i++) {
				if (!modelList.get(0).isSelected()) {
					modelList.get(i).click();
					UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMobile);
					String currntImgSrc = productInfoTabImgMobile.getAttribute("src");
					if (currntImgSrc.equals(previousImgSrc)) {
						UtilHBM.reportKO("Product Model not changed");
					} else {
						UtilHBM.reportOK("Product Model changed");
					}
					previousImgSrc = currntImgSrc;
				} else {
					temp++;
				}
			}
			for (int i = 0; i < noOfMdels - temp; i++) {
				driver.navigate().back();
			}
		} else {
			UtilHBM.reportInfo("Models not available for " + brandTitle + " : " + productName);
		}
		driver.navigate().back();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	public ProductInfo verifyProductInfoTabMobile(String brandName, String productName) {
		UtilHBM.reportInfo("Verifying product : " + brandName);
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMobile);
		UtilHBM.waitExplicitDisplayed(driver, firstProductTitleMobile);
		Verification.elementContainsString(firstProductTitleMobile, brandName, "firstProductBrandName");
		if (firstProductTitleMobile.getText().trim().contains((productName).toUpperCase())) {
			UtilHBM.reportOK("ProductName displayed");
		} else {
			UtilHBM.reportKO("ProductName not displayed");
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImgMobile);
		if (productInfoTabImgMobile.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productInfoTabImgMobile + " displayed");
		} else {
			UtilHBM.reportKO(productInfoTabImgMobile + " not displayed");
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabBrandImgMobile);
		if (productInfoTabBrandImgMobile.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productInfoTabBrandImgMobile + " displayed");
		} else {
			UtilHBM.reportKO(productInfoTabBrandImgMobile + " not displayed");
		}

		if (!productInfoTabVisitStore.isEmpty()) {
			if ((productInfoTabVisitStore.get(0).getAttribute("href").startsWith("http://")
					|| productInfoTabVisitStore.get(0).getAttribute("href").startsWith("https://"))
					&& productInfoTabVisitStore.get(0).getText().equalsIgnoreCase("VISIT STORE")) {
				UtilHBM.reportOK(productInfoTabVisitStore + " displayed");
			} else {
				UtilHBM.reportKO(productInfoTabVisitStore + " not displayed");
			}
		} else {
			UtilHBM.reportKO("Visit Store option not available for product :" + productName);
		}
		if (!productInfoTabDescriptionText.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionText.get(0));
			UtilHBM.waitExplicitDisplayed(driver, productInfoTabDescriptionMobile);
			if (!(productInfoTabDescriptionMobile.getText().equals(""))) {
				UtilHBM.reportOK("Product Description displayed");
			} else {
				UtilHBM.reportKO(" Product Description not displayed");
			}
		} else {
			UtilHBM.reportInfo("Product description Title not displayed");
		}
		return this;
	}
	
	public ProjectPage goToAboutTabMobile() {
		driver.findElement(By.cssSelector(".projectNav>.wrapper>#pull")).click();
		UtilHBM.waitExplicitClickable(driver, aboutTab);
		aboutTab.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
}
