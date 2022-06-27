package kitchen.bryo.scenarioTest;
//package ikea.scenarioTest;
//
//import hbm.planner.utility.Browser;
//import hbm.planner.utility.UtilHBM;
//import ikea.kitchen.pageobject.FloorPlan;
//import ikea.kitchen.pageobject.MakeItYours;
//import ikea.kitchen.pageobject.StartNow;
//
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//public class ScenarioTestTwo extends Browser {
//	@Test
//	public void kitchenScenarioTest2() throws Exception {
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		
//		start.startDemo("en-GB").startFromScratch();
//		// HomePage home = PageFactory.initElements(driver, HomePage.class);
//		// home.selectStyle(0);
//		// StylePage style = PageFactory.initElements(driver, StylePage.class);
//		// style.tryInMyRoom();
//		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
//
//		// *****************CHANGE ROOM SHAPE************************
//		plan.roomShape("Change the room shape","open", 1);
//
//		// ********************EDIT ROOM DIMENSIONS**********************
//		plan.editWallDimension("IKEAScenarioWallEdit", "5100 mm","apply left")
//				.verifyWallProperty("IKEAScenarioWallEdit", "5100 mm");
//
//		// **************ADD and DELETE OPENINGS**********************
//		plan.openings("0", "Fixed windows");
//		MakeItYours design = PageFactory
//				.initElements(driver, MakeItYours.class);
//		UtilHBM.dragDropIkea("IKEA_SceanrioDragOpeningSource",
//				"IKEA_SceanrioDragOpeningDestination",
//				"IKEA_SceanrioDragOpeningFinalImg");
//		plan.editDoorWindowProperties("IKEA_SceanrioDragOpeningFinalImg","", "900 mm",
//				"850 mm", "","",0).verifyDoorWindowProperties(
//				"IKEA_SceanrioDragOpeningFinalImg","", "900 mm", "850 mm", "","");
//
//		// **********************STEP 3*************************************
//		plan.step3();
//		plan.severalRoomPopUp("","IKEA_ScenarioSelectRoom");
//		design.clickAndDrag("IkeaClickDragSourceImg",
//				"IkeaClickDragDestinationImg", "IkeaClickDragFinalImg");
//
//		// ***************CREATE KITCHEN**************
//
//		design.addCabinet("Corner filler piece for base unit",
//				"Filler strip angle");
//		design.addCabinet("UD2SA60", "Base Cabinets");
//		design.addAppliance("SPUDSA60", "Sinks");
//		design.addCabinet("UD2SA60", "Base Cabinets");
//		design.addAppliance("CKT600", "Cooktops");
////		design.addCabinet("UD2SA60", "Base Cabinets");
//	}
//}
