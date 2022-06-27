package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class GeometricEditor extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void geometryEditor(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		Browser.openUrl(driver, "https://preprod-home.by.me/en/?alpha");
		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);		
		planner.clickMyContent()
		
		.clickImportYourOwn3DProductToOpenInfoPage()
		.verifyPage()
		.clickCancelButtonPlanner()
		.clickImportYourOwn3DProductToOpenInfoPage()
		.checkDoNotShowAgain()
		.clickGetStartedPlanner()
		.clickCloseButton()
		.verifyCancelDialog()
		.clickCancelNo()
		.clickCloseButton()
		.clickCancelYesPlanner()
		.clickImportYourOwn3DProductToOpenUpload3dModel()
		.uploadFile("fireplace_glb.glb")
		.clickNextButton()
		.clickUploadButtonPlanner()
		.verifyEditSuccessNotification()
		.verifyProcessingProduct("fireplace_glb")
		
		.clickImportYourOwn3DProductToOpenUpload3dModel()
		.uploadFile("Cole_Armchair_Maisons_Du_Monde_OBJ.obj")
		.editDimensions("", "", "100", true)
		.verifyDimensions("208.7", "116.5", "100")
		.clickNextButton()
		.editPrdNameAndDesc("Cole_Armchair_Maisons_Du_Monde_OBJ", "Cole_Armchair_Maisons_Du_Monde_OBJ Product")
		.clickUploadButtonPlanner()
		.verifyEditSuccessNotification()
		
		
//		.verifyProcessingProduct("Cole_Armchair_Maisons_Du_Monde_OBJ.OBJ");
//		.clickMyContent()
//		.clickImportYourOwn3DProductToOpenInfoPage()
//		.verifyPage()
//		.clickCancelButtonPlanner()
//		.clickImportYourOwn3DProductToOpenInfoPage()
//		.checkDoNotShowAgain()
//		.clickGetStartedPlanner()
//		.clickCloseButton()
//		.verifyCancelDialog()
//		.clickCancelNo()
//		.clickCloseButton()
//		.clickCancelYesPlanner()
//		.clickUploadButtonPlanner()
		
		
		
		
		
		;				
	}

}
