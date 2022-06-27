package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyProductCannotBeAdded  extends Browser {

    @Test(dataProvider="cloudCont", dataProviderClass= SignUpData.class)
    public void verifyProductCannotBeCreated(SignUpData signUpData)
    {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .createNewProduct()
                .setProductName("BoxAssembly","bryoCont")
                .setProductRef("BoxAssembly","bryoCont")
                .setProductType("Base cabinets")
                .setProductDate()
                .clickSaveAndVerifyPermissionDenied();
    }
}
