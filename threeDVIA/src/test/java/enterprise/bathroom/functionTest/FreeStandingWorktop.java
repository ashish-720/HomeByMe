package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FreeStandingWorktop extends Browser {
    @Test
    public void freeStandingWorktopTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .step3()
                .addProductThroughSearch("Worktop", "WOOD OAK", true, false)
                .editFreeStandingWorktopProperties(-8, 41, false, "800 mm", "900 mm", "900 mm")
                .verifyFreeStandingWorktopProperties(10,50, "800 mm", "900 mm", "900 mm")
                .position(10,50, "900 mm", "1500 mm", "")
                .verifyPosition(13,20, "1500 mm")
                .position(13,20, "972 mm", "600 mm", "")
                .twoDView()
                .verifyPosition(0, 0, "600 mm")
                .undo(5)
                .replaceFreeStandingProperty(10,20, "WOOD OAK", "ACRYLIC WHITE", "", true, "ACRYLIC WHITE")
                .editFreeStandingWorktopWaterFall(10, 20, "yes", "yes","")
                .modifyFreestandingWorktop(10,20, "")
                .editWorktopYes()
                .editWaterfall(-42, -1)
                .createCutOut(-4, -15, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(4, 8, "", "", "", "155 mm", "449 mm", "750 mm")
                .addEdgeCut(133, 20, "Triple cut", "", "", "", "", "", "", "")
                .verifyEdgeCut(125, 72, "700 mm")
                .addSplitEdge(-138, 11)
                .verifySplit(-138, 74, "450 mm")
                .moveSplit(-138, 74, -200, 84)
//		.verifyPriceInWorktop("1 181,00")
//		.validateWorktopEditor();

                //Test scenarios for KIT-1774
                //scenario : add worktop with waterfall and verify price and BOM
                .cancelWorktopEditor()
                .twoDView().emptyRoom(-70, -110, "KITCHEN", "16.0 m²", "Yes").threeDView()
//                .verifyPrice("0,00")
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .editFreeStandingWorktopProperties(-8,41,false,"800 mm", "900 mm","900 mm")
                .verifyFreeStandingWorktopProperties(10,50, "800 mm", "900 mm", "900 mm")
                .position(10,50, "900 mm", "1500 mm", "")
                .verifyPosition(13,20, "1500 mm")
                .position(13,20, "962 mm", "600 mm", "")
                .twoDView()
                .verifyPosition(0, 0, "1600 mm")
                .undo(5)
                .replaceFreeStandingProperty(10,20, "ACRYLIC WHITE", "ACRYLIC WHITE ANGLED", "", true, "ACRYLIC WHITE")
                .editFreeStandingWorktopWaterFall(10, 20, "yes", "yes","")
                .modifyFreestandingWorktop(10,20, "")
                .editWorktopYes()
                .editWaterfall(-42, -1)
                .createCutOut(-4, -15, "Circle", "", "", "", "", "155 mm")
                .verifyWorktopCutOut(4, 8, "", "", "", "155 mm", "449 mm", "750 mm")
                .addEdgeCut(133, 20, "Triple cut", "", "", "", "", "", "", "")
                .verifyEdgeCut(125, 72, "719 mm")
                .addSplitEdge(-138, 11)
                .verifySplit(-138, 74, "450 mm")
                .moveSplit(-138, 74, -200, 84);

//                .verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_1 > Price:50\n100 > Quantity:1 ", "")
//                .editFreeStandingWorktopWaterFall(-10, 35, "yes", "yes","")
////                .verifyMemberPrice("1 172,35")
//                .clickProductList()
//                .verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_1 > Price:50\n100 > Quantity:1 ", "3")

                //scenario : edit dimensions for worktop with waterfall and verify price and BOM
//                .editFreeStandingWorktopProperties(-10, 35, false, "1200 mm", "800 mm", "1100 mm")
////                .verifyMemberPrice("1 377,00")
//                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_2 > Price:50\n100 > Quantity:1 > Total:€ 196,90\n€ 393,80", "")
//                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_2 > Price:50\n100 > Quantity:1 > Total:€ 180,45\n€ 360,90", "2")

//                //scenario : edit dimensions for worktop with waterfall in worktop editor and verify price and BOM
//                .modifyFreestandingWorktop(-10, 35, "")
//                .editWorktopYes()
//                .moveWorktop(45, -10, 100, -10)
//                .editWaterfall(125, -10)
//                .moveWorktop(0, 180, 0, 100)
//                .validateWorktopEditor()
//                .twoDView().threeDView()
////                .verifyReducedOrMemberPrice("member", "1 438,55")
//                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_2 > Price:50\n100 > Quantity:1 > Total:€ 196,90\n€ 393,80", "")
//                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_2 > Price:50\n100 > Quantity:1 > Total:€ 180,45\n€ 360,90", "")
//                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:DKACRYLIC_2 > Price:€ 50,00\n100 > Quantity:1 > Total:€ 138,95\n€ 277,90", "")
//
//                //scenario : add side panel and verify price and BOM
//                .twoDView().emptyRoom(-490, -115, "KITCHEN", "16.0 m²", "Yes").threeDView()
//                .addProductThroughSearch("Cover Panel", "OPERA|16053", true, false)
//                .verifyPrice("18,00")
//                .clickProductList().verifyProductInfoInItemList("Accessories and extras", "Reference:opera_cover_panel_rouge_39_86 > Price:€ 18,00 > Quantity:1 > Total:€ 18,00", "")
//
//                //scenario : edit sidepanel, verify price and BOM
//                .clickAndDrag()
//                .selectProduct(-15, 100).editProperty().editFurniture("542 mm", "", "1000 mm")
//                .verifyPrice("50,00")
//                .clickProductList().verifyProductInfoInItemList("Accessories and extras", "Reference:opera_cover_panel_rouge_62_240 > Price:€ 50,00 > Quantity:1 > Total:€ 50,00", "")


                //Test scenarios for KIT-2029 : As a Range Maintainer, i want to be able to set the default height of freestanding worktops
                //Scenario 1 : Insert two different freestanding worktops , one having default height as 1000 and one having default height as 1500 and verify that default height is correct and
                // reflected correctly in the parameters
//                .twoDView().emptyRoom(-490, -115, "KITCHEN", "16.0 m²", "Yes").threeDView()
//                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
//                .verifyFreeStandingWorktopProperties(0, 45, "1000 mm", "635 mm", "1000 mm")
//                .addProductThroughSearch("Worktop", "illustration worktop", true, false)
//                .verifyFreeStandingWorktopProperties(0, 10, "1000 mm", "635 mm", "1500 mm")

//                //Scenario 2 : Replace/Modify parameters for the 1500 height worktop and verify that they can be modified for such a worktop
//                .translateProduct(0, 10, 0, 100)
//                .editFreeStandingWorktopProperties(-20, 115, false, "800 mm", "600 mm", "1000 mm")
//                .verifyFreeStandingWorktopProperties(0, 140, "800 mm", "600 mm", "1000 mm")
//                .replaceFreeStandingProperty(0, 140, "illustration worktop", "ACRYLIC WHITE", "", true, "ACRYLIC WHITE")
//                .verifyReplaceProperty(0, 140, "ACRYLIC WHITE", "ACRYLIC WHITE")
//                .verifyFreeStandingWorktopProperties(0, 140, "800 mm", "600 mm", "1000 mm")
//
////		        Test scenario for FUN120666 : As a user, I can zoom further in linear editors : worktop
//                .modifyFreestandingWorktop(10, 45, "")
//                .editWorktopYes()
//                .editWorktopDimension(0, -36, "1000 mm", "900 mm", "apply left")
//                .editWorktopDimension(59, 0, "635 mm", "550 mm", "apply below")
//                .zoomIn(22)
//                .addEdgeCut(-477, 0, "Triple cut", "", "", "", "", "", "", "")
//                .addEdgeCut(0, 275, "Triple cut", "", "", "", "", "", "", "");
    }
}
