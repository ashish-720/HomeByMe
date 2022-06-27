package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RecoverProjectTest extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void recoverProjectTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false,false)
		.addProduct("U2DA80", true, false,false)
		.addProduct("W6002", true, false,false)
		.refreshApplication()
		.startFromScratch()
		.recoverProject("yes")
		.verifyProduct(-45, -115, "W6002")
		.verifyPrice("1 754,00");

	}

}
