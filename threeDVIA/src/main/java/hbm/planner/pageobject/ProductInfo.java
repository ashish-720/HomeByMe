package hbm.planner.pageobject;

import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.CommunityContent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductInfo {
	
	WebDriver driver;
	
	public ProductInfo(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open>.content>.inner-content>div>.product-header>.product-brand")
	private WebElement brandName;
	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open>.content>.inner-content>div>.product-header>.product-brand+h1")
	private WebElement productName;
	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open>.content>.inner-content>.left-col>div>div>ul>li>img")
	private WebElement productImage;
	
//	@FindBy(css="div>.modal-wrap .productSheet-infos>div>div>div>img")
//	private WebElement brandLogo;
	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open>.content>.inner-content>.right-col>div>.cta-primary")
	private WebElement addToProject;
	
	@FindBy(css=".bookmark-button-container>.bt-icon-bookmark>div>.icon-hbm-function-bookmark")
	private WebElement bookmark;
	
//	@FindBy(css="div>.modal-wrap .productSheet-infos .productSheet-model-item.u-pts.u-pbs>p")
//	private WebElement modelText;
//	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open #sheet-model-combo")
	private WebElement selectModel;
	
	@FindBy(css=".mod-popin-product-sheet-xlarge.mod-open #sheet-model-combo>option[selected='selected']")
	private WebElement selectedModel;
	
//	@FindBy(css="div>.modal-wrap .productSheet-infos-inner>div>div>h5")
//	private WebElement productDescriptionTitle;
//	
//	@FindBy(css=".right-col>div>.bt-icon-label-horizontal[data-ui-action='open-share-subpopin']>svg+span")
//	private WebElement share;
//	
//	@FindBy(css=".productSheet-infos-inner .w-50.u-txtRight.shareBox.shareBoxProduct.shareBox--open>div>div>.addthis_button_facebook")
//	private WebElement facebook;
//	
//	@FindBy(css=".productSheet-infos-inner .w-50.u-txtRight.shareBox.shareBoxProduct.shareBox--open>div>div>.addthis_button_twitter")
//	private WebElement twitter;
//	
//	@FindBy(css=".productSheet-infos-inner .w-50.u-txtRight.shareBox.shareBoxProduct.shareBox--open>div>div>.addthis_button_pinterest_share")
//	private WebElement pinterest;
//	
//	@FindBy(css=".productSheet-infos-inner .w-50.u-txtRight.shareBox.shareBoxProduct.shareBox--open>div>div>a[href*='mailto']")
//	private WebElement email;
//	
//	@FindBy(css=".productSheet-infos-inner>p")
//	private WebElement descriptionText;
//	
//	@FindBy(css=".productSheet-infos-inner>#additional-items>h5")
//	private WebElement similarProducts;
//	
//	@FindBy(css=".productSheet-infos-inner>#additional-items>div>div>.u-mbs.product.w-50")
//	private List<WebElement> similarProductsList;
	
	@FindBy(css=".content>.popin-header>button>span>svg")
	private WebElement close;
	
	@FindBy(css="div>div>.modal-header-nav")
	private WebElement back;

	@FindBy(css= ".product-footer>.cta-primary")
	private WebElement replace;
	
	@FindBy(css="div.content>div.inner-content>div.left-col>div>div>ul>li>img")
	WebElement productInfoTabImg;
	
	@FindBy(css="div.product-footer>a.bt-icon-label-horizontal")
	List<WebElement> productInfoTabDiscoverMore;
	
	@FindBy(css="div.product-footer>button.bt-icon-label-horizontal")
	List<WebElement> productInfoTabShare;
	
	@FindBy(css="div.content>div.inner-content>div.right-col>div.product-header>div>h1")
	WebElement productTitleUserProduct;
	
	@FindBy(css="div.content>div.inner-content>div.right-col>div.product-header>div>div>div>div.name>a[href*='/en/profile/']")
	WebElement userNameUserProduct;

	@FindBy(css = ".mod-popin-product-sheet-xlarge.mod-open>.content>.inner-content>div>.product-header>.header-user>.caption-user>.avatar")
	WebElement userNameUserProductIcon;
	
	@FindBy(xpath = "//span[text()='Discover More']")
	WebElement ccDiscoverMore;
	
	
	public ThreeDPlanner addProductFromInfo(String brandProductImg){
		checkInfo(brandProductImg);
		addToProject.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner addProductOtherModelFromInfo(String brandProductImg, int model){
		checkInfo(brandProductImg);
//		if(model>0){
//			if(modelText.isDisplayed() && modelText.getText().equalsIgnoreCase("model") && new Select(selectModel).getOptions().size()>1){
//				UtilHBM.reportOK("Model list is available in product info panel of " + brandProductImg.split(">")[1]);
//				
//			}else{
//				UtilHBM.reportKO("Model list / text is not available in product info panel of " + brandProductImg.split(">")[1]);
//			}
//		}
		new Select(selectModel).selectByIndex(model-1);
		UtilHBM.waitFixTime(1000);
//		if(!productImage.getAttribute("src").equalsIgnoreCase(brandProductImg.split(">")[2])){
//			UtilHBM.reportOK("Model changed from " + brandProductImg.split(">")[1] + " to" + selectedModel.getText());
//		}else{
//			UtilHBM.reportKO("Model change failed in info panel of " + brandProductImg.split(">")[1] );
//		}
		addToProject.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected void checkInfo(String brandProductImg){
		UtilHBM.waitExplicitClickable(driver, bookmark);
		if((!(brandName.getText().contains(brandProductImg.split(">")[0]))) || !(productName.getText().toLowerCase().contains(brandProductImg.split(">")[1].toLowerCase()))){
			UtilHBM.reportKO("Brand or product name do not match in info panel of " + brandProductImg.split(">")[1]);	
			UtilHBM.reportKO("Excpected Brand & product name: "+ brandProductImg.split(">")[0] +" & " + brandProductImg.split(">")[1]);
			UtilHBM.reportKO("Actual Brand is: "+brandName.getText() +" & product name is "+ productName.getText());
		}
		if(brandProductImg.split(">").length==3){
			if(!productImage.getAttribute("src").contains(brandProductImg.split(">")[2].split("cloudfront.net/")[1])){
				UtilHBM.reportKO("Product Image in info panel do not match with catalog image for " + brandProductImg.split(">")[1]);
				UtilHBM.reportKO("Expected image: "+brandProductImg.split(">")[2]);
				UtilHBM.reportKO("Actual image: "+productImage.getAttribute("src"));
			}
		}
//		else{
//			if(!brandProductImg.split(">")[3].equalsIgnoreCase(brandLogo.getAttribute("src"))){
//				UtilHBM.reportKO("Brand Logo in toolbar info do not match with info panel");
//			}
//		}		
//		if(!brandLogo.getAttribute("src").startsWith("https://byme") && !brandLogo.getAttribute("src").endsWith(".png")){
//			UtilHBM.reportKO("Brand logo is not displayed in product info panel of " + brandProductImg.split(">")[1]);
//		}
		if(!bookmark.isDisplayed()){
			UtilHBM.reportKO("Bookmark icon is not available in info panel of " + brandProductImg.split(">")[1]);
		}
//		if(!productDescriptionTitle.getText().equalsIgnoreCase("Product Description") || descriptionText.getText().isEmpty()){			
//			UtilHBM.reportKO("Product description title or description is not availalbe in info panel of " + brandProductImg.split(">")[1]);
//		}
//		if(!similarProducts.getText().equalsIgnoreCase("Similar Products") || !(similarProductsList.size()>0)){
//			UtilHBM.reportKO("Similar products title or products are not available in info panel of "+ brandProductImg.split(">")[1]);
//		}
//		share.click();
//		UtilHBM.waitExplicitClickable(driver, facebook);
//		if(!facebook.isDisplayed() || !twitter.isDisplayed() || !pinterest.isDisplayed() || ! email.isDisplayed()){
//			UtilHBM.reportKO("One or more of share options is/are not available in product info panel of " + brandProductImg.split(">")[1]);
//		}		
	}
	
	protected ThreeDPlanner favFrmPrdSheet(String brandProductImg, String favList,String newOrExistingList,boolean isNewProduct){
		checkInfo(brandProductImg);
		bookmark.click();
		SelectFavList fav = PageFactory.initElements(driver, SelectFavList.class);
//		fav.searchNSelectFavList(favList, new_1_old_0);
		fav.selectFavList("", favList, newOrExistingList, isNewProduct);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner replaceFrmPrdSheet(String brandProductImg){
		//checkInfo(brandProductImg);
		UtilHBM.waitExplicitDisplayed(driver, replace);
		replace.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
		
	public ThreeDPlanner closePrdSheet(){
		Verification.displayOfWebElement(close);
		close.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ProductInfo discoverMore() {

		String handle = driver.getWindowHandle();
		UtilHBM.waitExplicitClickable(driver, ccDiscoverMore);
		ccDiscoverMore.click();
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equalsIgnoreCase(handle)) {
				driver.switchTo().window(winHandle);
			}
		}
		System.out.println(driver.getCurrentUrl());
		UtilHBM.reportInfo("URL opened after clicking discover more : "
				+ driver.getCurrentUrl());
		driver.close();
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"W");
		driver.switchTo().window(handle);
		
		System.out.println(driver.getCurrentUrl());
		UtilHBM.reportInfo("Previous URL opened : "
				+ driver.getCurrentUrl());
		return this;
	}
	
	public ThreeDPlanner verifyCommunityContentProductSheet(String prdImgSrc, String userName, String productName, String userIcon) {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		UtilHBM.waitExplicitDisplayed(driver, productInfoTabImg);
		if (productInfoTabImg.getAttribute("src").contains(prdImgSrc)) {
			UtilHBM.reportOK("productInfoTabImg displayed for product " + productName);
		} else {
			UtilHBM.reportKO("productInfoTabImg not displayed for product " + productName);
		}
		//Verification.displayNAttributeCheckOfElement(productImage, "productImage", "src", "https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/geometries/7AB858F6-2D59-438B-B2E2-421D2BC14D68/Thumbnails/Origin.jpg");
		UtilHBM.waitExplicitDisplayed(driver, productTitleUserProduct);
		Verification.VerifyEquals("Wrong productTitle displayed",productTitleUserProduct.getText().trim(),productName);
		Verification.VerifyEquals("Wrong username displayed",userNameUserProduct.getText(),userName);
		Verification.VerifyEquals("User name Icon not displayed", userNameUserProductIcon.getText(), userIcon);
		if (productInfoTabDiscoverMore.isEmpty()) {
			UtilHBM.reportInfo("Discover more button not displayed for product : " + productName);
		} else {
			Verification.VerifyEquals("Wrong discovermore button text",
					productInfoTabDiscoverMore.get(0).findElement(By.tagName("span")).getText(), "Discover More");
		}
		if (productInfoTabShare.isEmpty()) {
			UtilHBM.reportKO("Product share button not displayed for product : " + productName);
		} else {
			UtilHBM.reportOK("Product share button displayed");
		discoverMore()
		.closePrdSheet();
		
		}
		return PageFactory.initElements(driver, ThreeDPlanner.class);
		
	}
	

}
