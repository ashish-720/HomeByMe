package kitchen.bryo.pageObject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.Favorites;

import static org.testng.Assert.assertNotEquals;

import java.nio.charset.StandardCharsets;
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

public class MakeItYours {
	WebDriver driver;
	public static String projectNameVerification;
	public static String ruleCountVerification;

	public MakeItYours(WebDriver driver) {
		this.driver = driver;
	}

	// @FindBy(id = "customize-this-kitchen")
	// WebElement nextStep3;

	@FindBy(css = ".catalogSearchBar-form")
	private WebElement search;

	@FindBy(id = "cabinets")
	private WebElement cabinet;

	// @FindBy(css = "#design-toolbox-catalogs>li>li>#catalog-cabinet")
	// WebElement cabinetCatalog;

	@FindBy(id = "appliances")
	private WebElement appliances;

	@FindBy(id = "dining")
	private WebElement dining;

	@FindBy(id = "accessories")
	private WebElement accessories;

	@FindBy(id = "total-price-step-3")
	private WebElement totalPrice;

	@FindBy(css = "step-3-project-detail>p>b>.bt-icon")
	private WebElement priceInfo;

	@FindBy(css = ".vat")
	private WebElement vatIncluded;

	// @FindBy(css = "#step-3-project-detail>.cta-primary")
	// WebElement nextStepButton;

	@FindBy(css = "#show-help")
	private WebElement showHelpButton;

	@FindBy(css = "#design-catalog-browser>header>h2[class='title']")
	private WebElement catalogTitle;

	@FindBy(css = "#design-catalog-browser>header>ul>li>button>span[class='icon-view-maximize']")
	private WebElement maxMinCatalog;

	@FindBy(css = "button[data-ui-action='panel-close']")
	private List<WebElement> closeCatalog;

	@FindBy(css = "#mod-type-filterer>form>ul>li")
	private List<WebElement> filterCatalog;

	@FindBy(css = "button[data-ui-action='product-info']")
	private WebElement info;

	@FindBy(css = ".popin-header")
	private WebElement infoProductName;

	@FindBy(css = "ul>li>button>svg[class='icon-action-opening']")
	private WebElement opening;

	@FindBy(css = "ul>li>button>svg[class='icon-action-position']")
	private WebElement position;

	@FindBy(css = "input[data-ui-action='collision-toggle']")
	private WebElement allowCollision;

	@FindBy(css = "input[data-ui-action='rotate-model']")
	private WebElement preciseRotation;

	@FindBy(css = "ul>li>button>svg[class='icon-action-duplicate']")
	private WebElement duplicate;

	@FindBy(css = "ul>li>button>svg[class='icon-action-replace']")
	private WebElement replace;

	@FindBy(css = "button[id='replace']")
	private WebElement replaceExpiredProductButton;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement edit;

	@FindBy(xpath = "//button[@data-ui-action='delete']")
	private WebElement delete;

	@FindBy(css = "#design-edit-panel>header>ul>li[class='close']")
	private WebElement closeEditPanel;

	@FindBy(css = "#design-edit-panel>header>h2[class='title']")
	private WebElement title;

	@FindBy(css = "#design-edit-panel>header>p")
	private WebElement titleInfo;

	@FindBy(css = "button[data-ui-action='product-option-replace']")
	private List<WebElement> replaceProductOption;

	@FindBy(css = ".mod-product-list>li[class='item-edit']>div>p>span[class='name']")
	private List<WebElement> itemEdit;

	@FindBy(css = ".mod-product-list>li[class='item-edit']>div>p>span[class='desc']")
	private List<WebElement> itemDesc;

	@FindBy(css = "li[data-ui-publicationid='handle']")
	private WebElement handle;

	@FindBy(css = ".info-mod-popin.mod-open>div>header")
	private WebElement infoHeader;

	@FindBy(css = ".info-mod-popin.mod-open>div>div>img")
	private WebElement infoImage;

	@FindBy(css = ".mod-popin-product-info.mod-open>div>header>div>.header-actions>button[data-ui-action='popin-close']>span")
	private WebElement infoClose;

	@FindBy(css = ".canvas-tools-help-tooltip")
	private WebElement clickAndDrag;

	@FindBy(css = "#design-mod-properties-window-wide>ul")
	private List<WebElement> balloon;

	@FindBy(id = "bt-icon-view-2d")
	private WebElement twoDView;

	@FindBy(id = "bt-icon-view-3d")
	private WebElement threeDView;

	@FindBy(id = "bt-icon-view-fp")
	private WebElement fpView;

	@FindBy(xpath = "//div[@class='mod-nav-overlay']/div/ul/li/ul[@class='subsubcat']/li/button[@class='bt-text']")
	private List<WebElement> subCatagoryList;

	@FindBy(xpath = "//button[@data-ui-publicationid='worktopOption'][@data-ui-action='product-option-more']")
	private WebElement worktopOptionButton;

	@FindBy(xpath = "//article[@class='mod-popin-product-info-large mod-open']/div/div/div/div[@class='text']")
	private WebElement productInfoTitle;

	@FindBy(css = ".add-area .actions")
	private WebElement addAreaMoreInfo;

	@FindBy(css = ".product-info>.left-col>img")
	private WebElement productImage;

	@FindBy(css = ".product-info>.right-col>.text")
	private WebElement infoDescription;

	@FindBy(id = "search")
	private WebElement searchButton;

	@FindBy(id = "catalogSearchBar-form-input")
	private WebElement searchInputBox;

	@FindBy(css = "#catalogSearchBar-form-button>span")
	private WebElement searchIcon;
	
	@FindBy(css = "#catalogSearchBar-empty-button>span>span")
	private WebElement emptySearchButton;
	
	@FindBy(xpath = "//article[@class='mod-panel-catalog-browser-search mod-open mod-panel-catalog-browser']/header/ul/li[@class='expand']/button/span")
	private WebElement searchExpand;
	
	@FindBy(xpath = "//article[@class='mod-panel-catalog-browser-search mod-open mod-panel-catalog-browser']/header/ul/li[@class='close']/button/span")
	private WebElement searchClose;
	
	@FindBy(css = "#design-catalog-browser>div p.message")
	private WebElement searchMsg;

	@FindBy(css = "button[data-ui-action='product-option-add-wall-panel']")
	private WebElement wallPanelAddButton;

	@FindBy(xpath = "//li[@data-ui-publicationid='wallPanelOption']/div/div/button[@data-ui-action='product-option-more']")
	private WebElement wallPanelOptionButton;

	@FindBy(xpath = "//article[@id='design-options-panel']/article/div/div/ul/li/div/div/button[@data-ui-action='wall-panel-editor']")
	private WebElement wallPanelEditor;

	@FindBy(css = "button[data-ui-action='product-option-customise']")
	private WebElement customizewallEdgeStrip;

	@FindBy(css = "#design-mod-properties-window-wide>.text")
	private WebElement product;

	@FindBy(xpath = "//article[@id='design-mod-properties-window-wide']/div/h3")
	private List<WebElement> productName;

	@FindBy(css = "#design-mod-properties-window-wide>.text>.desc")
	private List<WebElement> productDesc;

	@FindBy(css = "#design-mod-properties-window-wide>.text>.secondary-desc")
	private List<WebElement> productSecDesc;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement customiseEdit;

	@FindBy(css = "button[data-ui-action='launch-measure-tool']")
	private WebElement measureButton;

	@FindBy(css = "div.dg.main.a:not(div.dg.main.a[style*='display: none'])")
	private WebElement debugMenu;

	@FindBy(css = "div.dg.main.a:not(div.dg.main.a[style*='display: none'])>ul>li")
	private List<WebElement> debugFunctionName;
//
//	@FindBy(css = "li[class='cr function']")
//	private List<WebElement> subFunctionName;

	@FindBy(css = ".mod-popin-product-info.mod-open")
	private WebElement productInfoPopUp;

	@FindBy(id = "close-app")
	private WebElement closePlanner;

	@FindBy(css = ".unsaved-changes-alert-mod-popin.mod-open>div")
	private List<WebElement> unsavedProjectPopUp;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p[@class='project-title']/span[@id='project-title']")
	private WebElement projectTitle;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p[@class='project-title']/span[@class='project-info']/span[starts-with(@class,'price-container')]/span[starts-with(@class,'standard-price')]/span[@class='standard-price ']")
	private WebElement projectStandardPrice;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p[@class='project-title']/span[@class='project-info']/span/span[@class='reduced-price']")
	private List<WebElement> projectReducedPrice;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p[@class='project-title']/span[@class='project-info']/span/span[@class='membership-price']")
	private List<WebElement> projectMembershipPrice;

	@FindBy(css = "article[id='mod-help-center']>button[class='bt-icon opened']")
	private WebElement newNotificationHelpCenter;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//ul[@class='mod-options-list']/li")
	private List<WebElement> productPropertyList;

	@FindBy(xpath = "//div/ul/li/div/div/button[@data-ui-action='worktop-editor']")
	private WebElement worktopModifyButton;

	@FindBy(xpath = "//article/div/div/ul/li/div/div/button[@data-ui-action='wall-panel-editor']")
	private WebElement wallPanelModifyButton;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(xpath = "//button[@data-ui-action='save']")
	private WebElement saveIcon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private List<WebElement> loginWindow;

	@FindBy(xpath = "//li[@id='step-finalize']/button[@data-step='4']")
	private WebElement nextStep4;

	@FindBy(css = "#design-action-area>ul>li>button[data-ui-action='print']")
	private WebElement printButton;

	@FindBy(xpath = "//button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(css = "button[data-ui-action='product-list']")
	private WebElement productListIcon;

	@FindBy(xpath = "//input[@name='front-displayer']")
	private WebElement displayFrontToggle;

	@FindBy(css = "button[data-state='floorplan']")
	private WebElement floorplan;

	@FindBy(css = "button[data-state='autodesign']")
	private WebElement pickALayout;

	@FindBy(css = ".manip-translate")
	private WebElement translatePointer;

	@FindBy(css = ".manip-rotate .rotate-handle")
	private WebElement rotatePointer;

	@FindBy(xpath = "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(xpath = "//article[@class='mod-properties-window-wide mod-open mod-inserted']/div/h3[@class='name']")
	private WebElement customMaterialName;

	@FindBy(xpath = "//article[@class='mod-properties-window-wide mod-open mod-inserted']/div/p[@class='desc']")
	private WebElement customMaterialDesc;

	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-small mod-open']")
	private List<WebElement> unSavedPopUp;

	@FindBy(css = "p[data-notif-action='save']")
	private WebElement saveRibbon;

	@FindBy(xpath = "//button[@id='takeAPicture']")
	private WebElement createImage;

	@FindBy(xpath = "//ul/li[@data-ui-subsubcat='hqRendering']/button")
	private WebElement takeRealisticPictureButton;

	@FindBy(xpath = "//ul/li[@data-ui-subsubcat='panoramicRendering']/button")
	private WebElement create360ImageButton;

	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement saveUnsavedChanges;

	@FindBy(id = "project-title")
	private List<WebElement> savedProjectName;

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']")
	private List<WebElement> recoverPopUp;

	@FindBy(xpath = "//button[@aria-controls='extras-tab-2']")
	private WebElement inMyProjectButton;

	@FindBy(id = "worktop_dimension-width")
	private WebElement worktopDimensionWidth;

	@FindBy(id = "worktop_dimension-depth")
	private WebElement worktopDimensionDepth;

	@FindBy(id = "worktop_dimension-altitude")
	private WebElement worktopDimensionAltitude;

	@FindBy(id = "wallpanel_dimension-width")
	private WebElement wallpanelDimensionWidth;

	@FindBy(id = "wallpanel_dimension-height")
	private WebElement wallpanelDimensionHeight;

	@FindBy(id = "wallpanel_dimension-altitude")
	private WebElement wallpanelDimensionAltitude;
	
	@FindBy(id = "refresh_check_without_change")
	private WebElement refresh;

	@FindBy(xpath = "//li[@class='rules-group']/span")
	private List<WebElement> rulesGroup;

	@FindBy(id = "show-help")
	private WebElement helpButton;

	@FindBy(xpath = "//button[@data-ui-action='item-notes']")
	private WebElement itemNotes;

	@FindBy(css = "button[data-ui-action='item-notes']>span[class='counter'][style='display: block;']")
	private WebElement itemNotesCounter;

	@FindBy(css = "article[id='design-mod-properties-window-wide']>ul>li>ul>li>button[data-ui-action='empty']")
	private WebElement emptyButton;

	@FindBy(css = "article[id='design-mod-properties-window-wide']>div[data-ui-container='nameAndDescription']>h3")
	private WebElement roomName;

	@FindBy(css = "article[id='design-mod-properties-window-wide']>div[data-ui-container='nameAndDescription']>p")
	private WebElement roomSurface;

	@FindBy(css = ".manip-elevate.secondary")
	WebElement elevatePointer;

	@FindBy(xpath = "//li[@data-ui-publicationid='worktopOption']//span[@class='desc']")
	private WebElement worktopOptionMsg;

	@FindBy(css = "fieldset>p>span>#edit-form-input-depth")
	private WebElement depthInputBoxFurniture;
	
	@FindBy(css = "fieldset>p>span>select#edit-form-select-depth")
	private WebElement depthSelectionFurniture;

	@FindBy(css = "fieldset>p>span>#edit-form-input-width")
	private WebElement widthInputBoxFurniture;
	
	@FindBy(css = "fieldset>p>span>select#edit-form-select-width")
	private WebElement widthSelectionFurniture;

	@FindBy(css = "fieldset>p>span>#edit-form-input-height")
	private WebElement heightInputBoxFurniture;
	
	@FindBy(css = "fieldset>p>span>select#edit-form-select-height")
	private WebElement heightSelectionFurniture;

	@FindBy(css = "button[data-ui-action='ungroup']")
	private WebElement ungroupButton;

	@FindBy(css = "button[data-ui-action='product-replace']")
	private WebElement replaceButton;

	@FindBy(css = "li.item-edit-primary span[data-i18n='product_property_panel.replace.label']")
	private WebElement replaceProductText;

	@FindBy(css = "button[data-ui-action='product-multiple-replace']")
	private WebElement chooseButton;
	
	@FindBy(css="article[class='mod-popin-no-space-small mod-open']")
	private WebElement noSpacePopIn;
	
	@FindBy(css="article[class='mod-popin-no-space-small mod-open']>div>div>h1")
	private WebElement noSpaceTitle;
	
	@FindBy(xpath="//article[@class='mod-popin-no-space-small mod-open']/div/div/div[@class='text']/div/p")
	private WebElement noSpaceInfo;
	
	@FindBy(css="article[class='mod-popin-no-space-small mod-open']>div>footer>button[class='cta-primary-alt-xl']")
	private WebElement noSpaceOKButton;

	@FindBy(xpath = "//span[@class='membership-price-label'][contains(text(),'Member Price')]")
	private WebElement memberPriceLabel;

	@FindBy(xpath = "//span[@class='price-details'][contains(text(),'From 01/01/2019 to 01/01/2029 or while stock last ')]")
	private WebElement memberPriceDetails;

	@FindBy(xpath = "//span/following-sibling::b[@data-i18n='kitchen.help_center.design_ok;planner.help_center.design_ok']")
	private WebElement designErrFreeMsg;

	@FindBy(xpath = "//main[@role='main']/div/div/div/div/ul/li/button[@id='favorites']")
	private WebElement favorites;

	@FindBy(css = "article[class='mod-popin-invalid-measure-small mod-open']>div>div>h1")
	private WebElement areYouSure;

	@FindBy(css = "li[data-ui-publicationid='plinthOption'] button[data-ui-action='product-option-more']")
	private WebElement plinthOption;

	@FindBy(css = "input#back-plinth")
	private WebElement backPlinthToggle;

	@FindBy(css = "article[class='mod-popin-invalid-measure-small mod-open']>div>div>div[class='text']>div>p")
	private WebElement changeMeasurementDesc;

	@FindBy(css = "article[class='mod-popin-invalid-measure-small mod-open']>div>div>div[class='text']>p[class='question']")
	private WebElement changeMeasurementQuestion;

	@FindBy(xpath = "//article[@class='mod-popin-invalid-measure-small mod-open']/div/footer/button/span[contains(.,'No')]")
	private WebElement applyMeasurementNo;

	@FindBy(xpath = "//article[@class='mod-popin-invalid-measure-small mod-open']/div/footer/button/span[contains(.,'Yes')]")
	private WebElement applyMeasurementYes;

	@FindBy(xpath = "//li[@data-ui-publicationid='doubleSided']/fieldset/p/label[contains(text(),'Double Sided')]")
	private WebElement doubleSidedLabel;
	
	@FindBy(css = "li[data-ui-publicationid='doubleSided']>fieldset>p>span[data-ui-publicationid='doubleSided']")
	private WebElement doubleSidedToggle;
	
	@FindBy(xpath = "//p[@id='search-result-number']")
	private WebElement searchResults;

	@FindBy(xpath = "//button[@id='show-help']//span[@class='new-notifications']")
	private WebElement showHelpDesignNotification;
	
	@FindBy(xpath = "//section[@class='mod-bottom-sheet mod-expanded']/div[@class='bottom-sheet-content']/button[@class='bt-handle']")
	private WebElement mBottomSheetClose;

	@FindBy(xpath = "//section[@class='mod-bottom-sheet']/div[@class='bottom-sheet-content']/button[@class='bt-handle']")
	private WebElement mBottomSheetOpen;
	
	@FindBy(xpath = "//div[@id='step-3-project-detail']/button[@data-step='4']")
	private WebElement nextStep4Mobile;
	
	@FindBy(css = "button[data-ui-action='command-cancel']")
	private WebElement cancelRenderingLayer;
	
	@FindBy(xpath = "//button[@id='reset_view']")
	private WebElement resetView;

	//Mobile
	@FindBy(css = "section.mod-bottom-sheet.mod-expanded ul.tools")
	private WebElement bottomSheetTools;

	private static int initialCount;
	
	public PickALayout clickPickALayout() {
		UtilHBM.waitExplicitDisplayed(driver, pickALayout);
		UtilHBM.waitExplicitClickable(driver, pickALayout);
		pickALayout.click();
		return PageFactory.initElements(driver, PickALayout.class);
	}

	public FloorPlan clickFloorplan() {
		UtilHBM.waitExplicitDisplayed(driver, floorplan);
		UtilHBM.waitExplicitClickable(driver, floorplan);
		floorplan.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public MakeItYours deleteMultipleProducts(String deleteMultipleProductsInStep3) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.deleteMultipleProductsStep3(deleteMultipleProductsInStep3);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours selectMultipleProducts(String productOffsets) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.multipleSelect(productOffsets.split("\\s*>\\s*"));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours positionMultipleProducts(String positionMultipleProductsInStep3, String positionValueToChange,
			String pos1) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.positionMultipleProductsInStep3(positionMultipleProductsInStep3, positionValueToChange, pos1);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyPositionMultipleProducts(String verifyPositionMultipleProductsInStep3, String dim) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.verifyPositionMultipleProInStep3(verifyPositionMultipleProductsInStep3, dim);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours duplicateMultipleProducts(String duplicateMultipleProductsInStep3) {
		clickBlank();
		MultipleDelete del = PageFactory.initElements(driver, MultipleDelete.class);
		del.duplicateMultipleProductsStep3(duplicateMultipleProductsInStep3);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours realisticImage(int backgroundImage) {
		UtilHBM.waitExplicitDisplayed(driver, createImage);
		UtilHBM.waitExplicitClickable(driver, createImage);
		createImage.click();
		UtilHBM.waitExplicitDisplayed(driver, takeRealisticPictureButton);
		UtilHBM.waitExplicitClickable(driver, takeRealisticPictureButton);
		takeRealisticPictureButton.sendKeys(Keys.ENTER);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveUnsavedChanges();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImage(backgroundImage);

		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours realisticImage3DView() {
		UtilHBM.waitExplicitDisplayed(driver, createImage);
		UtilHBM.waitExplicitClickable(driver, createImage);
		createImage.click();
		UtilHBM.waitExplicitDisplayed(driver, takeRealisticPictureButton);
		UtilHBM.waitExplicitClickable(driver, takeRealisticPictureButton);
		takeRealisticPictureButton.sendKeys(Keys.ENTER);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveUnsavedChanges();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImageIn3DView();

		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours cancelRealisticImageLayer() {
		UtilHBM.waitExplicitDisplayed(driver, cancelRenderingLayer);
		UtilHBM.waitExplicitClickable(driver, cancelRenderingLayer);
		cancelRenderingLayer.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours realisticImage(int backgroundImage, SignUpData signUpData, String projName, String projDesc) {
		UtilHBM.waitExplicitDisplayed(driver, createImage);
		UtilHBM.waitExplicitClickable(driver, createImage);
		createImage.click();
		UtilHBM.waitExplicitDisplayed(driver, takeRealisticPictureButton);
		UtilHBM.waitExplicitClickable(driver, takeRealisticPictureButton);
		takeRealisticPictureButton.sendKeys(Keys.ENTER);

		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveUnsavedChanges();
		login(signUpData);
		save.saveProjectWothoutRibbonValidation(projName, projDesc);
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImage(backgroundImage);

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours realisticImageMultiple(String viewHeight, boolean showWallCut, int noOfImages) {
		UtilHBM.waitExplicitDisplayed(driver, createImage);
		UtilHBM.waitExplicitClickable(driver, createImage);
		createImage.click();
		UtilHBM.waitExplicitDisplayed(driver, takeRealisticPictureButton);
		UtilHBM.waitExplicitClickable(driver, takeRealisticPictureButton);
		takeRealisticPictureButton.sendKeys(Keys.ENTER);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveUnsavedChanges();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImageMultiple(viewHeight, showWallCut, noOfImages);
		UtilHBM.waitExplicitDisplayed(driver, nextStep4);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours panoramic360Image(int backgroundImage) {
		UtilHBM.waitExplicitDisplayed(driver, createImage);
		UtilHBM.waitExplicitClickable(driver, createImage);
		createImage.click();
		UtilHBM.waitExplicitDisplayed(driver, create360ImageButton);
		UtilHBM.waitExplicitClickable(driver, create360ImageButton);
		create360ImageButton.sendKeys(Keys.ENTER);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveUnsavedChanges();
		PanoramicRendering panoramic = PageFactory.initElements(driver, PanoramicRendering.class);
		panoramic.render360Image(backgroundImage);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyPrice(String price) {
//		if (!price.isEmpty()) {
//			UtilHBM.waitExplicitClickable(driver, productListIcon);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
//			WebElement currency = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'£')]"));
//			Verification.displayOfWebElement(p);
//			Verification.displayOfWebElement(currency);
//		}

//		*********************PRE-PROD****************************
		if (!price.isEmpty()) {
			UtilHBM.waitFixTime(4000);
//			UtilHBM.waitExplicitDisplayed(driver, vatIncluded);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
//			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
//					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "");
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");

			System.out.println("p1:" + p1.replaceAll("\\n", "") + "price:" + price);
			System.out.println("equals :" + p1.equalsIgnoreCase(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Step 3 : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 3 : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}

		}

//		************* To ADD FOR PRICE NOT AVAILABLE*************
//		else if(price.equalsIgnoreCase("Price is not available")) {
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price calculating'][contains(text(),'" + price + "')]"));
//			Verification.displayOfWebElement(p);
//			priceInfoIcon.click();
//			if (driver.findElements(By.xpath("")).size() > 0) {
//				String titleText = "Change worktop";
//				String message = "You are about to change a worktop that you have already edited. Modifications will be deleted.";
//				String question = "Change worktop?";
//
//				Verification.displayNAttributeCheckOfElement(changeWorktopTitle, "Change worktop title", "text",
//						titleText);
//				Verification.displayNAttributeCheckOfElement(changeWorktopInfo, "Change worktop info", "text", message);
//				Verification.displayNAttributeCheckOfElement(changeWorktopQuestion, "Change worktop question", "text",
//						question);
//				changeWorktopYes.click();
//			}
//		}
		return this;
	}

	public MakeItYours verifyPricePerMonthInStep3(String pricePerMonth) {
		if (!pricePerMonth.isEmpty() && driver.findElement(By.xpath(
				"//span[@data-ui='total-price-container']/span/span[@class='monthly'][contains(text(),'/ month')]"))
				.isDisplayed()) {

			String p1 = driver
					.findElement(By.xpath("//span[@data-ui='total-price-container']/span/span[contains(text(),'\u20AC')]"))
					.getText().trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(pricePerMonth)) {
				UtilHBM.reportOK("Step 3 : Expected price: " + pricePerMonth + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 3 : Expected price " + pricePerMonth + " NOT SAME as actual price: " + p1);
			}

		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyPriceInformation(String price, String pricePerMonth, String loanDuration) {
		if (priceInfoIcon.isEnabled()) {
//			UtilHBM.waitExplicitDisplayed(driver, vatIncluded);
//			new Actions(driver).moveToElement(priceInfoIcon).build().perform();
			priceInfoIcon.click();
			Price p = PageFactory.initElements(driver, Price.class);
			p.priceInfo(price, pricePerMonth, loanDuration);
		}
		return this;
	}

	public MakeItYours verifyMemberPrice(String memberPrice) {
		UtilHBM.waitFixTime(2000);
		if (!memberPrice.isEmpty()) {
			WebElement p = driver
					.findElement(By.xpath("//span[@class='membership-price'][contains(text(),'" + memberPrice + "')]"));
			Verification.displayOfWebElement(vatIncluded);
			Verification.displayOfWebElement(memberPriceLabel);
			Verification.displayOfWebElement(memberPriceDetails);
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='membership-price'][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);

		}
		return this;
	}

	public MakeItYours verifyReducedPrice(String reducedPrice) {
		if (!reducedPrice.isEmpty()) {

			WebElement p = driver
					.findElement(By.xpath("//span[@class='reduced-price'][contains(text(),'" + reducedPrice + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='reduced-price'][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
		}
		return this;
	}
public MakeItYours discoverDesignGuidelines() {
	UtilHBM.waitExplicitDisplayed(driver, showHelpDesignNotification);
	Verification.VerifyEquals("Incorrect Discover design message", "Discover design guidelines", showHelpDesignNotification.getText());
	return this;
}
	public MakeItYours clickAndDrag() {

		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.dragAndDropBy(container3D, 200, 0);
		action.moveToElement(container3D, 10, 0).clickAndHold().pause(500).moveByOffset(-20, -10).release().build()
				.perform();

		return this;
	}

	public MakeItYours rotateProjectView(int number, String upDownLeftRight) {

		clickBlank();
		UtilHBM.hitArrowKeyDev(driver, number, upDownLeftRight);
//		Actions action = new Actions(driver);
//		action.moveToElement(container3D, 0, 0).clickAndHold().pause(500).moveByOffset(-30, -10).release().build()
//				.perform();

		return this;
	}

	public MakeItYours undo(int number) {
		for (int i = 0; i < number; i++) {
			undoButton.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours redo(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {
			redoButton.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours twoDView() {
		UtilHBM.waitFixTime(1000);
		twoDView.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public MakeItYours threeDView() {
		threeDView.click();
		UtilHBM.waitFixTime(2000);
		return this;
	}

	public MakeItYours firstPersonView() {

		return this;
	}

	public MakeItYours zoomIn(int zoomIncount) {
		UtilHBM.waitFixTime(1000);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public MakeItYours zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public MakeItYours addAProductFromFilter(String product) {
		String catalogCommand;
		catalogCommand = UtilHBM.getKeyValue(Setting.bryoCatalogPath).get(product).split(">")[0];

		switch (catalogCommand) {
		case "Cabinets":
			cabinet.click();
			break;
		case "Appliances":
			appliances.click();
			break;
		case "Dining":
			dining.click();
			break;
		case "Kitchen extras":
			accessories.click();
			break;
		case "Search":
			search.click();
			break;
		}

		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductFilter(product);
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK(product + " searched & added in the project successfully");
		return this;
	}

	public MakeItYours verifyProduct(int x, int y, String productNm) {
		selectProduct(x, y);

		String[] arrSplit_3 = product.getText().split(">");
		for (int i = 0; i < arrSplit_3.length; i++) {
			if (productName.size() > 0) {
				if (arrSplit_3[i].contains(productName.get(0).getText())) {
					if (!productName.get(0).getText().isEmpty()
							&& productName.get(0).getText().split("\\r?\\n")[0].equalsIgnoreCase(productNm)) {
						UtilHBM.reportOK("product name is displayed & the text is: "
								+ productName.get(0).getText().split("\\r?\\n")[0]);
					} else {
						UtilHBM.reportKO("Given product name not displayed available product is : "
								+ productName.get(0).getText().split("\\r?\\n")[0]);
					}
				}
			}

			if (productDesc.size() > 0) {
				if (arrSplit_3[i].contains(productDesc.get(0).getText())) {
					if (!productDesc.get(0).getText().isEmpty()) {
						UtilHBM.reportOK("product desc is displayed & the text is: " + productDesc.get(0).getText());
					} else {
						UtilHBM.reportWarning("Product desc not available");
					}
				}
			}
			if (productSecDesc.size() > 0) {
				if (arrSplit_3[i].contains(productSecDesc.get(0).getText())) {
					if (!productSecDesc.get(0).getText().isEmpty()) {
						UtilHBM.reportOK("product secondary desc is displayed & the text is: "
								+ productSecDesc.get(0).getText());
					} else {
						UtilHBM.reportWarning("Product secondary desc not available");
					}
				}
			}

		}
		return this;
	}

	public MakeItYours addProductThroughSearch(String product, String productToBeaAdded, boolean defaultStylePrd, boolean productInfoSheet) {
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		searchButton.click();
		search(product).minMaxCatalogPanel().addProductFromSearchOrReplace(productToBeaAdded, defaultStylePrd, productInfoSheet);
//		verifyPrice(price);
		return this;
	}
	public MakeItYours searchAndAddCabinet(String product, String productToBeaAdded, boolean defaultStylePrd,boolean productInfoSheet,String depth,String width) {
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		searchButton.click();
		search(product)
		.verifySearchResultNumber(product)
		.applyCabinetFiltersInSearch(depth,width).verifySearchResultNumberAfterFilter(productToBeaAdded).addProductFromSearchOrReplace(productToBeaAdded, defaultStylePrd, productInfoSheet);
//		verifyPrice(price);
		return this;
	}
	public MakeItYours searchAndAddWorktop(String product, String productToBeaAdded, boolean defaultStylePrd,boolean productInfoSheet,String type,String material,String thickness) {
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		searchButton.click();
		search(product)
		.verifySearchResultNumber(product)
		.applyWorktopFiltersInSearch(type, material, thickness).verifySearchResultNumberAfterFilter(productToBeaAdded).addProductFromSearchOrReplace(productToBeaAdded, defaultStylePrd, productInfoSheet);
		clickBlank();
		return this;
	}
	public MakeItYours ecoFeeProduct(String product, String productToBeaAdded, String price) {
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		searchButton.click();
		search(product);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.ecoFee(productToBeaAdded);
		return this;
	}

	public MakeItYours clickSearch() {
		searchButton.click();
		return this;
	}

	public Catalog search(String product) {
		verifyEmptySearchPanel();
		searchInputBox.click();
		searchInputBox.sendKeys(product);
		Verification.VerifyEquals("empty-search-button  icon not distinguishable...", emptySearchButton
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-view-close");
		searchIcon.click();
		
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	public Catalog verifyEmptySearchPanel() {
		UtilHBM.waitExplicitDisplayed(driver, searchIcon);
		UtilHBM.waitExplicitClickable(driver, searchIcon);
		Verification.VerifyEquals("Search icon not distinguishable...", searchIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-search");
		Verification.VerifyEquals("Search expand not distinguishable...", searchExpand
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-view-maximize");
		Verification.VerifyEquals("Search close not distinguishable...", searchClose
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-view-close");
		Verification.VerifyEquals("Search message not correct", searchMsg.getText(),
				"Search to find the product you want!\nYou can search by product type, reference, color, material etc");

		return PageFactory.initElements(driver, Catalog.class);
	}
	public MakeItYours addProductThroughSearchUsingShortCutKeys(String product, String productToBeaAdded,boolean productInfoSheet) {
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		searchButton.click();
		searchUsingShortCutKeys(product).minMaxCatalogPanel().addProductFromSearchOrReplace(productToBeaAdded, true, productInfoSheet);
//		verifyPrice(price);
		return this;
	}

	public Catalog searchUsingShortCutKeys(String product) {
		UtilHBM.waitExplicitDisplayed(driver, searchInputBox);
		UtilHBM.waitExplicitClickable(driver, searchInputBox);
		searchInputBox.click();
		searchInputBox.sendKeys(product);

//		new Actions(driver).moveToElement(searchInputBox).sendKeys(product).build().perform();
		UtilHBM.waitFixTime(1000);
		searchInputBox.sendKeys(Keys.CONTROL + "a");
		searchInputBox.sendKeys(Keys.CONTROL + "x");
//		Actions builder = new Actions(driver);
//		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
//		UtilHBM.waitFixTime(500);
//		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
//		UtilHBM.waitFixTime(500);
//		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
//		builder.keyDown(Keys.CONTROL).sendKeys("z").keyUp(Keys.CONTROL).build().perform();
		searchIcon.click();
		UtilHBM.waitFixTime(1000);
		if (searchMsg.isDisplayed()) {
			UtilHBM.reportOK("Search text removed using shortcut key CTRL+Z");
		} else {
			UtilHBM.reportKO("Search text not removed using shortcut key CTRL+Z");
		}
		searchInputBox.click();
//		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		searchInputBox.sendKeys(Keys.CONTROL + "v");
		searchIcon.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	public MakeItYours verifySearchProduct(int x, int y, String product) {
		clickBlank();
		getBallon(x, y);
		System.out.println(productName.get(0).getText());
		if (product.equalsIgnoreCase(productName.get(0).getText().split("\\r?\\n")[0])) {
			UtilHBM.reportOK(productName.get(0).getText().split("\\r?\\n")[0] + " added successfully using search");
		} else {
			UtilHBM.reportKO("Product not added");
			UtilHBM.reportKO(" Expected product name is : " + product + " Actual product name is : "
					+ productName.get(0).getText().split("\\r?\\n")[0]);
		}
		return this;
	}

	public MakeItYours tooltipsForStep3() {
		clickBlank();
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForDesignYourKitchen();
		return this;
	}

	public MakeItYours addProductFromInfo(String product, boolean defaultStylePrd, boolean applyFilter,
			boolean checkPrdInfoSheet) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		System.out.println(prdPath);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagory(product).addProductFromInfo(product, defaultStylePrd, applyFilter, checkPrdInfoSheet);
		return this;
	}

	/*Note to user : Use 'yes' for resetCustomizedLinearAppSettingIsFalse field when the "resetCustomizedLinear" in 3DCloudAppSetting is set to False
	otherwise leave this field blank i.e. do not pass any parameter for this field*/
	public MakeItYours replaceProperty(int x, int y, String propertyName, String product, String allOrSelected,boolean defaultStylePrd,
									   String acceptDelCustModifications, String... resetCustomizedLinearAppSettingIsFalse) {
		clickBlank();
		selectProduct(x, y).replaceProperty(propertyName, product, allOrSelected, defaultStylePrd, acceptDelCustModifications, resetCustomizedLinearAppSettingIsFalse);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours replaceProperty(String propertyName, String product, String allOrSelected,
									   boolean defaultStylePrd, String acceptDelCustModifications, String... resetCustomizedLinearAppSettingIsFalse) {
		editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.replace(propertyName, product, allOrSelected, defaultStylePrd, acceptDelCustModifications, resetCustomizedLinearAppSettingIsFalse);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		if (!acceptDelCustModifications.isEmpty() || resetCustomizedLinearAppSettingIsFalse.length==0) {
			catalog.closeCatalogForReplacePanel();
			clickBlank();
		}
//		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}


	public MakeItYours replaceFreeStandingProperty(int x, int y, String propertyName, String product,
			String allOrSelected, boolean defaultStylePrd, String replacedProduct) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.replace(propertyName, product, allOrSelected, defaultStylePrd, "");
		driver.findElement(By.cssSelector("button[data-ui-action='panel-back']")).click();
		property.verifyReplace(replacedProduct, product);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForReplacePanel();
		clickBlank();
//		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyReplaceProperty(int x, int y, String propertyName, String product) {
		clickBlank().selectProduct(x, y).verifyReplaceProperty(propertyName, product);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyReplaceProperty(String propertyName, String product) {
		editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyReplace(propertyName, product);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editHandleOptionsProperty(int x, int y, String handleLayoutOption,
			String handleOrientationOption) {
		selectProduct(x, y).editHandleOptionsProperty(handleLayoutOption, handleOrientationOption);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editHandleOptionsProperty(String handleLayoutOption, String handleOrientationOption) {
		editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.handleOptions(handleLayoutOption, handleOrientationOption);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editFrontOptionsProperty(int x, int y, String frontSide) throws InterruptedException {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.frontOptions(frontSide);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours editCustomWorktopDimensions(int x, int y,String heightFromFLoor) {
		selectProduct(x, y).editCustomWorktopDimensions(heightFromFLoor);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
	public MakeItYours editWorktopOverHangOptions(int x, int y, String overhangLeftOpt, String overhangRightOpt) {
		selectProduct(x, y).editWorktopOverHangOptions(overhangLeftOpt, overhangRightOpt);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours editCustomWorktopDimensions(String heightFromFLoor) {
		editProperty();
		worktopOptionButton();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.editCustomWorktopDimensionsProperties(heightFromFLoor);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForOptionPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours verifyCustomWorktopDimensions(int x,int y,String heightFromFLoor) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyCustomWorktopDimensionsProperties(heightFromFLoor);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours editWorktopOverHangOptions(String overhangLeftOpt, String overhangRightOpt) {
		editProperty();
		worktopOptionButton();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.worktopOverHangOption(overhangLeftOpt, overhangRightOpt);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editWorktopWaterFallOptions(int x, int y,String leftWaterfall, String rightWaterfall,String waterFallType) {
		selectProduct(x, y).editWorktopWaterFallOptions(leftWaterfall, rightWaterfall,waterFallType);
//		editWorktopOptionsProperty(overhangLeftOpt, overhangRightOpt, leftWaterfall, rightWaterfall);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editWorktopWaterFallOptions(String leftWaterfall, String rightWaterfall,String waterFallType) {
		editProperty();
		worktopOptionButton();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.worktopWaterFallOptions(leftWaterfall, rightWaterfall,waterFallType);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForOptionPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editFreeStandingWorktopOverhang(int x, int y, String overhangLeftOpt, String overhangRightOpt) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.worktopOverHangOption(overhangLeftOpt, overhangRightOpt);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
	
	public MakeItYours editFreeStandingWorktopWaterFall(int x, int y,
			String leftWaterfall, String rightWaterfall,String waterFallType) {
		clickBlank();
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.worktopWaterFallOptions(leftWaterfall, rightWaterfall,waterFallType);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editWallPanelOptionsProperty(int x, int y, String wallPanelHeight, String wallpanelSide,
			String leftWallpanelOption, String rightWallpanelOption) {
		selectProduct(x, y).editProperty();
		wallPanelOptionButton(x, y);
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.wallPanelOptionProperties(wallPanelHeight, wallpanelSide, leftWallpanelOption, rightWallpanelOption);
//		verifyPrice(price);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editSinkOptionsProperty(int x, int y, String sinkXOffset, String sinkYOffset, String mounting,
			String sideSinkXOffset, String sideSinkYOffset, String addGrooves, String groovesPosition) {
		clickBlank();
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.sinkOptions(sinkXOffset, sinkYOffset, mounting, sideSinkXOffset, sideSinkYOffset, addGrooves,
				groovesPosition);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifySinkOptionsProperty(int x, int y, String sinkXOffset, String sinkYOffset, String mounting,
			String sideSinkXOffset, String sideSinkYOffset, String groovesPosition) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifySinkProperties(sinkXOffset, sinkYOffset, mounting, sideSinkXOffset, sideSinkYOffset, groovesPosition);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editFaucetOptionsProperty(int x, int y, String faucetXOffset, String faucetYOffset,
			String sideFaucetXOffset, String sideFaucetYOffset) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.faucetOptions(faucetXOffset, faucetYOffset, sideFaucetXOffset, sideFaucetYOffset);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyFaucetOptionsProperty(int x, int y, String faucetXOffset, String isFaucetXOffsetEditable,
			String faucetYOffset, String isFaucetYOffsetEditable, String sideFaucetXOffset, String sideFaucetYOffset) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyFaucetProperties(faucetXOffset, isFaucetXOffsetEditable, faucetYOffset, isFaucetYOffsetEditable,
				sideFaucetXOffset, sideFaucetYOffset);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyHandleOptionsProperty(int x, int y, String handleLayoutOption,
			String handleOrientationOption) {
		selectProduct(x, y).verifyHandleOptionsProperty(handleLayoutOption, handleOrientationOption);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyHandleOptionsProperty(String handleLayoutOption, String handleOrientationOption) {
		editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyHandleOptions(handleLayoutOption, handleOrientationOption);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyHandleOptionsIsEditable(boolean isEditable) {
		editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyHandleOptionsEditable(isEditable);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyFrontOptionsProperty(int x, int y, String frontSide) {
		clickBlank();
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyFrontOptions(frontSide);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyWorktopOptionsProperty(int x, int y, String overhangLeftOpt, String overhangRightOpt,
			String leftWaterfall, String rightWaterfall) {

		selectProduct(x, y).editProperty();
		worktopOptionButton();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyWorktopOptionProperties(overhangLeftOpt, overhangRightOpt, leftWaterfall, rightWaterfall);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForOptionPanel();
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyWallPanelOptionsProperty(int x, int y, String wallPanelHeight,
			String wallPanelSide, String isLeftWPOptionEnabled, String leftWPOption, String isRightWPOptionEnabled, String rightWPOption) {

		selectProduct(x, y).editProperty().wallPanelOptionButton(x, y);
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyWallPanelOptions(wallPanelHeight, wallPanelSide, isLeftWPOptionEnabled, leftWPOption,
				isRightWPOptionEnabled, rightWPOption);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editProperty() {
		UtilHBM.waitExplicitClickable(driver, edit);
		Actions action = new Actions(driver);
		action.moveToElement(edit).pause(1000).click().build().perform();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours selectProduct(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector(".mod-properties-window-wide.mod-open")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.cssSelector(".mod-properties-window-wide.mod-open")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours deleteProperty(int x, int y, String propertyName) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.delete(propertyName);
//		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyDeleteProperty(int x, int y, String propertyName) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyDelete(propertyName);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours straightFillerPropertyON(int x, int y, String straightFiller, String coverPanelToRemoveWhenFillerON,
			String price) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.togglePropertiesON(straightFiller, coverPanelToRemoveWhenFillerON);
		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours straightFillerPropertyOFF(int x, int y, String straightFiller, String coverPanelToAddWhenFillerOFF,
			String price) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.togglePropertiesOFF(straightFiller, coverPanelToAddWhenFillerOFF);
		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours productInfo(int x, int y) {
		selectProduct(x, y);
		Actions action = new Actions(driver);
		action.moveToElement(info).click().build().perform();
		checkProductInfo();
		return this;
	}

	public MakeItYours priceInfoDetails(String price, String pricePerMonth) {
		clickBlank();
		if (priceInfoIcon.isEnabled()) {
			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
			UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
			new Actions(driver).moveToElement(priceInfoIcon).build().perform();
			new Actions(driver).moveToElement(priceInfoIcon).clickAndHold().pause(500).release().build().perform();
//			priceInfoIcon.click();
		} else {
			UtilHBM.reportKO("Price icon disabled");
		}
		Price p = PageFactory.initElements(driver, Price.class);
		p.priceInfo(price, pricePerMonth, "48 months");
		return this;
	}

	public MakeItYours checkProductInfo() {
//		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement infoPopUp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".mod-popin-product-info-large.mod-open")));
		if (!infoPopUp.isDisplayed()) {
			UtilHBM.reportKO("Product info pop-up not displayed");
		} else {
			UtilHBM.reportOK("Product info pop-up displayed");
		}
		if (!productInfoTitle.isDisplayed()) {
			UtilHBM.reportKO("Product information title not available");
		} else {
			UtilHBM.reportOK("Product info tilte displayed and product title is " + productInfoTitle.getText());
		}

		if (productImage.getAttribute("src").startsWith("https://")
				&& productImage.getAttribute("src").endsWith(".jpg")) {
			UtilHBM.reportOK("Product image displayed in info pop-up");
		} else {
			UtilHBM.reportKO("Product image not displayed in info pop-up");
		}
		if ((infoDescription.getText().isEmpty())) {
			UtilHBM.reportKO("Description and Dimension are empty");
		} else {
			UtilHBM.reportOK("Description and dimension are displayed");
		}
		infoClose.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return this;
	}

	public MakeItYours openClose(int x1, int y1, int x2, int y2) {
		selectProduct(x1, y1);
		Actions action = new Actions(driver);
		action.moveToElement(opening).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Close')]")));
		UtilHBM.reportOK("Open successful");
		opening.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Open')]")));
		UtilHBM.reportOK("Close successful");
		clickBlank();
		return this;

	}
	public MakeItYours openCloseRTL(int x1, int y1, int x2, int y2) {
		selectProduct(x1, y1);
		Actions action = new Actions(driver);
		action.moveToElement(opening).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Close')]")));
		UtilHBM.reportOK("Open successful");
		opening.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Open')]")));
		UtilHBM.reportOK("Close successful");
		clickBlank();
		return this;

	}
	
	public MakeItYours position(int x, int y, String positionValueToChange, String pos1, String appkyMeasurementYesNo) {
		UtilHBM.waitFixTime(1000);
		selectProduct(x, y);
//		new Actions(driver).moveToElement(position).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		position.click();
		List<WebElement> li = driver.findElements(By.cssSelector(".WallMeasure"));
		int i = 0;
		List<String> values = new ArrayList<String>();
		for (WebElement index : li) {

			if (positionValueToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				index.click();
				for (i = 0; i < positionValueToChange.length(); i++) {
					index.sendKeys(Keys.BACK_SPACE);
				}

				index.sendKeys(pos1 + Keys.ENTER);
				String a = pos1.replaceAll("[a-zA-Z]", "").replaceAll(" ", "");
				int b = Integer.parseInt(a);
				if (b > 10000) {
					String titleText = "Are you sure?";
					String desc = "You are trying to change the measurement to a value higher than 10000 mm.";
					String message = "Do you want to apply this measurement?";
					Verification.displayOfWebElement(areYouSure);
					Verification.VerifyEquals("Invalid-measure-popin heading not correct", areYouSure.getText(), titleText);
					Verification.VerifyEquals("Invalid-measure-popin title not correct", changeMeasurementDesc.getText(), desc);
					Verification.VerifyEquals("Invalid-measure-popin info not correct", changeMeasurementQuestion.getText(),
							message);
					if (appkyMeasurementYesNo.equalsIgnoreCase("Yes")) {
						applyMeasurementYes.click();
					} else {
						applyMeasurementNo.click();
						UtilHBM.waitFixTime(500);
					}

				}
				UtilHBM.waitFixTime(1000);
				break;
			} else {
				values.add(index.getAttribute("value"));
			}
		}
		if (!(i > 0)) {
			UtilHBM.reportKO("Position change failed. Expected initial position: " + positionValueToChange);
			UtilHBM.reportKO("Availalbe position values are: " + values.toString());
		}
		clickBlank();
//		verifyPrice(price);
		return this;
	}

	public MakeItYours verifyPosition(int x, int y, String dim) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		for (int tryCount = 0; tryCount < 5; tryCount++) {
			try {
				clickBlank();
				selectProduct(x, y);
				position.click();
				break;
			} catch (NoSuchElementException e) {
				if (tryCount == 4)
					throw new NoSuchElementException(
							"Unable to open edit menu and locate position tool for the given coordinates");
				UtilHBM.waitFixTime(500);
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> pos = driver.findElements(By.cssSelector(".WallMeasure.Tag3D"));
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

	public MakeItYours preciseRotation(int x, int y, String rotation, String dim) {
		selectProduct(x, y);
//		new Actions(driver).moveToElement(position).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		position.click();
		preciseRotation.clear();
		preciseRotation.sendKeys(rotation + Keys.ENTER);

		if (preciseRotation.getAttribute("value").equalsIgnoreCase(rotation)) {
			UtilHBM.reportOK("Precise rotation value changed and value is : " + preciseRotation.getAttribute("value"));
		} else {
			UtilHBM.reportKO(
					"Precise rotation value not changed and value is : " + preciseRotation.getAttribute("value"));
		}
		UtilHBM.waitFixTime(500);
		List<WebElement> pos = driver.findElements(By.cssSelector(".WallMeasure.Tag3D"));
		int index = 0;
		for (WebElement image : pos) {
			System.out.println("value " + image.getAttribute("value") + "dim " + dim);
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

	public MakeItYours verifyPreciseRotation(int x, int y, String rotation) {
		selectProduct(x, y);
//		new Actions(driver).moveToElement(position).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		position.click();

		if (preciseRotation.getAttribute("value").equalsIgnoreCase(rotation)) {
			UtilHBM.reportOK("Precise rotation value changed and value is : " + preciseRotation.getAttribute("value"));
		} else {
			UtilHBM.reportKO(
					"Precise rotation value not changed and value is : " + preciseRotation.getAttribute("value"));
		}

		return this;
	}

	public MakeItYours replaceProductFromEdit(int x, int y, String product, boolean defaultStylePrd, boolean filter,
			boolean productInfoSheet) {
		selectProduct(x, y).editProperty();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.replaceProduct(product, defaultStylePrd, filter, productInfoSheet);
		clickBlank();
//		verifyPrice(price);
		return this;

	}

	public MakeItYours replaceProduct(int x, int y, String product, boolean defaultStylePrd, boolean filter,
			boolean productInfoSheet) {
		selectProduct(x, y);
		replace.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductDesignStep(product, defaultStylePrd, filter, productInfoSheet);
//		Catalog close = PageFactory.initElements(driver, Catalog.class);
//		close.closeCatalogPanel();
		return this;

	}

	public MakeItYours verifyReplaceProduct(int x, int y, String product) {
		selectProduct(x, y);

		String proName = productName.get(0).getText().split("\\r?\\n")[0];
		if (proName.equalsIgnoreCase(product)) {
			UtilHBM.reportOK("Product " + proName + " replaced successfully");
		} else {
			UtilHBM.reportKO("Product " + proName + " replace failed");
		}
		return this;

	}

	public MakeItYours duplicateProduct() {
		UtilHBM.waitExplicitDisplayed(driver, duplicate);
		new Actions(driver).moveToElement(duplicate).click().build().perform();
//		if(!price.isEmpty()){
//			verifyPrice(price);
//		}
		return this;
	}

	public MakeItYours duplicateProduct(int x, int y) {
		selectProduct(x, y);
		duplicateProduct();
		return this;
	}

	public MakeItYours duplicateProductUsingShortCutKey(int x, int y) {
		selectProduct(x, y);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
//		verifyPrice(price);
		return this;

	}

	public Customise customiseProduct(int x, int y, String price) {
		selectProduct(x, y).editProperty();
		if (driver.findElement(By.xpath("//h3[@class='name']")).getText().equalsIgnoreCase("Custom Product")) {
			Customise property = PageFactory.initElements(driver, Customise.class);
			property.composeCustomizedFurniture(price);
		} else {
			Customise property = PageFactory.initElements(driver, Customise.class);
			property.composeFurniture(price);
		}
		return PageFactory.initElements(driver, Customise.class);

	}

	public Customise customiseProductThroughReplace(int x, int y, String price) {
		selectProduct(x, y).editProperty();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.productReplaceButton();
		Customise property = PageFactory.initElements(driver, Customise.class);
		property.composeFurniture(price);
		return PageFactory.initElements(driver, Customise.class);

	}

	public MakeItYours verifyComposedProduct(int x, int y) {

		selectProduct(x, y);
		if (productName.get(0).getText().equalsIgnoreCase("Custom Product")) {
			UtilHBM.reportOK("Product is customized and product name is : " + productName.get(0).getText());
		} else {
			UtilHBM.reportKO("Product is not customized and product name is : " + productName.get(0).getText());
			UtilHBM.pageCapture(driver, "VerifyCompose");
		}
		clickBlank();
//		verifyPrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyDelete(int x, int y, String product) {
		selectProduct(x, y);
		String proName = productName.get(0).getText().split("\\r?\\n")[0];
		if (proName.equalsIgnoreCase(product)) {
			UtilHBM.reportOK("Product deleted successfully");
		} else {
			UtilHBM.reportKO("Delete product KO");
		}
		UtilHBM.waitFixTime(1500);
		return this;
	}

	public WorktopEditor worktopEditor(int x, int y) {
		selectProduct(x, y).editProperty().worktopOptionButton();
		modifyWorktop();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor worktopWallPanelTypes(int x, int y, String price) {
		selectProduct(x, y).editProperty().worktopOptionButton();
		worktopModifyButton.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@data-ui-action='link-action']")).click();
		modifyWorktop();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor worktopOptionButton() {
		worktopOptionButton.sendKeys(Keys.ENTER);

		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor modifyWorktop() {
		UtilHBM.waitExplicitDisplayed(driver, worktopModifyButton);
		UtilHBM.waitExplicitClickable(driver, worktopModifyButton);
		worktopModifyButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor modifyFreestandingWorktop(int x, int y, String price) {
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, worktopModifyButton);
		worktopModifyButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, WorktopEditor.class);
	}
	public WallPanelEditor modifyFreestandingWallPanel(int x, int y, String price) {
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, wallPanelModifyButton);
		wallPanelModifyButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public MakeItYours addProperty(int x, int y, String propertyName, String product, String allOrSelected, boolean defaultStylePrd) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.add(propertyName, product, allOrSelected, defaultStylePrd);
//		verifyPrice(price);
		return this;
	}

	public MakeItYours addDirectProperty(int x, int y, String propertyName, String product, String allOrSelected) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.addDirectProperty(propertyName, product, allOrSelected);
//		verifyPrice(price);
		return this;
	}

	public MakeItYours verifyAddProperty(int x, int y, String propertyName, String product) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyReplace(propertyName, product);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		clickBlank();
		return this;
	}

	public WallPanelEditor wallPanelEditor(int x, int y) {
		selectProduct(x, y).editProperty().wallPanelOptionButton(x, y);
		modifyWallPanel();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WorktopEditor wallPanelOptionButton(int x, int y) {
		wallPanelOptionButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WallPanelEditor modifyWallPanel() {
		UtilHBM.waitExplicitClickable(driver, wallPanelModifyButton);
		wallPanelModifyButton.sendKeys(Keys.ENTER);

		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor modifyCustomizedWallPanel(int x, int y) {
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitClickable(driver, wallPanelModifyButton);
		wallPanelModifyButton.sendKeys(Keys.ENTER);

		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallEdgeStripEditor modifyWallEdgeStrip() {
		UtilHBM.waitExplicitClickable(driver, customizewallEdgeStrip);
		customizewallEdgeStrip.sendKeys(Keys.ENTER);
		WallEdgeStripEditor editor = PageFactory.initElements(driver, WallEdgeStripEditor.class);
		editor.editWallEdgeStripOverlay();
		return PageFactory.initElements(driver, WallEdgeStripEditor.class);
	}

	public WallEdgeStripEditor wallEdgeStripEditor(int x, int y) {
		selectProduct(x, y).editProperty();
		modifyWallEdgeStrip();
//		.verifyPriceInWallEdgeStrip(price);
		return PageFactory.initElements(driver, WallEdgeStripEditor.class);
	}

	public MakeItYours deleteProduct(int x, int y) {
		selectProduct(x, y).deleteProduct();
		return this;
	}

	public MakeItYours deleteProduct() {
		UtilHBM.waitExplicitDisplayed(driver, delete);
		UtilHBM.waitExplicitClickable(driver, delete);
		new Actions(driver).moveToElement(delete).build().perform();
		delete.sendKeys(Keys.ENTER);
//		if(!price.isEmpty())verifyPrice(price);
		clickBlank();
		return this;
	}

	public MakeItYours deleteProductUsingShortCutKey(int x, int y) {
		selectProduct(x, y);
		Actions builder = new Actions(driver);
//		builder.sendKeys(Keys.DELETE);
		builder.keyDown(Keys.CONTROL).sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
//		verifyPrice(price);
		return this;
	}

	public MakeItYours viewHeightIn3D(String height) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		WebElement element = driver.findElement(By.cssSelector(("select[data-ui-action='opening']")));
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText(height);
		return this;
	}

	public MakeItYours viewHeightIn2D(String visibleItems) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		twoDView.click();
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		WebElement element = driver.findElement(By.cssSelector(("select[data-ui-action='opening']")));
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText(visibleItems);
		return this;
	}

	public MakeItYours verifyViewHeightIn3D(String visibleItems) {
		clickBlank();

		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		WebElement element = driver.findElement(By.cssSelector(("select[data-ui-action='opening']")));
		Select oSelect = new Select(element);
		WebElement option = oSelect.getFirstSelectedOption();
		String defaultItem = option.getText().trim().replaceAll("/n/r", "");
		UtilHBM.waitExplicitDisplayed(driver, option);
		System.out.println(defaultItem);
		if (defaultItem.equalsIgnoreCase(visibleItems)) {
			UtilHBM.reportOK("Verification for Camera Height passed and height is : " + defaultItem);
		} else {
			UtilHBM.reportKO("Verification for Camera Height failed and height is : " + defaultItem);
		}

		return this;
	}

	public MakeItYours verifyViewHeightIn2D(String visibleItems, int x, int y, String product) {
		clickBlank();
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		WebElement element = driver.findElement(By.cssSelector(("select[data-ui-action='opening']")));
		Select oSelect = new Select(element);
		WebElement option = oSelect.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);
		if (defaultItem.equalsIgnoreCase(visibleItems)) {

			switch (defaultItem) {
			case "All items":
				getBallon(x, y);

				break;
			case "On floor":
				getBallon(x, y);
//				UtilHBM.reportMsg("Selected product name is " + productName.get(0).getText().split("/r/n"));
//				UtilHBM.verifyScreen(img);
//				UtilHBM.reportOK("Verification for Camera Height passed and height is : " + defaultItem + " with value "
//						+ option.getAttribute("value"));
				break;
			case "On floor no worktop":
				getBallon(x, y);
//				UtilHBM.reportMsg("Selected product name is " + productName.get(0).getText().split("/r/n"));
//				UtilHBM.verifyScreen(img);
//				UtilHBM.reportOK("Verification for Camera Height passed and height is : " + defaultItem + " with value "
//						+ option.getAttribute("value"));
				break;
			case "Not on floor":
				getBallon(x, y);
//				UtilHBM.reportMsg("Selected product name is " + productName.get(0).getText().split("/r/n"));
//				UtilHBM.verifyScreen(img);
//				UtilHBM.reportOK("Verification for Camera Height passed and height is : " + defaultItem + " with value "
//						+ option.getAttribute("value"));
				break;
			default:
				break;
			}
			if (productName.get(0).getText().split("\\r?\\n")[0].equalsIgnoreCase(product)) {
				UtilHBM.reportOK("Given " + product + " available for Camera Height passed and height is : "
						+ defaultItem + " with value " + option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Given " + product + " not available in duplicated project");
			}
			UtilHBM.reportOK("Verification for Camera Height passed and height is : " + defaultItem + " with value "
					+ option.getAttribute("value"));
		} else {
			UtilHBM.reportKO("Given " + product + " not available Camera Height failed and height is : " + defaultItem
					+ " with value " + option.getAttribute("value"));
		}
		threeDView();
		return this;
	}

	public MakeItYours displayFront() {
		UtilHBM.waitFixTime(2500);
		clickBlank();
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		new Actions(driver).moveToElement(displayFrontToggle).click().build().perform();
		return this;
	}

	public ProductList clickProductList() {
		UtilHBM.waitExplicitDisplayed(driver, productListIcon);
		UtilHBM.waitExplicitClickable(driver, productListIcon);
		productListIcon.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, ProductList.class);
	}

	public MakeItYours productList(String filePath, String price) {
		clickProductList().productListDetails(filePath, price);
		return this;
	}

	public MakeItYours measureEdit(int xPoint1, int yPoint1, int xPoint2, int yPoint2,String expectedMeasure) {
		measureButton.click();
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.checkMeasure(xPoint1, yPoint1, xPoint2, yPoint2,expectedMeasure);

		return this;
	}

	public MakeItYours debugMenu(String function, String subFunction) {
		System.out.println("In debug method");
		clickBlank();

		driver.findElement(By.tagName(("html"))).sendKeys(Keys.chord(Keys.CONTROL, Keys.F1));
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.tagName(("html"))).sendKeys(Keys.chord(Keys.ALT, Keys.F12));
		UtilHBM.waitExplicitDisplayed(driver,debugMenu);
		outer:for (WebElement e : debugFunctionName) {
			if (e.getText().equalsIgnoreCase(function)) {
				System.out.println("Function name: " + e.getText());
				e.click();
				UtilHBM.waitFixTime(1000);
				List<WebElement> subFunctionName=e.findElements(By.cssSelector("ul>li"));
				for (WebElement e1 : subFunctionName) {
					if (e1.getText().equalsIgnoreCase(subFunction)) {
						System.out.println("SubFunction name: " + e1.getText());
						e1.click();
						break outer;
					}
				}
			}
		}
		return this;
	}

	public MakeItYours editCornerFiller(int x, int y, String angle, String leftDepth, String leftWidth,
			String rightDepth, String rightWidth, String height) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.fillerProperties(angle, leftDepth, leftWidth, rightDepth, rightWidth, height);

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyCornerFiller(int x, int y, String angle, String leftDepth, String leftWidth,
			String rightDepth, String rightWidth, String height) {
		selectProduct(x, y).editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyFillerProperties(angle, leftDepth, leftWidth, rightDepth, rightWidth, height);

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours checkProjectDetails(String projectName, String price) {
		String projName = null;
		String projStandardPrice = null;
		String projRegularPrice = null;
		String projMembership = null;

		UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
		Verification.displayNAttributeCheckOfElement(projectTitle, "Project Title", "text", projectName);
		verifyPrice(price);
//		Verification.displayNAttributeCheckOfElement(projectStandardPrice, "Price", "text", price);
//		if (projectTitle.isDisplayed() && projectTitle != null) {
//			projName = projectTitle.getText();
//			if (projectName.equalsIgnoreCase(projName)) {
//				Verification.VerifyEquals("Project Title not correct", projName, projectName);
//			}
//		} else
//			UtilHBM.reportKO("Project title not available in step 3");
//		if (!price.isEmpty()) {
//			Verification.displayNAttributeCheckOfElement(projectStandardPrice, "Price", "text", price);
//			if (projectStandardPrice.isDisplayed() && projectStandardPrice != null) {
//				UtilHBM.waitFixTime(500);
//				projStandardPrice = projectStandardPrice.getText();
//				System.out.println("projStandardPrice" + projStandardPrice);
//				if (price.equalsIgnoreCase(projStandardPrice)) {
//					UtilHBM.reportOK("Standard kitchen price  available in step 3 and price displayed is SAME "
//							+ "<font style='color:blue'>" + projStandardPrice);
//				}else
//					UtilHBM.reportKO("Standard kitchen price  available in step 3 and price displayed is NOT SAME"
//							+ "<font style='color:blue'>" + projStandardPrice);
//				
//			}
//
//			if (projectReducedPrice.size() > 0) {
//				if (projectReducedPrice.get(0).isDisplayed() && projectReducedPrice != null) {
//					projRegularPrice = projectReducedPrice.get(0).getText();
//				} else
//					UtilHBM.reportKO("Reduced price for kitchen not available");
//			}
//			if (projectMembershipPrice.size() > 0) {
//				if (projectMembershipPrice.get(0).isDisplayed() && projectMembershipPrice != null) {
//					projMembership = projectMembershipPrice.get(0).getText();
//				} else
//					UtilHBM.reportKO("Membership price for kitchen not displayed in step 3");
//			}
//		}
		String projectDetails = projName + ":" + projStandardPrice + ":" + projRegularPrice + ":" + projMembership;
		setProjName(projectDetails);
		return this;
	}

	public MakeItYours verifyProductOnReOpen(int x, int y, String product) {

		selectProduct(x, y);
		if (productName.size() > 0) {
			if (productName.get(0).getText().split("\\r?\\n")[0].equalsIgnoreCase(product)) {
				UtilHBM.reportOK("Given " + product + " available on opening the project ");
			}
		} else {
			UtilHBM.reportKO("Given " + product + " not available on opening the project ");
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours replaceExpiredProduct(String product) {
		System.out.println(
				"name " + driver.findElement(By.xpath("//article[@id='design-catalog-browser']/header/h2")).getText());
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//article[@id='design-catalog-browser']/header/h2")));
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductFromSearchOrReplace(product, true, false);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours checkExpiredProductRuleIn3D(String rule) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkExpiredProductRuleShowIn3D(rule);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours checkBusinessRuleShowIn3D(String rule, boolean showBusinessRuleButton) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn3D(rule, showBusinessRuleButton);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours checkBusinessRuleShowIn2D(String rule) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.checkBusinessRuleShowIn2D(rule);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WorktopEditor checkBusinessRuleShowInWorktop(String rule, boolean isEditPanelDisplayed) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowInWorktop(rule, isEditPanelDisplayed);
		clickBlank();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}
	public WallPanelEditor checkBusinessRuleShowInWallPanel(String rule, boolean isEditPanelDisplayed) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleInWallPanel(rule, isEditPanelDisplayed);
		clickBlank();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor checkBusinessRuleShowInWallPanel(String rule) {
		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleInWallPanel(rule);
		clickBlank();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public MakeItYours verifyBusinessRuleRemoved(String rule) {
//		clickBlank();
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().businessRuleRemoved(rule);
//		clickBlank();
		return this;
	}

	public MakeItYours clickSave(SignUpData signUpData) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, saveIcon);
		UtilHBM.waitExplicitClickable(driver, saveIcon);
		new Actions(driver).moveToElement(saveIcon).clickAndHold().pause(500).release().build().perform();
		login(signUpData);
		return PageFactory.initElements(driver, MakeItYours.class);

	}

	public IKEASaveProject ikeaClickSave(SignUpData signUpData) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, saveIcon);
		UtilHBM.waitExplicitClickable(driver, saveIcon);
		new Actions(driver).moveToElement(saveIcon).clickAndHold().pause(500).release().build().perform();
		ikeaLogin(signUpData);
		return PageFactory.initElements(driver, IKEASaveProject.class);

	}

	public MakeItYours login(SignUpData signUpData) {
		driver.switchTo().parentFrame();
		if (loginWindow.size() > 0) {
			KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
			login.login(signUpData);

		} else {
			UtilHBM.reportInfo("User already logged in");
//			driver.switchTo().frame(driver.findElement(By.cssSelector("iframeContainer>iframe")));
		}
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours ikeaLogin(SignUpData signUpData) {
		driver.switchTo().parentFrame();
		if (driver.findElements(By.cssSelector("article[class='login-alert-mod-popin mod-open']")).size() > 0) {
			KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
			login.ikeaLogin(signUpData);

		} else {
			UtilHBM.reportInfo("User already logged in");
//			driver.switchTo().frame(driver.findElement(By.cssSelector("iframeContainer>iframe")));
		}
		List<WebElement> frames = driver.findElements(By.cssSelector("#embedded-kitchen-app>iframe"));
		driver.switchTo().frame(frames.get(0));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours saveProjectInStep3(SignUpData signUpData, String name, String desc) {
		clickSave(signUpData);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveProject(name, desc);
		verifySavedProjectDetails(name);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifySavedProjectDetails(String name) {

		if (savedProjectName.size() > 0) {

			if (savedProjectName.get(0).getText().equalsIgnoreCase(name))
				UtilHBM.reportOK("Project saved successfully and project name is " + savedProjectName.get(0).getText());
			else
				UtilHBM.reportKO("Project not saved and project name is " + savedProjectName.get(0).getText());
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours ikeaSaveProjectInStep3(SignUpData signUpData, String name, String desc) {
		ikeaClickSave(signUpData).ikeaSaveProject(name, desc);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public StartNow closePlanner() {
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, closePlanner);
		UtilHBM.waitExplicitClickable(driver, closePlanner);
		closePlanner.click();
		driver.switchTo().parentFrame();
//		 if (unSavedPopUp.size() > 0) {
//			saveChanges();
//		}else {
//			driver.switchTo().parentFrame();
//			if (driver.findElements(By.xpath("//button[@data-launch='fromScratch']")).size() > 0) {
//				UtilHBM.reportMsg("No un-saved popup");
//			}
//		}
		return PageFactory.initElements(driver, StartNow.class);
	}

	public StartNow refreshApplication() {
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
		return PageFactory.initElements(driver, StartNow.class);
	}

	public MakeItYours recoverProject(String yesOrNo) {
		UtilHBM.waitExplicitDisplayed(driver, recoverPopUp.get(0));
		RecoverProject recover = PageFactory.initElements(driver, RecoverProject.class);
		recover.recoverProject(yesOrNo);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public StartNow ikeaClosePlanner() {
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, closePlanner);
		UtilHBM.waitExplicitClickable(driver, closePlanner);
		try {
			closePlanner.click();
		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
				driver.switchTo().parentFrame();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
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

	public Print clickPrint() {
		UtilHBM.waitExplicitDisplayed(driver, printButton);
		UtilHBM.waitExplicitClickable(driver, printButton);
		printButton.click();
		return PageFactory.initElements(driver, Print.class);
	}

	public MakeItYours printTestInStep3(int renderCount, int planCount) {
		clickPrint().verifyMediasDisplayed(renderCount, planCount);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItHappen step4() {
		System.out.println(nextStep4.getText());

		UtilHBM.waitExplicitDisplayed(driver, nextStep4);
		UtilHBM.waitExplicitClickable(driver, nextStep4);
		nextStep4.click();
//		new Actions(driver).moveToElement(nextStep4).click().build().perform();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public void setProjName(String projName) {
		projectNameVerification = projName;
	}

	public static String getProjName() {
		return projectNameVerification;
	}

	MakeItYours selectProductToManipulate(int xcoordinate, int ycoordinate) {
		Actions actions = new Actions(driver);
		actions.moveToElement(container3D, xcoordinate, ycoordinate).clickAndHold().pause(1000).release().build()
				.perform();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours translateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		selectProductToManipulate(initialxcoordinate, intialycoordinate).translateProduct(finalxcoordinate,
				finalycoordinate);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours translateProduct(int finalxcoordinate, int finalycoordinate) {
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(translatePointer, finalxcoordinate, finalycoordinate).build().perform();
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours rotateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		selectProductToManipulate(initialxcoordinate, intialycoordinate).rotateProduct(finalxcoordinate,
				finalycoordinate);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours rotateProduct(int finalxcoordinate, int finalycoordinate) {
		Actions actions = new Actions(driver);
		UtilHBM.waitExplicitDisplayed(driver, rotatePointer);
		actions.dragAndDropBy(rotatePointer, finalxcoordinate, finalycoordinate).build().perform();
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours elevateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		selectProductToManipulate(initialxcoordinate, intialycoordinate);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(elevatePointer, finalxcoordinate, finalycoordinate).build().perform();
//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public MakeItYours getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		int i = 0;
		while (balloon.size() == 0 && i < 20) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			UtilHBM.waitFixTime(1000);
			i++;
		}
		if (i > 5) {
			UtilHBM.reportInfo("Number of clicks to get ballon = " + i);
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}

	public MakeItYours addProductBathroom(String product, boolean defaultStylePrd, boolean applyFilter,
								  boolean checkPrdInfoSheet) {

		String prdPath = UtilHBM.getKeyValue(Setting.bryoBathroomCatalogPath).get(product);
		System.out.println(prdPath);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagoryBathroom(product).addProductDesignStep(product, defaultStylePrd,
				applyFilter, checkPrdInfoSheet);
		Catalog close = PageFactory.initElements(driver, Catalog.class);
		close.closeCatalogPanel();
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//article[@class='mod-properties-window-wide mod-open']/ul/li/ul/li")));
		return this;
	}

	public MakeItYours addProduct(String product, boolean defaultStylePrd, boolean applyFilter,
			boolean checkPrdInfoSheet) {

		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		System.out.println(prdPath);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagory(product).addProductDesignStep(product, defaultStylePrd,
				applyFilter, checkPrdInfoSheet);
		Catalog close = PageFactory.initElements(driver, Catalog.class);
		close.closeCatalogPanel();
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//article[@class='mod-properties-window-wide mod-open']/ul/li/ul/li")));
		return this;
	}


	public MakeItYours addProduct(String product, boolean defaultStylePrd, boolean applyFilter,
			boolean checkPrdInfoSheet, boolean acceptInNoSpaceAvailablePopin) {

		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		System.out.println(prdPath);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIcon(catalogEle).clickSubCatagory(product).addProductDesignStep(product, defaultStylePrd,
				applyFilter, checkPrdInfoSheet);
		Catalog close = PageFactory.initElements(driver, Catalog.class);

		if (acceptInNoSpaceAvailablePopin) {
			UtilHBM.waitExplicitDisplayed(driver, noSpacePopIn);
			Verification.VerifyEquals("Incorrect no space title", noSpaceTitle.getText(), "No space available");
			Verification.VerifyEquals("Incorrect no space info", noSpaceInfo.getText(), " We have not found enough space to correctly position the cabinet. We will put it in the middle of the screen so that you can move it manually.");
			noSpaceOKButton.click();
			UtilHBM.waitFixTime(500);
		}

		close.closeCatalogPanel();
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//article[@class='mod-properties-window-wide mod-open']/ul/li/ul/li")));
		return this;
	}

	public MakeItYours addProductUsingDragDrop(String product, boolean filter, boolean productInfoSheet,
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

	public MakeItYours allowCollision(int x, int y, String positionValueToChange, String pos1) {
		selectProduct(x, y);
		UtilHBM.waitExplicitDisplayed(driver, position);
		UtilHBM.waitExplicitClickable(driver, position);
		position.click();
		UtilHBM.waitFixTime(1000);
//	UtilHBM.waitExplicitDisplayed(driver, allowCollision);
//	UtilHBM.waitExplicitDisplayed(driver, allowCollision);
		allowCollision.click();
		List<WebElement> li = driver.findElements(By.cssSelector(".WallMeasure"));
		int i = 0;
		List<String> values = new ArrayList<String>();
		for (WebElement index : li) {

			if (positionValueToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				index.click();
				for (i = 0; i < positionValueToChange.length(); i++) {
					index.sendKeys(Keys.BACK_SPACE);
				}
				index.sendKeys(pos1 + Keys.ENTER);
				UtilHBM.waitFixTime(1000);
				break;
			} else {
				values.add(index.getAttribute("value"));
			}
		}
		if (!(i > 0)) {
			UtilHBM.reportKO("Position change failed. Expected initial position: " + positionValueToChange);
			UtilHBM.reportKO("Availalbe position values are: " + values.toString());
		}
		clickBlank();
		return this;
	}

	public MakeItYours addNonVisibleItems(String subCatagory, String product, int addCount, int minusCount) {
		accessories.click();
		WebElement catagory = null;
		for (WebElement e : subCatagoryList) {
			if (e.getText().equalsIgnoreCase(subCatagory)) {
				catagory = e;
			}
		}
		catagory.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addNon3DItem(product, addCount, minusCount);
		return this;
	}

	public MakeItYours verifyNonVisibleItems(String subCatagory, String product, int count) {
		accessories.click();
		WebElement catagory = null;
		for (WebElement e : subCatagoryList) {
			if (e.getText().equalsIgnoreCase(subCatagory)) {
				catagory = e;
			}
		}
		catagory.click();
		inMyProjectButton.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.verifyNon3DItems(product, count);
		return this;
	}

	private MakeItYours clickCatalogIcon(WebElement element) {
		element.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "button.bt-icon-label-alt.selected"));
		return this;
	}

	private Catalog clickSubCatagoryBathroom(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoBathroomCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitFixTime(200);
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitDisplayed(driver, subCatagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}

	private Catalog clickSubCatagory(String product) {
		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		String catagory = prdPath.split(">")[2];
		String subcatagory = prdPath.split(">")[3];
		UtilHBM.waitFixTime(200);
		WebElement catagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/h2/button[normalize-space(.)='" + catagory + "']"));
		WebElement subCatagoryEle = driver
				.findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
		Verification.displayOfWebElement(catagoryEle);
		UtilHBM.waitExplicitDisplayed(driver, subCatagoryEle);
		UtilHBM.waitExplicitClickable(driver, subCatagoryEle);
		subCatagoryEle.click();
		WebElement prd = driver.findElement(By.cssSelector(
				"article[id*='catalog-browser']:not([class*='loading'])[class*='mod-open'] #mod-product-list>li[data-ui-id='0']>article>img[srcset*='https']"));
		UtilHBM.waitExplicitDisplayed(driver, prd);
		return PageFactory.initElements(driver, Catalog.class);
	}

	public MakeItYours replaceCustomMaterial(int x, int y, String propertyName, String product, String allOrSelected) {
		selectProduct(x, y).editProperty();

		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.replace(propertyName, product, allOrSelected, true, "");

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours confirmCustomMaterialChange(String acceptChange) {

		ChangeCustomMaterialConfirmation confirm = PageFactory.initElements(driver,
				ChangeCustomMaterialConfirmation.class);
		confirm.confirmCustomMaterialChange(acceptChange);
		clickBlank();

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyCustomMaterial(int x, int y, String propertyName) {
		selectProduct(x, y).editProperty();
		Verification.displayOfWebElement(customMaterialName);
		Verification.displayOfWebElement(customMaterialDesc);
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyCustomMaterial(propertyName);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editFreeStandingWorktopProperties(int x, int y, boolean doubleSided, String wt, String dp, String htFromFloor) {
		selectProduct(x, y).editProperty();
		if (doubleSided) {
			UtilHBM.waitExplicitDisplayed(driver, doubleSidedLabel);
			UtilHBM.waitExplicitDisplayed(driver, doubleSidedToggle);
			WebElement toggle=doubleSidedToggle.findElement(By.cssSelector("input"));
			toggle.click();
//			UtilHBM.waitFixTime(500);
//			UtilHBM.waitExplicitDisplayed(driver, doubleSidedToggle.findElement(By.cssSelector("input:checked[type='checkbox']")));
		}
		if (!(wt.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, worktopDimensionWidth);
			worktopDimensionWidth.click();
			for (int i = 0; i <= wt.length(); i++) {
				worktopDimensionWidth.sendKeys(Keys.BACK_SPACE);
			}
			worktopDimensionWidth.sendKeys(wt);
		}
		if (!(dp.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, worktopDimensionDepth);
			worktopDimensionDepth.click();
			for (int i = 0; i <= dp.length(); i++) {
				worktopDimensionDepth.sendKeys(Keys.BACK_SPACE);

			}
			worktopDimensionDepth.sendKeys(dp);
		}

		if (!(htFromFloor.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, worktopDimensionAltitude);
			worktopDimensionAltitude.click();
			for (int i = 0; i <= htFromFloor.length(); i++) {
				worktopDimensionAltitude.sendKeys(Keys.BACK_SPACE);
			}
			worktopDimensionAltitude.sendKeys(htFromFloor);
		}
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return this;
	}

	public MakeItYours verifyFreeStandingWorktopProperties(int x, int y, String wt, String dp, String htFromFloor) {
		selectProduct(x, y).editProperty();

		if (wt.isEmpty()) {
			UtilHBM.reportOK("Freestanding worktop Width property not available");
		} else if (!(wt.isEmpty())) {
			if (wt.equalsIgnoreCase(worktopDimensionWidth.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding worktop width property changed and value is "
						+ worktopDimensionWidth.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding worktop width property not changed and value is "
						+ worktopDimensionWidth.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding worktop width");
		}

		if (dp.isEmpty()) {
			UtilHBM.reportOK("Freestanding worktop depth property not available");
		} else if (!(dp.isEmpty())) {
			if (dp.equalsIgnoreCase(worktopDimensionDepth.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding worktop depth property changed and value is "
						+ worktopDimensionDepth.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding worktop depth property not changed and value is "
						+ worktopDimensionDepth.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding worktop depth");
		}
		if (htFromFloor.isEmpty()) {
			UtilHBM.reportOK("Freestanding worktop height from floor property not available");
		} else if (!(htFromFloor.isEmpty())) {
			System.out.println("a: " + htFromFloor);
			System.out.println("b: " + worktopDimensionAltitude.getAttribute("value"));
			if (htFromFloor.equalsIgnoreCase(worktopDimensionAltitude.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding worktop height from floor property changed and value is "
						+ worktopDimensionAltitude.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding worktop height from floor property not changed and value is "
						+ worktopDimensionAltitude.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding worktop height from floor");
		}
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return this;
	}
	public MakeItYours editFreeStandingWallPanelProperties(int x, int y, boolean doubleSided, String wt, String ht, String htFromFloor) {
		selectProduct(x, y).editProperty();
		
		if (!(wt.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, wallpanelDimensionWidth);
			wallpanelDimensionWidth.click();
			for (int i = 0; i <= wt.length(); i++) {
				wallpanelDimensionWidth.sendKeys(Keys.BACK_SPACE);
			}
			wallpanelDimensionWidth.sendKeys(wt);
		}
		if (!(ht.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, wallpanelDimensionHeight);
			wallpanelDimensionHeight.click();
			for (int i = 0; i <= ht.length(); i++) {
				wallpanelDimensionHeight.sendKeys(Keys.BACK_SPACE);

			}
			wallpanelDimensionHeight.sendKeys(ht);
		}

		if (!(htFromFloor.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, wallpanelDimensionAltitude);
			wallpanelDimensionAltitude.click();
			for (int i = 0; i <= htFromFloor.length(); i++) {
				wallpanelDimensionAltitude.sendKeys(Keys.BACK_SPACE);
			}
			wallpanelDimensionAltitude.sendKeys(htFromFloor);
		}
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return this;
	}

	public MakeItYours verifyFreeStandingWallPanelProperties(int x, int y, String wt, String ht, String htFromFloor) {
		selectProduct(x, y).editProperty();

		if (wt.isEmpty()) {
			UtilHBM.reportOK("Freestanding Wall Panel Width property not available");
		} else if (!(wt.isEmpty())) {
			if (wt.equalsIgnoreCase(wallpanelDimensionWidth.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding Wall Panel width property changed and value is "
						+ wallpanelDimensionWidth.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding Wall Panel width property not changed and value is "
						+ wallpanelDimensionWidth.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding Wall Panel width");
		}

		if (ht.isEmpty()) {
			UtilHBM.reportOK("Freestanding Wall Panel height property not available");
		} else if (!(ht.isEmpty())) {
			if (ht.equalsIgnoreCase(wallpanelDimensionHeight.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding Wall Panel height property changed and value is "
						+ wallpanelDimensionHeight.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding Wall Panel height property not changed and value is "
						+ wallpanelDimensionHeight.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding Wall Panel height");
		}
		if (htFromFloor.isEmpty()) {
			UtilHBM.reportOK("Freestanding Wall Panel height from floor property not available");
		} else if (!(htFromFloor.isEmpty())) {
			System.out.println("a: " + htFromFloor);
			System.out.println("b: " + wallpanelDimensionAltitude.getAttribute("value"));
			if (htFromFloor.equalsIgnoreCase(wallpanelDimensionAltitude.getAttribute("value"))) {
				UtilHBM.reportOK("Freestanding Wall Panel height from floor property changed and value is "
						+ wallpanelDimensionAltitude.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Freestanding Wall Panel height from floor property not changed and value is "
						+ wallpanelDimensionAltitude.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Freestanding Wall Panel height from floor");
		}
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForEditPanel();
		return this;
	}
	public MakeItYours checkBusinessRulesCount(int expireCount, int warningCount, int recommendCount) {
//		String ruleName = null;
		String ruleCounter = null;
		UtilHBM.waitFixTime(3000);
		JavascriptExecutor excecutor = (JavascriptExecutor) driver;
		excecutor.executeScript("arguments[0].click();", helpButton);
		UtilHBM.waitExplicitDisplayed(driver, refresh);
		new Actions(driver).moveToElement(refresh).click().build().perform();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.turnOffImplicitWaits(driver);
		if (expireCount == 0 && warningCount == 0 && recommendCount == 0 && designErrFreeMsg.isDisplayed()) {
			UtilHBM.reportOK("Design is error free");
		} else if (rulesGroup.size() > 0) {
			for (WebElement rules : rulesGroup) {

				if (rules.isDisplayed()) {
					UtilHBM.waitExplicitDisplayed(driver, rules);
					UtilHBM.waitExplicitClickable(driver, rules);
					if (rules.getText().contains("Expired products ")) {
						;
						String expireCounter = rules.findElement(By.id("expired_counter")).getText();
						ruleCounter = expireCounter.substring(expireCounter.indexOf("(") + 1,
								expireCounter.indexOf(")"));
						int expire = Integer.parseInt(ruleCounter);
						System.out.println("11: " + ruleCounter);
						if (expire == expireCount) {
							UtilHBM.reportOK("Expired products count is correct and count is :" + expire);
						}
					}
					if (rules.getText().contains("Warning ")) {
						String warningCounter = rules.findElement(By.id("warning_counter")).getText();
						ruleCounter = warningCounter.substring(warningCounter.indexOf("(") + 1,
								warningCounter.indexOf(")"));
						System.out.println("11: " + ruleCounter);
						int warn = Integer.parseInt(ruleCounter);
						System.out.println("11: " + ruleCounter);
						if (warn == warningCount) {
							UtilHBM.reportOK("Warning products count is correct and count is :" + warn);
						}
					}
					if (rules.getText().contains("Recommendations ")) {
						String tipCounter = rules.findElement(By.id("tip_counter")).getText();
						ruleCounter = tipCounter.substring(tipCounter.indexOf("(") + 1, tipCounter.indexOf(")"));
						System.out.println("11: " + ruleCounter);
						int tip = Integer.parseInt(ruleCounter);
						System.out.println("11: " + ruleCounter);
						if (tip == recommendCount) {
							UtilHBM.reportOK("Recommendations products count is correct and count is :" + tip);
						}
					}
				}
			}
		} else {
			UtilHBM.reportKO("No Business rule displayed");
		}

		if (helpButton.findElement(By.cssSelector(".icon-action-arrow")).isDisplayed()) {
			helpButton.findElement(By.cssSelector(".icon-action-arrow")).click();
		}

		return this;
	}

	public ItemNotes itemNotes() {
		UtilHBM.waitExplicitDisplayed(driver, itemNotes);
		UtilHBM.waitExplicitClickable(driver, itemNotes);
		Verification.displayOfWebElement(itemNotes);

		itemNotes.click();
		return PageFactory.initElements(driver, ItemNotes.class);

	}

//	public MakeItYours setProductNoteCount() {
//		UtilHBM.waitFixTime(2000);
//		System.out.println("size: " + itemNotesCounter.getText());
//		String initial = itemNotesCounter.getText();
//		int initialCount = Integer.parseInt(initial);
//		System.out.println("No of item notes available " + initialCount);
//		UtilHBM.reportOK("Number of item notes available :" + initialCount);
//		setItemNoteCount(initialCount);
//		return this;
//	}

//	public MakeItYours countAfterProductCustomization() {
//		UtilHBM.waitFixTime(2000);
//		System.out.println("size: " + itemNotesCounter.getText());
//		String initial = itemNotesCounter.getText();
//		int i = Integer.parseInt(initial);
//		if (getItemNoteCount() == i) {
//			UtilHBM.reportOK(
//					"Product customized therefore item note count is same and count is: " + itemNotesCounter.getText());
//		} else {
//			UtilHBM.reportKO("Incorrect Item note count displayed after product customization and count is "
//					+ itemNotesCounter.getText());
//		}
//		itemNotes.click();
//		System.out.println(driver.findElement(By.cssSelector("span[data-ui-selector='item-note-counter']")).getText());
//		String count = driver.findElement(By.cssSelector("span[data-ui-selector='item-note-counter']")).getText();
//		String count2 = driver
//				.findElement(By.cssSelector("span[data-ui-selector='project-note-counter'][aria-hidden='false'] "))
//				.getText();
//		int c = Integer.parseInt(count2);
//		int c1 = Integer.parseInt(count);
//		if (c + c1 == getItemNoteCount()) {
//
//			UtilHBM.reportOK(
//					"Product customized therefore item note count is same and count is: " + itemNotesCounter.getText());
//		} else {
//			UtilHBM.reportKO("Incorrect Item note count displayed after product customization and count is "
//					+ itemNotesCounter.getText());
//		}
//		ItemNotes note = PageFactory.initElements(driver, ItemNotes.class);
//		note.validate();
//		return this;
//	}

//	public MakeItYours countAfterNoteAddEdit() {
//		UtilHBM.waitFixTime(2000);
//		System.out.println("add edit size: " + itemNotesCounter.getText());
//		String initial = itemNotesCounter.getText();
//		int i = Integer.parseInt(initial);
//
//		if (getItemNoteCount() == i - 1) {
//			UtilHBM.reportOK("Product note added and count is " + itemNotesCounter.getText());
//		} else {
//			UtilHBM.reportKO("Incorrect Add/Edit Item note count displayed and count is " + itemNotesCounter.getText());
//		}
//		return this;
//	}
//
//	public MakeItYours countAfterNoteDeleteProductReplace() {
//		UtilHBM.waitFixTime(2000);
//		System.out.println("size: " + itemNotesCounter.getText());
//		String initial = itemNotesCounter.getText();
//		int i = Integer.parseInt(initial);
//
//		if (getItemNoteCount() == i + 1) {
//			UtilHBM.reportOK("Product note deleted and count is " + itemNotesCounter.getText());
//		} else {
//			UtilHBM.reportKO(
//					"Incorrect Delete/Replace Item note count displayed and count is " + itemNotesCounter.getText());
//		}
//		return this;
//	}

	public MakeItYours itemNotesCount(int count) {
		UtilHBM.waitExplicitDisplayed(driver, itemNotes);
		UtilHBM.waitExplicitClickable(driver, itemNotes);
		UtilHBM.waitFixTime(2000);
		System.out.println("size: " + itemNotesCounter.getText());
		String initial = itemNotesCounter.getText();
		int i = Integer.parseInt(initial);
		if (count == i) {
			UtilHBM.reportOK("Correct Item Note count displayed and count is " + itemNotesCounter.getText());
		} else {
			UtilHBM.reportKO(
					"Incorrect Item note count:" + count + " displayed and count is " + itemNotesCounter.getText());
		}

		return this;
	}

//	public void setItemNoteCount(int count) {
////		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitExplicitDisplayed(driver, itemNotes);
//		System.out.println("set count" + count);
//		initialCount = count;
//	}
//
//	public static Integer getItemNoteCount() {
//		return initialCount;
//
//	}
public MakeItYours emptyRoomBathroom(int x, int y, String name, String desc, String yesNo) {
	clickBlank();
	selectProduct(x, y);
	UtilHBM.waitExplicitDisplayed(driver, emptyButton);
	UtilHBM.waitExplicitClickable(driver, emptyButton);
	Verification.displayOfWebElement(roomName);
	Verification.displayOfWebElement(roomSurface);
	String surface = roomSurface.getText();
	System.out.println(surface);
	if (name.equalsIgnoreCase("Bathroom") && surface.startsWith(desc)) {
		emptyButton.click();
		EmptyRoom empty = PageFactory.initElements(driver, EmptyRoom.class);
		empty.emptyRoomPopUp(yesNo);
	}
	return this;
}

	public MakeItYours emptyRoom(int x, int y, String name, String desc, String yesNo) {
		clickBlank();
		selectProduct(x, y);
		UtilHBM.waitExplicitDisplayed(driver, emptyButton);
		UtilHBM.waitExplicitClickable(driver, emptyButton);
		Verification.displayOfWebElement(roomName);
		Verification.displayOfWebElement(roomSurface);
		String surface = roomSurface.getText();
		System.out.println(surface);
		if (name.equalsIgnoreCase("Kitchen") && surface.startsWith(desc)) {
			emptyButton.click();
			EmptyRoom empty = PageFactory.initElements(driver, EmptyRoom.class);
			empty.emptyRoomPopUp(yesNo);
		}
		return this;
	}

	public MakeItYours verifyNoteNotifForCustomCabinet() {
		WebElement notif = driver.findElement(By.xpath("//p[@data-notif-action='note_transferred']/span"));
		if (notif.getText().equalsIgnoreCase("Check the note is still valid for this cabinet.")) {
			UtilHBM.reportOK("Note addded for product after customization is still valid");
		} else
			UtilHBM.reportKO("Note addded for product after customization is not valid");
		WebElement notifi = driver.findElement(By.xpath(
				"//div[@class='mod-notification']/p[@class='success show']/span[@data-ui-selector='notification-text']"));
		if (notifi.getText().equalsIgnoreCase("Your cabinet has been updated in your kitchen.")) {
			UtilHBM.reportOK("Notification displayed after validating customize cabinet. ");
		} else
			UtilHBM.reportKO("Notification not displayed after validating customize cabinet. ");
		return this;
	}

	public MakeItYours verifySinkOffsets(int x, int y, String sinkXOffset, String isSinkXOffsetEditable,
			String sinkYOffset, String isSinkYOffsetEditable, String sideSinkXOffset, String sideSinkYOffset) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifySinkOffsets(sinkXOffset, isSinkXOffsetEditable, sinkYOffset, isSinkYOffsetEditable, sideSinkXOffset,
				sideSinkYOffset);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifySinkMounting(int x, int y, String sinkMounting, String isSinkMountingEditable) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifySinkMounting(sinkMounting, isSinkMountingEditable);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifySinkDrainerGrooves(int x, int y, String areGroovesAdded,
			String isAddDrainerGroovesEditable, String groovesPosition, String isGroovesPositionEditable) {
		selectProduct(x, y).editProperty();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifySinkDrainerGrooves(areGroovesAdded, isAddDrainerGroovesEditable, groovesPosition,
				isGroovesPositionEditable);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyWorktopOptionsOverhangProperty(int x, int y, String overhangLeftOpt,
			String overhangRightOpt, String isLeftOverhangEditable, String isRightOverhangEditable) {
		selectProduct(x, y).verifyWorktopOptionsOverhangProperty(overhangLeftOpt, overhangRightOpt,
				isLeftOverhangEditable, isRightOverhangEditable);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyWorktopOptionsOverhangProperty(String overhangLeftOpt, String overhangRightOpt,
			String isLeftOverhangEditable, String isRightOverhangEditable) {
		editProperty();
		worktopOptionButton();
		OptionsPanel opt = PageFactory.initElements(driver, OptionsPanel.class);
		opt.verifyWorktopOptionOverhangProperties(overhangLeftOpt, overhangRightOpt, isLeftOverhangEditable,
				isRightOverhangEditable);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForOptionPanel();
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyWorktopOptionsProperty(int x, int y, String msg) {
		selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitDisplayed(driver, worktopOptionMsg);
		Verification.VerifyEquals("Worktop options no worktop message ", worktopOptionMsg.getText(), msg);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyEditablePropertyPresent(String property, String isPresent) {
		UtilHBM.waitFixTime(1000);
		boolean editablePropertyFound = false;
		UtilHBM.turnOffImplicitWaits(driver);
		for (WebElement productProperty : productPropertyList) {
			if (productProperty.getAttribute("class").equals("item-edit")) {
				try {
					if (productProperty.findElement(By.cssSelector("span.name")).getText().trim()
							.equalsIgnoreCase(property)
							|| productProperty.findElement(By.cssSelector("label")).getText().trim()
									.equalsIgnoreCase(property)) {
						editablePropertyFound = true;
						break;
					}
				} catch (NoSuchElementException e) {
				}
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if (Boolean.toString(editablePropertyFound).equalsIgnoreCase(isPresent)) {
			UtilHBM.reportOK(
					"Property " + property + (isPresent.equalsIgnoreCase("true") ? " is present" : " is not present"));
		} else {
			UtilHBM.reportKO(
					"Property " + property + (isPresent.equalsIgnoreCase("true") ? " is not present" : " is present"));
		}

		closeEditPanel.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours editFurniture(String depth, String width, String height) {
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		if (!depth.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-depth")).size() > 0) {
				depthInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
				depthInputBoxFurniture.sendKeys(depth);
			} else {
				(new Select(depthSelectionFurniture)).selectByValue(depth);
			}
		}

		if (!width.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-width")).size() > 0) {
				widthInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
				widthInputBoxFurniture.sendKeys(width);
			} else {
				(new Select(widthSelectionFurniture)).selectByValue(width);
			}
		}

		if (!height.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-height")).size() > 0) {
				heightInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
				heightInputBoxFurniture.sendKeys(height);
			} else {
				(new Select(heightSelectionFurniture)).selectByValue(height);
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
//		clickBlank();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyItemNoteAndProductListIconsDistinguishable() {
		Verification.VerifyEquals("Item note icon not distinguishable...", itemNotes
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-notes");
		System.out.println(itemNotes.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
				.getAttribute("xlink:href"));
		Verification.VerifyEquals("Product list icon not distinguishable...", productListIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-function-product-list");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours ungroupProduct(int x, int y) {
		selectProduct(x, y);
		UtilHBM.waitExplicitDisplayed(driver, ungroupButton);
		UtilHBM.waitExplicitClickable(driver, ungroupButton);
		Verification.VerifyEquals("Ungroup icon not as expected...",
				ungroupButton.findElement(By.xpath(".//*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-ungroup");
		ungroupButton.click();
		UtilHBM.waitExplicitDisplayed(driver,
				"//p[@class='success show']/span[text()='Products have been ungrouped.']");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyProductsUngrouped(String prodOffsets) {
		String[] coords = prodOffsets.split("\\s*>\\s*");
		UtilHBM.turnOffImplicitWaits(driver);
		for (String coord : coords) {
			selectProduct(Integer.parseInt(coord.split(",")[0].trim()), Integer.parseInt(coord.split(",")[1].trim()));
			try {
				if (ungroupButton.isDisplayed())
					Assert.fail("Ungroup option still present for product after ungrouping");
			} catch (NoSuchElementException e) {
			}
			UtilHBM.reportOK("Verification success for ungroup product at " + coord);
			UtilHBM.waitFixTime(500);
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, MakeItYours.class);

	}

	public MakeItYours tooltipsForPosition(int x, int y) {
		selectProduct(x, y);
		UtilHBM.waitFixTime(1000);
		position.click();
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForPosition();
		return PageFactory.initElements(driver, MakeItYours.class);

	}

	public ReplaceWithMultipleCabinets replaceWithMultipleProducts(int x, int y) {
		clickBlank();
		selectProduct(x, y);
		editProperty();

		UtilHBM.waitExplicitDisplayed(driver, replaceButton);
		UtilHBM.waitExplicitClickable(driver, replaceButton);
		replaceButton.click();

		UtilHBM.waitExplicitDisplayed(driver, chooseButton);
		UtilHBM.waitExplicitClickable(driver, chooseButton);
		chooseButton.click();

		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, ReplaceWithMultipleCabinets.class);
	}

	public MakeItYours verifyMultiReplacePossible(int x, int y, boolean isMultiReplacePossible) {
		clickBlank();
		selectProduct(x, y);
		editProperty();
		UtilHBM.waitExplicitDisplayed(driver, replaceButton);
		UtilHBM.waitExplicitClickable(driver, replaceButton);
		replaceButton.click();
		UtilHBM.turnOffImplicitWaits(driver);
		try {
			UtilHBM.waitExplicitDisplayed(driver, chooseButton);
			UtilHBM.waitExplicitClickable(driver, chooseButton);
			if (!isMultiReplacePossible)
				Assert.fail(
						"'Choose' button is visible ..., Expected : This button is not visible when multiselect is not possible");
		} catch (NoSuchElementException | TimeoutException ex) {
			if (isMultiReplacePossible)
				Assert.fail("'Choose' button not visible ...");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public MakeItYours verifyRealisticToolTip() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForRealisticImage();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyCurrentSelectedView(String view) {
		switch (view) {
		case "2D":
			if (twoDView.getAttribute("class").contains("bt-icon selected"))
				UtilHBM.reportOK("2D view is selected");
			else
				UtilHBM.reportOK("2D view is not selected");
			break;

		case "3D":
			if (threeDView.getAttribute("class").contains("bt-icon selected"))
				UtilHBM.reportOK("3D view is selected");
			else
				UtilHBM.reportOK("3D view is not selected");
			break;

		case "FP":
			if (fpView.getAttribute("class").contains("bt-icon selected"))
				UtilHBM.reportOK("First person view is selected");
			else
				UtilHBM.reportOK("First person view is not selected");
			break;

		default:
			UtilHBM.reportKO("Wrong Parameter, Expected 2D, 3D or FP");
		}
		return this;
	}

	public MakeItYours verifyReplaceButtonPresent(int x, int y, String isReplaceButtonPresent) {
		selectProduct(x, y).editProperty();

		if (isReplaceButtonPresent.equalsIgnoreCase("yes")) {
			Verification.VerifyEquals("Verification for replace Entire Product failed ", replaceProductText.getText(),
					"Change the entire product?");
			UtilHBM.waitExplicitDisplayed(driver, replaceButton);
		} else {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(replaceButton));
				Assert.fail("Replace button is visible, Expected : Button should not be visible");
			} catch (TimeoutException e) {
				UtilHBM.reportOK("Replace button not present as expected");
			}

		}
		return this;

	}

	public FavoritesList clickOnFavorites() {
		UtilHBM.waitExplicitClickable(driver, favorites);
		WebElement icon = favorites.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(favorites, "Favorites command", "text", "Favorites");
		Verification.displayNAttributeCheckOfElement(icon, "Favorites command icon", "xlink:href",
				"./assets/icons/icons.svg#icon-function-favorite");
		favorites.click();

		return PageFactory.initElements(driver, FavoritesList.class);// return different
	}

	public MakeItYours clickAndDrag(int xOffset, int yOffset) {
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).moveByOffset(xOffset, yOffset).release()
				.build().perform();

		return this;
	}

	public MakeItYours verifyPlinthPropertyRemoved(int x, int y) {
		selectProduct(x, y);
		List<WebElement> plinthOption = driver.findElements(By.cssSelector("li[data-ui-publicationid='plinthOption']"));
		if (plinthOption.size() > 0) {
			UtilHBM.reportKO("plinthOption :option available for cabinet");
		} else
			UtilHBM.reportOK("plinthOption :option not available as altitude is greater than 300mm");
		return this;
	}

	public MakeItYours verifyCustomWorktopModifications(String action, String... customModifications) {
		ChangeCustomMaterialConfirmation worktopConfirmation = PageFactory.initElements(driver,
				ChangeCustomMaterialConfirmation.class);
		worktopConfirmation.verifyCustomModifications(customModifications);
		worktopConfirmation.confirmCustomMaterialChange(action, "yes");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForReplacePanel();
		return this;
	}

	public MakeItYours showNonCompatibleOptions() {
		ChangeCustomMaterialConfirmation worktopConfirmation = PageFactory.initElements(driver,
				ChangeCustomMaterialConfirmation.class);
		worktopConfirmation.showNonCompatibleOptions();
		return this;
	}

	public MakeItYours hideNonCompatibleOptions() {
		ChangeCustomMaterialConfirmation worktopConfirmation = PageFactory.initElements(driver,
				ChangeCustomMaterialConfirmation.class);
		worktopConfirmation.hideNonCompatibleOptions();
		return this;
	}
	
	public MakeItYours moveAvatar(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		selectAvatar(initialxcoordinate, intialycoordinate);
		Actions actions = new Actions(driver);
//		actions.dragAndDropBy(driver.findElement(By.cssSelector("div[class='canvas-wrap cursor-grab']")), finalxcoordinate, finalycoordinate).build().perform();
//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
				.dragAndDropBy(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours selectAvatar(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("div[class='canvas-wrap cursor-grab']")));

		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
	public MakeItYours verifyResetCameraViewIconDisplayedInStep3() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@id='canvas-center'][@style='display: block;']")));
		return PageFactory.initElements(driver, MakeItYours.class);

	}
	public MakeItYours verifyResetCameraViewIconRemovedInStep3() {
		
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 0, 0).clickAndHold().pause(500).release().build().perform();
		Verification.displayOfWebElement(emptyButton);
		clickBlank();
		return PageFactory.initElements(driver, MakeItYours.class);

	}
	public MakeItYours resetCameraView() {
		UtilHBM.waitExplicitDisplayed(driver, resetView);
		UtilHBM.waitExplicitClickable(driver, resetView);
		resetView.click();
		return PageFactory.initElements(driver, MakeItYours.class);

	}
//	<*************************************MOBILE METHODS*****************************************>
	public MakeItYours twoDViewMobile() {
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//div[@class='canvas-tools-navigation']/button[@class='bt-icon selected']")).click();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//section[@class='mod-bottom-sheet']")));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".canvas-tools-navigation.mod-open")));
		twoDView.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public MakeItYours threeDViewMobile() {
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//div[@class='canvas-tools-navigation']/button[@class='bt-icon selected']")).click();
		UtilHBM.waitFixTime(1000);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//section[@class='mod-bottom-sheet']")));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".canvas-tools-navigation.mod-open")));
		threeDView.click();
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@data-ui-action='toggle-bottom-sheet']"))).click()
				.build().perform();
		return this;
	}
	public MakeItYours clickBlankMobile() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, -16, -150).clickAndHold().pause(500).release().build().perform();
			System.out.println("click blank");
			j++;
		}

		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	
	public MakeItYours deleteProductMobile(int x,int y) {
		clickBlankMobile();
		selectProduct(x, y);
		driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='delete']")).click();
		clickBlankMobile();
		return this;
	}
	public MakeItYours closeBottomSheet() {
		UtilHBM.waitExplicitDisplayed(driver, mBottomSheetClose);
		UtilHBM.waitExplicitClickable(driver, mBottomSheetClose);
		Actions actions = new Actions(driver);
		actions.moveToElement(mBottomSheetClose).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet']");
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours openBottomSheet() {
		UtilHBM.waitExplicitDisplayed(driver, mBottomSheetOpen);
		UtilHBM.waitExplicitClickable(driver, mBottomSheetOpen);
		Actions actions = new Actions(driver);
		actions.moveToElement(mBottomSheetOpen).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-bottom-sheet mod-expanded']");
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours addProductMobile(String product, boolean defaultStylePrd, boolean applyFilter,
			boolean checkPrdInfoSheet) {

		String prdPath = UtilHBM.getKeyValue(Setting.bryoINLCatalogPath).get(product);
		System.out.println(prdPath);
		String catalog = prdPath.split(">")[1];
		WebElement catalogEle = driver.findElement(By.xpath("//span[.='" + catalog + "']/.."));
		WebElement catalogIcon = catalogEle.findElement(By.cssSelector("svg>use"));
		Verification.displayOfWebElement(catalogIcon);
		Verification.displayNAttributeCheckOfElement(catalogEle, catalog, "text", catalogEle.getText());
		clickCatalogIconMobile(catalogEle).clickSubCatagoryMobile(product).addProductDesignStep(product, defaultStylePrd,
				applyFilter, checkPrdInfoSheet);
	
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//article[@class='mod-properties-window-wide mod-open']/ul/li/ul/li")));
		UtilHBM.waitFixTime(200);
		closeBottomSheet();
		Actions action=new Actions(driver);
		action.moveToElement(container3D, -7, 215).clickAndHold().pause(500).release().build().perform();
		openBottomSheet();
		return this;
	}
	public MakeItYours selectProductMobile(int x, int y) {
		clickBlankMobile();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector(".mod-properties-window-wide.mod-open")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.cssSelector(".mod-properties-window-wide.mod-open")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	private MakeItYours clickCatalogIconMobile(WebElement element) {
		UtilHBM.waitExplicitClickable(driver, element);
		element.click();
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
	public MakeItYours openCloseMobile(int x1, int y1, int x2, int y2) {
		clickBlankMobile();
		selectProductMobile(x1, y1);
		WebElement opening=driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='open']"));
		Actions action = new Actions(driver);
		action.moveToElement(opening).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='open']/span[contains(text(),'Close')]")));
		UtilHBM.reportOK("Open successful");
		action.moveToElement(opening).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='open']/span[contains(text(),'Open')]")));
		UtilHBM.reportOK("Close successful");
		clickBlankMobile();
		return this;

	}
	public MakeItYours duplicateProductMobile(int x,int y) {
		clickBlankMobile();
		selectProduct(x, y);
		driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@data-ui-action='duplicate']")).click();
		clickBlankMobile();
		return this;
	}
	public MakeItYours addProductThroughSearchMobile(String product, String productToBeaAdded, boolean defaultStylePrd) {
		WebElement searchButton=driver.findElement(By.xpath("//div[@class='bottom-sheet-content-inner']/div/ul/li/button[@id='search']"));
		UtilHBM.waitExplicitDisplayed(driver, searchButton);
		UtilHBM.waitExplicitClickable(driver, searchButton);
		new Actions(driver).moveToElement(searchButton).build().perform();
		searchButton.click();
		search(product).addProductFromSearchOrReplace(productToBeaAdded, defaultStylePrd, false);
		clickBlankMobile();
		return this;
	}

    public MakeItYours verifyReplacementOptionsAvailable(int x, int y, String propertyName, int expectedReplacements) {
		clickBlank();
		selectProduct(x,y);
		editProperty();
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		int availableReplacements = property.getReplacementOptionsCount(propertyName);
		Assert.assertEquals(availableReplacements,expectedReplacements,"Unexpected Replacement count : ");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogForReplacePanel();
		catalog.closeCatalogPanel();
		return PageFactory.initElements(driver, MakeItYours.class);
    }
    public MakeItYours saveProjectInStep3Mobile(SignUpData signUpData, String name, String desc) {
		clickSave(signUpData);
		SaveProject save = PageFactory.initElements(driver, SaveProject.class);
		save.saveProjectMobile(name, desc);
//		verifySavedProjectDetails(name);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
    public StartNow closePlannerMobile() {
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, closePlanner);
		UtilHBM.waitExplicitClickable(driver, closePlanner);
		new Actions(driver).moveToElement(closePlanner).build().perform();
		new Actions(driver).moveToElement(closePlanner).click().build().perform();
		driver.switchTo().parentFrame();

		return PageFactory.initElements(driver, StartNow.class);
	}
    public MakeItHappen step4Mobile() {
		System.out.println(nextStep4Mobile.getText());
		UtilHBM.waitExplicitDisplayed(driver, nextStep4Mobile);
		UtilHBM.waitExplicitClickable(driver, nextStep4Mobile);
		nextStep4Mobile.click();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItYours verifyBackPlinthOptionAvailable(int x, int y, boolean isBackPlinthOptionAvailable) {
		clickBlank().selectProduct(x, y).editProperty();
		boolean isPlinthOptionsVisible = driver.findElements(By.cssSelector("li[data-ui-publicationid='plinthOption'] button[data-ui-action='product-option-more']")).size() > 0;
		if (isBackPlinthOptionAvailable != isPlinthOptionsVisible)
			UtilHBM.reportKO("Plint option visibllity : " + isPlinthOptionsVisible + " , Expected : " + isBackPlinthOptionAvailable);
		return this;
	}

	public MakeItYours setPlinthOption(int x, int y, boolean backPlinthOption) {
		clickBlank().selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitDisplayed(driver, plinthOption);
		plinthOption.click();
		UtilHBM.waitExplicitDisplayed(driver, backPlinthToggle.findElement(By.xpath("./following-sibling::span")));
		if (backPlinthToggle.isSelected() != backPlinthOption) backPlinthToggle.click();
		return this;
	}

	public MakeItYours verifyPlinthOption(int x, int y, boolean isbackPlinthOptionSelected) {
		clickBlank().selectProduct(x, y).editProperty();
		UtilHBM.waitExplicitDisplayed(driver, plinthOption);
		plinthOption.click();
		UtilHBM.waitExplicitDisplayed(driver, backPlinthToggle.findElement(By.xpath("./following-sibling::span")));
		if (backPlinthToggle.isSelected() != isbackPlinthOptionSelected)
			UtilHBM.reportKO("isbackPlinthOptionSelected  : " + backPlinthToggle.isSelected() + ", Expected : " + isbackPlinthOptionSelected);
		return this;
	}

	public MakeItYours verifyFurnitureDimensionEditable(String depth, String width, String height) {
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		if (!depth.isEmpty()) {
			boolean isEditable = Boolean.parseBoolean(depth.split(":")[0]);
			Assert.assertEquals(isEditable, driver.findElements(By.cssSelector("li[data-ui-publicationid='depth'].item-edit-options")).size()>0);
			if (depth.contains(":")) {
				String expectedType = depth.split(":")[1].trim();
				switch (expectedType) {
				case "continuous":
					Assert.assertTrue(depthInputBoxFurniture.isDisplayed());
					break;

				case "discrete":
				default:
					Assert.assertTrue(depthSelectionFurniture.findElement(By.xpath("./parent::span")).isDisplayed());
			}}
		}

		if (!width.isEmpty()) {
			boolean isEditable = Boolean.parseBoolean(width.split(":")[0]);
			Assert.assertEquals(isEditable, driver.findElements(By.cssSelector("li[data-ui-publicationid='width'].item-edit-options")).size()>0);
			if (width.contains(":")) {
				String expectedType = width.split(":")[1].trim();
				switch (expectedType) {
				case "continuous":
					Assert.assertTrue(widthInputBoxFurniture.isDisplayed());
					break;

				case "discrete":
				default:
					Assert.assertTrue(widthSelectionFurniture.findElement(By.xpath("./parent::span")).isDisplayed());
			}}
		}

		if (!height.isEmpty()) {
			boolean isEditable = Boolean.parseBoolean(height.split(":")[0]);
			Assert.assertEquals(isEditable, driver.findElements(By.cssSelector("li[data-ui-publicationid='height'].item-edit-options")).size()>0);
			if (height.contains(":")) {
				String expectedType = height.split(":")[1].trim();
				Assert.assertEquals(isEditable, driver.findElement(By.cssSelector("li[data-ui-publicationid='height'].item-edit-options")).isDisplayed());
				switch (expectedType) {
					case "continuous":
						Assert.assertTrue(heightInputBoxFurniture.isDisplayed());
						break;

					case "discrete":
					default:
						Assert.assertTrue(heightSelectionFurniture.isDisplayed());
				}
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		clickBlank();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyFurnitureDimensions(String depth, String width, String height) {
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		if (!depth.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-depth")).size() > 0) {
				Verification.VerifyEquals("Furniture depth not mathched", depthInputBoxFurniture.getAttribute("value"), depth);
			} else {
				Verification.VerifyEquals("Furniture depth not mathched", (new Select(depthSelectionFurniture)).getFirstSelectedOption().getText(), depth);
			}
		}

		if (!width.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-width")).size() > 0) {
				Verification.VerifyEquals("Furniture width not mathched", widthInputBoxFurniture.getAttribute("value"), width);
			} else {
				Verification.VerifyEquals("Furniture width not mathched", (new Select(widthSelectionFurniture)).getFirstSelectedOption().getText(), width);
			}
		}

		if (!height.isEmpty()) {
			if (driver.findElements(By.cssSelector("fieldset>p>span>#edit-form-input-height")).size() > 0) {
				Verification.VerifyEquals("Furniture height not mathched", heightInputBoxFurniture.getAttribute("value"), height);
			} else {
				Verification.VerifyEquals("Furniture height not mathched", (new Select(heightSelectionFurniture)).getFirstSelectedOption().getText(), height);
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		clickBlank();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyErrorMessage(String field, String expectedErrMsg) {
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		for (int counter=0; counter< 5 ; counter++) {
			try {
				String errMsg = driver.findElement(By.cssSelector("li[data-ui-publicationid='"+field+"'] b.error")).getText().trim();
				Verification.VerifyEquals("Unexpected error msg : " , errMsg, expectedErrMsg);
				break;
			} catch (NoSuchElementException e) {
				if(counter==4)throw e;
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyPossibleValues(String field, String values) {
		List<String> expectedVals= new ArrayList<>(Arrays.asList(values.split("\\s*>\\s*")));
		List<String> availableOptions = new ArrayList<>();
		for(WebElement opt : new Select(driver.findElement(By.cssSelector("li[data-ui-publicationid='"+field+"'] select"))).getOptions()){
			availableOptions.add(opt.getText().trim());
		}
		List<String> commonVals=new ArrayList<>(expectedVals);
		commonVals.retainAll(availableOptions);

		expectedVals.removeAll(commonVals);
		if (expectedVals.size() > 0) UtilHBM.reportKO("Expected values not available in options : "+expectedVals);

		availableOptions.removeAll(expectedVals);
		if (availableOptions.size() > 0) UtilHBM.reportKO("Values available in options but not expected: "+availableOptions);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours verifyBottomSheetToolsForCabinetMobile(int x,int y, String options) {
		clickBlankMobile();
		selectProduct(x, y);
		List<String> expectedOptions = new ArrayList<>(Arrays.asList(options.split("\\s*>\\s*")));

		List<String> availableOptions = new ArrayList<>();
		UtilHBM.waitExplicitDisplayed(driver, bottomSheetTools);
		for (WebElement ele : bottomSheetTools.findElements(By.cssSelector("li>button"))) {
			availableOptions.add(ele.getText().trim());
		}

		List<String> commonOpts = new ArrayList<>(expectedOptions);
		commonOpts.retainAll(availableOptions);

		expectedOptions.removeAll(commonOpts);
		if (!expectedOptions.isEmpty())
			UtilHBM.reportKO("Following bottom sheet tools for cabinet not available : " + expectedOptions);
		availableOptions.removeAll(commonOpts);
		if (!availableOptions.isEmpty())
			UtilHBM.reportKO("Following bottom sheet tools for cabinet not expected : " + availableOptions);

		clickBlankMobile();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
}
