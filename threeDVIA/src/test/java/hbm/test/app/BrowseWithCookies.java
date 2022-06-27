package hbm.test.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowseWithCookies {
	static WebDriver driver;
	
	
	
	public static void main(String[] args) {
		
		/*
		System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
			File file = new File("./src/main/ChromeDriver/preprodCookiesChrome.data");
			FileReader fileReader;
			fileReader = new FileReader(file);			
			BufferedReader bReader = new BufferedReader(fileReader);
			String currentLine;
			while((currentLine=bReader.readLine())!=null){
				StringTokenizer token = new StringTokenizer(currentLine, ";");
				while(token.hasMoreTokens()){
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;
					
					String val;
					if(!(val=token.nextToken()).equals("null")){
						DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);						
						expiry= df.parse(val);
						System.out.println("Date is: " + expiry);
					}
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.get("https://home.by.me/en/");
					driver.manage().addCookie(ck);					
				}				
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		driver.get("https://preprod-home.by.me/en/");
		driver.findElement(By.linkText("GALLERY")).click();
		driver.close();
		driver.quit();
		
		*/
	
						
		driver = new FirefoxDriver();
		driver.get("https://homebyme:betatest1@preprod-3dplan.by.me/en/");
		driver.get("https://homebyme:betatest1@preprod-home.by.me/en/");
		driver.findElement(By.id("accept-cookie-law")).click();
		driver.close();
		driver.quit();
		
		
	}
	
		
}
