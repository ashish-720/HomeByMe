package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import kitchen.threeDCloudByMe.pageObject.ProductRules;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyProductRuleCannotBeModified extends Browser {

    @Test(dataProvider="cloudCont", dataProviderClass= SignUpData.class)
    public void verifyProductRuleCannotBeModified(SignUpData signUpData)
    {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .goToProductRules()
                .searchAndOpen("INL_W10", ProductRules.class)
                .updateProductRuleName("_modified", "append")
                .saveAndVerifyPermissionDenied();
    }
}
