package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Sofa extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void sofa (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductDev("Pouf géant design polyester prune BIG MILIBAG", -150, 100)
		.verifyLogoLinkDev(-150, 100).deleteDev(-150, 100)			
		.addAProductDev("Ihina", -150, 100)
		.editGenericPropertiesDev(-150, 100, "100.0 cm", "200.0 cm", "90.0 cm", "Fabric", 0, "2323")
		.verifyGenericPropertiesDev(-150, 100, "100.0 cm", "200.0 cm", "90.0 cm", "2323");	
			
	}
}