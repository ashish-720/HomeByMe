package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Search extends Browser {
	@Test
	public void searchTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductThroughSearch("Vanity unit", "Vanity unit", true,false)
			.verifyProduct(-129, -37,"Vanity unit")
				.replaceProductFromEdit(-129, -37, "Vanity unit", true, false, false)
					.deleteProduct(-129,-37)
					.addProductThroughSearch("Shower", "Swing Door Shower", true, false)
					.verifyProduct(-124, -72,"Swing Door Shower")
					.deleteProduct(-124,-72)
					.undo(1)
					.position(-124,-72,"3100 mm","1550 mm","")
					.deleteProduct(15,-49)

		.addProductThroughSearch("Bathtub assembly", "Bathtub assembly", true,false)
			.verifySearchProduct(-92,-37,"Bathtub assembly")
					.deleteProduct(-92,-37)
					.undo(1)
			.replaceProductFromEdit(-92, -37, "Nadi bathtub", true, false, false)
			.verifyProduct(-92, -37, "Nadi bathtub")
					.deleteProduct(-92,-37)
				.addProductThroughSearch("Vanity unit", "Vanity unit",true,false)
			.verifySearchProduct(-123, -32,"Vanity unit")
				.deleteProduct(-123,-32)
				.undo(1)
				.position(-123,-32,"3560 mm","1000 mm","")
				.verifyProduct(65,-30,"Vanity unit")
				.deleteProduct(65,-30)

		.addProductThroughSearch("Shower", "Walk in Shower", true,false)
			.verifySearchProduct(-129, -37, "Walk in Shower")
				.position(-129,-37,"3100 mm","2500 mm","")
				.replaceProperty(-132, 16, "Shower Tray", "Shower Tray - Black", "",true, "")
				.verifyReplaceProperty(-132, 16, "Shower Tray", "Shower Tray - Black")
				.verifyReplaceProperty(-132, 16, "Shower Panel", "Left Shower Panel")
				.deleteProduct(-132,16)

		.addProductThroughSearch("Mirror","Bathroom mirror",true, false)
			.verifySearchProduct(-103,-105,"Bathroom mirror")
				.position(-103,-105,"2800 mm","1450 mm","")
				.position(7,-104,"1380 mm","1000 mm","")
				.deleteProduct(7,-81)
				.undo(1)

		.addProductThroughSearch("Toilets","Freestanding toilet",true,false)
			.verifySearchProduct(-129,-37,"Freestanding toilet")
				.position(-129,-37,"3617 mm","1000 mm","")
				.deleteProduct(64,-24)
				.undo(1)
				.deleteProduct(64,-24)


		.addProductThroughSearch("Toilets", "Suspended toilet", true,false)
			.verifySearchProduct(-121,-13,"Suspended toilet")
				.position(-121,-13,"3640 mm", "3000 mm","")
				.deleteProduct(-72,-22)
				.undo(1)
				.deleteProduct(-72,-22)

		.addProductThroughSearch("Toilets","Suspended toilet set",true, false)
			.verifySearchProduct(-123,-17,"Suspended toilet set")
				.openClose(-123,-17,-129,-37)
				.position(-123,-17,"3210 mm","1500 mm","")
				.deleteProduct(5,-22)
				.undo(1)
				.deleteProduct(5,-22)



		.addProductThroughSearch("Toilets","Ove suspended toilets",true, false)
			.verifySearchProduct(-123,-12,"Ove suspended toilets")
				.duplicateProduct(-123,-12)
				.position(-96,-16,"3226 mm", "1550 mm", "")
				.deleteProduct(-123,-12);







	}
}
