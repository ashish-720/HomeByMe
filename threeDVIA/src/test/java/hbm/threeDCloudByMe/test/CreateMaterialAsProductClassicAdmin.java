package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateMaterialAsProductClassicAdmin extends Browser{
	
	@Test(dataProvider="cloudOpenIdAdmin", dataProviderClass=SignUpData.class)
	public void createMaterialAsProductClassicAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("3DVIA")
		.createNewProduct()
		.setProductName("Carpet","admin")
		.setProductRef("Carpet","admin")
		.setProductType("Wallpapers")
		.setBrand("GENERIQUE")
		.setProductDate()
		.setCommercialDesc("Carpet_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Casual")
		.goToProductRepresentation()
		.upload3DModel("Carpet","Single", "BM3MAT")
		.uploadPicture("Carpet")
		.clickSave()
		.clickBack();
	}
}