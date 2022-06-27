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
public class EditRpcFacingSameDircConstraint extends Browser {

	public void teEditRpcSameDircConstraint() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage()
		.verifyDesign().addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("Group 1", "Mand", "null", "BaseCabinet1");
		group.createGroup("Group 2", "Mand", "null", "BaseCabinet2");
		Constraints constraints=PageFactory.initElements(driver, Constraints.class);
		constraints.faceSameDircRpC(-105,2, 15,2).goToDesignPage().saveProject().close();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("EditRpcFaceSameDircConstraint");
		start.startNow().verifyFloorplan().goToDesignPage().reopenProject("EditRpcFaceSameDircConstraint");
		constraints.editFaceSameDircRpc(15,2, -105,2).goToDesignPage().saveProject().close();
		transferFile.transferFile("EditRpcFaceSameDircConstraintV1");
	}
}
