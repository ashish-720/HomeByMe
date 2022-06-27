package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UsingHomeByMeFromScratch extends Browser {
	
	@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class)
	public void hbmProjectUsingScratchTest(SignUpData signUpData) {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.useHomeByMeProject()
		.clickHBMConnectLoginButton()
		.loginExitingUser(signUpData)
		.selectProjectForBryo("Project (32)", 0)
//		.loginForHBM(signUpData)
//		.selectHomeByMeProject("Project (32)")
		.selectFromSeveralRoom("Ground Floor", -185, -74)
		.step3()
		.twoDView()
		.threeDView()
		.verifyViewHeightIn3D("Default")
		.verifyPrice("0,00")
		.deleteProduct(48, -352)
		.deleteProduct(-494, -253)
		.verifyPrice("0,00")
		.twoDView()
		.threeDView()
		.deleteProduct(-60, 27)
		.deleteProduct(-62,126)
		.deleteProduct(3, -11)
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false);
	
	}
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class,dependsOnMethods = "hbmProjectUsingScratchTest")
	public void saveHBMProjectUsingScratchTest(SignUpData signUpData) {
		MakeItYours save=PageFactory.initElements(driver, MakeItYours.class);
		save.saveProjectInStep3(signUpData, "HBM_ODT_ScratchTest" + UtilHBM.getDate(0, "yyyyMMdd"), "HBM project from Scratch")
		.closePlanner()
		.openMyProjectList()
		.searchProject("HBM_ODT_ScratchTest" + UtilHBM.getDate(0, "yyyyMMdd"))
//		.openProject()
		.openProject(0, "HBM_ODT_ScratchTest" + UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyPrice("1 506,00")
		.verifyProductOnReOpen(-17, 47, "U2DA80");
//		.rotateProjectView(6, "right")
//		.zoomIn(6)
//		.verifyProductOnReOpen(247, 198, "External Product");
	}
}
