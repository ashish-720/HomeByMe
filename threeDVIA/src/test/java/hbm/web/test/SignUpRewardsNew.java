package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.LoginGmail;
import hbm.web.pageobject.SignUp;

public class SignUpRewardsNew extends Browser {
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class)
	public void createSameUserAccountToSponsor(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.completeProfile("Individual", "", false)
			.checkLoginStatus("3dviaqapune")	
			.goToAccountPage()
			.clickFriendshipReward()
			.clickInviteFriendsButton()
			.updateFriendshipCode()
			.sendSponsorshipCode("shubhamkhisti14496+1251@gmail.com")
			.checkCredits("5", "0", "3", "9", "0", "no")
			.logout();
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="createSameUserAccountToSponsor")
	public void openSignUpFromSponsorMailNew(SignUpData signUpData){
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.openSignUpFromSponsorMail(signUpData);
	}

	@Test(dataProvider = "rewardData1", dataProviderClass = SignUpData.class,dependsOnMethods = "openSignUpFromSponsorMailNew")
	public void signUpWithSponsorCodeNew1(SignUpData signUpData) {
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData)
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), true)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
	
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class,dependsOnMethods = "signUpWithSponsorCodeNew1")
	public void checkSposorshipRewardsNew1(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "13", "9", "0", "no")
			.logout();
	}
	
	@Test(dataProvider = "rewardData2", dataProviderClass = SignUpData.class, dependsOnMethods = "checkSposorshipRewardsNew1")
	public void signUpWithSponsorCodeNew2(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), false)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}

	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class, dependsOnMethods = "signUpWithSponsorCodeNew2")
	public void checkSposorshipRewardsNew2(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "23", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
}
