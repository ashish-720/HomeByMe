package kitchen.templateEditor.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class EditGroup extends Browser {

	public void teEditGroup() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage()
		.verifyDesign().addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("Group 1", "Mand", "null", "BaseCabinet")
		.goToDesignPage()
		.saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("editGroup")
		.goToDesignPage().close();
		start.startNow();
		floorplan.verifyFloorplan().reopenProject("editGroup")
		.verifyDesign()
		.addProduct("UD4SA60", true);
		group.editGroup("Group 1", "Group 2", "Mand", "null", "EditGrp")
		.goToDesignPage().saveProject();
		transferFile.transferFile("editGroupV1");
	}
}
