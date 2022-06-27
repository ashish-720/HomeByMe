package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WorktopJoints extends Browser {
    //FUN120664 : As a user, if I place a joint on a worktop board, it is priced and exported only as a joint
    @Test
    public void worktopJointsTest() {
        //TODO : Remove opening in alpha when the feature is moved to beta
        Browser.openUrl(driver, "https://preprod-bryo.enterprise-dev.by.me/en-GB/?kitchenAlpha");
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.setBryoAccessCode()
                .startDemo("en-GB")
                .startFromScratch()
                .step3()

                //Scenario 1 : Diagonal corner worktops
                .addProduct("CooktopCornerCabinet_KP8500", true, false, false)
                .addProduct("U2DA80", true, true, false)
                .addProduct("U2DA80", true, true, false).translateProduct(-180, 60)
                .replaceProperty(-40, 0, "Worktop", "ACRYLIC WHITE", "", true,"")
                .verifyReplaceProperty(-40, 0, "Worktop", "ACRYLIC WHITE")
                .worktopEditor(-40, 0)
                .editWorktopYes()
                .verifyJoint(-103, -176, "843 mm")
                .verifyJoint(-176, -103, "843 mm")
                .cancelWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:GEN_CWT_JOINT > Quantity:2 > Total:€ 400,00", "1")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_CUT_SINGLE > Quantity:2 > Total:€ 200,00", "1")

                //Scenario 1 : Joint aligned with a cut
                .twoDView().emptyRoom(100, 100, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("CORNER FILLER BASE UNIT", true, false, false)
                .editCornerFiller(-90,0,"","","","370 mm","","").translateProduct(-5, -25)
                .addProduct("U2DA80", true, true, false)
                .addProduct("U2DA80", true, true, false).translateProduct(-140, 25)
                .worktopEditor(-60, -10 )
                .editWorktopYes()
                .mergeWorktops(-139,-208)
                .verifyJoint(-186,-186,"995 mm")
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:GEN_CWT_JOINT > Quantity:1 > Total:€ 200,00", "1")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_CUT_DOUBLE > Quantity:1 > Total:€ 100,00", "1")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_CUT_SINGLE", "0");
    }
}
