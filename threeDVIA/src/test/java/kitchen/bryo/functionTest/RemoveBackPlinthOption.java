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

public class RemoveBackPlinthOption extends Browser {
    AppSettings appSettings;
    String secondTab;

    // FUN122523 : As a retailer, I can remove the back plinth option
    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void removeBackPlinthOption(SignUpData signUpData) throws IOException {
        //Change App setting backPlinthOptionVisible to false
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo", "\"backPlinthOptionVisible\":true", "\"backPlinthOptionVisible\":false");

        //Scenario : When backPlinthOptionVisible setting is not present for a plinth product, backPlinthOptionVisible setting in app setting is used to determine whether back plinth will be displayed
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/");

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        MakeItYours makeItYours = start.setBryoAccessCode()
                .startDemo("en-GB")
                .startFromScratch().step3()
                .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
                .translateProduct(120, 90)
                .verifyBackPlinthOptionAvailable(25, 80, false)

                //Scenario : When backPlinthOptionVisible option is present for a plinth product, backPlinthOptionVisible option of plinth prdt is used to determine whether back plinth will be displayed
                .replaceProperty(25, 80, "Plinth", "ODT_LinearProdTest_KIT-2111_Plinth", "", true,"")
                .verifyBackPlinthOptionAvailable(25, 80, true)
                .verifyPlinthOption(25, 80, true)
                .setPlinthOption(25, 80, false)
                .verifyPlinthOption(25, 80, false);

        //Change App setting backPlinthOptionVisible to true
        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("bryo", "\"backPlinthOptionVisible\":false", "\"backPlinthOptionVisible\":true");

        //Scenario : When backPlinthOptionVisible setting is not present for a plinth product, backPlinthOptionVisible setting in app setting is used to determine whether back plinth will be displayed
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        makeItYours.refreshApplication()
                .startFromScratch()
                .recoverProject("no")
                .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false).translateProduct(120, 90)
                .verifyBackPlinthOptionAvailable(25, 80, true)
                .verifyPlinthOption(25, 80, true)
                .setPlinthOption(25, 80, false)
                .verifyPlinthOption(25, 80, false)

                //Scenario : When backPlinthOptionVisible option is present for a plinth product, backPlinthOptionVisible option of plinth prdt is used to determine whether back plinth will be displayed
                .replaceProperty(25, 80, "Plinth", "MADELEINE|15771", "",true, "")
                .verifyBackPlinthOptionAvailable(25, 80, false);
    }


    @Test(alwaysRun = true, dependsOnMethods = {"removeBackPlinthOption"})
    public void resetAppSettings() throws IOException {
        //Revert app settings changes if something was modified
        if (appSettings != null) {
            Browser.switchToWindow(driver, secondTab);
            appSettings.resetAppSettingsParameter("bryo").logout();
        }
    }
}
