package kitchen.bryo.mobile;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


@Test
public class Openings extends Browser {

    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void openingsTest(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratchMobile()
//                .tooltipsForOpenings()
                .mobileAddOpeningThroughWalls(7, 130, "DOUBLE WINDOW")
                .verifyOpeningMobile(7, 130, "DOUBLE WINDOW")
                .addWaterSupply(-239, 60).verifyWaterSupply()
                .nextStep();
    }

}
