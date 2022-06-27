package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateProductClassicContributor extends Browser{

	@Test(dataProvider="cloudOpenIdCont", dataProviderClass=SignUpData.class)
	public void createProductClassicContributor(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("MAISONSDUMONDE")
		.createNewProduct()
		.setProductName("Lamp","cont")
		.setProductRef("Lamp","cont")
		.setProductType("Table lamps")
		.setBrand("MAISONS DU MONDE")
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
		.addMaterialReplacement(true,true,"abat jour","Default","Wood","odt_test_wood;odt_test_carpet")
		.addMaterialReplacement(true,true,"pied","Default","Wood","odt_test_wood;odt_test_carpet")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()
		
		.createNewProduct()
		.setProductName("Chair","cont")
		.setProductRef("Chair","cont")
		.setProductType("Chairs")
		.setBrand("MAISONS DU MONDE")
		.setProductDate()
		.setCommercialDesc("Chair_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("Chair", "Single","bm3")
		.uploadPicture("Chair")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,1100,1500)
		.addDimensionVariationDiscrete(true,true,"depth", "Default","850>P1;800>P2","800")
		.addDimensionVariationDiscrete(true,true,"width", "Default", "550>P1;600>P2","550")
		.addOptionBoolean(false,false,"packTripleBoolean","New", "false")
		.addOptionContinous(false,false,"packDoubleNumber","New",50,500,1000)
		.addOptionDiscrete(false,false,"packUnitNumber","New","50>P1;100>P3","50")
		.addMaterialReplacement(true,true,"pied","Default","Wood","odt_test_wood;odt_test_carpet")
		.addMaterialReplacement(true,true,"dossier","Default","Wood","odt_test_wood;odt_test_carpet")
		.addMaterialReplacement(true,true,"assise","Default","Wood","odt_test_wood;odt_test_carpet")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()

		.logout();
	}
}		
