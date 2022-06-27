package hr.planner.pageObject;

import java.util.List;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

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

	@FindBy(css = "[data-i18n='[prepend]sloped_ceiling.modal.title']")
	private WebElement title;

	@FindBy(css = "[data-i18n='sloped_ceiling.modal.subtitle']")
	private WebElement subtitle;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(css = "button[data-ui-action='command-cancel']")
	private WebElement cancelButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=undo]>.icon-action-undo")
	private WebElement undoButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=redo]>.icon-action-redo")
	private WebElement redoButton;

	@FindBy(css = "[class='icon-view-2d']")
	private WebElement viewTwoD;

	@FindBy(css = "[class='icon-view-3d']")
	private WebElement viewThreeD;

	@FindBy(xpath = "//span[@class='icon-view-fp']")
	private WebElement firstPersonView;

	@FindBy(xpath = "//button/span[@class='icon-action-zoom']")
	private WebElement zoomIn;

	@FindBy(xpath = "//button/span[@class='icon-action-unzoom']")
	private WebElement zoomOut;

	@FindBy(css = ".mod-overlay>footer>.cta-primary")
	private WebElement create;

	@FindBy(css = ".mod-overlay>footer>.cta-secondary")
	private WebElement cancel;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(css = "[data-ui-action='changeSlopedCeiling']")
	private WebElement change;

	@FindBy(css = "[data-ui-action='removeSlopedCeiling']")
	private WebElement delete;

	@FindBy(css = "[data-i18n='sloped_ceiling.label']")
	private WebElement popUpTitle;

	@FindBy(css = "[id='hide_schema']")
	private WebElement hideSchema;

	@FindBy(css = ".illustration>img")
	private WebElement image;

	@FindBy(css = "[id='sloped-ceiling-a']")
	private WebElement inputA;

	@FindBy(css = "[id='sloped-ceiling-b']")
	private WebElement inputB;

	@FindBy(css = "[id='sloped-ceiling-c']")
	private WebElement inputC;

	@FindBy(css = "[data-i18n='sloped_ceiling.remove']")
	private WebElement remove;

	public SlopedCeiling clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling undo() {
		UtilHBM.waitExplicitClickable(driver, undoButton);
		undoButton.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling redo() {
		UtilHBM.waitExplicitClickable(driver, redoButton);
		redoButton.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling viewTwoD() {
		UtilHBM.waitExplicitClickable(driver, viewTwoD);
		viewTwoD.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling viewThreeD() {
		UtilHBM.waitExplicitClickable(driver, viewThreeD);
		viewThreeD.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling firstPersonView() {
		UtilHBM.waitExplicitClickable(driver, firstPersonView);
		firstPersonView.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling zoomIn(int noOfSteps) {
		UtilHBM.waitExplicitClickable(driver, zoomIn);
		for(int i=0; i<noOfSteps; i++){
			zoomIn.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling zoomOut(int noOfSteps) {
		UtilHBM.waitExplicitClickable(driver, zoomOut);
		for(int i=0; i<noOfSteps; i++){
			zoomOut.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling cancel() {
		UtilHBM.waitExplicitClickable(driver, cancel);
		cancel.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling create() {
		UtilHBM.waitExplicitClickable(driver, create);
		create.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public HomePlanner validate() {

		UtilHBM.waitExplicitClickable(driver, validateButton);
		Verification.verifyText(title, "Add sloped ceiling" + "\n" + "Choose a wall, click to edit and add your sloped ceiling. Then, validate to save your floorplan", "title");
		Verification
				.verifyText(
						subtitle,
						"Choose a wall, click to edit and add your sloped ceiling. Then, validate to save your floorplan",
						"subtitle");
		validateButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner cancelButton() {
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public SlopedCeiling changeSlopedCeiling() {
		UtilHBM.waitExplicitClickable(driver, change);
		change.click();
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling deleteSlopedCeiling() {
		UtilHBM.waitExplicitClickable(driver, delete);
		delete.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling remove() {
		UtilHBM.waitExplicitClickable(driver, remove);
		remove.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling slopeVerification() {

		// Verification.disabledWebElement(popUpTitle);
		Verification.verifyText(popUpTitle, "Sloped ceiling", "popUpTitle");
		Verification.displayNAttributeCheckOfElement(hideSchema, "hide schema",
				"data-hide", "Hide schema");
		Verification
				.displayNAttributeCheckOfElement(
						image,
						"image",
						"src",
						"https://preprod-home.enterprise-dev.by.me/Planner/assets/images/sloped-ceiling-schema.png");
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling input(String inputA, String inputB) {

		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public SlopedCeiling slopedCeilingInput(String input_A, String input_B) {

		UtilHBM.waitFixTime(500);
		if (!input_A.isEmpty()) {

			inputA.sendKeys(Keys.CONTROL + "a");
			inputA.sendKeys(input_A);
		}

		if (!input_B.isEmpty()) {

			inputB.sendKeys(Keys.CONTROL + "a");
			inputB.sendKeys(input_B);
		}

		return PageFactory.initElements(driver, SlopedCeiling.class);
	}
}
