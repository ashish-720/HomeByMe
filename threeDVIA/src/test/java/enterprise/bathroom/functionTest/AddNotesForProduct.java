package enterprise.bathroom.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddNotesForProduct extends Browser {
	@Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
	public void addNotesForProductTest(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("Vanity unit",true, false, false)
		.addProductBathroom("Bathtub assembly",true, false, false)
		.addProductBathroom("Walk in Shower",true, false, false)
		.verifyItemNoteAndProductListIconsDistinguishable()
		.itemNotes()
		.zoomIn(5)
		.addProjectNotes("Project Note test for Bathroom ODT demo")
		.addItemNotes(-211, 9, "Vanity unit","Note for Vanity unit")
		.addItemNotes(-85, 59, "Bathtub assembly", "Note for Bathtub assembly")
		.editItemNotes(-211, 9, "Vanity unit","Edited Note for Vanity unit")
		.deleteNote(125, -6, "Bathtub assembly")
		.addItemNotes(100, 21, "Walk in Shower", "Note for Walk in Shower")
		.validate()
		.itemNotesCount(4);
          
	}
}
