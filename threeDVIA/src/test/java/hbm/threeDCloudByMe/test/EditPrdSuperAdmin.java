package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class EditPrdSuperAdmin extends Browser{
	
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void editProductSA(SignUpData signUpData){
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.openProduct("Lamp", "superadmin")
		.setProductName("LampV1","superadmin")
		.setProductRef("LampV1","superadmin")
		.setProductType("Base cabinets")
		.setProductDate()
		.setCommercialDesc("LampV1_comm_desc")
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
		.productVerification("LampV1","bryo","Base cabinets","superadmin")
		.openProduct("LampV1", "superadmin")
		.productNameVerify("LampV1","superadmin")
		.productRefVerify("LampV1", "superadmin")
		.commercialDescVerify("LampV1_comm_desc")
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