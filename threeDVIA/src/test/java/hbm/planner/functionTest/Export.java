package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import java.io.IOException;
import kitchen.templateEditor.pageObject.TransferFile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Export extends Browser{
	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void export (SignUpData signUpData) throws IOException{		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToMyProjects()
		.openOwnProject(0, "INL_AUTO_TEST_PROJECT")
		.openProject()
		.twoDView()
		.export()
		.exportDSHBMConfirmation(false)
		.export()
		.exportDSHBMConfirmation(true);
		TransferFile transferFile=PageFactory.initElements(driver, TransferFile.class);
		transferFile.exportTransferFile("ExportToDraftSight")
		;
	}

}
