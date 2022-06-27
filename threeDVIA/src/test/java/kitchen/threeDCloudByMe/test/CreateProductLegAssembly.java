package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateProductLegAssembly extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createProductLegAssembly(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.createNewProduct()
		.setProductName("LegAssembly","bryoCont")
		.setProductRef("LegAssembly","bryoCont")
		.setProductType("Legs")
		.setProductDate()
		.setCommercialDesc("LegAssembly_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("LegAssembly", "Single","bma")
		.uploadPicture("LegAssembly")
		.addDimensionVariationContinuous(true,true,"height", "Default" ,10,80,1000)
		.addDimensionVariationContinuous(true,true,"boxDepth", "New", 100,600,1000)
		.addDimensionVariationContinuous(true,true,"boxWidth", "New", 100,600,1000)
		.addDimensionVariationContinuous(true,true,"legHeight", "New", 10,80,1000)
		.addDimensionVariationContinuous(true,true,"xLegOffset", "New", 10,80,1000)
		.addDimensionVariationContinuous(true,true,"yBackLegOffset", "New", 10,80,1000)
		.addDimensionVariationContinuous(true,true,"yFrontLegOffset", "New", 10,120,1000)
		.addOptionDiscrete(false,false,"leftLegOption","New", "1>P1;2>P2;3>P3;4>P4","1")
		.addOptionDiscrete(false,false,"rightLegOption","New","0>P1;1>P2;2>P3","1")
		.addProductReplacement(false,false,"leg","New","Legs","LEG_01;LEG_02;Leg_ODT_ref", "Legs")
		.editProductReplacement("leg",false,false,"","","Leg_ODT_ref","Leg_ODT_ref","")
		.goToPricing().addPricing()
		.clickSave()
		.clickBack()
		.logout();

	}
}