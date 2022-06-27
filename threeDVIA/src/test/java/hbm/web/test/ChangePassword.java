package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.Login;

@Test
public class ChangePassword extends Browser{

	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class)
	public void changePassword(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.clickPrivateInfo()
			.clickChangePassword()
			.enterPasswords(signUpData.getPassword(), signUpData.getPassword()+"1")
			.saveChangePassword()
			.logout()
			;
	}
	
	@Test(dataProvider="newUserSignUpData", dataProviderClass=SignUpData.class, dependsOnMethods="changePassword")
	public void loginWithInvalidPwd(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginInvalidUser(signUpData);
	}	
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class, dependsOnMethods="loginWithInvalidPwd")
	public void LoginWithChangedPwd(SignUpData signUpData){		
		Login login = PageFactory.initElements(driver, Login.class);
		login.clearLoginFormFields()
			.enterLoginId(signUpData.getLoginId())
			.enterPassword(signUpData.getPassword()+"1")
			.clickLOGINButton()
			.goToAccountPage()
			.clickPrivateInfo()
			.clickChangePassword()
			.enterPasswords(signUpData.getPassword()+"1", signUpData.getPassword())
			.saveChangePassword()
			.logout()
			;
	}
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class, dependsOnMethods="LoginWithChangedPwd")
	public void LoginWithOriginalPwd(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.verifyPageTitle()
			.logout();
		
	}
}
