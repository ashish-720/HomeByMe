package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GalleryProjectPage {

	WebDriver driver;

	public GalleryProjectPage(WebDriver driver) {
		this.driver = driver;
	}		
	WebElement like;
	WebElement share;
	WebElement help;
	WebElement userName;
	WebElement projectSummary;
	WebElement turntableImg;
	WebElement slideImg;
	WebElement threeSixtyDegIconImg;
	WebElement clickAndDragToRotateImg;
	WebElement fullScreenView;
	WebElement commentBox;
	WebElement checkOurAllProducts;		
	WebElement mediaFilter;
	List<WebElement> slideArrowList;
	List<WebElement> imgDotList;
	List<WebElement> projectLegendList;
	List<WebElement> tabPageList;
	List<WebElement> colorList;
	List<WebElement> boxTitleList;
	List<WebElement> surfaceOfRooms;
	List<WebElement> colorPalette;
	List<WebElement> allSurfaceRooms;
	List<WebElement> allSurfaceArea;
	List<WebElement> featuredProductList;
	List<WebElement> sectionList;
	List<WebElement> shoppingProductList;
	List<WebElement> mediaList;
	
	public GalleryProjectPage projectDetails(){
		tabPageList = UtilHBM.listOfWebElement(driver, ".projectNav-item");		
		aboutTab();
		if(tabPageList.size()==1){
			Reporter.log("<font color = 'magenta'>" + "SHOPPING LIST & MEDIA tabs are not available in the project page" + "<font color = 'black'>"+"<br>");
		}else if(tabPageList.size()==2){
			if(tabPageList.get(1).getText().contains("SHOPPING LIST")){
				tabPageList.get(1).click();
				Reporter.log("<font color = 'magenta'>" + "MEDIA tabs is not available in the project page" + "<font color = 'black'>"+"<br>");
				shoppingListTab();
			}else{
				tabPageList.get(1).click();
				Reporter.log("<font color = 'magenta'>" + "SHOPPING LIST tabs is not available in the project page" + "<font color = 'black'>"+"<br>");
				mediaTab();
			}
		}else{
			tabPageList.get(1).click();
			shoppingListTab();
			tabPageList = UtilHBM.listOfWebElement(driver, ".projectNav-item");		
			tabPageList.get(2).click();
			mediaTab();
		}
		return PageFactory.initElements(driver, GalleryProjectPage.class);
	}
	
	public String projectName() {
		return UtilHBM.webElement(driver, ".subHeader-title").getText();
	}
	
	public GalleryProjectPage shoppingListTab() {
		Reporter.log("<font color = 'blue'>" + "Shopping Tab Report: " + "<font color = 'black'>"+"<br>");
		shoppingProductList = UtilHBM.listOfWebElement(driver, ".media");
		WebElement activeTab = UtilHBM.webElement(driver, "a[class='projectNav-link is-active']");		
		if(shoppingProductList.size()==Integer.parseInt(activeTab.getText().split("\\(")[1].split("\\)")[0])){
			Reporter.log("<font color = 'green'>" + "Products in Shopping List are: <br>");
			for (WebElement product: shoppingProductList){
				if(product.findElement(By.xpath("//img[starts-with(@src, 'https')]")).isDisplayed() &&
						!product.findElement(By.cssSelector("h3")).getText().isEmpty() &&
						!product.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("") &&
						!product.findElement(By.cssSelector(".media-legend a")).getText().isEmpty() &&
						!product.findElement(By.cssSelector(".media-legend a")).getText().equalsIgnoreCase("")){
					Reporter.log("<font color = 'black'>"+ product.findElement(By.cssSelector(".media-legend a")).getText() + ", "+"<br>");					
				}				
			}
			Reporter.log("<font color = 'green'>Products in shopping list are verified" + "<font color = 'black'>"+"<br>");
		}else{
			Reporter.log("<font color = 'red'>" + "Number of Products in shopping list are not equal to number mentioned in tab" + "<font color = 'black'>" + "<br>");
		}		
		return PageFactory.initElements(driver, GalleryProjectPage.class);		
	}
	
	public GalleryProjectPage mediaTab(){
		Reporter.log("<font color = 'blue'>" + "Media Tab Report:" + "<font color = 'black'>"+"<br>");
		mediaList = driver.findElements(By.cssSelector(".media"));				
		mediaFilter = UtilHBM.webElement(driver, "#sort_media_type");
		WebElement activeTab = UtilHBM.webElement(driver, ".projectNav-link.is-active");		
		if(mediaList.size()==Integer.parseInt(activeTab.getText().split("\\(")[1].split("\\)")[0])){
			Reporter.log("<font color = 'green'>" + "Images in Media List are: <br>");
			for (WebElement image: mediaList){
				if(image.findElement(By.xpath("//img[starts-with(@src, 'https')]")).isDisplayed() &&
						image.findElement(By.cssSelector("img")).getAttribute("src").startsWith("https://byme") &&
						image.findElement(By.cssSelector("img")).getAttribute("src").endsWith(".jpg")){
					Reporter.log("<font color = 'black'>"+ image.findElement(By.cssSelector("span")).getText() + ", " + "<br>");					
				}				
			}
			Reporter.log("<font color = 'green'>Images in media list are verified" + "<font color = 'black'>"+"<br>");
		}else{
			Reporter.log("<font color = 'red'>" + "Number of images in media list are not equal to number mentioned in tab" + "<font color = 'black'>"+"<br>");
		}			
		Verification.displayOfWebElement(UtilHBM.listOfWebElement(driver, ".u-mbs.grid-2-4").get(0));			
		int snapshot=0;
		int image360=0;
		int realisticImage =0;
		Select select = new Select(mediaFilter);
		select.selectByVisibleText("Screenshots");
		UtilHBM.waitFixTime(1000);
		if(!UtilHBM.webElement(driver, ".grid.grid--product.medias-gallery").getText().contains("No media to display !")){
//			List<WebElement> snapList = UtilHBM.listOfWebElement(driver, ".media");
			snapshot= UtilHBM.listOfWebElement(driver, ".media").size();
		}
		select.selectByVisibleText("360° Images");
		UtilHBM.waitFixTime(1000);
		if(!UtilHBM.webElement(driver, ".grid.grid--product.medias-gallery").getText().contains("No media to display !")){
//			List<WebElement> tumbList = UtilHBM.listOfWebElement(driver, ".media");
			image360= UtilHBM.listOfWebElement(driver, ".media").size();
		}
		select.selectByVisibleText("Realistic images");
		UtilHBM.waitFixTime(1000);
		if(!UtilHBM.webElement(driver, ".grid.grid--product.medias-gallery").getText().contains("No media to display !")){
//			List<WebElement> hqList = UtilHBM.listOfWebElement(driver, ".media");
			System.out.println("Thumbe namil text: " + UtilHBM.webElement(driver, ".grid.grid--product.medias-gallery").getText());
			realisticImage= UtilHBM.listOfWebElement(driver, ".media").size();
		}
		if(mediaList.size()==(snapshot+image360+realisticImage)){
			System.out.println("Media List size is: " + mediaList.size() + "And Sum is: " + (snapshot+image360+realisticImage));
			Reporter.log("<font color = 'green'>" + "Sum of Snapshot, Thumbnail & Realistic Images matches with total images in Media page" + "<font color = 'black'>"+"<br>");			
		}else {
			System.out.println("Media List size is: " + mediaList.size() + "And Sum is: " + (snapshot+image360+realisticImage));
			Reporter.log("<font color = 'red'>" + "Sum of Snapshot, Thumbnail & Realistic Images does not matches with total images in Media page" + "<font color = 'black'>" + "<br>");
		}		
		return PageFactory.initElements(driver, GalleryProjectPage.class);	
	}

	public GalleryProjectPage aboutTab() {		
		Actions action = new Actions(driver);		
		like = driver.findElement(By.linkText("LIKE"));
		share = driver.findElement(By.cssSelector(".shareBox"));
		help = driver.findElement(By.id("supporthero-button"));
		userName = UtilHBM.webElement(driver, ".subHeader-thumb-txt>a>span");
		projectSummary = UtilHBM.webElement(driver, ".subHeader-legend");
		turntableImg = UtilHBM.webElement(driver, "li[class='turntable-content slick-slide slick-current slick-active'] img[src*='https']");		
		threeSixtyDegIconImg = UtilHBM.webElement(driver, "li[class='turntable-content slick-slide slick-current slick-active'] img[src='https://d31ax5swi3lxrl.cloudfront.net/dist/images/view_360.585480f7aa56426a739ceca73ee51ea5.svg']");
		clickAndDragToRotateImg = UtilHBM.webElement(driver, "li[class='turntable-content slick-slide slick-current slick-active'] div[class='overlayTurntable']");
		fullScreenView = UtilHBM.webElement(driver, "#trigger-overlay");		
		projectLegendList = UtilHBM.listOfWebElement(driver, ".projectLegend-item");
		tabPageList = UtilHBM.listOfWebElement(driver, ".projectNav-item");
		colorList = UtilHBM.listOfWebElement(driver, "div[class='box project-color-palette'] li>a");
		boxTitleList = UtilHBM.listOfWebElement(driver, ".box-title");
		surfaceOfRooms = UtilHBM.listOfWebElement(driver, "div[class='box project-surfaces'] h3");
		colorPalette = UtilHBM.listOfWebElement(driver, "div[class='box project-color-palette'] div");
		allSurfaceRooms = UtilHBM.listOfWebElement(driver, "section>h3");
		allSurfaceArea = UtilHBM.listOfWebElement(driver, "section>div>dl");		
		commentBox = UtilHBM.webElement(driver, "main>section>div>div>div>div>#comments>#box-question>.comment-area.u-pbm>div[data-text='Enter your comment here...']");
		sectionList = UtilHBM.listOfWebElement(driver, "h2");
		try{
			checkOurAllProducts = driver.findElement(By.linkText("Check out all products"));
		}catch(Exception e){
			Reporter.log("<font color = 'red'>" + "'Check out all product' link is not present in the project Page" + "<font color = 'black'>" + "<br>");
		}
				
		Reporter.log("<font color = 'black'>" + "Report of project: "	+ projectName() + " *******************************************"+ "<font color = 'black'>" + "<br>");	
		
		Verification.displayOfWebElement(like);
		Verification.displayOfWebElement(share);
		Verification.displayOfWebElement(help);
		Verification.displayOfWebElement(userName);
		Verification.displayOfWebElement(commentBox);;
		Verification.displayOfWebElement(checkOurAllProducts);
		Verification.disabledWebElement(tabPageList.get(0));		
		Reporter.log("<font color = 'orange'>" + "Info about project: "
				+ projectSummary.getText()
				+ "<font color = 'black'>" + "<br>");		
		for (WebElement legend : projectLegendList) {
			try {
				if (!(legend.getText().equalsIgnoreCase(null)) && !(legend.getText().isEmpty())) {
					Reporter.log("<font color = 'orange'>"
							+ legend.findElement(By.cssSelector("span"))
									.getAttribute("class")
							+ "is displayed. The text is: " + legend.getText()
							+ "<font color = 'black'>" + "<br>");
				}
			} catch (Exception e) {
				Reporter.log("<font color = 'red'>"
						+ legend.findElement(By.cssSelector("span"))
								.getAttribute("class")
						+ "is displayed. The text is: " + legend.getText()
						+ "<font color = 'black'>" + "<br>");
			}
		}
//		Turntable test
		Verification.displayOfWebElement(turntableImg);
		Verification.displayOfWebElement(threeSixtyDegIconImg);
		Verification.displayOfWebElement(clickAndDragToRotateImg);
		try{
			imgDotList = UtilHBM.listOfWebElement(driver, "ul[class='slick-dots'] button");
			imgDotList.get(0).click();
			System.out.println("first test INL");
			try{
				slideArrowList = UtilHBM.listOfWebElement(driver, ".slick-arrow");				
				Verification.displayOfWebElement(slideArrowList.get(0));
				Verification.displayOfWebElement(slideArrowList.get(1));
				if (turntableImg.isDisplayed()) {
					slideArrowList.get(1).click();
					UtilHBM.waitFixTime(500);
					slideImg = UtilHBM.webElement(driver, "li[class='slick-slide slick-current slick-active'] img[src*='https']");
					if ((slideImg.isDisplayed())) {
						slideArrowList.get(0).click();
						UtilHBM.waitFixTime(500);
						Verification.displayOfWebElement(turntableImg);
					} else {
						Reporter.log("<font color = 'red'>"	+ "slide arrow is not working for project '"+ projectName() + "'" + "<font color = 'black'>"+ "<br>");
					}
				} else {
					Reporter.log("<font color = 'red'>"	+ "TurnTable image not displayed for '" + projectName()	+ "'" + "<font color = 'black'>"+ "<br>");
				}				
			}catch (Exception e){
				Reporter.log("<font color = 'red'>"	+ "problem in slide show for '" + projectName()	+ "'" + "<font color = 'black'>"+ "<br>");
			}

		}catch(Exception e){
			Reporter.log("<font color = 'red'>"	+ "Slide show images are not available for '" + projectName()	+ "'" + "<font color = 'black'>"+ "<br>");
		}			
//		Confirm project details at different locations on page
		if (projectLegendList.get(1).getText()
				.contains(Integer.toString(allSurfaceRooms.size())) && 
				projectLegendList.get(0).getText().equalsIgnoreCase(projectSummary.getText().split(" - ")[0]) &&
				projectLegendList.get(1).getText().equalsIgnoreCase(projectSummary.getText().split(" - ")[1]) &&
				projectLegendList.get(2).getText().equalsIgnoreCase(projectSummary.getText().split(" - ")[2])) {
			Reporter.log("<font color = 'green'>" + "Number of floors, rooms & surface area varified"
					+ "<br>");			
		} else {
			Reporter.log("<font color = 'red'>" + "Number of floors, rooms & surface area varification failed"
					+ "<font color = 'black'>" + "<br>");			
		}
		
		Reporter.log("<font color = 'orange'>" + "Sections displayed for project:" + sectionList.size()	+ "<font color = 'black'>" + "<br>");
		for(WebElement section: sectionList){
			Reporter.log("<font color = 'orange'>" + section.getText()+ "<font color = 'black'>" + "<br>");
		}
//		Color Palette test
		try{ 
			if (UtilHBM.webElement(driver, ".box.project-color-palette>.u-txtRight>.link-more.-underline.view-more.icon-content").isDisplayed()){
				UtilHBM.webElement(driver, ".box.project-color-palette>.u-txtRight>.link-more.-underline.view-more.icon-content").click();
			}			
		}catch (Exception e){
			Reporter.log("<font color = 'red'>" +"View more link not available in color palette" + "<font color = 'black'>"+ "<br>");
		}
		for (WebElement element: colorPalette){
			if (!(element.getAttribute("class").equalsIgnoreCase("u-txtRight"))){				
				if(!(element.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(null))){
					element.findElement(By.cssSelector("h3")).click();
				}else{
					Reporter.log("<font color = 'red'>" + "Floor name is blank"	+ "<font color = 'black'>" + "<br>");
				}				
				for (WebElement color: element.findElements(By.cssSelector("li"))){
					boolean colorCode = color.findElement(By.cssSelector("a")).getAttribute("data-product-id").replace(" ", "").isEmpty();
					if (!(colorCode)){						
						action.moveToElement(color);
					}else{
						Reporter.log("<font color = 'red'>" + "Color in color palette is not displayed"	+ "<font color = 'black'>" + "<br>");
					}
				}				
			}
		}
//		All Surface section test
		try{ 
			if (UtilHBM.webElement(driver, ".box.project-surfaces>.u-txtRight>.link-more.-underline.view-more.icon-content").isDisplayed()){
				UtilHBM.webElement(driver, ".box.project-surfaces>.u-txtRight>.link-more.-underline.view-more.icon-content").click();
			}			
		}catch (Exception e){
			Reporter.log("<font color = 'red'>" +"View more link not available in All Surfaces section" + "<font color = 'black'>"+ "<br>");
		}
		
		if(allSurfaceRooms.size()==allSurfaceArea.size()&&
				allSurfaceArea.size()==Integer.parseInt(projectLegendList.get(1).getText().split(" ")[0])){
			for (WebElement room: allSurfaceRooms){				
				if ((room.getText().contains("floor") || room.getText().contains("basement"))&& !room.getText().equalsIgnoreCase(null)){
					action.moveToElement(room);						
				}else{
					Reporter.log("<font color = 'red'>" + "Room name is null or empty in All Surface section"	+ "<font color = 'black'>" + "<br>");
				}				
			}
			for (WebElement area:allSurfaceArea){				
				String[] areaText= area.getText().split("\\r?\\n");
				if(areaText[0].equalsIgnoreCase("Floor surface") &&						
						!(Double.parseDouble(areaText[1].split(" ")[0])==0)&&
						areaText[1].split(" ")[1].equalsIgnoreCase("m2")){
					Reporter.log("<font color = 'orange'>" + area.getText() + "<font color = 'black'>" + "<br>");					
				}else{
					Reporter.log("<font color = 'red'>" + "Surface area information is either null/ empty or incorrect" + "<font color = 'black'>" + "<br>");
				}
			}
		}else{
			Reporter.log("<font color = 'red'>" + "number of rooms in All surface section do not macth with project details" + "<font color = 'black'>" + "<br>");
		}
//		Checking Featured product section
		try{
			featuredProductList = UtilHBM.listOfWebElement(driver, ".media");
			try{
				Reporter.log("<font color = 'green'>" + "The products used in project are: ");
				for (WebElement product: featuredProductList){					
					if(product.findElement(By.cssSelector("img[src*='https']")).isDisplayed() &&
							!product.findElement(By.cssSelector("h3")).getText().isEmpty() &&
							!product.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("") &&
							!product.findElement(By.cssSelector(".media-legend a")).getText().isEmpty() &&
							!product.findElement(By.cssSelector(".media-legend a")).getText().equalsIgnoreCase("")
							){
						Reporter.log(product.findElement(By.cssSelector(".media-legend a")).getText() + ", ");
					}										
				}
				Reporter.log("<br><font color = 'green'>" + "Number of products in Featured Product section are varified. product listaed in this section: "+ featuredProductList.size()+ "<font color = 'black'>" + "<br>");
			}catch(Exception e){
				Reporter.log("<font color = 'red'>" + "Problem in Featured product list. Either Images or Brand/product name is not displayed" + "<font color = 'black'>" + "<br>");
			}	
		}catch (Exception e) {
			Reporter.log("<font color = 'red'>" + "There are no featured products in the project" + "<font color = 'black'>" + "<br>");
		}	
		
		return PageFactory.initElements(driver, GalleryProjectPage.class);
	}



}
