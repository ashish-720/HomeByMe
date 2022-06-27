package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class IkeaDemoTest2 extends Browser {
	@Test(dataProvider = "ikeaLogin", dataProviderClass = SignUpData.class)
	public void ikeaDemoTest2(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.ikeaLogin(signUpData)
		.setAppDist("Other...","jus-GB")
		.launchIKEAApp()
		.step3()
		.addProductThroughSearch("Base Cabinet", "Base cabinet with 2 drawers 400", true, false)
		.twoDView()
		.position(0, 0, "3 mm", "0 mm", "")
		.zoomOut(6)
		.position(0, 0, "63 mm", "0 mm", "")
		.threeDView()
		.verifySearchProduct(-115,-33,"Base cabinet with 2 drawers 400")
		.worktopEditor(-115,-33)
		.editWorktopYes()
//		.createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
		.addJoint(-182, -150)
		.verifyJoint(-185, -175, "318 mm")
		.validateWorktopEditor()
		.verifyPrice("")
		.worktopEditor(-116,2)
		.verifyJoint(-185, -175, "318")
//		.verifyWorktopCutOut(-173, -173, "200 mm", "200 mm", "", "", "347 mm", "218 mm")
		.cancelWorktopEditor()
		.twoDView()
		.threeDView()
		.addProperty(-110,-20, "Wall panel", "Wall panel, matt off-white/stone effect ceramic", "", true)
		
		.verifyAddProperty(-110,-20,"Wall panel", "Wall panel, matt off-white/stone effect ceramic")
		.wallPanelEditor(-110,-20)
		.editWallPanelYes()
		.verifyWallPanelDimension(-217,-8, "1080 mm")
		.validateWallPanelEditor()
		.customiseProduct(-280,106, "")
		.editComposeReplaceProperty(151,40, "Front", "DrawerFront Dark Blue",false)
		.verifyComposeReplaceProperty(151,40, "Front","DrawerFront Dark Blue")
		.editComposeReplaceProperty(187,145, "Front", "DrawerFront Dark Blue",false)
		.verifyComposeReplaceProperty(187,145,"Front", "DrawerFront Dark Blue")
		.validateComposeFurniture()
		.verifyComposedProduct(-280,106)
		.ikeaSaveProjectInStep3(signUpData, "IKEA_DEMOTEST2" + UtilHBM.getDate(0, "yyyyMMdd"),"Ikea test" + UtilHBM.getDate(0, "yyyyMMdd"))
		.ikeaClosePlanner()
		.ikeaOpenMyProjectList()
		.ikeaOpenProjectFromMyProjects("IKEA_DEMOTEST2"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.worktopEditor(-292, 141)
//		.verifyWorktopCutOut(-173, -173, "200 mm", "200 mm", "", "", "347 mm", "218 mm")
		.verifyJoint(-162, -152, "349 mm")
		.cancelWorktopEditor()
		.twoDView().threeDView()
		.rotateProjectView(10, "left")
		.customiseProduct(-78,-18, "")
		
		.verifyComposeReplaceProperty(151,40, "Front","DrawerFront Dark Blue")
	
		.verifyComposeReplaceProperty(187,145,"Front", "DrawerFront Dark Blue")
		.cancelComposeFurniture()
		.ikeaClosePlanner();
		
		}
}												