package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Save3DModel {

	WebDriver driver;

	public Save3DModel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.header-actions>button[title='Upload']")
	WebElement uploadButton;

	@FindBy(css = "input#product-name-input")
	WebElement prdNameInput;

	@FindBy(id = "product-type-select")
	WebElement prdCategorySelect;

	@FindBy(id = "product-desc-input")
	WebElement prdDescInput;

	@FindBy(xpath = "//div[@class='content-inner']/header/h2")
	WebElement prdInfoHeader;

	@FindBy(xpath = "//div[@class='content-inner']/fieldset/p/label[text()='Name']")
	WebElement nameLabel;

	@FindBy(xpath = "//div[@class='content-inner']/fieldset/p/label[text()='Category']")
	WebElement categoryLabel;

	@FindBy(xpath = "//div[@class='content-inner']/fieldset/p/label[text()='Description']")
	WebElement descriptionLabel;

	@FindBy(xpath = "//div[@class='main-app']/header/div/div/h3")
	WebElement saveYourProductHeader1;

	@FindBy(xpath = "//div[@class='main-app']/header/div/div/div/span")
	WebElement saveYourProductHeader2;
	
	@FindBy(xpath = "//div[@class='main-app']/header/div/button[@class='bt-arrow-prev']")
	WebElement backButton;

	public UserProfilePage clickUploadButton() {
		UtilHBM.waitExplicitDisplayed(driver, uploadButton);
		UtilHBM.waitExplicitClickable(driver, uploadButton);
		uploadButton.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public ThreeDPlanner clickUploadButtonPlanner() {
		UtilHBM.waitExplicitDisplayed(driver, uploadButton);
		UtilHBM.waitExplicitClickable(driver, uploadButton);
		uploadButton.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public Save3DModel editPrdNameAndDesc(String prdName, String prdDesc) {
		UtilHBM.waitExplicitDisplayed(driver, prdInfoHeader);
		UtilHBM.waitExplicitDisplayed(driver, nameLabel);
		prdNameInput.clear();
		prdNameInput.sendKeys(prdName);
		UtilHBM.waitExplicitDisplayed(driver, descriptionLabel);
		prdDescInput.clear();
		prdDescInput.sendKeys(prdDesc);
		Verification.VerifyEquals("Incorrect prdName displayed after editing!!", prdNameInput.getAttribute("value"),
				prdName);
		Verification.VerifyEquals("Incorrect prdDesc displayed after editing!!", prdDescInput.getAttribute("value"),
				prdDesc);
		return this;
	}

	public Save3DModel editPrdCategory(String prdCategory) {
		UtilHBM.waitExplicitDisplayed(driver, prdInfoHeader);
		UtilHBM.waitExplicitDisplayed(driver, categoryLabel);
		UtilHBM.waitExplicitDisplayed(driver, prdCategorySelect);
		Select select = new Select(prdCategorySelect);
		select.selectByVisibleText(prdCategory);
		String categorySelected = select.getFirstSelectedOption().getText();
		Verification.VerifyEquals("Incorrect prdCategory displayed after editing!!", categorySelected,
				categorySelected);
		return this;
	}

	public Upload3dModel clickBackButton() {
		UtilHBM.waitExplicitDisplayed(driver, backButton);
		UtilHBM.waitExplicitClickable(driver, backButton);
		backButton.click();
		return PageFactory.initElements(driver, Upload3dModel.class);
	}

	public Save3DModel verifyPrdDetails(String prdName, String prdCategory, String prdDesc) {
		Verification.VerifyEquals("Wrong saveYourProductHeader1!!", saveYourProductHeader1.getText(), "Save your product");
		Verification.VerifyEquals("Wrong saveYourProductHeader2!!", saveYourProductHeader2.getText(), "Take a snapshot to define the thumbnail of your product");
		UtilHBM.waitExplicitDisplayed(driver, prdInfoHeader);
		UtilHBM.waitExplicitDisplayed(driver, nameLabel);
		UtilHBM.waitExplicitDisplayed(driver, descriptionLabel);
		Verification.VerifyEquals("Incorrect prdName displayed !!", prdNameInput.getAttribute("value"), prdName);
		Verification.VerifyEquals("Incorrect prdDesc displayed !!", prdDescInput.getAttribute("value"), prdDesc);
//		Select select = new Select(prdCategorySelect);
//		String categorySelected = select.getFirstSelectedOption().getText();
//		Verification.VerifyEquals("Incorrect prdCategory displayed!!", categorySelected, categorySelected);
		return this;
	}

}
