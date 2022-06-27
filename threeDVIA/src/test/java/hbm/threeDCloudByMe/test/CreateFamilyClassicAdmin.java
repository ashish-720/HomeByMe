package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateFamilyClassicAdmin extends Browser{

	@Test(dataProvider="cloudOpenIdAdmin", dataProviderClass=SignUpData.class)
	public void createFamilyClassicAdmin(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("3DVIA")
		.goToFamilyPage()
		.createNewFamily("Test_family", "UA80_admin;Carpet_admin","admin")
		.logout();
	}
}
