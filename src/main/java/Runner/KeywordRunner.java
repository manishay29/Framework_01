package Runner;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import StepDefinition.OrangeHRMSteps;
import Utilities.Commonmethods;
import Utilities.ExcelReadUtil;

public class KeywordRunner {
	 OrangeHRMSteps OS = new OrangeHRMSteps();
	 Commonmethods CM_obj;
	public  DataRunner DR_Obj = new DataRunner();
	 @BeforeMethod
	 public void launchBrowser() throws Exception {
		 CM_obj = new Commonmethods();
		 CM_obj.launchBrowser();
	 }
	 
	 @Test
	public void getKeyword() throws Exception {
		
		ExcelReadUtil ER = new ExcelReadUtil();
		Commonmethods CM = new Commonmethods();
		Properties prop	=CM.readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		
		ER.readStepKeyword("StepKeyword");
		
		
		for (int i = 0; i < ER.scriptnameList.size(); i++) 
		{
			//String Scriptname =prop.getProperty("Scenariotype");
			
			String Scriptname= DR_Obj.newdatamap.get("AutomationScriptName");
			
			if(ER.scriptnameList.get(i).equalsIgnoreCase(Scriptname))
			{
				String keyword = ER.stepKeywordList.get(i);
				
				if (keyword.equalsIgnoreCase("Login")) 
				{
					OS.loginSteps();
				} 
				else if(keyword.equalsIgnoreCase("AddPimuser")) 
				{
					OS.pimUserSteps();
				}
				else if(keyword.equalsIgnoreCase("adduser")) 
				{
					OS.adduserSteps();
				}
				
				else if(keyword.equalsIgnoreCase("logoff")) 
				{
					OS.logoutStep();
				}
			}
			
			
		}
		
		
		
	}
	
	@AfterMethod
	public void quitSession(){
		CM_obj = new Commonmethods();
		CM_obj.driver.close();
		
		
	}
	
	

}
