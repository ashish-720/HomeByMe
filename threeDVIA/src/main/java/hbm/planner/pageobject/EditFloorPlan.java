package hbm.planner.pageobject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditFloorPlan {
	
	WebDriver driver;
	
	public EditFloorPlan(WebDriver driver) {
		this.driver = driver;	
	}
	
	@CacheLookup
	@FindBy(css="div>div>div>#validate-background-image")
	private WebElement validateButton;
	
	
	@FindBy(css="div>div>div>div>div>form>#overlayBackgound-file-input")
	private WebElement uploadButton;
	
	@CacheLookup
	@FindBy(css="div>div>div>div>#delete-background-button")
	private WebElement deleteButton;
	
	@CacheLookup
	@FindBy(css="div>div>.button-close.button-close-background")
	private WebElement closeEditFloorPlan;
	
	@CacheLookup
	@FindBy(css="div>div>div>span>#scale")
	private WebElement scaleInputBox;	
	
	@FindBy(css="body>#notifMsg")
	private WebElement notification;
	
	public ThreeDPlanner validateEditPlan(){
		UtilHBM.waitExplicitClickable(driver, validateButton);	
		validateButton.click();
		UtilHBM.reportOK("FloorPlan added");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner uploadPlan(String plan){		
		uploadButton.sendKeys(new File(Setting.imgPath+plan).getAbsolutePath());
		if(notification.getText().contains("Processing your document")){
			UtilHBM.waitTillElementDisappear(driver, "body>#notifMsg>div>div>div>#notifText");
		}
		validateButton.click();
		UtilHBM.reportOK("FloorPlan changed to " + plan);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
		
	}
	

}
