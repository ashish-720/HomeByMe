package hbm.planner.pageobject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.io.File;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LevelNavigator {
	
	WebDriver driver;
	
	public LevelNavigator(WebDriver driver) {
		this.driver = driver;
	}
		
	@FindBy(css="div>header>div>a>#current-level")
	private WebElement closeLevelNavigator;
	
	@CacheLookup
	@FindBy(css="ul>li>a[data-i18n='floor.create_above']")
	private WebElement addAFloorButton;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>a>.floor-label.levelnav.u-txtCapitalize")
	private WebElement currentFloor;
		
	@FindBy(css="ul>li>ul>li>a>.floor-label.levelnav.u-txtCapitalize")
	private List<WebElement> listFloor;
		
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>form>div>div>span>input")
	private WebElement ceilingHtInputBox;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>form>div>div>input[class$='ceiling-height  input--disabled  ']")
	private WebElement ceilingHtInputBoxDisabled;
	
	
//	@FindBy(css = "ul>li>ul>li[class$='is-active']>div>form>div>div input#ceiling-height-0")
//	private WebElement ceilingHtInputBox;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>form>div>div>label")
	private WebElement ceilingHtText;
	
//	@FindBy(css = ".floor-link.accordion-link.accordion-link-active+.accordion-box .form--inline-legend")
//	WebElement ceilingHtUnit;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>form>div>div>#btn-ceiling-validate")
	private WebElement okButton;
	
//	@FindBy(css="ul>li>ul>li[class$='is-active']>div>div>div>.buttonDelete.button--small.u-mrs")
//	private WebElement deleteButton;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>div[class='table']>div>.buttonDelete.button--small.u-mrs")
	private WebElement deleteButton;
	
	@FindBy(css ="ul>li>ul>li[class$='is-active']>div>div[class='table is-disabled ']>div>.buttonDelete.button--small.u-mrs")
	private WebElement deleteButtonDisabled;
	
	@FindBy(xpath="//a[@class='floor-link accordion-link accordion-link-active']/following-sibling::div//a[contains(@class, 'background-image button button--small')]")
	private WebElement uploadOrChangeFloorPlanButton;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>div>div>div>form>.upload-background-file-input")
	private WebElement uploadAnExistingFloorPlan;
	
	@FindBy(css="ul>li>ul>li[class$='is-active']>div>div>div>.change-background-image.button.button--small")
	private WebElement changeBackgroundButton;
	
	@CacheLookup
	@FindBy(css="a[data-i18n='floor.create_below']")
	private WebElement addABasementButton;
		
	@FindBy(css="body>#notifMsg")
	private WebElement notification;
	
	@FindBy(css="body>#notifMsg>div>div>div>#notifText")
	private WebElement notificationText;
	
	@FindBy(css="[data-notif-action='preventionMessage']>span")
	private WebElement preventionNotificationText;
	
	@FindBy(css=".icon-view-close")
	private WebElement closePreventionNotificationText;
	
	@FindBy(css = "ul>li>ul>li[class$='is-active']>div>form>div>p>label[data-i18n='property.lock']")
	private WebElement lock;
	
	@FindBy(css = "ul>li>ul>li[class$='is-active']>div>form>div>p>input")
	private WebElement lockCheckbox;
	
	public LevelNavigator verifyLevelNevigatortPanel(){
		UtilHBM.waitExplicitClickable(driver, addABasementButton);
		if(addAFloorButton.isDisplayed() && addAFloorButton.getText().equalsIgnoreCase("add a floor")
				&& listFloor.size()>0 && !(listFloor.get(0).getText().isEmpty())			
				&& ceilingHtText.isDisplayed() && ceilingHtText.getText().equalsIgnoreCase("ceiling height")	
				&& ceilingHtInputBox.getAttribute("value").split(" ")[1].matches("cm|ft")
				&& ceilingHtInputBox.isEnabled() && !ceilingHtInputBox.getAttribute("value").isEmpty()
				&& okButton.isDisplayed() && okButton.getText().equalsIgnoreCase("OK") 
				&& uploadOrChangeFloorPlanButton.isDisplayed() && uploadOrChangeFloorPlanButton.getText().matches("UPLOAD AN EXISTING FLOORPLAN |CHANGE BACKGROUND IMAGE")
				&& addABasementButton.isDisplayed() && addABasementButton.getText().equalsIgnoreCase("Add a basement")){
			if(listFloor.size()>1){
				if(deleteButton.isDisplayed() && deleteButton.getText().equalsIgnoreCase("delete")){
					UtilHBM.reportOK("Level Nevigator panel verified successfully");					
				}else{
					UtilHBM.reportKO("Delete button not availalbe in Level Nevigator panel");
				}
			}
			if (uploadOrChangeFloorPlanButton.getText().equalsIgnoreCase("Change background Image")){
				UtilHBM.reportInfo("Floor plan already exist in background");				
			}else{
				UtilHBM.reportInfo("Floor plan is not available in background");
			}
		}else{
			UtilHBM.reportKO("Something is not availalbe in Level Nevigator panel");			
		}
		closeLevelNavigator.click();
		return this;
	}
	
	
	private LevelNavigator addFloor(){
		UtilHBM.waitExplicitClickable(driver, addAFloorButton);
		int i = listFloor.size();
		addAFloorButton.click();
		if(listFloor.size()==i+1 && currentFloor.getText().equalsIgnoreCase(closeLevelNavigator.getText())){
			UtilHBM.reportOK("New floor added in project & the floor name is "+ currentFloor.getText() + " Ceiling height of floor is " + ceilingHtInputBox.getAttribute("value"));
			if(!deleteButton.isDisplayed()){
				UtilHBM.reportKO("Delete button in Level Navigator is not displyed after adding floor");
			}
		}else{
			UtilHBM.reportKO("New floor addition failed");
		}				
		return this;
	}
	
	private LevelNavigator addBasement(){
		UtilHBM.waitExplicitClickable(driver, addABasementButton);
		int i = listFloor.size();
		addABasementButton.click();
		if(listFloor.size()==i+1 && currentFloor.getText().equalsIgnoreCase(closeLevelNavigator.getText())){
			UtilHBM.reportOK("New basement added in project & the floor name is "+ currentFloor.getText() + " Ceiling height of floor is " + ceilingHtInputBox.getAttribute("value"));
			if(!deleteButton.isDisplayed()){
				UtilHBM.reportKO("Delete button in Level Navigator is not displyed after adding basement");
			}
		}else{
			UtilHBM.reportKO("Basement addition failed");
		}				
		return this;
	}
	
	private LevelNavigator editCeilingHt(String ceilingHt){		
//		ceilingHtInputBox.clear();
		ceilingHtInputBox.click();
//		ceilingHtInputBox.sendKeys(Keys.CONTROL + "a");
//		ceilingHtInputBox.sendKeys(Keys.BACK_SPACE);
		while (!ceilingHtInputBox.getAttribute("value").isEmpty()){
			ceilingHtInputBox.sendKeys(Keys.BACK_SPACE);
		}
		ceilingHtInputBox.sendKeys(ceilingHt);
		okButton.click();
		if(ceilingHtInputBox.getAttribute("value").split(" ")[0].equalsIgnoreCase(ceilingHt)){
			UtilHBM.reportOK("Ceiling height changed to " + ceilingHtInputBox.getAttribute("value"));
		}else{
			UtilHBM.reportKO("Ceiling height modifcation failed after adding new floor. Expected Value = " + ceilingHt + " ; actual value = "+ ceilingHtInputBox.getAttribute("value"));
			
		}		
		return this;
	}
	
	private ThreeDPlanner uploadPlan(String plan){
		UtilHBM.waitExplicitClickable(driver, uploadOrChangeFloorPlanButton);		
		uploadAnExistingFloorPlan.sendKeys(new File(Setting.imgPath+plan).getAbsolutePath());
		UtilHBM.waitFixTime(2000);
		if(notification.getText().contains("Processing your document")){
			UtilHBM.waitTillElementDisappear(driver, "body>#notifMsg>div>div>div>#notifText");
		}
		floorPlanNotification();
		EditFloorPlan editPlan = PageFactory.initElements(driver, EditFloorPlan.class);
		editPlan.validateEditPlan();
		UtilHBM.reportOK("New floor plan " + plan +" added in project");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner changePlan(String plan){
		UtilHBM.waitExplicitClickable(driver, changeBackgroundButton);
		changeBackgroundButton.click();	
		UtilHBM.waitFixTime(1000);
		floorPlanNotification();
		EditFloorPlan editPlan = PageFactory.initElements(driver, EditFloorPlan.class);
		editPlan.uploadPlan(plan);	
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner addFloorOrBasement(int addFloor, int addBasement, String ceilingHt, String floorPlan){
		if(!(addFloor==0)){
			addFloor();
		}
		if(!(addBasement==0)){
			addBasement();
		}
		if(!(ceilingHt.isEmpty()) || !(ceilingHt==null)){
			editCeilingHt(ceilingHt);
		}
		if(!((floorPlan.isEmpty()) || (floorPlan==null))){			
			uploadPlan(floorPlan);
		}else{
			closeLevelNavigator.click();
		}
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}	
	
	public ThreeDPlanner deleteFloor(String floorName, boolean deleteConfirm){
		UtilHBM.waitExplicitDisplayed(driver, currentFloor);
		for(WebElement tempFloor: listFloor){
			if(tempFloor.getText().equalsIgnoreCase(floorName)){
				if(!(currentFloor.getText().equalsIgnoreCase(floorName))){
					tempFloor.click();
					UtilHBM.waitFixTime(1000);
				}				
				break;
			}
		}
		if(currentFloor.getText().equalsIgnoreCase(floorName)){
			deleteButton.click();
			Message msg = PageFactory.initElements(driver, Message.class);
			msg.deleteLevel(deleteConfirm);
		}else{
			UtilHBM.reportKO("Delete Floor test failed. Active floor is: " + currentFloor.getText() + "& floor to be deleted is: " + floorName);
		}		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner changeActiveFloor(String floorName){		
		for(WebElement tempFloor: listFloor){
			if(tempFloor.getText().equalsIgnoreCase(floorName)){
				tempFloor.click();
				break;
			}
		}
		closeLevelNavigator.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner floorPlanNotification(){
		
		if(preventionNotificationText.isDisplayed() && preventionNotificationText.getText().equalsIgnoreCase("Your plan information will be visible to all users. Do not share your name, address...")){
			UtilHBM.reportOK("Prevention notification for Floor Plan verified successfully");					
		}else{
			UtilHBM.reportKO("Prevention notification for Floor Plan not available");
		}
		closePreventionNotificationText.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner lockFloor(String floorName){
		UtilHBM.waitExplicitDisplayed(driver, currentFloor);
		
		if(currentFloor.getText().equalsIgnoreCase(floorName)){
			if(!(lockCheckbox.isSelected())){
				lock.click();
				Verification.disabledWebElement(deleteButtonDisabled);
					if(lockCheckbox.isSelected()){
					UtilHBM.reportOK("lock is successfull and delete button is disabled");
					}else{
					UtilHBM.reportKO("delete button is still enable after lock");
					}
			}else{
				UtilHBM.reportWarning("floor is already lock");
			}
		}else{
				UtilHBM.reportKO("Lock Floor test failed");
		}		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner unLockFloor(String floorName){
		UtilHBM.waitExplicitDisplayed(driver, currentFloor);
	
		if(currentFloor.getText().equalsIgnoreCase(floorName)){
			if(lockCheckbox.isSelected()){
			lock.click();
				if(deleteButton.isEnabled() && !(lockCheckbox.isSelected())){
				UtilHBM.reportOK("unlock is successfull and delete button is enabled");
				}else{
				UtilHBM.reportKO("delete button is still disabled after unlock");
				}
			}else{
			UtilHBM.reportWarning("floor is already unlock");
			}
		}else{
			UtilHBM.reportKO("UnLock Floor test failed!");
		}		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public ThreeDPlanner verifylockFloor(){
		Verification.disabledWebElement(ceilingHtInputBoxDisabled);	
		Verification.disabledWebElement(deleteButtonDisabled);
		Verification.disabledWebElement(okButton);
		Verification.disabledWebElement(uploadAnExistingFloorPlan);		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
}
