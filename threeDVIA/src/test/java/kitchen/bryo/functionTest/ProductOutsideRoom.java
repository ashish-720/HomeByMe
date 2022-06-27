package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test Scenarios for KIT-2139 : As a user, I am notified when a product is outside the room
public class ProductOutsideRoom extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void brProductOutsideRoom(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .ceiling("2500 mm")
                .step3()
                .verifyPrice("0,00")
                .addProduct("GVARIO03", true, false, false)
                .verifyProduct(-120, -80, "GVARIO03")
                .checkBusinessRulesCount(0, 0, 0)

                //Scenario 1 : If product is completely outside wall, BR should trigger warning the user
                .clickFloorplan()
                .twoDView()
                .moveWall(-230, 0, -110, 0)
                .step3()
                .checkBusinessRuleShowIn3D("Item position", true)

                //Scenario 2 : If product is partly colliding with outside wall, BR should trigger warning the user
                .clickFloorplan()
                .twoDView()
                .moveWall(-110, 0, -205, 0)
                .step3()
                .checkBusinessRuleShowIn3D("Item position", true)

                //Scenario 3 : Business Rule shouldnot trigger if product is colliding with inner walls only
                .twoDView().twoDView()
                .translateProduct(-185,-185, 65,135)
                .clickFloorplan()
                .twoDView()
                .addWall("bryoRoomAddWall2")
                .step3()
                .verifyBusinessRuleRemoved("Item position")

                //Scenario 4: Business Rule shouldnot trigger if product is colliding with room separator
                .clickFloorplan()
                .twoDView()
                .addRoomSeparators("bryoAddRoomSeparation2")
                .step3()
                .twoDView().twoDView()
                .translateProduct(-135, -65, 200, 100)
                .verifyBusinessRuleRemoved("Item position");

                //Scenario 5 : Show in 3D button should be there when the rule is triggered : covered in the other scenarios
    }
}
