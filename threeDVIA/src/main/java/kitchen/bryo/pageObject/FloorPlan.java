package kitchen.bryo.pageObject;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.DraftSightEmbed;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class FloorPlan {

	WebDriver driver;

	public FloorPlan(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "objects")
	private WebElement roomObjectButton;

	@FindBy(id = "openings")
	private WebElement openings;

	@FindBy(id = "covering")
	private WebElement coverings;

	@FindBy(css = "#bt-icon-view-2d[data-ui='view-2d']")
	private WebElement twoDButton;

	@FindBy(css = "button[data-ui='view-3d']")
	private WebElement threeDButton;

	@FindBy(id = "bt-icon-view-fp")
	private WebElement firstPersonView;

	@FindBy(id = "zoom-in")
	private WebElement zoonIn;

	@FindBy(id = "zoom-out")
	private WebElement zoonOut;

	@FindBy(css = "ul>li>button[data-ui-action='duplicate']")
	private WebElement duplicateButton;

	@FindBy(css = "ul>li>button[data-ui-action='edit']")
	private WebElement editButton;

	@FindBy(css = "ul>li>button[data-ui-action='delete']")
	private WebElement deleteButton;

	@FindBy(css = ".mod-properties-window-regular.mod-open>ul>li>ul>li>button[title='Openings']")
	private WebElement openingsBtnInProperties;

	@FindBy(id = "sketcher-edit-panel")
	private WebElement editPanel;

	@FindBy(css = "#sketcher-edit-panel>header>ul>li")
	private WebElement closeEditPanel;

	@FindBy(css = "#sketcher-mod-properties-window-regular>ul")
	private List<WebElement> balloon;

	@FindBy(id = "canvas")
	private List<WebElement> canvas;

	@FindBy(css = ".room .Tag3D")
	private List<WebElement> roomBaloon;

	@FindBy(id = "product-Circumference")
	private WebElement circumferenceInputBox;

	@FindBy(id = "product-width")
	private WebElement widthInputBox;

	@FindBy(id = "product-height")
	private WebElement heightInputBox;

	@FindBy(id = "product-depth")
	private WebElement depthInputBox;

	@FindBy(id = "product-height-from-floor")
	private WebElement htFromFloorInputBox;

	@FindBy(css = "fieldset[class='panel-form']>p>label>input[id='wall-side']+span")
	private WebElement wallSideInput;

	@FindBy(id = "thickness")
	private WebElement thicknessInputBox;

	@FindBy(id = "import-plan")
	private WebElement initiatePlan;

	@FindBy(css = "#RoomShape")
	private WebElement roomShapeButton;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(css = "#draw-plan")
	private WebElement drawPlan;

	@FindBy(css = "#add-wall")
	private WebElement addWallButton;

	@FindBy(css = "#sketcher-toolbox-catalogs>li>#WaterSupply")
	private WebElement waterSupplyButton;

	@FindBy(id = "ceiling-height")
	private WebElement ceilingHeight;

	@FindBy(id = "height")
	private WebElement wallHeight;

	@FindBy(id = "sloped-ceiling")
	WebElement slopedCeiling;

	@FindBy(xpath = "//ul[@class='mod-design-steps-tabs']/li/button[@data-step='3']")
	private WebElement MakeItYoursButton;

	@FindBy(css = ".Wall2DMeasure.Tag3D")
	private WebElement wall2DMeasure;

	@FindBy(css = "input.Tag3D[placeholder='Measure2D']")
	private List<WebElement> wallCornerMeasure;

	@FindBy(css = ".Tag3DMeasure2D>input")
	private WebElement wall2DMeasureInputBox;

	@FindBy(xpath = "//button[contains(text(),'apply above')]")
	private WebElement applyAbove;

	@FindBy(xpath = "//button[contains(text(),'apply below')]")
	private WebElement applyBelow;

	@FindBy(xpath = "//button[contains(text(),'apply left')]")
	private WebElement applyLeft;

	@FindBy(xpath = "//button[contains(text(),'apply right')]")
	private WebElement applyRight;

	@FindBy(xpath = "//div[@class='mod-nav-overlay']/div/ul/li/ul[@class='subsubcat']/li/button[@class='bt-text']")
	private List<WebElement> subCatagoryList;

	@FindBy(css = "#main-mod-view-3d>.mod-help-center>#show-help")
	private WebElement helpCenter;

	@FindBy(css = "button[id='go-to-auto-design']")
	private WebElement nextStep2;

	@FindBy(css = "button[id='customize-this-bathroom']")
	private WebElement nextStepBathroomBtn;

	@FindBy(xpath = "//article[@id='room-selector-layer']/div/header/div/div[@class='text']/h3")
	private WebElement roomSelectorTitle;

	@FindBy(xpath = "//article[@id='room-selector-layer']/div/header/div/div[@class='text']/b[@class='info']")
	private WebElement roomSelectorInfo;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement okButton;

	@FindBy(css = ".mod-popin-water-supply-small.mod-open>div>div>h1")
	private WebElement waterSupplyTitle;

	@FindBy(css = ".mod-popin-water-supply-small.mod-open>div>div>.text")
	private WebElement waterSupplyInfo;

	@FindBy(css = "article[class='mod-popin-water-supply-small mod-open'] button[data-ui-action='primary-button-action']")
	private WebElement yesBtnWaterSupplyMsg;

	@FindBy(css = "article[class='mod-popin-water-supply-small mod-open'] button[data-ui-action='secondary-button-action']")
	private WebElement noBtnWaterSupplyMsg;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open button[data-ui-action='primary-button-action']")
	private WebElement yesBtnSkipSolutionsMsg;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open button[data-ui-action='secondary-button-action']")
	private WebElement noBtnSkipSolutionsMsg;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open")
	private List<WebElement> skipLayout;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open>div>div>h1")
	private WebElement skipLayoutTitle;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open>div>div>div")
	private WebElement skipLayoutInfo;

	@FindBy(css = "ul>li>button>svg[class='icon-action-position']")
	private WebElement position;

	@FindBy(css = ".BayMeasure.Tag3D.visibility-visible.pointer-events-activated  ")
	private List<WebElement> bayMeasureList;

	@FindBy(css = ".BayMeasure.Tag3DMeasure2D.visibility-visible.direction-row>input")
	private WebElement bayMeasureInput;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p/span[@id='project-title']")
	private WebElement projectTitle;

	@FindBy(xpath = "//article[@class='mod-layer mod-open']")
	private List<WebElement> severalRoomArticle;

	@FindBy(css = "#sketcher-mod-properties-window-regular>div>h3")
	private WebElement roomName;

	@FindBy(css = "#sketcher-mod-properties-window-regular>div>p")
	private WebElement roomMeasurement;

	@FindBy(css = ".room.Tag3D>span")
	private WebElement roomSketcherMeasurement;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(css = "input[type='submit']")
	private WebElement loginButton;

	@FindBy(css = "button[data-ui-action='save']")
	private WebElement saveIcon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private List<WebElement> loginWindow;

	@FindBy(xpath = "//section[@class='form-container']/article/div/form[starts-with(@action,'/login')]")
	private List<WebElement> hbmLoginWindow;

	@FindBy(id = "close-app")
	private WebElement closePlanner;

	@FindBy(xpath = "//button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(css = ".manip-translate")
	WebElement translatePointer;

	@FindBy(css = ".manip-elevate.secondary")
	WebElement elevatePointer;

	@FindBy(css = "#design-action-area>ul>li>button[data-ui-action='print']")
	private WebElement printButton;

	@FindBy(css = ".RoomSeparatorMeasure.Tag3D")
	private WebElement roomSeparatorMeasures;

	@FindBy(xpath = "//article[@class='mod-popin-invalid-room-small mod-open']")
	private List<WebElement> invalidLayoutPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-invalid-room-small mod-open']/div/div/h1")
	private WebElement invalidRoomTitle;

	@FindBy(xpath = "//article[@class='mod-popin-invalid-room-small mod-open']/div/div/div/div/p")
	private WebElement invalidRoomInfo;

	@FindBy(xpath = "//footer/button[@class='cta-primary-alt-xl']")
	private WebElement okInvalidButton;

	@FindBy(css = "button[data-ui-action='product-info']")
	private WebElement info;

	@FindBy(xpath = "//button[@data-ui-action='product-replace']")
	private WebElement replaceButton;

	@FindBy(xpath = "//fieldset/p[@class='ceiling-height-row']/input[@id='ceiling-height-CB']")
	private WebElement ceilingHeightCheckbox;

	@FindBy(xpath = "//fieldset/p[@class='ceiling-height-row']/label[@for='ceiling-height-CB']")
	private WebElement ceilingHeightLabel;

	@FindBy(xpath = "//button[@data-ui-action='panel-close']")
	private WebElement closeWallPropertypPanel;

	@FindBy(xpath = "//button[@data-ui-action='add-sloped-ceiling']")
	private WebElement addSlopedCeilingButton;

	@FindBy(css = "div>p[data-notif-action='hbm_import']")
	private WebElement hbmImportRibbon;

	@FindBy(xpath = "//label[@data-ui-action='front-displayer']/span")
	private WebElement displayAllItems;

	@FindBy(css = "span[class='icon-tools-options']")
	private WebElement viewOptions;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']")
	private List<WebElement> recoverPopUp;

	@FindBy(css = "#bridge-container>div>section>footer>button.cta-primary-alt-l")
	private WebElement importFromHBMBtnSubLayer;

	@FindBy(xpath = "//button[@id='reset_view']")
	private WebElement resetView;

	@FindBy(css = "div[data-ui-selector='mod-mouse-tooltip'].mod-mouse-tooltip.position-bottom-center.mod-open")
	private WebElement mouseTooltip;

	@FindBy(xpath = "//button[@data-ui-action='item-notes']")
	private WebElement itemNotes;

	@FindBy(css = "button[data-ui-action='product-list']")
	private WebElement productListIcon;

	@FindBy(xpath = "//section[@class='mod-bottom-sheet mod-expanded']/div[@class='bottom-sheet-content']/button[@class='bt-handle']")
	private WebElement mBottomSheetClose;

	@FindBy(xpath = "//section[@class='mod-bottom-sheet']/div[@class='bottom-sheet-content']/button[@class='bt-handle']")
	private WebElement mBottomSheetOpen;
	
	@FindBy(css = "b[class='error']")
	private WebElement errorMsg;

	@FindBy(id = "importPlanFileUpload")
	private WebElement importPlanFileUpload;

	@FindBy(css = "div>p[class='success show']>span")
	private WebElement measuringImportRibbon;

	@FindBy(css = "article[class='mod-popin-no-space-small mod-open']")
	private WebElement noSpacePopIn;

	@FindBy(css = "article[class='mod-popin-no-space-small mod-open']>div>div>h1")
	private WebElement noSpaceTitle;

	@FindBy(xpath = "//article[@class='mod-popin-no-space-small mod-open']/div/div/div[@class='text']/div/p")
	private WebElement noSpaceInfo;

	@FindBy(css = "article[class='mod-popin-no-space-small mod-open']>div>footer>button[class='cta-primary-alt-xl']")
	private WebElement noSpaceOKButton;

	@FindBy(xpath = "//ul[@id='sketcher-toolbox-catalogs']/li[@data-element='4']/button[@id='ceilingHeight']")
	private WebElement ceilingHeightMobile;

	@FindBy(xpath = "//div[@class='mod-overlay-container-sloped-ceiling mod-open']")
	private WebElement slopedCeilingContainer;
	
	@FindBy(css = "ul.subsubcat>li[data-ui-subsubcat='import-laser-measurements']>button.bt-text")
	private WebElement importLaserMeasurements;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open section[data-ui-selector='sub-layer-onboarding']")
	private WebElement leicaLaserMeasurementSublayerOnboarding;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open section[data-ui-selector='upload-file']")
	private WebElement leicaLaserMeasurementSublayerFileUpload;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open section[data-ui-selector='upload-file'] input[data-ui-id='upload-input']")
	private WebElement leicaLaserMeasurementUploadFile;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open h3[data-i18n='import_laser_measurements.title']")
	private WebElement leicaLaserMeasurementTitle;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open b[data-i18n='import_laser_measurements.sub_title']")
	private WebElement leicaLaserMeasurementSubTitle;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open div.header-actions>button[data-ui-action='layer-close']")
	private WebElement leicaLaserMeasurementFileUploadSubLayerCancelBtn;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open section.mod-sublayer-media.mod-open footer>button[data-ui-action='layer-close']")
	private WebElement leicaLaserMeasurementOnboardingSublayerCancelBtn;

	@FindBy(css = "article.mod-layer-import-laser-measurements.mod-open section.mod-sublayer-media.mod-open footer>button[data-ui-action='sublayer-close']")
	private WebElement leicaLaserMeasurementOnboardingSublayerContinueBtn;

	@FindBy(css = "div.mod-notification>p.success")
	private WebElement notificationSuccessMsg;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded button[title='Openings']")
	private WebElement mobileOpeningsBtn;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded button[title='Edit']")
	private WebElement mobileEditBtn;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded button[title='Split']")
	private WebElement mobileSplitBtn;

	//Mobile
	@FindBy(css = "section[class='mod-bottom-sheet'] button[data-ui-action='toggle-bottom-sheet']")
	private WebElement mobileOpenBottomSheet;

	//Mobile
	@FindBy(css = "section[class='mod-bottom-sheet mod-expanded'] button[data-ui-action='toggle-bottom-sheet']")
	private WebElement mobileCloseBottomSheet;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded button[title='Delete']")
	private WebElement mobileDeleteBtn;

	//Mobile
	@FindBy(css = "article.mod-properties-window-regular.mod-open")
	private WebElement mobileOpeningHeader;

	@FindBy(css = "div#splash div.spinner")
	private WebElement spinnerOnLoadingScreen;

	@FindBy(css = "span.logo>img.hbm-logo-text")
	private WebElement hbmLogo;

	@FindBy(css = "span.logo>img.brand-logo")
	private WebElement brandLogo;

	@FindBy(css = "input.room.Tag3D.visibility-visible")
	private WebElement roomLabel;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded ul#sketcher-toolbox-tools button#import-plan")
	private WebElement initiatePlanBtnMobile;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet-with-backdrop.mod-expanded ul.subsubcat")
	private WebElement bottomSheetWithBackdrop;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded[data-ui-selector='bottom-sheet-actions'] ul.tools")
	private WebElement bottomSheetToolsForProducts;



	public MakeItYours editProperty() {
		UtilHBM.waitExplicitClickable(driver, editButton);
		Actions action = new Actions(driver);
		action.moveToElement(editButton).click().build().perform();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours selectProduct(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("article[class='mod-properties-window-regular mod-open']")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.cssSelector("article[class='mod-properties-window-regular mod-open']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public FloorPlan tooltipsForFloorplan() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForFloorPlanAfterLaunch().tooltipsForFloorplan();
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public FloorPlan tooltipsForOpenings() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForOpenings();
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public FloorPlan tooltipsForPosition(int x, int y) {
		selectProduct(x, y);
		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("button[title='Position']>svg[class='icon-action-position']")));
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//button[@title='Position']/span[contains(text(),'Position')]")));
		new Actions(driver).moveToElement(position).clickAndHold().pause(500).release().build().perform();
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForPosition();
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public MakeItYours switchFrameAfterReOpeningProject() {
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		UtilHBM.waitFixTime(1000);
		for (int i = 0; i > driver.findElements(By.xpath("//html[@class='js']")).size(); i++) {
			if (!driver.findElement(By.xpath("//html[@class='js']")).isDisplayed()) {
				UtilHBM.waitFixTime(6500);
			} else {
				break;
			}
		}
		UtilHBM.waitTillElementDisappear(driver, "figure>span[class='room']");
		UtilHBM.waitExplicitDisplayed(driver, projectTitle);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//button[@data-ui-action='product-list']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours ikeaSwitchFrameAfterReOpeningProject() {
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-kitchen-app>iframe")));
		UtilHBM.waitFixTime(1000);
		for (int i = 0; i > driver.findElements(By.xpath("//html[@class='js']")).size(); i++) {
			if (!driver.findElement(By.xpath("//html[@class='js']")).isDisplayed()) {
				UtilHBM.waitFixTime(6500);
			} else {
				break;
			}
		}
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-kitchen-app>iframe")));
		UtilHBM.waitFixTime(8500);
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		Verification.displayOfWebElement(roomLabel);
		Verification.displayOfWebElement(driver.findElement(By.cssSelector(".room.Tag3D>span")));
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public FloorPlan roomShape(String roomType, int roomID) {
		initiatePlan();
		String subcatagory = "Change the room shape";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		RoomShape shape = PageFactory.initElements(driver, RoomShape.class);
		shape.testRoomShape(roomType, roomID);
		overWriteRoomShape();
//		EditRoomShape edit = PageFactory.initElements(driver, EditRoomShape.class);
//		edit.overWriteRoomShape();
		return this;

	}

	public FloorPlan useMeasuringCode() {
		initiatePlan();
		String subcatagory = "Use a measuring code";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));

		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		UtilHBM.waitFixTime(1000);
		System.out.println("number of window handles: " + driver.getWindowHandles().size());
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			System.out.println("The error in closing file selection popup: " + e);
		}

		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan selectMeasuringFile(String measuringFile) {
		driver.switchTo().parentFrame();
		importPlanFileUpload.sendKeys(new File(Setting.imgPath + measuringFile).getAbsolutePath());
		List<WebElement> frames = driver.findElements(By.cssSelector("#embedded-kitchen-app>iframe"));
		driver.switchTo().frame(frames.get(0));
		verifyMeasuringImportMsg();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyMeasuringImportMsg() {
		UtilHBM.waitExplicitDisplayed(driver, measuringImportRibbon);
		Verification.displayNAttributeCheckOfElement(measuringImportRibbon, "Measuring import msg", "text",
				"Your measurements have been imported.");
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public Upload2DPlan uploadTwoDPlan() {
		initiatePlan();
		String subcatagory = "Upload a 2D floorplan";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		return PageFactory.initElements(driver, Upload2DPlan.class);
	}

	public FloorPlan overWriteRoomShape() {

		EditRoomShape edit = PageFactory.initElements(driver, EditRoomShape.class);
		edit.overWriteRoomShape();
		return this;

	}

	public FloorPlan rotateProjectView(int number, String upDownLeftRight) {
		clickBlank();
		UtilHBM.hitArrowKeyDev(driver, number, upDownLeftRight);
		return this;
	}

	public DraftSightEmbed useHomeByMeProject() {
		UtilHBM.waitExplicitDisplayed(driver, initiatePlan);
		UtilHBM.waitExplicitClickable(driver, initiatePlan);
		initiatePlan();
		String subcatagory = "Use a HomeByMe project";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.id("bridge-load-project")));
		UtilHBM.waitExplicitClickable(driver, importFromHBMBtnSubLayer);
		importFromHBMBtnSubLayer.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
		return PageFactory.initElements(driver, DraftSightEmbed.class);

	}

	public FloorPlan initiatePlan() {
		String catagory = "Initiate plan";
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/button[normalize-space(.)='" + catagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		catagoryEle.click();
		;
		return this;

	}

	//Mobile
	public FloorPlan initiatePlanMobile() {
		openBottomSheet();
		UtilHBM.waitExplicitDisplayed(driver, initiatePlanBtnMobile);
		initiatePlanBtnMobile.click();
		return this;

	}

	public FloorPlan roomType(int x, int y, String roomType) {
		selectProduct(x, y);
		Verification.displayOfWebElement(roomName);
		Verification.displayOfWebElement(roomMeasurement);
		String measure1 = roomSketcherMeasurement.getText();
		String measure2 = roomMeasurement.getText();
		if (measure1.equalsIgnoreCase(measure2)) {
			UtilHBM.reportOK("Room area displayed in skechter and room type is correct and measurment is :" + measure1);
		} else {
			UtilHBM.reportKO("Room area displayed in skechter and in properties are NOT same. Area in sketcher = "
					+ measure1 + " & area in properties = " + measure2);
		}
		editProperty();
		RoomType type = PageFactory.initElements(driver, RoomType.class);
		type.roomTypeProperties(roomType);
		closeEditPanel.click();
		return this;

	}

	public FloorPlan verifyRoomType(int x, int y, String roomName, String roomType) {
		clickBlank().getBallon(x, y).editProperty();
		RoomType type = PageFactory.initElements(driver, RoomType.class);
		type.verifyRoomTypeProperties(roomName, roomType);
		closeEditPanel.click();
		return this;

	}

	public FloorPlan verifyRoomNameAndDesc(int x, int y, String name, String measurement) {
		selectProduct(x, y);
		Verification.displayOfWebElement(roomName);
		Verification.displayOfWebElement(roomMeasurement);
		if (name.equalsIgnoreCase(roomName.getText()) && measurement.equalsIgnoreCase(roomMeasurement.getText())) {
			UtilHBM.reportOK("Room name and area displayed is correct and room name is :" + roomName.getText()
					+ " and room measurment is :" + roomMeasurement.getText());
		} else {
			UtilHBM.reportOK("Room name and area displayed is not correct and room name is :" + roomName.getText()
					+ " and room measurment is :" + roomMeasurement.getText());
		}

		return this;

	}

	public FloorPlan nextStep() {
		if (driver.getCurrentUrl().contains("bathroom")) {
			UtilHBM.waitExplicitDisplayed(driver, nextStepBathroomBtn);
			UtilHBM.waitExplicitClickable(driver, nextStepBathroomBtn);
			nextStepBathroomBtn.click();
		} else {
			UtilHBM.waitExplicitDisplayed(driver, nextStep2);
			UtilHBM.waitExplicitClickable(driver, nextStep2);
			nextStep2.click();

		}
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public PickALayout nextStepReturnsPickLayout() {
		UtilHBM.waitExplicitDisplayed(driver, nextStep2);
		UtilHBM.waitExplicitClickable(driver, nextStep2);
		nextStep2.click();
		return PageFactory.initElements(driver, PickALayout.class);
	}

	public FloorPlan invalidLayout() {
		String expectedTitle = "Your design is invalid";
		String expectedInfo = "You must have at least one room to design your kitchen. Create a closed shape and try again when the flooring appears.";
		UtilHBM.waitExplicitDisplayed(driver, invalidRoomTitle);
		Verification.VerifyEquals("Several Rooms title not correct", invalidRoomTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Several Rooms info not correct", invalidRoomInfo.getText(), expectedInfo);
		okInvalidButton.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan selectFromSeveralRoom(String floor, int x, int y) {
		UtilHBM.waitExplicitDisplayed(driver, "//article[@class='mod-layer mod-open']");
		String expectedTitle = "Select which room is your kitchen";
		String expectedInfo = "Among these rooms, pick the one that is your kitchen.";

		UtilHBM.waitExplicitDisplayed(driver, roomSelectorTitle);
		Verification.VerifyEquals("Several Rooms title not correct", roomSelectorTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Several Rooms info not correct", roomSelectorInfo.getText(), expectedInfo);
		HomeByMeProjects pro = PageFactory.initElements(driver, HomeByMeProjects.class);
		pro.selectFloorOptions(floor);
		UtilHBM.waitFixTime(2000);
		getBallon(x, y);
		okButton.click();
		UtilHBM.waitExplicitDisplayed(driver, nextStep2);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public MakeItYours skipLayoutYes() {
		UtilHBM.waitExplicitDisplayed(driver, yesBtnSkipSolutionsMsg);
		UtilHBM.waitExplicitClickable(driver, yesBtnSkipSolutionsMsg);
		Verification.displayNAttributeCheckOfElement(skipLayoutTitle, "Skip Layout Msg Title", "text",
				"Skip layout selection");
		if ((skipLayoutInfo.getText().isEmpty())) {
			UtilHBM.reportKO("Description for Skip layout selection is empty");
		} else {
			UtilHBM.reportOK("Description for Skip layout selection is displayed");
		}
		yesBtnSkipSolutionsMsg.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public FloorPlan skipLayoutNo() {
		UtilHBM.waitExplicitDisplayed(driver, noBtnSkipSolutionsMsg);
		UtilHBM.waitExplicitClickable(driver, noBtnSkipSolutionsMsg);
		Verification.displayNAttributeCheckOfElement(skipLayoutTitle, "Skip Layout Msg Title", "text",
				"Skip layout selection");
		if ((skipLayoutInfo.getText().isEmpty())) {
			UtilHBM.reportKO("Description for Skip layout selection is empty");
		} else {
			UtilHBM.reportOK("Description for Skip layout selection is displayed");
		}
		noBtnSkipSolutionsMsg.click();
		return this;
	}

	public PickALayout skipLayoutNoReturnPickALayout() {
		UtilHBM.waitExplicitDisplayed(driver, noBtnSkipSolutionsMsg);
		UtilHBM.waitExplicitClickable(driver, noBtnSkipSolutionsMsg);
		noBtnSkipSolutionsMsg.click();
		return PageFactory.initElements(driver, PickALayout.class);
	}

	public FloorPlan verifyImportedHBMProject(int x, int y) {
		UtilHBM.waitExplicitDisplayed(driver, hbmImportRibbon);
		if (hbmImportRibbon.getText().equalsIgnoreCase("A copy of your HomeByMe project has been imported.")) {
			UtilHBM.reportOK("HBM project import notification message displayed is correct and message is : "
					+ hbmImportRibbon.getText());
		} else {
			UtilHBM.reportKO("HBM project import notification message displayed is in-correct and message is : "
					+ hbmImportRibbon.getText());
		}
		UtilHBM.waitFixTime(10000);
		new Actions(driver).moveToElement(container3D, 25, 25).pause(500).moveByOffset(1, 1).build().perform();
		UtilHBM.waitFixTime(1000);
//		new Actions(driver).moveToElement(container3D, 25, 25).build().perform();
		if (driver.findElement(By.cssSelector("div[id='main-mod-view-3d']>div[style='cursor: not-allowed;']"))
				.isDisplayed()) {
			UtilHBM.reportOK("Cursor is disabled and product is not selectable in floorplan step");
		} else {
			UtilHBM.reportKO("Cursor not disabled and product is  selectable in floorplan step");
		}
		new Actions(driver).moveToElement(container3D, x, y).pause(500).moveByOffset(1, 1).build().perform();
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, mouseTooltip);
		if (mouseTooltip.getText().equalsIgnoreCase("You cannot move any items in this step")) {
			UtilHBM.reportOK("product is not selectable in floorplan step");
		} else {
			UtilHBM.reportKO("product is  selectable in floorplan step");
		}
		return this;
	}

	public PickALayout waterSupplyPositionPopUp(String YesNoWaterSupply, int x, int y) {
		UtilHBM.waitExplicitDisplayed(driver, yesBtnWaterSupplyMsg);
		UtilHBM.waitExplicitClickable(driver, yesBtnWaterSupplyMsg);
		if (!waterSupplyTitle.isDisplayed()) {
			UtilHBM.reportKO("Title for no water supply selected not displayed");
		} else {
			UtilHBM.reportOK("Title for no water supply selected displayed");
		}

		if ((waterSupplyInfo.getText().isEmpty())) {
			UtilHBM.reportKO("Description for no water supply is empty");
		} else {
			UtilHBM.reportOK("Description for no water supply is displayed");
		}
		if (YesNoWaterSupply.equalsIgnoreCase("Yes")) {
			UtilHBM.waitExplicitClickable(driver, yesBtnWaterSupplyMsg);
			yesBtnWaterSupplyMsg.click();
			WaterSupply water = PageFactory.initElements(driver, WaterSupply.class);
			water.selectWaterSupply(x, y);
		} else if (YesNoWaterSupply.equalsIgnoreCase("No")) {
			UtilHBM.waitExplicitClickable(driver, noBtnWaterSupplyMsg);
			noBtnWaterSupplyMsg.click();
		} else {
			System.out.println("Water supply pop-up not available");
		}
		return PageFactory.initElements(driver, PickALayout.class);
	}

	public FloorPlan addWall(String wallParameterName) {
		drawPlan();
		String subcatagory = "Add a wall";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		AddWall wall = PageFactory.initElements(driver, AddWall.class);
		wall.addWallInfo().createWall(wallParameterName);
		return this;
	}

	public FloorPlan addRoomSeparators(String wallParameterName) {
		drawPlan();
		String subcatagory = "Add a room separation";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		AddWall wall = PageFactory.initElements(driver, AddWall.class);
		wall.addRoomSeparatorInfo().createWall(wallParameterName);

		return this;
	}

	public FloorPlan undo(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {
			undoButton.click();
		}
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan redo(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {
			redoButton.click();

		}
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan drawPlan() {
		String catagory = "Draw plan";
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/button[normalize-space(.)='" + catagory + "']"));
		catagoryEle.click();
		Verification.displayOfWebElement(catagoryEle);
		return this;
	}

	public FloorPlan deleteWall(int x, int y) {
		selectProduct(x, y);
		deleteButton.click();
		return this;
	}

	public FloorPlan verifyDeletedWall(int x, int y, String nameOfRoom, String areaOfRoom) {
		selectProduct(x, y);
		if (roomName.isDisplayed() && roomMeasurement.isDisplayed()) {
			if (roomName.getText().equalsIgnoreCase(nameOfRoom)
					&& roomMeasurement.getText().equalsIgnoreCase(areaOfRoom)) {
				UtilHBM.reportOK("Door/Window on wall deleted along with wall");
			} else if (driver
					.findElement(
							By.xpath("//h3/../preceding-sibling::img[starts-with(@srcset, 'https')]/parent::article"))
					.isDisplayed()) {
				UtilHBM.reportKO("Door/Window on wall not deleted along with wall");
			}
		}
		return this;
	}

	public FloorPlan addWaterSupply(int x, int y) {

		waterSupplyButton.click();
		WaterSupply water = PageFactory.initElements(driver, WaterSupply.class);
		water.selectWaterSupply(x, y);
		return this;
	}

	public FloorPlan verifyWaterSupply() {
		UtilHBM.waitExplicitDisplayed(driver, waterSupplyButton);
		UtilHBM.waitExplicitClickable(driver, waterSupplyButton);
		waterSupplyButton.click();
		WaterSupply water = PageFactory.initElements(driver, WaterSupply.class);
		water.verifyWaterSupply();
		return this;
	}

	public FloorPlan manageSlopedWalls() {
		drawPlan();
		String subcatagory = "Manage sloped ceilings";
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public SlopedCeiling manageSlopedWalls(int x, int y) {
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, addSlopedCeilingButton);
		addSlopedCeilingButton.click();
		UtilHBM.waitExplicitDisplayed(driver, slopedCeilingContainer);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public FloorPlan addslopedCeiling3D(int x, int y, String slopedCeilingA, String slopedCeilingB,
			String slopedCeilingC) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.addSlopedCeilingFrom3DView(x, y, slopedCeilingA, slopedCeilingB, slopedCeilingC).validateSlopedCeiling();
		return this;
	}

	public FloorPlan changeSlopedCeiling3D(int x, int y, String slopedCeilingA, String slopedCeilingB,
			String slopedCeilingC) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.changeSlopedCeiling3D(x, y, slopedCeilingA, slopedCeilingB, slopedCeilingC);
		return this;
	}

	public FloorPlan verifySlopedCeiling3D(int x, int y, String slopedCeilingA, String slopedCeilingB,
			String slopedCeilingC) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.verifySlopedCeiling3D(x, y, slopedCeilingA, slopedCeilingB, slopedCeilingC);
		return this;
	}

	public FloorPlan deleteSlopedCeiling(int x, int y) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.deleteSlopedCeiling(x, y);
		return this;
	}

	public FloorPlan verifyDeleteSlopedCeiling3D(int x, int y) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.verifyDeleteSlopedCeiling3D(x, y);
		return this;
	}

	public FloorPlan verifyDeleteSlopedCeiling2D() {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.verifyDeleteSlopedCeiling2D();

		return this;
	}

	public FloorPlan addslopedCeiling2D(int x, int y, String slopedCeilingA, String slopedCeilingB,
			String slopedCeilingC) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.addSlopedCeilingFrom2DView(x, y, slopedCeilingA, slopedCeilingB, slopedCeilingC);
		return this;
	}

	public FloorPlan verifySlopedCeiling2D(int x, int y, String slopedCeilingA, String slopedCeilingB,
			String slopedCeilingC) {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.verifySlopedCeilingIn2D(x, y, slopedCeilingA, slopedCeilingB, slopedCeilingC);
		return this;
	}

	public FloorPlan validateSlopedCeiling() {
		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.clickValidateSlopedCeiling();
		return this;
	}

	public FloorPlan verifySlopedCeiling3DTo2D() {

		SlopedCeiling slope = PageFactory.initElements(driver, SlopedCeiling.class);
		slope.verifySlopedCeiling3DTo2D();
		return this;
	}

	public FloorPlan roomObject(String product, String subCatagory) {
		roomObjectButton.click();
		UtilHBM.waitFixTime(500);
		WebElement catagory = null;
		for (WebElement e : subCatagoryList) {
			System.out.println("Cat text " + e.getText());
			if (e.getText().equalsIgnoreCase(subCatagory)) {
				catagory = e;
			}
		}

		catagory.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		catalog.closeSketcherCatalogPanel();
		return this;
	}

	public FloorPlan editItemDimensionProperties(int x, int y, String circumference, String wt, String ht, String dp,
			String htFromFloor, int changeWallSide) {
		selectProduct(x, y).editProperty();
		if (!(circumference.isEmpty())) {
			System.out.println("Width:" + circumferenceInputBox.getAttribute("name"));
			UtilHBM.waitExplicitClickable(driver, circumferenceInputBox);

			circumferenceInputBox.click();
			for (int i = 0; i <= circumference.length(); i++) {
				circumferenceInputBox.sendKeys(Keys.BACK_SPACE);
			}
			circumferenceInputBox.sendKeys(circumference);
		}
		if (!(wt.isEmpty())) {

			System.out.println("Width:" + widthInputBox.getAttribute("name"));
			UtilHBM.waitExplicitClickable(driver, widthInputBox);

			widthInputBox.click();
			for (int i = 0; i <= wt.length(); i++) {
				widthInputBox.sendKeys(Keys.BACK_SPACE);
			}
			widthInputBox.sendKeys(wt);
		}
		if (!(ht.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, heightInputBox);
			heightInputBox.click();
			for (int i = 0; i <= ht.length(); i++) {
				heightInputBox.sendKeys(Keys.BACK_SPACE);

			}
			heightInputBox.sendKeys(ht);
		}

		if (!(dp.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, depthInputBox);
			depthInputBox.click();
			for (int i = 0; i <= dp.length(); i++) {
				depthInputBox.sendKeys(Keys.BACK_SPACE);
			}
			depthInputBox.sendKeys(dp);
		}
		if (!(htFromFloor.isEmpty())) {
			htFromFloorInputBox.click();
			for (int i = 0; i <= htFromFloor.length(); i++) {
				htFromFloorInputBox.sendKeys(Keys.BACK_SPACE);
			}
			htFromFloorInputBox.sendKeys(htFromFloor);
		}

		if (!(changeWallSide == 0)) {
			UtilHBM.waitExplicitDisplayed(driver, wallSideInput);
			UtilHBM.waitExplicitClickable(driver, wallSideInput);
			String input = driver
					.findElement(By.cssSelector("fieldset[class='panel-form']>p>label>input[id='wall-side']"))
					.getAttribute("value");
			System.out.println("input val before" + input);
			new Actions(driver).moveToElement(wallSideInput).click().build().perform();
			UtilHBM.waitFixTime(1000);

			System.out.println("input val after " + input);
			int value = Integer.parseInt(input);
			if (value == changeWallSide) {
				UtilHBM.reportKO("Changed wall side of door/window failed");

			} else {
				UtilHBM.reportOK("Changed wall side of door/window");
			}
		}
		UtilHBM.waitFixTime(3000);
		closeEditPanel.click();
		// duplicateButton.click();
		// deleteButton.click();
		return this;
	}

	public FloorPlan verifyItemDimensionProperties(int x, int y, String circumference, String wt, String ht, String dp,
			String htFromFloor) {
		selectProduct(x, y).editProperty();

		if (circumference.isEmpty()) {
			UtilHBM.reportOK("Circumference property not available");
		} else if (!(circumference.isEmpty())) {
			if (circumference.equalsIgnoreCase(circumferenceInputBox.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Circumference property changed and value is " + circumferenceInputBox.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Circumference property not changed and value is "
						+ circumferenceInputBox.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Circumference");
		}

		if (wt.isEmpty()) {
			UtilHBM.reportOK("Width property not available");
		} else if (!(wt.isEmpty())) {
			if (wt.equalsIgnoreCase(widthInputBox.getAttribute("value"))) {
				UtilHBM.reportOK("Width property changed and value is " + widthInputBox.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Width property not changed and value is " + widthInputBox.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for width");
		}
		if (ht.isEmpty()) {
			UtilHBM.reportOK("Height property not available");
		} else if (!(ht.isEmpty())) {
			if (ht.equalsIgnoreCase(heightInputBox.getAttribute("value"))) {
				UtilHBM.reportOK("Height property changed and value is " + heightInputBox.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Height property not changed and value is " + heightInputBox.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for height");
		}
		if (dp.isEmpty()) {
			UtilHBM.reportOK("Depth property not available");
		} else if (!(dp.isEmpty())) {
			if (dp.equalsIgnoreCase(depthInputBox.getAttribute("value"))) {
				UtilHBM.reportOK("Depth property changed and value is " + depthInputBox.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Depth property not changed and value is " + depthInputBox.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for depth");
		}
		if (htFromFloor.isEmpty()) {
			UtilHBM.reportOK("Height from floor property not available");
		} else if (!(htFromFloor.isEmpty())) {
			if (htFromFloor.equalsIgnoreCase(htFromFloorInputBox.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Height from floor property changed and value is " + htFromFloorInputBox.getAttribute("value"));
			} else {
				UtilHBM.reportKO(" Height from floor property not changed and value is "
						+ htFromFloorInputBox.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for height from floor");
		}

		closeEditPanel.click();
		return this;
	}

	public FloorPlan editWallProperties(int x, int y, String thickness, String height) {
		selectProduct(x, y);
		editButton.click();
		if (!(thickness.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, thicknessInputBox);
			thicknessInputBox.click();
			thicknessInputBox.clear();
			thicknessInputBox.sendKeys(thickness);
		}
		if (!height.isEmpty()) {
			if (height.equalsIgnoreCase("ceilingHt")) {
				if (!ceilingHeightCheckbox.isSelected()) {
					ceilingHeightLabel.click();
				}
			} else {
				if (ceilingHeightCheckbox.isSelected()) {
					ceilingHeightLabel.click();
				}
				wallHeight.click();
				wallHeight.clear();
				wallHeight.sendKeys(height);
//				wallHeight.sendKeys(Keys.ENTER);
			}
		}
		closeWallPropertypPanel.click();
		clickBlank();
		return this;
	}

	public FloorPlan verifyWallProperties(int x, int y, String thickness, String height, int ceilingHeight) {
		clickBlank();
		selectProduct(x, y).editProperty();

		if (thickness.isEmpty()) {
			UtilHBM.reportOK("Thickness property not available");
		} else if (!(thickness.isEmpty())) {
			if (thickness.equalsIgnoreCase(thicknessInputBox.getAttribute("value"))) {
				UtilHBM.reportOK("Thickness property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Thickness");
		}

		if (thickness.equalsIgnoreCase(thicknessInputBox.getAttribute("value"))
				&& height.equalsIgnoreCase(wallHeight.getAttribute("value"))) {
			UtilHBM.reportOK("Thickness & Height of wall verified successfully");
		} else {
			UtilHBM.reportKO("Thickness & Height of wall verification failed");
			UtilHBM.reportKO("Wall Thickness= " + thicknessInputBox.getAttribute("value"));
			UtilHBM.reportKO("Height = " + wallHeight.getAttribute("value"));
		}
		if (ceilingHeight == 1) {
			if (ceilingHeightCheckbox.isSelected()) {
				UtilHBM.reportOK("same as ceiling height checkbox is checked and  Verification success");
			} else {
				UtilHBM.reportKO("same as ceiling height checkbox is un-checked and  Verification failed");
			}
		} else {
			if (!ceilingHeightCheckbox.isSelected()) {
				UtilHBM.reportOK("same as ceiling height checkbox is un-checked and  Verification success");
			} else {
				UtilHBM.reportKO("same as ceiling height checkbox is checked and  Verification failed");
			}
		}
		closeWallPropertypPanel.click();
		clickBlank();
		return this;
	}

	public FloorPlan addSlopedCeilingFromWall(int x, int y, String ceilingA, String ceilingB, String ceilingC) {
		clickBlank();
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, addSlopedCeilingButton);
		addSlopedCeilingButton.click();
		SlopedCeiling ceiling = PageFactory.initElements(driver, SlopedCeiling.class);
		ceiling.addSlopedCeiling(ceilingA, ceilingB, ceilingC).clickBlank();
		ceiling.validateSlopedCeiling();
		return this;
	}

	public FloorPlan editSlopedCeilingFromWall(int x, int y, int x2, int y2, String ceilingA, String ceilingB,
			String ceilingC) {
		clickBlank();
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, addSlopedCeilingButton);
		addSlopedCeilingButton.click();
		SlopedCeiling ceiling = PageFactory.initElements(driver, SlopedCeiling.class);
		ceiling.threeDView().changeSlopedCeiling3D(x2, y2, ceilingA, ceilingB, ceilingC).validateSlopedCeiling();
		return this;
	}

	public FloorPlan duplicate(int x, int y) {
		selectProduct(x, y);
		duplicateButton.click();
		return this;
	}

	public FloorPlan delete(int x, int y) {
		selectProduct(x, y);
		deleteButton.click();
		return this;
	}

	public FloorPlan position(int x, int y, String positionValueToChange, String pos1) {
		selectProduct(x, y);
		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("button[title='Position']>svg[class='icon-action-position']")));
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//button[@title='Position']/span[contains(text(),'Position')]")));
		new Actions(driver).moveToElement(position).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		List<WebElement> li = driver.findElements(By.xpath("//div/input[starts-with(@id,'measurevalue')]"));
		for (WebElement index : li) {
			if (positionValueToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				index.click();
				for (int i = 0; i < positionValueToChange.length(); i++) {
					index.sendKeys(Keys.BACK_SPACE);
				}
				index.sendKeys(pos1 + Keys.ENTER);
				UtilHBM.waitFixTime(5000);
				break;
			}
		}
		clickBlank();
		return this;
	}

	public FloorPlan verifyPosition(int x, int y, String dim) {
		selectProduct(x, y);
		position.click();
		List<WebElement> pos = driver.findElements(By.cssSelector("input.WallMeasure.Tag3D"));
		int index = 0;
		for (WebElement image : pos) {
			if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
			}
		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for position with value  " + dim + " are  " + index);

		}
		clickBlank();
		return this;
	}

	public FloorPlan editWallDimension(int x, int y, String dim, String applyAboveBelowLeftRight) {
		selectProduct(x, y);
		wall2DMeasure.click();
		wall2DMeasureInputBox.sendKeys(dim);

		if (applyAboveBelowLeftRight.equalsIgnoreCase("apply above")) {
			Actions action = new Actions(driver);
			action.moveToElement(applyAbove).click().build().perform();
		} else if (applyAboveBelowLeftRight.equalsIgnoreCase("apply below")) {
			Actions action = new Actions(driver);
			action.moveToElement(applyBelow).click().build().perform();
		} else if (applyAboveBelowLeftRight.equalsIgnoreCase("apply left")) {
			Actions action = new Actions(driver);
			action.moveToElement(applyLeft).click().build().perform();
		} else {
			System.out.println(applyRight.getText());
			Actions action = new Actions(driver);
			action.moveToElement(applyRight).click().build().perform();
		}
		return this;
	}

	public FloorPlan verifyWallProperty(int x, int y, String wallDim) {
		selectProduct(x, y);
		if (wall2DMeasure.getAttribute("value").equalsIgnoreCase(wallDim)) {
			UtilHBM.reportOK("Wall Dimension verified & the value is " + wallDim);
		} else {
			UtilHBM.reportKO("Wall dimension verification failed. Expected value: " + wallDim + ", Actual value: "
					+ wall2DMeasure.getAttribute("value"));
		}
		clickBlank();

		return this;
	}

	public FloorPlan editBayDimensions(int x, int y, int currentValue, int changedValue) {
		selectProduct(x, y);
		WebElement dim = null;
		int i = 0;
		for (WebElement tempDim : bayMeasureList) {
//			int i = currentValue - Integer.parseInt(tempDim.getAttribute("value").split(" ")[0]);
			if (currentValue == Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])) {
				dim = tempDim;
				i++;
			}
		}
		if (i == 0) {
			UtilHBM.reportKO("Expected dimention value to edit is not available. Expected value is: " + currentValue
					+ " & available values are: ");
			for (WebElement tempDim : bayMeasureList) {
				UtilHBM.reportKO(tempDim.getAttribute("value"));
			}
		}
		new Actions(driver).moveToElement(dim).click().build().perform();
		// bayDimInput.clear();
		bayMeasureInput.sendKeys(Integer.toString(changedValue));
		bayMeasureInput.sendKeys(Keys.RETURN);

		return this;
	}

	public FloorPlan verifyBayDimension(int x, int y, int bayValue, int numberOfBayDim) {
		selectProduct(x, y);
		int i = 0;
		String dim = null;
		for (WebElement tempDim : bayMeasureList) {
			if (bayValue == Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])) {
				dim = tempDim.getAttribute("value");
				i++;
			}
		}
		if (i > 0) {
			UtilHBM.reportOK("Bay dimension verified. No of dimension with value " + dim + " are " + i);
		}

		return this;
	}

	public FloorPlan splitWall(int x, int y) {
		clickBlank();
		selectProduct(x, y);
		driver.findElement(By.cssSelector("button[data-ui-action='split']")).click();
		clickBlank();
		return this;
	}

	public FloorPlan moveWall(int x, int y, int x1, int y1) {
		clickBlank();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
				.pause(1000).release().build().perform();
		clickBlank();
		return this;
	}

	public FloorPlan verifySplitRoomSeparator(int x, int y, String wallDim) {
		selectProduct(x, y);
		if (wallDim.isEmpty()) {
			UtilHBM.reportOK("Room separator dimensiona not available");
		} else if (!(wallDim.isEmpty())) {
			if (wallDim.equalsIgnoreCase(roomSeparatorMeasures.getAttribute("value"))) {
				UtilHBM.reportOK("Split Room separator dimensions changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Room separator dimension");
		}
		UtilHBM.waitFixTime(2000);
		return this;
	}

	public FloorPlan clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public FloorPlan clickBlankAfterPaint() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (canvas.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public FloorPlan clickWallFloor(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		int i = 0;
		while (driver.findElements(By.cssSelector("article[class='catalog-browser-mod-panel mod-open']")).size() == 0
				&& i < 5) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}
	public FloorPlan clickWallFloorMobile(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		int i = 0;
		while (driver.findElements(By.xpath("//article[@class='mod-panel-catalog-browser-tabs-material with-footer mod-open']")).size() == 0
				&& i < 5) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;
			System.out.println("Wall clicked");
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}
	
	public FloorPlan getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		// clickBlank();
		int i = 0;

		while (balloon.size() == 0 && i < 20) {
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

	public FloorPlan openings(String product, String subCatagory) {
		clickBlank();
		openings.click();
		WebElement catagory = null;
		for (WebElement e : subCatagoryList) {
			if (e.getText().equalsIgnoreCase(subCatagory)) {
				catagory = e;
			}
		}
		new Actions(driver).moveToElement(catagory).click().build().perform();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		catalog.closeSketcherCatalogPanel();
		return this;
	}
	/*
	 * public FloorPlan dragDropProduct(int x, int y, String sourceImg, String
	 * destinationImg, String finalImg) { clickBlank(); getBallon(x, y);
	 * UtilHBM.dragDropIkea(sourceImg, destinationImg, finalImg);
	 * UtilHBM.waitFixTime(2000); return this; }
	 */

	public FloorPlan ceiling(String dimension) {

		if (!(dimension.isEmpty())) {
			for (int i = 0; i <= dimension.length(); i++) {
				ceilingHeight.sendKeys(Keys.BACK_SPACE);
			}
			ceilingHeight.sendKeys(dimension + Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			String minimunValue = "999 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int dia = Integer
					.parseInt(dimension.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (dia <= val) {
				Verification.displayOfWebElement(errorMsg);
				Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(),
						"The minimum value is 1000 mm.");
			}
		}
		// threeDView();
		UtilHBM.waitFixTime(4000);
		return this;
	}

	public FloorPlan verifyCeiling(int x, int y, String dimension) {
		clickBlank();
		if (dimension.isEmpty()) {
			UtilHBM.reportOK("Ceiling height not available");
		} else if (!(dimension.isEmpty())) {
			if (dimension.equalsIgnoreCase(ceilingHeight.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Ceiling height input value changed and value is " + ceilingHeight.getAttribute("value"));
				getBallon(x, y);
				editProperty();
				if (!(dimension.isEmpty())) {
					if (dimension.equalsIgnoreCase(wallHeight.getAttribute("value"))) {
						UtilHBM.reportOK(
								"Ceiling height for wall changed and value is " + wallHeight.getAttribute("value"));
					} else {
						UtilHBM.reportKO(
								"Ceiling height for wall not changed and value is " + wallHeight.getAttribute("value"));
					}

				}
			}else
				UtilHBM.reportKO("Property verification failed for Ceiling height, expected : " + dimension + ", Actual : " + ceilingHeight.getAttribute("value"));
		} else {
			UtilHBM.reportKO("Property verification failed for Ceiling height");
		}

		return this;
	}

	public FloorPlan twoDView() {
		clickBlank();
		twoDButton.click();
		return this;
	}

	public FloorPlan threeDView() {
		clickBlank();
		threeDButton.click();
		return this;
	}

	public FloorPlan firstPersonView() {

		return this;
	}

	public FloorPlan zoomIn(int zoomIncount) {
		UtilHBM.waitFixTime(1000);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public FloorPlan zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}
public FloorPlan changeRoomName(int x,int y, String roomName) {
	Actions action = new Actions(driver);
	action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
	UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='room Tag3D visibility-visible  text-size-bigger-one hover ']")));
	action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
//	driver.findElement(By.xpath("//div/input[@class='room Tag3D visibility-visible  text-size-bigger-one hover ']")).clear();
//	action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
	driver.findElement(By.xpath("//div/input[@class='room Tag3D visibility-visible  text-size-bigger-one hover ']")).sendKeys(roomName);
	return this;
}
	public MakeItYours step3() {
		UtilHBM.waitExplicitClickable(driver, MakeItYoursButton);
		UtilHBM.waitExplicitClickable(driver, MakeItYoursButton);
		MakeItYoursButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//ul[@class='mod-design-steps-tabs']/li[@class='current']/button[@data-step='3']")));
		UtilHBM.waitFixTime(1000);
		MakeItYours step3 = PageFactory.initElements(driver, MakeItYours.class);
		step3.clickAndDrag();
		twoDView();
		threeDView();
		return PageFactory.initElements(driver, MakeItYours.class);

	}

	public HomeByMeProjects loginForHBM(SignUpData signUpData) {
		DraftSightEmbed home = PageFactory.initElements(driver, DraftSightEmbed.class);
		home.loginExitingUser(signUpData);
		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}

	public HomeByMeProjects logoutForHBM() {
		KitchenLogin logout = PageFactory.initElements(driver, KitchenLogin.class);
		logout.hbmLogout();
		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}

	public SaveProject clickSave(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, saveIcon);
		UtilHBM.waitExplicitClickable(driver, saveIcon);
		saveIcon.click();

		login(signUpData);
		return PageFactory.initElements(driver, SaveProject.class);

	}

	public FloorPlan login(SignUpData signUpData) {
		driver.switchTo().parentFrame();
		if (loginWindow.size() > 0) {
			KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
			login.login(signUpData);

		} else {
			UtilHBM.reportInfo("User already logged in");
		}

		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan saveProjectInStep1(SignUpData signUpData, String name, String desc) {
		clickSave(signUpData).saveProject(name, desc);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan renameProject(String name, String desc) {
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.reNameProject(name, desc);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public StartNow closePlanner() {
		UtilHBM.waitFixTime(2500);
		closePlanner.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, StartNow.class);
	}

	public StartNow saveChanges() {
		if (driver.findElement(By.cssSelector(".mod-popin-unsaved-changes-small.mod-open")).isDisplayed()) {
			driver.findElement(By.cssSelector(
					".mod-popin-unsaved-changes-small.mod-open>div>footer>button[data-ui-action='primary-button-action']"))
					.click();
		}
		return PageFactory.initElements(driver, StartNow.class);
	}

	public FloorPlan addProductBathroomFloorplan(String product, boolean filter, boolean productInfoSheet) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoBathroomCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagoryBathroom(product).addProductDesignStep(product, true, filter,
				productInfoSheet);
		Catalog close = PageFactory.initElements(driver, Catalog.class);
		close.closeSketcherCatalogPanel();
		return this;
	}

	public FloorPlan addProduct(String product, boolean filter, boolean productInfoSheet) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagory(product).addProductDesignStep(product, true, filter,
				productInfoSheet);
		Catalog close = PageFactory.initElements(driver, Catalog.class);
		close.closeSketcherCatalogPanel();
		return this;
	}

	public FloorPlan addOpeningThroughWalls(int x, int y, String product, boolean productInfoSheet) {
		selectProduct(x, y);
		UtilHBM.waitExplicitDisplayed(driver, openingsBtnInProperties);
		openingsBtnInProperties.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#catalogbrowser-content-inner>ul")));
		Catalog design = PageFactory.initElements(driver, Catalog.class);
		design.addProductDesignStep(product, true, false, productInfoSheet);
		return this;
	}

	public FloorPlan addProductUsingDragDrop(String product, boolean filter, boolean productInfoSheet,
			int finalxcoordinate, int finalycoordinate) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagory(product).addProductDragAndDrop(product, true, filter,
				productInfoSheet, finalxcoordinate, finalycoordinate);
		return this;
	}

	public FloorPlan replaceProductFromEdit(int x, int y, String product) {
		selectProduct(x, y).editProperty();
		replaceButton.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.replaceProductInFloorplan(product);
		clickBlank();
		return this;

	}

	public FloorPlan addCoveringByClosingCatalog(String product, String allOrSelection) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagoryForCovering(product).selectCoveringMaterial(product, allOrSelection)
				.closeSketcherCatalogPanel();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan addCovering(String product, String allOrSelection) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagoryForCovering(product).selectCoveringMaterial(product, allOrSelection);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyLastUsedMaterial(String prdID) {
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.verifyLastUsed(prdID);
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan applyMaterialFromLastUsedList(String prdID,int x,int y) {
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.applyMaterialFromLastUsedList(prdID);
		applyMaterialIn3D(x,y);
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan applyMaterialIn3D(int x, int y) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan addCoveringByClickingWallFloor(int x, int y, String product, String allOrSelection, int applyOnX,
			int applyOnY) {
		clickBlank().clickWallFloor(x, y);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.selectCoveringMaterial(product, allOrSelection);
//		.clickBlankAfterPaint();
		return this;
	}

	public FloorPlan addCoveringUsingFullScreen(String product, String allOrSelection, int xOffset, int yOffset) {

		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagoryForCovering(product).minMaxCatalogPanel().selectCoveringMaterial(product,
				allOrSelection);
		return this;
	}

	/*
	 * public FloorPlan verifyCovering(String img) { clickBlank();
	 * UtilHBM.verifyScreen(img); return this; }
	 */
	private FloorPlan clickCatalogIcon(WebElement element) {
		UtilHBM.waitExplicitClickable(driver, element);
		element.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "button.bt-icon-label-alt.selected"));
		return this;
	}

	private Catalog clickSubCatagoryBathroom(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoBathroomCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']");
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']");
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		UtilHBM.waitExplicitDisplayed(driver,
				"//*[@data-ui-id='content'][@class='content']//*[@class='content-inner']");
		UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@id, 'catalog-browser')][not(contains(@class, 'loading'))][contains(@class, 'mod-open')]");
		UtilHBM.waitFixTime(500);
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog clickSubCatagory(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']");
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']");
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		UtilHBM.waitExplicitDisplayed(driver,
				"//*[@data-ui-id='content'][@class='content']//*[@class='content-inner']");
		UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@id, 'catalog-browser')][not(contains(@class, 'loading'))][contains(@class, 'mod-open')]");
		UtilHBM.waitFixTime(500);
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}
	private Catalog clickSubCatagoryForCovering(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']");
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		UtilHBM.waitExplicitDisplayed(driver, "//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']");
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		UtilHBM.waitExplicitDisplayed(driver, "//*[@class='content-fluid']//*[@class='content-inner']");
		UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@id, 'catalog-browser')][not(contains(@class, 'loading'))][contains(@class, 'mod-open')]");
		UtilHBM.waitFixTime(500);
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}

	FloorPlan selectProductToManipulate(int xcoordinate, int ycoordinate) {
		Actions actions = new Actions(driver);
		actions.moveToElement(container3D, xcoordinate, ycoordinate).clickAndHold().pause(500).release().build()
				.perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan translateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		selectProduct(initialxcoordinate, intialycoordinate);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(translatePointer, finalxcoordinate, finalycoordinate).build().perform();
//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public Print clickPrint() {
		printButton.click();
		return PageFactory.initElements(driver, Print.class);
	}

	public FloorPlan printTestInStep1(int renderCount, int printCount) {
		clickPrint().verifyMediasDisplayed(renderCount, printCount);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan displayAllItems(int x, int y) {
		UtilHBM.waitExplicitClickable(driver, viewOptions);
		UtilHBM.waitFixTime(1000);
		new Actions(driver).moveToElement(container3D, 25, 25).build().perform();
		UtilHBM.waitFixTime(500);
//		new Actions(driver).moveToElement(container3D, 25, 25).build().perform();
		if (driver.findElement(By.cssSelector("div[id='main-mod-view-3d']>div[style='cursor: not-allowed;']"))
				.isDisplayed()) {
			UtilHBM.reportOK("Cursor is disabled and product is not selectable in floorplan step");
		} else {
			UtilHBM.reportKO("Cursor not disabled and product is  selectable in floorplan step");
		}
		new Actions(driver).moveToElement(container3D, x, y).build().perform();
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("div[data-ui-selector='mod-mouse-tooltip']")));
		if (driver.findElement(By.cssSelector("div[data-ui-selector='mod-mouse-tooltip']")).getText()
				.equalsIgnoreCase("You cannot move any items in this step")) {
			UtilHBM.reportOK("product is not selectable in floorplan step");
		} else {
			UtilHBM.reportKO("product is  selectable in floorplan step");
		}
		viewOptions.click();
		UtilHBM.waitExplicitDisplayed(driver, displayAllItems);
		new Actions(driver).moveToElement(displayAllItems).click().build().perform();
		selectProduct(x, y);
		if (roomName.isDisplayed() && roomMeasurement.isDisplayed()) {
			UtilHBM.reportOK("All items in step 1 are hidden using display all items");
		} else if (driver.findElement(By.cssSelector("div[id='main-mod-view-3d']>div[style='cursor: not-allowed;']"))
				.isDisplayed()) {
			UtilHBM.reportKO("All items in step 1 are not hidden using display all items");
		}
		return this;
	}

	public MakeItYours recoverProject(String yesOrNo) {
		UtilHBM.waitExplicitDisplayed(driver, recoverPopUp.get(0));
		RecoverProject recover = PageFactory.initElements(driver, RecoverProject.class);
		recover.recoverProject(yesOrNo);
		if(yesOrNo.equalsIgnoreCase("no"))step3();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public FloorPlan deleteMultipleProducts(String roomObjectMultipleDelete) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.deleteMultipleRoomObjects(roomObjectMultipleDelete);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan duplicateMultipleProducts(String roomObjectMultipleDup) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.duplicateMultipleRoomObjects(roomObjectMultipleDup);
		clickBlank();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan positionMultipleProducts(String roomObjectMultiplePosition, String positionValueToChange,
			String pos1) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.positionMultipleRoomObjects(roomObjectMultiplePosition, positionValueToChange, pos1);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyMultipeProductsPosition(String roomObjectMultipleVerifyPosition, String dim) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.verifyPositionMultipleRoomObjects(roomObjectMultipleVerifyPosition, dim);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan elevateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		selectProductToManipulate(initialxcoordinate, intialycoordinate);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(elevatePointer, finalxcoordinate, finalycoordinate).build().perform();
//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verify3Dwallpaint(int x, int y, String product) {

		clickBlank().clickWallFloor(x, y).clickBlank().clickWallFloor(x, y);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.verifyCurrentCoveringSelection(product);
//		closeWallPropertypPanel.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan selectAvatar(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("div[class='canvas-wrap cursor-grab']")));

		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan resetCameraView() {
		UtilHBM.waitExplicitDisplayed(driver, resetView);
		UtilHBM.waitExplicitClickable(driver, resetView);
		resetView.click();
		return PageFactory.initElements(driver, FloorPlan.class);

	}
	public FloorPlan verifyResetCameraViewIconDisplayed() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@id='canvas-center'][@style='display: block;']")));
		return PageFactory.initElements(driver, FloorPlan.class);

	}
	public FloorPlan verifyResetCameraViewIconRemoved() {
		
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 0, 0).clickAndHold().pause(500).release().build().perform();
		Verification.displayOfWebElement(driver.findElement(
				By.xpath("//article[@class='mod-panel-catalog-browser-tabs-material mod-open']")));
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public FloorPlan moveAvatar(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		selectAvatar(initialxcoordinate, intialycoordinate);
		Actions actions = new Actions(driver);
//		actions.dragAndDropBy(driver.findElement(By.cssSelector("div[class='canvas-wrap cursor-grab']")), finalxcoordinate, finalycoordinate).build().perform();
//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
				.dragAndDropBy(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyItemNoteAndProductListIconsDistinguishable() {
		Verification.VerifyEquals("Item note icon not distinguishable...", itemNotes
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-notes");
		System.out.println(itemNotes.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
				.getAttribute("xlink:href"));
		Verification.VerifyEquals("Product list icon not distinguishable...", productListIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-function-product-list");
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public ItemNotes itemNotes() {
		UtilHBM.waitExplicitDisplayed(driver, itemNotes);
		UtilHBM.waitExplicitClickable(driver, itemNotes);
		itemNotes.click();
		return PageFactory.initElements(driver, ItemNotes.class);
	}

	public FloorPlan verifyNoSpaceAvailable() {
		UtilHBM.waitExplicitDisplayed(driver, noSpacePopIn);
		Verification.VerifyEquals("Incorrect no space title", noSpaceTitle.getText(), "No space available");
		Verification.VerifyEquals("Incorrect no space info", noSpaceInfo.getText(),
				"We have not found enough space to correctly position the roof window.\nWe will put it in the middle of the screen\nso that you can move it manually.");
		noSpaceOKButton.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	// ****MOBILE*********
	public FloorPlan twoDViewMobile() {
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//div[@class='canvas-tools-navigation']/button[@class='bt-icon selected']")).click();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//section[@class='mod-bottom-sheet']")));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".canvas-tools-navigation.mod-open")));
	new Actions(driver).moveToElement(twoDButton).click().build().perform();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public FloorPlan threeDViewMobile() {
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//div[@class='canvas-tools-navigation']/button[@class='bt-icon selected']")).click();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//section[@class='mod-bottom-sheet']")));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".canvas-tools-navigation.mod-open")));
		new Actions(driver).moveToElement(threeDButton).click().build().perform();
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@data-ui-action='toggle-bottom-sheet']"))).click()
				.build().perform();
		return this;
	}
	public FloorPlan closeBottomSheet() {
		UtilHBM.waitExplicitDisplayed(driver, mBottomSheetClose);
		UtilHBM.waitExplicitClickable(driver, mBottomSheetClose);
		Actions actions = new Actions(driver);
		actions.moveToElement(mBottomSheetClose).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet']");
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan openBottomSheet() {
		if (driver.findElements(By.cssSelector("section.mod-bottom-sheet.mod-expanded")).size() > 0) {
			UtilHBM.reportOK("Bottom Sheet already open");
			return PageFactory.initElements(driver, FloorPlan.class);
		}
		UtilHBM.waitExplicitDisplayed(driver, mBottomSheetOpen);
		UtilHBM.waitExplicitClickable(driver, mBottomSheetOpen);
		Actions actions = new Actions(driver);
		actions.moveToElement(mBottomSheetOpen).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet mod-expanded']");
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan ceilingHeightMobile(String dimension) {
		UtilHBM.waitExplicitDisplayed(driver, ceilingHeightMobile);
		UtilHBM.waitExplicitClickable(driver, ceilingHeightMobile);
		ceilingHeightMobile.click();
		if (!(dimension.isEmpty())) {
			for (int i = 0; i <= dimension.length(); i++) {
				ceilingHeight.sendKeys(Keys.BACK_SPACE);
			}
			ceilingHeight.sendKeys(dimension + Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			String minimunValue = "999 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int dia = Integer
					.parseInt(dimension.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (dia <= val) {
				Verification.displayOfWebElement(errorMsg);
				Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(),
						"The minimum value is 1000 mm.");
			}
		}
		// threeDView();
		UtilHBM.waitFixTime(4000);
		driver.findElement(By.xpath("//button[@data-ui-action='validate-ceiling-height']")).click();
		UtilHBM.waitFixTime(1000);
		

		return this;
	}

	public FloorPlan verifyWallPropertyMobile(int x, int y, String wallDim) {
		selectProduct(x, y);
		if (wall2DMeasure.getAttribute("value").equalsIgnoreCase(wallDim)) {
			UtilHBM.reportOK("Wall Dimension verified & the value is " + wallDim);
		} else {
			UtilHBM.reportKO("Wall dimension verification failed. Expected value: " + wallDim + ", Actual value: "
					+ wall2DMeasure.getAttribute("value"));
		}
		clickBlankMobile();
		return this;
	}
	public FloorPlan splitWallMobile(int x, int y) {
		clickBlankMobile();
		selectProduct(x, y);
		driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='split']")).click();
		UtilHBM.waitFixTime(200);
		closeBottomSheet();
		Actions action=new Actions(driver);
		action.moveToElement(container3D, -7, 215).clickAndHold().pause(500).release().build().perform();
		openBottomSheet();
		return this;
	}

	public FloorPlan moveWallMobile(int x, int y, int x1, int y1) {
		clickBlankMobile();
		UtilHBM.waitFixTime(2000);
//		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
//		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
//				.pause(1000).release().build().perform();
		
		TouchAction action = new TouchAction((PerformsTouchActions)driver);
		action.longPress(PointOption.point(x, y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(x1, y1))
		.release()
		.perform();
		clickBlankMobile();
		return this;
	}
	public FloorPlan clickBlankMobile() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, -5, -160).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	public MakeItYours selectProductMobile(int x, int y) {
		clickBlankMobile();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("article[class='mod-properties-window-regular mod-open']")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.cssSelector("article[class='mod-properties-window-regular mod-open']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public FloorPlan addProductMobile(String product, boolean filter, boolean productInfoSheet) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIconMobile(catalogEle).clickSubCatagoryMobile(product).addProductDesignStep(product, true, filter,
				productInfoSheet);
		return this;
	}
	private FloorPlan clickCatalogIconMobile(WebElement element) {
		UtilHBM.waitExplicitClickable(driver, element);
		new Actions(driver).moveToElement(element);
		element.sendKeys(Keys.ENTER);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".mod-bottom-sheet-with-backdrop.mod-expanded"));
		return this;
	}
	private Catalog clickSubCatagoryMobile(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet-with-backdrop mod-expanded']/div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']");
		WebElement catagoryEle = driver
				.findElement(By.xpath("//section[@class='mod-bottom-sheet-with-backdrop mod-expanded']/div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet-with-backdrop mod-expanded']/div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']");
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//section[@class='mod-bottom-sheet-with-backdrop mod-expanded']/div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		UtilHBM.waitExplicitDisplayed(driver,
				"//*[@data-ui-id='content'][@class='content']//*[@class='content-inner']");
//		UtilHBM.waitExplicitDisplayed(driver, "//*[@class='content-fluid']//*[@class='content-inner']");
		UtilHBM.waitExplicitDisplayed(driver,
				"//article[contains(@id, 'catalog-browser')][not(contains(@class, 'loading'))][contains(@class, 'mod-open')]");
		UtilHBM.waitFixTime(500);
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}
	public FloorPlan addWaterSupplyMobile(int x, int y) {
		waterSupplyButton.click();
		WaterSupply water = PageFactory.initElements(driver, WaterSupply.class);
		water.selectWaterSupplyMobile(x, y);
		return this;
	}

	//mobile
	public FloorPlan mobileAddOpeningThroughWalls(int x, int y, String product) {
		selectProduct(x, y);
		UtilHBM.waitExplicitDisplayed(driver, mobileOpeningsBtn);
		mobileOpeningsBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#catalogbrowser-content-inner>ul")));
		Catalog design = PageFactory.initElements(driver, Catalog.class);
		design.addProductDesignStep(product, true, false, false);
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitExplicitDisplayed(driver, closeWallPropertypPanel);
//		closeWallPropertypPanel.click();
//		UtilHBM.waitFixTime(1000);
		return this;
	}

	public FloorPlan verifyOpeningMobile(int x, int y, String opening) {
		clickBlankMobile();
		selectProductMobile(x,y);
		UtilHBM.waitExplicitDisplayed(driver, mobileOpeningHeader);

		return this;
	}
	public FloorPlan addCoveringByClickingWallFloorMobile(int x, int y, String product, String allOrSelection) {
		clickWallFloorMobile(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//article[@class='mod-panel-catalog-browser-tabs-material with-footer mod-open']")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.xpath("//article[@class='mod-panel-catalog-browser-tabs-material with-footer mod-open']")));
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.selectCoveringMaterial(product, allOrSelection);
//		.clickBlankAfterPaint();
		return this;
	}
	public FloorPlan editWallPropertiesAndVerifyErrMsg(int x, int y, String thickness, String height, String errMessage) {
		selectProduct(x, y);
		editButton.click();
		if (!(thickness.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, thicknessInputBox);
			thicknessInputBox.click();
			thicknessInputBox.clear();
			thicknessInputBox.sendKeys(thickness,Keys.ENTER);
			Verification.VerifyEquals("Wrong Error msg displayed", errorMsg.getText(), errMessage);
		}
		if (!height.isEmpty()) {
			if (height.equalsIgnoreCase("ceilingHt")) {
				if (!ceilingHeightCheckbox.isSelected()) {
					ceilingHeightLabel.click();
				}
			} else {
				if (ceilingHeightCheckbox.isSelected()) {
					ceilingHeightLabel.click();
				}
				wallHeight.click();
				wallHeight.clear();
				wallHeight.sendKeys(height,Keys.ENTER);
				Verification.VerifyEquals("Wrong Error msg displayed", errorMsg.getText(), errMessage);
			}
		}
		closeWallPropertypPanel.click();
		clickBlank();
		return this;
	}

	public FloorPlan verifyWallProperty(int x, int y, int wallCornerX, int wallCornerY , String cornerDims) {
		selectProduct(x, y);
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, wallCornerX, wallCornerY).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);

		List<String> expectedWallCornerDims = new ArrayList<>(Arrays.asList(cornerDims.split("\\s*>\\s*")));
		List<String> wallCornerDims = new ArrayList<>();
		for (WebElement wc : wallCornerMeasure) wallCornerDims.add(wc.getAttribute("value"));
		expectedWallCornerDims.removeAll(wallCornerDims);
		if (!(expectedWallCornerDims.size() == 0))
			UtilHBM.reportKO("Expected wall corner dimensions not available : " + expectedWallCornerDims + "\nAvailable : " + wallCornerDims);

		clickBlank();

		return this;
	}
	
	public FloorPlan importLaserMeasurements(String dxfFileName) {
		initiatePlan();
		UtilHBM.waitExplicitDisplayed(driver, importLaserMeasurements);
		importLaserMeasurements.click();

		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerOnboarding);
		verifyLeicaLaserMeasurementOnboardingSublayer();
		leicaLaserMeasurementOnboardingSublayerContinueBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerFileUpload);
		verifyLeicaLaserMeasurementFileUploadSublayer();
		leicaLaserMeasurementUploadFile.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\" + dxfFileName);
		UtilHBM.waitTillElementDisappear(driver, leicaLaserMeasurementSublayerFileUpload);
		UtilHBM.waitExplicitDisplayed(driver, notificationSuccessMsg.findElement(By.xpath("./span[text()='Your file has been successfully imported']")));
		return this;
	}

	private FloorPlan verifyLeicaLaserMeasurementFileUploadSublayer() {
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerFileUpload);
		Verification.VerifyEquals("Title verification failed", leicaLaserMeasurementTitle.getText().trim(),
				"Import your measurement file");
		Verification.VerifyEquals("Sub Title verification failed", leicaLaserMeasurementSubTitle.getText().trim(),
				"you can drop or select the file to import");
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerFileUpload.findElement(By.cssSelector("div.drop-area span.illustration-icon")));
		Verification.VerifyEquals("Drop File text verification failed", leicaLaserMeasurementSublayerFileUpload.findElement(By.cssSelector("div.drop-area p[data-i18n='import_laser_measurements.drop_file']")).getText().trim(),
				"Drop your file anywhere");
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerFileUpload.findElement(By.cssSelector("span[data-i18n='import_laser_measurements.select_file']")));
		Verification.VerifyEquals("file format info verification failed", leicaLaserMeasurementSublayerFileUpload.findElement(By.cssSelector("div.drop-area span[data-i18n='import_laser_measurements.supported_file']")).getText().trim(),
				"Supported file: Leica DXF");
		Verification.VerifyEquals("File size info verification failed", leicaLaserMeasurementSublayerFileUpload.findElement(By.cssSelector("div.drop-area span[data-i18n='import_laser_measurements.supported_size']")).getText().trim(),
				"Maximum upload file size: 1MB");
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementFileUploadSubLayerCancelBtn);
		return this;
	}

	private FloorPlan verifyLeicaLaserMeasurementOnboardingSublayer() {
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementSublayerOnboarding);
		Verification.VerifyEquals("Header verification failed", leicaLaserMeasurementSublayerOnboarding.findElement(By.cssSelector("header>h4[data-i18n='import_laser_measurements.sub_layer_onboarding.title']")).getText().trim(),
				"With laser measurements, starting with a precise floorplan of your room is made fast and easy");
		Verification.VerifyEquals("Description verification failed", leicaLaserMeasurementSublayerOnboarding.findElement(By.cssSelector("div.content>img")).getAttribute("src"),
				"https://preprod-kitchen.enterprise-dev.by.me/Kitchen/assets/images/import-laser-measurements/leica-illustration.png");
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementOnboardingSublayerCancelBtn);
		UtilHBM.waitExplicitDisplayed(driver, leicaLaserMeasurementOnboardingSublayerContinueBtn);
		return this;
	}

	public FloorPlan checkBusinessRuleShowIn3D(String rule, boolean showBusinessRuleButton) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn3D(rule, showBusinessRuleButton);
		clickBlank();
		return this;
	}
	
//	**************************MOBILE****************************
	public FloorPlan clickBlankAfterPaintMobile() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (canvas.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, -18, -204).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	public FloorPlan verify3DwallpaintMobile(int x, int y, String product) {

		clickBlank().clickWallFloorMobile(x, y).clickBlank().clickWallFloorMobile(x, y);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.verifyCurrentCoveringSelectionMpbile(product);
//		closeWallPropertypPanel.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan closeCoveringCatalogMobile() {
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.closeSketcherCatalogPanel();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyInitiatePlanOptionsAvailableMobile(String options) {
		List<String> expectedOptions = new ArrayList<>(Arrays.asList(options.split("\\s*>\\s*")));

		List<String> availableOptions = new ArrayList<>();
		UtilHBM.waitExplicitDisplayed(driver, bottomSheetWithBackdrop);
		for (WebElement ele : bottomSheetWithBackdrop.findElements(By.cssSelector("li>button"))) {
			availableOptions.add(ele.getText().trim());
		}

		List<String> commonOpts = new ArrayList<>(expectedOptions);
		commonOpts.retainAll(availableOptions);

		expectedOptions.removeAll(commonOpts);
		if (!expectedOptions.isEmpty())
			UtilHBM.reportKO("Following initiate plan options not available : " + expectedOptions);
		availableOptions.removeAll(commonOpts);
		if (!availableOptions.isEmpty())
			UtilHBM.reportKO("Following initiate plan options not expected : " + availableOptions);

		clickBlankMobile();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyBottomSheetToolsForProductMobile(int x, int y, String options) {
		clickBlankMobile();
		selectProduct(x, y);
		List<String> expectedOptions = new ArrayList<>(Arrays.asList(options.split("\\s*>\\s*")));

		List<String> availableOptions = new ArrayList<>();
		UtilHBM.waitExplicitDisplayed(driver, bottomSheetToolsForProducts);
		for (WebElement ele : bottomSheetToolsForProducts.findElements(By.cssSelector("li>button"))) {
			availableOptions.add(ele.getText().trim());
		}

		List<String> commonOpts = new ArrayList<>(expectedOptions);
		commonOpts.retainAll(availableOptions);

		expectedOptions.removeAll(commonOpts);
		if (!expectedOptions.isEmpty())
			UtilHBM.reportKO("Following bottom sht prdt tool options not available : " + expectedOptions);
		availableOptions.removeAll(commonOpts);
		if (!availableOptions.isEmpty())
			UtilHBM.reportKO("Following bottom sht prdt tool options not expected : " + availableOptions);

		clickBlankMobile();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
}