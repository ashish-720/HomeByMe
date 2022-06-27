package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class InteriorDesignServicePage {
	WebDriver driver;

	public InteriorDesignServicePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.cell-4.page--services__sticky>div>div>div>a[data-tag-label='buy_one_room_design_service']")
	WebElement buyIDSOneRoom;
	
	@FindBy(css = "div.cell-4.page--services__sticky>div>div>div>a[data-tag-label='buy_multi_room_design_service']")
	WebElement buyIDSMultiRoom;
	
	@FindBy(css = "div.cell-4.page--services__sticky>div>div:nth-child(1)>div>div.sticky-offers__price")
	WebElement priceIDSOneRoom;

	@FindBy(css = "div.cell-4.page--services__sticky>div>div:nth-child(2)>div>div.sticky-offers__price")
	WebElement priceIDSMultiRoom;
	
	public IDSFormDetails buyIDSOneRoom() {
		UtilHBM.waitExplicitClickable(driver, buyIDSOneRoom);
		UtilHBM.waitExplicitDisplayed(driver, buyIDSOneRoom);
		UtilHBM.waitExplicitDisplayed(driver, priceIDSOneRoom);
		Verification.elementContainsString(priceIDSOneRoom, "69.00", "IDS starting Price");
		UtilHBM.waitExplicitClickable(driver, buyIDSOneRoom);
		buyIDSOneRoom.click();
		return PageFactory.initElements(driver, IDSFormDetails.class);
	}

	public IDSFormDetails buyIDSMultiRoom() {
		UtilHBM.waitExplicitClickable(driver, buyIDSMultiRoom);
		UtilHBM.waitExplicitDisplayed(driver, buyIDSMultiRoom);
		UtilHBM.waitExplicitDisplayed(driver, priceIDSMultiRoom);
		Verification.elementContainsString(priceIDSMultiRoom, "139.00", "IDS starting Price");
		UtilHBM.waitExplicitClickable(driver, buyIDSMultiRoom);
		buyIDSMultiRoom.click();
		return PageFactory.initElements(driver, IDSFormDetails.class);
	}
	
	
	
}
