package kitchen.threeDCloudByMe.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateProductBoxAssembly extends Browser {
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createProductBoxAssembly(SignUpData signUpData) throws IOException
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.createNewProduct()
		.setProductName("BoxAssembly","bryoCont")
		.setProductRef("BoxAssembly","bryoCont")
		.setProductType("Base cabinets")
		.setProductDate()
		.setCommercialDesc("BoxAssembly_comm_desc")
		.setMaterialsTag("Steel")
		.setColorTag("Black")
		.setStylesTag("Asian")
		.setRoomTag("Hallway")
		.goToProductRepresentation()
		.upload3DModel("BoxAssembly","Single", "bma")
		.uploadPicture("BoxAssembly")

		.addDimensionVariationDiscrete(false,false,"depth", "Default", "370>P1;600>P2","600")
		.addDimensionVariationDiscrete(false,false,"width", "Default", "400>P1;450>P2;500>P3;600>P4;800>P5;1000>P6;1200>P7","600")
		.addDimensionVariationDiscrete(false,false,"height", "Default", "800>P1","800")
		.addDimensionVariationContinuous(false,false,"legHeight", "New" ,0,80,800)
		.addDimensionVariationDiscrete(true,true,"yBackLegOffset", "New", "80>P1","80")
		.addDimensionVariationDiscrete(true,true,"xLegOffset", "New", "60>P1","60")
		.addDimensionVariationDiscrete(true,true,"coverPanelDepth", "New", "13>P1","13")
		.addDimensionVariationDiscrete(true,true,"yFrontLegOffset", "New", "100>P1","100")
		.addDimensionVariationContinuous(false,false,"zLeftCoverPanelAltitude", "New" ,0,80,80)
		.addDimensionVariationContinuous(false,false,"zRightCoverPanelAltitude", "New" ,0,80,80)
		.addDimensionVariationDiscrete(true,true,"sidePlinthOffset", "New", "60>P1","60")

		.addOptionDiscrete(false,false,"leftLegOption","New","1>P1;2>P2;3>P3;4>P4","1")
		.addOptionDiscrete(false,false,"rightLegOption","New","0>P1;1>P2;2>P3","1")
		.addOptionBoolean(true,true,"plinthOption","New", "True")
		.addOptionBoolean(false,false,"worktopOption","New", "True")
		.addOptionBoolean(false,false,"wallPanelOption","New", "False")
		.addOptionBoolean(true,true,"backCoverOption","New", "False")
		.addOptionBoolean(true,true,"leftCoverOption","New", "False")
		.addOptionBoolean(true,true,"rightCoverOption","New", "False")
		.addOptionBoolean(true,true,"autoFillerOption","New", "True")
		.addOptionBoolean(true,true,"wallEdgeStripOption","New", "False")
		.addOptionBoolean(false,false,"allowWallPanelAutoCompletion","New", "True")

		.addProductReplacement(true,true,"leg","New","Legs","LEG_01;LEG_02", "Legs")
		.addProductReplacement(true,true,"box","New","Boxes","PARIS_Base_Unit_01;PARIS_Cooktop_Base_Unit_02;PARIS_Sink_Base_Unit_01", "Boxes")
		.addProductReplacement(true,true,"backCoverPanel","New","Cover panels","MADELEINE_Back_Panel_Gris;CONCORDE_Back_Panel_Blanc;CONCORDE_Back_Panel_Noir;MADELEINE_Back_Panel_Beige;OPERA_Back_Panel_Beige;OPERA_Back_Panel_Gris", "Cover panels")
		.addProductReplacement(true,true,"leftCoverPanel","New","Cover panels","MADELEINE_Side_Panel_Gris;CONCORDE_Side_Panel_Blanc;CONCORDE_Side_Panel_Noir;MADELEINE_Side_Panel_Beige;OPERA_Side_Panel_Beige;OPERA_Side_Panel_Gris", "Cover panels")
		.addProductReplacement(true,true,"rightCoverPanel","New","Cover panels","MADELEINE_Side_Panel_Gris;CONCORDE_Side_Panel_Blanc;CONCORDE_Side_Panel_Noir;MADELEINE_Side_Panel_Beige;OPERA_Side_Panel_Beige;OPERA_Side_Panel_Gris", "Cover panels")

		.goToPricing().addPricing()
		.clickSave()
		.clickBack()

		.goToProductCatalogs()
		.createNewCatalog("bryoAssemblyEditor", "bryo", "BoxAssembly_bryoCont","bryoCont")
		.logout();
	}
}
