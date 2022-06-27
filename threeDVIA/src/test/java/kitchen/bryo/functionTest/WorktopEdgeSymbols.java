package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopEdgeSymbols extends Browser {
    @Test
    public void worktopEdgeSymbolsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
                .step3()
                .addProduct("U2DA80", true, false, false)
                .replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE", "", true,"")
                .worktopEditor(-115, -11)
                .editWorktopYes()
                .verifyEdgeSymbol(4, 0, 0)
                .changeEdgeProduct(-185, -159, "DKACRYLIC_NOEDGE", "no")
                .verifyEdgeSymbol(3, 1, 0)

                //kit-1822
                .changeEdgeProduct(-185, -159, "Choose a reference / no edge", "no")
                .checkWorktopEditorBusinessRules("Missing edge finishes")
                .checkWorktopEditorBusinessRules("'DKACRYLIC_ALU' edge finish is invalid.")
                .addEdgeProduct(-185, -159, "DKACRYLIC_BADEDGE", "no")
                .verifyEdgeSymbol(3, 0, 1)
                .validateWorktopEditor()
                .addProduct("U2DA1002", true, false, false)
                .translateProduct(60, 30, 150, 55)
                .replaceProperty(150, 55, "Worktop", "illustration worktop", "Selected",true, "")
                .worktopEditor(150, 55)
                .verifyWorktopTypes("Custom and precut")
                .validateWorktopEditor()

                //KIT-1580 : As a kitchen retailer, I can choose to hide the "front" option
                .deleteProduct(115, 35)
                .worktopEditor(-110, 35)
                .changeEdgeProduct(-180, -159, "DKACRYLIC_ALU", "No")
                .verifyEdgeProduct(-180, -159, "DKACRYLIC_ALU", "No")
                .validateWorktopEditor()
                .worktopEditor(0, 10)
                .changeEdgeProduct(-180, -159, "DKACRYLIC_ALU", "Yes")
                .verifyEdgeProduct(-180, -159, "DKACRYLIC_ALU", "Yes");
    }

}
