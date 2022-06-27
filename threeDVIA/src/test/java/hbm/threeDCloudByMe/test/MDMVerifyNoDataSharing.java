package hbm.threeDCloudByMe.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.threeDCloudByMe.pageObject.Content;
import kitchen.threeDCloudByMe.pageObject.Login3DCloudByMe;

public class MDMVerifyNoDataSharing extends Browser {

	@Test(dataProvider = "cloudSupAdmin", dataProviderClass = SignUpData.class)
	public void mdmVerifyNoDataSharing(SignUpData signUpData) {
		Login3DCloudByMe login = PageFactory.initElements(driver, Login3DCloudByMe.class);
		login.login(signUpData)
			.changeLE("GAUTIER")
			.goToStatsPage()
			.userAvailability(signUpData, "No");
		Content content = PageFactory.initElements(driver, Content.class);
		content.logout();
	}
}

