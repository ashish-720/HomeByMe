//package kitchen.bryo.functionTest;
//
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import hbm.planner.dataobject.SignUpData;
//import hbm.planner.utility.Browser;
//import kitchen.bryo.pageObject.StartNow;
//
//public class ContactACoWorker extends Browser {
//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
//	public void contactCoWorkerTest(SignUpData signUpData) throws InterruptedException {
//
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.login(signUpData)
//		.openMyProjectList()
//		.openProjectFromMyProjects("ODT Project")
//		.verifyPrice("12 142,00")
//		.checkProjectDetails("ODT Project","€ 12 142,00")
//		.step4()
//		.verifyPriceInStep4("12 142,00")
//		.verifyProjectTitleDetails()
////		.coworker()
//		.twoDView()
//		.zoomIn(4)
//		.undo(driver, 1)
//		.verifyView()
//		.redo(driver, 1)
//		.verifyView()
//		.printTestInStep4(4,9);
//		
//	}
//}
