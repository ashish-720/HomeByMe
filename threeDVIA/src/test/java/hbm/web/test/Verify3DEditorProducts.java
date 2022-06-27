package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserProfilePage;

@Test
public class Verify3DEditorProducts extends Browser {

	@Test(dataProvider = "hbmProUserData", dataProviderClass = SignUpData.class)
	public void verifyGLTFProduct(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent()
			.verifyProcessedProduct(0,"ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"), "ponyCartoon-gltf-Desc");
	}

	@Test(dependsOnMethods = "verifyGLTFProduct")
	public void editGLTFProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickEditProductButton("ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyeditUserProductDialog("ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"), "ponyCartoon-gltf-Desc", "Free shapes")
			.clickEditProductButton("ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.editUserProduct("ODTGLTFPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description", "Wardrobes")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0, "ODTGLTFPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description");
	}

	@Test(dependsOnMethods = "editGLTFProduct")
	public void deleteGLTFProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("ODTGLTFPrd" + UtilHBM.getDate(0, "ddMMyyyy"));
	}

	@Test(dependsOnMethods = "deleteGLTFProduct")
	public void verifyGLBProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.verifyProcessedProduct(0, "premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"),"premierBall-glb-Desc");
	}

	@Test(dependsOnMethods = "verifyGLBProduct")
	public void editGLBProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickEditProductButton("premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyeditUserProductDialog("premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"),"premierBall-glb-Desc", "Free shapes")
			.clickEditProductButton("premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.editUserProduct("ODTGLBPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description", "Wardrobes")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0, "ODTGLBPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description");
	}

	@Test(dependsOnMethods = "editGLBProduct")
	public void deleteGLBProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("ODTGLBPrd" + UtilHBM.getDate(0, "ddMMyyyy"));
	}

	@Test(dependsOnMethods = "deleteGLBProduct")
	public void verifyColladaProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.verifyProcessedProduct(0, "gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"),"gramophone-Collada-Desc");
	}

	@Test(dependsOnMethods = "verifyColladaProduct")
	public void editColladaProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickEditProductButton("gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyeditUserProductDialog("gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"),"gramophone-Collada-Desc", "Free shapes")
			.clickEditProductButton("gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.editUserProduct("ODTColladaPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description", "Wardrobes")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0, "ODTColladaPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description");
	}

	@Test(dependsOnMethods = "editColladaProduct")
	public void deleteColladaProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("ODTColladaPrd" + UtilHBM.getDate(0, "ddMMyyyy"));
	}

	@Test(dependsOnMethods = "deleteColladaProduct")
	public void verifyOBJProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.verifyProcessedProduct(0, "knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"), "knight-obj-Desc");
	}

	@Test(dependsOnMethods = "verifyOBJProduct")
	public void editOBJProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickEditProductButton("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyeditUserProductDialog("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"), "knight-obj-Desc", "Free shapes")
			.clickEditProductButton("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.editUserProduct("ODTOBJPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description", "Wardrobes")
			.verifyEditSuccessNotification()
			.verifyProcessedProduct(0, "ODTOBJPrd" + UtilHBM.getDate(0, "ddMMyyyy"), "Edited Description");
	}

	@Test(dependsOnMethods = "editOBJProduct")
	public void deleteOBJProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("ODTOBJPrd" + UtilHBM.getDate(0, "ddMMyyyy"));
	}

	@Test(dependsOnMethods = "deleteOBJProduct")
	public void deleteExtraProduct() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.deleteProduct("premierBall-glb")
			.clickHbmLogo()
			.logout();
	}
}
