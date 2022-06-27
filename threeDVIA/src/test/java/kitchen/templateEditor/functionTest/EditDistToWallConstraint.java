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
public class EditDistToWallConstraint extends Browser {

	public void teEditDistToWallConstraint() throws IOException {
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
		constraints.createDistanceToWallConstraint("BaseCabinet")
		.goToDesignPage().saveProject().close();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("EditDistToWallConstraint");
		start.startNow();
		floorplan.verifyFloorplan().reopenProject("EditDistToWallConstraint");
		constraints.editDistanceToWallConstraint("BaseCabinetEdit").goToDesignPage().saveProject();
		transferFile.transferFile("EditDistToWallConstraintV1");
		
	}
}
