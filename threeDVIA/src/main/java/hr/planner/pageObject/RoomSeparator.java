package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomSeparator {
	
	WebDriver driver;

	public RoomSeparator(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#canvas-container>input[placeholder='Measure2D']")
	private List<WebElement> measureList;
	
	@FindBy(css = "[data-i18n='add_border_room_separator.title']")
	private WebElement title;
	
	@FindBy(css = "[data-i18n='add_border_room_separator.description']")
	private WebElement subtitle;
	
	@FindBy(css = "[data-i18n='common.validate']")
	private WebElement validate;
	
	@FindBy(css = "[data-i18n='common.cancel']")
	private WebElement cancel;
	
	public RoomSeparator drawSeparator(String points) {
		UtilHBM.waitExplicitDisplayed(driver, title);
		Verification.verifyText(title, "Add room separation", "Add room separation title");
		Verification
				.verifyText(
						subtitle,
						"Click directly where you want to draw a room separation. Then, validate to save your floorplan.",
						"Add separator layer sub-title");
		UtilHBM.turnOffImplicitWaits(driver);
		for (String temPixel : points.split(">")) {
			int a = Integer.parseInt(temPixel.split(";")[0]);
			int b = Integer.parseInt(temPixel.split(";")[1]);
			int i = 0;
			HomePlanner planner = PageFactory.initElements(driver,
					HomePlanner.class);
			if (!(measureList.size() > 0) && i < 20) {
				do {
					planner.hoverInPlanner(a, b).clickInPlanner(a, b)
							.hoverBlankSpaceDev();
					i++;
				} while (!(measureList.size() > 0) && i < 20);
			} else {
				do {
					planner.hoverInPlanner(a, b).clickInPlanner(a, b)
							.hoverBlankSpaceDev().hoverInPlanner(a, b);
					i++;
				} while (measureList.size() > 0 && i < 20);
			}
		}
		// new
		/*
		 * for(String temPixel:points.split(">")){ int a
		 * =Integer.parseInt(temPixel.split(";")[0]); int b
		 * =Integer.parseInt(temPixel.split(";")[1]); int i=0; HomePlanner
		 * planner = PageFactory.initElements(driver, HomePlanner.class);
		 * planner.hoverInPlanner(a, b); if(!(measureList.size()>0)){ do{
		 * planner.clickInPlanner(a, b).hoverBlankSpaceDev(); i++;
		 * }while(!(measureList.size()>0) && i<20); } }
		 */
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	
	public HomePlanner validateSepatator(){
		
		validate.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public HomePlanner cancelSepatator(){
		
		cancel.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
}
