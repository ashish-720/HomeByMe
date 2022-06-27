package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserProfilePage;

@Test
public class VerifyProcessedUserProduct extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void verifyMyContentNew(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent()
			.verifyMyContentPage()
			.verifyProcessedProduct(0,"Module L100 H41 P37 IMAGINE","\"1B68410 / Module L100 H41 P37 IMAGINE / chene_structure / 197\"")
			.goToMyProfile()
			.clickMyContent()
			;
	}
	
	@Test(dependsOnMethods = "verifyMyContentNew")
	public void editUserProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage
			.clickEditProductButton("Module L100 H41 P37 IMAGINE")
			.verifyeditUserProductDialog("Module L100 H41 P37 IMAGINE","\"1B68410 / Module L100 H41 P37 IMAGINE / chene_structure / 197\"",	"Choose a category")
			.clickEditProductButton("Module L100 H41 P37 IMAGINE")
			.editUserProduct("ODTPrd"+ UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description", "Wardrobes")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0,"ODTPrd"+ UtilHBM.getDate(0, "ddMMyyyy"),"Edited Description")
			;
	}
	
	@Test(dependsOnMethods = "editUserProduct")
	public void deleteUserProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("ODTPrd"+ UtilHBM.getDate(0, "ddMMyyyy"))
			.clickHbmLogo()
			.logout();
	}
}
