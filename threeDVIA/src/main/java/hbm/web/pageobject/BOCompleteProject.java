package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;


public class BOCompleteProject {
	
	WebDriver driver;
	
	public BOCompleteProject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement createProject;
	private String handle;
	
	public BackOffice createProject(NewProjectData newProjectData,int roomNumber, String surfaceArea, String selectRoomType) {
		clickCreateProjectButton().createProjectFP(newProjectData);
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.addARoom(roomNumber, surfaceArea, selectRoomType)
		.save().closePlanner();
		driver.close();    
		driver.switchTo().window(handle);
		UtilHBM.reportOK("Project Created Successfully");
		return PageFactory.initElements(driver, BackOffice.class);

	}
	
	public ProjectPage openProjectIDS() {
		clickCreateProjectButton();
		return PageFactory.initElements(driver, ProjectPage.class);
	}	

	public ProjectPage clickCreateProjectButton() {
		handle=driver.getWindowHandle();
		createProject.click();
		for(String handle1:driver.getWindowHandles()) {
			if(!handle1.equalsIgnoreCase(handle))
				driver.switchTo().window(handle1);
		}
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
		
	}
}