package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class Decorate extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void decorate (SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		.myProjects()
		.searchProjectName("ODT Decorate HR")
		.openProject("ODT Decorate HR", 0)
		.decorate()
		.catelogSubCategory("paint")
		//.filter("", "", "Red") //verification fails plz check
		.addProduct("Paint", "3")
		.clickOnWall(228, -111)
		.clickOnWall(402, -65)
		.clickOnWall(-74, -71)
		.clickOnWall(-132, 65)
		.clickOnWall(143, 65)
		.clickOnWall(-116, -85)
		.moveWall(0, 104, -300, 139)// Moving Avatar
		.clickOnWall(85, -75)
		.clickOnWall(161, 25)
		.clickOnWall(-105, 0)
		.subCategory("Paint & Wallpaper")
		.subSubCategory("flooring")
		.filter("", "Hardwoods", "")
		.addProduct("Mahogany parquet", "0")
		.clickOnWall(88, 43)
		.moveWall(-2, 76, 220, 250)// Moving Avatar
		.lastUsed(1)
		.clickOnWall(140, -66)
		.clickInPlanner(264, -138)
//		.floorLevelBtn()
		.levelSelector("Basement 1")
		.clickInPlanner(264, -138)
		.clickInPlanner(140, -66)
		.productInfo()
		//product sheet is open
		//.information()
		.similarProducts("386","")
		.image("Paint")
		//.similarProducts()
		.clickFavIconInSimilarList("0")
		.clickOnNewFavList("new list")
		.clickfavInProductSheet()
		.clickOnFavList("Retailer Fav List", 1)
		.closeProductSheet()
//		.floorLevelBtn()
		.levelSelector("FF")
		.moveWall(-3, 77, 15, -200)// move avatar 
		.rotatePlan(70, "left")
		.clickInPlanner(-33, -183)//paint on slopped ceiling
		.clickInPlanner(-107, -90)
		.maximizePanel()
		.minimizePanel()
		.closeFavPanel()
		
	
		
		
	
		;
	}
}
	
	
