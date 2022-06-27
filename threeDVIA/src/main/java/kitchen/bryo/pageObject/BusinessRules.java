package kitchen.bryo.pageObject;

import java.util.List;

import hbm.planner.utility.Verification;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class BusinessRules {
	WebDriver driver;
	public static String ruleTypeVerification;

	public BusinessRules(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "show-help")
	private WebElement helpButton;

	@FindBy(id = "refresh_check_without_change")
	private WebElement refresh;

	@FindBy(css = "#help-center-2>ul>li>ul>li>article")
	private List<WebElement> businessRule;

	@FindBy(xpath = "//li/article")
	private WebElement businessRuleTitle;

	@FindBy(xpath = "//li[@class='rules-group']/ul/li/article/h3/b")
	private List<WebElement> businessRulesList;

	@FindBy(xpath = "//li/article/p")
	private WebElement businessRuleDesc;

	@FindBy(css = "button[data-ui-action='primary-button-action']")
	private WebElement EditPanelYes;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateWorktop;

	@FindBy(css = "#design-mod-properties-window-wide>ul")
	private List<WebElement> balloon;

	@FindBy(xpath = "//li[@class='rules-group']/span")
	private List<WebElement> rulesGroup;

	@FindBy(xpath = "//article/img")
	private List<WebElement> businessRuleImage;

	@FindBy(xpath = "//article/div/video/source")
	private List<WebElement> businessRuleVideo;

	@FindBy(css = "article>button>span[data-i18n*='business_rule']")
	private WebElement businessRuleShowButton;

	@FindBy(css = "button[id='replace']")
	private List<WebElement> replaceExpiredProductButton;

	@FindBy(xpath = "//span/following-sibling::b[@data-i18n='kitchen.help_center.design_ok;planner.help_center.design_ok']")
	private WebElement designErrFreeMsg;

	public void setRuleType(String rulesArray) {
		ruleTypeVerification = rulesArray;
	}

	public static String getRuleType() {
		return ruleTypeVerification;
	}

	public BusinessRules verifyBusinessRules(boolean isBusinessRuleBtnDisplayed) {
		if (businessRule.size() > 0) {
			for (WebElement element : businessRule) {
				if (businessRuleTitle.isDisplayed()) {
					UtilHBM.reportOK(
							"Business rule title displayed : " + element.findElement(By.cssSelector("h3>b")).getText());
				}

				if (businessRuleTitle.findElements(By.xpath("img")).size() > 0) {
					if (businessRuleTitle.findElements(By.xpath("img")).get(0).getAttribute("srcset")
							.startsWith("./assets")) {
						UtilHBM.reportOK("Image displayed for business rule "
								+ element.findElement(By.cssSelector("h3>b")).getText());
					}
				}
				if (businessRuleTitle.findElements(By.xpath("div/video/source")).size() > 0) {
					if (businessRuleTitle.findElements(By.xpath("div/video/source")).get(0).getAttribute("src")
							.startsWith("https:")) {
						UtilHBM.reportOK("Video displayed for business rule "
								+ element.findElement(By.cssSelector("h3>b")).getText());
					}
				}
				if (businessRuleDesc.isDisplayed()) {
					UtilHBM.reportOK(
							"Business rule desc displayed : " + element.findElement(By.cssSelector("p")).getText());
				}
				if (isBusinessRuleBtnDisplayed) {
					if (businessRuleShowButton.isDisplayed()) {
						if (element.findElements(By.cssSelector("button>span[data-i18n*='business_rule']")).size() > 0) {
							UtilHBM.reportOK(
									element.findElement(By.cssSelector("button>span[data-i18n*='business_rule']")).getText()
											+ " button displayed for rule : "
											+ element.findElement(By.cssSelector("h3>b")).getText());
						} else {
							UtilHBM.reportOK(
									"Buttons not present for this BR..."
											+ element.findElement(By.cssSelector("h3>b")).getText());
						}
					}
				}
			}
		} else {
			System.out.println("No business rule button displayed");
		}
		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public BusinessRules businessRules(boolean isBusinessRuleBtnDisplayed) {
		UtilHBM.waitExplicitDisplayed(driver, refresh);
		new Actions(driver).moveToElement(refresh).click().build().perform();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.turnOffImplicitWaits(driver);
		if (rulesGroup.size() > 0) {
			for (WebElement rules : rulesGroup) {

				if (rules.isDisplayed()) {
					UtilHBM.waitExplicitDisplayed(driver, rules);
					UtilHBM.waitExplicitClickable(driver, rules);
		
					
					String ruleName = rules.getText().substring(0, rules.getText().indexOf(" "));
					String ruleCounter = rules.getText().substring(rules.getText().indexOf("(") + 1,rules.getText().indexOf(")"));

					if (rules.getAttribute("aria-expanded").equals("false")) {
						UtilHBM.reportInfo(
								ruleName + ": is hidden and number of rule counter displayed is " + ruleCounter);
						new Actions(driver).moveToElement(rules).click().build().perform();
//						UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//li/ul[@id='recommandation-group'][@aria-hidden='false']")));
					}
//					System.out.println("ruleType : " + ruleName + " rule count : " + ruleCounter);
//				
//					String rulesArray = ruleName + ":" + ruleCounter;
//					setRuleType(rulesArray);
				}
			}
		}

		else {
			UtilHBM.reportKO("No Business rule displayed");
		}

		verifyBusinessRules(isBusinessRuleBtnDisplayed);

		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public BusinessRules checkExpiredProductRuleShowIn3D(String rule) {
		businessRules(true);
		Boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By.xpath("//li/article/h3/b[contains(text(),'" + rule
						+ "')]/../following-sibling::button[@id='show-3d']"));
				System.out.println("Show in 3D " + showButton.getText());
				new Actions(driver).moveToElement(showButton).click().build().perform();
				clickReplaceButton(rule);
				break;
			}
		}
		if (businessRuleCheck == false) {
			UtilHBM.reportKO("Business rule" +rule+"not available in list. The available rules are: ");
			for (WebElement e : businessRulesList) {
				UtilHBM.reportKO(e.getText());
			}
		}
		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public BusinessRules clickReplaceButton(String rule) {
		if (replaceExpiredProductButton.size() > 0) {
			WebElement replace = driver.findElement(By.xpath(
					"//li/article/h3/b[contains(text(),'" + rule + "')]/../following-sibling::button[@id='replace']"));
			replace.click();
		}
		return this;
	}

	public BusinessRules checkBusinessRuleShowIn3D(String rule, boolean showBusinessRuleButton) {
		businessRules(showBusinessRuleButton);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals");
				businessRuleCheck = true;
				if(showBusinessRuleButton){
					WebElement showButton = driver.findElement(By
						.xpath("//li/article/h3/b[contains(text(),'" + rule + "')]/../following-sibling::button"));

					if(showButton.isDisplayed()){
						System.out.println("Show in 3D " + showButton.getText());
						new Actions(driver).moveToElement(showButton).click().build().perform();
					}else UtilHBM.reportKO("button for business rule not displayed");
				}
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule: "+rule+ " not available in list. Available Rules are: ");
			for (WebElement e : businessRulesList) {
				UtilHBM.reportKO(e.getText());
			}
		}
		openCloseHelpCenter();
//		UtilHBM.waitTillElementDisappear(driver,helpButton.findElement(By.cssSelector(".icon-action-arrow")));
		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public BusinessRules checkBusinessRuleShowIn2D(String rule) {
		openCloseHelpCenter().businessRules(true);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By
						.xpath("//li/article/h3/b[contains(text(),'" + rule + "')]/../following-sibling::button"));
				System.out.println("Show in 2D " + showButton.getText());
				new Actions(driver).moveToElement(showButton).click().build().perform();
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule: "+rule+ " not available in list. Available Rules are: ");
			for (WebElement e : businessRulesList) {
				UtilHBM.reportKO(e.getText());
			}
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public WallPanelEditor checkBusinessRuleShowIn2DWallPanel(String rule, String desc) {
		businessRules(true);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals in wall panel");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By
						.xpath("//li/article/h3/b[contains(text(),'" + rule + "')]/../following-sibling::button"));
				System.out.println("Show in 2D " + showButton.getText());
				new Actions(driver).moveToElement(showButton).click().build().perform();

				if(!desc.isEmpty()){
					String actualDesc = e.findElement(By.xpath("./ancestor::article[1]/p")).getText().trim();
					Verification.VerifyEquals("Description not matching", actualDesc, desc);
				}
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule:" +rule+" not available in list. The displayed business rules are:");
			for (WebElement e : businessRulesList){
				UtilHBM.reportKO(e.getText());
			}
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WorktopEditor checkBusinessRuleShowIn2DWorktop(String rule, String desc) {
		businessRules(true);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals in worktop");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By.xpath("//li/article/h3/b[contains(text(),\"" + rule + "\")]/../following-sibling::button[@id='show-2d']"));
				System.out.println("Show in 2D " + showButton.getText());
				new Actions(driver).moveToElement(showButton).click().build().perform();

				if(!desc.isEmpty()){
					String actualDesc = e.findElement(By.xpath("./ancestor::article[1]/p")).getText().trim();
					Verification.VerifyEquals("Description not matching", actualDesc, desc);
				}
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule:" +rule+" not available in list. The displayed business rules are:");
			for (WebElement e : businessRulesList){
				UtilHBM.reportKO(e.getText().trim());
			}
		}else{
			UtilHBM.reportOK(
					"Business rule " + rule + " is displayed in worktop editor as expected. The available rules are: ");
			for (WebElement element : businessRulesList) {
				UtilHBM.reportOK(element.getText());
			}
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}



	public BusinessRules checkBusinessRuleShowInWorktop(String rule, boolean isEditPanelDisplayed) {
		businessRules(true);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals in worktop");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By.xpath("//li/article/h3/b[contains(text(),'" + rule
						+ "')]/../following-sibling::button[@id='show-worktop-editor']"));
				showButton.click();
				if(isEditPanelDisplayed){
					UtilHBM.waitExplicitDisplayed(driver, EditPanelYes);
					UtilHBM.waitExplicitClickable(driver, EditPanelYes);
					EditPanelYes.click();
				}
				checkBusinessRuleShowIn2DWorktop(rule, "");
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule:" +rule+" not available in list. The displayed business rules are:");
			for (WebElement e : businessRulesList){
				UtilHBM.reportKO(e.getText());
			}
		}
		UtilHBM.waitTillElementDisappearSoft(driver,helpButton.findElement(By.cssSelector(".icon-action-arrow")),5);
		if(helpButton.findElement(By.cssSelector(".icon-action-arrow")).isDisplayed()){
			openCloseHelpCenter();
		}
		return PageFactory.initElements(driver, BusinessRules.class);
	}
	public BusinessRules checkBusinessRuleInWallPanel(String rule, boolean isEditPanelDisplayed) {
		businessRules(true);
		boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals in wall panel");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By.xpath("//li/article/h3/b[contains(text(),'" + rule
						+ "')]/../following-sibling::button[@id='show-wallPanel-editor']"));
				new Actions(driver).moveToElement(showButton).build().perform();
				showButton.click();
				if(isEditPanelDisplayed){
					UtilHBM.waitExplicitDisplayed(driver, EditPanelYes);
					UtilHBM.waitExplicitClickable(driver, EditPanelYes);
					EditPanelYes.click();
				}
				checkBusinessRuleShowIn2DWallPanel(rule, "");
				break;
			}
		}
		if (!businessRuleCheck) {
			UtilHBM.reportKO("Expected business rule:" +rule+" not available in list. The displayed business rules are:");
			for (WebElement e : businessRulesList){
				UtilHBM.reportKO(e.getText());
			}
		}
		UtilHBM.waitTillElementDisappearSoft(driver,helpButton.findElement(By.cssSelector(".icon-action-arrow")),5);
		if(helpButton.findElement(By.cssSelector(".icon-action-arrow")).isDisplayed()){
			openCloseHelpCenter();
		}
		return PageFactory.initElements(driver, BusinessRules.class);
	}
	public WallPanelEditor checkBusinessRuleInWallPanel(String rule) {
		businessRules(true);
		Boolean businessRuleCheck = false;
		for (WebElement e : businessRulesList) {
			if (rule.equalsIgnoreCase(e.getText())) {
				System.out.println("Rule equals in wall panel");
				businessRuleCheck = true;
				WebElement showButton = driver.findElement(By.xpath("//li/article/h3/b[contains(text(),'" + rule
						+ "')]/../following-sibling::button[@id='show-wallPanel-editor']"));
				new Actions(driver).moveToElement(showButton).build().perform();
				showButton.click();
				UtilHBM.waitExplicitDisplayed(driver, EditPanelYes);
				UtilHBM.waitExplicitClickable(driver, EditPanelYes);
				EditPanelYes.click();
				checkBusinessRuleShowIn2DWorktop(rule, "");
				break;
			}
		}
		if (businessRuleCheck == false) {
			UtilHBM.reportKO("Given business rule not available in list");
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor wallPanelEditorBusinessRuleRemoved(String rule) {
		UtilHBM.waitExplicitDisplayed(driver, refresh);
		new Actions(driver).moveToElement(refresh).click().build().perform();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(1500);
		if (businessRule.size() > 0) {
			boolean businessRuleCheck = false;
			for (WebElement element : businessRule) {
				if (element.getText().equalsIgnoreCase(rule)) {
					businessRuleCheck = true;
				}
			}
			if (businessRuleCheck)
				UtilHBM.reportKO("Business rule " + rule + " is displayed & is not corrected as expected");
			else {
				UtilHBM.reportOK("Given business rule " + rule + " is corrected and removed from list as expected");
			}
		} else {
			if (designErrFreeMsg.isDisplayed()) {
				UtilHBM.reportOK("Your design is error free");
			}
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WorktopEditor worktopEditorBusinessRuleRemoved(String rule) {
		UtilHBM.waitExplicitDisplayed(driver, refresh);
		new Actions(driver).moveToElement(refresh).click().build().perform();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(1500);
		if (businessRule.size() > 0) {
			boolean businessRuleCheck = false;
			for (WebElement element : businessRule) {
				if (element.getText().equalsIgnoreCase(rule)) {
					businessRuleCheck = true;
				}
			}
			if (businessRuleCheck){
				UtilHBM.reportKO(
						"Business rule " + rule + " is displayed and not removed from list in worktop editor as expected");
			}				
			else {
				UtilHBM.reportOK(
						"Business rule " + rule + " is corrected and removed from list in worktop editor as expected. The available rules are: ");
				for (WebElement element : businessRule) {
					UtilHBM.reportOK(element.getText());
				}
			}
		} else {
			if (designErrFreeMsg.isDisplayed()) {
				UtilHBM.reportOK("Your design is error free");
			}
		}
		openCloseHelpCenter();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public BusinessRules businessRuleRemoved(String rule) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, refresh);
		new Actions(driver).moveToElement(refresh).click().build().perform();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitFixTime(2500);
		UtilHBM.turnOffImplicitWaits(driver);
		if (businessRule.size() > 0) {
			boolean businessRuleCheck = false;
			for (WebElement element : businessRule) {
				if (element.getText().startsWith(rule)) {
					businessRuleCheck = true;
					break;
				}
			}
			if (businessRuleCheck)
				UtilHBM.reportKO("Business rule " + rule + " is displayed and not removed from list as expected");
			else {
				UtilHBM.reportOK("Business rule " + rule + " is corrected and removed from list as expected");
			}
		} else {
			if (designErrFreeMsg.isDisplayed()) {
				UtilHBM.reportOK("Your design is error free");
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		openCloseHelpCenter();
		return PageFactory.initElements(driver, BusinessRules.class);
	}

	public BusinessRules openCloseHelpCenter() {
		UtilHBM.waitFixTime(3000);
		JavascriptExecutor excecutor = (JavascriptExecutor) driver;
		excecutor.executeScript("arguments[0].click();", helpButton);

		return PageFactory.initElements(driver, BusinessRules.class);

	}

}
