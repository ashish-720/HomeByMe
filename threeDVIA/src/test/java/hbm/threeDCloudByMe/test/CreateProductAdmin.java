package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	public class CreateProductAdmin extends Browser{
		
		@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
		public void createProductAdmin(SignUpData signUpData)
		{
			Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
			login.login(signUpData)
			.changeLE("3DVIA")
			.createNewProduct()
			.setProductName("UA80","admin")
			.setProductRef("UA80","admin")
			.setProductType("Base cabinets")
			.setBrand("GENERIQUE")
			.setProductDate()
			.setCommercialDesc("UA80_comm_desc")
			.setMaterialsTag("Steel")
			.setColorTag("Black")
			.setStylesTag("Asian")
			.setRoomTag("Hallway")
			.goToProductRepresentation()
			.upload3DModel("UA80","Low","bm3")
			.uploadPicture("UA80")
			.addDimensionVariationContinuous(true,true,"height", "Default" ,10,800,1500)
			.addDimensionVariationDiscrete(true,true,"depth", "Default","500>P1;550>P2","500")
			.addDimensionVariationDiscrete(true,true,"width", "Default","600>P1;800>P2","800")
			.addOptionBoolean(false,false,"newOption3","New", "false")
			.addOptionContinous(false,false,"newOption2","New",50,500,1000)
			.addOptionDiscrete(false,false,"newOption1","New","50>P1;100>P3","50")
			.addMaterialReplacement(true,true,"caisson","Default","Steel","Acier semi poli;Acier brossé")
			.addMaterialReplacement(true,true,"façade","Default","Plastic","pvc_01_vert_pomme_04;pvc_01_vert_06")
			.addMaterialReplacement(true,true,"plinthe","Default","Steel","Acier semi poli;Acier brossé")
			.addMaterialReplacement(true,true,"plan de travail","Default","Plastic","pvc_01_vert_pomme_04;pvc_01_vert_06")
			.addMaterialReplacement(true,true,"poignée","Default","Steel","Acier semi poli;Acier brossé")
			.goToPricing().addPricing()
			.clickSave()
			.clickBack()
			.logout();
		}
}		
