package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ScreenshotTest extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void screenshot(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner
		.twoDView()
		.addAProductDev("4927", -295, -50).verifyLogoLinkDev(-295,  -50)
		.threeDView()
		.edit3DWallPropertiesDev(-300, 200, "Satin paint", 11, "10705", 1)
		.snapshot3D("3D", 1)
		.twoDView().deleteDev(-295, -50).threeDView()
		.snapshot3D("3D", 2).snapshot3D("3D", 3)
		.verify3DWallPropertiesDev(-250, 0, "Satin paint", 11, "10705", 1)
		.myImages()
		.shareMediaFrmPreview(1, "snapshot", 2)
		.deleteMedia(1, "snapshot", 2, false)
		.deleteMedia(1, "snapshot", 2, true)
		.closeMyImages()
		.twoDView()
		.addAProductDev("Base cabinet 3 drawers l100", -230, -260)
		.duplicateDev(-260, -230)
		.addAProductDev("Wall cabinet 2 lockers l100", -150, -275)
		.addAProductDev("Wall cabinet design l100", 150, 20)
		.addAProductDev("Cubic fauteuil tissu ou PU", -100, 100)
		.threeDView()
		.zoomOut(4)
		.snapshot3D("3D Screenshot : Setting 1", 0)
		.snapshot3D("3D Screenshot : Setting 2", 1)
		.snapshot3D("3D Screenshot : Setting 3", 2)
		.snapshot3D("3D Screenshot : Setting 4", 3)
		.snapshot3D("3D Screenshot : Setting 5", 4)
		.twoDView()
		.snapshot2D("On Floor with room name & no area", "on floor", true, false, "", true, false, false, false)
		.snapshot2D("NoFurnsh & Mtl dim medium name & area", "none", false, true, "medium", true, true, false, false)
		.threeDView()
		.emptyRoom(-100, 0)
		.verifyFloorPropertiesDev(-160, -50, "Guest room", "Hardwood", "4296", 0)
		.verify3DWallPropertiesDev(125, 15, "Satin paint", 1, "4751", 0)
		.snapshot3D("After Empty Room", 0);		
	}
}
