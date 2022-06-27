package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import static org.testng.Assert.assertNotEquals;

import java.nio.charset.StandardCharsets;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmptyRoom {
	WebDriver driver;

	public EmptyRoom(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article[class='mod-popin-empty-room-small mod-open']>div>div>h1")
	private WebElement heading;

	@FindBy(css = "article[class='mod-popin-empty-room-small mod-open']>div>div>div[class='text']>div>p")
	private WebElement title;

	@FindBy(css = "article[class='mod-popin-empty-room-small mod-open']>div>div>div[class='text']>p[class='question']")
	private WebElement info;

	@FindBy(xpath = "//article[@class='mod-popin-empty-room-small mod-open']/div/footer/button[@class='cta-secondary-xl']")
	private WebElement emptyRoomNo;

	@FindBy(xpath = "//article[@class='mod-popin-empty-room-small mod-open']/div/footer/button[@class='cta-primary-alt-xl']")
	private WebElement emptyRoomYes;

	@FindBy(xpath = "//article[@class='mod-popin-empty-room-small mod-open']/div/footer/button/span[contains(.,'نعم')]")
	private WebElement emptyRoomYesRTL;
	
	public EmptyRoom emptyRoomPopUp(String yesNo) {
		UtilHBM.waitExplicitDisplayed(driver, heading);
		String expectedHeading = "Empty the room";
		String expectedTitle = "You are about to remove the contents of your room.";
		String expectedInfo = "Are you sure you want to empty the room?";

		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("article[class='mod-popin-empty-room-small mod-open']>div>div>svg")));
		Verification.VerifyEquals("Empty Room heading not correct", heading.getText(), expectedHeading);
		Verification.VerifyEquals("Empty Room title not correct", title.getText(), expectedTitle);
		Verification.VerifyEquals("Empty Room info not correct", info.getText(), expectedInfo);
		byte[] bytesOfString = yesNo.getBytes();   
		String encoded_String = new String(bytesOfString, StandardCharsets.UTF_8); 
		System.out.println(encoded_String);
//		assertNotEquals(encoded_String, yesNo);
		if (yesNo.equalsIgnoreCase("yes")) {
			emptyRoomYes.click();
		} 
//		else if(yesNo.equalsIgnoreCase("نعم")){
//			emptyRoomYesRTL.click();
//			UtilHBM.waitFixTime(500);
//		}
		else {
			new Actions(driver).moveToElement(emptyRoomNo).click().build().perform();
		}
		return this;

	}
}
