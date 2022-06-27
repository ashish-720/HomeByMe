package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Family;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyFamilyCannotBeModified extends Browser {


    @Test(dataProvider = "cloudCont", dataProviderClass = SignUpData.class)
    public void verifyFamilyCannotBeModified(SignUpData signUpData) {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .goToFamilyPage()
                .searchAndOpen("ODT_Test_family", Family.class)
                .updateFamilyName("_modified", "append")
                .clickSaveAndVerifyPermissionDenied();
    }
}