package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class JointOverApplianceRule extends Browser {
	@Test
	public void jointOverApplianceRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.duplicateProduct(-112, -6)
		.replaceProperty(-54, -2, "Cooktop", "JEAN BAPTISTE", "", true,"")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.addJoint(-35, -154)
		.zoomIn(3)
		.editCutOutDimension(-139, -253, "1140 mm", "950 mm")
		.checkWorktopEditorBusinessRules("Joint over appliance rule")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Joint over appliance rule");
	}

}
