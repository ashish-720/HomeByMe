package hbm.planner.pageobject;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.Baner;
import hbm.web.pageobject.CompleteProfile;
import hbm.web.pageobject.IDSInfoPage;
import hbm.web.pageobject.InfoPageGeometryEditor;
import hbm.web.pageobject.MyProjects;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.SignUp;
import hbm.web.pageobject.Upload3dModel;
import hbm.web.pageobject.UserHomePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ThreeDPlanner {

	WebDriver driver;
	
	public ThreeDPlanner(WebDriver driver){
		this.driver = driver;
	}	
//	Screen s = new Screen();
		
	@CacheLookup
	@FindBy(css = "body>div>header>div>div>#btn-save")
	private WebElement saveButton;
	
	@FindBy(css=".notifMsg-item.is-fadeIn.play.notifMsg-item--success>.notifMsg-item-txt")
	private WebElement saveSuccessMsg;
	
	@CacheLookup
	@FindBy(css = "body>div>header>div>div>#btn-undo")
	private WebElement undoButton;
	
	@CacheLookup
	@FindBy(css = "body>div>header>div>div>#btn-redo")
	private WebElement redoButton;

	@CacheLookup
	@FindBy(css = "body>div>header>div>div>#button-help")
	private WebElement helpButton;
	
	@CacheLookup
	@FindBy(css="body>div>div>#draw-commands>div>.dropdown-list-button.icon.icon-draw")
	private WebElement designFloorPlan;	
	
	@FindBy(xpath = "//div[@id='draw-commands']/div/div/div/div/a[@class='icon icon-wall']/../..")
	private WebElement designAWall;	
	
	@FindBy(xpath="//div[@id='draw-commands']/div/div/div/div/a[@class='icon icon-room-shape']/../..")
	private WebElement addARoom;
	
	@FindBy(xpath="//div[@id='draw-commands']/div/div/div/div/a[@class='icon icon-separation']/../..")
	private WebElement roomSeparator;
	
	@FindBy(xpath = "//div[@id='draw-commands']/div/div/div/div/a[@class='icon icon-exterior']/../..")
	private WebElement exterior;
	
	@CacheLookup
	@FindBy(css="body>div>div>#catalog-commands>div>.dropdown-list-button.icon.icon-catalogue")
	private WebElement catalog;
	
	@FindBy(xpath = "//div[@id='catalog-commands']/div/div/div/div/a[@class='icon icon-building']/../..")
	private WebElement build;
	
	@FindBy(xpath = "//div[@id='catalog-commands']/div/div/div/div/a[@class='icon icon-furniture']/../..")
	private WebElement furnish;
	
	@FindBy(xpath = "//div[@id='catalog-commands']/div/div/div/div/a[@class='icon icon-decoration']/../..")
	private WebElement decorate;
	
	@FindBy(xpath = "//div[@id='catalog-commands']/div/div/div/div/a[@class='icon icon-brands']/../..")
	private WebElement brands;	
	
	@FindBy(xpath = "//div[@id='catalog-commands']/div/div/div/div/a[@class='icon icon-like']/../..")
	private WebElement favorites;
	
	@FindBy(xpath = "//div[text()='Community content']")
	private WebElement communityContent;
	
	@FindBy(xpath = "//div[text()='My content']")
	private WebElement myContent;
	
	@FindBy(xpath = "//div[text()='Arrow']")
	private WebElement arrow;
	
	@FindBy(xpath = "//div[text()='Rectangle']")
	private WebElement rectangle;
	
	@FindBy(xpath = "//div[text()='Ellipse']")
	private WebElement ellipse;
	
	@FindBy(xpath = "//div[text()='Insert image']")
	private WebElement insertImage;
	
	@FindBy(xpath = "//div[text()='Hide annotations']")
	private WebElement hideAnnotations;
	
	@FindBy(xpath = "//div[text()='Show annotations']")
	private WebElement showAnnotations;
	
	@FindBy(css = "#annotation-commands")
	private WebElement annotation;
	
	@CacheLookup
	@FindBy(css="body>div>div>#media-commands>div>.dropdown-list-button.icon.icon-screenshot")
	private WebElement photo;
		
	@FindBy(xpath="//div[@id='media-commands']/div/div/div/div/a[@class='icon icon-screenshot']/../..")
	private WebElement snapshotButton;
	
	@FindBy(xpath="//div[@id='media-commands']/div/div/div/div/a[@class='icon icon-realistic']/../..")
	private WebElement realisticImageButton;
		
	@FindBy(xpath="//div[@id='media-commands']/div/div/div/div/a[@class='icon icon-panoramic']/../..")
	private WebElement panoramic360;
	
	@CacheLookup
	@FindBy(id = "buy-render")
	private WebElement buyCreditButton;
	
	@FindBy(css = ".toolBar>.toolBar-group.toolsBar--all>#media-button")
	private WebElement mediaBtn;
	
	@CacheLookup
	@FindBy(css = "body>div>.toolBar>div>#mesure-button")
	private WebElement measureButton;	
	
	@CacheLookup
	@FindBy(css = "body>div>header>.head-item>a>.head-title")
	private WebElement projectTitle;
	
	@CacheLookup
	@FindBy(css = "body>div>header>.head-item>#project-details")
	private WebElement projectDetail;
	
	@CacheLookup
	@FindBy(css="body>div>header>.head-item>img")
	private WebElement hbmSymbol;
	
//	@CacheLookup
//	@FindBy(css = "span[title= 'Add a product']")
//	private WebElement addAProduct;
	
	@CacheLookup
	@FindBy(css="body>div>div>#catalog-commands")
	private WebElement catalogCommands;	
	
	@CacheLookup
	@FindBy(css = ".username")
	private WebElement username;
	
	@CacheLookup
	@FindBy(css = "header>div>a>#current-level")
	private WebElement currentLevel;
	
	@CacheLookup
	@FindBy(css = "div[class = 'head-item u-prn dropdown dropdown--floor is-collapse'][id = 'levelNavigator-button']")
	private WebElement levelNavCollapsed;
	
	@CacheLookup
	@FindBy(css = "div[class = 'head-item u-prn dropdown dropdown--floor'][id = 'levelNavigator-button']")
	private WebElement levelNavNotCollapsed;
	
//	@FindBy(css=".toolBar-group-infos")
//	private List<WebElement> propertiesList;
		
	@FindBy(css = "body>div>div>div>div>ul>li>#bt-icon-view-3d")
	private WebElement threeDView;
	
	@CacheLookup
	@FindBy(css = "body>div>div>div>div>ul>li>#bt-icon-view-2d")
	private WebElement twoDView;	
	
	@CacheLookup
	@FindBy(css = "body>div>div>div>div>ul>li>#bt-icon-view-fp")
	private WebElement firstPersonView;
	
//	@CacheLookup
//	@FindBy(xpath = "//a[@id='squareRoom-button']/../..")
//	private WebElement addARoom;
	
	@CacheLookup
	@FindBy(id = "button-zoom-in")
	private WebElement zoomIn;
	
	@CacheLookup
	@FindBy(id = "button-zoom-out")
	private WebElement zoomOut;
	
	@FindBy(css=".noUi-base")
	private WebElement zoomSliderDase;
	
	@FindBy(css=".noUi-handle noUi-handle-upper")
	private WebElement zoomHandle;
	
	@FindBy(css=".noUi-origin.noUi-connect.noUi-stacking")
	private WebElement zoomHandlePosition;	
	
//	@CacheLookup
//	@FindBy(xpath = "//a[@id='wall-button']/../..")
//	private WebElement designAWall;
//	
//	@CacheLookup
//	@FindBy(xpath = "//a[@id='roomSeparator-button']/../..")
//	private WebElement roomSeparator;
		
	@FindBy(id ="validate-design-tool")
	private WebElement validateButton;
	
	@FindBy(css=".canvas>input[placeholder='Measure2D']")
	private List<WebElement> measureList;
	

	@FindBy(css = "#notifText")
	private WebElement messageNotification;
	
	
	@FindBy(css = "a[class ='close-notif button button--small']")
	private WebElement messageNotificationCloseButton;
	
	@FindBy(css=".overlay-top-title-message")
	private WebElement productPlacementInstruction;
	
	@CacheLookup
	@FindBy(css=".button-close.button-close-embed")
	private WebElement closePlanner;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']")
	private WebElement bubbleToolbar;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']")
	private List<WebElement> bubbleCommandlist;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-infos.bt-icon-label")
	private WebElement infoBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-room.bt-icon-label")
	private WebElement addBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>[data-i18n='[title]property.toggle_light']")
	private WebElement lightBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>[data-i18n='[title]property.toggle_light']>svg>use")
	private WebElement lightBubbleIcon;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-duplicate.bt-icon-label")
	private WebElement duplicateBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-replace.bt-icon-label")
	private WebElement replaceBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-ungroup.bt-icon-label")
	private WebElement ungroupBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-configure.bt-icon-label")
	private WebElement configureBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-edit.bt-icon-label")
	private WebElement editBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-trash.bt-icon-label")
	private WebElement deleteBubble;

	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>[data-ui-action='select_all']")
	private WebElement includeAccessoriesBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-clean.bt-icon-label")
	private WebElement emptyBubble;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-decoration.bt-icon-label")
	private WebElement reUseBubble;
	
	@FindBy(css = "#validate-design-tool")
	private WebElement validateReuse;
	
	@FindBy(css="body>div>div>div:not([style*='visibility: hidden;'])[class='mod-bubble']>ul>li>.icon.icon-split.bt-icon-label")
	private WebElement splitBubble;
	
	@FindBy(css=".mod-bubble .icon.icon-next.bt-icon-label[data-ui-action='assemblyAnimate']")
	private WebElement animateBubble;
	
	
	@FindBy(css=".BayMeasure.Tag3D.visibility-visible.pointer-events-activated")
	private List<WebElement> bayDimList;
	
	@FindBy(css=".BayMeasure.Tag3DMeasure2D.visibility-visible.direction-row>input")
	private WebElement bayDimInput;
	
	@FindBy(css="body>div>.toolBar>div>div>div>.toolbar-brand-info")
	private WebElement toolbarBrandInfo;
	
	@FindBy(css="body>div>.toolBar>div>div>div>.toolbar-logo>img")
	private WebElement toolbarBrandLogo;
	
	@FindBy(id="bmSVG")
	private WebElement container3D;
	
	@FindBy(id="inputUsername")
	private WebElement usernameDev;
	
	@FindBy(id="inputPassword")
	private WebElement pwdDev;
	
	@FindBy(id="loginFormBtn")
	private WebElement loginBtnDev;
	
	// for standalone planner for dev team
	
	@FindBy(id="link-toggle-debug-menu")
	private WebElement debugMenu;
	
	@FindBy(xpath="//div/a[.='Create a project']")
	private WebElement createProjectDev;
	
	@FindBy(xpath="//div/a[.='Get all projects']")
	private WebElement getAllProject;
	
	@FindBy(css=".grid>.w-33.u-mbs")
	private List<WebElement> projectList;
	
	@FindBy(css = "#btn-export")
	private WebElement export;
	
	@FindBy(css = "[data-i18n='common.download']")
	private WebElement downloadDraftSightFile;
	
	@FindBy(css = "[data-i18n='common.cancel']")
	private WebElement cancelDraftSightFile;
	
	@FindBy(css = "[class='u-center u-mbxs']>img")
	private WebElement imageDS;
	
	@FindBy(css = "[data-i18n='exportDraftSight.modal.title']")
	private WebElement titleDS;
	
	@FindBy(css = "[data-i18n='[html]exportDraftSight.modal.description']")
	private WebElement descriptionDS;
	
	@FindBy(css="html>body#whole_container>#modal-cloneProject>div.modal-header>h2")
	private WebElement title;
	
	@FindBy(css = ".annotation-text-content")
	private List<WebElement> textBox; 
	
	@FindBy(css="[data-ui-action='notif-link-click']")
	private WebElement includeAccessNotificationText;
	
	@FindBy(css= ".bt-icon-alt>.icon-view-close")
	private WebElement closeIncludeAccessNotificationText;
	
	@FindBy(css= "[data-ui-selector='notification-text']")
	private WebElement includeAccessNotificationmsg;
	
	@FindBy (xpath ="//a[text()='View all']")
	WebElement viewAll;
	
	@FindBy(css ="div[class='flex flex--separate flex--wrap']>.u-mbs.product.w-20")
	private List<WebElement>  myContentList;
	
	@FindBy(css = ".mod-notification>.error.show>span")
	WebElement lockmsg;

	@FindBy(css= "header>div>a>div[id='lock-level-icon'][style='display: inline-block;']")
	private List <WebElement> lockSignDisplayed;
	
	@FindBy(css= "header>div>a>div[id='lock-level-icon'][style='display: none;']")
	private List <WebElement> lockSignNotDisplayed;
	
	@FindBy(css = "#app-notification>p.success")
	private WebElement successNotification;
	
	public ThreeDPlanner save(){
//		for (String winHandle: driver.getWindowHandles()){			
//			driver.switchTo().window(winHandle);
//		}
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, saveSuccessMsg);
		Verification.displayNAttributeCheckOfElement(saveSuccessMsg, "Project saved message", "text", "Your project has been saved.");
		/*if(saveSuccessMsg.getText().equalsIgnoreCase("Your project has been saved.")){
			UtilHBM.reportOK("Project Saved");
		}else{
			UtilHBM.waitFixTime(2000);
			if(UtilHBM.listOfWebElement(driver, "#notifText").get(0).getText().equalsIgnoreCase("Your project has been saved.")){
				UtilHBM.reportOK("Project Saved (after wait)");
			}else{
				UtilHBM.reportKO("Project not saved even after waiting");
			}
		}*/
		messageNotificationCloseButton.click();
		
		return this;
	}	
	
	
	/*
	 * public ThreeDPlanner saveTrialProject(SignUpData signUpData){
	 * saveButton.click(); for (String winHandle: driver.getWindowHandles()){
	 * driver.switchTo().window(winHandle); } SignUp signUp =
	 * PageFactory.initElements(driver, SignUp.class);
	 * signUp.loginTrialProject(signUpData); // SaveCopy save =
	 * PageFactory.initElements(driver, SaveCopy.class); // save.saveCopy(); //
	 * driver.findElement(By.xpath("//a[@id='cloneProjectBtn']")).click(); for
	 * (String winHandle: driver.getWindowHandles()){
	 * driver.switchTo().window(winHandle); } UtilHBM.waitExplicitDisplayed(driver,
	 * UtilHBM.webElement(driver, "#notifText")); if(UtilHBM.webElement(driver,
	 * "#notifText").getText().equalsIgnoreCase("Your project has been saved.")){
	 * UtilHBM.reportOK("Project Saved"); }else{ UtilHBM.waitFixTime(2000);
	 * if(UtilHBM.webElement(driver,
	 * "#notifText").getText().equalsIgnoreCase("Your project has been saved.")){
	 * UtilHBM.reportOK("Project Saved (after wait)"); }else{
	 * UtilHBM.reportKO("Project no saved even after waiting"); } } return this; }
	 */
	
	
	public ThreeDPlanner saveGalleryProject(SignUpData signUpData,String projectName) {
		saveButton.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(UtilHBM.webElement(driver, ".registration-modal-standalone"));		
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.loginTrialProject(signUpData);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("planner-embed-iframe");
		SaveCopy save = PageFactory.initElements(driver, SaveCopy.class);
		save.saveCopy(projectName);
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, saveSuccessMsg);
		Verification.displayNAttributeCheckOfElement(saveSuccessMsg, "Project saved message", "text", "Your project has been saved.");
		messageNotificationCloseButton.click();
		return this;
	}
	

	public ThreeDPlanner addARoom(int roomNumber, String surfaceArea, String selectRoomType){
//		designFloorPlan.click();
//		UtilHBM.waitExplicitClickable(driver, addARoom);
//		addARoom.click();
		new Actions(driver).moveToElement(designFloorPlan).build().perform();
		UtilHBM.waitExplicitClickable(driver, addARoom);
		addARoom.click();
//		new Actions(driver).moveToElement(designFloorPlan).click(addARoomButton).build().perform();
		AddARoom room = PageFactory.initElements(driver, AddARoom.class);
		room.roomDetails(roomNumber, surfaceArea, selectRoomType);	
		return this;
	}
	/*
	public ThreeDPlanner exterior(String referenceImg, int exteriorTypeNo, String surfaceArea){
		Location loc = UtilHBM.getLocation(referenceImg);
		new Actions(driver).moveToElement(designFloorPlan).build().perform();
		UtilHBM.waitExplicitClickable(driver, exterior);
		exterior.click();
		DesignYourExterior selectExterior = PageFactory.initElements(driver, DesignYourExterior.class);
		selectExterior.createExterior(exteriorTypeNo, surfaceArea);
		loc.hover();
		UtilHBM.waitFixTime(2000);
		turnOffImplicitWaits();
		int i = 0;
		do{
			loc.click();
			i++;			
		}while(UtilHBM.listOfWebElement(driver, ".overlay-top-title-message").size()>0 && i<10);		
		turnOnImplicitWaits();		
		return this;
	}
	
	public ThreeDPlanner delete(String img){
//		UtilHBM.clickImgTillElementAvailable(driver, img, bubbleCommandlist, 0, 0);
		clickImgTillPropertiesAppear(img, 0, 0);
		deleteBubble.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	*/
	public ThreeDPlanner threeDView(){
		threeDView.click();
		UtilHBM.waitFixTime(5000);		
		return this;		
	}
	
	public ThreeDPlanner twoDView(){
		twoDView.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public ThreeDPlanner firstPersonView(){
		firstPersonView.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public ThreeDPlanner snapshot3D(String name, int index){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, snapshotButton);		
		snapshotButton.click();
		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
		snap.takeSnapshot3D(name, index);
		UtilHBM.reportOK("Snapshot captured");
		return this;		
	}
	
	public ThreeDPlanner snapshot2D(String name, String displayFurnature, boolean mtl, boolean measure, String size, boolean roomName, boolean roomArea, boolean codeQR, boolean annotations){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, snapshotButton);		
		snapshotButton.click();
		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
		snap.takeSnapshot2D(name, displayFurnature, mtl, measure, size, roomName, roomArea, codeQR, annotations);
		UtilHBM.reportOK("Snapshot captured");
		return this;		
	}
	
//	public ThreeDPlanner snapshot2D(String name, String displayFurnature, boolean mtl, boolean measure, String size, boolean roomName, boolean roomArea){
//		new Actions(driver).moveToElement(photo).build().perform();
//		UtilHBM.waitExplicitClickable(driver, snapshotButton);		
//		snapshotButton.click();
//		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
//		snap.takeSnapshot2D(name, displayFurnature, mtl, measure, size, roomName, roomArea);
//		UtilHBM.reportOK("Snapshot captured");
//		return this;		
//	}
	
	
	// to be completed
	public ThreeDPlanner snapshot(){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, snapshotButton);		
		snapshotButton.click();
		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
		snap.takeSnapshot("");
		UtilHBM.reportOK("Snapshot captured");
		return this;		
	}	
	
	public  MyImages myImages(){
		mediaBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, "//article[@class='mod-layer-medias mod-open']/div/div/div[@class='wrap']/div/ul/li/button[@data-ui-filter='all']");		
		return PageFactory.initElements(driver, MyImages.class);
	}
	
	public  ThreeDPlanner screenshotShareCheck(int imageNumber){
		myImages();
		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
//		snap.shareOptionCheckScreenshot(imageNumber);		
		return this;
	}
	
	/*
	public ThreeDPlanner screenshotDelete(int imageNumber, int confirm0ForNo1ForYes){
		new Actions(driver).moveToElement(media).build().perform();
		UtilHBM.waitExplicitClickable(driver, snapshotButton);	
		snapshotButton.click();
		Snapshot snap = PageFactory.initElements(driver, Snapshot.class);
		snap.deleteScreenshot(imageNumber, confirm0ForNo1ForYes);
		return this;
	}
	*/
	
	public RealisticImage realisticImageClick(){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, realisticImageButton);
		realisticImageButton.click();		
		return PageFactory.initElements(driver, RealisticImage.class);
	}
	/*
	public ThreeDPlanner realisticImage(String smallOrLarge, boolean displayPeople){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, realisticImageButton);
		realisticImageButton.click();		
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImage(smallOrLarge, displayPeople);		
		return this;
	}
	
	public ThreeDPlanner realisticImageMultiRequest(String smallOrLarge, int backgroundNo, boolean displayPeople, int noOfImages){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, realisticImageButton);
		realisticImageButton.click();		
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImageMulti(smallOrLarge, backgroundNo, displayPeople, noOfImages);		
		return this;
	}
	*/
	/*
	public ThreeDPlanner realisticImageDelete(int imageNumber, int confirm0ForNo1ForYes){
		new Actions(driver).moveToElement(media).build().perform();
		UtilHBM.waitExplicitClickable(driver, realisticImageButton);
		realisticImageButton.click();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.deleteRealistcImage(imageNumber, confirm0ForNo1ForYes);
		return this;
	}
	
	public ThreeDPlanner realisticImageShareCheck(int imageNumber){
		new Actions(driver).moveToElement(media).build().perform();
		UtilHBM.waitExplicitClickable(driver, realisticImageButton);
		realisticImageButton.click();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.shareOptionCheck(imageNumber);
		return this;
	}	
	
	public ThreeDPlanner realisticImageLarg() {
		realisticImageButton.click();
		RealisticImage image = PageFactory.initElements(driver, RealisticImage.class);
		image.realisticImage("large");
		return this;
	}
	
	
	public ThreeDPlanner measureEdit(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2, String newValue){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.editMeasure(img, xPoint1, yPoint1, xPoint2, yPoint2, newValue);
		return this;
	}
	
	public ThreeDPlanner measureCheck(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.checkMeasure(img, xPoint1, yPoint1, xPoint2, yPoint2);
		return this;
	}
	
	public ThreeDPlanner verifyMeasure(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.verifyMeasure(img, xPoint1, yPoint1, xPoint2, yPoint2, expectedDist);
		return this;
	}
	*/
	
	public ThreeDPlanner panoramic360(int backgroundNo){
		new Actions(driver).moveToElement(photo).build().perform();
		UtilHBM.waitExplicitClickable(driver, panoramic360);		
		panoramic360.click();
		Panoramic360 panoramic = PageFactory.initElements(driver, Panoramic360.class);
		panoramic.panoramic360(backgroundNo);
		return this;
	}
	
	public ThreeDPlanner annotation(String annotations, int xOffset, int yOffset){
		new Actions(driver).moveToElement(annotation).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, ellipse);
		UtilHBM.waitExplicitClickable(driver, ellipse);
		switch(annotations){
		case "Arrow":
			arrow.click();
			break;
		case "Rectangle":
			rectangle.click();
			break;
		case "Ellipse":
			ellipse.click();
			break;
		case "Insert image":
			insertImage.click();
			clickObjTillPropertiesAppearDev(xOffset, yOffset);
			break;
		case "Hide annotations":
			hideAnnotations.click();						
			break;
		case "Show annotations":
			showAnnotations.click();
			break;
		}
		if(!annotations.equalsIgnoreCase("Hide Annotation")){
			int i=0;
			UtilHBM.turnOffImplicitWaits(driver);
			do{
				clickInPlanner(xOffset, yOffset);
				UtilHBM.waitFixTime(500);
				i++;
			}while(!(bubbleCommandlist.size()>0)&& i<5);
			UtilHBM.turnOnImplicitWaits(driver);
		}		
		return this;
	}
	
	public ThreeDPlanner textInput(int xOffset, int yOffset, String text, int index){
		clickInPlanner(xOffset, yOffset);
		textBox.get(index).sendKeys(text);
		return this;
	}
	
	public UserHomePage closePlanner(){	
		closePlanner.click();	
		driver.switchTo().parentFrame();
		driver.navigate().refresh();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public MyProjects closePlannerReturnMyProject(){	
		closePlanner.click();	
		driver.switchTo().parentFrame();
		driver.navigate().refresh();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	public ProjectPage closePlannerReturnProjectPage(){	
		closePlanner.click();	
		driver.switchTo().parentFrame();
		driver.navigate().refresh();
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class='async-hide']"));
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class='']"));
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public UserHomePage closePlannerWithoutSave(){	
		closePlanner.click();
		UtilHBM.webElement(driver, "#embedQuitPanel-btn-cancel").click();
		driver.switchTo().parentFrame();
		driver.navigate().refresh();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public ThreeDPlanner zoomIn(int number){
		for (int n=1; n<=number; n++){	
				zoomIn.click();
				UtilHBM.waitFixTime(1000);
				Reporter.log("ZoomIn clicked" + "<br>");
		}		
		return this;
	}
	
	public ThreeDPlanner zoomOut(int number){
		for (int n=1; n<=number; n++){		
				zoomOut.click();
				UtilHBM.waitFixTime(1000);				
				Reporter.log("ZoomOut clicked" + "<br>");	
		}
		return this;
	}
		
	public ThreeDPlanner levelCheck(){
//		if(levelNavCollapsed.isDisplayed()){
//			levelNavCollapsed.click();			
//		}else{
			levelNavNotCollapsed.click();
	//	}
		return this;
	}
	/*
	public ThreeDPlanner addAProduct (String product, String img, int xOffset, int yOffset){				
		
		System.out.println(product + "To be added");
		Location loc=new Location(0, 0);
		try{
		int xCo = s.find(UtilHBM.createPattern(img)).getCenter().x + xOffset;
		int yCo = s.find(UtilHBM.createPattern(img)).getCenter().y + yOffset;		
		loc = new Location(xCo, yCo);
		System.out.println(loc);
		}catch (Exception e){
			UtilHBM.reportKO("Could not find image while adding product: " + product);
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}		
		switch(catalogCommand){
		case "Build":
			build.click();
			break;
		case "Furnish":
			furnish.click();
			break;
		case "Decorate":
			decorate.click();
			break;
		case "Brands":
			brands.click();
			break;			
		}
//		addAProduct.click();
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		UtilHBM.waitFixTime(2000);
		turnOffImplicitWaits();		
		placeProduct(loc);
		turnOnImplicitWaits();
		clickBlankTillPropertiesDisappear();
//		UtilHBM.clickBlankTillElementDisappear(driver, ".toolBar-group-infos-right");
		UtilHBM.reportOK(product + " added in the project successfully");				
		return this;	
	}
	
	public ThreeDPlanner addAProductSearch(String product, String img, int xOffset, int yOffset){		
		System.out.println(product + "To be added");
		Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);	
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		UtilHBM.waitExplicitClickable(driver, build);
		build.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductSearch(product);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);
		turnOnImplicitWaits();
		clickBlankTillPropertiesDisappear();		
		UtilHBM.reportOK(product + " searched & added in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromInfo(String product, String img, int xOffset, int yOffset){		
				Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);		
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}
//		addAProduct.click();
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductFromInfoPage(product);
		UtilHBM.waitFixTime(2000);		
		placeProduct(loc);
//		turnOnImplicitWaits();
		clickBlankTillPropertiesDisappear();		
		UtilHBM.reportOK(product + " added from info panel in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductOtherModelFromInfo(String product, int model, String img, int xOffset, int yOffset){		
		System.out.println(product + "To be added");
		Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}
//		addAProduct.click();
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductOtherModelFromInfo(product, model);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);		
		clickBlankTillPropertiesDisappear();		
		UtilHBM.reportOK(product + " model " + model + " added from info panel in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromBrands(String product, String img, int xOffset, int yOffset){		
		Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		brands.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromBrands(product);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);		
		clickBlankTillPropertiesDisappear();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addPartnerProduct(String product, String img, int xOffset, int yOffset){		
		Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		brands.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addPartnerProduct(product);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);		
		clickBlankTillPropertiesDisappear();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromFavorites(String favListName, String product, String img, int xOffset, int yOffset){		
		Location loc = UtilHBM.getLocation(img).offset(xOffset, yOffset);
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		favorites.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromFavorites(favListName, product);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);		
		clickBlankTillPropertiesDisappear();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductWithoutFilter (String product, String img, int xOffset, int yOffset){				
		
		System.out.println(product + "To be added");
		Location loc=UtilHBM.getLocation(img).offset(xOffset, yOffset);		
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}
//		addAProduct.click();
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductWithoutFilter(product);
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);
		clickBlankTillPropertiesDisappear();
//		UtilHBM.clickBlankTillElementDisappear(driver, ".toolBar-group-infos-right");
		UtilHBM.reportOK(product + " added without using filter in the project successfully");				
		return this;	
	}
	
	public ThreeDPlanner addProductFromBalloonInfo(String img, int xOffset, int yOffset){
		String brandProductLogo;
		Location loc=UtilHBM.getLocation(img).offset(xOffset, yOffset);	
		clickImgTillPropertiesAppear(img, 0, 0);
		UtilHBM.waitExplicitDisplayed(driver, toolbarBrandLogo);
		System.out.println("toolbar text is: " + toolbarBrandInfo.getText() );
		System.out.println(toolbarBrandInfo.getText().split("\\r?\\n")[0]);
		brandProductLogo=toolbarBrandInfo.getText().split("\\r?\\n")[0] + ">"+ toolbarBrandInfo.getText().split("\\r?\\n")[1]+">>"+toolbarBrandLogo.getAttribute("src");
		infoBubble.click();
		ProductInfo info = PageFactory.initElements(driver, ProductInfo.class);		
		info.addProductFromInfo(brandProductLogo);
		placeProduct(loc);
		UtilHBM.reportOK(brandProductLogo.split(">")[1] + " added using info command in balloon successfully");
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner addFromBalloon (String wallImg, String product, String refImg, int xOffset, int yOffset){
		clickImgTillPropertiesAppear(wallImg, 0, 0);
		addBubble.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		UtilHBM.waitFixTime(2000);
		Location loc=new Location(0, 0);
		try{
		int xCo = s.find(UtilHBM.createPattern(refImg)).getCenter().x + xOffset;
		int yCo = s.find(UtilHBM.createPattern(refImg)).getCenter().y + yOffset;		
		loc = new Location(xCo, yCo);
		System.out.println(loc);
		}catch (Exception e){
			UtilHBM.reportKO("Could not find image while adding product: " + product);
		}
		
		turnOffImplicitWaits();
		int i = 0;
		do{
			loc.click();
			i++;			
		}while(UtilHBM.listOfWebElement(driver, ".overlay-top-title-message").size()>0 && i<10);		
		turnOnImplicitWaits();
		clickBlankTillPropertiesDisappear();		
		UtilHBM.reportOK(product + " added in the project using Add command in balloon");
		return this;
	}
	
	public ThreeDPlanner addMtlFrmWall(String frmWallImg, String toWallImg){
		Location loc = UtilHBM.getLocation(toWallImg).offset(0, 0);	
		clickImgTillPropertiesAppear(frmWallImg, 0, 0);
		editBubble.click();
		Edit edit = PageFactory.initElements(driver, Edit.class);
		edit.threeDWallCopyMtl();
		UtilHBM.waitFixTime(2000);
		placeProduct(loc);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	*/
	public ThreeDPlanner createFavoriteList(String favListName, String products, boolean isNewProduct){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		favorites.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.createFavList(favListName, products, isNewProduct);
		return this;
	}
	
	public ThreeDPlanner deleteFavoriteList (String listName){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		favorites.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.deleteFavList(listName);
		return this;
	}
	
	public ThreeDPlanner removePrdFrmFavList(String listName, String product){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		favorites.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.removePrdFromFav(listName, product);
		return this;
	}
	/*
	public ThreeDPlanner replace(String img, String product){
		clickImgTillPropertiesAppear(img, 0, 0);
		replaceBubble.click();
		UtilHBM.waitFixTime(1000);
		Catalog ctg = PageFactory.initElements(driver, Catalog.class);
		ctg.replaceProduct(product);
		clickBlankTillPropertiesDisappear();
		UtilHBM.reportOK("Exsting product replaced by " + product);
		return this;
	}
	
	public ThreeDPlanner wall(String img){
		new Actions(driver).click(designFloorPlan).click(designAWall).build().perform();
//		designFloorPlan.click();
//		new Actions(driver).moveToElement(designFloorPlan).build().perform();
//		UtilHBM.waitExplicitClickable(driver, designAWall);
//		designAWall.click();
	
		CreateWall wall = PageFactory.initElements(driver, CreateWall.class);
		wall.drawWall(img);
		Reporter.log("<font color='green'>" + "Wall created with respect to " + img + "<font color='black'>" + "<br>");
		return this;
	}
	
	public ThreeDPlanner roomSeparation (String img){
		new Actions(driver).click(designFloorPlan).click(roomSeparator).build().perform();
//		designFloorPlan.click();
//		new Actions(driver).moveToElement(designFloorPlan).build().perform();
//		UtilHBM.waitExplicitClickable(driver, roomSeparator);
//		roomSeparator.click();
			
		CreateWall wall = PageFactory.initElements(driver, CreateWall.class);
		wall.drawWall(img);
		Reporter.log("<font color='green'>" + "Wall created with respect to " + img + "<font color='black'>" + "<br>");
		return this;
	}
			
	public ThreeDPlanner edit3DWallProperties (String img, String dropdownCatagory, int colorPickerNumber, String colorId, int isBranded_1ForYes){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.threeDWallProperties(dropdownCatagory, colorPickerNumber, colorId, isBranded_1ForYes);	
		UtilHBM.waitFixTime(1000);
		clickBlankTillPropertiesDisappear();		
		return this;
	}
	
	public ThreeDPlanner verify3DWallProperties(String img, String dropdownCatagory, int colorPickerNumber, String colorId, int isBranded_1ForYes){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyThreeDWallProperties(dropdownCatagory, colorPickerNumber, colorId, isBranded_1ForYes);		
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner edit2DWallProperties(String img, int xOffset, int yOffset, String thickness, String height, String slopHt, String slopDpt){			
		clickImgTillPropertiesAppear(img, xOffset, yOffset);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.twoDWallProperties(thickness, height, slopHt, slopDpt);
		clickBlankTillPropertiesDisappear();
		return this;		
	}
	
	public ThreeDPlanner editTwoDWallDimension(String img, int xOffset, int yOffset, String oldValue, String newvalue, String applyToLeftRightAboveBelow){
		clickImgTillPropertiesAppear(img, xOffset, yOffset);		
		WallPropertiesTwoD properties = PageFactory.initElements(driver, WallPropertiesTwoD.class);
		properties.twoWallDimensions(oldValue, newvalue, applyToLeftRightAboveBelow);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner verify2DWallProperties(String img, int xOffset, int yOffset, String thickness, String height, String dimension, int ceilingHtBox, String slopHt, String slopDpth){
		clickImgTillPropertiesAppear(img, xOffset, yOffset);
		editBubble.click();
		Edit edit = PageFactory.initElements(driver, Edit.class);
		edit.verifyTwoDWallProperties(thickness, height, ceilingHtBox, slopHt, slopDpth);
		WallPropertiesTwoD properties = PageFactory.initElements(driver, WallPropertiesTwoD.class);
		properties.verifyTwoDWallProperties(dimension);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner editFloorProperties(String img, String roomType, String colorCatagory, String colorID, int isBranded_1ForYes){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.floorProperties(roomType, colorCatagory, colorID, isBranded_1ForYes);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner VerifyFloorProperties(String img, String roomType, String colorCatagory, String colorID, int isBranded_1ForYes){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyFloorProperties(roomType, colorCatagory, colorID, isBranded_1ForYes);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner editBayDimension(String img, int oldValue, int newValue){
		WebElement dim=null;
		clickImgTillPropertiesAppear(img, 0, 0);		
		for(WebElement tempDim: bayDimList){			
			if(oldValue==Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])){
				dim=tempDim;				
			}			
		}
		new Actions(driver).moveToElement(dim).click().build().perform();
//		bayDimInput.clear();
		bayDimInput.sendKeys(Integer.toString(newValue));
		bayDimInput.sendKeys(Keys.RETURN);	
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner verifyBayDimension(String img, int dimValue, int numberOfDim){
		clickImgTillPropertiesAppear(img, 0, 0);
		int i=0;
		String dim=null;
		for(WebElement tempDim: bayDimList){
			if(dimValue== Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])){
				dim = tempDim.getAttribute("value");
				i++;
			}			
		}
		if(i>0){
			UtilHBM.reportOK("Bay dimension verified. No of dimension with value " + dim + " are " + i);
		}
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner editDoorWinProperties(String img, String ht, String wth, String htFromFloor, int chgWalSd, int openingSd){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.doorWinProperties(ht, wth, htFromFloor, chgWalSd, openingSd);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner verifyDoorWinProperties(String img, String ht, String wth, String htFromFloor){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyDoorWinProperties(ht, wth, htFromFloor);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner editGenericProperties(String img, String ht, String wth, String dpth, String materialType, int colorPickerNumber, String materialId){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.genericProperties(ht, wth, dpth, materialType, colorPickerNumber, materialId);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner verifyGenericProperties(String img, String ht, String wth, String dpth, String materialId){
		clickImgTillPropertiesAppear(img, 0, 0);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyGenericProperties(ht, wth, dpth, materialId);
		clickBlankTillPropertiesDisappear();
		return this;
	}
	
	public ThreeDPlanner verifyLogoLink(String img){
		clickImgTillPropertiesAppear(img, 0, 0);
		UtilHBM.waitExplicitDisplayed(driver, toolbarBrandLogo);
		if(UtilHBM.webElement(driver, "#property-brand-logo[src*='https://']").isDisplayed()){
			UtilHBM.reportOK("Logo is displayed");
		}else{
			UtilHBM.reportKO("Logo is not displayed");
		}
		if(UtilHBM.webElement(driver, ".toolbar-brand-info").isDisplayed()){
			UtilHBM.reportOK("product name is displayed & the text is: " + UtilHBM.webElement(driver, ".toolbar-brand-info").getText() );
		}else{
			UtilHBM.reportKO("product name is not displayed");
		}
		if (UtilHBM.listOfWebElement(driver, ".toolBar-group-infos-right>.buttonSecondary.button--small").size()==1){
			UtilHBM.reportOK("ADD TO FAVORITES button displayed");
		}else{
			UtilHBM.reportKO("ADD TO FAVORITES button is not displayed");
		}
		if (UtilHBM.listOfWebElement(driver, ".button.button--small.u-mrs").size()==1){
			if(UtilHBM.webElement(driver, ".button.button--small.u-mrs").getAttribute("href").contains(UtilHBM.webElement(driver, ".toolbar-brand-title").getText().toLowerCase().replaceAll(" ", ""))){
				UtilHBM.reportOK("VISIT STORE button is displayed & points to correct brand link");
			}else{
				UtilHBM.reportWarning("VISIT STORE button displayed but link may not be pointng to correct brand");
			}
		}else{
			UtilHBM.reportKO("VISIT STORE button is not displayed");
		}
		clickBlankTillPropertiesDisappear();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner duplicate(String img){
		clickImgTillPropertiesAppear(img, 0, 0);
		duplicateBubble.click();
		clickBlankTillPropertiesDisappear();
		UtilHBM.reportOK("product duplicated using Duplicate in Balloon");
		return this;
	}
	
	public ThreeDPlanner splitWall(String img, int xOffset, int yOffset) {
		clickImgTillPropertiesAppear(img, xOffset, yOffset);
		splitBubble.click();
		clickBlankTillPropertiesDisappear();
		return this;		
	}
	*/
	public ThreeDPlanner changeProjectDetails (String projectName, String typrOfHousing, String typeOfProject){
		projectDetail.click();		
		ProjectDetails projectInfo= PageFactory.initElements(driver, ProjectDetails.class);
		projectInfo.changeProjectDetails(projectName, typrOfHousing, typeOfProject);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#notifText"));
		UtilHBM.waitExplicitDisplayed(driver, saveSuccessMsg);
		Verification.displayNAttributeCheckOfElement(saveSuccessMsg, "Project saved message", "text", "Your project has been saved.");		
		messageNotificationCloseButton.click();	
		return this;
	}
	
	public ThreeDPlanner verifyProjectDetails(String projectName, String typrOfHousing, String typeOfProject, int noOfFloor, int noOfRoom, double totalArea){
		projectDetail.click();
		ProjectDetails projectInfo = PageFactory.initElements(driver, ProjectDetails.class);
		projectInfo.verifyProjectDetails(projectName, typrOfHousing, typeOfProject, noOfFloor, noOfRoom, totalArea);
		UtilHBM.waitFixTime(1000);	
		return this;
	}
	
	public ThreeDPlanner addFloorOrBasementOrPlan(int addFloor, int addBasement, String ceilingHT, String plan){
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.addFloorOrBasement(addFloor, addBasement, ceilingHT, plan);
		return this;
	}
	
	public ThreeDPlanner deleteFloor(String floorName, boolean deleteConfirm){
		currentLevel.click();
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.deleteFloor(floorName, deleteConfirm);
		currentLevel.click();
		return this;
	}
	
	public ThreeDPlanner changeActiveFloor(String floorName){
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.changeActiveFloor(floorName);
		UtilHBM.reportOK("Active floor changed to " + floorName);
		return this;
	}
	
	public ThreeDPlanner lockFloor(String floorName){
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.lockFloor(floorName);
		clickBlankSpaceDev();
		return this;
	}
	
	public ThreeDPlanner verifylockFloor(){
		Verification.displayOfWebElement(lockSignDisplayed.get(0));
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.verifylockFloor();
		clickBlankSpaceDev();
		return this;
	}

	public ThreeDPlanner unLockFloor(String floorName){
		Verification.displayOfWebElement(lockSignDisplayed.get(0));
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.unLockFloor(floorName);
		clickBlankSpaceDev();
		UtilHBM.waitFixTime(1000);
		if(lockSignNotDisplayed.size()==1){
			UtilHBM.reportOK("Unlock floor test is successful");
		}else{
			UtilHBM.reportKO("Unlock floor test is failed");
		}
		return this;
	}
	
	public ThreeDPlanner changeFloorPlan(String plan){
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.changePlan(plan);
		return this;
	}
	
	public ThreeDPlanner verifyFloorPlanInfo(){
		currentLevel.click();		
		LevelNavigator level = PageFactory.initElements(driver, LevelNavigator.class);
		level.verifyLevelNevigatortPanel();		
		return this;
	}
	
	public ThreeDPlanner undo(int i){		
		for(int j=1; j<i+1; j++){
			undoButton.click();	
			UtilHBM.waitFixTime(2000);
			j++;
		}
		UtilHBM.reportOK("Undo last " + i + " steps.");
		return this;
	}
	
	public ThreeDPlanner redo(int i){
		for(int j=1; j<i+1; j++){
			redoButton.click();
			UtilHBM.waitFixTime(2000);
			j++;
		}		
		UtilHBM.reportOK("Redo last " + i + " steps.");
		return this;
	}
	
	public ThreeDPlanner verifyProjectName(String projectName){		
		assert projectTitle.getText().equalsIgnoreCase(projectName);
		return this;
	}
	
	public ThreeDPlanner verifyBanner(){
		UtilHBM.waitFixTime(40000);
		Baner baner = PageFactory.initElements(driver, Baner.class);
		baner.verifyBannerContents();	
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return this;
	}
	
	public ThreeDPlanner bannerSignUp(){
		UtilHBM.waitFixTime(40000);
		Baner baner = PageFactory.initElements(driver, Baner.class);
		baner.bannerSignUp();	
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return this;
	}
	
	public ThreeDPlanner fpRotate(int steps, String leftOrRoght){
		UtilHBM.hitArrowKey(steps, leftOrRoght);
		return this;
	}
	
	public ThreeDPlanner fpMoveFontOrBack(int steps, String frontOrBack){
		if(frontOrBack.equalsIgnoreCase("front")){
			UtilHBM.hitArrowKey(steps, "up");
		}else{
			UtilHBM.hitArrowKey(steps, "down");
		}		
		return this;
	}
	
	private void turnOffImplicitWaits() {
	    UtilHBM.turnOffImplicitWaits(driver);
	}

	private void turnOnImplicitWaits() {
	    UtilHBM.turnOnImplicitWaits(driver);
	}	
	/*
	private void clickBlankTillPropertiesDisappear(){
		turnOffImplicitWaits();
		int i=0;
		do{
			clickBlankSpaceDev();					
			i++;
		}while((bubbleCommandlist.size()>0)&&i<20);
		if(i>10){
			UtilHBM.reportInfo("Number of iteration in click on blank space to deselect object = "+ i);
		}			
		turnOnImplicitWaits();
	}	
	
	
	private void clickImgTillPropertiesAppear(String img, int xOffset, int yOffset){
		turnOffImplicitWaits();		
		int i=0;
		do{
			clickBlankSpaceDev();
			if(i<13){
				UtilHBM.clickImgOffset(img, xOffset, yOffset);
			}else{
				UtilHBM.doubleClickImg(img, xOffset, yOffset);
			}			
			i++;
		}while(!(bubbleCommandlist.size()>0)&&i<20);
		if(i>10 && i<13){			
			UtilHBM.reportInfo("Number of iteration in click on " + img + " for getting properties = "+ i);
		}else if(i>12){
			UtilHBM.reportInfo("Double click used on object to get properties. Number of iteration in click on " + img + " for getting properties = "+ i);
		}
		turnOnImplicitWaits();
	}
	
	
	private void placeProduct(Location loc){
		turnOffImplicitWaits();
		if(productPlacementInstruction.getText().equalsIgnoreCase("Click on walls or floors to apply your coating. Click again to undo.")){
			loc.click();
			validateButton.click();			
		}else{
			int i = 0;
			do{	
				if(i<13){
					loc.click();
				}else{
					loc.doubleClick();
				}				
				i++;				
			}while(UtilHBM.listOfWebElement(driver, ".overlay-top-title-message").size()>0 && i<20);
			if(i>12){
				UtilHBM.reportWarning("Used double click to place the product");
			}
		}			
		turnOnImplicitWaits();
	}
	*/
	//------------------------------Beta features-----------------------------
	
	public ThreeDPlanner exteriorDev(int xOffset, int yOffset, int exteriorTypeNo, String surfaceArea){		
		new Actions(driver).moveToElement(designFloorPlan).build().perform();
		UtilHBM.waitExplicitClickable(driver, exterior);
		exterior.click();
		DesignYourExterior selectExterior = PageFactory.initElements(driver, DesignYourExterior.class);
		selectExterior.createExterior(exteriorTypeNo, surfaceArea);
		hoverInPlanner(xOffset+5, yOffset+5);
		hoverInPlanner(xOffset, yOffset);
		placeProductDev(xOffset, yOffset);		
		return this;
	}
	
	public ThreeDPlanner deleteDev(int xOffset, int yOffset){		
		
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		deleteBubble.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner clickDeleteBubble(){		
		
		deleteBubble.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public ThreeDPlanner includeAccessories(int xOffset, int yOffset){		
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		includeAccessoriesBubble.click();
		Verification.displayOfWebElement(duplicateBubble);
		Verification.displayOfWebElement(deleteBubble);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	
	public ThreeDPlanner includeAccessoriesNotificationClick(){
		
		if(includeAccessNotificationText.isDisplayed() && includeAccessNotificationText.getText().equalsIgnoreCase("Include accessories")){
			UtilHBM.reportOK("includeAccessories notification verified successfully");					
		}else{
			UtilHBM.reportKO("includeAccessories notification not available");
		}
		includeAccessNotificationText.click();
		//closeIncludeAccessNotificationText.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner includeAccessoriesNotificationClose(){
		if(includeAccessNotificationmsg.isDisplayed() && includeAccessNotificationmsg.getText().equalsIgnoreCase("Do you want to apply the same movement to the objects that were associated with the selected element?")){
			UtilHBM.reportOK("includeAccessories notification verified successfully");					
		}else{
			UtilHBM.reportKO("includeAccessories notification not available");
		}
		closeIncludeAccessNotificationText.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner reUseDev(int xOffset, int yOffset){		
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		reUseBubble.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner reUseValidate(){		
		validateReuse.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner deleteRoom(int xOffset, int yOffset){		
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		deleteBubble.click();
		Message msg = PageFactory.initElements(driver, Message.class);
		msg.deleteRoomClickDelete();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner emptyRoom(int xOffset, int yOffset){		
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		emptyBubble.click();
		Message msg = PageFactory.initElements(driver, Message.class);
		msg.emptyRoomClickEmptyButton();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner measureEditDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String newValue){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.editMeasureDev(xPoint1, yPoint1, xPoint2, yPoint2, newValue);
		return this;
	}
	
	public ThreeDPlanner measureCheckDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.checkMeasureDev(xPoint1, yPoint1, xPoint2, yPoint2);
		return this;
	}
	
	public ThreeDPlanner verifyMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		measureButton.click();		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.verifyMeasureDev(xPoint1, yPoint1, xPoint2, yPoint2, expectedDist);
		return this;
	}
	
public ThreeDPlanner addAProductDev (String product, int xOffset, int yOffset){	
		System.out.println(product + "To be added");
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}		
		switch(catalogCommand){
		case "Build":
			build.click();
			break;
		case "Furnish":
			furnish.click();
			break;
		case "Decorate":
			decorate.click();
			break;
		case "Brands":
			brands.click();
			break;
		case "Community content":
			communityContent.click();
			break;
		}
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		UtilHBM.waitFixTime(2000);		
		hoverInPlanner(xOffset+5, yOffset+5);
		hoverInPlanner(xOffset, yOffset);
		placeProductDev(xOffset, yOffset);		
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK(product + " added in the project successfully");				
		return this;	
	}

	public ThreeDPlanner lockMsgDesignFloorPlan (String catalogCommand){	
	designFloorPlan.click();
	switch(catalogCommand){
	case "DesignAWall":
		designAWall.click();
		break;
	case "AddARoom":
		addARoom.click();
		break;
	case "roomSeparator":
		roomSeparator.click();
		break;
	case "Exterior":
		exterior.click();
		break;
		}
	lockMsgPopUp();
	//	UtilHBM.waitTillElementDisappear(driver, lockmsg);
	return this;	
	}
	
	public ThreeDPlanner lockMsgBuild (String product, int xOffset, int yOffset){	
		catalog.click();
		build.click();
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductFromInfoPage(product);
		UtilHBM.waitFixTime(2000);
		clickInPlanner(xOffset, yOffset);
		lockMsgPopUp();
		//	UtilHBM.waitTillElementDisappear(driver, lockmsg);
		return this;	
	}

	public ThreeDPlanner lockMsgPopUp (){	
		Verification.displayNAttributeCheckOfElement(lockmsg, "Lock notification is displayed", "text", "Your operation cannot be performed as the floor is locked.");
		Verification.verifyText(lockmsg, "Your operation cannot be performed as the floor is locked.", "Lock notification is displayed");
		UtilHBM.waitFixTime(4000);
		return this;	
	}
	
	public ThreeDPlanner addAProductSearchDev(String product, int xOffset, int yOffset){		
		System.out.println(product + "To be added");
		
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		UtilHBM.waitExplicitClickable(driver, build);
		build.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductSearch(product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);		
		clickBlankTillPropertiesDisappearDev();		
		UtilHBM.reportOK(product + " searched & added in the project successfully");	
		return this;
	}

	public ThreeDPlanner addAProductFromInfoDev(String product, int xOffset, int yOffset){		
		System.out.println(product + "To be added");			
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}

		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductFromInfoPage(product);
		UtilHBM.waitFixTime(2000);	
//		hoverInPlanner(xOffset+5, yOffset+5);
		hoverInPlanner(xOffset+5, yOffset+5);
		hoverInPlanner(xOffset, yOffset);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();		
		UtilHBM.reportOK(product + " added from info panel in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductOtherModelFromInfoDev(String product, int model, int xOffset, int yOffset){		
		System.out.println(product + "To be added");
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductOtherModelFromInfo(product, model);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();		
		UtilHBM.reportOK(product + " model " + model + " added from info panel in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromBrandsDev(String product, int xOffset, int yOffset){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		brands.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromBrands(product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addPartnerProductDev(String product, int xOffset, int yOffset){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		brands.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addPartnerProduct(product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromFavoritesDev(String favListName, String product, int xOffset, int yOffset){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		favorites.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromFavorites(favListName, product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();	
		UtilHBM.reportOK(product + " added from Brands tab in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner addAProductFromCommunityContentDev(String searchProduct, String product, String productID, int xOffset, int yOffset){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, communityContent);
		UtilHBM.waitExplicitClickable(driver, communityContent);
		communityContent.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromCommunityContentSearch(searchProduct, product, productID);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();	
		UtilHBM.reportOK(product + " added from community content in the project successfully");	
		return this;
	}
	
	public ThreeDPlanner clickMyContent(){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, myContent);
		UtilHBM.waitExplicitClickable(driver, myContent);
		myContent.click();
		return this;
	}
	
	@FindBy(css = "[data-ui-message='Open3DEditor']>div.product-thumb>span>.icon-action-zoom")
	public WebElement importYourOwnContent;
	
	@FindBy(css = "[data-ui-message='Open3DEditor']>div.product-legend>h4")
	public WebElement importYourOwnContentText;
	
	@FindBy(css = "[data-ui-message='Open3DEditor']>div.product-legend>p")
	public WebElement importYourOwnContentText1;
	
	@FindBy(xpath = "//html/body/div[1]/div/div/span[@class='spinner']")
	List<WebElement> loader;
	
	@FindBy(css = ".panelProduct-btn-icon")
	public WebElement closeCatalogue;

	public ThreeDPlanner closeCatalogueButton() {
		closeCatalogue.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyProcessingProduct(String prdName) {
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(0));
		WebElement expectedProduct = null;
		boolean isPrdAvailable = false;
		int myContentListSize = myContentList.size();
		for (int i = 0; i < myContentListSize; i++) {
			if (myContentList.get(i).findElement(By.cssSelector(".product-legend>a")).getText()
					.equalsIgnoreCase(prdName)) {
				expectedProduct = myContentList.get(i);
				isPrdAvailable = true;
				break;
			} else {
				continue;
			}
		}
		if (!isPrdAvailable) {
			UtilHBM.reportKO("Product not available in my content!! Product name :" + prdName);
		}
		String productSrc = expectedProduct.findElement(By.cssSelector(".u-mbs.product.w-20>div>img")).getAttribute("src");
		if (productSrc.contains("Thumbnails") && productSrc.contains("https:")) {
			UtilHBM.reportOK("Product thumbnail displayed");
		} else {
			UtilHBM.reportKO(productSrc+"Product thumbnail not displayed for product : " + prdName + " , " + productSrc);
		}
		Verification.VerifyEquals("Wrong product name!!",
				expectedProduct.findElement(By.cssSelector(".product-legend>a")).getText(), prdName);
		Verification.VerifyEquals("Waiting for process text not displayed for processing product",
				expectedProduct.findElement(By.cssSelector("div>.label-pill-icon-success-medium>span")).getText(),
				"Waiting for process");
		Verification.VerifyEquals("Coming soon text not displayed for processing product",
				expectedProduct.findElement(By.cssSelector(".product-thumb>.unavailable-layer>span")).getText(), "Coming soon");
		return this;
	}

	public ThreeDPlanner verifyEditSuccessNotification() {
		UtilHBM.waitExplicitDisplayed(driver, successNotification);
		Verification.VerifyEquals("Wrong success notification displayed for edit user product!!",
				successNotification.getText(), "Changes saved successfully");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
//		driver.navigate().refresh();
		return this;
	}
	
	public InfoPageGeometryEditor clickImportYourOwn3DProductToOpenInfoPage() {
		UtilHBM.waitExplicitDisplayed(driver, importYourOwnContent);
		UtilHBM.waitExplicitClickable(driver, importYourOwnContent);
		Verification.verifyText(importYourOwnContentText, "Import your own content", "import your own content text");
		Verification.verifyText(importYourOwnContentText1, "Use one of our editors to fully create or just import the objects you want to use within your projects.", "Geometric editor text");
		importYourOwnContent.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, InfoPageGeometryEditor.class);
	}
	
	public Upload3dModel clickImportYourOwn3DProductToOpenUpload3dModel() {
		UtilHBM.waitExplicitDisplayed(driver, importYourOwnContent);
		UtilHBM.waitExplicitClickable(driver, importYourOwnContent);
		Verification.verifyText(importYourOwnContentText, "Import your own content", "import your own content text");
		Verification.verifyText(importYourOwnContentText1, "Use one of our editors to fully create or just import the objects you want to use within your projects.", "Geometric editor text");
		importYourOwnContent.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		UtilHBM.waitFixTime(2000);
		int i;
		boolean temp = false;
		for (i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = loader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isLoaderDisappreared) {
				UtilHBM.reportInfo("Loader displayed for " + i + " seconds while opening geometry editor");
				temp = true;
				break;
			}
		}
		if (!temp) {
			UtilHBM.reportKO("Loader displayed for more than 10 seconds");
		}
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='https://preprod-3deditor.by.me/Editor/?unit=metrics&ln=en']")));
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Upload3dModel.class);
	}

	
	public ThreeDPlanner myContent(int productList, int index, int xOffset, int yOffset, String prdName){
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, communityContent);
		UtilHBM.waitExplicitClickable(driver, communityContent);
		communityContent.click();
		UtilHBM.waitExplicitDisplayed(driver, viewAll);
		Verification.displayOfWebElement(viewAll);
		viewAll.click();
		if(productList!=0){
			int myContent = myContentList.size()+1;
			
			if(!(productList==myContent)){
				UtilHBM.reportKO("my content count is not correct. Expected count = "+productList+ ", actual count = " + myContent);
			}
		}
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, myContentList.get(index));
		WebElement expectedProduct = driver.findElement(By.xpath("//div[@class='flex flex--separate flex--wrap']/div[@class='u-mbs product w-20'][not(descendant::div[@class='product-head-actions']/span)]/div/a[starts-with(text(), '"+prdName+"')]/../.."));
		String productSrc = expectedProduct.findElement(By.cssSelector("div>img")).getAttribute("src");
		WebElement productName = expectedProduct.findElement(By.xpath("//div/a[text()='"+prdName+"']"));
		if (productSrc.contains("/Thumbnails/") && productSrc.contains("https://")) {
			UtilHBM.reportOK("Product thumbnail displayed");
		} else {
			UtilHBM.reportKO("Product thumbnail not displayed for product : " + prdName + " , " + productSrc);
		}
		Verification.VerifyEquals("Wrong product name!!", productName.getText(), prdName);
		UtilHBM.waitExplicitClickable(driver, expectedProduct);
		new Actions(driver).moveToElement(expectedProduct).build().perform();
		UtilHBM.waitFixTime(1000);
		WebElement addToProject = expectedProduct.findElement(By.cssSelector("div>div.product-thumb-action>a>span"));
		Verification.displayOfWebElement(addToProject);
		addToProject.click();
		placeProductDev(xOffset, yOffset);
		return this;
	}
	
	public ThreeDPlanner addAProductWithoutFilterDev (String product, int xOffset, int yOffset){				
		System.out.println(product + "To be added");
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}
		new Actions(driver).moveToElement(catalogCommands).build().perform();
		switch(catalogCommand){
		case "Build":
			build.click();
			break;	
		case "Furnish":
			furnish.click();
			break;	
		case "Decorate":
			decorate.click();
			break;	
		case "Brands":
			brands.click();
			break;			
		}
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductWithoutFilter(product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();		
		UtilHBM.reportOK(product + " added without using filter in the project successfully");				
		return this;	
	}

	public ThreeDPlanner addProductFromBalloonInfoDev(int xObj, int yObj, int xOffset, int yOffset){
		String brandProductLogo;			
		clickObjTillPropertiesAppearDev(xObj, yObj);
		UtilHBM.waitExplicitDisplayed(driver, toolbarBrandLogo);
		System.out.println("toolbar text is: " + toolbarBrandInfo.getText() );
		System.out.println(toolbarBrandInfo.getText().split("\\r?\\n")[0]);
		brandProductLogo=toolbarBrandInfo.getText().split("\\r?\\n")[0] + ">"+ toolbarBrandInfo.getText().split("\\r?\\n")[1]+">>"+toolbarBrandLogo.getAttribute("src");
		infoBubble.click();
		driver.switchTo().parentFrame();
		ProductInfo info = PageFactory.initElements(driver, ProductInfo.class);		
//		info.addProductFromInfo(brandProductLogo);
		info.checkInfo(brandProductLogo);
		info.closePrdSheet();
//		hoverInPlanner(xOffset+5, yOffset+5);
//		hoverInPlanner(xOffset, yOffset);
//		placeProductDev(xOffset, yOffset);
//		UtilHBM.reportOK(brandProductLogo.split(">")[1] + " added using info command in balloon successfully");
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner addFromBalloonDev (int xOfWall, int yOfWall, String product, int xOffset, int yOffset){
		clickObjTillPropertiesAppearDev(xOfWall, yOfWall);
		addBubble.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProduct(product);
		UtilHBM.waitFixTime(2000);
//		hoverInPlanner(xOffset+5, yOffset+5);
		placeProductDev(xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();		
		UtilHBM.reportOK(product + " added in the project using Add command in balloon");
		return this;
	}
	
	public ThreeDPlanner addMtlFrmWallToFavorite(int x1, int y1, String favList, String newOrExistingList,boolean new_1_old_0){		
		clickObjTillPropertiesAppearDev(x1, y1);
		editBubble.click();
		Edit edit = PageFactory.initElements(driver, Edit.class);
		edit.addWallMtlToFavorite(favList, newOrExistingList, new_1_old_0);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner replaceDev(int xTarget, int yTarget, String product){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		replaceBubble.click();
		UtilHBM.waitFixTime(1000);
		Catalog ctg = PageFactory.initElements(driver, Catalog.class);
		ctg.replaceProduct(product);
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("Exsting product replaced by " + product);
		return this;
	}
	
	public ThreeDPlanner replaceFromCata(int xTarget, int yTarget, String product){
		
		
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		replaceBubble.click();
		UtilHBM.waitFixTime(1000);
		Catalog ctg = PageFactory.initElements(driver, Catalog.class);
		ctg.replaceFrmPrdSheet(product);
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("Exsting product replaced by " + product);
		return this;
	}
	
	public IDSInfoPage idsServices(){
		new Actions(driver).moveToElement(catalogCommands).build().perform();		
			furnish.click();
			UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
			Catalog catalog = PageFactory.initElements(driver, Catalog.class);
			catalog.idsServices()
			.verifyIDSInfoPage();
		return PageFactory.initElements(driver, IDSInfoPage.class);
	}
	
	public IDSInfoPage floorplanServices(){
		new Actions(driver).moveToElement(catalogCommands).build().perform();		
			build.click();
			UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
			Catalog catalog = PageFactory.initElements(driver, Catalog.class);
			catalog.floorplanServices()
			.verifyFPInfoPage();
		return PageFactory.initElements(driver, IDSInfoPage.class);
	}
	
	public ThreeDPlanner ungroup(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		ungroupBubble.click();
		UtilHBM.waitExplicitDisplayed(driver, messageNotification);
		Verification.displayNAttributeCheckOfElement(messageNotification, "Ungroup success notification", "text", "The product has been succesfully ungrouped");
		messageNotificationCloseButton.click();
		clickBlankTillPropertiesDisappearDev();		
		return this;
	}
	
	public ThreeDPlanner configure(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		configureBubble.click();
		FurnitureConfigurator conf = PageFactory.initElements(driver, FurnitureConfigurator.class);
		conf.verifyNClickDone("Rangement coulissant L200 H231 P60 IMAGINE");
		clickBlankTillPropertiesDisappearDev();		
		return this;
	}
	
	public ThreeDPlanner wallDev(String refInWallParameters){
		new Actions(driver).click(designFloorPlan).click(designAWall).build().perform();
		CreateWall wall = PageFactory.initElements(driver, CreateWall.class);
		wall.drawWallDev(refInWallParameters);
		UtilHBM.reportMsg("Wall created with respect to " + refInWallParameters);
		return this;
	}
	
	public ThreeDPlanner roomSeparationDev (String refInWallParameters){
		new Actions(driver).click(designFloorPlan).click(roomSeparator).build().perform();
		CreateWall wall = PageFactory.initElements(driver, CreateWall.class);
		wall.drawWallDev(refInWallParameters);
		UtilHBM.reportMsg("Wall created with respect to " + refInWallParameters);
		return this;
	}
	
	public ThreeDPlanner edit3DWallPropertiesDev (int xTraget, int yTarget, String dropdownCatagory, int colorPickerNumber, String colorId, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTraget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.threeDWallProperties(dropdownCatagory, colorPickerNumber, colorId, isBranded_1ForYes);	
		UtilHBM.waitFixTime(1000);
		clickBlankTillPropertiesDisappearDev();		
		return this;
	}
	
	public ThreeDPlanner verify3DWallPropertiesDev(int xTarget, int yTarget, String dropdownCatagory, int colorPickerNumber, String colorId, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyThreeDWallProperties(dropdownCatagory, colorPickerNumber, colorId, isBranded_1ForYes);		
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyLockInPlanner(boolean isLockedExpected,
			int xTarget, int yTarget) {
		clickInPlanner(xTarget, yTarget);
		if (isLockedExpected) {

			Verification.displayOfWebElement(lockSignDisplayed.get(0));
			if (bubbleCommandlist.isEmpty()) {
				UtilHBM.reportOK("bubble commands are not displayed!! Floor locked : "
						+ isLockedExpected);
			} else {
				UtilHBM.reportKO("bubble commands are displayed!! Floor locked : "
						+ isLockedExpected);

			}

		} else {
			if (lockSignDisplayed.isEmpty()) {
				UtilHBM.reportOK("Locked sign not displayed!! Floor locked : "
						+ isLockedExpected);
			} else {
				UtilHBM.reportKO("Locked sign displayed!! Floor locked : "
						+ isLockedExpected);

			}

			if (!(bubbleCommandlist.isEmpty())) {
				UtilHBM.reportOK("bubble commands are displayed!! Floor locked : "
						+ isLockedExpected);
			} else {
				UtilHBM.reportKO("bubble commands are not displayed!! Floor locked : "
						+ isLockedExpected);
			}
		}
		return this;
	}
	
	
	public ThreeDPlanner edit2DWallPropertiesDev(int xTarget, int yTarget, String thickness, String height, String slopHt, String slopDpt){			
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.twoDWallProperties(thickness, height, slopHt, slopDpt);
		clickBlankTillPropertiesDisappearDev();
		return this;		
	}
	
	public ThreeDPlanner editTwoDWallDimensionDev(int xTarget, int yTarget, String oldValue, String newvalue, String applyToLeftRightAboveBelow){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		UtilHBM.waitFixTime(500);
		WallPropertiesTwoD properties = PageFactory.initElements(driver, WallPropertiesTwoD.class);
		properties.twoWallDimensions(oldValue, newvalue, applyToLeftRightAboveBelow);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verify2DWallPropertiesDev(int xTarget, int yTarget, String thickness, String height, String dimension, int ceilingHtBox, String slopHt, String slopDpth){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit edit = PageFactory.initElements(driver, Edit.class);
		edit.verifyTwoDWallProperties(thickness, height, ceilingHtBox, slopHt, slopDpth);
		WallPropertiesTwoD properties = PageFactory.initElements(driver, WallPropertiesTwoD.class);
		properties.verifyTwoDWallProperties(dimension);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editFloorPropertiesDev(int xTarget, int yTarget, String roomType, String colorCatagory, String colorID, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.floorProperties(roomType, colorCatagory, colorID, isBranded_1ForYes);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}

	public ThreeDPlanner verifyFloorPropertiesDev(int xTarget, int yTarget, String roomType, String colorCatagory, String colorID, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyFloorProperties(roomType, colorCatagory, colorID, isBranded_1ForYes);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editCeilingPropertiesDev(int xTarget, int yTarget, String roomType, String colorCatagory, String colorId, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.ceilingProperties(roomType, colorCatagory, colorId, isBranded_1ForYes);
		return this;
	}
	
	public ThreeDPlanner verifyCeilingPropertiesDev(int xTarget, int yTarget, String roomType, String colorCatagory, String colorId, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyCeilingProperties(colorCatagory, colorId, isBranded_1ForYes);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editFloorPropertiesDev(int xTarget, int yTarget, boolean ceilingOpening, boolean floorOpening){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.floorProperties(ceilingOpening, floorOpening);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyFloorPropertiesDev(int xTarget, int yTarget, boolean ceilingOpening, boolean floorOpening){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyFloorProperties(ceilingOpening, floorOpening);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyFloorPropertiesDev(int xTarget, int yTarget, String colorCatagory, String colorID, int isBranded_1ForYes){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyCeilingProperties(colorCatagory, colorID, isBranded_1ForYes);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editBayDimensionDev(int xTarget, int yTarget, int oldValue, int newValue){
		WebElement dim=null;
		clickObjTillPropertiesAppearDev(xTarget, yTarget);		
		for(WebElement tempDim: bayDimList){			
			if(oldValue==Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])){
				dim=tempDim;				
			}			
		}
		new Actions(driver).moveToElement(dim).click().build().perform();
//		bayDimInput.clear();
		bayDimInput.sendKeys(Integer.toString(newValue));
		bayDimInput.sendKeys(Keys.RETURN);	
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyBayDimensionDev(int xTarget, int yTarget, int dimValue, int numberOfDim){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		int i=0;
		String dim=null;
		for(WebElement tempDim: bayDimList){
			if(dimValue== Integer.parseInt(tempDim.getAttribute("value").split(" ")[0])){
				dim = tempDim.getAttribute("value");
				i++;
			}			
		}
		if(i>0){
			UtilHBM.reportOK("Bay dimension verified. No of dimension with value " + dim + " are " + i);
		}
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editDoorWinPropertiesDev(int xTarget, int yTarget, String ht, String wth, String htFromFloor, int chgWalSd, int openingSd){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.doorWinProperties(ht, wth, htFromFloor, chgWalSd, openingSd);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
//	public Edit editAnnotationsDev(int xTarget, int yTarget){
//		clickObjTillPropertiesAppearDev(xTarget, yTarget);
//		editBubble.click();
//		return PageFactory.initElements(driver, Edit.class);
//	}
	
	public ThreeDPlanner editLineAnnotations(int xTarget, int yTarget, String value, int lineColorIndex, int index, String type, String endType){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.lineEditAnnotation(value, lineColorIndex, index, type, endType);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner editAnnotations(int xTarget, int yTarget, boolean solid, int fillColorIndex, int xOffset, int yOffset, String lineThickness, int lineColorIndex, int dashTypeIndex, int textColorIndex, String fontValue, String fontSizeValue){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.editAnnotation(solid, fillColorIndex, xOffset, yOffset, lineThickness, lineColorIndex, dashTypeIndex, textColorIndex, fontValue, fontSizeValue);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyAnnotation(int xTarget, int yTarget, boolean solid, String fillColor, String lineColor, String textColor){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyAnnotation(solid, fillColor, lineColor, textColor);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyDoorWinPropertiesDev(int xTarget, int yTarget, String ht, String wth, String htFromFloor){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyDoorWinProperties(ht, wth, htFromFloor);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner editGenericPropertiesDev(int xTarget, int yTarget, String ht, String wth, String dpth, String materialType, int colorPickerNumber, String materialId){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.genericProperties(ht, wth, dpth, materialType, colorPickerNumber, materialId);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public ThreeDPlanner verifyGenericPropertiesDev(int xTarget, int yTarget, String ht, String wth, String dpth, String materialId){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		editBubble.click();
		Edit properties = PageFactory.initElements(driver, Edit.class);
		properties.verifyGenericProperties(ht, wth, dpth, materialId);
		clickBlankTillPropertiesDisappearDev();
		return this;
	}
	
	public Edit editButton() {
		UtilHBM.waitExplicitClickable(driver, editBubble);
		editBubble.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	public ThreeDPlanner verifyLogoLinkDev(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		UtilHBM.waitExplicitDisplayed(driver, toolbarBrandLogo);
		if(UtilHBM.webElement(driver, "#property-brand-logo[src*='https://']").isDisplayed()){
			UtilHBM.reportOK("Logo is displayed");
		}else{
			UtilHBM.reportKO("Logo is not displayed");
		}
		if(UtilHBM.webElement(driver, ".toolbar-brand-info").isDisplayed()){
			UtilHBM.reportOK("product name is displayed & the text is: " + UtilHBM.webElement(driver, ".toolbar-brand-info").getText() );
		}else{
			UtilHBM.reportKO("product name is not displayed");
		}
		if (UtilHBM.listOfWebElement(driver, ".toolBar-group-infos-right>.buttonSecondary.button--small").size()==1){
			UtilHBM.reportOK("ADD TO FAVORITES button displayed");
		}else{
			UtilHBM.reportKO("ADD TO FAVORITES button is not displayed");
		}
		if (UtilHBM.listOfWebElement(driver, ".button.button--small.u-mrs").size()==1){
			if(UtilHBM.webElement(driver, ".button.button--small.u-mrs").getAttribute("href").contains(UtilHBM.webElement(driver, ".toolbar-brand-title").getText().toLowerCase().replaceAll(" ", ""))){
				UtilHBM.reportOK("VISIT STORE button is displayed & points to correct brand link");
			}else{
				UtilHBM.reportWarning("VISIT STORE button displayed but link may not be pointng to correct brand");
			}
		}else{
			UtilHBM.reportKO("VISIT STORE button is not displayed");
		}
		clickBlankTillPropertiesDisappearDev();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner duplicateDev(int xTarget, int yTarget){
		
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		duplicateBubble.click();
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("product duplicated using Duplicate in Balloon");
		return this;
	}
	
	public ProductInfo clickInfoBubble(int xTarget, int yTarget){
		
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		infoBubble.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ThreeDPlanner clickDuplicateBubble(){
		UtilHBM.waitExplicitDisplayed(driver, duplicateBubble);
		UtilHBM.waitExplicitClickable(driver, duplicateBubble);
		duplicateBubble.click();
		return this;
	}
	
	public ThreeDPlanner animate(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		animateBubble.click();
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("product duplicated using Duplicate in Balloon");
		return this;
	}
	
	public ThreeDPlanner splitWallDev(int xTarget, int yTarget) {
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		splitBubble.click();
		clickBlankTillPropertiesDisappearDev();
		return this;		
	}
	
	public ThreeDPlanner fpRotateDev(int steps, String upDownLeftRight){
		UtilHBM.hitArrowKeyDev(driver, steps, upDownLeftRight);		
		return this;
	}
	
	public ThreeDPlanner dragNDrop (int xPoint1, int yPoint1, int xPoint2, int yPoint2){
//		Actions action = new Actions(driver);
//		//hoverInPlanner(xPoint1, yPoint1);
//		clickInPlanner(xPoint1, yPoint1);
//		UtilHBM.waitFixTime(2000);
////		action.clickAndHold().moveByOffset(xPoint2, yPoint2).pause(500).release().build().perform();
//		action.moveToElement(container3D, xPoint1, yPoint1).clickAndHold().pause(1000)
//		.moveByOffset(xPoint2-xPoint1, yPoint2-yPoint1).pause(1000).release().pause(500)
//		.build().perform();
//		return this;
		
		//clickBlank();
		//clickBlankSpace();
//		doubleClickInPlanner(xPoint1, yPoint1);
		clickInPlanner(xPoint1, yPoint1);
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(container3D, xPoint1, yPoint1).clickAndHold().pause(1000).dragAndDropBy(container3D, xPoint2, yPoint2)
				.pause(1000).release().build().perform();
		//clickBlank();
		//clickBlankSpace();
		return this;
	}
	
	public ThreeDPlanner rotateProd (int xPoint1, int yPoint1, int xPoint2, int yPoint2){

		doubleClickInPlanner(xPoint1, yPoint1);
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xPoint1, yPoint1).clickAndHold().pause(1000).dragAndDropBy(container3D, xPoint2, yPoint2)
				.pause(1000).release().build().perform();
		return this;
	}


	private void placeProductDev(int xOffset, int yOffset){
		turnOffImplicitWaits();
		if(productPlacementInstruction.getText().equalsIgnoreCase("Click on walls or floors to apply your coating. Click again to undo.")){
			clickInPlanner(xOffset, yOffset);
			validateButton.click();			
		}else{
			int i = 0;
			do{	
				if(i<13){
					clickInPlanner(xOffset, yOffset);
					UtilHBM.waitFixTime(500);
				}else{
					doubleClickInPlanner(xOffset, yOffset);
				}								
				i++;				
			}while(UtilHBM.listOfWebElement(driver, ".overlay-top-title-message").size()>0 && i<20);
			if(i<13){
				UtilHBM.reportInfo("Number of click to place object = " + i);
			}else{
				UtilHBM.reportWarning("Double click used in planner. Number of click to place object = " + i);
			}
		}			
		turnOnImplicitWaits();
	}
	
//	-------------------------------PlaftformDev--------------------------------
	public ThreeDPlanner loginDev (SignUpData signUpData){		
		WebElement trial = UtilHBM.webElement(driver, "#trialClose");
		UtilHBM.waitExplicitClickable(driver, trial);
		trial.click();
		UtilHBM.webElement(driver, "body").sendKeys(Keys.CONTROL, Keys.SHIFT, Keys.F12);
		usernameDev.sendKeys(signUpData.getLoginId());
		pwdDev.sendKeys(signUpData.getPassword());
		loginBtnDev.click();		
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner createProjectDev(NewProjectData newProjectData){
		UtilHBM.webElement(driver, "body").sendKeys(Keys.CONTROL, Keys.F12);
		debugMenu.click();
		createProjectDev.click();
		UtilHBM.webElement(driver, "body").sendKeys(Keys.CONTROL, Keys.F12);
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillEmpltyProjectDetailsDev(newProjectData);
	}
	
	public ThreeDPlanner openProject(int prgIndex){
		UtilHBM.webElement(driver, "body").sendKeys(Keys.CONTROL, Keys.F12);
		debugMenu.click();
		getAllProject.click();
		projectList.get(prgIndex).click();
		UtilHBM.waitExplicitDisplayed(driver, projectTitle);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	//-----------------------------------generic API-----------
	public ThreeDPlanner clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner doubleClickInPlanner(int xOffset, int yOffset){
//		int x = (container3D.getSize().getWidth()/2) + xOffset;
//		int y = (container3D.getSize().getHeight()/2) + yOffset;
		int x = xOffset;
		int y = yOffset;
		System.out.println("point to click is: " + x + " , " + y);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).pause(2000).doubleClick().build().perform();
//		action.moveToElement(container3D, x, y).click().build().perform();
//		action.moveToElement(container3D, 100, 100).build().perform();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner hoverInPlanner(int xOffset, int yOffset){		
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).pause(2000).build().perform();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private ThreeDPlanner clickBlankSpaceDev(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).click().build().perform();
		new Actions(driver).moveToElement(container3D, 20-container3D.getRect().getWidth()/2, 10-container3D.getRect().getHeight()/2).clickAndHold().pause(500).release().build().perform();
//		new Actions(driver).moveToElement(container3D, 10, 10).click().build().perform();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private ThreeDPlanner doubleClickBlankSpaceDev(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).doubleClick().build().perform();
		new Actions(driver).moveToElement(container3D, 20-container3D.getRect().getWidth()/2, 10-container3D.getRect().getHeight()/2).pause(2000).doubleClick().build().perform();
//		new Actions(driver).moveToElement(container3D, 10, 10).click().build().perform();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner hoverBlankSpaceDev(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).build().perform();//
		new Actions(driver).moveToElement(container3D, 20-container3D.getRect().getWidth()/2, 10-container3D.getRect().getHeight()/2).pause(2000).build().perform();
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	public void clickObjTillPropertiesAppearDev(int xOffset, int yOffset){
		turnOffImplicitWaits();		
		int i=0;
		do{
			clickBlankSpaceDev();
			if(i<13){
				clickInPlanner(xOffset, yOffset);
			}else{
				doubleClickInPlanner(xOffset, yOffset);
			}						
			i++;			
		}while(!(bubbleCommandlist.size()>0)&&i<20);		
		turnOnImplicitWaits();
		if(i<13 && i>5){
			UtilHBM.reportInfo("Number of click to get property of object = "+ i);
		}else if(i>=13){
			UtilHBM.reportWarning("Double click used in planner to select object. Number of click to place object = " + i);
		}
	}
	
	public void clickBlankTillPropertiesDisappearDev(){
		turnOffImplicitWaits();
		int i=0;
		do{
			if(i<13){
				clickBlankSpaceDev();
			}else{
				doubleClickBlankSpaceDev();
			}					
			i++;
		}while((bubbleCommandlist.size()>0)&&i<20);
		if(i<13 && i>5){
			UtilHBM.reportInfo("Number of click to get property of object = "+ i);
		}else if(i>=13){
			UtilHBM.reportWarning("Double click used in planner to de-select object. Number of click to place object = " + i);
		}			
		turnOnImplicitWaits();
	}
	
	public ThreeDPlanner saveClick(){
		
		UtilHBM.waitFixTime(1000);
		//driver.switchTo().parentFrame();
		//driver.switchTo().frame("planner-embed-iframe");
		UtilHBM.waitExplicitClickable(driver, saveButton);
		saveButton.click();
		return this;
	}
	
	
	public ThreeDPlanner signUPFromTrialProject(SignUpData signUpData){
		driver.switchTo().parentFrame();
//		driver.switchTo().frame(UtilHBM.webElement(driver, ".register-iframe"));
		driver.switchTo().frame(UtilHBM.webElement(driver, ".registration-modal-standalone"));
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, "//header/h1[@data-testid='register-title']");
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData);
		for (String winHandle: driver.getWindowHandles()){			
			driver.switchTo().window(winHandle);
		}		
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		CompleteProfile completeProfile = PageFactory.initElements(driver, CompleteProfile.class);
		completeProfile 
//		.verifyCompleteProfileDialog()
		//.selectUsageType("Professional")
		.completeProfile("Student", "", false);
		UtilHBM.waitFixTime(2000);
		for (String winHandle: driver.getWindowHandles()){			
			driver.switchTo().window(winHandle);
		}
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-embed-iframe")));
		UtilHBM.waitExplicitDisplayed(driver, messageNotification);
		return this;
	}
	
	public ThreeDPlanner signUPFromGoogle(SignUpData signUpData){
		driver.switchTo().parentFrame();		
		driver.switchTo().frame(UtilHBM.webElement(driver, ".registration-modal-standalone"));
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, "//header/h1[@data-testid='register-title']");
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.gmailUser().signUpGoogle(signUpData);
		
//		UtilHBM.waitFixTime(5000);
//		for (String winHandle: driver.getWindowHandles()){			
//			driver.switchTo().window(winHandle);
//		}		
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		CompleteProfile completeProfile = PageFactory.initElements(driver, CompleteProfile.class);
		completeProfile 
//		.verifyCompleteProfileDialog()
		//.selectUsageType("Professional")
		.completeProfile("Student", "", false);
		UtilHBM.waitFixTime(2000);
		for (String winHandle: driver.getWindowHandles()){			
			driver.switchTo().window(winHandle);
		}
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-embed-iframe")));
		UtilHBM.waitExplicitDisplayed(driver, messageNotification);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	public ThreeDPlanner saveAsCopy(String projectName){
		
		UtilHBM.waitExplicitDisplayed(driver, title);
		UtilHBM.waitFixTime(2000);
		SaveCopy save = PageFactory.initElements(driver, SaveCopy.class);
		save.saveCopy(projectName);
		UtilHBM.waitExplicitDisplayed(driver, saveSuccessMsg);
		Verification.displayNAttributeCheckOfElement(saveSuccessMsg, "Project saved message", "text", "Your project has been saved.");
		messageNotificationCloseButton.click();
		return this;
	}
	
	//---------------------------Mobile-------------------
	

public ThreeDPlanner addAProductMobile (String product, int xOffset, int yOffset){	
		System.out.println(product + "To be added");
		catalogCommands.click();
		String catalogCommand;		
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){			
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product).split(">")[0];
		}else{				
			catalogCommand= UtilHBM.getKeyValue(Setting.catalogPath).get(product).split(">")[0];				
		}		
		switch(catalogCommand){
		case "Build":
			build.click();
			break;
		case "Furnish":
			furnish.click();
			break;
		case "Decorate":
			decorate.click();
			break;
		case "Brands":
			brands.click();
			break;			
		}
		UtilHBM.waitTillElementDisappear(driver, "#catalog-loader");
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductMobile(product);
		UtilHBM.waitFixTime(2000);
		validateButton.click();
		hoverInPlanner(0, 0);
		dragNDrop(0, 0, xOffset, yOffset);
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK(product + " added in the project successfully");				
		return this;	
	}

	public ThreeDPlanner addAProductFromBrandsMobile(String product, int xOffset, int yOffset){
		catalogCommands.click();
		brands.click();
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.addProductfromBrandsMobile(product);
		UtilHBM.waitFixTime(2000);		
	//	clickBlankSpaceDev()
		hoverInPlanner(0, 0)
		.dragNDrop(0, 0, xOffset, yOffset);
		validateButton.click();
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK(product + " added in the project successfully");		
		return this;
	}
	
	public ThreeDPlanner movePrdMobile(int xOffset, int yOffset, int xOffset1, int yOffset1){
		clickObjTillPropertiesAppearDev(xOffset, yOffset);
		dragNDrop(xOffset, yOffset, xOffset1, yOffset1);
		clickBlankTillPropertiesDisappearDev();	
		return this;
	}
	public ThreeDPlanner lightsOff(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		Verification.displayNAttributeCheckOfElement(lightBubbleIcon, "Light Off icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-bulb-off");
		Verification.verifyText(lightBubble, "Switch off", "lightBubble");
		lightBubble.click();
		Verification.displayNAttributeCheckOfElement(lightBubbleIcon, "Light On icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-bulb-alight");
		Verification.verifyText(lightBubble, "Switch on", "lightBubble");
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("Lights are turned ON");
		return this;
		}
	
	public ThreeDPlanner lightsOn(int xTarget, int yTarget){
		clickObjTillPropertiesAppearDev(xTarget, yTarget);
		Verification.displayNAttributeCheckOfElement(lightBubbleIcon, "Light On icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-bulb-alight");
		Verification.verifyText(lightBubble, "Switch on", "lightBubble");
		lightBubble.click();
		Verification.displayNAttributeCheckOfElement(lightBubbleIcon, "Light Off  icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-bulb-off");
		Verification.verifyText(lightBubble, "Switch off", "lightBubble");
		clickBlankTillPropertiesDisappearDev();
		UtilHBM.reportOK("Lights are turned OFF");
		return this;
	}
	
	public ThreeDPlanner export(){
		export.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public ThreeDPlanner exportDSHBMConfirmation(boolean export){
		Verification.displayNAttributeCheckOfElement(imageDS, "imageDS", "src", "https://preprod-platform.by.me/assets/images/hbm-to-draftsight.jpg");
		Verification.displayNAttributeCheckOfElement(titleDS, "titleDS", "text", "Export as a DraftSight file");
		Verification.displayNAttributeCheckOfElementExcludeLineBreak(descriptionDS, "descriptionDS", "text", "Export your HomeByMe project as a DraftSight file to create, edit and annotate your 2D drawings in DWG/DXF formats.");
		if (export){
			downloadDraftSightFile.click();
		}else{
			cancelDraftSightFile.click();
		}
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	public ThreeDPlanner cancelDSFile(){
		cancelDraftSightFile.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	

	}
