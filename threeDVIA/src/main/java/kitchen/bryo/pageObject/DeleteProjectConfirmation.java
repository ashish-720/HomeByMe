package kitchen.bryo.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class DeleteProjectConfirmation {

	WebDriver driver;

	public DeleteProjectConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article[data-ui-selector='delete-project-popin']>div>div>div>div>p")
	private WebElement confirmationText;

	@FindBy(css = "article[data-ui-selector='delete-popin']>div>div>footer>button[data-ui-action='popin-close']>span")
	private WebElement noButton;

	@FindBy(css = "button[data-ui-id='confirm-deletion']")
	private WebElement yesButton;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
	private WebElement projectOverlay;

	@FindBy(css=".mod-layer-my-projects.mod-open>div>main>header>div>button[data-ui-action='layer-close']")
	private WebElement closeProjectOverlay;
	


	public DeleteProjectConfirmation yes() {
//		 driver.switchTo().parentFrame();
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".mod-popin-alert-delete.mod-open")));
		UtilHBM.waitExplicitDisplayed(driver, confirmationText);
		if (!confirmationText.getText().equalsIgnoreCase(
				"Do you really want to delete this project?")) {
			UtilHBM.reportKO("Delete confirmation message not displayed in delete pop-up");
		}
		new Actions(driver).moveToElement(yesButton).build().perform();
		yesButton.click();
//		UtilHBM.waitFixTime(2000);
//		UtilHBM.waitTillElementDisappear(driver, ".mod-popin-alert-delete");

		return PageFactory
				.initElements(driver, DeleteProjectConfirmation.class);
	}

	public DeleteProjectConfirmation no() {
		if (!confirmationText.getText().equalsIgnoreCase(
				"Do you want to delete this project?")) {
			UtilHBM.reportKO("Delete confirmation message is not displayed in confirmation dialog");
		}
		noButton.click();
		return PageFactory
				.initElements(driver, DeleteProjectConfirmation.class);
	}

}
