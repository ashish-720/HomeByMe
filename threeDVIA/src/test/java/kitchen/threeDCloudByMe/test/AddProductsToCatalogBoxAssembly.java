package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class AddProductsToCatalogBoxAssembly extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void addProductToCatalogBoxAssembly(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToProductCatalogs()
		.openCatalog("testCatalog", "bryoAssemblyEditor").addproductsToExistingCatalog("BoxAssembly_bryoCont", "bryoCont").logout();
	}
}
