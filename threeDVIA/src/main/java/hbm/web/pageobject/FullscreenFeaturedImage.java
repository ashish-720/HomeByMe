package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class FullscreenFeaturedImage {
	WebDriver driver;

	public FullscreenFeaturedImage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#swipper-wrapper>.swiper-slide.swiper-slide-active img[src*='https']")
	private WebElement sliderCurrentImage;

	@FindBy(css = "#slider-origin-content>.swiper-container.swiper-container-initialized.swiper-container-horizontal>button.swiper-button-next")
	List<WebElement> sliderNextButton;

	@FindBy(xpath = "//div[@id='turntable'][contains(@style,'visibility: visible')]/div/div[@id='turntableContainer']/div[starts-with(@class,'reel reel-overlay')]/img[@class='reel']")
	private List<WebElement> turnTableImg;

	@FindBy(id = "close-overlay")
	private WebElement closeFullscreenButton;


	public FullscreenFeaturedImage verifyFullscreenFeaturedImage(int noOfMedias, int noOfBullets) {
		UtilHBM.waitExplicitDisplayed(driver, sliderCurrentImage);
		if (!(sliderCurrentImage.getAttribute("src").contains(".jpg")
				|| sliderCurrentImage.getAttribute("src").contains(".png"))) {
			UtilHBM.reportKO("Featured image not displyed in fullscreen mode!!");
		}
		if (noOfMedias != 0) {
			if (!sliderNextButton.isEmpty()) {
				UtilHBM.reportInfo("Checking fullscreen featured images in about tab for project");
				sliderNextButton.get(0).click();
				UtilHBM.waitFixTime(1000);
				String previousImgSrc = null;
				UtilHBM.waitExplicitDisplayed(driver, sliderNextButton.get(0));
				if (noOfBullets == 0) {
					UtilHBM.reportKO("No image is displayed in about page slider images");
				}
				for (int i = 0; i < noOfBullets - 1; i++) {
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
				sliderNextButton.get(0).click();
			} else {
				UtilHBM.reportKO("Slider Button not available");
			}
		} else {
			UtilHBM.reportInfo("Number of medias : " + noOfMedias);
			if (sliderNextButton.isEmpty() && noOfBullets == 0) {
				UtilHBM.reportOK("Media Tab & Slider Button in About tab are not available");
				UtilHBM.reportKO("Featured image bullets not displayed in about page");
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

	public ProjectPage clickCloseFullscreenImages() {
		UtilHBM.waitExplicitDisplayed(driver, closeFullscreenButton);
		UtilHBM.waitExplicitClickable(driver, closeFullscreenButton);
		closeFullscreenButton.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
}