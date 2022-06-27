package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserProfilePage;

@Test
public class VerifyCommunityContent extends Browser {

	@Test
	public void verifyCommunityContentPage() {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.goToCommunityContent()
			.verifyCommunityContentPage()
			.verifyProductSheet(2)
			.checkUserProfilePage(2)
			.openLandingPage()
			.goToCommunityContent()
			.applyFilter("Garden lounges")
			.verifyFilterApplied("Garden lounges")
			.verifyProductSheet(2)
			.checkUserProfilePage(2)
			.clickHbmLogo()
			;
	}
	
	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class,dependsOnMethods = "verifyCommunityContentPage")
	public void verifyMyContentOld(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent()
			.verifyMyContentPage()
			;
	}
		
	@Test(dependsOnMethods = "verifyMyContentOld")
	public void editOldUserProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickEditProductButton("ODTUserProduct")
			.verifyeditUserProductDialog("ODTUserProduct","Auto Description", "Wardrobes")
			.clickEditProductButton("ODTUserProduct")
			.editUserProduct("EditedUserProduct" + UtilHBM.getDate(0, "yyyyMMdd"), "Edited Description", "Armchairs")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0, "EditedUserProduct" + UtilHBM.getDate(0, "yyyyMMdd"), "Edited Description")
			.clickEditProductButton("EditedUserProduct"+UtilHBM.getDate(0,"yyyyMMdd"))
			.editUserProduct("ODTUserProduct", "Auto Description", "Wardrobes")
			.verifyProcessedProduct(0, "ODTUserProduct", "Auto Description")
			.clickHbmLogo()
			.logout();
			;
	}

}
