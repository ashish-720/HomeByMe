package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class VerifyProductDetailsClassicAdmin extends Browser{
	
	@Test(dataProvider="cloudOpenIdAdmin", dataProviderClass=SignUpData.class)
	public void verifyProductDetailsClassicAdmin(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
		.changeLE("3DVIA")
		.pageVerification("admin","hbm")
		.productVerification("UA80","hbm","Base cabinets","admin")
		.openProduct("UA80", "admin")
		.productNameVerify("UA80","admin")
		.productRefVerify("UA80", "admin")
		.verifyProductBrand("GENERIQUE")
		.commercialDescVerify("UA80_comm_desc")
		.materialTagVerify("Steel")
		.colorTagVerify("Black")
		.roomTagVerify("Hallway")
		.stylesTagVerify("Asian")
		.goToProductRepresentation()
		.dimensionVariationVerify("depth", "Depth", "500")
		.dimensionVariationVerify("width","Width", "800")
		.dimensionVariationVerify("height","Height","800")
		.optionVerify("newOption3", "newOption3", "false")
		.optionVerify("newOption2", "newOption2","500")
		.optionVerify("newOption1", "newOption1","50")
		.materialVerify("caisson", "caisson", "1259")
		.materialVerify("façade", "façade", "2295")
		.materialVerify("plinthe", "plinthe", "1259")
		.materialVerify("plan de travail", "plan de travail", "2295")
		.materialVerify("poignée", "poignée", "1259");
	} 
}