package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
/*
KIT-2338 : Delete/Duplicate multiple selected items
*/
public class DeleteOrDuplicateMultipleProducts extends Browser {

    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void deleteOrDuplicateMultipleProducts(SignUpData signUpData) {
        LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
        home.login(signUpData)
                .planMyRoomClick()
                .furnish().catelogSubCategory("kitchen_cabinets")
                .addProduct("Oven cabinet l60", "1")
                .addProduct("Under sink unit l60", "4")
                .closeCatalog().furnish().catelogSubCategory("tables")
                .addProduct("Isobel dining table", "0")
                .closeCatalog()

                //Scenario : Verify delete action for multiple selected furniture in 2D view
                .viewTwoD()
                .productNameVerify(0, -85, "Oven cabinet l60")
                .productNameVerify(80, 0, "Under sink unit l60")
                .productNameVerify(0, 85, "Isobel dining table")
                .selectMultipleProducts("0,-85 > 80,0 > 0,85")
                .deleteProd()
                .productNameVerify(0, -85, "Room")
                .productNameVerify(80, 0, "Room")
                .productNameVerify(0, 85, "Room")

                //Scenario : Verify undo action after delete action for multiple selected furniture in 2D view
                .undo(6)
                .productNameVerify(0, -85, "Oven cabinet l60")
                .productNameVerify(80, 0, "Under sink unit l60")
                .productNameVerify(0, 85, "Isobel dining table")

                //Scenario : Verify duplicate action for multiple selected furniture in 2D view
                .moveWall(163, -110, 350, -110)
                .selectMultipleProducts("0,-85 > 80,0 > 0,85")
                .duplicateProd()
                .productNameVerify(190, -85, "Oven cabinet l60")
                .productNameVerify(270, 0, "Under sink unit l60")
                .productNameVerify(170, 85, "Isobel dining table")

                //Scenario : Verify undo action after duplicate action for multiple selected furniture in 2D view
                .undo(7)
                .productNameVerify(190, -85, "Room")
                .productNameVerify(270, 0, "Room")
                .productNameVerify(170, 85, "Room")
            
                //Scenario : Verify duplicate/delete action for multiple selected furniture in 3D view
                .viewThreeD()
                .selectMultipleProducts("0,-40 > 65,60 > 0,125")
                .duplicateProd()
                .productNameVerify(160, -40, "Oven cabinet l60")
                .productNameVerify(225, 60, "Under sink unit l60")
                .productNameVerify(175, 125, "Isobel dining table")
                .selectMultipleProducts("160,-40 > 225,60 > 175,125")
                .deleteProd()
                .verifyProductIsSelected(160, -40, false, "Oven cabinet l60")
                .verifyProductIsSelected(225, 60, false, "Under sink unit l60")
                .verifyProductIsSelected(175, 125, false, "Isobel dining table")
                .selectMultipleProducts("0,-40 > 65,60 > 0,125")
                .deleteProd()
                
                //Scenario : Verify delete action for multiple selected walls
                .viewTwoD()
                .floorPlan()
                .addWall().drawWall("225;-160>225;310").drawWall("225;310>-165;310").drawWall("-165;310>-165;160").validate()
                .selectMultipleProducts("226,27 > 64,311").deleteProd()
                .verifyProductIsSelected(226,27, false, "wall")
                .verifyProductIsSelected(64,311, false, "wall")
                .undo(3)
                .verifyProductIsSelected(226,27, true, "wall")
                .verifyProductIsSelected(64,311, true, "wall")

                //Scenario : Verify delete action for multiple selected windows
                .build().catelogSubCategory("double_windows")
                .addProduct("Double window", "0").addProduct("Double window", "4").closeCatalog()
                .moveWall(100,165, 0,310)                 //moving window with this method
                .selectMultipleProducts("0,310 > 225,10").deleteProd()
                .productNameVerify(0,310, "wall")
                .productNameVerify(225,10, "wall")
                .undo(4)
                .productNameVerify(0,310, "Double window")
                .productNameVerify(225,10, "Double window")

                 //add 2 staircase for testing 
                .build().catelogSubCategory("straight_staircases")
                .addProduct("Stair", "2").closeCatalog()
                .translateProduct(85,0,-100,-50)
                .build().catelogSubCategory("helical_staircases")
                .addProduct("Aurelia helical stairs", "2")
                .closeCatalog()
                .selectMultipleProducts("0,-50 > 85,-10").deleteProd()
                .verifyProductIsSelected(0,-50, false,"Aurelia helical stairs")
                .verifyProductIsSelected(85,-10, false,"Stair")
                .undo(5)
                .productNameVerify(0,-50, "Stair")
                .productNameVerify(85,-10, "Aurelia helical stairs")
                
                //Scenario : Verify duplicate/delete action for multiple selected rooms
                .selectMultipleProducts("130,-80 > -50,235").deleteProd()
                .verifyProductIsSelected(130,-80, false,"Room")
                .verifyProductIsSelected(-75,225, false,"Room 3")
                .verifyProductIsSelected(85,-10, false,"Aurelia helical stairs")
                .verifyProductIsSelected(225,10, true,"Double window")
                .verifyProductIsSelected(0,310, false,"Double window")
                .undo(6)
                .verifyProductIsSelected(130,-80, true,"Room")
                .verifyProductIsSelected(-75,225, true,"Room 3")
                .verifyProductIsSelected(85,-10, true,"Aurelia helical stairs")
                .verifyProductIsSelected(225,10, true,"Double window")
                .verifyProductIsSelected(0,310, true,"Double window")
                ;

//        TODO : Add scenario for delete multiple selected items using KB Del key when IR-905606 is resolved
    }
}
