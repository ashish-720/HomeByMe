package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRoomShape {
	WebDriver driver;

	public EditRoomShape(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>div>h1")
	private WebElement editRoomShapeTitle;

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>div>div[class='text']>div")
	private WebElement editRoomShapeInfo;

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>div>div[class='text']>p[class='question']")
	private WebElement editRoomShapeQuestion;

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>div")
	private WebElement editRoomShapePopUp;

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>footer>button[class='cta-primary-alt-xl']")
	private WebElement editRoomShapeYes;

	@FindBy(css = "article[class='mod-popin-edit-room-small mod-open']>div>footer>button[class='cta-secondary-xl']")
	private WebElement editRoomShapeNo;


	@FindBy(css = "button[id='go-to-auto-design']")
	private WebElement nextStep2;

	@FindBy(css = "button[id='customize-this-bathroom']")
	private WebElement nextStepBathroomBtn;

	public RoomShape overWriteRoomShape() {
//		UtilHBM.waitFixTime(500);
//		System.out.println("size "+editRoomShapePopUp.size());
//		// Store the current window handle
//		String winHandleBefore = driver.getWindowHandle();
//
//		// Perform the click operation that opens new window
//
//		// Switch to new window opened
//		for(String winHandle : driver.getWindowHandles()){
//		    driver.switchTo().window(winHandle);
//		}

		// Perform the actions on new window
//		if (editRoomShapePopUp.size() > 0) {
		UtilHBM.waitExplicitDisplayed(driver, editRoomShapePopUp);
		String expectedTitle = "Edit room shape";
		String expectedInfo = "The room shape you selected will replace the previous floorplan you created.";
		String expectedQuestion = "Do you want to overwrite your previous floorplan?";
		Verification.VerifyEquals("Edit Room Shape  title not correct", editRoomShapeTitle.getText(),
				expectedTitle);
		Verification.VerifyEquals("Edit Room Shape  info not correct", editRoomShapeQuestion.getText(),
				expectedQuestion);
		Verification.VerifyEquals("Edit Room Shape  question not correct", editRoomShapeInfo.getText(),
				expectedInfo);
		Verification.displayOfWebElement(editRoomShapeYes);
		Verification.displayOfWebElement(editRoomShapeNo);
		clickYes();
//		}

		// Switch back to original browser (first window)
//		driver.switchTo().window(winHandleBefore);

		return PageFactory.initElements(driver, RoomShape.class);
	}

	public FloorPlan clickYes() {
		UtilHBM.waitExplicitDisplayed(driver, editRoomShapeYes);
		UtilHBM.waitExplicitClickable(driver, editRoomShapeYes);
		System.out.println("text " + editRoomShapeYes.getText());
//		editRoomShapeYes.sendKeys(Keys.ENTER);
		if (driver.getCurrentUrl().contains("bathroom")) {
			new Actions(driver).moveToElement(editRoomShapeYes).doubleClick().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, nextStepBathroomBtn);

		} else {
			new Actions(driver).moveToElement(editRoomShapeYes).doubleClick().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, nextStep2);

		}
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public RoomShape clickNo() {
		UtilHBM.waitExplicitDisplayed(driver, editRoomShapeNo);
		UtilHBM.waitExplicitClickable(driver, editRoomShapeNo);
		System.out.println("text " + editRoomShapeNo.getText());

		if (driver.getCurrentUrl().contains("bathroom")) {
			new Actions(driver).moveToElement(editRoomShapeNo).doubleClick().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, nextStepBathroomBtn);

		} else {

			new Actions(driver).moveToElement(editRoomShapeNo).click().build();
			UtilHBM.waitExplicitDisplayed(driver, nextStep2);

		}
		return PageFactory.initElements(driver, RoomShape.class);
	}

}
