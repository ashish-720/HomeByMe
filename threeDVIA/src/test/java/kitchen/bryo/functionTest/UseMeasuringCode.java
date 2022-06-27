package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;


	@Test
	public class UseMeasuringCode extends Browser {
		
		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void useMeasuringCode(SignUpData signUpData) {
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.launchApp()
			.step3()
			.addProduct("U2DA80", true, false, false)
			.clickFloorplan()
			.useMeasuringCode()
			.selectMeasuringFile("measure.json")
			.verifyRoomNameAndDesc(100, -60, "Room", "23.0 m²")
			.step3()
			.verifyProduct(-115, -11, "U2DA80")
			.verifyPrice("914,00");
			
			
		}
	}



