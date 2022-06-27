package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;



import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class IncludeAccessories extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void includeAccessories (SignUpData signUpData){
		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject()
		.addAProductDev("Ensemble lit double & chevet", -180, 100)
		.editFloorPropertiesDev(210, 120,"Kitchen", "Hardwood", "4306", 0)
		.ungroup(-180, 0)
		.includeAccessories(-180, 40)
		.dragNDrop(-180, 40, -180, 145)
		.includeAccessories(-65, 136)
		.clickDuplicateBubble()
		.dragNDrop(46, 165, 0, 100)
		.clickDuplicateBubble()
		.includeAccessories(202, 115)
		.clickDeleteBubble()
		.verifyFloorPropertiesDev(210, 120,"Kitchen", "Hardwood", "4306", 0)
		.twoDView()
		.addAProductDev("Ensemble commode", -200, -200)
		.ungroup(-200, -200)
		.includeAccessories(-200, -185)
		.dragNDrop(-200, -200, -200, -150)
		.includeAccessories(-218, -134)
		.clickDuplicateBubble()
		.includeAccessories(-100, -134)
		.clickDeleteBubble()
		.verifyFloorPropertiesDev(-100, -150,"Kitchen", "Hardwood", "4306", 0)
		.addAProductDev("Ensemble commode", -120, -200)
		.ungroup(-120, -185)
		.dragNDrop(-120, -185, -120, -250)
		.includeAccessoriesNotificationClick()
		.includeAccessories(-147, -260)
		.clickInPlanner(-125, -275)
		.verifyFloorPropertiesDev(-120, -200,"Kitchen", "Hardwood", "4306", 0)
//		.includeAccessories(20, 50)
		//.rotateProd(xPoint1, yPoint1, xPoint2, yPoint2)
		//rotation
		
		;
	}
	
}