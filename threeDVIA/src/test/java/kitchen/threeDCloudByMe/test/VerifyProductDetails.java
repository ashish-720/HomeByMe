package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class VerifyProductDetails extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void verifyProductDetails(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.pageVerification("bryoCont","bryo")
		.productVerification("Lamp","bryo","Table lamps","bryoCont")
		.openProduct("Lamp", "bryoCont")
		.productNameVerify("Lamp","bryoCont")
		.productRefVerify("Lamp", "bryoCont")
		.verifyProductBrand("Bryo")
		.commercialDescVerify("Lamp_comm_desc")
		.materialTagVerify("Steel")
		.colorTagVerify("Black")
		.roomTagVerify("Hallway")
		.stylesTagVerify("Asian")
		.goToProductRepresentation()
		.verifyUploadBm3()
		.dimensionVariationVerify("depth", "Depth", "550")
		.dimensionVariationVerify("width","Width", "750")
		.dimensionVariationVerify("height","Height","1100")
		.optionVerify("packUnitNumber", "packUnitNumber", "50")
		.optionVerify("packDoubleNumber", "packDoubleNumber","500")
		.optionVerify("packTripleBoolean", "packTripleBoolean","false")
		.materialVerify("pied", "pied", "2503")
		.materialVerify("abat jour", "abat jour", "2503");
	}
}