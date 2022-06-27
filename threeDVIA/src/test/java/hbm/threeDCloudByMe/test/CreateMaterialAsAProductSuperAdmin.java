package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateMaterialAsAProductSuperAdmin extends Browser{
	
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void createMaterialAsAProductSupAdmin(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.createNewProduct()
		.setProductName("Carpet","superadmin")
		.setProductRef("Carpet","superadmin")
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
