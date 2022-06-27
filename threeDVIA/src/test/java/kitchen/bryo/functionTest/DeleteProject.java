package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.MyProjects;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class DeleteProject extends Browser {

//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, priority=2)
//	public void deleteProjectFromDetailsPage(SignUpData signUpData) {
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB")
//		.login(signUpData)
//		.openMyProjectList()
//		.deleteProjectFromDetailsPage("copy of Duplicate ODT")
//		.openMyProjectList()
//		.verifyDuplicateDelete("Delete")
//		.closeMyProjects()
//		.logout();
//	}

//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, priority=1)
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void deleteProjectFromMyProjects(SignUpData signUpData) {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")	
		.login(signUpData)
		.openMyProjectList();
//		for (int i = 0; i < 40; i++) {
			MyProjects project = PageFactory.initElements(driver, MyProjects.class);
			project	
			.searchProject("ODT_Overhang_Test")
			.deleteProjectFromMyProjects(3, "ODT_Overhang_Test")
			.verifyDuplicateDelete("Delete")
			.searchProject("ODT_ShareProject")
			.deleteProjectFromMyProjects(3, "ODT_ShareProject")
			.verifyDuplicateDelete("Delete")
			.searchProject("SAVE_ODT_IN_STEP_4")
			.deleteProjectFromMyProjects(3, "SAVE_ODT_IN_STEP_4")
			.verifyDuplicateDelete("Delete")
			.searchProject("SAVE_ODT_IN_STEP_3")
			.deleteProjectFromMyProjects(3, "SAVE_ODT_IN_STEP_3")
			.verifyDuplicateDelete("Delete")
			.searchProject("SAVE_ODT_IN_STEP_2")
			.deleteProjectFromMyProjects(3, "SAVE_ODT_IN_STEP_2")
			.verifyDuplicateDelete("Delete")
			.searchProject("SAVE_ODT_IN_STEP_1")
			.deleteProjectFromMyProjects(3, "SAVE_ODT_IN_STEP_1")
			.verifyDuplicateDelete("Delete")
			.searchProject("ODT_EMPTY_PROJECT_TEST")
			.deleteProjectFromMyProjects(3, "ODT_EMPTY_PROJECT_TEST")
			.verifyDuplicateDelete("Delete")
			.searchProject("SAVE_OPEN_ODT_TEST")
			.deleteProjectFromMyProjects(3, "SAVE_OPEN_ODT_TEST")
			.verifyDuplicateDelete("Delete")
			.searchProject("Recover Logged in and saved project")
			.deleteProjectFromMyProjects(3, "Recover Logged in and saved project")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			//comenting on Mar 9, 2022
//			.searchProject("ODT_RENDERING_TEST")
//			.deleteProjectFromMyProjects(3, "ODT_RENDERING_TEST")
//			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			.searchProject("ODT_PickALayoutUpdateNeedsTest")
			.deleteProjectFromMyProjects(3, "ODT_PickALayoutUpdateNeedsTest")
			.verifyDuplicateDelete("Delete")					
			.searchProject("ODT_WaterFall_Test")
			.deleteProjectFromMyProjects(3, "ODT_WaterFall_Test")
			.verifyDuplicateDelete("Delete")
			.searchProject("ODT_CUSTOM_PRODUCT_TEST")
			.deleteProjectFromMyProjects(3, "ODT_CUSTOM_PRODUCT_TEST")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			.searchProject("RSE2_AUTOMATION_TEST")
			.deleteProjectFromMyProjects(3,"RSE2_AUTOMATION_TEST")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			.searchProject("BusinessRule_ODT")
			.deleteProjectFromMyProjects(3, "BusinessRule_ODT")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			.searchProject("ODT Project")
			.deleteProjectFromMyProjects(3, "ODT Project (copy)")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			.searchProject("HBM_ODT_TEST")
			.deleteProjectFromMyProjects(3, "HBM_ODT_TEST")
			.verifyDuplicateDelete("Delete")
			.searchProject("ODT_DEMO_SCENARIO")
			.deleteProjectFromMyProjects(3, "ODT_DEMO_SCENARIO")
			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
//			.searchProject("HBM_ODT_Scratch")
//			.deleteProjectFromMyProjects(3, "HBM_ODT_Scratch")
//			.verifyDuplicateDelete("Delete")
//			.closeMyProjects()
//			.openMyProjectList()
			;
//		}
//		MyProjects project = PageFactory.initElements(driver, MyProjects.class);
//		project.closeMyProjects()
//		.logout();
	}
}
