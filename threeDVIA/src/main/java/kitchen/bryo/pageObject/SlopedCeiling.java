package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlopedCeiling {
	WebDriver driver;

	public SlopedCeiling(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#sketcher-mod-sloped-ceiling>div>header>div>div>.title")
	private WebElement slopedCeilingTitle;

	@FindBy(css = "#sketcher-mod-sloped-ceiling>div>header>div>div>h3>.info")
	private WebElement slopedCeilingInfo;

	@FindBy(css = ".header-actions .cta-secondary-xl")
	private WebElement cancelSlopedCeiling;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateSlopedCeiling;

	@FindBy(css = "#zoom-in")
	private WebElement zoomInSlopedCeiling;

	@FindBy(css = "#zoom-out")
	private WebElement zoomOutSlopedCeiling;

	@FindBy(xpath = "//div[starts-with(@class,'mod-overlay-container')]")
	private List<WebElement> sloped_ceilingOverlay;

	@FindBy(xpath = "//div[@class='mod-overlay-container-sloped-ceiling mod-open']")
	private WebElement slopedCeilingContainer;

	@FindBy(css = "button[data-ui-action='changeSlopedCeiling']")
	private WebElement changeSlopedCeilingButton;

	@FindBy(css = "button[data-i18n='common.create']")
	private WebElement createButton;

	@FindBy(css = "#bt-icon-view-2d[data-ui='view-2d']")
	private WebElement twoDButton;

	@FindBy(css = "button[data-ui='view-3d']")
	private WebElement threeDButton;

	@FindBy(css = "#sloped-ceiling-a")
	private WebElement slopedCeilingA;

	@FindBy(css = "#sloped-ceiling-b")
	private WebElement slopedCeilingB;

	@FindBy(css = "#sloped-ceiling-c")
	private WebElement slopedCeilingC;

	@FindBy(css = "#bmSVG>g>rect[fill='none']")
	private List<WebElement> slopedCeiling;

	@FindBy(css = ".mod-overlay-container.mod-open")
	private List<WebElement> optionsOverlay;

	@FindBy(xpath = "//button[@data-ui-action='overlay-close']")
	private WebElement closeSlopedCeilingOverlay;

	@FindBy(css = "button[data-ui-action='removeSlopedCeiling']")
	private WebElement deleteSlopedCeiling;

	@FindBy(css = "span[data-i18n='common.remove']")
	private WebElement removeSlopedCeiling;

	@FindBy(xpath = "//h3[@data-i18n='sloped_ceiling.editor_title']")
	private WebElement overlayTitle;

	@FindBy(id = "hide_schema")
	private WebElement hideSchema;

	@FindBy(xpath = "//figure[@class='illustration']/img")
	private WebElement slopedCeilingImg;

	@FindBy(css = ".sloped-measures")
	private WebElement slopedMeasures;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	public FloorPlan addSlopedCeilingFrom3DView(int x, int y, String ceilingA, String ceilingB, String ceilingC) {
		slopedCeilingInfoVerification();
		UtilHBM.waitFixTime(500);
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, slopedCeilingContainer);
//		if (!slopedCeilingContainer.isDisplayed()) {
//			UtilHBM.reportKO("Wall not selected or Wall selected but properties not available");
//		} else {
//			UtilHBM.reportOK("Wall selected and sloped ceiling properties displayed");
		addSlopedCeiling(ceilingA, ceilingB, ceilingC);
		UtilHBM.waitExplicitClickable(driver, createButton);
		Actions action = new Actions(driver);
		action.moveToElement(createButton).click().build().perform();

//		}
//		UtilHBM.waitFixTime(1500);
//		validateSlopedCeiling.click();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public SlopedCeiling slopedCeilingInfoVerification() {
		String expectedTitle = "Add sloped ceiling";
		String expectedInfo = "Choose a wall, click to edit and add your sloped ceiling. Then, validate to save your floorplan";
		Verification.VerifyEquals("Sloped Ceiling  title not correct", slopedCeilingTitle.getText().split("\\r?\\n")[0],
				expectedTitle);
		Verification.VerifyEquals("Sloped Ceiling  info not correct", slopedCeilingInfo.getText(), expectedInfo);
		Verification.displayOfWebElement(zoomInSlopedCeiling);
		Verification.displayOfWebElement(zoomOutSlopedCeiling);
		Verification.displayOfWebElement(threeDButton);
		Verification.displayOfWebElement(twoDButton);
		Verification.displayOfWebElement(cancelSlopedCeiling);
		Verification.displayOfWebElement(validateSlopedCeiling);

		return this;
	}

	public SlopedCeiling changeSlopedCeiling3D(int x, int y, String ceilingA, String ceilingB, String ceilingC) {

		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, sloped_ceilingOverlay.get(0));
			changeSlopedCeilingButton.click();
			addSlopedCeilingFrom3DView(x, y, ceilingA, ceilingB, ceilingC);

		return this;
	}

	public SlopedCeiling verifySlopedCeiling3D(int x, int y, String ceilingA, String ceilingB, String ceilingC) {

		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		getBallon(x, y);

		UtilHBM.waitExplicitDisplayed(driver, changeSlopedCeilingButton);
		UtilHBM.waitExplicitClickable(driver, changeSlopedCeilingButton);
		changeSlopedCeilingButton.click();
		verifySlopedCeiling(ceilingA, ceilingB, ceilingC);
		closeSlopedCeilingOverlay.click();

		return this;
	}

	public FloorPlan addSlopedCeilingFrom2DView(int x, int y, String ceilingA, String ceilingB, String ceilingC) {
		slopedCeilingInfoVerification();
		twoDButton.click();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, sloped_ceilingOverlay.get(0));

		addSlopedCeiling(ceilingA, ceilingB, ceilingC);

		UtilHBM.waitFixTime(1500);
		validateSlopedCeiling.click();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public SlopedCeiling verifySlopedCeilingIn2D(int x, int y, String ceilingA, String ceilingB, String ceilingC) {
		twoDButton.click();
		clickBlank();
		UtilHBM.waitExplicitClickable(driver, slopedCeiling.get(0));
		Verification.enabledWebElement(driver, slopedCeiling.get(0));
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, changeSlopedCeilingButton);
		UtilHBM.waitExplicitClickable(driver, changeSlopedCeilingButton);
		changeSlopedCeilingButton.click();
		verifySlopedCeiling(ceilingA, ceilingB, ceilingC);
		hideSchema.click();
		return this;
	}

	public SlopedCeiling verifySlopedCeiling3DTo2D() {
		twoDButton.click();

		if (slopedCeiling.size() > 0) {
			if (slopedCeiling.get(0).isEnabled())
				UtilHBM.reportOK("Sloped Ceiling active");
		} else {
			UtilHBM.reportKO("Sloped Ceiling not active");
		}
		return this;
	}

	public SlopedCeiling verifySlopedCeiling(String ceilingA, String ceilingB, String ceilingC) {
		slopedCeilingInfoVerification();
		if (ceilingA.isEmpty()) {
			UtilHBM.reportInfo("Sloped ceiling A property not available for verification");
		} else if (!(ceilingA.isEmpty())) {
			if (ceilingA.equalsIgnoreCase(slopedCeilingA.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sloped ceiling A property changed and value is " + slopedCeilingA.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sloped ceiling A");
		}
		if (ceilingB.isEmpty()) {
			UtilHBM.reportInfo("Sloped ceiling B property not available for verification");
		} else if (!(ceilingB.isEmpty())) {
			if (ceilingB.equalsIgnoreCase(slopedCeilingB.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sloped ceiling B property changed and value is " + slopedCeilingB.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sloped ceiling B");
		}
		if (ceilingC.isEmpty()) {
			UtilHBM.reportInfo("Sloped ceiling C property not available for verification");
		} else if (!(ceilingC.isEmpty())) {
			if (ceilingC.equalsIgnoreCase(slopedCeilingC.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sloped ceiling C property changed and value is " + slopedCeilingC.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sloped ceiling C");
		}
		return this;
	}

	public SlopedCeiling deleteSlopedCeiling(int x, int y) {
		clickBlank();
		getBallon(x, y);
		deleteSlopedCeiling.click();
		return this;
	}

	public SlopedCeiling verifyDeleteSlopedCeiling3D(int x, int y) {
		clickBlank();
		getBallon(x, y);
		if (sloped_ceilingOverlay.get(0).isDisplayed()) {
			UtilHBM.reportOK("Sloped Ceiling deleted successfully in 3D view");
		} else {
			UtilHBM.reportKO("Sloped Ceiling not deleted in 3D view");
		}
		validateSlopedCeiling.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public SlopedCeiling verifyDeleteSlopedCeiling2D() {
		twoDButton.click();
		if (slopedCeiling.size() > 0) {
			if (slopedCeiling.get(0).isEnabled())
				UtilHBM.reportKO("Sloped Ceiling  active and not deleted");
		} else {
			UtilHBM.reportOK("Sloped Ceiling deleted successfully from 2D view");
		}
		validateSlopedCeiling.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public SlopedCeiling addSlopedCeiling(String ceilingA, String ceilingB, String ceilingC) {
		UtilHBM.waitExplicitDisplayed(driver, overlayTitle);
		String expectedTitle = "Sloped ceiling";
		System.out.println(overlayTitle.getText().trim().replaceAll("\n\r", ""));
		Verification.VerifyEquals("Sloped Ceiling overlay title not correct",
				overlayTitle.getText().trim().replaceAll("\n\r", ""), expectedTitle);
		if (slopedCeilingImg.getAttribute("src").contains(".png"))
			UtilHBM.reportOK("Sloped Ceiling image displayed");
		else
			UtilHBM.reportKO("Sloped Ceiling image not displayed");
		Verification.displayOfWebElement(slopedMeasures);
//			new Actions(driver).moveToElement(hideSchema).click().build().perform();
		UtilHBM.waitExplicitClickable(driver, hideSchema);
		hideSchema.click();
		UtilHBM.waitFixTime(1000);
		if (!slopedCeilingImg.isDisplayed() && hideSchema.getText().equalsIgnoreCase("Show schema")) {
			UtilHBM.reportOK("Sloped Ceiling image hidden on clicking hide schema");
		} else {
			UtilHBM.reportKO("Sloped Ceiling image not hidden on clicking hide schema");
		}
		if (!(ceilingA.isEmpty())) {
			System.out.println("Width:" + slopedCeilingA.getAttribute("value"));
			UtilHBM.waitExplicitClickable(driver, slopedCeilingA);
			slopedCeilingA.click();
			slopedCeilingA.clear();
			slopedCeilingA.sendKeys(ceilingA);
		}
		if (!(ceilingB.isEmpty())) {
			System.out.println("Width:" + slopedCeilingB.getAttribute("value"));
			UtilHBM.waitExplicitClickable(driver, slopedCeilingB);
			slopedCeilingB.click();
			slopedCeilingB.clear();
			slopedCeilingB.sendKeys(ceilingB + Keys.ENTER);
		}
		if (!(ceilingC.isEmpty())) {
			System.out.println("Width:" + slopedCeilingC.getAttribute("value"));
			driver.findElement(By.cssSelector("label[for='sloped-ceiling-radio-c']")).click();
			UtilHBM.waitExplicitClickable(driver, slopedCeilingC);
			slopedCeilingC.click();
			slopedCeilingC.clear();
			slopedCeilingC.sendKeys(ceilingC);
		}
		return this;
	}

	public SlopedCeiling validateSlopedCeiling() {
		validateSlopedCeiling.click();
		return this;
	}

	public SlopedCeiling clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (sloped_ceilingOverlay.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 427, -210).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public SlopedCeiling getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		// clickBlank();
		int i = 0;
		System.out.println("Image");
		while (sloped_ceilingOverlay.size() == 0 && i < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;
			System.out.println("image clicked");
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}

	public SlopedCeiling twoDView() {
		twoDButton.click();
		return this;
	}

	public SlopedCeiling threeDView() {
		threeDButton.click();
		return this;
	}

	public SlopedCeiling clickValidateSlopedCeiling() {
		validateSlopedCeiling.click();
		return this;
	}

	public FloorPlan clickCancelSlopedCeiling() {
		cancelSlopedCeiling.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public SlopedCeiling setSlopedCeilingDimensionsAndVerifyErrorMsg(String ceilingA, String ceilingB, String ceilingC, String errorMsg) {
		if (!(ceilingA.isEmpty())) {
			System.out.println("Width:" + slopedCeilingA.getAttribute("value"));
			UtilHBM.waitExplicitClickable(driver, slopedCeilingA);
			slopedCeilingA.click();
			slopedCeilingA.sendKeys(Keys.chord(Keys.CONTROL,"A"),ceilingA, Keys.ENTER);
			String actualErrMsg=slopedCeilingA.findElement(By.xpath("./following-sibling::b[@class='error']")).getText();
			Verification.VerifyEquals("",actualErrMsg, errorMsg);
		}
		if (!(ceilingB.isEmpty())) {
			System.out.println("Width:" + slopedCeilingB.getAttribute("value"));
			UtilHBM.waitExplicitClickable(driver, slopedCeilingB);
			slopedCeilingB.click();
			slopedCeilingB.sendKeys(Keys.chord(Keys.CONTROL,"A"),ceilingB, Keys.ENTER);
			String actualErrMsg=slopedCeilingA.findElement(By.xpath("./following-sibling::b[@class='error']")).getText();
			Verification.VerifyEquals("",actualErrMsg, errorMsg);
		}
		if (!(ceilingC.isEmpty())) {
			System.out.println("Width:" + slopedCeilingC.getAttribute("value"));
			driver.findElement(By.cssSelector("label[for='sloped-ceiling-radio-c']")).click();
			UtilHBM.waitExplicitClickable(driver, slopedCeilingC);
			slopedCeilingC.click();
			slopedCeilingC.sendKeys(Keys.chord(Keys.CONTROL,"A"),ceilingC, Keys.ENTER);
			String actualErrMsg=slopedCeilingA.findElement(By.xpath("./following-sibling::b[@class='error']")).getText();
			Verification.VerifyEquals("",actualErrMsg, errorMsg);
		}
		return  this;
	}
}