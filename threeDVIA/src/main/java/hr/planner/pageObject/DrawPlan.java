package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DrawPlan {

	WebDriver driver;

	public DrawPlan(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(css = "div.text>h3.title")
	private WebElement title;

	@FindBy(css = ".mod-measure-input>input")
	private WebElement editSurfaceInput;

	@FindBy(css = ".form-select>select")
	private WebElement roomTypeInput;

	@FindBy(css = ".room-shape-list>li>input#room1")
	private WebElement selectRoom;

	@FindBy(xpath = "//button[@data-ui-action='sublayer-close']")
	private WebElement addButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=undo]>.icon-action-undo")
	private WebElement undoButton;

	@FindBy(css = "ul.tool-list>li>button[data-ui-action=redo]>.icon-action-redo")
	private WebElement redoButton;

	@FindBy(css = "button[data-ui-action=layer-validate]")
	private WebElement validateButton;

	@FindBy(css = "button[data-ui-action=layer-close]")
	private WebElement cancelButton;

	@FindBy(xpath = "//main[@role='main']/div/div/div//div/div/ul/li/ul/li[@data-ui-subsubcat='add-room']/button[@class='bt-text']")
	private WebElement addRoom;

	// @FindBy(css = "div>#subtitle")
	// private WebElement subtitle;

	@FindBy(css = "div>.info")
	private WebElement subtitle;

	@FindBy(css = "[data-i18n='add_room.surface']")
	private WebElement surfaceAreaText;

	@FindBy(css = "[data-i18n='add_room.type']")
	private WebElement typeText;

	@FindBy(css = "#canvas-container>input[placeholder='Measure2D']")
	private List<WebElement> measureList;

	@FindBy(css = "input.room.Tag3D.visibility-visible.pointer-events-deactivated")
	private List<WebElement> roomTagList;

	public DrawPlan editSurface(String roomSurfaceArea) {
		UtilHBM.clearInputBox(editSurfaceInput);
		editSurfaceInput.sendKeys(roomSurfaceArea);
		Verification.displayNAttributeCheckOfElement(editSurfaceInput,
				"Room Area", "value", roomSurfaceArea);
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan roomType(String roomType) {
		
		Select select = new Select(driver.findElement(By.cssSelector(".form-select>select")));
		select.selectByVisibleText(roomType); 
		System.out.println("Room type is : " + roomType);
		Verification.displayNAttributeCheckOfElement(select.getFirstSelectedOption(),
				"Room Type", "text", roomType);
		
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan selectRoom(String room) {

		UtilHBM.webElementXPath(driver,
				"//ul[@class='room-shape-list']/li/label[@for='" + room + "']")
				.click();
		Verification.displayNAttributeCheckOfElement(selectRoom,
				"Select Room Shape", "id", room);
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public HomePlanner clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner hoverInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).pause(2000).build()
				.perform();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public DrawPlan addButton() {
		Verification.displayOfWebElement(addButton);
		addButton.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan addNewRoom(int xOffset, int yOffset) {

		hoverInPlanner(xOffset + 5, yOffset + 5);
		clickInPlanner(xOffset, yOffset);
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan undo() {
		UtilHBM.waitExplicitClickable(driver, undoButton);
		Verification.displayOfWebElement(undoButton);
		undoButton.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan redo() {
		UtilHBM.waitExplicitClickable(driver, redoButton);
		Verification.displayOfWebElement(redoButton);
		redoButton.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public DrawPlan cancel() {
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		return PageFactory.initElements(driver, DrawPlan.class);
	}

	public HomePlanner validate() {

		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public DrawPlan verifyAddRoom() {

		UtilHBM.waitExplicitDisplayed(driver, title);
		Verification.verifyText(title, "Add a room", "Add a room layer tiltle");
		Verification.verifyText(subtitle,
				"Select a shape to create a new room",
				"Add a room layer sub-title");
		Verification.verifyText(surfaceAreaText, "Surface",
				"Add a room layer 'Surface' text");
		Verification.verifyText(typeText, "Type",
				"Add a room layer 'Type' text");

		if (driver.getCurrentUrl().contains("US")) {

			Verification.displayNAttributeCheckOfElement(editSurfaceInput,
					"room surface area default value", "value", "107.6 ft"
							+ "\u00B2");

		} else {

			Verification.displayNAttributeCheckOfElement(editSurfaceInput,
					"room surface area default value", "value", "10.0 m"
							+ "\u00B2");
		}
		return this;
	}

	// public DrawPlan verifyAddWall(){
	//
	// UtilHBM.waitExplicitDisplayed(driver, title);
	// Verification.verifyText(title, "Add wall", "Add a room layer tiltle");
	// Verification.verifyText(subtitle,
	// "Click to draw walls, close your shape to create a room. Then, validate to save your floorplan.",
	// "Add a room layer sub-title");
	// return this;
	// }

	public DrawPlan drawWall(String points) {
		UtilHBM.waitExplicitDisplayed(driver, title);
		Verification.verifyText(title, "Add wall", "Add wall layer tiltle");
		Verification
				.verifyText(
						subtitle,
						"Click to draw walls, close your shape to create a room. Then, validate to save your floorplan.",
						"Add wall layer sub-title");
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

	public DrawPlan verifyNoOfRoomTag(int noOfRooms) {
		if (roomTagList.size() == noOfRooms) {
			UtilHBM.reportOK("Number of Room tags verified");
		} else {
			UtilHBM.reportKO("Number of Room tags verification failed. Expected value: "
					+ noOfRooms + ", actual value: " + roomTagList.size());
		}

		return PageFactory.initElements(driver, DrawPlan.class);
	}
}
