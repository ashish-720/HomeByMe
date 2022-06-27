package hbm.planner.tabletTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TrialProjectTablet extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void trialProjectTablet(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.trialProject().verifyBanner()
		.editGenericPropertiesDev(30, 240, "70", "200", "100", "Fabric", 0, "2325")
		.verifyGenericPropertiesDev(30, 240, "70.0 cm", "200.0 cm", "100.0 cm", "2325")
		.deleteDev(0, -210).deleteDev(-70, -210)
		.edit3DWallPropertiesDev(0, -210, "Satin paint", 6, "10077", 0)
		.edit3DWallPropertiesDev(0, -210, "Satin paint", 9, "9964", 0)
		.verify3DWallPropertiesDev(0, -210, "Satin paint", 9, "9964", 0)
		.addAProductFromBrandsMobile("Méga Pouf Acidulé ROUGE", -340, 15)
		.movePrdMobile(-20, 70, -340, 15)
		.verifyLogoLinkDev(-340, 15)
//		.saveGalleryProject(signUpData)
		.closePlanner();
	}

}
