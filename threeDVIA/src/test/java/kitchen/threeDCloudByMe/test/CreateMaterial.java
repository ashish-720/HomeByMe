package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateMaterial extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createMaterial(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToMaterialsPage()
		.createNewMaterial()
		.setMaterialName("Carpet", "bryoCont")
		.setMaterialTag("Carpet")
		.setMaterialColorTag("Black")
		.setMaterialStylesTag("Casual")
		.goToMaterialRepresentationTab()
		.uploadModel("Carpet")
		.uploadPicture("Carpet")
		.clickSaveButton()
		.verifySuccess()
		.logout();
	}
}
