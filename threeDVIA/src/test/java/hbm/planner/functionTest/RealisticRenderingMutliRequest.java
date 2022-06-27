package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class RealisticRenderingMutliRequest extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void realisticImageLarge(SignUpData signUpData){
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
	}
	
	@Parameters("browser")
	public void realisticImageLarge(@Optional("chrome")String browser){			
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.fpRotateDev(20, "right").fpRotateDev(20, "down")
		.realisticImageClick()
		.realisticImageMulti("large", 2, true, false, 10)
		.realisticImageClick()
		.realisticImageMulti("small", 2, true, false, 10)
		.realisticImageClick()
		.realisticImageMulti("large", 3, false, false, 5)
		.realisticImageClick()
		.realisticImageMulti("large", 3, true, false, 5)
		.realisticImageClick()
		.realisticImageMulti("large", 4, false, false, 5)
		.realisticImageClick()
		.realisticImageMulti("large", 4, true, true, 5)
		.realisticImageClick()
		.realisticImageMulti("small", 5, false, true, 5)
		.realisticImageClick()
		.realisticImageMulti("small", 5, true, true, 5);
	}	
}
