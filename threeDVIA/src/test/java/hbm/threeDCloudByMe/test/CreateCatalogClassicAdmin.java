package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateCatalogClassicAdmin extends Browser{

	@Test(dataProvider="cloudOpenIdAdmin", dataProviderClass=SignUpData.class)
	public void createCatalogClassicAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("3DVIA")
		.goToProductCatalogs()
		.createNewCatalog("test", "HomeByMe", "UA80_admin;Carpet_admin;Chair_admin","admin")
		.logout();
	}
}