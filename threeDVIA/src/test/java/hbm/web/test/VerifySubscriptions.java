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
public class VerifySubscriptions extends Browser {
	
	@Test(dataProvider = "gmailLoginData", dataProviderClass = SignUpData.class)
	public void buyMonthlySubscriptionAutoRenew(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUpNewUserWithDate(signUpData,1)
			.completeProfile("Individual", "", false)
			.goToOffers()
			.buySubscription("Monthly");
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditions()
			.makePayment("0", "", "LaCarte1", "Yes");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToAccountPage()
			.clickSubscriptions()
			.saveSubscriptionDetails(signUpData,1,"Monthly-AutoRenew")
			.verifySubscription("Pro monthly")
			.logout();	
	}
	
	@Test(dataProvider = "gmailLoginData", dataProviderClass = SignUpData.class,dependsOnMethods = "buyMonthlySubscriptionAutoRenew")
	public void buyMonthlySubscriptionUnsubscribed(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUpNewUserWithDate(signUpData,2)
			.completeProfile("Individual", "", false)
			.goToOffers()
			.buySubscription("Monthly");
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditions()
			.makePayment("0", "", "LaCarte1", "Yes");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToAccountPage()
			.clickSubscriptions()
			.saveSubscriptionDetails(signUpData,2,"Monthly-Unsubscribed")
			.verifySubscription("Pro monthly")
			.unsubscribe("Pro monthly")
			.logout();	
	}
	
	@Test(dataProvider = "gmailLoginData", dataProviderClass = SignUpData.class,dependsOnMethods = "buyMonthlySubscriptionUnsubscribed")
	public void buyMonthlySubscriptionModifiedToYearly(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUpNewUserWithDate(signUpData,3)
			.completeProfile("Individual", "", false)
			.goToAccountPage()
			.clickSubscriptions()
			.buySubscription("Monthly");
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditions()
			.makePayment("0", "", "LaCarte1", "Yes");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToAccountPage()
			.clickSubscriptions()
			.saveSubscriptionDetails(signUpData,3,"Yearly-Modified")
			.verifySubscription("Pro monthly")
			.modifySubscription("Pro monthly")
			.verifySubscription("Pro yearly-Modified")
			.logout();	
	}
	
	@Test(dataProvider = "gmailLoginData", dataProviderClass = SignUpData.class,dependsOnMethods = "buyMonthlySubscriptionModifiedToYearly")
	public void buyMonthlySubscriptionUnsubscriptionCancel(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.signUpNewUserWithDate(signUpData,4)
			.completeProfile("Individual", "", false)
			.goToInspiration()
			.openImageAtIndex(0) 
			.openProject()
			.threeDView()
			.twoDView()
			.saveClick()
			.saveAsCopy("Test")
			.closePlanner()
			.goToMyProjects()
			.openOwnProject(1)
			.duplicateOwnProject("Copy of Test")
			.duplicateOwnProject("Copy of Copy of Test")
			.duplicateOwnProject("Copy of Copy of Copy of Test")
			.duplicateOwnProject("Copy of Copy of Copy of Copy of Test")
			.clickHbmLogo()
			.buySubscriptionWhenProjectExhausted("Pro monthly");
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditions()
			.makePayment("0", "", "LaCarte2", "Yes");
		BuyAdditionalProjectsWhenExhausted1 buyAdditionalProjectsWhenExhausted1 = PageFactory.initElements(driver,
				BuyAdditionalProjectsWhenExhausted1.class);
		buyAdditionalProjectsWhenExhausted1.closeBuyAdditionalItemsDialog();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToAccountPage()
			.clickSubscriptions()
			.saveSubscriptionDetails(signUpData,4,"Monthly-CanceledUnsubscription")
			.verifySubscription("Pro monthly")
			.unsubscribe("Pro monthly")
			.cancelUnsubscribe()
			.verifySubscription("Pro monthly")
			.logout();	
	}
}
