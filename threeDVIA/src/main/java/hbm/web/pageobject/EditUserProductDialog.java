package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class EditUserProductDialog {
	WebDriver driver;

	public EditUserProductDialog(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(css = "div#g-modal-edit>div>div.g-modal-title")
	WebElement editYourContentTitle;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(1)>input")
	WebElement nameInput;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(1)>div")
	WebElement nameLabel;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(2)>input")
	WebElement descInput;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(2)>div")
	WebElement descLabel;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(3)>div")
	WebElement categoryLabel;

	@FindBy(css = "div#g-modal-edit>div>div#g-modal-form>div:nth-child(3)>select")
	WebElement categorySelect;

	@FindBy(css = "div#g-modal-edit>div>div.g-modal-close")
	WebElement closeButton;

	@FindBy(css = "div#g-modal-edit>div.g-modal-footer>button:nth-child(1)")
	WebElement cancelButton;

	@FindBy(css = "div#g-modal-edit>div.g-modal-footer>button:nth-child(2)[class='g-modal-button  disabled']")
	WebElement validateDisabled;

	@FindBy(css = "div#g-modal-edit>div.g-modal-footer>button:nth-child(2)[class='g-modal-button  g-modal-button-alt']")
	WebElement validateButton;

	public UserProfilePage verifyeditUserProductDialog(String prdName, String description, String category) {
		UtilHBM.waitExplicitDisplayed(driver, editYourContentTitle);
		UtilHBM.waitFixTime(1500);
		Verification.VerifyEquals("Wrong nameLabel", nameLabel.getText(), "Name");
		Verification.VerifyEquals("Incorrect product name displayed", nameInput.getAttribute("value"), prdName);
		Verification.VerifyEquals("Wrong descLabel", descLabel.getText(), "Description");
		Verification.VerifyEquals("Incorrect product description displayed", descInput.getAttribute("value"),
				description);
		Verification.VerifyEquals("Wrong categoryLabel", categoryLabel.getText(), "Category");
		Select select = new Select(categorySelect);
		Verification.VerifyEquals("Wrong selected category!!", select.getFirstSelectedOption().getText(), category);
		Verification.displayOfWebElement(cancelButton);
		Verification.displayOfWebElement(closeButton);
		Verification.displayOfWebElement(validateDisabled);
		clickCloseButton();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserProfilePage editUserProduct(String prdName, String description, String category) {
		UtilHBM.waitExplicitDisplayed(driver, editYourContentTitle);
		nameInput.clear();
		nameInput.sendKeys(prdName);
		descInput.clear();
		descInput.sendKeys(description);
		Select select = new Select(categorySelect);
		select.selectByVisibleText(category);
		Verification.VerifyEquals("Wrong nameLabel", nameLabel.getText(), "Name");
		Verification.VerifyEquals("Incorrect product name displayed", nameInput.getAttribute("value"), prdName);
		Verification.VerifyEquals("Wrong descLabel", descLabel.getText(), "Description");
		Verification.VerifyEquals("Incorrect product description displayed", descInput.getAttribute("value"),
				description);
		Verification.VerifyEquals("Wrong categoryLabel", categoryLabel.getText(), "Category");
		Verification.VerifyEquals("Wrong selected category!!", select.getFirstSelectedOption().getText(), category);
		Verification.displayOfWebElement(cancelButton);
		Verification.displayOfWebElement(closeButton);
		Verification.displayOfWebElement(validateButton);
		clickValidateButton();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserProfilePage clickCloseButton() {
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		UtilHBM.waitExplicitClickable(driver, closeButton);
		closeButton.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserProfilePage clickCancelButton() {
		UtilHBM.waitExplicitDisplayed(driver, cancelButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserProfilePage clickValidateButton() {
		UtilHBM.waitExplicitDisplayed(driver, validateButton);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

}
