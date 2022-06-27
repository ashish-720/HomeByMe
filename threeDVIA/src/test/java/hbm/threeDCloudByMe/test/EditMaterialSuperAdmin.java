package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EditMaterialSuperAdmin extends Browser{

	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void editMaterialSA(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToMaterialsPage()
		.openMaterial("Black", "Carpet", "superadmin")
		.setMaterialName("Wood", "superadmin")
		.setMaterialTag("Hardwood")
		.setMaterialColorTag("Brown")
		.setMaterialStylesTag("Casual")
		.goToMaterialRepresentationTab()
		.uploadModel("Wood")
		.uploadPicture("Wood")
		.clickSaveButton()
		.verifySuccess()
		.logout();
	}
}