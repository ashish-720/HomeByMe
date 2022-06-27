package hbm.planner.scenarioTest;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ImperialUnitTest extends Browser{
	
	@Test(dataProvider = "imperialLoginData", dataProviderClass=SignUpData.class)
	public void imperialSetUnit(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToAccountPage()
		.setUnit("ft");				
	}
	
	@Test(dataProvider="imperialProjectData", dataProviderClass=NewProjectData.class, dependsOnMethods="imperialSetUnit")
	public void imperialPlannerTest(NewProjectData newProjectData){
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.clickProjects().createNewProject(newProjectData)
		.editTwoDWallDimensionDev(100, -348, "11' 1 3/16\"", "20'", "right")
		.edit2DWallPropertiesDev(100, -348, "4 15/16\"", "9'5\"", "", "")
		.verify2DWallPropertiesDev(100, -348, "4 15/16\"", "9' 5\"", "20'", 0, "", "")
		.editTwoDWallDimensionDev(-172, 60, "22' 5 13/16\"", "20'", "above")
		.verify2DWallPropertiesDev(-172, 60, "3 15/16\"", "8' 2 7/16\"", "20'", 1, "", "")
		.addAProductFromBrandsDev("CLOUD Séjour TV 220cm Blanc-Gris", 120, -245)
		.addAProductDev("Serta Trinidad Deluxe Sofa in Chocolate Fabric", 130, 160)
		.addAProductDev("LES EXCLUSIVES - ONDE", -175, 130)
		.verifyDoorWinPropertiesDev(-175, 130, "7' 5/8\"", "2' 11 7/16\"", "0'")
		.threeDView()
		.addAProductDev("1486", 120, 100)
		.edit3DWallPropertiesDev(230, -100, "Satin paint", 11, "10702", 0)
		.measureEditDev(344, -75, 160, -75, "7' 5\"")		
		.editGenericPropertiesDev(110, 95, "1'", "5 '2\"", "2' 3 9/16\"", "Plastic", 0, "2252")
		.verifyGenericPropertiesDev(110, 95, "1'", "5' 2\"", "2' 3 9/16\"", "2252")
		.save()
		.snapshot3D("3D", 0)
		.realisticImageClick()
		.getStarted()
		.setBackground(1, true)
		.setSunPosition(10, 40, 20, 50)
//		.displayPeople(false)
		.lensOption(true, 2)
		.clickGenerateButton()
		.sendHQImageRequest("large")
		.closeHQMessage()
		//.realisticImage("small", false)
		.panoramic360(2)
		.closePlanner()
		.goToAccountPage()
		.setUnit("m");		
	}
}
