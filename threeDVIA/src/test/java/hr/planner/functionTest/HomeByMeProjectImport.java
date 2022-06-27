package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hr.planner.pageObject.HomePlanner;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class HomeByMeProjectImport extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void bryoLogin(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.planMyRoomClick();
				
	}
	@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class)
	public void homeByMeProjectImport(SignUpData signUpData) {	
		HomePlanner home = PageFactory.initElements(driver, HomePlanner.class);	
		home
		.floorPlan()
//		.initialPlan()
		.homeByMeProject()
		.clickHBMConnectLoginButton()
		.loginExitingUser(signUpData)
		.selectProjectForBryoHR("ODT-HomeRetailer", 0)
		.verifyProjectName("ODT-HomeRetailer - HOME")
		.productNameVerify(60, 80, "furniture")
		.position()
		.clickInPlanner(80, -300)	// blank space		
		.productNameVerify(120, -93, "furniture")
		.position()
		.levelSelector("First floor")
		.moveWall(0, 90, -365, 250) // move first person 
		.productNameVerify(490, 75, "furniture")
		.position()
		.decorate()
		.catelogSubCategory("paint")
		.addProduct("Paint", "0")
		.clickOnWall(420, -90)
		.closeCatalog()
		.furnish()
		.catelogSubCategory("wardrobes")
		.addProduct("Louise wardrobe", "4")
		.closeCatalog()
		.clickInPlanner(-490, -180)
		.translateProduct(0, -40, 0, -120)		
		.clickInPlanner(-490, -180)
		.save()
		.takePicture()
		.screenshot()
		.generateScreenshot()
		.viewTwoD()
		.moveWall(-199, -128, -399, 76)
		.translateProduct(-100, -290, -145, -290)
		.save()		
		.close2()
		.myProjects()
		.openProject("ODT-HomeRetailer - Home", 0)
		.verifyProjectName("ODT-HomeRetailer - Home")
		.productNameVerify(-273, 200, "FURNITURE")
		.position()
		.productNameVerify(244, -157, "FURNITURE")
		.position()
		.productNameVerify(-4, -262, "SAAR ARMCHAIR More info")
		.editFurniture(-4, -262, "96", "85", "86")
		.closeEditPanel()
		.takePicture()
		.screenshot()
		.generateScreenshot()
		.viewTwoD()
		.zoomIn(1)
		.zoomOut(1)
		.generateScreenshot()
		.closeScreenshot()
//		.save()
//		.close2()
//		.logOut() 
		;
				
	}
	
}