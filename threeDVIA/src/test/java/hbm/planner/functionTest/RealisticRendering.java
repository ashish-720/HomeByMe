package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.CreateData;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class RealisticRendering extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void realisticImage(SignUpData signUpData){
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject()
		.edit3DWallPropertiesDev(-100, -150, "Satin paint", 4, "10330", 0)
		.twoDView()
		.addAProductDev("TWINEA", -150, -295)		
		.addAProductDev("4929", 150, 0)
		.addAProductDev("1501", -150, -200)
		.editDoorWinPropertiesDev(150, 0, "1500 mm" , "200 cm", "50", 1, 1)		
		.verifyDoorWinPropertiesDev(150, 0, "150.0 cm", "200.0 cm", "50.0 cm")
		.editTwoDWallDimensionDev(0, -100, "295 cm", "200", "below")
		
//		.threeDView()
//		.addAProductDev("9424", 100, 100) //people
		.twoDView()
		.editDoorWinPropertiesDev(-150, -295, "215", "200", "", 0, 0)
		.verifyDoorWinPropertiesDev(-150, -295, "215.0 cm", "200.0 cm", "0.0 cm")
		.deleteDev(-150, -295)
		.threeDView()
		.addAProductSearchDev("lustre_32_light_RT_HQ", -100, -100)
		
//		.lightsOff(-100, -100)
		.lightsOn(-100, -100)
		.lightsOff(-100, -100)
	
//		.addAProductSearchDev("FU625500_light_RT_HQ", -50, -40)
		.addAProductDev("FU625500_light_RT_HQ", -50, -40)
		.addAProductDev("12534", -100, 50)
		.lightsOn(-50, -40)
		.realisticImageClick()
		.getStarted()
		.artifitialLight(true, "")
		.setBackground(2, true)
		.displayPeople(true)
		.lensOption(true, 1)
		.cameraHeight(0, 10)
		.setSunPosition(30, 10, 20, 50)
		.nightMode(true)
		.clickGenerateButton()
		.sendHQImageRequest("small")
		.closeHQMessage()
		.realisticImageClick()
		.realisticImageMulti("large", 5, false, false, 2)
		//.realisticImageMultiRequest("large", 5, false, 2)
		.snapshot3D("3D", 2)
		.firstPersonView()
		.snapshot()
//		.snapshot3D("First Person View", 0)
		;
		
	}	
}
