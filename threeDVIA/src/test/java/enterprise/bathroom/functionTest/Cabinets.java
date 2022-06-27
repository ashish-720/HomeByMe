package enterprise.bathroom.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Cabinets extends Browser {
	@Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
	public void cabinetTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("U2DA100", true, false,false)
		.verifyProduct(-96,-25, "U2DA100")
		.duplicateProductUsingShortCutKey(-96,-25)
		.deleteProductUsingShortCutKey(-37, -26)
		.openClose(-96,-25, -96,-25)
				.replaceProperty(-96,-25,"Right Cover Panel","MADELEINE|15528","",true,"")
		.verifyReplaceProperty(-96,-25, "Right Cover Panel","MADELEINE|15528")
		.replaceProperty(-96,-25, "Right Cover Panel", "CONCORDE|15488", "", true,"")
		.verifyReplaceProperty(-96,-25, "Right Cover Panel","CONCORDE|15488")
				.replaceProperty(-96,-25, "Right Cover Panel","OPERA|15534","",true,"")
		.verifyReplaceProperty(-96,-25, "Right Cover Panel","OPERA|15534");
	}
}
