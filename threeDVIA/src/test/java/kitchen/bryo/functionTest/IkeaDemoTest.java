package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class IkeaDemoTest extends Browser {
	@Test(dataProvider = "ikeaLogin", dataProviderClass = SignUpData.class)
	public void ikeaDemoTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.ikeaLogin(signUpData)
//		.ikeaOpenMyProjectList().ikeaOpenProjectFromMyProjects("ODT_DEMO_SCENARIO20200414");
		start.ikeaLogin(signUpData)
		.setAppDist("Other...","jus-GB")
		.launchIKEAApp()
//		.addWaterSupply(-239,60).verifyWaterSupply()
		.nextStep()
		.waterSupplyPositionPopUp("No", 0, 0)

//		.skipLayoutNoReturnPickALayout()
//		.ikeaFindSolutions("3 - I Shaped kitchen", "")
		.ikeaFindSolutions("Template 01", "")
		.nextStepDesignYourKitchen("No", "No")
		.addProduct("Base cabinet Double Door with shelves 103", true, false, false)
		.ikeaSaveProjectInStep3(signUpData, "IKEA_DEMOTEST" + UtilHBM.getDate(0, "yyyyMMdd"),"Ikea test" + UtilHBM.getDate(0, "yyyyMMdd"))
		.ikeaClosePlanner()
		.ikeaOpenMyProjectList()
		.ikeaOpenProjectFromMyProjects("IKEA_DEMOTEST"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyProductOnReOpen(118, 101, "Base cabinet Double Door with shelves 103")
		.replaceProperty(118, 101, "Front", "Front Woody Light", "all", false, "", "")
		.verifyReplaceProperty(118, 101, "Front", "Front Woody Light")
		.ikeaClickSave(signUpData)
		.verifySavedProjectDetails("IKEA_DEMOTEST"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.ikeaClosePlanner()
//		.reloadApplication()
		.ikeaOpenMyProjectList()
		.ikeaOpenProjectFromMyProjects("IKEA_DEMOTEST"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyReplaceProperty(118, 101, "Front", "Front Woody Light");
		}
}												