package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

public class PriceTest3 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceTestThree(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA90", true, true, false)
		.customiseProduct(-120, -10, "600,00")
		.deleteComposeProduct(160, 0)
		.composeFurniturePrice("430,00")
		.deleteComposeProduct(160, 160)
		.composeFurniturePrice("250,00")
		.undoInCompose(1)
		.composeFurniturePrice("430,00")
		.deleteComposeProduct(160, 160)
		.composeFurniturePrice("250,00")
		.addItemInCabinet("DOUBLE DOOR 800", false)
		.composeFurniturePrice("530,00")
		.validateComposeFurniture()
		.verifyPrice("733,00");
	}
}
