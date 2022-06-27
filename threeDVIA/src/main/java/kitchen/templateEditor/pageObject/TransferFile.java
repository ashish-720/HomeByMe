package kitchen.templateEditor.pageObject;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;

public class TransferFile {
	WebDriver driver;

	public TransferFile(WebDriver driver) {
		this.driver=driver;	
	}

	List<String> existingFiles = new ArrayList<String>();

	@FindBy(css="button[data-state='design']")
	WebElement designButton;

	@FindBy(css="#bmSVG")
	WebElement container3D;

	public TransferFile transferFile(String projectName) throws IOException
	{
		existingFiles=Design.getExistingFiles();
		String home = System.getProperty("user.home");
		List<String> fileList = new ArrayList<String>();		
		fileList=findProjectFile(home+"\\Downloads");
		if(existingFiles.size()>0)
		{
			fileList.removeAll(existingFiles);
			for(int i=0;i<fileList.size();i++)
			{
				String sourceFile = (home+"\\Downloads\\"+fileList.get(i));
				String destinationFile = Setting.screenCapturePath+"\\"+(fileList.get(i));		
				Path temp = Files.move(Paths.get(sourceFile),Paths.get(destinationFile));
				if(destinationFile.contains("BMTPROJ"))
				{
					Files.move(Paths.get(destinationFile), Paths.get(destinationFile).resolveSibling(projectName+".BMTPROJ"));
				}
				else if(destinationFile.contains("ZIP"))
				{
					Files.move(Paths.get(destinationFile), Paths.get(destinationFile).resolveSibling(projectName+".ZIP"));
				}
				if(temp != null) 
				{ 
					UtilHBM.reportOK("File moved");
				} 
				else
				{ 
					UtilHBM.reportKO("File not moved"); 
				}
			}
		}
		else
		{
			for(int i=0;i<fileList.size();i++)
			{
				String sourceFile = (home+"\\Downloads\\"+fileList.get(i));
				String destinationFile = Setting.screenCapturePath+"\\"+(fileList.get(i));		
				Path temp = Files.move(Paths.get(sourceFile),Paths.get(destinationFile));
				if(destinationFile.contains("BMTPROJ"))
				{
					Files.move(Paths.get(destinationFile), Paths.get(destinationFile).resolveSibling(projectName+".BMTPROJ"));
				}
				else if(destinationFile.contains("ZIP"))
				{
					Files.move(Paths.get(destinationFile), Paths.get(destinationFile).resolveSibling(projectName+".ZIP"));
				}
				if(temp != null) 
				{ 
					UtilHBM.reportOK("File moved");
				} 
				else
				{ 
					UtilHBM.reportKO("File not moved"); 
				}
			}
		}

		return PageFactory.initElements(driver, TransferFile.class);
	}

	List<String> findProjectFile(String directory) 
	{
		List<String> projectFiles = new ArrayList<String>();
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith((".BMTPROJ"))) {
				projectFiles.add(file.getName());
			}
			else if(file.getName().endsWith((".ZIP")))
			{
				projectFiles.add(file.getName());
			}else if(file.getName().endsWith((".DSHBM")))
			{
				projectFiles.add(file.getName());
			}
		}
		return projectFiles;
	}

	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public TransferFile exportTransferFile(String projectName) throws IOException{
		existingFiles=Design.getExistingFiles();
		String home = System.getProperty("user.home");
		List<String> fileList = new ArrayList<String>();		
		fileList=findProjectFile(home+"\\Downloads");
		if(existingFiles.size()>0){
			fileList.removeAll(existingFiles);
		}
		for(int i=0;i<fileList.size();i++){
			String sourceFile = (home+"\\Downloads\\"+fileList.get(i));
			String destinationFile = Setting.screenCapturePath+"\\"+(fileList.get(i));		
			Path temp = Files.move(Paths.get(sourceFile),Paths.get(destinationFile));
			if(destinationFile.contains("DSHBM")){
				if(Files.size(temp)>0){
					UtilHBM.reportOK("File size of downloaded file is: " +Files.size(temp) );
				}else{
					UtilHBM.reportKO("File size of downloaded file is: " +Files.size(temp));
				}
				
				Files.move(Paths.get(destinationFile), Paths.get(destinationFile).resolveSibling(projectName+".DSHBM"));
			}
			if(temp != null){ 
				UtilHBM.reportOK("File moved");
			}else{ 
				UtilHBM.reportKO("File not moved"); 
			}
		}
		return PageFactory.initElements(driver, TransferFile.class);
	}
}
