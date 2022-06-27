package kitchen.templateEditor.scenarioTest;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.templateEditor.pageObject.Circulations;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Design;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TestTemplate;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class IIShaped extends Browser {
	public void teIIShapedKitchen() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage();
		Design design=PageFactory.initElements(driver, Design.class);
		design.verifyDesign();
		UtilHBM.hitArrowKeyDev(driver, 45, "Left");
		design.addProduct("U2DA80", true) 
		.addProduct("W8002", true).positionProduct(-134,-90 , 572, 650)
		.addProduct("KDSA60", true)
		.addProduct("KET600CHXE", true).positionProduct(-87, -90, 568,650)
		.addProduct("U2DA402", true)
		.addProduct("W4002", true).positionProduct(-31,-94, 572,650)
		.addProduct("KNIVES STORAGE", true).translateProduct(-52,48, 15,-120);
		UtilHBM.hitArrowKeyDev(driver, 90, "Right");
		design.addProduct("UD4SA60", true)
		.addProduct("WG6002", false)
		.addProduct("WG6002", false)	
		.addProduct("WG6002", false)
		.addProduct("SPUD60", true)
		.addProduct("UD4SA60", true)
		.addProduct("DRAINING RACK", true).translateProduct(-28,28, 15,-120);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("right_linear", "Mand", "Water", "IIShapedRightLinear");
		UtilHBM.hitArrowKeyDev(driver, 90, "Left");
		group.createGroup("left_linear", "Mand", "null", "IIShapedLeftLinear");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.faceToFaceRpC(90,110 , -75,-10);
		Circulations circulations=PageFactory.initElements(driver, Circulations.class);
		circulations.createCirculation("left_linear","group", -110,-10, "800;0;0;0");
		UtilHBM.hitArrowKeyDev(driver, 90, "Right");
		circulations.createCirculation("right_linear","group", -113,-19, "800;0;0;0");
		constraints.createDistanceToWallConstraint("IIShapedRightLinear");
		UtilHBM.hitArrowKeyDev(driver, 90, "Left");
		constraints.createDistanceToWallConstraint("IIShapedLeftLinear");
		UtilHBM.hitArrowKeyDev(driver, 45, "Right");
		constraints.alignmentConstraint(-117,100, 127,-11, 94,39, 0);
		TestTemplate test=PageFactory.initElements(driver, TestTemplate.class);
		test.testTemplate(1, 4, 0, "")
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("IIShaped");
		
		}
}
