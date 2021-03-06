package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddNotesForProduct extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void addNotesForProductTest(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		
		.addProduct("GVARIO03",true, false, false)
		.addProduct("U2DA80",true, false, false)
		.addProduct("W6002",true, false, false)
		.verifyItemNoteAndProductListIconsDistinguishable()
		.itemNotes()
		.zoomIn(5)
		.addProjectNotes("Project Note test for ODT demo")
		.addItemNotes(-62, -56, "GVARIO03","Note for GVARIO03")
		.addItemNotes(4, 30, "U2DA80", "Note for U2DA80")
		.editItemNotes(-62, -56, "GVARIO03","Edited Note for GVARIO03")
		.deleteNote(4, 30, "U2DA80")
		.addItemNotes(14,-130, "W6002","Note for W6002")
		.validate()
		.itemNotesCount(3)	
		.customiseProduct(16, -153, "")
		.deleteComposeProduct(42,61)
		.addItemInCabinet("DOUBLE DOOR 800", false)
		.verifyAddedItemInCabinet(0, 65, "DOUBLE DOOR 800")
		.validateComposeFurniture()
		.verifyNoteNotifForCustomCabinet()
		.itemNotesCount(3)
		.itemNotes().verifyItemNoteForCustomProduct(19, -57,"Custom Product")
		.addItemNotes(22, 24, "U2DA80", "Note for U2DA80")
		.validate()
		.itemNotesCount(4)
		.itemNotes()
		.deleteNote(19, -57,"Custom Product")
		.validate()
		.itemNotesCount(3)

		.replaceProductFromEdit(-6, 1, "UD2SA80", true, false, false)
		.verifyReplaceProduct(-6, 1, "UD2SA80")
		.itemNotesCount(2)
		.itemNotes()
		.validate()
		.itemNotesCount(2)

		.clickFloorplan()
		.verifyItemNoteAndProductListIconsDistinguishable()
		.itemNotes()
		.addItemNotes(6, -73, "Custom Product", "Note for Custom Product")
		.validate()

		.itemNotesCount(3)
		.step4()
		.verifyItemNoteAndProductListIconsDistinguishable()
		.itemNotes()
		.verifyProjectNotes("Project Note test for ODT demo")
		.validate()
		.saveProjectInStep3(signUpData, "ODT_ItemNotes", "")
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_ItemNotes")
		.openProject(0, "ODT_ItemNotes")

		.itemNotesCount(3)
		.verifyItemNoteAndProductListIconsDistinguishable()
		.step4()
		.verifyItemNoteAndProductListIconsDistinguishable()
		.itemNotes()
		.addItemNotes(22, 24, "UD2SA80", "Note for UD2SA80")
		.validate()

		.itemNotesCount(4)
		.itemNotes()
		.verifyProjectNotes("Project Note test for ODT demo")
		.validate()
		.clickFloorplan()
		.step3()
		
		//KIT-1416 :As a user, I can create notes on more items
		.addProduct("Filler for Wall Unit",true, false, false)
		.twoDView()
		.position(-57, -2, "2450 mm", "1000 mm", "")
		.verifyPosition(109, 4, "1000 mm")
		.threeDView()
		.duplicateProduct(7, 21)
		.position(99, 51, "1724 mm", "1536 mm", "")
		.addProduct("W6002",true, false, false)
		.position(44, -67, "2124 mm", "1950 mm", "")
		.itemNotes()
		.addItemNotes(72,17, "Filler for Wall Unit", "Note for Filler for Wall Unit")
		.addItemNotes(2,25, "Filler for Base Unit", "Note for Base unit Filler created between two base cabinets")
		.addItemNotes(-5,-70, "Filler for Wall Unit", "Note for Wall unit Filler created between two wall cabinets")
		.validate()
		.itemNotesCount(7)
		.addProduct("CORNER FILLER BASE UNIT",true, false, false)
		.addProduct("CORNER FILLER WALL UNIT",true, false, false)
		.itemNotes()
		.addItemNotes(131, 60, "CORNER FILLER BASE UNIT", "Note for CORNER FILLER BASE UNIT")
		.addItemNotes(109,-66, "CORNER FILLER WALL UNIT", "Note for CORNER FILLER WALL UNIT")
		.validate()
		.itemNotesCount(9)
		
		
//		FUN119255 : As a user, I can add notes on linear products
		.clickPickALayout()
		  .lookingForNeedMapping("Update my needs", SelectMapping.class)
          .updateLayoutMapping("L-shaped")
          .updateCookingMapping("Integrated")
          .updateRefrigerationMapping("Integrated")
          .generateNewLayouts()
          .findSolutions("53 - L Shaped kitchen")
          .nextStepDesignYourKitchen("No", "Yes")
          .itemNotesCount(1)
          .itemNotes()
          .addItemNotesForLinears(-107, 8, "Worktop", "Note for WORKTOP")
          .viewHeight("Ground")
          .addItemNotesForLinears(-25, 43, "Plinth", "Note for PLINTH")
          .validate()
          .itemNotesCount(3)
          .twoDView().threeDView()
          .worktopEditor(-47, -63)
          .editWorktopYes()
          .createCutOut(-27, -180, "Rectangle", "150 mm", "150 mm", "no", "", "")
          .moveWorktop(-29, 187, -55, 187)
          .validateWorktopEditor()
          .itemNotesCount(3)
          .replaceProperty(-51,-56,"Worktop", "ACRYLIC WHITE", "",true, "", "")
          .confirmCustomMaterialChange("yes")
          .itemNotesCount(3)
          .itemNotes()
          .editItemNotes(-32, -103, "Worktop", "Note for worktop after replacing customized worktop")
          .validate()
          .itemNotesCount(3)
          .addProperty(-41, -97, "Wall Panel", "GEN_WP_OAK", "all", true)
          .addProductThroughSearch("Worktop", "LAMINATE BLACK", true,false)
          .editFreeStandingWorktopProperties(10, -60, true, "3000 mm", "500 mm", "900 mm")
          .itemNotes()
          .addItemNotesForLinears(-44, -124, "Wall panel", "Note for Wall Panel")
          .editItemNotes(57, 194, "Worktop", "Note for worktop after replacing customized worktop + freestanding worktop")
          .validate()
          .itemNotesCount(4)
          .deleteProduct(47, -25)
          .itemNotes()
          .deleteNote(-32, -103,"Worktop")
          .validate()
          .itemNotesCount(3)
          .duplicateProduct(123, -163)
          .duplicateProduct(123, -163)
          .addProperty(-65, -177, "Cornice", "MADELEINE", "selected", true)
          .addProperty(123, -163, "Deco Strip", "MADELEINE", "selected", true)
          .twoDView().threeDView()
          .itemNotes()
          .zoomIn(6)
          .viewHeight("High")
          .zoomIn(6)
          .addItemNotesForLinears(-28, 5, "Cornice", "Note for Cornice")
          .viewHeight("Worktop")
          .zoomOut(2)
          .addItemNotesForLinears(340, -100, "Deco strip", "Note for Decostrip")
          .validate().itemNotesCount(5)
          .twoDView().threeDView()
          .addProperty(-57, -133, "Deco Strip", "MADELEINE", "selected", true)
          .itemNotesCount(5)
          .addProperty(119, -118, "Cornice", "MADELEINE", "selected", true)
          .itemNotesCount(5)
          .itemNotes()
          .zoomIn(6)
          .viewHeight("High")
          .editItemNotes(270, 4, "Cornice", "Note for cornice by selecting another linear")
          .validate()
          .itemNotesCount(5)
          .wallPanelEditor(-112, 170)
          .editWallPanelYes()
          .addSplit(0, 0)
          .validateWallPanelEditor()
          .itemNotesCount(5)
          .replaceProperty(-45,50,"Wall Panel", "GB_WP_LAMINATE", "selected",true, "", "")
          .confirmCustomMaterialChange("yes")
          .itemNotesCount(5)
          .itemNotes()
          .editItemNotes(-23, 9, "Wall panel", "Note for wall panel after replacing customized wall panel")
          .validate()
          .itemNotesCount(5)
          .position(91, 81, "1738 mm", "1200 mm", "")
          .addProperty(125,119,"Wall Panel", "DK_WP_GLASS", "", true)
          .itemNotes()
          .editItemNotes(154, 62, "Wall panel", "Note for wall panel after replacing customized wall panel + seperating wall panel linear")
          .validate()
          .itemNotesCount(5);    
          
	}
}
