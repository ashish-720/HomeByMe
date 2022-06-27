package hbm.planner.scenarioTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;

import hbm.web.pageobject.ProjectPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TrialProject extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void trialProjectTest(SignUpData signUpData){
		
		
		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/reetie.y+191-1954/trial2");
		ProjectPage home = PageFactory.initElements(driver, ProjectPage.class);
		home.closeNewOfferPopin()
		.clickOpenProjectButtonOld()
		.verifyBanner()
		.editGenericPropertiesDev(30, 240, "70", "200", "100", "Fabric", 0, "2325")
		.verifyGenericPropertiesDev(30, 240, "70.0 cm", "200.0 cm", "100.0 cm", "2325")
		.deleteDev(0, -210).deleteDev(-70, -210)
		.edit3DWallPropertiesDev(0, -210, "Satin paint", 6, "10077", 0)
		.edit3DWallPropertiesDev(0, -210, "Satin paint", 9, "9964", 0)
		.verify3DWallPropertiesDev(0, -210, "Satin paint", 9, "9964", 0)
		.addAProductFromBrandsDev("Méga Pouf Acidulé ROUGE", -340, 15)
		.verifyLogoLinkDev(-340, 15)
		.saveGalleryProject(signUpData,"GalleryProject")
		.closePlanner()
		.goToMyProjects()
		.openOwnProject(0, "GalleryProject")
		.verifyOverviewTabPage("own", 1, 4, "96", 1, 1, 15, 0)
		.openProject()
		.emptyRoom(-250, 15)
		.verifyFloorPropertiesDev(-300, 170, "Bedroom", "Hardwood", "4307", 0)
		.save().closePlannerReturnProjectPage()
		.verifyOverviewTabPage("own", 1, 4, "96", 1, 1, 9, 0)
		.openProject()		
		.verifyFloorPropertiesDev(-300, 170, "Bedroom", "Hardwood", "4307", 0)
		.deleteRoom(270, -20)
		.verifyProjectDetails("GalleryProject", "Apartment", "Dreamed project", 1, 3, 86.17)
		.verify3DWallPropertiesDev(0, -210, "Satin paint", 9, "9964", 0)
		.save().closePlannerReturnProjectPage()
		.verifyOverviewTabPage("own", 1, 3, "86", 1, 1, 7, 0)
		;
	}

}
