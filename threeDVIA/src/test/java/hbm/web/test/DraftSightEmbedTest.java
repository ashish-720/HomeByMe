package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.DraftSightEmbed;

public class DraftSightEmbedTest extends Browser{

	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void exstingUserTest(SignUpData signUpData){
		DraftSightEmbed home = PageFactory.initElements(driver, DraftSightEmbed.class);
		home.clickHBMConnectLoginButton()
			.loginExitingUser(signUpData)
			.verifyPage()
			.logout()
			.verifyLogout()
			.clickHBMConnectLoginButton()
			.checkForgotPwdPage();
	}
	
}
