package kitchen.bryo.pageObject;

import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoSheet {
	
	WebDriver driver;
	
	public ProductInfoSheet(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css=".content.single-image>.inner-content>div[class^='right-col']>div[class='product-header']>h1")
	private WebElement prodName;
	
	@FindBy(css=".content.single-image>.inner-content>div[class^='right-col']>div[class='product-header']>p")
	private WebElement prodShortDesc;
	
	@FindBy(css=".content.single-image>.inner-content>div[class='left-col']>div[class='product-single-image-container']>img")
	private WebElement productImageContainer;
	
	@FindBy(css=".content>.inner-content>.product-area>div>div>p.info")
	private WebElement prodInfo;
	
	@FindBy(xpath = "//div[@class='product-desc']/div[@class='flex-container']/p[@class='desc']")
	private WebElement prodDesc;
	
	@FindBy(xpath = "//div[@class='product-desc']/div[@class='flex-container']/p[@class='dimensions']")
	private WebElement dimensions;
	
	@FindBy(xpath = "//ul[@class='product-option-list']/li")
	private List<WebElement> productOptionsList;
	
	@FindBy(xpath="//div/div/div/div/div/div/div/b[.='Dimensions']")
	private WebElement dimensionsText;
	
	@FindBy(xpath="//div/div/div/div/div/div/div/p[starts-with(text(), 'Height')]")
	private WebElement heightText;
	
	@FindBy(xpath="//div/div/div/div/div/div/div/p[starts-with(text(), 'Depth')]")
	private WebElement depthText;
	
	@FindBy(xpath="//div/div/div/div/div/div/div/p[starts-with(text(), 'Width')]")
	private WebElement widthText;
	
	@FindBy(css=".content>.main>.inner-content>.product-info>.left-col>img[src*='https']")
	private WebElement prodimg;
	
	@FindBy(xpath="//article[@class='mod-popin-product-sheet-xlarge mod-open']/div/header/button")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//article[@class='mod-popin-product-sheet-xlarge mod-open']/div/div/div[@class='right-col-no-footer']/div[@class='product-footer']/button[@data-ui-action='add-product']")
	private WebElement addInProjectButton;
	
	@FindBy(css="div.content.single-image>div.inner-content>div.right-col-no-footer>div.product-tab-contents>.mod-filters-tab-sm.product-tab-buttons>ul>li")
	private List<WebElement> productTabList;

@FindBy(css="div.product-tab-contents>div.product-tab-content-details[id='product-tab-2-simple']>div.catalog-browser>ul>li>article")
	List<WebElement> productInfoTabSimilarProductList;

	@FindBy(css="div.content>div.inner-content>div.right-col-no-footer>div.product-header>button.bt-back")
	List<WebElement> productInfoBack; 

@FindBy(css="div.content>header.popin-header>button.bt-icon>span.icon-view-close")
	WebElement productInfoClose;
	
@FindBy(css="div.content>div.inner-content>div.right-col-no-footer>div.product-header>h1")
List<WebElement> productTitle;

@FindBy(css="div.content>div.inner-content>div.right-col-no-footer>div.product-header>.short-description")
WebElement desc;


@FindBy(css = "div.content>div.inner-content>div.right-col-no-footer>div.product-tab-contents>div.product-tab-content-details>div>p.desc")
List<WebElement> productInfoTabDescriptionText;

@FindBy(css="div.content>div.inner-content>div.right-col-no-footer>div.product-tab-contents>div.product-tab-content-details>div>p.desc")
WebElement productInfoTabDescription;
	protected ProductInfoSheet verifyProductSheet(String prdName, String prdSize, String prdDesc, String img){
		
	UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-popin-product-sheet-xlarge mod-open']")));
//		UtilHBM.waitExplicitDisplayed(driver, prodimg);
		Verification.displayNAttributeCheckOfElement(prodName, "Product Name", "text", prdName);
		if(!prdDesc.isEmpty()){
			Verification.displayNAttributeCheckOfElement(prodShortDesc, "Product Description", "text", prdDesc);
		}
		UtilHBM.waitExplicitDisplayed(driver, productImageContainer);
		if (productImageContainer.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productImageContainer + " displayed");
		} else {
			UtilHBM.reportKO(productImageContainer + " not displayed");
		}
	
		
		if(!prdSize.isEmpty()){	
			System.out.println("****");
			String wdth=Integer.toString(Integer.parseInt((prdSize.split("x")[0].trim().replace("W", "")))/10);
			String dpth=Integer.toString(Integer.parseInt((prdSize.split("x")[1].trim().replace("D", "")))/10);
			String ht=Integer.toString(Integer.parseInt((prdSize.split("x")[2].trim().replace("H", ""))));
			String h1= "Height: "+ht+" mm";
			
			String w1="Width: "+wdth+" mm";
			System.out.println("h1:"+h1);
			if(!productOptionsList.isEmpty()&&productOptionsList.get(0).getText().contains("mm")) {
			for (int i = 0; i < productOptionsList.size(); i++) {
//				System.out.println("a:" +a.getText());
				if(productOptionsList.get(i).getText().startsWith("Height")) {
					String height = productOptionsList.get(i).getText();
					System.out.println("ht:"+height);
					
					if(height.equalsIgnoreCase(h1)) {
						UtilHBM.reportOK("Product size in info sheet verified");
					}else {
						UtilHBM.reportKO("Product size in info sheet not verified");
					}
				}
				}
			}
	
//			String width = dimensions.getText().split("x")[0].trim().replace("W", "");
//			String depth = dimensions.getText().split("x")[1].trim().replace("D", "");
//			String height = dimensions.getText().split("x")[2].trim().replace("H", "");
////			if(dimensionsText.isDisplayed() && heightText.getText().equals(height) &&
////					depthText.getText().equals(depth) && widthText.getText().equals(width)){
////				UtilHBM.reportOK("Product size in info sheet verified");
////			}
//			if(wdth.equalsIgnoreCase(width)&&dpth.equalsIgnoreCase(depth)&&ht.equalsIgnoreCase(height)){
//				UtilHBM.reportOK("Product size in info sheet verified");
//			}else{
//				UtilHBM.reportKO("Product size in info sheet KO. Expected value: ");
//				UtilHBM.reportKO(height);
//				UtilHBM.reportKO(width);
//				UtilHBM.reportKO(depth);
////				UtilHBM.reportKO("Actual value: ");
////				UtilHBM.reportKO(heightText.getText());
////				UtilHBM.reportKO(depthText.getText());
////				UtilHBM.reportKO(widthText.getText());
//			}		
		}
		
//		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
//		driver.switchTo().frame(frames.get(0));
		return PageFactory.initElements(driver, ProductInfoSheet.class);
	}
	protected Catalog addInProjectButton() {
		UtilHBM.waitExplicitClickable(driver, addInProjectButton);
		addInProjectButton.click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	protected MakeItYours closeProductInfoSheet() {
		UtilHBM.waitExplicitClickable(driver, closeBtn);
		closeBtn.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public ProductInfoSheet openSimilarProducts() {
		UtilHBM.waitExplicitClickable(driver, productTabList.get(1).findElement(By.cssSelector("button")));
		productTabList.get(1).findElement(By.cssSelector("button")).click();
		Verification.VerifyEquals("Similar products tab not displayed", productTabList.get(1).findElement(By.cssSelector("button>span.text")).getText(),"Similar products");
		Verification.displayNAttributeCheckOfElement(productTabList.get(1).findElement(By.cssSelector("button")), "Similar products", "aria-expanded", "true");
		return this;	
	}
	
	public ProductInfoSheet verifySimilarProducts() {
		boolean similarProductsTabAvailable = false;
		if (productTabList.size() > 1) {
			openSimilarProducts();
			similarProductsTabAvailable = true;
		} else if (productTabList.size() == 1) {
			String onlySimilarProductsTab = productTabList.get(0)
					.findElement(By.cssSelector("button[aria-expanded='true']>span.text")).getText();
			UtilHBM.reportInfo("Only one tab displayed in product sheet : " + onlySimilarProductsTab);
			if (onlySimilarProductsTab.equalsIgnoreCase("Similar Product")) {
			Verification.VerifyEquals("Similar products tab not available for product", onlySimilarProductsTab,
					"Similar products");
				similarProductsTabAvailable = true;
			}
		}
		if (similarProductsTabAvailable) {
			if (productInfoTabSimilarProductList.size() != 0) {
				
				for (WebElement a : productInfoTabSimilarProductList) {
					UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("img")));
					if (a.findElement(By.cssSelector("img")).getAttribute("srcset")
							.startsWith("https://")) {
						UtilHBM.reportOK("Similar product image displayed");
					} else {
						UtilHBM.reportKO("Similar product image not displayed");
					}
					UtilHBM.waitExplicitDisplayed(driver,
							a.findElement(By.cssSelector("div.text>h3.name>span")));
					String productName = a.findElement(By.cssSelector("div.text>h3.name>span"))
							.getText();
					String productDesc = a.findElement(By.cssSelector("div.text>p.desc"))
							.getText();
				String productSecondaryDesc = a.findElement(By.cssSelector("div.text>p.secondary-desc"))
							.getText();
					if (!(productName.equals("") || productDesc.equals(""))||productSecondaryDesc.equals("")) {
						UtilHBM.reportOK("Product name,desc  and product secondary-desc displayed for Similar products");
					} else {
						UtilHBM.reportInfo("Product name,desc  and product secondary-desc not displayed for Similar product!! Product name :"
								+ productName + ",Product desc : " + productDesc+ ",Product secondary-desc  : " +productSecondaryDesc);
					}
				}
				String productName = productInfoTabSimilarProductList.get(0)
						.findElement(By.cssSelector("div.text>h3.name>span"))
						.getText();
				String productTitle = productInfoTabSimilarProductList.get(0)
						.findElement(By.cssSelector("div.text>p.desc"))
						.getText();
				String prdSize = productInfoTabSimilarProductList.get(0)
						.findElement(By.cssSelector("div.text>p.secondary-desc"))
						.getText();
				clickOnWebelement(
						productInfoTabSimilarProductList.get(0).findElement(By.cssSelector("img")));
				verifyProductSheetDisplayed(productName, productTitle,prdSize);
				UtilHBM.waitFixTime(1000);
				clickProductInfoBackButton();
			} else {
				UtilHBM.reportKO("Similar products not displayed");
			}

		} else {
			UtilHBM.reportKO("Similar products not available for product!!");
		}
		return this;
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

	public String getPrdDesc() {
		UtilHBM.waitExplicitDisplayed(driver, desc);
		String prdDesc=desc.getText();
		return prdDesc;
	}
	
	public String getPrdImgSrc() {
		UtilHBM.waitExplicitDisplayed(driver, productImageContainer);
		String prdImgSrc1 = productImageContainer.getAttribute("src");
		String prdImgSrc = prdImgSrc1.substring(prdImgSrc1.lastIndexOf("/geometries/") + 12,prdImgSrc1.indexOf("/Thumbnails/"));
		return prdImgSrc;
	}
	private ProductInfoSheet clickOnWebelement(WebElement webElement) {
		UtilHBM.waitExplicitClickable(driver, webElement);
		Actions action=new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
		
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfoSheet.class);
	}
	public ProductInfoSheet verifyProductSheetDisplayed(String prductName, String productDesc,String prdSize) {
		if (!(prductName.equals("NA") && productDesc.equals("NA"))) {
			UtilHBM.reportInfo("Verifying product : " + prductName);
			UtilHBM.waitExplicitDisplayed(driver, productImageContainer);
			Verification.VerifyEquals(" Incorrect " + prodName.getText(), prodName.getText(), prductName);
			UtilHBM.waitExplicitDisplayed(driver, productTitle.get(0));
			if (productTitle.get(0).getText().trim().contains(prductName)) {
				UtilHBM.reportOK("ProductName displayed");
			} else {
				UtilHBM.reportKO("ProductName not displayed!!Expected : " + prductName + " , Available : "
						+ productTitle.get(0).getText());
			}
			if (desc.getText().trim().contains(productDesc)) {
				UtilHBM.reportOK("Product  Desc displayed");
			} else {
				UtilHBM.reportKO("ProductDesc not displayed!!Expected : " + productDesc + " , Available : "
						+ desc.getText());
			}
			
		} else {
			UtilHBM.reportInfo("Verifying product sheet : " + prductName);
			UtilHBM.waitExplicitDisplayed(driver, productImageContainer);
			String prdDesc = desc.getText();
			String prdName = productTitle.get(0).getText();
			if (prdDesc.equals("")) {
				UtilHBM.reportKO("Product name not displayed in product sheet!!Expected productName : " + prductName
						+ " , expected productname : " + productDesc);
			}
			if (prdName.equals("")) {
				UtilHBM.reportInfo("Product name not displayed in product sheet!!Expected productName : " + prductName
						+ " , expected productname : " + productDesc);
			}
		}
		if(!prdSize.isEmpty()){	
			System.out.println("****");
			String wdth=Integer.toString(Integer.parseInt((prdSize.split("x")[0].trim().replace("W", "")))/10);
			String dpth=Integer.toString(Integer.parseInt((prdSize.split("x")[1].trim().replace("D", "")))/10);
			String ht=Integer.toString(Integer.parseInt((prdSize.split("x")[2].trim().replace("H", ""))));
			String h1= "Height: "+ht+" mm";
			
			String w1="Width: "+wdth+" mm";
			System.out.println("h1:"+h1);
			if(!productOptionsList.isEmpty()&&productOptionsList.get(0).getText().contains("mm")) {
			for (int i = 0; i < productOptionsList.size(); i++) {
//				System.out.println("a:" +a.getText());
				if(productOptionsList.get(i).getText().startsWith("Height")) {
					String height = productOptionsList.get(i).getText();
					System.out.println("ht:"+height);
					
					if(height.equalsIgnoreCase(h1)) {
						UtilHBM.reportOK("Product size in info sheet verified");
					}else {
						UtilHBM.reportKO("Product size in info sheet not verified");
					}
				}
				}
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, productImageContainer);
		if (productImageContainer.getAttribute("src").startsWith("https://")) {
			UtilHBM.reportOK(productImageContainer + " displayed");
		} else {
			UtilHBM.reportKO(productImageContainer + " not displayed");
		}
		return PageFactory.initElements(driver, ProductInfoSheet.class);
	}
	public ProductInfoSheet clickProductInfoBackButton() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoBack.get(0));
		UtilHBM.waitExplicitClickable(driver, productInfoBack.get(0));
		productInfoBack.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfoSheet.class);
	}
	public MakeItYours clickProductInfoCloseButton() {
		UtilHBM.waitExplicitDisplayed(driver, productInfoClose);
		UtilHBM.waitExplicitClickable(driver, productInfoClose);
		productInfoClose.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
	public ProductInfoSheet verifyProductInformation(String information) {
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
}
