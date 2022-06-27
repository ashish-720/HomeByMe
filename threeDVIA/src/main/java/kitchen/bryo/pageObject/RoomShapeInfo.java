package kitchen.bryo.pageObject;

import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomShapeInfo {
	WebDriver driver;

	public RoomShapeInfo(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".content>header>div>div>.title")
	private WebElement title;

	@FindBy(css = ".content>header>div>div>.info")
	private WebElement info;

	public RoomShapeInfo testRoomInfo() {
		String expectedTitle = "Change your room shape";
		String expectedInfo = "Reset your floor plan by choosing a new shape. You can always go back and adjust it later";
		Verification.VerifyEquals("Room Shape  title not correct",
				title.getText(), expectedTitle);
		Verification.VerifyEquals("Room Shape  info not correct",
				info.getText(), expectedInfo);
	
		return this;

	}
}
