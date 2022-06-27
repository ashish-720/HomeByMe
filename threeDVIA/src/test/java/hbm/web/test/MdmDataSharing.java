package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

public class MdmDataSharing extends Browser{

	@Test(dataProvider = "emailMDMUser", dataProviderClass = SignUpData.class)
	public void dataShareMDM(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.clickPrivateInfo()
			.disallowDataSharing()
			.logout();	
	}
}
 