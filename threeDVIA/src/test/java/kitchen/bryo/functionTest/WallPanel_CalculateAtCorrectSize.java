package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WallPanel_CalculateAtCorrectSize extends Browser {
    /**
     * KIT-2060 : As a user, when planning with wall panels they are calculated at the correct size
     */
    @Test
    public void wallPanelCalculateAtCorrectSizeTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
                //Precondt : room setup
                .roomShape("Closed", 2)
                .moveWall(180, -125, 180, 25)
                .moveWall(-245, -245, -150, -245)
                .step3()
                .addProduct("CORNER FILLER BASE UNIT", true, false, false)
                .addProduct("UEDK88_KP8500", true, true, false).translateProduct(65, 0)
                .addProduct("U2DA50", true, false, false).translateProduct(-70, -60)
                .addProduct("U2DA50", true, false, false)
                .addProduct("U2DA50", true, false, false).translateProduct(-150, -50)
                .clickAndDrag(-30, 0)
                .addProduct("CORNER FILLER BASE UNIT", true, false, false)
                .addProduct("U2DA50", true, false, false).translateProduct(-80, 20)
                .addProduct("U2DA80", true, true, false)
                .addProperty(-85, -15, "Wall Panel", "DK_WP_GLASS", "all", true)
                .addProperty(85, 25, "Wall Panel", "GEN_WP_OAK", "all", true)

                //Scenario : For auto generated wall panels,  wall panels on both sides of the corner are shortened  (if the corner is an acute/obtuse angle) and one side is shortened ( if corner is at 90° )
                .wallPanelEditor(85, 25)
                .editWallPanelYes()
                .verifyWallPanelDimension(-161, -11, "1751 mm")        //rt side wall panel on the acute angle corner
                .verifyWallPanelDimension(140, -8, "1214 mm")            //lt side wall panel on the obtuse angle corner
                .switchWallPanelLayer(227, -11, "1451 mm")    //lt side wall panel on the acute angle corner
                .switchWallPanelLayer(-185, -8, "1393 mm")    //rt side wall panel on the right angle corner
                .switchWallPanelLayer(-66, -8, "2193 mm")    //lt side wall panel on the right angle corner and rt side wall panel on the obtuse angle corner

                //Scenario : It is possible to extend wall panel to the edge of the room but BR triggered if there is overlap
                //Scenario : BR doesn't show anymore if the overlap is fixed/removed
                .zoomIn(12)
                .verifyWallPanelDimension(303, 88, "550 mm") 
                .dragWallPanel(303, 88, 315, 88)
                .verifyWallPanelDimension(-235, -26, "2193 mm")            //lt and rt side wall panel on the rt angle corner now overlaps
                .checkBusinessRuleInWallPanel("Wall panel position")
                .dragWallPanel(315, 88, 303, 88)
                .verifyBusinessRuleInWallPanelRemoved("Wall panel position")

                .switchWallPanelLayer(140, -8, "1214 mm")            //lt side wall panel on the obtuse angle corner
                .zoomIn(12)
                .clickAndDrag(-350, 50)
                .dragWallPanel(493, 189, 505, 189)
                .verifyWallPanelDimension(174, 20, "1224 mm")            //lt and rt side wall panel on the obtuse angle corner now overlaps
                .checkBusinessRuleInWallPanel("Wall panel position")
                .dragWallPanel(505, 189, 493, 108)
                .verifyBusinessRuleInWallPanelRemoved("Wall panel position")

                .switchWallPanelLayer(229, -12, "1451 mm")            //lt side wall panel on the acute angle corner
                .zoomIn(11)
                .clickAndDrag(-550, 0)
                .dragWallPanel(531, 94, 535, 94)
                .verifyWallPanelDimension(168, -34, "1458 mm")            //lt and rt side wall panel on the acute angle corner now overlaps
                .checkBusinessRuleInWallPanel("Wall panel position")
                .dragWallPanel(535, 94, 531, 94)
                .verifyBusinessRuleInWallPanelRemoved("Wall panel position");
    }
}
