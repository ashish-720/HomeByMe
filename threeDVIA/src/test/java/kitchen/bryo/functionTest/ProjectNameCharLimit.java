package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectNameCharLimit extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)

	public void projectNameCharLimit(SignUpData signUpData) {

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
//		.saveProjectInStep1(signUpData,"My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen proj","")
//		.renameProject("My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen pro","");

		.saveProjectInStep1(signUpData, UtilHBM.getProperty("bryo", "saveProMoreThan300Char"), "")
		.renameProject(UtilHBM.getProperty("bryo", "saveProExact300Char"), "")
		.closePlanner()
		.openMyProjectList()
		.duplicateProject("My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My k...", 0)
		.deleteProjectFromMyProjects(0, "My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My kitchen My k...");

	}
}
