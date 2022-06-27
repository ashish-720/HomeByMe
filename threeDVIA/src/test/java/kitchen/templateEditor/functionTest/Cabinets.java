package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class Cabinets extends Browser {

    public void teCabinets() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startNow();
        Floorplan f1 = PageFactory.initElements(driver, Floorplan.class);
        f1.verifyFloorplan().goToDesignPage()
                .verifyDesign()
                //Verify product is in selected condition after adding
                .addProductUsingSearch("U2DA802").closeSearchPanel()
				.verifyProduct("U2DA802").deleteProduct("U2DA802", -107, 5)

                .addProductUsingSearch("U2DA80", "2").verifyProduct(-107, 5, "U2DA80")
                .closeSearchPanel().deleteProduct("U2DA80", -107, 5)
                .addProduct("U2DA80", true).duplicateFurniture("U2DA80", -107, 5, -41, 4).replacementProperty(-107, 5, "drawerFront", "MADELEINE/1", 0)
                .deleteProduct("U2DA80", -107, 5)
                .deleteProduct("U2DA80", -41, 4)
                .addProduct("UD4SA60", true).duplicateFurniture("UD4SA60", -113, 0, -68, 0).replacementProperty(-113, 0, "plinthOption", "CONCORDE/2", 3)
                .deleteProduct("UD4SA60", -113, 0).deleteProduct("UD4SA60", -68, 0)
                .addProduct("W6002", true).duplicateFurniture("W6002", -122, -91, -76, -91).replacementProperty(-76, -91, "front", "OPERA/0", 1)
                .deleteProduct("W6002", -122, -91).deleteProduct("W6002", -76, -91)
                .addProduct("U2DA80", true).openClose(-107, 5).replaceProduct("U2DA80", -107, 5, "UD2SA80").addProperty("UD2SA80", "wallPanelOption", -107, 5, "NO_WP_LAMINATE/Apply")
                .deleteProduct("UD2SA80", -107, 5)
                .addProduct("U2DA80", true).addProperty("U2DA80", "wallEdgeStripOption", -107, 5, "GEN_WES_WOOD")
                .deleteProduct("U2DA80", -107, 5);
    }

}
