package hbm.web.pageobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.pageobject.NewProject;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ProjectPage {
	
	private static String uName;

	WebDriver driver;
	
	public ProjectPage(WebDriver driver) {
		this.driver = driver;		 
	}
	
	@FindBy(css = "#app-notification>p.success")
	private WebElement addToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.success>button>span.icon-view-close.icon-content")
	private WebElement closeAddToCollectionSuccess;
	
	@FindBy(css = "#app-notification>p.error")
	private WebElement alreadyAvailableInCollection;
	
	@FindBy(css = "#app-notification>p.error>button>span.icon-view-close.icon-content")
	private WebElement closeAlreadyAvailableInCollection;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement myProjects;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;
	
	@FindBy(css=".at-expanded-menu-page-title")
	private WebElement emailProjectTitle;
	
	@FindBy(css=".at-expanded-menu-page-url")
	private WebElement emailProjectURL;
	
	@FindBy(id="at-expanded-menu-title")
	private WebElement emailAFriendTitle;
	
	@FindBy(css="#swipper-wrapper>.swiper-slide.swiper-slide-active img")
	private WebElement sliderCurrentImage;
	
	@FindBy(id="trigger-fullscreen")
	WebElement fullscreenIcon;
	
	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;
	
	@FindBy(css = "div.wrapper>.header-logo>a[href='/en/partner/gautier']")
	WebElement homebymeLinkMDM;
	
	@FindBy(css="#slider-origin-content>div.swiper-container.swiper-container-fade.swiper-container-initialized.swiper-container-horizontal > button.swiper-button-next")
	List<WebElement> sliderNextButton;
	
	@FindBy(css=".swiper-pagination.swiper-pagination-white.swiper-pagination-clickable.swiper-pagination-bullets>.swiper-pagination-bullet")
	List<WebElement> noOfBullets;
	
	@FindBy(css="#box-question>div.comment-area>div.editable")
	private WebElement enterNewComment;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']")
	List<WebElement> commentList;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='answers']/p/a")
	List<WebElement> loadOlderMessages;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='answers']/div[@class='answer']/div[@class='item flex']/div[@class='item-data w-100']")
	List<WebElement> firstCommentReplyList;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div[@class='actions']/span[2]/div/span[2]")
	WebElement firstCommentLikes;

	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='answers']/div[@class='answer']")
	List<WebElement> firstCommentRepliesList;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/p/span")
	List<WebElement> firstCommentShowHideReplies;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div[@class='actions']/*[.='Reply']")
	WebElement firstCommentReplyButton;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='answers']/div[@class=' item flex u-mbs']/div[@class='w-100']/div")
	WebElement firstCommentReplyBox;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div[@class='actions']/span[2]/div/span[1]")
	WebElement firstCommentLikeButton;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/a")
	WebElement firstCommenter;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/span")
	WebElement firstCommentTime;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='more']/i")
	WebElement firstCommentMoreIcon;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='answers']/div[@class='answer']/div[@class='item flex']/div[@class='more']")
	List<WebElement> replyMoreIcon;

	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div[@class='u-mbn content']")
	List<WebElement> firstCommentText;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='more']/div/ul/li/p[1]/span")
	WebElement editCommentButton;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='more']/div/ul/li/p[2]/span")
	WebElement deleteCommentButton;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div[@class='editable u-mtxxs']")
	WebElement editCommentTextarea;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div/div[@class='flex-left']/p/span")
	WebElement editCommentCancel;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']/div[@class='item-data w-100']/div/div[@class='flex-right']/a")
	WebElement editCommentOK;
	
	@FindBy(xpath="//*[@id='box-question']/div[@class='']/div[@class='item flex']")
	WebElement firstCommentBox;
	
	@FindBy(css="div.description>textarea")
	private WebElement descriptionTextarea;
	
	@FindBy(css="div.description>span")
	private WebElement projectDescription;
	
	@FindBy(css="li.building-type.icon-content>select")
	private WebElement descriptionBuildingSelect;
	
	@FindBy(css="li.building-type.icon-content>span")
	private WebElement descriptionBuildingText;
	
	@FindBy(css="li.type.icon-content>select")
	private WebElement descriptionTypeSelect;
	
	@FindBy(css="li.type.icon-content>span")
	private WebElement constructionBuildingText;
	
	@FindBy(css="div.box.project-description>button")
	private WebElement editDescription;
	
	@FindBy(xpath="//div[@class='tags']/ul/li/span")
	List<WebElement> tagsAdded;
	
	@FindBy(xpath="//div[@class='tags']/ul/li/span/following-sibling::a")
	List<WebElement> tagsAddedClose;
	
	@FindBy(css="div.tags>ul>li>input[type='text']")
	private WebElement tagsInput;
	
	@FindBy(css="li.tagit-new")
	private WebElement tagsInputEnter;
	
	@FindBy(css="button.buttonSecondary")
	private WebElement deleteMediaNo;
	
	@FindBy(css="div.confirm-box-btns>button.button")
	private WebElement deleteMediaYes;
	
	@FindBy(css="div.confirm-box>p")
	private WebElement deleteDialogBoxText;
	
	@FindBy(css="div.media>div")
	List<WebElement> mediaList;
	
	@FindBy(css=".media>.media-thumb>.media-thumb-link>img")
	List<WebElement> imageList;
	
	@FindBy(id="editProjectTag")
	private WebElement editTags;
	
	@FindBy(id="sort_media_type")
	private WebElement mediaFilter;
	
	@FindBy(css="ul#project-header-actions>li>button[class='bt-icon mol-pimple-filter js-confirm']>svg>use")
	private WebElement deleteButton;
	
	@FindBy(css="ul#project-header-actions>li>span[class='button--alt button--icon js-confirm']")
	private WebElement deletePRojectHbm4;
	
	@FindBy(css="ul[id='project-header-actions']>li>a[href$='planner']")
	private WebElement openProjectButton;
	
	@FindBy(css = "ul#project-header-actions>li>#duplicate_button")
	private WebElement duplicateButton;
	
	@FindBy(css="button[title='Visit in virtual reality'][class='bt-icon mol-pimple-filter open-experience-vr getVR']")
	private WebElement vrButton;
	
	@FindBy(xpath="//input[@class='form-checkbox']/following-sibling::label")
	private WebElement duplicateProjectMedia;
	
	@FindBy(xpath="//button[@title='Share'][@class='bt-icon mol-pimple-filter share-button']")
	private WebElement shareProjectButton;
	
	@FindBy(css="#project-page>.subHeader>.wrapper>.subHeader-txt>#project-header-actions>li>#trigger-overlay-mobile>.icon.icon-immersive-view")
	private WebElement immersiveViewButton;
	
	@FindBy(css="#partner-page>.subHeader>.wrapper>.subHeader-txt>.subHeader-buttonList>.subHeader-buttonList-item>.shareBox>.icon-content.button--alt.button--icon.flex-center")
	private WebElement shareMDMProjectButton;
	
	@FindBy(css="input[class='button']")
	private WebElement projectDuplicateOKButton;
    
	@FindBy(css="section.grid>div>.media>.media-thumb>.media-thumb-link>span[data-modal-href$='/upgrade']")
    private List<WebElement> upgradeImgBtnList;
		
	@FindBy(css="nav.projectNav>div>ul>li>a[title*='Images']")
	 private WebElement imagesTab;
	
	@FindBy(css="nav.projectNav>div>ul>li>a[title*='Rooms']")
	 private WebElement roomsTab;
	
	@FindBy(css="nav.projectNav>div>ul>li>a[title='Images']")
	 private List<WebElement> imagesTabList;
	
	@FindBy(css="nav.projectNav>div>ul>li>a[title*='Products']")
	private List<WebElement> productsTabList;
	
	@FindBy(css="#shopping-list>div>div>div>ul>li>article>div>img")
	private List<WebElement> allProductsImages;
	
	@FindBy(css="#shopping-list>div>div>div>ul>li>article>div.mol-label-product-presentation>.ato-label-brand")
	private List<WebElement> allBrandNames;
	
	@FindBy(css="#shopping-list>div>div>div>ul>li>article>div.mol-label-product-presentation>.ato-label-product")
	private List<WebElement> allProductNames;
	
	@FindBy(css="div[data-modal-open='modal_product_open']")
	private List<WebElement> availableProductList;
	
	@FindBy(css=".wrapper>.grid.grid--product>.grid-1-4.u-mbs>.media>.media-thumb>span>img")
	private List<WebElement> allProductsImagesMDM;
	
	@FindBy(css=".wrapper>.grid.grid--product>.grid-1-4.u-mbs>.media>.media-legend>h3")
	private List<WebElement> allBrandNamesMDM;
	
	@FindBy(css=".wrapper>.grid.grid--product>.grid-1-4.u-mbs>.media>.media-legend>span")
	private List<WebElement> allProductNamesMDM;
	
//	@FindBy(css="a.close-modal.button-close")
//	private WebElement closePopup;
	
	@FindBy(css="a[title='Our offers']")
	private WebElement ourOffers;
	
	@FindBy(css="a[title='Top Projects']")
	private WebElement topProjects;	
	

	@FindBy(css="a[class='button embed-buttonHBM']")
	private WebElement viewThisProject;
	
	@FindBy(css="#turntableContainer>div.reel.reel-overlay>img")
	private WebElement embededProjectTurnableImg;
	
	@FindBy(css="div.subHeader-thumb-img>img")
	private WebElement subHeaderThumbImg;
	
	@FindBy(css="div.subHeader-thumb-txt>h1")
	private WebElement subHeaderProjectName;
	
	@FindBy(css="time.media-time")
	private WebElement subHeaderProjectTime;
	
	@FindBy(css="a.byUser.byUser--small>span")
	private WebElement projectByUser;

	@FindBy(xpath="//ul[@id='project-header-actions']/li")
	private List<WebElement> projectActions;
	
	@FindBy(css = "ul.projectLegend>li")
	private List<WebElement> projectInfo;
		
	@FindBy(css="a.button.open-planner-embed")
	private WebElement openProject;
	
	@FindBy(css="p.subHeader-legend")
	private WebElement projectDetails;
	
	@FindBy(xpath="//li/span[@class='icon icon-floor-light']")
	private WebElement noOfFloorsIcon;
	
	@FindBy(xpath="//li/span[@class='icon icon-room-light']")
	private WebElement noOfRoomsIcon;
	
	@FindBy(xpath="//li/span[@class='icon icon-surface-light']")
	private WebElement surfaceAreaIcon;
	
	@FindBy(xpath="//li/span[@class='icon icon-bedroom-light']")
	private WebElement noOfBedroomsIcon;
	
	@FindBy(xpath="//li/span[@class='icon icon-bathroom-light']")
	private WebElement noOfBathroomsIcon;
	
//	@FindBy(xpath="//li/span[@class='icon icon-view-light']")
//	private WebElement viewsIcon;

	@FindBy(css="div.modal-header > h2")
	private WebElement duplicatePopupHeader;
	
	@FindBy(xpath="//li/span[@class='icon icon-floor-light']/parent::li")
	private WebElement noOfFloors1;
	
	@FindBy(xpath="//li/span[@class='icon icon-room-light']/parent::li")
	private WebElement noOfRooms1;
	
	@FindBy(xpath="//li/span[@class='icon icon-surface-light']/parent::li")
	private WebElement surfaceArea1;
	
	@FindBy(xpath="//li/span[@class='icon icon-bedroom-light']/parent::li")
	private WebElement noOfBedrooms1;
	
	@FindBy(xpath="//li/span[@class='icon icon-bathroom-light']/parent::li")
	private WebElement noOfBathrooms1;
	
//	@FindBy(xpath="//li/span[@class='icon icon-view-light']/parent::li")
//	private WebElement views1;
	
	@FindBy(css="div.box.project-color-palette>h2")
	private WebElement colorPaletteHeader;

	@FindBy(css="div.box.project-surfaces>h2")
	private WebElement allSurfacesHeader;
	
	@FindBy(xpath="//div[@class='box project-color-palette']/div[not(@class = 'u-txtRight')]")
	private List<WebElement> colorPaletteElements;
	
	@FindBy(xpath="//div[@class='box project-surfaces']/section/div")
	private List<WebElement> allSurfacesAreaDetails;
	
	@FindBy(xpath="//div[@class='box project-surfaces']/section/h3")
	private List<WebElement> allSurfacesRoomName;
	
	@FindBy(css="div.grid-1-3.u-mbs")
	private List<WebElement> featuredProducts;
	
	@FindBy(css="div.box.featured-products>h2")
	private List<WebElement> featuredProductsTitle;
	
	@FindBy(css="div.u-txtRight>span[class='item-link link-more view-more']")
	private WebElement colorPaletteViewMore;
	
	@FindBy(css="div.box.project-surfaces>div>span[class='item-link link-more view-more u-mtxs']")
	private WebElement allSurfacesViewMore;
	
	@FindBy(css="nav.projectNav>div>ul>li>a[title*='Products']")
	private WebElement productsTab;
	
	@FindBy(css="li>a[class='projectNav-link is-active'][title^='Products']")
	private WebElement activeProductsTab;
	
	@FindBy(css="nav.projectNav>div>ul>li>a[title='Overview']")
	private WebElement overviewTab;
	
	@FindBy(css="a[title='Images']>span[id='countMedias']")
	private WebElement mediaCount;
	
	@FindBy(xpath = "//div[@id='turntable'][contains(@style,'visibility: visible')]/div/div[@id='turntableContainer']/div[starts-with(@class,'reel reel-overlay frame-9')]/img[@class='reel']")
	private List<WebElement> turnTableImg;

	@FindBy(xpath="//h2[.='Description']")
	private List<WebElement> descriptionText;
	
	@FindBy(xpath="//h2[.='Tags']")
	private List<WebElement> tagsText;
	
	@FindBy(xpath="//div[@class='tags']/ul/li/a")
	private List<WebElement> tagsList;
	
	@FindBy(css=".subHeader-title>span")
	private WebElement subHeaderTextEmbed;
	
	@FindBy(css=".subHeader-title>a>img")
	private WebElement subHeaderLogoEmbed;
	
	@FindBy(xpath="//button[@class='swiper-button-prev']")
	private WebElement sliderPrevious;
	
	@FindBy(xpath="//button[@class='swiper-button-next']")
	private WebElement sliderNext;
	
	@FindBy(xpath="//button[@class='slick-next slick-arrow']")
	private WebElement sliderNextMDM;
	
	@FindBy(xpath="//button[@class='slick-prev slick-arrow']")
	private WebElement sliderPreviousMDM;
	
	@FindBy(xpath="//article[@id='slider-overlay']/button[@class='button-close button-close--light']")
	private WebElement closeFullScreenMedia;

	@FindBy(xpath="//textarea[@id='codeIframe']")
	private WebElement textArea;
	
	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/h2")
	private WebElement shareContainerHeader;
	
	@FindBy(css="body>main>section>div.section>div>div.grid--product.medias-gallery>p")
	private WebElement noMediaToDisplayText;
	
	@FindBy(xpath="//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div[@class='swiper-zoom-container']/img[starts-with(@src,'https:')]")
	private WebElement fullScrnImg;

	@FindBy(xpath="//div[@class='u-txtRight']/a[@class='link-more']")
	private WebElement checkOutAllProductsLink;
	
	@FindBy(css =".truste_box_overlay_inner>iframe")
	List<WebElement> emailIframe;

	@FindBy(css =".projectNav>.wrapper>#pull")
	private WebElement naviagationDropdownMobile;
	
	@FindBy(xpath ="//*[@class='grid-2-3 flex-order-first']/h2/*[@class='link-navMobile icon-content'][contains(text(),'Check out all products')]")
	private WebElement checkOutAllProductsMobile;
	
	@FindBy(xpath="//*[@class='grid-1-3']/h2/*[@class='link-navMobile icon-content'][contains(text(),'Color palette')]")
	private WebElement colorPaletteMobile;
	
	@FindBy(css=".header>.wrapper>.header-btnMenu")
	WebElement headerMenuMobile;
	
	@FindBy(xpath = "//div[@class='tpl-wrapper']/div[@class='medias-submenu']/ul/li/*[@class='is-active media-sort icon-content']")
	private WebElement activeMediaType;

	@FindBy(css = ".medias-container>.medias-gallery-new>.u-txtCenter.u-mtm>.button--alt")
	List<WebElement> moreButton;
	
	@FindBy(css = "#shopping-list>.react-tabs>.tabs>li")
	List<WebElement> roomsWtihProducts;

	@FindBy(css = "#rooms>div.project-rooms>.project-room-card")
	List<WebElement> availableRoomList;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My Collections']/span[contains(text(),'My Collections')]")
	private WebElement myCollections;
	
	public UserHomePage deleteProject() {
		clickDeleteProject().yes();
		UtilHBM.reportOK("Project deleted!!");
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public ConfirmDelete clickDeleteProject(){
		UtilHBM.waitExplicitDisplayed(driver, deleteButton);
		UtilHBM.waitExplicitClickable(driver, deleteButton);
		deleteButton.click();
		return PageFactory.initElements(driver, ConfirmDelete.class);	
	}
	
	public NewProject clickOpenProjectButtonNew() {
		UtilHBM.waitExplicitDisplayed(driver, openProjectButton);
		UtilHBM.waitExplicitClickable(driver, openProjectButton);
		openProjectButton.click();
//		closePopup.click();
		for (String winHandle: driver.getWindowHandles()){			
			driver.switchTo().window(winHandle);
		}		
		UtilHBM.reportOK("Opened Planner for project Creation");
		return PageFactory.initElements(driver, NewProject.class);
	} 
	
	public ThreeDPlanner clickOpenProjectButtonOld() {
		UtilHBM.waitExplicitDisplayed(driver, openProjectButton);
		UtilHBM.waitExplicitClickable(driver, openProjectButton);
		openProjectButton.click();
//		UtilHBM.webElement(driver, ".close-modal.button-close").click();		
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
//		UtilHBM.waitExplicitDisplayed(driver, "//div[@id='appLoader']");
		if(UtilHBM.webElement(driver, "img[src='assets/images/logo_hbm.png']").isDisplayed() &&
				UtilHBM.webElement(driver, "#loading").isDisplayed()){
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		}else{
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner createProjectFP(NewProjectData newProjectData) {
		return clickOpenProjectButtonNew().fillEmpltyProjectDetails(newProjectData);
	}
	
	public ThreeDPlanner openProject() {				
		clickOpenProjectButtonOld();
		if(UtilHBM.webElement(driver, "img[src='assets/images/logo_hbm.png']").isDisplayed() &&
				UtilHBM.webElement(driver, "#loading").isDisplayed()){
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		}else{
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));
				
		return PageFactory.initElements(driver,ThreeDPlanner.class);
	}
	
	public ShareContainer clickShareProjectButton() {
		if(driver.getCurrentUrl().contains("/partner/")){
			UtilHBM.waitExplicitDisplayed(driver, shareMDMProjectButton);
			UtilHBM.waitExplicitClickable(driver, shareMDMProjectButton);
			shareMDMProjectButton.click();
		}else{
			UtilHBM.waitFixTime(500);
			UtilHBM.waitExplicitDisplayed(driver, shareProjectButton);
			UtilHBM.waitExplicitClickable(driver, shareProjectButton);
			shareProjectButton.click();
		}		
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	public ProjectPage shareEmbededProject() {
		UtilHBM.waitExplicitDisplayed(driver, subHeaderProjectName);
		clickShareProjectButton().clickShareEmbed();
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeader);
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(),"Embed this project");
		String textAreaValue = textArea.getAttribute("value");
		String embededProjectLink=textAreaValue.substring(textAreaValue.indexOf("h", 2), (textAreaValue.indexOf("embed", 10) + 5));
		ShareEmbedDialog embedProject=PageFactory.initElements(driver, ShareEmbedDialog.class);
		embedProject.clickCancelButton().closeShareContainer();
		driver.get(embededProjectLink);
		UtilHBM.waitExplicitDisplayed(driver, embededProjectTurnableImg);
		Verification.displayOfWebElement(embededProjectTurnableImg);
		Verification.displayOfWebElement(viewThisProject);
		Verification.VerifyEquals("View this project Text test failed", viewThisProject.getText(), "VIEW THIS PROJECT");
		Verification.VerifyEquals("Sub Header text is not correct in Embed Link", subHeaderTextEmbed.getText(), "Visit the real property with");
		Verification.disabledWebElement(subHeaderLogoEmbed);	
		viewThisProject.click();
		UtilHBM.waitFixTime(1000);
		driver.close();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		String projectPageLink = driver.getCurrentUrl();
		if (embededProjectLink.contains(projectPageLink))
			UtilHBM.reportOK("View This Project Button working");
		else
			UtilHBM.reportKO("View This Project Button not working");
		return PageFactory.initElements(driver, ProjectPage.class);
	}


	public ProjectPage editTags(String tagList1) {
		UtilHBM.reportInfo("Clicking " + editTags.getText() + " button in Tags section.");
		editTags.click();
		UtilHBM.waitFixTime(1000);
		if (editTags.getText().trim().equalsIgnoreCase("ok")) {
			int tagsBeforeDelete = tagsAdded.size();
			UtilHBM.reportInfo("No. of Tags Before Delete : " + tagsBeforeDelete);
			if (tagsAdded.isEmpty()) {
				UtilHBM.reportInfo("No tags available for delete!!");
			} else {
				for (int i = tagsBeforeDelete; i > 0; i--) {
					UtilHBM.waitFixTime(1000);
					UtilHBM.reportInfo("Deleting tag : " + tagsAdded.get(i - 1).getText());
					tagsAddedClose.get(i - 1).click();
				}
			}
			UtilHBM.turnOffImplicitWaits(driver);
			if (tagsAdded.isEmpty()) {
				UtilHBM.reportOK("All Tags deleted successfully");
			} else {
				UtilHBM.reportKO("All Tags not deleted");
			}
			UtilHBM.turnOnImplicitWaits(driver);
			String d1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
			String[] tagList = tagList1.split(",");
			for (String a : tagList) {
				tagsInput.sendKeys(a + "-" + d1);
				editTags.click();
				UtilHBM.waitFixTime(1000);
				editTags.click();
				if (tagsAdded.get(tagsAdded.size() - 1).getText().equals(a + "-" + d1)) {
					UtilHBM.reportOK("Tag \"" + a + "-" + d1 + "\" added successfully");
				} else {
					int temp = 0;
					for (WebElement a1 : tagsAdded) {
						if (a1.getText().equals(a + "-" + d1)) {
							UtilHBM.reportOK("Tag \"" + a + "-" + d1 + "\" is already available in tag list.");
							temp = 1;
							break;
						}
					}
					if (temp == 0) {
						UtilHBM.reportKO("Tag \"" + a + "-" + d1 + "\" not added");
					}
				}

			}
			UtilHBM.reportInfo("Clicking " + editTags.getText() + " button in Tags section.");
			editTags.click();
		} else {
			UtilHBM.reportKO("Tags Section is not editable.");
		}
		return this;
	}
	
	public ProjectPage verifyOverviewTabPage(String projectOwnership, int noOfFloors, int noOfRooms, String area,
			int noOfBedrooms, int noOfBathrooms, int noOfShoppedProducts, int totalMediaCount) {
		UtilHBM.reportInfo("Verifying project link :" + driver.getCurrentUrl());
		if (projectOwnership.equalsIgnoreCase("own")) {
			Verification.displayOfWebElement(subHeaderProjectTime);
			if (projectActions.size() == 5) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed for own project!!!No of project actions displayed : "
						+ projectActions.size());
			}
			List<WebElement> own = new ArrayList<>();
			own.add(openProject);
			own.add(vrButton);
			own.add(duplicateButton);
			own.add(shareProjectButton);
			own.add(deleteButton);
			for (WebElement a : own) {
				Verification.displayOfWebElement(a);
			}
		} else if (projectOwnership.equalsIgnoreCase("others")) {
			if (projectActions.size() == 4) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed for others project!!!No of project actions displayed : "
						+ projectActions.size());
			}
			List<WebElement> others = new ArrayList<>();
			others.add(openProject);
			others.add(vrButton);
			others.add(duplicateButton);
			others.add(shareProjectButton);
			for (WebElement b : others) {
				Verification.displayOfWebElement(b);
			}
		} else {
			UtilHBM.reportKO("Wrong input for projectOwnership!!!");
		}
	
		clickDupicateprojectButton().verifyDuplicateDialogBox().closeDuplicateDialogBox();
		 clickShareProjectButton()
		 .shareProject()
		 .closeShareContainer()
		 ;
		if (projectInfo.size() == 5) {
			UtilHBM.reportOK("No. of project details displayed in details bar is correct!!!");
		} else {
			UtilHBM.reportKO("Incorrect no of project details displayed in details bar!!!No of project details displayed : "
					+ projectInfo.size());
		}
		if (projectOwnership.equalsIgnoreCase("own")) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
			Actions action1 = new Actions(driver);
			action1.moveToElement(userAvatar).build().perform();
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,
					"span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(1)"));
			String userName = UtilHBM
					.webElement(driver,
							"span.header_nav_item.header__nav__account.dropdown.dropdown.is-open>.dropdown_content>div>a:nth-child(1)")
					.getText().trim();
			setUserName(userName.split(" ")[1]);
		} else if (projectOwnership.equalsIgnoreCase("others")) {
			UtilHBM.waitExplicitDisplayed(driver,
					UtilHBM.webElement(driver, ".subHeader-thumb>.subHeader-thumb-txt>.byUser>span"));
			String userName = UtilHBM
					.webElement(driver, ".subHeader-thumb>.subHeader-thumb-txt>.byUser>span").getText()
					.trim();
			setUserName(userName);
		}
		Actions action = new Actions(driver);
		action.moveToElement(subHeaderProjectName).build().perform();
		Verification.displayOfWebElement(projectDetails);
		Verification.displayOfWebElement(noOfFloorsIcon);
		Verification.displayOfWebElement(noOfRoomsIcon);
		Verification.displayOfWebElement(surfaceAreaIcon);
		Verification.displayOfWebElement(noOfBedroomsIcon);
		Verification.displayOfWebElement(noOfBathroomsIcon);
		if (noOfFloors1.getText().contains("floor") && noOfRooms1.getText().contains("room")
				&& (surfaceArea1.getText().contains("m") || surfaceArea1.getText().contains("ft"))
				&& noOfBedrooms1.getText().contains("bedroom") && noOfBathrooms1.getText().contains("bathroom")) {
			UtilHBM.reportOK("Project Details Bar is Displayed");
		} else {
			UtilHBM.reportKO("Wrong detail titles displayed in details bar in project page");
		}
		if (noOfShoppedProducts != 0) {
			int noOfItemsShopped = Integer.parseInt(productsTab.getText()
					.substring(productsTab.getText().indexOf("(") + 1, (productsTab.getText().indexOf(")"))));
			if (noOfItemsShopped == noOfShoppedProducts) {
				UtilHBM.reportOK("noOfShoppedProducts displayed correctly in tab headers!!");
			} else {
				UtilHBM.reportKO(
						"noOfShoppedProducts displayed incorrectly in tab headers!!noOfShoppedProductsAvailable : "
								+ noOfItemsShopped + "noOfShoppedProductsExpected : " + noOfShoppedProducts);
			}
		} else if (!productsTabList.isEmpty()) {
			UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
		}
		if (totalMediaCount != 0) {
			int noOfMedias = Integer.parseInt(imagesTab.getText().substring(imagesTab.getText().indexOf("(") + 1,
					(imagesTab.getText().indexOf(")"))));
			if (noOfMedias == totalMediaCount) {
				UtilHBM.reportOK(" totalMediaCount displayed correctly in tab headers!!");
			} else {
				UtilHBM.reportKO("totalMediaCount displayed incorrectly in tab headers!! totalMediaCountAvailble : "
						+ noOfMedias + ", totalMediaCountExpected : " + totalMediaCount);
			}
		} else if (!imagesTabList.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Total media count expected: 0");
		}


		checkImagesInOverviewTab(totalMediaCount)
		.verifyProjectDetails(noOfFloors, noOfRooms, area, noOfBedrooms, noOfBathrooms)
		.verifyColorPalette(noOfFloors,noOfRooms, noOfBedrooms, noOfBathrooms)
		.verifyAllSurfaces(projectOwnership,noOfFloors, noOfRooms, area, noOfBedrooms, noOfBathrooms)
		.verifyFeaturedProducts(noOfShoppedProducts);
		UtilHBM.turnOffImplicitWaits(driver);
		if (turnTableImg.isEmpty()) {
			UtilHBM.reportKO("TurnTable not Generated");
		} else if (turnTableImg.get(0).getAttribute("src").startsWith("https://byme")
				&& turnTableImg.get(0).getAttribute("src").endsWith(".jpg")) {
			UtilHBM.reportOK("TurnTable Generated");
			if (sliderNextButton.isEmpty()) {
				UtilHBM.reportKO("Slider button not available for images in overview tab for project!!");
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if (descriptionText.isEmpty()) {
			UtilHBM.reportInfo("Description Not available");
		} else {
			Verification.displayOfWebElement(descriptionBuildingText);
			Verification.displayOfWebElement(constructionBuildingText);
			Verification.displayOfWebElement(projectDescription);
		}
		if (tagsText.isEmpty()) {
			UtilHBM.reportInfo("Tags Not available");
		} else {
			for (WebElement a : tagsList) {
				Verification.displayOfWebElement(a);
			}
		}
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
		
	public FullscreenFeaturedImage clickFullscreenFeaturedImages() {
		UtilHBM.waitExplicitDisplayed(driver, fullscreenIcon);
		UtilHBM.waitExplicitClickable(driver, fullscreenIcon);
		fullscreenIcon.click();
		return PageFactory.initElements(driver, FullscreenFeaturedImage.class);
	}
	
	public ProjectPage checkImagesInOverviewTab(int noOfMedias) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		boolean isSliderNextButtonEmpty=sliderNextButton.isEmpty();
		boolean isBulletsNotAvailable=noOfBullets.isEmpty();
		int bulletsAvailable=noOfBullets.size();
		UtilHBM.turnOnImplicitWaits(driver);
		if (noOfMedias != 0) {
			if (!isSliderNextButtonEmpty || !isBulletsNotAvailable) {
				UtilHBM.reportInfo("Checking featured images in overview tab for project");
				sliderNextButton.get(0).click();
				UtilHBM.waitFixTime(1000);
				String previousImgSrc = null;
				UtilHBM.waitExplicitDisplayed(driver, sliderNextButton.get(0));
				UtilHBM.reportInfo(bulletsAvailable + " images displayed in featured images in overview page.");
				for (int i = 0; i < bulletsAvailable - 1; i++) {
					UtilHBM.waitFixTime(1000);
					String currntImgSrc = sliderCurrentImage.getAttribute("src");
					if (currntImgSrc.equals(previousImgSrc)) {
						UtilHBM.reportKO("Sliderimage not changed");
					} else {
						UtilHBM.reportOK("Sliderimage changed");
					}
					previousImgSrc = currntImgSrc;
					sliderNextButton.get(0).click();
				}
			} else {
				UtilHBM.reportKO("Slider Button or image bullets not available");
			}
		} else {
			UtilHBM.reportInfo("Number of medias : " + noOfMedias);
			if (sliderNextButton.isEmpty() && bulletsAvailable == 0) {
				UtilHBM.reportOK("Media Tab & Slider Button in overview tab are not available");
			} else {
				UtilHBM.reportKO("Slider Button or image bullets available and Media tab is not available");
			}
		}
		if(bulletsAvailable!=0) {
		clickFullscreenFeaturedImages().verifyFullscreenFeaturedImage(noOfMedias, bulletsAvailable)
				.clickCloseFullscreenImages();
		}else {
			UtilHBM.reportInfo("Zero bullets available in overview tab. ");
		}
		return this;
	}

	public ProjectPage goToOverviewTab() {
		UtilHBM.waitExplicitClickable(driver, overviewTab);
		overviewTab.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public ProjectPage goToProductsTab() {
		UtilHBM.waitExplicitClickable(driver, productsTab);
		UtilHBM.waitExplicitDisplayed(driver, productsTab);
		productsTab.click();
		UtilHBM.waitExplicitDisplayed(driver, activeProductsTab);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage goToImagesTab() {
		UtilHBM.waitExplicitClickable(driver, imagesTab);
		UtilHBM.waitExplicitDisplayed(driver, imagesTab);
		imagesTab.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage goToRoomsTab() {
		UtilHBM.waitExplicitClickable(driver, roomsTab);
		UtilHBM.waitExplicitDisplayed(driver, roomsTab);
		roomsTab.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage verifyFeaturedProducts(int noOfShoppedProducts) {
		if (noOfShoppedProducts != 0) {
			Verification.VerifyEquals("Wrong Featured product title!!", featuredProductsTitle.get(0).getText(),
					"Featured products");
			int noOfItemsShopped = Integer.parseInt(productsTab.getText()
					.substring(productsTab.getText().indexOf("(") + 1, (productsTab.getText().indexOf(")"))));

			if (noOfItemsShopped < 6) {
				if (noOfItemsShopped == featuredProducts.size()) {
					UtilHBM.reportOK("All products displayed!! Total products : " + noOfItemsShopped);
				} else {
					UtilHBM.reportKO("All products not displayed!!Total products displayed in featured project : "
							+ featuredProducts.size());
				}
			} else {
				Verification.displayOfWebElement(checkOutAllProductsLink);
				if (featuredProducts.size() == 6) {
					UtilHBM.reportOK("All products(6 i.e. max count) displayed!!Total products : " + noOfItemsShopped);
				} else {
					UtilHBM.reportKO(
							"All products(6 i.e. max count) not displayed!!Total products displayed in featured project : "
									+ featuredProducts.size());
				}
			}
			for (WebElement p : featuredProducts) {
				if (p.findElement(By.tagName("img")).isDisplayed()) {
					UtilHBM.reportOK("Product Image Displayed");
				} else {
					UtilHBM.reportOK("Product Image not Displayed");
				}
				if (p.findElement(By.tagName("h3")).isDisplayed()) {
					UtilHBM.reportOK("Product Title Displayed");
				} else {
					UtilHBM.reportOK("Product Title not Displayed");
				}
				if (p.findElement(By.cssSelector("div>div.media-legend>span")).isDisplayed()) {
					UtilHBM.reportOK("Product Description Displayed");
				} else {
					UtilHBM.reportOK("Product Description not Displayed");
				}
			}
		} else if (featuredProductsTitle.isEmpty()) {
			UtilHBM.reportKO("Featured product title displayed!!!Shopped product count : 0");
		}
		return this;
	}
	
	public ProjectPage verifyAllSurfaces(String projectOwnership,int noOfFloors, int noOfRooms, String area, int noOfBedrooms,int noOfBathrooms) {
		int bedroom=0;int bathroom=0;
		Verification.VerifyEquals("All Surfaces Header is not displayed", allSurfacesHeader.getText(), "All surfaces");
		if ((noOfRooms > 4)) {
			allSurfacesViewMore.click();
		}
		List<String> floorsDisplayedinAS = new ArrayList<String>();
		if (allSurfacesAreaDetails.size() == noOfRooms) {
			for (WebElement roomName : allSurfacesRoomName) {
				if (roomName.getText().contains("Bedroom") || roomName.getText().contains("bedroom")) {
					bedroom++;
				}
				if (roomName.getText().contains("Bathroom") || roomName.getText().contains("bathroom")) {
					bathroom++;
				}
				Verification.displayOfWebElement(roomName);
				String s1 = roomName.getText().split(" - ")[0];
				if (floorsDisplayedinAS.isEmpty()) {
					floorsDisplayedinAS.add(s1);
				} else if (!floorsDisplayedinAS.contains(s1)) {
					floorsDisplayedinAS.add(s1);
				}
			}
			Double totalSurfaceArea = 0.00;
			for (WebElement a : allSurfacesAreaDetails) {
				Verification.VerifyEquals("Floor surface text not displayed",
						a.findElement(By.xpath("dl[1]/dt")).getText(), "Floor surface");
				String floorSurfaceArea = a.findElement(By.xpath("dl[1]/dd")).getText();
				if (floorSurfaceArea.contains("m") || floorSurfaceArea.contains("ft")) {
					if (!floorSurfaceArea.split(" ")[0].equals("0")) {
						totalSurfaceArea+=Double.parseDouble(floorSurfaceArea.split(" ")[0]);
						UtilHBM.reportOK("Floorsurface area value displayed successfully!!!");
					}
				} else {
					UtilHBM.reportKO("Surface Area not displayed correctly!! Value displayed : " + floorSurfaceArea);
				}
				if (projectOwnership.equalsIgnoreCase("own")) {
					Verification.VerifyEquals("Wall surface text not displayed",
							a.findElement(By.xpath("dl[2]/dt")).getText(), "Wall surface");
					String wallSurfaceArea = a.findElement(By.xpath("dl[2]/dd")).getText();
					if (wallSurfaceArea.contains("m") || wallSurfaceArea.contains("ft")) {
						if (!wallSurfaceArea.split(" ")[0].equals("0")) {
							UtilHBM.reportOK("Wallsurface area value displayed successfully!!!");
						}
					} else {
						UtilHBM.reportKO("Wall Area not displayed correctly!! Value displayed : " + wallSurfaceArea);
					}
				}
			}

			if(noOfBedrooms==bedroom) {
				UtilHBM.reportOK("No of bedrooms available in All surfaces is equal to no of bedrooms availble!!");
			} else {
				UtilHBM.reportKO("No of bedrooms available in All surfaces is not equal to no of bedrooms availble!!No of bedrooms available in color palette :"+bedroom+", no of bedrooms availble :"+noOfBedrooms);
			}
			if(noOfBathrooms==bathroom) {
				UtilHBM.reportOK("No of bathrooms available in All surfaces is equal to no of bathrooms availble!!");
			} else {
				UtilHBM.reportKO("No of bathrooms available in All surfaces is not equal to no of bathrooms availble!!No of bathrooms available in color palette :"+bathroom+", no of bathrooms availble :"+noOfBathrooms);
			}
			
		
			if ((int)Math.round(totalSurfaceArea) == Double.parseDouble(area.split(" ")[0]+".00")) {
				UtilHBM.reportOK("Addition of surface area of all rooms is equal to total surface area!");
			} else {
				UtilHBM.reportKO(
						"Addition of surface area of all rooms is not equal to total surface area!!!Addition of surface area : "
								+ (int)Math.round(totalSurfaceArea) + ",total surface area : "
								+ Double.parseDouble(area.split(" ")[0] + ".00"));
			}
			if (allSurfacesAreaDetails.size() == allSurfacesRoomName.size()) {
				UtilHBM.reportOK("allSurfacesArea Details is equal to allSurfacesRoomName");
			} else {
				UtilHBM.reportKO(
						"allSurfacesArea Details is not equal to allSurfacesRoomName!!!No. of allSurfacesAreaDetails : "
								+ allSurfacesAreaDetails.size() + ",No. of allSurfacesRoomName : "
								+ allSurfacesRoomName.size());
			}

			if (floorsDisplayedinAS.size() == noOfFloors) {
				UtilHBM.reportOK("No of floors displayed in All surfaces is equal to no of floors available");
			} else {
				UtilHBM.reportKO(
						"No of floors displayed in All surfaces is not equal to no of floors available!!!No of floors displayed in AS : "
								+ floorsDisplayedinAS.size() + " , No of floors available in project : "
								+ noOfFloors);
			}
		} else {
			UtilHBM.reportKO("Surface and wall areas of all rooms not displayed!!!!No. of allSurfacesAreaDetails :"
					+ allSurfacesAreaDetails.size() + ",No of rooms available : " + noOfRooms);
		}
		return this;
	}

	public ProjectPage verifyColorPalette(int noOfFloors, int noOfRooms, int noOfBedrooms, int noOfBathrooms) {
		int bedroom = 0;
		int bathroom = 0;
		Verification.VerifyEquals("ColorPaletteHeader is not available", colorPaletteHeader.getText(), "Color palette");
		if ((noOfRooms > 4)) {
			colorPaletteViewMore.click();
		}
		List<String> floorsDisplayedinCP = new ArrayList<String>();
		if (colorPaletteElements.size() == noOfRooms) {
			for (WebElement e : colorPaletteElements) {
				if (!(e.getText().startsWith("View"))) {
					WebElement roomName = e.findElement(By.tagName("h3"));
					if (roomName.getText().contains("Bedroom") || roomName.getText().contains("bedroom")) {
						bedroom++;
					}
					if (roomName.getText().contains("Bathroom") || roomName.getText().contains("bathroom")) {
						bathroom++;
					}
					Verification.displayOfWebElement(roomName);
					String f1 = roomName.getText().split(" - ")[0];

					if (floorsDisplayedinCP.isEmpty()) {
						floorsDisplayedinCP.add(f1);
					} else if (!floorsDisplayedinCP.contains(f1)) {
						floorsDisplayedinCP.add(f1);
					}
					List<WebElement> roomContents = e.findElements(By.cssSelector("li>a>img[src*='https:']"));
					if (roomContents.size() > 1) {
						int temp = 0;
						for (WebElement color : roomContents) {
							if (!color.isDisplayed()) {
								temp = 1;
							}
						}
						if (temp == 0) {
							UtilHBM.reportOK("All room colors Displayed");
						} else {
							UtilHBM.reportKO("All room colors not Displayed");
						}
					} else {
						UtilHBM.reportKO("Default Room ColorPalette Contents displayed less than Default(i.e. 2)");
					}
				}
			}
			if (noOfBedrooms == bedroom) {
				UtilHBM.reportOK("No of bedrooms available in color palette is equal to no of bedrooms availble!!");
			} else {
				UtilHBM.reportKO(
						"No of bedrooms available in color palette is not equal to no of bedrooms availble!!No of bedrooms available in color palette :"
								+ bedroom + ", no of bedrooms expected :" + noOfBedrooms);
			}
			if (noOfBathrooms == bathroom) {
				UtilHBM.reportOK("No of bathrooms available in color palette is equal to no of bathrooms availble!!");
			} else {
				UtilHBM.reportKO(
						"No of bathrooms available in color palette is not equal to no of bathrooms availble!!No of bathrooms available in color palette :"
								+ bathroom + ", no of bathrooms expected :" + noOfBathrooms);
			}
			if (floorsDisplayedinCP.size() == noOfFloors) {
				UtilHBM.reportOK("No of floors displayed in Color palette is equal to no of floors available");
			} else {
				UtilHBM.reportKO(
						"No of floors displayed in Color palette is not equal to no of floors available!!!No of floors displayed in CP : "
								+ floorsDisplayedinCP.size() + " , No of floors expected in project : " + noOfFloors);
			}
		} else {
			UtilHBM.reportKO("ColorPaletteElements of all rooms not displayed!! No. of ColorPaletteElements :"
					+ colorPaletteElements.size() + ",No of rooms expected : " + noOfRooms);
		}
		return this;
	}
	
	public ProjectPage upgradeRenderingimage() {
		int noOfMediasBeforeUpgrade = Integer.parseInt(mediaCount.getText());
		goToMediaType("Realistic images", false).clickMoreButton().clickUpgradeRendering(0).upgradeRenderings();
		UtilHBM.waitFixTime(1000);
		driver.navigate().refresh();
		int noOfMediasAfterUpgrade = Integer.parseInt(mediaCount.getText());
		if (noOfMediasBeforeUpgrade + 1 == noOfMediasAfterUpgrade) {
			UtilHBM.reportOK("Media upgrade request successful!!Media count(Navigation bar) before upgrade : "
					+ noOfMediasBeforeUpgrade + " , Media count(Navigation bar) after upgrade : "
					+ noOfMediasAfterUpgrade);
		} else {
			UtilHBM.reportKO("Media upgrade request failed!!Media count(Navigation bar) before upgrade : "
					+ noOfMediasBeforeUpgrade + " , Media count(Navigation bar) after upgrade : "
					+ noOfMediasAfterUpgrade);
		}
		goToMediaType("Realistic images", false);
		if (mediaList.get(0).findElement(By.cssSelector(".media-thumb-link>img"))
				.getAttribute("src").contains("placeholder")) {
			UtilHBM.reportOK("Upgrade image request successful");
		} else {
			UtilHBM.reportKO("Upgrade image request failed!!");
		}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage clickMoreButton() {
		for (int i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isMoreButtonAvailable = !moreButton.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (!isMoreButtonAvailable) {
				break;
			}
			moreButton.get(0).click();
			UtilHBM.waitFixTime(1000);
		}
		return this;
	}
	
	public UpgradeRenderingsDialog clickUpgradeRendering(int index) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> upgradeImgBtnList = driver.findElements(By.cssSelector(
				"section.grid>div>.media>.media-thumb>.media-thumb-link>span[data-modal-href$='/upgrade']"));
		UtilHBM.turnOnImplicitWaits(driver);
		WebElement upgradeBtnToBeClicked = upgradeImgBtnList.get(index);
		Actions actions = new Actions(driver);
		actions.moveToElement(upgradeBtnToBeClicked).build().perform();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, upgradeBtnToBeClicked);
		upgradeImgBtnList.get(index).click();
		return PageFactory.initElements(driver, UpgradeRenderingsDialog.class);
	}
	
 	public DuplicateConfirmation clickDupicateprojectButton() {
 		UtilHBM.waitExplicitDisplayed(driver, duplicateButton);
		UtilHBM.waitExplicitClickable(driver, duplicateButton);
		duplicateButton.click();
		return PageFactory.initElements(driver, DuplicateConfirmation.class);
	}
	
	public ProjectPage duplicateOwnProject(String expectedProjectTitle) {
		UtilHBM.waitExplicitDisplayed(driver, subHeaderProjectName);
		UtilHBM.waitExplicitClickable(driver, duplicateButton);
		clickDupicateprojectButton().verifyDuplicateDialogBox().clickDuplicateOK().verifyDuplicated(expectedProjectTitle);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage duplicateGalleryProject(String expectedProjectTitle) {
		clickDupicateprojectButton().verifyDuplicateDialogBox().clickDuplicateOK().verifyDuplicated(expectedProjectTitle);
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public ProjectPage verifyDuplicated(String expectedProjectTitle){
		UtilHBM.waitExplicitDisplayed(driver, subHeaderProjectName);
		Verification.VerifyEquals("Duplicated Project title", subHeaderProjectName.getText(), expectedProjectTitle);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage verifyProductsTabMDM(int noOfShoppedProducts) {
		if (noOfShoppedProducts == 0) {
			if (!productsTabList.isEmpty()) {
				UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
			}
		} else {
			goToProductsTab().checkProductListMDM(noOfShoppedProducts).verifyProductSheet("Yes").goToOverviewTab();
		}
		return this;
	}	
	
	public ProjectPage verifyProductsTab(int noOfShoppedProducts, String productsInRoom) {
		if (noOfShoppedProducts == 0) {
			if (!productsTabList.isEmpty()) {
				UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
			}
		} else {
				goToProductsTab().checkProductList(noOfShoppedProducts, productsInRoom).verifyProductSheet("No").goToOverviewTab();
			}
		return this;
	}
	
	public ProjectPage verifyRoomsTab(String roomList) {
		goToRoomsTab().checkRoomList(roomList);
		return this;
	}

	public ProjectPage checkRoomList(String roomList1) {
		UtilHBM.waitExplicitDisplayed(driver, availableRoomList.get(0));
		String[] rooms = roomList1.split(",");
		List<String> roomList = Arrays.asList(rooms);
		int roomsDisplayedCount = availableRoomList.size();
		int roomsExpectedCount = roomList.size();
		if (roomsDisplayedCount == roomsExpectedCount) {
			UtilHBM.reportOK("Correct number of rooms displayed in rooms tab!!");
		} else {
			UtilHBM.reportKO("Incorrect number of rooms displayed in rooms tab!!Expected : " + roomsExpectedCount
					+ "Available :" + roomsDisplayedCount);
		}
		for (int i = 0; i < roomsExpectedCount; i++) {
			String expectedRoomName = roomList.get(i).split("-")[0];
			String expectedRoomArea = roomList.get(i).split("-")[1];
			WebElement currentRoom = availableRoomList.get(i);
			Verification.VerifyEquals("Wrong room name displayed for room : " + expectedRoomName,
					currentRoom.findElement(By.cssSelector("h3")).getText(), expectedRoomName);
			Verification.VerifyEquals("Wrong room area displayed for room : " + expectedRoomName,
					currentRoom.findElement(By.cssSelector("span")).getText(), expectedRoomArea);
			String currentRoomImgSrc = currentRoom.findElement(By.cssSelector("img")).getAttribute("src");
			String expectedRoomName1;
			if (expectedRoomName.contains(" ")) {
				expectedRoomName1 = expectedRoomName.replace(" ", "-");
			} else {
				expectedRoomName1 = expectedRoomName;
			}
			if (expectedRoomName.startsWith("room")) {
				if (currentRoomImgSrc.contains("roomTypes/none.")) {
					UtilHBM.reportOK("Room preview displayed!!");
				} else {
					UtilHBM.reportKO("Room preview not displayed correctly for room : " + expectedRoomName);
				}
			} else {
				if (expectedRoomName1.equals("Kid’s-room")) {
					if (currentRoomImgSrc.contains("nursery")) {
						UtilHBM.reportOK("Room preview displayed!!");
					} else {
						UtilHBM.reportKO("Room preview not displayed correctly for room : " + expectedRoomName);
					}
				} else {
					if (currentRoomImgSrc.contains(expectedRoomName1.toLowerCase())) {
						UtilHBM.reportOK("Room preview displayed!!");
					} else {
						UtilHBM.reportKO("Room preview not displayed correctly for room : " + expectedRoomName);
					}
				}
			}
		}
			return this;
	}

	public ProjectPage verifyProductSheet(String isMDM) {
		if (isMDM.equalsIgnoreCase("Yes")) {
			String brandTitle = allBrandNamesMDM.get(0).getText().trim();
			Verification.displayOfWebElement(allProductNamesMDM.get(0));
			String productName = allProductNamesMDM.get(0).getText().trim();
			if (allProductNamesMDM.get(0).getText().trim().contains("...")) {
				productName = productName.replace("...", "");
			}
			allProductsImagesMDM.get(0).click();
			ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
			productInfo.checkProductSheetMDM(brandTitle, productName);
			return this;
		} else {
			String brandTitle = allBrandNames.get(0).getText().trim();
			Verification.displayOfWebElement(allProductNames.get(0));
			String productName = allProductNames.get(0).getText().trim();
			if (allProductNames.get(0).getText().trim().contains("...")) {
				productName = productName.replace("...", "");
			}
			// availableProductList.get(0).click();
			allProductsImages.get(0).click();
			ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
			productInfo.checkProductSheet(brandTitle, productName,"No");
			return this;
		}
	}

	
	public FavoritesListPage addItemInCollection(boolean isNewCollection, boolean isItemAlreadyAvailableInCollection,
			String collectionName, int noOfImages, int noOfProducts, String itemType, String itemAttribute) {
		if (itemType.equals("Product")) {
			String prdName = itemAttribute.split(";")[0];
			openPrdSheet(prdName);
			ProductInfo productInfo = PageFactory.initElements(driver, ProductInfo.class);
			String prdImgSrc = productInfo.getPrdImgSrc();
			String brndName = itemAttribute.split(";")[1];
			productInfo.clickProductBookmark().addToCollection(isNewCollection, collectionName, itemType);
			ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
			projectPage.verifyAddToFavSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				projectPage.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, prdName + ";" + brndName + ";" + prdImgSrc) 
					.openProductsTab(noOfProducts)
					.verifyCollectionItem(itemType,itemAttribute + ";" + prdImgSrc);
			}
		} else if (itemType.equals("Image")) {
			String imgAttribute1 = itemAttribute.substring(itemAttribute.lastIndexOf("/") + 1, itemAttribute.length());
			openImageShareContainer(itemAttribute).openImagePageByCopyLink().clickImageBookmark()
					.addToCollection(isNewCollection, collectionName, itemType);
			FeaturedMediaPage featuredMediaPage1 = PageFactory.initElements(driver, FeaturedMediaPage.class);
			featuredMediaPage1.verifyAddToCollectionSuccess(collectionName, isItemAlreadyAvailableInCollection);
			if (!isItemAlreadyAvailableInCollection) {
				featuredMediaPage1.goToMyCollections()
					.verifyFirstCollectionName(collectionName)
					.openCollection(0, collectionName)
					.verifyCollectionItemInAllItemsTab(noOfImages, noOfProducts, itemType, imgAttribute1)
					.openImagesTab(noOfImages)
					.verifyCollectionItem(itemType, imgAttribute1);
			}
		}
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}
	
	public String getImgSrc(int index) {
		UtilHBM.waitExplicitDisplayed(driver, mediaList.get(index));
		WebElement imgPath = mediaList.get(index).findElement(By.cssSelector("span>img"));
		String imgSrc = imgPath.getAttribute("src");
		return imgSrc;
	} 
	
	public MyFavorites goToMyCollections() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}

	public ProductInfo openPrdSheet(String prdName) {
		Verification.displayOfWebElement(allProductNames.get(0));
		boolean isPrdAvailable = false;
		for (WebElement a : allProductNames) {
			if (a.getText().equals(prdName)) {
				isPrdAvailable = true;
				a.click();
				UtilHBM.reportInfo("Opening product sheet of product name : " + prdName);
				break;
			}
		}
		if (!isPrdAvailable) {
			UtilHBM.reportKO("Product not found!! prdName : " + prdName);
		}
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	public ProjectPage verifyAddToFavSuccess(String favListName, boolean isItemAlreadyAvailableInFavList) {
		if (isItemAlreadyAvailableInFavList) {
			UtilHBM.waitExplicitDisplayed(driver, alreadyAvailableInCollection);
			Verification.VerifyEquals(
					"Your product has already been added to this favorites list message not displayed",
					alreadyAvailableInCollection.getText(), "Your product has already been added to this collection");
			UtilHBM.waitExplicitDisplayed(driver, closeAlreadyAvailableInCollection);
			UtilHBM.waitExplicitClickable(driver, closeAlreadyAvailableInCollection);
			closeAlreadyAvailableInCollection.click();
			UtilHBM.waitFixTime(500);
			AddToFavorites addToFavorites = PageFactory.initElements(driver, AddToFavorites.class);
			addToFavorites.closeAddToCollectionInInspiration();
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		} else {
			UtilHBM.waitExplicitDisplayed(driver, addToCollectionSuccess);
			Verification.VerifyEquals("Added to favorite list succcess message not displayed",
					addToCollectionSuccess.getText(), "Added to " + favListName);
			UtilHBM.waitExplicitDisplayed(driver, closeAddToCollectionSuccess);
			UtilHBM.waitExplicitClickable(driver, closeAddToCollectionSuccess);
			closeAddToCollectionSuccess.click();
			UtilHBM.waitFixTime(500);
		}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		return this;
	}

	public ProjectPage checkProductList(int noOfItemsShopped,String productsInRoom) {
		UtilHBM.waitExplicitDisplayed(driver, allProductsImages.get(noOfItemsShopped - 1));
		String[] ProductCountPerRoom = productsInRoom.split(",");
		List<String> allProducts = new ArrayList<String>();
		List<String> productsInDiffRooms = new ArrayList<String>();
		for (int i = 0; i < noOfItemsShopped; i++) {
			allProducts.add(allBrandNames.get(i).getText() + "-" + allProductNames.get(i).getText());
		}
		for (int i = 1; i <= ProductCountPerRoom.length; i++) {
			roomsWtihProducts.get(i).click();
			UtilHBM.waitFixTime(1000);
			String currentRoomCategory = roomsWtihProducts.get(i).getText();
			UtilHBM.reportInfo("Verifying products in room category : " + currentRoomCategory);
			String noOfProductsAvailableInTabs1 = roomsWtihProducts.get(i).findElement(By.cssSelector("span"))
					.getText();
			int noOfProductsAvailableInTabs = Integer.parseInt(noOfProductsAvailableInTabs1);
			int noOfProductsExpected = Integer.parseInt(ProductCountPerRoom[i - 1]);
			if (noOfProductsAvailableInTabs == noOfProductsExpected) {
				UtilHBM.reportOK("Correct no of products displayed in tabs for room category :" + currentRoomCategory);
			} else {
				UtilHBM.reportOK("Incorrect no of products displayed in tabs for room category : " + currentRoomCategory
						+ " , Available no of products : " + noOfProductsAvailableInTabs
						+ " , Expected no of products :" + noOfProductsExpected);
			}
			List<String> currentRoomProducts = new ArrayList<String>();
			for (int j = 0; j < allProductsImages.size(); j++) {
				currentRoomProducts.add(allBrandNames.get(j).getText() + "-" + allProductNames.get(j).getText());
			}
			int noOfProductsAvailable = currentRoomProducts.size();
			if (noOfProductsAvailable == noOfProductsExpected) {
				int noOfProductImages = allProductsImages.size();
				if (noOfProductImages == noOfProductsExpected) {
					UtilHBM.reportOK(
							"No of Images in products tab room " + currentRoomCategory + " are same as No of Products");
				} else {
					UtilHBM.reportKO("No of Images in products tab for room " + currentRoomCategory
							+ " are not same as No of Products.No of Products Images : " + noOfProductImages
							+ " No Of product images expected : " + noOfProductsExpected);
				}
				if (allBrandNames.size() == noOfProductsExpected) {
					UtilHBM.reportOK("No of brand titles in products tab room " + currentRoomCategory
							+ " are same as No of Products");
				} else {
					UtilHBM.reportKO("No of brand titles in products tab for room " + currentRoomCategory
							+ " are not same as No of Products.No of brand titles : " + allBrandNames.size()
							+ " No Of brand names expected : " + noOfProductsExpected);
				}
				if (allProductNames.size() == noOfProductsExpected) {
					UtilHBM.reportOK("No of Product names in products tab room " + currentRoomCategory
							+ " are same as No of Products");
				} else {
					UtilHBM.reportKO(
							"No of Product names in products tab are not same as No of Products.No of Products Names : "
									+ allProductNames.size() + " No Of product names expected : "
									+ noOfProductsExpected);
				}
			} else {
				UtilHBM.reportKO("Incorrect no of product previews displayed in products tab for room category : "
						+ currentRoomCategory + "!! No of products available : " + noOfProductsAvailable
						+ " No of products expected : " + noOfProductsExpected);
			}
			List<String> currentRoomProductsCopy = new ArrayList<>(currentRoomProducts);
			currentRoomProductsCopy.removeAll(productsInDiffRooms);
			productsInDiffRooms.addAll(currentRoomProductsCopy);
		}
		allProducts.removeAll(productsInDiffRooms); 
		if(allProducts.isEmpty()) {
			UtilHBM.reportOK("All products displayed correctly in all rooms in product tab");
		}else {
			UtilHBM.reportKO("Products displayed incorrectly in product tab!!Following products not displayed in any rooms but displayed in All products category :");
			for (String a:allProducts) {
				UtilHBM.reportKO(a);
			}
		}
		roomsWtihProducts.get(0).click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	
	
	public ProjectPage checkProductListMDM(int noOfItemsShopped) {
		UtilHBM.waitExplicitDisplayed(driver, allProductsImagesMDM.get(0));
		int noOfProductImages = allProductsImagesMDM.size();
		if (noOfProductImages == noOfItemsShopped) {
			UtilHBM.reportOK("No of Images in products tab are same as No of Products");
		} else {
			UtilHBM.reportKO("No of Images in products tab are not same as No of Products.All Products Images : "
					+ noOfProductImages + " No Of Items Shopped : " + noOfItemsShopped);
		}
		if (allBrandNamesMDM.size() == noOfItemsShopped) {
			UtilHBM.reportOK("No of product titles in products tab are same as No of Products");
		} else {
			UtilHBM.reportKO(
					"No of product titles in products tab are not same as No of Products.All Products Titles : "
							+ allBrandNames.size() + " No Of Items Shopped : " + noOfItemsShopped);
		}
		if (allProductNamesMDM.size() == noOfItemsShopped) {
			UtilHBM.reportOK("No of Product Descriptions in products tab are same as No of Products");
		} else {
			UtilHBM.reportKO(
					"No of Product Descriptions in products tab are not same as No of Products.All Products Description : "
							+ allProductNamesMDM.size() + " No Of Items Shopped : " + noOfItemsShopped);
		}
		return this;
	}
	
	public UserHomePage clickHbmLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage clickHbmLogoMDM() {
		UtilHBM.waitExplicitClickable(driver, homebymeLinkMDM);
		homebymeLinkMDM.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
//	public ProjectPage sharemedia(String filterMediaText, String isMdmOrNot, int mediaIndex) {
//		goToImagesTab();
//		verifyMediaCount(isMdmOrNot);
//		goToMediaType(filterMediaText, isMdmOrNot);
//		UtilHBM.reportInfo("Verifying share operation in media tab for first media in " + filterMediaText);
//		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
//		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
//				"ul[@class='media-actions']/li/span/i[@class='icon icon-share u-fs16']/parent::span[@title='Share']/.."));
//		UtilHBM.waitExplicitClickable(driver, shareButton1);
//		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
//		Verification.displayOfWebElement(shareButton1);
//		clickShareMediaButton(mediaIndex).shareMedia().closeShareContainer();
//		return PageFactory.initElements(driver, ProjectPage.class);
//	}

	public ProjectPage sharemedia(String filterMediaText, boolean isMdmOrNot, int mediaIndex) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		goToImagesTab();
		verifyMediaCount(isMdmOrNot);
		goToMediaType(filterMediaText,isMdmOrNot);
		UtilHBM.reportInfo("Verifying share operation in media tab for first media in " + filterMediaText);
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
				"ul[@class='media-actions']/li/*[@class='item-link button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		Verification.displayOfWebElement(shareButton1);
		clickShareMediaButton(mediaIndex).shareMedia().closeShareContainer();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
//	public ProjectPage sharemediaFullscreen(String filterMediaText, String isMdmOrNot, int mediaIndex) {
//		goToImagesTab().verifyMediaCount(isMdmOrNot).goToMediaType(filterMediaText, isMdmOrNot);
//		openMediaInFullscreen(mediaIndex).sharemediaFullscreen(filterMediaText);
//		return PageFactory.initElements(driver, ProjectPage.class);
//	}
	
	public ProjectPage sharemediaFullscreen(String filterMediaText, boolean isMdmOrNot, int mediaIndex) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		goToImagesTab();
		verifyMediaCount(isMdmOrNot);
//		filterMedia(filterMediaText, isMdmOrNot);
		goToMediaType(filterMediaText,isMdmOrNot);
		openMediaInFullscreen(mediaIndex).sharemediaFullscreen(filterMediaText);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
		
	public ShareContainer clickShareMediaButton(int mediaIndex) {
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
				"ul[@class='media-actions']/li/*[@class='item-link button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		shareButton1.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	public ProjectPage goToMediaType(String mediaType, boolean isMdmOrNot) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(500);
		if (activeMediaType.getText().contains(mediaType)) {
			UtilHBM.reportInfo(mediaType + " category is already selected!!");
		} else {
			UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath(
					"//div[@class='tpl-wrapper']/div[@class='medias-submenu']/ul/li/*[contains(@class,'media-sort icon-content')][normalize-space(text())='"
							+ mediaType + "']")));
			WebElement expectedMedia = driver.findElement(By.xpath(
					"//div[@class='tpl-wrapper']/div[@class='medias-submenu']/ul/li/*[contains(@class,'media-sort icon-content')][normalize-space(text())='"
							+ mediaType + "']"));
			expectedMedia.click();
			UtilHBM.waitFixTime(2000);
			Verification.elementContainsString(activeMediaType, mediaType, "Active Media Type");
		}
		return this;
	}

	ProjectPage verifyMediaCount(boolean isMdmOrNot) {
		UtilHBM.waitExplicitDisplayed(driver, mediaCount);
		int noOfMedias = Integer.parseInt(mediaCount.getText());
		if (getMediaCount(isMdmOrNot) == noOfMedias) {
			UtilHBM.reportOK("No of Images in Media tab are same as No of Media Generated.");
		} else {
			UtilHBM.reportKO(
					"No of Images in Media tab are not same as No of Media Generated. Media count is in tab text is: "
							+ mediaCount.getText() + "count of media is: " + getMediaCount(isMdmOrNot));
		}
		return this;
	}

	int getMediaCount(boolean isMdmOrNot) {
		clickMoreButton();
//		Actions actions =PageFactory.initElements(driver, Actions.class);
//		WebElement footer=driver.findElement(By.tagName("footer"));
//		actions.moveToElement(footer).build().perform();
		int mediaCount = 0;
		if (!isMdmOrNot) {
			mediaCount = driver.findElements(
							By.cssSelector("section.grid>div.grid-2-4.u-mbs>div>div.media-thumb>.media-thumb-link>img"))
					.size();
		} else if (isMdmOrNot) {
			mediaCount = driver.findElements(By.cssSelector(
					"section#partner-page>div.section>div.wrapper>div.grid--product.medias-gallery>div>div>.media-thumb>.media-thumb-link.trigger-overlay-medias>.b-lazy"))
					.size();
		}
		return mediaCount;
	}

//	public ProjectPage deleteMedia(String filterMediaText,int mediaIndex, String isMdmOrNot, String deleteActionYesOrNo) {
//		goToImagesTab();
//		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
//		verifyMediaCount(isMdmOrNot);
//		goToMediaType(filterMediaText,isMdmOrNot);
//		int beforeDelete = getMediaCount(isMdmOrNot);
//		if (beforeDelete < mediaIndex) {
//			UtilHBM.reportKO("Media of Index no." + mediaIndex
//					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
//					+ " are " + beforeDelete);
//		}
//		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
//		WebElement deleteButton1 = mediaList.get(mediaIndex - 1).findElement(
//				By.xpath("ul[@class='media-actions']/li/span/span[@class='icon icon-trash u-fs16']/../.."));
//		UtilHBM.waitExplicitDisplayed(driver, deleteButton1);
//		UtilHBM.waitExplicitClickable(driver, deleteButton1);
//		Verification.displayOfWebElement(deleteButton1);
//		deleteButton1.click();
//		UtilHBM.waitExplicitClickable(driver, deleteMediaNo);
//		Verification.displayOfWebElement(deleteMediaNo);
//		Verification.displayOfWebElement(deleteMediaYes);
//		Verification.VerifyEquals("Wrong delete dialog box text", deleteDialogBoxText.getText(),
//				"Are you sure you want to delete this media?");
//		UtilHBM.reportInfo("Delete media decision :" + deleteActionYesOrNo);
//		if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
//			deleteMediaYes.click();
//			goToMediaType(filterMediaText, isMdmOrNot);
//			if (beforeDelete == 1) {
//				UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//				Verification.VerifyEquals("Wrong noMediaToDisplayText", noMediaToDisplayText.getText(),
//						"No media to display !");
//			}
//			int noOfMediasAfterDeletion = Integer.parseInt(mediaCount.getText());
//			if (noOfMediasBeforeDeletion == noOfMediasAfterDeletion + 1) {
//				UtilHBM.reportOK("Media deleted successfully!!Media count(Navigation bar) before deletion : "
//						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after deletion : "
//						+ noOfMediasAfterDeletion);
//			} else {
//				UtilHBM.reportKO(
//						"Media not deleted!!Media count(Navigation bar) before deletion : " + noOfMediasBeforeDeletion
//								+ " , Media count(Navigation bar) after deletion : " + noOfMediasAfterDeletion);
//			}
//			int afterDelete = getMediaCount(isMdmOrNot);
//			if (beforeDelete == afterDelete + 1) {
//				UtilHBM.reportOK("Media deleted successfully!!Media count before deletion : " + beforeDelete
//						+ " , Media count after deletion : " + afterDelete);
//			} else {
//				UtilHBM.reportKO("Media not deleted!!Media count before deletion : " + beforeDelete
//						+ " , Media count after deletion : " + afterDelete);
//			}
//		} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
//			deleteMediaNo.click();
//			goToMediaType(filterMediaText, isMdmOrNot);
//			int noOfMediasAfter = Integer.parseInt(mediaCount.getText());
//			if (noOfMediasBeforeDeletion == noOfMediasAfter) {
//				UtilHBM.reportOK("Media count(Navigation bar) before : " + noOfMediasBeforeDeletion
//						+ " , Media count(Navigation bar) after : " + noOfMediasAfter);
//			} else {
//				UtilHBM.reportKO("Different Media counts than earlier!!Media count(Navigation bar) before : "
//						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after : " + noOfMediasAfter);
//			}
//			int afterDelete = getMediaCount(isMdmOrNot);
//			if (beforeDelete == afterDelete) {
//				UtilHBM.reportOK("Media count before : " + beforeDelete + " , Media count after : " + afterDelete);
//			} else {
//				UtilHBM.reportKO("Different Media counts than earlier!!Media count before : " + beforeDelete
//						+ " , Media count after : " + afterDelete);
//			}
//		}
//		goToMediaType("All Medias",isMdmOrNot).verifyMediaCount(isMdmOrNot);
//		return this;
//	}
	
	public ProjectPage deleteMedia(String filterMediaText,int mediaIndex, boolean isMdmOrNot, String deleteActionYesOrNo) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		goToImagesTab();
		verifyMediaCount(isMdmOrNot);
		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
		goToMediaType(filterMediaText,isMdmOrNot);
		int beforeDelete = getMediaCount(isMdmOrNot);
		if (beforeDelete < mediaIndex) {
			UtilHBM.reportKO("Media of Index no." + mediaIndex
					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
					+ " are " + beforeDelete);
		}
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement deleteButton1 = mediaList.get(mediaIndex - 1).findElement(
				By.xpath("ul[@class='media-actions']/li/span/i[@class='icon icon-trash u-fs16']/../.."));
		UtilHBM.waitExplicitDisplayed(driver, deleteButton1);
		UtilHBM.waitExplicitClickable(driver, deleteButton1);
		Verification.displayOfWebElement(deleteButton1);
		deleteButton1.click();
		UtilHBM.waitExplicitClickable(driver, deleteMediaNo);
		Verification.displayOfWebElement(deleteMediaNo);
		Verification.displayOfWebElement(deleteMediaYes);
		Verification.VerifyEquals("Wrong delete dialog box text", deleteDialogBoxText.getText(),
				"Are you sure you want to delete this media?");
		UtilHBM.reportInfo("Delete media decision :" + deleteActionYesOrNo);
		if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
			deleteMediaYes.click();
			driver.navigate().refresh();
			goToMediaType(filterMediaText, isMdmOrNot);
			if (beforeDelete == 1) {
				UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
				Verification.VerifyEquals("Wrong noMediaToDisplayText", noMediaToDisplayText.getText(),
						"No media to display !");
			}
			UtilHBM.waitExplicitDisplayed(driver, mediaCount);
			int noOfMediasAfterDeletion = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfterDeletion + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count(Navigation bar) before deletion : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after deletion : "
						+ noOfMediasAfterDeletion);
			} else {
				UtilHBM.reportKO(
						"Media not deleted!!Media count(Navigation bar) before deletion : " + noOfMediasBeforeDeletion
								+ " , Media count(Navigation bar) after deletion : " + noOfMediasAfterDeletion);
			}
			int afterDelete = getMediaCount(isMdmOrNot);
			if (beforeDelete == afterDelete + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count before deletion : " + beforeDelete
						+ " , Media count after deletion : " + afterDelete);
			} else {
				UtilHBM.reportKO("Media not deleted!!Media count before deletion : " + beforeDelete
						+ " , Media count after deletion : " + afterDelete);
			}
		} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
			deleteMediaNo.click();
			goToMediaType(filterMediaText, isMdmOrNot);
			UtilHBM.waitExplicitDisplayed(driver, mediaCount);
			int noOfMediasAfter = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfter) {
				UtilHBM.reportOK("Media count(Navigation bar) before : " + noOfMediasBeforeDeletion
						+ " , Media count(Navigation bar) after : " + noOfMediasAfter);
			} else {
				UtilHBM.reportKO("Different Media counts than earlier!!Media count(Navigation bar) before : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after : " + noOfMediasAfter);
			}
			int afterDelete = getMediaCount(isMdmOrNot);
			if (beforeDelete == afterDelete) {
				UtilHBM.reportOK("Media count before : " + beforeDelete + " , Media count after : " + afterDelete);
			} else {
				UtilHBM.reportKO("Different Media counts than earlier!!Media count before : " + beforeDelete
						+ " , Media count after : " + afterDelete);
			}
		}

		goToMediaType("All Medias",isMdmOrNot).verifyMediaCount(isMdmOrNot);
		return this;
	}
	
	public ProjectPage verifyMediaGenerated(int noOfSnpshots, int noOfSnapshotHQ, int noOfPanoramic,boolean isMdmOrNot) {
		goToImagesTab();
		List<String> filterOptions = Arrays.asList("Screenshots", "Realistic images", "360° Images");
		for (String a : filterOptions) {
			goToMediaType(a, isMdmOrNot);
			UtilHBM.waitFixTime(2000);
			int activeMediaCategoryNavCount=Integer.parseInt(activeMediaType.findElement(By.xpath("span[@class='new-badge']")).getText());
			clickMoreButton();
			int noOfImages = imageList.size();
			switch (a) {
			case "Screenshots":
				if (activeMediaCategoryNavCount == noOfSnpshots) {
					UtilHBM.reportOK("Correct media count displayed in navigation bar for media category -" + a
							+ " , Count : " + activeMediaCategoryNavCount);
				} else {
					UtilHBM.reportKO("Incorrect media count displayed in navigation bar for media category -" + a
							+ " , Count expected: " + noOfSnpshots + " , count available : "
							+ activeMediaCategoryNavCount);
				}
				if (noOfSnpshots == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfSnpshots) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfSnpshots + ", Medias displayed : " + noOfImages);
				}
				break;

			case "Realistic images":
				if (activeMediaCategoryNavCount == noOfSnapshotHQ) {
					UtilHBM.reportOK("Correct media count displayed in navigation bar for media category -" + a
							+ " , Count : " + activeMediaCategoryNavCount);
				} else {
					UtilHBM.reportKO("Incorrect media count displayed in navigation bar for media category -" + a
							+ " , Count expected: " + noOfSnapshotHQ + " , count available : "
							+ activeMediaCategoryNavCount);
				}
				if (noOfSnapshotHQ == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfSnapshotHQ) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfSnapshotHQ + ", Medias displayed : " + noOfImages);
				}
				break;

			case "360° Images":
				if (activeMediaCategoryNavCount == noOfPanoramic) {
					UtilHBM.reportOK("Correct media count displayed in navigation bar for media category -" + a
							+ " , Count : " + activeMediaCategoryNavCount);
				} else {
					UtilHBM.reportKO("Incorrect media count displayed in navigation bar for media category -" + a
							+ " , Count expected: " + noOfPanoramic + " , count available : "
							+ activeMediaCategoryNavCount);
				}
				if (noOfPanoramic == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfPanoramic) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfPanoramic + ", Medias displayed : " + noOfImages);
				}
				break;
			}
			new Actions(driver).moveToElement(imageList.get(noOfImages - 1)).build().perform();
			UtilHBM.reportInfo("Number of images in " + a + " : " + noOfImages);
			for (int i = 1; i <= noOfImages; i++) {
				String src = imageList.get(i - 1).getAttribute("src");
				String alt = imageList.get(i - 1).getAttribute("alt");
				if (src.contains("https:") && alt.contains("image") && !(src.contains("placeholder")) 
						&& (src.contains(".jpg") || src.contains(".png"))) {
					UtilHBM.reportOK(a + " " + i + " generated!!");
				} else if (alt.contains("placeholder")) {
					UtilHBM.reportKO(a + " no.: " + i + " not generated!!");
				}
			}
		}
		return this;

	}
	
	public ProjectPage deleteFullScreenMedia(String filterMediaText, int mediaIndex, boolean isMdmOrNot, String deleteActionYesOrNo) {
		goToImagesTab();
		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
		verifyMediaCount(isMdmOrNot);
		goToMediaType(filterMediaText, isMdmOrNot);
		int beforeDelete = getMediaCount(isMdmOrNot);
		if (beforeDelete < mediaIndex) {
			UtilHBM.reportKO("Media of Index no." + mediaIndex
					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
					+ " are " + beforeDelete);
		}
		openMediaInFullscreen(mediaIndex).deleteFullScreenMedia(filterMediaText, deleteActionYesOrNo);
		if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, subHeaderProjectName);
			if (beforeDelete == 1) {
				UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
				Verification.VerifyEquals("Wrong noMediaToDisplayText", noMediaToDisplayText.getText(),
						"No media to display !");
			}
			// ***** Verifying media count in navigation bar after deletion
			driver.navigate().refresh();
			UtilHBM.waitExplicitDisplayed(driver, mediaCount);
			goToMediaType(filterMediaText, isMdmOrNot);
			int noOfMediasAfterDeletion = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfterDeletion + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count(Navigation bar) before deletion : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after deletion : "
						+ noOfMediasAfterDeletion);
			} else {
				UtilHBM.reportKO(
						"Media not deleted!!Media count(Navigation bar) before deletion : " + noOfMediasBeforeDeletion
								+ " , Media count(Navigation bar) after deletion : " + noOfMediasAfterDeletion);
			}
			goToMediaType(filterMediaText, isMdmOrNot);
			int afterDelete = getMediaCount(isMdmOrNot);
			if (beforeDelete == afterDelete + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count before deletion : " + beforeDelete
						+ " , Media count after deletion : " + afterDelete);
			} else {
				UtilHBM.reportKO("Media not deleted from fullscreen mode,Delete action:" + deleteActionYesOrNo
						+ ",Media count before deletion : " + beforeDelete + " , Media count after deletion : "
						+ afterDelete);
			}
		} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
			UtilHBM.waitExplicitClickable(driver, subHeaderProjectName);
			int noOfMediasAfter = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfter) {
				UtilHBM.reportOK("Delete action:" + deleteActionYesOrNo + ",Media count(Navigation bar) before : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after : " + noOfMediasAfter);
			} else {
				UtilHBM.reportKO("Media deleted from fullscreen mode,Delete action:" + deleteActionYesOrNo
						+ ", Media count(Navigation bar) before : " + noOfMediasBeforeDeletion
						+ " , Media count(Navigation bar) after : " + noOfMediasAfter);
			}
			int afterDelete = getMediaCount(isMdmOrNot);
			if (beforeDelete == afterDelete) {
				UtilHBM.reportOK("Media count before : " + beforeDelete + " , Media count after: " + afterDelete);
			} else {
				UtilHBM.reportKO("Delete action:" + deleteActionYesOrNo
						+ ",Different Media counts than earlier!!Media count before : " + beforeDelete
						+ " , Media count after : " + afterDelete);
			}
		}
		goToMediaType("All Medias", isMdmOrNot).verifyMediaCount(isMdmOrNot);
		return this;
	}
	
	public ProjectPage verifyImagesTab(String projectOwnership, int noOfSnpshots, int noOfSnapshotHQ,
			int noOfPanoramic,boolean isMdmOrNot) {
		UtilHBM.waitExplicitDisplayed(driver, subHeaderProjectName);
		UtilHBM.turnOffImplicitWaits(driver);
		int totalMediaCount = noOfSnpshots + noOfSnapshotHQ + noOfPanoramic;
		if (totalMediaCount != 0) {
			verifyMediaGenerated(noOfSnpshots, noOfSnapshotHQ, noOfPanoramic, isMdmOrNot)
					.goToMediaType("All Medias", isMdmOrNot).verifyMediaCount(isMdmOrNot);
			int AllMediaCount = 0;
			List<String> mediaCategories = Arrays.asList("All Medias", "Screenshots", "Realistic images",
					"360° Images");

			for (String a : mediaCategories) {
				goToMediaType(a,isMdmOrNot);
				if (getMediaCount(false) == 0) {
					UtilHBM.reportInfo("No media displayed in " + a);
				} else {
					UtilHBM.waitFixTime(1000);
					int mediaCount = getMediaCount(false);
					UtilHBM.reportInfo("No. of medias in " + a + " :\t" + mediaCount);
					if (a.equalsIgnoreCase("All Medias")) {
						if (mediaCount == totalMediaCount) {
							UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
						} else {
							UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a
									+ "!!,Medias expected : " + totalMediaCount + ", Medias displayed : " + mediaCount);
						}
						AllMediaCount = mediaCount;
					} else {
						AllMediaCount = AllMediaCount - mediaCount;
						switch (a) {
						case "Screenshots":
							if (noOfSnpshots == 0) {
								 UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								 Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								 noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnpshots) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnpshots + ", Medias displayed : " + mediaCount);
							}
							break;

						case "Realistic images":
							if (noOfSnapshotHQ == 0) {
								 UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								 Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								 noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnapshotHQ) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnapshotHQ + ", Medias displayed : " + mediaCount);
							}
							break;

						case "360° Images":
							if (noOfPanoramic == 0) {
								 UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								 Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								 noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfPanoramic) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfPanoramic + ", Medias displayed : " + mediaCount);
							}
							break;

						default:
							UtilHBM.reportInfo("Wrong media type!!!");
							break;

						}
						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
							clickShareMediaButton(1).shareMediaByCopyLink("media", a);
						}
						new Actions(driver).moveToElement(mediaList.get(0)).build().perform();
						WebElement shareButton1 = mediaList.get(0).findElement(By.xpath(
								"ul[@class='media-actions']/li/*[@class='item-link button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
						UtilHBM.waitExplicitDisplayed(driver, shareButton1);
						UtilHBM.waitExplicitClickable(driver, shareButton1);
						if (projectOwnership.equalsIgnoreCase("own")) {
							WebElement deleteButton1 = mediaList.get(0).findElement(By.xpath(
									"ul[@class='media-actions']/li/*[@class='item-link button button--icon']/i[@class='icon icon-trash u-fs16']/../.."));
							Verification.displayOfWebElement(deleteButton1);
						}
						if (!a.equalsIgnoreCase("360° Images")) {
							WebElement downloadButton = mediaList.get(0).findElement(By.xpath(
									"ul[@class='media-actions']/li/*[@class='button button--icon download-media']/i[@class='icon icon-download u-fs16']/../.."));
							UtilHBM.waitExplicitDisplayed(driver, downloadButton);
							Verification.displayOfWebElement(downloadButton);
						}
						
						Verification.displayOfWebElement(shareButton1);
						clickShareMediaButton(1).verifyShareContainer("media").closeShareContainer();
						UtilHBM.turnOnImplicitWaits(driver);
					}
				}
			}
			
			 if (AllMediaCount == 0) {
			 UtilHBM.reportOK("Total no. of medias displayed is correct");
			 } else {
			 UtilHBM.reportKO("Total no. of medias displayed is incorrect");
			 }
			 goToOverviewTab();
		} else if (!imagesTabList.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
		}
		return this;
	}

	public ShareContainer openImageShareContainer(String imgSrc) {
		WebElement shareButton1 = null;
		boolean isImgAvailable = false;
		clickMoreButton();
		for (WebElement a : mediaList) {
			if (a.findElement(By.cssSelector("span>img")).getAttribute("src").contains(imgSrc)) {
				new Actions(driver).moveToElement(a).build().perform();
				shareButton1 = a.findElement(By.xpath(
						"ul[@class='media-actions']/li/*[@class='item-link button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
				UtilHBM.reportInfo("Image found!!");
				isImgAvailable = true;
				break;
			}
		}
		if (!isImgAvailable) {
			UtilHBM.reportKO("Image not found!!");
		}
//		new Actions(driver).moveToElement(shareButton1).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		shareButton1.click();
		UtilHBM.reportInfo("Opening share container for image : " + imgSrc);
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
//	public ProjectPage verifyImagesTab1(String projectOwnership, int noOfSnpshots, int noOfSnapshotHQ,int noOfPanoramic) {
//		int totalMediaCount = noOfSnpshots + noOfSnapshotHQ + noOfPanoramic;
//		if (totalMediaCount != 0) {
//			verifyMediaGenerated(noOfSnpshots, noOfSnapshotHQ, noOfPanoramic);
//			goToImagesTab();
//			verifyMediaCount("No");
//			Select select = new Select(mediaFilter);
//			Verification.VerifyEquals("All medias filter is not selected initially in media page!!", select.getFirstSelectedOption().getText(), "All Medias");
//			List<String> filterOptions = Arrays.asList("All Medias", "Screenshots", "Realistic images", "360° Images");
//			int AllMediaCount = 0; 
//			for (String a : filterOptions) {
//				select.selectByVisibleText(a);
//				UtilHBM.waitFixTime(2000);
//				if (getMediaCount("No")==0) {
//					UtilHBM.reportInfo("No media displayed in " + a);
//				} else {
//					UtilHBM.waitFixTime(3000);
//					int mediaCount = getMediaCount("No");
//					UtilHBM.reportInfo("No. of medias in " + a + " :\t" + mediaCount);
//					if (a.equalsIgnoreCase("All Medias")) {
//						if (mediaCount == totalMediaCount) {
//							UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
//						} else {
//							UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
//									+ totalMediaCount + ", Medias displayed : " + mediaCount);
//						}
//						AllMediaCount = mediaCount;
//					} else {
//						AllMediaCount = AllMediaCount - mediaCount;
//						switch (a) {
//						case "Screenshots":
//							if (noOfSnpshots == 0) {
//								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
//										noMediaToDisplayText.getText(), "No media to display !");
//							} else if (mediaCount == noOfSnpshots) {
//								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
//							} else {
//								UtilHBM.reportKO(
//										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
//												+ noOfSnpshots + ", Medias displayed : " + mediaCount);
//							}
//							break;
//
//						case "Realistic images":
//							if (noOfSnapshotHQ == 0) {
//								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
//										noMediaToDisplayText.getText(), "No media to display !");
//							} else if (mediaCount == noOfSnapshotHQ) {
//								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
//							} else {
//								UtilHBM.reportKO(
//										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
//												+ noOfSnapshotHQ + ", Medias displayed : " + mediaCount);
//							}
//							break;
//
//						case "360° Images":
//							if (noOfPanoramic == 0) {
//								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
//										noMediaToDisplayText.getText(), "No media to display !");
//							} else if (mediaCount == noOfPanoramic) {
//								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
//							} else {
//								UtilHBM.reportKO(
//										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
//												+ noOfPanoramic + ", Medias displayed : " + mediaCount);
//							}
//							break;
//						
//						default:
//							UtilHBM.reportInfo("Wrong media type!!!");
//							break;
//
//						}
////						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
////								verifyCopyToClipbioard("media",a);
////						}
//						new Actions(driver).moveToElement(mediaList.get(0)).build().perform();						
//						WebElement shareButton1=mediaList.get(0).findElement(By.xpath("ul[@class='media-actions']/li/span/i[@class='icon icon-share u-fs16']/parent::span[@title='Share']/.."));
//						UtilHBM.waitExplicitDisplayed(driver, shareButton1);
//						UtilHBM.waitExplicitClickable(driver, shareButton1);
//						if (projectOwnership.equalsIgnoreCase("own")) {
//							WebElement deleteButton1 = mediaList.get(0).findElement(By.xpath("ul[@class='media-actions']/li/span/span[@class='icon icon-trash u-fs16']/../.."));
//							Verification.displayOfWebElement(deleteButton1);
//						}
//						WebElement downloadButton = mediaList.get(0).findElement(By.xpath("ul[@class='media-actions']/li/span/i[@class='icon icon-download u-fs16']/../.."));
//						UtilHBM.waitExplicitDisplayed(driver, downloadButton);
//						Verification.displayOfWebElement(downloadButton);
//						Verification.displayOfWebElement(shareButton1);	
//						clickShareMediaButton(1).verifyShareContainer("media").closeShareContainer();
//						openMediaInFullscreen(1).verifyFullscreenMedia(projectOwnership, a, mediaCount);
//					}
//				}
//			}
//			if (AllMediaCount == 0) {
//				UtilHBM.reportOK("Total no. of medias displayed is correct");
//			} else {
//				UtilHBM.reportKO("Total no. of medias displayed is incorrect");
//			}
//			goToOverviewTab();
//		} else if (!imagesTabList.isEmpty()) {
//			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
//		}
//			return this;
//	}
//	
//	public ProjectPageMediaTab goToMediaType(String mediaType) {
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
//		driver.findElement(By.xpath(
//				"//div[@class='wrapper']/div[@class='medias-submenu']/ul/li/*[contains(@class,'media-sort icon-content')][normalize-space(text())='"
//						+ mediaType + "']"))
//				.click();
//		UtilHBM.waitFixTime(1000);
//		Verification.elementContainsString(activeMediaType, mediaType, "Active Media Type");
//		return this;
//
//	}
	

	
//	public FullscreenMedia openMediaInFullscreen(int mediaIndex) {
//		WebElement expectedMedia=mediaList.get(mediaIndex-1).findElement(By.cssSelector(".media-thumb-link.trigger-overlay-slider"));
//		UtilHBM.waitExplicitClickable(driver, expectedMedia);
//		expectedMedia.click();
//		return PageFactory.initElements(driver, FullscreenMedia.class);
//	}	
	
	public FullscreenMedia openMediaInFullscreen(int mediaIndex) {
		WebElement expectedMedia = mediaList.get(mediaIndex - 1).findElement(By.cssSelector(".media-thumb-link>img"));
		UtilHBM.waitExplicitClickable(driver, expectedMedia);
		expectedMedia.click();
		return PageFactory.initElements(driver, FullscreenMedia.class);
	}
	
	public void setUserName(String userName1) {
		uName = userName1;
	}
	
	public static String getUserName() {		
		return uName;
	}


	public ProjectPage editDescription(String buildingType, String constructionType, String description) {
		UtilHBM.reportInfo("Clicking "+editDescription.getText()+" button in Description section.");
		Actions actions=new Actions(driver);
		actions.moveToElement(projectDescription).build().perform();
		editDescription.click();
		UtilHBM.waitFixTime(1000);
		if(editDescription.getText().trim().equalsIgnoreCase("ok")) {
			Select select=new Select(descriptionBuildingSelect);
			select.selectByVisibleText(buildingType);
			UtilHBM.reportInfo("Option \""+buildingType+"\" selected in building type.");
			Select select1=new Select(descriptionTypeSelect);
			select1.selectByVisibleText(constructionType);
			UtilHBM.reportInfo("Option \""+constructionType+"\" selected in construction type.");
			descriptionTextarea.clear();
			descriptionTextarea.sendKeys(description);
			UtilHBM.reportInfo("Clicking "+editDescription.getText()+" button in Description section.");
			editDescription.click();
			UtilHBM.waitExplicitDisplayed(driver,constructionBuildingText);
			Verification.VerifyEquals("BuildingType not updated", descriptionBuildingText.getAttribute("innerHTML").trim(),buildingType);
			Verification.VerifyEquals("constructionType not updated", constructionBuildingText.getAttribute("innerHTML").trim(),constructionType);
			UtilHBM.waitExplicitDisplayed(driver,projectDescription);
			Verification.VerifyEquals("description not updated", projectDescription.getAttribute("innerHTML").trim(),description);
		}
		else {
			UtilHBM.reportKO("Description Section is not editable.");
		}
		return this;
	}

	public ProjectPage addNewComment(String comment) {
		UtilHBM.waitExplicitDisplayed(driver, enterNewComment);
		UtilHBM.waitExplicitClickable(driver, enterNewComment);
		enterNewComment.click();
		enterNewComment.sendKeys(comment+Keys.ESCAPE);
		enterNewComment.click();
		enterNewComment.sendKeys(comment+Keys.ENTER);
		int i = 0;
		while (i < 50 || !(firstCommentText.get(0).getText().trim().equalsIgnoreCase(comment))) {
			UtilHBM.waitFixTime(200);
			i++;
		}
		Verification.VerifyEquals("Wrong Comment", firstCommentText.get(0).getText().trim(),comment);
		return this;
		}
	
	public ProjectPage editComment(String comment) {
		if(commentList.isEmpty())
			UtilHBM.reportKO("Comment list is empty!!!");
		else {
			new Actions(driver).moveToElement(firstCommentBox).build().perform();
			UtilHBM.waitExplicitDisplayed(driver,firstCommentMoreIcon);
			UtilHBM.waitExplicitClickable(driver,firstCommentMoreIcon);
			firstCommentMoreIcon.click();
			UtilHBM.waitExplicitClickable(driver,editCommentButton);
			editCommentButton.click();
			editCommentTextarea.clear();
			editCommentTextarea.sendKeys(comment);
			editCommentCancel.click();
			new Actions(driver).moveToElement(firstCommentBox).build().perform();
			UtilHBM.waitExplicitDisplayed(driver,firstCommentMoreIcon);
			firstCommentMoreIcon.click();
			UtilHBM.waitExplicitClickable(driver,editCommentButton);
			editCommentButton.click();
			Verification.displayOfWebElement(editCommentOK);
			editCommentTextarea.clear();
			editCommentTextarea.sendKeys(comment+Keys.ENTER);
			int i = 0;
			while (i < 50 || !(firstCommentText.get(0).getText().trim().equalsIgnoreCase(comment))) {
				UtilHBM.waitFixTime(200);
				i++;
			}
			int beforeLike=Integer.parseInt(firstCommentLikes.getText());
			firstCommentLikeButton.click();
			UtilHBM.waitFixTime(2000);
			int afterLike=Integer.parseInt(firstCommentLikes.getAttribute("innerHTML"));
			if(afterLike==beforeLike+1)
				UtilHBM.reportOK("Comment Liked and no. of Likes increased");
			else
				UtilHBM.reportKO("Comment Like failed and no. of Likes not increased");
			Verification.VerifyEquals("Wrong Edited Comment", firstCommentText.get(0).getText().trim(),comment);
		}
		return this;
	}
	
	public ProjectPage deleteComment() {
		if(commentList.isEmpty()) 
			UtilHBM.reportKO("Comment list is empty!!!");
		else if(commentList.size()==1){
			new Actions(driver).moveToElement(firstCommentBox).build().perform();
			UtilHBM.waitExplicitDisplayed(driver,firstCommentMoreIcon);
			firstCommentMoreIcon.click();
			UtilHBM.waitExplicitClickable(driver,deleteCommentButton);
			UtilHBM.reportInfo("Comment to be deleted : "+firstCommentText.get(0).getText());
			UtilHBM.reportInfo("Commenter : "+firstCommenter.getText());
			deleteCommentButton.click();
			UtilHBM.waitFixTime(2000);
			if(commentList.isEmpty())
				UtilHBM.reportOK("Comment deleted and Comment list is empty!!!");
			else
				UtilHBM.reportKO("Comment delete failed and Comment list is not empty");
		}
		else {
			int beforeDelete=commentList.size();
			new Actions(driver).moveToElement(firstCommentBox).build().perform();
			UtilHBM.waitExplicitDisplayed(driver,firstCommentMoreIcon);
			firstCommentMoreIcon.click();
			UtilHBM.waitExplicitClickable(driver,deleteCommentButton);
			UtilHBM.reportInfo("Comment to be deleted : "+firstCommentText.get(0).getText());
			UtilHBM.reportInfo("Commenter : "+firstCommenter.getText());
			deleteCommentButton.click();
			UtilHBM.waitFixTime(2000);
			int afterDelete=commentList.size();
			if(afterDelete==beforeDelete-1)
				UtilHBM.reportOK("Comment deleted and no. of comments decreased");
			else
				UtilHBM.reportKO("Comment delete failed and no. of comments not decreased");
		}
		return this;
	}
	
	public ProjectPage addReply(String replyText) {
		UtilHBM.turnOffImplicitWaits(driver);
		 if(commentList.size()==0) 
				UtilHBM.reportKO("Comment list is empty!!!");
		 else {			 
			while(!loadOlderMessages.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, loadOlderMessages.get(0));
				loadOlderMessages.get(0).click();
			}			
			if(!(firstCommentShowHideReplies.isEmpty())&&firstCommentShowHideReplies.get(0).getText().contains("Show replies")) 
				firstCommentShowHideReplies.get(0).click();
			while(!firstCommentReplyList.isEmpty()) {
				deleteReply();
			}
			UtilHBM.waitExplicitDisplayed(driver, firstCommentReplyButton);
			UtilHBM.waitExplicitClickable(driver, firstCommentReplyButton);
			firstCommentReplyButton.click();
			firstCommentReplyBox.sendKeys(Keys.ESCAPE);
			firstCommentReplyButton.click();
			firstCommentReplyBox.sendKeys(replyText+Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			Verification.displayOfWebElement(firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("a")));
			UtilHBM.reportInfo("Replied on comment by :"+firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("a")).getText());
			Verification.displayOfWebElement(firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("div.u-mbn.content")));
			Verification.VerifyEquals("Wrong reply added", firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("div.u-mbn.content")).getText(), replyText);
			UtilHBM.turnOnImplicitWaits(driver);
		 }		
		return this;
		}
	
	public ProjectPage editReply(String replyText) {
		UtilHBM.turnOffImplicitWaits(driver);
		if(commentList.size()==0)
			UtilHBM.reportKO("Comment list is empty!!!");
		else {			
			while(!loadOlderMessages.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, loadOlderMessages.get(0));
				loadOlderMessages.get(0).click();
			}			
			new Actions(driver).moveToElement(replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath(".."))).build().perform();
			WebElement lastReplyMoreIcon=replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("i"));
			UtilHBM.waitExplicitDisplayed(driver,lastReplyMoreIcon);
			UtilHBM.waitExplicitClickable(driver,lastReplyMoreIcon);
			lastReplyMoreIcon.click();
			WebElement editReplyButton=replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("div/ul/li/p[1]/span"));
			UtilHBM.waitExplicitClickable(driver,editReplyButton);
			editReplyButton.click();
			replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("../div[@class='item-data w-100']/div")).clear();
			replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("../div[@class='item-data w-100']/div")).sendKeys(replyText+Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			Verification.displayOfWebElement(firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("a")));
			UtilHBM.reportInfo("Edited reply of user :"+firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("a")).getText());
			Verification.displayOfWebElement(firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("div.u-mbn.content")));
			Verification.VerifyEquals("Reply edited failed", firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("div.u-mbn.content")).getText().trim(), replyText);
			UtilHBM.turnOnImplicitWaits(driver);
		}
		return this;
	}
	
	public ProjectPage deleteReply() {
		UtilHBM.turnOffImplicitWaits(driver);
		if(commentList.size()==0) 
			UtilHBM.reportKO("Comment list is empty!!!");
		else {			
			while(!loadOlderMessages.isEmpty()) {
				UtilHBM.waitExplicitClickable(driver, loadOlderMessages.get(0));
				loadOlderMessages.get(0).click();
			}			
			int beforeDelete=firstCommentReplyList.size();
			new Actions(driver).moveToElement(replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath(".."))).build().perform();
			WebElement lastReplyMoreIcon=replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("i"));
			UtilHBM.waitExplicitDisplayed(driver,lastReplyMoreIcon);
			UtilHBM.waitExplicitClickable(driver,lastReplyMoreIcon);
			lastReplyMoreIcon.click();
			WebElement deleteReplyButton=replyMoreIcon.get(replyMoreIcon.size()-1).findElement(By.xpath("div/ul/li/p[2]/span"));
			UtilHBM.reportInfo("Reply to be deleted : "+firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("div.u-mbn.content")).getText());
			UtilHBM.reportInfo("Reply of : "+firstCommentReplyList.get(firstCommentReplyList.size()-1).findElement(By.cssSelector("a")).getText());
			UtilHBM.waitExplicitClickable(driver,deleteReplyButton);
			deleteReplyButton.click();
			UtilHBM.waitFixTime(1000);
			int afterDelete=firstCommentReplyList.size();
			if(afterDelete==beforeDelete-1)
				UtilHBM.reportOK("Comment deleted and no. of comments decreased");
			else
				UtilHBM.reportKO("Comment delete failed and no. of comments not decreased");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	
	public ProjectPage verifyProjectDetails(int noOfFloors, int noOfRooms, String area, int noOfBedrooms,int noOfBathrooms) {
		Verification.elementContainsString(projectDetails,noOfFloors + " floor", "noOfFloors in project details");
		Verification.elementContainsString(projectDetails,noOfRooms + " room", "noOfRooms in project details");
		Verification.elementContainsString(projectDetails,area, "surfaceArea in project details");
		Verification.elementContainsString(noOfFloors1, noOfFloors + " floor", "noOfFloors");
		Verification.elementContainsString(noOfRooms1, noOfRooms + " room", "noOfRooms1");
		Verification.elementContainsString(surfaceArea1, area, "surfaceArea1");
		Verification.elementContainsString(noOfBedrooms1, noOfBedrooms + " bedroom", "noOfBedrooms1");
		Verification.elementContainsString(noOfBathrooms1, noOfBathrooms + " bathroom", "noOfBathrooms1");
		return this;
	}
	
	public ProjectPage verifyProjectName(String projectName) {
		UtilHBM.waitExplicitDisplayed(driver, subHeaderProjectName);
		Verification.VerifyEquals("Wrong ", subHeaderProjectName.getText(), projectName);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/project/") || !(currentUrl.contains("Error")),
				"Error displayed or 'Project' word is not displayed in project URL irrespective of language!! URL : " + currentUrl);
		return this;
	}

	public ProjectPage verifyOverviewTabMDM(String projectOwnership,int noOfFloors, int noOfRooms, String area,
			int noOfBedrooms, int noOfBathrooms, int noOfShoppedProducts, int totalMediaCount) {
		UtilHBM.turnOffImplicitWaits(driver);
		Verification.displayOfWebElement(subHeaderThumbImg);
		Verification.displayOfWebElement(subHeaderProjectName);
		if (projectOwnership.equalsIgnoreCase("own")) {
			if (projectActions.size() == 5) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed for own project!!!No of project actions displayed : "
						+ projectActions.size());
			}
			Verification.displayOfWebElement(subHeaderProjectTime);
			List<WebElement> own = new ArrayList<>();
			own.add(openProject);
//			own.add(vrButton);
			own.add(duplicateButton);
			own.add(shareMDMProjectButton);
			own.add(deletePRojectHbm4);
			for (WebElement a : own) {
				Verification.displayOfWebElement(a);
			}
		} else if (projectOwnership.equalsIgnoreCase("others")) {
			if (projectActions.size() == 3) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed for other  users project!!!No of project actions displayed : "
						+ projectActions.size());
			}
			List<WebElement> others = new ArrayList<>();
			others.add(openProject);
//			others.add(vrButton);
			others.add(duplicateButton);
			others.add(shareMDMProjectButton);
			for (WebElement b : others) {
				Verification.displayOfWebElement(b);
			}
		} else {
			UtilHBM.reportKO("Wrong input for projectOwnership!!!");
		}

		shareProjectMDM();
		if (projectInfo.size() == 5) {
			UtilHBM.reportOK("No. of project details displayed in details bar is correct!!!");
		} else {
			UtilHBM.reportKO(
					"Incorrect no of project details displayed in details bar!!!No of project details displayed : "
							+ projectInfo.size());
		}
		Verification.displayOfWebElement(projectDetails);
		Verification.displayOfWebElement(noOfFloorsIcon);
		Verification.displayOfWebElement(noOfRoomsIcon);
		Verification.displayOfWebElement(surfaceAreaIcon);
		Verification.displayOfWebElement(noOfBedroomsIcon);
		Verification.displayOfWebElement(noOfBathroomsIcon);
		
		if (noOfFloors1.getText().contains("floor") && noOfRooms1.getText().contains("room")
				&& (surfaceArea1.getText().contains("m") || surfaceArea1.getText().contains("ft"))
				&& noOfBedrooms1.getText().contains("bedroom") && noOfBathrooms1.getText().contains("bathroom") ) {
			UtilHBM.reportOK("Project Details Bar is Displayed");
		} else {
			UtilHBM.reportKO("Wrong detailTitles displayed in details bar in project page");
		}
		
		if (noOfShoppedProducts != 0) {
			int noOfItemsShopped = Integer.parseInt(productsTab.getText()
					.substring(productsTab.getText().indexOf("(") + 1, (productsTab.getText().indexOf(")"))));
			if (noOfItemsShopped == noOfShoppedProducts) {
				UtilHBM.reportOK("noOfShoppedProducts displayed correctly in tab headers!!");
			} else {
				UtilHBM.reportKO(
						"noOfShoppedProducts displayed incorrectly in tab headers!!noOfShoppedProductsAvailable : "
								+ noOfItemsShopped + "noOfShoppedProductsExpected : " + noOfShoppedProducts);
			}
		} else if (!productsTabList.isEmpty()) {
			UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
		}

		if (totalMediaCount != 0) {
			int noOfMedias = Integer.parseInt(imagesTab.getText().substring(imagesTab.getText().indexOf("(") + 1,
					(imagesTab.getText().indexOf(")"))));
			if (noOfMedias == totalMediaCount) {
				UtilHBM.reportOK("totalMediaCount displayed correctly in tab headers!!");
			} else {
				UtilHBM.reportKO("totalMediaCount displayed incorrectly in tab headers!! totalMediaCountAvailble : "
						+ noOfMedias + ", totalMediaCountExpected : " + totalMediaCount);
			}
		} else if (!imagesTabList.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
		}
		
		checkImagesInOverviewTab(totalMediaCount)
		.verifyProjectDetails(noOfFloors, noOfRooms, area, noOfBedrooms,noOfBathrooms)
		.verifyColorPalette(noOfFloors, noOfRooms, noOfBedrooms, noOfBathrooms)
		.verifyAllSurfaces(projectOwnership,noOfFloors, noOfRooms,area, noOfBedrooms, noOfBathrooms)
		.verifyFeaturedProducts(noOfShoppedProducts);
		
		if (turnTableImg.isEmpty()) {
			UtilHBM.reportKO("TurnTable not Generated");
		} else if (turnTableImg.get(0).getAttribute("src").startsWith("https://byme")
				&& turnTableImg.get(0).getAttribute("src").endsWith(".jpg")) {
			UtilHBM.reportOK("TurnTable Generated");
			UtilHBM.turnOffImplicitWaits(driver);
			if (sliderNextButton.isEmpty()) {
				UtilHBM.reportKO("Slider buttons not available for images in overview tab for project!!");
			}
			UtilHBM.turnOnImplicitWaits(driver);
		}

		if (descriptionText.isEmpty()) {
			UtilHBM.reportInfo("Description Not available");
		} else {
			Verification.displayOfWebElement(descriptionBuildingText);
			Verification.displayOfWebElement(constructionBuildingText);
			Verification.displayOfWebElement(projectDescription);
		}
		if (tagsText.isEmpty()) {
			UtilHBM.reportInfo("Tags Not available");
		} else {
			for (WebElement a : tagsList) {
				Verification.displayOfWebElement(a);
			}
		}
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, ProjectPage.class);
		
	}

	public ProjectPage verifyImagesTabMDM(String projectOwnership, int noOfSnpshots, int noOfSnapshotHQ,int noOfPanoramic) {
		int totalMediaCount = noOfSnpshots + noOfSnapshotHQ + noOfPanoramic;
		if (totalMediaCount != 0) {
			goToImagesTab();
			verifyMediaCount(true);
			Select select = new Select(mediaFilter);
			List<String> filterOptions = Arrays.asList("All Medias", "Screenshots", "Realistic images", "360° Images");
			int AllMediaCount = 0;
			for (String a : filterOptions) {
				select.selectByVisibleText(a);
				UtilHBM.waitFixTime(2000);
				if (getMediaCount(true)==0) {
					UtilHBM.reportInfo("No media displayed in " + a);
				} else {
					int mediaCount = getMediaCount(true);
					UtilHBM.reportInfo("No. of medias in " + a + " :\t" + mediaCount);
					if (a.equalsIgnoreCase("All Medias")) {
						AllMediaCount = mediaCount;
					} else {
						AllMediaCount = AllMediaCount - mediaCount;
						switch (a) {
						case "Screenshots":
							if (noOfSnpshots == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnpshots) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnpshots + ", Medias displayed : " + mediaCount);
							}
							break;
						case "Realistic images":
							if (noOfSnapshotHQ == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnapshotHQ) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnapshotHQ + ", Medias displayed : " + mediaCount);
							}
							break;
						case "360° Images":
							if (noOfPanoramic == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfPanoramic) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfPanoramic + ", Medias displayed : " + mediaCount);
							}
							break;
						default:
							UtilHBM.reportInfo("Wrong media type!!!");
							break;

						}
						new Actions(driver).moveToElement(mediaList.get(0)).build().perform();						
						WebElement shareButton=mediaList.get(0).findElement(By.xpath("ul[@class='media-actions']/li/span/i[@class='icon icon-share u-fs16']/parent::span[@title='Share']/.."));
						UtilHBM.waitExplicitDisplayed(driver, shareButton);
						UtilHBM.waitExplicitClickable(driver, shareButton);
						Verification.displayOfWebElement(shareButton);
						if (projectOwnership.equalsIgnoreCase("own")) {
							WebElement deleteButton = mediaList.get(0).findElement(By.xpath("ul[@class='media-actions']/li/span/span[@class='icon icon-trash u-fs16']/.."));
							Verification.displayOfWebElement(deleteButton);
						}
						WebElement downloadButton = mediaList.get(0).findElement(
								By.xpath("ul[@class='media-actions']/li/span/i[@class='icon icon-download u-fs16']/.."));
						UtilHBM.waitExplicitDisplayed(driver, downloadButton);
						Verification.displayOfWebElement(downloadButton);
//						UtilHBM.waitExplicitDisplayed(driver, shareButton);
//						UtilHBM.waitExplicitClickable(driver, shareButton);
//						shareButton.click();
						clickShareMediaButton(1).verifyShareContainer("media").closeShareContainer();
						openMediaInFullscreen(1).verifyFullscreenMedia(projectOwnership, a, mediaCount);
//						WebElement shareFacebook1 = mediaList.get(0).findElement(By.xpath("//ul/li/div[@class='shareBox shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Facebook']/i"));
//						WebElement shareTwitter1 = mediaList.get(0).findElement(By.xpath("//ul/li/div[@class='shareBox shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Twitter']/i"));
//						WebElement sharePinterest1 = mediaList.get(0).findElement(By.xpath("//ul/li/div[@class='shareBox shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Pinterest']/i"));
//						WebElement shareEmail1 = mediaList.get(0).findElement(By.xpath("//ul/li/div[@class='shareBox shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Email']/i"));						
//						Verification.displayOfWebElement(shareFacebook1);
//						Verification.displayOfWebElement(shareTwitter1);
//						Verification.displayOfWebElement(sharePinterest1);
//						Verification.displayOfWebElement(shareEmail1);
//						mediaList.get(0).findElement(By.cssSelector(".media-thumb-link.trigger-overlay-medias")).click();
//						if(!a.equalsIgnoreCase("360° Images")) {
//							UtilHBM.waitExplicitDisplayed(driver,driver.findElement(By.xpath("//div[@class='slick-slide slick-current slick-active']/img[starts-with(@src,'https:')]")));
//							Verification.displayOfWebElement(driver.findElement(By.xpath("//div[@class='slick-slide slick-current slick-active']/img[starts-with(@src,'https:')]")));
//							UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='slick-slide slick-current slick-active']/div/a/i[@class='icon icon-share u-fs16 u-mrxxs']/../..")));
//							UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath("//div[@class='slick-slide slick-current slick-active']/div/a/i[@class='icon icon-share u-fs16 u-mrxxs']/../..")));
//							WebElement shareButton11=driver.findElement(By.xpath("//div[@class='slick-slide slick-current slick-active']/div/a/i[@class='icon icon-share u-fs16 u-mrxxs']/.."));
////							if (projectOwnership.equalsIgnoreCase("own")) {
////								WebElement deleteButton11 = driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']/div/div/ul/li/a/i[@class='icon icon-trash u-fs20']/../.."));
////								Verification.displayOfWebElement(deleteButton11);
////							}
////							WebElement downloadButton11 = driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']/div/div/ul/li/a/i[@class='icon icon-download u-fs20']/../.."));
////							UtilHBM.waitExplicitDisplayed(driver, downloadButton11);
////							Verification.displayOfWebElement(downloadButton11);
//							Verification.displayOfWebElement(shareButton11);	
//							shareButton11.click();
//							UtilHBM.waitFixTime(1000);
//							UtilHBM.waitExplicitDisplayed(driver,driver.findElement(By.xpath("//div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Facebook']")));
//							WebElement shareFacebook2 = driver.findElement(By.xpath("//div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Facebook']"));
//							WebElement shareTwitter2 = driver.findElement(By.xpath("//div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Twitter']"));
//							WebElement sharePinterest2 = driver.findElement(By.xpath("//div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Pinterest']"));
//							WebElement shareEmail2 = driver.findElement(By.xpath("//div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Email']"));
//							Verification.displayOfWebElement(shareFacebook2.findElement(By.tagName("i")));
//							Verification.displayOfWebElement(shareTwitter2.findElement(By.tagName("i")));
//							Verification.displayOfWebElement(sharePinterest2.findElement(By.tagName("i")));
//							Verification.displayOfWebElement(shareEmail2.findElement(By.tagName("i")));
//							shareButton11.click();
//						}	
//						if (mediaCount > 1) {
//							UtilHBM.waitExplicitDisplayed(driver, sliderNextMDM);
//							Verification.displayOfWebElement(sliderNextMDM);
//							UtilHBM.waitExplicitDisplayed(driver, sliderPreviousMDM);
//							Verification.displayOfWebElement(sliderPreviousMDM);
//						}
//						closeFullScreenMedia.click();
					}
				}
			}
			if (AllMediaCount == 0) {
				UtilHBM.reportOK("Total no. of medias is correct");
			} else {
				UtilHBM.reportKO("Total no. of medias is incorrect");
			}
		} else if (!imagesTabList.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Expected total media count : 0");
		}
		goToOverviewTab();
			return this;
	}

/*
	public ProjectPage sharemediaMDM(String filterMediaText, int mediaIndex) {
		imagesTab.click();
		verifyMediaCount("Yes");
		filterMedia(filterMediaText, "Yes");
		UtilHBM.reportInfo("Verifying share operation in media tab for first media in " + filterMediaText);
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
				"ul[@class='media-actions']/li/div/a/i[@class='icon icon-share u-fs16']/parent::a[@title='Share']/../.."));
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		Verification.displayOfWebElement(shareButton1);
		shareButton1.click();
		WebElement shareFacebook1 = mediaList.get(mediaIndex - 1)
				.findElement(By.xpath("ul/li/div/a[@title='Share']/following-sibling::div/a[@title='Facebook']"));
		WebElement shareTwitter1 = mediaList.get(mediaIndex - 1)
				.findElement(By.xpath("ul/li/div/a[@title='Share']/following-sibling::div/a[@title='Twitter']"));
		WebElement sharePinterest1 = mediaList.get(mediaIndex - 1)
				.findElement(By.xpath("ul/li/div/a[@title='Share']/following-sibling::div/a[@title='Pinterest']"));
		WebElement shareEmail1 = mediaList.get(mediaIndex - 1)
				.findElement(By.xpath("ul/li/div/a[@title='Share']/following-sibling::div/a[@title='Email']"));
		Verification.displayOfWebElement(shareFacebook1);
		Verification.displayOfWebElement(shareTwitter1);
		Verification.displayOfWebElement(sharePinterest1);
		Verification.displayOfWebElement(shareEmail1);
		UtilHBM.waitExplicitClickable(driver, shareFacebook1);
		ArrayList<WebElement> shareOptions = new ArrayList<WebElement>();
		shareOptions.add(shareFacebook1);
		shareOptions.add(shareTwitter1);
		shareOptions.add(sharePinterest1);
		shareOptions.add(shareEmail1);
		verifyShareOperation(shareButton1, shareOptions, mediaIndex);
		UtilHBM.reportInfo("Verifying share operation in fullscreen mode for first media in " + filterMediaText);
		mediaList.get(mediaIndex - 1).findElement(By.cssSelector(".media-thumb-link.trigger-overlay-medias")).click();
		if (!filterMediaText.equalsIgnoreCase("360° Images")) {
			WebElement fullScreenMedia = driver.findElement(
					By.xpath("//div[@class='slick-slide slick-current slick-active']/img[starts-with(@src,'https:')]"));
			UtilHBM.waitExplicitDisplayed(driver, fullScreenMedia);
			Verification.displayOfWebElement(fullScreenMedia);
			WebElement shareButton11 = driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div/a/i[@class='icon icon-share u-fs16 u-mrxxs']/../.."));
			UtilHBM.waitExplicitDisplayed(driver, shareButton11);
			UtilHBM.waitExplicitClickable(driver, shareButton11);
			Verification.displayOfWebElement(shareButton11);
			shareButton11.click();
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Facebook']")));
			WebElement shareFacebook2 = driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Facebook']"));
			WebElement shareTwitter2 = driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Twitter']"));
			WebElement sharePinterest2 = driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Pinterest']"));
			WebElement shareEmail2 = driver.findElement(By.xpath(
					"//div[@class='slick-slide slick-current slick-active']/div[@class='shareBox u-mtxs shareBox--open']/a[@title='Share']/following-sibling::div/a[@title='Email']"));
			Verification.displayOfWebElement(shareFacebook2);
			Verification.displayOfWebElement(shareTwitter2);
			Verification.displayOfWebElement(sharePinterest2);
			Verification.displayOfWebElement(shareEmail2);
			UtilHBM.waitExplicitClickable(driver, shareFacebook2);
			ArrayList<WebElement> shareOptions1 = new ArrayList<WebElement>();
			shareOptions1.add(shareFacebook2);
			shareOptions1.add(shareTwitter2);
			shareOptions1.add(sharePinterest2);
			shareOptions1.add(shareEmail2);
			verifyShareOperation(shareButton11, shareOptions1, mediaIndex);
		}
		closeFullScreenMedia.click();
		return this;
	}
*/

//	public ProjectPage verifyShareOperation(WebElement shareButton1, ArrayList<WebElement> shareOptions,
//			int mediaIndex) {
//		for (WebElement b : shareOptions) {
//			UtilHBM.waitExplicitDisplayed(driver, shareButton1);
//			UtilHBM.waitExplicitClickable(driver, shareButton1);
//			shareButton1.click();
//			String site = b.getAttribute("title");
//			UtilHBM.waitExplicitClickable(driver, b);
//			b.click();
//			String handle = driver.getWindowHandle();
//			for (String handle1 : driver.getWindowHandles()) {
//				if (!handle1.equalsIgnoreCase(handle)) {
//					driver.switchTo().window(handle1);
//				}
//			}
//			UtilHBM.waitFixTime(2000);
//			switch (site) {
//
//			case "Facebook":
//				UtilHBM.waitExplicitDisplayed(driver,
//						UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink"));
//				Verification.VerifyEquals("Wrong Header for Facebook",
//						UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink").getText(), "Facebook");
//				if (driver.getCurrentUrl().contains("facebook")) {
//					UtilHBM.reportOK("Facebook link verified");
//				} else {
//					UtilHBM.reportKO("Facebook link not opened");
//				}
//				break;
//
//			case "Twitter":
//				UtilHBM.waitExplicitDisplayed(driver,
//						UtilHBM.webElementXPath(driver, "//body/div[@id='bd']/h2[@class='action-information']"));
//				Verification.VerifyEquals("Wrong text displayed for Twitter", UtilHBM
//						.webElementXPath(driver, "//body/div[@id='bd']/h2[@class='action-information']").getText(),
//						"Share a link with your followers");
//				if (driver.getCurrentUrl().contains("twitter")) {
//					UtilHBM.reportOK("Twitter link verified");
//				} else {
//					UtilHBM.reportKO("Twitter link not opened");
//				}
//				break;
//
//			case "Pinterest":
////				 UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver,"//h3[.='Log in to see more']"));
////				 Verification.VerifyEquals("Wrong text displayed for Pinterest",UtilHBM.webElementXPath(driver, "//h3[.='Log in to see more']").getText(),"Log in to see more");
//				if (driver.getCurrentUrl().contains("pinterest")) {
//					UtilHBM.reportOK("Pinterest link verified");
//				} else {
//					UtilHBM.reportKO("Pinterest link not opened");
//				}
//				break;
//
//			case "Email":
//				if (driver.getCurrentUrl().contains("addthis")) {
//					UtilHBM.reportOK("Email link verified");
//					UtilHBM.waitExplicitDisplayed(driver, emailAFriendTitle);
//					Verification.displayOfWebElement(emailProjectTitle);
//					Verification.displayOfWebElement(emailProjectURL);
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-to").sendKeys("toexample@abc.com");
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-from").sendKeys("fromexample@abc.com");
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-note").sendKeys("Example note");
////					 Verification.VerifyEquals("Wrong Recaptcha text",UtilHBM.webElement(driver, "#recaptcha-anchor-label").getText(), "I'm not a robot");
//				} else {
//					UtilHBM.reportKO("Email link not opened");
//				}
//				break;
//			}
//			driver.close();
//			driver.switchTo().window(handle);
//		}
//		return this;
//	}

/*
	public ProjectPage deleteMediaMDM(String filterMediaText, int mediaIndex, String deleteActionYesOrNo) {
		imagesTab.click();
		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
		verifyMediaCount("Yes");
		filterMedia(filterMediaText, "Yes");
		int beforeDelete = getMediaCount("Yes");
		if (beforeDelete < mediaIndex) {
			UtilHBM.reportKO("Media of Index no." + mediaIndex
					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
					+ " are " + beforeDelete);
		}
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement deleteButton1 = mediaList.get(mediaIndex - 1).findElement(
				By.xpath("ul[@class='media-actions']/li/a/span[@class='icon icon-trash u-fs16']/../.."));
		UtilHBM.waitExplicitDisplayed(driver, deleteButton1);
		UtilHBM.waitExplicitClickable(driver, deleteButton1);
		Verification.displayOfWebElement(deleteButton1);
		deleteButton1.click();
		UtilHBM.waitExplicitClickable(driver, deleteMediaNo);
		Verification.displayOfWebElement(deleteMediaNo);
		Verification.displayOfWebElement(deleteMediaYes);
		Verification.VerifyEquals("Wrong delete dialog box text", deleteDialogBoxText.getText(),
				"Are you sure you want to delete this media?");
		UtilHBM.reportInfo("Delete media decision :" + deleteActionYesOrNo);
		if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
			deleteMediaYes.click();
			UtilHBM.waitFixTime(1000);
			filterMedia(filterMediaText, "Yes");
			int noOfMediasAfterDeletion = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfterDeletion + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count(Navigation bar) before deletion : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after deletion : "
						+ noOfMediasAfterDeletion);
			} else {
				UtilHBM.reportKO(
						"Media not deleted!!Media count(Navigation bar) before deletion : " + noOfMediasBeforeDeletion
								+ " , Media count(Navigation bar) after deletion : " + noOfMediasAfterDeletion);
			}
			int afterDelete = getMediaCount("Yes");
			if (beforeDelete == afterDelete + 1) {
				UtilHBM.reportOK("Media deleted successfully!!Media count before deletion : " + beforeDelete
						+ " , Media count after deletion : " + afterDelete);
			} else {
				UtilHBM.reportKO("Media not deleted!!Media count before deletion : " + beforeDelete
						+ " , Media count after deletion : " + afterDelete);
			}
		} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
			deleteMediaNo.click();
			filterMedia(filterMediaText, "Yes");
			UtilHBM.waitFixTime(1000);
			int noOfMediasAfter = Integer.parseInt(mediaCount.getText());
			if (noOfMediasBeforeDeletion == noOfMediasAfter) {
				UtilHBM.reportOK("Media count(Navigation bar) before : " + noOfMediasBeforeDeletion
						+ " , Media count(Navigation bar) after : " + noOfMediasAfter);
			} else {
				UtilHBM.reportKO("Different Media counts than earlier!!Media count(Navigation bar) before : "
						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after : " + noOfMediasAfter);
			}
			int afterDelete = getMediaCount("Yes");
			if (beforeDelete == afterDelete) {
				UtilHBM.reportOK("Media count before : " + beforeDelete + " , Media count after : " + afterDelete);
			} else {
				UtilHBM.reportKO("Different Media counts than earlier!!Media count before : " + beforeDelete
						+ " , Media count after : " + afterDelete);
			}
		}
		filterMedia("All Medias", "Yes").verifyMediaCount("Yes");
		return this;
	}
*/	

	public ProjectPage shareProjectMDM() {
		clickShareProjectButton();	
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-facebook u-fs24']/..")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-facebook u-fs24']/..")));
		WebElement shareFacebook = driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-facebook u-fs24']/.."));
		WebElement shareTwitter = driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-twitter u-fs24']/.."));
		WebElement sharePinterest = driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-pinterest u-fs24']/.."));
		WebElement shareEmail = driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-email u-fs24']/.."));
		WebElement shareEmbedded=driver.findElement(By.xpath("//ul[@id='project-header-actions']/li/div[@class='shareBox shareBox--open']/div/a/i[@class='icon icon-embed u-fs24']/.."));
		Verification.displayOfWebElement(shareFacebook.findElement(By.tagName("i")));
		Verification.displayOfWebElement(shareTwitter.findElement(By.tagName("i")));
		Verification.displayOfWebElement(sharePinterest.findElement(By.tagName("i")));
		Verification.displayOfWebElement(shareEmail.findElement(By.tagName("i")));
		Verification.displayOfWebElement(shareEmbedded.findElement(By.tagName("i")));
		UtilHBM.waitExplicitClickable(driver, shareFacebook);
		ArrayList<WebElement> shareOptions = new ArrayList<WebElement>();
		shareOptions.add(shareFacebook);
		shareOptions.add(shareTwitter);
		shareOptions.add(sharePinterest);
//		shareOptions.add(shareEmail);
		shareOptions.add(shareEmbedded);
		for (WebElement b : shareOptions) {
			clickShareProjectButton();
			String site = b.getAttribute("title");
			UtilHBM.waitExplicitClickable(driver, b);
			b.click();
			String handle=null;
			if (!site.equalsIgnoreCase("Pinterest")) {
				handle = driver.getWindowHandle();
				for (String handle1 : driver.getWindowHandles()) {
					if (!handle1.equalsIgnoreCase(handle)) {
						driver.switchTo().window(handle1);
					}
				}
			}
			UtilHBM.waitFixTime(2000);
			switch (site) {
			case "Facebook":
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink"));
				Verification.VerifyEquals("Wrong Header for Facebook",UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink").getText(), "Facebook");
				if (driver.getCurrentUrl().contains("facebook")) {
					UtilHBM.reportOK("Facebook link verified");
				} else {
					UtilHBM.reportKO("Facebook link not opened");
				}
				break;

			case "Twitter":
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//span[.='Want to log in first?']"));
				if (driver.getCurrentUrl().contains("twitter")) {
					UtilHBM.reportOK("Twitter link verified");
				} else {
					UtilHBM.reportKO("Twitter link not opened");
				}
				break;

			case "Email":
				UtilHBM.waitFixTime(1000);
				if (!emailIframe.isEmpty()) {
					driver.switchTo().frame(emailIframe.get(0));
					UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call")));
					WebElement acceptCookies = driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call"));
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					acceptCookies.click();
					driver.switchTo().parentFrame();
				}
				if (driver.getCurrentUrl().contains("addthis")) {
					UtilHBM.reportOK("Email link verified");
					UtilHBM.waitExplicitDisplayed(driver, emailAFriendTitle);
					Verification.displayOfWebElement(emailProjectTitle);
					Verification.displayOfWebElement(emailProjectURL);
					UtilHBM.webElement(driver, "#at-expanded-menu-email-to").sendKeys("toexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-from").sendKeys("fromexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-note").sendKeys("Example note");
//					Verification.VerifyEquals("Wrong Recaptcha text",UtilHBM.webElement(driver, "#recaptcha-anchor-label").getText(), "I'm not a robot");
				} else {
					UtilHBM.reportKO("Email link not opened");
				}
				break;	
				
	
			case "Pinterest":
				UtilHBM.waitFixTime(1000);
				WebElement iframe1 = driver.findElement(By.xpath("//iframe[contains(@src,'https://assets.pinterest.com')]"));
				driver.switchTo().frame(iframe1);
				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#choosePin"));	
				Verification.VerifyEquals("Wrong Pinterrest message",UtilHBM.webElement(driver, "#choosePin").getText(),"Choose a Pin to save");

				new Actions(driver).moveToElement(UtilHBM.webElement(driver, "#ct>span:nth-child(2)")).build().perform();
				UtilHBM.waitFixTime(1000);
				UtilHBM.webElement(driver, "#ct>span:nth-child(2)>span").click();
				handle = driver.getWindowHandle();
				for (String handle1 : driver.getWindowHandles()) {
					if (!handle1.equalsIgnoreCase(handle)) {
						driver.switchTo().window(handle1);
					}
				}
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//h3[.='Log in to see more']"));
//				Verification.VerifyEquals("Wrong text displayed for Pinterest",UtilHBM.webElementXPath(driver, "//h3[.='Log in to see more']").getText(),"Log in to see more");
				if (driver.getCurrentUrl().contains("pinterest")) {
					UtilHBM.reportOK("Pinterest link verified");
				} else {
					UtilHBM.reportKO("Pinterest link not opened");
				}
				break;

			case "Embed":
				ShareEmbedDialog embedProject = PageFactory.initElements(driver, ShareEmbedDialog.class);
				embedProject.verifyEmbedProjectMDM();
				break;
			}
			if (!site.equalsIgnoreCase("Embed")) {
				driver.close();
				driver.switchTo().window(handle);
			}
		}
		return this;
	}
	
	public MyProjects goToMyProjects() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,myProjects);
		UtilHBM.waitExplicitClickable(driver,myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public LandingPage logout(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver,userAvatar);
		Actions action = new Actions(driver);			
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, logout);
		logout.click();
//		action.moveToElement(logout).click().build().perform();	
		UtilHBM.reportOK("Logout success");					
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public ProjectPage logoutAndReopenProjectPage() {
		logout();
		driver.navigate().back();
		driver.navigate().refresh();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	
/*---------------------Following methods are used for mobile automation---------------------*/

	public ProjectPage verifyOverviewTabMobile(String projectOwnership, int noOfFloors, int noOfRooms, String area,
			int noOfBedrooms, int noOfBathrooms, int noOfShoppedProducts, int totalMediaCount, boolean isDuplicated) {
		UtilHBM.reportInfo("Verifying project link :" + driver.getCurrentUrl());
		UtilHBM.turnOffImplicitWaits(driver);
		if (projectOwnership.equalsIgnoreCase("own")) {
			Verification.displayOfWebElement(subHeaderProjectTime);
			if (projectActions.size() == 2) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed!!!No of project actions displayed : "
						+ projectActions.size());
			}
			List<WebElement> own = new ArrayList<>();
			own.add(shareProjectButton);
			own.add(immersiveViewButton);
			for (WebElement a : own) {
				Verification.displayOfWebElement(a);
			}
		} else if (projectOwnership.equalsIgnoreCase("others")) {
			if (projectActions.size() == 2) {
				UtilHBM.reportOK("No. of project actions displayed is correct!!!");
			} else {
				UtilHBM.reportKO("Incorrect no of project actions displayed!!!No of project actions displayed : "
						+ projectActions.size());
			}
			List<WebElement> others = new ArrayList<>();
			others.add(shareProjectButton);
			others.add(immersiveViewButton);
			for (WebElement b : others) {
				Verification.displayOfWebElement(b);
			}
		} else {
			UtilHBM.reportKO("Wrong input for projectOwnership!!!");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		 clickShareProjectButton()
		 .verifyShareContainerMobile("project")
		 .closeShareContainer()
		 ;
		if (projectInfo.size() == 8) {
			UtilHBM.reportOK("No. of project details displayed in details bar is correct!!!");
		} else {
			UtilHBM.reportKO("Incorrect no of project details displayed in details bar!!!No of project details displayed : "
					+ projectInfo.size());
		}
	
		Verification.displayOfWebElement(noOfFloorsIcon);
		Verification.displayOfWebElement(noOfRoomsIcon);
		Verification.displayOfWebElement(surfaceAreaIcon);
		Verification.displayOfWebElement(noOfBedroomsIcon);
		Verification.displayOfWebElement(noOfBathroomsIcon);
		if (noOfFloors1.getText().contains("floor") && noOfRooms1.getText().contains("room")
				&& (surfaceArea1.getText().contains("m") || surfaceArea1.getText().contains("ft"))
				&& noOfBedrooms1.getText().contains("bedroom") && noOfBathrooms1.getText().contains("bathroom")) {
			UtilHBM.reportOK("Project Details Bar is Displayed");
		} else {
			UtilHBM.reportKO("Wrong detail titles displayed in details bar in project page");
		}
//		if (noOfShoppedProducts != 0) {
//			int noOfItemsShopped = Integer.parseInt(productsTab.getText()
//					.substring(productsTab.getText().indexOf("(") + 1, (productsTab.getText().indexOf(")"))));
//			if (noOfItemsShopped == noOfShoppedProducts) {
//				UtilHBM.reportOK("noOfShoppedProducts displayed correctly in tab headers!!");
//			} else {
//				UtilHBM.reportKO(
//						"noOfShoppedProducts displayed incorrectly in tab headers!!noOfShoppedProductsAvailable : "
//								+ noOfItemsShopped + "noOfShoppedProductsExpected : " + noOfShoppedProducts);
//			}
//		} else if (!productsTabList.isEmpty()) {
//			UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
//		}
//		if (totalMediaCount != 0) {
//			int noOfMedias = Integer.parseInt(imagesTab.getText().substring(imagesTab.getText().indexOf("(") + 1,
//					(imagesTab.getText().indexOf(")"))));
//			if (noOfMedias == totalMediaCount) {
//				UtilHBM.reportOK(" totalMediaCount displayed correctly in tab headers!!");
//			} else {
//				UtilHBM.reportKO("totalMediaCount displayed incorrectly in tab headers!! totalMediaCountAvailble : "
//						+ noOfMedias + ", totalMediaCountExpected : " + totalMediaCount);
//			}
//		} else if (!imagesTabList.isEmpty()) {
//			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
//		}

		if (!isDuplicated) {
//			checkImagesInAboutMobile(totalMediaCount);
		} else {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!sliderNextButton.isEmpty()) {
				UtilHBM.reportKO("Slider button available for images in overview page & Project is duplicated project!!");
			}
			UtilHBM.turnOnImplicitWaits(driver);
		}
//		verifyProjectDetails(noOfFloors, noOfRooms, area, noOfBedrooms, noOfBathrooms)
//		.0verifyColorPalette(noOfFloors,noOfRooms, noOfBedrooms, noOfBathrooms);
//		.verifyAllSurfaces(projectOwnership,noOfFloors, noOfRooms, area, noOfBedrooms, noOfBathrooms)
//		.verifyFeaturedProducts(noOfShoppedProducts);

		if (turnTableImg.isEmpty()) {
			UtilHBM.reportKO("TurnTable not Generated");
		} else if (turnTableImg.get(0).getAttribute("src").startsWith("https://byme")
				&& turnTableImg.get(0).getAttribute("src").endsWith(".jpg")) {
			UtilHBM.reportOK("TurnTable Generated");
		}

		if (descriptionText.isEmpty()) {
			UtilHBM.reportInfo("Description Not available");
		} else {
			Verification.displayOfWebElement(descriptionBuildingText);
			Verification.displayOfWebElement(constructionBuildingText);
			Verification.displayOfWebElement(projectDescription);
		}
		if (tagsText.isEmpty()) {
			UtilHBM.reportInfo("Tags Not available");
		} else {
			for (WebElement a : tagsList) {
				Verification.displayOfWebElement(a);
			}
		}
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage checkImagesInOverviewMobile(int noOfMedias) {
		if (noOfMedias != 0) {
			if (!(sliderNextButton.isEmpty())) {
				UtilHBM.reportInfo("Checking featured images in overview tab for project");
				sliderNextButton.get(0).click();
				UtilHBM.waitFixTime(1000);
				String previousImgSrc = null;
				UtilHBM.waitExplicitDisplayed(driver, sliderNextButton.get(0));
//				UtilHBM.reportInfo(BulletsAvailable + " images displayed in featured images in overview page.");
//				for (int i = 0; i < BulletsAvailable - 1; i++) {
//					UtilHBM.waitFixTime(1000);
//					String currntImgSrc = sliderCurrentImage.getAttribute("src");
//					if (currntImgSrc.equals(previousImgSrc)) {
//						UtilHBM.reportKO("Sliderimage not changed");
//					} else {
//						UtilHBM.reportOK("Sliderimage changed");
//					}
//					previousImgSrc = currntImgSrc;
//					sliderNextButton.get(0).click();
//				}
				sliderNextButton.get(0).click();
			} else {
				UtilHBM.reportKO("Slider Button or image bullets not available");
			}
		} else {
			UtilHBM.reportInfo("Number of medias : " + noOfMedias);
			if (sliderNextButton.isEmpty()) {
				UtilHBM.reportOK("Media Tab & Slider Button in overview tab are not available");
				if (turnTableImg.get(0).getAttribute("src").startsWith("https://byme")
						&& turnTableImg.get(0).getAttribute("src").endsWith(".jpg")) {
					UtilHBM.reportOK("TurnTable Generated");
				} else if (turnTableImg.isEmpty()) {
					UtilHBM.reportKO("TurnTable not Generated");
				}
			} else {
				UtilHBM.reportKO("Slider Button or image bullets available and Media tab is not available");
			}
		}
		return this;
	}
	
	public ProductInfo goToProductsTabMobile() {
		UtilHBM.waitExplicitClickable(driver, naviagationDropdownMobile);
		naviagationDropdownMobile.click();
		UtilHBM.waitExplicitClickable(driver, productsTab);
		UtilHBM.waitExplicitDisplayed(driver, productsTab);
		productsTab.click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public ProjectPage goToOverviewTabMobile() {
		driver.findElement(By.cssSelector(".projectNav>.wrapper>#pull")).click();
		UtilHBM.waitExplicitClickable(driver, overviewTab);
		overviewTab.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage goToImagesTabMobile() {
		UtilHBM.waitExplicitClickable(driver, naviagationDropdownMobile);
		naviagationDropdownMobile.click();
		UtilHBM.waitExplicitClickable(driver, imagesTab);
		UtilHBM.waitExplicitDisplayed(driver, imagesTab);
		imagesTab.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public ProjectPage verifyMediaPageMobile(String projectOwnership, int noOfSnpshots, int noOfSnapshotHQ,int noOfPanoramic) {
		int totalMediaCount = noOfSnpshots + noOfSnapshotHQ + noOfPanoramic;
		if (totalMediaCount != 0) {
			verifyMediaGeneratedMobile(noOfSnpshots, noOfSnapshotHQ, noOfPanoramic);
			goToMediaType("All Medias",false);
			verifyMediaCountMobile("No");
			Select select = new Select(mediaFilter);
			Verification.VerifyEquals("All medias filter is not selected initially in media page!!", select.getFirstSelectedOption().getText(), "All Medias");
			List<String> filterOptions = Arrays.asList("All Medias", "Screenshots", "Realistic images", "360° Images");
			int AllMediaCount = 0;
			for (String a : filterOptions) {
				select.selectByVisibleText(a);
				UtilHBM.waitFixTime(2000);
				if (getMediaCount(false)==0) {
					UtilHBM.reportInfo("No media displayed in " + a);
				} else {
					UtilHBM.waitFixTime(3000);
					int mediaCount = getMediaCount(false);
					UtilHBM.reportInfo("No. of medias in " + a + " :\t" + mediaCount);
					if (a.equalsIgnoreCase("All Medias")) {
						if (mediaCount == totalMediaCount) {
							UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
						} else {
							UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
									+ totalMediaCount + ", Medias displayed : " + mediaCount);
						}
						AllMediaCount = mediaCount;
					} else {
						AllMediaCount = AllMediaCount - mediaCount;
						switch (a) {
						case "Screenshots":
							if (noOfSnpshots == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnpshots) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnpshots + ", Medias displayed : " + mediaCount);
							}
							break;

						case "Realistic images":
							if (noOfSnapshotHQ == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfSnapshotHQ) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfSnapshotHQ + ", Medias displayed : " + mediaCount);
							}
							break;

						case "360° Images":
							if (noOfPanoramic == 0) {
								UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
										noMediaToDisplayText.getText(), "No media to display !");
							} else if (mediaCount == noOfPanoramic) {
								UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
							} else {
								UtilHBM.reportKO(
										"Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
												+ noOfPanoramic + ", Medias displayed : " + mediaCount);
							} 
							break;
						
						default:
							UtilHBM.reportInfo("Wrong media type!!!");
							break;

						}
//						Remove comment after adding new media page for mobile
//						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
//								verifyCopyToClipbioardMobile("media");
//						}
						UtilHBM.waitFixTime(2000);
						new Actions(driver).moveToElement(mediaList.get(0)).build().perform();
						WebElement shareButton1 = driver.findElement(By.xpath(
								"//div[@class='media'][1]/div/ul[@class='media-actions']/li/span/i[@class='icon icon-share u-fs16']/parent::span[@title='Share']/.."));
						UtilHBM.waitExplicitDisplayed(driver, shareButton1);
						UtilHBM.waitExplicitClickable(driver, shareButton1);
						if (projectOwnership.equalsIgnoreCase("own")) {
							WebElement deleteButton1 = driver.findElement(By.xpath(
									"//div[@class='media'][1]/div/ul[@class='media-actions']/li/span/span[@class='icon icon-trash u-fs16']/../.."));
							Verification.displayOfWebElement(deleteButton1);
						}

						WebElement downloadButton = driver.findElement(By.xpath(
								"//div[@class='media'][1]/div/ul[@class='media-actions']/li/span/i[@class='icon icon-download u-fs16']/../.."));
						UtilHBM.waitExplicitDisplayed(driver, downloadButton);
						Verification.displayOfWebElement(downloadButton);

						Verification.displayOfWebElement(shareButton1);
						clickShareMediaButtonMobile(1).verifyShareContainerMobile("media").closeShareContainer();
						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
							openMediaInFullscreenMobile(1).verifyFullscreenMediaMobile(projectOwnership, a, mediaCount);
						}
//						mediaList.get(0).findElement(By.cssSelector(".media-thumb-link.trigger-overlay-slider")).click();								
//						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
//							UtilHBM.waitExplicitDisplayed(driver,fullScrnImg);
//							Verification.displayOfWebElement(fullScrnImg);							
//							WebElement shareButton11=driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-share u-fs20']/.."));
//							UtilHBM.waitExplicitDisplayed(driver, shareButton11);
//							UtilHBM.waitExplicitClickable(driver, shareButton11);
//							if (projectOwnership.equalsIgnoreCase("own")) {
//								WebElement deleteButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-trash u-fs20']/../.."));
//								Verification.displayOfWebElement(deleteButton11);
//							}
//							WebElement downloadButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-download']/../.."));
//							UtilHBM.waitExplicitDisplayed(driver, downloadButton11);
//							Verification.displayOfWebElement(downloadButton11);
//							Verification.displayOfWebElement(shareButton11);	
//							shareButton11.click();
//							UtilHBM.waitFixTime(1000);
//							ShareContainer shareContainer=PageFactory.initElements(driver, ShareContainer.class);
//							shareContainer.verifyShareContainer("media").closeShareContainer();
//						}	
//						if (mediaCount > 1) {
//							UtilHBM.waitExplicitDisplayed(driver, sliderNext);
//							Verification.displayOfWebElement(sliderNext);
//							UtilHBM.waitExplicitDisplayed(driver, sliderPrevious);
//							Verification.displayOfWebElement(sliderPrevious);
//						}
//						closeFullScreenMedia.click();
//						UtilHBM.waitTillElementDisappear(driver, closeFullScreenMedia);
					}
				}
			}
			if (AllMediaCount == 0) {
				UtilHBM.reportOK("Total no. of medias displayed is correct");
			} else {
				UtilHBM.reportKO("Total no. of medias displayed is incorrect");
			}
			goToOverviewTabMobile();
		} else if (!imagesTabList.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
		}
			return this;
	}
	
	public ProjectPage verifyMediaGeneratedMobile(int noOfSnpshots, int noOfSnapshotHQ, int noOfPanoramic) {
		goToImagesTabMobile();
		List<String> filterOptions = Arrays.asList("Screenshots", "Realistic images", "360° Images");
		for (String a : filterOptions) {
			goToMediaType(a, false);
			UtilHBM.waitFixTime(2000);
			int noOfImages = imageList.size();
			switch (a) {
			case "Screenshots":
				if (noOfSnpshots == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfSnpshots) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfSnpshots + ", Medias displayed : " + noOfImages);
				}
				break;

			case "Realistic images":
				if (noOfSnapshotHQ == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfSnapshotHQ) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfSnapshotHQ + ", Medias displayed : " + noOfImages);
				}
				break;

			case "360° Images":
				if (noOfPanoramic == 0) {
					UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
					Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a, noMediaToDisplayText.getText(),
							"No media to display !");
				} else if (noOfImages == noOfPanoramic) {
					UtilHBM.reportOK("Correct no of medias displayed with filter " + a);
				} else {
					UtilHBM.reportKO("Incorrect no of medias displayed with filter " + a + "!!,Medias expected : "
							+ noOfPanoramic + ", Medias displayed : " + noOfImages);
				}
				break;
			}
			new Actions(driver).moveToElement(imageList.get(noOfImages - 1)).build().perform();
			UtilHBM.reportInfo("Number of images in " + a + " : " + noOfImages);
			for (int i = 1; i <= noOfImages; i++) {
				String src = imageList.get(i - 1).getAttribute("src");
				String alt = imageList.get(i - 1).getAttribute("alt");
				if (src.contains("https:") && alt.contains("image") && !(src.contains("placeholder")) 
						&& (src.contains(".jpg") || src.contains(".png"))) {
					UtilHBM.reportOK(a + " " + i + " generated!!");
				} else if (alt.contains("placeholder")) {
					UtilHBM.reportKO(a + " no.: " + i + " not generated!!");
				}
			}
		}
		return this;

	}

	ProjectPage verifyMediaCountMobile(String isMdmOrNot) {
		String mediaTitleText = naviagationDropdownMobile.getText();
		int noOfMedias = Integer
				.parseInt(mediaTitleText.substring(mediaTitleText.indexOf("(") + 1, mediaTitleText.indexOf(")")));
//		if (getMediaCount(isMdmOrNot) == noOfMedias) {
//			UtilHBM.reportOK("No of Images in Media tab are same as No of Media Generated.");
//		} else {
//			UtilHBM.reportKO(
//					"No of Images in Media tab are not same as No of Media Generated. Media count is in tab text is: "
//							+ mediaCount.getText() + "count of media is: " + getMediaCount(isMdmOrNot));
//		}
		return this;
	}

	
	public ProjectPage verifyCopyToClipbioardMobile(String mediaOrProject) {
		new Actions(driver).moveToElement(mediaList.get(0)).build().perform();						
		clickShareMediaButtonMobile(1).shareMediaByCopyLinkMobile(mediaOrProject);
		return this;
	}
	
	ShareContainer clickShareMediaButtonMobile(int mediaIndex) {
		WebElement shareButton1=driver.findElement(By.xpath("//div[@class='media']["+mediaIndex+"]/div/ul[@class='media-actions']/li/span/i[@class='icon icon-share u-fs16']/parent::span[@title='Share']/.."));
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		shareButton1.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	public FullscreenMedia openMediaInFullscreenMobile(int mediaIndex) {
		WebElement expectedMedia = driver.findElement(By.xpath(
				"//div[@class='media'][" + mediaIndex + "]/div/*[contains(@class,'media-thumb-link trigger-overlay-slider')]/img"));
		UtilHBM.waitExplicitDisplayed(driver, expectedMedia);
		UtilHBM.waitExplicitClickable(driver, expectedMedia);
		new Actions(driver).moveToElement(expectedMedia).build().perform();	
		expectedMedia.click();
		return PageFactory.initElements(driver, FullscreenMedia.class);
	}

	
	public ProjectPage verifyProductsTabMobile(int noOfShoppedProducts) {
//		clickCheckOutAllProductsMobile()
//		.checkProductList(noOfShoppedProducts)
//		.goToOverviewTabMobile()
//		.goToProductsTabMobile()
//		.checkProductsMobile();
//		if (noOfShoppedProducts == 0) {
//			if (!productsTabList.isEmpty()) {
//				UtilHBM.reportKO("products tab displayed!!!Shopped product count : 0");
//			}
//		} else {
//			goToProductsTabMobile().checkProductList(noOfShoppedProducts).checkShoppingTabProducts().goToAboutTab();
//		}
		return this;
	}
	
	public ProjectPage clickCheckOutAllProductsMobile() {
		UtilHBM.waitExplicitClickable(driver, checkOutAllProductsMobile);
		checkOutAllProductsMobile.click();
		
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage clickColorPaletteMobile() {
		UtilHBM.waitExplicitClickable(driver, colorPaletteMobile);
		colorPaletteMobile.click();
		return this;
	}
	
	public HeaderMenusMobile clickHeaderMenuMobile() {
//		headerMenuMobile.click();
		new Actions(driver).moveToElement(headerMenuMobile, 0, 10).click().build().perform();
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}
	
	public ProjectPage closeNewOfferPopin(){
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='popin-content-medium']/div[@class='-close']");
		UtilHBM.webElementXPath(driver, "//div[@class='popin-content-medium']/div[@class='-close']").click();
		UtilHBM.waitFixTime(500);
		return this;
	}
	
}

