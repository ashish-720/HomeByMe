package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class PlantsnFlowers extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void plantsNFlowers (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductDev("657", -150, 0)
		.editGenericPropertiesDev(-150, 0, "250.0 cm", "200.0 cm", "150.0 cm", "Glass", 0, "1264")
		.threeDView()
		.verifyGenericPropertiesDev(-135, 90, "250.0 cm", "200.0 cm", "150.0 cm", "1264")
		.editGenericPropertiesDev(-135, 90, "2300 mm", "2200mm", "170.0 cm", "Metal", 0, "2476")
		.verifyGenericPropertiesDev(-135, 90, "230.0 cm", "220.0 cm", "170.0 cm", "2476");
	}
}
