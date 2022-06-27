package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProductInSelectedStateAfterInsertion extends Browser {
    /*
    KIT-2527 : [Home Retailers] As a user, I would like products to be selected after insertion
    */
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void productInSelectedStateAfterInsertion(SignUpData signUpData) {
        LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
        home.login(signUpData)
                .planMyRoomClick()
                //scenario : Furniture in selected state when added by clicking on catalog item
                .furnish().catelogSubCategory("kitchen_cabinets")
                .addProduct("Oven cabinet l60", "1").closeCatalog()
                .verifyProductIsSelected(true, "Oven cabinet l60")

                //scenario : Furniture in selected state when added by dragging from catalog and dropping onto sketcher
                .furnish().catelogSubCategory("kitchen_cabinets")
                .addProductUsingDragDrop("Under sink unit l60", "4", 60, 130).closeCatalog()
                .verifyProductIsSelected(true, "Under sink unit l60")

                //repeat above scenarios dor something that goes on a wall ( like a window)
                .viewTwoD()
                .build().catelogSubCategory("simple_windows")
                .addProduct("Simple window", "0")
                .closeCatalog()
                .verifyProductIsSelected(false, "Simple window")
                .build().catelogSubCategory("simple_windows")
                .addProductUsingDragDrop("Simple window", "4", 32, -163).closeCatalog()
                .verifyProductIsSelected(false, "Simple window");
    }
}
