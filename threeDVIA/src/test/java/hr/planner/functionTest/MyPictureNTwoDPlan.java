package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class MyPictureNTwoDPlan extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void myPictureNTwoDPlan (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProjectPage("HR-ODT", 0)
		.verifyProjectPageName("HR-ODT")
		.myPicture("5")
		.image360Generated(1) //count 360 image
		.realistic(1) //count realistic image
		.screenshot(4) //count screenshot image
		//Open print from My Picture in Project Page
		.printInMyPicture()
		.itemList()
		.medias()
		.selectAll()
		.selectAll()
		.printClose() 
		.myPicture("5")
		.shareRealisticImage()//Do same for .share360() and screenshot
		.facebook()
		.twitter()
		.pinterest()
		.embed()
		.mail()
		.copyLInk()// check this somethign wrong I need image here not project page
		.projectOverview()
		.verifyProjectPageName("HR-ODT")		
		;
	
	}
}
