package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
/*KIT-1368
 */
public class EditMultipleItems extends Browser {
    @Test
    public void editMultipleItems() {
    	StartNow start=PageFactory.initElements(driver, StartNow.class);
    	start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                .selectStyleMapping("Paris - White", "38mm Laminate Worktop", "234mm Bar Handle")
                .layoutMapping("L-Shaped").cookingMapping("").refrigerationMapping("integrated").startPlanning()
                .nextStep()
                .waterSupplyPositionPopUp("No", 0, 0)
                .findSolutions("87 - L Shaped kitchen")
                .nextStepDesignYourKitchen("No", "")
//                .verifyPrice("14 059,09")
                .twoDView().threeDView()

                //Edit multiple cabinets property - change handles
                .verifyReplaceProperty(-115,-40, "Handle", "SAMMY")
                .verifyReplaceProperty(-50,-90, "Handle", "SAMMY")
                .selectMultipleProducts("-115,-40 > -50,-90").replaceProperty("Handle", "LAURA", "", true, "")
                .verifyReplaceProperty(-115,-40, "Handle", "LAURA")
                .verifyReplaceProperty(-50,-90, "Handle", "LAURA")

                //edit multiple cabinets property - change front for cabinets with only doors or drawers
                .selectMultipleProducts("-115,-40 > -50,-90 > -5,25 > 125,-25").replaceProperty("Front", "OPERA|15761", "", true, "")
                .selectMultipleProducts("-90,50 > 60,40").replaceProperty("Drawer Front", "CONCORDE|14125", "", true, "")
                .verifyReplaceProperty(-115,-40, "Front", "OPERA|15761")
                .verifyReplaceProperty(-50,-90, "Front", "OPERA|15761")
                .verifyReplaceProperty(-5,25, "Front", "OPERA|15761")
                .verifyReplaceProperty(125,-25, "Front", "OPERA|15761")
                .verifyReplaceProperty(-90,50, "Drawer Front", "CONCORDE|14125")
                .verifyReplaceProperty(60,40, "Drawer Front", "CONCORDE|14125")
                .verifyReplaceProperty(-52,25, "Drawer Front", "MADELEINE|15514")

                //edit multiple cabinets properties - change fronts for some cabinets having doors and some having drawers in the selection -> property not shown in multiple selection
                //Verify that if a certain cabinet in the selection doesnt have a particular property, then the property doesnt show up in the multiselection
                .selectMultipleProducts("-115,-40 > -90,50 > -5,25 > 125,-25").editProperty().verifyEditablePropertyPresent("Front", "false")
                .selectMultipleProducts("-115,-40 > -90,50 > -5,25 > 125,-25").editProperty().verifyEditablePropertyPresent("Drawer Front", "false")
                .selectMultipleProducts("-115,-40 > -90,50").editProperty().verifyEditablePropertyPresent("Handle", "false")

                //Verify that when a property has different values for different  items in a multi-selection, it is properly displayed in the ui
                .selectMultipleProducts("-115,-40 > -5,25 > 125,-25").verifyReplaceProperty("Handle", "Multiple settings")
                .selectMultipleProducts("-115,-40 > -5,25 > 125,-25").verifyHandleOptionsIsEditable(false)
                .editHandleOptionsProperty(125,-25, "", "Horizontal")
                .selectMultipleProducts("-115,-40 > 125,-25").verifyReplaceProperty("Handle", "Multiple settings")
                .selectMultipleProducts("-115,-40 > 125,-25").verifyHandleOptionsProperty("", "Multiple values")

                //Edit option of property in multiselection
                .selectMultipleProducts("-115,-40 > 125,-25").editHandleOptionsProperty("", "Horizontal")
                .verifyHandleOptionsProperty(-115,-40, "", "Horizontal")
                .verifyHandleOptionsProperty(125,-25, "", "Horizontal")

                //Edit property : worktop for multiselection  :  if items in same linear -> whole linear gets replaced;  if items in different linear -> both the linears get fully replaced
                //worktop options : editing is disabled if not possible for any of the items in the selection , possible otherwise
                .selectMultipleProducts("-90,50 > 60,40").replaceProperty("Worktop Option", "ACRYLIC WHITE", "", true, "")
                .verifyReplaceProperty(-90,50, "Worktop Option", "ACRYLIC WHITE")
                .verifyReplaceProperty(60,40, "Worktop Option", "ACRYLIC WHITE")
                .verifyReplaceProperty(-5,25, "Worktop Option", "ACRYLIC WHITE")

                .addProduct("U2DA80", true, true, false)
                .addProduct("U2DA80", true, true, false)
                .translateProduct(140, 130, -400, -20)
                .selectMultipleProducts("-90,50 > -180,120").replaceProperty("Worktop Option", "LAMINATE BLACK", "", true, "")
                .verifyReplaceProperty(-90,50, "Worktop Option", "LAMINATE BLACK")
                .verifyReplaceProperty(-5,25, "Worktop Option", "LAMINATE BLACK")
                .verifyReplaceProperty(-180,120, "Worktop Option", "LAMINATE BLACK")
                .verifyReplaceProperty(170,65, "Worktop Option", "ACRYLIC WHITE")

                .selectMultipleProducts("-90,50 > -180,120").verifyWorktopOptionsOverhangProperty("Multiple values", "Multiple Values", "false", "false")
                .selectMultipleProducts("-90,50 > 160,100").verifyWorktopOptionsOverhangProperty("30 mm", "Multiple Values", "true", "false")
                .selectMultipleProducts("-90,50 > 160,100").editWorktopOverHangOptions("50 mm", "")
                .verifyWorktopOptionsOverhangProperty(-90,50, "50 mm", "0 mm", "true", "false")
                .verifyWorktopOptionsOverhangProperty(170,60, "50 mm", "30 mm", "true", "true");
    }
}
