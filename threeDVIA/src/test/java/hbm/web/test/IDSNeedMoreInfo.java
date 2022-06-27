package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	@Test
	public class IDSNeedMoreInfo extends Browser{
		
		@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class)
		public void needMoreInfoIDS(SignUpData signUpData)  {
			LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
			homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.dates()
			.needMoreInfoIDS("IDS5","IDSOrder2");	
		}
}