package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Message {
	
	WebDriver driver;
	
	public Message(WebDriver driver) {
		this.driver = driver;
	}
		
	@FindBy(css = "#success-sublayer>header>h4")
	private WebElement messageYourRequestHasBeenSent;	
		
	@FindBy(css = "#success-sublayer>footer>button.cta-secondary-alt-l")
	private WebElement okGotItBtn;
	
	@FindBy(css = "#success-sublayer>footer>button.cta-primary-l")
	private WebElement createNewRealisticImgBtn;	
	
	@FindBy(css=".modal-wrap>.modal-inner>.u-center.u-mbxs>.modal-title")
	private WebElement msgTitle;
	
	@FindBy(css=".modal-wrap>.modal-inner>.u-center.u-mbxs>.modal-description>span")
	private WebElement msgText;
	
	@FindBy(css=".modal-wrap>.modal-inner>.u-center.footer>.button.btn-flush-confirm")
	private WebElement msgConfirmButton;
	
	@FindBy(xpath="//div[@class='modal-wrap']/div[@class='modal-inner']/div[@class='u-center footer']/a[@class='buttonSecondary btn-flush-cancel'][.='Cancel']")
	private WebElement msgCancelButton;
	
	@FindBy(css=".mod-popin--small.mod-open>div>div>h1")
	private WebElement titleDeleteLevelMsg;
	
	@FindBy(css=".mod-popin--small.mod-open>div>div>h1+div")
	private WebElement textDeleteLevelMsg;
	
	@FindBy(css=".mod-popin--small.mod-open>div>footer>button.cta-secondary-xl")
	private WebElement cancelBtnDeleteLevel;
	
	@FindBy(css=".mod-popin--small.mod-open>div>footer>button.cta-primary-alt-xl")
	private WebElement deleteBtnDeleteLevel;
	
	
	
	
	
	public ThreeDPlanner closeHQMessage(){
		UtilHBM.waitExplicitClickable(driver, okGotItBtn);	
//		UtilHBM.waitExplicitDisplayed(driver, closeMessageYourRequestHasBeenSent);
		UtilHBM.reportInfo(messageYourRequestHasBeenSent.getText());
		okGotItBtn.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public RealisticImage createNewHQImage(){
		UtilHBM.waitExplicitClickable(driver, okGotItBtn);	
//		UtilHBM.waitExplicitDisplayed(driver, closeMessageYourRequestHasBeenSent);
		UtilHBM.reportInfo(messageYourRequestHasBeenSent.getText());
		createNewRealisticImgBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, "//article[@class='mod-layer-realistic-picture mod-open']");
		return PageFactory.initElements(driver, RealisticImage.class);
	}
	
	public ThreeDPlanner deleteRoomClickDelete(){
		UtilHBM.waitExplicitDisplayed(driver, msgCancelButton);
		Verification.verifyText(msgTitle, "DELETE THE ROOM", "Delete Room confirmation diaog");
		Verification.verifyText(msgText, "Are you sure you want to delete this room?", "Delete room confirmation msg text");		
		msgConfirmButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner emptyRoomClickEmptyButton(){
		UtilHBM.waitExplicitDisplayed(driver, msgCancelButton);
		Verification.verifyText(msgTitle, "EMPTY THE ROOM", "Delete Room confirmation diaog");
		Verification.verifyText(msgText, "Are you sure you want to clear this room?", "Clear room confirmation msg text");		
		msgConfirmButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected LevelNavigator deleteLevel(boolean confirm){
		UtilHBM.waitExplicitDisplayed(driver, cancelBtnDeleteLevel);
		Verification.displayNAttributeCheckOfElement(titleDeleteLevelMsg, "Delete Level Msg Title", "text", "DELETE THE FlOOR");
		Verification.displayNAttributeCheckOfElement(textDeleteLevelMsg, "Delete Level Msg", "text", "Are you sure you want to delete this floor?");
		if (confirm) {
			deleteBtnDeleteLevel.click();
		}else{
			cancelBtnDeleteLevel.click();
		}
		return PageFactory.initElements(driver, LevelNavigator.class);
	}
	
}
