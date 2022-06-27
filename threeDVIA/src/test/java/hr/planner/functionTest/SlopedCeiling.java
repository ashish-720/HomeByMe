package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class SlopedCeiling extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void slopedCeiling (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		
		//Open Print in planner
		
		.myProjects()
		.searchProjectName("Sloped ceiling")
		.openProject("Sloped ceiling", 0)
		.floorPlan()
		.manageSlopedCeiling()		
		.viewTwoD()
		.viewThreeD()
		.zoomIn(1)
		.zoomOut(1)
		//3D add slope
		.clickInPlanner(-123, -278)
		.slopeVerification()
		.create()
		.clickInPlanner(380, -276)
		.slopeVerification()
		.create()
		//3d delete slope
		.clickInPlanner(-128, -236)
		.deleteSlopedCeiling()//failing here
		//3d change slope
		.clickInPlanner(336, -214)
		.changeSlopedCeiling()
		.slopedCeilingInput("", "150")
		.create()
		.viewTwoD()
		//2D add slope
		.clickInPlanner(-168, -138)
		.viewThreeD()
		.viewTwoD()
		//2D remove slope
		.clickInPlanner(-210, 27)
		.slopeVerification()
		.remove()
		.undo()
		.redo()
		.validate()
		.zoomOut(4)
		
		
		;
	
	}
}
