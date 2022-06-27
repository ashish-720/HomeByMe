package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.HBMFor;

public class MdmSignUp extends Browser {

	@Test(dataProvider = "newMDMUserSignUpData", dataProviderClass = SignUpData.class)
	public void signUpAndAcceptDataOfferHBM4(SignUpData signUpData) {
		HBMFor hBMFor = PageFactory.initElements(driver, HBMFor.class);
		hBMFor.signUpMDM(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfileMDM()
			.acceptDataSharingHBM4()
			.logoutHBM4();
	}

}