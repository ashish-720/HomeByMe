package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddARoom {

	WebDriver driver;
	
	public AddARoom(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(id = "room1")
	WebElement room1;
	
	@CacheLookup
	@FindBy(id = "room2")
	WebElement room2;
	
	@CacheLookup
	@FindBy(id = "room3")
	WebElement room3;
	
	@CacheLookup
	@FindBy(id = "room4")
	WebElement room4;
	
	@CacheLookup
	@FindBy(id = "room5")
	WebElement room5;
	
	@CacheLookup
	@FindBy(id = "room6")
	WebElement room6;
	
	@CacheLookup
	@FindBy(id = "room7")
	WebElement room7;
	
	@CacheLookup
	@FindBy(id = "room8")
	WebElement room8;
	
	@CacheLookup
	@FindBy(id = "room9")
	WebElement room9;
	
	@CacheLookup
	@FindBy(id = "room10")
	WebElement room10;
	
	@CacheLookup
	@FindBy(id = "createRoom-surface")
	WebElement surfaceSize;
	
	@CacheLookup
	@FindBy (id = "createRoom-type")
	WebElement roomTypeDropdownInCreateRoom;
	
	@CacheLookup
	@FindBy(id= "createRoom")
	WebElement createRoomButton;
	
	@CacheLookup
	@FindBy(css = "a[class='close-modal button-close']")
	WebElement closeCreateRoomDialog;
	
	@CacheLookup
	@FindBy(css = "a[class*='w-20 shape-link']")
	List<WebElement> roomList;
	

	
	public ThreeDPlanner roomDetails(int roomNumber, String surfaceArea, String roomType){
		UtilHBM.waitExplicitClickable(driver, createRoomButton);
		roomList.get(roomNumber-1).click();
		//surfaceSize.clear();
		if(!surfaceArea.isEmpty()){
			surfaceSize.sendKeys(surfaceArea);
		}
		if(!roomType.isEmpty()){
			new Select(roomTypeDropdownInCreateRoom).selectByVisibleText(roomType);	
			createRoomButton.click();	
		}
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
}
