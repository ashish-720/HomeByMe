package enterprise.bathroom.mobile;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Openings extends Browser {

    @Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
    public void  openingsTest(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
        .mobileAddOpeningThroughWalls(7,130, "FIXED WINDOW")
                .verifyOpeningMobile(7,130, "FIXED WINDOW")
                .nextStep();

//        .mobileAddOpeningThroughWalls(-135,-19,"DOUBLE WINDOW")
//                .verifyOpeningMobile(-135,-19,"DOUBLE WINDOW")
//
//        .mobileAddOpeningThroughWalls(110,-12,"SIMPLE WIDOW")
//                .verifyOpeningMobile(110,-12,"SIMPLE WINDOW")
//
//        .mobileAddOpeningThroughWalls(-10,114,"Interior door")
//                .verifyOpeningMobile(-10,-114,"Interior door")
//
//                .nextStep();



    }
 }
