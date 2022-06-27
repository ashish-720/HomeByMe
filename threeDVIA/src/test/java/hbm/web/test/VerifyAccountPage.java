package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class VerifyAccountPage extends Browser{

	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class)
	public void verifyAccountLaCarte(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToAccountPage()
		.setUnit("m")
		.clickProfileInfo()
		.uploadPhoto("AutoFP.jpg")
		.clickProfileInfo()
		.deletePhoto()
		.clickProfileInfo()
		.verifyPhotoDeleted()
		.clickPrivateInfo()
		.clickChangePassword()
		.verifyChangePasswordDialog()
		.clickCancelButton()
		.clickPrivateInfo()
		.verifyPrivateInfoForm(signUpData.getLoginId(), "", "", "", "India", "", "Individual")
		.editPrivateInfo("Edited Fname", "Edited Lname", "Mr", "France", "Paris", "Real estate agent")
		.verifyPrivateInfoForm(signUpData.getLoginId(), "Edited Fname", "Edited Lname", "Mr", "France", "Paris","Real estate agent")
		.clickFriendshipReward()
		.verifyFriendshipReward()	
		.clickPurchases()	
		.verifyPurchase("360", 1)
		.verifyPurchase("Additional projects", 2)
		.verifyPurchase("Realistic renderings", 1)
		.verifyPurchase("One Time Pack", 1)
		.clickCredits()
		.checkCredits("27", "0", "22", "9", "7", "no")
		;
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
	
	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void verifyAccountSrv(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToAccountPage()
		.setUnit("m")
		.clickProfileInfo()
		.uploadPhoto("AutoFP.jpg")
		.clickProfileInfo()
		.deletePhoto()
		.clickProfileInfo()
		.verifyPhotoDeleted()
		.clickPrivateInfo()
		.verifyPrivateInfoForm(signUpData.getLoginId(), "First Name", "Last Name", "Mr", "India", "Maharashtra", "Architect")
		.editPrivateInfo("Edited Fname", "Edited Lname", "Mrs", "France", "Paris", "Real estate agent")
		.verifyPrivateInfoForm(signUpData.getLoginId(), "Edited Fname", "Edited Lname", "Mrs", "France", "Paris", "Real estate agent")
		.editPrivateInfo("First Name", "Last Name", "Mr", "India", "Maharashtra", "Architect")
		.clickPrivateInfo()
		.clickChangePassword()
		.verifyChangePasswordDialog()
		.clickCancelButton()
		.clickFriendshipReward()
		.verifyFriendshipReward()
		.clickPurchases()
		.verifyPurchase("Floor plan", 4)
		.verifyPurchase("One room design", 2)
		.verifyPurchase("Multi-purpose room design", 1)
		;
		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
}