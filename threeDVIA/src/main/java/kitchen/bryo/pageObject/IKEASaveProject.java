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

public class IKEASaveProject {
	WebDriver driver;

	public IKEASaveProject(WebDriver driver) {
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

	@FindBy(id = "project-title")
	private List<WebElement> savedProjectName;



	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-small mod-open']/div/div")
	private List<WebElement> unSavedChangesPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-unsaved-changes-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement saveUnsavedChanges;

	public IKEASaveProject saveUnsavedChanges() {
		UtilHBM.waitFixTime(1500);
		System.out.println(unSavedChangesPopUp.size());
		if (unSavedChangesPopUp.size() > 0) {
			if (unSavedChangesPopUp.get(0).isDisplayed()) {
				saveUnsavedChanges.sendKeys(Keys.ENTER);
			}
		}
		return PageFactory.initElements(driver, IKEASaveProject.class);
	}
	
	public IKEASaveProject ikeaSaveProject(String name, String desc) {
		UtilHBM.waitFixTime(500);
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
		UtilHBM.waitExplicitDisplayed(driver, saveRibbon);
		if(saveRibbon.getText().equalsIgnoreCase("Your project has been saved.")) {
			UtilHBM.reportOK("project saved and notification message displayed is : "+saveRibbon.getText());
		}
		verifySavedProjectDetails(name);
		return PageFactory.initElements(driver, IKEASaveProject.class);
	}

	public MakeItYours verifySavedProjectDetails(String name) {
				if (savedProjectName.get(0).getText().equalsIgnoreCase(name))
				UtilHBM.reportOK("Project saved successfully and project name is " + savedProjectName.get(0).getText());
			else
				UtilHBM.reportKO("Project not saved and project name is " + savedProjectName.get(0).getText());
		return PageFactory.initElements(driver, MakeItYours.class);
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

}
