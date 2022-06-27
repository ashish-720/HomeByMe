package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class SaveProject {
	WebDriver driver;

	public SaveProject(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#popin>.content>form>.popin-footer>button[data-ui-action='validate']")
	private WebElement validateLoginButton;

	@FindBy(css = ".mod-popin-save-project-medium.mod-open>div>div>.icon-action-save")
	private WebElement saveIconOnSavePopUp;

	@FindBy(css = ".mod-popin-save-project-medium.mod-open>div>div>h1")
	private WebElement saveTitle;

	@FindBy(css = ".mod-popin-save-project-medium.mod-open>div>div>div>div>p")
	private WebElement saveInfo;

	@FindBy(id = "input-save-name")
	private WebElement projectName;

	@FindBy(id = "input-save-desc")
	private WebElement projectDesc;

	@FindBy(css = "button[data-ui-action='primary-button-action']>span")
	private WebElement saveButton;

	@FindBy(css = "p[data-notif-action='save']")
	private WebElement saveRibbon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private List<WebElement> loginForm;

	@FindBy(xpath = "//div/p[@class='error persistent show']/span")
	private WebElement projectExceedsMsg;

	@FindBy(xpath = "//div/p[@class='error persistent show']/button[@data-ui-action='notif-link-click']")
	private WebElement reNameProjectLink;
	
	@FindBy(xpath = "//div/p[@class='error persistent show']/button[@data-ui-action='close-notif']/span")
	private WebElement projectExceedCloseMsg;
	
	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-from-media-small mod-open']/div/div")
	private List<WebElement> unSavedChangesPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-from-media-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement saveUnsavedChanges;

	public SaveProject saveUnsavedChanges() {
		UtilHBM.waitFixTime(1500);
		System.out.println(unSavedChangesPopUp.size());
		if (unSavedChangesPopUp.size() > 0) {
			if (unSavedChangesPopUp.get(0).isDisplayed()) {
				saveUnsavedChanges.sendKeys(Keys.ENTER);
			}
		}

		return PageFactory.initElements(driver, SaveProject.class);
	}

	public SaveProject saveProject(String name, String desc) {
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, saveIconOnSavePopUp);
//		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
//		driver.switchTo().frame(frames.get(0));
		String expectedTitle = "Save your project";
		String expectedInfo = "Please feel free to rename it if you like.";
		Verification.displayOfWebElement(saveIconOnSavePopUp);
		Verification.VerifyEquals("Save project title incorrect ", saveTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Save project info incorrect ", saveInfo.getText(), expectedInfo);
//		projectName.sendKeys("invalid>data");
//		WebElement ele = driver.findElement(By.cssSelector("#project-name-error"));
//		UtilHBM.waitExplicitDisplayed(driver, ele);
//		if (saveButton.isEnabled()) {
//			UtilHBM.reportKO(saveButton.getText() +" is not disabled for invalid symbols");
//		} else {
//			UtilHBM.reportOK(saveButton.getText() + " is  disabled for invalid symbols.");
//		}
//		Verification.VerifyEquals("Wrong error message", ele.getText(),
//				"The following symbols are not valid <, >, \", /, &.");
//		UtilHBM.waitFixTime(1000);
		if (!(name.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectName);
			projectName.click();
			projectName.clear();
			projectName.sendKeys(name);
		}

		if (!(desc.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectDesc);
			projectDesc.click();
			projectDesc.clear();
			projectDesc.sendKeys(desc);
		}

		UtilHBM.waitFixTime(1500);
		saveButton.click();
		verifyProjectExceed(name);
		return PageFactory.initElements(driver, SaveProject.class);
	}

	public SaveProject verifyProjectExceed(String name) {
		if (name.length() > 300) {
			UtilHBM.waitExplicitDisplayed(driver, projectExceedsMsg);
			Verification.VerifyEquals("Incorrect Project exceeds error msg ", projectExceedsMsg.getText(),
					"Project name exceeds maximum length.");
		} else {
			UtilHBM.waitExplicitDisplayed(driver, saveRibbon);
			Verification.VerifyEquals("Incorrect notification message displayed ", saveRibbon.getText(),
					"Your project has been saved.");
		}
		return PageFactory.initElements(driver, SaveProject.class);
	}

	public SaveProject reNameProject(String name,String desc) {
		UtilHBM.waitExplicitDisplayed(driver,reNameProjectLink );
		UtilHBM.waitExplicitClickable(driver,reNameProjectLink );
		Verification.VerifyEquals("Incorrect Rename your project text displayed ", reNameProjectLink.getText(),
				"Rename your project");
		Verification.VerifyEquals("Project exceed close icon not distinguishable...", projectExceedCloseMsg
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-view-close");
		reNameProjectLink.click();
		saveProject(name, desc);
		return PageFactory.initElements(driver, SaveProject.class);
	}

	public SaveProject saveProjectWothoutRibbonValidation(String name, String desc) {
		UtilHBM.waitFixTime(500);

		String expectedTitle = "Save your project";
		String expectedInfo = "Please feel free to rename it if you like.";
		Verification.displayOfWebElement(saveIconOnSavePopUp);
		Verification.VerifyEquals("Save project title incorrect ", saveTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Save project info incorrect ", saveInfo.getText(), expectedInfo);

		if (!(name.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectName);
			projectName.click();
			projectName.clear();
			projectName.sendKeys(name);
		}

		if (!(desc.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectDesc);
			projectDesc.click();
			projectDesc.clear();
			projectDesc.sendKeys(desc);
		}

		UtilHBM.waitFixTime(1500);
		saveButton.click();
		UtilHBM.waitFixTime(1500);

		return PageFactory.initElements(driver, SaveProject.class);
	}

	// public SaveProject validateLoginUser() {
	// driver.switchTo().parentFrame();
	// if (driver.findElement(
	// By.cssSelector(".login-alert-mod-popin.mod-open>div>form"))
	// .isDisplayed()) {
	// UtilHBM.reportOK("Login form displayed");
	// System.out.println("Login form displayed");
	// } else {
	// UtilHBM.reportKO("Login form not displayed");
	// System.out.println("Login form not displayed");
	// }
	// validateLoginButton.click();
	// return this;
	// }
	//
	public SaveProject saveProjectMobile(String name, String desc) {
		UtilHBM.waitFixTime(500);
		String expectedTitle = "Save your project";
		String expectedInfo = "Please feel free to rename it if you like.";
		Verification.displayOfWebElement(saveIconOnSavePopUp);
		Verification.VerifyEquals("Save project title incorrect ", saveTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Save project info incorrect ", saveInfo.getText(), expectedInfo);
		if (!(name.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectName);
			projectName.click();
			projectName.clear();
			projectName.sendKeys(name);
		}

		if (!(desc.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, projectDesc);
			projectDesc.click();
			projectDesc.clear();
			projectDesc.sendKeys(desc);
		}
		UtilHBM.waitFixTime(1500);
		saveButton.click();
		verifyProjectExceed(name);
		return PageFactory.initElements(driver, SaveProject.class);
	}
}
