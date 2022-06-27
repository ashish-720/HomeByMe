package kitchen.bryo.pageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
/*TODO: Change custom material confirmation popup is to be replaced by Change worktop popup as new functionality
   is to ratain all compatible changes on the new Worktop. The feature is already on beta so this class needs to be
    modified on beta flag removal. For now adding the new features with "kitchenBeta" comment
    */
public class ChangeCustomMaterialConfirmation {
	WebDriver driver;

	public ChangeCustomMaterialConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/div")
	private List<WebElement> changeWorktopPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/div/h1")
	private WebElement changeWorktopTitle;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']/div/div/h1")
	private WebElement changeWorktopTitleBeta;

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/div/div/div/p")
	private WebElement changeWorktopInfo;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']/div/div/div/p")
	private WebElement changeWorktopInfoBeta;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']/div/div/div/ul[@class='list']")
	private WebElement changeWorktopModificationsList;

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/div/div/p[@class='question']")
	private WebElement changeWorktopQuestion;

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement changeWorktopYes;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement changeWorktopOK;

	@FindBy(xpath = "//article[@class='mod-popin-change-worktop-type-small mod-open']/div/footer/button[@data-ui-action='secondary-button-action']")
	private WebElement changeWorktopNo;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']/div/footer/button[@data-ui-action='secondary-button-action']")
	private WebElement changeWorktopUndo;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']//button[text()='Show non-compatible options']")
	private WebElement showNonCompatibleOptionsLink;

	//kitchenBeta
	@FindBy(xpath = "//article[@class='mod-popin-infos_replace_worktop-small mod-open']//button[text()='Hide non-compatible options']")
	private WebElement hideNonCompatibleOptionsLink;

	@FindBy(xpath = "//article[@class='mod-popin-change-wallpanel-type-small mod-open']/div/div")
	private List<WebElement> changeWallPanelPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-change-wallpanel-type-small mod-open']/div/div/h1")
	private WebElement changeWallPanelTitle;

	@FindBy(xpath = "//article[@class='mod-popin-change-wallpanel-type-small mod-open']/div/div/div/div/p")
	private WebElement changeWallPanelInfo;

	@FindBy(xpath = "//article[@class='mod-popin-change-wallpanel-type-small mod-open']/div/div/div/p[@class='question']")
	private WebElement changeWallPanelQuestion;

	@FindBy(css = "article[class='mod-popin-change-wallpanel-type-small mod-open']>div>footer>button[data-ui-action='primary-button-action']>span")
	private WebElement changeWallPanelYes;

	@FindBy(css = "article[class='mod-popin-change-wallpanel-type-small mod-open']>div>footer>button[data-ui-action='secondary-button-action']>span")
	private WebElement changeWallPanelNo;

	public MakeItYours confirmCustomMaterialChange(String acceptConfirmation) {
		UtilHBM.waitFixTime(1500);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("article>div>div>h1")));
			String propertyName = driver.findElement(By.cssSelector("article>div>div>h1")).getText();
			System.out.println("property name : "+propertyName);
			switch (propertyName) {
			case "Change worktop":
					String titleText = "Change worktop";
					String message = "You are about to change a worktop that you have already edited. Modifications will be deleted.";
					String question = "Change worktop?";

					Verification.displayNAttributeCheckOfElement(changeWorktopTitle, "Change worktop title", "text",
							titleText);
					Verification.displayNAttributeCheckOfElement(changeWorktopInfo, "Change worktop info", "text",
							message);
				Verification.displayNAttributeCheckOfElement(changeWorktopQuestion, "Change worktop question",
						"text", question);
				if (acceptConfirmation.equalsIgnoreCase("yes"))
					changeWorktopYes.click();
				else if (acceptConfirmation.equalsIgnoreCase("no"))
					changeWorktopNo.click();
				break;

			case "Change wall panel":
				System.out.println("size " + changeWallPanelPopUp.size());
					System.out.println("Wall panel");
					String titleText1 = "Change wall panel";
					String message1 = "You are about to change your wall panel that you have already edited. Modifications will be deleted.";
					String question1 = "Change wall panel?";

					Verification.displayNAttributeCheckOfElement(changeWallPanelTitle, "Change wall panel title",
							"text", titleText1);
					Verification.displayNAttributeCheckOfElement(changeWallPanelInfo, "Change wall panel info", "text",
							message1);
					Verification.displayNAttributeCheckOfElement(changeWallPanelQuestion, "Change wall panel question",
							"text", question1);
				if (acceptConfirmation.equalsIgnoreCase("yes")) {
					UtilHBM.waitExplicitDisplayed(driver, changeWallPanelYes);
					UtilHBM.waitExplicitClickable(driver, changeWallPanelYes);
					changeWallPanelYes.click();
				} else if (acceptConfirmation.equalsIgnoreCase("no")) {
					UtilHBM.waitExplicitDisplayed(driver, changeWallPanelNo);
					UtilHBM.waitExplicitClickable(driver, changeWallPanelNo);
					changeWallPanelNo.click();
				}
				break;
			case "default":
				break;
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	//Note to user : this method is only to be used if the app dist setting 'resetCustomizedLinear' is set to false
	public MakeItYours confirmCustomMaterialChange(String acceptConfirmation, String resetCustomizedLinearAppSettingIsFalse) {
		UtilHBM.waitFixTime(1500);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("article>div>div>h1")));
		String titleText = "Change worktop";
		String message = "Some options are not compatible between the previous and current worktop. These options have been removed.";
//				String question = "Change worktop?";

		Verification.displayNAttributeCheckOfElement(changeWorktopTitleBeta, "Change worktop title", "text",
				titleText);
		Verification.displayNAttributeCheckOfElement(changeWorktopInfoBeta, "Change worktop info", "text",
				message);

		if (acceptConfirmation.equalsIgnoreCase("OK"))
			changeWorktopOK.click();
		else if (acceptConfirmation.equalsIgnoreCase("Undo"))
			changeWorktopUndo.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}


	public MakeItYours verifyCustomModifications(String[] customModifications) {
		UtilHBM.waitExplicitDisplayed(driver, changeWorktopTitleBeta);
		List<WebElement> modificationsListElems = changeWorktopModificationsList.findElements(By.cssSelector("li"));
		List<String> avModificationsList = new ArrayList<>();
		for (WebElement modificationsListElem : modificationsListElems)
			avModificationsList.add(modificationsListElem.getText().trim());

		List<String> expectedModifications = new ArrayList<>(Arrays.asList(customModifications));


		for (String eM : expectedModifications) {
			if (!avModificationsList.remove(eM))
				UtilHBM.reportKO("Expected modification: '" + eM + "' not present");
		}
		if (!avModificationsList.isEmpty())
			UtilHBM.reportKO("Following modifications visible but not expected :" + avModificationsList.toString());

		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours showNonCompatibleOptions() {
		UtilHBM.waitExplicitDisplayed(driver, showNonCompatibleOptionsLink);
		showNonCompatibleOptionsLink.click();
		UtilHBM.waitFixTime(1000);
		if(!changeWorktopModificationsList.isDisplayed())
			UtilHBM.reportKO("non compatible list is still not displayed after clicking 'Show non-Compatible options' link");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours hideNonCompatibleOptions() {
		UtilHBM.waitExplicitDisplayed(driver, hideNonCompatibleOptionsLink);
		hideNonCompatibleOptionsLink.click();
		UtilHBM.waitFixTime(1000);
		if(changeWorktopModificationsList.isDisplayed())
			UtilHBM.reportKO("non compatible list is still displayed after clicking 'Hide non-Compatible options' link");
		return PageFactory.initElements(driver, MakeItYours.class);
	}
}
