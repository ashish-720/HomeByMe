package hbm.web.pageobject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ProjectPageMediaTab {
	WebDriver driver;

	public ProjectPageMediaTab(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.media>div")
	List<WebElement> mediaList;

	@FindBy(css = ".medias-container>.medias-gallery-new>.u-txtCenter.u-mtm>.button--alt")
	List<WebElement> moreButton;

	@FindBy(css = ".flex.list-reset>li>.is-active.media-sort.icon-content>.new-badge")
	WebElement mediaCount;

	@FindBy(css = "nav.projectNav>div>ul>li>*[title='Media']")
	private List<WebElement> mediaTab1;
	
	@FindBy(xpath = "//div[@class='wrapper']/div[@class='medias-submenu']/ul/li/*[@class='is-active media-sort icon-content']")
	private WebElement activeMediaType;
	
	@FindBy(css="button.button--alt")
	private WebElement deleteMediaNo;
	
	@FindBy(css="button.button")
	private WebElement deleteMediaYes;
	
	@FindBy(css="div.confirm-box>p")
	private WebElement deleteDialogBoxText;

	public ProjectPageMediaTab verifyMediaPageAlpha(String projectOwnership, int noOfSnpshots, int noOfSnapshotHQ,
			int noOfPanoramic,boolean isMdmOrNot) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
		UtilHBM.turnOffImplicitWaits(driver);
		int totalMediaCount = noOfSnpshots + noOfSnapshotHQ + noOfPanoramic;
		if (totalMediaCount != 0) {
			verifyMediaCount(false);
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
								// UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								// Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								// noMediaToDisplayText.getText(), "No media to display !");
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
								// UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								// Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								// noMediaToDisplayText.getText(), "No media to display !");
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
								// UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
								// Verification.VerifyEquals("Wrong noMediaToDisplayText for " + a,
								// noMediaToDisplayText.getText(), "No media to display !");
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
//						if (!(a.equalsIgnoreCase("360° Images") || a.equalsIgnoreCase("All Medias"))) {
//							verifyCopyToClipbioard("media");
//						}
						new Actions(driver).moveToElement(mediaList.get(0)).build().perform();
						WebElement shareButton1 = mediaList.get(0).findElement(By.xpath(
								"ul[@class='media-actions']/li/*[@class='button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
						UtilHBM.waitExplicitDisplayed(driver, shareButton1);
						UtilHBM.waitExplicitClickable(driver, shareButton1);
						if (projectOwnership.equalsIgnoreCase("own")) {
							WebElement deleteButton1 = mediaList.get(0).findElement(By.xpath(
									"ul[@class='media-actions']/li/*[@class='button button--icon']/i[@class='icon icon-trash u-fs16']/../.."));
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
//						openMediaInFullscreen(1).verifyFullscreenMedia(projectOwnership, a, mediaCount);

					}
				}
			}
			
			 if (AllMediaCount == 0) {
			 UtilHBM.reportOK("Total no. of medias displayed is correct");
			 } else {
			 UtilHBM.reportKO("Total no. of medias displayed is incorrect");
			 }
//			 goToAboutTab();

		} else if (!mediaTab1.isEmpty()) {
			UtilHBM.reportKO("Media Tab displayed!!!Total media count : 0");
		}
		return this;
	}

	ProjectPageMediaTab verifyMediaCount(Boolean isMdmOrNot) {
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

	int getMediaCount(Boolean isMdmOrNot) {
		while (!moreButton.isEmpty()) {
			moreButton.get(0).click();
			UtilHBM.waitFixTime(2000);
		}
		int mediaCount = 0;
		if (!isMdmOrNot) {
			mediaCount = driver
					.findElements(
							By.cssSelector("section.grid>div.grid-2-4.u-mbs>div>div.media-thumb>.media-thumb-link>img"))
					.size();
		} else if (isMdmOrNot) {
			// mediaCount = driver.findElements(By.cssSelector(
			// "section#partner-page>div.section>div>div.grid--product.medias-gallery>div>.media-thumb>.media-thumb-link.trigger-overlay-slider>.b-lazy"))
			// .size();
		}
		return mediaCount;
	}

//	public ProjectPageMediaTab verifyCopyToClipbioard(String mediaOrProject) {
//		new Actions(driver).moveToElement(mediaList.get(0)).build().perform();
//		clickShareMediaButton(1).shareMediaByCopyLink(mediaOrProject);
//		return this;
//	}

	public ShareContainer clickShareMediaButton(int mediaIndex) {
		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
				"ul[@class='media-actions']/li/*[@class='button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		shareButton1.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}

	public FullscreenMedia openMediaInFullscreen(int mediaIndex) {
		WebElement expectedMedia = mediaList.get(mediaIndex - 1).findElement(By.cssSelector(".media-thumb-link>img"));
		UtilHBM.waitExplicitClickable(driver, expectedMedia);
		expectedMedia.click();
		return PageFactory.initElements(driver, FullscreenMedia.class);
	}

	public ProjectPageMediaTab sharemedia(String filterMediaText, boolean isMdmOrNot, int mediaIndex) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
//		goToMediaTab();
		verifyMediaCount(isMdmOrNot);
//		filterMedia(filterMediaText, isMdmOrNot);
		goToMediaType(filterMediaText,isMdmOrNot);
		UtilHBM.reportInfo("Verifying share operation in media tab for first media in " + filterMediaText);
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement shareButton1 = mediaList.get(mediaIndex - 1).findElement(By.xpath(
				"ul[@class='media-actions']/li/*[@class='button button--icon']/i[@class='icon icon-share u-fs16']/../.."));
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		Verification.displayOfWebElement(shareButton1);
		clickShareMediaButton(mediaIndex).shareMedia().closeShareContainer();
		return PageFactory.initElements(driver, ProjectPageMediaTab.class);
	}

	public ProjectPageMediaTab sharemediaFullscreen(String filterMediaText, boolean isMdmOrNot, int mediaIndex) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
//		goToMediaTab();
		verifyMediaCount(isMdmOrNot);
//		filterMedia(filterMediaText, isMdmOrNot);
		goToMediaType(filterMediaText,isMdmOrNot);
		openMediaInFullscreen(mediaIndex).sharemediaFullscreen(filterMediaText);
		return PageFactory.initElements(driver, ProjectPageMediaTab.class);
	}
	
	public ProjectPageMediaTab goToMediaType(String mediaType,boolean isMdmOrNot) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
		driver.findElement(By.xpath(
				"//div[@class='wrapper']/div[@class='medias-submenu']/ul/li/*[contains(@class,'media-sort icon-content')][normalize-space(text())='"
						+ mediaType + "']"))
				.click();
		UtilHBM.waitFixTime(2000);
		Verification.elementContainsString(activeMediaType, mediaType, "Active Media Type");
		return this;

	}
	
	
	public ProjectPageMediaTab deleteMedia(String filterMediaText,int mediaIndex, boolean isMdmOrNot, String deleteActionYesOrNo) {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
//		goToMediaTab();
		verifyMediaCount(isMdmOrNot);
		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
		verifyMediaCount(isMdmOrNot);
		goToMediaType(filterMediaText,isMdmOrNot);
		int beforeDelete = getMediaCount(isMdmOrNot);
		if (beforeDelete < mediaIndex) {
			UtilHBM.reportKO("Media of Index no." + mediaIndex
					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
					+ " are " + beforeDelete);
		}
		new Actions(driver).moveToElement(mediaList.get(mediaIndex - 1)).build().perform();
		WebElement deleteButton1 = mediaList.get(mediaIndex - 1).findElement(
				By.xpath("ul[@class='media-actions']/li/span/span[@class='icon icon-trash u-fs16']/../.."));
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
			goToMediaType(filterMediaText, isMdmOrNot);
//			filterMedia(filterMediaText, isMdmOrNot);
//			if (beforeDelete == 1) {
//				UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//				Verification.VerifyEquals("Wrong noMediaToDisplayText", noMediaToDisplayText.getText(),
//						"No media to display !");
//			}
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
	
	
//	public ProjectPage deleteFullScreenMedia(String filterMediaText, int mediaIndex, String isMdmOrNot, String deleteActionYesOrNo) {
//		goToMediaTab();
//		int noOfMediasBeforeDeletion = Integer.parseInt(mediaCount.getText());
//		verifyMediaCount(isMdmOrNot);
//		filterMedia(filterMediaText, isMdmOrNot);
//		int beforeDelete = getMediaCount(isMdmOrNot);
//		if (beforeDelete < mediaIndex) {
//			UtilHBM.reportKO("Media of Index no." + mediaIndex
//					+ " is not available for delete operation!!!Number of medias available in " + filterMediaText
//					+ " are " + beforeDelete);
//		}
//		openMediaInFullscreen(mediaIndex).deleteFullScreenMedia(filterMediaText, deleteActionYesOrNo);
//		if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
//			UtilHBM.waitExplicitClickable(driver, subHeaderProjectName);
//			if (beforeDelete == 1) {
//				UtilHBM.waitExplicitDisplayed(driver, noMediaToDisplayText);
//				Verification.VerifyEquals("Wrong noMediaToDisplayText", noMediaToDisplayText.getText(),
//						"No media to display !");
//			}
//			// ***** Verifying media count in navigation bar after deletion
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
//			// ***** Verifying media count in media page after deletion
//			int afterDelete = getMediaCount(isMdmOrNot);
//			if (beforeDelete == afterDelete + 1) {
//				UtilHBM.reportOK("Media deleted successfully!!Media count before deletion : " + beforeDelete
//						+ " , Media count after deletion : " + afterDelete);
//			} else {
//				UtilHBM.reportKO("Media not deleted from fullscreen mode,Delete action:" + deleteActionYesOrNo
//						+ ",Media count before deletion : " + beforeDelete + " , Media count after deletion : "
//						+ afterDelete);
//			}
//		} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
//			UtilHBM.waitExplicitClickable(driver, subHeaderProjectName);
//			int noOfMediasAfter = Integer.parseInt(mediaCount.getText());
//			if (noOfMediasBeforeDeletion == noOfMediasAfter) {
//				UtilHBM.reportOK("Delete action:" + deleteActionYesOrNo + ",Media count(Navigation bar) before : "
//						+ noOfMediasBeforeDeletion + " , Media count(Navigation bar) after : " + noOfMediasAfter);
//			} else {
//				UtilHBM.reportKO("Media deleted from fullscreen mode,Delete action:" + deleteActionYesOrNo
//						+ ", Media count(Navigation bar) before : " + noOfMediasBeforeDeletion
//						+ " , Media count(Navigation bar) after : " + noOfMediasAfter);
//			}
//			int afterDelete = getMediaCount(isMdmOrNot);
//			if (beforeDelete == afterDelete) {
//				UtilHBM.reportOK("Media count before : " + beforeDelete + " , Media count after: " + afterDelete);
//			} else {
//				UtilHBM.reportKO("Delete action:" + deleteActionYesOrNo
//						+ ",Different Media counts than earlier!!Media count before : " + beforeDelete
//						+ " , Media count after : " + afterDelete);
//			}
//		}
//		filterMedia("All Medias", isMdmOrNot).verifyMediaCount(isMdmOrNot);
//		return this;
//	}
	
	
}
