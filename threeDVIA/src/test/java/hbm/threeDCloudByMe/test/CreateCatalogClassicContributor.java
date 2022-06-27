package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateCatalogClassicContributor extends Browser{

	@Test(dataProvider="cloudOpenIdCont", dataProviderClass=SignUpData.class)
	public void createCatalogClassicContributor(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("MAISONSDUMONDE")
		.goToProductCatalogs()
		.createNewCatalog("test", "MaisonsDuMonde;HomeByMe", "Lamp_cont;Chair_cont;Carpet_cont","cont")
		.logout();
	}
}

