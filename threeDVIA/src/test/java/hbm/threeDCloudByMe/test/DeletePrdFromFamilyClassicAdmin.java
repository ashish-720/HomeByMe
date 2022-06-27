package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeletePrdFromFamilyClassicAdmin extends Browser{

	@Test(dataProvider="cloudOpenIdAdmin", dataProviderClass=SignUpData.class)
	public void deletePrdFromFamilyClassicAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("3DVIA")
		.goToFamilyPage()
		.deletePrdFromFamily("Test_family", "Carpet_admin","admin")
		.logout();
	}
}

