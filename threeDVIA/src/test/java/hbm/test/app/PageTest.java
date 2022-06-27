package hbm.test.app;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://homebyme:betatest1@preprod-platform.by.me/");
		driver.get("https://homebyme:betatest1@preprod-home.by.me/");
		/*
		String src=driver.findElement(By.tagName("html")).getAttribute("innerHTML");
		File file = new File("./src/test/resources/inl.html"); 
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream file1=null;
		try {
			file1 = new FileOutputStream(file);			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file1.write(src.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		verifyLinks(driver, "LandingPage");
		driver.close();
		driver.quit();
	}
	
	
	public static void verifyLinks(WebDriver driver, String page){
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
			UtilHBM.waitFixTime(2000);
			try {
				new FileOutputStream(new File(Setting.htmlOutPreprod + link + i + ".txt")).write(driver.findElement(By.tagName("body")).getAttribute("innerHTML").getBytes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				compareFiles(Setting.htmlRefPreprod + link + i + ".txt", Setting.htmlOutPreprod + link + i + ".txt");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("problem in compare");
			}
			UtilHBM.reportInfo("-------------Verifying link in "+ link);	
			for(String str: UtilHBM.getKeyValue(Setting.hyperlinks).keySet()){
				if(str.startsWith(link +" Links")){					
					for(String link3: UtilHBM.getKeyValue(Setting.hyperlinks).get(link+" Links").split(",")){
						driver.findElements(By.linkText(link3)).get(j).click();
						UtilHBM.waitFixTime(2000);
						try {
							new FileOutputStream(new File(Setting.htmlOutPreprod + link+link3 + i + ".txt")).write(driver.findElement(By.tagName("body")).getAttribute("innerHTML").getBytes());
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						UtilHBM.reportInfo("-------------Verifying link in "+ link3);					
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
         List<String> tmpList = new ArrayList<String>(list1);
         tmpList.removeAll(list2);
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
            		 System.out.println(tmpList.get(i)); //content from test.txt which is not there in test2.txt
                     UtilHBM.reportKO(tmpList.get(i));
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
            		 System.out.println(tmpList.get(i)); //content from test.txt which is not there in test2.txt
                     UtilHBM.reportKO(tmpList.get(i));
            	 }                 
             }
         }
        
         br1.close();
         br2.close();
     }
}
