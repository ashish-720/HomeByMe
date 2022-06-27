package kitchen.assemblyEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.AssemblyEditor;
import kitchen.assemblyEditor.pageObject.StartApplication;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class CreateBoxAssembly extends Browser {
	public void createBoxAssembly() throws IOException 
		{
			StartApplication startApplication=PageFactory.initElements(driver, StartApplication.class);
			startApplication.startApp() 
			.addNewParameter("legHeight","number","80")
			.addNewParameter("leg","component","Legs","Leg")
			.addNewParameter("leftLegOption","integer","1")
			.addNewParameter("rightLegOption","integer","1")
			.addNewParameter("yFrontLegOffset","number","100")
			.addNewParameter("yBackLegOffset","number","80")
			.addNewParameter("xLegOffset","number","60")
			.addNewParameter("depth","number","600")
			.addNewParameter("drawerDepth","number","542")
			.addNewParameter("width","number","600")
			.addNewParameter("height","number","800")
			.addNewParameter("drawerHeight","number","400")
			.addNewParameter("leftCoverPanel","component","Side Panel","MADELEINE")
			.addNewParameter("rightCoverPanel","component","Side Panel","MADELEINE")
			.addNewParameter("backCoverPanel","component","Back Panel","MADELEINE")
			.addNewParameter("leftCoverOption","boolean","true")
			.addNewParameter("rightCoverOption","boolean","true")
			.addNewParameter("backCoverOption","boolean","true")
			.addNewComponent("legAssembly_1","catalog","legAssembly_ODT","legAssembly_ODT")
			.addNewComponent("box_1","catalog","box","ODT_BoxForCreateBoxAssembly")
//			.addNewComponent("DRAWER_01","catalog","drawer 400","DRAWER 400")
//			.addNewComponent("DRAWER_02","catalog","drawer 200","DRAWER 200")
			.addNewComponent("DRAWER_01","catalog","ODT_DrawerForCreateBoxAssembly","ODT_DrawerForCreateBoxAssembly")
			.addNewComponent("DRAWER_02","catalog","ODT_DrawerForCreateBoxAssembly","ODT_DrawerForCreateBoxAssembly")
			.addNewRelation("drawer_y","number","-depth*0.5")
			.addNewRelation("drawer_1_z","number","legHeight")
			.addNewRelation("drawer_2_z","number","legHeight+400")
			.addYComponentPosition("DRAWER_01","symbol","drawer_y")
			.addZComponentPosition("DRAWER_01","symbol","drawer_1_z")
			.addYComponentPosition("DRAWER_02","symbol","drawer_y")
			.addZComponentPosition("DRAWER_02","symbol","drawer_2_z")
			.addComponentOverloads("box_1","depth","symbol","depth")
			.addComponentOverloads("box_1","width","symbol","width")
			.addComponentOverloads("box_1","height","symbol","height")
			.addComponentOverloads("box_1","leftCoverPanel","symbol","leftCoverPanel")
			.addComponentOverloads("box_1","rightCoverPanel","symbol","rightCoverPanel")
			.addComponentOverloads("box_1","backCoverPanel","symbol","backCoverPanel")
			.addComponentOverloads("box_1","leftCoverOption","symbol","leftCoverOption")
			.addComponentOverloads("box_1","rightCoverOption","symbol","rightCoverOption")
			.addComponentOverloads("box_1","backCoverOption","symbol","backCoverOption")
			.addComponentOverloads("legAssembly_1","leg","symbol","leg")
			.addComponentOverloads("legAssembly_1","legHeight","symbol","legHeight")
			.addComponentOverloads("legAssembly_1","boxDepth","symbol","depth")
			.addComponentOverloads("legAssembly_1","boxWidth","symbol","width")
			.addComponentOverloads("legAssembly_1","xLegOffset","symbol","xLegOffset")
			.addComponentOverloads("legAssembly_1","leftLegOption","symbol","leftLegOption")
			.addComponentOverloads("legAssembly_1","rightLegOption","symbol","rightLegOption")
			.addComponentOverloads("legAssembly_1","yBackLegOffset","symbol","yBackLegOffset")
			.addComponentOverloads("legAssembly_1","yFrontLegOffset","symbol","yFrontLegOffset")
			.addComponentOverloads("DRAWER_01","depth","symbol","depth")
			.addComponentOverloads("DRAWER_01","width","symbol","width")
			.addComponentOverloads("DRAWER_01","height","symbol","drawerHeight")
			.addComponentOverloads("DRAWER_01","drawerDepth","symbol","drawerDepth")
			.addComponentOverloads("DRAWER_02","width","symbol","width")
			.addComponentOverloads("DRAWER_02","depth","symbol","depth")
			.addComponentOverloads("DRAWER_02","height","symbol","drawerHeight")
			.addComponentOverloads("DRAWER_02","drawerDepth","symbol","drawerDepth")
			.select3DProduct(140,150).verifyComponent("DRAWER_01", "ODT_DrawerForCreateBoxAssembly")
			.showHideComponent("DRAWER_01",false,"hide")
			.select3DProduct(140,150).verifyComponent("box_1", "ODT_BoxForCreateBoxAssembly")
			.showHideComponent("DRAWER_01",true,"show")
			.select3DProduct(140,150).verifyComponent("DRAWER_01", "ODT_DrawerForCreateBoxAssembly")
			.openComponent("DRAWER_01",false).switchToWindowWithComponent("76337")
			.select3DProduct(-10,160).verifyComponent("DrawerFront", "drawerFront (MADELEINE)")
			.returnToParentComponentWindow()
			.addTranslation(300, 0, 0)
			.addNewOutputSet("polyline", "narrowTopPath")
			.addNewPolyLine(1)
			.addNewPoint(1,1,300,-300,880)
			.addNewPoint(1,1,-300,-300,880)
			.verifyPolyLine(1, "narrowTopPath", 1)
			.verifyPoint(1, 1, 300,-300,880)
			.verifyOutputSetCount(1)
			.addAnchorPoint()
			.addAnchorPointPosition(0,0,300,580)
//			.addAnchorPointReceiveTag(0, "DRAWER_100")
//			.addAnchorPointReceiveTag(0, "DRAWER_200")
			.saveAssembly();
			TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
			transferFile.transferFile("BoxAssembly");
			AssemblyEditor assemblyEditor=PageFactory.initElements(driver, AssemblyEditor.class);
			assemblyEditor.unzipBmaProject("BoxAssembly");
		}
}