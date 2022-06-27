package enterprise.bathroom.businessRules;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ElectricalSafetyRule extends Browser {

    @Test
    public void electricalSafetyRule () {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .addProductBathroomFloorplan("PLUG",false,false)
                .threeDView()
                .zoomIn(5)
                .position(-2,-37,"1000 mm", "600 mm")
                .step3()
                .addProductBathroom("Vanity unit",true,false,false)
                .position(-130,10,"1520 mm", "1000 mm","")
                .checkBusinessRuleShowIn3D("Electrical Item Height",true)
                .zoomIn(6)
                .clickFloorplan()
                .threeDView()
                .zoomIn(7)
                .position(110,18,"600 mm","900 mm")
                .step3()
                .verifyBusinessRuleRemoved("Electrical Item Height");






    }
}
