package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class EditMaterial extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void editMaterial(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToMaterialsPage()
		.openMaterial("Black", "Carpet", "bryoCont")
		.setMaterialName("Wood", "bryoCont")
		.setMaterialTag("Hardwood")
		.setMaterialColorTag("Brown")
		.setMaterialStylesTag("Casual")
		.goToMaterialRepresentationTab()
		.uploadModel("DarkRed")
		.uploadPicture("DarkRed")
		.clickSaveButton()
		.verifySuccess()
		.logout();
	}
}
