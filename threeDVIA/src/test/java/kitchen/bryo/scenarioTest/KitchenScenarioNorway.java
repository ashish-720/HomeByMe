package kitchen.bryo.scenarioTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;
import kitchen.bryo.pageObject.StylePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class KitchenScenarioNorway extends Browser {
	@Test
	public void cabinetTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.selectStyle(0);
		StylePage style = PageFactory.initElements(driver, StylePage.class);
		style.tryInMyRoom();
		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
		plan.openings("0","Fixed windows");
//		UtilHBM.dragDropIkea("IkeaSourceDrag", "IkeaDestinationImg", "IkeaFinalImgAfterDragDrop");
	}
}
