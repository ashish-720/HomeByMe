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

public class CustomWorktopWallPanelRule extends Browser {
	String secondTab;

	// FUN121512 :As a user, I am notified if worktops or wall panels dimensions are under the minimum values allowed
	@Test(dataProvider = "cloudAdmin", dataProviderClass = SignUpData.class)
	public void customWorktopWallPanelRule(SignUpData signUpData) throws IOException {

		
				
				

		// Go to 3D cloud ==>product ==> Search worktop==> open Laminate concrete ==>
		// add minWidth/minDepth options
		secondTab = Browser.openUrlInNewTab(driver, "https://preprod-staging-3dcloud.enterprise-dev.by.me/en/login");
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.searchProductWithoutDate("ODT_LAMINATE CONCRETE", "")
		.openProductWithoutDate("ODT_LAMINATE CONCRETE","")
		.goToProductRepresentation()
		.addDimensionVariationDiscrete(false, false, "minWidth", "New", "1000>P1", "1000")
		.clickSave()
		.clickBack()
		.searchProductWithoutDate("ODT_DK_WP_GLASS", "")
		.openProductWithoutDate("ODT_DK_WP_GLASS","")
		.goToProductRepresentation()
		.addDimensionVariationDiscrete(false, false, "minHeight", "New", "500>P1", "500")
		.clickSave();
		  Browser.switchToWindow(driver, Browser.mainWindowHandle);
	      Browser.openUrl(driver, "https://preprod-staging-bryo.enterprise-dev.by.me/");
	      StartNow start = PageFactory.initElements(driver, StartNow.class);
	      start.setBryoAccessCode().startDemo("en-GB").startFromScratch().step3()
	      .addProductThroughSearch("U2DA", "U2DA100", true, false)
		 .replaceProperty(-102,-1, "Worktop", "ODT_LAMINATE CONCRETE", "",true, "", "")	
		 .worktopEditor(-102,-1)
		 .editWorktopYes()
		 .verifyWorktopDimension(-194, -156, "1080 mm")
		 .editWorktopDimension(-194, -156, "1080 mm", "999 mm", "left")
		.checkWorktopEditorBusinessRules("There is no product available to make this worktop")
		 .validateWorktopEditor()
		 .addProperty(28,10, "Wall Panel", "ODT_DK_WP_GLASS", "all", true)
		 .wallPanelEditor(28, 10)
		 .editWallPanelYes()
		 .verifyWallPanelDimension(-132, 30, "570 mm")
		 .editWallPanelDimension(-132, 30, "570 mm", "499 mm", "below")
		 .checkBusinessRuleInWallPanel("There is no product available to make this worktop")
		 .validateWallPanelEditor();
		 Browser.switchToWindow(driver, secondTab);
		 Product product=PageFactory.initElements(driver, Product.class);
		 product.clickBack()
		 .searchProductWithoutDate("ODT_LAMINATE CONCRETE", "")
		.openProductWithoutDate("ODT_LAMINATE CONCRETE","")
		.goToProductRepresentation()
		 .deleteVariableDimensions("minWidth")
		.clickSave()
		.clickSave().clickBack()
		.searchProductWithoutDate("ODT_DK_WP_GLASS", "")
		.openProductWithoutDate("ODT_DK_WP_GLASS","")
		.goToProductRepresentation()
		 .deleteVariableDimensions("minHeight")
		 .clickSave()
		 .clickSave();
		 Browser.switchToWindow(driver, Browser.mainWindowHandle);
		 start.refreshApplication()
         .startFromScratch()
         .recoverProject("yes")

		 .worktopEditor(30,13)
		 .verifyWorktopDimension(-157, -141, "999 mm")
		 .verifyBusinessRuleInWorktopEditorRemoved("There is no product available to make this worktop")
		 .validateWorktopEditor()
		 .wallPanelEditor(30, 13)
		 .verifyWallPanelDimension(-130, 30, "499 mm")
		 .verifyBusinessRuleInWallPanelRemoved("\"There is no product available to make this worktop");
	}

}
