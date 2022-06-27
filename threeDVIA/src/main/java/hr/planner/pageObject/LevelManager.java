package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LevelManager {
	
	WebDriver driver;
	public LevelManager(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[name='add-floor']")
	private WebElement addFloor;
	
	@FindBy(css = "[name='add-basement']")
	private WebElement addBasement;
	
	@FindBy(css = "[data-i18n='level_manager.title']")
	private WebElement levelManagerText;
	
	@FindBy(css = "[class='mod-popin-level-manager-large mod-open']>div>header>button>span.icon-view-close")
	private WebElement levelManagerCloseBtn;
	
	public LevelManager addFloor(){		
		Verification.displayOfWebElement(levelManagerText);
		Verification.verifyText(addFloor, "+ Add a floor", "Add a floor text");
		addFloor.click();
		return PageFactory.initElements(driver, LevelManager.class);	
	}
	
	public LevelManager addBasement(){
		Verification.verifyText(addBasement, "+ Add a basement", "Add a basement text");
		addBasement.click();
		return PageFactory.initElements(driver, LevelManager.class);	
	}
	
	public LevelManager floorName(String id, String floorName){
		
		if(!floorName.isEmpty()) {
			
			Verification.displayNAttributeCheckOfElement(UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>span>input"), "GF text", "value", "Ground floor");
			UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>span>input").sendKeys(Keys.CONTROL+"a");
			UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>span>input").sendKeys(floorName);
			UtilHBM.waitFixTime(500);
			}
		return PageFactory.initElements(driver, LevelManager.class);
	}
	
	public LevelManager floorHeight(String id,  String ceilingHeight){
		
		if(!ceilingHeight.isEmpty()) {
			
			if (driver.getCurrentUrl().contains("US")) {

				Verification.displayNAttributeCheckOfElement(UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>p>span>[name='change-level-ceiling'"), "Default ceiling height", "value", "98 3/8"
							+ "\"");

			} else {

				Verification.displayNAttributeCheckOfElement(UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>p>span>[name='change-level-ceiling'"), "Default ceiling height", "value", "250 cm");
			}
			
			//98 3/8"
			
			UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>p>span>[name='change-level-ceiling'").sendKeys(Keys.CONTROL+"a");
			UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>p>span>[name='change-level-ceiling'").sendKeys(ceilingHeight);
			UtilHBM.waitFixTime(500);
			}
		return PageFactory.initElements(driver, LevelManager.class);
	
	}
	
	public LevelManager floorDelete(String id){		
		UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>button>.icon-action-delete").click();
		UtilHBM.webElement(driver, "[data-ui-index='"+id+"']>div>span>button.cta-primary").click();
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, LevelManager.class);
	
	}
	
	public HomePlanner levelManagerClose(){	
		UtilHBM.waitFixTime(500);
		levelManagerCloseBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, "//article[@class='mod-popin-level-manager-large']");
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	
	
}