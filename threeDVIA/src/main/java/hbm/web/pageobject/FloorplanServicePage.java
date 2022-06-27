package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class FloorplanServicePage {
	WebDriver driver;

	public FloorplanServicePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.cell-4.page--services__sticky>div>div>div>a[href='https://preprod-home.by.me/en/floorplan-conversion/upload/floor-plan']")
	WebElement buyUnfurnishedFPSticky;

	@FindBy(css = "div.cell-4.page--services__sticky>div>div>div>a[href='https://preprod-home.by.me/en/floorplan-conversion/upload/furniture-floor-plan']")
	WebElement buyFurnishedFPSticky;

	@FindBy(css = "section.panel.panel--default.accordion-image>div>div>div>div>div>div>a[href^='https://home.by.me/en/floorplan-conversion/upload/floor-plan']")
	WebElement buyUnfurnishedFP;

	@FindBy(css = "section.panel.panel--default.accordion-image>div>div>div>div>div>div>a[href^='https://home.by.me/en/floorplan-conversion/upload/furniture-floor-plan']")
	WebElement buyFurnishedFP;

	@FindBy(css = "div.cell-4.page--services__sticky>div>div:nth-child(1)>div>div.sticky-offers__price")
	WebElement priceUnfurnishedFPSticky;

	@FindBy(css = "div.cell-4.page--services__sticky>div>div:nth-child(2)>div>div.sticky-offers__price")
	WebElement priceFurnishedFPSticky;

	public FloorPlanConversion clickBuyUnfurnishedFP() {
		UtilHBM.waitExplicitClickable(driver, buyUnfurnishedFPSticky);
		UtilHBM.waitExplicitDisplayed(driver, buyUnfurnishedFPSticky);
		buyUnfurnishedFPSticky.click();
		return PageFactory.initElements(driver, FloorPlanConversion.class);
	}

	public FloorPlanConversion clickBuyFurnishedFP() {
		UtilHBM.waitExplicitClickable(driver, buyFurnishedFPSticky);
		UtilHBM.waitExplicitDisplayed(driver, buyFurnishedFPSticky);
		buyFurnishedFPSticky.click();
		return PageFactory.initElements(driver, FloorPlanConversion.class);
	}

	public FloorPlanConversion clickBuyUnfurnishedFPSticky() {
		UtilHBM.waitExplicitClickable(driver, buyUnfurnishedFPSticky);
		UtilHBM.waitExplicitDisplayed(driver, buyUnfurnishedFPSticky);
		buyUnfurnishedFPSticky.click();
		return PageFactory.initElements(driver, FloorPlanConversion.class);
	}

	public FloorPlanConversion clickBuyFurnishedFPSticky() {
		UtilHBM.waitExplicitClickable(driver, buyFurnishedFPSticky);
		UtilHBM.waitExplicitDisplayed(driver, buyFurnishedFPSticky);
		buyFurnishedFPSticky.click();
		return PageFactory.initElements(driver, FloorPlanConversion.class);
	}
	
	public UploadedFloorplanDetails buyFloorPlanServices(String fpInput) {
		String floorplanProject = UtilHBM.getProperty("testData", fpInput + "Offer");
		if (floorplanProject.equals("Furnished project")) {
			clickBuyFurnishedFP().uploadFloorPlan(fpInput);
		} else if (floorplanProject.equals("Unfurnished project")) {
			clickBuyUnfurnishedFP().uploadFloorPlan(fpInput);
		}
		return PageFactory.initElements(driver, UploadedFloorplanDetails.class);
	}

	public UploadedFloorplanDetails buyFloorPlanServicesSticky(String fpInput) {
		String floorplanProject = UtilHBM.getProperty("testData", fpInput + "Offer");
		String expectedPrice = UtilHBM.getProperty("testData", fpInput + "Price");
		if (floorplanProject.equalsIgnoreCase("Furnished project")) {
			UtilHBM.waitExplicitDisplayed(driver, priceFurnishedFPSticky);
			Verification.elementContainsString(priceFurnishedFPSticky, expectedPrice, "Offer Price");
			clickBuyFurnishedFPSticky().uploadFloorPlan(fpInput);
		} else if (floorplanProject.equalsIgnoreCase("Unfurnished project")) {
			UtilHBM.waitExplicitDisplayed(driver, priceUnfurnishedFPSticky);
			Verification.elementContainsString(priceUnfurnishedFPSticky, expectedPrice, "Offer Price");
			clickBuyUnfurnishedFPSticky().uploadFloorPlan(fpInput);
		}
		return PageFactory.initElements(driver, UploadedFloorplanDetails.class);
	}

}
