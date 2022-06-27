package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class DeletePrdAdmin extends Browser{
	
	@Test(dataProvider="cloudAdmin", dataProviderClass=SignUpData.class)
	public void deleteProductAdmin(SignUpData signUpData){

		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
		.deleteProduct("UA80","admin")
		.logout();
		
	}
}