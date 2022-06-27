package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EmptyRoom extends Browser {
    @Test
    public void emptyRoom() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .tooltipsForFloorplan()
                .roomShape("open", 2)
                .nextStep()
                .selectFromSeveralRoom("Room 1", -8, 140)
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("I-shaped")
                .updateCookingMapping("Integrated")
                .updateRefrigerationMapping("Freestanding")
                .generateNewLayouts()
                .findSolutions("16 - I Shaped kitchen")
                .nextStepDesignYourKitchen("No", "")
                .addProduct("GVARIO03", true, false, false)
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .twoDView()
                .emptyRoom(-63, 97, "Kitchen", "14.0 m²", "Yes")
                .verifyPrice("0,00")
                .undo(1)
                .verifyPrice("9 893,10")
                //FUN122399 :As a user, I need an easier way to delete all items in the project
               .threeDView()
               .addProduct("GVARIO03", true, false, false)
               .emptyRoom(-33, 133, "Kitchen", "14.0 m²", "Yes")
               .verifyPrice("0,00")
               .clickProductList()
               .verifyEmptyItemList();


    }
}
