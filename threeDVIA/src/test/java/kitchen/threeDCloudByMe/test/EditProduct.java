package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class EditProduct extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void editProduct(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.openProduct("Lamp", "bryoCont")
		.setProductName("Lamp-V1","bryoCont")
		.setProductRef("Lamp-V1","bryoCont")
		.setProductType("Base cabinets")
		.setProductDate()
		.setCommercialDesc("Lamp-V1_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
//		.edit3DModel("UA80", "bm3")
//		.editPicture("UA80")
		.deleteExistingVariations()
		.goToPricing().deletePrice().addPricing()
		.clickSave()
		.clickBack()
		.productVerification("Lamp-V1","bryo","Base cabinets","bryoCont")
		.openProduct("Lamp-V1", "bryoCont")
		.productNameVerify("Lamp-V1","bryoCont")
		.productRefVerify("Lamp-V1", "bryoCont")
		.commercialDescVerify("Lamp-V1_comm_desc")
		.materialTagVerify("Steel")
		.colorTagVerify("Black")
		.roomTagVerify("Hallway")
		.stylesTagVerify("Asian")
		.goToProductRepresentation()
		.verifyUploadBm3()
//		.clickBack()
		.logout();
	}
}
 