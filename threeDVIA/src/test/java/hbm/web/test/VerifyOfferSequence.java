package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyOfferSequence extends Browser {

	@Test(dataProvider = "emailLogin", dataProviderClass = SignUpData.class)
	public void verifyAccountLaCarte(SignUpData signUpData) {
//		Functionality is not applicable for new our offers page		
//		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
//		homepage.loginExistingUser(signUpData)
//			.goToAccountPage()
//			.clickPrivateInfo()
//			.verifyOfferSequence();
	}
}
