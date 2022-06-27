package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopPositionOutsideRoomRule extends Browser {
	@Test
	public void worktopPositionOutsideRoomRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.editWorktopDimension(-178, -152, "880 mm", "1100 mm", "apply left")
		.checkWorktopEditorBusinessRules("Worktop position")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Worktop position")
		.editWorktopDimension(-178, -152, "880 mm", "920 mm", "apply left")
		.checkWorktopEditorBusinessRules("Worktop position")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Worktop position")
		.cancelWorktopEditor()
		.clickFloorplan()
		.addWall("bryoRoomAddWall")
		.step3()
		.twoDView()
		.position(-144, -264, "1276 mm", "0 mm", "")
		.preciseRotation(-154, -143, "180°", "1227 mm")
		.worktopEditor(-154, -143)
		.editWorktopYes()
		.editWorktopDimension(-133, -26, "635 mm", "850 mm", "apply below")
		.checkWorktopEditorBusinessRules("Worktop position")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Worktop position");
	}

}
