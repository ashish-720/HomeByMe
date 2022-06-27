package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class SaveReOpenEmptyProject extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void saveReOpenEmptyProjectTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList().createNewProjectFromMyProjectsList()
		.step3().saveProjectInStep3(signUpData, "ODT_EMPTY_PROJECT_TEST_" + UtilHBM.getDate(0, "yyyyMMdd"),"Empty Project created on" + UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyPrice("0,00")
		.verifyPriceInformation("0,00", "", "")
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_EMPTY_PROJECT_TEST_"+ UtilHBM.getDate(0, "yyyyMMdd"))
//		.openProject()
		.openProject(0, "ODT_EMPTY_PROJECT_TEST_"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.checkProjectDetails("ODT_EMPTY_PROJECT_TEST_"+ UtilHBM.getDate(0, "yyyyMMdd"),"0,00")
		.step4()
		.verifyEmptyPlansAndImages();
		
	}
}
