package kitchen.bryo.pageObject;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class TwoDPlansAndImagesCheck {
	WebDriver driver;

	public TwoDPlansAndImagesCheck(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@data-ui-selector='project-plans']/div[@class='empty-section']/p[contains(.,'You have not created any 2D plans of your project.')]")
	private List<WebElement> emptyPlans;

	@FindBy(xpath = "//div[@data-ui-selector='project-images-empty']/div[@class='empty-section']/p[contains(.,'You have not created any images of your project.')]")
	private List<WebElement> emptyImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Worktop')]")
	private List<WebElement> worktopPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Wall Panel')]")
	private List<WebElement> wallPanelPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'TopPlan')]")
	private List<WebElement> topPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'FacePlan')]")
	private List<WebElement> facePlanImages;

//	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[contains(@src,'project-overview-placeholder.jpg')]")
//	private List<WebElement> inProgressImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div/div[@class='img-container']")
	private List<WebElement> imageContainerList;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@data-ui-status='unavailable']/div[@class='img-container']/span/*[local-name()='svg'][@class='icon-action-360-render']/../following-sibling::img[contains(@src,'https://byme-enterprise-preprod')]")
	private List<WebElement> inProgress360Image;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@data-ui-status='unavailable']/div[@class='img-container']/span/*[local-name()='svg'][@class='icon-function-hq-render']/../following-sibling::img[contains(@src,'https://byme-enterprise-preprod')]")
	private List<WebElement> inProgressHQImage;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@data-ui-status='available']/div[@class='img-container']/span/*[local-name()='svg'][@class='icon-action-360-render']/../following-sibling::img[contains(@src,'https://byme-enterprise-preprod')]")
	private List<WebElement> generated360Image;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@data-ui-status='available']/div[@class='img-container']/span/*[local-name()='svg'][@class='icon-function-hq-render']/../following-sibling::img[contains(@src,'https://byme-enterprise-preprod')]")
	private List<WebElement> generatedHQImage;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[starts-with(@src,'https')]")
	private List<WebElement> snapShotCount;

	@FindBy(xpath = "//div[@class='project-plans']/div/button/span")
	private WebElement twoDPlanToggle;

	@FindBy(xpath = "//div[@class='project-plans']/div/h3")
	private WebElement twoDPlanHdr;

	@FindBy(xpath = "//div[@class='project-images']/div/button")
	private WebElement imagesToggle;

	@FindBy(xpath = "//div[@class='project-images']/div/h3")
	private WebElement imagesHdr;

	@FindBy(xpath = "//div[@class='empty-section-plan']/span[@class='icon-tools-plan']")
	private WebElement planToolsIcon;

	@FindBy(xpath = "//div[@class='empty-section-picture']/span[@class='icon-tools-picture']")
	private WebElement pictureToolsIcon;

	@FindBy(xpath = "//div[@class='empty-section-plan']/div/p[@data-i18n='media_list.plan2D_not_found']")
	private WebElement plan2DNotFoundText;

	@FindBy(xpath = "//div[@class='empty-section-picture']/div/p[@data-i18n='media_list.images_not_found']")
	private WebElement imagesNotFoundText;

	@FindBy(xpath = "//div[@class='empty-section-picture']/div/button[@data-ui-action='create-media-action']")
	private WebElement createOneButton;

	@FindBy(xpath = "//div[@class='img-container']/div[@class='img-container-inner']/img")
	private List<WebElement> twoDPlansAndImages;

	@FindBy(xpath = "//div[@class='show-all-images-tile']/button[@data-i18n='kitchen.index.showImages;planner.index.showImages'][contains(text(),'Show images')]")
	private WebElement showImagesButton;

	@FindBy(xpath = "//article[@class='mod-layer-project-medias mod-open']/div/main/header/div/div/button[@data-ui-action='layer-close']")
	private WebElement close2DPlanAndImageLayer;

	@FindBy(xpath = "//button[@class='bt-next-round']")
	private List<WebElement> sliderNavigationNextButton;

	@FindBy(xpath = "//button[@class='bt-prev-round']")
	private List<WebElement> sliderNavigationPreviousButton;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/header/button[@class='bt-back']")
	private WebElement backButton;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/header/button[@data-ui-action='layer-close']")
	private WebElement cancelFullScreen;

	@FindBy(xpath = "//article[@class='mod-layer-project-medias mod-open']/div/main/header/div/div/h3")
	private WebElement title;

	@FindBy(xpath = "//article[@class='mod-layer-project-medias mod-open']/div/main/div/div/div/div[@class='project-images']/div/div[@class='empty-section-picture']/p")
	private WebElement emptyImageSection;

	@FindBy(xpath = "//div[@class='img-container']/div[@class='img-container-inner-picture-loader']/span[@class='icon-action-reload']")
	private WebElement inProgressLoader;

	@FindBy(xpath = "//div[@data-ui-media-type='HQRendering']/div[@class='img-container']/span[@class='bt-icon-circle']")
	private WebElement hqImageCircleIcon;

	@FindBy(xpath = "//div[@class='img-container']/div[@class='img-container-inner-picture-loader']/span[@class='icon-action-reload']/following-sibling::span")
	private WebElement inProgressMessage;

	@FindBy(xpath = "//ul/li/a[@data-ui-action='media-download']/span[@class='icon-action-download']")
	private WebElement download;

	public MakeItHappen showImages() {
		Verification.displayOfWebElement(showImagesButton);
		UtilHBM.waitExplicitClickable(driver, showImagesButton);
		UtilHBM.waitFixTime(3000);
		showImagesButton.click();
		driver.switchTo().frame(UtilHBM.webElement(driver,
				"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/Medias/embed.html']"));
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen close2DplanAndImagesLayer() {

		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitClickable(driver, close2DPlanAndImageLayer);
		close2DPlanAndImageLayer.click();
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, showImagesButton);
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public TwoDPlansAndImagesCheck verifyProjectImages(int noOf360Images, int noOfHQImages) {
		UtilHBM.waitExplicitDisplayed(driver, title);
		Assert.assertEquals(title.getText(), "Images & 2D Plans", "Title not correct");
		toggleImagesSection();
		if (noOf360Images + noOfHQImages == 0) {
			Verification.displayOfWebElement(emptyImageSection);
			Verification.VerifyEquals("Image text not correct", emptyImageSection.getText(),
					"You have not created any images of your project. To create one, go back to the ”Design your kitchen” step.");
		} else {
			int renderImagesCount = inProgress360Image.size() + inProgressHQImage.size() + generated360Image.size()
					+ generatedHQImage.size();

			if (renderImagesCount == noOf360Images + noOfHQImages) {
				UtilHBM.reportOK(
						"Correct number of medias displayed and number of render(generated+in progress) images are "
								+ renderImagesCount);

				if (inProgress360Image.size() > 0) {
					UtilHBM.reportInfo("360 rendering image is in progress and number of images in progress are :"
							+ inProgress360Image.size());
				}
				if (inProgressHQImage.size() > 0) {
					UtilHBM.reportInfo("HQ rendering image is in progress and number of images in progress are :"
							+ inProgressHQImage.size());
//					List<WebElement> inProgressImg = driver
//							.findElements(By.xpath("//div[@class='img-container']/div[@data-ui-action='media-img-clicked']/img[contains(@src,'.jpg')]"));
					int inProgressListSize = inProgressHQImage.size();
					if (inProgressListSize == noOfHQImages) {
						for (int i = 0; i < inProgressListSize; i++) {
							UtilHBM.waitExplicitDisplayed(driver, inProgressLoader);
							Verification.VerifyEquals("HQ image circle icon not distinguishable...",
									hqImageCircleIcon
											.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
											.getAttribute("xlink:href"),
									"/Shared/icons/icons.svg#icon-function-hq-render");
							Verification.VerifyEquals("In progress loader icon not distinguishable...",
									inProgressLoader
											.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
											.getAttribute("xlink:href"),
									"/Shared/icons/icons.svg#icon-action-reload");
							Verification.VerifyEquals("Verification for rendering in progress failed ",
									inProgressMessage.getText(), "Rendering in progress");
							WebElement currentImg = inProgressHQImage.get(i);
							String imgSrc = currentImg.getAttribute("src");
							System.out.println("img SRC: " + imgSrc);
							Actions action = new Actions(driver);
							action.moveToElement(currentImg).click().build().perform();

							UtilHBM.waitExplicitDisplayed(driver, inProgressHQImage.get(0));
						}
					} else
						UtilHBM.reportKO("Incorrect number of image in progress:" + inProgressListSize);
				}
				if (generated360Image.size() > 0) {
					if ((driver.findElement(
							By.xpath("//div[@class='project-images']/div/div/div[@class='img-container']/img")))
									.getAttribute("src").contains(".jpg")) {
						UtilHBM.reportInfo("360 rendering image generated and number of images generated are : "
								+ generated360Image.size());
					}
				}
				if (generatedHQImage.size() > 0) {
					if ((driver.findElement(
							By.xpath("//div[@class='project-images']/div/div/div[@class='img-container']/img")))
									.getAttribute("src").contains(".jpg")) {
						UtilHBM.reportInfo("HQ rendering image generated and number of images generated are : "
								+ generatedHQImage.size());
					}
				}
//				int mediaListSize = generatedHQImage.size();
//				for (int i = 0; i < mediaListSize; i++) {
//					UtilHBM.waitExplicitDisplayed(driver, title);
//					WebElement currentImg = generatedHQImage.get(i);
//					String imgSrc = currentImg.getAttribute("src");
////				String prdName = currentImg.findElement(By.xpath("div/span[@class='title']")).getText();
//
//					UtilHBM.waitExplicitClickable(driver, currentImg);
//					Actions actions = new Actions(driver);
//					actions.moveToElement(currentImg).click().build().perform();
//
//					UtilHBM.waitFixTime(500);
//					UtilHBM.waitExplicitDisplayed(driver, backButton);
//					WebElement fullWidth = driver.findElement(By.xpath(
//							"//section[@class='mod-sublayer-media-slider mod-open']/div/div/div/ul/li[@class='item swiper-slide-active']/img"));
//					String fullSrceenSrc = fullWidth.getAttribute("src");
//					if (fullSrceenSrc.equals(imgSrc)) {
//
//						UtilHBM.reportOK("Image displayed correctly in fullscreen mode");
//					} else {
//						UtilHBM.reportKO("Image displayed correctly in fullscreen mode!!imgSrc : " + imgSrc
//								+ ", fullSrceenSrc :" + fullSrceenSrc);
//					}
//					backButton.click();
//				}
				if (generatedHQImage.size() > 0) {
					Actions actions = new Actions(driver);
					actions.moveToElement(generatedHQImage.get(0)).click().build().perform();
					fullScreenVerificationChecks();
				}
			}
		}

		return this;
	}

	public TwoDPlansAndImagesCheck verifyProjectPlans(int noOf2DPlanImages) {
		UtilHBM.waitExplicitDisplayed(driver, title);
		assertEquals(title.getText(), "Images & 2D Plans", "Title not correct");
		toggle2DPlansSection();
		if (noOf2DPlanImages == 0
				&& driver.findElements(By.xpath("//div[@class='plan-container medias-item']")).size() < 0) {
			UtilHBM.reportInfo("No 2D plan Images to display.");
		} else if (topPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of top plans displayed are :" + topPlanImages.size());
		}
		if (facePlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of face plans displayed are :" + facePlanImages.size());
		}

		if (worktopPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of worktop plans displayed are :" + worktopPlanImages.size());
		}
		if (wallPanelPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of wallpanel plans displayed are :" + wallPanelPlanImages.size());
		}
		int twoDPlanImagesCount = topPlanImages.size() + facePlanImages.size() + worktopPlanImages.size()
				+ wallPanelPlanImages.size();
		if (twoDPlanImagesCount == noOf2DPlanImages) {
			UtilHBM.reportOK("Correct number of 2D plan images displayed and number of 2D plan images are "
					+ twoDPlanImagesCount);
			List<WebElement> img = driver.findElements(
					By.xpath("//div[@class='project-plans']/div/div[@class='plan-container medias-item']"));

			int mediaListSize = img.size();
			for (int i = 0; i < mediaListSize; i++) {
				UtilHBM.waitExplicitDisplayed(driver, title);
				WebElement currentImg = img.get(i);
				String imgSrc = currentImg.findElement(By.xpath("div/img")).getAttribute("src");
//				String prdName = currentImg.findElement(By.xpath("div/span[@class='title']")).getText();

				UtilHBM.waitExplicitClickable(driver, currentImg);
				currentImg.click();
				UtilHBM.waitFixTime(500);
				UtilHBM.waitExplicitDisplayed(driver, backButton);
				Verification.VerifyEquals("Download icon not distinguishable...",
						download.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
								.getAttribute("xlink:href"),
						"/Shared/icons/icons.svg#icon-action-download");
				Verification.VerifyEquals("Download Text not correct", download.getText(), "Download");
				WebElement fullWidth = driver.findElement(By.xpath(
						"//section[@class='mod-sublayer-media-slider mod-open']/div/div/div/ul/li[@class='item swiper-slide-active']/img"));
				String fullSrceenSrc = fullWidth.getAttribute("src");
				if (fullSrceenSrc.equals(imgSrc)) {

					UtilHBM.reportOK("Image displayed correctly in fullscreen mode");
				} else {
					UtilHBM.reportKO("Image displayed correctly in fullscreen mode!!imgSrc : " + imgSrc
							+ ", fullSrceenSrc :" + fullSrceenSrc);
				}
				backButton.click();
			}
			img.get(0).click();
			fullScreenVerificationChecks();
			backButton.click();
		}
		return this;
	}

	public TwoDPlansAndImagesCheck fullScreenVerificationChecks() {
		Verification.displayOfWebElement(backButton);
		Verification.VerifyEquals("Back button icon not distinguishable...", backButton
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"../media/img/icons.svg#icon-action-arrow");
		Verification.VerifyEquals("Back button text not distinguishable...",
				backButton.findElement(By.xpath("span[contains(text(),'Back')]")).getText(), "Back");
		Verification.VerifyEquals("Item note icon not distinguishable...", download
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"/Shared/icons/icons.svg#icon-action-download");
		Verification.VerifyEquals("Download Text not correct", download.getText(), "Download");
		if (!(sliderNavigationNextButton.isEmpty())) {
			Verification.VerifyEquals("Next arrow icon not distinguishable...", sliderNavigationNextButton.get(0)
					.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
					"../media/img/icons.svg#icon-action-arrow");
			sliderNavigationNextButton.get(0).click();
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, sliderNavigationNextButton.get(0));
			sliderNavigationNextButton.get(0).click();

		} else if (!(sliderNavigationPreviousButton.isEmpty())) {
			Verification.VerifyEquals("Previous arrow icon not distinguishable...",
					sliderNavigationPreviousButton.get(0)
							.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
							.getAttribute("xlink:href"),
					"../media/img/icons.svg#icon-action-arrow");
			sliderNavigationNextButton.get(0).click();
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, sliderNavigationNextButton.get(0));
			sliderNavigationNextButton.get(0).click();
		} else {
			UtilHBM.reportKO("Slider Navidation Button or arrow image not available");
		}

		return this;
	}

	public TwoDPlansAndImagesCheck toggle2DPlansSection() {
		UtilHBM.waitExplicitClickable(driver, twoDPlanHdr);
		twoDPlanHdr.click();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//div[@class='project-plans']/div[@class='mod-togglable-section-toggler']/button[@aria-expanded='false']")));
		twoDPlanHdr.click();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//div[@class='project-plans']/div[@class='mod-togglable-section-toggler active']/button[@aria-expanded='true']")));
		return this;

	}

	public TwoDPlansAndImagesCheck toggleImagesSection() {
		UtilHBM.waitExplicitDisplayed(driver, imagesHdr);
		UtilHBM.waitExplicitClickable(driver, imagesHdr);
		imagesHdr.click();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//div[@class='project-images']/div[@class='mod-togglable-section-toggler']/button[@aria-expanded='false']")));
		imagesHdr.click();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//div[@class='project-images']/div[@class='mod-togglable-section-toggler active']/button[@aria-expanded='true']")));
		return this;

	}

	public TwoDPlansAndImagesCheck verifyDownloadPossibleFor2DPlans(boolean isDownloadPossible) {
		List<WebElement> img = driver
				.findElements(By.xpath("//div[@class='project-plans']/div/div[@class='plan-container medias-item']"));

		int mediaListSize = img.size();
		for (int i = 0; i < mediaListSize; i++) {
			UtilHBM.waitExplicitDisplayed(driver, title);
			WebElement currentImg = img.get(i);
			String imgSrc = currentImg.findElement(By.xpath("div/img")).getAttribute("src");
//			String prdName = currentImg.findElement(By.xpath("div/span[@class='title']")).getText();

			UtilHBM.waitExplicitClickable(driver, currentImg);
			currentImg.click();
			UtilHBM.waitFixTime(500);
			UtilHBM.waitExplicitDisplayed(driver, backButton);
			try {
				UtilHBM.waitExplicitDisplayed(driver, download);
				UtilHBM.waitExplicitClickable(driver, download);
				if (!isDownloadPossible) {
					UtilHBM.reportKO(
							"'Download' button is visible for 2D plans..., Expected : This button is not visible when multiselect is not possible");
				}else {
					UtilHBM.reportKO("'Download' button not visible ... for 2D plans");
				}
			} catch (NoSuchElementException | TimeoutException ex) {
				if (isDownloadPossible)
					UtilHBM.reportKO("'Download' button not visible ...");
			}
			WebElement fullWidth = driver.findElement(By.xpath(
					"//section[@class='mod-sublayer-media-slider mod-open']/div/div/div/ul/li[@class='item swiper-slide-active']/img"));
			String fullSrceenSrc = fullWidth.getAttribute("src");
			if (fullSrceenSrc.equals(imgSrc)) {

				UtilHBM.reportOK("Image displayed correctly in fullscreen mode");
			} else {
				UtilHBM.reportKO("Image displayed correctly in fullscreen mode!!imgSrc : " + imgSrc
						+ ", fullSrceenSrc :" + fullSrceenSrc);
			}
			backButton.click();
		}
		img.get(0).click();
		backButton.click();
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public TwoDPlansAndImagesCheck verifyDownloadPossibleForImages(boolean isDownloadPossible) {
		if (generatedHQImage.size() > 0) {
			Actions actions = new Actions(driver);
			actions.moveToElement(generatedHQImage.get(0)).click().build().perform();
			try {
				UtilHBM.waitExplicitDisplayed(driver, download);
				UtilHBM.waitExplicitClickable(driver, download);
				if (!isDownloadPossible) {
					UtilHBM.reportKO(
							"'Download' button is visible for HQ images..., Expected : This button is not visible when multiselect is not possible");
				}else {
					UtilHBM.reportKO("'Download' button not visible ... for HQ images");
				}
			} catch (NoSuchElementException | TimeoutException ex) {
				if (isDownloadPossible)
					UtilHBM.reportKO("'Download' button not visible for HQ images ...");
			}
		}

		backButton.click();
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
}
