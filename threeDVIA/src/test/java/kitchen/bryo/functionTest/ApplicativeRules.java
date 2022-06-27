package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class ApplicativeRules extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void businessRulesTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("CKT600", true, false, false)
		.checkBusinessRuleShowIn3D("Worktop thickness", true)
		.replaceProperty(-112, -6, "Cooktop", "JEAN BAPTISTE", "",true, "")
		.verifyReplaceProperty(-112, -6,"Cooktop", "JEAN BAPTISTE")
		.verifyBusinessRuleRemoved("Worktop thickness")
		.openClose(-112, -6,-112, -6)
		.checkBusinessRuleShowIn3D("Area of worktop around the cooking unit", true)
		.position(-112, -6,"50 mm", "850 mm", "")
		.verifyPosition(-43, -0, "850 mm")
		.addProduct("U2DA80", true, false, false)
//		.position(-43, -0,"2524 mm", "2537 mm", "1 852,00")
//		.verifyPosition(-43, -0, "2537 mm")
		.addProduct("U2DA80", true, false, false)
		.verifyBusinessRuleRemoved("Area of worktop around the cooking unit")
		.rotateProjectView(5, "left")
		.twoDView()
		.threeDView()
		.addProduct("W6002", true, false, false)
		.duplicateProduct(-63, -87)
		.deleteProduct(-27, -89)
		.position(-63, -87, "3581 mm", "2387 mm", "")
		.verifyPosition(-108,-50, "2387 mm")
		
		.checkBusinessRuleShowIn3D("Item position", true)
		.position(-108,-50, "2387 mm", "3581 mm", "")
		.verifyPosition(-63, -87,"3581 mm")
		.verifyBusinessRuleRemoved("Item position")
		.saveProjectInStep3(signUpData, "BusinessRule_ODT_" + UtilHBM.getDate(0, "yyyyMMdd"),"MY BRYO KITCHEN created on_" + UtilHBM.getDate(0, "yyyyMMdd"))
		.closePlanner()
		.openMyProjectList()
		.searchProject("BusinessRule_ODT_" + UtilHBM.getDate(0, "yyyyMMdd"))
//		.openProject()
		.openProject(0,"BusinessRule_ODT_" + UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyPrice("")
		.verifyProductOnReOpen(-22, 27, "CKT600");
	}

}
