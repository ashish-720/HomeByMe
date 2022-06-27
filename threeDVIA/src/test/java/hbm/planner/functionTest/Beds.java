package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Beds extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void beds(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.twoDView().addAProductDev("IKAA lit",-150, 0)
		.verifyLogoLinkDev(-150, 0).deleteDev(-150, 0)
		.addAProductDev("Round bed", -150, -200)
		.editGenericPropertiesDev(-150, -200, "500 mm", "230.0 cm", "250.0 cm", "Matt paint", 7, "1326")
		.verifyGenericPropertiesDev(-150, -200, "50.0 cm", "230.0 cm", "250.0 cm", "1326");				
	}
}
