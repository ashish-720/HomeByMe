package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/*
 FUN118227 : As a range maintainer, I can define the default dimensions of the freestanding worktops
 */
public class WorktopDefaultDimensionsOfFreestandingWT extends Browser {
    @Test
    public void worktopDefaultDimensionsOfFreestandingWT() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
                .step3()
                //Scenario : Verify default dimension for custom WT
                .addProductThroughSearch("Worktop", "ODT_ACRYLIC WHITE", true, false)
                .verifyFreeStandingWorktopProperties(15,40,"1000 mm","635 mm","1000 mm")

                //Scenario : Verify default dimension can be edited
                .editFreeStandingWorktopProperties(15,40,false,"1200 mm", "700 mm", "880 mm")
				.verifyFreeStandingWorktopProperties(15,40,"1200 mm","700 mm", "880 mm")

                //Scenario : Verify dimensions not reverted to default on refreshing application and recovering previous work
                .refreshApplication()
                .startFromScratch()
                .recoverProject("yes")
                .verifyFreeStandingWorktopProperties(15,40,"1200 mm","700 mm", "880 mm")
                .deleteProduct(15,40)

                //Scenario : Verify above scenarios for precut WT
                .addProductThroughSearch("Worktop", "WOOD OAK", true, false)
                .verifyFreeStandingWorktopProperties(15,40,"2460 mm","635 mm","1000 mm")
                .editFreeStandingWorktopProperties(15,40,false,"2000 mm", "800 mm", "880 mm")
                .verifyFreeStandingWorktopProperties(15,40,"2000 mm","800 mm", "880 mm")
                .refreshApplication()
                .startFromScratch()
                .recoverProject("yes")
                .verifyFreeStandingWorktopProperties(15,40,"2000 mm","800 mm", "880 mm");
    }
}
