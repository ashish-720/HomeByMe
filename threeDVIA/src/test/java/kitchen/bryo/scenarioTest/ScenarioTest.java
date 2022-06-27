package kitchen.bryo.scenarioTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class ScenarioTest extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void kitchenScenarioTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.editWallDimension(0, -246, "4463 mm", "apply left").verifyWallProperty(0, -246, "4463 mm")
		.step3()
		.addProduct("GVARIO03", true, false, false)
		.addProduct("U2DA402", true, false, false)
		.addProduct("SPUDSA60", true, false, false)
		.addProductThroughSearch("UD4SA60", "UD4SA60", true, false)
		.addProduct("CKT600", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProduct("CORNER FILLER BASE UNIT", true, false, false)
		.addProduct("U2DA402", true, false, false)
		.addProductThroughSearch("W6002","W6002", true, false)
		.duplicateProduct(-108, -100)
		.addProduct("W3002", true, false, false)
		.addProduct("KET600CHXE", true, false, false)
		.addProduct("WG5002", false, false, false)
		.addProductThroughSearch("W4502", "W4502", true, false)
		.addProduct("WED6802", true, false, false)
		.addProduct("W6002", true, false, false)
		.addProduct("W2002", true, false, false)
		.replaceProperty(73, -9, "Worktop","LAMINATE CONCRETE", "",true, "")
		.verifyReplaceProperty(73, -9, "Worktop","LAMINATE CONCRETE")
		
		.checkBusinessRuleShowIn3D("Distance between tap hole and sink", true)
		.deleteProperty(-76, -6, "Sink")
		.verifyDeleteProperty(-76, -6, "Sink")
		.deleteProperty(-76, -6, "Faucet")
		.verifyDeleteProperty(-76, -6, "Faucet")
		.verifyBusinessRuleRemoved("Distance between tap hole and sink")
		
		
		.checkBusinessRuleShowIn3D("Worktop thickness", true)
		.replaceProperty(20, -11, "Cooktop","JEAN BAPTISTE", "", true,"")
		.verifyReplaceProperty(20, -11,"Cooktop", "JEAN BAPTISTE")
		.verifyBusinessRuleRemoved("Worktop thickness")

//		.checkBusinessRuleShowIn3D("Distance between hood and hob", true)
//		.position(19, -101,"542 mm", "668 mm", "11 409,90")
//		.verifyPosition(19, -101, "668 mm")
//		.verifyBusinessRuleRemoved("Distance between hood and hob")
	
		// *********************ADD SINK**************************************
		.addProduct("SPUDSA60", true, false, false)
		.verifyDeleteProperty(132, 73, "Sink")
		.verifyDeleteProperty(132, 73, "Faucet")
		.addProperty(132, 73, "Sink", "KALADIN", "selection", true)
		.verifyAddProperty(132, 73, "Sink", "KALADIN")
		.addProperty(132, 73, "Faucet", "BENJ", "", true)
		.verifyAddProperty(132, 73, "Faucet", "BENJ")
		.addProduct("U2DA80", true, false, false)
		// *************************PRODUCT MODIFICATION**********************
//		.productInfo(73, -9)
		.openClose(73, -9, 73, -9)
		.replaceProperty(76, -11, "Drawer Front","CONCORDE|14125", "selection", true,"")
		.verifyReplaceProperty(76, -11, "Drawer Front","CONCORDE|14125")
		.verifyPrice("13 558,40")
//		***********************COMPOSE FURNITURE**************************
		.customiseProduct(-29, -12, "794,00")
		.deleteComposeProduct(104,-33)
		.deleteComposeProduct(140,25)
		.deleteComposeProduct(144,87)
		.deleteComposeProduct(144,159)
		.addItemInCabinet("DOOR 800", false)
		.verifyAddedItemInCabinet(62, 65, "DOOR 800")
		.verifyComposeReplaceProperty(62, 65, "Front","CONCORDE|14119")
		.validateComposeFurniture()
		.verifyComposedProduct(-63, 11)
		// *******************WORKTOP EDITOR*********************************
		.worktopEditor(-22, 10)
		.editWorktopYes()
		.addJoint(162, 18)
		.createCutOut(-111, -157, "Rectangle", "150 mm", "150 mm", "", "", "")
		.verifyWorktopCutOut(-112, -155, "150 mm", "150 mm", "", "", "", "")
		.validateWorktopEditor()
		.verifyPrice("13 161,40")
		// ******************WALL PANEL EDITOR******************************
		.twoDView()
		.threeDView()
		.addProperty(-121,50, "Wall Panel", "DK_WP_GLASS", "all", true)
		.verifyAddProperty(-121,50, "Wall Panel","DK_WP_GLASS")
		.wallPanelEditor(-121,50)
		.editWallPanelYes()
		.addWallPanelEdgeCut(19, -9, "100 mm", "100 mm", "1500 mm", "no", "", "")
		.verifyWallPanelEdgeCut(19, -9, "100 mm")
		.createCutOutForWallPanel(-111, 24, "Rectangle", "150 mm", "150 mm", "no", "", "")
		.verifyCutOutForWallPanel(41, 34, "150 mm", "150 mm", "", "", "", "")
		.switchWallPanelLayer(-145, -10, "2594 mm")
		.createCutOutForWallPanel(-111, 24, "Rectangle", "150 mm", "150 mm", "no", "", "")
		.verifyCutOutForWallPanel(41, 34, "150 mm", "150 mm", "", "", "", "")
		.switchWallPanelLayer(282, 73, "3800 mm")
		.addWallPanelEdgeCut(-145, -10, "100 mm", "100 mm", "1500 mm", "no", "", "")
		.verifyWallPanelEdgeCut(-202, 21, "650 mm")
		.verifyPriceInWallPanel("4 423,20")
		.validateWallPanelEditor()
		.verifyPrice("17 584,60")
		// *************************SAVE PROJECT********************************
		.saveProjectInStep3(signUpData, "RSE2_AUTOMATION_TEST" + UtilHBM.getDate(0, "dd_MM_yyyy"),"MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "dd_MM_yyyy"))
		.verifyPrice("17 584,60")
		.step4()
		.clickDesignStep()
		.realisticImage(4)
		.closePlanner()
		
		// *************************RE-OPEN PROJECT********************************
		.openMyProjectList()
//		.openProjectDetailsPage("RSE2_AUTOMATION_TEST" + UtilHBM.getDate(0, "dd_MM_yyyy"))
//		.verifyRenderingImages(1)
//		.openProject()
//		.openProjectFromMyProjects("RSE2_AUTOMATION_TEST" + UtilHBM.getDate(0, "dd_MM_yyyy"))
		.openProject(0,"RSE2_AUTOMATION_TEST" + UtilHBM.getDate(0, "dd_MM_yyyy"))
		.verifyPrice("17 584,60")
		.verifyReplaceProperty(-24, 20, "Worktop", "LAMINATE CONCRETE")
		.verifyComposedProduct(-65, 14)
		.worktopEditor(-24, 20)
		.cancelWorktopEditor()
		.verifyPrice("17 584,60");
				
		

		// ***************DEBUG MENU*********************************
		// UtilHBM.waitFixTime(4500);
		// design.debugMenu("2D plans", "Plans Message");

	

	}
}
