package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;

import hbm.web.pageobject.HMSSelectAppointment;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyAccount;
import hbm.web.pageobject.UserHomePage;

@Test
public class HMSChangeAppointment extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void hMSChangeAppointment(SignUpData signUpData)  {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData).goToAccountPage().editPurchase("Home Measurement");
		HMSSelectAppointment buyHMSSelectAppointment=PageFactory.initElements(driver, HMSSelectAppointment.class);
		buyHMSSelectAppointment.hmsEditAppointment("HMS1",3);
		MyAccount myAccount=PageFactory.initElements(driver, MyAccount.class);
		myAccount.checkUpdateAppointmentSuccess();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}	
	
}
