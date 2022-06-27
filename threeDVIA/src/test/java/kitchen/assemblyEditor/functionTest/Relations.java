package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class Relations extends Browser {
    public void aeRelations() {
        StartApplication startApplication = PageFactory.initElements(driver, StartApplication.class);
        startApplication.startApp()
		.addNewRelation("drawer_y", "number", "-depth*0.5")
		.verifyRelation("drawer_y", "number", "0", "-depth*0.5", "Identifier 'depth' is unknown.")
		.addNewParameter("depth", "number", "600")
		.addNewParameter("rightLegOption", "integer", "1")
		.addNewRelation("activateLeg_1", "boolean", "(rightLegOption === 0) ? false : true")
		.verifyRelation("activateLeg_1", "boolean", "true", "(rightLegOption === 0) ? false : true")
		.duplicateRelation("drawer_y")
		.verifyRelation("drawer_y-copy0", "number", "-300", "-depth*0.5")
		.verifyRelationCount(3)
		.deleteRelation("activateLeg_1")
		.verifyRelationCount(2);
    }
}
