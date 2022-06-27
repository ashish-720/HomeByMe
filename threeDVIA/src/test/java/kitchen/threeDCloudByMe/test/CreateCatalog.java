package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateCatalog extends Browser{
//
//	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
//	public void createCatalog(SignUpData signUpData)
//	{
//		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
//		login.login(signUpData)
//		.goToProductCatalogs()
//		.createNewCatalog("testCatalog", "bryo;HBMHfR", "UA80_bryoCont;Chair_bryoCont;Chair-HR_bryoCont;Lamp_bryoCont;Carpet_cont","bryoCont").logout();
//	}

//	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
//	public void createCatalog(SignUpData signUpData)
//	{
//		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
//		login.login(signUpData)
//				.switchTo3DCloudBeta()
//				.createNewCatalog("testCatalog", "UA80_bryoCont_ref_22_06_2022_07_36 > Chair_bryoCont_ref_22_06_2022_07_34 >" +
//						"Chair-HR_bryoCont_ref_22_06_2022_07_30 > Lamp-V1_bryoCont_ref_22_06_2022_07_58 > Carpet_cont_ref_22_06_2022_07_39")
//				.logoutfrom3DCloudBeta()
//				.logout();
//	}

	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)//, dependsOnMethods = "createCatalog"
	public void useCreatedCatalogInAppDistribution(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
				.switchTo3DCloudBeta()
				.gotoAppDistributions()
				.editAppDistribution("bryo")
		.ssss();
//				.createNewCatalog("testCatalog", "UA80_bryoCont_ref_22_06_2022_07_36 > Chair_bryoCont_ref_22_06_2022_07_34 >" +
//						"Chair-HR_bryoCont_ref_22_06_2022_07_30 > Lamp-V1_bryoCont_ref_22_06_2022_07_58 > Carpet_cont_ref_22_06_2022_07_39")
//				.logoutfrom3DCloudBeta()
//				.logout()

	}
}

