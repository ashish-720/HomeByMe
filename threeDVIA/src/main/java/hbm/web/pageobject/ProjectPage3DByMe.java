package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ProjectPage3DByMe {

	WebDriver driver;

	public ProjectPage3DByMe(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "div#projects-gallery-container>div>div>div#createBtn")
	private WebElement createProjectButton;
	
	@FindBy(xpath = "//div[@class='card-container content-wrapped mainshop']/div/p[text()='Sheet']")
	private WebElement sheetProduct;

	@FindBy(xpath = "//button[@id='add-to-project'][text()='Add to project']")
	private WebElement addToProject;
	
	@FindBy(id = "okButton")
	private WebElement okButton;
	
	@FindBy(id = "show-settings")
	private WebElement showSettings;
	
	@FindBy(xpath = "//button[text()='Delete this Project']")
	private WebElement deleteThisProject;
	
	@FindBy(id = "delete-project-confirm")
	private WebElement deleteProjectConfirm;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/h1")
	private WebElement projectOnboarding6Header;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/div/div/input[@id='projectname']")
	private WebElement projectOnboarding6Input;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/button[@id='projectNameButton'][@disabled]")
	private WebElement projectOnboarding6OKDisabled;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/button[@id='projectNameButton']")
	private WebElement projectOnboarding6OK;
	
	public ProjectPage3DByMe createProject() {
		UtilHBM.waitExplicitDisplayed(driver, createProjectButton.findElement(By.cssSelector("a")));
		UtilHBM.waitExplicitClickable(driver, createProjectButton.findElement(By.cssSelector("a")));
		createProjectButton.findElement(By.cssSelector("a")).click();
		return this; 
	}
	
	public ProjectPage3DByMe enterProjectName(String projectName) {
		UtilHBM.waitExplicitDisplayed(driver, projectOnboarding6Header);
		Verification.VerifyEquals("Wrong project name obboarding header", projectOnboarding6Header.getText(), "Give your project a name");
		Verification.displayOfWebElement(projectOnboarding6OKDisabled);
		projectOnboarding6Input.sendKeys(projectName);
		UtilHBM.waitExplicitDisplayed(driver, projectOnboarding6OK);
		Verification.displayOfWebElement(projectOnboarding6OK);
		projectOnboarding6OK.click();
		return this; 
	}
	
	public ProjectPage3DByMe addProductsToProject() {
		UtilHBM.waitExplicitClickable(driver, sheetProduct);
		sheetProduct.click();
		UtilHBM.waitExplicitClickable(driver, addToProject);
		addToProject.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, okButton);
		okButton.click();
		return this;
	}
	
	public UserHomePage3DByMe deleteProject() {
		UtilHBM.waitExplicitClickable(driver, showSettings);
		showSettings.click();
		UtilHBM.waitExplicitClickable(driver, deleteThisProject);
		deleteThisProject.click();
		UtilHBM.waitExplicitClickable(driver, deleteProjectConfirm);
		deleteProjectConfirm.click();
		return PageFactory.initElements(driver, UserHomePage3DByMe.class);
	}
	
}
