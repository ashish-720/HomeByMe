package hbm.web.test;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class VerifyServiceProjects extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyServiceProjects(SignUpData signUpData){	
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);			
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.goToMyProjects().verifyMyProjects("FP", 1).verifyMyProjects("IDS", 1);
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
}
