package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class Tables extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void tables (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductDev("Table", 0, 100)
		.editGenericPropertiesDev(0, 100, "100.0 cm", "150.0 cm", "150.0 cm", "Wood", 0, "1231")
		.verifyGenericPropertiesDev(0, 100, "100. cm", "150. cm", "150. cm", "1231");		
	}
}