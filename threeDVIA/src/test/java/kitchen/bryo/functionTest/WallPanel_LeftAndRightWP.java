package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WallPanel_LeftAndRightWP extends Browser {
    //Scenarios for KIT-1507 : As a user, I can add wall panels to the side of base cabinets when touching a wall
    @Test
    public void wallPanelTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addProduct("U2DA80", true, false, false)
                .addProperty(-115, -30, "Wall Panel", "DK_WP_GLASS", "all", true)
                .verifyAddProperty(-115, -30, "Wall Panel", "DK_WP_GLASS")

                //Scenario 1 : If a unit (or filler) are touching a wall on either the left or right of the entire linear then options to add side wall panels are enabled
                .verifyWallPanelOptionsProperty(-100, -10, "570 mm", "", "true", "false", "false", "")
                .translateProduct(-100, -10, -10, 0)
                .verifyWallPanelOptionsProperty(-110, -10, "570 mm", "", "true", "false", "false", "")

                .translateProduct(-110, -10, 100, 0)
                .verifyWallPanelOptionsProperty(-10, -10, "570 mm", "", "false", "", "false", "")

                .translateProduct(-10, -10, 130, 0)
                .verifyWallPanelOptionsProperty(120, -10, "570 mm", "", "false", "", "true", "false")

                .translateProduct(120, -10, 10, 0)
                .verifyWallPanelOptionsProperty(110, -10, "570 mm", "", "false", "", "true", "false")

                //Scenario 2 : If a part of the linear is only touching one side wall then the other option is disabled : covered in scenario 1

                //Scenario 3 : When a side wall panel is created it matches the height of the existing wall panel, and extends to the front of the worktop
                .editWallPanelOptionsProperty(110, -10, "400 mm", "", "", "true")
                .verifyWallPanelOptionsProperty(110, -10, "400 mm", "", "false", "", "true", "true")
                .wallPanelEditor(110, -10)
                .editWallPanelYes()
                .switchWallPanelLayer(210, 14, "830 mm")
                .switchWallPanelLayer(-240, 14, "629 mm")
                .verifyWallPanelDimension(-195, 40, "400 mm")

                //Scenario 4 : The new wall panel created can be edited in height, and should appear and be editable in wall panel editor
                .editWallPanelDimension(-195, 40, "400 mm", "500 mm", "apply above")
                .verifyWallPanelDimension(-195, 40, "500 mm")
                .dragWallPanel(-240, -2, -240, -32)
                .verifyWallPanelDimension(-195, 40, "710 mm")
                .createCutOutForWallPanel(-240, 25, "Rectangle", "200 mm", "200 mm", "yes", "20 mm", "")
                .dragWallPanel(-195, 40, -210, 40)
                .verifyPriceInWallPanel("Price is not available")
                .changeGrainDirection(-240, -15)
                .verifyPriceInWallPanel("857,90")
                .cornerCutForWallPanel(-210, -30, "Double", "", "", "115 mm", "115 mm", "no", "", "")
                .verifyCornerCutForWallPanel(-217, -16, "115 mm")
                .validateWallPanelEditor()
                .verifyProduct(15, -65, "DK_WP_GLASS");
    }
}
