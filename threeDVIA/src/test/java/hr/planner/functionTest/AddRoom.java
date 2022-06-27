package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class AddRoom extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void addRoom(SignUpData signUpData) {
		
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home
		.planMyRoomClick()
		.floorPlan()
		.addRoom().verifyAddRoom()
		.editSurface("15")
		.roomType("Bedroom")
		.selectRoom("room1")
		.addButton()
		.addNewRoom(350, -138)
		.undo()
		.verifyNoOfRoomTag(1)
		.redo()
		.verifyNoOfRoomTag(2)
		.validate()
		.viewTwoD()
		.editWall(-154, -10, "20 cm", "240")
		.splitWall()
		.deleteProd()
		.verifyNoOfRoomTag(1)
		.undo()
		.verifyNoOfRoomTag(2)
		.moveWall(0, -158, 0, -250)
		.floorPlan()
		.addWall()
		.drawWall("-162;-162>-500;-162>-500;160>-162;160")
		.validate()
		.verifyNoOfRoomTag(3)
		.clickInPlanner(230, -100)
		.editRoom(5, "Bedroom 1") //room select than delete
		.deleteProd()
		.verifyNoOfRoomTag(2)
		.undo()
		.moveWall(-168, 283, 18, 283)
		.clickInPlanner(-200, 100)
		.editRoom(5, "Room 3")
		.closeEditPanel()
		.floorPlan()
		.addSeparation()
		.drawSeparator("-200;-158>-200;158")
		.validateSepatator()
		.clickInPlanner(-400, 300)
		.verifyNoOfRoomTag(4)
		.moveWall(-200, 0, -150, 0)
		.verifyNoOfRoomTag(4)
		.clickInPlanner(-150, 0)
		.splitWall()
		.clickInPlanner(-150, -130)
		.deleteProd()
		.verifyNoOfRoomTag(3)
		.saveProjectWithoutLogin()
		.loginInPlanner(signUpData)
		.saveDetailWithoutLogin("saved without login", "HR")
		.close2()
		.myProjects()
		.verifyDuplicateProjectName("saved without login", 0)
		.openProject("saved without login", 0)
		.viewTwoD()
		.verifyNoOfRoomTag(3)
		.verifyProjectName("saved without login");
	}
}
