package kitchen.templateEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Circulations;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Design;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TestTemplate;
import kitchen.templateEditor.pageObject.TransferFile;

 
@Test
public class IShaped extends Browser {
	
	public void teIShapedKitchen() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan().goToDesignPage();
		Design design=PageFactory.initElements(driver, Design.class);
		design.verifyDesign()
		.addProduct("U2DA80", true)
		.addProduct("W8001", true).positionProduct(-112, -88 , 572,650)
		.addProduct("CKT800", true)
		.addProduct("KET600CHXE", true).positionProduct(863,940).positionProduct(-55,-97,566, 650)
		.addProduct("UD4SA60", true)
		.addProduct("W6001", true).positionProduct(10,-87 , 572,650)
		.addProduct("KNIVES STORAGE", true).translateProduct(-28,51, 35,-120);
		Group g1=PageFactory.initElements(driver, Group.class);
		g1.createGroup("group1","Mand","null","IShapedCooktopLinear");
		Circulations circulations=PageFactory.initElements(driver, Circulations.class);
		circulations.createCirculation("cooktop_linear","group", -58, -1, "800;0;0;0");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.createDistanceToWallConstraint("IShaped");
		TestTemplate test=PageFactory.initElements(driver, TestTemplate.class);
		test.testTemplate(1,4, 0, "")
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("IShaped");
		
	}
}