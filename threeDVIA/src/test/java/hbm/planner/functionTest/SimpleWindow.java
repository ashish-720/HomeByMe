package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class SimpleWindow extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void simpleWindowTest(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver,	LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductOtherModelFromInfoDev("8530", 2, 295, 150)
		.editDoorWinPropertiesDev(295, 150, "200", "150", "10", 0, 1)
		.verifyDoorWinPropertiesDev(295, 150, "200.0 cm", "150.0 cm", "10.0 cm")
		.addAProductDev("8404", -295, 150)
		.editDoorWinPropertiesDev(-295, 150, "150", "150", "50", 1, 0)
		.verifyDoorWinPropertiesDev(-295, 150,  "150.0 cm", "150.0 cm", "50.0 cm");						
	}
}