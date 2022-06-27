package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.UserHomePage;
import hbm.web.pageobject.LandingPage;

@Test
public class RejectIDSRequest extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void idsBuyToBeRejected(SignUpData signUpData) {
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
	
	@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods="idsBuyToBeRejected")
	public void rejectIDSRequest(SignUpData signUpData)  {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.dates()
			.rejectIDS("IDS4", "IDSOrder2")
			.logout();
	}
}
