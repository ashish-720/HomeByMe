package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeleteCatalogSuperAdmin extends Browser{
	
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void deleteCatalogSA(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.goToProductCatalogs()
		.deleteCatalog("test","superadmin")
		.logout();
	}
}
