package hbm.web.test;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BuyAdditionalProjectsWhenExhausted1;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.LoginGmail;
import hbm.web.pageobject.ServiceConditions;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HbmNewUser extends Browser{	

	@Test(dataProvider = "newUserSignUpData", dataProviderClass = SignUpData.class)
	public void createNewUser(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", "", false)
			.checkLoginStatus("3dviaqapune")
			.closeDiscountPopupIfAvailable();
	}
	
	@Test(dataProvider = "projectData", dataProviderClass= NewProjectData.class, dependsOnMethods="createNewUser")
	public void verifyCreditsOfNewUser(NewProjectData newProjectData){
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);		
		userHomePage.goToAccountPage()
			.VerifyUserProfile("Individual")
			.clickFriendshipReward()
			.verifyFriendshipReward()
			.clickInviteFriendsButton()
			.verifySponsorshipDialog()
			.closeSponsorshipDialogMyAccount()
			.checkCredits("5", "0", "3", "9", "0", "no")
			.goToUserHomePage()
			.verifyUserHomePage(0);
	}	
	
	@Test(dataProvider = "projectData", dataProviderClass= NewProjectData.class, dependsOnMethods="verifyCreditsOfNewUser")
	public void newUserProject(NewProjectData newProjectData){
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);		
		userHomePage.createNewProject(newProjectData)
			.threeDView()
			.save()
			.closePlanner()
			.verifyUserHomePage(1)
			.logout();
	}	
	
	@Test(dependsOnMethods = "newUserProject",dataProvider="newUserSignUpData", dataProviderClass= SignUpData.class)
	public void verifyFirstProject(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.login()
			.login(signUpData)
			/*
			.connectWithFb()
			.loginNewMethod(signUpData)
			.loginNewMethodMsg();
			LoginGmail activateNewMethod = PageFactory.initElements(driver, LoginGmail.class);
			activateNewMethod.newConnectionMethodActivation(signUpData)
			.connectWithFbWithCache()
			*/
			.editFirstProject()
			.threeDView()
			.verifyProjectDetails("INL_AUTO_TEST_PROJECT", "House", "New construction", 1, 1, 20)
			.closePlanner()
			.logout()
			.loginExistingUser(signUpData);
	}	
	/*
	@Test(dependsOnMethods={"facebookLoginTest"})
	public void logoutFB(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}
	
	
	@Test(dataProvider="newUserSignUpData", dataProviderClass= SignUpData.class, dependsOnMethods="verifyFirstProject")
	public void gmailLoginTest(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginGmailUser(signUpData);		
	}	
	*/
	
	@Test(dataProvider="projectData", dataProviderClass=NewProjectData.class, dependsOnMethods="verifyFirstProject")
	public void secondProject(NewProjectData projectData){
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.createEmptyProject(projectData)
			.closePlanner()
			.verifyUserHomePage(2);
	}
	/*
	@Test(dependsOnMethods={"secondProject"})
	public void logoutGmail(){
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.logout();
	}
	
	@Test(dataProvider="newUserSignUpData", dataProviderClass=SignUpData.class, dependsOnMethods="secondProject")
	public void loginUsingEmail(SignUpData signUpData){
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.loginExistingUser(signUpData);
	}
	*/

	@Test(dependsOnMethods="secondProject", dataProvider="projectData", dataProviderClass=NewProjectData.class)
	public void createProjectFromScratch(NewProjectData newProjectData){
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.createProjectFromScratch(newProjectData, "wallFromScratch")
			.save()
			.threeDView()
			.closePlanner()
			.verifyUserHomePage(3);
	}
	
	@Test(dependsOnMethods="createProjectFromScratch")
	public void duplicateNewUserProjectMyProjects() {
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToMyProjects()
			.openOwnProject(2, "INL_AUTO_TEST_PROJECT")
			.duplicateOwnProject("Copy of INL_AUTO_TEST_PROJECT")
			.verifyOverviewTabPage("OWN", 1, 1, "20 m\u00B2", 0, 0, 0, 0)
			.verifyRoomsTab("Guest room-20 m²")
			.clickHbmLogo();
	}
	
	@Test(dependsOnMethods="duplicateNewUserProjectMyProjects")
	public void duplicateNewUserProjectUserHomePage() {
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.duplicateProject("INL_AUTO_TEST_PROJECT")
			.clickHbmLogo()
			.verifyUserHomePage(5)
			.buyAdditionalProjectsWhenExhausted(2);
		ServiceConditions condition = PageFactory.initElements(driver, ServiceConditions.class);
		condition.acceptServiceConditionsAndCloseTab();
		UserHomePage home2 = PageFactory.initElements(driver, UserHomePage.class);
		home2.buyAdditionalProjectsWhenExhausted(2)
			.makePayment("1", "", "LaCarte", "Yes");
		BuyAdditionalProjectsWhenExhausted1 buyAdditionalProjectsWhenExhausted1 = PageFactory.initElements(driver,
				BuyAdditionalProjectsWhenExhausted1.class);
		buyAdditionalProjectsWhenExhausted1.closeBuyAdditionalItemsDialog();
		UserHomePage home3 = PageFactory.initElements(driver, UserHomePage.class);
		home3.goToAccountPage()
			.checkCredits("2", "0", "3", "9", "0", "no");
	}
}
