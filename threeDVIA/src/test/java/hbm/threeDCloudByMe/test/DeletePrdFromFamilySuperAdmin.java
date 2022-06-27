package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeletePrdFromFamilySuperAdmin extends Browser{
	
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
		public void delPrdFromFamSA(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.goToFamilyPage()
		.deletePrdFromFamily("Test_family", "Carpet_superadmin","superadmin")
		.logout();
	}
}

