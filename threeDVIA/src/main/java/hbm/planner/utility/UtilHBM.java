package hbm.planner.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilHBM {		
//	public static Pattern createPattern(String img){
//		Pattern p = new Pattern (Setting.imgPath + img);/*edit black image if similarity is below 0.9*/
//		return p;
//	}
//	
//	public static boolean verifyScreen (String img){
//		double i=0;		
//		Screen s = new Screen();
//		s.setAutoWaitTimeout(30);			
//		try {
//			i = s.find(createPattern(img)).getScore();
//		} catch (FindFailed e) {				
//			e.printStackTrace();
//		}
//		if(i>0.92){								
//			reportOK("Result on screen matches with reference image. Matching percentage is: " + i);			
//			return true;
//		}else{
//			reportKO("Result on screen does not matches with reference image. Matching percentage is: " + i);
//			return false;
//		}
//	}
//	
//	public static void clickImg(String img){
//		Screen s = new Screen();
//		try {			
//			System.out.println(s.find(createPattern(img)).getScore());
//			s.click(createPattern(img));			
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void doubleClickImg(String img, int xOffset, int yOffset){
//		Screen s = new Screen();
//		try {
//			s.doubleClick(createPattern(img).targetOffset(xOffset, yOffset));
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void clickImgOffset(String img, int xOffset, int yOffset){
//		Screen s = new Screen();
//		try {
//			System.out.println(s.find(createPattern(img)).getScore());			
//			s.click(createPattern(img).targetOffset(xOffset, yOffset));			
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void hoverImgOffset(String img, int x, int y){
//		Screen s = new Screen();		
//		try {			
//			s.hover(createPattern(img).targetOffset(x, y));
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void hoverNClickImg(String img, Location loc){
//		Screen s = new Screen();		
//		try {
////			s.hover(createPattern(img).targetOffset(loc).getImage());			
//			s.click(s.hover(createPattern(img).targetOffset(loc).getImage()));
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void hoverOnBlank(){
//		Screen s = new Screen();		
//		try {
//			s.hover(createPattern("BlankSpace.png"));				
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public static void clickBlankSpace(){		
//		Screen s = new Screen();
//		try {			
//			s.doubleClick(createPattern("BlankSpace.png"));			
//			System.out.println("click on blank");
//		} catch (FindFailed e) {			
//			reportKO("Problem in clicking blank space");
//			System.out.println("Problem in clicking blank space");
//			e.printStackTrace();
//		}
//	}
//	public static void clickBlankSpaceIkea(){		
//		Screen s = new Screen();
//		try {			
//			s.click(createPattern("bryoBlankSpace.png").exact());
//			System.out.println("click on blank");
//		} catch (FindFailed e) {			
//			reportKO("Problem in clicking blank space");
//			System.out.println("Problem in clicking blank space");
//			e.printStackTrace();
//		}
//	}
//	
//	public static void click3DBlankSpace(){		
//		Screen s = new Screen();
//		try {			
//			s.doubleClick(createPattern("3DBlankSpace.png"));
//			System.out.println("click on blank");
//		} catch (FindFailed e) {			
//			reportKO("Problem in clicking blank space");
//			System.out.println("Problem in clicking blank space");
//			e.printStackTrace();
//		}
//	}
	
	
	public static void pageCapture(WebDriver driver, String pageName) {	
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();		
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			
		String imageFileName = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss")
		.format(new GregorianCalendar().getTime()) + browserName + "_"
				+ pageName +driver.getTitle()+ ".png";			
		File failureImageFile = new File(Setting.screenCapturePath+imageFileName);
		try{
			imageFile.renameTo(failureImageFile);
//			FileUtils.moveFile(imageFile, failureImageFile);
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
	/*
	public static void screenCapture(WebDriver driver, String pageName){
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();		
		String imageName = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss")
		.format(new GregorianCalendar().getTime()) + browserName + "_" +pageName;
//		Screen s = new Screen();		
//		s.capture().getFile(Setting.screenCapturePath, imageName);
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File failureImageFile = new File(Setting.screenCapturePath+imageName);
		imageFile.renameTo(failureImageFile);
	}
	*/
	
	public static void waitImplicit(WebDriver driver, long timeInSec) {
		System.out.println("time for implicit wait =" + timeInSec);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));		
	}
	
	public static void waitExplicitClickable(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}

	public static void waitExplicitDisplayed(WebDriver driver, String xpath){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void waitExplicitDisplayed(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public static void waitFixTime(long waitTimeInMiliSecond){		
		try {
			Thread.sleep(waitTimeInMiliSecond);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	public static void waitTillElementDisappear(WebDriver driver, String cssPath){
	
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(cssPath))));	
//		while (listOfWebElement(driver, cssPath).size()>0){
//			
//		}
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void waitTillElementDisappear (WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	//This method will not break the code even if the element is not display or disappeared
	public static void waitTillElementDisappearSoft (WebDriver driver, WebElement element, int timeoutInSec){
		turnOffImplicitWaits(driver);
		try{
			System.out.println("Waiting started");
			waitExplicitDisplayed(driver, element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec));
			wait.until(ExpectedConditions.invisibilityOf(element));	
		}catch (Exception e){
			reportKO(element + "Element not displayed or disappeard");
		}
		turnOnImplicitWaits(driver);
		System.out.println("Waiting stoped");
		
	}
	
	/*
	
	public static int getLocXCo(String img){		
		Screen s = new Screen();
		int x = 0;
		try {
			x = s.find(new Pattern (Setting.imgPath + img)).getCenter().x;					
		} catch (FindFailed e) {
			System.out.println("Error in getting X coordinate of "+ img);
			e.printStackTrace();
		}		
		return x;
	}
	
	public static int getLocYCo(String img){		
		Screen s = new Screen();
		int y = 0;		
		try {
			y = s.find(new Pattern (Setting.imgPath + img)).getCenter().x;					
		} catch (FindFailed e) {
			System.out.println("Error in getting X coordinate of "+ img);
			e.printStackTrace();
		}		
		return y;
	}
	public static Location getLocation(String img){
		Screen s = new Screen();
		Location loc=new Location(0, 0);
		try {
			loc = s.find(UtilHBM.createPattern(img)).getCenter();
		} catch (FindFailed e) {			
			e.printStackTrace();
		}
		return loc;	
	}	
	
	public static void verifyLinks(WebDriver driver, String page){
		String linksToTest = getKeyValue(Setting.hyperlinks).get(page);
		System.out.println(linksToTest);
		String[] linkList = linksToTest.split(",");
		String dupLink = null;
		for (String link:linkList){
			WebElement element = driver.findElement(By.linkText(link));			
			int i=1;
			if(link.equalsIgnoreCase(dupLink)){
				System.out.println("duplicate");
				element = driver.findElements(By.linkText(link)).get(i);
				i++;
			}							
			System.out.println(link);
			element.click();
			String actualTitle = driver.getTitle();						
			String expectedTitle = getKeyValue(Setting.hyperlinks).get(link);
			if(i>1){
				expectedTitle = getKeyValue(Setting.hyperlinks).get(link + (i-1));
			}
			reportInfo(link + " : " + actualTitle);				
			if (actualTitle.equals(expectedTitle)){
				reportOK("Click on '" + link + "' in page '" + page +"' & Page title verified. Page loaded successfully");			
			}else{
				reportKO("Click on '" + link + "' in page '" + page +"' & Error in Page title verification. Page loading may have failed");
				UtilHBM.reportKO("Actual title is: " + driver.getTitle());
			}
			dupLink=link;
			driver.navigate().back();
		}
	}
	*/
	
	public static Map<String, String> getKeyValue(String filePath){
		BufferedReader br = null;
		String currentLine;
		Map<String, String> map = new HashMap<String, String>();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((currentLine = br.readLine())!= null){
				String key = currentLine.split(";", 2)[0];
				String value = currentLine.split(";", 2)[1];
				map.put(key, value);				
			}				
			br.close();			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return map;
	}
	
	public static void verifyLinks(WebDriver driver, String page){
		String linksToTest = getKeyValue(Setting.hyperlinks).get(page);
		System.out.println(linksToTest);
		String[] linkList = linksToTest.split(",");		
		for (String link:linkList){
			if(link.contains("HOVER")) {
				String hoverOnElement = link.split(" HOVER ")[0];
				String path = getKeyValue(Setting.hyperlinks).get(hoverOnElement);
				Actions actions=new Actions(driver);
				actions.moveToElement(webElement(driver, path)).build().perform();
				link=link.split(" HOVER ")[1];
			}
			WebElement element = driver.findElement(By.linkText(link));					
			element.click();
			UtilHBM.reportInfo("-------------Verifying link in "+ link);
			for(String str: getKeyValue(Setting.hyperlinks).keySet()){
				if (str.startsWith(link + " title")) {
					String titleExpected = getKeyValue(Setting.hyperlinks).get(str);
					String titleAvailable = driver.getTitle();
					if (titleAvailable.equals(titleAvailable)) {
						UtilHBM.reportOK("Page title displayed correctly");
					} else {
						UtilHBM.reportKO("Page not displayed or Incorrect title displayed for page : -" + str + " , Expected title : "
								+ titleExpected + ",Available title : " + titleAvailable);
					}
				}
				if(str.startsWith(link +" css")){					
					String cssPath = getKeyValue(Setting.hyperlinks).get(str).split("==")[0];
					String text = getKeyValue(Setting.hyperlinks).get(str).split("==")[1];					
					if(cssPath.contains("img") || cssPath.contains("video")){
//						if(driver.getCurrentUrl().contains("preprod")){
//							text=text.replace("https://", "https://preprod-");
//						}
						Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath), "Image/Video "+ str+" in "+ link, "src", text);
					}else {
						Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath), "Text "+ str+" in "+ link, "text", text);
						}
					}	
			}
			for(String str: getKeyValue(Setting.hyperlinks).keySet()){
				if(str.startsWith(link +" Links")){					
					for(String link1: getKeyValue(Setting.hyperlinks).get(link+" Links").split(",")){
						waitFixTime(2000);
						driver.findElement(By.linkText(link1)).click();
						UtilHBM.reportInfo("-------------Verifying link in "+ link1);
						for(String str1: getKeyValue(Setting.hyperlinks).keySet()){
							if (str.startsWith(link + " title")) {
								String titleExpected = getKeyValue(Setting.hyperlinks).get(str);
								String titleAvailable = driver.getTitle();
								if (titleAvailable.equals(titleAvailable)) {
								} else {
									UtilHBM.reportKO("Page not displayed or Incorrect title displayed for page : -" + str + " , Expected title : "
											+ titleExpected + ",Available title : " + titleAvailable);
								}
							}
							if(str1.startsWith(link1 +" css")){
								String cssPath = getKeyValue(Setting.hyperlinks).get(str1).split("==")[0];
								String text = getKeyValue(Setting.hyperlinks).get(str1).split("==")[1];					
								if(cssPath.contains("img") || cssPath.contains("video")){
//									if(driver.getCurrentUrl().contains("preprod")){
//										text=text.replace("https://", "https://preprod-");
//									}
									Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath), "Image/Video "+str1 +" in "+ link1, "src", text);
									
								}else {
									Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath), "Text "+str1 +" in "+ link1, "text", text);
									}
								}
						}
							driver.navigate().back();
							waitFixTime(2000);
					}	
				}
			}		
			driver.navigate().back();
			waitFixTime(2000);
		}
	}
	
	public static List<WebElement> listOfWebElement (WebDriver driver, String cssPath){
		List<WebElement> elements = driver.findElements(By.cssSelector(cssPath));
		return elements;		
	}
	
	public static WebElement webElement(WebDriver driver, String cssPath){
		return driver.findElement(By.cssSelector(cssPath));
	}
	public static WebElement webElementXPath(WebDriver driver, String xPath){
		return driver.findElement(By.xpath(xPath));
	}
	/*
	public static void clickImgTillElementAvailable (WebDriver driver, String img, List<WebElement> elementList, int xOffset, int yOffset){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		clickBlankSpace();
		int i=0;
		clickImgOffset(img, xOffset, yOffset);			
		while(!(elementList.size()>0)&&i<12){
			clickBlankSpace();
			clickImgOffset(img, xOffset, yOffset);			
			i++;
		}
		if(i>0){			
			System.out.println("Name of method:" + Thread.currentThread().getName());
			UtilHBM.reportInfo("Number of iteration in " +Thread.currentThread().getName().getClass()+ ": " +i);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	public static void clickBlankTillElementDisappear (WebDriver driver, String cssPath){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		clickBlankSpace();
		int i=0;				
		while((listOfWebElement(driver, cssPath).size()>0)&&i<12){
			clickBlankSpace();					
			i++;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	*/
	public static void clearInputBox(WebElement inputBox){
		while (!inputBox.getAttribute("value").isEmpty()){
			inputBox.sendKeys(Keys.BACK_SPACE);			
		}
	}
	
	public static void reportMsg (String message){
		Reporter.log("<font color = 'black'>" + message + "<br>");
	}
	public static void reportOK (String message){
		// following line should be commented to remove all OK messsage from test report to focus only on KO & Warnings
		Reporter.log("<font color = 'green'>" + message + "<font color = 'black'><br>");
		System.out.println("<font color = 'green'>" + message + "<font color = 'black'><br>");
	}
	
	public static void reportKO (String message){
		Reporter.log("<font color = 'red'>" + message + "<font color = 'black'><br>");
		System.out.println("<font color = 'red'>" + message + "<font color = 'black'><br>");
	}
	
	public static void reportInfo (String message){
		Reporter.log("<font color = 'orange'>" + message + "<font color = 'black'><br>");
	}
	
	public static void reportWarning (String message){
		Reporter.log("<font color = 'magenta'>" + message + "<font color = 'black'><br>");
	}
	
	/*
	public static void waitForImg(String img, double timeoutInSec){
		Screen s = new Screen();		
			try {
				s.wait(createPattern(img), timeoutInSec);
			} catch (FindFailed e) {				
				e.printStackTrace();
			}		
		}
		*/
	public static void hitArrowKey(int number, String upDownLeftRight){
		String userKey = upDownLeftRight.toLowerCase();
			try {
				Robot r = new Robot();
				for(int i=0; i<number; i++){
					switch (userKey) {
					case "up":
						r.keyPress(KeyEvent.VK_UP);
						r.keyRelease(KeyEvent.VK_UP);
						break;
					case "down":						
						r.keyPress(KeyEvent.VK_DOWN);
						r.keyRelease(KeyEvent.VK_DOWN);
						break;
					case "left":						
						r.keyPress(KeyEvent.VK_LEFT);
						r.keyRelease(KeyEvent.VK_LEFT);
						break;
					case "right":						
						r.keyPress(KeyEvent.VK_RIGHT);
						r.keyRelease(KeyEvent.VK_RIGHT);
						break;					
					}	
					waitFixTime(500);					
				}				
			} catch (AWTException e) {				
				e.printStackTrace();
			}
		}
	
	public static void hitArrowKeyDev(WebDriver driver, int number, String upDownLeftRight){		
		WebElement canvas = driver.findElement(By.tagName("body"));		
//		Actions action = new Actions(driver);
		
		for(int i=0;i<number;i++){
			switch (upDownLeftRight.toLowerCase()) {
			case "left":
//				action.sendKeys(canvas, Keys.ARROW_LEFT);
				canvas.sendKeys(Keys.ARROW_LEFT);
				break;
			case "right":
//				action.sendKeys(canvas, Keys.ARROW_RIGHT);
				canvas.sendKeys(Keys.ARROW_RIGHT);
				break;
			case "up":
//				action.sendKeys(canvas, Keys.ARROW_UP);
				canvas.sendKeys(Keys.ARROW_UP);
				break;
			case "down":
//				action.sendKeys(canvas, Keys.ARROW_DOWN);
				canvas.sendKeys(Keys.ARROW_DOWN);
				break;
			default:
				break;
			}
		}
		
	}
	/*
	public static void dragDropIkea (String sourceImg, String destinationImg, String finalImgAfterDrop){
		Screen s = new Screen();		
		try {
			int i=0;
			do{
				clickBlankSpaceIkea();
				s.dragDrop(createPattern(sourceImg), createPattern(destinationImg));
				clickBlankSpaceIkea();
				i++;
			}while(!s.find(createPattern(finalImgAfterDrop)).isValid() && i<12);
			reportOK(sourceImg +" dragged & droped at "+ destinationImg);
		} catch (FindFailed e) {
			reportKO(sourceImg +" dragdrop failed");
			e.printStackTrace();
		}
	}
	*/
	public static void turnOffImplicitWaits(WebDriver driver) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	public static void turnOnImplicitWaits(WebDriver driver) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//new test method to verify pages
	public static void verifyLinksNew(WebDriver driver, String page){
		String linksToTest = UtilHBM.getKeyValue(Setting.hyperlinks).get(page);
		System.out.println(linksToTest);
		String[] linkList = linksToTest.split(",");	
		int i=0;
		int j=0;
		String link1=null;
		String link2=null;
		for (String link:linkList){		
			if(link.equals(link1)){
				i++;
			}else{
				i=0;
			}			
			WebElement element = driver.findElements(By.linkText(link)).get(i);					
			element.click();
			UtilHBM.waitFixTime(5000);
			try {
				new FileOutputStream(new File(Setting.htmlOutPreprod + link + i + ".txt")).write(driver.findElement(By.tagName("body")).getAttribute("innerHTML").getBytes());
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
				UtilHBM.reportKO("File Not Found for writting test in " +link);
			} catch (IOException e) {				
				e.printStackTrace();
				UtilHBM.reportKO("File writting KO for " +link);
			}
			try {
				compareFiles(Setting.htmlRefPreprod + link + i + ".txt", Setting.htmlOutPreprod + link + i + ".txt");
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("problem in compare");
			}				
			for(String str: UtilHBM.getKeyValue(Setting.hyperlinks).keySet()){
				if(str.startsWith(link +" Links")){	
					UtilHBM.reportInfo("-------------Verifying link in "+ link);
					for(String link3: UtilHBM.getKeyValue(Setting.hyperlinks).get(link+" Links").split(",")){
						driver.findElements(By.linkText(link3)).get(j).click();
						UtilHBM.waitFixTime(5000);
						try {
							new FileOutputStream(new File(Setting.htmlOutPreprod + link+link3 + i + ".txt")).write(driver.findElement(By.tagName("body")).getAttribute("innerHTML").getBytes());
						} catch (FileNotFoundException e) {							
							e.printStackTrace();
							UtilHBM.reportKO("File Not Found for writting test in " +link+link3);
						} catch (IOException e) {							
							e.printStackTrace();
							UtilHBM.reportKO("File Not Found for writting test in " +link+link3);
						}
//						UtilHBM.reportInfo("-------------Verifying link in "+ link3);					
						if(driver.getWindowHandles().size()>1){
							driver.close();
						}else{
							driver.navigate().back();
						}
						if(link3.equals(link2)){
							j++;
						}else{
							j=0;
						}
						link2 = link3;
					}	
				}
			}
			if(driver.getWindowHandles().size()>1){
				driver.close();
			}else{
				driver.navigate().back();
			}
			link1 = link;
		}
	}
	
	 public static void compareFiles(String path1 , String path2) throws Exception {
         BufferedReader br1 = null;
         BufferedReader br2 = null;
         String sCurrentLine;
         List<String> list1 = new ArrayList<String>();
         List<String> list2 = new ArrayList<String>();
         br1 = new BufferedReader(new FileReader(path1));
         br2 = new BufferedReader(new FileReader(path2));
         int a = 0;
         int b = 0;
         while ((sCurrentLine = br1.readLine()) != null) {
             list1.add("line" + a+ ": "+sCurrentLine);
             a++;
         }
//         System.out.println("Line in file "+path1 + ": " + a);
         while ((sCurrentLine = br2.readLine()) != null) {
             list2.add("line" + b+ ": "+sCurrentLine);
             b++;
         }
//         System.out.println("Line in file "+path2 + ": " + b);
         if(!(a==b)){
        	 UtilHBM.reportKO("Number of lines in files Does not match");
        	 UtilHBM.reportKO("Number of lines in file " + path1 + "="+a);
        	 UtilHBM.reportKO("Number of lines in file " + path2 + "="+b);
         }
         List<String> tmpList = new ArrayList<String>(list1);
         tmpList.removeAll(list2);
         java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<(.*?)>");
         if(tmpList.size()>0){           	 
             for(int i=0;i<tmpList.size();i++){
            	 if(!(tmpList.get(i).contains("/bundles/fosjsrouting/js/router.js") || 
            			 tmpList.get(i).contains("window._kmq.push") ||
            			 tmpList.get(i).contains("analytics.setAnonymousId") ||
            			 tmpList.get(i).contains("if (Cookies.get('km_ai')"))){
            		 if(i==0){
            			 System.out.println("Content of "+path1+" which is not available in "+path2);
                         UtilHBM.reportInfo("Content of "+path1+" which is not available in "+path2);
            		 }            		 
            		 String[] result = pattern.split(tmpList.get(i));
            		 System.out.println(Arrays.toString(result)); //content from test.txt which is not there in test2.txt
                     UtilHBM.reportKO(Arrays.toString(result)+"<br>");
            	 }                 
             }
         }
         
         tmpList = list2;
         tmpList.removeAll(list1);
         if(tmpList.size()>0){
             for(int i=0;i<tmpList.size();i++){
            	 if(!(tmpList.get(i).contains("/bundles/fosjsrouting/js/router.js") || 
            			 tmpList.get(i).contains("window._kmq.push") ||
            			 tmpList.get(i).contains("analytics.setAnonymousId") ||
            			 tmpList.get(i).contains("if (Cookies.get('km_ai')"))){
            		 if(i==0){
                    	 System.out.println("Content of "+path2+" which is not available in "+path1);
                         UtilHBM.reportInfo("Content of "+path2+" which is not available in "+path1);
            		 }
            		 String[] result = pattern.split(tmpList.get(i));
            		 System.out.println(Arrays.toString(result)); //content from test.txt which is not there in test2.txt
                     UtilHBM.reportKO(Arrays.toString(result)+"<br>");
            	 }                 
             }
         }
        
         br1.close();
         br2.close();
     }
	 
	 /*
	 //following method is used for Kitchen planner/ template editor
	 public static void selectFurniture(String img, String refImg) {
			int i=0;
			do{
				System.out.println(i);
				UtilHBM.clickImg(img);
				clickBlankSpaceIkea();
				i++;			
			}while (UtilHBM.verifyScreen(refImg)==false && i<12); 		
		}
	 */
	 
	public static String getDate(int workDays, String dateFormat){
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		date=calendar.getTime(); 
		if(workDays<0) {
			for(int i=0;i>workDays;){
		    	calendar.add(Calendar.DAY_OF_MONTH, -1);
		    	if(calendar.get(Calendar.DAY_OF_WEEK)!=7 && calendar.get(Calendar.DAY_OF_WEEK)!=1)
		            i--;
		    }
		}
		else { 	
			for(int i=0;i<workDays;){
			   	calendar.add(Calendar.DAY_OF_MONTH, 1);
			   	if(calendar.get(Calendar.DAY_OF_WEEK)!=7 && calendar.get(Calendar.DAY_OF_WEEK)!=1)
			           i++;
			}
		}
		date=calendar.getTime(); 
		SimpleDateFormat s=new SimpleDateFormat(dateFormat);
		return s.format(date);
	}
	
	public static void setProperty(String fileName, String key, String value) {
		String path = new java.io.File(Setting.testDatapath + fileName + ".properties").getAbsolutePath();
		FileInputStream in = null;
		try {
			in = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			reportKO("File \"" + fileName + ".properties\" not found in method setproperty");
		}
		Properties props = new Properties();
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			reportKO("Input operation failed or interpreted for file \"" + fileName + ".properties\" in method setproperty");
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			reportKO("File \"" + fileName + ".properties\" not found in method setproperty");
		}
		try {
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			reportKO("Output operation failed or interpreted for file \"" + fileName + ".properties\" in method setproperty");
		}

	}

	public static String getProperty(String fileName, String key) {
		String path = new java.io.File(Setting.testDatapath + fileName + ".properties").getAbsolutePath();
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			reportKO("File \"" + fileName + ".properties\" not found in method getproperty");
		}
		return p.getProperty(key);
	}
	
	public static boolean isAttribtuePresent(WebDriver driver, WebElement element, String attribute) {
	    Boolean result = false;
	    turnOffImplicitWaits(driver);
	    String value = element.getAttribute(attribute);
        if (value != null){
            result = true;
        }
        turnOnImplicitWaits(driver);
	    return result;
	}
	
	public static void buildInfo(WebDriver driver){
		String buildDetails = webElement(driver, "body>pre").getText();
		String buildToPrint = "";
		String testDate = getDate(0, "dd-MM-yyyy");		
		
		for(String build:buildDetails.split(",") ){	
			if(build.contains("date")){				
				buildToPrint= " build date " + build.split("\"")[3];
			}
			if(build.contains("\"tag\"")){				
				buildToPrint = build.split("\"")[3] + buildToPrint;
			}			
		}
		if(driver.getCurrentUrl().contains("staging-kitchen.enterprise")){
			buildToPrint = "staging-" + buildToPrint;
		}
		reportInfo(buildToPrint);
		reportInfo("Test date: " + testDate);		
	}
	
		public static void scrollToElementWithOffset(WebDriver driver, WebElement element, int yOffset) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView() \n" +
						"window.scrollBy(0,arguments[1])", element, yOffset);
	}

	public static String getTextMatchingPattern(String regexPattern, String fromText) {
		Matcher matcher = Pattern.compile(regexPattern).matcher(fromText);
		if (matcher.find()) return matcher.group();
		else {
			reportKO("Couldn't find text matching pattern \"" + regexPattern + "\" in searched text \"" + fromText + "\"");
			return null;
		}
	}

	public static List<String> getTextsMatchingPattern(String regexPattern, String fromText) {
		Matcher matcher = Pattern.compile(regexPattern).matcher(fromText);
		List<String> matchingTexts = new ArrayList<>();
		while (matcher.find()) matchingTexts.add( matcher.group());
		if(matchingTexts.size()!=0)return matchingTexts;
		else {
			reportKO("Couldn't find text matching pattern \"" + regexPattern + "\" in searched text \"" + fromText + "\"");
			return null;
		}
	}

	public static void writeJSONObjectToFile(String JSONObject, File file) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		ObjectReader reader = mapper.readerFor(Map.class);
//		Map<String, Object> map = reader.readValue(JSONObject);
//		mapper.writeValue(file, map);
		BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
		try {
			bufferedWriter.write(JSONObject);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufferedWriter.close();
		}

	}

	public static String getSavedBryoAppSettings(File appSettingsBackupFile) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.readTree(appSettingsBackupFile).toString();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(appSettingsBackupFile));
		String savedSettings = "";
		String currentLine;
		try {
			while ((currentLine = bufferedReader.readLine())!= null )
				savedSettings += currentLine;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufferedReader.close();
		}
		return savedSettings;
	}
//	public static void waitFor(WaitExpression expression, WebElement withElement){
//		int timeoutInSec=60;
//		Date startTime=new Date();
//		boolean toWait=true, conditionSatisfied=false;
//		while(toWait){
//			try{
//				if(expression.evaluateExpression(withElement)){
//					toWait=false;
//					conditionSatisfied=true;
//				}
//				else waitFixTime(500);
//
//				if(startTime.getTime()-new Date().getTime()>timeoutInSec*1000)toWait=false;
//
//			}catch(Exception ex){
//				if(startTime.getTime()-new Date().getTime()>timeoutInSec*1000)throw ex;
//			}
//		}
//
//		if(!conditionSatisfied)throw new TimeoutException("Timed out...");
//	}
}



