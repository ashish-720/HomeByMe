package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//KIT=1588 : As a user, I can edit corner cabinets in the cabinet editor - SDA6
public class EditCornerCabinetsInCabinetEditor extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void editCornerCabinetsInCabinetEditorTest(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .verifyPrice("0,00")
                .twoDView().threeDView()
//		scenario 1 : 1 Door left/right corner base cabinet (with 128cm carousel)
//    		Open the kitchen planner and go to “design your kitchen” step.
//    		Add a 1 door left/right corner base cabinet
//    		Access to cabinet editor (“modify” button)
//    		Remove the carousel and the door from the standard model
//    		Add the same guests back
//    		Replace the door
//    		Change handle orientation
//    		Replace the handle
//    		Remove the carrousel
//    		Add 1 white shelf (128 cm shelf)
//    		Move the shelf to another free anchor point
//    		Add 1 black shelf (128 cm shelf) - optional step depending on the availability of black shelf
//    		Move the shelf to another free anchor point
//    		Add shelves until the cabinet is full (128 cm shelves)
//    		Remove the 80 cm door and add two 40 cm doors
                .addProduct("UEDBD10060R2_KP8500", true, true, false)
                .customiseProduct(-90, -10, "")
                .deleteComposeProduct(140,40)
                .deleteComposeProduct(130,-15)
                
                .addItemInCabinet("CAROUSEL_02_KP8500", false)
                .verifyAddedItemInCabinet(130,-15, "CAROUSEL_02_KP8500")
                .addItemInCabinet("KP8500_DOOR_800", false)
                .verifyAddedItemInCabinet(140,40, "KP8500_DOOR_800")
                .editComposeReplaceProperty(140,40, "Front", "MADELEINE|13699",false)
                .verifyComposeReplaceProperty(140,40, "Front","MADELEINE|13699")
                .handleOrientation(140,40, "Horizontal")
                .verifyHandleOrientation(140,40,"Horizontal")
                .rotateView(140,40,-50,0)
                .deleteComposeProduct(55,55)
                
                .addItemInCabinet("UTRUSTA_SHELF_1280_W", false)
                .verifyAddedItemInCabinet(75,-50, "UTRUSTA_SHELF_1280_W")
                .elevateProduct(75,-50,75,30)
                .verifyAddedItemInCabinet(95,-15, "UTRUSTA_SHELF_1280_W")
                .deleteComposeProduct(-60,70)
                .addItemInCabinet("KP8500_DOOR_400", false)
                .addItemInCabinet("KP8500_DOOR_400", false)
                .verifyAddedItemInCabinet(-60,10, "KP8500_DOOR_400")
                .verifyAddedItemInCabinet(-60,100, "KP8500_DOOR_400")
                .validateComposeFurniture()

//		Scenario 2 : 1 Door left corner wall cabinet (with shelves)
//		This test scenario can also be performed on the 1 Door right corner wall cabinet
//		Open the kitchen planner and go to “design your kitchen” step.
//				Add a 1 door left/right corner wall cabinet
//		Access to cabinet editor (“modify” button)
//		Remove the door and shelves from the standard model
//		Add the same guests back
//		Replace the door
//		Change handle orientation
//		Replace the handle
//		Move the shelf to another free anchor point
//		Add 1 black shelf (80 cm shelf) - optional step depending on the availability of black shelf
//		Move the shelf to another free anchor point
//		Add shelves until the cabinet is full (80 cm shelves)
//		Remove the 80 cm door and add two 40 cm doors
//
                .twoDView().emptyRoom(200, 200, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("LCWU_01_KP8500", true, true, false)
                .customiseProduct(-120, -115, "")
                .rotateView(140, 40, -50, 0)
                .deleteComposeProduct(-40, 40)
                .deleteComposeProduct(40, -10)
                .deleteComposeProduct(40, 40)
                
                .addItemInCabinet("KP8500_DOOR_800", false)
                .verifyAddedItemInCabinet(-40, 40, "KP8500_DOOR_800")
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .verifyAddedItemInCabinet(40, -62, "UTRUSTA_SHELF_02_W")
                .editComposeReplaceProperty(-40, 40, "Front", "OPERA|15758",false)
                .verifyComposeReplaceProperty(-40, 40, "Front","OPERA|15758")
                .handleOrientation(-40, 40, "Horizontal")
                .editComposeReplaceProperty(-40, 40, "Handle", "SAMMY",false)
                .verifyComposeReplaceProperty(-40, 40, "Handle","SAMMY")
                .elevateProduct(40, -62, 0, 70)
                .verifyAddedItemInCabinet(40, 10, "UTRUSTA_SHELF_02_W")
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_02_W", false)
                .verifyCabinetIsFull()
                .deleteComposeProduct(-40, 40)
                .addItemInCabinet("KP8500_DOOR_400", false)
                .addItemInCabinet("KP8500_DOOR_400", false)
                .verifyAddedItemInCabinet(-45, -20, "KP8500_DOOR_800")
                .verifyAddedItemInCabinet(-45, 90, "KP8500_DOOR_800")
                .validateComposeFurniture()

//		Scenario 3: 1 Door square corner base cabinet 88x88cm (with carousel)
//		Open the kitchen planner and go to “design your kitchen” step.
//				Add a 1 Door L-shaped corner base cabinet
//		Access to cabinet editor (“modify” button)
//		Remove the door and carousel from the standard model
//		Add the same guests back
//		Change door opening side
//		Change handle orientation
//		Replace the handle
//		Remove the carrousel
//		Add 1 white shelf (88 cm shelf)
//		Move the shelf to another free anchor point
//		Add 1 black shelf (88 cm shelf) - optional step depending on the availability of black shelf
//		Move the shelf to another free anchor point
//		Add shelves until the cabinet is full (88 cm shelves)
//
                .twoDView().twoDView().emptyRoom(0, 0, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("UEDK88_KP8500", true, true, false)
                .customiseProduct(-100, -30, "")
                .rotateView(140, 40, -80, 0)
                .deleteComposeProduct(-125, 70)
                .deleteComposeProduct(-25, 0)
                
                .addItemInCabinet("KP8500_DOUBLE CORNER DOOR 800", false)
                .verifyAddedItemInCabinet(-125, 70, "KP8500_DOUBLE CORNER DOOR 800")
                .addItemInCabinet("SF90_KP8500", false)
                .verifyAddedItemInCabinet(-25, 0, "SF90_KP8500")
                .setFrontOptions(-125, 70, "Right", "")
                .verifyAddedItemInCabinet(-10, 90, "KP8500_DOUBLE CORNER DOOR 800")
                .handleOrientation(-10, 90, "Horizontal")
                .verifyHandleOrientation(-10, 90, "Horizontal")
                .editComposeReplaceProperty(-10, 90, "Handle", "SAMMY", false)
                .verifyComposeReplaceProperty(-10, 90, "Handle", "SAMMY")
                .rotateView(140, 40, 20, 0)
                .deleteComposeProduct(0, 0)
                
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .elevateProduct(25, -70, 25, 70)
                .verifyAddedItemInCabinet(20, 15, "SF90_KP8500")
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .addItemInCabinet("UTRUSTA_SHELF_03_W", false)
                .verifyCabinetIsFull()
                .validateComposeFurniture()

//		Scenario 4: 1 Door diagonal corner wall cabinet – 60 cm (with diagonal corner shelves)
//		Open the kitchen planner and go to “design your kitchen” step.
//				Add a 1 Door diagonal corner base cabinet with a height of 60 cm
//		Access to cabinet editor (“modify” button)
//		Remove the door and shelves from the standard model
//		Add the same guests back
//		Replace the door
//		Change opening side
//		Change handle orientation
//		Replace the handle
//		Move the shelf to another free anchor point
//		Add 1 black shelf (diagonal corner shelf) - optional step depending on the availability of black shelf
//		Move the shelf to another free anchor point
//		Add shelves until the cabinet is full (diagonal corner shelves)
//		Remove all shelves
//		Add the 60cm carousel
//
                .twoDView().twoDView().emptyRoom(0, 0, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("KP8500_WED6801_H600", true, true, false)
                .customiseProduct(-115, -103, "")
                .rotateView(140, 40, -80, 0)
                .deleteComposeProduct(-105, 55)
                .deleteComposeProduct(-20, -5)
                .deleteComposeProduct(-20, 50)
                
                .addItemInCabinet("KP8500_DOOR_600", false)
                .verifyAddedItemInCabinet(-105, 55, "KP8500_DOOR_600")
                .addItemInCabinet("KP8500_NANTES", false)
                .verifyAddedItemInCabinet(-15, -30, "KP8500_NANTES")
                .editComposeReplaceProperty(-105, 55, "Front", "OPERA|15758",false)
                .verifyComposeReplaceProperty(-105, 55, "Front","OPERA|15758")
                .setFrontOptions(-105, 55, "Right", "")
                .verifyAddedItemInCabinet(10, 75, "KP8500_DOOR_600")
                .handleOrientation(10, 75, "Horizontal")
                .verifyHandleOrientation(10, 75, "Horizontal")
                .editComposeReplaceProperty(10, 75, "Handle", "SAMMY", false)
                .verifyComposeReplaceProperty(10, 75, "Handle", "SAMMY")
                .elevateProduct(-30, -30, 25, 70)
                .verifyAddedItemInCabinet(-40, 20, "KP8500_NANTES")
                .addItemInCabinet("KP8500_NANTES", false)
                .addItemInCabinet("KP8500_NANTES", false)
                .addItemInCabinet("KP8500_NANTES", false)
                .addItemInCabinet("KP8500_NANTES", false)
                .addItemInCabinet("KP8500_NANTES", false)
                .verifyCabinetIsFull()
                .deleteComposeProduct(-40, -30)
                .deleteComposeProduct(-40, -5)
                .deleteComposeProduct(-40, 20)
                .deleteComposeProduct(-40, 45)
                .deleteComposeProduct(-40, 70)
                .deleteComposeProduct(-40, 90)
                .addItemInCabinet("KP8500_CAROUSEL03_H600", false)
                .verifyAddedItemInCabinet(-40, 20, "KP8500_CAROUSEL03_H600")
                .validateComposeFurniture()

//		Scenario 5: 1 Door diagonal corner wall cabinet – 80 cm (with diagonal corner shelves)
//
//		Open the kitchen planner and go to “design your kitchen” step.
//				Add a 1 Door diagonal corner base cabinet with a height of 80 cm
//		Access to cabinet editor (“modify” button)
//		Remove the door and shelves from the standard model             -covered in previous scenario(s)
//		Add the same guests back             -covered in previous scenario
//		Replace the door             -covered in previous scenario
//		Change opening side             -covered in previous scenario
//		Change handle orientation             -covered in previous scenario
//		Replace the handle             -covered in previous scenario
//		Move the shelf to another free anchor point             -covered in previous scenario
//		Add 1 black shelf (diagonal corner shelf) - optional step depending on the availability of black shelf
//		Move the shelf to another free anchor point
//		Add shelves until the cabinet is full (diagonal corner shelves) -covered in previous scenario
//		Remove the 80 cm door and add two 40 cm doors
//		Remove all shelves
//		Add the 80cm carrousel
//		Remove the carousel
//		Add a 60cm carrousel
//		Place a shelf on top of the carrousel. Move the carrousel accordingly if needed.
//				Place a shelf under the carrousel. Move the carrousel accordingly if needed.
//
                .twoDView().twoDView().emptyRoom(0, 0, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("KP8500_WED6802_H800", true, true, false)
                .customiseProduct(-103, -108, "")
                .rotateView(140, 40, -80, 0)
                .deleteComposeProduct(-105, 60)
                .deleteComposeProduct(-30, -5)
                .deleteComposeProduct(-20, 50)
                
                .addItemInCabinet("KP8500_DOOR_400", false)
                .addItemInCabinet("KP8500_DOOR_400", false)
                .addItemInCabinet("KP8500_CAROUSEL03_H800", false)
                .verifyAddedItemInCabinet(-110, -15, "KP8500_DOOR_400")
                .verifyAddedItemInCabinet(-110, 100, "KP8500_DOOR_400")
                .verifyAddedItemInCabinet(0, -15, "KP8500_CAROUSEL03_H800")
                .deleteComposeProduct(0, -15)
                
                .addItemInCabinet("KP8500_CAROUSEL03_H600", false)
                .verifyAddedItemInCabinet(0, 30, "KP8500_CAROUSEL03_H600")
                .elevateProduct(0, 30,0,50)
                .addItemInCabinet("KP8500_NANTES", false)
                .verifyAddedItemInCabinet(-10, -60, "KP8500_NANTES")
                .elevateProduct(-5, 30,0,-50)
                .addItemInCabinet("KP8500_NANTES", false)
                .verifyAddedItemInCabinet(-30, 110, "KP8500_NANTES")
                .validateComposeFurniture();
    }
}
