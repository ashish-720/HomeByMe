package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeleteMaterialAdmin extends Browser{
	
	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
	public void deleteMaterialAdmin(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToMaterialsPage()
		.deleteMaterial("Black", "Carpet","admin")
		.logout();
	}
}
