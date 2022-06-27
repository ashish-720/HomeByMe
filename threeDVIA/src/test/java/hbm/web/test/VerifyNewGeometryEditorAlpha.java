package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.Upload3dModel;
import hbm.web.pageobject.UserProfilePage;

@Test
public class VerifyNewGeometryEditorAlpha extends Browser {
	
	@Test(dataProvider = "hbmProUserData", dataProviderClass = SignUpData.class)
	public void openMyContent3DEditor(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent()
			.openAlphaLink();
	}

	@Test(dependsOnMethods = "openMyContent3DEditor")
	public void verifyUnsupportedFile() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenInfoPage()
			.clickGetStarted()
			.uploadFile("notSupported.jpg")
			.verifyErrorPage()
			.cancelFromErrorPage()
			.uploadFile("notSupported.jpg")
			.uploadFileFromErrorPage("ponyCartoon-gltf.zip")
			.clickCloseButton()
			.clickCancelYes();
	}

	@Test(dependsOnMethods = "verifyUnsupportedFile")
	public void openNewFile() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenInfoPage()
			.clickGetStarted()
			.uploadFile("ponyCartoon-gltf.zip")
			.clickBackPlanToggle()
			.verifyBackPlanToggle(true)
			.openFromDisk()
			.verifyOpenFromDiskPage()
			.openNewFileConfirmNo()
			.openFromDisk()
			.uploadFileFromOpenNewPage("premierBall-glb.zip")
			.clickNextButton()
			.editPrdNameAndDesc("premierBall-glb", "premierBall-glb-Desc")
			.clickUploadButton()
			.switchToParentFrame()
			.verifyEditSuccessNotification()
			.verifyProcessingProduct("premierBall-glb")
			;
	}	

	@Test(dependsOnMethods = "openNewFile")
	public void verify3DEditorDialog() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenInfoPage()
			.verifyPage()
			.clickCancelButton()
			.clickImportYourOwn3DProductToOpenInfoPage()
			.checkDoNotShowAgain()
			.clickGetStarted()
			.verifyUpload3dModelPageDisplayed()
			.clickCloseButton()
			.verifyCancelDialog()
			.clickCancelNo()
			.clickCloseButton()
			.clickCancelYes()
			.clickImportYourOwn3DProductToOpenUpload3dModel()
			.verifyPageNoFileUploaded()
			;
	}
	
	@Test(dependsOnMethods = "verify3DEditorDialog")
	public void uploadOBJModel() {
		Upload3dModel upload3dModel = PageFactory.initElements(driver, Upload3dModel.class);
		upload3dModel.uploadFile("knight-obj.obj")
			.verifyBackPlanToggle(false)
			.clickBackPlanToggle()
			.verifyBackPlanToggle(true)
			.verifyHumanScaleToggle(false)
			.clickHumanScaleToggle()
			.verifyHumanScaleToggle(true)
			.verifyDimensions("1.44", "4.27", "6.93")
			.editDimensions("", "", "1000.00", true)
			.verifyDimensions("20.81", "61.56", "100")
			.clickNextButton()		
			.editPrdNameAndDesc("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"), "knight-obj-Desc")
			//.editPrdCategory("Free shapes")
			.clickBackButton()
			.clickNextButton()
			.verifyPrdDetails("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"), "Free shapes", "knight-obj-Desc")
			.clickUploadButton()
			;
	}
	
	@Test(dependsOnMethods = "uploadOBJModel")
	public void verifyOBJProductProcessing(){
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.switchToParentFrame()
			.verifyEditSuccessNotification()
			.verifyProcessingProduct("knight-obj-" + UtilHBM.getDate(0, "ddMMyyyy"))
			;
	}
	
	@Test(dependsOnMethods = "verifyOBJProductProcessing")
	public void uploadColladaModel() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenUpload3dModel()
			.uploadFile("gramophone-Collada.dae")
			.clickNextButton()
			.editPrdNameAndDesc("gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"), "gramophone-Collada-Desc")
			//.editPrdCategory("Free shapes")
			.clickUploadButton()
			;
	}
	
	@Test(dependsOnMethods = "uploadColladaModel")
	public void verifyColladaProductProcessing(){
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.switchToParentFrame()
			.verifyEditSuccessNotification()
			.verifyProcessingProduct("gramophone-Collada-" + UtilHBM.getDate(0, "ddMMyyyy"))
			;
	}
	
	@Test(dependsOnMethods = "verifyColladaProductProcessing")
	public void uploadGLBModel() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenUpload3dModel()
			.uploadFile("premierBall-glb.zip")
			.clickNextButton()
			.editPrdNameAndDesc("premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"), "premierBall-glb-Desc")
			//.editPrdCategory("Free shapes")
			.clickUploadButton()
			;
	}
	
	@Test(dependsOnMethods = "uploadGLBModel")
	public void verifyGLBProductProcessing(){
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.switchToParentFrame()
			.verifyEditSuccessNotification()
			.verifyProcessingProduct("premierBall-glb-" + UtilHBM.getDate(0, "ddMMyyyy"))
			;
	}
	
	@Test(dependsOnMethods = "verifyGLBProductProcessing")
	public void uploadGLTFModel() {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickImportYourOwn3DProductToOpenUpload3dModel()
			.uploadFile("ponyCartoon-gltf.zip")
			.clickNextButton()
			.editPrdNameAndDesc("ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"), "ponyCartoon-gltf-Desc")
			//.editPrdCategory("Free shapes")
			.clickUploadButton()
			;
	}
	
	@Test(dependsOnMethods = "uploadGLTFModel")
	public void verifyGLTFProductProcessing(){
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.switchToParentFrame()
			.verifyEditSuccessNotification()
			.verifyProcessingProduct("ponyCartoon-gltf-" + UtilHBM.getDate(0, "ddMMyyyy"))
			;
	}
}
