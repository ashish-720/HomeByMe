package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutToAnyOperationRuleCase2 extends Browser {
	@Test
	public void cutToAnyOperationRuleCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD80", true, false, false)
		
		.position(-112, -6, "50 mm", "100 mm", "")
		.editFaucetOptionsProperty(-112, -6, "", "20 mm", "", "Back")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-67, -188, "Rectangle", "200 mm", "200 mm", "", "", "")
		.editCutOutDimension(-70, -192, "1288 mm", "1000 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between cut-outs and any other operation")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-outs and any other operation");
		
		
		
	}

}
