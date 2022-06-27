package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.HBMFor;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;


public class MDMCreateProject extends Browser {
	
	@Test(dataProvider="hmsLoginData", dataProviderClass=SignUpData.class)
	public void hbmForLogin(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.verifyLanguagesHBMFor("HBMForLn").loginExistingUserMDM(signUpData);
	}

	@Test(dataProvider="projectData", dataProviderClass=NewProjectData.class, dependsOnMethods="hbmForLogin")
	public void hbmForCreateNewProject(NewProjectData newProjectData) {
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.createHBMForProject(newProjectData)
			.twoDView()
			.save()
			.closePlanner()
			.logoutHBM4();	
	}
	
	@Test(dataProvider="hmsLoginData", dataProviderClass=SignUpData.class,dependsOnMethods="hbmForCreateNewProject")
		public void createTrialProjectHbmFor(SignUpData signUpData) {
			HBMFor hbmfor=PageFactory.initElements(driver,HBMFor.class);
			hbmfor.createTrialProject().saveGalleryProject(signUpData,"GalleryProject")
			.twoDView()
			.addPartnerProductDev("Module W100 H41 D37 IMAGINE", -75, -50)
			.duplicateDev(-75, -50)
			.deleteDev(300, 300)
			.emptyRoom(300, 300)
			.editFloorPropertiesDev(300, 300, "Kitchen", "", "", 0)
			.edit2DWallPropertiesDev(300, 0, "9", "1", "", "")
			.addPartnerProductDev("Module W100 H41 D37 IMAGINE", 300, 250)
			.configure(300, 250)
			.save()
			.closePlanner()
//			.logoutHBM4()
			;
		}
	
	@Test(dependsOnMethods="createTrialProjectHbmFor")
	public void verifyUserProductProcessing(){
		Browser.openUrl(driver, "https://preprod-home.by.me/en/");
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.closeDiscountPopupIfAvailable()
			.goToMyProfile()
			.clickMyContent()
			.verifyProcessingProduct("Module L100 H41 P37 IMAGINE")
			.clickHbmLogo()
			.logout()
			;
	}
	
}


	
