package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class EditAppDistrInCatalogSuperAdmin extends Browser {

	@Test(dataProvider = "cloudSupAdmin", dataProviderClass = SignUpData.class)
	public void EditAppDistrInContCatalogSuperAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
			.changeLE("MAISONSDUMONDE")
			.goToProductCatalogs()
			.openCatalog("test", "cont")
			.addAppDistribution("HomeByMe")
			.clickSave()
			.clickBackButton()
			.logout();

	}
}
