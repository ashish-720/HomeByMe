package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CloudProductTest extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void cloudProductTest(SignUpData signUpData) {

        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
                .step3()
                .addProductThroughSearch("UA80_bryoCont", "UA80_bryoCont_" + UtilHBM.getDate(0, "dd_MM_yyyy"), true, false)

                //Test scenario for KIT-2020 : Verification of AS affecting resize of cabinet components in bryo
                .addProductThroughSearch("ODT_BA1_KIT2020", "ODT_BA1_KIT2020", true, false)
                .customiseProduct(-60, -10, "555,00")
                .deleteComposeProduct(140, -5).deleteComposeProduct(160, 120)
                .addItemInCabinet("NANTES|Black shelf", false)
                .rotateView(300, 0, -30, 0)
                .verifyProductIsSelected(-60, 10, false, "")
                .verifyProductIsSelected(65, 10, false, "")
                .rotateView(300, 0, -30, 0)
                .verifyProductIsSelected(0, -30, false, "")
                .verifyProductIsSelected(-20, 0, true, "NANTES")
                .cancelComposeFurniture()

                .addProductThroughSearch("ODT_BA2_KIT2020", "ODT_BA2_KIT2020", true, false)
                .customiseProduct(60, 30, "555,00")
                .deleteComposeProduct(140, -5).deleteComposeProduct(160, 120)
                .addItemInCabinet("NANTES|Black shelf", false)
                .rotateView(300, 0, -30, 0)
                .verifyProductIsSelected(-60, 10, true, "NANTES")
                .verifyProductIsSelected(65, 10, true, "NANTES")
                .rotateView(300, 0, -30, 0)
                .verifyProductIsSelected(0, -30, true, "NANTES")
                .validateComposeFurniture();

    }
}
