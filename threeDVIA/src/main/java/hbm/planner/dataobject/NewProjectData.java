package hbm.planner.dataobject;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class NewProjectData {

	private String projectName;
	private String typeOfProject;
	private String typeOfHousing;
	private int roomNumber;
	private String surfaceArea;
	private String roomType;
	private String floorPlan;
	
	Properties properties = new Properties();
		
	public NewProjectData() throws IOException{
		properties.load(NewProjectData.class.getResourceAsStream("/newprojectdata.properties"));
		projectName = properties.getProperty("projectName");
		typeOfProject = properties.getProperty("typeOfProject");
		typeOfHousing = properties.getProperty("typeOfHousing");
		roomNumber = Integer.parseInt(properties.getProperty("roomNumber"));
		surfaceArea = properties.getProperty("surfaceArea");
		roomType = properties.getProperty("roomType");
		floorPlan=properties.getProperty("floorPlan");
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTypeOfProject() {
		return typeOfProject;
	}
	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}
	public String getTypeOfHousing() {
		return typeOfHousing;
	}
	public void setTypeOfHousing(String typeOfHousing) {
		this.typeOfHousing = typeOfHousing;
	}
	
	public int getRoomId() {
		return roomNumber;
	}
	public void setRoomId(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(String surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getFloorPlan() {
		return floorPlan;
	}


	public void setFloorPlan(String floorPlan) {
		this.floorPlan = floorPlan;
	}


	@DataProvider(name = "projectData")
	public static Object[][] getNewProjectData() throws IOException{
		NewProjectData newProjectData = new NewProjectData();
//		newProjectData.setProjectName("INL_AUTO_TEST_PROJECT");
//		newProjectData.setTypeOfProject("New construction");
//		newProjectData.setTypeOfHousing("House");
		return new NewProjectData[][]{{newProjectData}};				
	}
	
	@DataProvider(name = "imperialProjectData")
	public static Object[][] getImperialProjectData() throws IOException{
		Properties properties = new Properties();
		properties.load(NewProjectData.class.getResourceAsStream("/newprojectdata.properties"));
		NewProjectData newProjectData = new NewProjectData();
		newProjectData.setProjectName(properties.getProperty("imperialProjectName"));
		newProjectData.setTypeOfProject(properties.getProperty("imperialTypeOfProject"));
		newProjectData.setTypeOfHousing(properties.getProperty("imperialTypeOfHousing"));
		newProjectData.setRoomId(Integer.parseInt(properties.getProperty("imperialRoomNumber")));
		newProjectData.setSurfaceArea(properties.getProperty("imperialSurfaceArea"));
		newProjectData.setRoomType(properties.getProperty("imperialRoomType"));
		newProjectData.setFloorPlan(properties.getProperty("floorPlan"));
		return new NewProjectData[][]{{newProjectData}};				
	}
	
	@DataProvider(name = "projectDataODT")
	public static Object[][] getNewProjectDataODT() throws IOException{
		Properties properties = new Properties();
		properties.load(NewProjectData.class.getResourceAsStream("/newprojectdata.properties"));
		NewProjectData newProjectData = new NewProjectData();
		newProjectData.setProjectName(properties.getProperty("projectNameODT"));
		newProjectData.setTypeOfProject(properties.getProperty("typeOfProjectODT"));
		newProjectData.setTypeOfHousing(properties.getProperty("typeOfHousingODT"));
		return new NewProjectData[][]{{newProjectData}};				
	}
}
