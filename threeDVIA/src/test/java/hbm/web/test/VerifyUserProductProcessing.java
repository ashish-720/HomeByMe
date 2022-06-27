package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyUserProductProcessing extends Browser {


	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void verifyUserProductProcessing(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent()
			.verifyProcessingProduct("Module L100 H41 P37 IMAGINE")
			.clickHbmLogo()
			.logout()
			;
	}
}
