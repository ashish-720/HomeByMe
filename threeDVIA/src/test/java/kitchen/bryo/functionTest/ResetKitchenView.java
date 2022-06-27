package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ResetKitchenView extends Browser {
	@Test
	public void resetKitchenViewTest() {

		// KIT-2140 : As a user, I can reset the camera view

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().threeDView()
				// place the avatar outside the room
				.moveAvatar(15, 100, 300, 100)
				// Reset view button appears
				.verifyResetCameraViewIconDisplayed()
				// On clicking the button
				.resetCameraView()
				// avatar is placed in the center of project
				// button is hidden
				.verifyResetCameraViewIconRemoved()
				
				.moveAvatar(-1, 93, 300, 100)
				.firstPersonView()
				.threeDView()
				.verifyResetCameraViewIconRemoved()
				
				.moveAvatar(-1, 93, 300, 100)
				.twoDView()
				.changeRoomName(0, 0, "Kitchen")
				.verifyRoomType(10, 10, "Kitchen", "Untitled room")
				
				//reset test in step 3 without product
				.step3()
				.moveAvatar(15, 100, 300, 100)
				.verifyResetCameraViewIconDisplayedInStep3()
				.resetCameraView()
				.verifyResetCameraViewIconRemovedInStep3()
				
				.moveAvatar(-1, 93, 300, 100)
				.firstPersonView()
				.threeDView()
				.verifyResetCameraViewIconRemovedInStep3()
				
				.moveAvatar(-1, 93, 300, 100)
				.twoDView()
//				.emptyRoom(0, 0, "Kitchen", "16.0", "no");
				
				.threeDView()
				.moveAvatar(12, 93, 300, 100)
				.step4()
				.clickDesignStep()
				.verifyResetCameraViewIconRemovedInStep3()
				.emptyRoom(0, 0, "Kitchen", "16.0", "no")
				
				
				//reset test in step 3 with product
				.addProductThroughSearch("U2D", "U2DA1002", true, false)
				.moveAvatar(-1, 141, 300, 100) 
				.verifyResetCameraViewIconDisplayedInStep3()
				.resetCameraView()
				.verifyResetCameraViewIconRemovedInStep3()
				
				.moveAvatar(-1, 144, 580, -120)
				.firstPersonView()
				.threeDView()
				.verifyResetCameraViewIconRemovedInStep3()
				
				.moveAvatar(-1, 144, 300, 100)
				.twoDView()
//				.emptyRoom(0, 0, "Kitchen", "16.0", "no");
				
				.threeDView()
				.moveAvatar(0, 115, 405, 110)
				.step4()
				.clickDesignStep()
				.verifyResetCameraViewIconRemovedInStep3()
				.emptyRoom(46, 112, "Kitchen", "16.0", "no")
				.verifyProduct(0, 0, "U2DA1002");
				
	}

}
