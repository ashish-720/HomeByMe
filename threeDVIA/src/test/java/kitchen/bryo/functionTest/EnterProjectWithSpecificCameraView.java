package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EnterProjectWithSpecificCameraView extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void enterProjectWithSpecificCameraView(SignUpData signUpData) {
    	StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.clickDiscover()
                .openPariCollectionDesign()
                .verifyPrice("18 183,28")
                .verifyCurrentSelectedView("FP")
                .realisticImage(2,signUpData,"ODT_RIForSpecificCameraViewPoint","Desc")
                .verifyCurrentSelectedView("3D")
                .addProduct("U2DA80", true, true, false,true)
                .translateProduct(-200,40)
                .twoDView().threeDView()
                .verifyProduct(-82, 86, "U2DA80");

    }

}
