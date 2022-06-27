package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import kitchen.threeDCloudByMe.pageObject.Templates;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyTemplateCanBeEdited extends Browser {

    @Test(dataProvider = "cloudCont", dataProviderClass = SignUpData.class)
    public void verifyTemplateCanBeEdited(SignUpData signUpData) {
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login.login(signUpData)
                .goToTemplatesPage()
                .searchAndOpen("ODT_TestTemplate", Templates.class)
                .updateTemplateName("_Modified", "append")
                .clickSaveButton()
                .templateNameVerify("ODT_TestTemplate_Modified")
                .updateTemplateName("ODT_TestTemplate", "modify")
                .clickSaveButton()
                .uploadTemplate("test_template")
                .verifyUploadedTemplateFileInfo();
    }
}
