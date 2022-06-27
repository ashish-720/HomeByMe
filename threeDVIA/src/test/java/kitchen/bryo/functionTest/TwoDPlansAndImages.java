package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TwoDPlansAndImages extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void twoDPlansAndImages(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start
//		.login(signUpData)
//		.openMyProjectList()
//		.searchProject("ODT_TwoPlansAndImages")
//		.openProject(0, "ODT_TwoPlansAndImages")
		.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.step4()
		.verifyStep4()
		.verify2DPlansAndImages("Plans", 3)
		.clickShowImages()
		.verifyProjectPlans(3)
		.verifyProjectImages(0,0)
		.close2DplanAndImagesLayer()
		.clickDesignStep()
		.saveProjectInStep3(signUpData, "ODT_TwoPlansAndImages", "plans and images test")
		.realisticImage(2)
		.panoramic360Image(3)
		.step4()
		.verifyRenderingInProgress(2)
		.clickShowImages()
		.verifyProjectPlans(3)
		.verifyProjectImages(1,1)
		.close2DplanAndImagesLayer();
	}
}

