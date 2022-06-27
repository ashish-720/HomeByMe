package hr.web.pageObject;

import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.ProjectPage;
import hr.planner.pageObject.HomePlanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceDetails {

	
	WebDriver driver;

	public PriceDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	//How to check product list and item price , Qty and total
	
	@FindBy(css = ".project-products-header>[data-i18n='project_overview.itemlist_title']")
	private WebElement priceDetailText;
	
	@FindBy(css = ".cta-secondary-icon>.icon-action-print")
	private WebElement printIcon;
	
	@FindBy(css = "[data-i18n='project_overview.item_list.print']")
	private WebElement printText;
	
	@FindBy(css = ".icon-formatting-insertunorderedlist")
	private WebElement listView;
	
	@FindBy(css = ".icon-view-grid")
	private WebElement gridView;
	
	@FindBy(css = "[data-i18n='project_overview.item_list.all']")
	private WebElement allItemList;
	
	@FindBy(css = ".mod-item-list>div>.item-list-subrow")
	List<WebElement> items;
	
	public PriceDetails items(int noOfItems){
		
		UtilHBM.waitExplicitDisplayed(driver, items.get(0));
		int noOfProductImages = items.size();
		if (noOfProductImages == noOfItems) {
			UtilHBM.reportOK("No of Images in products tab are same as No of Products");
		} else {
			UtilHBM.reportKO("No of Images in products tab are not same as No of Products.All Products Images : "
					+ noOfProductImages + " No Of Items Shopped : " + noOfItems);
		}
		
		return PageFactory.initElements(driver, PriceDetails.class);
	}
	
	
	public Print printInPriceDetails() {
		UtilHBM.waitExplicitClickable(driver, printIcon);
		WebElement icon = printIcon.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(printText, "Print Text", "text", "Print");
		Verification.displayNAttributeCheckOfElement(icon, "Print icon", "xlink:href", "/Shared/icons/icons.svg#icon-action-print");
		printText.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[id='layer-iframe']>iframe")));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "[data-i18n='print.print_title']"));
		return PageFactory.initElements(driver, Print.class);
	}
	
	public PriceDetails listView(){
		
		listView.click();
		return PageFactory.initElements(driver, PriceDetails.class);
	}
	
	public PriceDetails gridView(){
		
		gridView.click();
		return PageFactory.initElements(driver, PriceDetails.class);
	}
	
	public PriceDetails allItemList(){
		
		allItemList.click();
		return PageFactory.initElements(driver, PriceDetails.class);
	}
	
	public PriceDetails addToCart(){
		
		allItemList.click();
		return PageFactory.initElements(driver, PriceDetails.class);
	}
	
//	public void filterProjects(String product) {
//
//		List<WebElement> itemList=driver.findElements(By.xpath(
//				"//div[@class='item-list-row']/div/div/label[@for='"+product+"']"));
//		if(!itemList.isEmpty()) {
//			itemList.get(0);
//		}
//	}
	
	
	
}
