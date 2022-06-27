package hr.planner.pageObject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.pageobject.WallPropertiesTwoD;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.DraftSightEmbed;
import hr.web.pageObject.LandingPageHR;
import hr.web.pageObject.Login;
import hr.web.pageObject.PriceDetails;
import hr.web.pageObject.Print;
import hr.web.pageObject.ProjectOverview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePlanner {

	WebDriver driver;

	public HomePlanner(WebDriver driver) {
		this.driver = driver;
	}



	@FindBy(id="bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='initiate-plan']")
	private WebElement initialPlan;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div//div/ul/li/ul/li[@data-ui-subsubcat='multiple-level']/button[@class='bt-text']")
	private WebElement manageLevels;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div//div/ul/li/ul/li[@data-ui-subsubcat='homebyme']/button[@class='bt-text']")
	private WebElement useHomeByMeProject;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div//div/ul/li/ul/li[@data-ui-subsubcat='upload-plan-2d']/button[@class='bt-text']")
	private WebElement uploadTwoDPlan;

	@FindBy(css="#draw-plan>.icon-tools-change-room+span")
	private WebElement floorPlanButton;

	@FindBy(css="#draw-plan>.icon-tools-change-room>use")
	private WebElement floorPlanIcon;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='add-wall']/button[@class='bt-text']")
	private WebElement addWall;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='add-room-separator']/button[@class='bt-text']")
	private WebElement addRoomSeparator;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='add-sloped-wall']/button[@class='bt-text']")
	private WebElement manageSlopedCeilings;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='building']")
	private WebElement build;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/h2/button[@data-ui-subcat='exterior_doors']")
	private WebElement exteriorDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='front_doors']/button")
	private WebElement frontDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='patio_doors']/button")
	private WebElement patioDoorsWindow;
	// check xpath we have 2 patio doors

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='garage_doors']/button")
	private WebElement garageDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/h2/button[@data-ui-subcat='interior_doors']")
	private WebElement interiorDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='folding_doors']/button")
	private WebElement foldingDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='sliding_doors']/button")
	private WebElement slidingDoors;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/h2/button[@data-ui-subcat='windows']")
	private WebElement windows;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='simple_windows']/button")
	private WebElement simpleWindow;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='double_windows']/button")
	private WebElement doubleWindows;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='sliding_windows']/button")
	private WebElement slidingWindow;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='patio_doors']/button")
	private WebElement patioDoors;
	// check xpath we have 2 patio doors

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/h2/button[@data-ui-subcat='staircases']")
	private WebElement staircase;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='straight_staircases']/button")
	private WebElement straightStaircase;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='helical_staircases']/button")
	private WebElement helicalStaircase;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='quarterTurn_staircases']/button")
	private WebElement quarterTurnStaircases;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='double_quaterTurn_staircases']/button")
	private WebElement doubleQuaterTurnStaircases;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/h2/button[@data-ui-subcat='technical_equipments']")
	private WebElement technicalEquipments;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='electricity']/button")
	private WebElement electricity;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='heating_and_cooling']/button")
	private WebElement heatingAndCooling;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='plumbing']/button")
	private WebElement plumbing;

	@FindBy(xpath = "//main/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='construction']/button")
	private WebElement construction;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='furniture']")
	private WebElement furnish;

	@FindBy(xpath = "//div/ul/li/ul/li[@data-ui-subsubcat='beds']/button")
	private WebElement beds;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='decoration']")
	private WebElement decorate;

//	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='favorites']")
//	private WebElement favorites;
	
	@FindBy(xpath = "//button[@class='bt-icon']/span[@class='icon-function-favorite']")
	private WebElement favorites;
	
	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='search']")
	private WebElement search;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='take-picture']")
	private WebElement takePicture;

	@FindBy(css = ".subsubcat>li[data-ui-subsubcat='take-a-screenshot']>.bt-text")
	private WebElement takeScreenshot;

	@FindBy(css = "[data-i18n='create_snapshot.generate_snapshot']")
	private WebElement generateScreenshot;

	@FindBy(css =".bt-icon-circle>.icon-function-render")
	private WebElement generateScreenshotClick;

	@FindBy(css = ".bt-icon-alt-light>.icon-view-close")
	private WebElement closeScreenshot;

	@FindBy(css = ".subsubcat>li[data-ui-subsubcat='take-realistic-picture']>.bt-text")
	private WebElement takeRealistic;

	@FindBy(css = ".subsubcat>li[data-ui-subsubcat='take-360-picture']>.bt-text")
	private WebElement take360;

	@FindBy(xpath = "//body/div/header/div/h1")
	private WebElement logo;

	@FindBy(xpath = "//body/div/header/div/div[@class='project-detail-header']/button[@class='bt-text project-title']")
	private WebElement projectName;

	@FindBy(xpath = "//body/div/header/div/div[@class='project-detail-header']/button[@class='bt-icon']")
	private WebElement moreInfo;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-tools-measure']")
	private WebElement measure;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-action-export-hbm']")
	private WebElement export;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-action-print']")
	private WebElement print;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-action-undo']")
	private WebElement undo;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-action-redo']")
	private WebElement redo;

	@FindBy(xpath = "//body/div/header/div/div/ul/li/button/span[@class='icon-action-save']")
	private WebElement save;
	
	@FindBy(css =  ".mod-loader" )
	private WebElement saveloader;

	@FindBy(xpath = "//body/div/header/div/div/button/span[@class='icon-view-close']")
	private WebElement close;

	@FindBy(xpath = "//main/div/div/div/div/p/span/span[@class='price-container standard']")
	private WebElement price;

	@FindBy(xpath = "//main/div/div/div/div/p/button[@class='bt-text']")
	private WebElement projectOverview;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='medias']")
	private WebElement myMedia;

	@FindBy(xpath = "//main/div/div/div/div/button/span[@class='icon-function-order']")
	private WebElement cart;

	@FindBy(xpath = "//main/div/div/article/button/span[@class='icon-action-arrow']")
	private WebElement help;

	@FindBy(xpath = "//button/span[@class='icon-action-zoom']")
	private WebElement zoomIn;

	@FindBy(xpath = "//button/span[@class='icon-action-unzoom']")
	private WebElement zoomOut;

	@FindBy(css = ".icon-action-zoom-extend>svg")
	private WebElement canvasCenter;

	@FindBy(css = "div[id='canvas-level-selector']>span>select")
	private WebElement levelSelector;

	@FindBy(css = "[id='canvas-level-selector']>span>select>[value='manage-levels']")
	private WebElement levelToLevelManager;

	@FindBy(css = ".icon-tools-options")
	private WebElement viewModeOptionsBtn;

	@FindBy(css = ".mod-overlay>div>ul>li>span>.form-select>select")
	private WebElement cameraHeightValue;

	@FindBy(css = "[class='icon-view-2d']")
	private WebElement viewTwoD;

	@FindBy(xpath = "//span[text()='Display room names']/ancestor::li//label")
	private WebElement displayRoomNames;

	@FindBy(xpath = "//span[text()='Display room areas']/ancestor::li//label")
	private WebElement displayRoomAreas;

	@FindBy(css = "[class='icon-view-3d']")
	private WebElement viewThreeD;

	@FindBy(xpath = "//main/div/div/div/div/div/button/span[@class='icon-view-fp']")
	private WebElement firstPersonView;

	@FindBy(css = "canvas")
	private WebElement canvas;

	@FindBy(css = "input.room.Tag3D.visibility-visible.pointer-events-deactivated")
	private List<WebElement> roomTagList;

	@FindBy(css = ".mod-notification>.success.show")
	private WebElement notificationText;
	
	@FindBy(xpath =  "//p[@class='success show']/button" )
	private WebElement viewButton;

	@FindBy(css = ".bt-icon-label>.icon-function-favorite")
	private WebElement favoriteBtn;

	@FindBy(css = ".bt-icon-label>.icon-action-edit>use")
	private WebElement editIcon;
	
	@FindBy(css = ".bt-icon-label>.icon-action-edit+span")
	private WebElement editBtn;
	
	@FindBy(xpath = "//span[@class='form-select']//span[text()='Kitchen']")
	private WebElement roomTypeDefaultText;

	@FindBy(css = ".bt-icon-label>.icon-action-duplicate")
	private WebElement duplicateBtn;

	@FindBy(css = ".bt-icon-label>svg[class='icon-action-delete']+span")
	private WebElement deleteBtn;

	@FindBy(css = ".bt-icon-label>svg[class='icon-action-delete']>use")
	private WebElement deleteIcon;
	
	@FindBy(css = "button>svg[class='icon-action-split']+span")
	private WebElement splitBtn;
	
	@FindBy(css = "button>svg[class='icon-action-split']>use")
	private WebElement splitIcon;

	@FindBy(css = "[data-ui-action='product-replace']")
	private WebElement replaceBtn;

	@FindBy(css = "[data-ui-action='product-info']>.icon-action-info")
	private WebElement productInfoIcon;

	@FindBy(css = "li>button>.icon-action-ungroup")
	private WebElement ungroupBtn;

	@FindBy(xpath =  "//span[@data-ui-selector='notification-text']")
	private WebElement ungroupSuccessMsg;

	@FindBy(css = ".bt-icon-label[title='Position']")
	private WebElement positionBtn;

	@FindBy(css = "header>ul>li>.bt-icon-alt")
	private WebElement closeEditProperties;

	@FindBy(css = "#design-mod-properties-window-wide>ul>li>ul>li>button")
	private List<WebElement> bubbleCommandlist;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='add-room']/button[@class='bt-text']")
	private WebElement addRoom;

	@FindBy(css = "[data-ui-id='project-title']")
	private WebElement projectTitleHeader;

	//from bryo
	@FindBy(css = "#sketcher-mod-properties-window-regular>ul")
	private List<WebElement> balloon;

	@FindBy(css =  "[data-ui-selector='notification-text']")
	private WebElement noSlopedCeilingMsg;

	@FindBy(css =  "[data-ui-action='notif-link-click']")
	private WebElement addSlopedCeilingMsg;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(css = ".manip-rotate>.rotate-handle>svg")
	private WebElement rotateTooltip;

	@FindBy(css = ".manip-manager>.manip-translate>svg")
	private WebElement translateTooltip;

	@FindBy(css = "[class='manip-elevate secondary']")
	private WebElement elevateTooltip;

	@FindBy(css = "div#nav-overlay-take-picture ul.subsubcat>li>button")
	private List<WebElement> HQRenderOptions;



//	public HomePlanner initialPlan() {
//		UtilHBM.waitExplicitClickable(driver, initialPlan);
//		WebElement icon = initialPlan.findElement(By.cssSelector("svg>use"));
//		Verification.displayNAttributeCheckOfElement(initialPlan, "Initiate plan command", "text", "Initiate Plan");
//		Verification.displayNAttributeCheckOfElement(icon, "Initiate plan command icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-change-room");
//		initialPlan.click();
//		return PageFactory.initElements(driver, HomePlanner.class);
//	}

	public LevelManager manageLevel() {
		UtilHBM.waitExplicitClickable(driver, manageLevels);
		manageLevels.click();
		return PageFactory.initElements(driver, LevelManager.class);
	}

	public UploadTwoDPlan uploadTwoDPlan() {
		UtilHBM.waitExplicitClickable(driver, uploadTwoDPlan);
		uploadTwoDPlan.click();
		return PageFactory.initElements(driver, UploadTwoDPlan.class);
	}

	public DraftSightEmbed homeByMeProject() {
		UtilHBM.waitExplicitClickable(driver, useHomeByMeProject);
		useHomeByMeProject.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("div>#embedded-app-frame")));
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

	public HomePlanner floorPlan() {
		UtilHBM.waitExplicitClickable(driver, floorPlanButton);
		Verification.displayNAttributeCheckOfElement(floorPlanButton, "Draw plan command", "text", "Floor plan");
		Verification.displayNAttributeCheckOfElement(floorPlanIcon, "Draw Plan icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-change-room");
		floorPlanButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public DrawPlan addRoom() {
		UtilHBM.waitExplicitClickable(driver, addRoom);
		Verification.displayNAttributeCheckOfElement(addRoom, "Add a room link text", "text", "Add a room");
		addRoom.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan addWall() {
		UtilHBM.waitExplicitClickable(driver, addWall);
		Verification.displayNAttributeCheckOfElement(addWall, "Add a wall link text", "text", "Add a wall");
		addWall.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public RoomSeparator addSeparation() {
		UtilHBM.waitExplicitClickable(driver, addRoomSeparator);
		Verification.displayNAttributeCheckOfElement(addRoomSeparator, "Add room separator link text", "text", "Add a separation");
		addRoomSeparator.click();
		return PageFactory.initElements(driver, RoomSeparator.class);
	}

	public SlopedCeiling manageSlopedCeiling() {
		UtilHBM.waitExplicitClickable(driver, manageSlopedCeilings);
		Verification.displayNAttributeCheckOfElement(manageSlopedCeilings, "Manage sloped ceiling link text", "text", "Manage sloped ceilings");
		manageSlopedCeilings.click();
		UtilHBM.waitExplicitDisplayed(driver, validateButton);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public HomePlanner build() {
		UtilHBM.waitExplicitClickable(driver, build);
		WebElement icon = build.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(build, "Build command", "text", "Build");
		Verification.displayNAttributeCheckOfElement(icon, "Build command icon", "xlink:href", "./assets/icons/icons.svg#icon-action-opening");
		build.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public SlopedCeiling addRoofWindow() {

		Verification.VerifyEquals("msg not displayed", "You cannot add a roof window without a sloped ceiling.", "You cannot add a roof window without a sloped ceiling.");
		Verification.VerifyEquals("msg not displayed", "Add a sloped ceiling", "Add a sloped ceiling");
		addSlopedCeilingMsg.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SlopedCeiling.class);
	}

	public HomePlanner furnish() {
		UtilHBM.waitExplicitClickable(driver, furnish);
		WebElement icon = furnish.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(furnish, "Furnish command", "text", "Furnish");
		Verification.displayNAttributeCheckOfElement(icon, "Furnish command icon", "xlink:href", "./assets/icons/icons.svg#icon-hr-catalog-furnish");
		furnish.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}


	public HomePlanner decorate() {
		UtilHBM.waitExplicitClickable(driver, decorate);
		WebElement icon = decorate.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(decorate, "Decorate command", "text", "Decorate");
		Verification.displayNAttributeCheckOfElement(icon, "Decorate command icon", "xlink:href", "./assets/icons/icons.svg#icon-catalog-coverings");
		decorate.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public Favorites clickOnFavorites() {
		UtilHBM.waitExplicitClickable(driver, favorites);
		WebElement icon = favorites.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "Favorites command icon", "xlink:href", "assets/icons/icons.svg#icon-function-favorite");
		favorites.click();

		return PageFactory.initElements(driver, Favorites.class);//return different
	}



	public HomePlanner takePicture() {
		UtilHBM.waitExplicitClickable(driver, takePicture);
		WebElement icon = takePicture.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(takePicture, "Take a picture command", "text", "Take a picture");
		Verification.displayNAttributeCheckOfElement(icon, "Take a picture command icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-picture");
		takePicture.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different

	}

	public MediaPopUp myMedia() {
		UtilHBM.waitExplicitClickable(driver, myMedia);
		myMedia.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/embed.html']"));

		return PageFactory.initElements(driver, MediaPopUp.class);//return will be different
	}

	public HomePlanner screenshot() {
		UtilHBM.waitExplicitClickable(driver, takeScreenshot);
		takeScreenshot.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public HomePlanner generateScreenshot() {
		UtilHBM.waitExplicitClickable(driver, generateScreenshot);
		WebElement icon = takePicture.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(generateScreenshot, "Generate screenshot command", "text", "Generate a screenshot");
		Verification.displayNAttributeCheckOfElement(icon, "Generate screenshot command icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-picture");
		generateScreenshotClick.click();
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.displayNAttributeCheckOfElement(notificationText, "generate screenshot msg", "text", "Your new screenshot is available");

		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}
	
	public MediaPopUp viewScreenshot() {
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.displayNAttributeCheckOfElement(notificationText, "generate screenshot msg", "text", "Your new screenshot is available");
		UtilHBM.waitExplicitDisplayed(driver, viewButton);
		viewButton.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/embed.html']"));
		
		return PageFactory.initElements(driver, MediaPopUp.class);//return will be different
	}

	public HomePlanner closeScreenshot() {
//		UtilHBM.waitExplicitClickable(driver, takeScreenshot);
		WebElement icon = closeScreenshot.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "Close screenshot command icon", "xlink:href", "./assets/icons/icons.svg#icon-view-close");
		closeScreenshot.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public Image realisticImage() {
		UtilHBM.waitExplicitClickable(driver, takeRealistic);
		takeRealistic.click();
		return PageFactory.initElements(driver, Image.class);//return will be different
	}

	public Image take360Image() {
		UtilHBM.waitExplicitClickable(driver, take360);
		take360.click();
		return PageFactory.initElements(driver, Image.class);//return will be different
	}

	public HomePlanner projectName() {
		Verification.displayOfWebElement(logo);
		UtilHBM.waitExplicitClickable(driver, projectName);
		projectName.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public HomePlanner moreInfo() {
		UtilHBM.waitExplicitClickable(driver, moreInfo);
		moreInfo.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public Measure measure() {
		UtilHBM.waitExplicitClickable(driver, measure);
		measure.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("[data-ui-action='command-validate']")));
		return PageFactory.initElements(driver, Measure.class);
	}

	public DraftSightEmbed export() {
		UtilHBM.waitExplicitClickable(driver, export);
		export.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[id='layer-iframe']")));
		return PageFactory.initElements(driver, DraftSightEmbed.class);//return will be different
	}

	@FindBy(css = ".bt-icon>.icon-action-print")
	private WebElement printIcon;

	@FindBy(css = "[data-i18n='common.print']")
	private WebElement printText;

	public Print printInPlanner() {

        UtilHBM.waitExplicitClickable(driver, printIcon);
        WebElement icon = printIcon.findElement(By.cssSelector("svg>use"));
        Verification.displayNAttributeCheckOfElement(printText, "Print Text", "text", "Print");
        Verification.displayNAttributeCheckOfElement(icon, "Print icon", "xlink:href", "assets/icons/icons.svg#icon-action-print");
        print.click();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[id='layer-iframe']>iframe")));
        UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "[data-i18n='print.print_title']"));
        return PageFactory.initElements(driver, Print.class);//return will be different
    }

    public HomePlanner undo() {
        UtilHBM.waitExplicitClickable(driver, undo);
        undo.click();
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner undo(int count) {
        for (int counter = 0; counter < count; counter++) {
            UtilHBM.waitExplicitClickable(driver, undo);
            undo.click();
            UtilHBM.waitFixTime(500);
        }
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner redo() {
        UtilHBM.waitExplicitClickable(driver, redo);
        redo.click();
        return PageFactory.initElements(driver, HomePlanner.class);
    }


	public ProjectOverview close() {
		UtilHBM.waitExplicitClickable(driver, close);
		close.click();
		UtilHBM.waitFixTime(500);
		driver.switchTo().defaultContent();
		return PageFactory.initElements(driver, ProjectOverview.class);
	}

	public LandingPageHR close2() {
		UtilHBM.waitExplicitClickable(driver, close);
		close.click();
		UtilHBM.waitFixTime(500);
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, LandingPageHR.class);
	}

	public HomePlanner price() {
		UtilHBM.waitExplicitClickable(driver, price);
		price.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public MediaPopUp projectOverview() {
		UtilHBM.waitExplicitClickable(driver, projectOverview);
		projectOverview.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/embed.html']"));

		return PageFactory.initElements(driver, MediaPopUp.class);//return will be different
	}

	public HomePlanner cart() {
		UtilHBM.waitExplicitClickable(driver, cart);
		cart.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return will be different
	}

	public HomePlanner help() {
		UtilHBM.waitExplicitClickable(driver, help);
		help.click();
		return PageFactory.initElements(driver, HomePlanner.class);//return?
	}

	public HomePlanner zoomIn(int noOfSteps) {
		UtilHBM.waitExplicitDisplayed(driver, "//button/span[@class='icon-action-zoom']");
		UtilHBM.waitExplicitClickable(driver, zoomIn);
		for(int i=0; i<noOfSteps; i++){
			zoomIn.click();
			UtilHBM.waitFixTime(1000);
		}		
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner zoomOut(int noOfSteps) {
		UtilHBM.waitExplicitDisplayed(driver, "//button/span[@class='icon-action-unzoom']");
		UtilHBM.waitExplicitClickable(driver, zoomOut);
		for(int i=0; i<noOfSteps; i++){
			zoomOut.click();
			UtilHBM.waitFixTime(1000);
		}		
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner canvasCenter() {
		UtilHBM.waitExplicitDisplayed(driver, canvasCenter);
		canvasCenter.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner levelSelector(String visibleText) {
		UtilHBM.waitExplicitClickable(driver, levelSelector.findElement(By.cssSelector("option[selected]")));
		new Select(levelSelector).selectByVisibleText(visibleText);
		UtilHBM.waitFixTime(1000);
//		UtilHBM.webElement(driver, "[id='canvas-level-selector']>span>select>[value='"+value+"']").click();
		//verify text
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public LevelManager levelToLevelManager() {
		UtilHBM.waitExplicitDisplayed(driver, levelSelector.findElement(By.cssSelector("option[selected]")));
		new Select(levelSelector).selectByVisibleText("Manage levels");
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, LevelManager.class);
	}

	public HomePlanner viewModeOptions() {
		UtilHBM.waitExplicitClickable(driver, viewModeOptionsBtn);
		viewModeOptionsBtn.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner cameraHeight(String value) {
		UtilHBM.waitExplicitDisplayed(driver, cameraHeightValue.findElement(By.cssSelector("option[selected]")));
		new Select(cameraHeightValue).selectByVisibleText(value);
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner displayRoomName() {
		UtilHBM.waitExplicitDisplayed(driver, displayRoomNames);
		UtilHBM.turnOffImplicitWaits(driver);
		int noOfRoomTags = roomTagList.size();
		System.out.println("no of rooms: " + noOfRoomTags);
		UtilHBM.reportInfo("Before: "+ displayRoomNames.findElement(By.tagName("input")).getAttribute("value"));
		displayRoomNames.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.reportInfo(displayRoomNames.findElement(By.tagName("input")).getAttribute("value"));
		if(noOfRoomTags!=roomTagList.size()){
			UtilHBM.reportOK("Room name display status changed");
			UtilHBM.reportOK("No of room tag before toggle switch: "+ noOfRoomTags + " No of room tag after toggle switch: "+roomTagList.size());
		}else{
			UtilHBM.reportKO("Room name display status not changed after click on Display Room Name toggle");
			UtilHBM.reportKO("No of room tag before toggle switch: "+ noOfRoomTags + " No of room tag after toggle switch: "+roomTagList.size());
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner verifyNoOfRoomTag(int noOfRooms){
		if(roomTagList.size()==noOfRooms){
			UtilHBM.reportOK("Number of Room tags verified");
		}else{
			UtilHBM.reportKO("Number of Room tags verification failed. Expected value: " + noOfRooms + ", actual value: " + roomTagList.size() );
		}

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner displayRoomArea() {
		UtilHBM.waitExplicitClickable(driver, displayRoomAreas);
		displayRoomAreas.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner viewTwoD() {
		UtilHBM.waitExplicitClickable(driver, viewTwoD);
		viewTwoD.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner viewThreeD() {
		UtilHBM.waitExplicitClickable(driver, viewThreeD);
		viewThreeD.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner firstPersonView() {
		UtilHBM.waitExplicitClickable(driver, firstPersonView);
		firstPersonView.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner save() {
		UtilHBM.waitExplicitClickable(driver, save);
		save.click();
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.verifyText(notificationText, "Project has been saved successfully!", "Save notification");
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner saveProject() {
		save();
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.displayNAttributeCheckOfElement(notificationText, "Save msg", "text", "Project has been saved successfully!");
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, HomePlanner.class);
		}

	public HomePlanner saveProjectDetail(String projectName, String projectDescription ) {
//		save();
		UtilHBM.waitExplicitClickable(driver, save);
		save.click();
		SaveProject prjDetails = PageFactory.initElements(driver, SaveProject.class);
		prjDetails.saveProject(projectName, projectDescription);
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.displayNAttributeCheckOfElement(notificationText, "Save msg", "text", "Project has been saved successfully!");

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner saveDetailWithoutLogin(String projectName, String projectDescription ) {
		SaveProject prjDetails = PageFactory.initElements(driver, SaveProject.class);
		prjDetails.saveProject(projectName, projectDescription);
		UtilHBM.waitExplicitDisplayed(driver, saveloader);
		UtilHBM.waitExplicitDisplayed(driver, notificationText);		
		Verification.displayNAttributeCheckOfElement(notificationText, "Save msg", "text", "Project has been saved successfully!");
		UtilHBM.waitTillElementDisappear(driver, saveloader);
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public Login saveProjectWithoutLogin() {
		save.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, Login.class);

	}

	public HomePlanner catelogCategory(String category) {
		UtilHBM.webElementXPath(driver, "//li/button[@id='"+category+"']").click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//header/div/ul/li/button[@data-ui-current='Bedroom']"));
		return PageFactory.initElements(driver, HomePlanner.class);//return?

	}


	public Catalog catelogSubCategory(String subCategory) {

		UtilHBM.webElementXPath(driver, "//li[@data-ui-subsubcat='"+subCategory+"']/button").click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//div/div/ul/li[@data-ui-id='0']/article/div[@class='text']"));
		return PageFactory.initElements(driver, Catalog.class);

	}


    public Catalog search(String searchProduct) {
        WebElement icon = search.findElement(By.cssSelector("svg>use"));
        Verification.displayNAttributeCheckOfElement(search, "Search command", "text", "Search");
        Verification.displayNAttributeCheckOfElement(icon, "Search command icon", "xlink:href", "./assets/icons/icons.svg#icon-action-search");
        search.click();
        Catalog catalog = PageFactory.initElements(driver, Catalog.class);
        catalog.searchProduct(searchProduct);
        return PageFactory.initElements(driver, Catalog.class);//return will be different
    }

    @FindBy(css = "[data-ui-container='nameAndDescription']>.name")
    private WebElement productName;

    public HomePlanner productNameVerify(int xOffset, int yOffset, String nameOfProduct) {

        clickObjTillPropertiesAppear(xOffset, yOffset);
        Verification.VerifyEquals("productName verification failed...",productName.getText().split("\n")[0].trim(), nameOfProduct);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner editFurniture(int xOffset, int yOffset, String depth, String width, String height) {

        clickObjTillPropertiesAppear(xOffset, yOffset);
        editBtn.click();
        EditProperties edit = PageFactory.initElements(driver, EditProperties.class);
        edit.editFurniture(depth, width, height);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner editBuild(int xOffset, int yOffset, String depth, String width, String height) {

        clickObjTillPropertiesAppear(xOffset, yOffset);
        editBtn.click();
        EditProperties edit = PageFactory.initElements(driver, EditProperties.class);
        edit.editBuild(depth, width, height);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner editWall(int xOffset, int yOffset, String thickness, String height) {

        clickObjTillPropertiesAppear(xOffset, yOffset);
        editBtn.click();
        EditProperties edit = PageFactory.initElements(driver, EditProperties.class);
        edit.editWall(thickness, height);
        closeEditProperties.click();
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner splitWall(){

        UtilHBM.waitExplicitClickable(driver, splitBtn);
        Verification.displayNAttributeCheckOfElement(splitBtn, "Split command", "text", "Split");
        Verification.displayNAttributeCheckOfElement(splitIcon, "Split icon", "xlink:href", "./assets/icons/icons.svg#icon-action-split");
        splitBtn.click();
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner duplicateProd(){
        UtilHBM.waitExplicitDisplayed(driver, duplicateBtn);
        WebElement icon = duplicateBtn.findElement(By.cssSelector("svg>use"));
        //Verification.displayNAttributeCheckOfElement(duplicateBtn, "Duplicate command", "text", "Duplicate");
        Verification.displayNAttributeCheckOfElement(icon, "Duplicate icon", "xlink:href", "./assets/icons/icons.svg#icon-action-duplicate");
        Verification.displayNAttributeCheckOfElement(driver.findElement(By.xpath("//span[text()='Duplicate']")), "Duplicate command", "text", "Duplicate");
        duplicateBtn.click();
        UtilHBM.waitFixTime(1000);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner deleteProd(){

        UtilHBM.waitExplicitDisplayed(driver, deleteBtn);
//        Verification.displayNAttributeCheckOfElement(deleteBtn.findElement(By.xpath("./following-sibling::span")), "Delete command", "text", "Delete");
        Verification.displayNAttributeCheckOfElement(deleteBtn, "Delete command", "text", "Delete");
        Verification.displayNAttributeCheckOfElement(deleteIcon, "Delete icon", "xlink:href", "./assets/icons/icons.svg#icon-action-delete");
        deleteBtn.click();
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public Catalog replaceProd(){

        UtilHBM.waitExplicitDisplayed(driver, replaceBtn);

        Verification.displayNAttributeCheckOfElement(replaceBtn, "Replace command", "text", "Replace");
        replaceBtn.click();
        UtilHBM.waitFixTime(1000);
        return PageFactory.initElements(driver, Catalog.class);
    }


	public ProductSheet productInfo(){
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, productInfoIcon);
		WebElement icon = productInfoIcon.findElement(By.cssSelector("svg>use"));
		//Verification.displayNAttributeCheckOfElement(positionBtn, "Position command", "text", "Position");
		Verification.displayNAttributeCheckOfElement(icon, "Position icon", "xlink:href", "./assets/icons/icons.svg#icon-action-info");
		productInfoIcon.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProductSheetView/embed.html']"));

		return PageFactory.initElements(driver, ProductSheet.class);
	}

	public HomePlanner position(){

		UtilHBM.waitExplicitClickable(driver, positionBtn);
		WebElement icon = positionBtn.findElement(By.cssSelector("svg>use"));
		//Verification.displayNAttributeCheckOfElement(positionBtn, "Position command", "text", "Position");
		Verification.displayNAttributeCheckOfElement(icon, "Position icon", "xlink:href", "./assets/icons/icons.svg#icon-action-position");
		Verification.displayNAttributeCheckOfElement(positionBtn, "Position command", "text", "Position");
		positionBtn.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner ungroupProd(){

		UtilHBM.waitExplicitClickable(driver, ungroupBtn);
		WebElement icon = ungroupBtn.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "Ungroup icon", "xlink:href", "./assets/icons/icons.svg#icon-action-ungroup");
		//Verification.displayNAttributeCheckOfElement(ungroupBtn, "Ungroup command", "text", "Ungroup");
		Verification.displayNAttributeCheckOfElement(driver.findElement(By.xpath("//span[text()='Ungroup']")), "Ungroup command", "text", "Ungroup");

		ungroupBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, ungroupSuccessMsg);
		Verification.displayNAttributeCheckOfElement(ungroupSuccessMsg, "Save msg", "text", "Your set has been ungrouped successfully!");

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-maximize")
	private WebElement maximizeCatalog;

	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-minimize")
	private WebElement minimizeCatalog;

	@FindBy(css="#catalog-browser>#header-filter>.actions>.close>button")
	private WebElement closeCatalogButton;

	public HomePlanner maximizePanel(){
		//UtilHBM.waitFixTime(1000);
		maximizeCatalog.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner minimizePanel(){
		minimizeCatalog.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner closeFavPanel(){
		closeCatalogButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner closeEditPanel(){
		//UtilHBM.waitFixTime(1000);

		closeEditProperties.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}



	public EditProperties editProperties(int xOffset, int yOffset) {
		clickObjTillPropertiesAppear(xOffset, yOffset);
		editBtn.click();
		return PageFactory.initElements(driver, EditProperties.class);
	}

	public HomePlanner editRoom(int value, String defaulRoomName) {

		UtilHBM.waitExplicitDisplayed(driver, editBtn);
		editBtn.click();
		Verification.displayNAttributeCheckOfElement(UtilHBM.webElement(driver, ".mod-measure-input>input"), "Name", "value", defaulRoomName);
		
		//add verification
		//Verification.verifyText(roomTypeDefaultText, "Room", "Default room type");
		WebElement typeValue = driver.findElement(By.xpath("//span[@class='form-select']/select/option[@value='"+value+"']"));
		typeValue.click();
		Verification.verifyText(typeValue, "Boiler room", "Changed room type");
		Verification.verifyText(UtilHBM.webElement(driver, ".panel-form>.legend"), "Properties", "Properties");
		Verification.verifyText(UtilHBM.webElement(driver, "[data-i18n='room_properties_panel.name_label']"), "Name", "Name");
		Verification.verifyText(UtilHBM.webElement(driver, "[data-i18n='room_properties_panel.type_label']"), "Type", "Type");
		Verification.displayNAttributeCheckOfElement(UtilHBM.webElement(driver, ".mod-measure-input>input"), "Name", "value", "Boiler room");
		return PageFactory.initElements(driver, HomePlanner.class);
	}


	public HomePlanner editTwoDWallDimensionDev(int xTarget, int yTarget, String oldValue, String newvalue, String applyToLeftRightAboveBelow){
		clickObjTillPropertiesAppear(xTarget, yTarget);
		UtilHBM.waitFixTime(500);
		WallPropertiesTwoD properties = PageFactory.initElements(driver, WallPropertiesTwoD.class);
		properties.twoWallDimensions(oldValue, newvalue, applyToLeftRightAboveBelow);
		clickBlankTillPropertiesDisappear();
		return this;
	}

	public HomePlanner clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner hoverInPlanner(int xOffset, int yOffset){
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).pause(2000).build().perform();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	private HomePlanner clickBlankSpace(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).click().build().perform();
		new Actions(driver).moveToElement(container3D, container3D.getRect().getWidth()/2-10, 10-container3D.getRect().getHeight()/2).clickAndHold().pause(500).release().build().perform();
//		new Actions(driver).moveToElement(container3D, 10, 10).click().build().perform();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	protected ThreeDPlanner hoverBlankSpaceDev(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).build().perform();//
		new Actions(driver).moveToElement(container3D, 20-container3D.getRect().getWidth()/2, 10-container3D.getRect().getHeight()/2).pause(2000).build().perform();
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	private void clickObjTillPropertiesAppear(int xOffset, int yOffset){
		UtilHBM.turnOffImplicitWaits(driver);
		int i=0;
		do{
			clickBlankSpace();
			clickInPlanner(xOffset, yOffset);
			i++;
		}while(!(bubbleCommandlist.size()>0)&&i<20);
		UtilHBM.turnOnImplicitWaits(driver);
	}

	private void clickBlankTillPropertiesDisappear(){
		UtilHBM.turnOffImplicitWaits(driver);
		int i=0;
		do{
			clickBlankSpace();
			i++;
		}while((bubbleCommandlist.size()>0)&&i<20);
		UtilHBM.turnOnImplicitWaits(driver);
	}

	public HomePlanner verifyProjectName(String projectNameExpected){
		UtilHBM.waitFixTime(5000);
		UtilHBM.waitExplicitDisplayed(driver, projectTitleHeader);
		Verification.VerifyEquals("Project Title KO", projectTitleHeader.getText(), projectNameExpected.toUpperCase());
		return PageFactory.initElements(driver, HomePlanner.class);
	}


//	public HomePlanner verifyNewProjectName(String projectNameExpected){
//		
//		UtilHBM.waitExplicitDisplayed(driver, projectTitleHeader);
//		Verification.VerifyEquals("Project Title KO", projectTitleHeader.getText(), projectNameExpected.toUpperCase());
//		return PageFactory.initElements(driver, HomePlanner.class);
//	}

	// reference ByroDemoScenario > FloorPlan > Move wall

//		public HomePlanner clickBlank() {
//			UtilHBM.turnOffImplicitWaits(driver);
//			int j = 0;
//			while (balloon.size() > 0 && j < 10) {
//				// UtilHBM.clickBlankSpaceIkea();
//				Actions action = new Actions(driver);
//				action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
//				j++;
//			}
//
//			UtilHBM.turnOnImplicitWaits(driver);
//			return this;
//		}

		public HomePlanner moveWall(int x, int y, int x1, int y1) {
			//clickBlank();
			clickBlankSpace();
			UtilHBM.waitFixTime(2000);
			Actions action = new Actions(driver);
//			action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
			action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
					.pause(1000).release().build().perform();
			//clickBlank();
			clickBlankSpace();
			return this;
		}

		public HomePlanner rotatePlan(int steps, String letfRightUpDown) {
			UtilHBM.hitArrowKeyDev(driver, steps, letfRightUpDown);
			return this;
		}

		public HomePlanner translateProduct(int x, int y, int x1, int y1) {
			//clickBlank();
			//clickBlankSpace();
			clickObjTillPropertiesAppear(x, y);
			UtilHBM.waitFixTime(2000);
			Actions action = new Actions(driver);
//			action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
//			action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
//					.pause(1000).release().build().perform();

        action.dragAndDropBy(translateTooltip, x1, y1)
                .pause(1000).release().build().perform();


        //clickBlank();
        clickBlankTillPropertiesDisappear();
        return this;
    }

    @FindBy(css = ".manip-rotate>svg>circle.progress-value")
    private WebElement circle;

    public HomePlanner rotateTooltip(int x, int y, int xOffset, int yOffset) {

        clickObjTillPropertiesAppear(x, y);
        UtilHBM.waitFixTime(2000);
        Actions action = new Actions(driver);
        action.moveToElement(circle, xOffset, yOffset);//.pause(1000).release().build().perform();
        //action.dragAndDropBy(rotateTooltip, xOffset, yOffset);//.pause(1000).release().build().perform();
        clickBlankTillPropertiesDisappear();
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner elevateTooltip(int x, int y){

        Actions action = new Actions(driver);
        action.click(elevateTooltip).clickAndHold().pause(1000).dragAndDropBy(elevateTooltip, x, y).pause(1000).release().build().perform();
        ;
        return PageFactory.initElements(driver, HomePlanner.class);
    }


    public HomePlanner selectMultipleProducts(String productOffsets) {
        clickBlankSpace();
        UtilHBM.waitFixTime(1000);
        multipleSelect(productOffsets.split("\\s*>\\s*"));
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    private HomePlanner multipleSelect(String[] productOffsets) {
        new Actions(driver).keyDown(Keys.CONTROL).perform();
        for (String a : productOffsets) {
            System.out.println("a: " + Integer.parseInt(a.split(",")[0].trim()));
            System.out.println("b: " + Integer.parseInt(a.split(",")[1].trim()));
            hoverInPlanner(Integer.parseInt(a.split(",")[0].trim()), Integer.parseInt(a.split(",")[1].trim()));
            clickInPlanner(Integer.parseInt(a.split(",")[0].trim()), Integer.parseInt(a.split(",")[1].trim()));
            UtilHBM.waitFixTime(500);
        }
        new Actions(driver).keyUp(Keys.CONTROL).perform();
        UtilHBM.waitFixTime(1000);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner verifyProductIsSelected(int x, int y, boolean isPrdtSelected, String product) {
        clickBlankSpace();
        UtilHBM.waitFixTime(1000);
        Actions action = new Actions(driver);
        action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
        verifyProductIsSelected(isPrdtSelected, product);
        return PageFactory.initElements(driver, HomePlanner.class);
    }

    public HomePlanner verifyProductIsSelected(boolean isPrdtSelected, String productName) {

        if (isPrdtSelected) {
            UtilHBM.waitExplicitDisplayed(driver,
                    driver.findElement(By.cssSelector("#design-mod-properties-window-wide")));
            WebElement productNm = driver
                    .findElement(By.cssSelector("#design-mod-properties-window-wide>div>h3[class='name']"));
            if (productNm.getText().split("\n")[0].trim().equalsIgnoreCase(productName)) {
                UtilHBM.reportOK("Item " + productNm.getText() + " is selected");
            } else
                Assert.fail("product " + productName + " is not selected");
        } else {
            UtilHBM.turnOffImplicitWaits(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#design-mod-properties-window-wide"))));
                WebElement productNm = driver
                        .findElement(By.cssSelector("#design-mod-properties-window-wide>div>h3[class='name']"));
                if (productNm.getText().split("\n")[0].trim().equalsIgnoreCase(productName)) {
                    Assert.fail("product " + productName + " is selected");
                } else {
                    UtilHBM.reportOK("Different item  " + (productNm.getText().split("\n\r")[0].trim() + " is selected"));
                }
            } catch (NoSuchElementException | TimeoutException e) {
                UtilHBM.reportOK("Item " + productName + " is not selected");
            }
            UtilHBM.turnOnImplicitWaits(driver);
        }

        return PageFactory.initElements(driver, HomePlanner.class);
    }


	public HomePlanner verifyHQRenderingOptionsAvailable(String... expectedHQRenderingOptions) {
		List<String> expectedOptions = new ArrayList<>(Arrays.asList(expectedHQRenderingOptions));

		List<String> availableOptions= new ArrayList<>();
		for(WebElement opt:HQRenderOptions)availableOptions.add(opt.getText().trim());

		List<String> commonOpts=new ArrayList<>(expectedOptions);
		commonOpts.retainAll(availableOptions);

		expectedOptions.removeAll(commonOpts);
		Assert.assertTrue(expectedOptions.size()>0,"Following hQRender options not available : "+expectedOptions);

		availableOptions.removeAll(commonOpts);
		Assert.assertTrue(availableOptions.size()>0,"Following hQRender options not expected : "+availableOptions);

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public LandingPageHR refreshApplication() {
		try {
			driver.navigate().refresh();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();
			driver.switchTo().parentFrame();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, LandingPageHR.class);
	}
}
