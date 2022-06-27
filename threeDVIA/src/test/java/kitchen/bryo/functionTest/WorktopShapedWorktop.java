package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test scenarios for KIT-1058 : IPlan with shaped worktops
public class WorktopShapedWorktop extends Browser {
    @Test
    public void planWithShapedWorktops() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()

                //scenario 1 : Circular worktops
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .modifyFreestandingWorktop(0, 45, "555,10")
                .editWorktopYes()
                .addEdgeCut(-15, -48, "Rounded", "", "", "", "", "", "", "500 mm")
                .verifyRoundedEdgePresent(-15, -102)
                .moveWorktop(0, 22, 0, -50)
                .addEdgeCut(0, -34, "Rounded", "", "", "", "", "", "", "500 mm")
                .verifyRoundedEdgePresent(-17  , 17)
                .verifyPriceInWorktop("742,30")
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC > Total:€ 578,25\n€ 742,30", "")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_SHAPE_CIRCULAR > Price:€ 100,00 > Quantity:1 > Total:€ 100,00", "1")

                .modifyFreestandingWorktop(0, 20, "742,30")
                .createCutOut(-20, -45, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(-20, -45, "", "", "", "155 mm", "", "")
                .changeGrainDirection(15, -45)
                .verifyPriceInWorktop("852,30")
                .validateWorktopEditor()
                .translateProduct(0, 20, -90, 170)
                .verifyProduct(-90, 190, "ACRYLIC WHITE")

                //scenario 2 : Arc worktops with arc at the end of the worktop
                .twoDView().twoDView().emptyRoom(0, 0, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .modifyFreestandingWorktop(0, 45, "555,10").editWorktopYes()
                .addEdgeCut(-55, -2, "Rounded", "", "", "", "", "", "", "318 mm")
                .verifyRoundedEdgePresent(97, 0)
                .verifyPriceInWorktop("795,70")
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC > Total:€ 579,45\n€ 795,70", "")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_SHAPE_ARCEND > Price:€ 100,00 > Quantity:1 > Total:€ 100,00", "1")

                .modifyFreestandingWorktop(0, 40, "795,70")
                .createCutOut(-35, -15, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(-35, -15, "", "", "", "155 mm", "", "")
                .changeGrainDirection(0, -15)
                .verifyPriceInWorktop("Price is not available")
                .changeGrainDirection(0, -15)
                .verifyPriceInWorktop("905,70")
                .validateWorktopEditor()
                .translateProduct(0, 40, -80, 150)
                .verifyProduct(22, 18, "ACRYLIC WHITE")


                //scenario 3 : Arc worktop with arc along the length of the worktop
                .twoDView().twoDView().emptyRoom(-11, 90, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProductThroughSearch("Worktop", "LAMINATE BLACK", true, false)
                .modifyFreestandingWorktop(0, 45, "500,12").editWorktopYes()
                .addEdgeCut(-15, -51, "Rounded", "", "", "", "", "", "", "800 mm")
                .verifyRoundedEdgePresent(-14, -72)
                .verifyPriceInWorktop("600,12")
                .validateWorktopEditor()
                .verifyPrice("")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:NOLAMINATE > Total:€ 600,12", "")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_SHAPE_ARCLENGTH > Price:€ 100,00 > Quantity:1 > Total:€ 100,00", "1")

                .modifyFreestandingWorktop(0, 40, "600,12")
                .createCutOut(-20, -15, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(-20, -15, "", "", "", "155 mm", "", "")
                .changeGrainDirection(10, -15)
                .changeGrainDirection(10, -15)      //TODO CHECK
                .verifyPriceInWorktop("681,20")
                .changeGrainDirection(0, -15)
                .verifyPriceInWorktop("700,12")
                .validateWorktopEditor()

                //scenario 4 : Mushroom shaped worktops
                .twoDView().twoDView().emptyRoom(-100, -100, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .modifyFreestandingWorktop(0, 45, "555,10").editWorktopYes()

                .moveWorktop(-5 ,23, -5, 50)
                .addEdgeCut(60, -9, "Rounded", "", "", "", "", "", "", "433 mm mm")
                .verifyRoundedEdgePresent(77, -8)
                .moveWorktop(39,39,17,39)
                .verifyPriceInWorktop("896,60")
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC > Total:€ 663,95\n€ 896,60", "")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_SHAPE_MUSHROOM > Price:€ 100,00 > Quantity:1 > Total:€ 100,00", "1")

                .modifyFreestandingWorktop(10, 45, "896,60")
                .createCutOut(0,0, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(0,0, "", "", "", "155 mm", "", "")
                .changeGrainDirection(15, 0)
                .verifyPriceInWorktop("Price is not available")
                .changeGrainDirection(15, 0)
                .verifyPriceInWorktop("896,60")
                .validateWorktopEditor();
    }
}
