package kitchen.templateEditor.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Circulations;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class EditCirculations extends Browser {

	public void teEditCirculations() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage()
		.verifyDesign().addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("Group 1", "Mand", "null", "BaseCabinet");
		Circulations circulations=PageFactory.initElements(driver, Circulations.class);
		circulations.createCirculation("Group 1", "group", -40, 2, "300;0;0;0")
		.goToDesignPage().saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("editCirculation")
		.goToDesignPage().close();
		start.startNow().verifyFloorplan().reopenProject("editCirculation").verifyDesign();
		circulations.verifyCirculation("Group 1", "300;0;0;0")
		.editCirculations("Group 1", "500;0;0;0").goToDesignPage().saveProject();
		transferFile.transferFile("editCirculationV1");
	}
}
