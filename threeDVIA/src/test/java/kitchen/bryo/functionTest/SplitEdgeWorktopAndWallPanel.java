package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class SplitEdgeWorktopAndWallPanel extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void brSplitEdgeWorktopAndWallPanel(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE", "",true, "", "")
		.worktopEditor(-115, -11)
		.editWorktopYes()    
		.addSplitEdge(-165, -143)
		.checkWorktopEditorBusinessRules("Multiple edges")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Multiple edges")
		.validateWorktopEditor()
		.twoDView().threeDView()
		.addProperty(-8, 12, "Wall Panel", "DK_WP_GLASS", "all", true)
		.wallPanelEditor(-8, 12)
		.editWallPanelYes()
		.addSplit(-231, -14)
		.checkBusinessRuleInWallPanel("Multiple edges")
		.undoInWallPanelEditor(driver, 2)
		.verifyBusinessRuleInWallPanelRemoved("Multiple edges");
		
    }
}
