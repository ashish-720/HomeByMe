package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.ProjectPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SignUpFromBanner extends Browser{
	
	@Test(dataProvider="newUserSignUpData", dataProviderClass=SignUpData.class)
	public void signUpFromBanner(SignUpData signUpData){

		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/reetie.y+191-1954/trial2");
		ProjectPage home = PageFactory.initElements(driver, ProjectPage.class);
		home.closeNewOfferPopin()
		.clickOpenProjectButtonOld()
		.bannerSignUp()
		.signUPFromTrialProject(signUpData)
		.saveClick()
		.saveAsCopy("SignUpFromBanner")
		.closePlanner()
		.logout()
		.loginExistingUser(signUpData)
		.goToMyProjects()
		.openOwnProject(0, "SignUpFromBanner")
		.verifyOverviewTabPage("own", 1, 4, "96", 1, 1, 16, 0)
		.openProject()
		.emptyRoom(-250, 15)
		.verifyFloorPropertiesDev(-300, 170, "Bedroom", "Hardwood", "4307", 0)
		.verifyFloorPropertiesDev(-300, 170, "Satin paint", "4751", 0)
		.save().closePlannerReturnProjectPage()
		.verifyOverviewTabPage("own", 1, 4, "96", 1, 1, 11, 0)
		.verifyRoomsTab("Kitchen-9 m²,Bedroom-23 m²,Bathroom-11 m²,Living room-50 m² ")
		.verifyImagesTab("own", 0, 0, 0, false)
		;
	}

}
