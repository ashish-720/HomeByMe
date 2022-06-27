package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateMaterialAdmin extends Browser{
	
	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
	public void createMaterialAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.goToMaterialsPage()
		.createNewMaterial()
		.setMaterialName("Carpet", "admin")
		.setBrand("GENERIQUE")
		.setMaterialTag("Carpet")
		.setMaterialColorTag("Black")
		.setMaterialStylesTag("Casual")
		.goToMaterialRepresentationTab()
		.uploadModel("Carpet")
		.uploadPicture("Carpet")
		.goToMaterialInformationTab()
		.clickSaveButton()
		.verifySuccess()
		.logout();
	}
	
}
