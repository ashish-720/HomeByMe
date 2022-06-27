package kitchen.templateEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Design;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TestTemplate;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class UShaped extends Browser {
	public void teUShapedKitchen() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow()
		.verifyFloorplan();
		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
		plan.editWallDimension(-2,-247, "3550 mm", "apply right");
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.goToDesignPage();
		Design design=PageFactory.initElements(driver, Design.class);
		design.verifyDesign()
		.addProduct("UEDBD10060L", true).translateProduct(-95,15 , -118,0)
		.addProduct("UEDBD10060L", true).translateProduct(20,3 , 79,0)
		.addProduct("UD4SA80", true).translateProduct(0,0,15,0)
		.addProduct("UD4SA80", true).translateProduct(124,78 , -190,-90)
		.addProduct("UD4SA80", true).translateProduct(124,78 , 135,-40)
		.addProduct("UD4SA80", true)
		.addProduct("UD4SA80", true).translateProduct(124,78 , -260,-80);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("middle_linear","Mand","null","UShapedMiddleLinear");
		UtilHBM.hitArrowKeyDev(driver, 20, "Left");
		group.createGroup("left_linear","Mand","null","UShapedLeftLinear");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.createCornerConstraint(-31,-21, "right", "open")
		.perpendicularToASpecificSideRpC(-31,-21, 24,-22)
		.distanceConstraint(-31,-21, 24,-22, -6,-1, "0/-10/10");
		UtilHBM.hitArrowKeyDev(driver, 50, "Right");
		group.createGroup("right_linear","Mand","null","UShapedRightLinear");
		constraints.createCornerConstraint(-59,-14, "right", "open")
		.perpendicularToASpecificSideRpC(-59,-14 , -8,-17)
		.distanceConstraint(-59, -14, -20,-17, -27, 13, "0/-10/10");
		TestTemplate test=PageFactory.initElements(driver, TestTemplate.class);
		test.testTemplate(0, 2, 0, "")
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("UShaped");
	}
}