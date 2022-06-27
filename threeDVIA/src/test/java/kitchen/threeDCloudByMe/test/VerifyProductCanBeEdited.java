package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import kitchen.threeDCloudByMe.pageObject.Product;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyProductCanBeEdited extends Browser {

    @Test(dataProvider="cloudCont", dataProviderClass= SignUpData.class)
    public void verifyProductCanBeEdited(SignUpData signUpData)
    {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .searchAndOpen("ODT_TestProduct_BoxAssembly", Product.class)
                .updateProductName("_modified","append")
                .clickSave()
                .clickBack()
                .searchAndOpen("ODT_TestProduct_BoxAssembly_modified", Product.class)
                .productNameVerify("ODT_TestProduct_BoxAssembly_modified")
                .updateProductName("ODT_TestProduct_BoxAssembly","modify")
                .clickSave();
    }
}
