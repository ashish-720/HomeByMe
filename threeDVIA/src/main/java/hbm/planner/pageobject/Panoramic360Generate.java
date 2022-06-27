package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Panoramic360Generate {
	
	WebDriver driver;
	
	public Panoramic360Generate(WebDriver driver) {		
		this.driver = driver;		 
	}
	
	@FindBy(css="body>div>div>div>div>div>.head-2-icon.icon.icon-panoramic")
	private WebElement panoramicTitleIcon;
		
	@FindBy(css="body>div>div>div>div>div>span[data-i18n='command.blocker.rendering360.title']")
	private WebElement panoramicTitle;
	
	@FindBy(css="body>div>div>div>div>p")
	private WebElement instruction;	
	
	@FindBy(css="body>div>div>a[data-ui-action='modify-settings']")
	private WebElement modifyButton;
	
	@FindBy(css="body>div>div>a[data-ui-action='generate-realistic-render']")
	private WebElement generateButton;
	
	private String title = "360° IMAGE";
	private String instructionText2 = "Verify your point of view before generating your image.";
	
	public ThreeDPlanner generatePanoramic(){
		Verification.displayOfWebElement(panoramicTitleIcon);
		Verification.displayNAttributeCheckOfElement(panoramicTitle, "Panoramic Title", "text", title);
		Verification.displayNAttributeCheckOfElement(instruction, "Instructions2", "text", instructionText2);
		generateButton.click();
//		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".jquery-modal.blocker[style$='opacity: 0.5;']"));
		PanoramicConfirmation confirm = PageFactory.initElements(driver, PanoramicConfirmation.class);
		confirm.backToByFloorPlan();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public Panoramic360 modifyPanoramic(){
		Verification.displayOfWebElement(panoramicTitleIcon);
		Verification.displayNAttributeCheckOfElement(panoramicTitle, "Panoramic Title", "text", title);
		Verification.displayNAttributeCheckOfElement(instruction, "Instructions2", "text", instructionText2);
		modifyButton.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "body>div>div>div>div>.dropdown-link-blocker.u-prn"));
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "body>div>div>div>div>.dropdown-link-blocker.u-prn"));
		return PageFactory.initElements(driver, Panoramic360.class);
	}

}
