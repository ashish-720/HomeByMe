package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DisableMuliReplaceFeature extends Browser {
    AppSettings appSettings;
    String secondTab;

    //FUN122684 : As a user, I can disable multi-replace within the solution
    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void disableMuliReplaceWithinTheSolution(SignUpData signUpData) throws IOException {
        //Change App setting allowMultiReplace to false
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo", "\"allowMultiReplace\":true", "\"allowMultiReplace\":false");
               
        //Verify multi replace option not available
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me");

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        MakeItYours makeItYours = start.setBryoAccessCode()
                .startDemo("en-GB")
                .startFromScratch().step3()
                .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
                .verifyMultiReplacePossible(-100, -15, false);

        //Change App setting allowMultiReplace to true
        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("bryo", "\"allowMultiReplace\":false", "\"allowMultiReplace\":true");

        //Verify multi replace option is available
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        makeItYours.refreshApplication()
                .startFromScratch()
                .recoverProject("yes")
                .verifyMultiReplacePossible(10, -5, true);
    }

    @Test(alwaysRun = true , dependsOnMethods = {"disableMuliReplaceWithinTheSolution"})
    public void resetAppSettings() throws IOException {
        //Revert app settings changes if something was modified
        if (appSettings != null) {
            Browser.switchToWindow(driver, secondTab);
            appSettings.resetAppSettingsParameter("bryo").logout();
        }
    }
}
