package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutToAnyOperationRuleCase1 extends Browser {
	@Test
	public void cutToAnyOperationRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCornerCutOut(-123, -152, "", "Single", "200 mm", "200 mm", "", "", "", "", "", "", "")
		.zoomIn(3)
		.addEdgeCut(-170, -270, "Triple", "150 mm", "150 mm", "120 mm", "", "", "", "")
		.checkWorktopEditorBusinessRules("Minimum distance between cut and cut.")
		.editWorktopDimension(-186, -226, "283 mm", "250 mm", "apply above")
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut and cut.");
		
	}

}
