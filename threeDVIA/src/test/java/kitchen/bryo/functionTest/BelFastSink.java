package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class BelFastSink extends Browser {
	@Test
	public void belFastSinkTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProductThroughSearch("SPUDSA60BEL","SPUDSA60BEL", true, false)
		.addProductThroughSearch("UD4SA80","UD4SA80", true, false)
		.customiseProduct(-43, -0, "")
		.editComposeReplaceProperty(151,40, "Front", "OPERA",false)
		.verifyComposeReplaceProperty(151,40,"Front", "OPERA")
		.validateComposeFurniture()
		.twoDView()
		.threeDView()
//		.worktopEditor(-19, -95)
//		.editWorktopYes()
		.position(-23, -1,"850 mm", "837 mm", "")
		.verifyPosition(-23, -1, "825 mm");
		
	}
}
