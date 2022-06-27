package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class PreciseRotation extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void preciseRotationTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false,false)
		.verifyProduct(-115,-20, "U2DA80")
		
		//KIT-2270 : As a user, I am presented with tips on how best to use the position tool
		.tooltipsForPosition(-115,-20)
		.position(-115,-20, "3137 mm", "10001 mm", "yes")
//		.verifyPosition(-604, -4, "5851 mm")
		.undo(3)
		.verifyPosition(-115,-20, "3137 mm")
		.position(-115,-20, "3137 mm", "2137 mm", "")
		.verifyPosition(-37, -16, "2137 mm")
		.position(-37,-16, "3351 mm", "2351 mm", "")
		.verifyPosition(-38, 54, "2351 mm")
		.preciseRotation(-38, 54, "90°","1101 mm")
		.verifyPreciseRotation(-38, 54, "0°")
		.step4()
		.verifyPriceInStep4("914,00");
//		.estimatedDelivery();
		

	}
}
