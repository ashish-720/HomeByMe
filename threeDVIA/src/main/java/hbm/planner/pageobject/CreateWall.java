package hbm.planner.pageobject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateWall {
	
	WebDriver driver;
	public CreateWall(WebDriver driver) {
	this.driver = driver;
	}	
	
//	Screen s=new Screen();

	@CacheLookup
	@FindBy(id ="validate-design-tool")
	WebElement validateButton;
		
	@CacheLookup
	@FindBy(id = "cancel-design-tool")
	WebElement closeWallCreation;
	
	@FindBy(css="input.room.Tag3D.visibility-visible.pointer-events-deactivated")
	List<WebElement> roomTag;
	
	@FindBy(css=".LevelBorderVertexMeasure.Tag3D.visibility-visible.pointer-events-deactivated")
	List<WebElement> measureListLive;
	
	
	public ThreeDPlanner drawWallDev (String refInWallParameters){			
		UtilHBM.waitExplicitClickable(driver, validateButton);	
		String pixelValues = UtilHBM.getKeyValue(Setting.wallParametersPath).get(refInWallParameters);
		UtilHBM.turnOffImplicitWaits(driver);
		for(String temPixel:pixelValues.split(">")){
			int a =Integer.parseInt(temPixel.split(",")[0]);
			int b =Integer.parseInt(temPixel.split(",")[1]);
			int i=0;
			ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
			if(!(measureListLive.size()>0) && i<5){
				do{	
					planner.hoverInPlanner(a, b).clickInPlanner(a, b).hoverBlankSpaceDev();											
					i++;
				}while(!(measureListLive.size()>0) && i<5);				
			}else{
				do{	
					planner.hoverInPlanner(a, b).clickInPlanner(a, b)
					.hoverBlankSpaceDev().hoverInPlanner(a, b);														
					i++;
				}while(measureListLive.size()>0 && i<5);				
			}			
			if(i>=2){
				UtilHBM.reportWarning("Number of click in while creating wall = " + i);
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);		
		validateButton.click();
		UtilHBM.reportOK("Wall created. Ends points using regerence \"" + refInWallParameters + "\" are " + pixelValues);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
}
