package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import kitchen.threeDCloudByMe.pageObject.Material;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyMaterialCanBeEdited extends Browser {

    @Test(dataProvider = "cloudCont", dataProviderClass = SignUpData.class)
    public void verifyMaterialCanBeEdited(SignUpData signUpData) {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .goToMaterialsPage()
                .searchAndOpen("ODT_TestMaterial_Carpet", Material.class)
                .updateMaterialName("_Modified", "append")
                .clickSave()
                .materialNameVerify("ODT_TestMaterial_Carpet_Modified")
                .updateMaterialName("ODT_TestMaterial_Carpet", "modify")
                .clickSave();
    }
}
