package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EditCabinet extends Browser {
	@Test
	public void editCabinetTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.productList("BOM.txt","803,00")
		.clickFloorplan()
		.step3()
		.productList("BOM.txt","803,00")
		.clickFloorplan()
		.roomShape("Closed", 1)
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("W6002", true, false, false)
		.position(-120,-95, "3337 mm", "3350 mm", "")
		.checkBusinessRuleShowIn3D("Item position", true)
		.position(-120,-95, "3350 mm", "3337 mm", "")
		.verifyBusinessRuleRemoved("Item position")
//		.replaceProperty(-154,-222, "Box", "PARIS", "", "1 104,00")
//		.verifyReplaceProperty(-154,-222,"Box", "PARIS")
		.deleteProperty(-120,-95, "Damper")
		.verifyDeleteProperty(-120,-95, "Damper")
		.addDirectProperty(-120,-95, "Damper", "", "")
		.verifyAddProperty(-120,-95,"Damper", "Damper")
		.addDirectProperty(-120,-95, "Spot Light", "", "")
		.verifyAddProperty(-120,-95, "Spot Light","LMOON")
		.addProperty(-120,-95, "Worktop Light", "BIARRITZ|18106", "", true)
		.verifyAddProperty(-120,-95, "Worktop Light","BIARRITZ|18106")
		.deleteProperty(-126,-50, "Suspension Rail")
		.verifyDeleteProperty(-126,-50, "Suspension Rail")
		.addProduct("U2DA80", true, false, false)
		.verifyDeleteProperty(-70,-50, "Suspension Rail")
		.deleteProduct(-42,-39)
		.addDirectProperty(-126,-50, "Suspension Rail", "", "")
		.verifyAddProperty(-126,-50, "Suspension Rail", "Suspension rail")
		.replaceProperty(-126,-50, "Front", "CONCORDE", "all",true, "")
		.verifyReplaceProperty(-126,-50,"Front", "CONCORDE")
		.displayFront()
		.deleteProperty(-126,-50, "Right Cover Panel")
		.displayFront()
		.verifyDeleteProperty(-126,-50, "Right Cover Panel")
		.addDirectProperty(-126,-50, "Drawer Light", "", "")
		.verifyAddProperty(-126,-50, "Drawer Light", "BIARRITZ")
		.replaceProperty(-126,-50, "Plinth", "OPERA", "", true,"")
		.verifyReplaceProperty(-126,-50, "Plinth","OPERA")
		.editWorktopOverHangOptions(-126,-50, "", "250 mm")
		.verifyWorktopOptionsProperty(-126,-50, "", "250 mm", "", "")
		.addDirectProperty(-126,-50, "GLASS SIDES", "", "")
		.verifyAddProperty(-126,-50, "GLASS SIDES","VERSAILLES")
		.addDirectProperty(-120,-95, "Top Light", "", "")
		.verifyAddProperty(-120,-95, "Top Light","CHARLOTTE");
	

	}
}
