//package kitchen.bryo.functionTest;
//
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import hbm.planner.utility.Browser;
//import hbm.planner.utility.UtilHBM;
//import kitchen.bryo.pageObject.StartNow;
//
//public class FinalizeStepUndoRedo extends Browser {
//	@Test
//	public void undoRedoInFinalizeTest() throws InterruptedException {
//
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB").startFromScratch()
//		.step3()
//		.addProduct("GVARIO03", false, false, "1 510,00", "")
//		.step4()
//		.twoDView()
//		.undo(driver, 1)
//		.redo(driver, 1)
//		.threeDView()
//		.firstPersonView()
//		.undo(driver, 1)
//		.verifyView();
//		
//	}
//}
