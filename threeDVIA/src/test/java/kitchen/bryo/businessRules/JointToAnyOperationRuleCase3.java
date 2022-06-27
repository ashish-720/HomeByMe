package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class JointToAnyOperationRuleCase3 extends Browser {
	@Test
	public void jointToAnyOperationRuleCase3(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.duplicateProduct(-112, -6)
		.replaceProperty(-54, -2, "Cooktop", "JEAN BAPTISTE", "",true, "")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.addJoint(-130, -150)
		.zoomIn(3)
		.editCutOutDimension(-139, -253, "1140 mm", "800 mm")
		.checkWorktopEditorBusinessRules("Distance between a sink or hob and adjacent joint.")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Distance between a sink or hob and adjacent joint.")
		.validateWorktopEditor()
		.deleteProduct(-10, 30)
		.deleteProduct(45, 35)
		.addProduct("SPUD80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(45, 35)
		.editWorktopYes()
		.zoomIn(3)
		.editCutOutDimension(-245, -245, "2177 mm", "1500 mm")
		.checkWorktopEditorBusinessRules("Distance between a sink or hob and adjacent joint.")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Distance between a sink or hob and adjacent joint.");
		
	}

}
