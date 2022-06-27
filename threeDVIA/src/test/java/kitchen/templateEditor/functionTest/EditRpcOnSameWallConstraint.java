package kitchen.templateEditor.functionTest;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Scenarios for KIT-1597 : As a range maintainer, I can see the type of "relative placement" constraint
@Test
public class EditRpcOnSameWallConstraint extends Browser {

    public void editRpcOnSameWallConstraint() throws IOException {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startNow();
        Floorplan floorplan = PageFactory.initElements(driver, Floorplan.class);
        floorplan.verifyFloorplan().goToDesignPage()
                .verifyDesign().addProduct("U2DA80", true)
                .addProduct("UD4SA60", true)
                .addProduct("U2DA80", true).translateProduct(0, -15, 130, -15)
                .addProduct("UD2SA80", true);
        Group group = PageFactory.initElements(driver, Group.class);
        group.createGroup("Group 1", "Mand", "null", "EditRpcOnSameWallConstraintCabinetGrp1");
        group.createGroup("Group 2", "Mand", "null", "EditRpcOnSameWallConstraintCabinetGrp2");
        group.createGroup("Group 3", "Mand", "null", "EditRpcOnSameWallConstraintCabinetGrp3");

        //Scenario : Add OnSame Wall RPC
        Constraints constraints = PageFactory.initElements(driver, Constraints.class);
        constraints.onSameWallRpC(-105, -15, 60, -15);
        TestTemplate template = PageFactory.initElements(driver, TestTemplate.class);
        template.testTemplate(1, 5, 1, "3 242,00").saveProject().close();
        TransferFile transferFile = PageFactory.initElements(driver, TransferFile.class);
        transferFile.transferFile("EditRpcOnSameWallConstraint");

        //Scenario : Edit OnSameWall RPC
        start.startNow().verifyFloorplan().goToDesignPage().reopenProject("EditRpcOnSameWallConstraint");
        constraints.editOnSameWallRpc("", "120,-15");
        template.testTemplate(1, 5, 1, "3 242,00").saveProject().close();
        transferFile.transferFile("EditRpcOnSameWallConstraintV1");

        //Scenario : Two different relative placement constraints present simultaneously
        start.startNow().verifyFloorplan().goToDesignPage().reopenProject("EditRpcOnSameWallConstraintV1");
        constraints.faceToFaceRpC(-80, 30, 70, 15);
        template.testTemplate(1, 4, 1, "3 242,00").saveProject().close();
        transferFile.transferFile("EditRpcOnSameWallConstraintV2");

        //Scenario : delete RPC
        start.startNow().verifyFloorplan().goToDesignPage().reopenProject("EditRpcOnSameWallConstraintV2");
        constraints.deleteConstraint("RelativePlacement");

        //Scenario : Two contradicting RPC present together
        constraints.faceToFaceRpC(-105, -15, 120, -15);
        template.testTemplate(1, 0, 0, "").saveProject().close();
        transferFile.transferFile("EditRpcOnSameWallConstraintV3");
    }
}
