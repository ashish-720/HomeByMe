package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.OurOffers;
import hbm.web.pageobject.UserHomePage;

@Test
public class BuyHMS extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void buyHMS(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		driver.get("https://preprod-home.by.me/en/home-measurement-service");
		OurOffers ourOffersAlpha=PageFactory.initElements(driver, OurOffers.class);
		ourOffersAlpha.buyMeasuringServiceNew("HMS1")
		.buyHMSForm("HMS1").hmsSelectAppointment("HMS1")		
		.hmsVerifyDetails("HMS1").hmsEditMyRequest("HMS2").hmsVerifyDetails("HMS2").hmsPurchase()
		.makePayment("", "HMSOrder1", "HMS2", "No");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}
	@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods="buyHMS")
	public void hmsValidateNew(SignUpData signUpData)  {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToBackOffice()
		.bONewHMS("HMS2","HMSOrder1");	
	}
}
