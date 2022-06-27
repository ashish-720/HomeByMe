package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class DoubleSidedWorktop extends Browser {
	@Test
	public void doubleSidedWorktop() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().step3()

				.addProductThroughSearch("Worktop", "LAMINATE BLACK", true, false)	
				.verifyPrice("500,12")
				.clickProductList()
				.verifyProductInfoInItemList("Worktops and wall panels","Reference:NOLAMINATE > Price:-- > Quantity:-- > Total:€ 500,12", "")
				.editFreeStandingWorktopProperties(-8, 41, true, "", "", "")			
				.clickProductList()
				.verifyProductInfoInItemList("Worktops and wall panels","Reference:NOLAMINATE > Price:-- > Quantity:-- > Total:€ 600,12", "")
				.clickProductList()
				.verifyProductInfoInItemList("Worktops and wall panels","Reference:NOLAMINATE_DOUBLE > Price:€ 100,00 > Quantity:1 > Total:€ 100,00", "");
			
		
	}
}
