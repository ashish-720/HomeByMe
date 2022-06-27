package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import hr.web.pageObject.MyProject;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class DeleteProject extends Browser {

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void deleteProject(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.login(signUpData)
		.myProjects()
		.searchProjectName("saved without login")
		.deleteProject("saved without login", 3)
		.deleteNo()
		.searchProjectName("saved without login")
		.deleteProject("saved without login", 3)
		.deleteYes()
		.searchProjectName("HrRedWireGB")
		.deleteProject("HrRedWireGB", 5)
		.deleteYes()
		.searchProjectName("Duplicate-HR (copy)")
		.deleteProject("Duplicate-HR (copy)", 3)
		.deleteYes()
		.searchProjectName("ODT-HR-US")
		.deleteProject("ODT-HR-US", 5)
		.deleteYes()
		.searchProjectName("Duplicate-HR (copy)")
		.deleteProject("Duplicate-HR (copy)", 3)
		.deleteYes()
		.searchProjectName("Duplicate-HR (copy) (copy)")
		.deleteProject("Duplicate-HR (copy) (copy)", 3)
		.deleteYes()
//		for(int i=0; i<100; i++){
//			MyProject myProjects = PageFactory.initElements(driver, MyProject.class);
//			myProjects.searchProjectName("ODT-HR-US")
//			.deleteProject("ODT-HR-US", 7)
//			.deleteYes();
//		}
		;		
	}
}