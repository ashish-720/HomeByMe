package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class Animations extends Browser 
{
	public void aeAnimation()
	{
		StartApplication startApplication=PageFactory.initElements(driver, StartApplication.class);
		startApplication.startApp()
		.addRotation(100,100,100,1,1,1)
		.previewAnimation()
		.verifyRotation(100, 100, 100, 1, 1, 1)
		.deleteAnimation()
		.addTranslation(100, 50, 0)
		.previewAnimation()
		.verifyTranslation(100, 50, 0)
		.deleteAnimation();
		
	}
}
