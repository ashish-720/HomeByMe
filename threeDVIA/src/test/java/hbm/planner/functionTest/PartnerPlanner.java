package hbm.planner.functionTest;


import hbm.planner.utility.Browser;
import hbm.web.pageobject.HBMFor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PartnerPlanner extends Browser {
	
	@Test
	public void partnerPlannerTest(){
	
		
		HBMFor mdm = PageFactory.initElements(driver, HBMFor.class);
		mdm.seeThisProject()
		.twoDView()
		.addPartnerProductDev("Module W100 H41 D37 IMAGINE", -75, -50)
		.duplicateDev(-75, -50)
		//.replaceDev(-100, -50, "Module W50 H41 D60 IMAGINE")
		.deleteDev(300, 300)
		.emptyRoom(300, 300)
		.editFloorPropertiesDev(300, 300, "Kitchen", "", "", 0)
		.edit2DWallPropertiesDev(300, 0, "9", "1", "", "")
		.addPartnerProductDev("Module W100 H41 D37 IMAGINE", 300, 250)
		
		;		
	}

}
