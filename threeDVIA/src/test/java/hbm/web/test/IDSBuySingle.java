package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BOValidateFP;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class IDSBuySingle extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void idsBuySingle(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openServicesTab()
			.clickDiscoverIDS()
			.buyIDSOneRoom()
			.iDSFillForm("IDS1")
			.iDSFormEditDetails("IDS2")
			.iDSPurchaseRequest()
			.makePayment("", "IDSOrder1", "IDS2", "No");
			UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
			home.logout();
	}
	
	@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods="idsBuySingle")
	public void idsDeliverSingle(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.bOValidateIDS("IDS2","IDSOrder1");
		ProjectPage projectPage=PageFactory.initElements(driver, ProjectPage.class);
		projectPage.openProject()
			.twoDView()
	//		.addAProduct("canap", "GuestRoom", 0, 0);
			.save()
			.closePlanner();
		BOValidateFP boValidateIDS=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateIDS.releaseIDSProject()		
			.uploadBookIDS("IDS2","IDSOrder1")
			.openProjectIDS();
	}
}