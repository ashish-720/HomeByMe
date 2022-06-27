package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class VerifyProductDetailsClassicReviewer extends Browser{

	@Test(dataProvider="cloudReview", dataProviderClass=SignUpData.class)
	public void verifyProductDetailsReviewer(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.openIdLogin(signUpData)
			.changeLE("Gautier")
			.pageVerification("reviewer","hbm")
			.productVerification("Lamp","hbm","Table lamps","cont")
			.openProduct("Lamp", "cont")
			.productNameReviewerVerify("Lamp","cont")
			.productRefReviewerVerify("Lamp", "cont")
			.commercialDescReviewerVerify("Lamp_comm_desc")
			.materialTagReviewerVerify("Steel")
			.colorTagReviewerVerify("Black")
			.roomTagReviewerVerify("Hallway")
			.stylesTagReviewerVerify("Asian")
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

