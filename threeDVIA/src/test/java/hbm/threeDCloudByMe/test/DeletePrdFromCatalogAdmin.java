package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;


public class DeletePrdFromCatalogAdmin extends Browser{
	
	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
		public void delPrdFromCat(SignUpData signUpData){
			Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
			login.login(signUpData)
			.goToProductCatalogs()
			.deletePrdFromCatalog("test", "Carpet_admin","admin")
			.logout();
	}
}
