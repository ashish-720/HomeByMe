package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Panoramic360Test extends Browser{
	
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void panoramic360(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject()
//		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
//		String browser = cap.getBrowserName().toLowerCase();
//		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
//		planner
		.twoDView()
		.addAProductDev("TWINEA", -150, -295)		
		.addAProductDev("4929", 150, 0)
		.editTwoDWallDimensionDev(0, -100, "295 cm", "200", "below")
		.edit2DWallPropertiesDev(100, 300, "", "", "200", "100")
		.addAProductDev("Rooftop Window", 0, 280)
		.editDoorWinPropertiesDev(0, 250, "80", "70", "", 0, 0)
		.verifyDoorWinPropertiesDev(0, 250, "80.0 cm", "70.0 cm", "")
//		.panoramic360(2, 30, 10, 20, 50);
		.panoramic360(2);
	}
}
