package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This ODT covers test scenarions for FUN118565 : As a user, I can replace an edited worktop without loosing compatible items
 */
public class WorktopEditWTWithoutLosingCompatibleItems extends Browser {
    AppSettings appSettings;
    String secondTab;

    @Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
    public void worktopEditWTWithoutLosingCompatibleItemsTest(SignUpData signUpData) throws IOException {
        //Change App setting resetCustomizedLinear to false
        secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
        Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
        appSettings = login.login(signUpData)
                .goToAppSettings()
                .getAppSettingsBackup("bryo")
                .modifyAppSettingsParameter("bryo", "\"resetCustomizedLinear\":true","\"resetCustomizedLinear\":false");

        //Start test
        Browser.switchToWindow(driver, Browser.mainWindowHandle);
        Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/en-GB/");

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.setBryoAccessCode().startDemo("en-GB")
                .startFromScratch()
                .step3()
                .addProduct("U2DA80", true, true, false)


                //Scenario 10: In case of split WT, only the board which is being replaced is affected and the other remains intact TODO
                //Scenario 11: Effect of Undo/Redo TODO

                //Scenario 1: Change WT popup displayed properly when changing to different WT which has incompatble items : verify popup
                //Scenario 2: Clicking undo on popup reverts back to previous WT and previous modifications are kept.
                .replaceProperty(-110, -15, "Worktop", "ACRYLIC WHITE", "", true,"", "yes")
                .verifyCustomWorktopModifications("OK", "Edge finish have been added")
                .verifyReplaceProperty(-110, -15, "Worktop", "ACRYLIC WHITE")
                .replaceProperty(-110, -15, "Worktop", "WOOD OAK", "",true, "", "")
                .verifyCustomWorktopModifications("Undo", "Edge finish have been removed")
                .verifyReplaceProperty(-110, -15, "Worktop", "ACRYLIC WHITE")

                //Scenario 3: Clicking OK on popup results in the WT being changed and compatible items are retained and incompatible items are removed and listed in the warning popup
                //Scenario 4: Change of size
                .worktopEditor(-110, -15)
                .editWorktopYes()
                .moveWorktop(-122, -172, -90, -172)
                .moveWorktop(-157, -149, -157, -120)
                .verifyWorktopDimension(-90, -172, "899 mm")
                .verifyWorktopDimension(-157, -120, "1172 mm")
                .validateWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "WOOD OAK", "",true, "", "")
                .verifyCustomWorktopModifications("OK", "Edge finish have been removed")
                .worktopEditor(0, 25)
                .verifyWorktopDimension(-96, -179, "899 mm")
                .verifyWorktopDimension(-154, -129, "1172 mm")
                .cancelWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "ACRYLIC WHITE", "", true,"OK", "yes")

                //Scenario 5: Change of cuts
                //Scenario 6: Change of cut-outs
                //Scenario 7: Show/Hide Compatible Options link work
                .worktopEditor(0, 25)
                .createCutOut(-140, -165, "Circle", "", "", "", "", "200 mm")
                .verifyWorktopCutOut(-140, -165, "", "", "", "200 mm", "", "")
                .validateWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "LAMINATE BLACK", "",true, "", "")
                .showNonCompatibleOptions()
                .hideNonCompatibleOptions()
                .showNonCompatibleOptions()
                .verifyCustomWorktopModifications("OK", "Cut outs edge finish have been removed", "Edge finish have been modified")
                .worktopEditor(0, 25)
                .verifyWorktopCutOut(-140, -165, "", "", "", "200 mm", "", "")
                .cancelWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "WOOD OAK", "",true, "", "")
                .verifyCustomWorktopModifications("OK", "Edge finish have been removed")
                .worktopEditor(0, 25)
                .verifyWorktopCutOut(-140, -165, "", "", "", "200 mm", "", "")
                .cancelWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "ACRYLIC WHITE", "",true, "OK", "yes")

                //Scenario 7:  Change of edges
                .worktopEditor(0, 25)
                .addEdgeCut(-94, -160, "Rounded", "", "", "", "", "", "", "900 mm")
                .verifyRoundedEdgePresent(-80, -171)
                .verifyWorktopDimension(-80, -171, "120 mm")
                .changeEdgeProduct(-80, -171, "DKACRYLIC_NOEDGE", "")
                .validateWorktopEditor()
                .replaceProperty(0, 25, "Worktop", "LAMINATE BLACK", "",true, "", "")
                .showNonCompatibleOptions()
                .verifyCustomWorktopModifications("OK", "Cut outs edge finish have been removed", "Edge finish have been modified")
                .worktopEditor(0, 25)
                .verifyRoundedEdgePresent(-80, -171)
                .verifyWorktopDimension(-80, -171, "120 mm")
                .verifyEdgeProduct(-80, -171, "NOLAMINATE_PPEDGE", "")
                .validateWorktopEditor()

                //Scenario 8: Change of waterfalls
                //Scenario 9: Addition/Removal of joints
                .addProduct("U2DA80", true, true, false).translateProduct(50,100)
                .worktopEditor(90,130)
                .addJoint(135,8)
                .verifyJoint(132, -16, "430 mm")
                .addWaterfall(84,-17,"")
                .editWaterfall(84,-17)
                .moveWorktop(0,164, 0,140)
                .addSplitEdge(-116,18)
                .moveWorktop(-116,72, -70,72)
                .createCutOut(40, -90, "Circle", "", "", "", "", "200 mm")
                .validateWorktopEditor()
                .replaceProperty(85, 130, "Worktop", "ACRYLIC WHITE", "selected", true,"", "")
                .verifyCustomWorktopModifications("OK", "Edge finish have been modified", "Edge finish have been modified on waterfalls on waterfalls","Edge finish have been added on waterfalls on waterfalls");

    }

    @Test(alwaysRun = true, dependsOnMethods = {"worktopEditWTWithoutLosingCompatibleItemsTest"})
    public void resetAppSettings() throws IOException {
        //Revert app settings changes if something was modified
        if (appSettings != null) {
            Browser.switchToWindow(driver, secondTab);
            appSettings.resetAppSettingsParameter("bryo").logout();
        }
    }
}
