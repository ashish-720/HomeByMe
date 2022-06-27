package hbm.web.mobileTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Mobile;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;


@Test
public class VerifyProjectPage extends Mobile {
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void verifyProjectPage(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.verifyPlayStoreBanner()
				.closePlayStoreBanner()
				.clickHeaderMenuMobile()
				.clickLogin()
				.loginMobile(signUpData)
				.closePlayStoreBanner()
				.clickHeaderMenuMobile()
				.clickMyProjects()
				.openOwnProjectMobile(0, "Duplicate")
				.verifyProjectName("Duplicate")
//				.verifyOverviewTabMobile("OWN",1, 3, "39 m\u00B2", 0, 1, 2, 19, false)
//				.verifyProductsTabMobile(3)
//				.verifyMediaPageMobile("OWN",5,15,1)
				;
//		 
//			MyProjects myProjects=PageFactory.initElements(driver, MyProjects.class);
//			myProjects.clickHeaderMenuMobile()
//				.clickInspiration()
				
		
//  Verify project page of other user opened from link
			driver.get("https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
			ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
			projectPage.verifyProjectName("ski23_jun17_CR")
		;
	}
	
}
