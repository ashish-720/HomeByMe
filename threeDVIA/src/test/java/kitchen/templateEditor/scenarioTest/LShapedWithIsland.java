package kitchen.templateEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.templateEditor.pageObject.Circulations;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.Substitutions;
import kitchen.templateEditor.pageObject.TestTemplate;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class LShapedWithIsland extends Browser {

	public void teLShapedWithIsland() throws IOException 
	{
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.goToDesignPage()
		.verifyDesign()
		.addProduct("UEDBD10060L", true).translateProduct(-95,15, 200,-13)
		.addProduct("CKT600", true)
		.addProduct("U2DA80", true).translateProduct(-95,15, 157,84)
		.addProduct("U2DA80", true).translateProduct(-95,15, 100,84)
		.addProduct("UD4SA60", true).translateProduct(-95,14, 150,-10)
		.addProduct("SPUDASA60", true).translateProduct(-95,14, 100,-10)
		.addProduct("U2DA402", true).translateProduct(-128,2 , 70,-10)
		.addProduct("U2DA402", true).translateProduct(-100,-2, 280,25)
		.addProduct("GMO032", true).translateProduct(157,18 ,240,-30)
		.addProduct("GVARIO03", true)
		.addProduct("W4002", true)
		.addProduct("W6002", true)
		.addProduct("W6002", true)
		.addProduct("WDAF6001", true).positionProduct(46,-100,548,748)
		.addProduct("WG6002", false)
		.addProduct("WG6002", false)
		.addProduct("CLOCK", true).translateProduct(-130,-110, 334,190)
		.addProduct("KNIVES STORAGE", true).translateProduct(-28,51, 22,-120)
		.addProduct("CUPS HANGER", true).translateProduct(-25,44, 130,-115)
		.addProduct("FRUITS BASKET", true).translateProduct(-28,45, 80,-15);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("left_linear","Mand","Water", "LShapedWithIslandLeftLinear");
		group.createGroup("island", "Optional", "RoomSeparator", "LShapedWithIslandIsland");
		UtilHBM.hitArrowKeyDev(driver, 20, "Right");
		group.createGroup("right_linear","Mand","RoomSeperator", "LShapedWithIslandRightLinear");
		Circulations circulations=PageFactory.initElements(driver, Circulations.class);
		circulations.createCirculation("island","group", 21,52, "300;300;300;300");
		Substitutions substitutions=PageFactory.initElements(driver, Substitutions.class);
		substitutions.createSubtitution("LshapedWithIslandLeftLinear");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.createCornerConstraint(6,-50, "right", "open")
		.perpendicularToASpecificSideRpC(-140,60, 103,-43)
		.onSameWallRpC(-140,60, 19,53)
		.alignmentConstraint(-27,0, 59,41 , -25,21 , 100)
		.distanceConstraint(4,-51, 33,-29, 28,-12 , "0/-10/10");
		TestTemplate test=PageFactory.initElements(driver, TestTemplate.class);
		test.testTemplate(1, 4, 0, "")
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("LShapedWithIsland");
	}
}
