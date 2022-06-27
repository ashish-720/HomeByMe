package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class VerifyProductDetailsSuperAdmin extends Browser{
	
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)
	public void verifyProductDetailsSupAdmin(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.pageVerification("superadmin","hbm")
		.productVerification("Lamp","hbm","Table lamps","superadmin")
		.openProduct("Lamp", "superadmin")
		.productNameVerify("Lamp","superadmin")
		.productRefVerify("Lamp", "superadmin")
		.verifyProductBrand("GENERIQUE")
		.commercialDescVerify("Lamp_comm_desc")
		.materialTagVerify("Steel")
		.colorTagVerify("Black")
		.roomTagVerify("Hallway")
		.stylesTagVerify("Asian")
		.goToProductRepresentation()
		.dimensionVariationVerify("depth", "Depth", "550")
		.dimensionVariationVerify("width","Width", "750")
		.dimensionVariationVerify("height","Height","1100")
		.optionVerify("packUnitNumber", "packUnitNumber", "50")
		.optionVerify("packDoubleNumber", "packDoubleNumber","500")
		.optionVerify("packTripleBoolean", "packTripleBoolean","false")
		.materialVerify("pied", "pied", "2295")
		.materialVerify("abat jour", "abat jour", "1259");	
	}
}