package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PanoramicConfirmation {
	
	WebDriver driver;
	
	public PanoramicConfirmation(WebDriver driver) {
		this.driver=driver;	
	}
	
	@CacheLookup
	@FindBy(css="body>div>div>.modal-title")
	private WebElement title;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>.u-mtm.u-mbxs")
	private WebElement image;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>p>span")
	private WebElement message;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>div>#back-link")
	private WebElement backToMyFloorPlan;
	
	@CacheLookup
	@FindBy(css = "body>div>.close-modal.button-close")
	private WebElement closeButton;
		
	private String titleText = "Your request has been sent";
	private String messageText="We will inform you when" + '\n' + "your 360° image is ready.";
	private String imagePath ="assets/images/rendering360/request-send@1x.png, assets/images/rendering360/request-send@2x.png";
	
	public ThreeDPlanner backToByFloorPlan(){
		UtilHBM.waitExplicitDisplayed(driver, image);
		Verification.displayNAttributeCheckOfElement(title, "Title", "text", titleText);		
		Verification.displayNAttributeCheckOfElement(image, "Images", "srcset", imagePath);
		Verification.displayNAttributeCheckOfElement(message, "Message", "text", messageText);		
		backToMyFloorPlan.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
}
