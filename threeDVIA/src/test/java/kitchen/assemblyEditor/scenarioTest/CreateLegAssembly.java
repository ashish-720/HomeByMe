package kitchen.assemblyEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.AssemblyEditor;
import kitchen.assemblyEditor.pageObject.StartApplication;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class CreateLegAssembly extends Browser 
{
	public void createLegAssembly() throws IOException 
	{
		StartApplication startApplication=PageFactory.initElements(driver, StartApplication.class);
		startApplication.startApp()
		.addNewParameter("leg","component","leg","leg (13805)")
		.addNewParameter("height","number","80")
		.addNewParameter("xLegOffset","number","60")
		.addNewParameter("yFrontLegOffset","number","120")
		.addNewParameter("yBackLegOffset","number","80")
		.addNewParameter("rightLegOption","integer","1")
		.addNewParameter("leftLegOption","integer","1")
		.addNewParameter("boxWidth","number","400")
		.addNewParameter("boxDepth","number","600")
		.addNewComponent("Leg_1", "symbol", "leg")
		.addNewComponent("Leg_2","symbol", "leg")
		.addNewComponent("Leg_3","symbol", "leg")
		.addNewComponent("Leg_4","symbol", "leg")
		.addNewRelation("legWidth", "number", "(leg!==null)&&(Leg_1!==null)?Leg_1.width:0")
		.addNewRelation("legDepth", "number", "(leg!==null)&&(Leg_1!==null)?Leg_1.depth:0")
		.addNewRelation("xRightLegPosition", "number", "boxWidth*0.5-xLegOffset-legWidth*0.5")
		.addNewRelation("xLeftLegOption", "number", "(leftLegOption === 2) || (leftLegOption === 3) ? -boxWidth*0.5 : -boxWidth*0.5+xLegOffset+legWidth*0.5")
		.addNewRelation("yFrontLegPosition", "number", "-boxDepth*0.5 + yFrontLegOffset+legDepth*0.5")
		.addNewRelation("yBackLegPosition", "number", "boxDepth*0.5-yBackLegOffset-legDepth*0.5")
		.addNewRelation("activateLeg_1", "boolean", "(rightLegOption === 0) ? false : true")
		.addNewRelation("activateLeg_2", "boolean", "(rightLegOption === 0) || (rightLegOption === 2) ? false : true")
		.addNewRelation("activateLeg_4", "boolean", "(leftLegOption === 3)||(leftLegOption === 4) ? false : true")
		.componentSelectActivated("Leg_1","activateLeg_1")
		.componentSelectActivated("Leg_2", "activateLeg_2")
		.componentSelectActivated("Leg_4", "activateLeg_4")
		.addXComponentPosition("Leg_1","symbol","xRightLegPosition")
		.addXComponentPosition("Leg_2","symbol","xRightLegPosition")
		.addXComponentPosition("Leg_3","symbol","xLeftLegOption")
		.addXComponentPosition("Leg_4","symbol","xLeftLegOption")
		.addYComponentPosition("Leg_1","symbol","yFrontLegPosition")
		.addYComponentPosition("Leg_2","symbol","yBackLegPosition")
		.addYComponentPosition("Leg_3", "symbol","yFrontLegPosition")
		.addYComponentPosition("Leg_4", "symbol","yBackLegPosition")
		.addComponentYYOrientation("Leg_3","value","1")
		.addComponentYYOrientation("Leg_4","value","-1")
		.addComponentOverloads("Leg_1", "height", "symbol", "height")
		.addComponentOverloads("Leg_2","height","symbol","height")
		.addComponentOverloads("Leg_3","height","symbol","height")
		.addComponentOverloads("Leg_4", "height","symbol","height")
		.select3DProduct(87, 181).verifyComponent("Leg_1", "leg (leg)")
		.select3DProduct(15, 230).verifyComponent("Leg_3", "leg (leg)")
		.select3DProduct(-21, 118).verifyComponent("Leg_2", "leg (leg)")
		.select3DProduct(-94, 177).verifyComponent("Leg_4", "leg (leg)")
		.saveAssembly();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("LegAssembly");
		AssemblyEditor assemblyEditor=PageFactory.initElements(driver, AssemblyEditor.class);
		assemblyEditor.unzipBmaProject("LegAssembly");
	} 
}
