package kitchen.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class CreateFamily extends Browser{
	
	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createFamily(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.goToFamilyPage()
		.createNewFamily("Test_family", "UA80_bryoCont;Chair_bryoCont;Lamp_bryoCont;Carpet_cont","bryoCont")
		.logout();
	}
}