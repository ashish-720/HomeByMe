package hbm.planner.dataobject;

import hbm.planner.utility.Setting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CatalogData {
		
	private String catagory;
	private String product;		
		
	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	List<CatalogData> catalogList = new ArrayList<CatalogData>();
	BufferedReader br;

	public List<CatalogData> getCatalogData(){		
		String currentLine;
		try{			
			br = new BufferedReader(new FileReader(Setting.catalogPath));
			while ((currentLine = br.readLine()) != null){			
				CatalogData catalogData = new CatalogData();
				catalogData.setCatagory(currentLine.split(";")[0]);
				System.out.println("catagory added: "+ catalogData.catagory);
				catalogData.setProduct(currentLine.split(";")[1]);		
				catalogList.add(catalogData);
				catalogData = null;
				System.out.println(catalogList);					
			}
			
		}catch (Exception e){
			System.out.println("Catalog Data List not created");
			e.printStackTrace();
		}
		
		finally {
			try {
				br.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
}
		return catalogList;		
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
