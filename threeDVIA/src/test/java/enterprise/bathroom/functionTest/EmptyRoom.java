package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EmptyRoom extends Browser {
    @Test
    public void emptyRoom() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .roomShape("closed", 2)
                .roomType(-15,135,"Bathroom")
                .verifyRoomType(-15,135,"Bathroom", "Bathroom")
                .step3()
                .addProductBathroom("Vanity unit", true, false, false)
                .addProductThroughSearch("Toilets", "Suspended toilet", true, false)
                .twoDView()
                .emptyRoomBathroom(-22, 7, "Bathroom", "15.0 m²", "Yes")
                .threeDView();


    }
}
