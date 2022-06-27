package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateConfirmation {
	
	WebDriver driver;

	public DuplicateConfirmation(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//body[contains(@class,'no-scroll')]//div[@class='modal-header']/h2[@class='modal-title']")
	private WebElement duplicateHeader;
	
	@FindBy(xpath = "//div[@class='form-item-field']/preceding-sibling::label")
	private WebElement nameOfNewProjectText;

	@FindBy(css = "input[class='button']")
	private WebElement projectDuplicateOKButton;

	@FindBy(id = "project_duplicate_medias")
	private WebElement projectDuplicateCheckBox;
	
	@FindBy(xpath = "//a[@class='close-modal button-close']")
	private WebElement closeButton;

	public DuplicateConfirmation verifyDuplicateDialogBox() {
		UtilHBM.waitExplicitDisplayed(driver, duplicateHeader);
		Verification.VerifyEquals("Wrong duplicate header text", duplicateHeader.getText(), "Duplicate this project");
		Verification.displayOfWebElement(projectDuplicateOKButton);
		Verification.displayOfWebElement(closeButton);
		return this;
	}
	
	public ProjectPage clickDuplicateOK() {
		UtilHBM.waitExplicitDisplayed(driver, duplicateHeader);
		UtilHBM.waitExplicitClickable(driver, projectDuplicateOKButton);
		projectDuplicateOKButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".jquery-modal.blocker");
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public ProjectPage closeDuplicateDialogBox() {
		UtilHBM.waitExplicitClickable(driver, closeButton);
		closeButton.click();
//		UtilHBM.waitTillElementDisappear(driver, ".jquery-modal.blocker");
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
}
