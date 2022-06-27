package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.CreateData;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateMaterialContributor extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createMaterialContributor(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
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
