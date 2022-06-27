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

public class DisableDownloadInMediaWidget extends Browser {
   
	 AppSettings appSettings;
	    String secondTab;
    //FUN119278  : As a retailer, I can disable download actions in media widget
    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void disableDownloadInMediaWidget(SignUpData signUpData) throws IOException {
        //Change App setting download2DPlans and downloadImages to false
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo", "\"download2DPlans\":true","\"download2DPlans\":false")
                .modifyAppSettingsParameter("bryo", "\"downloadImages\":true","\"downloadImages\":false");
    }
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, dependsOnMethods = "disableDownloadInMediaWidget")
    public void verifyDisableDownloadInMediaWidget(SignUpData signUpData) throws IOException {
        //Verify download button is  not available
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://widgeted:widgeting@preprod-staging-widgets.enterprise-dev.by.me/MyProjectsView/embed.html");
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/?kitchenBeta");

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.setBryoAccessCode()
                .startDemo("en-GB")
                .login(signUpData)
                .openMyProjectListStaging()
                .searchProject("ODT_DisableDownloadTest")
                .openProjectStaging(0, "ODT_DisableDownloadTest")
                .step4()
                .verifyPriceInStep4("")
                .clickShowImagesStaging()
                .verifyDownloadPossibleFor2DPlans(false)
                .verifyDownloadPossibleForImages(false);
      
        //Change App setting download2DPlans and downloadImages to true
        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("bryo", "\"download2DPlans\":false","\"download2DPlans\":true")
        .modifyAppSettingsParameter("bryo", "\"downloadImages\":false","\"downloadImages\":true");

        //Verify download button is available
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        MakeItYours design=PageFactory.initElements(driver, MakeItYours.class);
	 	design.refreshApplication()
	 	.openMyProjectListStaging()
        .searchProject("ODT_DisableDownloadTest")
        .openProjectStaging(0, "ODT_DisableDownloadTest")
        .recoverProject("yes")
        .verifyPrice("753,00")
        .step4()
        .verifyPriceInStep4("753,00")
        .clickShowImagesStaging()
        .verifyDownloadPossibleFor2DPlans(true)
        .verifyDownloadPossibleForImages(true);
    }
}
