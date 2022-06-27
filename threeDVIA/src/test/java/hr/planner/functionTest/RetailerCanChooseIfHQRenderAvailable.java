package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.Setting;
import hr.planner.pageObject.HomePlanner;
import hr.web.pageObject.LandingPageHR;

import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

//FUN126001 : As a retailer, I can choose if HQ renders are available within the Home Retailer solution
@Test
public class RetailerCanChooseIfHQRenderAvailable extends Browser {
    AppSettings appSettings;
    String secondTab;

    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void retailerCanChooseIfHQRenderAvailable(SignUpData signUpData) throws IOException {
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("HBMHfR")
                .addAppSettingsParameter("HBMHfR", "\"hqRendering\": {\"isEnabled\" : true}");

        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver,Setting.hrWebPreprodStaging);
        LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
        HomePlanner hp = home.login(signUpData)
                .planMyRoomClick()
                .takePicture()
                .verifyHQRenderingOptionsAvailable("Take a screenshot", "Take a realistic picture", "Take a 360° Image");

        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("HBMHfR", "\"hqRendering\":{\"isEnabled\":true}", "\"hqRendering\":{\"isEnabled\":false}");

        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        hp.refreshApplication()
                .planMyRoomClick()
                .takePicture()
                .verifyHQRenderingOptionsAvailable("Take a screenshot", "Take a 360° Image");
    }

	@Test(alwaysRun = true , dependsOnMethods = {"retailerCanChooseIfHQRenderAvailable"})
	public void resetAppSettings() throws IOException {
		//Revert app settings changes if something was modified
		if (appSettings != null) {
			Browser.switchToWindow(driver, secondTab);
			appSettings.resetAppSettingsParameter("HBMHfR").logout();
		}
	}

}
