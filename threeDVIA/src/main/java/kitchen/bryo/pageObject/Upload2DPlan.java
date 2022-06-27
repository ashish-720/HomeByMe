package kitchen.bryo.pageObject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.UploadTwoDPlan;

public class Upload2DPlan {
	WebDriver driver;

	public Upload2DPlan(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-layer-import-2d-plan mod-open']")
	private WebElement import2DPlanLayer;

	@FindBy(css = "[data-i18n='floor_plan.on_bording.start']")
	private WebElement getStarted;

	@FindBy(xpath = "//section[@class='mod-sublayer-media mod-open']/header/h4[text()='Transform your floorplan into a 3D project']")
	private WebElement floorPlanTitle;

	@FindBy(xpath = "//section[@class='mod-sublayer-media mod-open']/div/p[text()='Import your floorplan to start your project with precise measurements.']")
	private WebElement floorPlanDesc;

	@FindBy(xpath = "//section[@class='mod-sublayer-media mod-open']/div/img[@src='./assets/images/import-2d-plan/import-2d-plan-onboarding.png']")
	private WebElement floorplanImage;

	@FindBy(css = ".content>.drop-area>.cta-primary-xl.input-file>input")
	private WebElement selectFile;

	@FindBy(xpath = "//div/h3[text()='Import your floorplan file']")
	private WebElement floorPlanMainTitle;

	@FindBy(xpath = "//div/b[text()='You can drop or select the file to import.']")
	private WebElement floorPlanMainInfo;

	@FindBy(xpath = "//div/p[text()='Drop your file anywhere']")
	private WebElement floorPlanDragDrop;

	@FindBy(xpath = "//span[@data-i18n='floor_plan.upload_plan.supported_files'][text()='Supported files: PDF, JPG and PNG']")
	private WebElement floorPlanSupportedFile;

	@FindBy(xpath = "//span[@data-i18n='floor_plan.upload_plan.file_info'][text()='Maximum upload file size: 1 MB']")
	private WebElement floorPlanFileInfo;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//div[@class='media-tools']/ul/li/button/span[@class='icon-action-download']")
	private WebElement downloadTool;
	
	@FindBy(xpath = "//div[@class='media-tools']/ul/li/button/span[@class='icon-action-rotate-clockwise']")
	private WebElement rotationTool;

	@FindBy(xpath = "//div[@class='media-tools']/ul/li/button/span[@class='icon-tools-opacity']")
	private WebElement opacityTool;
	
	@FindBy(xpath = "//div[@class='media-tools']/ul/li/button/span[@class='icon-action-move']")
	private WebElement moveTool;
	
	@FindBy(xpath = "//span[text()='Rotation']")
	private WebElement rotationText;

	@FindBy(css = ".mod-tool-rotate-plan>.track>.path-circle")
	private WebElement circle;

	@FindBy(css = ".value-display>[data-ui-selector='value-display']")
	private WebElement angle1;

	@FindBy(xpath = "//span[text()='Opacity']")
	private WebElement opacityText;

	@FindBy(css = ".mod-tool-opacity-plan>form>input")
	private WebElement line;

	@FindBy(css = ".mod-tool-opacity-plan>form>.label>span")
	private WebElement lineValue;

	@FindBy(xpath = "//span[text()='Move']")
	private WebElement moveText;

	@FindBy(xpath = "//span[text()='Your plan']")
	private WebElement yourPlanText;
	
	@FindBy(css = ".content>.mod-tool-2d-plan>.footer-actions>.cta-secondary")
	private WebElement deleteYourPlan;
	
	@FindBy(css = ".overlay-actions[aria-hidden='false']>span>.cta-primary")
	private WebElement deleteYes;
	
	@FindBy(css = ".overlay-actions[aria-hidden='false']>span>.cta-secondary")
	private WebElement deleteNo;
	
	@FindBy(css = ".content>.mod-tool-2d-plan>.footer-actions>.cta-primary")
	private WebElement changeYourPlan;
	
	@FindBy(css = "ul.tool-list>li>button[data-ui-action=undo]>.icon-action-undo")
	private WebElement undoButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=redo]>.icon-action-redo")
	private WebElement redoButton;
	
	@FindBy(xpath = "//button/span[@class='icon-action-zoom']")
	private WebElement zoomIn;
	
	@FindBy(xpath = "//button/span[@class='icon-action-unzoom']")
	private WebElement zoomOut;
	
	@FindBy(css = "[data-i18n='floor_plan.select_pdf.title']")
	private WebElement pdfTitle;
	
	@FindBy(css = "[data-ui-action='validate-selection']")
	private WebElement chooseThisPage;
	
	public Upload2DPlan getStarted() {

		UtilHBM.waitExplicitDisplayed(driver, import2DPlanLayer);
		UtilHBM.waitExplicitClickable(driver, getStarted);
		System.out.println("Get started");
		Verification.displayNAttributeCheckOfElement(floorPlanTitle, "title text", "text",
				"Transform your floorplan into a 3D project");
		Verification.displayNAttributeCheckOfElement(floorPlanDesc, "desc text", "text",
				"Import your floorplan to start your project with precise measurements.");
		Verification.displayNAttributeCheckOfElement(floorplanImage, "image", "src",
				"https://preprod-kitchen.enterprise-dev.by.me/Kitchen/assets/images/import-2d-plan/import-2d-plan-onboarding.png");
		Verification.displayNAttributeCheckOfElement(getStarted, "get started", "text", "Get started");
		new Actions(driver).moveToElement(getStarted).build().perform();
		getStarted.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}

	public Upload2DPlan selectFile(String fileName) {
		UtilHBM.waitExplicitDisplayed(driver, selectFile);
		UtilHBM.waitExplicitClickable(driver, selectFile);
		Verification.displayNAttributeCheckOfElement(selectFile, " Select file ", "text", "Select file");
		Verification.displayNAttributeCheckOfElement(floorPlanMainTitle, " floorPlan main title text ", "text",
				"Import your floorplan file");
		Verification.displayNAttributeCheckOfElement(floorPlanMainInfo, " floorPlan main text ", "text",
				"You can drop or select the file to import.");
		Verification.displayNAttributeCheckOfElement(floorPlanDragDrop, " Drag & drop text ", "text",
				"Drop your file anywhere");
		Verification.displayNAttributeCheckOfElement(floorPlanSupportedFile, " floorplan supported file text ", "text",
				"Supported files: PDF, JPG and PNG");
		Verification.displayNAttributeCheckOfElement(floorPlanFileInfo, " floorplan file info text ", "text",
				"Maximum upload file size: 1 MB");
		WebElement dropArea = driver
				.findElement(By.xpath("//section[@class='mod-sublayer-drag-and-drop mod-open']/div/div/span"));
		Verification.VerifyEquals("Drab & drop icon not distinguishable...", dropArea
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-drag");
		selectFile.sendKeys(new File(Setting.imgPath + fileName).getAbsolutePath());
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
public Upload2DPlan chooseThisPage() {
		
		UtilHBM.waitExplicitClickable(driver, chooseThisPage);
		Verification.displayNAttributeCheckOfElement(pdfTitle, "PDF Title text", "text", "Choose the page you want to import");
		Verification.displayNAttributeCheckOfElement(chooseThisPage, "Choose this page", "text", "choose this page");
		chooseThisPage.click();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan selectFloorPlan(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}

public Upload2DPlan yourPlan() {
		
		
	Verification.VerifyEquals("Your Plan(download) icon not distinguishable...", downloadTool
			.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
			"./assets/icons/icons.svg#icon-action-download");
		Verification.displayNAttributeCheckOfElement(yourPlanText, "Your plan text", "text", "Your plan");
		yourPlanText.click();
		
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan deleteYourPlan() {
		UtilHBM.waitExplicitDisplayed(driver, deleteYourPlan);
		UtilHBM.waitExplicitClickable(driver, deleteYourPlan);
		deleteYourPlan.click();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan changeYourPlan() {
		changeYourPlan.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFile);
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan deleteYes() {
		UtilHBM.waitExplicitDisplayed(driver, deleteYes);
		Verification.VerifyEquals("Delete yes text not correct", deleteYes.getText(), "Yes");
		deleteYes.click();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan deleteNo() {
		UtilHBM.waitExplicitDisplayed(driver, deleteNo);
		Verification.VerifyEquals("Delete no text not correct", deleteNo.getText(), "No");
		Verification.displayOfWebElement(deleteNo);
		deleteNo.click();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
	
	public Upload2DPlan rotation(int xOffset, int yOffset, String angle) {

		Verification.VerifyEquals("Rotation icon not distinguishable...", rotationTool
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-rotate-clockwise");
		Verification.displayNAttributeCheckOfElement(rotationText, "rotation text", "text", "Rotation");
		rotationText.click();
		new Actions(driver).moveToElement(circle, xOffset, yOffset).click().build().perform();
		Verification.displayNAttributeCheckOfElement(angle1, "Angle", "text", angle);
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}

	public Upload2DPlan opacity(int xOffset, int yOffset, String value) {
		UtilHBM.waitFixTime(500);
		Verification.VerifyEquals("Opacity icon not distinguishable...", opacityTool
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-tools-opacity");
		Verification.displayNAttributeCheckOfElement(opacityText, "opacity text", "text", "Opacity");
		opacityText.click();
		new Actions(driver).moveToElement(line, xOffset, yOffset).click().build().perform();
		Verification.displayNAttributeCheckOfElement(lineValue, "Angle", "text", value);

		return PageFactory.initElements(driver, Upload2DPlan.class);
	}

	public Upload2DPlan move() {
		UtilHBM.waitFixTime(500);
		Verification.VerifyEquals("Move icon not distinguishable...", moveTool
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-move");
		Verification.displayNAttributeCheckOfElement(moveText, "move text", "text", "Move");
		moveText.click();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}
public Upload2DPlan movePlan(int x, int y, int x1, int y1) {
		
		selectFloorPlan(x, y);
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
				.pause(1000).release().build().perform();
		
		return this;
	}
public Upload2DPlan zoomIn(int zoomIncount) {
	UtilHBM.waitFixTime(1000);
	for (int i = 1; i <= zoomIncount; i++) {
		zoomIn.click();
		UtilHBM.waitFixTime(500);

	}
	return this;
}

public Upload2DPlan zoomOut(int zoomOutcount) {
	for (int i = 1; i <= zoomOutcount; i++) {
		zoomOut.click();
		UtilHBM.waitFixTime(500);

	}
	return this;
}
public Upload2DPlan undo(WebDriver driver, int number) {
	for (int i = 0; i < number; i++) {
		undoButton.click();
	}
	return PageFactory.initElements(driver, Upload2DPlan.class);
}

public Upload2DPlan redo(WebDriver driver, int number) {
	for (int i = 0; i < number; i++) {
		redoButton.click();

	}
	return PageFactory.initElements(driver, Upload2DPlan.class);
}
}
