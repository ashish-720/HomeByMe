package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.LoginGmail;
import hbm.web.pageobject.SignUp;

public class SignUpRewards extends Browser {
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class)
	public void createNewUserForSponsor(SignUpData signUpData) {
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
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="createNewUserForSponsor")
	public void openSignUpFromSponsorMail1(SignUpData signUpData){
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.openSignUpFromSponsorMail(signUpData);
	}

	@Test(dataProvider = "rewardData1", dataProviderClass = SignUpData.class,dependsOnMethods = "openSignUpFromSponsorMail1")
	public void signUpUsingSponsorCode1(SignUpData signUpData) {
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData)
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), true)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class,dependsOnMethods = "signUpUsingSponsorCode1")
	public void checkSposorshipRewards1(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "13", "9", "0", "no")
			.clickFriendshipReward()
			.clickInviteFriendsButton()
			.updateFriendshipCode()
			.sendSponsorshipCode("shubhamkhisti14496+1252@gmail.com")
			.logout();
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="checkSposorshipRewards1")
	public void openSignUpFromSponsorMail2(SignUpData signUpData){
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.openSignUpFromSponsorMail(signUpData);
	}

	@Test(dataProvider = "rewardData2", dataProviderClass = SignUpData.class,dependsOnMethods = "openSignUpFromSponsorMail2")
	public void signUpUsingSponsorCode2(SignUpData signUpData) {
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData)
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), true)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class,dependsOnMethods = "signUpUsingSponsorCode2")
	public void checkSposorshipRewards2(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "23", "9", "0", "no")
			.clickFriendshipReward()
			.clickInviteFriendsButton()
			.updateFriendshipCode()
			.sendSponsorshipCode("shubhamkhisti14496+1253@gmail.com")
			.logout();
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="checkSposorshipRewards2")
	public void openSignUpFromSponsorMail3(SignUpData signUpData){
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.openSignUpFromSponsorMail(signUpData);
	}

	@Test(dataProvider = "rewardData3", dataProviderClass = SignUpData.class,dependsOnMethods = "openSignUpFromSponsorMail3")
	public void signUpUsingSponsorCode3(SignUpData signUpData) {
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData)
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), true)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
	
	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class,dependsOnMethods = "signUpUsingSponsorCode3")
	public void checkSposorshipRewards3(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "33", "9", "0", "no")
			.logout();
	}
	
    
	@Test(dataProvider = "rewardData4", dataProviderClass = SignUpData.class, dependsOnMethods = "checkSposorshipRewards3")
	public void signUpWithSponsorCode4(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), false)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}

	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class, dependsOnMethods = "signUpWithSponsorCode4")
	public void checkSposorshipRewards4(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "43", "9", "0", "no")
			.logout();
	}

	@Test(dataProvider = "rewardData5", dataProviderClass = SignUpData.class, dependsOnMethods = "checkSposorshipRewards4")
	public void signUpWithSponsorCode5(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), false)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}

	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class, dependsOnMethods = "signUpWithSponsorCode5")
	public void checkSposorshipRewards5(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "53", "9", "0", "no")
			.logout();
	}

	@Test(dataProvider = "rewardData6", dataProviderClass = SignUpData.class, dependsOnMethods = "checkSposorshipRewards5")
	public void signUpWithSponsorCode6(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", UtilHBM.getProperty("testData", "rewardCode"), false)
			.goToAccountPage()
			.checkCredits("5", "0", "6", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}

	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class, dependsOnMethods = "signUpWithSponsorCode6"
			)
	public void checkSposorshipRewards6(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "63", "9", "0", "no")
			.clickFriendshipReward()
			.clickInviteFriendsButton()
			.updateFriendshipCode()
			.sendSponsorshipCode("shubhamkhisti14496+1257@gmail.com")
			.logout();
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="checkSposorshipRewards6")
	public void openSignUpFromSponsorMail7(SignUpData signUpData){
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.openSignUpFromSponsorMail(signUpData);
	}

	@Test(dataProvider = "rewardData7", dataProviderClass = SignUpData.class, dependsOnMethods = "openSignUpFromSponsorMail7")
	public void signUpWithUsedSponsorCode7(SignUpData signUpData) {
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.verifySponsorshipCode()
			.clickServiceConditionsLabel()
			.clickNewsletterLabel()
			.clickContinueInvalidSponsorCode()
			.verifySponsorAlert()
			.clearSponsorCode()
			.selectUsageType("Professional")
			.selectProfile("Student")
			.clickContinue()
			.goToAccountPage()
			.checkCredits("5", "0", "3", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}

	@Test(dataProvider = "newHBMUserSignUpData", dataProviderClass = SignUpData.class, dependsOnMethods = "signUpWithUsedSponsorCode7")
	public void checkSposorshipRewards7(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToAccountPage()
			.checkCredits("5", "0", "63", "9", "0", "no")
			.clickPrivateInfo()
			.deleteAccount(signUpData, "hbm");
	}
	
}