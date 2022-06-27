package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

public class verifyMails extends Browser{
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void idsDeliverMulti(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToBackOffice()
		.clickMails()
		.clickLogs()
		.filterMails()
		.validateMails("3DPLM", "360 Render ready", 3);
	}
}
