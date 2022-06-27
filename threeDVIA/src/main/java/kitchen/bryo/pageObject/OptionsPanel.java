package kitchen.bryo.pageObject;

import java.util.List;

import hbm.planner.utility.Verification;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;

public class OptionsPanel {
	WebDriver driver;

	public OptionsPanel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "select[data-ui-publicationid='handleLayout']")
	private WebElement handleLayout;

	@FindBy(css = "select[data-ui-publicationid='handleOrientation']")
	private WebElement handleOrientation;

	@FindBy(css = "select[data-ui-publicationid='side']")
	private WebElement side;

	@FindBy(xpath = "//input[@id='overhang-left']")
	private WebElement overhangLeft;

	@FindBy(xpath = "//input[@id='overhang-right']")
	private WebElement overhangRight;

	@FindBy(xpath = "//div[@class='mod-waterfall-solution']/div/p")
	private WebElement waterfallOption;

	@FindBy(xpath = "//figure[@id='waterfall-illustration']")
	private WebElement waterfallIllustration;

	@FindBy(id = "wall-panel-height")
	private WebElement wallPanelHt;

	@FindBy(css = "fieldset>p>span>input[id='add-rail']+span")
	private WebElement wallPanelRail;

	@FindBy(css = "p>label[for='waterfall-right']+.bt-toggle>input")
	private WebElement rightWaterFallToggle;

	@FindBy(xpath = "//figure[@id='waterfall-illustration']/img[@src='/Kitchen/assets/images//waterfall-right.png']")
	private List<WebElement> activeRightWaterFall;

	@FindBy(xpath = "//figure[@id='waterfall-illustration']/img[@src='/Kitchen/assets/images//waterfall-all.png']")
	private List<WebElement> activeAllWaterFall;

	@FindBy(css = "p>span>input[id='waterfall-left']+span")
	private WebElement leftWaterFallToggle;

	@FindBy(xpath = "//figure[@id='waterfall-illustration']/img[@src='/Kitchen/assets/images//waterfall-left.png']")
	private List<WebElement> activeLeftWaterFall;

	@FindBy(xpath = "//p/label[@for='waterfall-left']/following-sibling::span/input")
	private WebElement waterFallLeft;

	@FindBy(xpath = "//p/label[@for='waterfall-right']/following-sibling::span/input")
	private WebElement waterFallRight;

	@FindBy(xpath = "//span[contains(text(),'Handle')]/../following-sibling::div/button[@data-ui-action='product-option-more']")
	private WebElement handleOptionsButton;

	@FindBy(xpath = "//span[contains(text(),'Front')]/../following-sibling::div/button[@data-ui-action='product-option-more']")
	private WebElement frontOptionsButton;

	@FindBy(xpath = "//span[contains(text(),'Sink')]/../following-sibling::div/button[@data-ui-action='product-option-more']")
	private WebElement sinkOptionsButton;

	@FindBy(xpath = "//span/input[@id='edit-form-input-sinkXOffset']")
	private WebElement inputSinkXOffset;

	@FindBy(xpath = "//span/select[@id='edit-form-select-sinkXOffset']")
	private WebElement inputSinkXOffset2;

	@FindBy(xpath = "//span/input[@id='edit-form-input-sinkYOffset']")
	private WebElement inputSinkYOffset;

	@FindBy(xpath = "//span/select[@id='edit-form-select-sinkYOffset']")
	private WebElement inputSinkYOffset2;

	@FindBy(css = "select[data-ui-publicationid='sinkMounting']")
	private WebElement selectSinkMounting;

	@FindBy(xpath = "//input[@id='addDrainerGrooves']/following-sibling::span")
	private WebElement addDrainerGrooves;

	@FindBy(css = "input#addDrainerGrooves")
	private WebElement addDrainerGroovesToggle;

	@FindBy(css = "select[data-ui-publicationid='drainerGroovesPosition']")
	private WebElement selectDrainerGroovePosition;

	@FindBy(xpath = "//span[contains(text(),'Faucet')]/../following-sibling::div/button[@data-ui-action='product-option-more']")
	private WebElement faucetOptionsButton;

	@FindBy(xpath = "//span/*[@data-ui-publicationid='faucetXOffset']")
	private WebElement inputFaucetXOffset;

	@FindBy(xpath = "//span/*[@data-ui-publicationid='faucetYOffset']")
	private WebElement inputFaucetYOffset;

	@FindBy(xpath = "//span/*[@id='worktop_dimension-altitude']")
	private WebElement heightFromFloor;
	
	@FindBy(css = "input#add-left-wall-panel")
	private WebElement leftWallpanelOption;

	@FindBy(css = "input#add-right-wall-panel")
	private WebElement rightWallpanelOption;

	@FindBy(css = "b[class='error']")
	private WebElement errorMsg;
	
	@FindBy(css = "select[id='change-waterfall-type']")
	private WebElement changeWaterFallType;
	
	@FindBy(css = "select[id='wallpanel-side']")
	private WebElement wallpanelSide;
	
	public OptionsPanel handleOptions(String handleLayoutOption, String handleOrientationOption) {
		handleOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (!(handleLayoutOption.isEmpty())) {
			handleLayout.click();
			handleLayout.sendKeys(handleLayoutOption);
		}
		if (!(handleOrientationOption.isEmpty())) {
			handleOrientation.click();
			handleOrientation.sendKeys(handleOrientationOption);
			UtilHBM.reportOK("Handle property changed");
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel frontOptions(String frontSide) {
		frontOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (!(frontSide.isEmpty())) {
			side.click();
			side.sendKeys(frontSide);
			UtilHBM.reportOK("Front property changed");
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel sinkOptions(String sinkXOffset, String sinkYOffset, String mounting, String sideSinkXOffset,
			String sideSinkYOffset, String addGrooves, String groovesPosition) {
		sinkOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (!(sinkXOffset.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, inputSinkXOffset);
			inputSinkXOffset.click();

			for (int i = 0; i < sinkXOffset.length(); i++) {
				inputSinkXOffset.sendKeys(Keys.BACK_SPACE);
			}
			inputSinkXOffset.sendKeys(sinkXOffset);
			inputSinkXOffset.sendKeys(Keys.ENTER);

		}
		if (!(sinkYOffset.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, inputSinkYOffset);
			inputSinkYOffset.click();

			for (int i = 0; i < sinkYOffset.length(); i++) {
				inputSinkYOffset.sendKeys(Keys.BACK_SPACE);
			}
			inputSinkYOffset.sendKeys(sinkYOffset);
			inputSinkYOffset.sendKeys(Keys.ENTER);
		}
		if (!(mounting.isEmpty())) {
			UtilHBM.waitFixTime(1000);
			WebElement element = driver.findElement(By.cssSelector(("select[data-ui-publicationid='sinkMounting']")));
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(mounting);
		}
		if (!(sideSinkXOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkXOffset']")));
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(sideSinkXOffset);
		}
		if (!(sideSinkYOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkYOffset']")));
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(sideSinkYOffset);
		}
		if (!(addGrooves.isEmpty())) {
			if (addGrooves.equalsIgnoreCase("yes")) {
				if (addDrainerGrooves.isEnabled()) {
					UtilHBM.waitExplicitClickable(driver, addDrainerGrooves);
					new Actions(driver).moveToElement(addDrainerGrooves).click().build().perform();
					UtilHBM.waitFixTime(500);
				}
			} else {
				UtilHBM.reportMsg("Add Drainer Grooves disabled");
			}
		}
		if (!(groovesPosition.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='drainerGroovesPosition']")));

			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(groovesPosition);
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel faucetOptions(String faucetXOffset, String faucetYOffset, String sideFaucetXOffset,
			String sideFaucetYOffset) {
		UtilHBM.waitExplicitClickable(driver, faucetOptionsButton);
		faucetOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (!(faucetXOffset.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, inputFaucetXOffset);
			inputFaucetXOffset.click();

			for (int i = 0; i < faucetXOffset.length(); i++) {
				inputFaucetXOffset.sendKeys(Keys.BACK_SPACE);
			}
			inputFaucetXOffset.sendKeys(faucetXOffset);
		}
		if (!(faucetYOffset.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, inputFaucetYOffset);
			inputFaucetYOffset.click();
			for (int i = 0; i < faucetYOffset.length(); i++) {
				inputFaucetYOffset.sendKeys(Keys.BACK_SPACE);
			}
			inputFaucetYOffset.sendKeys(faucetYOffset);

		}
		if (!(sideFaucetXOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideFaucetXOffset']")));
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(sideFaucetXOffset);
		}
		if (!(sideFaucetYOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideFaucetYOffset']")));
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(sideFaucetYOffset);
		}

		return PageFactory.initElements(driver, OptionsPanel.class);
	}
	
	public OptionsPanel editCustomWorktopDimensionsProperties(String height) {
		
		UtilHBM.waitFixTime(1000);
		if (!(height.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, heightFromFloor);
			heightFromFloor.click();
			for (int i = 0; i < height.length(); i++) {
				inputFaucetYOffset.sendKeys(Keys.BACK_SPACE);
			}
			inputFaucetYOffset.sendKeys(height);

		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}
	public OptionsPanel verifyCustomWorktopDimensionsProperties(String height) {
		UtilHBM.waitFixTime(1000);
	if (height.isEmpty()) {
		UtilHBM.reportOK("Height from floor property not available");
	} else if (!(height.isEmpty())) {
		if (height.equalsIgnoreCase(heightFromFloor.getAttribute("value"))) {
			UtilHBM.reportOK("Height from floor property changed and value is " + heightFromFloor.getAttribute("value"));
		} else {
			UtilHBM.reportKO(
					"Height from floor property not changed and value is " + heightFromFloor.getAttribute("value"));
		}
	} else {
		UtilHBM.reportKO("Property verification failed for Left overhang");
	}
	return PageFactory.initElements(driver, OptionsPanel.class);
	}
	public OptionsPanel worktopOverHangOption(String overhangLeftOpt, String overhangRightOpt) {
		UtilHBM.waitFixTime(1000);
		if (!(overhangLeftOpt.isEmpty())) {
			if (overhangLeft.isEnabled()) {
				if (!(overhangLeftOpt.isEmpty())) {

					UtilHBM.waitExplicitClickable(driver, overhangLeft);
					overhangLeft.click();

					for (int i = 0; i < overhangLeftOpt.length(); i++) {
						overhangLeft.sendKeys(Keys.BACK_SPACE);
					}
					overhangLeft.sendKeys(overhangLeftOpt);
					overhangLeft.sendKeys(Keys.ENTER);
					UtilHBM.waitFixTime(2500);
					String minimunValue = "0 mm";
					String maxValue="250 mm";
					int minVal = Integer
							.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					int maxVal = Integer
							.parseInt(maxValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					int rectVal = Integer
							.parseInt(overhangLeftOpt.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					if (rectVal < minVal) {
						Verification.displayOfWebElement(errorMsg);
						Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 0.");
					}else if(rectVal>maxVal) {
						Verification.displayOfWebElement(errorMsg);
						Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The maximum value is 250.");
					}
				}
			}
		}
		if (!(overhangRightOpt.isEmpty())) {
			if (overhangRight.isEnabled()) {
				if (!(overhangRightOpt.isEmpty())) {
					UtilHBM.waitExplicitClickable(driver, overhangRight);
					overhangRight.click();

					for (int i = 0; i < overhangRightOpt.length(); i++) {
						overhangRight.sendKeys(Keys.BACK_SPACE);
					}
					overhangRight.sendKeys(overhangRightOpt);
					overhangRight.sendKeys(Keys.ENTER);
					UtilHBM.waitFixTime(2500);
					String minimunValue = "0 mm";
					String maxValue="250 mm";
					int minVal = Integer
							.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					int maxVal = Integer
							.parseInt(maxValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					int rectVal = Integer
							.parseInt(overhangRightOpt.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
					if (rectVal < minVal) {
						Verification.displayOfWebElement(errorMsg);
						Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 0.");
					}else if(rectVal>maxVal) {
						Verification.displayOfWebElement(errorMsg);
						Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The maximum value is 250.");
					}
				}
			}
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}
	public OptionsPanel worktopWaterFallOptions( String leftWaterfall,
			String rightWaterfall,String waterFallType) {
		UtilHBM.waitFixTime(1000);
		
		if (!(leftWaterfall.isEmpty())) {
			if (leftWaterfall.equalsIgnoreCase("yes")) {
				if (!waterFallLeft.isSelected()) {

//					UtilHBM.waitExplicitClickable(driver, leftWaterFallToggle);
					new Actions(driver).moveToElement(leftWaterFallToggle).click().build().perform();
					UtilHBM.waitFixTime(500);
//					if (activeLeftWaterFall.get(0).isDisplayed()) {
//
//						UtilHBM.reportOK("Left waterfall added to the worktop");
//					}
				}
			}else if (leftWaterfall.equalsIgnoreCase("no")) {
				if (waterFallLeft.isSelected()) {

//					UtilHBM.waitExplicitClickable(driver, leftWaterFallToggle);
					new Actions(driver).moveToElement(leftWaterFallToggle).click().build().perform();
					UtilHBM.waitFixTime(500);
//					if (activeLeftWaterFall.size()==0) {
//
//						UtilHBM.reportOK("Left waterfall removed frm the worktop");
//					}

				}
			}
		}
		if (!(rightWaterfall.isEmpty())) {
			if (rightWaterfall.equalsIgnoreCase("yes")) {
//				UtilHBM.waitExplicitClickable(driver, rightWaterFallToggle);
//				new Actions(driver).moveToElement(rightWaterFallToggle).click().build().perform();
				if (!waterFallRight.isSelected()) {
					rightWaterFallToggle.click();
//				new Actions(driver).moveToElement(rightWaterFallToggle).click().pause(500).release().build().perform();
//					UtilHBM.waitFixTime(700);
//					if (activeAllWaterFall.size() > 0) {
//
//						UtilHBM.reportOK("Left and Right waterfall added to the worktop");
//
//					} else if (activeRightWaterFall.get(0).isDisplayed()) {
//						UtilHBM.reportOK("Right waterfall added to the worktop");
//					}
				}
			}else if (rightWaterfall.equalsIgnoreCase("no")) {
				if (waterFallRight.isSelected()) {

//					UtilHBM.waitExplicitClickable(driver, rightWaterFallToggle);
					new Actions(driver).moveToElement(rightWaterFallToggle).click().build().perform();
					UtilHBM.waitFixTime(500);
//					if (activeRightWaterFall.size()==0) {
//
//						UtilHBM.reportOK("Right waterfall removed frm the worktop");
//					}

				}
			}
		}
		
		if (!(waterFallType.isEmpty())) {
		Select oSelect = new Select(changeWaterFallType);
			oSelect.selectByVisibleText(waterFallType);
		}else {
			UtilHBM.reportOK("WaterFall Type property not available");
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel wallPanelOptionProperties(String wallPanelHeight, String side, String ltWallPanelOption, String rtWallpanelOption){

		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (!(wallPanelHeight.isEmpty())) {
			if (wallPanelHt.isEnabled()) {
				wallPanelHeight(wallPanelHeight);
			} 
//			else {
//				UtilHBM.waitExplicitClickable(driver, wallPanelRail);
//				new Actions(driver).moveToElement(wallPanelRail).click().build().perform();
//				UtilHBM.waitExplicitClickable(driver, wallPanelHt);
//				if (wallPanelHt.isEnabled()) {
//					wallPanelHeight(wallPanelHeight);
//				}
//			}
			UtilHBM.waitFixTime(1000);
		}
		if (!(side.isEmpty())) {
			Select oSelect = new Select(wallpanelSide);
				oSelect.selectByVisibleText(side);
			}else {
				UtilHBM.reportOK("Wall panel side property not available");
			}
		if (!ltWallPanelOption.isEmpty()) {
			if (ltWallPanelOption.equalsIgnoreCase("true")) {
				if (!leftWallpanelOption.isSelected()) leftWallpanelOption.click();
			} else if (ltWallPanelOption.equalsIgnoreCase("false")) {
				if (leftWallpanelOption.isSelected()) leftWallpanelOption.click();
			}
			UtilHBM.waitFixTime(1000);
		}

		if (!rtWallpanelOption.isEmpty()) {
			if (rtWallpanelOption.equalsIgnoreCase("true")) {
				if (!rightWallpanelOption.isSelected()) rightWallpanelOption.click();
			} else if (rtWallpanelOption.equalsIgnoreCase("false")) {
				if (rightWallpanelOption.isSelected()) rightWallpanelOption.click();
			}
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public ProductProperties wallPanelHeight(String wallPanelHeight){

		UtilHBM.waitExplicitClickable(driver, wallPanelHt);
		wallPanelHt.click();
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		builder.keyDown(Keys.CONTROL).sendKeys("z").keyUp(Keys.CONTROL).build().perform();
		wallPanelHt.sendKeys(wallPanelHeight);
		wallPanelHt.sendKeys(Keys.ENTER);
//		wallPanelHt.sendKeys(wallPanelHeight);
//		wallPanelHt.sendKeys(Keys.ENTER);
		UtilHBM.waitFixTime(2500);

		return PageFactory.initElements(driver, ProductProperties.class);
	}

	public OptionsPanel verifyHandleOptionsEditable(boolean isEditable) {
		boolean optionsButtonPresent=driver.findElements(By.xpath("//span[contains(text(),'Handle')]/../following-sibling::div/button[@data-ui-action='product-option-more']")).size()>0;
		if(optionsButtonPresent==isEditable)
			UtilHBM.reportOK("Options Button for Handle is "+(isEditable?"present":"not present"));
		else UtilHBM.reportKO("Options Button for Handle is "+(isEditable?"not present":"present"));
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyHandleOptions(String handleLayoutOption, String handleOrientationOption) {
		handleOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (handleLayoutOption.isEmpty()) {
			UtilHBM.reportOK("Handle Option property not available");
		} else {
			if (handleLayoutOption.equalsIgnoreCase(new Select(handleLayout).getFirstSelectedOption().getText())) {
				UtilHBM.reportOK("Handle Option property changed");
			} else if (handleOrientationOption.equalsIgnoreCase("Multiple Values")) {
				if (driver.findElement(By.cssSelector("select[data-ui-publicationid='handleLayout']~span")).getText().equalsIgnoreCase("Multiple values"))
					UtilHBM.reportOK("Multiple values showing for Handle Layout");
				else UtilHBM.reportKO("Multiple values not showing for Handle Layout");
			} else UtilHBM.reportKO("Handle Layout property value is different");
		}

		if (handleOrientationOption.isEmpty()) {
			UtilHBM.reportOK("Handle Orientation property not available");
		} else {
			if (handleOrientationOption.equalsIgnoreCase(new Select(handleOrientation).getFirstSelectedOption().getText())) {
				UtilHBM.reportOK("Handle Orientation property changed");
			} else if (handleOrientationOption.equalsIgnoreCase("Multiple Values")) {
				if (driver.findElement(By.cssSelector("select[data-ui-publicationid='handleOrientation']~span")).getText().equalsIgnoreCase("Multiple values"))
					UtilHBM.reportOK("Multiple values showing for Handle Orientation");
				else UtilHBM.reportKO("Multiple values not showing for Handle Orientation");
			} else UtilHBM.reportKO("Handle Orientation property value is different");
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyFrontOptions(String frontSide) {
		frontOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (frontSide.isEmpty()) {
			UtilHBM.reportOK("Side property not available");
		} else if (!(frontSide.isEmpty())) {
			if (frontSide.equalsIgnoreCase(side.getAttribute("value"))) {
				UtilHBM.reportOK("Side property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Side");
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyWorktopOptionOverhangProperties(String overhangLeftOpt, String overhangRightOpt, String isLeftOverhangEditable, String isRightOverhangEditable) {
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (overhangLeftOpt.isEmpty()) {
			UtilHBM.reportOK("Left overhang property not available");
		} else if (!(overhangLeftOpt.isEmpty())) {
			if (!isLeftOverhangEditable.isEmpty()) {
				String expected = isLeftOverhangEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit overhang", Boolean.toString(overhangLeft.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isLeftOverhangEditable' can be either true or false");
				}
			}

			if (overhangLeftOpt.equalsIgnoreCase(overhangLeft.getAttribute("value"))) {
				UtilHBM.reportOK("Left overhang property  value is " + overhangLeft.getAttribute("value"));
			} else if(overhangLeftOpt.equalsIgnoreCase("Multiple values")){
				if(overhangLeft.getAttribute("placeholder").equalsIgnoreCase("Multiple values"))UtilHBM.reportOK("Left overhang property  value is "+overhangLeft.getAttribute("placeholder"));
				else UtilHBM.reportKO("Expected : Multiple values , Actual : "+overhangLeft.getAttribute("placeholder"));
			}else {
				UtilHBM.reportKO(
						"Left overhang property  value is " + overhangLeft.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Left overhang");
		}

		if (overhangRightOpt.isEmpty()) {
			UtilHBM.reportOK("Right overhang property not available");
		} else if (!(overhangRightOpt.isEmpty())) {
			if (!isRightOverhangEditable.isEmpty()) {
				String expected = isRightOverhangEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit overhang", Boolean.toString(overhangRight.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isRightOverhangEditable' can be either true or false");
				}
			}

			if (overhangRightOpt.equalsIgnoreCase(overhangRight.getAttribute("value"))) {
				UtilHBM.reportOK("Right overhang property value is " + overhangRight.getAttribute("value"));
			}  else if(overhangRightOpt.equalsIgnoreCase("Multiple values")){
				if(overhangRight.getAttribute("placeholder").equalsIgnoreCase("Multiple values"))UtilHBM.reportOK("Left overhang property  value is "+overhangRight.getAttribute("placeholder"));
				else UtilHBM.reportKO("Expected : Multiple values , Actual : "+overhangRight.getAttribute("placeholder"));
			}else {
				UtilHBM.reportKO(
						"Right overhang property  value is " + overhangRight.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Right overhang");
		}

		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyWorktopOptionProperties(String overhangLeftOpt, String overhangRightOpt,
			String leftWaterfall, String rightWaterfall) {

		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (overhangLeftOpt.isEmpty()) {
			UtilHBM.reportOK("Left overhang property not available");
		} else if (!(overhangLeftOpt.isEmpty())) {
			if (overhangLeftOpt.equalsIgnoreCase(overhangLeft.getAttribute("value"))) {
				UtilHBM.reportOK("Left overhang property changed and value is " + overhangLeft.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Left overhang property not changed and value is " + overhangLeft.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Left overhang");
		}
		if (overhangRightOpt.isEmpty()) {
			UtilHBM.reportOK("Right overhang property not available");
		} else if (!(overhangRightOpt.isEmpty())) {
			if (overhangRightOpt.equalsIgnoreCase(overhangRight.getAttribute("value"))) {
				UtilHBM.reportOK("Right overhang property changed and value is " + overhangRight.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Right overhang property not changed and value is " + overhangLeft.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Right overhang");
		}
		if (leftWaterfall.isEmpty()) {
			UtilHBM.reportOK("Left waterfall property not available");
		} else if (!(leftWaterfall.isEmpty())) {
			if (waterfallOption.findElement(By.xpath("//label[@for='waterfall-left']")).isEnabled()) {

				if (waterfallIllustration.findElement(By.xpath("//img[@src='/Kitchen/assets/images//waterfall-left.png']"))
						.isDisplayed()) {

					UtilHBM.reportOK("Verification success for left waterfall added to the worktop");
				} else {
					UtilHBM.reportKO("Verification failed for left waterfall");
				}
			}
		} else {
			UtilHBM.reportKO("Property verification failed for left waterfall");
		}
		if (rightWaterfall.isEmpty()) {
			UtilHBM.reportOK("Right waterfall property not available");
		} else if (!(rightWaterfall.isEmpty())) {
			if (waterfallOption.findElement(By.xpath("//label[@for='waterfall-right']")).isEnabled()) {

				if (waterfallIllustration.findElement(By.xpath("//img[@src='/Kitchen/assets/images//waterfall-right.png']"))
						.isDisplayed()) {

					UtilHBM.reportOK("Verification success for right waterfall added to the worktop");
				} else {
					UtilHBM.reportKO("Verification failed for right waterfall");
				}
			}
		} else {
			UtilHBM.reportKO("Property verification failed for right waterfall");
		}

		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyWallPanelOptions(String wallPanelHeight, String side, String isLeftWPOptionEnabled, String leftWPOption, String isRightWPOptionEnabled, String rightWPOption) {
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (wallPanelHeight.isEmpty()) {
			UtilHBM.reportOK("wall panel height Option property not available");
		} else if (!(wallPanelHeight.isEmpty())) {
			if (wallPanelHeight.equalsIgnoreCase(wallPanelHt.getAttribute("value"))) {
				UtilHBM.reportOK(
						"wall panel height property changed and value is " + wallPanelHt.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"wall panel height property not changed and value is " + wallPanelHt.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for wall panel height");
		}
		if (side.isEmpty()) {
			UtilHBM.reportOK("Wall Panel side property not available");
		} else {
			if (side.equalsIgnoreCase(new Select(wallpanelSide).getFirstSelectedOption().getText())) {
				UtilHBM.reportOK("Wall Panel side property changed: "+new Select(wallpanelSide).getFirstSelectedOption().getText());
			} else UtilHBM.reportKO("Wall Panel side property is different : "+new Select(wallpanelSide).getFirstSelectedOption().getText());
		}
		if(!isLeftWPOptionEnabled.isEmpty()){
			String expected = isLeftWPOptionEnabled.trim().toLowerCase();
			if (expected.equals("true")) {
				Verification.VerifyEquals("Ability to edit leftWP option", Boolean.toString(leftWallpanelOption.isEnabled()), expected);
			}else if(expected.equals("false")){
				UtilHBM.turnOffImplicitWaits(driver);
				try {
					if(leftWallpanelOption.isEnabled())UtilHBM.reportKO("Field value 'leftWallpanelOption' is enabled");
				} catch (NoSuchElementException e) {}
				UtilHBM.turnOnImplicitWaits(driver);
			}else {
				UtilHBM.reportKO("Field value 'isLeftWPOptionDisabled' can be either true or false");
			}
		}

		if (!leftWPOption.isEmpty()) {
			if (leftWPOption.equalsIgnoreCase(Boolean.toString(leftWallpanelOption.isSelected()))) {
				UtilHBM.reportOK(
						"Left Wall Panel option changed and value is " + leftWallpanelOption.isSelected());
			} else {
				UtilHBM.reportKO("Left Wall Panel option property not changed and value is "
						+ leftWallpanelOption.isSelected());
			}
		}

		if(!isRightWPOptionEnabled.isEmpty()){
			String expected = isRightWPOptionEnabled.trim().toLowerCase();
			if (expected.equals("true")) {
				Verification.VerifyEquals("Ability to edit right WP option", Boolean.toString(rightWallpanelOption.isEnabled()), expected);
			} else if(expected.equals("false")){
				UtilHBM.turnOffImplicitWaits(driver);
				try {
					if(rightWallpanelOption.isEnabled())UtilHBM.reportKO("Field value 'rightWallpanelOption' is enabled");
				} catch (NoSuchElementException e) {}
				UtilHBM.turnOnImplicitWaits(driver);
			}else {
				UtilHBM.reportKO("Field value 'isRightWPOptionDisabled' can be either true or false");
			}
		}

		if (!rightWPOption.isEmpty()) {
			if (rightWPOption.equalsIgnoreCase(Boolean.toString(rightWallpanelOption.isSelected()))) {
				UtilHBM.reportOK(
						"Right Wall Panel option changed and value is " + rightWallpanelOption.isSelected());
			} else {
				UtilHBM.reportKO("Right Wall Panel option property not changed and value is "
						+ rightWallpanelOption.isSelected());
			}
		}

		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifySinkProperties(String sinkXOffset, String sinkYOffset, String mounting,
			String sideSinkXOffset, String sideSinkYOffset, String groovesPosition) {
		sinkOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (sinkXOffset.isEmpty()) {
			UtilHBM.reportOK("Sink X offset property not available");
		} else if (!(sinkXOffset.isEmpty())) {
			if (sinkXOffset.equalsIgnoreCase(inputSinkXOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sink X offset property changed and value is " + inputSinkXOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Sink X offset property not changed and value is " + inputSinkXOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sink X offset");
		}
		if (sinkYOffset.isEmpty()) {
			UtilHBM.reportOK("Sink Y offset property not available");
		} else if (!(sinkYOffset.isEmpty())) {
			if (sinkYOffset.equalsIgnoreCase(inputSinkYOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sink Y offset property changed and value is " + inputSinkYOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Sink Y offset property not changed and value is " + inputSinkYOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sink Y offset");
		}

		if (!(mounting.isEmpty())) {
			WebElement element = driver.findElement(By.cssSelector(("select[data-ui-publicationid='sinkMounting']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(mounting)) {
				UtilHBM.reportOK("Verification for Sink Mounting passed and value is : " + defaultItem + " with value "
						+ option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for Sink Mounting failed and value is : " + defaultItem + " with value "
						+ option.getAttribute("value"));
			}
		}
		if (!(sideSinkXOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkXOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideSinkXOffset)) {
				UtilHBM.reportOK("Verification for Side Sink X offset passed and value is : " + defaultItem
						+ " with value " + sideSinkXOffset);
			} else {
				UtilHBM.reportKO("Verification for Side Sink X offset failed and value is : " + defaultItem
						+ " with value " + sideSinkXOffset);
			}
		}
		if (!(sideSinkYOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkYOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideSinkYOffset)) {
				UtilHBM.reportOK("Verification for Side Sink Y offset passed and value is : " + defaultItem
						+ " with value " + option.getText());
			} else {
				UtilHBM.reportKO("Verification for Side Sink Y offset failed and value is : " + defaultItem
						+ " with value " + option.getText());
			}
		}
		if (!(groovesPosition.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='drainerGroovesPosition']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(groovesPosition)) {
				UtilHBM.reportOK("Verification for drainer grooves position passed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for drainer grooves position failed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			}
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifyFaucetProperties(String faucetXOffset, String isFaucetXOffsetEditable, String faucetYOffset, String isFaucetYOffsetEditable, String sideFaucetXOffset,
			String sideFaucetYOffset) {
		faucetOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if (faucetXOffset.isEmpty()) {
			UtilHBM.reportOK("Faucet X offset property not available");
		} else if (!(faucetXOffset.isEmpty())) {
			if(!isFaucetXOffsetEditable.isEmpty()){
				String expected = isFaucetXOffsetEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit faucet x-offset", Boolean.toString(inputFaucetXOffset.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isFaucetXOffsetEditable' can be either true or false");
				}
			}

			if (faucetXOffset.equalsIgnoreCase(inputFaucetXOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Faucet X offset property changed and value is " + inputFaucetXOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Faucet X offset property not changed and value is "
						+ inputFaucetXOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Faucet X offset");
		}
		if (faucetYOffset.isEmpty()) {
			UtilHBM.reportOK("Faucet Y offset property not available");
		} else if (!(faucetYOffset.isEmpty())) {
			if(!isFaucetYOffsetEditable.isEmpty()){
				String expected = isFaucetYOffsetEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to editfaucet y-offset", Boolean.toString(inputFaucetYOffset.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isFaucetYOffsetEditable' can be either true or false");
				}
			}

			if (faucetYOffset.equalsIgnoreCase(inputFaucetYOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Faucet Y offset property changed and value is " + inputFaucetYOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Faucet Y offset property not changed and value is "
						+ inputFaucetYOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sink Y offset");
		}

		if (!(sideFaucetXOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideFaucetXOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideFaucetXOffset)) {
				UtilHBM.reportOK("Verification for Side Faucet X offset passed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for Side Faucet X offset failed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			}
		}
		if (!(sideFaucetYOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideFaucetYOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideFaucetYOffset)) {
				UtilHBM.reportOK("Verification for Side Faucet Y offset passed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for Side Faucet Y offset failed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			}
		}

		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifySinkOffsets(String sinkXOffset, String isXOffsetEditable, String sinkYOffset, String isYOffsetEditable, String sideSinkXOffset, String sideSinkYOffset) {
		sinkOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);

		UtilHBM.turnOffImplicitWaits(driver);
		WebElement inpSinkXOffset, inpSinkYOffset;
		try {
			inputSinkXOffset.isDisplayed();
			inpSinkXOffset = inputSinkXOffset;
		} catch (NoSuchElementException e) {
			inpSinkXOffset = inputSinkXOffset2;
		}
		try {
			inputSinkYOffset.isDisplayed();
			inpSinkYOffset = inputSinkYOffset;
		} catch (NoSuchElementException e) {
			inpSinkYOffset = inputSinkYOffset2;
		}
		UtilHBM.turnOnImplicitWaits(driver);

		if (sinkXOffset.isEmpty()) {
			UtilHBM.reportOK("Sink X offset property not available");
		} else if (!(sinkXOffset.isEmpty())) {
			if (!isXOffsetEditable.isEmpty()) {
				String expected = isXOffsetEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit sink x-offset", Boolean.toString(inpSinkXOffset.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isXOffsetEditable' can be either true or false");
				}
			}

			if (sinkXOffset.equalsIgnoreCase(inpSinkXOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sink X offset property value is " + inpSinkXOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Sink X offset property  value is " + inpSinkXOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sink X offset");
		}

		if (sinkYOffset.isEmpty()) {
			UtilHBM.reportOK("Sink Y offset property not available");
		} else if (!(sinkYOffset.isEmpty())) {
			if (!isYOffsetEditable.isEmpty()) {
				String expected = isYOffsetEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit sink y-offset", Boolean.toString(inpSinkYOffset.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isYOffsetEditable' can be either true or false");
				}
			}

			if (sinkYOffset.equalsIgnoreCase(inpSinkYOffset.getAttribute("value"))) {
				UtilHBM.reportOK(
						"Sink Y offset property  value is " + inpSinkYOffset.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Sink Y offset property value is " + inpSinkYOffset.getAttribute("value"));
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Sink Y offset");
		}

		if (!(sideSinkXOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkXOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideSinkXOffset)) {
				UtilHBM.reportOK("Verification for Side Sink X offset passed and value is : " + defaultItem
						+ " with value " + sideSinkXOffset);
			} else {
				UtilHBM.reportKO("Verification for Side Sink X offset failed and value is : " + defaultItem
						+ " with value " + sideSinkXOffset);
			}
		}
		if (!(sideSinkYOffset.isEmpty())) {
			WebElement element = driver
					.findElement(By.cssSelector(("select[data-ui-publicationid='sideSinkYOffset']")));
			Select oSelect = new Select(element);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(sideSinkYOffset)) {
				UtilHBM.reportOK("Verification for Side Sink Y offset passed and value is : " + defaultItem
						+ " with value " + option.getText());
			} else {
				UtilHBM.reportKO("Verification for Side Sink Y offset failed and value is : " + defaultItem
						+ " with value " + option.getText());
			}
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifySinkMounting(String mounting , String isMountingEditable){
		sinkOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);

		if (!(mounting.isEmpty())) {
			if (!isMountingEditable.isEmpty()) {
				String expected = isMountingEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit sink mounting", Boolean.toString(selectSinkMounting.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isMountingEditable' can be either true or false");
				}
			}

//			WebElement element = driver.findElement(By.cssSelector(("select[data-ui-publicationid='sinkMounting']")));
			Select oSelect = new Select(selectSinkMounting);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(mounting)) {
				UtilHBM.reportOK("Verification for Sink Mounting passed and value is : " + defaultItem + " with value "
						+ option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for Sink Mounting failed and value is : " + defaultItem + " with value "
						+ option.getAttribute("value"));
			}
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}

	public OptionsPanel verifySinkDrainerGrooves(String groovesAdded, String isAddDrainerGroovesEditable, String groovesPosition, String isGroovesPositionEditable){
		sinkOptionsButton.sendKeys(Keys.ENTER);
		WebElement optionsPanel = driver.findElement(By.cssSelector(".options-mod-panel.mod-open"));
		UtilHBM.waitExplicitDisplayed(driver, optionsPanel);
		if(!groovesAdded.isEmpty()){
			if(!isAddDrainerGroovesEditable.isEmpty()){
				String expected = isAddDrainerGroovesEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit drainer grooves position", Boolean.toString(addDrainerGroovesToggle.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isAddDrainerGroovesEditable' can be either true or false");
				}
			}

			String expected=groovesAdded.trim().toLowerCase();
			if (expected.equals("true") || expected.equals("false")) {
				Verification.VerifyEquals("Drainer groove added ", Boolean.toString(addDrainerGroovesToggle.isSelected()), expected);
			} else {
				UtilHBM.reportKO("Field value 'groovesAdded' can be either true or false");
			}
		}

		if ((!groovesPosition.isEmpty()) && addDrainerGroovesToggle.isSelected()) {
			if (!isGroovesPositionEditable.isEmpty()) {
				String expected = isGroovesPositionEditable.trim().toLowerCase();
				if (expected.equals("true") || expected.equals("false")) {
					Verification.VerifyEquals("Ability to edit drainer grooves position", Boolean.toString(selectDrainerGroovePosition.isEnabled()), expected);
				} else {
					UtilHBM.reportKO("Field value 'isGroovesPositionEditable' can be either true or false");
				}
			}

//			WebElement element = driver.findElement(By.cssSelector(("select[data-ui-publicationid='drainerGroovesPosition']")));
			Select oSelect = new Select(selectDrainerGroovePosition);
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();

			if (defaultItem.equalsIgnoreCase(groovesPosition)) {
				UtilHBM.reportOK("Verification for drainer grooves position passed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification for drainer grooves position failed and value is : " + defaultItem
						+ " with value " + option.getAttribute("value"));
			}
		}
		return PageFactory.initElements(driver, OptionsPanel.class);
	}
}
