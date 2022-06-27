package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopOverHang extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void worktopOverHangTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.position(-115, -11, "3137 mm", "2500 mm", "")
		.verifyPosition(-53, -5, "2500 mm")
		.editWorktopOverHangOptions(-53, -5, "250 mm", "")
		.saveProjectInStep3(signUpData, "ODT_Overhang_Test", "Worktop overhang test")
		.verifyWorktopOptionsProperty(-10, 27, "250 mm", "30 mm", "", "")
//		.verifyPriceInformation("848,00")
		.clickSave(signUpData).verifySavedProjectDetails("ODT_Overhang_Test")
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_Overhang_Test")
		.openProject(0, "ODT_Overhang_Test")
//		.openProject()
//		.verifyPrice("848,00")
		.verifyWorktopOptionsProperty(-10, 27, "250 mm", "30 mm", "", "");
		
	
	}
}
