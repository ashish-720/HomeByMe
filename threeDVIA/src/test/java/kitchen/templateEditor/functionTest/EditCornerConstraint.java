package kitchen.templateEditor.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Constraints;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class EditCornerConstraint extends Browser {

	public void teEditCornerConstraint() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage()
		.verifyDesign().addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("Group 1", "Mand", "null", "BaseCabinet");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.createCornerConstraint(-100,-3, "right", "open").goToDesignPage().saveProject().close();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("EditCornerConstraint");
		start.startNow().verifyFloorplan().goToDesignPage().reopenProject("EditCornerConstraint");
		constraints.editCornerConstraint("left", "close").goToDesignPage().saveProject().close();
		transferFile.transferFile("EditCornerConstraintV1");
	}
}
