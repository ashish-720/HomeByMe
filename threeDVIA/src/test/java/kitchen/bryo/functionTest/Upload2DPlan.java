package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;


	@Test
	public class Upload2DPlan extends Browser {
		
		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void upload2DPlan(SignUpData signUpData) {
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.startDemo("en-GB")
			.login(signUpData)
			.openMyProjectList()
			.searchProject("upload 2D plan")
			.openProject(0, "upload 2D plan")
			.clickFloorplan()
			.uploadTwoDPlan()
			.getStarted()
			.selectFile("AutoFP.jpg")
			.selectFloorPlan(50, 60)
			.zoomIn(2)
			.zoomOut(2)
			.yourPlan()
			.deleteYourPlan()
			.deleteNo()
			.changeYourPlan()
			.selectFile("AutoFP.jpg")
			.selectFloorPlan(50, 60)
			.undo(driver, 1)
			.redo(driver,1)
			.selectFloorPlan(50, 60)
			.yourPlan()
			.deleteYourPlan()
			.deleteYes()
			.selectFile("IDSBook.pdf")
			.chooseThisPage()
			.selectFloorPlan(50, 60)
			.rotation(-10, 20, "243")
			.opacity(20, 0, "66")
			.move()
			.movePlan(50, 60, 100, 120)
			.zoomIn(2)
			.zoomOut(2)
			.yourPlan()
			.deleteYourPlan()
			.deleteNo();
			
			
		}
	}



