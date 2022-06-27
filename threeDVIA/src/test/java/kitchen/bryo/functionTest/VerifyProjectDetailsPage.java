//package kitchen.bryo.functionTest;
//
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import hbm.planner.dataobject.SignUpData;
//import hbm.planner.utility.Browser;
//import hbm.planner.utility.UtilHBM;
//import kitchen.bryo.pageObject.StartNow;
//
//public class VerifyProjectDetailsPage extends Browser {
//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
//
//	public void verifyProjectDetailsTest(SignUpData signUpData){
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB")
//		.login(signUpData)
//		.openMyProjectList()
//		.searchProject("ODT Project")
//		.modificationsOnProjectPage(" Desc" + UtilHBM.getDate(0, "yyyyMMdd"), "Dummy Text")
//		.verifyAddNotes("Dummy Text")
//		.verifyMediaOnProjectPage(4, 9)
//		.goToMyProjects()
//		.searchProject("ODT_ExpireProduct_Test")
//		.modificationsOnProjectPage(" Desc" + UtilHBM.getDate(0, "yyyyMMdd"), "Expire Product Test")
//		.verifyAddNotes("Expire Product Test");
//		
//	}
//}
