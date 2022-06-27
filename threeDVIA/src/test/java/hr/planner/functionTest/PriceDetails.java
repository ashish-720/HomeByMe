package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class PriceDetails extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceDetailVeification (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProjectPage("HR-ODT", 0)
		.verifyProjectPageName("HR-ODT")
		.priceDetails("28")
		.items(10) //items count ( here paint is consider as 1)
		.gridView()
		.listView()
		
		//Open Print in Price Details in Project page
		.printInPriceDetails()
		.itemList()
		.medias()
		.selectAll()
		.selectAll()
		//.print("(2)")
		.printClose()
		;
	
	}
}
