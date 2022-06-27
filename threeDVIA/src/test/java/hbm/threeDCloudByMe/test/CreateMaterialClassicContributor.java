package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateMaterialClassicContributor extends Browser{
	
	@Test(dataProvider="cloudOpenIdCont", dataProviderClass=SignUpData.class)
	public void createMaterialClassicContributor(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("MAISONSDUMONDE")
		.goToMaterialsPage()
		.createNewMaterial()
		.setMaterialName("Carpet", "cont")
		.setBrand("MAISONS DU MONDE")
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
