package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ReOpenProject extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void reOpenProjectTest(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT Project")
		.openProject(0, "ODT Project")
		.checkProjectDetails("ODT Project","12 240,00")
		.viewHeightIn2D("On floor")
		.verifyViewHeightIn2D("On floor",103,-165,"CKT600")
		.clickFloorplan()
		.twoDView()
		.zoomIn(4)
		.displayAllItems(-300,-136)
		.step3()
		.step4()
		.clickShowImages()
		.verifyProjectPlans(7)
		.verifyProjectImages(4,4);
	}
}
