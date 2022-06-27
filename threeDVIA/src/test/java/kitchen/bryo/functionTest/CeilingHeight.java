package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CeilingHeight extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void ceilingHeightTest(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
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
                .verifyBusinessRuleRemoved("Ceiling Height")
                //Scenario 3: Revert ceiling height reemoves business rule : implemented in the previous scenarios

                //FUN119283 : As a user, I can import from Leica laser measure
                .saveProjectInStep3(signUpData, "FUN119283_ImportFromLeicaMeasure", "As a user, I can import from Leica laser measure")
                .verifySavedProjectDetails("FUN119283_ImportFromLeicaMeasure")
                .clickFloorplan()
                .importLaserMeasurements("plan_export_2D.dxf")
                .verifyWallProperty(-155, 0, "3622 mm")
                .verifyWallProperty(155, 0, "3758 mm")
                .verifyWallProperty(0, -305, "1820 mm")
                .verifyWallProperty(-100, 285, "689 mm")
                .verifyWallProperty(50, 305, "1132 mm")
                .verifyWallProperty(-45, 295, "137 mm")
                .step3().verifySavedProjectDetails("MY KITCHEN")

                .clickFloorplan()
                .verifyCeiling(-155, 0, "3000 mm")
                .importLaserMeasurements("plan_export_3D.dxf")
                .verifyCeiling(-155, 0, "2501 mm");
    }
}
