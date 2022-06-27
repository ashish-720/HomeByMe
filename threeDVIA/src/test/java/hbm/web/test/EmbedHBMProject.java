package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.EmbedHBMProjectSite;
import hbm.web.pageobject.UserHomePage;

@Test
public class EmbedHBMProject extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void verifyEmbedProjectWebsite(SignUpData signUpData) {
		EmbedHBMProjectSite embedProjectSite = PageFactory.initElements(driver, EmbedHBMProjectSite.class);
		embedProjectSite
			.verifyEmbedProject("prod1")
			.verifyViewThisProject("Bala's maison")
			.switchToParentIframe()
			.verifyEmbedProject("preprod1")
			.verifyViewThisProject("Sar4_12 march 2019")
			.switchToParentIframe()
			.verifyEmbedProject("preprod2")
			.verifyOpenProject()
//			.verifyProjectDetails("samm's house", "House", "New construction", 2, 10, 152)
			.verifyProjectName("SAMM'S HOUSE")
			.edit3DWallPropertiesDev(100, -190, "Satin paint", 11, "10712", 1)
			.saveGalleryProject(signUpData, "Partner embedded Project")
			.closePlanner()
			.openFirstTab();
			Browser.openUrl(driver, "https://preprod-home.by.me/en/");
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.goToMyProjects()
			.openOwnProject(0, "Partner embedded Project")
			.verifyOverviewTabPage("Own", 2, 10, "152 m\u00B2", 1, 1, 11, 0)	
			.verifyRoomsTab("Hallway-42 m²,Kitchen-8 m²,Bathroom-2 m²,Bedroom-10 m²,Guest room-13 m²,room 1-42 m²,room 2-10 m²,room 3-13 m²,room 4-8 m²,room 5-2 m²")
			.verifyProductsTab(11, "10,1")
			.verifyImagesTab("Own",0,0,0,false)
			.logout()
			;	
	}

}
