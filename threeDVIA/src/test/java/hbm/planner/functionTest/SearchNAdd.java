package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class SearchNAdd extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void searchNAdd(SignUpData signUpData){
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.twoDView().addAProductSearchDev("Table basse ronde Séverin", 0, 150)
		.verifyLogoLinkDev(0, 150);		
	}

}
