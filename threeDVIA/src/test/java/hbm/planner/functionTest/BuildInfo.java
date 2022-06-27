package hbm.planner.functionTest;

import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;

public class BuildInfo extends Browser{

	@Test
	public void buildInfo(){
		UtilHBM.buildInfo(driver);
	}
}
