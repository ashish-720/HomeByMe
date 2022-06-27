package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class CommunityContent extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void communityContent(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.twoDView()
		.addAProductDev("Module W100 H41 D37 IMAGINE", -175, 50)
		.configure(-175, 50)
		.addAProductFromCommunityContentDev("Table","table", "672", -200, 150)
		.myContent(60, 6, 0, 150, "Module L100 H41 P37 IMAGINE")
		.clickInfoBubble(-200, 175)
		.verifyCommunityContentProductSheet("8E465FF3-5C71-4C88-A4D7-124E21F2A94E/Thumbnails", "Pallavi" , "table", "P")
		.clickInPlanner(-200, 175)
		.clickDuplicateBubble()
		.deleteDev(-78, 122);
		
		/*
		 * need to add verification of processing product for configured product
		 */
	}
}