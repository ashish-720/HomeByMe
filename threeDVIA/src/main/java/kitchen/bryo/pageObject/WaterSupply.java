package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaterSupply {
	WebDriver driver;

	public WaterSupply(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[@data-i18n='kitchen.design_own_water_supply.title;planner.design_own_water_supply.title']")
	private WebElement waterSupplyTitle;

	@FindBy(xpath = "//b[@data-i18n='kitchen.design_own_water_supply.info;planner.design_own_water_supply.info']")
	private WebElement waterSupplyInfo;

	@FindBy(css = ".header-actions .cta-secondary-xl")
	private WebElement cancelWaterSupply;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement okWaterSupply;

	@FindBy(xpath = "//button[@id='zoom-in']")
	private WebElement zoomInWaterSupply;

	@FindBy(xpath = "//button[@id='zoom-out']")
	private WebElement zoomOutWaterSupply;

	@FindBy(css = "#bmSVG>g>polyline")
	private List<WebElement> waterSupply;

	@FindBy(css = "g>polyline")
	private List<WebElement> activeWaterSupplySize;

	@FindBy(css = "g>polyline")
	private WebElement activeWaterSupply;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(id = "bmSVG")
	private WebElement container3D;
	
	public FloorPlan selectWaterSupply(int x,int y) {
		UtilHBM.waitExplicitDisplayed(driver, waterSupplyTitle);
		String expectedTitle = "Position your water supply";
		String expectedInfo = "Select the wall where your water supply is located. We will use it to position the sink on kitchen layout suggestions.";
		Verification.VerifyEquals("Water supply  title not correct",
				waterSupplyTitle.getText().trim(), expectedTitle);
		Verification.VerifyEquals("Water supply  info not correct",
				waterSupplyInfo.getText().trim(), expectedInfo);
		Verification.displayOfWebElement(cancelWaterSupply);
		Verification.displayOfWebElement(okWaterSupply);
		Verification.displayOfWebElement(zoomInWaterSupply);
		Verification.displayOfWebElement(zoomOutWaterSupply);

		getBallon(x,y);
		clickBlank();
		UtilHBM.waitFixTime(1500);
		okWaterSupply.click();

		UtilHBM.reportOK("Water supply added successfully");
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyWaterSupply() {

		clickBlank();
//		if (activeWaterSupplySize.size() > 0) {
			if (activeWaterSupply.isEnabled()) {
				UtilHBM.reportOK("Water Supply is in selected mode");

//			}
		} else {
			UtilHBM.reportKO("Water Supply is not in selected mode");
		}
		validateButton.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public WaterSupply clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (waterSupply.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 84, -353).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public WaterSupply getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		// clickBlank();
		int i = 0;

		while (waterSupply.size() == 0 && i < 20) {
			// UtilHBM.hoverImgOffset("bryoBlankSpace.png", 0, 0);
			// UtilHBM.clickImg(img);
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;

			System.out.println("image clicked");
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}
	
	
//	<****************************MOBILE METHODS************************>
	public FloorPlan selectWaterSupplyMobile(int x,int y) {
		UtilHBM.waitExplicitDisplayed(driver, waterSupplyTitle);
		String expectedTitle = "Position your water supply";
		Verification.VerifyEquals("Water supply  title not correct",
				waterSupplyTitle.getText().trim(), expectedTitle);
			Verification.displayOfWebElement(cancelWaterSupply);
		Verification.displayOfWebElement(okWaterSupply);
			getBallon(x,y);
		clickBlankMobile();
		UtilHBM.waitFixTime(1500);
		okWaterSupply.click();

		UtilHBM.reportOK("Water supply added successfully");
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public WaterSupply clickBlankMobile() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (waterSupply.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 140, -230).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		
		return this;
	}
}