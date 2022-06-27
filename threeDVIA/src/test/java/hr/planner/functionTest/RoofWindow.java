package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class RoofWindow extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void roofWindow (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.myProjects()
		.searchProjectName("Roof Window")
		.openProject("Roof Window", 0)
		.build()
		.catelogSubCategory("roof_windows")
		.addProduct("ROOF WINDOW", "0")
		.closeCatalog()
		.addRoofWindow()// sloped Ceiling layer is open
		.viewTwoD()
		.viewThreeD()
		.zoomIn(1)
		.zoomOut(1)
		.clickInPlanner(-300, -100)
		.create()
		.clickInPlanner(250, -130)
		.create()
		.viewTwoD()
		.zoomIn(2)
		.clickInPlanner(-21, -121)
		.clickInPlanner(200, -80)
		.undo()
		.redo()
		.validate()//check title verification
		.zoomOut(3)
		.build()
		.catelogSubCategory("roof_windows")
		.addProduct("ROOF WINDOW", "0")
		.closeCatalog()
		
		
		;
	}
	
}
