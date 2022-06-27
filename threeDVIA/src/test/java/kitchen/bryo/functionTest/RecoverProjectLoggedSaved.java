package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RecoverProjectLoggedSaved extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void recoverProjectLoggedSaved(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.saveProjectInStep3(signUpData, "Recover Logged in and saved project" + UtilHBM.getDate(0, "yyyyMMdd"), "")
		.addProduct("W6002", true, false, false)
		.refreshApplication()
		.openMyProjectList()
//		.openProjectFromMyProjects("Recover Logged in and saved project")
		.openProject(0,"Recover Logged in and saved project"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.recoverProject("yes")
		.verifyProduct(-111, -256, "W6002")
		.verifyPrice("1 754,00")
		.addProduct("W6002", true, false, false)
		.refreshApplication()
		.openMyProjectList()
//		.openProjectFromMyProjects("Recover Logged in and saved project")
		.openProject(0,"Recover Logged in and saved project"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.recoverProject("no")
		.verifyPrice("1 453,00");
		

	}

}
