package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyProjects;
import hbm.web.pageobject.UserHomePage;


@Test
public class ShareEmbededProject extends Browser{
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
		public void shareEmbededProject(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.verifyProjectName("Duplicate")
			.shareEmbededProject()
			.verifyOverviewTabPage("OWN",1, 3, "39 m\u00B2", 0, 1,2,40)
			.verifyRoomsTab("Guest room-30 m²,Kitchen-5 m²,Bathroom-2 m²")
			.verifyProductsTab(2, "2")
			.verifyImagesTab("OWN",4,36,1,false)
			;
		
		
//		.goToGallery()
//		.filterProjects("Views")
//		.openOthersProject("sar4_12 march 2019")
//		.verifyProjectName("sar4_12 march 2019")
//		.shareEmbededProject()
//		.verifyOverviewTabPage("others", 2, 12, "129 m\u00B2", 2, 1, 12, 19, false)
//		.verifyProductsTab(12, "No")
//		.verifyImagesTab("others",9,7,3,false);
	}
}