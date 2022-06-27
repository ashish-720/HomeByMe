package hr.web.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Print {

	
	WebDriver driver;

	public Print(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[data-i18n='print.print_title']")
	private WebElement printText;
	
//	@FindBy(css = "[data-i18n='print.item_list']")
//	private WebElement itemList;
	
	@FindBy(css = ".label-icon")
	private WebElement itemList;
	
	@FindBy(css = "label>[data-i18n='print.medias']")
	private WebElement medias;
	
	@FindBy(css = "[data-i18n='print.select_all']")
	private WebElement selectAll;
	
	@FindBy(css = "[data-ui-selector='toggler-btn']")
	private WebElement iconArrow;
	
	@FindBy(css = "[data-i18n='print.print']")
	private WebElement print;
	
	@FindBy(css = ".icon-view-close")
	private WebElement printClose;
	
	public Print itemList(){
		UtilHBM.waitExplicitClickable(driver, itemList);
		WebElement icon = itemList.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(itemList, "Item list", "text", "Item list");
		Verification.displayNAttributeCheckOfElement(icon, "Item list command icon", "xlink:href", "/Shared/icons/icons.svg#icon-function-product-list");
		itemList.click();
		return PageFactory.initElements(driver, Print.class);
	}
	
//	public HomePlanner initialPlan() {
//		UtilHBM.waitExplicitClickable(driver, initialPlan);
//		WebElement icon = initialPlan.findElement(By.cssSelector("svg>use"));
//		Verification.displayNAttributeCheckOfElement(initialPlan, "Initiate plan command", "text", "Initiate Plan");
//		Verification.displayNAttributeCheckOfElement(icon, "Initiate plan command icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-change-room");
//		initialPlan.click();
//		return PageFactory.initElements(driver, HomePlanner.class);
//	}
	
	public Print medias(){
		UtilHBM.waitExplicitClickable(driver, medias);
		Verification.displayNAttributeCheckOfElement(medias, "Medias", "text", "Medias");
		medias.click();
		return PageFactory.initElements(driver, Print.class);
	}

	public Print selectAll(){
		
		UtilHBM.waitExplicitClickable(driver, selectAll);
		Verification.displayNAttributeCheckOfElement(selectAll, "Select All ", "text", "Select all");
		selectAll.click();
		return PageFactory.initElements(driver, Print.class);
	}
	
//	public Print print(String imagCount){
//	
//		UtilHBM.webElementXPath(driver, "//button[@class='cta-primary-xl']/span/span[text()='"+imagCount+"']").click();
//		//print.click();
//		return PageFactory.initElements(driver, Print.class);
//	}
	
	public ProjectOverview printClose(){
		
		printClose.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector(".iframe-container>iframe")));
		
		return PageFactory.initElements(driver, ProjectOverview.class);
		}

	
}