package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BOValidateFP;
import hbm.web.pageobject.IDSFormVerifyDetails;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class IDSDeliverMulti extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void replyNeedMoreIDS(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToAccountPage()
		.editPurchase("Multi-purpose room");
		IDSFormVerifyDetails iDSFormVerifyDetails=PageFactory.initElements(driver, IDSFormVerifyDetails.class);
		iDSFormVerifyDetails.iDSFormEditDetails("IDS5")
		.iDSPurchaseRequest();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
	
	@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods="replyNeedMoreIDS")
	public void idsDeliverMulti(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData).goToBackOffice().bOValidateIDS("IDS5","IDSOrder2");
		ProjectPage projectPage=PageFactory.initElements(driver, ProjectPage.class);
		projectPage.openProject().twoDView()
//		.addAProduct("canap", "GuestRoom", 0, 0);
		.save()
		.closePlanner();
		BOValidateFP boValidateIDS=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateIDS.releaseIDSProject()
		.uploadBookIDS("IDS5","IDSOrder2")
		.openProjectIDS();
	}

}