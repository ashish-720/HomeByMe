package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Snapshot {

	WebDriver driver;
	
	public Snapshot(WebDriver driver) {
	this.driver = driver;
	}
	
	@FindBy(css="body>div>div>div>div>div>.head-2-icon.icon.icon-screenshot")
	private WebElement titleIcon;
		
	@FindBy(css="body>div>div>div>div>div>span[data-i18n='snapshot.screenshot']")
	private WebElement heading;
	
	@FindBy(css="body>div>div>div>div>p[class='overlay-top-title-message']")
	private WebElement instruction;
	
	@CacheLookup
	@FindBy(id = "popin-snapshoot")
	private WebElement takeSnapshotButton;	
	
	@FindBy(css=".notifMsg-item.is-fadeIn.play.notifMsg-item--success>.notifMsg-item-txt")
	private WebElement notificationMsgSuccess;
	
	@FindBy(css=".close-notif.button.button--small")
	private WebElement closeNotificationMsg;
	
	@CacheLookup
	@FindBy(css = "a[class = 'button-close button-close-snapshot']")
	private WebElement closeSnapshot;
	
	@FindBy(css=".canvas>.container-frame-snapshot>#snapshot-title")
	private WebElement titleOfScreenshot;
	
	@FindBy(xpath="//div[@class='overlayDropdown dropdown--blocker is-collapse']/ul/li/li/span[.='Display furniture']/following-sibling::span/span/select")
	private WebElement displayFurnitureInput;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Display materials']/../following-sibling::span/label")
	private WebElement displayMtlToggle;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Display measurements']/../following-sibling::span/label")
	private WebElement displayMeasurementToggle;
	
	@FindBy(xpath="//div/ul/li/li/span[.='Size']/following-sibling::span/span/select")
	private WebElement sizeMeasurement;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Display room name']/../following-sibling::span/label")
	private WebElement roomNameToggle;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Display room areas']/../following-sibling::span/label")
	private WebElement roomAreaToggle;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Add project QR code']/../following-sibling::span/label")
	private WebElement qrCodeToggle;
	
	@FindBy(xpath="//div/ul/li/li/span/span[.='Display annotations']/../following-sibling::span/label")
	private WebElement annotationsToggle;
	
	@FindBy(css=".overlay-top>.overlay-top-inner.overlay-top-inner--inline>.overlayDropdown.dropdown--blocker")
	private WebElement settingButton;
	
	@FindBy(css=".overlayDropdown.dropdown--blocker.is-collapse")
	private WebElement settingBtnCollapse;
	
	@FindBy(css=".overlayDropdown.dropdown--blocker.is-collapse>ul>li>p[data-i18n='snapshot.view_type']")
	private WebElement viewSettingTitle;
	
	@FindBy(css=".overlayDropdown.dropdown--blocker.is-collapse>ul>li>.background-image-container>div>button.slick-prev.slick-arrow")
	private WebElement previousArrowBtn;
	
	@FindBy(css=".background-image-container>div>button.slick-next.slick-arrow")
	private WebElement nextArrowBtn;
	
	@FindBy(css=".background-image-container>div>button.slick-prev.slick-arrow+div>div>.sliderSnapshotBg-item.slick-slide.slick-active")
	private WebElement activeView3DSetting;

	private String instructionText = "Select a view mode and take a screenshot of your image";
	
	
//	protected ThreeDPlanner takeSnapshot2D(String name, String displayFurnature, boolean mtl, boolean measure, String size, boolean roomName, boolean roomArea){
//		settingButton.click();
//		UtilHBM.waitExplicitDisplayed(driver, displayMtlToggle);
//		screenshotPageCheck()		
//		.selectFurnitureDisplayOption(displayFurnature)
//		.displayMtl(mtl)
//		.displayMeasurement(measure, size)
//		.clickSettingBtn();
//		if(roomAreaToggle.isDisplayed()){
//			UtilHBM.reportKO("Settting button in snapshot do not collapse menu options");
//		}
//		clickSettingBtn()
//		.displayRoomName(roomName)
//		.displayRoomArea(roomArea)
//		.takeSnapshot(name);
//		return PageFactory.initElements(driver, ThreeDPlanner.class);
//	}
	
	protected ThreeDPlanner takeSnapshot2D(String name, String displayFurnature, boolean mtl, boolean measure, String size, boolean roomName, boolean roomArea, boolean codeQR, boolean annotations){
//		settingButton.click();
		UtilHBM.waitExplicitDisplayed(driver, displayMtlToggle);
		screenshotPageCheck()		
		.selectFurnitureDisplayOption(displayFurnature)
		.displayMtl(mtl)
		.displayMeasurement(measure, size)
		.clickSettingBtn();
		if(roomAreaToggle.isDisplayed()){
			UtilHBM.reportKO("Settting button in snapshot do not collapse menu options");
		}
		clickSettingBtn()
		.displayRoomName(roomName)
		.displayRoomArea(roomArea)
		.displayQRCode(codeQR)
		.displayAnnotations(annotations)
		.takeSnapshot(name);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner takeSnapshot3D(String name, int index){
		screenshotPageCheck()
		.viewSetting3D(index)
		.takeSnapshot(name);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	protected Snapshot takeSnapshot(String name){
		enterSnapshotName(name);
		takeSnapshotButton.click();
		UtilHBM.waitExplicitDisplayed(driver, notificationMsgSuccess);
		Verification.verifyText(notificationMsgSuccess, "The image is now available.", "Screenshot success notification");
		closeNotificationMsg.click();
		closeSnapshotPanel();
		return PageFactory.initElements(driver, Snapshot.class);		
	}	
	
	private Snapshot screenshotPageCheck(){
		UtilHBM.waitExplicitDisplayed(driver, titleIcon);
		Verification.displayNAttributeCheckOfElement(heading, "Title", "text", "SCREENSHOT");
		Verification.displayNAttributeCheckOfElement(instruction, "Instruction", "text", instructionText);
		if(titleIcon.isDisplayed() && takeSnapshotButton.isDisplayed()){
			UtilHBM.reportOK("All icons & buttons in Screenshot page displayed");
		}else{
			UtilHBM.reportKO("All icons & buttons in Screenshot page are not displayed");
		}
		return this;
	}
	
	private Snapshot enterSnapshotName (String name){
		titleOfScreenshot.sendKeys(name);
		return this;
	}
	
	private Snapshot selectFurnitureDisplayOption (String allOrOnFloorOrNone){
//		displayFurnitureInput.click();
		new Select(displayFurnitureInput).selectByVisibleText(allOrOnFloorOrNone.toLowerCase());
		return this;
	}
	
	private Snapshot displayMtl (boolean mtl){
		WebElement mtlToggleStatus = displayMtlToggle.findElement(By.tagName("input"));
		if(mtl){
			if(!mtlToggleStatus.isSelected()){
				displayMtlToggle.click();
			}
		}else{
			if(mtlToggleStatus.isSelected()){
				displayMtlToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot displayMeasurement (boolean measure, String size){
		WebElement measureStatus = displayMeasurementToggle.findElement(By.tagName("input"));
		if(measure){			
			if(!measureStatus.isSelected()){
				displayMeasurementToggle.click();
			}
//			sizeMeasurement.click();
			new Select(sizeMeasurement).selectByVisibleText(size.toLowerCase());
		}else{
			if(measureStatus.isSelected()){
				displayMeasurementToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot displayRoomName (boolean roomName){
		WebElement roomNameStatus = roomNameToggle.findElement(By.tagName("input"));
		if(roomName){
			if(!roomNameStatus.isSelected()){
				roomNameToggle.click();
			}
		}else{
			if(roomNameStatus.isSelected()){
				roomNameToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot displayRoomArea (boolean roomArea){
		WebElement roomAreaStatus = roomAreaToggle.findElement(By.tagName("input"));
		if(roomArea){
			if(!roomAreaStatus.isSelected()){
				roomAreaToggle.click();
			}
		}else{
			if(roomAreaStatus.isSelected()){
				roomAreaToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot displayQRCode (boolean codeQR){
		WebElement qrCodeStatus = qrCodeToggle.findElement(By.tagName("input"));
		if(codeQR){
			if(!qrCodeStatus.isSelected()){
				qrCodeToggle.click();
			}
		}else{
			if(qrCodeStatus.isSelected()){
				qrCodeToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot displayAnnotations (boolean annotations){
		WebElement annotationsStatus = annotationsToggle.findElement(By.tagName("input"));
		if(annotations){
			if(!annotationsStatus.isSelected()){
				annotationsToggle.click();
			}
		}else{
			if(annotationsStatus.isSelected()){
				annotationsToggle.click();
			}
		}
		return this;
	}
	
	private Snapshot clickSettingBtn(){
		settingButton.click();
		return PageFactory.initElements(driver, Snapshot.class);
	}
	
	public Snapshot viewSetting3D(int index){
		UtilHBM.waitExplicitDisplayed(driver, activeView3DSetting);
		Verification.displayNAttributeCheckOfElement(viewSettingTitle, "View Setting Text", "text", "View settings");
		int i=Integer.parseInt(activeView3DSetting.getAttribute("data-slick-index"));
		//i is always 0
		
		if(i!=index){
			int j;
			if(i>index){
				//this condition will never be true
				j=i-index;
				for(int k=0;k>j;k++){
					previousArrowBtn.click();
				}
			}else {
				j=index;
//				for(int k=0;k>j;k++){
					for(int k=0;k<j;k++){
					nextArrowBtn.click();	
					UtilHBM.waitFixTime(500);
				}
			}
			UtilHBM.waitFixTime(500);
		}		
		Verification.displayNAttributeCheckOfElement(activeView3DSetting, "Screenshot view", "data-slick-index", Integer.toString(index));
		return PageFactory.initElements(driver, Snapshot.class);
	}
	
	private ThreeDPlanner closeSnapshotPanel(){
		closeSnapshot.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
}
