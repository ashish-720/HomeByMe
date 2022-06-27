package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.testng.Assert;

public class AddWall {
	WebDriver driver;

	public AddWall(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "h3[data-i18n='kitchen.design_own_wall.title;planner.design_own_wall.title']")
	private WebElement addWallTitle;

	@FindBy(css = "b[data-i18n='kitchen.design_own_wall.info;planner.design_own_wall.info']")
	private WebElement addWallInfo;

	@FindBy(css = "header>div>.header-actions .cta-secondary-xl")
	private WebElement cancelAddWall;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement okAddWall;

	@FindBy(css = "input[placeholder='Room']")
	private List<WebElement> room;

	@FindBy(css = "input[placeholder='Measure2D']")
	private List<WebElement> dimList;

	@FindBy(css = "h3[data-i18n='kitchen.design_own_room_separator.title;planner.design_own_room_separator.title']")
	private WebElement addRoomSeparatorTitle;

	@FindBy(css = "b[data-i18n='kitchen.design_own_room_separator.info;planner.design_own_room_separator.info']")
	private WebElement addRoomSeparatorInfo;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;
	
	public AddWall addWallInfo() {
		UtilHBM.waitExplicitClickable(driver, okAddWall);
		String expectedTitle = "Add wall";
		String expectedInfo = "Click to draw walls, close your shape to create a room. Then, validate to save your floorplan.";
		Verification.VerifyEquals("Add Wall title not correct", addWallTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Add Wall  info not correct", addWallInfo.getText(), expectedInfo);
		Verification.displayOfWebElement(cancelAddWall);
		Verification.displayOfWebElement(okAddWall);
		return PageFactory.initElements(driver, AddWall.class);
	}

	public AddWall addRoomSeparatorInfo() {
		UtilHBM.waitExplicitClickable(driver, okAddWall);
		String expectedTitle = "Add room separation";
		String expectedInfo = "Click directly where you want to draw a room separation. Then, validate to save your floorplan.";
		Verification.VerifyEquals("Add Room Separator title not correct", addRoomSeparatorTitle.getText(),
				expectedTitle);
		Verification.VerifyEquals("Add Room Separator info not correct", addRoomSeparatorInfo.getText(), expectedInfo);
		Verification.displayOfWebElement(cancelAddWall);
		Verification.displayOfWebElement(okAddWall);
		return PageFactory.initElements(driver, AddWall.class);
	}

	public FloorPlan createWall(String wallParameterName) {
		int initialRoomCount=getRoomCount();
		String pixelValues = UtilHBM.getKeyValue(Setting.wallParametersPath).get(wallParameterName);
		UtilHBM.turnOffImplicitWaits(driver);
		System.out.println("Pixel " + pixelValues);
		for (String temPixel : pixelValues.split(">")) {
			int a = Integer.parseInt(temPixel.split(",")[0]);
			int b = Integer.parseInt(temPixel.split(",")[1]);
			System.out.println("a : "+a);
			System.out.println("b : "+b);
			int i = 0;
			if (!(dimList.size() > 0) && i < 8) {
				do {
					hoverWall(a, b);
					clickInPlanner(a, b);
					hoverWall(a + 100, b + 100);
					i++;
				} while (!(dimList.size() > 0) && i < 8);
			} else {
				do {
					hoverWall(a, b);
					clickInPlanner(a, b);
					hoverWall(a + 100, b + 100);
					i++;
				} while (dimList.size() > 0);
			}
		}
		validateAddWall();
//		verifyCreatedWall();
		int currentRoomCount = getRoomCount();
		if (!(currentRoomCount > initialRoomCount))
			UtilHBM.reportWarning("Earlier roomCount : " + initialRoomCount  + " , Current Room Count : " + currentRoomCount + ", so wall not created correctly.");

		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan validateAddWall() {
		okAddWall.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan verifyCreatedWall() {
		if (room.size() > 0) {
			UtilHBM.reportOK("Wall created successfully and number of rooms displayed are : " + room.size());
		} else {
			UtilHBM.reportKO(" Only " + room.size() + " room displayed therefore wall not created ");
		}
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public int getRoomCount() {
		UtilHBM.waitFixTime(1000);
		return room.size();
	}


	public FloorPlan clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold().pause(1000).release().perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan hoverWall(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).pause(1000).perform();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
}
