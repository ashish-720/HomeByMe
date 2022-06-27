package kitchen.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Content;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateProduct extends Browser{
	
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createProductHBR(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.createNewProduct()
		.setProductName("Chair-HR","bryoCont")
		.setProductRef("Chair-HR","bryoCont")
		.setProductType("Chairs")
		.setBrand("BryoForHR")
		.setProductDate()
		.setCommercialDesc("Chair_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Living Room")
		.goToProductRepresentation()
		.upload3DModel("Chair", "Single","bm3")
		.uploadPicture("Chair")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
		.addDimensionVariationContinuous(true,false,"depth", "Default",400,550,800)
		.addDimensionVariationDiscrete(true,true,"width", "Default", "550>P1;600>P2","550")
		.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
		.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
		.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
		.addMaterialReplacement(true,true,"pied","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"dossier","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"assise","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack();
	}
	
	@Test(dependsOnMethods="createProductHBR")
	public void createNewProduct()
	{
		Content product = PageFactory.initElements(driver, Content.class);
		product
		.createNewProduct()
		.setProductName("Lamp","bryoCont")
		.setProductRef("Lamp","bryoCont")
		.setProductType("Table lamps")
		.setBrand("Bryo")
		.setProductDate()
		.setCommercialDesc("Lamp_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("Lamp","Single", "bm3")
		.uploadPicture("Lamp")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
		.addDimensionVariationDiscrete(true,true,"depth", "Default", "550>P1;600>P2","550")
		.addDimensionVariationDiscrete(true,true,"width", "Default", "600>P1;750>P2","750")
		.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
		.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
		.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
		.addMaterialReplacement(true,true,"abat jour","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"pied","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()
		
		.createNewProduct()
		.setProductName("Chair","bryoCont")
		.setProductRef("Chair","bryoCont")
		.setProductType("Chairs")
		.setBrand("Bryo")
		.setProductDate()
		.setCommercialDesc("Chair_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("Chair", "High","bm3")
		.uploadPicture("Chair")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
		.addDimensionVariationContinuous(true,false,"depth", "Default",400,550,800)
		.addDimensionVariationDiscrete(true,true,"width", "Default", "550>P1;600>P2","550")
		.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
		.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
		.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
		.addMaterialReplacement(true,true,"pied","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"dossier","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"assise","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()
		
		.createNewProduct()
		.setProductName("UA80","bryoCont")
		.setProductRef("UA80","bryoCont")
		.setProductType("Base cabinets")
		.setBrand("Bryo")
		.setProductDate()
		.setCommercialDesc("UA80_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("UA80","Single" ,"bm3")
		.uploadPicture("UA80")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,800,1500)
		.addDimensionVariationDiscrete(true,true,"depth", "Default","500>P1;550>P2","500")
		.addDimensionVariationDiscrete(true,true,"width", "Default","600>P1;800>P2","800")
		.addOptionBoolean(false,false,"newOption3","New", "false")
		.addOptionContinous(false,false,"newOption2","New",50,500,1000)
		.addOptionDiscrete(false,false,"newOption1","New","50>P1;100>P3","50")
		.addMaterialReplacement(true,true,"caisson","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"fa�ade","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"plinthe","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"plan de travail","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.addMaterialReplacement(true,true,"poign�e","Default","Steel", "metal_acier_poli_01;metal_acier_semi_poli_01")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()
		.logout();
	}
}