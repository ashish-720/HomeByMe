package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class VerifyProductEmbededLink extends Browser{
	
	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
	public void byMePrdViewer(SignUpData signUpData){

		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("3DVIA")
		.selectProduct("Lamp", "cont")
		.verifyShareLink("Lamp_cont");
	}
}
