package hr.planner.scenarioTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class HrRedWireGB extends Browser{

		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void redWireGB(SignUpData signUpData) {
		
			LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
			
			home.login(signUpData)
			.myProjects()
			//creating new project
			.newProject()
			//All about furniture
			.furnish()
			.catelogSubCategory("beds")
			.filter("", "Single beds", "Blue")
			.addProduct("Cozy single bed", "1")
			.closeCatalog()
			.clickInPlanner(86, 73)
			.duplicateProd()
			.deleteProd()
			.clickInPlanner(86, 73)
			.position()
			.clickInPlanner(86, 73)
			.clickInPlanner(150, 100)
			.editFurniture(86, 73, "250", "", "")
			.closeEditPanel()
			//all about door
			.build()
			.catelogSubCategory("folding_doors")
			.filter("Wood", "", "Brown")//verification fails plz check
			.addProduct("Interior door", "0")
			.closeCatalog()
			.clickInPlanner(56, 165)
			.duplicateProd()//check verification not working
			.deleteProd()
			.editBuild(56, 165, "", "100", "") //Error in height: element not interactable
			.closeEditPanel()
			//Add room in project
			.floorPlan()
			.addRoom()
			.verifyAddRoom()
			.editSurface("15")
			//.roomType("5") //Please check this
			.selectRoom("room1")
			.addButton()
			.addNewRoom(350, -138)
			.undo()
			.verifyNoOfRoomTag(1)
			.redo()
			.verifyNoOfRoomTag(2)
			.validate()
			//moving wall
			.moveWall(0, -158, 0, -250)
			//.translateProduct(86, 73, 400, -230)
			//Add walls in project
			.floorPlan()
			.addWall()
			.drawWall("-162;-162>-500;-162>-500;160>-162;160")
			.validate()
			.verifyNoOfRoomTag(3)
			.viewTwoD()
			.editWall(-154, -10, "20 cm", "240")//wall edits
			.splitWall()
			.clickInPlanner(-154, -10)
			.deleteProd()
			.verifyNoOfRoomTag(2)
			.undo()
			.verifyNoOfRoomTag(3)
			.saveProjectDetail("HrRedWireGB", "Home Retailer")
			//.clickInPlanner(170, -10)//clicked on window
			.clickInPlanner(200, -10)
			.editRoom(5,"") //add default room name
			.deleteProd()
			.verifyNoOfRoomTag(2)
			.undo()
			
			//All about favorites
			.clickOnFavorites()
			.createNewFavoritesList("Retailer Fav List")
			.searchProductInFav()
			.search("sofa")
			.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Sofa", "0")
			.closeCatalog()
			.viewThreeD()
			.moveWall(0, 104, -300, 139)// Moving Avatar
			
			//ungroup the product
			.search("Living room set")
			.addProduct("Living room set", "0")
			.closeCatalog()			
			.clickInPlanner(67, 12)
			.ungroupProd()
			.zoomIn(1)
			.zoomOut(1)
			.levelToLevelManager()
			.levelManagerClose()
			.viewModeOptions()
			.cameraHeight("1m") //option= 2.3 , 1.7  , 1 , 0.2
			.viewTwoD()
			.viewModeOptions()
			.displayRoomName()
			.displayRoomArea()
//			.saveProject()
			//Add floors
			.floorPlan()
//			.initialPlan()
			.manageLevel()
			.addFloor()
			.addBasement()
			.floorName("1", "FF")
			.floorHeight("1", "270")
			.floorDelete("2")
			.levelManagerClose()
			.saveProject()
			.close()					
			.myProjectsPP()
			.searchProjectName("HrRedWireGB")
			.openProject("HrRedWireGB", 0)//open previously saved project in planner
			//screenshot
			.takePicture()
			.screenshot()
			.generateScreenshot()
			.viewTwoD()
			.zoomIn(1)
			.zoomOut(1)
			.generateScreenshot()
			.closeScreenshot()
			.saveProject()
			//HQ Rendering
			.takePicture()
			.realisticImage()
			.layer1Verification()
			//background image icon is inactive for 3D realistic image
			.sunPosition(30, 40, "146")
			.sunInclination(30, 40, "146")
			.generate()
			.layer3Verification()
			.createNew()
			.cancel()
			//360 Image
			.saveProject()
			.takePicture()
			.take360Image()
			.layer1Verification360()
			.backGroundImage()
			.nextArrow()
			.nextArrow()
			.previousArrow()
			.sunPosition(30, 40, "146")
			.sunInclination(30, 40, "146")
			.preview() 
	//		.modify()
	//		.preview()
			.generate360()
			.generate2()
			.layer3Verification360()
			.okGotIt360()
			//loading layer verification not done
			.saveProject()
			.close()			
			.myProjectsPP()
			.searchProjectName("HrRedWireGB")
			//project duplicate
			.duplicateProject("HrRedWireGB", 0)
			.verifyDuplicateProjectName("HrRedWireGB (copy)", 0)
			.searchProjectName("HrRedWireGB")
			//delete project
			.deleteProject("HrRedWireGB (copy)", 0)
			.deleteNo()
			.deleteProject("HrRedWireGB (copy)", 0)
			.deleteYes()
			.searchProjectName("HrRedWireGB")
			//open previously saved project in planner
			.openProject("HrRedWireGB", 0)
			.verifyProjectName("HrRedWireGB")
			//sloped ceiling
			.build()
			.catelogSubCategory("roof_windows")
			.addProduct("ROOF WINDOW", "0")
			.closeCatalog()
			.addRoofWindow()// sloped Ceiling layer is open
			.viewTwoD()
			.viewThreeD()
			.zoomIn(1)
			.zoomOut(1)
			.clickInPlanner(-300, -100)
			.create()
			.clickInPlanner(200, -200)
			.create()
			.viewTwoD()
			.zoomIn(1)
			.zoomIn(1)
			.clickInPlanner(-21, -121)
			.clickInPlanner(200, -80)
			.undo()
			.redo()
			.validate()//check title verification
			.zoomOut(1)
			.zoomOut(1)
			.zoomOut(1)
			.build()
			.catelogSubCategory("roof_windows")
			.addProduct("ROOF WINDOW", "0")
			.closeCatalog()
			.saveProject()
			.close()			
			.myProjectsPP()
			.searchProjectName("HrRedWireGB")
			.openProject("HrRedWireGB", 0)
			.decorate()
			.catelogSubCategory("paint")
			//.filter("", "", "Red") //verification fails plz check
			.addProduct("Paint", "1")
			.clickOnWall(0, -100)
			.clickOnWall(250, -150)
			.clickOnWall(-180, -90)
			.clickOnWall(450, -100)
			.clickOnWall(-126, 27)
			.moveWall(0, 104, -368, 139)// Moving Avatar
			.clickOnWall(200, 0)
			.clickOnWall(430, -115)
			.closeCatalog()
			.saveProject()
			.close()
			
			// Upload 2D plan- only image- pdf remaining
			.myProjectsPP()
			.searchProjectName("HrRedWireGB")
			.openProject("HrRedWireGB", 0)
			.floorPlan()
//			.initialPlan()
			.uploadTwoDPlan()
			.getStarted()
			.uploadFromFile("AutoFP.jpg")//failed here
			.clickInPlanner(50, 60)
			.rotation(-10, 20, "247")
			.opacity(20, 0, "65")
			.move()
			.movePlan(50, 60, 100, 120)
			.zoomIn(1)
			.zoomIn(1)
			.zoomOut(1)
			.yourPlan()
			.yourPlanDelete()
			.deleteNo()
			.yourPlanChange()
			.deleteNo()
			.undo()
			.redo()
			.toolOption()
			.gridDisplay().planSelector("No").floorSelector("0")//verification not done
			.uploadFromFile("AutoFP.jpg")
			.clickInPlanner(50, 60)
			.rotation(-10, 20, "247")
			.opacity(20, 0, "65")
			.move()
			.movePlan(50, 60, 100, 120)
			.zoomIn(1)
			.zoomIn(1)
			.zoomOut(1)
			.yourPlan()
			.yourPlanDelete()
			.deleteNo()
			.yourPlanChange()
			.deleteNo()
			.undo()
			.redo()
			.toolOption()
			.gridDisplay().planSelector("Upper floor")
			.validate()
			.saveProject()
			.close()
			
			
			//open project page 
			.myProjectsPP()
			.searchProjectName("HrRedWireGB")
			.openProjectPage("HrRedWireGB", 0)
			.projectOverview()
			.verifyProjectPageName("HrRedWireGB")
			;
					
		}
}
		
	


