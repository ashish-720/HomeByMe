package enterprise.bathroom.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RecoverProjectTest extends Browser {
	@Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
	public void recoverProjectTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("Vanity unit", true, false,false)
		.addProductBathroom("Vanity unit", true, false,false)
		.addProductBathroom("Bathtub assembly", true, false,false)
		.refreshApplication()
		.launchApp()
		.recoverProject("yes")
		.verifyProduct(33, 16, "Bathtub assembly");

	}

}
