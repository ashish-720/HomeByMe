package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class OutputSets extends Browser 
{
	public void aeOutputSets()
	{
		StartApplication startApplication=PageFactory.initElements(driver, StartApplication.class);
		startApplication.startApp()
		.addNewOutputSet("polyline", "narrowTopPath")
		.addNewPolyLine(1)
		.addNewPoint(1,1,300,-300,680)
		.verifyPolyLine(1,"narrowTopPath",1)
		.verifyPoint(1, 1, 300, -300,680)
		.duplicateOutputSet(1)
		.verifyOutputSetCount(2)
		.deleteOutputSet(1)
		.deleteOutputSet(1)
		.addNewOutputSet("edgeline", "outputset1")
		.addNewEdgeLine(1).setEdgeLineDetails(1, 1, 100, 100, 100, 100)
		.deleteOutputSet(1);
	}
}
