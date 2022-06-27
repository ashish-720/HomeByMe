package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class LaunchPlanner extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void launchPlanner(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		//object of that class
	
		home.login(signUpData)
		.myProjects()
		.newProject();
		
		
		//openProject("902817E5-A8C7-4B26-A5BE-CEAFECEB6E72", "Safari ipad 16 July");
		
//		.planMyRoomClick().furnish().catelogSubCategory("Beds")
//		.filter("", "Single beds", "Blue")
//		.addProduct("Cozy single bed", "1")
//		.search("sofa").addProductNoSpace("Sofa", "0");
//		
		
	}
	
}
