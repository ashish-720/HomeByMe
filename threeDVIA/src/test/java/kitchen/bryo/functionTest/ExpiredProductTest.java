package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ExpiredProductTest extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void expiredProductTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT_ExpireProduct_Test")
//		.modificationsOnProjectPage(" Desc" + UtilHBM.getDate(0, "dd_MM_yyyy"), "Expire Product Test")
		.openProject(0,"ODT_ExpireProduct_Test")
		.addProduct("CKT600", true, false, false)
		.checkProjectDetails("ODT_ExpireProduct_Test","")
		.checkExpiredProductRuleIn3D("expired_product_test product is expired")
		.replaceProperty(-83, 50, "façade", "metal_acier_semi_poli_01", "",true, "")
		.verifyReplaceProperty(-83, 50, "façade", "metal_acier_semi_poli_01")
//		.step4()
//		.clickDesignStep()
//		.verifyBusinessRulesList()
//		.backToDetails()
		.checkExpiredProductRuleIn3D("expired_product_test product is expired")
		.replaceExpiredProduct("U2DA80")
		.verifyBusinessRuleRemoved("expired_product_test product is expired")
		.undo(2)
		.checkExpiredProductRuleIn3D("expired_product_test product is expired");
		

	}

}