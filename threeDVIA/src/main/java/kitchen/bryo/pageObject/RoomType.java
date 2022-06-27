package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoomType {
	WebDriver driver;

	public RoomType(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#edit-form-select-type")
	private WebElement roomTypeDropdown;

	@FindBy(css = ".mod-measure-input>#name")
	private WebElement roomNameInputBox;

	public FloorPlan roomTypeProperties(String roomType) {
		UtilHBM.waitExplicitDisplayed(driver, roomNameInputBox);
		new Select(roomTypeDropdown).selectByVisibleText(roomType);
		UtilHBM.waitFixTime(500);
		verifyRoomTypeProperties(roomType, roomType);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan verifyRoomTypeProperties(String roomName, String roomType) {
	
		System.out.println("name: "+new Select(roomTypeDropdown).getFirstSelectedOption().getText());
		System.out.println("type: "+roomNameInputBox.getAttribute("value").trim());
		if (roomType.equalsIgnoreCase(new Select(roomTypeDropdown).getFirstSelectedOption().getText())) {
			UtilHBM.reportOK(
					"Room type verified successfully. The room type is: " +new Select(roomTypeDropdown).getFirstSelectedOption().getText());
		} else {
			UtilHBM.reportKO(
					"Room type verification failed. The room name is: " +new Select(roomTypeDropdown).getFirstSelectedOption().getText());
		}
		if(roomName.equalsIgnoreCase(roomNameInputBox.getAttribute("value"))) {
			UtilHBM.reportOK(
					"Room name verified successfully. The room name is: " + roomNameInputBox.getAttribute("value"));
		} else {
			UtilHBM.reportKO(
					"Room name verification failed. The room name is: " + roomNameInputBox.getAttribute("value"));
		}
		
		return PageFactory.initElements(driver, FloorPlan.class);
	}
}
