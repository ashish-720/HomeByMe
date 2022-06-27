package hr.planner.scenarioTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class HrRedWireUS extends Browser{

		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void redWireUS(SignUpData signUpData) {
		
			LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
			
			home.login(signUpData)
			.myProjects()
			.newProject()
			//Delete default walls
			.viewTwoD()
			.clickInPlanner(-9, -161)
			.deleteProd()
			.clickInPlanner(152, -112)
			.deleteProd()
			.clickInPlanner(-157, 16)
			.deleteProd()
			//delete wall
			.clickInPlanner(13, 171) 
			.deleteProd()
			//Add room
			.floorPlan()
			.addRoom()
			.verifyAddRoom()
			.editSurface("550")
			//.roomType("5") //Please check this
			.selectRoom("room1")
			.addButton()
			.addNewRoom(100, -10)
			.undo()
			.verifyNoOfRoomTag(0)
			.redo()
			.verifyNoOfRoomTag(1)
			.validate()
			
			//edit wall thickness
			.editWall(-254, 21, "12", "")
			.zoomOut(1)
			.zoomOut(1)
			.clickInPlanner(400, 10)
			.editWall(380, 0, "12", "")
			.clickInPlanner(400, 10)
			.editWall(0, -315, "12", "")
			.clickInPlanner(400, 10)
			.editWall(50, 290, "12", "")	
			
			//Add walls in project
			.floorPlan()
			.addWall()
			.drawWall("380;26>60;26>60;-219>380;-219")
			.drawWall("200;-219>200;-300")
			.drawWall("60;-50>-210;-50")
			.drawWall("150;26>150;290")
			.drawWall("60;-219>60;-315")
			.validate()
			.verifyNoOfRoomTag(6)
			
			
			.editWall(150, 200, "12", "")
			.splitWall()
			.moveWall(150, 70, 300, 70)
			.clickInPlanner(200, 165)//if split skip than it will fail here
			.deleteProd()
			.clickInPlanner(300, 40)
			.deleteProd()
			.verifyNoOfRoomTag(5)
			
			//move wall
			.moveWall(380, 150, 500, 150)
			.saveProjectDetail("ODT-HR-US", "Home Retailer")
			.viewThreeD()
			
			
			
		.build()
		.catelogSubCategory("roof_windows")
		.addProduct("ROOF WINDOW", "0")
		.closeCatalog()
		.addRoofWindow()// sloped Ceiling layer is open
		.viewTwoD()
		.viewThreeD()
		.zoomIn(1)
		.zoomOut(1)
		//.clickInPlanner(-300, -100)
		.clickInPlanner(320, -76)
		.create()
		.validate()
		.build()
		.catelogSubCategory("roof_windows")
		.addProduct("ROOF WINDOW", "0")
		.closeCatalog()
		.saveProject()			
		.floorPlan()
		.manageSlopedCeiling()		
		// sloped Ceiling layer is open
		.viewTwoD()
		.viewThreeD()
		.zoomIn(1)
		.zoomOut(1)
		//3D add slope
		.clickInPlanner(-50, -200)
		.slopeVerification()
		.create()
		.clickInPlanner(-225, 58)
		.slopeVerification()
		.create()
		//3d delete slope
		.clickInPlanner(-225, 58)
		.deleteSlopedCeiling()//
		//3d change slope
		.clickInPlanner(-50, -200)
		.changeSlopedCeiling()
		.slopedCeilingInput("", "150")
		.create()
		.viewTwoD()
		//2D add slope
		.clickInPlanner(-148, -173)
		.viewThreeD()
		.viewTwoD()
		//2D remove slope
		.clickInPlanner(120, 182)
		.slopeVerification()
		.remove()
		.undo()
		.redo()
		.validate()		
		.save()				
			.viewThreeD()
			.moveWall(0, 20, -120, 194)//move avatar
			//add favorite
			.clickOnFavorites()
			.createNewFavoritesList("Retailer Fav List")
			
			//search and add grouped product
			.searchProductInFav()
			.search("livi")
			.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Ensemble de salon", "0")
			.closeCatalog()
			.clickInPlanner(0, 30)
			.position()
			.clickInPlanner(-10, -20) //click anywhere
			.ungroupProd()
			.save()
			//add kitchen set
			.moveWall(0, 90, 500, 90)//move avatar
			
			.furnish()
			.catelogSubCategory("kitchen_set")
			.addProduct("Kitchen set I shape l280", "1")
			.closeCatalog()
			.save()
			.translateProduct(0, 30, -129, -84)
//			.clickInPlanner(-98, -114)
//			.duplicateProd()
//			.deleteProd()
			.viewTwoD()
			.save()
			
			.moveWall(0, 80, -500, -400)
			.canvasCenter()
			//Add bed
			
			//check here
			.furnish()
			.catelogSubCategory("beds")
			.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Cozy single bed", "4")
			.closeCatalog()
			.translateProduct(-95, -71, -130, -80)
			//rotate
			.editFurniture(-211, -135, "250", "", "")//failed here
			.viewThreeD()
			.search("sofa")
			.addProduct("Sofa", "0")
			.closeCatalog()
			.saveProject()
			.viewTwoD()
			.translateProduct(31, 2, -114, -321)
			
			//failing here
			.save()
			//add door
			.build()
			.catelogSubCategory("patio_doors")
			.addProduct("Sliding patio door", "3")
			.closeCatalog()
			.save()
//			.editBuild(150, 200, "", "400", "")
			//.clickInPlanner(-313, -189)
			//.deleteProd()
			//.save()
			.levelToLevelManager()
			.levelManagerClose()
			.viewModeOptions()
			.cameraHeight("1m") //option= 2.3 , 1.7  , 1 , 0.2
			.viewTwoD()
			.viewModeOptions()
			.displayRoomName()
			.displayRoomArea()
			.save()
			
			//Add floors
			.floorPlan()
//			.initialPlan()
			.manageLevel()
			.addFloor()
			.addFloor()
			.addBasement()
			.floorName("2", "FF")
			.floorHeight("2", "100")
			.floorDelete("3")
			.levelManagerClose()
			.saveProject()
			.close()
			
			.myProjectsPP()
			.searchProjectName("ODT-HR-US")
			.openProject("ODT-HR-US", 0)//open previously saved project in planner
			//screenshot
			.takePicture()
			.screenshot()
			.generateScreenshot()
			.viewTwoD()
			.zoomIn(1)
			.zoomOut(1)
			.zoomOut(1)
			.zoomOut(1)
			.generateScreenshot()
			.closeScreenshot()
			.saveProject()
			//HQ Rendering
			.takePicture()
			.realisticImage()
			.layer1Verification()
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
			.searchProjectName("ODT-HR-US")
			//project duplicate
			.duplicateProject("ODT-HR-US", 0)
			.verifyDuplicateProjectName("ODT-HR-US (copy)", 0)
			
			.searchProjectName("ODT-HR-US")
			//delete project
			.deleteProject("ODT-HR-US", 4)
			.deleteNo()
			.deleteProject("ODT-HR-US", 4)
			.deleteYes()
			.searchProjectName("ODT-HR-US")
			//open previously saved project in planner
			.openProject("ODT-HR-US", 0)
			.verifyProjectName("ODT-HR-US")
			.saveProject()
			.close()
			
			//open project page 
			.myProjectsPP()
			.searchProjectName("Duplicate-HR")
			.openProjectPage("Duplicate-HR", 0)
			.projectOverview()
			.verifyProjectPageName("Duplicate-HR")
	
			

			;
					
		}
}
		
	



