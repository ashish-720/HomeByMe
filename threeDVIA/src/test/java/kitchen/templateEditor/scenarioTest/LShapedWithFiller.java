package kitchen.templateEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Design;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TestTemplate;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class LShapedWithFiller extends Browser {

	public void teLShapedWithFillerkitchen() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan().goToDesignPage();		
		Design design=PageFactory.initElements(driver, Design.class);
		design.verifyDesign()
		.addProduct("CORNER FILLER BASE UNIT", "0")
		.addProduct("KDSA60", true)
		.addProduct("VANEAU", true).positionProduct(-59,-93, 768,650)
		.addProduct("UD4SA60", true).translateProduct(-9,-2, -124,30)
		.addProduct("UD4SA60", true)
		.addProduct("W6001", true).positionProduct(-11,-100, 572,650)
		.addProduct("KNIVES STORAGE", true).translateProduct(-28,51, 15,-120)
		.addProduct("SPUD40", true).translateProduct(26,-14, -175,70);
		UtilHBM.hitArrowKeyDev(driver, 45, "Left");
		design.addProduct("WG4002", false).positionProduct(25, -99, 393, 575)
		.addProduct("WG6002", false)
		.addProduct("DRAINING RACK", true).translateProduct(-50,48 , 110, -110)
		//KIT-1596
		.verifyPrice("9 401,00");
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("left_linear", "Mand", "Water", "LShapedWithFillerLeftLinear");
		UtilHBM.hitArrowKeyDev(driver, 45, "Right");
		group.createGroup("right_linear", "Mand", "null", "LShapedWithFillerRightLinear");
		UtilHBM.hitArrowKeyDev(driver, 23, "Left");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.perpendicularToASpecificSideRpC(-39,18 , 50,24)
		.createCornerFillerConstraint("LShapedWithFiller");
		TestTemplate test=PageFactory.initElements(driver, TestTemplate.class);
		test.testTemplate(1, 4, 4, "9 401,00")
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("LShapedWithFiller");
	}
}

