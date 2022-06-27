package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.IDSFormVerifyDetails;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class IDSReplyNeedMore extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void replyNeedMoreIDS(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToAccountPage()
		.editPurchase("Multi-purpose room");
		IDSFormVerifyDetails iDSFormVerifyDetails=PageFactory.initElements(driver, IDSFormVerifyDetails.class);
		iDSFormVerifyDetails.iDSFormEditDetails("IDS6").iDSPurchaseRequest();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
}
