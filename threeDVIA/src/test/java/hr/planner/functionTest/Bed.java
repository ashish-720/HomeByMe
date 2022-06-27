package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class Bed extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void bed(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.planMyRoomClick()
		.furnish()
		.catelogSubCategory("beds")
		.filter("", "Single beds", "Blue") //verification fails plz check
		//.favIconInCatalogList("0", "Retailer Fav List", 0)
		.addProduct("Cozy single bed", "1")
		.closeCatalog()
		.clickInPlanner(86, 73)
		.duplicateProd()//check verification not working
		.deleteProd()
		.clickInPlanner(86, 73)
		.position()
		.clickInPlanner(150, 100)
		.editFurniture(86, 73, "", "150", "")
		.closeEditPanel()
		.furnish()
		.catelogSubCategory("beds")
		.addProduct("Skrooll double bed", "0")
		.closeCatalog()
		.clickInPlanner(-8, 73)
		.productInfo()
		.share()
		.facebookPS()
		.twitterPS()
		.pinterestPS()
		.embedPS()
		.mailPS()
		.copyLInk()
		//.translateProduct(86, 73, -100, -10)
		
		
		
		//.rotateTooltip(-20, 50,-150, -20) //not rotating
//		.viewTwoD()
//		.viewThreeD()
//		.translateProduct(-18, -50, -50, 0)
		
		//.elevateTooltip(16, 20)
		//.saveProjectDetail("bed", "xyz")
		;
		
	}
	//info, product sheet layer, replace
}
