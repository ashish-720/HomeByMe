package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class AnchorPoints extends Browser {
    public void aeAnchorPoint() {
        StartApplication startApplication = PageFactory.initElements(driver, StartApplication.class);
        startApplication.startApp()
                .addAnchorPoint()
                .addAnchorPointPosition(0, 0, -300, 580)
                .addAnchorPointOrientation(0, 1, 0, 0, 1, -1, 0)
                .verifyAnchorPoint(1, 0, -300, 580)
                .duplicateAnchorPoint(1)
                .verifyAnchorPoint(2, 0, -300, 580)
                .addAnchorPointAvailableSpace(1, 800, 600, 200)
                .verifyAnchorPointAvSpace(1, 800, 600, 200)
                .verifyAnchorPointCount(2)
                .deleteAnchorPoint(1)
                .addAnchorPointReceiveTag(0, "DRAWER_100")
                .addAnchorPointReceiveTag(0, "DRAWER_200");
    }
}
