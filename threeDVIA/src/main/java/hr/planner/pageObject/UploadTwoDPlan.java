package hr.planner.pageObject;

import java.io.File;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UploadTwoDPlan {
	
	WebDriver driver;
	public UploadTwoDPlan(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[data-i18n='floor_plan.on_bording.start']")
	private WebElement getStarted;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancel1;
	
	@FindBy(css = ".content>.drop-area>.cta-primary-xl.input-file>input")
	private WebElement uploadFromFile;
	
	@FindBy(xpath = "//button/span[text()='Cancel']")
	private WebElement cancel2;
	
	@FindBy(css = ".header-actions>.cta-primary-alt-l>[data-i18n='common.validate']")
	private WebElement validate;
	
	@FindBy(xpath = "//header/h4[text()='Transform your floorplan into a real 3D project']")
	private WebElement text01;
	
	@FindBy(xpath = "//div/p[text()='You can redraw your floorplan by adding wall directly on it and use the parameters to personnalize your display.']")
	private WebElement text02;
	
	@FindBy(xpath = "//div/img[@src='./assets/images/import-2d-plan/import-2d-plan-onboarding.png']")
	private WebElement image;
	
	@FindBy(xpath = "//div/h3[text()='Add a floorplan']")
	private WebElement text11;
	
	@FindBy(xpath = "//div/b[text()='Upload your floorplan and adjust the scale distance value between the two points.']")
	private WebElement text12;
	
	@FindBy(xpath = "//div/p[text()='Drag & Drop your 2D plan']")
	private WebElement text13;
	
	@FindBy(id="bmSVG")
	private WebElement container3D;
	
	@FindBy(css = ".bt-icon-label>.icon-action-download>svg>use")
	private WebElement yourPlanIcon;
	
	@FindBy(xpath = "//span[text()='Your plan']")
	private WebElement yourPlanText;
	
	@FindBy(css = ".content>.mod-tool-2d-plan>.footer-actions>.cta-secondary")
	private WebElement yourPlanDelete;
	
	@FindBy(css = ".overlay-actions[aria-hidden='false']>span>.cta-primary")
	private WebElement deleteYes;
	
	@FindBy(css = ".overlay-actions[aria-hidden='false']>span>.cta-secondary")
	private WebElement deleteNo;
	
	@FindBy(css = ".content>.mod-tool-2d-plan>.footer-actions>.cta-primary")
	private WebElement yourPlanChange;
	
	@FindBy(css = ".icon-action-rotate-clockwise>svg>use")
	private WebElement rotationIcon;
	
	@FindBy(xpath = "//span[text()='Rotation']")
	private WebElement rotationText;
	
	@FindBy(css = ".mod-tool-rotate-plan>.track>.path-circle")
	private WebElement circle;
	
	@FindBy(css = ".value-display>[data-ui-selector='value-display']")
	private WebElement angle1;
	
	@FindBy(css = ".bt-icon-label>.icon-tools-opacity>svg>use")
	private WebElement opacityIcon;
	
	@FindBy(xpath = "//span[text()='Opacity']")
	private WebElement opacityText;
	
	@FindBy(css = ".mod-tool-opacity-plan>form>input")
	private WebElement line;
	
	@FindBy(css = ".mod-tool-opacity-plan>form>.label>span")
	private WebElement lineValue;
	
	@FindBy(css = ".bt-icon-label>.icon-action-move>svg>use")
	private WebElement moveIcon;
	
	@FindBy(xpath = "//span[text()='Move']")
	private WebElement moveText;
	
	@FindBy(css = ".icon-tools-options>svg")
	private WebElement toolOption;
	
	@FindBy(css = ".bt-toggle>input")
	private WebElement gridMode;
	
	@FindBy(xpath = "//span[text()='Display Grid']")
	private WebElement gridModeText;
	
	@FindBy(css = "div>.form-select>[data-ui-action='opening']")
	private WebElement floorSelector;
	
	@FindBy(css = ".dropdown-action-inline >span>.form-select>select")
	private WebElement displayWall;
	
	@FindBy(xpath = "//span[text()='Display wall']")
	private WebElement displayWallText;
	
	@FindBy(css = "ul.tool-list>li>button[data-ui-action=undo]>.icon-action-undo")
	private WebElement undoButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=redo]>.icon-action-redo")
	private WebElement redoButton;
	
	@FindBy(xpath = "//button/span[@class='icon-action-zoom']")
	private WebElement zoomIn;
	
	@FindBy(xpath = "//button/span[@class='icon-action-unzoom']")
	private WebElement zoomOut;
	
	@FindBy(css = "[data-i18n='floor_plan.select_pdf.title']")
	private WebElement textTitlePDF;
	
	@FindBy(css = "[data-ui-action='validate-selection']")
	private WebElement chooseThisPage;
	
	public UploadTwoDPlan uploadFromFile(String fileName) {
		UtilHBM.waitExplicitClickable(driver, uploadFromFile);
		Verification.displayNAttributeCheckOfElement(uploadFromFile, " Upload file ", "text", "Upload from file");
		Verification.displayNAttributeCheckOfElement(text11, " Heading text ", "text", "Add a floorplan");
		Verification.displayNAttributeCheckOfElement(text12, " Sub heading text ", "text", "Upload your floorplan and adjust the scale distance value between the two points.");
		Verification.displayNAttributeCheckOfElement(text13, " Drag $ drop text ", "text", "Drag & Drop your 2D plan");
		uploadFromFile.sendKeys(new File(Setting.imgPath+fileName).getAbsolutePath());
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan uploadFromFilePDF(String fileName) {
		UtilHBM.waitExplicitClickable(driver, uploadFromFile);
		Verification.displayNAttributeCheckOfElement(uploadFromFile, " Upload file ", "text", "Upload from file");
		Verification.displayNAttributeCheckOfElement(text11, " Heading text ", "text", "Add a floorplan");
		Verification.displayNAttributeCheckOfElement(text12, " Sub heading text ", "text", "Upload your floorplan and adjust the scale distance value between the two points.");
		Verification.displayNAttributeCheckOfElement(text13, " Drag $ drop text ", "text", "Drag & Drop your 2D plan");
		uploadFromFile.sendKeys(new File(Setting.imgPath+fileName).getAbsolutePath());
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
public UploadTwoDPlan chooseThisPage() {
		
		UtilHBM.waitExplicitClickable(driver, chooseThisPage);
		Verification.displayNAttributeCheckOfElement(textTitlePDF, "top text", "text", "Choose the page you want to import");
//		Verification.displayNAttributeCheckOfElement(text02, "bottom text", "text", "You can redraw your floorplan by adding wall directly on it and use the parameters to personnalize your display.");
//		Verification.displayNAttributeCheckOfElement(image, "image", "src", "https://preprod-home.enterprise-dev.by.me/Planner/assets/images/import-2d-plan/import-2d-plan-onboarding.png");
		Verification.displayNAttributeCheckOfElement(chooseThisPage, "Choose this page", "text", "choose this page");
		chooseThisPage.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan getStarted() {
		
		UtilHBM.waitExplicitClickable(driver, getStarted);
		Verification.displayNAttributeCheckOfElement(text01, "top text", "text", "Transform your floorplan into a real 3D project");
		Verification.displayNAttributeCheckOfElement(text02, "bottom text", "text", "You can redraw your floorplan by adding wall directly on it and use the parameters to personnalize your display.");
		Verification.displayNAttributeCheckOfElement(image, "image", "src", "https://preprod-home.enterprise-dev.by.me/Planner/assets/images/import-2d-plan/import-2d-plan-onboarding.png");
		Verification.displayNAttributeCheckOfElement(getStarted, "get started", "text", "Get started");
		getStarted.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public HomePlanner validate() {
		
		validate.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public UploadTwoDPlan clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan yourPlan() {
		
		
		Verification.displayNAttributeCheckOfElement(yourPlanIcon, "Your plan icon", "xlink:href", "./assets/icons/icons.svg#icon-action-download");
		Verification.displayNAttributeCheckOfElement(yourPlanText, "Your plan text", "text", "Your plan");
		yourPlanText.click();
		
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan yourPlanDelete() {
		
		yourPlanDelete.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan yourPlanChange() {
		
		yourPlanDelete.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan deleteYes() {
		
		deleteYes.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan deleteNo() {
		
		Verification.displayOfWebElement(deleteNo);
		deleteNo.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan rotation(int xOffset, int yOffset, String angle) {
		
		
		Verification.displayNAttributeCheckOfElement(rotationIcon, "rotation icon", "xlink:href", "./assets/icons/icons.svg#icon-action-rotate-clockwise");
		Verification.displayNAttributeCheckOfElement(rotationText, "rotation text", "text", "Rotation");
		rotationText.click();
		//WebElement circle=UtilHBM.webElement(driver, ".mod-tool-rotate-plan>.track>.path-circle");
		new Actions(driver).moveToElement(circle, xOffset, yOffset).click().build().perform();
		//WebElement angle1=UtilHBM.webElement(driver, ".value-display>[data-ui-selector='value-display']");;
		Verification.displayNAttributeCheckOfElement(angle1, "Angle", "text", angle);
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan opacity(int xOffset, int yOffset, String value) {
		
		
		Verification.displayNAttributeCheckOfElement(opacityIcon, "opacity icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-opacity");
		Verification.displayNAttributeCheckOfElement(opacityText, "opacity text", "text", "Opacity");
		opacityText.click();
		//UtilHBM.webElement(driver, ".mod-tool-opacity-plan>form>span").click();
		//new Actions(driver).moveToElement(circle, xOffset, yOffset).click().build().perform();
		new Actions(driver).moveToElement(line, xOffset, yOffset).click().build().perform();
		Verification.displayNAttributeCheckOfElement(lineValue, "Angle", "text", value);
		
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan move() {
		
		
		Verification.displayNAttributeCheckOfElement(moveIcon, "move icon", "xlink:href", "./assets/icons/icons.svg#icon-action-move");
		Verification.displayNAttributeCheckOfElement(moveText, "move text", "text", "Move");
		moveText.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	
	
	public UploadTwoDPlan toolOption() {
		UtilHBM.waitExplicitClickable(driver, toolOption);
		toolOption.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan gridDisplay() {
		
		//UtilHBM.waitExplicitClickable(driver, gridMode);
		//UtilHBM.waitExplicitDisplayed(driver, gridModeText );
		gridMode.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan floorSelector(String value) {
		//UtilHBM.waitExplicitClickable(driver, floorSelector);
		//can select any floor ie. GF or FF
		floorSelector.click();
		UtilHBM.webElement(driver, "[id='canvas-level-selector']>span>select>[value='"+value+"']").click();
		
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan planSelector(String value) {
		// select No wall, current floor, upper floor or lower floor
		Verification.disabledWebElement(displayWallText);
		displayWall.click();
		WebElement displayWall = driver.findElement(By.cssSelector(".dropdown-action-inline>span>.form-select>select"));
		new Select(displayWall).selectByVisibleText(value);
		String selectedOption = new Select(displayWall).getFirstSelectedOption().getText();
		if(!selectedOption.equalsIgnoreCase(value)){
			UtilHBM.reportKO("Wall display option is not selected. Expected value: "+ value+", selected option"+selectedOption);
		}
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan movePlan(int x, int y, int x1, int y1) {
		
		clickInPlanner(x, y);
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
				.pause(1000).release().build().perform();
		
		return this;
	}
	
	public UploadTwoDPlan undo() {
		UtilHBM.waitExplicitClickable(driver, undoButton);
		Verification.displayOfWebElement(undoButton);
		undoButton.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}

	public UploadTwoDPlan redo() {
		UtilHBM.waitExplicitClickable(driver, redoButton);
		Verification.displayOfWebElement(redoButton);
		redoButton.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan zoomIn(int noOfSteps) {
		UtilHBM.waitExplicitClickable(driver, zoomIn);
		for(int i=0; i<noOfSteps; i++){
			zoomIn.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
	public UploadTwoDPlan zoomOut(int noOfSteps) {
		UtilHBM.waitExplicitClickable(driver, zoomOut);
		for(int i=0; i<noOfSteps; i++){
			zoomOut.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}
	
}
