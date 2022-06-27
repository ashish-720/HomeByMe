package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login extends Browser{
	@Test(dataProvider="bryoLogin", dataProviderClass=SignUpData.class)
	public void loginTest(SignUpData signUpData){		
		StartNow start = PageFactory.initElements(driver,
				StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData);
		
	}
	
	@Test(dependsOnMethods={"loginTest"})
	public void logoutTest(){
		StartNow start = PageFactory.initElements(driver,
				StartNow.class);
		start.logout();
	}
	
}
