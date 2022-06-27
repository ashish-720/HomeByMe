package kitchen.bryo.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CheckRulesForBrokenBusinessRules extends Browser {
    AppSettings appSettings;
    String secondTab;

    // FUN125131   : As a user, I am notified of broken business rules when entering step 4
    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void checkRulesForBrokenBusinessRules(SignUpData signUpData) throws IOException {
//    	.Go to the corresponding 3D-Cloud and add/edit the attribute "checkRules":"none"/"step3ToStep4"/"step4Proceed", in order to activate the feature.

//    	Scenario 1: Change App setting checkRules to step3ToStep4 , Desired Issues to resolve Popin appears on visiting step 4 (only if  there are some Broke Rules in current Design)
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo","\"checkRules\":\"none\"", "\"checkRules\":\"step3ToStep4\"");

        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/");
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.setBryoAccessCode()
                .startDemo("en-GB")
                .startFromScratch().step3()
                .addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
                .position(-102, -6, "50 mm", "0 mm", "")
                .checkBusinessRuleShowIn3D("Base cabinet position", true)
                .step4()
//                .We can now see the Desired popin, if there are some Broke Rules in current Design.
//                .In the popin, "Yes"(primary CTA) will lead us to the Help center in Design state - similar to "Go Back to Fix".                
                .checkRulesOnStep3ToStep4("yes");
        		

//      Scenario 2: Change App setting checkRules to step4Proceed , Desired Issues to resolve Popin appears on clicking proceed button in step 4 
        Browser.switchToWindow(driver, secondTab);
        appSettings.modifyAppSettingsParameter("bryo", "\"checkRules\":\"step3ToStep4\"", "\"checkRules\":\"step4Proceed\"");
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
		MakeItYours design=PageFactory.initElements(driver, MakeItYours.class);
		 	design.refreshApplication()
		 	.startFromScratch()
		 	.recoverProject("yes")
        	.step4()
        	.clickProceedButton()
        	.checkRulesOnStep3ToStep4("yes")
        	.step4()
        	.clickProceedButton()
//          .Whereas, "No"(secondary CTA) will continue retailer defined actions when clicking the Proceed button. 
        	.checkRulesOnStep3ToStep4("no");

		 	
//     	Scenario 3: Change App setting checkRules to none , continue retailer defined actions when clicking the Proceed button. 
	    Browser.switchToWindow(driver, secondTab);
	    appSettings.modifyAppSettingsParameter("bryo", "\"checkRules\":\"step4Proceed\"", "\"checkRules\":\"none\"");
	    Browser.switchToWindow(driver, Browser.mainWindowHandle);
			 design.refreshApplication()
	        .startFromScratch()
	        .recoverProject("yes")
	        .step4()
	        .clickProceedButton()
	        .saveChanges();
	        
    }

}
