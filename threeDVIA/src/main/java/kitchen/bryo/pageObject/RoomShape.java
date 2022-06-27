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

public class RoomShape {
	WebDriver driver;

	public RoomShape(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#RoomShape")
	private WebElement roomShapeButton;

	@FindBy(css = ".header-actions .cta-secondary-xl")
	private WebElement cancelButton;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(css = "button[aria-controls='room-shape-closed")
	private WebElement standardKitchenButton;

	@FindBy(css = "button[aria-controls='room-shape-open")
	private WebElement openKitchenButton;

	@FindBy(css = "label[for='room-shape-closed-1']")
	private WebElement roomClosedKitchen1;

	@FindBy(css = "label[for='room-shape-closed-2']")
	private WebElement roomClosedKitchen2;

	@FindBy(css = "label[for='room-shape-closed-3']")
	private WebElement roomClosedKitchen3;

	@FindBy(css = "label[for='room-shape-open-1']")
	private WebElement roomOpenKitchen1;

	@FindBy(css = "label[for='room-shape-open-2']")
	private WebElement roomOpenKitchen2;

	@FindBy(css = "label[for='room-shape-open-3']")
	private WebElement roomOpenKitchen3;

	@FindBy(css = ".checked .icon-action-select-thumb")
	private WebElement roomTick;

	@FindBy(css = ".content>header>div>div>.title")
	private WebElement title;

	@FindBy(css = ".content>header>div>div>.info")
	private WebElement info;

	@FindBy(css = ".bt-tab.selected")
	private WebElement kitchenActive;

	@FindBy(css = ".bt-tab")
	private WebElement kitchenOther;

	@FindBy(css = "#room-shape-closed-kitchen>li>label")
	private List<WebElement> closedKitchens;

	@FindBy(css = "#room-shape-open-kitchen>li>label")
	private List<WebElement> openKitchens;

	@FindBy(css = "#room-shape-closed-kitchen>li")
	private List<WebElement> closedKitchenRooms;

	@FindBy(css = "#room-shape-open-kitchen>li")
	private List<WebElement> openKitchenRooms;
	
	@FindBy(css = "article[class='mod-layer-room-shape mod-open']")
	private List<WebElement> roomShapePopUp;
	

	public RoomShape testRoomShape(String roomType, int roomID) {
	

		String expectedTitle = "Change your room shape";
		String expectedInfo = "Select a shape to reset your floorplan with this new shape. You will be able to adapt it later";
		Verification.VerifyEquals("Room Shape  title not correct", title.getText(), expectedTitle);
		Verification.VerifyEquals("Room Shape  info not correct", info.getText(), expectedInfo);

		for (WebElement a : closedKitchenRooms) {
			Verification.displayOfWebElement(a.findElement(By.tagName("input")));
		}
		for (WebElement a : openKitchenRooms) {
			Verification.displayOfWebElement(a.findElement(By.tagName("input")));
		}

		Verification.displayOfWebElement(cancelButton);
		Verification.displayOfWebElement(validateButton);
		if (roomType.equalsIgnoreCase("Closed")) {
			switch (roomID) {
				case 1:
					roomClosedKitchen1.click();
					UtilHBM.waitFixTime(1000);
					break;
				case 2:
					roomClosedKitchen2.click();
					UtilHBM.waitFixTime(1000);
					break;
				case 3:
					roomClosedKitchen3.click();
					UtilHBM.waitFixTime(1000);
					break;

			}
		} else {
			switch (roomID) {
				case 1:
					roomOpenKitchen1.click();
					UtilHBM.waitFixTime(1000);
					break;
				case 2:
					roomOpenKitchen2.click();
					UtilHBM.waitFixTime(1000);
					break;
				case 3:
					roomOpenKitchen3.click();
					UtilHBM.waitFixTime(1000);
					break;

			}
		}
		validateButton.click();

		return this;
	}

	

}
