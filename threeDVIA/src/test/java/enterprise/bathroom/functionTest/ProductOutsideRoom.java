package enterprise.bathroom.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test Scenarios for KIT-2139 : As a user, I am notified when a product is outside the room
public class ProductOutsideRoom extends Browser {
    @Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
    public void brProductOutsideRoom(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .ceiling("2500 mm")
                .step3()
//                .verifyPrice("0,00")
                .addProductBathroom("U2DA100", true, false, false)
                .verifyProduct(-90, -10, "U2DA100")
                .checkBusinessRulesCount(0, 0, 0)

                //Scenario 1 : If product is completely outside wall, BR should trigger warning the user
                .clickFloorplan()
                .twoDView()
                .moveWall(-245, 0, -70, 0)
                .step3()
                .checkBusinessRuleShowIn3D("Item position", true)

                //Scenario 2 : If product is partly colliding with outside wall, BR should trigger warning the user
                .clickFloorplan()
                .twoDView()
                .moveWall(-70, 0, -105, 0)
                .step3()
                .checkBusinessRuleShowIn3D("Item position", true)

                //Scenario 3 : Business Rule shouldnot trigger if product is colliding with inner walls only
                .clickFloorplan()
                .twoDView()
                .moveWall(-120,-30, -270,-30)
                .twoDView()
                .step3()
                .translateProduct(-15,-9,10,63)
                .clickFloorplan()
                .addWall("bathroomWall01")
                .step3()
                .verifyBusinessRuleRemoved("Item position")

//                //Scenario 4: Business Rule shouldnot trigger if product is colliding with room separator
                .clickFloorplan()
                .twoDView()
                .addRoomSeparators("bathroomRoomSeparator01")
                .step3()
                .twoDView()
                .twoDView()
//                .translateProduct(-135, -65, 200, 100)
                .verifyBusinessRuleRemoved("Item position");

    }
}
