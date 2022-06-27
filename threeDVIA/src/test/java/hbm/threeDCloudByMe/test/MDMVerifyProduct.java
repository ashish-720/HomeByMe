package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Content;
import kitchen.threeDCloudByMe.pageObject.Dashboard;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class MDMVerifyProduct extends Browser{ 
	@Test(dataProvider="cloudSupAdmin", dataProviderClass=SignUpData.class)		
	public void verifyMDMProduct(SignUpData signUpData)
	{			
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
			.changeLE("MAISONSDUMONDE")
			.openProduct()
			.verifyProductBrand("MAISONS DU MONDE");
		Content content = PageFactory.initElements(driver, Content.class);
		content.logout();
	}
}
