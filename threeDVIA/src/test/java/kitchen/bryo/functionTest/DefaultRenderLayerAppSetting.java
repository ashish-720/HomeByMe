package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefaultRenderLayerAppSetting extends Browser {
    AppSettings appSettings;
    String secondTab;

    // FUN122690  : As a retailer, I can choose the default render when entering the render layer
    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void defaultRenderLayerAppSetting(SignUpData signUpData) throws IOException {
        //Change App setting is3DViewDefault to true
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo", "\"is3DViewDefault\":false", "\"is3DViewDefault\":true");
    } 
    
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, dependsOnMethods = "defaultRenderLayerAppSetting")
    public void verifyDefaultRenderLayerAppSetting(SignUpData signUpData) throws IOException {
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://widgeted:widgeting@preprod-staging-widgets.enterprise-dev.by.me/MyProjectsView/embed.html");
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/");

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.setBryoAccessCode()
                .startDemo("en-GB")
                .startFromScratch().step3()
                .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
                .saveProjectInStep3(signUpData, "ODT_DefaultRenderLayer"+UtilHBM.getDate(0, "dd_MM_yyyy"), "")
               .realisticImage3DView()
               .step4()
               .clickDesignStep()
               .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
               .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false);

        //Change App setting is3DViewDefault to false
        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("bryo", "\"is3DViewDefault\":true", "\"is3DViewDefault\":false");
    }

}
