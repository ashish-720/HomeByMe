package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.ProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SignUpFromGoogle extends Browser{
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class)
	public void signUpFromGoogle(SignUpData signUpData){

		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/reetie.y+191-1954/trial2");
		ProjectPage home = PageFactory.initElements(driver, ProjectPage.class);
		home.closeNewOfferPopin()
		.clickOpenProjectButtonOld()
		.bannerSignUp()
		.signUPFromGoogle(signUpData)
		.saveClick()
		.saveAsCopy("google sign up TrialProject")
		.emptyRoom(-250, 15)
		.verifyFloorPropertiesDev(-300, 170, "Bedroom", "Hardwood", "4307", 0)
		.verifyFloorPropertiesDev(-300, 170, "Satin paint", "4751", 0)
		.save()
		.closePlanner()
		.logout()
		;
	}
	
}
