package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeletePrdFromFamily extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void deletePrdFromFamily(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToFamilyPage()
		.deletePrdFromFamily("Test_family", "Chair_bryoCont","bryoCont")
		.logout();
	}
}

 