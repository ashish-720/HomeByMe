package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class Parameters extends Browser 
{
	public void aeParameters()
	{
		StartApplication startApplication=PageFactory.initElements(driver, StartApplication.class);
		startApplication.startApp()
		.addNewParameter("leg","component","leg","leg (13805)")
		.addNewParameter("height", "number", "80")
		.verifyParameter("leg", "component", "leg")
		.verifyParameter("height", "number", "80")
		.duplicateParameter("height")
		.verifyParameter("height-copy0", "number", "80")
		.verifyParameterCount(3)
		.editParameter("height", "newHeight", "number", "100")
		.verifyParameter("newHeight", "number", "100")
		.deleteParameter("height");
	}
}