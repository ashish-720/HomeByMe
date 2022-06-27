package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class RemoveJoint extends Browser {
	@Test
	public void removeJointTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-115, -11)
		.editWorktopYes()
		.changeGrainDirection(-181, -182)
		.createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
		.verifyWorktopCutOut(-182, -187, "200 mm", "200 mm", "", "", "347 mm", "218 mm")
		.changeGrainDirection(-144, -176)
		.validateWorktopEditor()
		.worktopEditor(6, 15)
		.verifyPriceInWorktop("100,00")
		.deleteCutOrCutOuts(-182, -187)
		.verifyDeletedCutOut(-182, -187)
		.addJoint(-185, -159)
		.zoomIn(4)
		.verifyJoint(-270,-270,"440 mm")
		.removeJoint(-270,-270)
		.verifyPriceInWorktop("100,00")
		.addSplitEdge(-266, -240)
		.editWorktopDimension(-311, -239, "440 mm", "540 mm", "apply left")
		.verifyWorktopDimension(-311, -239, "540 mm")
		.checkWorktopEditorBusinessRules("Worktop position")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Worktop position");
	
	}
}
