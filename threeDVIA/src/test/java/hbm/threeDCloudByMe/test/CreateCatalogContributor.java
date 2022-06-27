package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateCatalogContributor extends Browser{

	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createCatalogCont(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("MAISONSDUMONDE")
		.goToProductCatalogs()
		.createNewCatalog("test", "MaisonsDuMonde", "Lamp_cont;Chair_cont;Carpet_cont","cont")
		.logout();
	}
}

