package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;

public class BODeliverProject {
	
	WebDriver driver;
	
	public BODeliverProject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement openProject;
	
	public BOInProgress openProjectIDS() {
		driver.navigate().refresh();
		openProject.click();
		String handle=driver.getWindowHandle();
		for(String handle1:driver.getWindowHandles()) {
//			if(!handle1.equalsIgnoreCase(handle))
				driver.switchTo().window(handle1);
		}	
		
		ProjectPage projectPage=PageFactory.initElements(driver, ProjectPage.class);
		projectPage.openProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView();		
		planner.closePlanner();
		UtilHBM.reportOK("Opened Project with successfully");
		return PageFactory.initElements(driver, BOInProgress.class);
	}
}