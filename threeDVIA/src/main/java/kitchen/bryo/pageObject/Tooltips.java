package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tooltips {
	WebDriver driver;

	public Tooltips(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "button[data-ui-action='import_plan']")
	private WebElement showRoomTip;

	@FindBy(css = "button[data-ui-action='draw_plan']")
	private WebElement showOpenKitchenTip;
	
	@FindBy(css = "button[data-ui-action='measure2d']")
	private WebElement showEditMeasureTip;

	@FindBy(css = "button[data-ui-action='doors_windows']")
	private WebElement showDoorsWindowsTip;

	@FindBy(css = "button[data-ui-action='ceiling_height']")
	private WebElement showCeilingHeightTip;

	@FindBy(css = "button[data-ui-action='select_wall']")
	private WebElement showAdjustWallCornerTip;
	
	@FindBy(css = "button[data-ui-action='water_supply']")
	private WebElement showWaterSupplyTip;

	@FindBy(css = "button[data-ui-action='change_roomObjects']")
	private WebElement showRoomObjectTip;

	@FindBy(css = "button[data-ui-action='change_coverings']")
	private WebElement showCoveringTip;

	@FindBy(css = "button[data-ui-action='add_cut_out']")
	private WebElement showCutOutTip;

	@FindBy(css = "button[data-ui-action='change_grain_direction']")
	private WebElement showGrainTip;

	@FindBy(css = ".mod-onboarding.mod-ui-tip .label")
	private WebElement toolTipTitle;

	@FindBy(css = ".mod-onboarding.mod-ui-tip >.label+p")
	private WebElement toolTipInfo;

	@FindBy(css = "button[data-ui-action='add_joint']")
	private WebElement showAddJointTip;

	@FindBy(css = "button[data-ui-action='add_edge_out']")
	private WebElement showEdgeCutTip;

	@FindBy(css = "button[data-ui-action='add_edge_product']")
	private WebElement showEdgeProductTip;

	@FindBy(css = "button[data-ui-action='split_an_edge']")
	private WebElement showSplitTip;

	@FindBy(css = "button[data-ui-action='add_corner_cut']")
	private WebElement showCornerCutTip;

	@FindBy(css = "button[data-ui-action='edit_measurement']")
	private WebElement showMeasureTip;

	@FindBy(css = "button[data-ui-action='customize_kitchen']")
	private WebElement showCustomizeTip;

	@FindBy(xpath = "//button[@data-ui-action='tip-hide']")
	private WebElement hideTip;

	@FindBy(css = "button[data-ui-action='add_cabinet']")
	private WebElement showAddCabinetTip;

	@FindBy(css = "button[data-ui-action='add_appliance']")
	private WebElement showAddAppliancesTip;

	@FindBy(css = "button[data-ui-action='hide_cabinet_front']")
	private WebElement showHideFrontTip;

	@FindBy(css = "button[data-ui-action='change_view']")
	private WebElement showChangeViewTip;

	@FindBy(css = "button[data-ui-action='undo_action']")
	private WebElement showUndoActionTip;

	@FindBy(css = "button[data-ui-action='check_price']")
	private WebElement showPriceTip;

	@FindBy(css = "button[data-ui-action='add_cut_out']")
	private WebElement showWPAddCutOutTip;

	@FindBy(css = "button[data-ui-action='add_triple_cut']")
	private WebElement showAddTripleCutTip;

	@FindBy(css = "button[data-ui-action='add_corner_cut']")
	private WebElement showWPAddCornerCutTip;

	@FindBy(css = "button[data-ui-action='select_item']")
	private WebElement showSelectItemTip;

	@FindBy(css = "button[data-ui-action='add_on']")
	private WebElement showAddOnTip;

	@FindBy(css = "button[data-ui-action='move_item']")
	private WebElement showMoveItemTip;

	@FindBy(css = "button[data-ui-action='see_inside']")
	private WebElement showSeeInsideTip;

	@FindBy(css = "#mod-help-center>#show-help")
	private WebElement helpCenter;

	@FindBy(id = "bt-tab-help-center-1")
	private WebElement toolTipsPanel;

	@FindBy(id = "bt-tab-help-center-2")
	private WebElement planningHelpCenter;

	@FindBy(xpath = "//button[@data-ui-action='tip-close']")
	private WebElement showTipButton;
	
	@FindBy(xpath = "//div[@class='mod-notification']/p/span[@data-ui-selector='notification-text']")
	private WebElement notificationRibbon;
	
	public Tooltips tooltipsForFloorPlanAfterLaunch() {
		String expectedWallOrCornerTipLabel = "Adjust wall or corner";
		String expectedWallOrCornerTip="Adapt the room shape by changing measurements and angles.";
		String expectedHtTipLabel = "Adjust ceiling height";
		String expectedHtTip = "Remember to adjust the ceiling height with your real measurements.";
		String expectedOpenDesignTipLabel="Design an open kitchen";
		String expectedOpenDesignTip="Split the floor into several areas.";
		String expectedRoomObjectTipLabel = "Add a room object";
		String expectedRoomObjectTip = "If you have any radiator, column, etc. in your room, you can add it and resize it directly here.";
		String expectedCoveringTipLabel = "Change coverings";
		String expectedCoveringTip = "Find a flooring and a wall covering close to your home to finish your room personalisation.";
	
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Adjust wall or corner  title not correct", toolTipTitle.getText(), expectedWallOrCornerTipLabel);
		Verification.VerifyEquals("Adjust wall or corner  info not correct", toolTipInfo.getText(), expectedWallOrCornerTip);
		showTipButton.findElement(By.xpath("span[contains(text(),'See 4 more tips')]")).click();
		UtilHBM.waitExplicitDisplayed(driver, showTipButton.findElement(By.xpath("span[contains(text(),'Next (1/4)')]")));
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Ceiling height title not correct", toolTipTitle.getText(), expectedHtTipLabel);
		Verification.VerifyEquals("Ceiling height info not correct", toolTipInfo.getText(), expectedHtTip);
		showTipButton.findElement(By.xpath("span[contains(text(),'Next (1/4)')]")).click();
		UtilHBM.waitExplicitDisplayed(driver, showTipButton.findElement(By.xpath("span[contains(text(),'Next (2/4)')]")));
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Design an open kitchen  title not correct", toolTipTitle.getText(), expectedOpenDesignTipLabel);
		Verification.VerifyEquals("Design an open kitchen info not correct", toolTipInfo.getText(), expectedOpenDesignTip);
		showTipButton.findElement(By.xpath("span[contains(text(),'Next (2/4)')]")).click();
		UtilHBM.waitExplicitDisplayed(driver, showTipButton.findElement(By.xpath("span[contains(text(),'Next (3/4)')]")));
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add a room object  title not correct", toolTipTitle.getText(), expectedRoomObjectTipLabel);
		Verification.VerifyEquals("Add a room object  info not correct", toolTipInfo.getText(), expectedRoomObjectTip);
		showTipButton.findElement(By.xpath("span[contains(text(),'Next (3/4)')]")).click();
		UtilHBM.waitExplicitDisplayed(driver, hideTip);
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Change coverings title not correct", toolTipTitle.getText(), expectedCoveringTipLabel);
		Verification.VerifyEquals("Change coverings info not correct", toolTipInfo.getText(), expectedCoveringTip);
		hideTip.click();
		UtilHBM.waitExplicitDisplayed(driver, notificationRibbon);
		Verification.verifyText(notificationRibbon, "Visit the help center for advice on your kitchen design", "Ribbon Notification");		
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#mod-help-center:not([class*=mod-open])>#show-help")));
		return PageFactory.initElements(driver, Tooltips.class);
	}
	
	public Tooltips tooltipsForFloorplan() {
		String expectedRoomTipLabel = "Start with a shape";
		String expectedRoomTip = "You can directly import plan with several options. You can for example start with basic shape or even use your home by me project.";
		
		String expectedOpenKitchenTipLabel = "Design an open kitchen";
		String expectedOpenKitchenTip = "Split the floor into several areas.";
		
		String expectedWaterTipLabel = "Position water supply";
		String expectedWaterTip = "You can go here to select the wall where is your water supply.We will use this information to suggest kitchen layouts with a sink on the corresponding wall when possible.";
		
		String expectedRoomObjectTipLabel = "Add a room object";
		String expectedRoomObjectTip = "If you have any radiator, column, etc. in your room, you can add it and resize it directly here.";
		
		String expectedCoveringTipLabel = "Change coverings";
		String expectedCoveringTip = "Find a flooring and a wall covering close to your home to finish your room personalisation.";
		
		String expectedHtTipLabel = "Adjust ceiling height";
		String expectedHtTip = "Remember to adjust the ceiling height with your real measurements.";
		
		String expectedAdjustWallCornerTipLabel = "Adjust wall or corner";
		String expectedAdjustWallCornerTip = "Adapt the room shape by changing measurements and angles.";
		
		String expectedDimTipLabel = "Edit measurements";
		String expectedDimTip = "You can directly edit measurements or drag walls to adapt the room shape.";
		
				
		UtilHBM.waitFixTime(1500);
		UtilHBM.waitExplicitDisplayed(driver, helpCenter);
		UtilHBM.waitExplicitClickable(driver, helpCenter);		
//		JavascriptExecutor ex = (JavascriptExecutor) driver;
//		ex.executeScript("arguments[0].click();", helpCenter);
		 helpCenter.click();
		 UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("article[class='mod-help-center-with-footer mod-open']")));
		UtilHBM.waitFixTime(2000);
		// UtilHBM.waitExplicitDisplayed(driver,
		// driver.findElement(By.cssSelector(".content>content-inner")));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("article[class='mod-help-center-with-footer mod-open']>div>div>div>div[id='help-center-1']>ul>li")));
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, showRoomTip);
		UtilHBM.waitExplicitClickable(driver, showRoomTip);
		showRoomTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Room Shape  title not correct", toolTipTitle.getText(), expectedRoomTipLabel);
		Verification.VerifyEquals("Room Shape  info not correct", toolTipInfo.getText(), expectedRoomTip);
		hideTip.click();

		showOpenKitchenTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Design open kitchen title not correct", toolTipTitle.getText(), expectedOpenKitchenTipLabel);
		Verification.VerifyEquals("Design open kitchen info not correct", toolTipInfo.getText(), expectedOpenKitchenTip);
		hideTip.click();
		
		showWaterSupplyTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Water supply title not correct", toolTipTitle.getText(), expectedWaterTipLabel);
		Verification.VerifyEquals("Water supply info not correct", toolTipInfo.getText(), expectedWaterTip);
		hideTip.click();
		
		showRoomObjectTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		System.out.println(toolTipTitle.getText());
		Verification.VerifyEquals("Room object title not correct", toolTipTitle.getText(), expectedRoomObjectTipLabel);
		Verification.VerifyEquals("Room object info not correct", toolTipInfo.getText(), expectedRoomObjectTip);
		hideTip.click();
		
		showCoveringTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Covering title not correct", toolTipTitle.getText(), expectedCoveringTipLabel);
		Verification.VerifyEquals("Covering info not correct", toolTipInfo.getText(), expectedCoveringTip);
		hideTip.click();
		
		showCeilingHeightTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Ceiling height title not correct", toolTipTitle.getText(), expectedHtTipLabel);
		Verification.VerifyEquals("Ceiling height info not correct", toolTipInfo.getText(), expectedHtTip);
		hideTip.click();
		
		showAdjustWallCornerTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Ceiling height title not correct", toolTipTitle.getText(), expectedAdjustWallCornerTipLabel);
		Verification.VerifyEquals("Ceiling height info not correct", toolTipInfo.getText(), expectedAdjustWallCornerTip);
		hideTip.click();
		
		showEditMeasureTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Edit measurments  title not correct", toolTipTitle.getText(), expectedDimTipLabel);
		Verification.VerifyEquals("Edit measurments info not correct ", toolTipInfo.getText(), expectedDimTip);
		hideTip.click();
	
		 return this;

	}
public Tooltips tooltipsForOpenings () {
	String expectedBayTipLabel = "Position doors and windows";
	String expectedBayTip = "You can directly click on a door or window to move it, replace it by another one and edit size.";
//	UtilHBM.waitFixTime(1500);
	UtilHBM.waitExplicitDisplayed(driver, helpCenter);
	JavascriptExecutor ex = (JavascriptExecutor) driver;
	ex.executeScript("arguments[0].click();", helpCenter);
	// helpCenter.click();
	UtilHBM.waitExplicitDisplayed(driver,
			driver.findElement(By.cssSelector("article[class='mod-help-center-with-footer mod-open']")));
	UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
	UtilHBM.waitExplicitClickable(driver, showDoorsWindowsTip);
	showDoorsWindowsTip.click();
	UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
	Verification.VerifyEquals("Doors Windows  title not correct", toolTipTitle.getText(), expectedBayTipLabel);
	Verification.VerifyEquals("Doors Windows info not correct ", toolTipInfo.getText(), expectedBayTip);
	hideTip.click();
	return this;
	
}
	public Tooltips tooltipsForDesignYourKitchen() {
		String expectedCustomizeTipLabel = "Customize your kitchen";
		String expectedCustomizeTip = "You can directly click on a cabinet to move it, modify it or swap it out with an another one.";
		String expectedCabinetTipLabel = "Add a cabinet";
		String expectedCabinetTip = "You can click here to find and add all types of cabinets in various dimensions.";
		String expectedApplianceTipLabel = "Add an appliance";
		String expectedApplianceTip = "You can click here to add cabinets which include appliances.";
		String expectedHideFrontTipLabel = "Hide cabinet fronts";
		String expectedHideFrontTip = "You can hide the cabinet fronts to check inside and see how you can manage your storage.";
		String expectedChangeViewTipLabel = "Change the view";
		String expectedChangeViewTip = "You can change the view and see your kitchen in 2D or 3D mode.";
		String expectedUndoActionTipLabel = "Undo action";
		String expectedUndoActionTip = "You can click here to undo your last actions.";
		String expectedPriceTipLabel = "Check your price";
		String expectedPriceTip = "When you make changes in your kitchen, the price is automatically updated.";

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", helpCenter);
//		UtilHBM.waitFixTime(2000);
		executor1.executeScript("arguments[0].click();", toolTipsPanel);

		showCustomizeTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Customize Kitchen title not correct", toolTipTitle.getText(),
				expectedCustomizeTipLabel);

		Verification.VerifyEquals("Customize Kitchen info not correct", toolTipInfo.getText(), expectedCustomizeTip);
		hideTip.click();

		showAddCabinetTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add cabinet title not correct", toolTipTitle.getText(), expectedCabinetTipLabel);
		Verification.VerifyEquals("Add cabinet info not correct ", toolTipInfo.getText(), expectedCabinetTip);
		hideTip.click();

		showAddAppliancesTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add appliances title not correct", toolTipTitle.getText(),
				expectedApplianceTipLabel);
		Verification.VerifyEquals("Add appliances info not correct ", toolTipInfo.getText(), expectedApplianceTip);
		hideTip.click();
		showHideFrontTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Hide front title not correct", toolTipTitle.getText(), expectedHideFrontTipLabel);
		Verification.VerifyEquals("Hide front info not correct", toolTipInfo.getText(), expectedHideFrontTip);
		hideTip.click();
		executor1.executeScript("arguments[0].click();", helpCenter);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, showChangeViewTip);
		UtilHBM.waitExplicitClickable(driver, showChangeViewTip);

		showChangeViewTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Change view title not correct", toolTipTitle.getText(), expectedChangeViewTipLabel);
		Verification.VerifyEquals("Change view info not correct", toolTipInfo.getText(), expectedChangeViewTip);
		hideTip.click();
		executor1.executeScript("arguments[0].click();", helpCenter);
//		UtilHBM.waitFixTime(1000);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver, showUndoActionTip);
		showUndoActionTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Undo action title not correct", toolTipTitle.getText(), expectedUndoActionTipLabel);
		Verification.VerifyEquals("Undo action info not correct", toolTipInfo.getText(), expectedUndoActionTip);
		hideTip.click();
		showPriceTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Price title not correct", toolTipTitle.getText(), expectedPriceTipLabel);
		Verification.VerifyEquals("Price info not correct", toolTipInfo.getText(), expectedPriceTip);
		hideTip.click();
		executor1.executeScript("arguments[0].click();", helpCenter);
		return this;

	}

	public Tooltips tooltipsForWorktopEditor() {
		String expectedCutOutTipLabel = "Add a cut-out";
		String expectedCutOutTip = "Select a worktop, in the menu click on the add button and choose your dimensions. You can always edit it them by selecting the cut out.";
		String expectedGrainTipLabel = "Change grain direction";
		String expectedGrainTip = "Select a worktop, click on the change button and select next or previous direction.";
		String expectedJointTipLabel = "Add a joint";
		String expectedJointTip = "Select an edge and click on the add button. You can remove it by selecting the joint.";
		String expectedEdgeProductTipLabel = "Change an edge product";
		String expectedEdgeProductTip = "Select an edge, click on the change button and choose your material reference.";
		String expectedEdgeCutTipLabel = "Add an edge cut";
		String expectedEdgeCutTip = "Select an edge, click on the add button and choose your dimensions.";
		String expectedSplitTipLabel = "Split an edge";
		String expectedSplitTip = "Select an edge and click on the split button.";
		String expectedCornerCutTipLabel = "Add a corner cut";
		String expectedCornerCutTip = "Select a corner, click on the add button and choose your dimensions.";
		String expectedMeasureTipLabel = "Edit measurements";
		String expectedMeasureTip = "You can adjust the measurements or click and drag the sides of the worktop to adjust it.";

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", helpCenter);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		executor1.executeScript("arguments[0].click();", toolTipsPanel);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(3000);
		UtilHBM.waitExplicitDisplayed(driver, showGrainTip);
		UtilHBM.waitExplicitClickable(driver, showGrainTip);
		showGrainTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Grain direction title not correct", toolTipTitle.getText(), expectedGrainTipLabel);
		Verification.VerifyEquals("Grain direction info not correct ", toolTipInfo.getText(), expectedGrainTip);
		hideTip.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, showSplitTip);
		showSplitTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Split edge title not correct", toolTipTitle.getText(), expectedSplitTipLabel);
		Verification.VerifyEquals("Split edge info not correct", toolTipInfo.getText(), expectedSplitTip);
		hideTip.click();
		UtilHBM.waitExplicitClickable(driver, showMeasureTip);
		showMeasureTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Edit measurement title not correct", toolTipTitle.getText(),
				expectedMeasureTipLabel);
		Verification.VerifyEquals("Edit measurement info not correct", toolTipInfo.getText(), expectedMeasureTip);
		hideTip.click();
		UtilHBM.waitExplicitClickable(driver, showEdgeProductTip);
		showEdgeProductTip.click();
		UtilHBM.waitExplicitClickable(driver, toolTipTitle);
		Verification.VerifyEquals("Edge product title not correct", toolTipTitle.getText(),
				expectedEdgeProductTipLabel);
		Verification.VerifyEquals("Edge product info not correct", toolTipInfo.getText(), expectedEdgeProductTip);
		hideTip.click();
		UtilHBM.waitExplicitClickable(driver, showEdgeCutTip);
		showEdgeCutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Edge cut title not correct", toolTipTitle.getText(), expectedEdgeCutTipLabel);
		Verification.VerifyEquals("Edge cut info not correct", toolTipInfo.getText(), expectedEdgeCutTip);
		hideTip.click();
		UtilHBM.waitExplicitClickable(driver, showAddJointTip);
		showAddJointTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add joint title not correct", toolTipTitle.getText(), expectedJointTipLabel);
		Verification.VerifyEquals("Add joint info not correct ", toolTipInfo.getText(), expectedJointTip);
		hideTip.click();
		UtilHBM.waitExplicitClickable(driver, showCornerCutTip);
		showCornerCutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Corner cut title not correct", toolTipTitle.getText(), expectedCornerCutTipLabel);
		Verification.VerifyEquals("Corner cut info not correct", toolTipInfo.getText(), expectedCornerCutTip);
		hideTip.click();

//		executor1.executeScript("arguments[0].click();", helpCenter);
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver, showCutOutTip);
		showCutOutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add cut-out title not correct", toolTipTitle.getText(), expectedCutOutTipLabel);

		Verification.VerifyEquals("Add cut-out info not correct", toolTipInfo.getText(), expectedCutOutTip);
		hideTip.click();

		planningHelpCenter.click();
		executor1.executeScript("arguments[0].click();", helpCenter);
		return this;

	}

	public Tooltips tooltipsForWallPanelEditor() {
		String expectedWPCutOutTipLabel = "Add a cut-out";
		String expectedWPCutOutTip = "Select a wall panel, click on the add button and choose your dimensions.";
		String expectedTripleCutTipLabel = "Add a triple cut";
		String expectedTripleCutTip = "Select an edge, click on the add button and choose your dimensions.";
		String expectedWPCornerCutTipLabel = "Add a corner cut";
		String expectedWPCornerCutTip = "Select a corner, click on the add button and choose your dimensions.";

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", helpCenter);
		UtilHBM.waitFixTime(2000);
		executor1.executeScript("arguments[0].click();", toolTipsPanel);
		UtilHBM.waitExplicitDisplayed(driver, showCutOutTip);
		showCutOutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add cut-out title not correct", toolTipTitle.getText(), expectedWPCutOutTipLabel);
		Verification.VerifyEquals("Add cut-out info not correct", toolTipInfo.getText(), expectedWPCutOutTip);
		hideTip.click();

		showAddTripleCutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Triple Cut title not correct", toolTipTitle.getText(), expectedTripleCutTipLabel);
		Verification.VerifyEquals("Triple Cut info not correct ", toolTipInfo.getText(), expectedTripleCutTip);
		hideTip.click();

		showWPAddCornerCutTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Corner cut title not correct", toolTipTitle.getText(), expectedWPCornerCutTipLabel);
		Verification.VerifyEquals("Corner cut info not correct ", toolTipInfo.getText(), expectedWPCornerCutTip);
		hideTip.click();
		driver.findElement(By.xpath("//button[@id='bt-tab-help-center-2']")).click();
		executor1.executeScript("arguments[0].click();", helpCenter);

		return this;

	}

	public Tooltips tooltipsForComposeFurniture() {
		String expectedSelectItemTipLabel = "Select an item";
		String expectedSelectItemTip = "You can click on an item to edit or delete it and customize your cabinet.";
		String expectedAddOnTipLabel = "Add on";
		String expectedAddOnTip = "If you have enough space, you can add a product to customise the cabinet.";
		String expectedMoveItemTipLabel = "Move an item";
		String expectedMoveItemTip = "If you have enough space, you can directly click on an item and move it up or down.";
		String expectedSeeInsideTipLabel = "See inside";
		String expectedSeeInsideTip = "You can open the cabinet to better see inside.";

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", helpCenter);
		UtilHBM.waitFixTime(2000);
		executor1.executeScript("arguments[0].click();", toolTipsPanel);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, showSelectItemTip);
		UtilHBM.waitExplicitClickable(driver, showSelectItemTip);
		showSelectItemTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Select item title not correct", toolTipTitle.getText(), expectedSelectItemTipLabel);
		Verification.VerifyEquals("Select item info not correct", toolTipInfo.getText(), expectedSelectItemTip);
		hideTip.click();

		showAddOnTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Add on title not correct", toolTipTitle.getText(), expectedAddOnTipLabel);
		Verification.VerifyEquals("Add on info not correct ", toolTipInfo.getText(), expectedAddOnTip);
		new Actions(driver).moveToElement(hideTip).click().build().perform();

		showMoveItemTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Move item title not correct", toolTipTitle.getText(), expectedMoveItemTipLabel);
		Verification.VerifyEquals("Move item info not correct ", toolTipInfo.getText(), expectedMoveItemTip);
		hideTip.click();

		showSeeInsideTip.click();
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("See inside title not correct", toolTipTitle.getText(), expectedSeeInsideTipLabel);
		Verification.VerifyEquals("See inside info not correct ", toolTipInfo.getText(), expectedSeeInsideTip);
		hideTip.click();

		return this;

	}
	public Tooltips tooltipsForPosition() {
		String expectedPositionTipLabel = "Position item";
		String expectedPositionTip = "Edit measurements to change the position of the item.";
		
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Position item title not correct", toolTipTitle.getText(), expectedPositionTipLabel);
		Verification.VerifyEquals("Position item info not correct ", toolTipInfo.getText(), expectedPositionTip);
		hideTip.click();

		return this;

	}
	public Tooltips tooltipsForRealisticImage() {
		String expectedRealisticTipLabel = "Create a realistic image";
		String expectedRealisticTip = "Realistic images allow you to create high quality visuals of your project.";
		
		UtilHBM.waitExplicitDisplayed(driver, toolTipTitle);
		Verification.VerifyEquals("Realistic images title not correct", toolTipTitle.getText(), expectedRealisticTipLabel);
		Verification.VerifyEquals("Realistic images info not correct ", toolTipInfo.getText(), expectedRealisticTip);
		hideTip.click();

		return this;

	}
}
