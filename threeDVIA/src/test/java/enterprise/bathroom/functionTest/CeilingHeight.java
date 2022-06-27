package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CeilingHeight extends Browser {
    @Test
    public void ceilingHeightTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
				.ceiling("999 mm")
                .ceiling("4000 mm")
                .verifyCeiling(-235, 25, "4000 mm")

                //Test scenarios for KIT-2193 : As a user, I am notified if my ceiling height is too low
                //Scenario 1: When ceiling height is too low
                .ceiling("1999 mm")
                .verifyCeiling(-235, 25, "1999 mm")
                .step3()
                .checkBusinessRuleShowIn3D("Ceiling Height", false)
                .checkBusinessRulesCount(0, 0, 1)
                .clickFloorplan()
                .ceiling("2000 mm")
                .verifyCeiling(-235, 25, "2000 mm")
                .step3()
                .verifyBusinessRuleRemoved("Ceiling Height")
                .clickFloorplan()

                //Scenario 2 : When there is a sloped ceiling with the lower end being too low
                .ceiling("3000 mm")
                .verifyCeiling(-235, 25, "3000 mm")
                .addSlopedCeilingFromWall(-235, 25, "1999 mm", "", "")
                .manageSlopedWalls()
                .verifySlopedCeiling2D(-235, 25, "1999 mm", "", "")
                .validateSlopedCeiling()
                .step3()
                .checkBusinessRuleShowIn3D("Ceiling Height", false)
                .checkBusinessRulesCount(0, 0, 1)
                .clickFloorplan()
                .editSlopedCeilingFromWall(-235, 25, -140, 25, "2000 mm", "", "")
                .manageSlopedWalls()
                .verifySlopedCeiling2D(-235, 25, "2000 mm", "", "")
                .validateSlopedCeiling()
                .step3()
                .verifyBusinessRuleRemoved("Ceiling Height");
        //Scenario 3: Revert ceiling height reemoves business rule : implemented in the previous scenarios
    }
}
