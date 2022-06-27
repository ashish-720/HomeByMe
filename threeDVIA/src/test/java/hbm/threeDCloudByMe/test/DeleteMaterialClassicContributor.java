
package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeleteMaterialClassicContributor extends Browser{

	@Test(dataProvider="cloudOpenIdCont", dataProviderClass=SignUpData.class)
	public void deleteMaterialContributor(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.goToMaterialsPage()
		.deleteMaterial("Black", "Carpet","cont")
		.logout();
	}
}

