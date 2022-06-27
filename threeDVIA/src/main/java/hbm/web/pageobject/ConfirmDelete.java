package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class ConfirmDelete {

	WebDriver driver;

	public ConfirmDelete(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='confirm'][contains(@style,'opacity: 1')]/div/p")
	WebElement confirmBoxText;

	@FindBy(css = "div.confirm-box>div.confirm-box-btns>button.button--alt")
	WebElement noButton;

	@FindBy(css = "div.confirm-box>div.confirm-box-btns>button.button")
	WebElement yesButton;

	public UserHomePage yes() {
		UtilHBM.waitExplicitDisplayed(driver, confirmBoxText);
		if (!confirmBoxText.getText().equalsIgnoreCase("ARE YOU SURE YOU WANT TO DELETE YOUR PROJECT?")) {
			UtilHBM.reportKO("Delete confirmation message is not displayed in confirmation dialog");
		}
		UtilHBM.waitExplicitClickable(driver, yesButton);
		yesButton.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public ProjectPage no() {
		UtilHBM.waitExplicitDisplayed(driver, confirmBoxText);
		if (!confirmBoxText.getText().equalsIgnoreCase("ARE YOU SURE YOU WANT TO DELETE YOUR PROJECT?")) {
			UtilHBM.reportKO("Delete confirmation message is not displayed in confirmation dialog");
		}
		UtilHBM.waitExplicitClickable(driver, noButton);
		noButton.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
}
