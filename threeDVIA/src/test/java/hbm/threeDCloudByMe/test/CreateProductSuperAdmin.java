package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	public class CreateProductSuperAdmin extends Browser{
		
		@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
		public void createProductSA(SignUpData signUpData)
		{
			Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
			login.login(signUpData)
			.changeLE("3DVIA")
			.createNewProduct()
			.setProductName("Lamp","superadmin")
			.setProductRef("Lamp","superadmin")
			.setProductType("Table lamps")
			.setBrand("GENERIQUE")
			.setProductDate()
			.setCommercialDesc("Lamp_comm_desc")
			.setMaterialsTag("Steel")
			.setColorTag("Black")
			.setStylesTag("Asian")
			.setRoomTag("Hallway")
			.goToProductRepresentation()
			.upload3DModel("Lamp","High", "bm3")
			.uploadPicture("Lamp")
			.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
			.addDimensionVariationDiscrete(true,true,"depth", "Default", "550>P1;600>P2","550")
			.addDimensionVariationDiscrete(true,true,"width", "Default", "600>P1;750>P2","750")
			.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
			.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
			.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
			.addMaterialReplacement(true,true,"abat jour","Default","Steel","Acier semi poli;Acier brossé")
			.addMaterialReplacement(true,true,"pied","Default","Plastic", "pvc_01_vert_pomme_04;pvc_01_jaune_02")
			.goToPricing().addPricing()
			.clickSave()
			.clickBack()
			
			.createNewProduct()
			.setProductName("Chair","superadmin")
			.setProductRef("Chair","superadmin")
			.setProductType("Chairs")
			.setBrand("GENERIQUE")
			.setProductDate()
			.setCommercialDesc("Chair_comm_desc")
			.setMaterialsTag("Steel")
			.setColorTag("Black")
			.setStylesTag("Asian")
			.setRoomTag("Hallway")
			.goToProductRepresentation()
			.upload3DModel("Chair","High", "bm3")
			.uploadPicture("Chair")
			.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
			.addDimensionVariationDiscrete(true,true,"depth", "Default","850>P1;800>P2","800")
			.addDimensionVariationDiscrete(true,true,"width", "Default", "550>P1;600>P2","550")
			.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
			.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
			.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
			.addMaterialReplacement(true,true,"pied","Default","Steel","Acier semi poli;Acier brossé")
			.addMaterialReplacement(true,true,"dossier","Default","Steel","Acier semi poli;Acier brossé")
			.addMaterialReplacement(true,true,"assise","Default","Plastic","pvc_01_vert_pomme_04;pvc_01_vert_06")
			.goToPricing().addPricing()
			.clickSave()
			.clickBack()

			.logout();
		}
}