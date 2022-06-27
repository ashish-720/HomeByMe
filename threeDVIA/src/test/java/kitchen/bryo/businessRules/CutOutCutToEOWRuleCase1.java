package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutOutCutToEOWRuleCase1 extends Browser {
	@Test
	public void cutOutCutToEOWRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-67, -188, "Rectangle", "200 mm", "200 mm", "", "", "")
		.editCutOutDimension(-70, -192, "181 mm", "49 mm")
		.checkWorktopEditorBusinessRules("Distance between cut-out and back of worktop")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Distance between cut-out and back of worktop");
		
		
		
	}

}
