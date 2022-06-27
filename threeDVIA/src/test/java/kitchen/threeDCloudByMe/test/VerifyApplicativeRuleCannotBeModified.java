package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.ApplicativeRule;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyApplicativeRuleCannotBeModified extends Browser {

    @Test(dataProvider="cloudCont", dataProviderClass= SignUpData.class)
    public void verifyApplicativeRuleCannotBeModified(SignUpData signUpData)
    {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .goToApplicativeRulesPage()
                .searchAndOpen("ODT_AppRule1", ApplicativeRule.class)
                .updateapplicativeRuleName("_modified", "append")
                .saveAndVerifyPermissionDenied();
    }
}
