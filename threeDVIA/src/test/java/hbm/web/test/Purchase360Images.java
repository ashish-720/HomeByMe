package hbm.web.test;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class Purchase360Images extends Browser{

	@Test(dataProvider = "emailLogin", dataProviderClass=SignUpData.class)
	public void purchase360Images(SignUpData signUpData) throws IOException{		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openPacksTab()
			.purchase360Image("2")
			.makePayment("2", "", "LaCarte1", "No");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}	
}