package enterprise.bathroom.mobile;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class LaunchApp extends Browser {

    @Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
    public void bathroomTestOnMobile(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver,StartNow.class);
                start.launchApp()
                        .editWallDimension(-5,-125,"4604 mm","apply left")
                        .undo(driver,1);

    }


}
