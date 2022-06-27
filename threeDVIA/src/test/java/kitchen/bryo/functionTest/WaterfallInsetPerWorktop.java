package kitchen.bryo.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;
import kitchen.threeDCloudByMe.pageObject.AppSettings;
import kitchen.threeDCloudByMe.pageObject.Level1DlgBox;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;
import kitchen.threeDCloudByMe.pageObject.Product;

public class WaterfallInsetPerWorktop extends Browser {
	String secondTab;

	// FUN119284 : As a retailer, I can configure the waterfall inset per worktop
	@Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
	public void waterfallInsetPerWorktop(SignUpData signUpData) throws IOException {

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().step3()
				.addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
				.addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
				.translateProduct(-50, -35, 50, -35)
				.replaceProperty(-111, -32, "Worktop", "ACRYLIC WHITE", "selected",true, "OK", "")
				.editWorktopWaterFallOptions(-111, -32, "", "yes","");

		// Go to 3D cloud ==>product ==> Search worktop==> open Laminate concrete ==>
		// set value waterfallInsetEnd ==100(currently this might be 0)
		// waterfallInsetFront=200
		secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.searchProductWithoutDate("ODT_LAMINATE CONCRETE", "")
		.openProductWithoutDate("ODT_LAMINATE CONCRETE","")
		.goToProductRepresentation()
		.editOptionDiscrete(false,false,"waterfallInsetEnd","","100>P1","100")
		.editOptionDiscrete(false,false,"waterfallInsetFront","","200>P1","200")
		.clickSave();
		
		  Browser.switchToWindow(driver, Browser.mainWindowHandle);
		 MakeItYours design=PageFactory.initElements(driver, MakeItYours.class);
		 design.refreshApplication()
         .startFromScratch()
         .recoverProject("yes")
		 .replaceProperty(28,10, "Worktop", "ODT_LAMINATE CONCRETE", "selected",true, "", "")
		 .editWorktopWaterFallOptions(28,10, "", "yes","")
		 .verifyWorktopOptionsProperty(28, 10, "30 mm", "128 mm", "", "")
		 .worktopEditor(28,10)
		 .editWorktopYes()
		 .verifyWorktopDimension(-194, -156, "891 mm")
		 .editWaterfall(-124, -179)
		 .verifyWorktopDimension(2, -150, "634 mm")
		 .mainWorktopView("")
		 .verifyWorktopDimension(2, -157, "958 mm")
		 .editWaterfall(56, -177)
		 .verifyWorktopDimension(42, -143, "435 mm")
		 .validateWorktopEditor();
		 
		 Browser.switchToWindow(driver, secondTab);
		 Product product=PageFactory.initElements(driver, Product.class);
		 product.goToProductRepresentation()
		 .editOptionDiscrete(false,false,"waterfallInsetEnd","","80>P1","80")
			.editOptionDiscrete(false,false,"waterfallInsetFront","","60>P1","60")
			.clickSave();
		 
		 Browser.switchToWindow(driver, Browser.mainWindowHandle);
		 design.refreshApplication()
         .startFromScratch()
         .recoverProject("yes")
         .deleteProperty(30, 13, "Worktop")  
         .addProperty(30, 13,  "Worktop", "ODT_LAMINATE CONCRETE", "selected", true)
		 .verifyWorktopOptionsProperty(30, 13, "30 mm", "30 mm", "", "")
		 .editWorktopWaterFallOptions(30,13, "", "yes","")
		 .worktopEditor(30,13)
		 .verifyWorktopDimension(-194, -156, "891 mm")
		 .editWaterfall(-124, -179)
		 .verifyWorktopDimension(2, -150, "634 mm")
		 .mainWorktopView("")
		 .verifyWorktopDimension(2, -157, "938 mm")
		 .editWaterfall(56, -177)
		 .verifyWorktopDimension(42, -143, "575 mm")
		 .validateWorktopEditor();
	}

}
