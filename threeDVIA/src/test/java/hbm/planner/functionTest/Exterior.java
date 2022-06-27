package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class Exterior extends Browser{
	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void exterior (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().exteriorDev(0,150, 1, "100.0")
		.exteriorDev(260, -170, 3, "25.0")
		.threeDView()		
		.addAProductFromInfoDev("8157", 335, 20)
		.snapshot3D("3D", 1);		
	}

}
