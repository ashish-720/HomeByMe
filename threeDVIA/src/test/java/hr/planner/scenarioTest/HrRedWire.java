package hr.planner.scenarioTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class HrRedWire extends Browser{

		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void launchPlanner(SignUpData signUpData) {
		
			LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
			
			home.login(signUpData)
			.myProjects()
			.newProject()
			
			.furnish()
			.catelogSubCategory("beds")
			.filter("", "Single beds", "Blue") //verification fails plz check
			//.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Cozy single bed", "1")
			.closeCatalog()
			.clickInPlanner(86, 73)
			.duplicateProd()//check verification not working
			.deleteProd()
			.editFurniture(86, 73, "", "150", "")
			.closeEditPanel()
			
			
			.build()
			.catelogSubCategory("folding_doors")
			.filter("Wood", "", "Brown")//verification fails plz check
			//.favIconInCatalogList("0", "Retailer Fav List", 1)
			.addProduct("Interior door", "0")
			.closeCatalog()
			.clickInPlanner(56, 165)
			.duplicateProd()//check verification not working
			.deleteProd()
			.editBuild(56, 165, "", "100", "") //Error in height: element not interactable
			.closeEditPanel()
			
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
			.moveWall(0, -158, 0, -250)
			.translateProduct(86, 73, 400, -230)
			.floorPlan()
			.addWall()
			.drawWall("-162;-162>-500;-162>-500;160>-162;160")
			.validate()
			.verifyNoOfRoomTag(3)
			.viewTwoD()
			.editWall(-154, -10, "20", "240")
			.splitWall()
			.clickInPlanner(-154, -10)
			//try to drag wall than add wall to close the room , than verify number of rooms
			//that will be check for split
			.deleteProd()
			.verifyNoOfRoomTag(2)
			.undo()
			.verifyNoOfRoomTag(3)
			
			
			.saveProjectDetail("HomeRetailersRedWire", "Home Retailer")
			
			.search("sofa")
			.addProduct("Sofa", "0")
			.closeCatalog()
			.saveProject()
			//.moveProduct(116, 43, 537, -58)
			.saveProject()
			.viewThreeD()
			.moveWall(0, 104, -368, 139)//Avatar
			.search("Living room set")
			.addProduct("Living room set", "8")
			.closeCatalog()
			.translateProduct(30, 37, 523, -37)
			.clickInPlanner(67, 12) 
			//add select and drag product(sofa , bed, door, window)
			//we are stuck here
			.ungroupProd()
			.saveProject()
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
			.floorPlan()
//			.initialPlan()
			.manageLevel()
			.addFloor()
			.addBasement()
			.floorName("1", "FF")
			.floorHeight("1", "270")
			.floorDelete("2")
			.levelManagerClose()
			
			.clickOnFavorites()
			.createNewFavoritesList("Retailer Fav List")
			.searchProductInFav()
			.search("Chair")
			.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Chair", "1")//add detail here
			.closeCatalog()
			
			.saveProject()
			.close()
			
//			.myProjects()
//			.searchProjectName("HomeRetailersRedWire")
//			.duplicateProject("HomeRetailersRedWire", 0)
//			.verifyDuplicateProjectName("Duplicate-HR (copy)")
//			.searchProjectName("Duplicate-HR (copy)")
//			.deleteProject("Duplicate-HR (copy)", 0)
//			.deleteNo()
//			.deleteProject("Duplicate-HR (copy)", 0)
//			.deleteYes()	
//			.searchProjectName("HomeRetailersRedWire")
//			.openProjectPage("HomeRetailersRedWire", 0)
//			.projectOverview()
//			.verifyProjectPageName1("HomeRetailersRedWire")
//			.openProject()
//			.close()
//			
//			.myProjects()
//			.newProject()
//			.verifyProjectName("PROJECT NAME")
//			.close()
			;
					
		}
}
		
	


