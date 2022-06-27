package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class FreeShape extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void freeShape(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();		
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductDev("2125", 100, 100)
		.editGenericPropertiesDev(100, 100, "2000 mm", "75", "120", "Stones", 0, "2329")
		.verifyGenericPropertiesDev(100, 100, "200.0 cm", "75.0 cm", "120.0 cm", "2329");		
	}
}
