package kitchen.templateEditor.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.Group;
import kitchen.templateEditor.pageObject.StartNow;
import kitchen.templateEditor.pageObject.Substitutions;
import kitchen.templateEditor.pageObject.TransferFile;

@Test
public class EditSubstitutions extends Browser {

	public void teEditSubstitutions() throws IOException {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan().goToDesignPage()
		.verifyDesign().addProduct("U2DA80", true)
		.addProduct("U2DA80", true)
		.addProduct("U2DA80", true);
		Group group=PageFactory.initElements(driver, Group.class);
		group.createGroup("Group 1", "Mand", "null", "BaseCabinet");
		Substitutions substitutions=PageFactory.initElements(driver, Substitutions.class);
		substitutions.createSubtitution("BaseCabinet").goToDesignPage().saveProject();
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.transferFile("EditSubstitution").goToDesignPage().close();
		start.startNow().verifyFloorplan().reopenProject("EditSubstitution");
		substitutions.editSubstitution("Group 1", "BaseCabinetEdit");
	}
}
