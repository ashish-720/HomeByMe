package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;

@Test
public class Verify3DcloudProducts extends Browser {
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void verify3DcloudProducts(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.editLatestProject()
			.twoDView()
			.addAProductDev("TWINEA", -150, -295)
			.threeDView()
			.addAProductSearchDev("Chair_cont_" + UtilHBM.getDate(0, "dd_MM_yyyy"), -170, 50)
			.verifyGenericPropertiesDev(-170, 10, "110.0 cm", "55.0 cm", "80.0 cm", "3172")
			.clickObjTillPropertiesAppearDev(-170, 10);
		ThreeDPlanner threeDPlanner = PageFactory.initElements(driver, ThreeDPlanner.class);
		threeDPlanner.editButton()
			.editGenericPropertiesByMaterialId("100.0 cm", "60.0 cm", "85.0 cm", "5245");
		threeDPlanner.clickBlankTillPropertiesDisappearDev();
		threeDPlanner.verifyGenericPropertiesDev(-170, 10, "100.0 cm", "60.0 cm", "85.0 cm", "5245")
			.addAProductSearchDev("Lamp_cont_" + UtilHBM.getDate(0, "dd_MM_yyyy"), -71, 50)
			.verifyGenericPropertiesDev(-71, 20, "110.0 cm", "75.0 cm", "55.0 cm", "3172")
			.clickObjTillPropertiesAppearDev(-71, 20);
		threeDPlanner.editButton()
			.editGenericPropertiesByMaterialId("100.0 cm", "60.0 cm", "60.0 cm", "5245");
		threeDPlanner.clickBlankTillPropertiesDisappearDev();
		threeDPlanner.verifyGenericPropertiesDev(-71, 20, "100.0 cm", "60.0 cm", "60.0 cm", "5245")
			.addAProductSearchDev("Carpet_cont_" + UtilHBM.getDate(0, "dd_MM_yyyy"), -260, 56)
			.addAProductSearchDev("Carpet_admin_" + UtilHBM.getDate(0, "dd_MM_yyyy"), 134, -13)
			.fpRotateDev(10, "down")
			.fpRotateDev(10, "left")
			.realisticImageClick()
			.getStarted().lensOption(true, 1)
			.cameraHeight(0, 10)
			.setSunPosition(30, 10, 20, 50)
			.clickGenerateButton()
			.sendHQImageRequest("large")
			.closeHQMessage();	
	}
}
