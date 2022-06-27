package kitchen.templateEditor.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Substitutions {
	WebDriver driver;

	public Substitutions(WebDriver driver) {
		this.driver=driver;	
	}
	@FindBy(css="#template-editor-panel>div>div>section>div>button.cta-primary-l")
	WebElement addSubstitutionsButton;

	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	@FindBy(css="#step-substitution")
	WebElement substitutionStep;

	@FindBy(css=".cta-primary")
	WebElement nextButton;
	
	@FindBy(css="button[data-ui-action='add-distance-rule']")
	WebElement addDistanceRuleButton;
	
	@FindBy(css="button[data-ui-action='add-alignment-rule']")
	WebElement addAlignmentRuleButton;
	
	@FindBy(css="//input[@data-ui-value='left']//parent::label/span[@class='state']")
	WebElement leftAlignmentRadioButton;
	
	@FindBy(css="//input[@data-ui-value='right']//parent::label/span[@class='state']")
	WebElement rightAlignmentRadioButton;
	
	@FindBy(css="button[data-ui-action='validate-alignment-rule']")
	WebElement validateAlignmentRuleButton;
	
	@FindBy(css="button[data-ui-action='validate-distance-rule']")
	WebElement validateDistanceRuleButton;
	
	@FindBy(css="button[data-ui-action='display-original']")
	WebElement originalSolution;
	
	@FindBy(css="button[data-ui-action='display-min']")
	WebElement minimalSolution;
	
	@FindBy(css="#substitution-definition-table>section>button")
	WebElement addReplacementButton;

	@FindBy(css="ul.product-replacement-list>li>div>p>button")
	List<WebElement> selectReplacementProductButton;
	
	@FindBy(css="#template-editor-panel>div>div>section>ul>li")
	List<WebElement> subgroupList;

	@FindBy(css="li[data-ui-second-level-index='0']:nth-child(1)>p>button")
	WebElement selectProductButton;

	@FindBy(css="button[data-ui-action='add-link']")
	WebElement addSubGroup;

	@FindBy(css="button[data-ui-action='add replacement']")
	WebElement addMoreButton;

	@FindBy(css="#link-definition-table>div>div>div>div.inner-horizontal>ul>li>p>button")
	List<WebElement> selectReplacementButton;

	@FindBy(css="li[data-ui-action='product-add']")
	List<WebElement> productList;

	@FindBy(css="#catalogSearchBar-form-input")
	WebElement searchKeyInput;

	@FindBy(css=".bt-icon-search")
	WebElement searchButton;

	@FindBy(css="h2")
	WebElement title1;

	@FindBy(css="#wizard-title")
	WebElement title2;

	@FindBy(css=".content-inner>div>p.intro")
	WebElement title3;

	@FindBy(css="div.main-actions>p>b")
	WebElement subtitle2;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select one group by clicking on it to add replacements')]")
	WebElement selectGroupForSubstitutionMsg;

	@FindBy(css="button[class='cta-primary-l']")
	WebElement subGroupButton;

	@FindBy(css="ul.group-list>li")
	List<WebElement> groupList;

	@FindBy(css="p.intro")
	WebElement subtitle1;
	
	@FindBy(css="button[data-state='design']")
	WebElement designButton;
	
	@FindBy(css="ul.group-list>li>div>button[data-ui-action='delete']")
	WebElement deleteSubGroupButton;
	
	@FindBy(css="button[data-ui-action='display-max'].bt-tab.selected")
	private WebElement maximalSoluitionSelectedState;
	
	String subtitle1ExpectedText="Substitution rules allow a group to resize itself to fit available space.";
	String subtitle2ExpectedText="Add subsitution rules to a group if you want to make your design more flexible.";
	String subtitle4ExpectedText="Create sub-group of linked products by clicking on them. Products in a sub-group will be resized or replaced together, so that when one is replaced, the others will follow accordingly.A product can only be in one sub-group.";

	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Substitutions editSubstitution(String groupName,String substitutionParameters)
	{
		substitutionStep.click();
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'"+groupName+"')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		deleteSubGroupButton.click();
		UtilHBM.waitFixTime(3000);	
		selectSubGroup(substitutionParameters);
		selectReplacementProduct(substitutionParameters);
		independentReplacement(substitutionParameters);
		distanceRule(substitutionParameters);
		alignmentRule(substitutionParameters);
		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
		UtilHBM.reportOK("Maximal solution displayed");
		if(originalSolution.isDisplayed())
			originalSolution.click();
		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
		UtilHBM.reportOK("Original solution displayed");
		if(minimalSolution.isDisplayed())
			minimalSolution.click();
		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
		UtilHBM.reportOK("Minimal solution displayed");
		nextButton.click();
		UtilHBM.reportOK("Substitution "+groupList.get(groupList.size()-1).findElement(By.cssSelector("p.text")).getText()+" created");

		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	
	public Substitutions createSubtitution(String substitutionParameters)
	{
		UtilHBM.reportInfo("Creating new substitution");
		substitutionStep.click();
		Verification.VerifyEquals("Page title not displayed", title1.getText(), "Substitutions list");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle1.getText(), subtitle1ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), subtitle2ExpectedText);
		addSubstitutionsButton.click();
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Group selection");
		UtilHBM.reportOK("selecting group");
		int groupXCoordinate=Integer.parseInt(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[0].split(",")[0]);
		int groupYCoordinate=Integer.parseInt(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[0].split(",")[1]);
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, selectGroupForSubstitutionMsg);
		selectProduct(groupXCoordinate,groupYCoordinate);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, addSubGroup);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Link Definition");
		selectSubGroup(substitutionParameters);
		selectReplacementProduct(substitutionParameters);
		independentReplacement(substitutionParameters);
		distanceRule(substitutionParameters);
		alignmentRule(substitutionParameters);
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitTillElementDisappear(driver, "div#canvas-wrap-1 div.mod-loader span.spinner>svg.icon-view-loader");
//		UtilHBM.waitTillElementDisappear(driver,".spinner>.icon-view-loader");
//		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='canvas-wrap cursor-rotate']");
		Verification.displayNAttributeCheckOfElement(maximalSoluitionSelectedState, "Maximal Button", "text", "MAXIMAL");//div#canvas-wrap-1 div.mod-loader span.spinner>svg.icon-view-loader
//		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
		UtilHBM.waitExplicitClickable(driver, originalSolution);
		originalSolution.click();
//		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".spinner>.icon-view-loader[aria-hidden='true']"));
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK("Original solution displayed");
		UtilHBM.waitTillElementDisappear(driver, "div#canvas-wrap-1 div.mod-loader span.spinner>svg.icon-view-loader");
		UtilHBM.waitExplicitClickable(driver, minimalSolution);
//		UtilHBM.waitFixTime(2000);
		minimalSolution.click();
//		UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
		UtilHBM.reportOK("Minimal solution displayed");
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitTillElementDisappear(driver, "div#canvas-wrap-1 div.mod-loader span.spinner>svg.icon-view-loader");
		nextButton.click();
		UtilHBM.reportOK("Substitution "+groupList.get(groupList.size()-1).findElement(By.cssSelector("p.text")).getText()+" created");
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions alignmentRule(String substitutionParameters)
	{
		String alignmentRule=UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[5];
		if(!alignmentRule.equalsIgnoreCase("null"))
		{
			if(alignmentRule.contains(";"))
			{
				for(String a:alignmentRule.split(";"))
				{
					addAlignmentRuleButton.click();
					if(a.split(">")[0].contentEquals("Left"))
					{
						leftAlignmentRadioButton.click();
					}
					else if(a.split(">")[0].contentEquals("Right"))
					{
						rightAlignmentRadioButton.click();
					}
					selectProduct(Integer.parseInt(a.split(">")[1].split("/")[0].split(",")[0]), Integer.parseInt(a.split(">")[1].split("/")[0].split(",")[1]));
					selectProduct(Integer.parseInt(a.split(">")[1].split("/")[1].split(",")[0]), Integer.parseInt(a.split(">")[1].split("/")[1].split(",")[1]));
					validateAlignmentRuleButton.click();
					UtilHBM.reportOK("Alignment rule added");
				}
			}
			else
			{
				addAlignmentRuleButton.click();
				if(alignmentRule.split(">")[0].contentEquals("Left"))
				{
					leftAlignmentRadioButton.click();
				}
				else if(alignmentRule.split(">")[0].contentEquals("Right"))
				{
					rightAlignmentRadioButton.click();
				}
				selectProduct(Integer.parseInt(alignmentRule.split(">")[1].split(",")[0]), Integer.parseInt(alignmentRule.split(">")[1].split(",")[1]));
				validateAlignmentRuleButton.click();
				UtilHBM.reportOK("Alignment rule added");
			}
			nextButton.click();
		}
		else
			nextButton.click();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions distanceRule(String substitutionParameters)
	{
		String distanceRule=UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[4];
		if(!distanceRule.equalsIgnoreCase("null"))
		{
			if(distanceRule.contains(";"))
			{
				for(String a:distanceRule.split(";"))
				{
					addDistanceRuleButton.sendKeys(Keys.ENTER);
					selectProduct(Integer.parseInt(a.split("/")[0].split(",")[0]), Integer.parseInt(a.split("/")[0].split(",")[1]));
					selectProduct(Integer.parseInt(a.split("/")[1].split(",")[0]), Integer.parseInt(a.split("/")[1].split(",")[1]));
					selectProduct(Integer.parseInt(a.split("/")[2].split(",")[0]), Integer.parseInt(a.split("/")[2].split(",")[1]));
					validateDistanceRuleButton.click();
					UtilHBM.reportOK("Distance rule added");
				}
			}
			else
			{
				addDistanceRuleButton.sendKeys(Keys.ENTER);
				selectProduct(Integer.parseInt(distanceRule.split("/")[0].split(",")[0]), Integer.parseInt(distanceRule.split("/")[0].split(",")[1]));
				selectProduct(Integer.parseInt(distanceRule.split("/")[1].split(",")[0]), Integer.parseInt(distanceRule.split("/")[1].split(",")[1]));
				selectProduct(Integer.parseInt(distanceRule.split("/")[2].split(",")[0]), Integer.parseInt(distanceRule.split("/")[2].split(",")[1]));
				validateDistanceRuleButton.click();
				UtilHBM.reportOK("Distance rule added");
			}
			nextButton.click();
			
		}
		else
			nextButton.click();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions independentReplacement(String substitutionParameters)
	{
		String independentReplacement=UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3];
		if(!independentReplacement.equalsIgnoreCase("null"))
		{
			if(independentReplacement.contains(";"))
			{
				for(String a:independentReplacement.split(";"))
				{
					selectProduct(Integer.parseInt(a.split("/")[0].split(",")[0]), Integer.parseInt(a.split("/")[0].split(",")[1]));
					UtilHBM.waitFixTime(3000);
					addReplacementButton.click();
					if(a.split("/")[1].contains(","))
					{
						for(String b:a.split("/")[1].split(","))
						{
							selectReplacementProductButton.get(selectReplacementProductButton.size()-1).click();
							SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
							substitutionLinkDefCatalog.selectProduct(b);
							UtilHBM.reportOK("Indepenedent replacement added:"+b);
						}
					}
					else
					{
						selectReplacementProductButton.get(selectReplacementProductButton.size()-1).click();
						SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
						if(a.split("/")[1].contains(">"))
							substitutionLinkDefCatalog.selectProduct(a.split("/")[1].split(">")[0],a.split("/")[1].split(">")[1]);
						else
							substitutionLinkDefCatalog.selectProduct(a.split("/")[1].split(">")[0]);
						UtilHBM.reportOK("Independent replacement added:"+a.split("/")[1].split(">")[0]);
					}
					clickBlank();
				}
			}
			else
			{
				selectProduct(Integer.parseInt(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[0].split(",")[0]), Integer.parseInt(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[0].split(",")[1]));
				addReplacementButton.click();
				selectReplacementProductButton.get(selectReplacementProductButton.size()-1).click();
				SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
				if(UtilHBM.getProperty((String) "TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[1].contains(">"))
					substitutionLinkDefCatalog.selectProduct(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[1].split(">")[0],UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[1].split(">")[1]);
				else
					substitutionLinkDefCatalog.selectProduct(UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[1].split(">")[0]);
				UtilHBM.reportOK("Independent replacement added:"+UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[3].split("/")[1].split(">")[0]);
			}
			nextButton.click();
		}
		else
			nextButton.click();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions selectReplacementProduct(String substitutionParameters)
	{
		String replacementProduct=UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[2];
		if(!replacementProduct.equalsIgnoreCase("null"))
		{
			if(replacementProduct.contains(";"))
			{
				for(String l:replacementProduct.split(";"))
				{
					for(int i=0;i<l.split(";").length;i++)
					{
						if(l.contains(","))
						{
							for(String b:l.split(","))
							{
								for(int j=0;j<b.split("/").length;j++)
								{
									UtilHBM.waitFixTime(3000);
									UtilHBM.waitExplicitDisplayed(driver, selectReplacementButton.get(0));
									UtilHBM.waitFixTime(1000);
									selectReplacementButton.get(0).click();
									SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
									substitutionLinkDefCatalog.selectProduct(b.split("/")[j]);
									UtilHBM.reportOK("Replacement "+b.split("/")[j]+" added");
									UtilHBM.waitFixTime(3000);
								}
								addMoreButton.click();
							}
						}	
						else 
							for(int j=0;j<l.split("/").length;j++)
							{
								selectReplacementButton.get(0).click();
								SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
								substitutionLinkDefCatalog.selectProduct(l.split("/")[j]);
								UtilHBM.reportOK("Replacement "+l.split("/")[j]+" added");
							}
						addMoreButton.click();	
					}
					nextButton.click();
				}
			}		
			else
			{
				if(replacementProduct.contains(","))
				{
					for(String b:replacementProduct.split(","))
					{
						for(int j=0;j<b.split("/").length;j++)
						{

							selectReplacementButton.get(0).click();
							SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
							substitutionLinkDefCatalog.selectProduct(b.split("/")[j]);
							UtilHBM.reportOK("Replacement "+b.split("/")[j]+" added");
						}
						addMoreButton.click();
					}
				}	
				else 
					for(int j=0;j<replacementProduct.split("/").length;j++)
					{
						selectReplacementButton.get(0).click();
						SubstitutionLinkDefCatalog substitutionLinkDefCatalog=PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
						substitutionLinkDefCatalog.selectProduct(replacementProduct.split("/")[j]);
						UtilHBM.reportOK("Replacement "+replacementProduct.split("/")[j]+" added");
					}
				addMoreButton.click();	
			}
		}
		else
			nextButton.click();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions selectSubGroup(String substitutionParameters)
	{
		String subGrpCoordinates=UtilHBM.getProperty("TemplateEditor", substitutionParameters+"Substitution").split(":")[1];
		clickBlank();
		if(!subGrpCoordinates.equalsIgnoreCase("null"))
		{
			if(subGrpCoordinates.contains(";"))
			{
				for(String a:subGrpCoordinates.split(";"))
				{
					for(String b:a.split("/"))
					{
						selectProduct(Integer.parseInt(b.split(",")[0]),Integer.parseInt(b.split(",")[1]));
					}
					UtilHBM.waitFixTime(500);
					addSubGroup.click();
					UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "ul.group-list>li"));
				}
				nextButton.click();
				
			}
			else
			{
				for(String a:subGrpCoordinates.split("/"))
				{
					selectProduct(Integer.parseInt(a.split(",")[0]), Integer.parseInt(a.split(",")[1]));
				}
				addSubGroup.click();
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "ul.group-list>li"));
				nextButton.click();
			}
		}
		else
			nextButton.click();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions clickBlank() 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Substitutions.class);
	}
	
	Substitutions selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();		
		return PageFactory.initElements(driver, Substitutions.class);
	}

}
