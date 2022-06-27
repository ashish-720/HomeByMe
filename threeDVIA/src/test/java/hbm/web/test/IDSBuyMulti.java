package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class IDSBuyMulti extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void idsBuyMulti(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openServicesTab()
			.clickDiscoverIDS()
			.buyIDSMultiRoom()
			.iDSFillForm("IDS4")
			.iDSPurchaseRequest()
			.makePayment("", "IDSOrder2", "IDS4", "No");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}
	@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods="idsBuyMulti")
	public void needMoreInfoIDS(SignUpData signUpData)  {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.dates()
			.needMoreInfoIDS("IDS4","IDSOrder2")
			.logout();	
	}
}
