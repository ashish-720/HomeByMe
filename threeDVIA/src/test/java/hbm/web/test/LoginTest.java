package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LoginTest extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void loginTest(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
//		Assert.assertEquals(UtilHBM.webElement(driver, "body>main>section>div>div>h1").getText().split(" ")[1].split("!")[0].toLowerCase(), signUpData.getLoginId());		
	}
	
	@Test(dependsOnMethods={"loginTest"})
	public void logoutTest(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}
	
	@Test(dependsOnMethods={"logoutTest"}, dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void loginFrmSignUpExistingUser(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUpExistingUser(signUpData);
	}
	
	@Test(dependsOnMethods={"loginFrmSignUpExistingUser"})
	public void logoutSignUpExistingUserTest(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}	

	@Test( dataProvider="loginData", dataProviderClass=SignUpData.class,dependsOnMethods="logoutSignUpExistingUserTest")
	public void signUpExistingUserTest(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUp()
				.enterExistingUserEmail(signUpData)
				.enterPassword(signUpData.getPassword())
				.clickLOGINButton()
				.checkLoginStatus("3DPLM")
				;
	}
	
	@Test(dependsOnMethods={"signUpExistingUserTest"})
	public void logoutFrmSignUpExistingUser(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}
	
	/*
	@Test(dependsOnMethods = {"logoutFB"}, dataProvider="gmailLoginData", dataProviderClass= SignUpData.class)
	public void gmailLoginTest(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginGmailUser(signUpData);		
	}	
	
	@Test(dependsOnMethods={"gmailLoginTest"})
	public void logoutGmail(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}
	*/
}
