package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DeleteMultipleProducts extends Browser {
    @Test
    public void deleteMultipleProductsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .roomShape("closed", 2)
                .roomType(-15,135, "Bathroom")
                .verifyRoomType(-15,135,"Bathroom", "Bathroom")
                .step3()
                .addProductBathroom("Swing Door Shower",true,false,false)
                .addProductBathroom("Vanity unit",true,false,false)
                .addProductBathroom("Bathtub assembly",true,false,false)
                .twoDView()
                .threeDView()
                .selectMultipleProducts("-168,26>-116,27>80,64")
                .deleteProduct()
                .undo(1)
                .duplicateProduct(-168,26)
                .selectMultipleProducts("-168,26>-116,27>80,64>-15,-13")
                .deleteProduct()
                .twoDView()
                .threeDView()

    //Deleting multiple products in 2D view
                .twoDView()
                .addProductBathroom("Swing Door Shower",true,false,false)
                .addProductBathroom("Vanity unit",true,false,false)
                .addProductBathroom("Bathtub assembly",true,false,false)
                .selectMultipleProducts("155,156>85,183>-44,161")
                .deleteProduct()
                .threeDView();







    }

}
