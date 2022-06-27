package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class UploadTwoDPlan extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void uploadTwoDPlan(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.myProjects()
		.newProject()
		
		.floorPlan()
//		.initialPlan()
		.manageLevel()
		.addFloor()
		.addBasement()
		.floorName("1", "GF")
		.floorHeight("1", "270")
		.floorDelete("0")//Basement deleted
		.addBasement()
		.levelManagerClose()
		.saveProjectDetail("twoDPlanProject", "Home Retailer")
		.floorPlan()
//		.initialPlan()
		.uploadTwoDPlan()
		.getStarted()
		.uploadFromFile("AutoFP.jpg")
		.clickInPlanner(50, 60)
		.rotation(-10, 20, "247")
		.opacity(20, 0, "65")
		.move()
		.movePlan(50, 60, 100, 120)
		.zoomIn(2)
		.zoomOut(1)
		.yourPlan()
		.yourPlanDelete()
		.deleteNo()
		.yourPlanChange()
		.deleteNo()
		.undo()
		.redo()
		.toolOption()
		.gridDisplay()
		.planSelector("Current floor") //-2: no wall,0: current floor,-1: lower floor, 1:upper floor
		//PlanSelector Not working
		.floorSelector("2")
		.uploadFromFilePDF("IDSBook.pdf")
		.chooseThisPage()
		.clickInPlanner(50, 60)
		.rotation(-10, 20, "247")
		.opacity(20, 0, "65")
		.move()
		.movePlan(50, 60, 100, 120)
		.zoomIn(2)
		.zoomOut(1)
		.yourPlan()
		.yourPlanDelete()
		.deleteNo()
		.yourPlanChange()
		.deleteNo()
		.undo()
		.redo()
		.toolOption()
		.gridDisplay()
		.planSelector("No") //		PlanSelector Not working
		.floorSelector("1")
		.uploadFromFile("AutoFP.jpg")
		.clickInPlanner(50, 60)
		.rotation(-10, 20, "247")
		.opacity(20, 0, "65")
		.move()
		.movePlan(50, 60, 100, 120)
		.zoomIn(2)
		.zoomOut(1)
//		.yourPlan()
//		.yourPlanDelete()
//		.deleteNo()
//		.yourPlanChange()
//		.deleteNo()
		.undo()
		.redo()
		.toolOption()
		.gridDisplay()
		.planSelector("Lower floor") //		PlanSelector Not working
		.validate()
		
		
		
		
		;
				
	}
	
}
