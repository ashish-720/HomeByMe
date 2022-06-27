package hr.planner.pageObject;


import java.util.ArrayList;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSheet {
	WebDriver driver;
	public ProductSheet(WebDriver driver){
		this.driver = driver;
		
	}
	
	@FindBy(css = "[data-ui-action='add-product']")
	private WebElement addInProjectButton;
	
	@FindBy(css = ".left-col>.product-single-image-container>img")
	private WebElement leftImage;
	
	@FindBy(css = "[data-i18n='product_sheet.tab_infomation']")
	private WebElement information;
	
	@FindBy(css = ".desc-container>.desc")
	private WebElement infoText;
	
	@FindBy(css = "[data-i18n='product_sheet.similar_products']")
	private WebElement similarProductHeaderText;
	
	@FindBy(css = "[data-ui-id='0']>article>div>.brand")
	private WebElement similarProductBrand;
	
	@FindBy(css = "[data-ui-id='0']>article>div>.desc")
	private WebElement similarProductText;
	
	@FindBy(css = ".product-header>h1")
	private WebElement productHeader1;
	
	@FindBy(css = ".product-header>span")
	private WebElement productHeader2;
	
	@FindBy(css = ".product-header>.favorite-button-container>button")
	private WebElement favoriteIcon;

	@FindBy(css = ".icon-view-close")
	private WebElement closeButton;
	
	@FindBy(css =".bt-back>.icon-action-arrow")
	private WebElement backButton;
	
	@FindBy(css = "[data-ui-action='configure-product']")
	private WebElement configureButton;
	
	@FindBy(css = "[data-i18n='product_sheet.visit_store']")
	private WebElement visitStoreButton;
	
	@FindBy(css = "[data-i18n='product_sheet.share_title']")
	private WebElement shareButton;
	
	public HomePlanner addInProject() {
		
		addInProjectButton.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public ConfigureProduct configure() {
		
		configureButton.click();
		UtilHBM.waitFixTime(500);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='https://d2iury6ergb1tc.cloudfront.net']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#configurator")));
		return PageFactory.initElements(driver, ConfigureProduct.class);
	}

	public ProductSheet visitStore() {
		UtilHBM.waitExplicitClickable(driver, visitStoreButton);
		visitStoreButton.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if(driver.getCurrentUrl().contains("gautier.fr")){
			UtilHBM.reportOK("Welcome to the second page");	
			//driver.close();
		}else{
			UtilHBM.reportKO("No such window was open");
		}
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getCurrentUrl().contains("bryohome")){
			UtilHBM.reportOK("Welcome to the original Bryo page");	
		}else{
			UtilHBM.reportKO("No such window was open");
		}
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, ProductSheet.class);
	}

	public PopUpLayer1 share() {
	UtilHBM.waitExplicitClickable(driver, shareButton);
	shareButton.click();
	return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	
	public HomePlanner closeProductSheet() {
		
		Verification.displayOfWebElement(UtilHBM.webElement(driver, ".product-header"));
		closeButton.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public ProductSheet image(String productName) {
		
		//Verification.displayOfWebElement(UtilHBM.webElement(driver, "img[src='https://d15x0cs0o0urpo.cloudfront.net/6BFDB286-016A-4530-BFFB-C843BA7B2EC0/Thumbnails/512.jpg']"));
		Verification.displayOfWebElement(UtilHBM.webElement(driver, ".product-header"));
		Verification.displayNAttributeCheckOfElement(productHeader1, "product name in header", "text", productName);
		Verification.displayNAttributeCheckOfElement(productHeader2, "brand name in header", "text", "BryoForHR");
		
		Verification.displayNAttributeCheckOfElement(leftImage, "image", "src", "https://d15x0cs0o0urpo.cloudfront.net/1D35DD70-84B7-4E1B-8E81-ECD82BE7546C/Thumbnails/512.jpg");
		//img link is different for different product
		//check
		return PageFactory.initElements(driver, ProductSheet.class);
	}
	
	public ProductSheet information() {
		
		Verification.displayNAttributeCheckOfElement(information, "information ", "text", "Information");
		Verification.displayNAttributeCheckOfElement(infoText, "text inside information ", "text", "Baker Francis Chairs");
		information.click();
		return PageFactory.initElements(driver, ProductSheet.class);
	}
	
	@FindBy(css = ".counter")
	private WebElement similarProductCount;
	
	public ProductSheet similarProducts(String productCount, String similarproductTextVerify) {
		
		Verification.displayNAttributeCheckOfElement(similarProductHeaderText, "similar product text -  ", "text", "Similar products");
		similarProductHeaderText.click();
		Verification.displayNAttributeCheckOfElement(similarProductBrand, "similar products Brand name -  ", "text", "BryoForHR");
		Verification.displayNAttributeCheckOfElement(similarProductText, "first similar product Text under name -  ", "text", similarproductTextVerify);
		Verification.verifyText(similarProductCount, productCount, "similarProductCount");
		UtilHBM.waitExplicitDisplayed(driver, similarProductCount);
		String similarProductTabProductCount = similarProductCount.getText();
		if (similarProductTabProductCount == productCount) {
			UtilHBM.reportOK("No of product in similar product tab are same");
		} else {
			UtilHBM.reportKO("No of product in similar product tab are not same. All product count : "
					+ similarProductTabProductCount + " No Of product : " + productCount);
		}
		
		return PageFactory.initElements(driver, ProductSheet.class);
	}
	
	public Favorites clickfavInProductSheet() {
		
		favoriteIcon.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, Favorites.class);
	}

	public Favorites clickFavIconInSimilarList(String dataId) {	
		
//		WebElement favIcon = UtilHBM.webElementXPath(driver, "//li[@data-ui-id='"+dataId+"']//div[@class='favorite-button-container']/button");
		WebElement favIcon = UtilHBM.webElementXPath(driver, "//div[@class='favorite-button-container']/button");
		
		UtilHBM.waitExplicitClickable(driver, favIcon);
		favIcon.click();
		driver.switchTo().parentFrame();
		
		return PageFactory.initElements(driver, Favorites.class);		
	}

	public ProductSheet clickOnSimilarProduct(String dataId) {
		Verification.displayOfWebElement(UtilHBM.webElement(driver, ".product-header"));
		WebElement image = UtilHBM.webElementXPath(driver, "//li[@data-ui-id='"+dataId+"']//article/img");
		UtilHBM.waitExplicitClickable(driver, image);
		WebElement clickOnAnySimilarProduct = UtilHBM.webElementXPath(driver, "//li[@data-ui-id='"+dataId+"']//div[@class='text']/h3");
		UtilHBM.waitExplicitClickable(driver, clickOnAnySimilarProduct);
		clickOnAnySimilarProduct.click();
		return PageFactory.initElements(driver, ProductSheet.class);
	}
	
	public ProductSheet back() {
		UtilHBM.waitExplicitDisplayed(driver, backButton);
		backButton.click();
		return PageFactory.initElements(driver, ProductSheet.class);
	}
	
	}
