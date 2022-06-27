package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
//Test Scenarios for KIT-2187 : As a user, I see a clear error message on the Bryo landing page if I don't enter the right access code
public class AccessCodeTest extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void accessCodeTest(SignUpData signUpData) {
        //Scenario 1 : If start demo is clicked without entering any access code : covered in bryoTestAccessCode() method , hbm.planner.utility.Browser class

        //Scenario 2 : If start demo is clicked by entering wrong access code : covered in bryoTestAccessCode() method , hbm.planner.utility.Browser class

        //Scenario 3 : User tries to access website by entering url to browser directly : covered in bryoTestAccessCode() method , hbm.planner.utility.Browser class

        //Scenario 4 : If start demo is clicked by entering correct access code : covered in bryoTestAccessCode() method , hbm.planner.utility.Browser class

        //Basic test after entering using correct access code
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                .selectStyleMapping("Ottawa - Wood", "38mm Acrylic Worktop", "170mm Bar Handle");
    }

}
