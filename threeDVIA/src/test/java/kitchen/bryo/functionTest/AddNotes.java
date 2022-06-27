package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddNotes extends Browser {
	@Test
	public void addNotesTest(){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("GVARIO03", true, false, false)
		.step4()
		.verifyStep4()
		.verifyPriceInStep4("1 510,00")
		/* Commneted this code as Description section in summary steps is removed
		 * 
		
		.addNotes("valid", UtilHBM.getProperty("bryo", "validAddNote"))
		.addNotes("invalid",UtilHBM.getProperty("bryo", "invalidAddNote"))
		.addNotesUsingShortCutKeys("valid", UtilHBM.getProperty("bryo", "validAddNote"))
 */

		//Test scenarios for KIT-2069 : As a user, I have clear icons for notes and item list
				//scenario 1: Icons clearly distinguishable in step 4
				.verifyItemNoteAndProductListIconsDistinguishable()
				//Scenario 2: Icons clearly distinguishable in step 3
				.clickDesignStep()
				.verifyItemNoteAndProductListIconsDistinguishable();
	}
}
