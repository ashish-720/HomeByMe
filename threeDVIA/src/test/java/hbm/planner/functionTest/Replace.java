package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Replace extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void replace(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner
		.twoDView()
		.addAProductDev("Chifonier aura", 0, 150)
		.threeDView()
		.verifyLogoLinkDev(0, 150)
		.replaceDev(0, 150, "12794")
		.ungroup(0, 170)
		.addAProductDev("Chifonier aura", -100, 100)
		.threeDView()
		.verifyLogoLinkDev(-100, 100)
		.replaceFromCata(-100, 100, "3416")
		.editGenericPropertiesDev(0, 170, "", "", "", "Wood", 0, "2327")
		.verifyGenericPropertiesDev(0, 170, "97.8 cm", "60.0 cm", "35.0 cm", "2327")
		.addAProductDev("Sliding storage W150 H231 D60 IMAGINE", -130, -50)
		.configure(-130, -50)
		.closePlannerWithoutSave();
	}
}
