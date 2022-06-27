package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BuyAdditionalProjectsWhenExhausted1;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ServiceConditions;
import hbm.web.pageobject.UserHomePage;

@Test
public class BuyAdditionalProjectsWhenExhausted extends Browser {

	@Test(dataProvider = "emailLogin", dataProviderClass = SignUpData.class)
	public void buyAdditionalProjectsWhenExhausted(SignUpData signUpData) {

		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);

		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.buyAdditionalProjectsWhenExhausted(2);
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditionsAndCloseTab();
		UserHomePage home2 = PageFactory.initElements(driver, UserHomePage.class);
		home2.buyAdditionalProjectsWhenExhausted(2).makePayment("1", "", "LaCarte", "Yes");
		BuyAdditionalProjectsWhenExhausted1 buyAdditionalProjectsWhenExhausted1 = PageFactory.initElements(driver,
				BuyAdditionalProjectsWhenExhausted1.class);
		buyAdditionalProjectsWhenExhausted1.closeBuyAdditionalItemsDialog();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}
}
