package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateMaterialAsAProductClassicContributor extends Browser{
	
	@Test(dataProvider="cloudOpenIdCont", dataProviderClass=SignUpData.class)
	public void createMaterialAsAProductClassicContributor(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("MAISONSDUMONDE")
		.createNewProduct()
		.setProductName("Carpet","cont")
		.setProductRef("Carpet","cont")
		.setProductType("Wallpapers")
		.setBrand("MAISONS DU MONDE")
		.setProductDate()
		.setCommercialDesc("Carpet_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Casual")
		.goToProductRepresentation()
		.upload3DModel("Carpet","Single", "BM3MAT")
		.uploadPicture("Carpet")
		.clickSave()
		.clickBack()
		.logout();
	}
}
