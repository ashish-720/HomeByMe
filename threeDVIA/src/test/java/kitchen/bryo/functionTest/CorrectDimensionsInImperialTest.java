package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class CorrectDimensionsInImperialTest extends Browser {

    //FUN119286 :As a user, I am presented with correct dimensions/measurements in imperial
    @Test
    public void correctDimensionsInImperialTest() throws IOException {
        Browser.openUrl(driver, "https://preprod-staging-kitchen.enterprise-dev.by.me/");
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchBaseApp("", "en-US", false, false, false)
                .verifyWallProperties(-245, -5, "6\"", "98 3/8\"", 1)
                .editWallPropertiesAndVerifyErrMsg(-245, -5, "73\"", "", "The maximum value is 72\".")
                .editWallPropertiesAndVerifyErrMsg(-245, -5, "1/2\"", "", "The minimum value is 1\".")
                .verifyWallProperty(-245, -5, -225, 225, "36\" > 36\" > 50 7/8\"")
                .manageSlopedWalls(-245, -5)
                .verifySlopedCeiling("50\"", "55\"","")
                .setSlopedCeilingDimensionsAndVerifyErrorMsg("1/2\"","1/2\"","","The minimum value is 1\".")
                .setSlopedCeilingDimensionsAndVerifyErrorMsg("99\"","","","The maximum value is 98 3/8\".")
                .setSlopedCeilingDimensionsAndVerifyErrorMsg("","73\"","","The maximum value is es 72\".")
                .clickCancelSlopedCeiling();
    }
}
