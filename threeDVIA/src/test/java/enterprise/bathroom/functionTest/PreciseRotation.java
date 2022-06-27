package enterprise.bathroom.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PreciseRotation extends Browser {
	@Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
	public void preciseRotationTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("Swing Door Shower", true, false,false)
		.verifyProduct(-115,-20, "Swing Door Shower")
		
		//KIT-2270 : As a user, I am presented with tips on how best to use the position tool
		.tooltipsForPosition(-115,-20)
		.position(-115,-20, "3100 mm", "1500 mm", "yes")
				.undo(3)
		.verifyPosition(-115,-20, "3100 mm")
		.position(-115,-20, "3100 mm", "1800 mm", "")
		.verifyPosition(-12, -37, "1800 mm")
		.preciseRotation(-12, -37, "90°","1310 mm")
		.verifyPreciseRotation(-12, -37, "0°");


	}
}
