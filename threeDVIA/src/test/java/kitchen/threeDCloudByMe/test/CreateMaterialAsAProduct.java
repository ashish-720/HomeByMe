package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateMaterialAsAProduct extends Browser{
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createMaterialAsAProductBryo(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.createNewProduct()
		.setProductName("Carpet","cont")
		.setProductRef("Carpet","cont")
		.setProductType("Wallpapers")
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
		
		.createNewProduct()
		.setProductName("Carpet-HBR","cont")
		.setProductRef("Carpet-HBR","cont")
		.setBrand("BryoForHR")
		.setProductType("Wallpapers")
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
