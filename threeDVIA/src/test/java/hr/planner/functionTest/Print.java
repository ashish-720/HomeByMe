package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Print extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceDetailVeification (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		
		//Open Print in planner
		
		.myProjects()
		.searchProjectName("Duplicate-HR")
		.openProject("Duplicate-HR", 0)
		.printInPlanner() //failing here date 10 dec
		//not working
		.itemList()
		.medias()
		.selectAll()
		.selectAll()
		//.print("(2)")
		.printClose()
		;
	
	}
}
