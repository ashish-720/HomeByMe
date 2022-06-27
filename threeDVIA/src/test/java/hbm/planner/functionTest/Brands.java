package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Brands extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void brands (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.twoDView().addAProductFromBrandsDev("Table basse design réglable rouge avec rangement LOLA", -150, -100)
		.verifyLogoLinkDev(-150, -100).deleteDev(-150, -100)
		.addAProductFromBrandsDev("Bibliothèque Séverin", -150, -100)
		.verifyLogoLinkDev(-150, -100);		
	}
}
