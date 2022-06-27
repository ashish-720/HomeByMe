package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyFavorites;
import hbm.web.pageobject.UserHomePage;

public class SignUpFromTryNow extends Browser {

	@Test(dataProvider = "newUserSignUpData", dataProviderClass = SignUpData.class)
	public void signUpFromTryNow(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickTryNow()
			.createNewUser(signUpData)
			.verifyCompleteProfileDialog()
			.completeProfile("Individual", "", false)
			.checkLoginStatus("3dviaqapune")
			;
	}
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class,dependsOnMethods = "signUpFromTryNow")
	public void verifyCreditsOfNewUserFrmTryNow(SignUpData signUpData){
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.goToAccountPage()
			.VerifyUserProfile("Individual")
			.checkCredits("5", "0", "3", "9", "0", "no")
			.clickSubscriptions()
//			.verifySubscription("")
			.goToUserHomePage()
			.verifyUserHomePage(0)
			.goToMyCollections()
			.verifyNoCollectionsAvailable()
			.logout();
	}	
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class,dependsOnMethods = "verifyCreditsOfNewUserFrmTryNow")
	public void loginFromSignUp(SignUpData signUpData){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickTryNow()
			.loginFromSignUp(signUpData)
			.checkLoginStatus("3dviaqapune");
	}	
	
	@Test(dependsOnMethods = "loginFromSignUp")
	public void addPrdToAutoGeneratedCollectionAndDelete() {
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);	
		userHomePage.goToInspiration()
			.addItemInCollectionFrmImgPage(false, false, "My first collection", 0, 1, "Product")
			.goToMyCollections()
			.verifyFirstCollectionName("My first collection")
			.verifyCollection("My first collection", 0, 1)
			.openCollection(0)
			.openProductsTab(1)
			.clickCollectionActions()
			.clickEditCollection()
			.deleteFavListItem("Product",0)
			.verifyCollectionContents(0, 0)
			.goToMyCollections()
			.verifyFirstCollectionName("My first collection")
			.openCollection(0,"My first collection")
			.editCollectionNameFromActions("Edited first collection")
			.deleteCollection("Edited first collection", 0);
	}
			
	@Test(dependsOnMethods = "addPrdToAutoGeneratedCollectionAndDelete")
	public void addImgToAutoGeneratedCollection() {	
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);	
		userHomePage.goToInspiration()
			.addItemInCollectionFromFeed(false, false, "My first collection", 1, 0, "Image")
			.goToInspiration()
			.addItemInCollectionFromFeed(false, true, "My first collection", 1, 0, "Image")
			.logout()
			;
		}
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class,dependsOnMethods = "addImgToAutoGeneratedCollection")
	public void deleteMultipleItemsFrmAutoGeneratedCollection(SignUpData signUpData) {	
			LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
			homepage.loginExistingUser(signUpData)
			.goToMyCollections()
			.verifyCollection("My first collection", 1, 0)
			.goToInspiration()
			.addItemInCollectionFrmImgPage(false, false, "My first collection", 1, 1, "Product")
			.goToMyCollections()
			.verifyFirstCollectionName("My first collection")
			.openCollection(0,"My first collection")
			.editCollectionNameFromTitle("Edited first collection")
			.goToMyCollections()
			.openCollection(0)
			.verifyCollectionTitle("Edited first collection")
			.clickCollectionActions()
			.clickEditCollection()
			.clickSelectAll()
			.verifyEditCollectionHeader(2)
			.clickDeleteItem()
			.clickConfirmDeleteItem()
			.verifyCollectionContents(0, 0)
			.goToMyCollections()
			.openCollection(0,"Edited first collection")
			.deleteCollection("Edited first collection", 0)
			.verifyNoCollectionsAvailable();
	}	
}