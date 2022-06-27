package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ProjectOverview extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void projectOverviewVeification (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		.myProjects()
		.searchProjectName("Roof Window")
		.openProjectPage("Roof Window", 0)
		.projectOverview()
		.verifyProjectPageName("Roof Window")
		.nextSlideIcon()
		.previousSlideIcon()
		.description("Home Retailer")
		.roomByRoom(6)
		.global()
		// add media list open it delete share
		.property()//check verification
		.shareProject()
		.facebookPrjPage()
		.twitterPrjPage()
		.pinterestPrjPage()
		.embedPrjPage()
		.mailPrjPage()
		.copyLInkPrjPage()
		.verifyProjectPageName("Roof Window")
		
		
		
		// Open Print in Project Page Project Overview
//		.printProject()
//		.itemList()
//		.medias()
//		.selectAll()
//		.selectAll()
//		//.print("(2)")
//		.printClose()  
		
		//.viewAll()//keep this at last
		
		;
	
	}
}