package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.IKEAMyProjects;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class IkeaDemoTest3 extends Browser {
	@Test(dataProvider = "ikeaLogin", dataProviderClass = SignUpData.class)
	public void ikeaDemoTest3(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.ikeaLogin(signUpData)
		.ikeaOpenMyProjectList();
		for (int i = 0; i < 2; i++) {
			IKEAMyProjects project = PageFactory.initElements(driver, IKEAMyProjects.class);
			project.ikeaDeleteProjectFromMyProjects("ID3")
			.verifyDuplicateDelete("Delete");
			System.out.println(i);
		}
		}
}												