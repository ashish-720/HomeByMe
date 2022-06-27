package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class GenericPlinth extends Browser {
	@Test
	public void genericPlinthTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().step3()
				// Test scenarios for KIT-2500 sub-task KIT-2503
				.addProduct("U2DA80", true, false, false)
				// scenario : select the plinth “MADELEINE beige” (this is a generic plinth) with the default leg (the black one)
				.replaceProperty(-106, -28, "Plinth", "leg|13805", "", true,"")
				
				.replaceProperty(-106, -28, "Plinth", "MADELEINE|15771", "",true, "")

				// scenario : Go to the item list , it should contain “Plinth_80” product in the list
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:Plinth_80 > Price:€ 50,00 > Quantity:1 ", "1")
				
				// scenario : Change the legs to the white one (adjustable stainless steel feet) and select the plinth “MADELEINE beige”
				.replaceProperty(-106, -28, "Plinth", "Leg|17493", "",true, "")
				.replaceProperty(-106, -28, "Plinth", "MADELEINE|15771", "",true, "")
				
				// scenario : Go to the item list , it should contain “Plinth_100” product in the list
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:Plinth_100 > Price:€ 150,00 > Quantity:1 ", "1")
				
				.deleteProduct(-106, -28)
			
				// FUN118566:As a user, I can add, remove and edit independently legs and plinths on cabinets
				// scenario 1:add a few base cabinets (of any "ground" cabinet) in the project, connected together
				.addProduct("U2DA80", true, false, false)
				.addProduct("U2DA80", true, false, false)
				
				.viewHeightIn3D("Ground")
				// check that there is a "delete" button available for the plinth option, and click on it
				.deleteProperty(-106, -28, "Plinth")
				// since the plinth option is linked to the leg option (that cannot be removed on these cabinets), the option is "replaced" by the current selected leg, and a "replace" button is available to select a plinth
				.verifyReplaceProperty(-106, -28, "Plinth", "leg")
		
				.twoDView()
				.emptyRoom(222, 184, "Kitchen", "16.0 m²", "yes")
				.threeDView()
				// scenario 2:add a W4501 (it is a Wall Cabinet)
				.addProductThroughSearch("W4501", "W4501", true, false)
				
				.viewHeightIn3D("Default")
				
				//altitude lower than 300mm
				.position(-160, -30, "1480 mm", "300 mm", "")
				
				//check that there is a plinth option available when the cabinet has an altitude lower than 300mm
				//click on the "add" button to add a plinth, 
				.addProperty(-160, 107, "plinth", "CONCORDE|15774", "all", true)
				.verifyAddProperty(-160, 107, "plinth", "CONCORDE|15774")
				//"replace" to set another plinth,
				.replaceProperty(-160, 107, "plinth", "OPERA|15779", "all", true,"")
				.verifyReplaceProperty(-160, 107,"plinth", "OPERA|15779")
				// and "delete" to remove it.
				.deleteProperty(-160, 107, "plinth")
				.verifyDeleteProperty(-160, 107, "plinth")
				.undo(5)
				//if a plinth is set on the W4501, and if you move the cabinet altitude, the plinth height should update accordingly.
				.position(-160, 107, "50 mm", "400 mm", "")
				.position(-126, 114, "300 mm", "150 mm", "")
				.verifyReplaceProperty(-126, 114,"plinth", "OPERA|15779")
				//it the cabinet altitude becomes greater than 300mm, the plinth option is automatically removed
				.position(-126, 114, "150 mm", "301 mm", "")
				.verifyPlinthPropertyRemoved(-126, 114)
		
				//FUN118342 : As a user, I want the z position of the cabinet configurator components to be updated according to the leg height
				//Visual verification not possible : (Found alternative by verifying custom worktop height)
				.twoDView()
				.emptyRoom(222, 184, "Kitchen", "16.0 m²", "yes")
				.threeDView()
				.addProductThroughSearch("U2DA80", "U2DA80", true, false)
				.replaceProperty(-106, -28, "Worktop", "ACRYLIC WHITE", "",true, "")
				.worktopEditor(-106, -28)
				.editWorktopYes()
				.createCutOut(-177, -186, "Rectangle", "100 mm", "100 mm", "", "", "")
				.validateWorktopEditor()
				.verifyCustomWorktopDimensions(-9, -27, "880 mm")
				.deleteProduct(-9, -27)
				.addProperty(-11, 16, "Worktop", "ACRYLIC WHITE", "", true)
				.replaceProperty(-11, 16, "Plinth", "Leg|17493", "",true, "")
				.worktopEditor(-11, 16)
				.editWorktopYes()
				.createCutOut(-200, -215, "Rectangle", "100 mm", "100 mm", "", "", "")
				.validateWorktopEditor()
				.verifyCustomWorktopDimensions(-11, 16, "900 mm");
				
	}
}
