package hbm.threeDCloudByMe.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateFamilyContributor extends Browser{

	@Test(dataProvider="cloudCont", dataProviderClass=SignUpData.class)
	public void createFamilyCont(SignUpData signUpData)
	{
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.changeLE("MAISONSDUMONDE")
		.goToFamilyPage()
		.createNewFamily("Test_family", "Lamp_cont;Chair_cont;Carpet_cont","cont")
		.logout();
	}
}