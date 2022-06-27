package hr.web.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;

public class MyProject {

	WebDriver driver;

	public MyProject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//li/div/span/span[@class='icon-action-zoom']")
	private WebElement newProject;
	
	@FindBy(css = ".cta-primary-l")
	private WebElement deleteYesbutton;
	
	@FindBy(css = ".cta-secondary-l")
	private WebElement deleteNobutton;
	
	@FindBy(css = "[data-ui-selector='search-input']")
	private WebElement searchInput;
	
	@FindBy(css = ".search-button")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//div/div[@class='text']/p[@class='name']/span")
	private List <WebElement> projectNameInMyProject;
	
	@FindBy(xpath = "//div/p[text()='Do you really want to delete this project?']")
	private WebElement deleteProjectBoxText;
	
	public HomePlanner newProject() {
		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		UtilHBM.waitFixTime(3000);
		UtilHBM.webElement(driver, "li>div>span>.icon-action-zoom").click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-home.enterprise-dev.by.me/Planner']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader"));
		UtilHBM.waitTillElementDisappear(driver, ".loader");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//main[@role='main']/div/div/div/div/ul/li/button[@id='draw-plan']"));
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public ProjectOverview openProjectPage(String projectName, int index) {
		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		WebElement projectToOpenPP = driver.findElements(By.xpath("//div//span[text()='"+projectName+"']/ancestor::div[@class='inner-content']/div[@class='text']")).get(index);
		UtilHBM.waitExplicitClickable(driver, projectToOpenPP);
		new Actions(driver).moveToElement(projectToOpenPP).build().perform();
		projectToOpenPP.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//button[@aria-controls='project-overview-tab-1']/span[text()='Project overview']"));	
		
		return PageFactory.initElements(driver, ProjectOverview.class);
	}
	
	public HomePlanner openProject(String projectName, int index) {
		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		WebElement projectToOpen = driver.findElements(By.xpath("//div//span[text()='"+projectName+"']/ancestor::div[@class='inner-content']")).get(index);
		UtilHBM.waitExplicitClickable(driver, projectToOpen);
		new Actions(driver).moveToElement(projectToOpen).build().perform();
		WebElement openProjectBtn = projectToOpen.findElement(By.xpath("div/span/button[@title='Open']"));
		UtilHBM.waitExplicitDisplayed(driver, openProjectBtn);
		openProjectBtn.click();
		UtilHBM.waitFixTime(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src^='https://preprod-home.enterprise-dev.by.me/Planner']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader"));
		UtilHBM.waitTillElementDisappear(driver, ".loader");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//main[@role='main']/div/div/div/div/ul/li/button[@id='draw-plan']"));
		UtilHBM.waitFixTime(5000);
		return PageFactory.initElements(driver, HomePlanner.class);
	}

	

	public MyProject duplicateProject(String projectName, int index) {	
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		WebElement projectToDuplicate = driver.findElements(By.xpath("//div//span[text()='"+projectName+"']/ancestor::div[@class='inner-content']")).get(index);
		UtilHBM.waitExplicitClickable(driver, projectToDuplicate);
		new Actions(driver).moveToElement(projectToDuplicate).build().perform();
		WebElement duplicateBtn = projectToDuplicate.findElement(By.xpath("div/span/ul/li/button[@title='Duplicate']"));
		UtilHBM.waitExplicitDisplayed(driver, duplicateBtn);
		Verification.displayOfWebElement(duplicateBtn);
		duplicateBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='wrap']/div[@class='content loading']");
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='wrap']/div[@class='content']");
		return PageFactory.initElements(driver, MyProject.class);		
	}
	
	
	

	public MyProject deleteProject(String projectName, int index) {		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		WebElement projectToDelete = driver.findElements(By.xpath("//div//span[text()='"+projectName+"']/ancestor::div[@class='inner-content']")).get(index);
		UtilHBM.waitExplicitClickable(driver, projectToDelete);
		new Actions(driver).moveToElement(projectToDelete).build().perform();
		WebElement deleteBtn = projectToDelete.findElement(By.xpath("div/span/ul/li/button[@title='Delete']"));
		deleteBtn.click();
		UtilHBM.waitExplicitClickable(driver, deleteYesbutton);	//for verification	
//		deleteYes();
		return PageFactory.initElements(driver, MyProject.class);			
	}
	
	public MyProject deleteYes(){		
		Verification.VerifyEquals("Delete confirmation message is not displayed in confirmation dialog", deleteProjectBoxText.getText(), "Do you really want to delete this project?");
		deleteYesbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='wrap']/div[@class='content loading']");
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='wrap']/div[@class='content']");
		return PageFactory.initElements(driver, MyProject.class);
	}
	
	public MyProject deleteNo(){
		
		Verification.VerifyEquals("Delete confirmation message is not displayed in confirmation dialog", deleteProjectBoxText.getText(), "Do you really want to delete this project?");
		deleteNobutton.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, MyProject.class);
	}

	public MyProject searchProjectName(String searchProject) {	
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "li>div>span>.icon-action-zoom"));	
		UtilHBM.clearInputBox(searchInput);
		searchInput.sendKeys(searchProject + Keys.ENTER);
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='content'][@data-ui-selector='scrolling-content']");
		List<WebElement>searchProjectList = driver.findElements(By.xpath("//div//span[text()='"+searchProject+"']/ancestor::div[@class='inner-content']"));
		UtilHBM.waitExplicitClickable(driver, searchProjectList.get(0));
		return PageFactory.initElements(driver, MyProject.class);
	}
		
	public MyProject verifyDuplicateProjectName(String projectNameExpected, int index){		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));		
		Verification.VerifyEquals("Project Title KO", projectNameInMyProject.get(index).getText(), projectNameExpected);
		return PageFactory.initElements(driver, MyProject.class);
	}
	


}
